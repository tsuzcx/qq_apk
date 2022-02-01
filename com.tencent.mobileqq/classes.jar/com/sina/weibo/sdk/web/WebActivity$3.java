package com.sina.weibo.sdk.web;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class WebActivity$3
  implements View.OnClickListener
{
  WebActivity$3(WebActivity paramWebActivity) {}
  
  public final void onClick(View paramView)
  {
    WebActivity.d(this.aA);
    WebActivity.b(this.aA).reload();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.web.WebActivity.3
 * JD-Core Version:    0.7.0.1
 */