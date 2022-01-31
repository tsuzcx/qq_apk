package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import umx;
import und;
import unf;
import urk;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(umx paramumx) {}
  
  public void run()
  {
    if (umx.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Und != null) {
        this.this$0.jdField_a_of_type_Und.a();
      }
      umx.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Unf = ((unf)umx.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Unf == null)
    {
      if (this.this$0.jdField_a_of_type_Und != null) {
        this.this$0.jdField_a_of_type_Und.a();
      }
      umx.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Unf.b();
    urk.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + umx.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Unf.a(this.this$0);
    this.this$0.jdField_a_of_type_Unf.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      urk.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Unf.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Unf.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_Unf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */