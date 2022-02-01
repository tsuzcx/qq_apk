package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.video.decode.ShortVideoSoLoad;

public class FileFFmpegUtils
{
  public static String a(Context paramContext)
  {
    String str;
    if (Build.VERSION.SDK_INT >= 16) {
      str = "trim_process_pie";
    } else {
      str = "trim_process_pic";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ShortVideoSoLoad.getShortVideoSoPath(paramContext));
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String b(Context paramContext)
  {
    paramContext = ShortVideoSoLoad.getShortVideoSoPath(paramContext);
    String str = VideoEnvironment.getShortVideoSoLibName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.util.FileFFmpegUtils
 * JD-Core Version:    0.7.0.1
 */