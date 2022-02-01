package com.sina.weibo.sdk.web;

import android.view.View;
import android.view.View.OnClickListener;
import com.sina.weibo.sdk.web.a.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class WebActivity$2
  implements View.OnClickListener
{
  WebActivity$2(WebActivity paramWebActivity) {}
  
  public final void onClick(View paramView)
  {
    WebActivity.c(this.aA).t();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.web.WebActivity.2
 * JD-Core Version:    0.7.0.1
 */