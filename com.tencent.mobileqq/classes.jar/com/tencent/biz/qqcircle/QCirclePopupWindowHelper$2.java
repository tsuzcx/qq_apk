package com.tencent.biz.qqcircle;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.PopupWindow;

class QCirclePopupWindowHelper$2
  extends CountDownTimer
{
  QCirclePopupWindowHelper$2(QCirclePopupWindowHelper paramQCirclePopupWindowHelper, long paramLong1, long paramLong2, Context paramContext)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if (QCirclePopupWindowHelper.a(this.b) != null)
    {
      Context localContext = this.a;
      if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()))
      {
        QCirclePopupWindowHelper.a(this.b).dismiss();
        QCirclePopupWindowHelper.a(this.b, null);
      }
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePopupWindowHelper.2
 * JD-Core Version:    0.7.0.1
 */