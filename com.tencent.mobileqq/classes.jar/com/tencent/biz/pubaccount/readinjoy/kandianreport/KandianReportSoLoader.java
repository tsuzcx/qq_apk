package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import awrn;
import bace;
import bgmq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import mol;
import mpr;
import mqq.app.AppRuntime;
import ndn;
import obz;
import org.json.JSONArray;
import org.json.JSONObject;

public class KandianReportSoLoader
{
  private static final String KANDIANREPORT_SO_OFFLINE_BID = "3454";
  private static final String QQ_REINSTALL_FLAG = "qq_is_reinstall";
  private static String SO_DOWNLOAD_DIR;
  private static final String SO_FILE_COPY_STATE = "kd_fc_so_copy";
  private static final String SO_FILE_DOWNLOAD_STATE = "kd_fc_so_download";
  private static String SO_LOAD_DIR;
  private static final int SUPPORT_SO_VERSION = 1;
  private static final String TAG = "kandianreport.KandianReportSoLoader";
  private static String configDownloadPath;
  private static String configLoadPath;
  private static boolean isSoFileLoad;
  private static int soVersion = -1;
  
  static
  {
    try
    {
      SO_DOWNLOAD_DIR = mol.a("3454") + "3454";
      SO_LOAD_DIR = BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/txlib/kandianreport";
      configDownloadPath = SO_DOWNLOAD_DIR + "/so_config.json";
      configLoadPath = SO_LOAD_DIR + "/so_config.json";
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.KandianReportSoLoader", 2, localThrowable.getLocalizedMessage());
    }
  }
  
  public static boolean checkSoFileIsReady()
  {
    boolean bool2 = ((Boolean)bgmq.a("kd_fc_so_copy", Boolean.valueOf(false))).booleanValue();
    boolean bool1 = new File(configLoadPath).exists();
    boolean bool3 = ((Boolean)bgmq.a("kd_fc_so_download", Boolean.valueOf(false))).booleanValue();
    boolean bool4 = new File(configDownloadPath).exists();
    QLog.d("kandianreport.KandianReportSoLoader", 1, "copy flag: " + bool2);
    QLog.d("kandianreport.KandianReportSoLoader", 1, "actual copy state: " + bool1);
    QLog.d("kandianreport.KandianReportSoLoader", 1, "download flag: " + bool3);
    QLog.d("kandianreport.KandianReportSoLoader", 1, "actual download state: " + bool4);
    if (bool2 != bool1) {
      TaskException.reportException("copy state is wrong " + bool2);
    }
    if (bool3 != bool4) {
      TaskException.reportException("download state is wrong " + bool3);
    }
    if (bool4) {}
    do
    {
      try
      {
        if (!mpr.a(SO_DOWNLOAD_DIR, "3454"))
        {
          logAndReport("checkSoFileIsReady: verification failed");
          bool2 = false;
          return bool2;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("kandianreport.KandianReportSoLoader", 1, localThrowable, new Object[0]);
        return false;
      }
      if ((!bool1) && (bool4))
      {
        QLog.d("kandianreport.KandianReportSoLoader", 1, "download success but not copy");
        bool1 = copySoFromSdcardToData();
        QLog.d("kandianreport.KandianReportSoLoader", 1, "copy result: " + bool1);
        if (!mpr.a(SO_DOWNLOAD_DIR, "3454"))
        {
          logAndReport("checkSoFileIsReady: verification failed");
          return false;
        }
      }
      bool2 = bool1;
    } while (!bool1);
    return verifySoFiles();
  }
  
  private static boolean copyFile(String paramString1, String paramString2)
  {
    boolean bool1 = bace.d(paramString1, paramString2);
    boolean bool2;
    if (!bool1)
    {
      logAndReport("copy file result false " + paramString1);
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = copyFilePrivate(paramString1, paramString2);
        if (bool2) {
          break label163;
        }
        logAndReport("double copy file result false fail " + paramString1);
      }
    }
    for (;;)
    {
      QLog.d("kandianreport.KandianReportSoLoader", 1, "copy file final result" + bool2);
      return bool2;
      if (!new File(paramString2).exists())
      {
        logAndReport("copy file result true but still not found " + paramString1);
        bool1 = false;
        break;
      }
      logAndReport("copy file result success and found " + paramString1);
      break;
      label163:
      if (!new File(paramString2).exists())
      {
        logAndReport("double copy file result true but still not found " + paramString1);
        bool2 = false;
      }
    }
  }
  
  private static boolean copyFilePrivate(String paramString1, String paramString2)
  {
    try
    {
      File localFile = new File(paramString1);
      Object localObject = new File(paramString2);
      if (!localFile.exists())
      {
        QLog.d("kandianreport.KandianReportSoLoader", 1, "copy file result false not found " + paramString1);
        return false;
      }
      paramString1 = (String)localObject;
      if (!((File)localObject).exists()) {
        paramString1 = bace.a(paramString2);
      }
      if (localFile.getAbsolutePath().toString().equals(paramString1.getAbsolutePath().toString())) {
        return true;
      }
      paramString2 = new FileInputStream(localFile);
      paramString1 = new FileOutputStream(paramString1);
      localObject = new byte[1024];
      for (;;)
      {
        int i = paramString2.read((byte[])localObject);
        if (i <= 0) {
          break;
        }
        paramString1.write((byte[])localObject, 0, i);
      }
      paramString2.close();
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    paramString1.close();
    return true;
  }
  
  private static boolean copySoFromSdcardToData()
  {
    for (;;)
    {
      try
      {
        bgmq.a("kd_fc_so_copy", Boolean.valueOf(false));
        JSONArray localJSONArray = (JSONArray)new JSONObject(TaskOfflineUtils.readInputStreamAsString(new FileInputStream(configDownloadPath))).get("so_name");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          QLog.d("kandianreport.KandianReportSoLoader", 1, "so config copy " + localJSONArray.toString());
          if (!copyFile(configDownloadPath, configLoadPath))
          {
            QLog.d("kandianreport.KandianReportSoLoader", 1, "so config copy fail");
            bool = false;
            return bool;
          }
          String str1 = mpr.a(configDownloadPath);
          String str2 = mpr.a(configLoadPath);
          logAndReport("so config copy success: " + str1 + " " + str2);
          if (str1 != null)
          {
            if (str1.equals(str2)) {
              break label380;
            }
            break label375;
            if (i < localJSONArray.length())
            {
              str2 = localJSONArray.getString(i);
              String str3 = SO_DOWNLOAD_DIR + "/" + str2;
              str1 = SO_LOAD_DIR + "/" + str2;
              if (!copyFile(str3, str1))
              {
                QLog.d("kandianreport.KandianReportSoLoader", 1, "jscjni copy fail " + str2);
                bool = false;
                continue;
              }
              str2 = mpr.a(str3);
              str1 = mpr.a(str1);
              logAndReport("so copy success: " + str2 + " " + str1);
              if (str2 == null) {
                break label385;
              }
              if (str2.equals(str1)) {
                break label390;
              }
              break label385;
            }
            bgmq.a("kd_fc_so_copy", Boolean.valueOf(true));
            bool = true;
            continue;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        bool = false;
      }
      finally {}
      label375:
      continue;
      label380:
      int i = 0;
      continue;
      label385:
      boolean bool = false;
      continue;
      label390:
      i += 1;
    }
  }
  
  public static void downLoadSoFiles()
  {
    downLoadSoFiles(null);
  }
  
  public static void downLoadSoFiles(Runnable paramRunnable)
  {
    if (((Boolean)bgmq.a("qq_is_reinstall", Boolean.valueOf(true))).booleanValue()) {
      bgmq.a("qq_is_reinstall", Boolean.valueOf(false));
    }
    try
    {
      if (new File(configDownloadPath).exists()) {
        bgmq.a("kd_fc_so_download", Boolean.valueOf(true));
      }
      QLog.d("kandianreport.KandianReportSoLoader", 1, "download so files now");
      TaskOfflineUtils.checkUpdate("3454", 1, new KandianReportSoLoader.1(paramRunnable));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("kandianreport.KandianReportSoLoader", 1, "check local offline file fail!");
        localException.printStackTrace();
      }
    }
  }
  
  public static String getSoLoadDir()
  {
    return SO_LOAD_DIR;
  }
  
  public static int getSoVersion()
  {
    return soVersion;
  }
  
  public static boolean isSoFileDownload()
  {
    return new File(configDownloadPath).exists();
  }
  
  public static boolean isSoFiledLoad()
  {
    return isSoFileLoad;
  }
  
  public static void loadSoFiles()
  {
    try
    {
      loadSoFiles(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void loadSoFiles(Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        if (!isSoFiledLoad()) {
          continue;
        }
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
      catch (Throwable paramRunnable)
      {
        QLog.d("kandianreport.KandianReportSoLoader", 1, "load so files fail " + paramRunnable.getMessage());
        TaskException.reportSOException("load so files fail " + paramRunnable.getMessage());
        bace.a(SO_DOWNLOAD_DIR);
        continue;
      }
      finally {}
      return;
      if (!checkSoFileIsReady())
      {
        QLog.d("kandianreport.KandianReportSoLoader", 1, "so not ready");
        bace.a(SO_DOWNLOAD_DIR);
      }
      else
      {
        QLog.d("kandianreport.KandianReportSoLoader", 1, "so ready, now load so");
        boolean bool = new File(configDownloadPath).exists();
        logAndReport("config find result " + bool);
        if (!bool)
        {
          QLog.d("kandianreport.KandianReportSoLoader", 1, "configDownloadPath not exists");
          bace.a(SO_DOWNLOAD_DIR);
        }
        else
        {
          JSONArray localJSONArray = (JSONArray)new JSONObject(TaskOfflineUtils.readInputStreamAsString(new FileInputStream(configDownloadPath))).get("so_name");
          if (localJSONArray != null)
          {
            int i = localJSONArray.length();
            if (i > 0) {
              try
              {
                System.loadLibrary("c++_shared");
                i = 0;
                for (;;)
                {
                  if (i >= localJSONArray.length()) {
                    break label487;
                  }
                  String str1 = localJSONArray.getString(i);
                  String str2 = SO_LOAD_DIR + "/" + str1;
                  if (!bace.a(str2))
                  {
                    if (copyFile(SO_DOWNLOAD_DIR + "/" + str1, str2)) {
                      break;
                    }
                    QLog.d("kandianreport.KandianReportSoLoader", 1, "load so copy fail " + str1);
                    bace.a(SO_DOWNLOAD_DIR);
                  }
                  System.load(str2);
                  QLog.d("kandianreport.KandianReportSoLoader", 1, "load so success " + str2);
                  i += 1;
                }
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  QLog.d("kandianreport.KandianReportSoLoader", 1, "load c++_shared fail " + localThrowable.getMessage());
                  TaskException.reportSOException("load c++_shared fail " + localThrowable.getMessage());
                  continue;
                  QLog.d("kandianreport.KandianReportSoLoader", 1, "load so copy success " + localThrowable);
                }
                label487:
                isSoFileLoad = true;
                ndn.a(null, "", "0X80099E1", "0X80099E1", 0, 0, "", "", "", "load so success", false);
              }
            }
          }
          soVersion = TaskOfflineUtils.checkOffLineConfig("3454", 1).version;
          logAndReport("so load success");
          if (paramRunnable != null) {
            paramRunnable.run();
          }
        }
      }
    }
  }
  
  public static void logAndReport(String paramString)
  {
    if (TaskManager.isConfigureOn)
    {
      QLog.d("kandianreport.KandianReportSoLoader", 1, paramString);
      HashMap localHashMap = new HashMap();
      AppRuntime localAppRuntime = obz.a();
      if (localAppRuntime != null) {
        localHashMap.put("uin", localAppRuntime.getAccount());
      }
      localHashMap.put("log", paramString);
      awrn.a(BaseApplicationImpl.getContext()).a(null, "kandianreportdataframe", true, 1L, 0L, localHashMap, null);
      TaskException.reportException(paramString);
    }
  }
  
  private static boolean verifySoFiles()
  {
    if (!new File(configDownloadPath).exists()) {
      return false;
    }
    try
    {
      JSONArray localJSONArray = (JSONArray)new JSONObject(TaskOfflineUtils.readInputStreamAsString(new FileInputStream(configDownloadPath))).get("so_name");
      int i = 0;
      while (i < localJSONArray.length())
      {
        String str = localJSONArray.getString(i);
        if (!new File(SO_LOAD_DIR + "/" + str).exists())
        {
          QLog.d("kandianreport.KandianReportSoLoader", 1, str + " not found");
          return false;
        }
        i += 1;
      }
      QLog.d("kandianreport.KandianReportSoLoader", 1, "so verify pass");
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.KandianReportSoLoader", 1, localThrowable.getMessage());
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.KandianReportSoLoader
 * JD-Core Version:    0.7.0.1
 */