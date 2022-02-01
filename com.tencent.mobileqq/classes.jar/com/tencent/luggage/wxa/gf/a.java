package com.tencent.luggage.wxa.gf;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fx.d;
import com.tencent.luggage.wxa.gg.c;

public class a
  implements b
{
  protected int a;
  protected String b;
  protected volatile boolean c;
  protected c d;
  
  protected String A()
  {
    return d.a(this.b, this.a);
  }
  
  public int B()
  {
    return this.a;
  }
  
  public String C()
  {
    return this.b;
  }
  
  public c D()
  {
    return this.d;
  }
  
  public void a(@Nullable Bitmap paramBitmap) {}
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.c = true;
  }
  
  public void a(MotionEvent paramMotionEvent) {}
  
  public void a(c paramc)
  {
    this.d = paramc;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a(com.tencent.luggage.wxa.fx.a parama)
  {
    return false;
  }
  
  public String b(com.tencent.luggage.wxa.fx.a parama)
  {
    return null;
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void d()
  {
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gf.a
 * JD-Core Version:    0.7.0.1
 */