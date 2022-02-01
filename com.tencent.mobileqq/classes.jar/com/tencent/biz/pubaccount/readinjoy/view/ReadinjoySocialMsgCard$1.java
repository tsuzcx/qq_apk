package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadinjoySocialMsgCard$1
  implements View.OnClickListener
{
  ReadinjoySocialMsgCard$1(ReadinjoySocialMsgCard paramReadinjoySocialMsgCard) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySocialMsgCard.a(true, -1, ReadinjoySocialMsgCard.a(this.a));
    if (ReadinjoySocialMsgCard.a(this.a) != null) {
      ReadinjoySocialMsgCard.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgCard.1
 * JD-Core Version:    0.7.0.1
 */