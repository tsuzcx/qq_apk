package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.utils.RandomUtils;
import com.tencent.mobileqq.utils.ViewUtils;

class BusinessEggsAnimation$2
  implements BusinessEggsElement.IPathStrategy
{
  BusinessEggsAnimation$2(BusinessEggsAnimation paramBusinessEggsAnimation) {}
  
  public Point a(Point paramPoint)
  {
    Point localPoint = new Point();
    localPoint.x = ((int)(RandomUtils.a(-1.0F, 1.0F) * ViewUtils.a(50.0F) + paramPoint.x / 2));
    localPoint.y = 0;
    return localPoint;
  }
  
  public Point a(Point paramPoint1, Point paramPoint2, float paramFloat)
  {
    Point localPoint = new Point();
    if (paramPoint1.x % 2 == 0) {}
    for (int i = (int)(Math.sin(paramFloat * 6.283185307179586D) * ViewUtils.a(60.0F));; i = (int)(Math.cos(paramFloat * 6.283185307179586D) * ViewUtils.a(60.0F)))
    {
      localPoint.x = ((int)(i * 1.5F + paramPoint1.x));
      localPoint.y = ((int)(1.3F * paramPoint2.y * paramFloat));
      return localPoint;
    }
  }
  
  public void a(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator.setDuration(5500L);
    paramValueAnimator.setInterpolator(new AccelerateInterpolator());
    paramValueAnimator.addListener(new BusinessEggsAnimation.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation.2
 * JD-Core Version:    0.7.0.1
 */