package com.tencent.biz.videostory.support;

import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;

class VideoStoryPicToVideo$2
  implements FFmpegExecuteResponseCallback
{
  VideoStoryPicToVideo$2(VideoStoryPicToVideo paramVideoStoryPicToVideo, VideoStoryPicToVideo.ConvertListener paramConvertListener, VideoStoryPicToVideo.RetCode paramRetCode) {}
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$ConvertListener != null)
    {
      this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode.a(943004);
      this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode.a(paramString);
      this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$ConvertListener.b(this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo failure");
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo finish");
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo start");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$ConvertListener != null) {
      this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$ConvertListener.a(this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.support.VideoStoryPicToVideo.2
 * JD-Core Version:    0.7.0.1
 */