package com.tencent.mm.appbrand.v8;

import android.util.SparseArray;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class v
  implements f
{
  private final AtomicInteger a = new AtomicInteger(0);
  private final AtomicInteger b = new AtomicInteger(0);
  private final SparseArray<ByteBuffer> c = new SparseArray();
  
  public int a()
  {
    try
    {
      int i = this.a.addAndGet(1);
      this.c.put(i, null);
      o.d("V8EngineBufferStore", "generateId:%d", new Object[] { Integer.valueOf(i) });
      return i;
    }
    finally {}
  }
  
  public ByteBuffer a(int paramInt, boolean paramBoolean)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)this.c.get(paramInt);
      this.c.remove(paramInt);
      if (localByteBuffer == null)
      {
        o.b("V8EngineBufferStore", "getBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        return null;
      }
      int i = localByteBuffer.capacity();
      o.d("V8EngineBufferStore", "getBuffer:%d remains[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.b.addAndGet(-i)) });
      return localByteBuffer;
    }
    finally {}
  }
  
  public void a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return;
    }
    ByteBuffer localByteBuffer = p.a(paramByteBuffer);
    if (!localByteBuffer.isDirect())
    {
      o.d("V8EngineBufferStore", "setBuffer:%d cannot convert to direct buffer", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    try
    {
      if (this.c.indexOfKey(paramInt) < 0)
      {
        o.d("V8EngineBufferStore", "setBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      this.c.put(paramInt, localByteBuffer);
      o.d("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramByteBuffer.isDirect()), Integer.valueOf(this.b.addAndGet(paramByteBuffer.capacity())) });
      return;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    o.b("V8EngineBufferStore", "no bind to here");
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.v
 * JD-Core Version:    0.7.0.1
 */