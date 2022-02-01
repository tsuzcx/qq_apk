package com.tencent.mobileqq.activity.shortvideo;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EncodeVideoUtil
{
  public static EncodeVideoUtil.VideoInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new File(paramString);
        EncodeVideoUtil.VideoInfo localVideoInfo = new EncodeVideoUtil.VideoInfo();
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          String str = a((File)localObject);
          localObject = b((File)localObject);
          if (TextUtils.isEmpty(str)) {
            return null;
          }
          localVideoInfo.a = str;
          localVideoInfo.b = ((String)localObject);
          localVideoInfo.c = paramString;
          return localVideoInfo;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EncodeVideoUtil", 2, "getVideoInfoByPath error", paramString);
        }
      }
    }
    return null;
  }
  
  @NonNull
  private static String a(File paramFile)
  {
    paramFile = paramFile.listFiles();
    if ((paramFile != null) && (paramFile.length > 0))
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if (localObject.getName().endsWith(".mp4")) {
          return localObject.getAbsolutePath();
        }
        i += 1;
      }
    }
    return null;
  }
  
  @NonNull
  private static String b(File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("audio_data_cache");
    paramFile = new File(localStringBuilder.toString());
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0)) {
        return paramFile[0].getAbsolutePath();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoUtil
 * JD-Core Version:    0.7.0.1
 */