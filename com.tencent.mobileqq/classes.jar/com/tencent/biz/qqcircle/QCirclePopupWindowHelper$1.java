package com.tencent.biz.qqcircle;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

class QCirclePopupWindowHelper$1
  implements Runnable
{
  QCirclePopupWindowHelper$1(QCirclePopupWindowHelper paramQCirclePopupWindowHelper, Context paramContext, View paramView) {}
  
  public void run()
  {
    if (QCirclePluginConfig.a().n())
    {
      QCirclePopupWindowHelper localQCirclePopupWindowHelper = this.this$0;
      Context localContext = this.a;
      if (localQCirclePopupWindowHelper.a(localContext, this.b, localContext.getResources().getString(2131895722))) {
        QCirclePluginConfig.a().s();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePopupWindowHelper.1
 * JD-Core Version:    0.7.0.1
 */