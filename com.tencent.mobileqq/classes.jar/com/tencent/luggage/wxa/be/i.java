package com.tencent.luggage.wxa.be;

import android.os.HandlerThread;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.sc.d;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
{
  private final String a = "MicroMsg.YUVDateRenderToRBGBufferThread";
  private HandlerThread b = d.d("YUVDateRenderToRBGBufferThread", 5);
  private s c;
  private i.a d = null;
  private final AtomicBoolean e = new AtomicBoolean(false);
  private int f;
  private int g;
  private int h;
  private boolean i = false;
  
  private void a(Runnable paramRunnable)
  {
    if ((this.b.isAlive()) && (!this.e.get())) {
      this.c.a(paramRunnable);
    }
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasStart : ");
    localStringBuilder.append(this.i);
    o.e("MicroMsg.YUVDateRenderToRBGBufferThread", localStringBuilder.toString());
    if (this.i) {
      return;
    }
    this.i = true;
    this.b.start();
    this.c = new s(this.b.getLooper());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    o.d("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    if (paramInt1 != this.f) {
      this.f = paramInt1;
    }
    this.g = paramInt2;
    this.h = paramInt3;
  }
  
  public void a(i.a parama)
  {
    this.d = parama;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.i) {
      return;
    }
    a(new i.1(this, paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public void b()
  {
    a(new i.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.i
 * JD-Core Version:    0.7.0.1
 */