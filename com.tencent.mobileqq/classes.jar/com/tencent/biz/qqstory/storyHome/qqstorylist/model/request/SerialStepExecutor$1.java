package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import ygd;
import ygj;
import ygl;
import ykq;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(ygd paramygd) {}
  
  public void run()
  {
    if (ygd.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Ygj != null) {
        this.this$0.jdField_a_of_type_Ygj.a();
      }
      ygd.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Ygl = ((ygl)ygd.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Ygl == null)
    {
      if (this.this$0.jdField_a_of_type_Ygj != null) {
        this.this$0.jdField_a_of_type_Ygj.a();
      }
      ygd.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Ygl.b();
    ykq.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + ygd.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Ygl.a(this.this$0);
    this.this$0.jdField_a_of_type_Ygl.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      ykq.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Ygl.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Ygl.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_Ygl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */