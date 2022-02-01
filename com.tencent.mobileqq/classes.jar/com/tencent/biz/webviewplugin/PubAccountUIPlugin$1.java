package com.tencent.biz.webviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PubAccountUIPlugin$1
  implements View.OnClickListener
{
  PubAccountUIPlugin$1(PubAccountUIPlugin paramPubAccountUIPlugin) {}
  
  public void onClick(View paramView)
  {
    this.a.f.setClickable(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountUIPlugin.1
 * JD-Core Version:    0.7.0.1
 */