package com.tencent.aelight.camera.aioeditor.capture.util;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QIMFileUtils
{
  public static File a()
  {
    return MobileQQ.getContext().getCacheDir();
  }
  
  public static String a(File paramFile, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    paramFile = new File(localStringBuilder.toString());
    if (paramFile.exists())
    {
      paramFile = FileUtils.fileToBytes(paramFile);
      if (paramFile != null)
      {
        if (paramFile.length <= 0) {
          return null;
        }
        if (Build.VERSION.SDK_INT <= 8) {
          return new String(paramFile);
        }
        try
        {
          paramFile = new String(paramFile, "UTF-8");
          return paramFile;
        }
        catch (UnsupportedEncodingException paramFile)
        {
          if (QLog.isDevelopLevel()) {
            paramFile.printStackTrace();
          }
        }
      }
      return null;
    }
    return "";
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 90	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 94	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_0
    //   11: invokevirtual 100	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: aload_0
    //   16: astore_1
    //   17: aload_0
    //   18: astore_2
    //   19: aload_0
    //   20: invokestatic 105	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_1
    //   26: aload_0
    //   27: ifnull +68 -> 95
    //   30: aload_0
    //   31: invokevirtual 110	java/io/InputStream:close	()V
    //   34: aload_3
    //   35: areturn
    //   36: astore_0
    //   37: aload_3
    //   38: astore_1
    //   39: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +53 -> 95
    //   45: aload_0
    //   46: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   49: aload_3
    //   50: areturn
    //   51: astore_0
    //   52: goto +45 -> 97
    //   55: astore_0
    //   56: aload_2
    //   57: astore_1
    //   58: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +9 -> 70
    //   64: aload_2
    //   65: astore_1
    //   66: aload_0
    //   67: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   70: aload_2
    //   71: ifnull +21 -> 92
    //   74: aload_2
    //   75: invokevirtual 110	java/io/InputStream:close	()V
    //   78: goto +14 -> 92
    //   81: astore_0
    //   82: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   92: ldc 84
    //   94: astore_1
    //   95: aload_1
    //   96: areturn
    //   97: aload_1
    //   98: ifnull +21 -> 119
    //   101: aload_1
    //   102: invokevirtual 110	java/io/InputStream:close	()V
    //   105: goto +14 -> 119
    //   108: astore_1
    //   109: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   119: aload_0
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramString	String
    //   3	99	1	localObject	Object
    //   108	8	1	localException	java.lang.Exception
    //   1	74	2	str1	String
    //   23	27	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   30	34	36	java/lang/Exception
    //   4	15	51	finally
    //   19	24	51	finally
    //   58	64	51	finally
    //   66	70	51	finally
    //   4	15	55	java/io/IOException
    //   19	24	55	java/io/IOException
    //   74	78	81	java/lang/Exception
    //   101	105	108	java/lang/Exception
  }
  
  public static void a(File paramFile, String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new QIMFileUtils.1(paramFile, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils
 * JD-Core Version:    0.7.0.1
 */