package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$7
  extends VideoCombineHelper.FFmpegCallback
{
  VideoCombineHelper$7(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.Callback paramCallback, String paramString)
  {
    super(paramVideoCombineHelper);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mixAudio end : isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(".troop.VideoCombineHelper", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mixAudioTime: ");
      localStringBuilder.append(System.currentTimeMillis() - this.c.b);
      QLog.d(".troop.trace_video_combine", 2, localStringBuilder.toString());
      this.c.b = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.a.a(this.b, false, "mixAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.7
 * JD-Core Version:    0.7.0.1
 */