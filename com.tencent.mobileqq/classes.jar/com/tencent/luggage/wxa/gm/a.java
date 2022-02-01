package com.tencent.luggage.wxa.gm;

import com.tencent.luggage.wxa.gw.b;
import com.tencent.luggage.wxa.rt.i;
import java.io.IOException;
import java.io.RandomAccessFile;

public class a
{
  private RandomAccessFile a = null;
  private String b;
  private String c;
  private String d;
  
  public a(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.b = paramString2;
    this.d = a(paramString1, this.b);
    b.b("MicroMsg.Mix.AudioPcmCacheFile", "AudioPcmCacheFile mUrl:%s, fileName:%s,", new Object[] { this.b, this.d });
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return com.tencent.luggage.wxa.gw.a.a(paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteFile, fileName:");
    localStringBuilder.append(paramString);
    b.b("MicroMsg.Mix.AudioPcmCacheFile", localStringBuilder.toString());
    paramString = new i(paramString);
    if (paramString.j())
    {
      b.b("MicroMsg.Mix.AudioPcmCacheFile", "delete the piece File");
      paramString.w();
      return;
    }
    b.a("MicroMsg.Mix.AudioPcmCacheFile", "file not exist, delete piece File fail");
  }
  
  public int a(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      b.a("MicroMsg.Mix.AudioPcmCacheFile", "read error, length == 0");
      return -1;
    }
    finally {}
    if (this.a == null)
    {
      b.a("MicroMsg.Mix.AudioPcmCacheFile", "read error, randomAccessFile is null");
      return -1;
    }
    try
    {
      this.a.seek(paramLong);
      int i = this.a.read(paramArrayOfByte, 0, paramInt);
      return i;
    }
    catch (IOException localIOException)
    {
      label62:
      break label62;
    }
    b.a("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(c()), Integer.valueOf(paramArrayOfByte.length) }));
    return -1;
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (this.a == null)
      {
        b.a("MicroMsg.Mix.AudioPcmCacheFile", "setLength error, randomAccessFile is null");
        return;
      }
      if (paramLong <= 0L)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("setLength error, length is ");
        localStringBuilder1.append(paramLong);
        b.a("MicroMsg.Mix.AudioPcmCacheFile", localStringBuilder1.toString());
        return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("");
      localStringBuilder1.append(paramLong);
      b.a("MicroMsg.Mix.AudioPcmCacheFile", "set file length %s ", new Object[] { localStringBuilder1.toString() });
      try
      {
        this.a.setLength(paramLong);
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(localIOException.getMessage());
        b.a("MicroMsg.Mix.AudioPcmCacheFile", "Error set length of file, err %s", new Object[] { localStringBuilder2.toString() });
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: ldc 28
    //   2: ldc 136
    //   4: invokestatic 55	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: new 57	com/tencent/luggage/wxa/rt/i
    //   10: dup
    //   11: aload_0
    //   12: getfield 26	com/tencent/luggage/wxa/gm/a:d	Ljava/lang/String;
    //   15: invokespecial 59	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 63	com/tencent/luggage/wxa/rt/i:j	()Z
    //   23: ifne +27 -> 50
    //   26: ldc 28
    //   28: ldc 138
    //   30: iconst_1
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: invokevirtual 141	com/tencent/luggage/wxa/rt/i:v	()Z
    //   40: invokestatic 146	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   43: aastore
    //   44: invokestatic 35	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: goto +8 -> 55
    //   50: aload_1
    //   51: invokevirtual 68	com/tencent/luggage/wxa/rt/i:w	()Z
    //   54: pop
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 148	com/tencent/luggage/wxa/rt/i:b	()Ljava/lang/String;
    //   60: iconst_1
    //   61: invokestatic 153	com/tencent/luggage/wxa/rt/k:b	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   64: putfield 17	com/tencent/luggage/wxa/gm/a:a	Ljava/io/RandomAccessFile;
    //   67: ldc 28
    //   69: ldc 155
    //   71: iconst_1
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: getfield 26	com/tencent/luggage/wxa/gm/a:d	Ljava/lang/String;
    //   81: aastore
    //   82: invokestatic 124	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_1
    //   88: goto +75 -> 163
    //   91: astore_1
    //   92: ldc 28
    //   94: ldc 157
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_1
    //   103: aastore
    //   104: invokestatic 124	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: ldc 28
    //   109: ldc 155
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_0
    //   118: getfield 26	com/tencent/luggage/wxa/gm/a:d	Ljava/lang/String;
    //   121: aastore
    //   122: invokestatic 124	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_1
    //   128: ldc 28
    //   130: ldc 159
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_1
    //   139: aastore
    //   140: invokestatic 124	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: ldc 28
    //   145: ldc 155
    //   147: iconst_1
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_0
    //   154: getfield 26	com/tencent/luggage/wxa/gm/a:d	Ljava/lang/String;
    //   157: aastore
    //   158: invokestatic 124	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: iconst_0
    //   162: ireturn
    //   163: ldc 28
    //   165: ldc 155
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_0
    //   174: getfield 26	com/tencent/luggage/wxa/gm/a:d	Ljava/lang/String;
    //   177: aastore
    //   178: invokestatic 124	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	a
    //   18	39	1	locali	i
    //   87	1	1	localObject	Object
    //   91	12	1	localIOException	IOException
    //   127	55	1	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   7	47	87	finally
    //   50	55	87	finally
    //   55	67	87	finally
    //   92	107	87	finally
    //   128	143	87	finally
    //   7	47	91	java/io/IOException
    //   50	55	91	java/io/IOException
    //   55	67	91	java/io/IOException
    //   7	47	127	java/io/FileNotFoundException
    //   50	55	127	java/io/FileNotFoundException
    //   55	67	127	java/io/FileNotFoundException
  }
  
  public void b()
  {
    try
    {
      b.b("MicroMsg.Mix.AudioPcmCacheFile", "close");
      RandomAccessFile localRandomAccessFile = this.a;
      if (localRandomAccessFile != null) {
        try
        {
          this.a.close();
        }
        catch (IOException localIOException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(localIOException.getMessage());
          b.a("MicroMsg.Mix.AudioPcmCacheFile", "close RandomAccessFile error ", new Object[] { localStringBuilder.toString() });
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean b(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      b.a("MicroMsg.Mix.AudioPcmCacheFile", "write error, length == 0");
      return false;
    }
    finally {}
    if (this.a == null)
    {
      b.a("MicroMsg.Mix.AudioPcmCacheFile", "write error, randomAccessFile is null");
      return false;
    }
    try
    {
      this.a.seek(paramLong);
      this.a.write(paramArrayOfByte, 0, paramInt);
      return true;
    }
    catch (IOException localIOException)
    {
      label59:
      break label59;
    }
    b.a("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error writing %d bytes to from buffer with size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) }));
    return false;
  }
  
  /* Error */
  public int c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/tencent/luggage/wxa/gm/a:a	Ljava/io/RandomAccessFile;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 28
    //   11: ldc 178
    //   13: invokestatic 72	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_m1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 17	com/tencent/luggage/wxa/gm/a:a	Ljava/io/RandomAccessFile;
    //   24: invokevirtual 182	java/io/RandomAccessFile:length	()J
    //   27: lstore_2
    //   28: lload_2
    //   29: l2i
    //   30: istore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: astore 4
    //   37: new 42	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: ldc 120
    //   50: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 5
    //   56: aload 4
    //   58: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
    //   61: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 28
    //   67: ldc 184
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload 5
    //   77: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: aastore
    //   81: invokestatic 124	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: monitorexit
    //   86: iconst_m1
    //   87: ireturn
    //   88: astore 4
    //   90: aload_0
    //   91: monitorexit
    //   92: aload 4
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	a
    //   30	4	1	i	int
    //   27	2	2	l	long
    //   35	22	4	localIOException	IOException
    //   88	5	4	localObject	Object
    //   44	32	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	28	35	java/io/IOException
    //   2	16	88	finally
    //   20	28	88	finally
    //   37	84	88	finally
  }
  
  public void d()
  {
    b.b("MicroMsg.Mix.AudioPcmCacheFile", "deleteFile");
    a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gm.a
 * JD-Core Version:    0.7.0.1
 */