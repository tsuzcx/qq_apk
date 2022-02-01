package com.tencent.mobileqq.activity.aio.roam;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class C2CRoamMsgFetcher$3
  extends AccountObserver
{
  C2CRoamMsgFetcher$3(C2CRoamMsgFetcher paramC2CRoamMsgFetcher) {}
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onRefrshDA2 result: ");
      paramString1.append(paramBoolean);
      paramString1.append(", da2 length: ");
      if (paramString2 == null) {
        i = 0;
      } else {
        i = paramString2.length();
      }
      paramString1.append(i);
      QLog.d("C2CMsgRoamProxy", 2, paramString1.toString());
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString2))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      C2CRoamMsgFetcher.a(this.a, true);
    } else {
      C2CRoamMsgFetcher.a(this.a, false);
    }
    C2CRoamMsgFetcher.c(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.roam.C2CRoamMsgFetcher.3
 * JD-Core Version:    0.7.0.1
 */