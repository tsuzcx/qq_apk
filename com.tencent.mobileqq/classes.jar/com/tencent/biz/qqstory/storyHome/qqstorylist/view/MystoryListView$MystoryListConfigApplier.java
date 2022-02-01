package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.app.Activity;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewDividerSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.PlaceholderSegment;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentList.SegmentListConfigApplier;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.HardCodeUtil;

public class MystoryListView$MystoryListConfigApplier
  implements SegmentList.SegmentListConfigApplier
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(StoryApi.a(localActivity, 5));
    paramSegmentList.a(new NewMyStorySegment(localActivity, (IMyStoryListView)localObject));
    paramSegmentList.a(new NewDividerSegment(localActivity));
    paramSegmentList.a(new LocalVideoPushSegment(localActivity));
    localObject = new FeedSegment(localActivity, localActivity, 10, (IMyStoryListView)localObject, bool);
    paramSegmentList.a((SegmentView)localObject);
    paramSegmentList.a(new PlaceholderSegment(localActivity, "FeedSegment", HardCodeUtil.a(2131707069) + QQStoryConstant.a + "\n拍摄一段视频，分享眼前的世界", 2130846959, 2130846960));
    ((FeedSegment)localObject).e_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.MystoryListConfigApplier
 * JD-Core Version:    0.7.0.1
 */