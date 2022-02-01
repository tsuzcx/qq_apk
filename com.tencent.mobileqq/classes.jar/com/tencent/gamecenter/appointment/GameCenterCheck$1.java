package com.tencent.gamecenter.appointment;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.WLog;
import org.json.JSONArray;
import org.json.JSONException;

final class GameCenterCheck$1
  implements Runnable
{
  public void run()
  {
    String str2 = GameCenterSpUtils.a("APPOINTMENT_LIST");
    String str3 = GameCenterSpUtils.a("DELAY_LIST");
    String str4 = GameCenterSpUtils.a("APPOINTMENT_UPDATE_LIST");
    String str1 = GameCenterSpUtils.a("APPOINTMENT_TGPA_LIST");
    if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4)) && (TextUtils.isEmpty(str1)))
    {
      WLog.c("GameCenterCheck", "checkGameCenter no task, unRegisterReceiver");
      GameCenterBroadcastReceiver.b();
    }
    for (;;)
    {
      return;
      WLog.c("GameCenterCheck", "checkGameCenter begin");
      GameCenterUtils.a();
      if ((!TextUtils.isEmpty(str3)) && (GameCenterUtils.a)) {
        GameCenterCheck.a(str3.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str2)) && (GameCenterUtils.b)) {
        GameCenterCheck.b(str2.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str4)) && (GameCenterUtils.c)) {}
      try
      {
        GameCenterCheck.a(new JSONArray(str4));
        if (TextUtils.isEmpty(str1)) {
          continue;
        }
        try
        {
          GameCenterCheck.b(new JSONArray(str1));
          return;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          return;
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck.1
 * JD-Core Version:    0.7.0.1
 */