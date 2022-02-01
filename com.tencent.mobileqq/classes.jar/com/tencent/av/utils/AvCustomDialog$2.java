package com.tencent.av.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AvCustomDialog$2
  implements View.OnClickListener
{
  AvCustomDialog$2(AvCustomDialog paramAvCustomDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AvCustomDialog.2
 * JD-Core Version:    0.7.0.1
 */