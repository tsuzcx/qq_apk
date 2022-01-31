package com.tencent.gamecenter.appointment;

import aact;
import android.text.TextUtils;
import bfnq;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

final class GameCenterCheck$1
  implements Runnable
{
  GameCenterCheck$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    int j = 0;
    bfnq.c("GameCenterCheck", "start checkGameCenter isWiFi=" + AppNetConnInfo.isWifiConn());
    aact.a();
    String[] arrayOfString;
    int k;
    int i;
    if (!TextUtils.isEmpty(this.a))
    {
      arrayOfString = this.a.split("\\|");
      if ((aact.a) && (AppNetConnInfo.isWifiConn())) {
        aact.a(arrayOfString);
      }
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        aact.a(null, "558", "203713", arrayOfString[i], "55801", "4", "430");
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(this.b))
    {
      arrayOfString = this.b.split("\\|");
      if (aact.b) {
        aact.b(arrayOfString);
      }
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        aact.a(null, "558", "203701", arrayOfString[i], "55801", "4", "430");
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck.1
 * JD-Core Version:    0.7.0.1
 */