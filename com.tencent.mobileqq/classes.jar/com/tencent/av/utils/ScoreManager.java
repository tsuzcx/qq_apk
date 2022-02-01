package com.tencent.av.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ScoreManager
{
  public static long a(String paramString)
  {
    long[] arrayOfLong = new long[4];
    paramString = paramString.split("\\.");
    int k = paramString.length;
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < k)
      {
        String str = paramString[i];
        try
        {
          arrayOfLong[j] = Long.parseLong(str);
          j += 1;
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            QLog.i("ScoreManager", 1, "ipStrToLong", localNumberFormatException);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.i("ScoreManager", 1, "ipStrToLong", localThrowable);
          }
        }
      }
    }
    return (arrayOfLong[0] << 24) + (arrayOfLong[1] << 16) + (arrayOfLong[2] << 8) + arrayOfLong[3];
  }
  
  public static String a()
  {
    String str = EffectConfigBase.a(270, EffectConfigBase.c).getString("scoreInfos", null);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 2, "getScoreInfos:" + str);
    }
    return str;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    b(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      AVLog.printColorLog("ScoreManager", "saveAVChatInfosForScore error ");
    }
    do
    {
      return;
      if (QAVConfig.a(270) != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ScoreManager", 1, "saveAVChatInfosForScore, 没有配置, infos[" + paramString + "]");
    return;
    SharedPreferences.Editor localEditor = EffectConfigBase.a(270, EffectConfigBase.c).edit();
    localEditor.putString("scoreInfos", paramString);
    localEditor.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ScoreManager.DownloadInfo paramDownloadInfo)
  {
    paramQQAppInterface = (IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 2, "requestToDownload");
    }
    if (paramDownloadInfo == null) {
      return false;
    }
    ScoreManager.1 local1 = new ScoreManager.1(paramDownloadInfo);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = local1;
    localHttpNetReq.mReqUrl = paramDownloadInfo.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramDownloadInfo.c;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mSupportBreakResume = true;
    paramQQAppInterface.sendReq(localHttpNetReq);
    paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 1, "submitDownloadTask. url = " + paramDownloadInfo.jdField_a_of_type_JavaLangString);
    }
    return true;
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      AVLog.printColorLog("ScoreManager", "parse config: " + paramString1 + ", curUin : " + paramString2);
      paramString2 = SharedPreUtils.e(paramString2);
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString1);
        int i;
        if (((JSONObject)localObject).has("scoreSwitch"))
        {
          i = ((JSONObject)localObject).getInt("scoreSwitch");
          paramString2.edit().putInt("qav_score_switch", i).commit();
        }
        if (((JSONObject)localObject).has("scoreTime"))
        {
          i = ((JSONObject)localObject).getInt("scoreTime");
          paramString2.edit().putInt("qav_score_time", i).commit();
        }
        if (((JSONObject)localObject).has("scoreRate"))
        {
          i = ((JSONObject)localObject).getInt("scoreRate");
          paramString2.edit().putInt("qav_score_rate", i).commit();
        }
        if (!((JSONObject)localObject).has("scoreIconUrl")) {
          break label393;
        }
        paramString1 = ((JSONObject)localObject).getString("scoreIconUrl");
        paramString2 = "";
        if (((JSONObject)localObject).has("scoreIconMd5")) {
          paramString2 = ((JSONObject)localObject).getString("scoreIconMd5");
        }
        if ((paramString1 != null) && (!paramString1.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ScoreManager", 2, "parse|down load icons!");
          }
          localObject = new ScoreManager.DownloadInfo();
          ((ScoreManager.DownloadInfo)localObject).jdField_a_of_type_JavaLangString = paramString1;
          ((ScoreManager.DownloadInfo)localObject).c = (ImageResUtil.b() + ((ScoreManager.DownloadInfo)localObject).jdField_a_of_type_JavaLangString.substring(((ScoreManager.DownloadInfo)localObject).jdField_a_of_type_JavaLangString.lastIndexOf(".")));
          ((ScoreManager.DownloadInfo)localObject).b = paramString2;
          a(paramQQAppInterface, (ScoreManager.DownloadInfo)localObject);
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        AVLog.printColorLog("ScoreManager", "parse exception: " + paramQQAppInterface.toString());
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ScoreManager", 2, "parse exception: " + paramQQAppInterface.toString());
        return;
      }
      AVLog.printColorLog("ScoreManager", "parse|config is empty!");
      if (QLog.isColorLevel())
      {
        QLog.i("ScoreManager", 2, "parse|config is empty!");
        return;
        label393:
        paramString1 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.ScoreManager
 * JD-Core Version:    0.7.0.1
 */