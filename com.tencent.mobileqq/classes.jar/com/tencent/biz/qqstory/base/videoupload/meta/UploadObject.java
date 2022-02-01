package com.tencent.biz.qqstory.base.videoupload.meta;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class UploadObject
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  public UploadObject.UploadFinishListener a;
  protected AtomicInteger a;
  
  public UploadObject()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  protected abstract void a();
  
  public void a(UploadObject.UploadFinishListener paramUploadFinishListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaUploadObject$UploadFinishListener = paramUploadFinishListener;
  }
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  protected void b()
  {
    UploadObject.UploadFinishListener localUploadFinishListener = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaUploadObject$UploadFinishListener;
    if (localUploadFinishListener != null) {
      localUploadFinishListener.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.UploadObject
 * JD-Core Version:    0.7.0.1
 */