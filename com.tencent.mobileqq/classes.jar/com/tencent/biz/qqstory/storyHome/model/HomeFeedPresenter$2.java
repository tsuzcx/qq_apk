package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;

class HomeFeedPresenter$2
  implements Runnable
{
  HomeFeedPresenter$2(HomeFeedPresenter paramHomeFeedPresenter, HomeFeedData paramHomeFeedData) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.g.isSuccess())) {
      HomeFeedPresenter.b(this.this$0).clear();
    }
    HomeFeedPresenter.b(this.this$0).addAll(this.a.f);
    HomeFeedPresenter localHomeFeedPresenter = this.this$0;
    localHomeFeedPresenter.a(HomeFeedPresenter.b(localHomeFeedPresenter));
    Collections.sort(HomeFeedPresenter.b(this.this$0), GeneralHomeFeed.l);
    HomeFeedPresenter.a(this.this$0, this.a.a);
    this.a.f = HomeFeedPresenter.b(this.this$0);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(HomeFeedPresenter.b(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (HomeFeedPresenter.c(this.this$0) != null) {
      HomeFeedPresenter.c(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */