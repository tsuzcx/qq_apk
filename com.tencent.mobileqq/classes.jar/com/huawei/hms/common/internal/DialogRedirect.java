package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

public abstract class DialogRedirect
  implements DialogInterface.OnClickListener
{
  public static DialogRedirect getInstance(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    return new DialogRedirectImpl(paramIntent, paramActivity, paramInt);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      redirect();
      return;
    }
    catch (Throwable localThrowable)
    {
      HMSLog.e("DialogRedirect", "Failed to start resolution intent");
      return;
    }
    finally
    {
      paramDialogInterface.dismiss();
    }
  }
  
  protected abstract void redirect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.DialogRedirect
 * JD-Core Version:    0.7.0.1
 */