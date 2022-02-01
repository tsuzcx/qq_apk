package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.storyHome.model.HomeFeedData;
import java.util.List;

class ProfileFeedPresenter$2
  implements Runnable
{
  ProfileFeedPresenter$2(ProfileFeedPresenter paramProfileFeedPresenter, HomeFeedData paramHomeFeedData) {}
  
  public void run()
  {
    if (this.a.d)
    {
      this.this$0.b(this.a);
      return;
    }
    ProfileFeedPresenter.a(this.this$0, this.a);
    ProfileFeedPresenter.a(this.this$0).remove(ProfileFeedPresenter.a());
    ProfileFeedPresenter.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */