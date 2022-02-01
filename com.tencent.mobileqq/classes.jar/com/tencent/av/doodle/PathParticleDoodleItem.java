package com.tencent.av.doodle;

import android.graphics.Canvas;
import com.tencent.qphone.base.util.BaseApplication;

public class PathParticleDoodleItem
  extends PathDoodleItem
{
  private PathParticleEffect l = new PathParticleEffect();
  
  public PathParticleDoodleItem(int paramInt)
  {
    a(paramInt);
  }
  
  private void a(int paramInt)
  {
    this.l.a(BaseApplication.getContext(), 2131230807, paramInt);
    this.l.a(this.k);
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    this.l.a((float)paramLong / 1000.0F);
  }
  
  public void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    this.l.a(paramCanvas);
  }
  
  public void d(float paramFloat1, float paramFloat2)
  {
    super.d(paramFloat1, paramFloat2);
    this.l.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleDoodleItem
 * JD-Core Version:    0.7.0.1
 */