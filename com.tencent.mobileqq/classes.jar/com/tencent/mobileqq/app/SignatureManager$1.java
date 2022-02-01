package com.tencent.mobileqq.app;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class SignatureManager$1
  implements Handler.Callback
{
  SignatureManager$1(SignatureManager paramSignatureManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      SignatureManager.m = (SignatureTemplateConfig.SignatureTemplateType[])paramMessage.obj;
      if (this.a.j != null)
      {
        paramMessage = this.a.j.getHandler(EditActivity.class);
        if (paramMessage != null) {
          paramMessage.sendEmptyMessageDelayed(2, 50L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "update sign tpl info...");
        }
      }
    }
    else if ((3 == paramMessage.what) && (this.a.j != null))
    {
      paramMessage = this.a.j.getHandler(EditActivity.class);
      if (paramMessage != null) {
        paramMessage.sendEmptyMessageDelayed(7, 50L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Signature", 2, "update sign tpl animation ...");
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.1
 * JD-Core Version:    0.7.0.1
 */