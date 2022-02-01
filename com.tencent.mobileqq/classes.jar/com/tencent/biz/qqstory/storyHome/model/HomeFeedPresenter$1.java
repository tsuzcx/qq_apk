package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicBoolean;

class HomeFeedPresenter$1
  implements LbsManager.LbsUpdateListener
{
  HomeFeedPresenter$1(HomeFeedPresenter paramHomeFeedPresenter, LbsManager paramLbsManager) {}
  
  public void a(boolean paramBoolean, @Nullable BasicLocation paramBasicLocation)
  {
    SLog.e("Q.qqstory.home.data.HomeFeedPresenter", "lbs update %b %s", new Object[] { Boolean.valueOf(paramBoolean), paramBasicLocation });
    this.a.b(this);
    if (this.b.c.get())
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "is destroy");
      return;
    }
    HomeFeedPresenter.a(this.b).i = paramBasicLocation;
    HomeFeedPresenter.a(this.b).a(null, 0);
    ((FeedManager)SuperManager.a(11)).i = paramBasicLocation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.1
 * JD-Core Version:    0.7.0.1
 */