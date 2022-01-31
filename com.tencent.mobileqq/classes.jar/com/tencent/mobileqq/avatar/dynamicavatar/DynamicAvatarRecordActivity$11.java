package com.tencent.mobileqq.avatar.dynamicavatar;

import android.view.WindowManager.BadTokenException;
import anul;
import bdgm;
import bdjz;
import com.tencent.qphone.base.util.QLog;

public class DynamicAvatarRecordActivity$11
  implements Runnable
{
  DynamicAvatarRecordActivity$11(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      str = this.this$0.getString(2131699726);
    }
    this.this$0.a = bdgm.a(this.this$0, 230).setMessage(str).setPositiveButton(this.this$0.getString(2131694207), new anul(this));
    try
    {
      this.this$0.a.setCancelable(false);
      this.this$0.a.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("DynamicAvatarRecordActivity", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.11
 * JD-Core Version:    0.7.0.1
 */