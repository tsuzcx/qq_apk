package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleFolderSplashPart$10
  implements View.OnClickListener
{
  QCircleFolderSplashPart$10(QCircleFolderSplashPart paramQCircleFolderSplashPart) {}
  
  public void onClick(View paramView)
  {
    if (QCircleFolderSplashPart.f(this.a) == 2)
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleSelectTabEvent(6));
      QCircleFolderSplashPart.g(this.a);
    }
    else
    {
      this.a.c().onBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.10
 * JD-Core Version:    0.7.0.1
 */