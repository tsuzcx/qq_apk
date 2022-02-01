package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import ypx;
import yqd;
import yqf;
import yuk;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(ypx paramypx) {}
  
  public void run()
  {
    if (ypx.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Yqd != null) {
        this.this$0.jdField_a_of_type_Yqd.a();
      }
      ypx.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Yqf = ((yqf)ypx.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Yqf == null)
    {
      if (this.this$0.jdField_a_of_type_Yqd != null) {
        this.this$0.jdField_a_of_type_Yqd.a();
      }
      ypx.a(this.this$0, 2);
      this.this$0.d();
      return;
    }
    this.this$0.jdField_a_of_type_Yqf.b();
    yuk.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + ypx.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Yqf.a(this.this$0);
    this.this$0.jdField_a_of_type_Yqf.a(this.this$0);
    if (this.this$0.jdField_a_of_type_JavaLangObject == null) {
      yuk.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Yqf.a() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Yqf.a(this.this$0.jdField_a_of_type_JavaLangObject);
    this.this$0.jdField_a_of_type_Yqf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */