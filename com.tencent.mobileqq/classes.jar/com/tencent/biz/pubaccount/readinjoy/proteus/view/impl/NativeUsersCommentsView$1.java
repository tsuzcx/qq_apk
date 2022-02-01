package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NativeUsersCommentsView$1
  implements View.OnClickListener
{
  NativeUsersCommentsView$1(NativeUsersCommentsView paramNativeUsersCommentsView) {}
  
  public void onClick(View paramView)
  {
    this.a.callOnClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeUsersCommentsView.1
 * JD-Core Version:    0.7.0.1
 */