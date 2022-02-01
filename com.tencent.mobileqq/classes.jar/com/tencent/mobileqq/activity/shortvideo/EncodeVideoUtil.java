package com.tencent.mobileqq.activity.shortvideo;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QZoneVideoCompressor;
import java.io.File;

public class EncodeVideoUtil
{
  public static final String TAG = "EncodeVideoUtil";
  
  public static int adjustBitrate(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
  {
    int i = 0;
    if ((paramPublishVideoEntry == null) || (paramPublishVideoEntry.videoMaxrate <= 0)) {
      i = -1;
    }
    do
    {
      for (;;)
      {
        return i;
        double d = paramPublishVideoEntry.recordTime / 1000.0D;
        int j = paramPublishVideoEntry.videoMaxrate;
        try
        {
          j = QZoneVideoCompressor.trimByFFmpeg(new String[] { "-threads", "1", "-ss", "0.0", "-accurate_seek", "-i", paramString1, "-t", String.valueOf(d), "-vf", "null", "-metadata:s", "rotate=0", "-acodec", "aac", "-vcodec", "libx264", "-movflags", "faststart", "-preset", "veryfast", "-tune", "psnr", "-profile:v", "high", "-level", "3.0", "-b:v", String.valueOf(j), "-y", paramString2 });
          return j;
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("EncodeVideoUtil", 2, "TrimNative.trim: ", paramString1);
            return 0;
          }
        }
        catch (Error paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("EncodeVideoUtil", 2, "TrimNative.trim: error", paramString1);
    return 0;
  }
  
  @NonNull
  private static String getAudioPath(File paramFile)
  {
    paramFile = new File(paramFile.getAbsolutePath() + File.separator + "audio_data_cache");
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0)) {
        return paramFile[0].getAbsolutePath();
      }
    }
    return null;
  }
  
  public static EncodeVideoUtil.VideoInfo getVideoInfoByPath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new File(paramString);
        EncodeVideoUtil.VideoInfo localVideoInfo = new EncodeVideoUtil.VideoInfo();
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          String str = getVideoPath((File)localObject);
          localObject = getAudioPath((File)localObject);
          if (TextUtils.isEmpty(str)) {
            return null;
          }
          localVideoInfo.videoPath = str;
          localVideoInfo.audioPath = ((String)localObject);
          localVideoInfo.sourcePath = paramString;
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
  
  public static String getVideoOutputPath(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = ShortVideoUtils.getShortVideoPath(new File(paramString).getParentFile());
      return paramString;
    }
    catch (Exception paramString)
    {
      QZLog.i("EncodeVideoUtil", 1, "get target path error encode error", paramString);
    }
    return null;
  }
  
  @NonNull
  private static String getVideoPath(File paramFile)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoUtil
 * JD-Core Version:    0.7.0.1
 */