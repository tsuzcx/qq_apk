package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import vli;
import vns;
import vnz;
import voc;
import vpd;
import xvv;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(vns paramvns, vpd paramvpd, voc paramvoc) {}
  
  public void run()
  {
    xvv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Vpd });
    vli.a().dispatch(this.jdField_a_of_type_Voc);
    vli.a().dispatch(new vnz());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */