package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tribe.async.dispatch.Dispatcher;
import vli;
import wbc;
import xrf;
import xrs;
import xvv;

public class PageLoaderStep$1
  implements Runnable
{
  public void run()
  {
    xvv.b("Q.qqstory.home.qqstory_step", "finish step plz reference below dump");
    this.this$0.b();
    this.this$0.jdField_a_of_type_Int = 2;
    int i = this.this$0.a(this.a);
    if ((i == 0) && (this.this$0.b()))
    {
      xrf localxrf = this.this$0;
      localxrf.b -= 1;
      this.this$0.jdField_a_of_type_Wbc.c();
      this.this$0.jdField_a_of_type_Int = 1;
      return;
    }
    if (i == 2)
    {
      this.this$0.a(this.a);
      vli.a().unRegisterSubscriber(this.this$0);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.this$0.jdField_a_of_type_Long;
    xvv.b("Q.qqstory.home.PageLoaderStep", "finish " + this.this$0.a() + " step and cost time=" + (l1 - l2));
    xvv.a("Q.qqstory.home.PageLoaderStep", "unRegisterSubscriber %s", this.this$0);
    vli.a().unRegisterSubscriber(this.this$0);
    if (this.this$0.jdField_a_of_type_Xrs != null)
    {
      this.this$0.jdField_a_of_type_Xrs.a(this.this$0.a());
      return;
    }
    xvv.d("Q.qqstory.home.PageLoaderStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.PageLoaderStep.1
 * JD-Core Version:    0.7.0.1
 */