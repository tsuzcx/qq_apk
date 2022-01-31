package android.support.v4.view.animation;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.view.animation.Interpolator;

@TargetApi(9)
class PathInterpolatorCompatBase
{
  public static Interpolator create(float paramFloat1, float paramFloat2)
  {
    return new PathInterpolatorGingerbread(paramFloat1, paramFloat2);
  }
  
  public static Interpolator create(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new PathInterpolatorGingerbread(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static Interpolator create(Path paramPath)
  {
    return new PathInterpolatorGingerbread(paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.animation.PathInterpolatorCompatBase
 * JD-Core Version:    0.7.0.1
 */