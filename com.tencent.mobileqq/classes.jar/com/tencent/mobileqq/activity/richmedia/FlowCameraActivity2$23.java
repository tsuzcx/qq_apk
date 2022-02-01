package com.tencent.mobileqq.activity.richmedia;

import akro;
import android.view.WindowManager.BadTokenException;
import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class FlowCameraActivity2$23
  implements Runnable
{
  FlowCameraActivity2$23(FlowCameraActivity2 paramFlowCameraActivity2, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      str = this.this$0.getString(2131698487);
    }
    this.this$0.a = bfur.a(this.this$0, 230).setMessage(str).setPositiveButton(this.this$0.getString(2131693580), new akro(this));
    try
    {
      this.this$0.a.setCancelable(false);
      this.this$0.a.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FlowCameraActivity", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.23
 * JD-Core Version:    0.7.0.1
 */