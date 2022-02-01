package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryDetailPresenter$LikeListReceiver
  extends UIBaseEventReceiver<StoryDetailPresenter, DetailLikeListLoader.GetLikeListEvent>
{
  StoryDetailPresenter$LikeListReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent)
  {
    if ((paramGetLikeListEvent.jdField_a_of_type_Boolean) && (paramGetLikeListEvent.jdField_a_of_type_JavaLangString.equals(StoryDetailPresenter.a(paramStoryDetailPresenter))) && (!paramGetLikeListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (StoryDetailPresenter.a(paramStoryDetailPresenter) != null))
    {
      SLog.a(this.TAG, "receive like list event. %s.", paramGetLikeListEvent.toString());
      boolean bool2 = StoryDetailPresenter.a(paramStoryDetailPresenter);
      boolean bool1;
      if (paramGetLikeListEvent.jdField_a_of_type_Int == 0) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      StoryDetailPresenter.a(paramStoryDetailPresenter).b(bool1, paramGetLikeListEvent.b);
      StoryDetailPresenter.a(paramStoryDetailPresenter).b(paramGetLikeListEvent.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 == bool1) {
        paramStoryDetailPresenter.a();
      }
      return;
    }
    SLog.b(this.TAG, "ignore this like list event. %s.", paramGetLikeListEvent.toString());
  }
  
  public Class acceptEventClass()
  {
    return DetailLikeListLoader.GetLikeListEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.LikeListReceiver
 * JD-Core Version:    0.7.0.1
 */