package com.tencent.avgame.gamelogic.gameres;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class AvGameResPreloadManager
{
  public static AvGameResPreloadManager.ConfInfo a()
  {
    CJPreloadConfBean localCJPreloadConfBean = CJPreloadConfProcessor.a();
    if (localCJPreloadConfBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameResPreloadManager", 2, "getConfInfo SpringFestivalRedpacketPreloadConfProcessor.loadConfig null");
      }
      return new AvGameResPreloadManager.ConfInfo();
    }
    return localCJPreloadConfBean.a();
  }
  
  public static AvGameResPreloadManager.PathInfo a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4);
    AvGameResPreloadManager.PathInfo localPathInfo = new AvGameResPreloadManager.PathInfo();
    localPathInfo.b = localSharedPreferences.getString("preloadVoiceRecogSoPath", "");
    localPathInfo.c = localSharedPreferences.getString("preloadVoiceRecogModelPath", "");
    localPathInfo.d = localSharedPreferences.getString("preloadVoiceRecogAILabSoPath", "");
    localPathInfo.e = localSharedPreferences.getString("preloadVoiceRecogAILabModelPath", "");
    return localPathInfo;
  }
  
  public static AvGameResPreloadManager.PathInfo a(QQAppInterface paramQQAppInterface)
  {
    AvGameResPreloadManager.PathInfo localPathInfo = new AvGameResPreloadManager.PathInfo();
    localPathInfo.a = a(paramQQAppInterface, "res1009Android");
    localPathInfo.b = a(paramQQAppInterface, "AVGameVoiceRecogSo", "libwxvoiceembed.so");
    localPathInfo.c = a(paramQQAppInterface, "AVGameVoiceRecogModel", "libwxvoiceembedlvcsr.bin");
    localPathInfo.d = a(paramQQAppInterface, "AVGameVoiceRecogAILabSo", "libAILibCkws.so");
    localPathInfo.e = a(paramQQAppInterface, "AVGameVoiceRecogAILabModel", "model_fixed_noprior.bin");
    return localPathInfo;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (IPreloadService)paramQQAppInterface.getRuntimeService(IPreloadService.class, "");
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameResPreloadManager", 2, "getResFolderPath preloadManager null");
      }
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.getUnzipFolderPathByResId(paramString);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameResPreloadManager", 2, "getResFolderPath unzipFolderName null with resId:" + paramString);
      }
      return "";
    }
    return paramQQAppInterface + File.separator;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramString1);
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      paramString1 = paramQQAppInterface + paramString2;
      paramQQAppInterface = paramString1;
    } while (new File(paramString1).exists());
    if (QLog.isColorLevel()) {
      QLog.e("AvGameResPreloadManager", 2, "getResFilePath filePath not exist:" + paramString1);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str1 = paramString1.substring(0, paramString1.lastIndexOf(File.separator));
    String str2 = paramString1.substring(paramString1.lastIndexOf(File.separator) + 1);
    paramString4 = paramString4 + paramString2;
    paramString2 = paramString4 + File.separator + str2;
    String str3 = FileUtils.c(paramString1);
    if ((str3 == null) || (!str3.equalsIgnoreCase(paramString3)))
    {
      QLog.w("AvGameResPreloadManager", 1, "copyResFile. fails to check srcResPath:" + paramString1 + ", md5:" + paramString3 + ", as not equals calculated: " + str3);
      paramString1 = "";
    }
    boolean bool;
    label448:
    do
    {
      return paramString1;
      if (FileUtils.a(paramString2))
      {
        QLog.d("AvGameResPreloadManager", 1, "copyPreload. file already exists: " + paramString2);
        bool = a(str1, paramString4);
        paramString1 = FileUtils.c(paramString2);
        if ((bool) || (paramString1 == null) || (!paramString1.equalsIgnoreCase(paramString3))) {
          QLog.w("AvGameResPreloadManager", 1, "copyResFile. file already exists but root filesDiff or md5 not equals, so delete: " + paramString2 + ", filesDiff:" + bool);
        }
      }
      else
      {
        paramString1 = paramString4 + "_temp";
        new StringBuilder().append(paramString1).append(File.separator).append(str2).toString();
        FileUtils.a(paramString4);
        FileUtils.a(paramString1);
        QLog.d("AvGameResPreloadManager", 1, "copyResFile. copy from " + str1 + " to " + paramString1);
        if (FileUtils.a(str1, paramString1 + File.separator, false) != 0) {
          QLog.e("AvGameResPreloadManager", 1, "copyResFile. FileUtils.copyDirectory fails from " + str1 + " to " + paramString1);
        }
        if (FileUtils.c(paramString1, paramString4)) {
          break label448;
        }
        QLog.e("AvGameResPreloadManager", 1, "copyResFile. fails to rename: " + paramString1 + " to " + paramString4);
        return "";
      }
      QLog.d("AvGameResPreloadManager", 1, "copyPreload. file already exists and everything ok");
      return paramString2;
      bool = a(str1, paramString4);
      paramString4 = FileUtils.c(paramString2);
      if ((bool) || (paramString4 == null)) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString4.equalsIgnoreCase(paramString3));
    QLog.w("AvGameResPreloadManager", 1, "copyResFile. fails to check final copied dstResFilePath md5 as not equals or filesDiff: " + paramString2 + ", filesDiff:" + bool);
    return "";
  }
  
  private static ArrayList<String> a(String paramString)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramString.add(localObject[i].getName());
      i += 1;
    }
    return paramString;
  }
  
  public static void a(AvGameResPreloadManager.ConfInfo paramConfInfo)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4);
    localSharedPreferences.edit().putString("preloadVoiceRecogSoMD5", paramConfInfo.d).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogSoFileMD5", paramConfInfo.e).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogModelMD5", paramConfInfo.g).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogModelFileMD5", paramConfInfo.h).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogAILabSoMD5", paramConfInfo.j).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogAILabSoFileMD5", paramConfInfo.k).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogAILabModelMD5", paramConfInfo.m).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogAILabModelFileMD5", paramConfInfo.n).commit();
  }
  
  public static void a(AvGameResPreloadManager.PathInfo paramPathInfo)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4);
    localSharedPreferences.edit().putString("resPath", paramPathInfo.a).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogSoPath", paramPathInfo.b).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogModelPath", paramPathInfo.c).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogAILabSoPath", paramPathInfo.d).commit();
    localSharedPreferences.edit().putString("preloadVoiceRecogAILabModelPath", paramPathInfo.e).commit();
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    QLog.d("AvGameResPreloadManager", 1, "dirCompare. srcFiles: " + paramString1 + ", dstFiles:" + paramString2);
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext()) {
      if (!paramString2.contains((String)paramString1.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static AvGameResPreloadManager.ConfInfo b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4);
    AvGameResPreloadManager.ConfInfo localConfInfo = new AvGameResPreloadManager.ConfInfo();
    localConfInfo.d = localSharedPreferences.getString("preloadVoiceRecogSoMD5", "");
    localConfInfo.e = localSharedPreferences.getString("preloadVoiceRecogSoFileMD5", "");
    localConfInfo.g = localSharedPreferences.getString("preloadVoiceRecogModelMD5", "");
    localConfInfo.h = localSharedPreferences.getString("preloadVoiceRecogModelFileMD5", "");
    localConfInfo.j = localSharedPreferences.getString("preloadVoiceRecogAILabSoMD5", "");
    localConfInfo.k = localSharedPreferences.getString("preloadVoiceRecogAILabSoFileMD5", "");
    localConfInfo.m = localSharedPreferences.getString("preloadVoiceRecogAILabModelMD5", "");
    localConfInfo.n = localSharedPreferences.getString("preloadVoiceRecogAILabModelFileMD5", "");
    return localConfInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameResPreloadManager
 * JD-Core Version:    0.7.0.1
 */