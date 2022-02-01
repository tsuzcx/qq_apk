package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class OverloadTipsActivity$2
  implements DialogInterface.OnKeyListener
{
  OverloadTipsActivity$2(OverloadTipsActivity paramOverloadTipsActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.a.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.OverloadTipsActivity.2
 * JD-Core Version:    0.7.0.1
 */