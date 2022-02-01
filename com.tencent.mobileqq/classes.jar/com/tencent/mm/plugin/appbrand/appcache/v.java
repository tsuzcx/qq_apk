package com.tencent.mm.plugin.appbrand.appcache;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iw.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class v
  implements Closeable
{
  public static final ByteOrder a = ByteOrder.BIG_ENDIAN;
  private final i b;
  private volatile RandomAccessFile c;
  private volatile FileChannel d = null;
  private volatile boolean e = true;
  private volatile Map<String, v.a> f = null;
  private volatile FileStructStat g;
  private volatile com.tencent.luggage.wxa.iw.a h;
  
  public v(i parami)
  {
    this.b = parami;
    h();
  }
  
  public v(String paramString)
  {
    this(new i(paramString));
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: new 2	com/tencent/mm/plugin/appbrand/appcache/v
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 58	com/tencent/mm/plugin/appbrand/appcache/v:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: aload_3
    //   14: invokevirtual 61	com/tencent/mm/plugin/appbrand/appcache/v:c	()Z
    //   17: ifeq +13 -> 30
    //   20: aload_2
    //   21: astore_0
    //   22: aload_3
    //   23: invokevirtual 64	com/tencent/mm/plugin/appbrand/appcache/v:d	()I
    //   26: istore_1
    //   27: goto +5 -> 32
    //   30: iconst_0
    //   31: istore_1
    //   32: aload_3
    //   33: invokevirtual 67	com/tencent/mm/plugin/appbrand/appcache/v:close	()V
    //   36: iload_1
    //   37: ireturn
    //   38: astore_2
    //   39: goto +8 -> 47
    //   42: astore_2
    //   43: aload_2
    //   44: astore_0
    //   45: aload_2
    //   46: athrow
    //   47: aload_0
    //   48: ifnull +10 -> 58
    //   51: aload_3
    //   52: invokevirtual 67	com/tencent/mm/plugin/appbrand/appcache/v:close	()V
    //   55: goto +7 -> 62
    //   58: aload_3
    //   59: invokevirtual 67	com/tencent/mm/plugin/appbrand/appcache/v:close	()V
    //   62: aload_2
    //   63: athrow
    //   64: astore_0
    //   65: goto -3 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramString	String
    //   26	11	1	i	int
    //   10	11	2	localObject1	Object
    //   38	1	2	localObject2	Object
    //   42	21	2	localThrowable	java.lang.Throwable
    //   8	51	3	localv	v
    // Exception table:
    //   from	to	target	type
    //   13	20	38	finally
    //   22	27	38	finally
    //   45	47	38	finally
    //   13	20	42	java/lang/Throwable
    //   22	27	42	java/lang/Throwable
    //   51	55	64	java/lang/Throwable
  }
  
  /* Error */
  private InputStream a(@NonNull v.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mm/plugin/appbrand/appcache/v:b	Lcom/tencent/luggage/wxa/rt/i;
    //   4: invokevirtual 74	com/tencent/luggage/wxa/rt/i:b	()Ljava/lang/String;
    //   7: iconst_0
    //   8: invokestatic 79	com/tencent/luggage/wxa/rt/k:b	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_1
    //   15: getfield 84	com/tencent/mm/plugin/appbrand/appcache/v$a:d	I
    //   18: newarray byte
    //   20: astore 4
    //   22: aload_3
    //   23: astore_2
    //   24: aload_3
    //   25: aload_1
    //   26: getfield 86	com/tencent/mm/plugin/appbrand/appcache/v$a:c	I
    //   29: i2l
    //   30: invokevirtual 92	java/io/RandomAccessFile:seek	(J)V
    //   33: aload_3
    //   34: astore_2
    //   35: aload_3
    //   36: aload 4
    //   38: invokevirtual 96	java/io/RandomAccessFile:readFully	([B)V
    //   41: aload_3
    //   42: astore_2
    //   43: new 98	java/io/ByteArrayInputStream
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 100	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: astore 4
    //   54: aload_3
    //   55: invokestatic 105	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   58: aload 4
    //   60: areturn
    //   61: astore 4
    //   63: goto +13 -> 76
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_2
    //   69: goto +49 -> 118
    //   72: astore 4
    //   74: aconst_null
    //   75: astore_3
    //   76: aload_3
    //   77: astore_2
    //   78: ldc 107
    //   80: ldc 109
    //   82: iconst_3
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_0
    //   89: getfield 45	com/tencent/mm/plugin/appbrand/appcache/v:b	Lcom/tencent/luggage/wxa/rt/i;
    //   92: invokevirtual 74	com/tencent/luggage/wxa/rt/i:b	()Ljava/lang/String;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_1
    //   99: getfield 112	com/tencent/mm/plugin/appbrand/appcache/v$a:b	Ljava/lang/String;
    //   102: aastore
    //   103: dup
    //   104: iconst_2
    //   105: aload 4
    //   107: aastore
    //   108: invokestatic 117	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_3
    //   112: invokestatic 105	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: aload_2
    //   119: invokestatic 105	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	v
    //   0	124	1	parama	v.a
    //   13	106	2	localRandomAccessFile1	RandomAccessFile
    //   11	101	3	localRandomAccessFile2	RandomAccessFile
    //   20	39	4	localObject	Object
    //   61	1	4	localException1	Exception
    //   72	34	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   14	22	61	java/lang/Exception
    //   24	33	61	java/lang/Exception
    //   35	41	61	java/lang/Exception
    //   43	54	61	java/lang/Exception
    //   0	12	66	finally
    //   0	12	72	java/lang/Exception
    //   14	22	117	finally
    //   24	33	117	finally
    //   35	41	117	finally
    //   43	54	117	finally
    //   78	111	117	finally
  }
  
  private void h()
  {
    boolean bool;
    if ((i()) && (j())) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
  }
  
  private boolean i()
  {
    i locali = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locali != null)
    {
      if (!locali.j()) {
        return false;
      }
      bool1 = bool2;
      if (this.b.q() > 14L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean j()
  {
    l();
    if (this.d == null) {
      return false;
    }
    int i = k();
    if (i < 0)
    {
      o.b("MicroMsg.AppBrandWxaPkg", "parseHeader, version is %d", new Object[] { Integer.valueOf(i) });
      return false;
    }
    o.d("MicroMsg.AppBrandWxaPkg", "wxapkg version: %d", new Object[] { Integer.valueOf(i) });
    this.h = y.a(i);
    if (this.h == null)
    {
      o.b("MicroMsg.AppBrandWxaPkg", "parseHeader, mIWxaPkgAction is null");
      return false;
    }
    try
    {
      boolean bool = this.h.a(this.d);
      return bool;
    }
    catch (IOException localIOException)
    {
      o.b("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", new Object[] { af.a(localIOException) });
    }
    return true;
  }
  
  private int k()
  {
    try
    {
      this.d.position(1L);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(a);
      this.d.read(localByteBuffer);
      int i = b.a(localByteBuffer.array(), 0, 4);
      return i;
    }
    catch (IOException localIOException)
    {
      o.b("MicroMsg.AppBrandWxaPkg", "getVersionFromHead, exp = %s", new Object[] { af.a(localIOException) });
    }
    return -1;
  }
  
  private void l()
  {
    if (this.d != null) {
      return;
    }
    try
    {
      RandomAccessFile localRandomAccessFile = com.tencent.luggage.wxa.rt.k.b(this.b.b(), false);
      this.c = localRandomAccessFile;
      this.d = localRandomAccessFile.getChannel();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      o.b("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", new Object[] { af.a(localFileNotFoundException) });
    }
  }
  
  public FileStructStat a()
  {
    FileStructStat localFileStructStat2 = this.g;
    FileStructStat localFileStructStat1 = localFileStructStat2;
    if (localFileStructStat2 == null)
    {
      localFileStructStat1 = new FileStructStat();
      FileStat.a(this.b.l(), localFileStructStat1);
      this.g = localFileStructStat1;
    }
    return localFileStructStat1;
  }
  
  public v.a b(String paramString)
  {
    if ((this.f != null) && (!af.c(paramString)))
    {
      v.a locala = (v.a)this.f.get(paramString);
      localObject = locala;
      if (locala == null)
      {
        paramString = com.tencent.mm.plugin.appbrand.appstorage.k.b(paramString);
        localObject = (v.a)this.f.get(paramString);
      }
      return localObject;
    }
    Object localObject = this.f;
    int i = 0;
    boolean bool;
    if (localObject == null) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.f != null) {
      i = this.f.size();
    }
    o.b("MicroMsg.AppBrandWxaPkg", "handleInterruptReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
    return null;
  }
  
  public String b()
  {
    return this.b.l();
  }
  
  public InputStream c(String paramString)
  {
    v.a locala = b(paramString);
    if ((this.h != null) && (this.h.a(locala)))
    {
      if (locala != null) {
        return this.h.b(locala);
      }
      o.c("MicroMsg.AppBrandWxaPkg", "can't find info of file: %s", new Object[] { paramString });
      return null;
    }
    if (locala != null)
    {
      if (Thread.currentThread().isInterrupted()) {
        return a(locala);
      }
      try
      {
        Object localObject = this.d.map(FileChannel.MapMode.READ_ONLY, locala.c, locala.d);
        ((MappedByteBuffer)localObject).order(a);
        ((MappedByteBuffer)localObject).limit(locala.d);
        localObject = new com.tencent.luggage.util.a((ByteBuffer)localObject);
        return localObject;
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.AppBrandWxaPkg", "handleOpenReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[] { paramString, Integer.valueOf(locala.c), Integer.valueOf(locala.d), af.a(localException) });
        return null;
      }
    }
    o.c("MicroMsg.AppBrandWxaPkg", "can't find info of file: %s", new Object[] { paramString });
    return null;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public void close()
  {
    if (this.d != null) {}
    try
    {
      this.d.close();
      this.d = null;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          this.c.close();
          this.c = null;
          return;
        }
        catch (IOException localIOException2) {}
        localIOException1 = localIOException1;
      }
    }
    if (this.c != null) {}
  }
  
  public int d()
  {
    if (this.h == null) {
      return -1;
    }
    return this.h.a();
  }
  
  public boolean e()
  {
    if ((c()) && (this.d != null) && (this.h != null) && (this.h.b() > 4))
    {
      if ((this.f != null) && (this.h.c() >= 0) && (this.h.c() == this.f.size())) {
        return true;
      }
      try
      {
        this.f = this.h.a(this.d, this.b);
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", new Object[] { af.a(localException) });
      }
      return this.f != null;
    }
    boolean bool = c();
    FileChannel localFileChannel = this.d;
    int i;
    if (this.h == null) {
      i = -1;
    } else {
      i = this.h.b();
    }
    o.b("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", new Object[] { Boolean.valueOf(bool), localFileChannel, Integer.valueOf(i) });
    return false;
  }
  
  @NonNull
  public List<v.a> f()
  {
    if (!e()) {
      o.b("MicroMsg.AppBrandWxaPkg", "listInfos readInfo returns false");
    }
    if (this.f == null) {
      return Collections.emptyList();
    }
    return new LinkedList(this.f.values());
  }
  
  protected void finalize()
  {
    try
    {
      close();
      if (this.h != null) {
        this.h.close();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public List<String> g()
  {
    return new LinkedList(this.f.keySet());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v
 * JD-Core Version:    0.7.0.1
 */