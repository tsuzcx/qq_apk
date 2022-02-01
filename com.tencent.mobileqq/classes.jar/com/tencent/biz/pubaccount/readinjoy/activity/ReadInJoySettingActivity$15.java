package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.Switch;

class ReadInJoySettingActivity$15
  implements ActionSheet.OnDismissListener
{
  ReadInJoySettingActivity$15(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onDismiss()
  {
    boolean bool = true;
    ReadInJoySettingActivity.a(this.a, true);
    Switch localSwitch = ReadInJoySettingActivity.a(this.a);
    if (!ReadInJoySettingActivity.a(this.a)) {}
    for (;;)
    {
      localSwitch.setChecked(bool);
      ReadInJoySettingActivity.a(this.a).cancel();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.15
 * JD-Core Version:    0.7.0.1
 */