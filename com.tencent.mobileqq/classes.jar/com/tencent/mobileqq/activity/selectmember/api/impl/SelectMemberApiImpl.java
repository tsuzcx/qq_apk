package com.tencent.mobileqq.activity.selectmember.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberApi;
import com.tencent.qphone.base.util.QLog;

public class SelectMemberApiImpl
  implements ISelectMemberApi
{
  private static final String TAG = "SelectMemberApiImpl";
  
  public void startSelectMemberActivityForResult(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())))
    {
      QLog.e("SelectMemberApiImpl", 1, "startSelectMemberActivityForResult, activity is null/finished. sdk_int: " + Build.VERSION.SDK_INT);
      return;
    }
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.api.impl.SelectMemberApiImpl
 * JD-Core Version:    0.7.0.1
 */