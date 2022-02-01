package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;

class VideoCompositeHelper$1
  implements Runnable
{
  VideoCompositeHelper$1(VideoCompositeHelper paramVideoCompositeHelper, PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack) {}
  
  public void run()
  {
    try
    {
      SLog.d(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "composite thread try get lock");
      try
      {
        SLog.c(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "composite thread get lock and start doComposite");
        this.this$0.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      SLog.c(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "do composite exception", localException);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack.a(942012, localException.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.1
 * JD-Core Version:    0.7.0.1
 */