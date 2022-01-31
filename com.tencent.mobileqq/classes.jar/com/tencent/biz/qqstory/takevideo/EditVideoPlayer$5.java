package com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import ved;
import vhw;

public class EditVideoPlayer$5
  implements Runnable
{
  public EditVideoPlayer$5(vhw paramvhw, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    ved.a("Q.qqstory.record.EditVideoPlayer", "setMosaic %d", Integer.valueOf(this.jdField_a_of_type_Int));
    VideoSourceHelper.nativeSetMosaic(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */