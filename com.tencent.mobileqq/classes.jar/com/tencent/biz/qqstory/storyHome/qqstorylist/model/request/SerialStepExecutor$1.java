package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import uzt;
import uzz;
import vab;
import veg;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(uzt paramuzt) {}
  
  public void run()
  {
    if (uzt.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Uzz != null) {
        this.this$0.jdField_a_of_type_Uzz.a();
      }
      uzt.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Vab = ((vab)uzt.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Vab == null)
    {
      if (this.this$0.jdField_a_of_type_Uzz != null) {
        this.this$0.jdField_a_of_type_Uzz.a();
      }
      uzt.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Vab.b();
    veg.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + uzt.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Vab.a(this.this$0);
    this.this$0.jdField_a_of_type_Vab.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      veg.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Vab.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Vab.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_Vab.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */