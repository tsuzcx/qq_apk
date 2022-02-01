package com.tencent.av.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.ManageConfig.QAVConfig;
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
    while (i < k)
    {
      String str = paramString[i];
      try
      {
        arrayOfLong[j] = Long.parseLong(str);
      }
      catch (Throwable localThrowable)
      {
        QLog.i("ScoreManager", 1, "ipStrToLong", localThrowable);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.i("ScoreManager", 1, "ipStrToLong", localNumberFormatException);
      }
      j += 1;
      i += 1;
    }
    return (arrayOfLong[0] << 24) + (arrayOfLong[1] << 16) + (arrayOfLong[2] << 8) + arrayOfLong[3];
  }
  
  public static String a()
  {
    String str = QAVConfigUtils.a(270, QAVConfigUtils.b).getString("scoreInfos", null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getScoreInfos:");
      localStringBuilder.append(str);
      QLog.i("ScoreManager", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    b(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null)
    {
      AVLog.printColorLog("ScoreManager", "saveAVChatInfosForScore error ");
      return;
    }
    if (QAVConfig.a(270) == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveAVChatInfosForScore, 没有配置, infos[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.w("ScoreManager", 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = QAVConfigUtils.a(270, QAVConfigUtils.b).edit();
    ((SharedPreferences.Editor)localObject).putString("scoreInfos", paramString);
    ((SharedPreferences.Editor)localObject).commit();
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
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("submitDownloadTask. url = ");
      paramQQAppInterface.append(paramDownloadInfo.jdField_a_of_type_JavaLangString);
      QLog.i("ScoreManager", 1, paramQQAppInterface.toString());
    }
    return true;
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse config: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", curUin : ");
      ((StringBuilder)localObject).append(paramString2);
      AVLog.printColorLog("ScoreManager", ((StringBuilder)localObject).toString());
      paramString2 = SharedPreUtils.e(paramString2);
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString1);
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
        boolean bool = ((JSONObject)localObject).has("scoreIconUrl");
        paramString2 = "";
        if (!bool) {
          break label434;
        }
        paramString1 = ((JSONObject)localObject).getString("scoreIconUrl");
        if (((JSONObject)localObject).has("scoreIconMd5")) {
          paramString2 = ((JSONObject)localObject).getString("scoreIconMd5");
        }
        if ((paramString1 == null) || (paramString1.isEmpty())) {
          break label433;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ScoreManager", 2, "parse|down load icons!");
        }
        localObject = new ScoreManager.DownloadInfo();
        ((ScoreManager.DownloadInfo)localObject).jdField_a_of_type_JavaLangString = paramString1;
        paramString1 = new StringBuilder();
        paramString1.append(ImageResUtil.a());
        paramString1.append(((ScoreManager.DownloadInfo)localObject).jdField_a_of_type_JavaLangString.substring(((ScoreManager.DownloadInfo)localObject).jdField_a_of_type_JavaLangString.lastIndexOf(".")));
        ((ScoreManager.DownloadInfo)localObject).c = paramString1.toString();
        ((ScoreManager.DownloadInfo)localObject).b = paramString2;
        a(paramQQAppInterface, (ScoreManager.DownloadInfo)localObject);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramString1 = new StringBuilder();
        paramString1.append("parse exception: ");
        paramString1.append(paramQQAppInterface.toString());
        AVLog.printColorLog("ScoreManager", paramString1.toString());
        if (!QLog.isColorLevel()) {
          break label433;
        }
      }
      paramString1 = new StringBuilder();
      paramString1.append("parse exception: ");
      paramString1.append(paramQQAppInterface.toString());
      QLog.i("ScoreManager", 2, paramString1.toString());
      return;
      AVLog.printColorLog("ScoreManager", "parse|config is empty!");
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 2, "parse|config is empty!");
      }
      label433:
      return;
      label434:
      paramString1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.ScoreManager
 * JD-Core Version:    0.7.0.1
 */