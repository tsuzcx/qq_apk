package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import umc;
import uom;
import uot;
import uow;
import uqf;
import wxe;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(uom paramuom, uqf paramuqf, uow paramuow) {}
  
  public void run()
  {
    wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Uqf });
    umc.a().dispatch(this.jdField_a_of_type_Uow);
    umc.a().dispatch(new uot());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */