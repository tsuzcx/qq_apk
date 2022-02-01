package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

public final class PathSegment
{
  private final PointF mEnd;
  private final float mEndFraction;
  private final PointF mStart;
  private final float mStartFraction;
  
  public PathSegment(@NonNull PointF paramPointF1, float paramFloat1, @NonNull PointF paramPointF2, float paramFloat2)
  {
    this.mStart = ((PointF)Preconditions.checkNotNull(paramPointF1, "start == null"));
    this.mStartFraction = paramFloat1;
    this.mEnd = ((PointF)Preconditions.checkNotNull(paramPointF2, "end == null"));
    this.mEndFraction = paramFloat2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PathSegment)) {
        return false;
      }
      paramObject = (PathSegment)paramObject;
    } while ((Float.compare(this.mStartFraction, paramObject.mStartFraction) == 0) && (Float.compare(this.mEndFraction, paramObject.mEndFraction) == 0) && (this.mStart.equals(paramObject.mStart)) && (this.mEnd.equals(paramObject.mEnd)));
    return false;
  }
  
  @NonNull
  public PointF getEnd()
  {
    return this.mEnd;
  }
  
  public float getEndFraction()
  {
    return this.mEndFraction;
  }
  
  @NonNull
  public PointF getStart()
  {
    return this.mStart;
  }
  
  public float getStartFraction()
  {
    return this.mStartFraction;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.mStart.hashCode();
    if (this.mStartFraction != 0.0F) {}
    for (int i = Float.floatToIntBits(this.mStartFraction);; i = 0)
    {
      int m = this.mEnd.hashCode();
      if (this.mEndFraction != 0.0F) {
        j = Float.floatToIntBits(this.mEndFraction);
      }
      return ((i + k * 31) * 31 + m) * 31 + j;
    }
  }
  
  public String toString()
  {
    return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.graphics.PathSegment
 * JD-Core Version:    0.7.0.1
 */