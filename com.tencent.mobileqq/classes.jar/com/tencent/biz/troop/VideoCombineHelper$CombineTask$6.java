package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$CombineTask$6
  extends VideoCombineHelper.FFmpegCallback
{
  VideoCombineHelper$CombineTask$6(VideoCombineHelper.CombineTask paramCombineTask, VideoCombineHelper.Callback paramCallback, String paramString)
  {
    super(paramCombineTask.e);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "watermark doen");
    }
    this.a.a(this.b, paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.6
 * JD-Core Version:    0.7.0.1
 */