package com.tencent.gamecenter.appointment;

import abub;
import abuf;
import android.text.TextUtils;
import bjqp;
import org.json.JSONArray;
import org.json.JSONException;

final class GameCenterCheck$1
  implements Runnable
{
  public void run()
  {
    String str2 = abuf.a("APPOINTMENT_LIST");
    String str3 = abuf.a("DELAY_LIST");
    String str4 = abuf.a("APPOINTMENT_UPDATE_LIST");
    String str1 = abuf.a("APPOINTMENT_TGPA_LIST");
    if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4)) && (TextUtils.isEmpty(str1)))
    {
      bjqp.c("GameCenterCheck", "checkGameCenter no task, unRegisterReceiver");
      abub.b();
    }
    for (;;)
    {
      return;
      bjqp.c("GameCenterCheck", "checkGameCenter begin");
      abuf.a();
      if ((!TextUtils.isEmpty(str3)) && (abuf.a)) {
        GameCenterCheck.a(str3.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str2)) && (abuf.b)) {
        GameCenterCheck.b(str2.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str4)) && (abuf.c)) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck.1
 * JD-Core Version:    0.7.0.1
 */