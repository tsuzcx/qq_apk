package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.model.TagManager.FeedTagListUpdateEvent;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest.FeedTagInfoList;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class StoryDetailPresenter$GetTagInfoListReceiver
  extends QQUIEventReceiver<StoryDetailPresenter, TagManager.FeedTagListUpdateEvent>
{
  public StoryDetailPresenter$GetTagInfoListReceiver(@NonNull StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull TagManager.FeedTagListUpdateEvent paramFeedTagListUpdateEvent)
  {
    if (StoryDetailPresenter.a(paramStoryDetailPresenter) == null) {
      SLog.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramFeedTagListUpdateEvent.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramFeedTagListUpdateEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      SLog.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramFeedTagListUpdateEvent.toString());
      paramFeedTagListUpdateEvent = (GetFeedTagInfoListRequest.FeedTagInfoList)paramFeedTagListUpdateEvent.jdField_a_of_type_JavaUtilMap.get(StoryDetailPresenter.a(paramStoryDetailPresenter));
    } while (paramFeedTagListUpdateEvent == null);
    paramFeedTagListUpdateEvent = ((TagManager)SuperManager.a(27)).a(StoryDetailPresenter.a(paramStoryDetailPresenter).a(), paramFeedTagListUpdateEvent.a);
    StoryDetailPresenter.a(paramStoryDetailPresenter).b(paramFeedTagListUpdateEvent, true);
    paramStoryDetailPresenter.a();
  }
  
  public Class acceptEventClass()
  {
    return TagManager.FeedTagListUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.GetTagInfoListReceiver
 * JD-Core Version:    0.7.0.1
 */