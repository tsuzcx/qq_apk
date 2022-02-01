package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFSPersonalFeedAdapter$1
  implements View.OnClickListener
{
  QFSPersonalFeedAdapter$1(QFSPersonalFeedAdapter paramQFSPersonalFeedAdapter, int paramInt, QFSPersonalFeedInfo paramQFSPersonalFeedInfo) {}
  
  public void onClick(View paramView)
  {
    if (QFSPersonalFeedAdapter.a(this.c) != null) {
      QFSPersonalFeedAdapter.a(this.c).a(this.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter.1
 * JD-Core Version:    0.7.0.1
 */