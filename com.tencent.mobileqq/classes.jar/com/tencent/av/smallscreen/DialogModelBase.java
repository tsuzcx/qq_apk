package com.tencent.av.smallscreen;

import android.os.Bundle;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public abstract class DialogModelBase
{
  protected final BaseActivity a;
  
  public DialogModelBase(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  protected abstract void a();
  
  protected abstract void a(Bundle paramBundle);
  
  void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (paramQQCustomDialog != null)
    {
      if (this.a.isFinishing()) {
        return;
      }
      boolean bool = false;
      try
      {
        paramQQCustomDialog.show();
        bool = true;
      }
      catch (Throwable paramQQCustomDialog)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showDialog BadTokenException, from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w("DialogModelBase", 1, localStringBuilder.toString(), paramQQCustomDialog);
      }
      catch (WindowManager.BadTokenException paramQQCustomDialog)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showDialog BadTokenException, from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w("DialogModelBase", 1, localStringBuilder.toString(), paramQQCustomDialog);
      }
      if (QLog.isColorLevel())
      {
        paramQQCustomDialog = new StringBuilder();
        paramQQCustomDialog.append("showDialog, from[");
        paramQQCustomDialog.append(paramString);
        paramQQCustomDialog.append("], isShowSuc[");
        paramQQCustomDialog.append(bool);
        paramQQCustomDialog.append("]");
        QLog.w("DialogModelBase", 2, paramQQCustomDialog.toString());
      }
    }
  }
  
  protected abstract void b();
  
  protected abstract void c();
  
  protected abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.DialogModelBase
 * JD-Core Version:    0.7.0.1
 */