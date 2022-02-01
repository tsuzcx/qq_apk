package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tribe.async.dispatch.Dispatcher;
import wad;
import wpx;
import yga;
import ygn;
import ykq;

public class PageLoaderStep$1
  implements Runnable
{
  public void run()
  {
    ykq.b("Q.qqstory.home.qqstory_step", "finish step plz reference below dump");
    this.this$0.b();
    this.this$0.jdField_a_of_type_Int = 2;
    int i = this.this$0.a(this.a);
    if ((i == 0) && (this.this$0.b()))
    {
      yga localyga = this.this$0;
      localyga.b -= 1;
      this.this$0.jdField_a_of_type_Wpx.c();
      this.this$0.jdField_a_of_type_Int = 1;
      return;
    }
    if (i == 2)
    {
      this.this$0.a(this.a);
      wad.a().unRegisterSubscriber(this.this$0);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.this$0.jdField_a_of_type_Long;
    ykq.b("Q.qqstory.home.PageLoaderStep", "finish " + this.this$0.a() + " step and cost time=" + (l1 - l2));
    ykq.a("Q.qqstory.home.PageLoaderStep", "unRegisterSubscriber %s", this.this$0);
    wad.a().unRegisterSubscriber(this.this$0);
    if (this.this$0.jdField_a_of_type_Ygn != null)
    {
      this.this$0.jdField_a_of_type_Ygn.a(this.this$0.a());
      return;
    }
    ykq.d("Q.qqstory.home.PageLoaderStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.PageLoaderStep.1
 * JD-Core Version:    0.7.0.1
 */