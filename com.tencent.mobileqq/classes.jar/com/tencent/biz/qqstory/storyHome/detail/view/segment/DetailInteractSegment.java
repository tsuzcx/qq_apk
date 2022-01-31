package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.BannerWebShareMode;
import com.tencent.biz.qqstory.newshare.mode.FeedDetailShareMode;
import com.tencent.biz.qqstory.newshare.mode.ShareGroupOneDayStoryShareMode;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
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
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import nvp;
import nvq;
import nvr;

public class DetailInteractSegment
  extends SegmentView
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
    d(paramBaseViewHolder);
    ((ElasticImageView)paramBaseViewHolder.a(2131371702)).setVisibility(8);
    Object localObject = (ElasticImageView)paramBaseViewHolder.a(2131366782);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramBaseViewHolder.a(2131371703);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      SLog.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      ((ElasticImageView)localObject).setVisibility(0);
      ((ElasticImageView)localObject).setOnClickListener(this);
      break;
      label109:
      if (localBannerFeedItem.getOwner().isMe()) {
        a((TextView)localObject, localBannerFeedItem.mViewTotalTime, 1);
      } else {
        a((TextView)localObject, 0L, 0);
      }
    }
  }
  
  private StoryVideoItem a(@NonNull List paramList)
  {
    Object localObject2 = null;
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().iterator();
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (!StoryVideoItem.isFakeVid(localStoryVideoItem.mVid))
      {
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = localStoryVideoItem;
        }
        for (;;)
        {
          paramList.add(localStoryVideoItem.mVid);
          localObject2 = localObject1;
          break;
          localObject1 = localObject2;
          if (localObject2.mCreateTime > localStoryVideoItem.mCreateTime) {
            localObject1 = localStoryVideoItem;
          }
        }
      }
    }
    return localObject2;
  }
  
  private void a(TextView paramTextView, long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843437);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format("浏览%s", new Object[] { UIUtils.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format("浏览%s", new Object[] { UIUtils.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(null);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = UIUtils.a(paramString);
    return (localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2]);
  }
  
  private View b(BaseViewHolder paramBaseViewHolder)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    d(paramBaseViewHolder);
    e(paramBaseViewHolder);
    ElasticImageView localElasticImageView = (ElasticImageView)paramBaseViewHolder.a(2131366782);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramBaseViewHolder.a(2131371703);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      SLog.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private View c(BaseViewHolder paramBaseViewHolder)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    d(paramBaseViewHolder);
    e(paramBaseViewHolder);
    Object localObject = (ElasticImageView)paramBaseViewHolder.a(2131366782);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramBaseViewHolder.a(2131371703);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      SLog.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      ((ElasticImageView)localObject).setVisibility(0);
      ((ElasticImageView)localObject).setOnClickListener(this);
      break;
      label102:
      if (localVideoListFeedItem.getOwner().isFriend()) {
        a((TextView)localObject, 0L, 0);
      } else if (localVideoListFeedItem.getOwner().isMe()) {
        a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
      } else {
        a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 2);
      }
    }
  }
  
  private void d(BaseViewHolder paramBaseViewHolder)
  {
    paramBaseViewHolder = (ElasticImageView)paramBaseViewHolder.a(2131362023);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mHadLike == 1)
    {
      paramBaseViewHolder.setImageResource(2130843431);
      return;
    }
    paramBaseViewHolder.setImageResource(2130843435);
  }
  
  private void e(BaseViewHolder paramBaseViewHolder)
  {
    paramBaseViewHolder = (ElasticImageView)paramBaseViewHolder.a(2131371702);
    if ((a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.date)) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() > 1))
    {
      paramBaseViewHolder.setVisibility(0);
      paramBaseViewHolder.setOnClickListener(this);
      return;
    }
    paramBaseViewHolder.setVisibility(8);
    paramBaseViewHolder.setOnClickListener(null);
  }
  
  private void f()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe())
    {
      str = "分享我的一天";
      localObject = localStoryShare.a(str).a(new nvp(this)).a(new FeedDetailShareMode(localStoryVideoItem, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label212;
      }
      str = "1";
      label165:
      localObject = ((StoryShare)localObject).a("vote", str);
      if (!bool2) {
        break label219;
      }
    }
    label212:
    label219:
    for (String str = "1";; str = "0")
    {
      ((StoryShare)localObject).a("grade", str).a();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131433100);
      break;
      str = "0";
      break label165;
    }
  }
  
  private void h()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      SLog.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
      if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a("分享日迹圈子").a(ShareGroupOneDayStoryShareMode.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size())).a(new nvq(this, localVideoListFeedItem)).a();
    StoryReportor.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433100)).a(new nvr(this)).a(new BannerWebShareMode(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a())).a();
  }
  
  public void J_()
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null)
    {
      SLog.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramBaseViewHolder.a();
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e())) {
      return c(paramBaseViewHolder);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f()) {
      return b(paramBaseViewHolder);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.g()) {
      return a(paramBaseViewHolder);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.type);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970705, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131362023);
    ElasticImageView localElasticImageView = (ElasticImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131366884);
    paramViewGroup.setOnClickListener(this);
    localElasticImageView.setOnClickListener(this);
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(paramInt1, paramInt2, paramIntent);
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131362023: 
    case 2131366884: 
    case 2131371702: 
    case 2131366782: 
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f())
            {
              paramView = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
              if ((paramView != null) && (paramView.type == 2) && (ShareGroupUtil.a(paramView))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "你无权进行该项操作", 1).a();
              }
            }
            else if ((ShareGroupUtil.a()) && ((this.b == 63) || (this.b == 64)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "你无权进行该项操作", 1).a();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback == null);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback.c();
          return;
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f())
          {
            paramView = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
            if ((paramView != null) && (paramView.type == 2) && (ShareGroupUtil.a(paramView))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "你无权进行该项操作", 1).a();
            }
          }
          else if ((ShareGroupUtil.a()) && ((this.b == 63) || (this.b == 64)))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "你无权进行该项操作", 1).a();
            return;
          }
        } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback == null);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback.d();
        return;
        i = PlayModeUtils.a(this.jdField_a_of_type_Int, this.b);
        paramView = null;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof QQUserUIItem)) {
          paramView = ((QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner()).qq;
        }
        StoryPlayVideoActivity.a((FragmentActivity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.ownerId, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, GeneralFeedProfileSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem), null, 1, true, i, this.jdField_a_of_type_Int, null);
        i = StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem)) {}
        for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().getUnionId();; paramView = "")
        {
          StoryReportor.a("home_page", "clk_play", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a), 0, new String[] { String.valueOf(i), StoryReportor.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, paramView });
          return;
        }
      } while (UIUtils.b());
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()))
      {
        f();
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem)) {
          break label660;
        }
      }
      label660:
      for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().getUnionId();; paramView = "")
      {
        StoryReportor.a("home_page", "clk_share", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a), 0, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a)), StoryReportor.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, paramView });
        return;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f())
        {
          h();
          break;
        }
        if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.g()) {
          break;
        }
        i();
        break;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, this.jdField_a_of_type_Int);
    int i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe()) {}
    for (paramView = "1";; paramView = "2")
    {
      StoryReportor.a("home_page", "clk_view_detail", i, 0, new String[] { paramView, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment
 * JD-Core Version:    0.7.0.1
 */