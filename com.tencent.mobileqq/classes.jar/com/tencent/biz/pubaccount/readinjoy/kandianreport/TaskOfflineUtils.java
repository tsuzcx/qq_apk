package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class TaskOfflineUtils
{
  private static final String CONFIG_FILENAME = "log_task_config.geojson";
  private static final int DEFAULT_DELAY_CHECKUP_TIME = 5;
  private static String TAG = "kandianreport.TaskOfflineUtils";
  
  public static TaskOfflineUtils.ConfigData checkOffLineConfig(String paramString, int paramInt)
  {
    TaskOfflineUtils.ConfigData localConfigData = new TaskOfflineUtils.ConfigData();
    Object localObject = OfflineEnvHelper.a(paramString);
    if (localObject == null) {
      QLog.d(TAG, 2, "checkOffLineConfig: offline root dir is null");
    }
    int i;
    int j;
    do
    {
      return localConfigData;
      paramString = (String)localObject + paramString;
      paramString = paramString + "/" + "log_task_config.geojson";
      localObject = new File(paramString);
      try
      {
        if (!((File)localObject).exists())
        {
          QLog.d(TAG, 2, "checkOffLineConfig: there is not file " + paramString);
          return localConfigData;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e(TAG, 1, "checkOffLineConfig: throwable", paramString);
        return localConfigData;
      }
      paramString = new JSONObject(readInputStreamAsString(new FileInputStream((File)localObject)));
      i = paramString.getInt("version_id");
      j = paramString.getInt("support_min_version_id");
      localConfigData.version = i;
      localConfigData.minSupportVerision = j;
      QLog.d(TAG, 2, "version_id : " + i + "  support_min_version_id: " + j);
      if (i == paramInt)
      {
        localConfigData.isValid = true;
        return localConfigData;
      }
    } while ((i <= paramInt) || (j > paramInt));
    localConfigData.isValid = true;
    return localConfigData;
  }
  
  public static void checkUpdate(String paramString, int paramInt, TaskOfflineUtils.OfflineCallBack paramOfflineCallBack)
  {
    QLog.d(TAG, 2, "bid : " + paramString);
    try
    {
      HtmlOffline.a();
      ThreadManager.executeOnFileThread(new TaskOfflineUtils.1(paramString, paramInt, paramOfflineCallBack));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "HtmlOffline init ", localThrowable);
      }
    }
  }
  
  public static String readInputStreamAsString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          QLog.e(TAG, 1, QLog.getStackTraceString(paramInputStream));
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      QLog.d(TAG, 2, "fail to read string from input stream");
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            QLog.e(TAG, 1, QLog.getStackTraceString(paramInputStream));
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          QLog.e(TAG, 1, QLog.getStackTraceString(paramInputStream));
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError = localOutOfMemoryError;
      QLog.d(TAG, 2, "fail to read string from input stream due to OOM");
      try
      {
        paramInputStream.close();
        return null;
      }
      catch (IOException paramInputStream)
      {
        QLog.e(TAG, 1, QLog.getStackTraceString(paramInputStream));
        return null;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskOfflineUtils
 * JD-Core Version:    0.7.0.1
 */