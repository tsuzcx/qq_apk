package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class SpaceLowNoticeActiviy$3
  implements DialogInterface.OnKeyListener
{
  SpaceLowNoticeActiviy$3(SpaceLowNoticeActiviy paramSpaceLowNoticeActiviy) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.a.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SpaceLowNoticeActiviy.3
 * JD-Core Version:    0.7.0.1
 */