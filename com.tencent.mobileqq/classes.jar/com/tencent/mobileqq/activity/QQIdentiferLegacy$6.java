package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.WeJson;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

class QQIdentiferLegacy$6
  implements YTAGReflectLiveCheckInterface.GetLiveStyleResult
{
  QQIdentiferLegacy$6(QQIdentiferLegacy paramQQIdentiferLegacy, boolean paramBoolean) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    String str = new WeJson().toJson(new LiveStyleRequester.YTLiveStyleReq(-2.0F, "10164651"));
    Message localMessage = this.b.d.obtainMessage(2);
    localMessage.arg1 = 24;
    localMessage.obj = str;
    if (paramInt == 3) {
      this.b.d.sendMessageDelayed(localMessage, 2000L);
    } else {
      this.b.d.sendMessage(localMessage);
    }
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "getLightInfo Failed code=", Integer.valueOf(paramInt), " tips=", paramString1, " howtofix=", paramString2, " lightRTry=", Integer.valueOf(QQIdentiferLegacy.f(this.b).get()) });
  }
  
  public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse)
  {
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "getLightInfo success, current is loading : ", Boolean.valueOf(QQIdentiferLegacy.e(this.b).get()) });
    paramYTLiveStyleReq.app_id = "10164651";
    paramYTLiveStyleReq = new WeJson().toJson(paramYTLiveStyleReq);
    this.b.d.removeMessages(2);
    paramLiveStyleResponse = this.b.d.obtainMessage(2);
    paramLiveStyleResponse.arg1 = 23;
    this.b.d.sendMessage(paramLiveStyleResponse);
    if (QQIdentiferLegacy.e(this.b).compareAndSet(true, true)) {
      return;
    }
    QQIdentiferLegacy.a(this.b, paramYTLiveStyleReq, this.a);
    if (QLog.isColorLevel()) {
      QLog.d("QQIdentiferLegacy", 2, "getLightInfo success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.6
 * JD-Core Version:    0.7.0.1
 */