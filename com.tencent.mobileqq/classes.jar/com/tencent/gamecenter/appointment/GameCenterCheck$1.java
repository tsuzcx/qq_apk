package com.tencent.gamecenter.appointment;

import android.text.TextUtils;
import bckd;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import yez;

final class GameCenterCheck$1
  implements Runnable
{
  GameCenterCheck$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    int j = 0;
    bckd.b("GameCenterCheck", "start checkGameCenter isWiFi=" + AppNetConnInfo.isWifiConn());
    yez.a();
    String[] arrayOfString;
    int k;
    int i;
    if (!TextUtils.isEmpty(this.a))
    {
      arrayOfString = this.a.split("\\|");
      if ((yez.a) && (AppNetConnInfo.isWifiConn())) {
        yez.a(arrayOfString);
      }
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        yez.a(null, "558", "203713", arrayOfString[i], "55801", "4", "430");
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(this.b))
    {
      arrayOfString = this.b.split("\\|");
      if (yez.b) {
        yez.b(arrayOfString);
      }
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        yez.a(null, "558", "203701", arrayOfString[i], "55801", "4", "430");
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck.1
 * JD-Core Version:    0.7.0.1
 */