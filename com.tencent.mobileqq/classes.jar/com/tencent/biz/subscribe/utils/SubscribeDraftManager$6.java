package com.tencent.biz.subscribe.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class SubscribeDraftManager$6
  implements View.OnClickListener
{
  SubscribeDraftManager$6(SubscribeDraftManager paramSubscribeDraftManager, SubscribeFollowUserUtil.ResultListener paramResultListener, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false, this.b, true);
    this.c.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.6
 * JD-Core Version:    0.7.0.1
 */