package com.tencent.biz.webviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UrlCheckPlugin$3
  implements View.OnClickListener
{
  UrlCheckPlugin$3(UrlCheckPlugin paramUrlCheckPlugin) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.UrlCheckPlugin.3
 * JD-Core Version:    0.7.0.1
 */