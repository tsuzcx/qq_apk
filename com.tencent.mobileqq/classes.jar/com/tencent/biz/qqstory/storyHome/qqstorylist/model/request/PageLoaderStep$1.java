package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tribe.async.dispatch.Dispatcher;
import umc;
import vcf;
import wso;
import wtb;
import wxe;

public class PageLoaderStep$1
  implements Runnable
{
  public void run()
  {
    wxe.b("Q.qqstory.home.qqstory_step", "finish step plz reference below dump");
    this.this$0.b();
    this.this$0.jdField_a_of_type_Int = 2;
    int i = this.this$0.a(this.a);
    if ((i == 0) && (this.this$0.b()))
    {
      wso localwso = this.this$0;
      localwso.b -= 1;
      this.this$0.jdField_a_of_type_Vcf.c();
      this.this$0.jdField_a_of_type_Int = 1;
      return;
    }
    if (i == 2)
    {
      this.this$0.a(this.a);
      umc.a().unRegisterSubscriber(this.this$0);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.this$0.jdField_a_of_type_Long;
    wxe.b("Q.qqstory.home.PageLoaderStep", "finish " + this.this$0.a() + " step and cost time=" + (l1 - l2));
    wxe.a("Q.qqstory.home.PageLoaderStep", "unRegisterSubscriber %s", this.this$0);
    umc.a().unRegisterSubscriber(this.this$0);
    if (this.this$0.jdField_a_of_type_Wtb != null)
    {
      this.this$0.jdField_a_of_type_Wtb.a(this.this$0.a());
      return;
    }
    wxe.d("Q.qqstory.home.PageLoaderStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.PageLoaderStep.1
 * JD-Core Version:    0.7.0.1
 */