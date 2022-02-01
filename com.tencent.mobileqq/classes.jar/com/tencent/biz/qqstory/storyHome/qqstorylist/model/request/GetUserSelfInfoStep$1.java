package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;

class GetUserSelfInfoStep$1
  implements Runnable
{
  GetUserSelfInfoStep$1(GetUserSelfInfoStep paramGetUserSelfInfoStep, GetUserSelfInfoStep.Response paramResponse) {}
  
  public void run()
  {
    SLog.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self info: %s", this.a);
    Object localObject = GetUserSelfInfoStep.a(this.this$0).a();
    int i = this.a.a;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    ((MyStorys)localObject).h = bool;
    GetUserSelfInfoStep.a(this.this$0).a().i = this.a.e;
    GetUserSelfInfoStep.a(this.this$0).a().j = this.a.f;
    GetUserSelfInfoStep.a(this.this$0).a().k = this.a.g;
    GetUserSelfInfoStep.a(this.this$0).a().l = this.a.h;
    GetUserSelfInfoStep.a(this.this$0).a().m = this.a.i;
    GetUserSelfInfoStep.a(this.this$0).a().n = this.a.b;
    localObject = (StoryConfigManager)SuperManager.a(10);
    ((StoryConfigManager)localObject).d("qqstory_my_fans_count", Integer.valueOf(this.a.e));
    ((StoryConfigManager)localObject).d("qqstory_i_am_vip", Integer.valueOf(this.a.a));
    ((StoryConfigManager)localObject).d("qqstory_my_vidoe_count", Integer.valueOf(this.a.f));
    ((StoryConfigManager)localObject).d("qqstory_my_visiter_count", Integer.valueOf(this.a.g));
    ((StoryConfigManager)localObject).d("qqstory_my_newest_video_cover", this.a.h);
    ((StoryConfigManager)localObject).d("qqstory_my_newest_video_vid", this.a.i);
    QQStoryContext.a().a(this.a.b);
    this.this$0.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1
 * JD-Core Version:    0.7.0.1
 */