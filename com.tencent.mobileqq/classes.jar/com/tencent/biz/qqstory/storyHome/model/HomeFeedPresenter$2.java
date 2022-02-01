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
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      HomeFeedPresenter.a(this.this$0).clear();
    }
    HomeFeedPresenter.a(this.this$0).addAll(this.a.b);
    this.this$0.a(HomeFeedPresenter.a(this.this$0));
    Collections.sort(HomeFeedPresenter.a(this.this$0), GeneralHomeFeed.a);
    HomeFeedPresenter.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = HomeFeedPresenter.a(this.this$0);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(HomeFeedPresenter.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (HomeFeedPresenter.a(this.this$0) != null) {
      HomeFeedPresenter.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */