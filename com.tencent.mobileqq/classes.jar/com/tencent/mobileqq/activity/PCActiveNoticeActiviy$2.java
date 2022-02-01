package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

class PCActiveNoticeActiviy$2
  implements DialogInterface.OnKeyListener
{
  PCActiveNoticeActiviy$2(PCActiveNoticeActiviy paramPCActiveNoticeActiviy) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      SettingCloneUtil.writeValue(this.a, PCActiveNoticeActiviy.a(this.a), null, "pcactive_notice_key", false);
      this.a.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy.2
 * JD-Core Version:    0.7.0.1
 */