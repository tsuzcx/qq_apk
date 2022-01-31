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

public final class behy
  implements Closeable
{
  private static final OutputStream jdField_a_of_type_JavaIoOutputStream = new beia();
  static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[A-Za-z0-9_-]{1,120}");
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final File jdField_a_of_type_JavaIoFile;
  private Writer jdField_a_of_type_JavaIoWriter;
  private final LinkedHashMap<String, beid> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(0, 0.75F, true);
  private final Callable<Void> jdField_a_of_type_JavaUtilConcurrentCallable = new behz(this);
  final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final File jdField_b_of_type_JavaIoFile;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private final File jdField_c_of_type_JavaIoFile;
  private final File d;
  
  private behy(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaIoFile = new File(paramFile, "journal");
    this.jdField_c_of_type_JavaIoFile = new File(paramFile, "journal.tmp");
    this.d = new File(paramFile, "journal.bkp");
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static behy a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
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
        break label113;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new behy(paramFile, paramInt1, paramInt2, paramLong);
      if (!((behy)localObject).jdField_b_of_type_JavaIoFile.exists()) {
        break label174;
      }
      try
      {
        ((behy)localObject).c();
        ((behy)localObject).d();
        return localObject;
      }
      catch (IOException localIOException)
      {
        label113:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((behy)localObject).b();
      }
      a((File)localObject, localFile, false);
    }
    label174:
    paramFile.mkdirs();
    paramFile = new behy(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.e();
    return paramFile;
  }
  
  private beib a(String paramString, long paramLong)
  {
    for (;;)
    {
      beib localbeib;
      try
      {
        f();
        b(paramString);
        beid localbeid = (beid)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
        if (paramLong != -1L) {
          if (localbeid != null)
          {
            long l = beid.a(localbeid);
            if (l == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localbeid == null)
        {
          localbeid = new beid(this, paramString, null);
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, localbeid);
          localbeib = new beib(this, localbeid, null);
          beid.a(localbeid, localbeib);
          this.jdField_a_of_type_JavaIoWriter.write("DIRTY " + paramString + '\n');
          this.jdField_a_of_type_JavaIoWriter.flush();
          paramString = localbeib;
          continue;
        }
        localbeib = beid.a(localbeid);
      }
      finally {}
      if (localbeib != null) {
        paramString = null;
      }
    }
  }
  
  private void a(beib parambeib, boolean paramBoolean)
  {
    int k = 0;
    beid localbeid;
    try
    {
      localbeid = beib.a(parambeib);
      if (beid.a(localbeid) != parambeib) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!beid.a(localbeid))
      {
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.jdField_b_of_type_Int) {
            break;
          }
          if (beib.a(parambeib)[i] == 0)
          {
            parambeib.b();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
          }
          if (!localbeid.b(i).exists())
          {
            parambeib.b();
            return;
          }
          i += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (j < this.jdField_b_of_type_Int)
      {
        parambeib = localbeid.b(j);
        if (paramBoolean)
        {
          if (parambeib.exists())
          {
            File localFile = localbeid.a(j);
            parambeib.renameTo(localFile);
            l1 = beid.a(localbeid)[j];
            long l2 = localFile.length();
            beid.a(localbeid)[j] = l2;
            this.jdField_b_of_type_Long = (this.jdField_b_of_type_Long - l1 + l2);
          }
        }
        else {
          a(parambeib);
        }
      }
      else
      {
        this.jdField_c_of_type_Int += 1;
        beid.a(localbeid, null);
        if ((beid.a(localbeid) | paramBoolean))
        {
          beid.a(localbeid, true);
          this.jdField_a_of_type_JavaIoWriter.write("CLEAN " + beid.a(localbeid) + localbeid.a() + '\n');
          if (paramBoolean)
          {
            l1 = this.jdField_c_of_type_Long;
            this.jdField_c_of_type_Long = (1L + l1);
            beid.a(localbeid, l1);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaIoWriter.flush();
          if ((this.jdField_b_of_type_Long <= this.jdField_a_of_type_Long) && (!b())) {
            break;
          }
          this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_JavaUtilConcurrentCallable);
          break;
          this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(beid.a(localbeid));
          this.jdField_a_of_type_JavaIoWriter.write("REMOVE " + beid.a(localbeid) + '\n');
        }
      }
      j += 1;
    }
  }
  
  private static void a(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void a(String paramString)
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
        this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(str);
      }
    }
    else
    {
      str = paramString.substring(j, k);
    }
    for (;;)
    {
      beid localbeid2 = (beid)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
      beid localbeid1 = localbeid2;
      if (localbeid2 == null)
      {
        localbeid1 = new beid(this, str, null);
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, localbeid1);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        beid.a(localbeid1, true);
        beid.a(localbeid1, null);
        beid.a(localbeid1, paramString);
        return;
      }
      if ((k == -1) && (i == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        beid.a(localbeid1, new beib(this, localbeid1, null));
        return;
      }
      if ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private static String b(InputStream paramInputStream)
  {
    return beif.a(new InputStreamReader(paramInputStream, beif.b));
  }
  
  private void b(String paramString)
  {
    if (!jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString).matches()) {}
  }
  
  private boolean b()
  {
    return (this.jdField_c_of_type_Int >= 2000) && (this.jdField_c_of_type_Int >= this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: new 378	beij
    //   3: dup
    //   4: new 380	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 89	behy:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   12: invokespecial 382	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: getstatic 384	beif:a	Ljava/nio/charset/Charset;
    //   18: invokespecial 385	beij:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 386	beij:a	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_2
    //   28: invokevirtual 386	beij:a	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_2
    //   34: invokevirtual 386	beij:a	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_2
    //   40: invokevirtual 386	beij:a	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_2
    //   46: invokevirtual 386	beij:a	()Ljava/lang/String;
    //   49: astore 7
    //   51: ldc_w 388
    //   54: aload_3
    //   55: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifeq +55 -> 113
    //   61: ldc_w 394
    //   64: aload 4
    //   66: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +44 -> 113
    //   72: aload_0
    //   73: getfield 80	behy:jdField_a_of_type_Int	I
    //   76: invokestatic 398	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   79: aload 5
    //   81: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +29 -> 113
    //   87: aload_0
    //   88: getfield 99	behy:jdField_b_of_type_Int	I
    //   91: invokestatic 398	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   94: aload 6
    //   96: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +14 -> 113
    //   102: ldc_w 400
    //   105: aload 7
    //   107: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   110: ifne +77 -> 187
    //   113: new 108	java/io/IOException
    //   116: dup
    //   117: new 141	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 402
    //   127: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 404
    //   137: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 4
    //   142: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 404
    //   148: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 6
    //   153: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 404
    //   159: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 7
    //   164: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 406
    //   170: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 314	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   179: athrow
    //   180: astore_3
    //   181: aload_2
    //   182: invokestatic 409	beif:a	(Ljava/io/Closeable;)V
    //   185: aload_3
    //   186: athrow
    //   187: iconst_0
    //   188: istore_1
    //   189: aload_0
    //   190: aload_2
    //   191: invokevirtual 386	beij:a	()Ljava/lang/String;
    //   194: invokespecial 411	behy:a	(Ljava/lang/String;)V
    //   197: iload_1
    //   198: iconst_1
    //   199: iadd
    //   200: istore_1
    //   201: goto -12 -> 189
    //   204: astore_3
    //   205: aload_0
    //   206: iload_1
    //   207: aload_0
    //   208: getfield 51	behy:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   211: invokevirtual 374	java/util/LinkedHashMap:size	()I
    //   214: isub
    //   215: putfield 105	behy:jdField_c_of_type_Int	I
    //   218: aload_2
    //   219: invokevirtual 413	beij:a	()Z
    //   222: ifeq +12 -> 234
    //   225: aload_0
    //   226: invokespecial 175	behy:e	()V
    //   229: aload_2
    //   230: invokestatic 409	beif:a	(Ljava/io/Closeable;)V
    //   233: return
    //   234: aload_0
    //   235: new 415	java/io/BufferedWriter
    //   238: dup
    //   239: new 417	java/io/OutputStreamWriter
    //   242: dup
    //   243: new 419	java/io/FileOutputStream
    //   246: dup
    //   247: aload_0
    //   248: getfield 89	behy:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   251: iconst_1
    //   252: invokespecial 422	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   255: getstatic 384	beif:a	Ljava/nio/charset/Charset;
    //   258: invokespecial 425	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   261: invokespecial 428	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   264: putfield 209	behy:jdField_a_of_type_JavaIoWriter	Ljava/io/Writer;
    //   267: goto -38 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	behy
    //   188	27	1	i	int
    //   21	209	2	localbeij	beij
    //   26	105	3	str1	String
    //   180	6	3	localObject	Object
    //   204	1	3	localEOFException	java.io.EOFException
    //   31	110	4	str2	String
    //   37	43	5	str3	String
    //   43	109	6	str4	String
    //   49	114	7	str5	String
    // Exception table:
    //   from	to	target	type
    //   22	113	180	finally
    //   113	180	180	finally
    //   189	197	180	finally
    //   205	229	180	finally
    //   234	267	180	finally
    //   189	197	204	java/io/EOFException
  }
  
  private void d()
  {
    a(this.jdField_c_of_type_JavaIoFile);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      beid localbeid = (beid)localIterator.next();
      int i;
      if (beid.a(localbeid) == null)
      {
        i = 0;
        while (i < this.jdField_b_of_type_Int)
        {
          this.jdField_b_of_type_Long += beid.a(localbeid)[i];
          i += 1;
        }
      }
      else
      {
        beid.a(localbeid, null);
        i = 0;
        while (i < this.jdField_b_of_type_Int)
        {
          a(localbeid.a(i));
          a(localbeid.b(i));
          i += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoWriter != null) {
          this.jdField_a_of_type_JavaIoWriter.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jdField_c_of_type_JavaIoFile), beif.a));
        beid localbeid;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.jdField_a_of_type_Int));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.jdField_b_of_type_Int));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localbeid = (beid)localIterator.next();
          if (beid.a(localbeid) != null)
          {
            localBufferedWriter.write("DIRTY " + beid.a(localbeid) + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        localObject1.write("CLEAN " + beid.a(localbeid) + localbeid.a() + '\n');
      }
      finally {}
    }
    localObject1.close();
    if (this.jdField_b_of_type_JavaIoFile.exists()) {
      a(this.jdField_b_of_type_JavaIoFile, this.d, true);
    }
    a(this.jdField_c_of_type_JavaIoFile, this.jdField_b_of_type_JavaIoFile, false);
    this.d.delete();
    this.jdField_a_of_type_JavaIoWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jdField_b_of_type_JavaIoFile, true), beif.a));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaIoWriter == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long)
    {
      long l = this.jdField_a_of_type_Long / 2L;
      while (this.jdField_b_of_type_Long > l) {
        a((String)((Map.Entry)this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator().next()).getKey());
      }
    }
  }
  
  public long a()
  {
    try
    {
      long l = this.jdField_a_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public beib a(String paramString)
  {
    return a(paramString, -1L);
  }
  
  /* Error */
  public beie a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokespecial 179	behy:f	()V
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 181	behy:b	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 51	behy:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   18: aload_1
    //   19: invokevirtual 185	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 187	beid
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
    //   44: invokestatic 247	beid:a	(Lbeid;)Z
    //   47: ifeq -12 -> 35
    //   50: aload_0
    //   51: getfield 99	behy:jdField_b_of_type_Int	I
    //   54: anewarray 481	java/io/InputStream
    //   57: astore 5
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: aload_0
    //   63: getfield 99	behy:jdField_b_of_type_Int	I
    //   66: if_icmpge +65 -> 131
    //   69: aload 5
    //   71: iload_2
    //   72: new 380	java/io/FileInputStream
    //   75: dup
    //   76: aload 6
    //   78: iload_2
    //   79: invokevirtual 262	beid:a	(I)Ljava/io/File;
    //   82: invokespecial 382	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: aastore
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -29 -> 61
    //   93: astore_1
    //   94: iconst_0
    //   95: istore_2
    //   96: aload 4
    //   98: astore_3
    //   99: iload_2
    //   100: aload_0
    //   101: getfield 99	behy:jdField_b_of_type_Int	I
    //   104: if_icmpge -69 -> 35
    //   107: aload 4
    //   109: astore_3
    //   110: aload 5
    //   112: iload_2
    //   113: aaload
    //   114: ifnull -79 -> 35
    //   117: aload 5
    //   119: iload_2
    //   120: aaload
    //   121: invokestatic 409	beif:a	(Ljava/io/Closeable;)V
    //   124: iload_2
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: goto -32 -> 96
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 105	behy:jdField_c_of_type_Int	I
    //   136: iconst_1
    //   137: iadd
    //   138: putfield 105	behy:jdField_c_of_type_Int	I
    //   141: aload_0
    //   142: getfield 209	behy:jdField_a_of_type_JavaIoWriter	Ljava/io/Writer;
    //   145: new 141	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 483
    //   155: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: bipush 10
    //   164: invokevirtual 214	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   167: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 486	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   173: pop
    //   174: aload_0
    //   175: invokespecial 295	behy:b	()Z
    //   178: ifeq +15 -> 193
    //   181: aload_0
    //   182: getfield 69	behy:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   185: aload_0
    //   186: getfield 76	behy:jdField_a_of_type_JavaUtilConcurrentCallable	Ljava/util/concurrent/Callable;
    //   189: invokevirtual 299	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   192: pop
    //   193: new 488	beie
    //   196: dup
    //   197: aload_0
    //   198: aload_1
    //   199: aload 6
    //   201: invokestatic 192	beid:a	(Lbeid;)J
    //   204: aload 5
    //   206: aload 6
    //   208: invokestatic 269	beid:a	(Lbeid;)[J
    //   211: aconst_null
    //   212: invokespecial 491	beie:<init>	(Lbehy;Ljava/lang/String;J[Ljava/io/InputStream;[JLbehz;)V
    //   215: astore_3
    //   216: goto -181 -> 35
    //   219: astore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	behy
    //   0	224	1	paramString	String
    //   60	68	2	i	int
    //   34	182	3	localObject1	Object
    //   1	107	4	localObject2	Object
    //   57	148	5	arrayOfInputStream	InputStream[]
    //   25	182	6	localbeid	beid
    // Exception table:
    //   from	to	target	type
    //   61	86	93	java/io/FileNotFoundException
    //   5	27	219	finally
    //   42	59	219	finally
    //   61	86	219	finally
    //   99	107	219	finally
    //   117	124	219	finally
    //   131	193	219	finally
    //   193	216	219	finally
  }
  
  public Set<String> a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet();
  }
  
  public void a()
  {
    try
    {
      f();
      g();
      this.jdField_a_of_type_JavaIoWriter.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 209	behy:jdField_a_of_type_JavaIoWriter	Ljava/io/Writer;
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
    //   0	27	0	this	behy
    //   12	7	1	bool	boolean
    //   6	2	2	localWriter	Writer
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public boolean a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        f();
        b(paramString);
        beid localbeid = (beid)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
        Object localObject;
        if (localbeid != null)
        {
          localObject = beid.a(localbeid);
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.jdField_b_of_type_Long -= beid.a(localbeid)[i];
          beid.a(localbeid)[i] = 0L;
          i += 1;
        }
        if (i < this.jdField_b_of_type_Int)
        {
          localObject = localbeid.a(i);
          if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.jdField_c_of_type_Int += 1;
      this.jdField_a_of_type_JavaIoWriter.append("REMOVE " + paramString + '\n');
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
      if (b()) {
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_JavaUtilConcurrentCallable);
      }
      boolean bool = true;
    }
  }
  
  public long b()
  {
    try
    {
      long l = this.jdField_b_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    close();
    beif.a(this.jdField_a_of_type_JavaIoFile);
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_JavaIoWriter;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          beid localbeid = (beid)((Iterator)localObject1).next();
          if (beid.a(localbeid) == null) {
            continue;
          }
          beid.a(localbeid).b();
          continue;
        }
        g();
      }
      finally {}
      this.jdField_a_of_type_JavaIoWriter.close();
      this.jdField_a_of_type_JavaIoWriter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     behy
 * JD-Core Version:    0.7.0.1
 */