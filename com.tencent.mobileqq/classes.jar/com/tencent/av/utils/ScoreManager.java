package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import khe;
import khf;
import khg;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ScoreManager
{
  protected static INetEngine.IBreakDownFix a;
  protected static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "qav" + File.separator;
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new khg();
  }
  
  public static long a(String paramString)
  {
    long[] arrayOfLong = new long[4];
    paramString = paramString.split("\\.");
    int k = paramString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      arrayOfLong[j] = Long.parseLong(paramString[i]);
      j += 1;
      i += 1;
    }
    return (arrayOfLong[0] << 24) + (arrayOfLong[1] << 16) + (arrayOfLong[2] << 8) + arrayOfLong[3];
  }
  
  protected static String a(int paramInt)
  {
    return jdField_a_of_type_JavaLangString + String.valueOf(paramInt) + File.separator;
  }
  
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      File localFile = new File(a(paramInt) + "scoreconfig.xml");
      localObject1 = localObject2;
      AVLog.c("ScoreManager", "getScoreConfig:" + localFile.getPath() + "|" + localFile.exists());
      localObject1 = localObject2;
      if (localFile.exists())
      {
        localObject1 = localObject2;
        paramContext = FileUtils.b(localFile);
        localObject1 = paramContext;
        AVLog.c("ScoreManager", "getScoreConfig:" + paramContext);
        return paramContext;
      }
      localObject1 = localObject2;
      SharedPreUtils.o(paramContext, 0, paramString);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      AVLog.c("ScoreManager", "getScoreConfig exception:" + paramContext.toString());
    }
    return localObject1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramString1 == null)
    {
      AVLog.c("ScoreManager", "updateVideoConfig error ");
      return;
    }
    String str = a(paramInt2);
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.isFile())) {
      FileUtils.d(str);
    }
    a(paramString1, str, "scoreconfig.xml");
    a(paramQQAppInterface, paramString1, paramString2);
    SharedPreUtils.o(paramQQAppInterface.getApplication(), paramInt1, paramString2);
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      AVLog.c("ScoreManager", "parse config: " + paramString1 + ", curUin : " + paramString2);
      paramString2 = SharedPreUtils.f(paramString2);
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
        AVLog.c("ScoreManager", "parse exception: " + paramQQAppInterface.toString());
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ScoreManager", 2, "parse exception: " + paramQQAppInterface.toString());
        return;
      }
      AVLog.c("ScoreManager", "parse|config is empty!");
      if (QLog.isColorLevel())
      {
        QLog.i("ScoreManager", 2, "parse|config is empty!");
        return;
        label393:
        paramString1 = "";
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      AVLog.c("ScoreManager", "saveAVChatInfosForScore error ");
    }
    String str;
    File localFile;
    do
    {
      return;
      str = a(270);
      localFile = new File(str);
    } while ((!localFile.exists()) || (localFile.isFile()));
    a(paramString, str, "scoreInfos.xml");
  }
  
  static void a(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.getFileThreadHandler().post(new khe(paramString2, paramString3, paramString1));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ScoreManager.DownloadInfo paramDownloadInfo)
  {
    paramQQAppInterface = paramQQAppInterface.getNetEngine(0);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 2, "requestToDownload");
    }
    if (paramDownloadInfo == null) {
      return false;
    }
    khf localkhf = new khf(paramDownloadInfo);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = localkhf;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.c = paramDownloadInfo.c;
    localHttpNetReq.e = 1;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    paramQQAppInterface.a(localHttpNetReq);
    paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 1, "submitDownloadTask. url = " + paramDownloadInfo.jdField_a_of_type_JavaLangString);
    }
    return true;
  }
  
  public static String b(Context paramContext, int paramInt, String paramString)
  {
    paramString = null;
    String str = null;
    paramContext = str;
    try
    {
      File localFile = new File(a(paramInt) + "scoreInfos.xml");
      paramContext = str;
      AVLog.c("ScoreManager", "getScoreInfos:" + localFile.getPath() + "|" + localFile.exists());
      paramContext = str;
      if (localFile.exists())
      {
        paramContext = str;
        str = FileUtils.b(localFile);
        paramContext = str;
        AVLog.c("ScoreManager", "getScoreInfos:" + str);
        paramContext = str;
        paramString = str;
        if (QLog.isColorLevel())
        {
          paramContext = str;
          QLog.i("ScoreManager", 2, "getScoreInfos:" + str);
          return str;
        }
      }
      else
      {
        paramContext = str;
        AVLog.c("ScoreManager", "getScoreInfos: not exist!");
        paramContext = str;
        if (QLog.isColorLevel())
        {
          paramContext = str;
          QLog.i("ScoreManager", 2, "getScoreInfos: not exist!");
          return null;
        }
      }
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      AVLog.c("ScoreManager", "getScoreInfos exception:" + paramString.toString());
      paramString = paramContext;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.ScoreManager
 * JD-Core Version:    0.7.0.1
 */