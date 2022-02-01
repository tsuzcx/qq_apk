package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import ymc;
import ymi;
import ymk;
import yqp;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(ymc paramymc) {}
  
  public void run()
  {
    if (ymc.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Ymi != null) {
        this.this$0.jdField_a_of_type_Ymi.a();
      }
      ymc.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Ymk = ((ymk)ymc.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Ymk == null)
    {
      if (this.this$0.jdField_a_of_type_Ymi != null) {
        this.this$0.jdField_a_of_type_Ymi.a();
      }
      ymc.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Ymk.b();
    yqp.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + ymc.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Ymk.a(this.this$0);
    this.this$0.jdField_a_of_type_Ymk.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      yqp.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Ymk.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Ymk.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_Ymk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */