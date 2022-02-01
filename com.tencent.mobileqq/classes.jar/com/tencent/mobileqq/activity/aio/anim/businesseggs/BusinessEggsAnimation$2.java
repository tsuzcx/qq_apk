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
    float f1 = RandomUtils.a(-1.0F, 1.0F);
    float f2 = ViewUtils.dip2px(50.0F);
    localPoint.x = ((int)(paramPoint.x / 2 + f1 * f2));
    localPoint.y = 0;
    return localPoint;
  }
  
  public Point a(Point paramPoint1, Point paramPoint2, float paramFloat)
  {
    Point localPoint = new Point();
    double d1;
    double d2;
    if (paramPoint1.x % 2 == 0)
    {
      d1 = paramFloat;
      Double.isNaN(d1);
      d2 = Math.sin(d1 * 6.283185307179586D);
      d1 = ViewUtils.dip2px(60.0F);
      Double.isNaN(d1);
    }
    else
    {
      d1 = paramFloat;
      Double.isNaN(d1);
      d2 = Math.cos(d1 * 6.283185307179586D);
      d1 = ViewUtils.dip2px(60.0F);
      Double.isNaN(d1);
    }
    localPoint.x = ((int)((int)(d2 * d1) * 1.5F + paramPoint1.x));
    localPoint.y = ((int)(paramPoint2.y * 1.3F * paramFloat));
    return localPoint;
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