package com.tencent.biz.subscribe.widget.relativevideo;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;

class SubScribeDraftItemView$1
  implements View.OnClickListener
{
  SubScribeDraftItemView$1(SubScribeDraftItemView paramSubScribeDraftItemView, SubscribeDraftBean paramSubscribeDraftBean) {}
  
  public void onClick(View paramView)
  {
    if (!FastClickUtils.a("subscribe_draft_click"))
    {
      boolean bool = SubScribeDraftItemView.a(this.b);
      Intent localIntent = new Intent();
      localIntent.putExtra("postUin", SubScribeDraftItemView.b(this.b));
      localIntent.putExtra("has_shop", bool);
      localIntent.putExtra("subscribeDraftID", String.valueOf(this.a.getDraftId()));
      QZoneHelper.forwardToQQPublicAccountPublishPage((Activity)this.b.getContext(), localIntent, 0);
      VSReporter.b(SubScribeDraftItemView.c(this.b), "auth_pubish", "clk_draftclk", 0, 0, new String[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView.1
 * JD-Core Version:    0.7.0.1
 */