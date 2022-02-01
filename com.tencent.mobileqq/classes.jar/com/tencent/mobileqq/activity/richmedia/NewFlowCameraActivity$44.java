package com.tencent.mobileqq.activity.richmedia;

import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$44
  implements Runnable
{
  NewFlowCameraActivity$44(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      str = this.this$0.getString(2131699097);
    }
    this.this$0.a = DialogUtil.a(this.this$0, 230).setMessage(str).setPositiveButton(this.this$0.getString(2131693935), new NewFlowCameraActivity.44.1(this));
    try
    {
      this.this$0.a.setCancelable(false);
      this.this$0.a.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("PTV.NewFlowCameraActivity", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.44
 * JD-Core Version:    0.7.0.1
 */