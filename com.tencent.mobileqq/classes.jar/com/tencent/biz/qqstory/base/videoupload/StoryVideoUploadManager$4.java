package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import wfo;
import why;
import wif;
import wii;
import wjr;
import yqp;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(why paramwhy, wjr paramwjr, wii paramwii) {}
  
  public void run()
  {
    yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Wjr });
    wfo.a().dispatch(this.jdField_a_of_type_Wii);
    wfo.a().dispatch(new wif());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */