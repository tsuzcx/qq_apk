package com.tencent.biz.troop;

import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$CombineTask$4
  extends ExecuteBinResponseCallback
{
  VideoCombineHelper$CombineTask$4(VideoCombineHelper.CombineTask paramCombineTask, VideoCombineHelper.FFmpegCallback paramFFmpegCallback) {}
  
  public void onFailure(String paramString)
  {
    QLog.w(".troop.VideoCombineHelper", 1, "concatMediaByTs change ts onSuccess: " + paramString);
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$FFmpegCallback.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel())
    {
      QLog.w(".troop.trace_video_combine", 2, "concatMediaByTs change ts onSuccess: " + paramString);
      QLog.d(".troop.trace_video_combine", 2, "convertToTsTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.a.a));
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.a.a = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.4
 * JD-Core Version:    0.7.0.1
 */