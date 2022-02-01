package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.FeedItemThumbAdapter;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.OnOverScrollRightListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.OnScrollChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeedSegment$VideoListTouchEventHandler
  implements StoryHomeHorizontalListView.OnOverScrollRightListener, StoryHomeHorizontalListView.OnScrollChangeListener, LoadingMoreHelper.OnLoadMoreListener, HorizontalListView.OnScrollStateChangedListener
{
  private int jdField_a_of_type_Int = -1;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  
  protected FeedSegment$VideoListTouchEventHandler(FeedSegment paramFeedSegment) {}
  
  public void P_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      AssertUtils.a(HardCodeUtil.a(2131704483), new Object[0]);
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_Int == 12) {
      return;
    }
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(this.jdField_a_of_type_Int);
    FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, localStoryHomeFeed);
  }
  
  public void Q_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      AssertUtils.a(HardCodeUtil.a(2131704505), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      AssertUtils.a(HardCodeUtil.a(2131704485), new Object[0]);
      return;
    }
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(this.jdField_a_of_type_Int);
    if ((localStoryHomeFeed.a() != null) && (!TextUtils.isEmpty(localStoryHomeFeed.a().feedId)))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_JavaUtilMap.put(localStoryHomeFeed.a().feedId, Integer.valueOf(paramInt2));
      SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localStoryHomeFeed.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    AssertUtils.a(HardCodeUtil.a(2131704506), new Object[0]);
    SLog.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = paramBaseViewHolder;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      AssertUtils.a(HardCodeUtil.a(2131704494), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        VideoListHomeFeed localVideoListHomeFeed = (VideoListHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(this.jdField_a_of_type_Int);
        int i = StoryReportor.a(localVideoListHomeFeed.a());
        if (localVideoListHomeFeed.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            StoryReportor.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localVideoListHomeFeed.a().feedId });
            return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a(localVideoListHomeFeed);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        SLog.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        AssertUtils.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      AssertUtils.a(HardCodeUtil.a(2131704500), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (FeedSegment.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131374981);
        StoryHomeFeed localStoryHomeFeed;
        Object localObject;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().size() > this.jdField_a_of_type_Int)
        {
          localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(this.jdField_a_of_type_Int);
          if ((localStoryHomeFeed != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            SLog.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localStoryHomeFeed);
            FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, (List)localObject, i);
            FeedSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, (List)localObject, i);
          }
          localObject = (FeedItemThumbAdapter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localStoryHomeFeed == null)) {
            break;
          }
          paramInt = localStoryHomeHorizontalListView.getFirstVisiblePosition();
          if (paramInt >= 0) {
            break label361;
          }
          paramInt = j;
        }
        for (;;)
        {
          if (((FeedItemThumbAdapter)localObject).a.isEmpty()) {
            break label362;
          }
          FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment).jdField_a_of_type_JavaUtilMap.put("1_" + localStoryHomeFeed.a().feedId, ((StoryVideoItem)((FeedItemThumbAdapter)localObject).a.get(paramInt)).mVid);
          return;
          localStoryHomeFeed = null;
          break label93;
          if ((FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment) == null) || (FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment).b() != 1)) {
            break;
          }
          FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.VideoListTouchEventHandler
 * JD-Core Version:    0.7.0.1
 */