package com.tencent.aelight.camera.ae.view;

import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class AECameraErrorDialog
{
  private static final String a = "AECameraErrorDialog";
  private Activity b;
  private QQCustomDialog c;
  
  public AECameraErrorDialog(Activity paramActivity)
  {
    this.b = paramActivity;
  }
  
  private void b(Runnable paramRunnable)
  {
    if (this.c != null) {
      return;
    }
    String str = this.b.getString(2131897217);
    this.c = DialogUtil.a(this.b, 230).setMessage(str).setPositiveButton(this.b.getString(2131891511), new AECameraErrorDialog.1(this, paramRunnable));
  }
  
  public void a()
  {
    QQCustomDialog localQQCustomDialog = this.c;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.hide();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      b(paramRunnable);
      if (!this.c.isShowing())
      {
        this.c.setCancelable(false);
        this.c.show();
        return;
      }
    }
    catch (WindowManager.BadTokenException paramRunnable)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "", paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECameraErrorDialog
 * JD-Core Version:    0.7.0.1
 */