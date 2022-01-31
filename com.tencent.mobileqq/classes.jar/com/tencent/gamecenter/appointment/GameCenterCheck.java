package com.tencent.gamecenter.appointment;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.open.wadl.WLog;
import com.tencent.open.wadl.WadlJsBridge;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;
import qhl;
import qhm;

public class GameCenterCheck
  extends AsyncStep
{
  public static String a;
  public final long a;
  public INetEngine.INetEngineListener a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://info.gamecenter.qq.com/cgi-bin/gc_pre_download_async_fcgi?param={\"key\":{\"param\":{\"qq_version\":\"7.6.0.3525\"},\"module\":\"gc_pre_download\",\"method\":\"get_pre_download\"}}";
  }
  
  public GameCenterCheck()
  {
    this.jdField_a_of_type_Long = 86400L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new qhl(this);
  }
  
  public static void b()
  {
    String str1 = GameCenterUtils.a("APPOINTMENT_CHECKLIST");
    String str2 = GameCenterUtils.a("APPOINTMENT_LIST");
    String str3 = GameCenterUtils.a("DELAY_LIST");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)))
    {
      if (QLog.isColorLevel()) {
        WLog.b("QQInitHandler", "checkGameCenter no task");
      }
      GameCenterBroadcastReceiver.b();
      return;
    }
    ThreadManager.post(new qhm(str3, str2), 5, null, false);
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      WLog.b("QQInitHandler", "yuyue:GameCenterCheck start");
    }
    Object localObject = BaseApplicationImpl.getContext();
    WadlJsBridge.registerPackageInstallNotificationReceiver((Context)localObject, GameCenterUtils.a((Context)localObject));
    GameCenterUtils.a();
    if ((!GameCenterUtils.b) && (!GameCenterUtils.a))
    {
      if (QLog.isColorLevel()) {
        WLog.b("QQInitHandler", "yuyue:!GameCenterUtils.isAppointDownload && !GameCenterUtils.isDelayDownload");
      }
      return super.a();
    }
    Long localLong2 = Long.valueOf(GameCenterUtils.a("APPOINTMENT_LASTGET_TIME"));
    Long localLong1 = Long.valueOf(GameCenterUtils.a("APPOINTMENT_LOAD_GAP"));
    localObject = localLong1;
    if (0L == localLong1.longValue()) {
      localObject = Long.valueOf(86400L);
    }
    if (NetConnInfoCenter.getServerTime() - localLong2.longValue() < ((Long)localObject).longValue())
    {
      if (QLog.isColorLevel()) {
        WLog.b("QQInitHandler", "yuyue:no getAppointment list , lastTime:" + localLong2);
      }
      b();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(GameCenterUtils.a("APPOINTMENT_LIST"))) || (!TextUtils.isEmpty(GameCenterUtils.a("APPOINTMENT_CHECKLIST"))) || (!TextUtils.isEmpty(GameCenterUtils.a("DELAY_LIST")))) {
        GameCenterBroadcastReceiver.a();
      }
      return super.a();
      if (GameCenterUtils.b) {
        GameCenterUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener);
      }
      GameCenterUtils.a("APPOINTMENT_LASTGET_TIME", NetConnInfoCenter.getServerTime());
    }
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          WLog.b("QQInitHandler", "strJson=" + paramString);
        }
        paramString = new JSONObject(paramString).getJSONObject("data").getJSONObject("key").getJSONObject("retBody").getJSONObject("data");
        GameCenterUtils.a("APPOINTMENT_LOAD_GAP", paramString.optLong("load_gap", 86400L));
        JSONArray localJSONArray = paramString.getJSONArray("pre_download_list");
        String[] arrayOfString = GameCenterUtils.a("APPOINTMENT_HAS_DOWNLOAD_LIST").split("\\|");
        int i = 0;
        if (i < localJSONArray.length())
        {
          paramString = new JSONObject((String)localJSONArray.get(i)).optString("appid");
          j = 0;
          if (j < arrayOfString.length)
          {
            paramString = new JSONObject((String)localJSONArray.get(i)).optString("appid");
            if ((!TextUtils.isEmpty(arrayOfString[j])) && (!TextUtils.isEmpty(paramString)) && (arrayOfString[j].equals(paramString)))
            {
              j = 1;
              if ((j == 0) && (!TextUtils.isEmpty(paramString)))
              {
                GameCenterUtils.c(paramString, "APPOINTMENT_LIST");
                GameCenterUtils.a(paramString, localJSONArray.get(i).toString(), "APPOINT_APPID_DETAIL_");
                GameCenterUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, "426", "202238", paramString, "42601", "1", "116");
              }
              i += 1;
              continue;
            }
            j += 1;
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck
 * JD-Core Version:    0.7.0.1
 */