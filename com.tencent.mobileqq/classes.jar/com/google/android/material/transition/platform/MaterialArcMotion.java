package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class MaterialArcMotion
  extends PathMotion
{
  private static PointF a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat2 > paramFloat4) {
      return new PointF(paramFloat3, paramFloat2);
    }
    return new PointF(paramFloat1, paramFloat4);
  }
  
  @NonNull
  public Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramFloat1, paramFloat2);
    PointF localPointF = a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    localPath.quadTo(localPointF.x, localPointF.y, paramFloat3, paramFloat4);
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialArcMotion
 * JD-Core Version:    0.7.0.1
 */