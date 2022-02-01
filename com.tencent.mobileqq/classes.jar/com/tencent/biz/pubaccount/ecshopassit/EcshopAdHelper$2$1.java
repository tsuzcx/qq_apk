package com.tencent.biz.pubaccount.ecshopassit;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

class EcshopAdHelper$2$1
  implements PopupWindow.OnDismissListener
{
  EcshopAdHelper$2$1(EcshopAdHelper.2 param2) {}
  
  public void onDismiss()
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.a.a).getWindow().getAttributes();
    localLayoutParams.alpha = 1.0F;
    ((Activity)this.a.a).getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHelper.2.1
 * JD-Core Version:    0.7.0.1
 */