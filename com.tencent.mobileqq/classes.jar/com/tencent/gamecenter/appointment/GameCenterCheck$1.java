package com.tencent.gamecenter.appointment;

import abep;
import abet;
import android.text.TextUtils;
import bifn;
import org.json.JSONArray;
import org.json.JSONException;

final class GameCenterCheck$1
  implements Runnable
{
  public void run()
  {
    String str2 = abet.a("APPOINTMENT_LIST");
    String str3 = abet.a("DELAY_LIST");
    String str4 = abet.a("APPOINTMENT_UPDATE_LIST");
    String str1 = abet.a("APPOINTMENT_TGPA_LIST");
    if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4)) && (TextUtils.isEmpty(str1)))
    {
      bifn.c("GameCenterCheck", "checkGameCenter no task, unRegisterReceiver");
      abep.b();
    }
    for (;;)
    {
      return;
      bifn.c("GameCenterCheck", "checkGameCenter begin");
      abet.a();
      if ((!TextUtils.isEmpty(str3)) && (abet.a)) {
        GameCenterCheck.a(str3.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str2)) && (abet.b)) {
        GameCenterCheck.b(str2.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str4)) && (abet.c)) {}
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