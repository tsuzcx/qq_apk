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
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Calendar;
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
    d(paramBaseViewHolder);
    ((ElasticImageView)paramBaseViewHolder.a(2131374985)).setVisibility(8);
    Object localObject = (ElasticImageView)paramBaseViewHolder.a(2131377936);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramBaseViewHolder.a(2131381730);
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
  
  private StoryVideoItem a(@NonNull List<String> paramList)
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
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846826);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(HardCodeUtil.a(2131703185), new Object[] { UIUtils.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(HardCodeUtil.a(2131703184), new Object[] { UIUtils.a(paramLong) }));
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
    ElasticImageView localElasticImageView = (ElasticImageView)paramBaseViewHolder.a(2131377936);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramBaseViewHolder.a(2131381730);
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
    Object localObject = (ElasticImageView)paramBaseViewHolder.a(2131377936);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramBaseViewHolder.a(2131381730);
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
    paramBaseViewHolder = (ElasticImageView)paramBaseViewHolder.a(2131370355);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mHadLike == 1)
    {
      paramBaseViewHolder.setImageResource(2130846819);
      return;
    }
    if (QQStoryContext.a())
    {
      paramBaseViewHolder.setImageResource(2130846825);
      return;
    }
    paramBaseViewHolder.setImageResource(2130846824);
  }
  
  private void e(BaseViewHolder paramBaseViewHolder)
  {
    paramBaseViewHolder = (ElasticImageView)paramBaseViewHolder.a(2131374985);
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
      str = HardCodeUtil.a(2131703181);
      localObject = localStoryShare.a(str).a(new DetailInteractSegment.1(this)).a(new FeedDetailShareMode(localStoryVideoItem, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label216;
      }
      str = "1";
      label169:
      localObject = ((StoryShare)localObject).a("vote", str);
      if (!bool2) {
        break label223;
      }
    }
    label216:
    label223:
    for (String str = "1";; str = "0")
    {
      ((StoryShare)localObject).a("grade", str).b();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131719311);
      break;
      str = "0";
      break label169;
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
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(HardCodeUtil.a(2131703180) + QQStoryConstant.a + HardCodeUtil.a(2131703182)).a(ShareGroupOneDayStoryShareMode.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size())).a(new DetailInteractSegment.2(this, localVideoListFeedItem)).b();
    StoryReportor.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    SLog.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719311)).a(new DetailInteractSegment.3(this)).a(new BannerWebShareMode(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a())).b();
  }
  
  public void R_()
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
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561783, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131370355);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131365027);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131377936);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131374985);
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131381730);
    if (QQStoryContext.a())
    {
      paramViewGroup.setImageResource(2130846825);
      localElasticImageView1.setImageResource(2130846818);
      localElasticImageView3.setImageResource(2130846871);
      localElasticImageView2.setImageResource(2130847157);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166514));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
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
    case 2131370355: 
    case 2131365027: 
    case 2131374985: 
    case 2131377936: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f())
          {
            localObject = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
            if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (ShareGroupUtil.a((ShareGroupItem)localObject))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131703178), 1).a();
            }
          }
          else if ((ShareGroupUtil.b()) && ((this.b == 63) || (this.b == 64)))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131703177), 1).a();
            continue;
          }
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback != null)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback.M_();
            continue;
            if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f())
            {
              localObject = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
              if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (ShareGroupUtil.a((ShareGroupItem)localObject))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131703183), 1).a();
              }
            }
            else if ((ShareGroupUtil.b()) && ((this.b == 63) || (this.b == 64)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131703179), 1).a();
              continue;
            }
            if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback != null) {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback.f();
            }
          }
        }
        i = PlayModeUtils.a(this.jdField_a_of_type_Int, this.b);
        localObject = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, "", 1, false), i);
        StoryPlayerLauncher.a((Activity)this.jdField_a_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), null);
        i = StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem)) {}
        for (localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().getUnionId();; localObject = "")
        {
          StoryReportor.a("home_page", "clk_play", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a), 0, new String[] { String.valueOf(i), StoryReportor.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, localObject });
          break;
        }
      } while (UIUtils.b());
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()))
      {
        f();
        label533:
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem)) {
          break label669;
        }
      }
      label669:
      for (localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().getUnionId();; localObject = "")
      {
        StoryReportor.a("home_page", "clk_share", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a), 0, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a)), StoryReportor.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, localObject });
        break;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f())
        {
          h();
          break label533;
        }
        if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.g()) {
          break label533;
        }
        i();
        break label533;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, this.jdField_a_of_type_Int);
    int i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe()) {}
    for (Object localObject = "1";; localObject = "2")
    {
      StoryReportor.a("home_page", "clk_view_detail", i, 0, new String[] { localObject, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment
 * JD-Core Version:    0.7.0.1
 */