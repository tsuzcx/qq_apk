package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCombineHelper$CombineTask$5
  extends VideoCombineHelper.FFmpegCallback
{
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("splitAudio end : isSuccess = ");
    localStringBuilder.append(paramBoolean);
    QLog.d(".troop.VideoCombineHelper", 2, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.a.a(this.b.getAbsolutePath(), true, "cmobine auido video done.");
      return;
    }
    this.a.a(this.c.getAbsolutePath(), false, "cmobine auido video done.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.5
 * JD-Core Version:    0.7.0.1
 */