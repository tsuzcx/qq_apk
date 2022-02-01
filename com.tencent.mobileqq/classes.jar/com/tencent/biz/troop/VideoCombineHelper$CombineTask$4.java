package com.tencent.biz.troop;

import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$CombineTask$4
  extends ExecuteBinResponseCallback
{
  VideoCombineHelper$CombineTask$4(VideoCombineHelper.CombineTask paramCombineTask, VideoCombineHelper.FFmpegCallback paramFFmpegCallback) {}
  
  public void onFailure(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("concatMediaByTs change ts onSuccess: ");
    localStringBuilder.append(paramString);
    QLog.w(".troop.VideoCombineHelper", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$FFmpegCallback.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("concatMediaByTs change ts onSuccess: ");
      localStringBuilder.append(paramString);
      QLog.w(".troop.trace_video_combine", 2, localStringBuilder.toString());
      paramString = new StringBuilder();
      paramString.append("convertToTsTime = ");
      paramString.append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.a.a);
      QLog.d(".troop.trace_video_combine", 2, paramString.toString());
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.a.a = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.4
 * JD-Core Version:    0.7.0.1
 */