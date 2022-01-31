package com.tencent.av.doodle;

import android.graphics.Canvas;
import com.tencent.common.app.BaseApplicationImpl;

public class PathParticleDoodleItem
  extends PathDoodleItem
{
  private PathParticleEffect a;
  
  public PathParticleDoodleItem(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvDoodlePathParticleEffect = new PathParticleEffect();
    a(paramInt);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvDoodlePathParticleEffect.a(BaseApplicationImpl.getApplication(), 2131230735, paramInt);
    this.jdField_a_of_type_ComTencentAvDoodlePathParticleEffect.a(this.jdField_a_of_type_AndroidGraphicsPathMeasure);
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvDoodlePathParticleEffect.a((float)paramLong / 1000.0F);
  }
  
  public void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvDoodlePathParticleEffect.a(paramCanvas);
  }
  
  public void c(float paramFloat1, float paramFloat2)
  {
    super.c(paramFloat1, paramFloat2);
    this.jdField_a_of_type_ComTencentAvDoodlePathParticleEffect.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleDoodleItem
 * JD-Core Version:    0.7.0.1
 */