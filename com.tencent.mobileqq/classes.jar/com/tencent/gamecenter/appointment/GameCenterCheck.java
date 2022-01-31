package com.tencent.gamecenter.appointment;

import android.text.TextUtils;
import axbt;
import bdoe;
import bich;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tgpa.vendorpd.GameHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import ynz;
import yob;
import yod;

public class GameCenterCheck
  extends AsyncStep
{
  public final long a;
  
  public GameCenterCheck()
  {
    this.jdField_a_of_type_Long = 30L;
  }
  
  public static void b()
  {
    String str1 = yod.a("APPOINTMENT_CHECKLIST");
    String str2 = yod.a("APPOINTMENT_LIST");
    String str3 = yod.a("DELAY_LIST");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)))
    {
      if (QLog.isColorLevel()) {
        bdoe.b("GameCenterCheck", "checkGameCenter no task");
      }
      ynz.b();
      return;
    }
    if (QLog.isColorLevel()) {
      bdoe.b("GameCenterCheck", "checkGameCenter checkList=" + str1);
    }
    ThreadManager.excute(new GameCenterCheck.1(str3, str2), 192, null, false);
  }
  
  public static void c()
  {
    Object localObject = yod.a("APPOINTMENT_RES_LIST");
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterCheck", 2, "checkGameRes resList =" + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      ArrayList localArrayList = new ArrayList();
      JSONObject localJSONObject = new JSONObject();
      int i = 0;
      for (;;)
      {
        if (i < localObject.length)
        {
          String str = yod.a("APPID_PKGNAME_" + localObject[i]);
          try
          {
            localJSONObject.put(str, localObject[i]);
            localArrayList.add(str);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              QLog.e("GameCenterCheck", 1, "checkGameRes read appid_pkg fail e=" + localJSONException.toString());
            }
          }
        }
      }
      GameHelper.getGameVersionUpdateInfo(BaseApplicationImpl.getContext(), "qq", localArrayList, new yob(localJSONObject));
    }
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      bdoe.b("GameCenterCheck", "yuyue:GameCenterCheck start");
    }
    yod.a();
    if ((!yod.b) && (!yod.a))
    {
      if (QLog.isColorLevel()) {
        bdoe.b("GameCenterCheck", "yuyue:!GameCenterUtils.isAppointDownload && !GameCenterUtils.isDelayDownload");
      }
      return super.a();
    }
    Long localLong3 = Long.valueOf(yod.a("APPOINTMENT_LASTGET_TIME"));
    Long localLong2 = Long.valueOf(yod.a("APPOINTMENT_LOAD_GAP"));
    Long localLong1 = localLong2;
    if (0L == localLong2.longValue()) {
      localLong1 = Long.valueOf(30L);
    }
    if (NetConnInfoCenter.getServerTime() - localLong3.longValue() < localLong1.longValue())
    {
      if (QLog.isColorLevel()) {
        bdoe.b("GameCenterCheck", "yuyue:no getAppointment list ,loadGap=" + localLong1 + ", lastTime:" + localLong3);
      }
      b();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(yod.a("APPOINTMENT_LIST"))) || (!TextUtils.isEmpty(yod.a("APPOINTMENT_CHECKLIST"))) || (!TextUtils.isEmpty(yod.a("DELAY_LIST")))) {
        ynz.a();
      }
      GameCenterReceiver.a();
      bich.a().a(false, -1L);
      return super.a();
      if (QLog.isColorLevel()) {
        bdoe.b("GameCenterCheck", "yuyue: getPreDownloadList loadGap=" + localLong1 + ",isAppointDownload=" + yod.b);
      }
      if (yod.b) {
        ((axbt)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(12)).c();
      }
      yod.a("APPOINTMENT_LASTGET_TIME", NetConnInfoCenter.getServerTime());
    }
  }
  
  public void a()
  {
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck
 * JD-Core Version:    0.7.0.1
 */