package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class NewAuthDevUgFragment$2
  extends BroadcastReceiver
{
  NewAuthDevUgFragment$2(NewAuthDevUgFragment paramNewAuthDevUgFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (NewAuthDevUgFragment.l(this.a) == null) {
      QLog.e("NewAuthDevUgFragment", 1, "mBroadcastReceiver.onReceive: mDevlockInfo is null.");
    }
    paramContext = paramIntent.getStringExtra("PhoneNum");
    paramIntent = paramIntent.getStringExtra("PhoneCountryCode");
    if (!NewAuthDevUgFragment.a(this.a, paramContext, paramIntent))
    {
      QLog.e("NewAuthDevUgFragment", 1, "mBroadcastReceiver.onReceive: PhoneNum is not valid.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.substring(0, 3));
    localStringBuilder.append("******");
    localStringBuilder.append(paramContext.substring(paramContext.length() - 2));
    paramContext = localStringBuilder.toString();
    NewAuthDevUgFragment.l(this.a).Mobile = paramContext;
    if (!TextUtils.isEmpty(paramIntent)) {
      NewAuthDevUgFragment.l(this.a).CountryCode = paramIntent;
    }
    NewAuthDevUgFragment.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment.2
 * JD-Core Version:    0.7.0.1
 */