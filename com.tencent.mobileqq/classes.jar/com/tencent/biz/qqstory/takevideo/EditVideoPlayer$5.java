package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;

class EditVideoPlayer$5
  implements Runnable
{
  EditVideoPlayer$5(EditVideoPlayer paramEditVideoPlayer, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    SLog.a("Q.qqstory.record.EditVideoPlayer", "setMosaic %d", Integer.valueOf(this.jdField_a_of_type_Int));
    VideoSourceHelper.nativeSetMosaic(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */