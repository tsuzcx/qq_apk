package com.tencent.mobileqq.avatar.dynamicavatar;

import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class DynamicAvatarRecordActivity$11
  implements Runnable
{
  DynamicAvatarRecordActivity$11(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = this.a;
    if (this.b == 2002) {
      str = this.this$0.getString(2131897217);
    }
    DynamicAvatarRecordActivity localDynamicAvatarRecordActivity = this.this$0;
    localDynamicAvatarRecordActivity.S = DialogUtil.a(localDynamicAvatarRecordActivity, 230).setMessage(str).setPositiveButton(this.this$0.getString(2131891511), new DynamicAvatarRecordActivity.11.1(this));
    try
    {
      this.this$0.S.setCancelable(false);
      this.this$0.S.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DynamicAvatarRecordActivity", 2, "", localBadTokenException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.11
 * JD-Core Version:    0.7.0.1
 */