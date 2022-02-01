package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QQTranslucentBrowserActivity$LoadingDialog
  extends ReportDialog
{
  public QQTranslucentBrowserActivity$LoadingDialog(Context paramContext)
  {
    super(paramContext, 2131953180);
    setContentView(2131628666);
    getWindow().setFlags(1024, 2048);
  }
  
  public void a(String paramString)
  {
    ((TextView)findViewById(2131447463)).setText(paramString);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WebLog_QQBrowserActivity", 2, localException, new Object[0]);
      }
    }
  }
  
  public void setTitle(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = getContext().getResources().getString(paramInt);
    }
    a(str);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WebLog_QQBrowserActivity", 2, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.LoadingDialog
 * JD-Core Version:    0.7.0.1
 */