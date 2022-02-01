package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.f.u;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

class i$1
  implements Runnable
{
  i$1(i parami, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if ((i.a(this.d) != null) && (!i.b(this.d).get()))
    {
      i.b(this.d).compareAndSet(false, true);
      long l = af.b();
      byte[] arrayOfByte = u.a(this.a, this.b, this.c, i.c(this.d));
      if ((i.c(this.d) != 90) && (i.c(this.d) != 270)) {
        arrayOfByte = u.a(arrayOfByte, this.b, this.c, i.d(this.d), i.e(this.d));
      } else {
        arrayOfByte = u.a(arrayOfByte, this.c, this.b, i.d(this.d), i.e(this.d));
      }
      if (arrayOfByte == null)
      {
        i.b(this.d).compareAndSet(true, false);
        return;
      }
      ByteBuffer localByteBuffer = i.a(this.d).b();
      localByteBuffer.position(0);
      localByteBuffer.put(arrayOfByte);
      i.a(this.d).a();
      o.d("MicroMsg.YUVDateRenderToRBGBufferThread", "cost time: %d ms", new Object[] { Long.valueOf(af.c(l)) });
      i.b(this.d).compareAndSet(true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.i.1
 * JD-Core Version:    0.7.0.1
 */