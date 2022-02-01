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
    Object localObject = this.this$0;
    ((SerialStepExecutor)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep = ((Step)SerialStepExecutor.a((SerialStepExecutor)localObject).poll());
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
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("剩下step:");
    ((StringBuilder)localObject).append(SerialStepExecutor.a(this.this$0).size());
    SLog.b("Q.qqstory.home.SerialStepExecutor", ((StringBuilder)localObject).toString());
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.this$0);
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("step:");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a());
      ((StringBuilder)localObject).append(",return null result");
      SLog.e("Q.qqstory.home.SerialStepExecutor", ((StringBuilder)localObject).toString());
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */