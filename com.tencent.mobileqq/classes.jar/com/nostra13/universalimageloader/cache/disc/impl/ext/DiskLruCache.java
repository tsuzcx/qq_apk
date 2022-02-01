package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    if (this.journalWriter != null) {
      return;
    }
    throw new IllegalStateException("cache is closed");
  }
  
  private void completeEdit(DiskLruCache.Editor paramEditor, boolean paramBoolean)
  {
    try
    {
      localEntry = DiskLruCache.Editor.access$1500(paramEditor);
      if (DiskLruCache.Entry.access$800(localEntry) != paramEditor) {
        break label472;
      }
      int k = 0;
      j = k;
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
              break label126;
            }
            if (DiskLruCache.Editor.access$1600(paramEditor)[i] == 0) {
              break;
            }
            if (!localEntry.getDirtyFile(i).exists())
            {
              paramEditor.abort();
              return;
            }
            i += 1;
          }
          paramEditor.abort();
          paramEditor = new StringBuilder();
          paramEditor.append("Newly created entry didn't create value for index ");
          paramEditor.append(i);
          throw new IllegalStateException(paramEditor.toString());
        }
      }
    }
    finally
    {
      for (;;)
      {
        DiskLruCache.Entry localEntry;
        int j;
        label126:
        Object localObject;
        long l1;
        long l2;
        for (;;)
        {
          label472:
          throw paramEditor;
        }
        j += 1;
      }
    }
    if (j < this.valueCount)
    {
      paramEditor = localEntry.getDirtyFile(j);
      if (paramBoolean)
      {
        if (paramEditor.exists())
        {
          localObject = localEntry.getCleanFile(j);
          paramEditor.renameTo((File)localObject);
          l1 = DiskLruCache.Entry.access$1100(localEntry)[j];
          l2 = ((File)localObject).length();
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
        paramEditor = this.journalWriter;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CLEAN ");
        ((StringBuilder)localObject).append(DiskLruCache.Entry.access$1200(localEntry));
        ((StringBuilder)localObject).append(localEntry.getLengths());
        ((StringBuilder)localObject).append('\n');
        paramEditor.write(((StringBuilder)localObject).toString());
        if (paramBoolean)
        {
          l1 = this.nextSequenceNumber;
          this.nextSequenceNumber = (1L + l1);
          DiskLruCache.Entry.access$1302(localEntry, l1);
        }
      }
      else
      {
        this.lruEntries.remove(DiskLruCache.Entry.access$1200(localEntry));
        paramEditor = this.journalWriter;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("REMOVE ");
        ((StringBuilder)localObject).append(DiskLruCache.Entry.access$1200(localEntry));
        ((StringBuilder)localObject).append('\n');
        paramEditor.write(((StringBuilder)localObject).toString());
      }
      this.journalWriter.flush();
      if ((this.size > this.maxSize) || (this.fileCount > this.maxFileCount) || (journalRebuildRequired())) {
        this.executorService.submit(this.cleanupCallable);
      }
      return;
      throw new IllegalStateException();
    }
  }
  
  private static void deleteIfExists(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.delete()) {
        return;
      }
      throw new IOException();
    }
  }
  
  private DiskLruCache.Editor edit(String paramString, long paramLong)
  {
    try
    {
      checkNotClosed();
      validateKey(paramString);
      Object localObject = (DiskLruCache.Entry)this.lruEntries.get(paramString);
      if (paramLong != -1L) {
        if (localObject != null)
        {
          long l = DiskLruCache.Entry.access$1300((DiskLruCache.Entry)localObject);
          if (l == paramLong) {}
        }
        else
        {
          return null;
        }
      }
      if (localObject == null)
      {
        localObject = new DiskLruCache.Entry(this, paramString, null);
        this.lruEntries.put(paramString, localObject);
      }
      else
      {
        localEditor = DiskLruCache.Entry.access$800((DiskLruCache.Entry)localObject);
        if (localEditor != null) {
          return null;
        }
      }
      DiskLruCache.Editor localEditor = new DiskLruCache.Editor(this, (DiskLruCache.Entry)localObject, null);
      DiskLruCache.Entry.access$802((DiskLruCache.Entry)localObject, localEditor);
      localObject = this.journalWriter;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DIRTY ");
      localStringBuilder.append(paramString);
      localStringBuilder.append('\n');
      ((Writer)localObject).write(localStringBuilder.toString());
      this.journalWriter.flush();
      return localEditor;
    }
    finally {}
  }
  
  private static String inputStreamToString(InputStream paramInputStream)
  {
    return Util.readFully(new InputStreamReader(paramInputStream, Util.UTF_8));
  }
  
  private boolean journalRebuildRequired()
  {
    int i = this.redundantOpCount;
    return (i >= 2000) && (i >= this.lruEntries.size());
  }
  
  public static DiskLruCache open(File paramFile, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (paramLong > 0L)
    {
      if (paramInt3 > 0)
      {
        if (paramInt2 > 0)
        {
          Object localObject = new File(paramFile, "journal.bkp");
          if (((File)localObject).exists())
          {
            File localFile = new File(paramFile, "journal");
            if (localFile.exists()) {
              ((File)localObject).delete();
            } else {
              renameTo((File)localObject, localFile, false);
            }
          }
          localObject = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong, paramInt3);
          if (((DiskLruCache)localObject).journalFile.exists()) {
            try
            {
              ((DiskLruCache)localObject).readJournal();
              ((DiskLruCache)localObject).processJournal();
              ((DiskLruCache)localObject).journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((DiskLruCache)localObject).journalFile, true), Util.US_ASCII));
              return localObject;
            }
            catch (IOException localIOException)
            {
              PrintStream localPrintStream = System.out;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("DiskLruCache ");
              localStringBuilder.append(paramFile);
              localStringBuilder.append(" is corrupt: ");
              localStringBuilder.append(localIOException.getMessage());
              localStringBuilder.append(", removing");
              localPrintStream.println(localStringBuilder.toString());
              ((DiskLruCache)localObject).delete();
            }
          }
          paramFile.mkdirs();
          paramFile = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong, paramInt3);
          paramFile.rebuildJournal();
          return paramFile;
        }
        throw new IllegalArgumentException("valueCount <= 0");
      }
      throw new IllegalArgumentException("maxFileCount <= 0");
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void processJournal()
  {
    deleteIfExists(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
      DiskLruCache.Editor localEditor = DiskLruCache.Entry.access$800(localEntry);
      int j = 0;
      int i = 0;
      if (localEditor == null)
      {
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
        i = j;
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
  
  private void readJournal()
  {
    localStrictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
    for (;;)
    {
      try
      {
        str1 = localStrictLineReader.readLine();
        str2 = localStrictLineReader.readLine();
        localObject2 = localStrictLineReader.readLine();
        str3 = localStrictLineReader.readLine();
        str4 = localStrictLineReader.readLine();
        if (("libcore.io.DiskLruCache".equals(str1)) && ("1".equals(str2)) && (Integer.toString(this.appVersion).equals(localObject2)) && (Integer.toString(this.valueCount).equals(str3)))
        {
          boolean bool = "".equals(str4);
          if (bool) {
            i = 0;
          }
        }
      }
      finally
      {
        String str1;
        String str2;
        Object localObject2;
        String str3;
        String str4;
        int i;
        Util.closeQuietly(localStrictLineReader);
        continue;
        throw localObject1;
        continue;
      }
      try
      {
        readJournalLine(localStrictLineReader.readLine());
        i += 1;
      }
      catch (EOFException localEOFException) {}
    }
    this.redundantOpCount = (i - this.lruEntries.size());
    Util.closeQuietly(localStrictLineReader);
    return;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("unexpected journal header: [");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str3);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str4);
    ((StringBuilder)localObject2).append("]");
    throw new IOException(((StringBuilder)localObject2).toString());
  }
  
  private void readJournalLine(String paramString)
  {
    int i = paramString.indexOf(' ');
    if (i != -1)
    {
      int j = i + 1;
      int k = paramString.indexOf(' ', j);
      if (k == -1)
      {
        localObject2 = paramString.substring(j);
        localObject1 = localObject2;
        if (i == 6)
        {
          localObject1 = localObject2;
          if (paramString.startsWith("REMOVE")) {
            this.lruEntries.remove(localObject2);
          }
        }
      }
      else
      {
        localObject1 = paramString.substring(j, k);
      }
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.lruEntries.get(localObject1);
      Object localObject2 = localEntry;
      if (localEntry == null)
      {
        localObject2 = new DiskLruCache.Entry(this, (String)localObject1, null);
        this.lruEntries.put(localObject1, localObject2);
      }
      if ((k != -1) && (i == 5) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        DiskLruCache.Entry.access$702((DiskLruCache.Entry)localObject2, true);
        DiskLruCache.Entry.access$802((DiskLruCache.Entry)localObject2, null);
        DiskLruCache.Entry.access$900((DiskLruCache.Entry)localObject2, paramString);
        return;
      }
      if ((k == -1) && (i == 5) && (paramString.startsWith("DIRTY")))
      {
        DiskLruCache.Entry.access$802((DiskLruCache.Entry)localObject2, new DiskLruCache.Editor(this, (DiskLruCache.Entry)localObject2, null));
        return;
      }
      if ((k == -1) && (i == 4) && (paramString.startsWith("READ"))) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unexpected journal line: ");
      ((StringBuilder)localObject1).append(paramString);
      throw new IOException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("unexpected journal line: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new IOException(((StringBuilder)localObject1).toString());
  }
  
  private void rebuildJournal()
  {
    try
    {
      if (this.journalWriter != null) {
        this.journalWriter.close();
      }
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
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
        while (localIterator.hasNext())
        {
          DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
          StringBuilder localStringBuilder;
          if (DiskLruCache.Entry.access$800(localEntry) != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("DIRTY ");
            localStringBuilder.append(DiskLruCache.Entry.access$1200(localEntry));
            localStringBuilder.append('\n');
            localBufferedWriter.write(localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("CLEAN ");
            localStringBuilder.append(DiskLruCache.Entry.access$1200(localEntry));
            localStringBuilder.append(localEntry.getLengths());
            localStringBuilder.append('\n');
            localBufferedWriter.write(localStringBuilder.toString());
          }
        }
        localBufferedWriter.close();
        if (this.journalFile.exists()) {
          renameTo(this.journalFile, this.journalFileBackup, true);
        }
        renameTo(this.journalFileTmp, this.journalFile, false);
        this.journalFileBackup.delete();
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        return;
      }
      finally
      {
        localBufferedWriter.close();
      }
      throw localObject1;
    }
    finally {}
    for (;;) {}
  }
  
  private static void renameTo(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      deleteIfExists(paramFile2);
    }
    if (paramFile1.renameTo(paramFile2)) {
      return;
    }
    throw new IOException();
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
    if (LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("keys must match regex [a-z0-9_-]{1,64}: \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void close()
  {
    try
    {
      Object localObject1 = this.journalWriter;
      if (localObject1 == null) {
        return;
      }
      localObject1 = new ArrayList(this.lruEntries.values()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        DiskLruCache.Entry localEntry = (DiskLruCache.Entry)((Iterator)localObject1).next();
        if (DiskLruCache.Entry.access$800(localEntry) != null) {
          DiskLruCache.Entry.access$800(localEntry).abort();
        }
      }
      trimToSize();
      trimToFileCount();
      this.journalWriter.close();
      this.journalWriter = null;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
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
  
  public DiskLruCache.Snapshot get(String paramString)
  {
    for (;;)
    {
      try
      {
        checkNotClosed();
        validateKey(paramString);
        localEntry = (DiskLruCache.Entry)this.lruEntries.get(paramString);
        if (localEntry == null) {
          return null;
        }
        boolean bool = DiskLruCache.Entry.access$700(localEntry);
        if (!bool) {
          return null;
        }
        arrayOfFile = new File[this.valueCount];
        arrayOfInputStream = new InputStream[this.valueCount];
        j = 0;
        i = 0;
      }
      finally
      {
        DiskLruCache.Entry localEntry;
        File[] arrayOfFile;
        InputStream[] arrayOfInputStream;
        Object localObject;
        StringBuilder localStringBuilder;
        continue;
        throw paramString;
        continue;
      }
      try
      {
        if (i < this.valueCount)
        {
          localObject = localEntry.getCleanFile(i);
          arrayOfFile[i] = localObject;
          arrayOfInputStream[i] = new FileInputStream((File)localObject);
          i += 1;
          continue;
        }
        this.redundantOpCount += 1;
        localObject = this.journalWriter;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("READ ");
        localStringBuilder.append(paramString);
        localStringBuilder.append('\n');
        ((Writer)localObject).append(localStringBuilder.toString());
        if (journalRebuildRequired()) {
          this.executorService.submit(this.cleanupCallable);
        }
        paramString = new DiskLruCache.Snapshot(this, paramString, DiskLruCache.Entry.access$1300(localEntry), arrayOfFile, arrayOfInputStream, DiskLruCache.Entry.access$1100(localEntry), null);
        return paramString;
      }
      catch (FileNotFoundException paramString)
      {
        i = j;
        continue;
      }
      if ((i >= this.valueCount) || (arrayOfInputStream[i] == null)) {
        continue;
      }
      Util.closeQuietly(arrayOfInputStream[i]);
      i += 1;
    }
    return null;
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
  
  public boolean isClosed()
  {
    try
    {
      Writer localWriter = this.journalWriter;
      boolean bool;
      if (localWriter == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean remove(String paramString)
  {
    try
    {
      checkNotClosed();
      validateKey(paramString);
      Object localObject2 = (DiskLruCache.Entry)this.lruEntries.get(paramString);
      int i = 0;
      if ((localObject2 != null) && (DiskLruCache.Entry.access$800((DiskLruCache.Entry)localObject2) == null))
      {
        while (i < this.valueCount)
        {
          localObject1 = ((DiskLruCache.Entry)localObject2).getCleanFile(i);
          if ((((File)localObject1).exists()) && (!((File)localObject1).delete()))
          {
            paramString = new StringBuilder();
            paramString.append("failed to delete ");
            paramString.append(localObject1);
            throw new IOException(paramString.toString());
          }
          this.size -= DiskLruCache.Entry.access$1100(localObject2)[i];
          this.fileCount -= 1;
          DiskLruCache.Entry.access$1100((DiskLruCache.Entry)localObject2)[i] = 0L;
          i += 1;
        }
        this.redundantOpCount += 1;
        Object localObject1 = this.journalWriter;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("REMOVE ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append('\n');
        ((Writer)localObject1).append(((StringBuilder)localObject2).toString());
        this.lruEntries.remove(paramString);
        if (journalRebuildRequired()) {
          this.executorService.submit(this.cleanupCallable);
        }
        return true;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
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