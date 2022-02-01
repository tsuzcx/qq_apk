package com.huawei.hms.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.huawei.hms.support.log.HMSLog;

public abstract class AbstractDialog
{
  public Activity a;
  public AlertDialog b;
  public AbstractDialog.Callback c;
  
  public static int a(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  public void cancel()
  {
    AlertDialog localAlertDialog = this.b;
    if (localAlertDialog != null) {
      localAlertDialog.cancel();
    }
  }
  
  public void dismiss()
  {
    AlertDialog localAlertDialog = this.b;
    if (localAlertDialog != null) {
      localAlertDialog.dismiss();
    }
  }
  
  public void fireCancel()
  {
    AbstractDialog.Callback localCallback = this.c;
    if (localCallback != null) {
      localCallback.onCancel(this);
    }
  }
  
  public void fireDoWork()
  {
    AbstractDialog.Callback localCallback = this.c;
    if (localCallback != null) {
      localCallback.onDoWork(this);
    }
  }
  
  public Activity getActivity()
  {
    return this.a;
  }
  
  public int getDialogThemeId()
  {
    if ((a(this.a) != 0) && (Build.VERSION.SDK_INT >= 16)) {
      return 0;
    }
    return 3;
  }
  
  public AlertDialog onCreateDialog(Activity paramActivity)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity(), getDialogThemeId());
    String str = onGetTitleString(paramActivity);
    if (str != null) {
      localBuilder.setTitle(str);
    }
    str = onGetMessageString(paramActivity);
    if (str != null) {
      localBuilder.setMessage(str);
    }
    str = onGetPositiveButtonString(paramActivity);
    if (str != null) {
      localBuilder.setPositiveButton(str, new AbstractDialog.a(this));
    }
    paramActivity = onGetNegativeButtonString(paramActivity);
    if (paramActivity != null) {
      localBuilder.setNegativeButton(paramActivity, new AbstractDialog.b(this));
    }
    return localBuilder.create();
  }
  
  public abstract String onGetMessageString(Context paramContext);
  
  public abstract String onGetNegativeButtonString(Context paramContext);
  
  public abstract String onGetPositiveButtonString(Context paramContext);
  
  public abstract String onGetTitleString(Context paramContext);
  
  public void setMessage(CharSequence paramCharSequence)
  {
    AlertDialog localAlertDialog = this.b;
    if (localAlertDialog != null) {
      localAlertDialog.setMessage(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AlertDialog localAlertDialog = this.b;
    if (localAlertDialog != null) {
      localAlertDialog.setTitle(paramCharSequence);
    }
  }
  
  public void show(Activity paramActivity, AbstractDialog.Callback paramCallback)
  {
    this.a = paramActivity;
    this.c = paramCallback;
    paramActivity = this.a;
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      this.b = onCreateDialog(this.a);
      this.b.setCanceledOnTouchOutside(false);
      this.b.setOnCancelListener(new AbstractDialog.c(this));
      this.b.setOnKeyListener(new AbstractDialog.d(this));
      this.b.show();
      return;
    }
    HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.ui.AbstractDialog
 * JD-Core Version:    0.7.0.1
 */