package com.b.a.a;

import android.os.SystemClock;
import com.b.a.b;
import com.b.a.b.a;
import com.b.a.j;
import com.b.a.u;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public class d
  implements b
{
  private final Map<String, d.a> a = new LinkedHashMap(16, 0.75F, true);
  private long b = 0L;
  private final File c;
  private final int d;
  
  public d(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  private d(File paramFile, int paramInt)
  {
    this.c = paramFile;
    this.d = 5242880;
  }
  
  static int a(InputStream paramInputStream)
  {
    int i = c(paramInputStream);
    int j = c(paramInputStream);
    int k = c(paramInputStream);
    return c(paramInputStream) << 24 | i | 0x0 | j << 8 | k << 16;
  }
  
  public static b.a a(j paramj)
  {
    long l6 = System.currentTimeMillis();
    Map localMap = paramj.b;
    Object localObject1 = (String)localMap.get("Date");
    long l3;
    if (localObject1 != null) {
      l3 = b((String)localObject1);
    } else {
      l3 = 0L;
    }
    localObject1 = (String)localMap.get("Cache-Control");
    int i = 0;
    int j = 0;
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split(",");
      l2 = 0L;
      i = 0;
      l1 = 0L;
      for (;;)
      {
        label82:
        if (j < localObject1.length)
        {
          localObject2 = localObject1[j].trim();
          if ((!((String)localObject2).equals("no-cache")) && (!((String)localObject2).equals("no-store")) && (!((String)localObject2).startsWith("max-age="))) {
            break;
          }
        }
      }
    }
    try
    {
      l4 = Long.parseLong(((String)localObject2).substring(8));
      l5 = l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l4 = l2;
        long l5 = l1;
      }
    }
    if (((String)localObject2).startsWith("stale-while-revalidate="))
    {
      l5 = Long.parseLong(((String)localObject2).substring(23));
      l4 = l2;
    }
    else if (!((String)localObject2).equals("must-revalidate"))
    {
      l4 = l2;
      l5 = l1;
      if (!((String)localObject2).equals("proxy-revalidate")) {}
    }
    else
    {
      i = 1;
      l5 = l1;
      l4 = l2;
    }
    j += 1;
    l2 = l4;
    l1 = l5;
    break label82;
    return null;
    j = 1;
    break label242;
    l2 = 0L;
    l1 = 0L;
    j = 0;
    label242:
    localObject1 = (String)localMap.get("Expires");
    if (localObject1 != null) {
      l5 = b((String)localObject1);
    } else {
      l5 = 0L;
    }
    localObject1 = (String)localMap.get("Last-Modified");
    if (localObject1 != null) {
      l4 = b((String)localObject1);
    } else {
      l4 = 0L;
    }
    localObject1 = (String)localMap.get("ETag");
    if (j != 0)
    {
      l2 = l6 + l2 * 1000L;
      if (i != 0)
      {
        l1 = l2;
      }
      else
      {
        Long.signum(l1);
        l5 = l1 * 1000L + l2;
        l1 = l2;
        l2 = l5;
        break label406;
      }
    }
    else
    {
      if ((l3 > 0L) && (l5 >= l3))
      {
        l2 = l5 - l3 + l6;
        l1 = l2;
        break label406;
      }
      l1 = 0L;
    }
    l2 = l1;
    label406:
    Object localObject2 = new b.a();
    ((b.a)localObject2).a = paramj.a;
    ((b.a)localObject2).b = ((String)localObject1);
    ((b.a)localObject2).f = l1;
    ((b.a)localObject2).e = l2;
    ((b.a)localObject2).c = l3;
    ((b.a)localObject2).d = l4;
    ((b.a)localObject2).g = localMap;
    return localObject2;
  }
  
  private static InputStream a(File paramFile)
  {
    return new FileInputStream(paramFile);
  }
  
  static String a(long paramLong)
  {
    return b().format(new Date(paramLong));
  }
  
  static String a(d.b paramb)
  {
    return new String(a(paramb, b(paramb)), "UTF-8");
  }
  
  public static String a(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("Content-Type");
    if (paramMap != null)
    {
      paramMap = paramMap.split(";");
      int i = 1;
      while (i < paramMap.length)
      {
        String[] arrayOfString = paramMap[i].trim().split("=");
        if ((arrayOfString.length == 2) && (arrayOfString[0].equals("charset"))) {
          return arrayOfString[1];
        }
        i += 1;
      }
    }
    return "ISO-8859-1";
  }
  
  static void a(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >>> 24);
  }
  
  static void a(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((byte)(int)paramLong);
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void a(OutputStream paramOutputStream, String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    a(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  private void a(String paramString, d.a parama)
  {
    if (!this.a.containsKey(paramString))
    {
      this.b += parama.a;
    }
    else
    {
      d.a locala = (d.a)this.a.get(paramString);
      this.b += parama.a - locala.a;
    }
    this.a.put(paramString, parama);
  }
  
  private static byte[] a(d.b paramb, long paramLong)
  {
    long l = paramb.a();
    if ((paramLong >= 0L) && (paramLong <= l))
    {
      int i = (int)paramLong;
      if (i == paramLong)
      {
        byte[] arrayOfByte = new byte[i];
        new DataInputStream(paramb).readFully(arrayOfByte);
        return arrayOfByte;
      }
    }
    paramb = new StringBuilder("streamToBytes length=");
    paramb.append(paramLong);
    paramb.append(", maxLength=");
    paramb.append(l);
    throw new IOException(paramb.toString());
  }
  
  static long b(InputStream paramInputStream)
  {
    return c(paramInputStream) & 0xFF | 0L | (c(paramInputStream) & 0xFF) << 8 | (c(paramInputStream) & 0xFF) << 16 | (c(paramInputStream) & 0xFF) << 24 | (c(paramInputStream) & 0xFF) << 32 | (c(paramInputStream) & 0xFF) << 40 | (c(paramInputStream) & 0xFF) << 48 | (0xFF & c(paramInputStream)) << 56;
  }
  
  public static long b(String paramString)
  {
    try
    {
      long l = b().parse(paramString).getTime();
      return l;
    }
    catch (ParseException localParseException)
    {
      u.a(localParseException, "Unable to parse dateStr: %s, falling back to 0", new Object[] { paramString });
    }
    return 0L;
  }
  
  private static SimpleDateFormat b()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat;
  }
  
  static Map<String, String> b(d.b paramb)
  {
    int j = a(paramb);
    Object localObject;
    if (j == 0) {
      localObject = Collections.emptyMap();
    } else {
      localObject = new HashMap(j);
    }
    int i = 0;
    while (i < j)
    {
      ((Map)localObject).put(a(paramb).intern(), a(paramb).intern());
      i += 1;
    }
    return localObject;
  }
  
  private static int c(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    if (i != -1) {
      return i;
    }
    throw new EOFException();
  }
  
  private void c(String paramString)
  {
    try
    {
      boolean bool = e(paramString).delete();
      f(paramString);
      if (!bool) {
        u.b("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, d(paramString) });
      }
      return;
    }
    finally {}
  }
  
  private static String d(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append(String.valueOf(paramString.substring(i).hashCode()));
    return localStringBuilder.toString();
  }
  
  private File e(String paramString)
  {
    return new File(this.c, d(paramString));
  }
  
  private void f(String paramString)
  {
    paramString = (d.a)this.a.remove(paramString);
    if (paramString != null) {
      this.b -= paramString.a;
    }
  }
  
  /* Error */
  public final b.a a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/b/a/a/d:a	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 63 2 0
    //   12: checkcast 213	com/b/a/a/d$a
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +7 -> 26
    //   22: aload_0
    //   23: monitorexit
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 326	com/b/a/a/d:e	(Ljava/lang/String;)Ljava/io/File;
    //   31: astore_2
    //   32: new 221	com/b/a/a/d$b
    //   35: dup
    //   36: new 364	java/io/BufferedInputStream
    //   39: dup
    //   40: aload_2
    //   41: invokestatic 366	com/b/a/a/d:a	(Ljava/io/File;)Ljava/io/InputStream;
    //   44: invokespecial 367	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: aload_2
    //   48: invokevirtual 369	java/io/File:length	()J
    //   51: invokespecial 372	com/b/a/a/d$b:<init>	(Ljava/io/InputStream;J)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokestatic 375	com/b/a/a/d$a:a	(Lcom/b/a/a/d$b;)Lcom/b/a/a/d$a;
    //   59: astore 5
    //   61: aload_1
    //   62: aload 5
    //   64: getfield 376	com/b/a/a/d$a:b	Ljava/lang/String;
    //   67: invokestatic 381	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   70: ifne +45 -> 115
    //   73: ldc_w 383
    //   76: iconst_3
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_2
    //   83: invokevirtual 386	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload_1
    //   90: aastore
    //   91: dup
    //   92: iconst_2
    //   93: aload 5
    //   95: getfield 376	com/b/a/a/d$a:b	Ljava/lang/String;
    //   98: aastore
    //   99: invokestatic 342	com/b/a/u:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_0
    //   103: aload_1
    //   104: invokespecial 334	com/b/a/a/d:f	(Ljava/lang/String;)V
    //   107: aload_3
    //   108: invokevirtual 389	com/b/a/a/d$b:close	()V
    //   111: aload_0
    //   112: monitorexit
    //   113: aconst_null
    //   114: areturn
    //   115: aload_3
    //   116: aload_3
    //   117: invokevirtual 223	com/b/a/a/d$b:a	()J
    //   120: invokestatic 171	com/b/a/a/d:a	(Lcom/b/a/a/d$b;J)[B
    //   123: astore 5
    //   125: new 123	com/b/a/b$a
    //   128: dup
    //   129: invokespecial 124	com/b/a/b$a:<init>	()V
    //   132: astore 6
    //   134: aload 6
    //   136: aload 5
    //   138: putfield 128	com/b/a/b$a:a	[B
    //   141: aload 6
    //   143: aload 4
    //   145: getfield 391	com/b/a/a/d$a:c	Ljava/lang/String;
    //   148: putfield 131	com/b/a/b$a:b	Ljava/lang/String;
    //   151: aload 6
    //   153: aload 4
    //   155: getfield 392	com/b/a/a/d$a:d	J
    //   158: putfield 139	com/b/a/b$a:c	J
    //   161: aload 6
    //   163: aload 4
    //   165: getfield 393	com/b/a/a/d$a:e	J
    //   168: putfield 141	com/b/a/b$a:d	J
    //   171: aload 6
    //   173: aload 4
    //   175: getfield 394	com/b/a/a/d$a:f	J
    //   178: putfield 137	com/b/a/b$a:e	J
    //   181: aload 6
    //   183: aload 4
    //   185: getfield 396	com/b/a/a/d$a:g	J
    //   188: putfield 134	com/b/a/b$a:f	J
    //   191: aload 6
    //   193: aload 4
    //   195: getfield 399	com/b/a/a/d$a:h	Ljava/util/Map;
    //   198: putfield 144	com/b/a/b$a:g	Ljava/util/Map;
    //   201: aload_3
    //   202: invokevirtual 389	com/b/a/a/d$b:close	()V
    //   205: aload_0
    //   206: monitorexit
    //   207: aload 6
    //   209: areturn
    //   210: astore 4
    //   212: aload_3
    //   213: invokevirtual 389	com/b/a/a/d$b:close	()V
    //   216: aload 4
    //   218: athrow
    //   219: astore_3
    //   220: ldc_w 401
    //   223: iconst_2
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_2
    //   230: invokevirtual 386	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: aload_3
    //   237: invokevirtual 402	java/io/IOException:toString	()Ljava/lang/String;
    //   240: aastore
    //   241: invokestatic 342	com/b/a/u:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload_0
    //   245: aload_1
    //   246: invokespecial 404	com/b/a/a/d:c	(Ljava/lang/String;)V
    //   249: aload_0
    //   250: monitorexit
    //   251: aconst_null
    //   252: areturn
    //   253: astore_1
    //   254: aload_0
    //   255: monitorexit
    //   256: aload_1
    //   257: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	d
    //   0	258	1	paramString	String
    //   31	199	2	localFile	File
    //   54	159	3	localb	d.b
    //   219	18	3	localIOException	IOException
    //   15	179	4	locala	d.a
    //   210	7	4	localObject1	Object
    //   59	78	5	localObject2	Object
    //   132	76	6	locala1	b.a
    // Exception table:
    //   from	to	target	type
    //   55	107	210	finally
    //   115	201	210	finally
    //   32	55	219	java/io/IOException
    //   107	111	219	java/io/IOException
    //   201	205	219	java/io/IOException
    //   212	219	219	java/io/IOException
    //   2	17	253	finally
    //   26	32	253	finally
    //   32	55	253	finally
    //   107	111	253	finally
    //   201	205	253	finally
    //   212	219	253	finally
    //   220	249	253	finally
  }
  
  public final void a()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.c.exists();
        i = 0;
        if (!bool)
        {
          if (!this.c.mkdirs()) {
            u.c("Unable to create cache dir %s", new Object[] { this.c.getAbsolutePath() });
          }
          return;
        }
        File[] arrayOfFile = this.c.listFiles();
        if (arrayOfFile == null) {
          return;
        }
        int j = arrayOfFile.length;
        if (i < j) {
          localFile = arrayOfFile[i];
        }
      }
      finally
      {
        int i;
        File localFile;
        long l;
        d.b localb;
        d.a locala;
        continue;
        throw localObject1;
        continue;
      }
      try
      {
        l = localFile.length();
        localb = new d.b(new BufferedInputStream(a(localFile)), l);
      }
      catch (IOException localIOException)
      {
        continue;
      }
      try
      {
        locala = d.a.a(localb);
        locala.a = l;
        a(locala.b, locala);
        localb.close();
      }
      finally
      {
        localb.close();
      }
      i += 1;
    }
  }
  
  public final void a(String paramString, b.a parama)
  {
    try
    {
      i = parama.a.length;
      l1 = this.b;
      long l2 = i;
      if (l1 + l2 < this.d) {
        break label255;
      }
      if (u.a) {
        u.a("Pruning old cache entries.", new Object[0]);
      }
      l1 = this.b;
      l3 = SystemClock.elapsedRealtime();
      localObject1 = this.a.entrySet().iterator();
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label400;
        }
        localObject2 = (d.a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (e(((d.a)localObject2).b).delete()) {
          this.b -= ((d.a)localObject2).a;
        } else {
          u.b("Could not delete cache entry for key=%s, filename=%s", new Object[] { ((d.a)localObject2).b, d(((d.a)localObject2).b) });
        }
        ((Iterator)localObject1).remove();
        i += 1;
        j = i;
        if ((float)(this.b + l2) < this.d * 0.9F) {
          break;
        }
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        long l1;
        long l3;
        Object localObject1;
        Object localObject2;
        label356:
        for (;;)
        {
          label255:
          throw paramString;
        }
        label400:
        int j = i;
      }
    }
    if (u.a) {
      u.a("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(j), Long.valueOf(this.b - l1), Long.valueOf(SystemClock.elapsedRealtime() - l3) });
    }
    localObject1 = e(paramString);
    try
    {
      localObject2 = new BufferedOutputStream(new FileOutputStream((File)localObject1));
      d.a locala = new d.a(paramString, parama);
      if (locala.a((OutputStream)localObject2))
      {
        ((BufferedOutputStream)localObject2).write(parama.a);
        ((BufferedOutputStream)localObject2).close();
        a(paramString, locala);
        return;
      }
      ((BufferedOutputStream)localObject2).close();
      u.b("Failed to write header for %s", new Object[] { ((File)localObject1).getAbsolutePath() });
      throw new IOException();
    }
    catch (IOException paramString)
    {
      break label356;
    }
    if (!((File)localObject1).delete()) {
      u.b("Could not clean up file %s", new Object[] { ((File)localObject1).getAbsolutePath() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */