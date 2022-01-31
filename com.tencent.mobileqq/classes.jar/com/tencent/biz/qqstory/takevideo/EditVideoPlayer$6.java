package com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import ved;
import vhw;

public class EditVideoPlayer$6
  implements Runnable
{
  public EditVideoPlayer$6(vhw paramvhw, int paramInt) {}
  
  public void run()
  {
    ved.a("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.a));
    VideoSourceHelper.nativeSetPlayMode(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */