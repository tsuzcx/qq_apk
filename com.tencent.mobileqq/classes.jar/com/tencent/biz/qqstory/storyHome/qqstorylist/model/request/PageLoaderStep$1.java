package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;

class PageLoaderStep$1
  implements Runnable
{
  public void run()
  {
    SLog.b("Q.qqstory.home.qqstory_step", "finish step plz reference below dump");
    this.this$0.b();
    Object localObject = this.this$0;
    ((PageLoaderStep)localObject).jdField_a_of_type_Int = 2;
    int i = ((PageLoaderStep)localObject).a(this.a);
    if ((i == 0) && (this.this$0.b()))
    {
      localObject = this.this$0;
      ((PageLoaderStep)localObject).b -= 1;
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader.c();
      this.this$0.jdField_a_of_type_Int = 1;
      return;
    }
    if (i == 2)
    {
      this.this$0.a(this.a);
      StoryDispatcher.a().unRegisterSubscriber(this.this$0);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.this$0.jdField_a_of_type_Long;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("finish ");
    ((StringBuilder)localObject).append(this.this$0.a());
    ((StringBuilder)localObject).append(" step and cost time=");
    ((StringBuilder)localObject).append(l1 - l2);
    SLog.b("Q.qqstory.home.PageLoaderStep", ((StringBuilder)localObject).toString());
    SLog.a("Q.qqstory.home.PageLoaderStep", "unRegisterSubscriber %s", this.this$0);
    StoryDispatcher.a().unRegisterSubscriber(this.this$0);
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
    {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(this.this$0.a());
      return;
    }
    SLog.d("Q.qqstory.home.PageLoaderStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.PageLoaderStep.1
 * JD-Core Version:    0.7.0.1
 */