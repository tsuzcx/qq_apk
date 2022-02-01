package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class SerialStepExecutor$1
  implements Runnable
{
  SerialStepExecutor$1(SerialStepExecutor paramSerialStepExecutor) {}
  
  public void run()
  {
    if (SerialStepExecutor.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler != null) {
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler.a();
      }
      SerialStepExecutor.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep = ((Step)SerialStepExecutor.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep == null)
    {
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler != null) {
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler.a();
      }
      SerialStepExecutor.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.b();
    SLog.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + SerialStepExecutor.a(this.this$0).size());
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.this$0);
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      SLog.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */