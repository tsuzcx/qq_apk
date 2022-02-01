package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class QQIdentiferLegacy$7
  implements EIPCResultCallback
{
  QQIdentiferLegacy$7(QQIdentiferLegacy paramQQIdentiferLegacy, boolean paramBoolean, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callServer ACTION_APP_CONF error_code:");
    localStringBuilder.append(paramEIPCResult.code);
    QLog.d("QQIdentiferLegacy", 1, localStringBuilder.toString());
    int i = paramEIPCResult.code;
    if (i != -102)
    {
      if (i != 0)
      {
        if (i != 15)
        {
          QQIdentiferLegacy.e(this.c).set(false);
        }
        else
        {
          QQIdentiferLegacy.e(this.c).set(false);
          QQIdentiferLegacy.a(this.c, true);
        }
      }
      else
      {
        QQIdentiferLegacy.e(this.c).set(false);
        if (paramEIPCResult.data != null)
        {
          paramEIPCResult = (AppConf)paramEIPCResult.data.getSerializable("FaceRecognition.AppConf");
          QQIdentiferLegacy.c(this.c).setAppConf(paramEIPCResult);
          QQIdentiferLegacy.g(this.c);
        }
        QLog.d("QQIdentiferLegacy", 1, new Object[] { "callServer ACTION_APP_CONF success conf :", QQIdentiferLegacy.c(this.c).getAppConf() });
      }
    }
    else {
      QQIdentiferLegacy.e(this.c).set(false);
    }
    if (this.a)
    {
      QQIdentiferLegacy.h(this.c);
    }
    else if ("identify".equals(this.b))
    {
      QQIdentiferUtil.a(QQIdentiferLegacy.c(this.c).getAppConf(), "0X800B2BE");
      this.c.d.removeCallbacks(QQIdentiferLegacy.i(this.c));
    }
    QQIdentiferLegacy.b(this.c, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.7
 * JD-Core Version:    0.7.0.1
 */