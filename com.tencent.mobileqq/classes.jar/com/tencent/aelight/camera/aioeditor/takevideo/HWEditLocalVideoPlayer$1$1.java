package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class HWEditLocalVideoPlayer$1$1
  implements Runnable
{
  HWEditLocalVideoPlayer$1$1(HWEditLocalVideoPlayer.1 param1) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.a.this$0.jdField_a_of_type_JavaUtilList.get(0);
      HWEditLocalVideoPlayer.a(this.a.this$0, localMp4VideoFragmentInfo);
    }
    else
    {
      SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "mFragmentInfos is empty");
    }
    HWEditLocalVideoPlayer.a(this.a.this$0, this.a.this$0.jdField_a_of_type_Int);
    HWEditLocalVideoPlayer.a(this.a.this$0).set(true);
    this.a.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */