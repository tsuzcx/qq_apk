package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.support.logging.SLog;

public class StoryDetailPresenter$DetailFeedPushObserver
  extends QQStoryObserver
{
  private StoryDetailPresenter.DetailFeedPushObserver.OnPushCallback a;
  public String a;
  
  public StoryDetailPresenter$DetailFeedPushObserver(String paramString, @NonNull StoryDetailPresenter.DetailFeedPushObserver.OnPushCallback paramOnPushCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver$OnPushCallback = paramOnPushCallback;
  }
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPushMsg.d))
    {
      SLog.a("DetailFeedPushObserver", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, this.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      SLog.a("DetailFeedPushObserver", "Receive new comment PUSH: %s, refreshing comments......", paramStoryPushMsg);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver$OnPushCallback.a(1);
      return;
    }
    if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 16) || (paramStoryPushMsg.a == 18))
    {
      SLog.a("DetailFeedPushObserver", "Receive new like PUSH: %s, refreshing likes......", paramStoryPushMsg);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver$OnPushCallback.a(2);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver$OnPushCallback.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.DetailFeedPushObserver
 * JD-Core Version:    0.7.0.1
 */