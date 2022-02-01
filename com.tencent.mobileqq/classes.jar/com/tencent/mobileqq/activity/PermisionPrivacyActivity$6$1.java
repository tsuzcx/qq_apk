package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;

class PermisionPrivacyActivity$6$1
  implements Runnable
{
  PermisionPrivacyActivity$6$1(PermisionPrivacyActivity.6 param6) {}
  
  public void run()
  {
    if (PermisionPrivacyActivity.a(this.a.this$0) == 0)
    {
      PermisionPrivacyActivity.a(this.a.this$0).setRightText("");
      return;
    }
    FormSimpleItem localFormSimpleItem = PermisionPrivacyActivity.a(this.a.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PermisionPrivacyActivity.a(this.a.this$0));
    localStringBuilder.append(HardCodeUtil.a(2131707925));
    localFormSimpleItem.setRightText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.6.1
 * JD-Core Version:    0.7.0.1
 */