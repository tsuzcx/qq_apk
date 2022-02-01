package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class HWEditImportVideoPlayer$1$1
  implements Runnable
{
  HWEditImportVideoPlayer$1$1(HWEditImportVideoPlayer.1 param1) {}
  
  public void run()
  {
    if (this.a.this$0.a.size() > 0)
    {
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.a.this$0.a.get(0);
      HWEditImportVideoPlayer.a(this.a.this$0, localMp4VideoFragmentInfo);
    }
    else
    {
      SLog.e("Q.qqstory.record.HWEditImportVideoPlayer", "mFragmentInfos is empty");
    }
    HWEditImportVideoPlayer.a(this.a.this$0).set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */