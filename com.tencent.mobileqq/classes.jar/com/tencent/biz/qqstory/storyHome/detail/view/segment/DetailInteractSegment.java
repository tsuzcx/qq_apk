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
  private int jdField_a_of_type_Int;
  private StoryShare jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
  private DetailEventCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback;
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  private int b;
  
  public DetailInteractSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(BaseViewHolder paramBaseViewHolder)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131380962);
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
  
  private StoryVideoItem a(@NonNull List<String> paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().iterator();
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
        paramTextView.setText(String.format(HardCodeUtil.a(2131703316), new Object[] { UIUtils.a(paramLong) }));
        paramTextView.setVisibility(0);
        paramTextView.setOnClickListener(null);
        return;
      }
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846706);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(HardCodeUtil.a(2131703317), new Object[] { UIUtils.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private View b(BaseViewHolder paramBaseViewHolder)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    localObject = (TextView)paramBaseViewHolder.a(2131380962);
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
  
  private View c(BaseViewHolder paramBaseViewHolder)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131380962);
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
  
  private void f()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject2 = new ArrayList();
    Object localObject3 = a((List)localObject2);
    if (localObject3 == null)
    {
      SLog.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
    StoryShare localStoryShare = this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe()) {
      localObject1 = HardCodeUtil.a(2131703313);
    } else {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131719029);
    }
    localObject3 = localStoryShare.a((String)localObject1).a(new DetailInteractSegment.1(this)).a(new FeedDetailShareMode((StoryVideoItem)localObject3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, ((List)localObject2).size()));
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
  
  private void h()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null)
    {
      SLog.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    if (localVideoListFeedItem == null) {
      return;
    }
    StoryShare localStoryShare = this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131703312));
    localStringBuilder.append(QQStoryConstant.a);
    localStringBuilder.append(HardCodeUtil.a(2131703314));
    localStoryShare.a(localStringBuilder.toString()).a(ShareGroupOneDayStoryShareMode.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size())).a(new DetailInteractSegment.2(this, localVideoListFeedItem)).b();
    StoryReportor.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719029)).a(new DetailInteractSegment.3(this)).a(new BannerWebShareMode(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a())).b();
  }
  
  public void P_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
    if (paramViewGroup == null)
    {
      SLog.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramBaseViewHolder.a();
    }
    if ((!paramViewGroup.d()) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f()) {
        return b(paramBaseViewHolder);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.g()) {
        return a(paramBaseViewHolder);
      }
      paramBaseViewHolder = new StringBuilder();
      paramBaseViewHolder.append("detail interact segment can't recognize this feed type. type=");
      paramBaseViewHolder.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.type);
      throw new IllegalStateException(paramBaseViewHolder.toString());
    }
    return c(paramBaseViewHolder);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561645, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131380962);
    if (QQStoryContext.a()) {
      paramViewGroup.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    StoryShare localStoryShare = this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
    if (localStoryShare != null) {
      localStoryShare.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback = paramDetailEventCallback;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    BaseViewHolder localBaseViewHolder = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
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
    case 2131380962: 
      QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, this.jdField_a_of_type_Int);
      i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe()) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      StoryReportor.a("home_page", "clk_view_detail", i, 0, new String[] { localObject, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
      break;
    case 2131377360: 
      if (!UIUtils.b())
      {
        if ((!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()))
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f()) {
            h();
          } else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.g()) {
            i();
          }
        }
        else {
          f();
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem)) {
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().getUnionId();
        }
        StoryReportor.a("home_page", "clk_share", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a), 0, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a)), StoryReportor.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, localObject });
      }
      break;
    case 2131370022: 
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f())
      {
        localObject = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
        if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (ShareGroupUtil.a((ShareGroupItem)localObject)))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131703310), 1).a();
          break;
        }
      }
      else if (ShareGroupUtil.b())
      {
        i = this.b;
        if ((i == 63) || (i == 64))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131703309), 1).a();
          break;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback;
      if (localObject != null) {
        ((DetailEventCallback)localObject).J_();
      }
      break;
    case 2131364910: 
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f())
      {
        localObject = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
        if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (ShareGroupUtil.a((ShareGroupItem)localObject)))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131703315), 1).a();
          break;
        }
      }
      else if (ShareGroupUtil.b())
      {
        i = this.b;
        if ((i == 63) || (i == 64))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131703311), 1).a();
          break;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback;
      if (localObject != null) {
        ((DetailEventCallback)localObject).f();
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