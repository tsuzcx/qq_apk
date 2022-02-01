package com.tencent.luggage.wxa.qg;

import com.tencent.luggage.wxa.qq.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;

public class h
{
  private RandomAccessFile a = null;
  private String b;
  private String c;
  
  public h(String paramString)
  {
    this.b = paramString;
    this.c = a(this.b);
    o.d("MicroMsg.Music.PieceFileCache", "PieceFileCache mUrl:%s, fileName:%s,", new Object[] { this.b, this.c });
  }
  
  public static String a(String paramString)
  {
    return b.b(paramString);
  }
  
  public static long b(String paramString)
  {
    paramString = new i(a(paramString));
    if (paramString.j()) {
      return paramString.q();
    }
    return -1L;
  }
  
  public static void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteFile, fileName:");
    localStringBuilder.append(paramString);
    Logger.i("MicroMsg.Music.PieceFileCache", localStringBuilder.toString());
    paramString = new i(paramString);
    if (paramString.j())
    {
      Logger.i("MicroMsg.Music.PieceFileCache", "delete the piece File");
      paramString.w();
      return;
    }
    Logger.e("MicroMsg.Music.PieceFileCache", "file not exist, delete piece File fail");
  }
  
  public static void d(String paramString)
  {
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    c(a(paramString));
  }
  
  public static boolean e(String paramString)
  {
    Logger.i("MicroMsg.Music.PieceFileCache", "existFileByUrl");
    return f(a(paramString));
  }
  
  public static boolean f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("existFile, fileName:");
    localStringBuilder.append(paramString);
    Logger.i("MicroMsg.Music.PieceFileCache", localStringBuilder.toString());
    boolean bool = new i(paramString).j();
    o.d("MicroMsg.Music.PieceFileCache", "the piece File exist:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public int a(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      Logger.e("MicroMsg.Music.PieceFileCache", "read error, length == 0");
      return -1;
    }
    finally {}
    if (this.a == null)
    {
      Logger.e("MicroMsg.Music.PieceFileCache", "read error, randomAccessFile is null");
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
    Logger.e("MicroMsg.Music.PieceFileCache", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(c()), Integer.valueOf(paramArrayOfByte.length) }));
    return -1;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: ldc 25
    //   2: ldc 144
    //   4: invokestatic 72	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: new 41	com/tencent/luggage/wxa/rt/i
    //   10: dup
    //   11: aload_0
    //   12: getfield 23	com/tencent/luggage/wxa/qg/h:c	Ljava/lang/String;
    //   15: invokespecial 43	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 47	com/tencent/luggage/wxa/rt/i:j	()Z
    //   23: ifne +24 -> 47
    //   26: ldc 25
    //   28: ldc 146
    //   30: iconst_1
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: invokevirtual 149	com/tencent/luggage/wxa/rt/i:v	()Z
    //   40: invokestatic 102	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   43: aastore
    //   44: invokestatic 33	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 151	com/tencent/luggage/wxa/rt/i:b	()Ljava/lang/String;
    //   52: iconst_1
    //   53: invokestatic 156	com/tencent/luggage/wxa/rt/k:b	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   56: putfield 16	com/tencent/luggage/wxa/qg/h:a	Ljava/io/RandomAccessFile;
    //   59: ldc 25
    //   61: ldc 158
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_0
    //   70: getfield 23	com/tencent/luggage/wxa/qg/h:c	Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 160	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: return
    //   78: astore_1
    //   79: goto +59 -> 138
    //   82: astore_1
    //   83: ldc 25
    //   85: ldc 162
    //   87: aload_1
    //   88: invokestatic 165	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: ldc 25
    //   93: ldc 158
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_0
    //   102: getfield 23	com/tencent/luggage/wxa/qg/h:c	Ljava/lang/String;
    //   105: aastore
    //   106: invokestatic 160	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: return
    //   110: astore_1
    //   111: ldc 25
    //   113: ldc 167
    //   115: aload_1
    //   116: invokestatic 165	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: ldc 25
    //   121: ldc 158
    //   123: iconst_1
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_0
    //   130: getfield 23	com/tencent/luggage/wxa/qg/h:c	Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 160	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: return
    //   138: ldc 25
    //   140: ldc 158
    //   142: iconst_1
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_0
    //   149: getfield 23	com/tencent/luggage/wxa/qg/h:c	Ljava/lang/String;
    //   152: aastore
    //   153: invokestatic 160	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	h
    //   18	31	1	locali	i
    //   78	1	1	localObject	Object
    //   82	6	1	localIOException	IOException
    //   110	47	1	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   7	47	78	finally
    //   47	59	78	finally
    //   83	91	78	finally
    //   111	119	78	finally
    //   7	47	82	java/io/IOException
    //   47	59	82	java/io/IOException
    //   7	47	110	java/io/FileNotFoundException
    //   47	59	110	java/io/FileNotFoundException
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (this.a == null)
      {
        Logger.e("MicroMsg.Music.PieceFileCache", "setLength error, randomAccessFile is null");
        return;
      }
      if (paramLong <= 0L)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("setLength error, length is ");
        localStringBuilder1.append(paramLong);
        Logger.e("MicroMsg.Music.PieceFileCache", localStringBuilder1.toString());
        return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("");
      localStringBuilder1.append(paramLong);
      Logger.e("MicroMsg.Music.PieceFileCache", "set file length %s ", new Object[] { localStringBuilder1.toString() });
      try
      {
        this.a.setLength(paramLong);
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(localIOException.getMessage());
        Logger.e("MicroMsg.Music.PieceFileCache", "Error set length of file, err %s", new Object[] { localStringBuilder2.toString() });
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      Logger.i("MicroMsg.Music.PieceFileCache", "close");
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
          Logger.e("MicroMsg.Music.PieceFileCache", "close RandomAccessFile error ", new Object[] { localStringBuilder.toString() });
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
      Logger.e("MicroMsg.Music.PieceFileCache", "write error, length == 0");
      return false;
    }
    finally {}
    if (this.a == null)
    {
      Logger.e("MicroMsg.Music.PieceFileCache", "write error, randomAccessFile is null");
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
    Logger.e("MicroMsg.Music.PieceFileCache", String.format("Error writing %d bytes to from buffer with size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) }));
    return false;
  }
  
  /* Error */
  public int c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/tencent/luggage/wxa/qg/h:a	Ljava/io/RandomAccessFile;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 25
    //   11: ldc 205
    //   13: invokestatic 82	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_m1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 16	com/tencent/luggage/wxa/qg/h:a	Ljava/io/RandomAccessFile;
    //   24: invokevirtual 208	java/io/RandomAccessFile:length	()J
    //   27: lstore_2
    //   28: lload_2
    //   29: l2i
    //   30: istore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: astore 4
    //   37: new 55	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: ldc 176
    //   50: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 5
    //   56: aload 4
    //   58: invokevirtual 184	java/io/IOException:getMessage	()Ljava/lang/String;
    //   61: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 25
    //   67: ldc 210
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload 5
    //   77: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: aastore
    //   81: invokestatic 160	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	95	0	this	h
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
  
  public boolean d()
  {
    return new i(this.c).j();
  }
  
  public void e()
  {
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile");
    c(this.c);
  }
  
  public long f()
  {
    try
    {
      i locali = new i(this.c);
      if (locali.j())
      {
        long l = locali.q();
        return l;
      }
      return -1L;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qg.h
 * JD-Core Version:    0.7.0.1
 */