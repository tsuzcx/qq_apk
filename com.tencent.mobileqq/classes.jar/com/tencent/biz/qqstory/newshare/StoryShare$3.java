package com.tencent.biz.qqstory.newshare;

import com.tencent.biz.qqstory.newshare.callback.OnShareListener;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;
import com.tencent.biz.qqstory.newshare.ui.OnShareUIListener;

class StoryShare$3
  implements OnShareUIListener
{
  StoryShare$3(StoryShare paramStoryShare) {}
  
  public void b(int paramInt)
  {
    StoryShare.d(this.a).c(paramInt);
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).a(paramInt);
    }
  }
  
  public void c()
  {
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).b();
    }
  }
  
  public void d()
  {
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).c();
    }
  }
  
  public void e()
  {
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).d(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.StoryShare.3
 * JD-Core Version:    0.7.0.1
 */