package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import wad;
import wcn;
import wcu;
import wcx;
import wdy;
import ykq;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(wcn paramwcn, wdy paramwdy, wcx paramwcx) {}
  
  public void run()
  {
    ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Wdy });
    wad.a().dispatch(this.jdField_a_of_type_Wcx);
    wad.a().dispatch(new wcu());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */