package com.tencent.map.core.functions.animation;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.sdk.a.nt;

public class DoublePointEvaluator
  implements nt<DoublePoint>
{
  public DoublePoint evaluate(float paramFloat, DoublePoint paramDoublePoint1, DoublePoint paramDoublePoint2)
  {
    double d1 = paramDoublePoint1.x;
    double d2 = paramFloat;
    double d3 = paramDoublePoint2.x;
    double d4 = paramDoublePoint1.x;
    Double.isNaN(d2);
    double d5 = paramDoublePoint1.y;
    double d6 = paramDoublePoint2.y;
    double d7 = paramDoublePoint1.y;
    Double.isNaN(d2);
    return new DoublePoint(d1 + (d3 - d4) * d2, d5 + d2 * (d6 - d7));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.DoublePointEvaluator
 * JD-Core Version:    0.7.0.1
 */