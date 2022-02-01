package com.tencent.biz.qqstory.utils.ffmpeg;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.video.decode.ShortVideoSoLoad;

class FileUtils
{
  static final String FFMPEG_BIN_FILE_NAME_PIC = "trim_process_pic";
  static final String FFMPEG_BIN_FILE_NAME_PIE = "trim_process_pie";
  
  static String getAVCodecSoFilePath(Context paramContext)
  {
    paramContext = ShortVideoSoLoad.getShortVideoSoPath(paramContext);
    String str = VideoEnvironment.getShortVideoSoLibName();
    return paramContext + str;
  }
  
  static String getFFmpeg(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (String str = "trim_process_pie";; str = "trim_process_pic") {
      return ShortVideoSoLoad.getShortVideoSoPath(paramContext) + str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FileUtils
 * JD-Core Version:    0.7.0.1
 */