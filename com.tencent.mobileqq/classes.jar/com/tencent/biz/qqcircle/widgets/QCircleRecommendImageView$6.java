package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;

class QCircleRecommendImageView$6
  implements Runnable
{
  QCircleRecommendImageView$6(QCircleRecommendImageView paramQCircleRecommendImageView, String paramString) {}
  
  public void run()
  {
    if (!HostHostNetworkUtils.a(this.this$0.getContext()))
    {
      QCircleToast.a(QCircleToast.c, this.this$0.getContext().getResources().getString(2131892113), 0);
      return;
    }
    QCircleToast.a(QCircleToast.c, this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.6
 * JD-Core Version:    0.7.0.1
 */