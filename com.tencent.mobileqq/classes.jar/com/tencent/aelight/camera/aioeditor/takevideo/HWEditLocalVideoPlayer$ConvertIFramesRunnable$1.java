package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;

class HWEditLocalVideoPlayer$ConvertIFramesRunnable$1
  implements HWEncodeListener
{
  HWEditLocalVideoPlayer$ConvertIFramesRunnable$1(HWEditLocalVideoPlayer.ConvertIFramesRunnable paramConvertIFramesRunnable, HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo) {}
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("encode error errorCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" Exception = ");
    localStringBuilder.append(paramThrowable);
    SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b == 0)
    {
      paramThrowable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
      paramThrowable.b = 1;
      paramThrowable.a = 3;
      paramThrowable = new StringBuilder();
      paramThrowable.append("Reencode i frame video by mIFrameInterval = ");
      paramThrowable.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b);
      paramThrowable.append(" mFrameRate = ");
      paramThrowable.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.a);
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", paramThrowable.toString());
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 1000L);
      return;
    }
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video failed");
    try
    {
      ShortVideoExceptionReporter.a(paramThrowable);
    }
    catch (Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.a(new HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.2(this), 0L);
  }
  
  public void onEncodeFinish(String paramString)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$Mp4VideoFragmentInfo.a = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeFinish  iframe file filePath = ");
    localStringBuilder.append(paramString);
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.a(new HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1(this), 0L);
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1
 * JD-Core Version:    0.7.0.1
 */