package com.tencent.gdtad.basics.adbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtAdBoxDialog$2
  implements View.OnClickListener
{
  GdtAdBoxDialog$2(GdtAdBoxDialog paramGdtAdBoxDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxDialog.2
 * JD-Core Version:    0.7.0.1
 */