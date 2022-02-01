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
  private int b = -1;
  private BaseViewHolder c;
  
  protected FeedSegment$VideoListTouchEventHandler(FeedSegment paramFeedSegment) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.b == -1)
    {
      AssertUtils.fail(HardCodeUtil.a(2131902482), new Object[0]);
      return;
    }
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.a.b.i().get(this.b);
    if ((localStoryHomeFeed.g() != null) && (!TextUtils.isEmpty(localStoryHomeFeed.g().feedId)))
    {
      this.a.d.put(localStoryHomeFeed.g().feedId, Integer.valueOf(paramInt2));
      SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localStoryHomeFeed.g().feedId, Integer.valueOf(paramInt2));
      return;
    }
    AssertUtils.fail(HardCodeUtil.a(2131902502), new Object[0]);
    SLog.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    this.b = paramInt;
    this.c = paramBaseViewHolder;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.b == -1)
    {
      AssertUtils.fail(HardCodeUtil.a(2131902490), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        VideoListHomeFeed localVideoListHomeFeed = (VideoListHomeFeed)this.a.b.i().get(this.b);
        int i = StoryReportor.a(localVideoListHomeFeed.i());
        paramBoolean = localVideoListHomeFeed.i().getOwner().isMe();
        localObject = "1";
        String str;
        if (paramBoolean) {
          str = "1";
        } else {
          str = "2";
        }
        if (this.a.a == 10)
        {
          StoryReportor.a("home_page", "left_load", i, 0, new String[] { str, localObject, "", localVideoListHomeFeed.i().feedId });
          paramBoolean = this.a.b.a(localVideoListHomeFeed);
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
  
  public void bx_()
  {
    if (this.b == -1) {
      AssertUtils.fail(HardCodeUtil.a(2131902501), new Object[0]);
    }
  }
  
  public void by_() {}
  
  public void e()
  {
    if (this.b == -1)
    {
      AssertUtils.fail(HardCodeUtil.a(2131902480), new Object[0]);
      return;
    }
    if (this.a.a != 12)
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.a.b.i().get(this.b);
      FeedSegment.b(this.a, localStoryHomeFeed);
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (this.b == -1)
    {
      AssertUtils.fail(HardCodeUtil.a(2131902496), new Object[0]);
      return;
    }
    if (!FeedSegment.j(this.a)) {
      return;
    }
    Object localObject1 = (StoryHomeHorizontalListView)this.c.a(2131442683);
    StoryHomeFeed localStoryHomeFeed;
    if (this.a.b.i().size() > this.b) {
      localStoryHomeFeed = (StoryHomeFeed)this.a.b.i().get(this.b);
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
      FeedSegment.a(this.a, (List)localObject2, i);
      FeedSegment.b(this.a, (List)localObject2, i);
    }
    Object localObject2 = (FeedItemThumbAdapter)this.c.a("general_adapter");
    if (paramInt == 4097)
    {
      paramInt = FeedSegment.k(this.a);
      this.a.c(paramInt);
      if ((localObject1 != null) && (localObject2 != null) && (localStoryHomeFeed != null))
      {
        i = ((StoryHomeHorizontalListView)localObject1).getFirstVisiblePosition();
        paramInt = i;
        if (i < 0) {
          paramInt = 0;
        }
        if (!((FeedItemThumbAdapter)localObject2).b.isEmpty())
        {
          localObject1 = FeedSegment.l(this.a).g;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("1_");
          localStringBuilder.append(localStoryHomeFeed.g().feedId);
          ((Map)localObject1).put(localStringBuilder.toString(), ((StoryVideoItem)((FeedItemThumbAdapter)localObject2).b.get(paramInt)).mVid);
        }
      }
    }
    else if ((FeedSegment.m(this.a) != null) && (FeedSegment.m(this.a).getAutoPlayState() == 1))
    {
      FeedSegment.m(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.VideoListTouchEventHandler
 * JD-Core Version:    0.7.0.1
 */