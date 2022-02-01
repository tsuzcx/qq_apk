package com.tencent.gamecenter.appointment;

import aced;
import aceh;
import android.text.TextUtils;
import bize;
import org.json.JSONArray;
import org.json.JSONException;

final class GameCenterCheck$1
  implements Runnable
{
  public void run()
  {
    String str3 = aceh.a("APPOINTMENT_LIST");
    String str4 = aceh.a("DELAY_LIST");
    String str5 = aceh.a("APPOINTMENT_UPDATE_LIST");
    String str2 = aceh.a("APPOINTMENT_TGPA_LIST");
    String str1 = aceh.a("UNPACK_APK_LIST");
    if ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4)) && (TextUtils.isEmpty(str5)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str1)))
    {
      bize.c("GameCenterCheck", "checkGameCenter no task, unRegisterReceiver");
      aced.b();
    }
    for (;;)
    {
      return;
      bize.c("GameCenterCheck", "checkGameCenter begin");
      aceh.a();
      if ((!TextUtils.isEmpty(str4)) && (aceh.a)) {
        GameCenterCheck.a(str4.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str3)) && (aceh.b)) {
        GameCenterCheck.b(str3.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str5)) && (aceh.c)) {}
      try
      {
        GameCenterCheck.a(new JSONArray(str5));
        if (TextUtils.isEmpty(str2)) {}
      }
      catch (JSONException localJSONException3)
      {
        try
        {
          GameCenterCheck.b(new JSONArray(str2));
          if ((TextUtils.isEmpty(str1)) || (!aceh.d)) {
            continue;
          }
          try
          {
            GameCenterCheck.c(new JSONArray(str1));
            return;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            return;
          }
          localJSONException3 = localJSONException3;
          localJSONException3.printStackTrace();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck.1
 * JD-Core Version:    0.7.0.1
 */