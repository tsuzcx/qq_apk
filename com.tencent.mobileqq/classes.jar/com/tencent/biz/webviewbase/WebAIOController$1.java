package com.tencent.biz.webviewbase;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebAIOController$1
  implements View.OnClickListener
{
  WebAIOController$1(WebAIOController paramWebAIOController) {}
  
  public void onClick(View paramView)
  {
    WebAIOController.b = true;
    this.a.a(false);
    this.a.a(paramView.getContext());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewbase.WebAIOController.1
 * JD-Core Version:    0.7.0.1
 */