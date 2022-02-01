package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;

class EditVideoPlayer$6
  implements Runnable
{
  EditVideoPlayer$6(EditVideoPlayer paramEditVideoPlayer, int paramInt) {}
  
  public void run()
  {
    SLog.a("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.a));
    VideoSourceHelper.nativeSetPlayMode(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */