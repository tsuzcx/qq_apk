package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import uzq;
import uzw;
import uzy;
import ved;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(uzq paramuzq) {}
  
  public void run()
  {
    if (uzq.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Uzw != null) {
        this.this$0.jdField_a_of_type_Uzw.a();
      }
      uzq.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Uzy = ((uzy)uzq.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Uzy == null)
    {
      if (this.this$0.jdField_a_of_type_Uzw != null) {
        this.this$0.jdField_a_of_type_Uzw.a();
      }
      uzq.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Uzy.b();
    ved.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + uzq.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Uzy.a(this.this$0);
    this.this$0.jdField_a_of_type_Uzy.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      ved.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Uzy.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Uzy.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_Uzy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */