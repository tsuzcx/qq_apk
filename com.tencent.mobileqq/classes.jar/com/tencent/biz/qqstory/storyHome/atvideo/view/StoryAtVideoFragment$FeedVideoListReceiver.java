package com.tencent.biz.qqstory.storyHome.atvideo.view;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class StoryAtVideoFragment$FeedVideoListReceiver
  extends UIBaseEventReceiver<StoryAtVideoFragment, VideoListPageLoader.GetVideoListEvent>
{
  StoryAtVideoFragment$FeedVideoListReceiver(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if ((!paramGetVideoListEvent.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null))
    {
      SLog.b(this.TAG, "ignore this comment list event. %s.", paramGetVideoListEvent.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.c())
    {
      SLog.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramGetVideoListEvent.toString() });
      return;
    }
    SLog.a(this.TAG, "receive comment list event. %s.", paramGetVideoListEvent.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(paramGetVideoListEvent.jdField_a_of_type_JavaUtilList, paramGetVideoListEvent.c);
    paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().updateVideoInfo(paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem);
  }
  
  public Class acceptEventClass()
  {
    return VideoListPageLoader.GetVideoListEvent.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment.FeedVideoListReceiver
 * JD-Core Version:    0.7.0.1
 */