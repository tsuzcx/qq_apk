package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;

class ReadInjoyTextView$1$2
  implements Runnable
{
  ReadInjoyTextView$1$2(ReadInjoyTextView.1 param1) {}
  
  public void run()
  {
    this.a.a.setText(ReadInjoyTextView.a(this.a.a, this.a.b, RIJStringUtils.a(ReadInJoyUserInfoModule.a())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.1.2
 * JD-Core Version:    0.7.0.1
 */