package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import ste;
import svo;
import svv;
import svy;
import sxh;
import veg;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(svo paramsvo, sxh paramsxh, svy paramsvy) {}
  
  public void run()
  {
    veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Sxh });
    ste.a().dispatch(this.jdField_a_of_type_Svy);
    ste.a().dispatch(new svv());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */