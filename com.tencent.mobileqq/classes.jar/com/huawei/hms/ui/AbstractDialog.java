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
  private Activity a;
  private AlertDialog b;
  private AbstractDialog.Callback c;
  
  private static int a(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  public void cancel()
  {
    if (this.b != null) {
      this.b.cancel();
    }
  }
  
  public void dismiss()
  {
    if (this.b != null) {
      this.b.dismiss();
    }
  }
  
  protected void fireCancel()
  {
    if (this.c != null) {
      this.c.onCancel(this);
    }
  }
  
  protected void fireDoWork()
  {
    if (this.c != null) {
      this.c.onDoWork(this);
    }
  }
  
  protected Activity getActivity()
  {
    return this.a;
  }
  
  protected int getDialogThemeId()
  {
    if ((a(this.a) != 0) && (Build.VERSION.SDK_INT >= 16)) {
      return 0;
    }
    return 3;
  }
  
  protected AlertDialog onCreateDialog(Activity paramActivity)
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
      localBuilder.setPositiveButton(str, new AbstractDialog.1(this));
    }
    paramActivity = onGetNegativeButtonString(paramActivity);
    if (paramActivity != null) {
      localBuilder.setNegativeButton(paramActivity, new AbstractDialog.2(this));
    }
    return localBuilder.create();
  }
  
  protected abstract String onGetMessageString(Context paramContext);
  
  protected abstract String onGetNegativeButtonString(Context paramContext);
  
  protected abstract String onGetPositiveButtonString(Context paramContext);
  
  protected abstract String onGetTitleString(Context paramContext);
  
  public void setMessage(CharSequence paramCharSequence)
  {
    if (this.b != null) {
      this.b.setMessage(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.b != null) {
      this.b.setTitle(paramCharSequence);
    }
  }
  
  public void show(Activity paramActivity, AbstractDialog.Callback paramCallback)
  {
    this.a = paramActivity;
    this.c = paramCallback;
    if ((this.a == null) || (this.a.isFinishing()))
    {
      HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
      return;
    }
    this.b = onCreateDialog(this.a);
    this.b.setCanceledOnTouchOutside(false);
    this.b.setOnCancelListener(new AbstractDialog.3(this));
    this.b.setOnKeyListener(new AbstractDialog.4(this));
    this.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.ui.AbstractDialog
 * JD-Core Version:    0.7.0.1
 */