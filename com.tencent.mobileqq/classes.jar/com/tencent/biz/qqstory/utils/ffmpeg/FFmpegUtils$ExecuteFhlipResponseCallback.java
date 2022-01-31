package com.tencent.biz.qqstory.utils.ffmpeg;

import android.os.SystemClock;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qphone.base.util.QLog;

public class FFmpegUtils$ExecuteFhlipResponseCallback
  implements FFmpegExecuteResponseCallback
{
  public long a;
  public FFmpegExecuteResponseCallback a;
  
  public FFmpegUtils$ExecuteFhlipResponseCallback(FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void a(String paramString)
  {
    paramString = String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    StoryReportor.a("play_video", "down_watermark_hfliptime", 0, 0, new String[] { paramString });
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegCmd", 2, "play_video down_watermark_hfliptime:" + paramString);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.b(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "play_video hflip video Error:" + paramString);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.ExecuteFhlipResponseCallback
 * JD-Core Version:    0.7.0.1
 */