package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DiySecureFileHelper
{
  private static final Map<String, Integer> a = new HashMap();
  
  public static int a(String arg0, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(???);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    synchronized (a)
    {
      int i;
      if (a.containsKey(paramString2))
      {
        i = ((Integer)a.get(paramString2)).intValue();
      }
      else
      {
        i = BaseApplication.getContext().getSharedPreferences("StepUpdate", 4).getInt(paramString2, 0);
        a.put(paramString2, Integer.valueOf(i));
      }
      return i;
    }
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("custom_background/");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String a(String paramString)
  {
    if (paramString.length() > 4)
    {
      String str = paramString.substring(4);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" -> ");
        localStringBuilder.append(str);
        QLog.d("DiySecureFileHelper", 4, localStringBuilder.toString());
      }
      return str;
    }
    return paramString;
  }
  
  public static void a(String arg0, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(???);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    for (;;)
    {
      synchronized (a)
      {
        if (a.containsKey(paramString2))
        {
          i = ((Integer)a.get(paramString2)).intValue();
          if (i != paramInt)
          {
            BaseApplication.getContext().getSharedPreferences("StepUpdate", 4).edit().putInt(paramString2, paramInt).commit();
            a.put(paramString2, Integer.valueOf(paramInt));
          }
          return;
        }
      }
      int i = -1;
    }
  }
  
  private static File[] b(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    paramFile = arrayOfFile;
    if (arrayOfFile == null)
    {
      QLog.e("DiySecureFileHelper", 1, new Throwable(), new Object[0]);
      paramFile = new File[0];
    }
    return paramFile;
  }
  
  private static void c(String paramString1, String paramString2)
  {
    Object localObject1 = new File(paramString1);
    if (((File)localObject1).exists())
    {
      int i;
      if (((File)localObject1).isFile())
      {
        i = FileUtils.quickMove(paramString1, paramString2);
        if (i != 0)
        {
          paramString2 = new StringBuilder();
          paramString2.append("Move [");
          paramString2.append(paramString1);
          paramString2.append("] errorcode = ");
          paramString2.append(i);
          QLog.d("DiySecureFileHelper", 1, paramString2.toString());
        }
      }
      else if (((File)localObject1).isDirectory())
      {
        localObject1 = b((File)localObject1);
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          c(localObject2.getAbsolutePath(), new File(paramString2, localObject2.getName()).getAbsolutePath());
          i += 1;
        }
      }
      FileUtils.deleteDirectory(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.DiySecureFileHelper
 * JD-Core Version:    0.7.0.1
 */