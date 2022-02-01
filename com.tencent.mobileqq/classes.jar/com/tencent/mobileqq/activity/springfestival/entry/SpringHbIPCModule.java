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
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new SpringHbIPCModule();
      }
      return a;
    }
    finally {}
  }
  
  private static EIPCResult a(AppRuntime paramAppRuntime)
  {
    try
    {
      if ((paramAppRuntime instanceof QQAppInterface)) {}
      for (boolean bool = ((QQAppInterface)paramAppRuntime).isVideoChatting();; bool = false)
      {
        paramAppRuntime = new Bundle();
        paramAppRuntime.putBoolean("isVideoChatting", bool);
        return EIPCResult.createSuccessResult(paramAppRuntime);
        QLog.e("SpringHbIPCModule", 1, "doGetIsVideoChatting appRuntime is not QQAppInterface");
      }
      return EIPCResult.createSuccessResult(paramAppRuntime);
    }
    catch (Exception paramAppRuntime)
    {
      paramAppRuntime = new Bundle();
      paramAppRuntime.putBoolean("isVideoChatting", false);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject2 = null;
    Bundle localBundle = null;
    if (QLog.isColorLevel()) {
      QLog.d("SpringHbIPCModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = localBundle;
    if (localAppRuntime != null)
    {
      if ((localAppRuntime instanceof QQAppInterface)) {
        break label78;
      }
      localObject1 = localBundle;
    }
    label78:
    label362:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return localObject1;
                if (!"ReportData".equals(paramString)) {
                  break;
                }
                paramString = (SpringHbReportManager.ReportInfo)paramBundle.getSerializable("key1");
                paramBundle = (SpringHbReportManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.SPRING_HB_REPORT_MANAGER);
                localObject1 = localBundle;
              } while (paramBundle == null);
              paramBundle.a(paramString);
              return null;
              localObject1 = localBundle;
            } while ("GetDomain".equals(paramString));
            localObject1 = localBundle;
          } while ("GetEmergencyInfo".equals(paramString));
          localObject1 = localBundle;
        } while ("GetHtmlOffline".equals(paramString));
        if ("GetCfgInfo".equals(paramString))
        {
          paramString = (SpringFestivalRedpacketConfigManager)localAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER);
          if (paramString == null) {}
          for (paramString = null;; paramString = paramString.a())
          {
            paramBundle = new EIPCResult();
            localObject1 = new Bundle();
            if (paramString == null) {
              break;
            }
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
          if (paramBundle == null)
          {
            paramString = localObject2;
            paramBundle = new EIPCResult();
            localObject1 = new Bundle();
            if (TextUtils.isEmpty(paramString)) {
              break label362;
            }
            ((Bundle)localObject1).putString("file_path", paramString);
            paramBundle.data = ((Bundle)localObject1);
          }
          for (;;)
          {
            return paramBundle;
            paramString = paramBundle.b(paramString);
            break;
            paramBundle.data = ((Bundle)localObject1);
            paramBundle.code = -102;
          }
        }
        if ("removeEntryLoadingAnimationView".equals(paramString))
        {
          QLog.i("SpringHbIPCModule", 1, "webview ACTION_REMOVE_ENTRY_LOADING_ANIMATION_VIEW");
          ThreadManager.getUIHandler().postDelayed(new SpringHbIPCModule.1(this), 1000L);
          return EIPCResult.createSuccessResult(new Bundle());
        }
        if (!"GetActivityPref".equals(paramString)) {
          break;
        }
        localObject1 = (SpringFestivalEntryManager)localAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        paramString = new EIPCResult();
        paramBundle = new Bundle();
        if (((SpringFestivalEntryManager)localObject1).a() != null)
        {
          localObject1 = ((SpringFestivalEntryManager)localObject1).a().commonData.activityUrlPrefix;
          if (QLog.isColorLevel()) {
            QLog.d("SpringHbIPCModule onCall ACTION_GET_ACTIVITY_PREF_INFO ", 2, "activityPrefix " + (String)localObject1);
          }
          paramBundle.putString("activity_pref", (String)localObject1);
          paramString.data = paramBundle;
        }
        localObject1 = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("SpringHbIPCModule onCall ", 2, "result.data " + paramString.data);
      return paramString;
      if ("GetServerTime".equals(paramString)) {
        return new EIPCResult();
      }
      if ("getIsVideoChatting".equals(paramString)) {
        return a(localAppRuntime);
      }
      localObject1 = localBundle;
    } while (!"getAward".equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.i("SpringHbIPCModule", 2, "onCall ACTION_GET_AWARD = getAward");
    }
    paramString = (SpringFestivalEntryManager)localAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    paramBundle = paramString.a();
    localObject1 = new EIPCResult();
    if (paramBundle != null)
    {
      localBundle = new Bundle();
      localBundle.putInt("k_c_time", paramBundle.jdField_c_of_type_Int);
      localBundle.putInt("key_mtime", paramBundle.jdField_f_of_type_Int);
      localBundle.putInt("k_money", paramBundle.jdField_d_of_type_Int);
      localBundle.putInt("key_award_type", paramBundle.jdField_b_of_type_Int);
      localBundle.putInt("key_promotion_id", paramBundle.jdField_g_of_type_Int);
      localBundle.putInt("key_business_id", paramBundle.jdField_e_of_type_Int);
      localBundle.putInt("k_state", paramBundle.jdField_a_of_type_Int);
      localBundle.putInt("cardStyle", paramString.a().commonData.cardStyle);
      localBundle.putString("key_signature", paramBundle.jdField_b_of_type_JavaLangString);
      localBundle.putString("key_req_id", paramBundle.jdField_f_of_type_JavaLangString);
      localBundle.putString("k_pack_id", paramBundle.jdField_a_of_type_JavaLangString);
      localBundle.putString("key_wishing", paramBundle.jdField_e_of_type_JavaLangString);
      localBundle.putString("key_order", paramBundle.jdField_d_of_type_JavaLangString);
      localBundle.putString("key_url", paramBundle.jdField_c_of_type_JavaLangString);
      localBundle.putString("key_business_name", paramBundle.jdField_g_of_type_JavaLangString);
      localBundle.putString("key_business_logo", paramBundle.h);
      localBundle.putString("key_business_cover", paramBundle.j);
      localBundle.putString("key_business_video", paramBundle.i);
      localBundle.putString("key_business_video_cover", paramBundle.k);
      ((EIPCResult)localObject1).data = localBundle;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SpringHbIPCModule", 2, "onCall result.data = " + ((EIPCResult)localObject1).data.toString());
    }
    callbackResult(paramInt, (EIPCResult)localObject1);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringHbIPCModule
 * JD-Core Version:    0.7.0.1
 */