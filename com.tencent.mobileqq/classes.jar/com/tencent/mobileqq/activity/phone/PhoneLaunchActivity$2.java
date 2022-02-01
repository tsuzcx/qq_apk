package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;

class PhoneLaunchActivity$2
  implements DenyRunnable.OnCancelAction
{
  PhoneLaunchActivity$2(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
  public void onCancel(Context paramContext, boolean paramBoolean)
  {
    PhoneLaunchActivity.a(this.a).setEnabled(true);
    if ((!paramBoolean) && (paramContext != null))
    {
      Intent localIntent = new Intent(paramContext, GuideBindPhoneActivity.class);
      localIntent.putExtra("fromKeyForContactBind", 2);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.2
 * JD-Core Version:    0.7.0.1
 */