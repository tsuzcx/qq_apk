package com.tencent.luggage.wxa.j;

import java.nio.ByteBuffer;

public class e
  extends a
{
  public final b a = new b();
  public ByteBuffer b;
  public long c;
  private final int d;
  
  public e(int paramInt)
  {
    this.d = paramInt;
  }
  
  public static e e()
  {
    return new e(0);
  }
  
  private ByteBuffer f(int paramInt)
  {
    int i = this.d;
    if (i == 1) {
      return ByteBuffer.allocate(paramInt);
    }
    if (i == 2) {
      return ByteBuffer.allocateDirect(paramInt);
    }
    Object localObject = this.b;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ByteBuffer)localObject).capacity();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Buffer too small (");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" < ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(")");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void a()
  {
    super.a();
    ByteBuffer localByteBuffer = this.b;
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
  }
  
  public void e(int paramInt)
  {
    ByteBuffer localByteBuffer = this.b;
    if (localByteBuffer == null)
    {
      this.b = f(paramInt);
      return;
    }
    int i = localByteBuffer.capacity();
    int j = this.b.position();
    paramInt += j;
    if (i >= paramInt) {
      return;
    }
    localByteBuffer = f(paramInt);
    if (j > 0)
    {
      this.b.position(0);
      this.b.limit(j);
      localByteBuffer.put(this.b);
    }
    this.b = localByteBuffer;
  }
  
  public final boolean f()
  {
    return (this.b == null) && (this.d == 0);
  }
  
  public final boolean g()
  {
    return d(1073741824);
  }
  
  public final void h()
  {
    this.b.flip();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.j.e
 * JD-Core Version:    0.7.0.1
 */