package com.tencent.gamecenter.appointment;

import aacp;
import aacr;
import aact;
import android.text.TextUtils;
import aywz;
import bfnq;
import bfnt;
import bkeu;
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
    String str1 = aact.a("APPOINTMENT_CHECKLIST");
    String str2 = aact.a("APPOINTMENT_LIST");
    String str3 = aact.a("DELAY_LIST");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)))
    {
      if (QLog.isColorLevel()) {
        bfnq.c("GameCenterCheck", "checkGameCenter no task");
      }
      aacp.b();
      return;
    }
    if (QLog.isColorLevel()) {
      bfnq.c("GameCenterCheck", "checkGameCenter checkList=" + str1);
    }
    ThreadManager.excute(new GameCenterCheck.1(str3, str2), 192, null, false);
  }
  
  public static void c()
  {
    Object localObject = aact.a("APPOINTMENT_RES_LIST");
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
          String str = aact.a("APPID_PKGNAME_" + localObject[i]);
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
      GameHelper.getGameVersionUpdateInfo(BaseApplicationImpl.getContext(), "qq", localArrayList, new aacr(localJSONObject));
    }
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      bfnq.c("GameCenterCheck", "yuyue:GameCenterCheck start");
    }
    aact.a();
    if ((!aact.b) && (!aact.a))
    {
      if (QLog.isColorLevel()) {
        bfnq.c("GameCenterCheck", "yuyue:!GameCenterUtils.isAppointDownload && !GameCenterUtils.isDelayDownload");
      }
      return super.a();
    }
    Long localLong3 = Long.valueOf(aact.a("APPOINTMENT_LASTGET_TIME"));
    Long localLong2 = Long.valueOf(aact.a("APPOINTMENT_LOAD_GAP"));
    Long localLong1 = localLong2;
    if (0L == localLong2.longValue()) {
      localLong1 = Long.valueOf(30L);
    }
    if (NetConnInfoCenter.getServerTime() - localLong3.longValue() < localLong1.longValue())
    {
      if (QLog.isColorLevel()) {
        bfnq.c("GameCenterCheck", "yuyue:no getAppointment list ,loadGap=" + localLong1 + ", lastTime:" + localLong3);
      }
      b();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(aact.a("APPOINTMENT_LIST"))) || (!TextUtils.isEmpty(aact.a("APPOINTMENT_CHECKLIST"))) || (!TextUtils.isEmpty(aact.a("DELAY_LIST")))) {
        aacp.a();
      }
      bfnt.a();
      bkeu.a().a(false, -1L);
      return super.a();
      if (QLog.isColorLevel()) {
        bfnq.c("GameCenterCheck", "yuyue: getPreDownloadList loadGap=" + localLong1 + ",isAppointDownload=" + aact.b);
      }
      if (aact.b) {
        ((aywz)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(12)).c();
      }
      aact.a("APPOINTMENT_LASTGET_TIME", NetConnInfoCenter.getServerTime());
    }
  }
  
  public void a()
  {
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck
 * JD-Core Version:    0.7.0.1
 */