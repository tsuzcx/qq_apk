package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import nyd;

public class SerialStepExecutor
  extends SimpleStepExector
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Step a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public SerialStepExecutor(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 2) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new nyd(this));
  }
  
  public SerialStepExecutor a(SimpleStepExector.CompletedHandler paramCompletedHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler = paramCompletedHandler;
    return this;
  }
  
  public SerialStepExecutor a(SimpleStepExector.ErrorHandler paramErrorHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$ErrorHandler = paramErrorHandler;
    return this;
  }
  
  public SerialStepExecutor a(Step paramStep)
  {
    SLog.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramStep.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramStep);
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Int = 1;
      e();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$ErrorHandler != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$ErrorHandler.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        SLog.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a() + ",return null result");
      }
      e();
      return;
    }
    c();
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        SLog.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a() + ",return null result");
      }
      e();
      return;
    }
    finally {}
  }
  
  public void b() {}
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Int = 2;
      SLog.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.c();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(null);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$ErrorHandler = null;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor
 * JD-Core Version:    0.7.0.1
 */