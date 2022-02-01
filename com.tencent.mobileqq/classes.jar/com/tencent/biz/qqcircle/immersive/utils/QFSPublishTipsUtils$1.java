package com.tencent.biz.qqcircle.immersive.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFSPublishTipsUtils$1
  implements View.OnClickListener
{
  QFSPublishTipsUtils$1(QFSPublishTipsUtils paramQFSPublishTipsUtils) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView.getContext());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils.1
 * JD-Core Version:    0.7.0.1
 */