package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class PathInterpolatorCompat
{
  public static Interpolator create(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new PathInterpolator(paramFloat1, paramFloat2);
    }
    return new PathInterpolatorApi14(paramFloat1, paramFloat2);
  }
  
  public static Interpolator create(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new PathInterpolator(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    return new PathInterpolatorApi14(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static Interpolator create(Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new PathInterpolator(paramPath);
    }
    return new PathInterpolatorApi14(paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.animation.PathInterpolatorCompat
 * JD-Core Version:    0.7.0.1
 */