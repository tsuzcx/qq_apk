package com.tencent.biz.qqstory.newshare;

import com.tencent.biz.qqstory.newshare.callback.OnShareListener;
import com.tencent.biz.qqstory.newshare.callback.StoryShareCallback;
import com.tencent.biz.qqstory.newshare.model.ShareData;

class StoryShare$1
  implements StoryShareCallback
{
  StoryShare$1(StoryShare paramStoryShare) {}
  
  public void a(ShareData paramShareData)
  {
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).b(paramShareData.a);
    }
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).d();
    }
  }
  
  public void b(ShareData paramShareData)
  {
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).c(paramShareData.a);
    }
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).d();
    }
  }
  
  public void c(ShareData paramShareData)
  {
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).d(paramShareData.a);
    }
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.StoryShare.1
 * JD-Core Version:    0.7.0.1
 */