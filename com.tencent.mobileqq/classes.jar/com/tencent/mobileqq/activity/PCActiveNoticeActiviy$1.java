package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

class PCActiveNoticeActiviy$1
  implements DialogInterface.OnClickListener
{
  PCActiveNoticeActiviy$1(PCActiveNoticeActiviy paramPCActiveNoticeActiviy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SettingCloneUtil.writeValue(this.a, PCActiveNoticeActiviy.a(this.a), null, "pcactive_notice_key", false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy.1
 * JD-Core Version:    0.7.0.1
 */