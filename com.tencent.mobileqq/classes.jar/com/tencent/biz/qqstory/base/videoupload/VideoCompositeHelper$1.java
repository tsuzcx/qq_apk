package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import wmk;
import wmr;
import yuk;

public class VideoCompositeHelper$1
  implements Runnable
{
  public VideoCompositeHelper$1(wmk paramwmk, PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, wmr paramwmr) {}
  
  public void run()
  {
    try
    {
      yuk.d(wmk.jdField_a_of_type_JavaLangString, "composite thread try get lock");
      try
      {
        yuk.c(wmk.jdField_a_of_type_JavaLangString, "composite thread get lock and start doComposite");
        this.this$0.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_Wmr);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      yuk.c(wmk.jdField_a_of_type_JavaLangString, "do composite exception", localException);
      this.jdField_a_of_type_Wmr.a(942012, localException.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.1
 * JD-Core Version:    0.7.0.1
 */