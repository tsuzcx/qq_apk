package com.tencent.luggage.wxa.f;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import androidx.core.view.ViewCompat;

class s$1
  implements SurfaceHolder.Callback
{
  s$1(s params) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.b(paramInt2, paramInt3);
    if (!ViewCompat.isInLayout(this.a.a)) {
      this.a.j();
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.a.b(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.s.1
 * JD-Core Version:    0.7.0.1
 */