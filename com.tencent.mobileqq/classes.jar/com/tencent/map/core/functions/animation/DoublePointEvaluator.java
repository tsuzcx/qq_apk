package com.tencent.map.core.functions.animation;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.sdk.a.nt;

public class DoublePointEvaluator
  implements nt<DoublePoint>
{
  public DoublePoint evaluate(float paramFloat, DoublePoint paramDoublePoint1, DoublePoint paramDoublePoint2)
  {
    return new DoublePoint(paramDoublePoint1.x + paramFloat * (paramDoublePoint2.x - paramDoublePoint1.x), paramDoublePoint1.y + paramFloat * (paramDoublePoint2.y - paramDoublePoint1.y));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.DoublePointEvaluator
 * JD-Core Version:    0.7.0.1
 */