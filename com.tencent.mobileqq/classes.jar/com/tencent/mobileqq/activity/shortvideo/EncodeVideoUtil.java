package com.tencent.mobileqq.activity.shortvideo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EncodeVideoUtil
{
  public static EncodeVideoUtil.VideoInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new File(paramString);
        if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
        {
          File[] arrayOfFile = ((File)localObject1).listFiles();
          if ((arrayOfFile != null) && (((File)localObject1).length() > 0L))
          {
            int j = arrayOfFile.length;
            i = 0;
            localObject1 = null;
            if (i >= j) {
              break label178;
            }
            File localFile = arrayOfFile[i];
            if (localFile.getName().contains("video.mp4"))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new EncodeVideoUtil.VideoInfo();
              }
              ((EncodeVideoUtil.VideoInfo)localObject2).a = localFile.getAbsolutePath();
            }
            else
            {
              localObject2 = localObject1;
              if (localFile.getName().contains("audio.mp4"))
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = new EncodeVideoUtil.VideoInfo();
                }
                ((EncodeVideoUtil.VideoInfo)localObject2).b = localFile.getAbsolutePath();
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EncodeVideoUtil", 2, "getVideoInfoByPath error", paramString);
        }
      }
      Object localObject2 = null;
      label178:
      do
      {
        return localObject2;
        localObject2 = localObject1;
      } while (localObject1 == null);
      ((EncodeVideoUtil.VideoInfo)localObject1).c = paramString;
      return localObject1;
      i += 1;
      Object localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoUtil
 * JD-Core Version:    0.7.0.1
 */