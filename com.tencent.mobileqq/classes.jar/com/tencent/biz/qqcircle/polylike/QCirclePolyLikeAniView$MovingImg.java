package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.graphics.PointF;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class QCirclePolyLikeAniView$MovingImg
  extends URLImageView
{
  private int mHeight;
  private int mTopShift;
  private int mWidth;
  
  public QCirclePolyLikeAniView$MovingImg(Context paramContext)
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = ((int)(this.mWidth * paramPointF.y));
        localLayoutParams.height = ((int)(this.mHeight * paramPointF.y));
        setLayoutParams(localLayoutParams);
      }
    }
    QLog.d("QCirclePolymorphicAniView", 4, "scale y:" + paramPointF.y);
  }
  
  public void setTopShift(int paramInt)
  {
    this.mTopShift = paramInt;
  }
  
  public void setWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView.MovingImg
 * JD-Core Version:    0.7.0.1
 */