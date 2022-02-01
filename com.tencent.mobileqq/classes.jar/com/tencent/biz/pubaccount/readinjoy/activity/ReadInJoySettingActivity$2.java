package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.widget.Switch;

class ReadInJoySettingActivity$2
  implements QQProgressDialog.Callback
{
  ReadInJoySettingActivity$2(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void a()
  {
    boolean bool2 = true;
    Object localObject;
    if (this.a.a)
    {
      localObject = this.a;
      if (ReadInJoySettingActivity.a(this.a)) {
        break label61;
      }
      bool1 = true;
      ReadInJoySettingActivity.a((ReadInJoySettingActivity)localObject, bool1);
      localObject = ReadInJoySettingActivity.a(this.a);
      if (ReadInJoySettingActivity.a(this.a)) {
        break label66;
      }
    }
    label61:
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((Switch)localObject).setChecked(bool1);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.2
 * JD-Core Version:    0.7.0.1
 */