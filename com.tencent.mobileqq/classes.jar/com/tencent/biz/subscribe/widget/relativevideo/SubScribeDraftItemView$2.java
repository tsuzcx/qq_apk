package com.tencent.biz.subscribe.widget.relativevideo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubScribeDraftItemView$2
  implements View.OnClickListener
{
  SubScribeDraftItemView$2(SubScribeDraftItemView paramSubScribeDraftItemView, SubscribeDraftBean paramSubscribeDraftBean) {}
  
  public void onClick(View paramView)
  {
    VSReporter.b(SubScribeDraftItemView.c(this.b), "auth_pubish", "clk_delete_draft", 0, 0, new String[0]);
    SubscribeDraftManager.a().a(this.b.getContext(), SubScribeDraftItemView.c(this.b), String.valueOf(this.a.getDraftId()), 2131916923, new SubScribeDraftItemView.2.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView.2
 * JD-Core Version:    0.7.0.1
 */