package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$8
  extends VideoCombineHelper.FFmpegCallback
{
  VideoCombineHelper$8(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.Callback paramCallback, String paramString1, String paramString2)
  {
    super(paramVideoCombineHelper);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("combineUnit end : isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(".troop.VideoCombineHelper", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("combineAudioAndVideoTime: ");
      localStringBuilder.append(System.currentTimeMillis() - this.d.b);
      QLog.d(".troop.trace_video_combine", 2, localStringBuilder.toString());
      this.d.b = System.currentTimeMillis();
    }
    if (paramBoolean)
    {
      this.a.a(this.b, true, "cmobine auido video done.");
      return;
    }
    this.a.a(this.c, false, "cmobine auido video done.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.8
 * JD-Core Version:    0.7.0.1
 */