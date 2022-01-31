package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import sgi;
import sis;
import siz;
import sjc;
import skl;
import urk;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(sis paramsis, skl paramskl, sjc paramsjc) {}
  
  public void run()
  {
    urk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Skl });
    sgi.a().dispatch(this.jdField_a_of_type_Sjc);
    sgi.a().dispatch(new siz());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */