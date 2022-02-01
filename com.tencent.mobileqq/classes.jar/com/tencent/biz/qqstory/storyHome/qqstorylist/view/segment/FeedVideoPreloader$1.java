package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;

class FeedVideoPreloader$1
  extends SimpleJob<Object>
{
  FeedVideoPreloader$1(FeedVideoPreloader paramFeedVideoPreloader, String paramString, StoryVideoItem paramStoryVideoItem, List paramList)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    synchronized (FeedVideoPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$CurrentVid = new FeedVideoPreloader.CurrentVid(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.b();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader.1
 * JD-Core Version:    0.7.0.1
 */