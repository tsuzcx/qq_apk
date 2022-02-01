package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;

class ReadInJoySettingActivity$20
  implements DialogInterface.OnKeyListener
{
  ReadInJoySettingActivity$20(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt == 4)
    {
      ReadInJoySettingActivity.a(this.a, true);
      paramDialogInterface = ReadInJoySettingActivity.a(this.a);
      if (ReadInJoySettingActivity.a(this.a)) {
        break label53;
      }
    }
    for (;;)
    {
      paramDialogInterface.setChecked(bool);
      ReadInJoySettingActivity.a(this.a).cancel();
      return false;
      label53:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.20
 * JD-Core Version:    0.7.0.1
 */