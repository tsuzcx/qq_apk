package com.tencent.biz.qqcircle.manager;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleRewardAdResultEvent;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;

class QcircleRewardAdManager$2
  implements VasRewardAdCallback
{
  QcircleRewardAdManager$2(QcircleRewardAdManager paramQcircleRewardAdManager, String paramString1, int paramInt1, int paramInt2, int paramInt3, Context paramContext, String paramString2) {}
  
  public void onReward(int paramInt, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("traceId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" type:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" number:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" request:");
    String str2 = "null";
    String str1;
    if (paramArrayOfByte1 == null) {
      str1 = "null";
    } else {
      str1 = new String(paramArrayOfByte1);
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(" report:");
    if (paramArrayOfByte2 == null) {
      str1 = str2;
    } else {
      str1 = new String(paramArrayOfByte2);
    }
    localStringBuilder.append(str1);
    QLog.e("QcircleRewardAdManager", 1, localStringBuilder.toString());
    if (this.d == 0) {
      HostUIHelper.closeHostEnvironment();
    }
    paramArrayOfByte1 = QcircleRewardAdManager.a(this.g, paramInt, paramArrayOfByte1, paramArrayOfByte2, QCircleApplication.APP, this.b);
    if (this.d == 0) {
      QcircleRewardAdManager.a(this.g, this.e, paramArrayOfByte1);
    } else {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleRewardAdResultEvent(paramArrayOfByte1));
    }
    paramArrayOfByte1 = this.g;
    QcircleRewardAdManager.a(paramArrayOfByte1, this.b, this.c, this.d, paramArrayOfByte1.a, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QcircleRewardAdManager.2
 * JD-Core Version:    0.7.0.1
 */