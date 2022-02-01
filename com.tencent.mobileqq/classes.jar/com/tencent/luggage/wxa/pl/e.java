package com.tencent.luggage.wxa.pl;

import com.tencent.luggage.wxa.pn.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] b = new byte[0];
  private ByteBuffer a;
  protected boolean c;
  protected d.a d;
  protected boolean e;
  
  public e() {}
  
  public e(d.a parama)
  {
    this.d = parama;
    this.a = ByteBuffer.wrap(b);
  }
  
  public e(d paramd)
  {
    this.c = paramd.d();
    this.d = paramd.f();
    this.a = paramd.c();
    this.e = paramd.e();
  }
  
  public void a(d.a parama)
  {
    this.d = parama;
  }
  
  public void a(d paramd)
  {
    ByteBuffer localByteBuffer1 = paramd.c();
    if (this.a == null)
    {
      this.a = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.a.put(localByteBuffer1);
      localByteBuffer1.reset();
    }
    else
    {
      localByteBuffer1.mark();
      ByteBuffer localByteBuffer2 = this.a;
      localByteBuffer2.position(localByteBuffer2.limit());
      localByteBuffer2 = this.a;
      localByteBuffer2.limit(localByteBuffer2.capacity());
      if (localByteBuffer1.remaining() > this.a.remaining())
      {
        localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.a.capacity());
        this.a.flip();
        localByteBuffer2.put(this.a);
        localByteBuffer2.put(localByteBuffer1);
        this.a = localByteBuffer2;
      }
      else
      {
        this.a.put(localByteBuffer1);
      }
      this.a.rewind();
      localByteBuffer1.reset();
    }
    this.c = paramd.d();
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public ByteBuffer c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public d.a f()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Framedata{ optcode:");
    localStringBuilder.append(f());
    localStringBuilder.append(", fin:");
    localStringBuilder.append(d());
    localStringBuilder.append(", payloadlength:[pos:");
    localStringBuilder.append(this.a.position());
    localStringBuilder.append(", len:");
    localStringBuilder.append(this.a.remaining());
    localStringBuilder.append("], payload:");
    localStringBuilder.append(Arrays.toString(b.a(new String(this.a.array()))));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pl.e
 * JD-Core Version:    0.7.0.1
 */