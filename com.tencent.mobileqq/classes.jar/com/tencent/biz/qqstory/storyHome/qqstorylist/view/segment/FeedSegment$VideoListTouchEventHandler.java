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
  
  public void N_()
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      AssertUtils.fail(HardCodeUtil.a(2131704573), new Object[0]);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_Int != 12)
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(this.jdField_a_of_type_Int);
      FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, localStoryHomeFeed);
    }
  }
  
  public void O_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      AssertUtils.fail(HardCodeUtil.a(2131704595), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      AssertUtils.fail(HardCodeUtil.a(2131704575), new Object[0]);
      return;
    }
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(this.jdField_a_of_type_Int);
    if ((localStoryHomeFeed.a() != null) && (!TextUtils.isEmpty(localStoryHomeFeed.a().feedId)))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_JavaUtilMap.put(localStoryHomeFeed.a().feedId, Integer.valueOf(paramInt2));
      SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localStoryHomeFeed.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    AssertUtils.fail(HardCodeUtil.a(2131704596), new Object[0]);
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
      AssertUtils.fail(HardCodeUtil.a(2131704584), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        VideoListHomeFeed localVideoListHomeFeed = (VideoListHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(this.jdField_a_of_type_Int);
        int i = StoryReportor.a(localVideoListHomeFeed.a());
        paramBoolean = localVideoListHomeFeed.a().getOwner().isMe();
        localObject = "1";
        String str;
        if (paramBoolean) {
          str = "1";
        } else {
          str = "2";
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_Int == 10)
        {
          StoryReportor.a("home_page", "left_load", i, 0, new String[] { str, localObject, "", localVideoListHomeFeed.a().feedId });
          paramBoolean = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a(localVideoListHomeFeed);
          return paramBoolean;
        }
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onLoadMore occur error:");
        ((StringBuilder)localObject).append(localException);
        SLog.e("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject).toString());
        AssertUtils.fail(localException.getMessage(), new Object[0]);
        return false;
      }
      Object localObject = "3";
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      AssertUtils.fail(HardCodeUtil.a(2131704590), new Object[0]);
      return;
    }
    if (!FeedSegment.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment)) {
      return;
    }
    Object localObject1 = (StoryHomeHorizontalListView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131374513);
    StoryHomeFeed localStoryHomeFeed;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().size() > this.jdField_a_of_type_Int) {
      localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(this.jdField_a_of_type_Int);
    } else {
      localStoryHomeFeed = null;
    }
    int i;
    if ((localStoryHomeFeed != null) && ((paramInt == 4097) || (paramInt == 4098)))
    {
      int j = ((StoryHomeHorizontalListView)localObject1).getFirstVisiblePosition();
      i = j;
      if (j < 0) {
        i = 0;
      }
      SLog.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
      localObject2 = new ArrayList();
      ((List)localObject2).add(localStoryHomeFeed);
      FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, (List)localObject2, i);
      FeedSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, (List)localObject2, i);
    }
    Object localObject2 = (FeedItemThumbAdapter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a("general_adapter");
    if (paramInt == 4097)
    {
      paramInt = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.b(paramInt);
      if ((localObject1 != null) && (localObject2 != null) && (localStoryHomeFeed != null))
      {
        i = ((StoryHomeHorizontalListView)localObject1).getFirstVisiblePosition();
        paramInt = i;
        if (i < 0) {
          paramInt = 0;
        }
        if (!((FeedItemThumbAdapter)localObject2).a.isEmpty())
        {
          localObject1 = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment).jdField_a_of_type_JavaUtilMap;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("1_");
          localStringBuilder.append(localStoryHomeFeed.a().feedId);
          ((Map)localObject1).put(localStringBuilder.toString(), ((StoryVideoItem)((FeedItemThumbAdapter)localObject2).a.get(paramInt)).mVid);
        }
      }
    }
    else if ((FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment) != null) && (FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment).b() == 1))
    {
      FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.VideoListTouchEventHandler
 * JD-Core Version:    0.7.0.1
 */