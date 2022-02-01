package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import wip;
import wiw;
import yqp;

public class VideoCompositeHelper$1
  implements Runnable
{
  public VideoCompositeHelper$1(wip paramwip, PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, wiw paramwiw) {}
  
  public void run()
  {
    try
    {
      yqp.d(wip.jdField_a_of_type_JavaLangString, "composite thread try get lock");
      try
      {
        yqp.c(wip.jdField_a_of_type_JavaLangString, "composite thread get lock and start doComposite");
        this.this$0.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_Wiw);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      yqp.c(wip.jdField_a_of_type_JavaLangString, "do composite exception", localException);
      this.jdField_a_of_type_Wiw.a(942012, localException.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.1
 * JD-Core Version:    0.7.0.1
 */