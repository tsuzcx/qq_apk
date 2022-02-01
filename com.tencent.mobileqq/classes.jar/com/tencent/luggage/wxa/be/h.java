package com.tencent.luggage.wxa.be;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import com.tencent.luggage.wxa.bf.a;
import com.tencent.luggage.wxa.f.q;
import com.tencent.luggage.wxa.g.b;
import java.nio.ByteBuffer;

public class h
  extends e
{
  public h(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.a = new com.tencent.luggage.wxa.f.h(paramContext, paramSurfaceTexture, paramInt1, paramInt2);
    m();
  }
  
  protected void a(com.tencent.luggage.wxa.f.h paramh, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.c instanceof a)) {
      ((a)this.c).a(paramArrayOfByte, paramInt3);
    }
    if (this.b != null) {
      this.b.a(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, d.d paramd)
  {
    if ((paramd == null) && (paramByteBuffer == null))
    {
      if (this.c != null)
      {
        this.c.b();
        this.c = null;
      }
      return;
    }
    if (this.c == null)
    {
      this.c = new a();
      q localq = this.a.getPreviewSize();
      Point localPoint = f();
      ((a)this.c).a(localq.a(), localq.b(), g(), localPoint.x, localPoint.y);
      ((a)this.c).a(new h.1(this, paramd, paramByteBuffer));
      ((a)this.c).a(this.a.getEglContext());
    }
  }
  
  protected void q()
  {
    super.q();
    q localq = this.a.getPreviewSize();
    Point localPoint = f();
    if ((this.c instanceof a)) {
      ((a)this.c).a(localq.a(), localq.b(), b.a(g()), localPoint.x, localPoint.y);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.h
 * JD-Core Version:    0.7.0.1
 */