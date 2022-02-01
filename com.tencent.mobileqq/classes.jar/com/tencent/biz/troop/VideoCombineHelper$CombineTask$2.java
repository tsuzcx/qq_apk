package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCombineHelper$CombineTask$2
  extends VideoCombineHelper.FFmpegCallback
{
  VideoCombineHelper$CombineTask$2(VideoCombineHelper.CombineTask paramCombineTask, long paramLong, VideoCombineHelper.Callback paramCallback, File paramFile)
  {
    super(paramCombineTask.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("combineVideos total = ");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.d(".troop.trace_video_combine", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.2
 * JD-Core Version:    0.7.0.1
 */