package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

public abstract class PathMotion
{
  public PathMotion() {}
  
  public PathMotion(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public abstract Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.PathMotion
 * JD-Core Version:    0.7.0.1
 */