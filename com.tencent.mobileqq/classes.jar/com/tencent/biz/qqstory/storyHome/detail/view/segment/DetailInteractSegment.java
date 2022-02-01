package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.BannerWebShareMode;
import com.tencent.biz.qqstory.newshare.mode.FeedDetailShareMode;
import com.tencent.biz.qqstory.newshare.mode.ShareGroupOneDayStoryShareMode;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.shareGroup.ShareGroupUtil;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DetailInteractSegment
  extends SegmentView<DetailFeedItem>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private DetailFeedItem a;
  private int b;
  private int c;
  private DetailEventCallback d;
  private BaseViewHolder e;
  private StoryShare f;
  
  public DetailInteractSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  private StoryVideoItem a(@NonNull List<String> paramList)
  {
    Iterator localIterator = this.a.a().iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (!StoryVideoItem.isFakeVid(localStoryVideoItem.mVid))
      {
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (localObject1.mCreateTime <= localStoryVideoItem.mCreateTime) {}
        }
        else
        {
          localObject2 = localStoryVideoItem;
        }
        paramList.add(localStoryVideoItem.mVid);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private void a(TextView paramTextView, long paramLong, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramTextView.setCompoundDrawables(null, null, null, null);
        paramTextView.setText(String.format(HardCodeUtil.a(2131901276), new Object[] { UIUtils.a(paramLong) }));
        paramTextView.setVisibility(0);
        paramTextView.setOnClickListener(null);
        return;
      }
      Drawable localDrawable = this.l.getResources().getDrawable(2130848258);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(HardCodeUtil.a(2131901277), new Object[] { UIUtils.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private View d(BaseViewHolder paramBaseViewHolder)
  {
    BannerFeedItem localBannerFeedItem = this.a.n();
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131449952);
    if (localBannerFeedItem.mViewTotalTime <= 0L)
    {
      SLog.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a(localTextView, 0L, 0);
    }
    else if (localBannerFeedItem.getOwner().isMe())
    {
      a(localTextView, localBannerFeedItem.mViewTotalTime, 1);
    }
    else
    {
      a(localTextView, 0L, 0);
    }
    return paramBaseViewHolder.a();
  }
  
  private View f(BaseViewHolder paramBaseViewHolder)
  {
    VideoListFeedItem localVideoListFeedItem = this.a.f();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    localObject = (TextView)paramBaseViewHolder.a(2131449952);
    if (localVideoListFeedItem.mViewTotalTime <= 0L)
    {
      SLog.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    else
    {
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
    return paramBaseViewHolder.a();
  }
  
  private View g(BaseViewHolder paramBaseViewHolder)
  {
    VideoListFeedItem localVideoListFeedItem = this.a.f();
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131449952);
    if (localVideoListFeedItem.mViewTotalTime <= 0L)
    {
      SLog.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a(localTextView, 0L, 0);
    }
    else if (localVideoListFeedItem.getOwner().isFriend())
    {
      a(localTextView, 0L, 0);
    }
    else if (localVideoListFeedItem.getOwner().isMe())
    {
      a(localTextView, localVideoListFeedItem.mViewTotalTime, 1);
    }
    else
    {
      a(localTextView, localVideoListFeedItem.mViewTotalTime, 2);
    }
    return paramBaseViewHolder.a();
  }
  
  private void j()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject2 = new ArrayList();
    Object localObject3 = a((List)localObject2);
    if (localObject3 == null)
    {
      SLog.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.f == null) {
      this.f = StoryShare.a((Activity)this.l);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.a.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.a.a());
    StoryShare localStoryShare = this.f;
    Object localObject1;
    if (this.a.a.getOwner().isMe()) {
      localObject1 = HardCodeUtil.a(2131901273);
    } else {
      localObject1 = this.l.getString(2131916565);
    }
    localObject3 = localStoryShare.a((String)localObject1).a(new DetailInteractSegment.1(this)).a(new FeedDetailShareMode((StoryVideoItem)localObject3, this.a.a.feedId, ((List)localObject2).size()));
    localObject2 = "1";
    if (bool1) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localObject3 = ((StoryShare)localObject3).a("vote", (String)localObject1);
    if (bool2) {
      localObject1 = localObject2;
    } else {
      localObject1 = "0";
    }
    ((StoryShare)localObject3).a("grade", (String)localObject1).b();
  }
  
  private void k()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null)
    {
      SLog.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.a.f().getOwner();
    if (this.f == null) {
      this.f = StoryShare.a((Activity)this.l);
    }
    VideoListFeedItem localVideoListFeedItem = this.a.f();
    if (localVideoListFeedItem == null) {
      return;
    }
    StoryShare localStoryShare = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901272));
    localStringBuilder.append(QQStoryConstant.a);
    localStringBuilder.append(HardCodeUtil.a(2131901274));
    localStoryShare.a(localStringBuilder.toString()).a(ShareGroupOneDayStoryShareMode.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.a.a().size())).a(new DetailInteractSegment.2(this, localVideoListFeedItem)).b();
    StoryReportor.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void m()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.f == null) {
      this.f = StoryShare.a((Activity)this.l);
    }
    this.f.a(this.l.getString(2131916565)).a(new DetailInteractSegment.3(this)).a(new BannerWebShareMode(this.a.n())).b();
  }
  
  public int a()
  {
    if ((this.m) && (this.a != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.a;
    if (paramViewGroup == null)
    {
      SLog.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramBaseViewHolder.a();
    }
    if ((!paramViewGroup.g()) && (!this.a.i()))
    {
      if (this.a.k()) {
        return f(paramBaseViewHolder);
      }
      if (this.a.m()) {
        return d(paramBaseViewHolder);
      }
      paramBaseViewHolder = new StringBuilder();
      paramBaseViewHolder.append("detail interact segment can't recognize this feed type. type=");
      paramBaseViewHolder.append(this.a.a.type);
      throw new IllegalStateException(paramBaseViewHolder.toString());
    }
    return g(paramBaseViewHolder);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.e = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628024, paramViewGroup, false));
    paramViewGroup = (TextView)this.e.a(2131449952);
    if (QQStoryContext.e()) {
      paramViewGroup.setTextColor(this.l.getResources().getColor(2131167385));
    }
    return this.e;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    StoryShare localStoryShare = this.f;
    if (localStoryShare != null) {
      localStoryShare.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.d = paramDetailEventCallback;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, int paramInt1, int paramInt2)
  {
    this.a = paramDetailFeedItem;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public String b()
  {
    return "DetailInteractSegment";
  }
  
  public void br_()
  {
    if (((StoryDetailListView)w()).b())
    {
      this.m = true;
      return;
    }
    this.m = false;
  }
  
  public int d()
  {
    BaseViewHolder localBaseViewHolder = this.e;
    if (localBaseViewHolder == null) {
      return 0;
    }
    return localBaseViewHolder.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject = "";
    switch (i)
    {
    default: 
      break;
    case 2131449952: 
      QQStoryWatcherListActivity.a((Activity)this.l, this.a.a.feedId, this.b);
      i = StoryReportor.a(this.a.a);
      if (this.a.a.getOwner().isMe()) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      StoryReportor.a("home_page", "clk_view_detail", i, 0, new String[] { localObject, StoryReportor.b(this.b), "", this.a.a.feedId });
      break;
    case 2131445753: 
      if (!UIUtils.d())
      {
        if ((!this.a.g()) && (!this.a.i()))
        {
          if (this.a.k()) {
            k();
          } else if (this.a.m()) {
            m();
          }
        }
        else {
          j();
        }
        if ((this.a.a.getOwner() instanceof ShareGroupItem)) {
          localObject = this.a.a.getOwner().getUnionId();
        }
        StoryReportor.a("home_page", "clk_share", StoryReportor.a(this.a.a), 0, new String[] { String.valueOf(StoryReportor.b(this.a.a)), StoryReportor.b(this.b), this.a.a.feedId, localObject });
      }
      break;
    case 2131437178: 
      if (this.a.k())
      {
        localObject = (ShareGroupItem)this.a.f().getOwner();
        if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (ShareGroupUtil.a((ShareGroupItem)localObject)))
        {
          QQToast.makeText(this.l, 1, HardCodeUtil.a(2131901270), 1).show();
          break;
        }
      }
      else if (ShareGroupUtil.b())
      {
        i = this.c;
        if ((i == 63) || (i == 64))
        {
          QQToast.makeText(this.l, 1, HardCodeUtil.a(2131901269), 1).show();
          break;
        }
      }
      localObject = this.d;
      if (localObject != null) {
        ((DetailEventCallback)localObject).bp_();
      }
      break;
    case 2131431033: 
      if (this.a.k())
      {
        localObject = (ShareGroupItem)this.a.f().getOwner();
        if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (ShareGroupUtil.a((ShareGroupItem)localObject)))
        {
          QQToast.makeText(this.l, 1, HardCodeUtil.a(2131901275), 1).show();
          break;
        }
      }
      else if (ShareGroupUtil.b())
      {
        i = this.c;
        if ((i == 63) || (i == 64))
        {
          QQToast.makeText(this.l, 1, HardCodeUtil.a(2131901271), 1).show();
          break;
        }
      }
      localObject = this.d;
      if (localObject != null) {
        ((DetailEventCallback)localObject).g();
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment
 * JD-Core Version:    0.7.0.1
 */