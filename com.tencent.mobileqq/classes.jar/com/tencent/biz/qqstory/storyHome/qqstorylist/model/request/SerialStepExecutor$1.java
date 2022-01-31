package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import woi;
import woo;
import woq;
import wsv;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(woi paramwoi) {}
  
  public void run()
  {
    if (woi.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Woo != null) {
        this.this$0.jdField_a_of_type_Woo.a();
      }
      woi.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Woq = ((woq)woi.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Woq == null)
    {
      if (this.this$0.jdField_a_of_type_Woo != null) {
        this.this$0.jdField_a_of_type_Woo.a();
      }
      woi.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Woq.b();
    wsv.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + woi.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Woq.a(this.this$0);
    this.this$0.jdField_a_of_type_Woq.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      wsv.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Woq.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Woq.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_Woq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */