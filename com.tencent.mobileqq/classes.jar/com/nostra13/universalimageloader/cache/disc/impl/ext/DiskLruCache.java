package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DiskLruCache
  implements Closeable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final OutputStream NULL_OUTPUT_STREAM = new DiskLruCache.2();
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Callable<Void> cleanupCallable = new DiskLruCache.1(this);
  private final File directory;
  final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private int fileCount = 0;
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  private Writer journalWriter;
  private final LinkedHashMap<String, DiskLruCache.Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private int maxFileCount;
  private long maxSize;
  private long nextSequenceNumber = 0L;
  private int redundantOpCount;
  private long size = 0L;
  private final int valueCount;
  
  private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
    this.maxFileCount = paramInt3;
  }
  
  private void checkNotClosed()
  {
    if (this.journalWriter == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void completeEdit(DiskLruCache.Editor paramEditor, boolean paramBoolean)
  {
    int k = 0;
    DiskLruCache.Entry localEntry;
    try
    {
      localEntry = DiskLruCache.Editor.access$1500(paramEditor);
      if (DiskLruCache.Entry.access$800(localEntry) != paramEditor) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!DiskLruCache.Entry.access$700(localEntry))
      {
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.valueCount) {
            break;
          }
          if (DiskLruCache.Editor.access$1600(paramEditor)[i] == 0)
          {
            paramEditor.abort();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
          }
          if (!localEntry.getDirtyFile(i).exists())
          {
            paramEditor.abort();
            return;
          }
          i += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (j < this.valueCount)
      {
        paramEditor = localEntry.getDirtyFile(j);
        if (paramBoolean)
        {
          if (paramEditor.exists())
          {
            File localFile = localEntry.getCleanFile(j);
            paramEditor.renameTo(localFile);
            l1 = DiskLruCache.Entry.access$1100(localEntry)[j];
            long l2 = localFile.length();
            DiskLruCache.Entry.access$1100(localEntry)[j] = l2;
            this.size = (this.size - l1 + l2);
            this.fileCount += 1;
          }
        }
        else {
          deleteIfExists(paramEditor);
        }
      }
      else
      {
        this.redundantOpCount += 1;
        DiskLruCache.Entry.access$802(localEntry, null);
        if ((DiskLruCache.Entry.access$700(localEntry) | paramBoolean))
        {
          DiskLruCache.Entry.access$702(localEntry, true);
          this.journalWriter.write("CLEAN " + DiskLruCache.Entry.access$1200(localEntry) + localEntry.getLengths() + '\n');
          if (paramBoolean)
          {
            l1 = this.nextSequenceNumber;
            this.nextSequenceNumber = (1L + l1);
            DiskLruCache.Entry.access$1302(localEntry, l1);
          }
        }
        for (;;)
        {
          this.journalWriter.flush();
          if ((this.size <= this.maxSize) && (this.fileCount <= this.maxFileCount) && (!journalRebuildRequired())) {
            break;
          }
          this.executorService.submit(this.cleanupCallable);
          break;
          this.lruEntries.remove(DiskLruCache.Entry.access$1200(localEntry));
          this.journalWriter.write("REMOVE " + DiskLruCache.Entry.access$1200(localEntry) + '\n');
        }
      }
      j += 1;
    }
  }
  
  private static void deleteIfExists(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private DiskLruCache.Editor edit(String paramString, long paramLong)
  {
    for (;;)
    {
      DiskLruCache.Editor localEditor;
      try
      {
        checkNotClosed();
        validateKey(paramString);
        DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.lruEntries.get(paramString);
        if (paramLong != -1L) {
          if (localEntry != null)
          {
            long l = DiskLruCache.Entry.access$1300(localEntry);
            if (l == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localEntry == null)
        {
          localEntry = new DiskLruCache.Entry(this, paramString, null);
          this.lruEntries.put(paramString, localEntry);
          localEditor = new DiskLruCache.Editor(this, localEntry, null);
          DiskLruCache.Entry.access$802(localEntry, localEditor);
          this.journalWriter.write("DIRTY " + paramString + '\n');
          this.journalWriter.flush();
          paramString = localEditor;
          continue;
        }
        localEditor = DiskLruCache.Entry.access$800(localEntry);
      }
      finally {}
      if (localEditor != null) {
        paramString = null;
      }
    }
  }
  
  private static String inputStreamToString(InputStream paramInputStream)
  {
    return Util.readFully(new InputStreamReader(paramInputStream, Util.UTF_8));
  }
  
  private boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }
  
  public static DiskLruCache open(File paramFile, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt3 <= 0) {
      throw new IllegalArgumentException("maxFileCount <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    Object localObject = new File(paramFile, "journal.bkp");
    File localFile;
    if (((File)localObject).exists())
    {
      localFile = new File(paramFile, "journal");
      if (!localFile.exists()) {
        break label168;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong, paramInt3);
      if (!((DiskLruCache)localObject).journalFile.exists()) {
        break label232;
      }
      try
      {
        ((DiskLruCache)localObject).readJournal();
        ((DiskLruCache)localObject).processJournal();
        ((DiskLruCache)localObject).journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((DiskLruCache)localObject).journalFile, true), Util.US_ASCII));
        return localObject;
      }
      catch (IOException localIOException)
      {
        label168:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((DiskLruCache)localObject).delete();
      }
      renameTo((File)localObject, localFile, false);
    }
    label232:
    paramFile.mkdirs();
    paramFile = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong, paramInt3);
    paramFile.rebuildJournal();
    return paramFile;
  }
  
  private void processJournal()
  {
    deleteIfExists(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
      int i;
      if (DiskLruCache.Entry.access$800(localEntry) == null)
      {
        i = 0;
        while (i < this.valueCount)
        {
          this.size += DiskLruCache.Entry.access$1100(localEntry)[i];
          this.fileCount += 1;
          i += 1;
        }
      }
      else
      {
        DiskLruCache.Entry.access$802(localEntry, null);
        i = 0;
        while (i < this.valueCount)
        {
          deleteIfExists(localEntry.getCleanFile(i));
          deleteIfExists(localEntry.getDirtyFile(i));
          i += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  /* Error */
  private void readJournal()
  {
    // Byte code:
    //   0: new 450	com/nostra13/universalimageloader/cache/disc/impl/ext/StrictLineReader
    //   3: dup
    //   4: new 452	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 134	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:journalFile	Ljava/io/File;
    //   12: invokespecial 454	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: getstatic 388	com/nostra13/universalimageloader/cache/disc/impl/ext/Util:US_ASCII	Ljava/nio/charset/Charset;
    //   18: invokespecial 455	com/nostra13/universalimageloader/cache/disc/impl/ext/StrictLineReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 458	com/nostra13/universalimageloader/cache/disc/impl/ext/StrictLineReader:readLine	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_2
    //   28: invokevirtual 458	com/nostra13/universalimageloader/cache/disc/impl/ext/StrictLineReader:readLine	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_2
    //   34: invokevirtual 458	com/nostra13/universalimageloader/cache/disc/impl/ext/StrictLineReader:readLine	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_2
    //   40: invokevirtual 458	com/nostra13/universalimageloader/cache/disc/impl/ext/StrictLineReader:readLine	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_2
    //   46: invokevirtual 458	com/nostra13/universalimageloader/cache/disc/impl/ext/StrictLineReader:readLine	()Ljava/lang/String;
    //   49: astore 7
    //   51: ldc 29
    //   53: aload_3
    //   54: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +54 -> 111
    //   60: ldc 38
    //   62: aload 4
    //   64: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +44 -> 111
    //   70: aload_0
    //   71: getfield 127	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:appVersion	I
    //   74: invokestatic 469	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   77: aload 5
    //   79: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +29 -> 111
    //   85: aload_0
    //   86: getfield 140	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:valueCount	I
    //   89: invokestatic 469	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   92: aload 6
    //   94: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +14 -> 111
    //   100: ldc_w 471
    //   103: aload 7
    //   105: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +77 -> 185
    //   111: new 314	java/io/IOException
    //   114: dup
    //   115: new 227	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 473
    //   125: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_3
    //   129: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 475
    //   135: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 4
    //   140: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 475
    //   146: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 6
    //   151: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 475
    //   157: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 7
    //   162: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 477
    //   168: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 478	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   177: athrow
    //   178: astore_3
    //   179: aload_2
    //   180: invokestatic 482	com/nostra13/universalimageloader/cache/disc/impl/ext/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   183: aload_3
    //   184: athrow
    //   185: iconst_0
    //   186: istore_1
    //   187: aload_0
    //   188: aload_2
    //   189: invokevirtual 458	com/nostra13/universalimageloader/cache/disc/impl/ext/StrictLineReader:readLine	()Ljava/lang/String;
    //   192: invokespecial 485	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:readJournalLine	(Ljava/lang/String;)V
    //   195: iload_1
    //   196: iconst_1
    //   197: iadd
    //   198: istore_1
    //   199: goto -12 -> 187
    //   202: astore_3
    //   203: aload_0
    //   204: iload_1
    //   205: aload_0
    //   206: getfield 96	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   209: invokevirtual 357	java/util/LinkedHashMap:size	()I
    //   212: isub
    //   213: putfield 193	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:redundantOpCount	I
    //   216: aload_2
    //   217: invokestatic 482	com/nostra13/universalimageloader/cache/disc/impl/ext/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   220: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	DiskLruCache
    //   186	27	1	i	int
    //   21	196	2	localStrictLineReader	StrictLineReader
    //   26	103	3	str1	String
    //   178	6	3	localObject	Object
    //   202	1	3	localEOFException	java.io.EOFException
    //   31	108	4	str2	String
    //   37	41	5	str3	String
    //   43	107	6	str4	String
    //   49	112	7	str5	String
    // Exception table:
    //   from	to	target	type
    //   22	111	178	finally
    //   111	178	178	finally
    //   187	195	178	finally
    //   203	216	178	finally
    //   187	195	202	java/io/EOFException
  }
  
  private void readJournalLine(String paramString)
  {
    int i = paramString.indexOf(' ');
    if (i == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int j = i + 1;
    int k = paramString.indexOf(' ', j);
    String str;
    if (k == -1)
    {
      str = paramString.substring(j);
      if ((i == "REMOVE".length()) && (paramString.startsWith("REMOVE"))) {
        this.lruEntries.remove(str);
      }
    }
    else
    {
      str = paramString.substring(j, k);
    }
    for (;;)
    {
      DiskLruCache.Entry localEntry2 = (DiskLruCache.Entry)this.lruEntries.get(str);
      DiskLruCache.Entry localEntry1 = localEntry2;
      if (localEntry2 == null)
      {
        localEntry1 = new DiskLruCache.Entry(this, str, null);
        this.lruEntries.put(str, localEntry1);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        DiskLruCache.Entry.access$702(localEntry1, true);
        DiskLruCache.Entry.access$802(localEntry1, null);
        DiskLruCache.Entry.access$900(localEntry1, paramString);
        return;
      }
      if ((k == -1) && (i == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        DiskLruCache.Entry.access$802(localEntry1, new DiskLruCache.Editor(this, localEntry1, null));
        return;
      }
      if ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private void rebuildJournal()
  {
    for (;;)
    {
      try
      {
        if (this.journalWriter != null) {
          this.journalWriter.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        DiskLruCache.Entry localEntry;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.appVersion));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.valueCount));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.lruEntries.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (DiskLruCache.Entry)localIterator.next();
          if (DiskLruCache.Entry.access$800(localEntry) != null)
          {
            localBufferedWriter.write("DIRTY " + DiskLruCache.Entry.access$1200(localEntry) + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        localObject1.write("CLEAN " + DiskLruCache.Entry.access$1200(localEntry) + localEntry.getLengths() + '\n');
      }
      finally {}
    }
    localObject1.close();
    if (this.journalFile.exists()) {
      renameTo(this.journalFile, this.journalFileBackup, true);
    }
    renameTo(this.journalFileTmp, this.journalFile, false);
    this.journalFileBackup.delete();
    this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
  }
  
  private static void renameTo(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      deleteIfExists(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void trimToFileCount()
  {
    while (this.fileCount > this.maxFileCount) {
      remove((String)((Map.Entry)this.lruEntries.entrySet().iterator().next()).getKey());
    }
  }
  
  private void trimToSize()
  {
    while (this.size > this.maxSize) {
      remove((String)((Map.Entry)this.lruEntries.entrySet().iterator().next()).getKey());
    }
  }
  
  private void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
    }
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.journalWriter;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.lruEntries.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          DiskLruCache.Entry localEntry = (DiskLruCache.Entry)((Iterator)localObject1).next();
          if (DiskLruCache.Entry.access$800(localEntry) == null) {
            continue;
          }
          DiskLruCache.Entry.access$800(localEntry).abort();
          continue;
        }
        trimToSize();
      }
      finally {}
      trimToFileCount();
      this.journalWriter.close();
      this.journalWriter = null;
    }
  }
  
  public void delete()
  {
    close();
    Util.deleteContents(this.directory);
  }
  
  public DiskLruCache.Editor edit(String paramString)
  {
    return edit(paramString, -1L);
  }
  
  public long fileCount()
  {
    try
    {
      int i = this.fileCount;
      long l = i;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void flush()
  {
    try
    {
      checkNotClosed();
      trimToSize();
      trimToFileCount();
      this.journalWriter.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public DiskLruCache.Snapshot get(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokespecial 317	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:checkNotClosed	()V
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 320	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 96	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   18: aload_1
    //   19: invokevirtual 323	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 209	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Entry
    //   25: astore 6
    //   27: aload 6
    //   29: ifnonnull +10 -> 39
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: areturn
    //   39: aload 4
    //   41: astore_3
    //   42: aload 6
    //   44: invokestatic 218	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Entry:access$700	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Entry;)Z
    //   47: ifeq -12 -> 35
    //   50: aload_0
    //   51: getfield 140	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:valueCount	I
    //   54: anewarray 129	java/io/File
    //   57: astore_3
    //   58: aload_0
    //   59: getfield 140	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:valueCount	I
    //   62: anewarray 565	java/io/InputStream
    //   65: astore 5
    //   67: iconst_0
    //   68: istore_2
    //   69: iload_2
    //   70: aload_0
    //   71: getfield 140	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:valueCount	I
    //   74: if_icmpge +74 -> 148
    //   77: aload 6
    //   79: iload_2
    //   80: invokevirtual 251	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Entry:getCleanFile	(I)Ljava/io/File;
    //   83: astore 7
    //   85: aload_3
    //   86: iload_2
    //   87: aload 7
    //   89: aastore
    //   90: aload 5
    //   92: iload_2
    //   93: new 452	java/io/FileInputStream
    //   96: dup
    //   97: aload 7
    //   99: invokespecial 454	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: aastore
    //   103: iload_2
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: goto -38 -> 69
    //   110: astore_1
    //   111: iconst_0
    //   112: istore_2
    //   113: aload 4
    //   115: astore_3
    //   116: iload_2
    //   117: aload_0
    //   118: getfield 140	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:valueCount	I
    //   121: if_icmpge -86 -> 35
    //   124: aload 4
    //   126: astore_3
    //   127: aload 5
    //   129: iload_2
    //   130: aaload
    //   131: ifnull -96 -> 35
    //   134: aload 5
    //   136: iload_2
    //   137: aaload
    //   138: invokestatic 482	com/nostra13/universalimageloader/cache/disc/impl/ext/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   141: iload_2
    //   142: iconst_1
    //   143: iadd
    //   144: istore_2
    //   145: goto -32 -> 113
    //   148: aload_0
    //   149: aload_0
    //   150: getfield 193	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:redundantOpCount	I
    //   153: iconst_1
    //   154: iadd
    //   155: putfield 193	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:redundantOpCount	I
    //   158: aload_0
    //   159: getfield 148	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:journalWriter	Ljava/io/Writer;
    //   162: new 227	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 567
    //   172: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_1
    //   176: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: bipush 10
    //   181: invokevirtual 287	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   184: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokevirtual 570	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   190: pop
    //   191: aload_0
    //   192: invokespecial 185	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:journalRebuildRequired	()Z
    //   195: ifeq +15 -> 210
    //   198: aload_0
    //   199: getfield 116	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:executorService	Ljava/util/concurrent/ThreadPoolExecutor;
    //   202: aload_0
    //   203: getfield 123	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:cleanupCallable	Ljava/util/concurrent/Callable;
    //   206: invokevirtual 303	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   209: pop
    //   210: new 572	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot
    //   213: dup
    //   214: aload_0
    //   215: aload_1
    //   216: aload 6
    //   218: invokestatic 327	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Entry:access$1300	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Entry;)J
    //   221: aload_3
    //   222: aload 5
    //   224: aload 6
    //   226: invokestatic 259	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Entry:access$1100	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Entry;)[J
    //   229: aconst_null
    //   230: invokespecial 575	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot:<init>	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache;Ljava/lang/String;J[Ljava/io/File;[Ljava/io/InputStream;[JLcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$1;)V
    //   233: astore_3
    //   234: goto -199 -> 35
    //   237: astore_1
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_1
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	DiskLruCache
    //   0	242	1	paramString	String
    //   68	77	2	i	int
    //   34	200	3	localObject1	Object
    //   1	124	4	localObject2	Object
    //   65	158	5	arrayOfInputStream	InputStream[]
    //   25	200	6	localEntry	DiskLruCache.Entry
    //   83	15	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   69	85	110	java/io/FileNotFoundException
    //   90	103	110	java/io/FileNotFoundException
    //   5	27	237	finally
    //   42	67	237	finally
    //   69	85	237	finally
    //   90	103	237	finally
    //   116	124	237	finally
    //   134	141	237	finally
    //   148	210	237	finally
    //   210	234	237	finally
  }
  
  public File getDirectory()
  {
    return this.directory;
  }
  
  public int getMaxFileCount()
  {
    try
    {
      int i = this.maxFileCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getMaxSize()
  {
    try
    {
      long l = this.maxSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 148	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:journalWriter	Ljava/io/Writer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	DiskLruCache
    //   12	7	1	bool	boolean
    //   6	2	2	localWriter	Writer
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public boolean remove(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        checkNotClosed();
        validateKey(paramString);
        DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.lruEntries.get(paramString);
        Object localObject;
        if (localEntry != null)
        {
          localObject = DiskLruCache.Entry.access$800(localEntry);
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.size -= DiskLruCache.Entry.access$1100(localEntry)[i];
          this.fileCount -= 1;
          DiskLruCache.Entry.access$1100(localEntry)[i] = 0L;
          i += 1;
        }
        if (i < this.valueCount)
        {
          localObject = localEntry.getCleanFile(i);
          if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.redundantOpCount += 1;
      this.journalWriter.append("REMOVE " + paramString + '\n');
      this.lruEntries.remove(paramString);
      if (journalRebuildRequired()) {
        this.executorService.submit(this.cleanupCallable);
      }
      boolean bool = true;
    }
  }
  
  public void setMaxSize(long paramLong)
  {
    try
    {
      this.maxSize = paramLong;
      this.executorService.submit(this.cleanupCallable);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long size()
  {
    try
    {
      long l = this.size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache
 * JD-Core Version:    0.7.0.1
 */