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
    super(paramContext, 2131755693);
    setContentView(2131562402);
    getWindow().setFlags(1024, 2048);
  }
  
  public void a(String paramString)
  {
    ((TextView)findViewById(2131379432)).setText(paramString);
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
      while (!QLog.isColorLevel()) {}
      QLog.e("WebLog_QQBrowserActivity", 2, localException, new Object[0]);
    }
  }
  
  public void setTitle(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = null;; str = getContext().getResources().getString(paramInt))
    {
      a(str);
      return;
    }
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
      while (!QLog.isColorLevel()) {}
      QLog.e("WebLog_QQBrowserActivity", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.LoadingDialog
 * JD-Core Version:    0.7.0.1
 */