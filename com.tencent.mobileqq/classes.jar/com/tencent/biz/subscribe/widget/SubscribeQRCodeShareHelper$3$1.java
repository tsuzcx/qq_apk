package com.tencent.biz.subscribe.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribeQRCodeShareHelper$3$1
  implements View.OnClickListener
{
  SubscribeQRCodeShareHelper$3$1(SubscribeQRCodeShareHelper.3 param3) {}
  
  public void onClick(View paramView)
  {
    SubscribeQRCodeShareHelper.g(this.a.this$0).dismiss();
    SubscribeQRCodeShareHelper.a(this.a.this$0, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */