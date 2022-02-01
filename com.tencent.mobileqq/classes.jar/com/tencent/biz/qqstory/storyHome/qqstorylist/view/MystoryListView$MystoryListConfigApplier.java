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
    if ((paramSegmentList instanceof MystoryListView))
    {
      paramSegmentList = (MystoryListView)paramSegmentList;
      Activity localActivity = paramSegmentList.b;
      Object localObject = paramSegmentList.a;
      boolean bool = paramSegmentList.g();
      paramSegmentList.a(StoryApi.a(localActivity, 5));
      paramSegmentList.a(new NewMyStorySegment(localActivity, (IMyStoryListView)localObject));
      paramSegmentList.a(new NewDividerSegment(localActivity));
      paramSegmentList.a(new LocalVideoPushSegment(localActivity));
      localObject = new FeedSegment(localActivity, localActivity, 10, (IMyStoryListView)localObject, bool);
      paramSegmentList.a((SegmentView)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131904929));
      localStringBuilder.append(QQStoryConstant.a);
      localStringBuilder.append("\n拍摄一段视频，分享眼前的世界");
      paramSegmentList.a(new PlaceholderSegment(localActivity, "FeedSegment", localStringBuilder.toString(), 2130848389, 2130848390));
      ((FeedSegment)localObject).c(true);
      return;
    }
    throw new IllegalArgumentException("arg should match type!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.MystoryListConfigApplier
 * JD-Core Version:    0.7.0.1
 */