package com.tencent.biz.qrcode.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QRCardActivity$8$2
  implements View.OnClickListener
{
  QRCardActivity$8$2(QRCardActivity.8 param8) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)this.a.a.findViewById(2131365294);
    if ((localTextView.getText() instanceof String)) {
      this.a.a((String)localTextView.getText());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRCardActivity.8.2
 * JD-Core Version:    0.7.0.1
 */