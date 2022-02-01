package com.tencent.av.service;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQServiceForAV$6
  extends NearbyCardObserver
{
  QQServiceForAV$6(QQServiceForAV paramQQServiceForAV) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(", nickname=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", gender=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", age=");
    ((StringBuilder)localObject1).append(paramInt2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QQServiceForAV.onNearbyCardDownload(), isSuccess: ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", card = ");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new Intent();
    ((Intent)localObject2).setAction("tencent.video.q2v.getNearByProfile");
    ((Intent)localObject2).putExtra("uin", String.valueOf(paramLong));
    ((Intent)localObject2).putExtra("nickname", paramString);
    ((Intent)localObject2).putExtra("gender", paramInt1);
    ((Intent)localObject2).putExtra("age", paramInt2);
    localObject1 = (QQAppInterface)this.a.a();
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = (QQAppInterface)this.a.a();
    }
    if (paramString != null) {
      paramString.getApp().sendBroadcast((Intent)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.6
 * JD-Core Version:    0.7.0.1
 */