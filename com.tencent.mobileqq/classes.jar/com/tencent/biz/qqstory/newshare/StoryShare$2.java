package com.tencent.biz.qqstory.newshare;

import android.app.Activity;
import com.tencent.biz.qqstory.newshare.callback.OnPrepareShareListener;
import com.tencent.biz.qqstory.newshare.callback.OnShareListener;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.ui.ShareUI;
import com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils;

class StoryShare$2
  implements OnPrepareShareListener
{
  StoryShare$2(StoryShare paramStoryShare) {}
  
  public void a(ShareData paramShareData)
  {
    StoryShare.b(this.a).c();
    Activity localActivity = StoryShare.b(this.a).g();
    if (localActivity == null)
    {
      c(paramShareData);
      return;
    }
    StoryBasicShareUtils.a(localActivity, paramShareData, StoryShare.c(this.a));
  }
  
  public void b(ShareData paramShareData)
  {
    StoryShare.b(this.a).c();
    if (StoryShare.a(this.a) != null)
    {
      StoryShare.a(this.a).c(paramShareData.c);
      StoryShare.a(this.a).d();
    }
  }
  
  public void c(ShareData paramShareData)
  {
    StoryShare.b(this.a).c();
    if (StoryShare.a(this.a) != null)
    {
      StoryShare.a(this.a).d(paramShareData.c);
      StoryShare.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.StoryShare.2
 * JD-Core Version:    0.7.0.1
 */