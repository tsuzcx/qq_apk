package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import wsr;
import wsx;
import wsz;
import wxe;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(wsr paramwsr) {}
  
  public void run()
  {
    if (wsr.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Wsx != null) {
        this.this$0.jdField_a_of_type_Wsx.a();
      }
      wsr.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Wsz = ((wsz)wsr.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Wsz == null)
    {
      if (this.this$0.jdField_a_of_type_Wsx != null) {
        this.this$0.jdField_a_of_type_Wsx.a();
      }
      wsr.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Wsz.b();
    wxe.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + wsr.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Wsz.a(this.this$0);
    this.this$0.jdField_a_of_type_Wsz.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      wxe.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Wsz.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Wsz.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_Wsz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */