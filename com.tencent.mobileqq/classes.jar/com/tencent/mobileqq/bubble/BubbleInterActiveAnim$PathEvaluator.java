package com.tencent.mobileqq.bubble;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class BubbleInterActiveAnim$PathEvaluator
  implements TypeEvaluator<BubbleInterActiveAnim.AnimFrameData>
{
  public BubbleInterActiveAnim.AnimFrameData a(float paramFloat, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData1, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData2)
  {
    long l = System.currentTimeMillis();
    float f2;
    float f1;
    if (paramAnimFrameData2.g.i == 2)
    {
      float f4 = 1.0F - paramFloat;
      f2 = f4 * f4 * f4;
      float f3 = paramAnimFrameData1.g.a;
      f1 = 3.0F * f4;
      f4 = f4 * f1 * paramFloat;
      float f5 = paramAnimFrameData2.g.e;
      float f6 = f1 * paramFloat * paramFloat;
      float f7 = paramAnimFrameData2.g.g;
      float f8 = paramFloat * paramFloat * paramFloat;
      float f9 = paramAnimFrameData2.g.a;
      f1 = f2 * paramAnimFrameData1.g.b + f4 * paramAnimFrameData2.g.f + f6 * paramAnimFrameData2.g.h + f8 * paramAnimFrameData2.g.b;
      f2 = f3 * f2 + f5 * f4 + f7 * f6 + f9 * f8;
    }
    else if (paramAnimFrameData2.g.i == 1)
    {
      f2 = paramAnimFrameData1.g.a + (paramAnimFrameData2.g.a - paramAnimFrameData1.g.a) * paramFloat;
      f1 = paramAnimFrameData1.g.b + (paramAnimFrameData2.g.b - paramAnimFrameData1.g.b) * paramFloat;
    }
    else
    {
      f2 = paramAnimFrameData2.g.a;
      f1 = paramAnimFrameData2.g.b;
    }
    PathPoint localPathPoint = PathPoint.b(f2, f1);
    BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
    localPathPoint.d = (paramAnimFrameData1.g.d + (paramAnimFrameData2.g.d - paramAnimFrameData1.g.d) * paramFloat);
    localAnimFrameData.g = localPathPoint;
    localAnimFrameData.l = paramAnimFrameData2.l;
    localAnimFrameData.f = paramAnimFrameData2.f;
    localAnimFrameData.a = paramAnimFrameData2.a;
    localAnimFrameData.b = paramAnimFrameData2.b;
    localAnimFrameData.c = paramAnimFrameData2.c;
    localAnimFrameData.d = paramAnimFrameData2.d;
    localAnimFrameData.h = paramAnimFrameData2.h;
    return BubbleInterActiveAnim.a(paramFloat, paramAnimFrameData1, paramAnimFrameData2, l, f2, f1, localPathPoint, localAnimFrameData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.PathEvaluator
 * JD-Core Version:    0.7.0.1
 */