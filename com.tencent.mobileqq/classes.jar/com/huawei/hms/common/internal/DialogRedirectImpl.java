package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

public class DialogRedirectImpl
  extends DialogRedirect
{
  private final Activity activity;
  private final Intent intent;
  private final int requestCode;
  
  DialogRedirectImpl(Intent paramIntent, Activity paramActivity, int paramInt)
  {
    this.intent = paramIntent;
    this.activity = paramActivity;
    this.requestCode = paramInt;
  }
  
  public final void redirect()
  {
    Intent localIntent = this.intent;
    if (localIntent != null) {
      this.activity.startActivityForResult(localIntent, this.requestCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.DialogRedirectImpl
 * JD-Core Version:    0.7.0.1
 */