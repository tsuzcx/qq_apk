package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleFolderSplashPart$9
  implements View.OnClickListener
{
  QCircleFolderSplashPart$9(QCircleFolderSplashPart paramQCircleFolderSplashPart) {}
  
  public void onClick(View paramView)
  {
    QCircleFolderSplashPart.e(this.a);
    QCircleFolderSplashPart localQCircleFolderSplashPart = this.a;
    QCircleFolderSplashPart.a(localQCircleFolderSplashPart, localQCircleFolderSplashPart.g());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.9
 * JD-Core Version:    0.7.0.1
 */