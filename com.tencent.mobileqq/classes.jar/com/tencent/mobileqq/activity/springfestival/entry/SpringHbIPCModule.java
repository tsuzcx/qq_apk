package com.tencent.mobileqq.activity.springfestival.entry;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager;
import com.tencent.mobileqq.activity.springfestival.entry.model.CommonData;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.activity.springfestival.entry.model.RedPacketResultData;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.ReportInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SpringHbIPCModule
  extends QIPCModule
{
  public static SpringHbIPCModule a;
  
  public SpringHbIPCModule()
  {
    super("SpringHbIPCModule");
  }
  
  public static SpringHbIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new SpringHbIPCModule();
        }
      }
      finally {}
    }
    return a;
  }
  
  private static EIPCResult a(AppRuntime paramAppRuntime)
  {
    try
    {
      boolean bool;
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        bool = ((QQAppInterface)paramAppRuntime).isVideoChatting();
      }
      else
      {
        QLog.e("SpringHbIPCModule", 1, "doGetIsVideoChatting appRuntime is not QQAppInterface");
        bool = false;
      }
      paramAppRuntime = new Bundle();
      paramAppRuntime.putBoolean("isVideoChatting", bool);
      paramAppRuntime = EIPCResult.createSuccessResult(paramAppRuntime);
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      label50:
      break label50;
    }
    paramAppRuntime = new Bundle();
    paramAppRuntime.putBoolean("isVideoChatting", false);
    return EIPCResult.createSuccessResult(paramAppRuntime);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("action = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", params = ");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.d("SpringHbIPCModule", 2, ((StringBuilder)localObject1).toString());
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = null;
    Object localObject2 = null;
    if (localAppRuntime != null)
    {
      if (!(localAppRuntime instanceof QQAppInterface)) {
        return null;
      }
      if ("ReportData".equals(paramString))
      {
        paramString = (SpringHbReportManager.ReportInfo)paramBundle.getSerializable("key1");
        paramBundle = (SpringHbReportManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.SPRING_HB_REPORT_MANAGER);
        if (paramBundle != null)
        {
          paramBundle.a(paramString);
          return null;
        }
      }
      else
      {
        if ("GetDomain".equals(paramString)) {
          return null;
        }
        if ("GetEmergencyInfo".equals(paramString)) {
          return null;
        }
        if ("GetHtmlOffline".equals(paramString)) {
          return null;
        }
        if ("GetCfgInfo".equals(paramString))
        {
          paramString = (SpringFestivalRedpacketConfigManager)localAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER);
          if (paramString == null) {
            paramString = (String)localObject2;
          } else {
            paramString = paramString.a();
          }
          paramBundle = new EIPCResult();
          localObject1 = new Bundle();
          if (paramString != null)
          {
            ((Bundle)localObject1).putInt("task_id", paramString.taskId);
            ((Bundle)localObject1).putInt("cfg_version", paramString.version);
            ((Bundle)localObject1).putSerializable("cfg_data", paramString);
            paramBundle.data = ((Bundle)localObject1);
            return paramBundle;
          }
          paramBundle.data = ((Bundle)localObject1);
          paramBundle.code = -102;
          return paramBundle;
        }
        if ("GetPreloadFilePath".equals(paramString))
        {
          paramString = paramBundle.getString("url", "");
          paramBundle = (IPreloadRes)localAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          if (paramBundle == null) {
            paramString = (String)localObject1;
          } else {
            paramString = paramBundle.b(paramString);
          }
          paramBundle = new EIPCResult();
          localObject1 = new Bundle();
          if (!TextUtils.isEmpty(paramString))
          {
            ((Bundle)localObject1).putString("file_path", paramString);
            paramBundle.data = ((Bundle)localObject1);
            return paramBundle;
          }
          paramBundle.data = ((Bundle)localObject1);
          paramBundle.code = -102;
          return paramBundle;
        }
        if ("removeEntryLoadingAnimationView".equals(paramString))
        {
          QLog.i("SpringHbIPCModule", 1, "webview ACTION_REMOVE_ENTRY_LOADING_ANIMATION_VIEW");
          ThreadManager.getUIHandler().postDelayed(new SpringHbIPCModule.1(this), 1000L);
          return EIPCResult.createSuccessResult(new Bundle());
        }
        if ("GetActivityPref".equals(paramString))
        {
          localObject1 = (SpringFestivalEntryManager)localAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          paramString = new EIPCResult();
          paramBundle = new Bundle();
          if (((SpringFestivalEntryManager)localObject1).a() != null)
          {
            localObject1 = ((SpringFestivalEntryManager)localObject1).a().commonData.activityUrlPrefix;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("activityPrefix ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("SpringHbIPCModule onCall ACTION_GET_ACTIVITY_PREF_INFO ", 2, ((StringBuilder)localObject2).toString());
            }
            paramBundle.putString("activity_pref", (String)localObject1);
            paramString.data = paramBundle;
          }
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("result.data ");
            paramBundle.append(paramString.data);
            QLog.d("SpringHbIPCModule onCall ", 2, paramBundle.toString());
          }
          return paramString;
        }
        if ("GetServerTime".equals(paramString)) {
          return new EIPCResult();
        }
        if ("getIsVideoChatting".equals(paramString)) {
          return a(localAppRuntime);
        }
        if ("getAward".equals(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SpringHbIPCModule", 2, "onCall ACTION_GET_AWARD = getAward");
          }
          paramBundle = (SpringFestivalEntryManager)localAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          localObject1 = paramBundle.a();
          paramString = new EIPCResult();
          if (localObject1 != null)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("k_c_time", ((RedPacketResultData)localObject1).jdField_c_of_type_Int);
            ((Bundle)localObject2).putInt("key_mtime", ((RedPacketResultData)localObject1).jdField_f_of_type_Int);
            ((Bundle)localObject2).putInt("k_money", ((RedPacketResultData)localObject1).jdField_d_of_type_Int);
            ((Bundle)localObject2).putInt("key_award_type", ((RedPacketResultData)localObject1).jdField_b_of_type_Int);
            ((Bundle)localObject2).putInt("key_promotion_id", ((RedPacketResultData)localObject1).jdField_g_of_type_Int);
            ((Bundle)localObject2).putInt("key_business_id", ((RedPacketResultData)localObject1).jdField_e_of_type_Int);
            ((Bundle)localObject2).putInt("k_state", ((RedPacketResultData)localObject1).jdField_a_of_type_Int);
            ((Bundle)localObject2).putInt("cardStyle", paramBundle.a().commonData.cardStyle);
            ((Bundle)localObject2).putString("key_signature", ((RedPacketResultData)localObject1).jdField_b_of_type_JavaLangString);
            ((Bundle)localObject2).putString("key_req_id", ((RedPacketResultData)localObject1).jdField_f_of_type_JavaLangString);
            ((Bundle)localObject2).putString("k_pack_id", ((RedPacketResultData)localObject1).jdField_a_of_type_JavaLangString);
            ((Bundle)localObject2).putString("key_wishing", ((RedPacketResultData)localObject1).jdField_e_of_type_JavaLangString);
            ((Bundle)localObject2).putString("key_order", ((RedPacketResultData)localObject1).jdField_d_of_type_JavaLangString);
            ((Bundle)localObject2).putString("key_url", ((RedPacketResultData)localObject1).jdField_c_of_type_JavaLangString);
            ((Bundle)localObject2).putString("key_business_name", ((RedPacketResultData)localObject1).jdField_g_of_type_JavaLangString);
            ((Bundle)localObject2).putString("key_business_logo", ((RedPacketResultData)localObject1).h);
            ((Bundle)localObject2).putString("key_business_cover", ((RedPacketResultData)localObject1).j);
            ((Bundle)localObject2).putString("key_business_video", ((RedPacketResultData)localObject1).i);
            ((Bundle)localObject2).putString("key_business_video_cover", ((RedPacketResultData)localObject1).k);
            paramString.data = ((Bundle)localObject2);
          }
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("onCall result.data = ");
            paramBundle.append(paramString.data.toString());
            QLog.i("SpringHbIPCModule", 2, paramBundle.toString());
          }
          callbackResult(paramInt, paramString);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringHbIPCModule
 * JD-Core Version:    0.7.0.1
 */