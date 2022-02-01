package androidx.transition;

import android.graphics.PointF;
import android.view.View;

class ChangeBounds$ViewBounds
{
  private int mBottom;
  private int mBottomRightCalls;
  private int mLeft;
  private int mRight;
  private int mTop;
  private int mTopLeftCalls;
  private View mView;
  
  ChangeBounds$ViewBounds(View paramView)
  {
    this.mView = paramView;
  }
  
  private void setLeftTopRightBottom()
  {
    ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
    this.mTopLeftCalls = 0;
    this.mBottomRightCalls = 0;
  }
  
  void setBottomRight(PointF paramPointF)
  {
    this.mRight = Math.round(paramPointF.x);
    this.mBottom = Math.round(paramPointF.y);
    this.mBottomRightCalls += 1;
    if (this.mTopLeftCalls == this.mBottomRightCalls) {
      setLeftTopRightBottom();
    }
  }
  
  void setTopLeft(PointF paramPointF)
  {
    this.mLeft = Math.round(paramPointF.x);
    this.mTop = Math.round(paramPointF.y);
    this.mTopLeftCalls += 1;
    if (this.mTopLeftCalls == this.mBottomRightCalls) {
      setLeftTopRightBottom();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeBounds.ViewBounds
 * JD-Core Version:    0.7.0.1
 */