package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePolyLikePayView$3
  implements View.OnClickListener
{
  QCirclePolyLikePayView$3(QCirclePolyLikePayView paramQCirclePolyLikePayView, String paramString) {}
  
  public void onClick(View paramView)
  {
    QCirclePolyLikePayView.a(this.b).cancel();
    QCircleLauncher.a(this.b.getContext(), "https://h5.qzone.qq.com/v2/wezone/pay?_wv=17301507&_proxy=1&_wwv=1&polylikeid={polylikeid}".replace("{polylikeid}", this.a), null, -1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView.3
 * JD-Core Version:    0.7.0.1
 */