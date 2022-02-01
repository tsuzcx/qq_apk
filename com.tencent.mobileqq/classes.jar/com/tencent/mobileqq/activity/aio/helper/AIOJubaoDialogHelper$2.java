package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOJubaoDialogHelper$2
  implements View.OnClickListener
{
  AIOJubaoDialogHelper$2(AIOJubaoDialogHelper paramAIOJubaoDialogHelper) {}
  
  public void onClick(View paramView)
  {
    this.a.a.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper.2
 * JD-Core Version:    0.7.0.1
 */