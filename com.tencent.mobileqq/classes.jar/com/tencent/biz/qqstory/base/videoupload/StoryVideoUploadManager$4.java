package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import uht;
import ukd;
import ukk;
import ukn;
import ulw;
import wsv;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(ukd paramukd, ulw paramulw, ukn paramukn) {}
  
  public void run()
  {
    wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Ulw });
    uht.a().dispatch(this.jdField_a_of_type_Ukn);
    uht.a().dispatch(new ukk());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */