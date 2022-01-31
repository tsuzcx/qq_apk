package com.tencent.biz.qqstory.storyHome.memory.controller;

import java.util.List;
import utk;
import uwm;

public class ProfileFeedPresenter$2
  implements Runnable
{
  public ProfileFeedPresenter$2(utk paramutk, uwm paramuwm) {}
  
  public void run()
  {
    if (this.a.d)
    {
      this.this$0.b(this.a);
      return;
    }
    utk.a(this.this$0, this.a);
    utk.a(this.this$0).remove(utk.a());
    utk.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */