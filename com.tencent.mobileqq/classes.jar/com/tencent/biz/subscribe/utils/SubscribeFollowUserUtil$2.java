package com.tencent.biz.subscribe.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

final class SubscribeFollowUserUtil$2
  implements View.OnClickListener
{
  SubscribeFollowUserUtil$2(SubscribeFollowUserUtil.ResultListener paramResultListener, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false, this.b, true);
    this.c.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil.2
 * JD-Core Version:    0.7.0.1
 */