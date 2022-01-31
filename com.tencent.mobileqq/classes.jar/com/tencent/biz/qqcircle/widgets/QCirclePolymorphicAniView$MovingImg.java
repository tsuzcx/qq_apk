package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.PointF;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class QCirclePolymorphicAniView$MovingImg
  extends URLImageView
{
  private int mTopShift;
  
  public QCirclePolymorphicAniView$MovingImg(Context paramContext)
  {
    super(paramContext);
  }
  
  public void setMPointF(PointF paramPointF)
  {
    setX(paramPointF.x);
    setY(paramPointF.y - this.mTopShift);
    QLog.d("QCirclePolymorphicAniView", 4, "compute end:" + paramPointF.y);
  }
  
  public void setMScale(PointF paramPointF)
  {
    if (paramPointF.y >= 0.0F)
    {
      setScaleX(paramPointF.y);
      setScaleY(paramPointF.y);
    }
    QLog.d("QCirclePolymorphicAniView", 4, "scale y:" + paramPointF.y);
  }
  
  public void setTopShift(int paramInt)
  {
    this.mTopShift = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView.MovingImg
 * JD-Core Version:    0.7.0.1
 */