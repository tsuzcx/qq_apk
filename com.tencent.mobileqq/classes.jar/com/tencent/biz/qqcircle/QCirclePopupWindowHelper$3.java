package com.tencent.biz.qqcircle;

import android.os.CountDownTimer;
import android.widget.PopupWindow;

class QCirclePopupWindowHelper$3
  extends CountDownTimer
{
  QCirclePopupWindowHelper$3(QCirclePopupWindowHelper paramQCirclePopupWindowHelper, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if (QCirclePopupWindowHelper.a(this.a) != null)
    {
      QCirclePopupWindowHelper.a(this.a).dismiss();
      QCirclePopupWindowHelper.a(this.a, null);
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePopupWindowHelper.3
 * JD-Core Version:    0.7.0.1
 */