package com.tencent.biz.qrcode.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QRLoginBaseActivity$1
  implements View.OnClickListener
{
  QRLoginBaseActivity$1(QRLoginBaseActivity paramQRLoginBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */