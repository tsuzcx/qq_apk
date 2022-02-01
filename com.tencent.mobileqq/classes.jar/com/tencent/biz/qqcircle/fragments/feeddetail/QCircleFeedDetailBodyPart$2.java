package com.tencent.biz.qqcircle.fragments.feeddetail;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleFeedDetailBodyPart$2
  implements View.OnClickListener
{
  QCircleFeedDetailBodyPart$2(QCircleFeedDetailBodyPart paramQCircleFeedDetailBodyPart) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c() != null) {
      this.a.c().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailBodyPart.2
 * JD-Core Version:    0.7.0.1
 */