package com.tencent.mobileqq.activity.richmedia;

import ahvn;
import android.view.WindowManager.BadTokenException;
import bbcv;
import bbgg;
import com.tencent.qphone.base.util.QLog;

public class NewFlowCameraActivity$45
  implements Runnable
{
  NewFlowCameraActivity$45(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      str = this.this$0.getString(2131699354);
    }
    this.this$0.a = bbcv.a(this.this$0, 230).setMessage(str).setPositiveButton(this.this$0.getString(2131694087), new ahvn(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.45
 * JD-Core Version:    0.7.0.1
 */