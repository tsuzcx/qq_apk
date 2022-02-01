package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SDKSetEmotionDialog$1
  implements View.OnClickListener
{
  SDKSetEmotionDialog$1(SDKSetEmotionDialog paramSDKSetEmotionDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.b, 0);
    }
    try
    {
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
      label37:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKSetEmotionDialog.1
 * JD-Core Version:    0.7.0.1
 */