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

public final class c
  extends b
{
  private static final ByteOrder a = ByteOrder.BIG_ENDIAN;
  private volatile int b = -1;
  private volatile int c = 0;
  private volatile int d = 0;
  private volatile int e = 0;
  private volatile int f = -1;
  
  public int a()
  {
    return this.b;
  }
  
  public Map<String, v.a> a(FileChannel paramFileChannel, i parami)
  {
    if (paramFileChannel == null)
    {
      o.b("MicroMsg.WxaPkgMixedImpl", "fileChannel is null");
      return null;
    }
    if (parami == null)
    {
      o.b("MicroMsg.WxaPkgMixedImpl", "file is null");
      return null;
    }
    paramFileChannel.position(18L);
    Object localObject = ByteBuffer.allocate(this.c);
    ((ByteBuffer)localObject).order(a);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.f = a((byte[])localObject, 0, 4);
    ArrayMap localArrayMap = new ArrayMap();
    paramFileChannel = null;
    int i = 0;
    int k;
    for (int j = 4; i < this.f; j = k)
    {
      k = a((byte[])localObject, j, 4);
      j += 4;
      String str = new String((byte[])localObject, j, k);
      j += k;
      int m = a((byte[])localObject, j, 1);
      j += 1;
      int i1 = a((byte[])localObject, j, 4);
      j += 4;
      int n = a((byte[])localObject, j, 4);
      k = j + 4;
      if (m == 0) {}
      for (j = this.c + 18 + this.d;; j = this.c + 18)
      {
        j += i1;
        break label256;
        if (m != 1) {
          break;
        }
      }
      o.b("MicroMsg.WxaPkgMixedImpl", "encType error: %d", new Object[] { Integer.valueOf(m) });
      j = 0;
      label256:
      paramFileChannel = new c.a(parami.l(), str, j, n, m);
      localArrayMap.put(str, paramFileChannel);
      i += 1;
    }
    if ((paramFileChannel != null) && (paramFileChannel.c + paramFileChannel.d > parami.q()))
    {
      o.b("MicroMsg.WxaPkgMixedImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(paramFileChannel.c), Integer.valueOf(paramFileChannel.d), Long.valueOf(parami.q()) });
      return null;
    }
    return localArrayMap;
  }
  
  public boolean a(v.a parama)
  {
    return ((parama instanceof c.a)) && (parama.b != null) && (((c.a)parama).e == 1);
  }
  
  public boolean a(FileChannel paramFileChannel)
  {
    boolean bool = false;
    if (paramFileChannel == null) {
      return false;
    }
    paramFileChannel.position(0L);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(18);
    localByteBuffer.order(a);
    paramFileChannel.read(localByteBuffer);
    if (-66 == localByteBuffer.get(0))
    {
      if (-19 != localByteBuffer.get(17)) {
        return false;
      }
      paramFileChannel = localByteBuffer.array();
      bool = true;
      this.b = a(paramFileChannel, 1, 4);
      this.c = a(paramFileChannel, 5, 4);
      this.d = a(paramFileChannel, 9, 4);
      this.e = a(paramFileChannel, 13, 4);
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
    return this.f;
  }
  
  public void close() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iw.c
 * JD-Core Version:    0.7.0.1
 */