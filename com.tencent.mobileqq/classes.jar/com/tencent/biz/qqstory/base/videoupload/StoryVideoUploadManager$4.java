package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import wjj;
import wlt;
import wma;
import wmd;
import wnm;
import yuk;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(wlt paramwlt, wnm paramwnm, wmd paramwmd) {}
  
  public void run()
  {
    yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Wnm });
    wjj.a().dispatch(this.jdField_a_of_type_Wmd);
    wjj.a().dispatch(new wma());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */