package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import mzb;
import mzh;
import org.json.JSONObject;

public class TaskOfflineUtils
{
  private static final String CONFIG_FILENAME = "log_task_config.geojson";
  private static final int DEFAULT_DELAY_CHECKUP_TIME = 5;
  private static String TAG = "kandianreport.TaskOfflineUtils";
  
  public static TaskOfflineUtils.ConfigData checkOffLineConfig(String paramString, int paramInt)
  {
    TaskOfflineUtils.ConfigData localConfigData = new TaskOfflineUtils.ConfigData();
    Object localObject = mzh.a(paramString);
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
      mzb.a();
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
  
  /* Error */
  public static String readInputStreamAsString(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 137	java/io/BufferedReader
    //   3: dup
    //   4: new 139	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 142	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 145	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 47	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 148	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +31 -> 61
    //   33: aload_1
    //   34: aload_3
    //   35: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: goto -15 -> 24
    //   42: astore_2
    //   43: getstatic 18	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskOfflineUtils:TAG	Ljava/lang/String;
    //   46: iconst_2
    //   47: ldc 150
    //   49: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: invokevirtual 155	java/io/InputStream:close	()V
    //   56: aload_1
    //   57: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: areturn
    //   61: aload_0
    //   62: invokevirtual 155	java/io/InputStream:close	()V
    //   65: goto -9 -> 56
    //   68: astore_0
    //   69: goto -13 -> 56
    //   72: astore_1
    //   73: getstatic 18	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskOfflineUtils:TAG	Ljava/lang/String;
    //   76: iconst_2
    //   77: ldc 157
    //   79: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: invokevirtual 155	java/io/InputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: areturn
    //   91: astore_1
    //   92: aload_0
    //   93: invokevirtual 155	java/io/InputStream:close	()V
    //   96: aload_1
    //   97: athrow
    //   98: astore_0
    //   99: goto -43 -> 56
    //   102: astore_0
    //   103: goto -7 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramInputStream	java.io.InputStream
    //   23	34	1	localStringBuilder	java.lang.StringBuilder
    //   72	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   91	6	1	localObject	Object
    //   15	10	2	localBufferedReader	java.io.BufferedReader
    //   42	1	2	localIOException	java.io.IOException
    //   28	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   24	29	42	java/io/IOException
    //   33	39	42	java/io/IOException
    //   61	65	68	java/io/IOException
    //   24	29	72	java/lang/OutOfMemoryError
    //   33	39	72	java/lang/OutOfMemoryError
    //   82	86	88	java/io/IOException
    //   24	29	91	finally
    //   33	39	91	finally
    //   43	52	91	finally
    //   73	82	91	finally
    //   52	56	98	java/io/IOException
    //   92	96	102	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskOfflineUtils
 * JD-Core Version:    0.7.0.1
 */