package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import stb;
import svl;
import svs;
import svv;
import sxe;
import ved;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(svl paramsvl, sxe paramsxe, svv paramsvv) {}
  
  public void run()
  {
    ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Sxe });
    stb.a().dispatch(this.jdField_a_of_type_Svv);
    stb.a().dispatch(new svs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */