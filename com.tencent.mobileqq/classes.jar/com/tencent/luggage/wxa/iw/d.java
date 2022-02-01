package com.tencent.luggage.wxa.iw;

import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appcache.v.a;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Map;

public final class d
  extends b
{
  private static final ByteOrder a = ByteOrder.BIG_ENDIAN;
  private volatile int b = -1;
  private volatile int c = 0;
  private volatile int d = 0;
  private volatile int e = -1;
  
  public int a()
  {
    return this.b;
  }
  
  public Map<String, v.a> a(FileChannel paramFileChannel, i parami)
  {
    if (paramFileChannel == null)
    {
      o.b("MicroMsg.WxaPkgNormalImpl", "fileChannel is null");
      return null;
    }
    if (parami == null)
    {
      o.b("MicroMsg.WxaPkgNormalImpl", "file is null");
      return null;
    }
    paramFileChannel.position(14L);
    Object localObject = ByteBuffer.allocate(this.c);
    ((ByteBuffer)localObject).order(a);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.e = a((byte[])localObject, 0, 4);
    ArrayMap localArrayMap = new ArrayMap();
    paramFileChannel = null;
    int i = 0;
    int j = 4;
    while (i < this.e)
    {
      int k = a((byte[])localObject, j, 4);
      j += 4;
      String str = new String((byte[])localObject, j, k);
      j += k;
      k = a((byte[])localObject, j, 4);
      j += 4;
      int m = a((byte[])localObject, j, 4);
      j += 4;
      paramFileChannel = new b.a(parami.l(), str, k, m);
      localArrayMap.put(str, paramFileChannel);
      i += 1;
    }
    if ((paramFileChannel != null) && (paramFileChannel.c + paramFileChannel.d > parami.q()))
    {
      o.b("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(paramFileChannel.c), Integer.valueOf(paramFileChannel.d), Long.valueOf(parami.q()) });
      return null;
    }
    return localArrayMap;
  }
  
  public boolean a(v.a parama)
  {
    return false;
  }
  
  public boolean a(FileChannel paramFileChannel)
  {
    boolean bool = false;
    if (paramFileChannel == null) {
      return false;
    }
    paramFileChannel.position(0L);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(14);
    localByteBuffer.order(a);
    paramFileChannel.read(localByteBuffer);
    if (-66 == localByteBuffer.get(0))
    {
      if (-19 != localByteBuffer.get(13)) {
        return false;
      }
      paramFileChannel = localByteBuffer.array();
      bool = true;
      this.b = a(paramFileChannel, 1, 4);
      this.c = a(paramFileChannel, 5, 4);
      this.d = a(paramFileChannel, 9, 4);
    }
    return bool;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public InputStream b(v.a parama)
  {
    return null;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void close()
  {
    this.b = -1;
    this.c = 0;
    this.d = 0;
    this.e = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iw.d
 * JD-Core Version:    0.7.0.1
 */