package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import xri;
import xro;
import xrq;
import xvv;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(xri paramxri) {}
  
  public void run()
  {
    if (xri.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Xro != null) {
        this.this$0.jdField_a_of_type_Xro.a();
      }
      xri.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Xrq = ((xrq)xri.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Xrq == null)
    {
      if (this.this$0.jdField_a_of_type_Xro != null) {
        this.this$0.jdField_a_of_type_Xro.a();
      }
      xri.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Xrq.b();
    xvv.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + xri.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Xrq.a(this.this$0);
    this.this$0.jdField_a_of_type_Xrq.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      xvv.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Xrq.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Xrq.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_Xrq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */