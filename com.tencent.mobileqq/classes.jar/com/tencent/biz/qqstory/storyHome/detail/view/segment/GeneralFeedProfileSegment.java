package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileUtils;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.StoryCoverClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.OnOverScrollRightListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.OnScrollChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneralFeedProfileSegment
  extends SegmentView<DetailFeedItem>
  implements View.OnClickListener, QQStoryAutoPlayView.StoryCoverClickListener, StoryHomeHorizontalListView.OnOverScrollRightListener, StoryHomeHorizontalListView.OnScrollChangeListener, LoadingMoreHelper.OnLoadMoreListener
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private DetailEventCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback;
  protected DetailFeedItem a;
  private FeedManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  private String jdField_a_of_type_JavaLangString;
  protected final int b;
  private boolean b;
  
  public GeneralFeedProfileSegment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return UIUtils.a(paramContext, 15.0F) + UIUtils.a(paramContext, 147.0F) * paramInt - UIUtils.a(paramContext, 2.5F);
  }
  
  public static int a(DetailFeedItem paramDetailFeedItem)
  {
    boolean bool = paramDetailFeedItem.d();
    int i = 1;
    if (!bool)
    {
      if (paramDetailFeedItem.e()) {
        return 1;
      }
      if (paramDetailFeedItem.f())
      {
        if (paramDetailFeedItem.a.getOwner().getRelationType() != 2) {
          i = 0;
        }
        if (i != 0) {
          return 2;
        }
        return 3;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
    if (localQQUserUIItem == null)
    {
      SLog.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramBaseViewHolder.a();
    }
    Object localObject = (RelativeLayout)paramBaseViewHolder.a(2131374484);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131368058);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131371854);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131380921);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131374510);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131378070);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131374509);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramBaseViewHolder.a(2131380668);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramBaseViewHolder.a(2131374000);
    ((RelativeLayout)localObject).setOnClickListener(this);
    UIUtils.b(localImageView, localQQUserUIItem.headUrl, 68, 68, ImageUtil.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark)) {
      localTextView3.setText(localQQUserUIItem.nickName);
    } else {
      localTextView3.setText(localQQUserUIItem.remark);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e())
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
      if (!TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).blurb)) {
        localObject = ((GeneralRecommendFeedItem)localObject).blurb;
      } else {
        localObject = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
      }
    }
    else
    {
      localObject = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localTextView1.setText((CharSequence)localObject);
      localTextView1.setVisibility(0);
    }
    else
    {
      localTextView1.setVisibility(8);
    }
    localStoryUserBadgeView.setUnionID(localQQUserUIItem.getUnionId(), 2);
    if (!this.jdField_b_of_type_Boolean) {
      localStoryUserBadgeView.a();
    }
    if (localQQUserUIItem.isMe()) {
      a(localTextView2, 0, null);
    } else if (StoryProfileUtils.a(localQQUserUIItem)) {
      a(localTextView2, 1, HardCodeUtil.a(2131705334));
    } else {
      a(localTextView2, 0, null);
    }
    a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, localRelativeLayout, localStoryHomeHorizontalListView);
    this.jdField_b_of_type_Boolean = true;
    return paramBaseViewHolder.a();
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void N_()
  {
    a(a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem));
  }
  
  public void O_() {}
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      DetailFeedItem localDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
      if ((localDetailFeedItem != null) && ((localDetailFeedItem.d()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e())) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() > 0)) {
        return 1;
      }
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if ((!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e())) {
      throw new IllegalStateException("bind view failed because it's not a general feed.");
    }
    return a(paramInt, paramBaseViewHolder);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561643, paramViewGroup, false));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a("adapter", null);
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    StoryApi.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.c();
    int i = 0;
    if (!bool)
    {
      AssertUtils.assertTrue(false, "general feed should have video list, but it's not a video list feed.");
      SLog.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
      return;
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() == 0)
    {
      paramRelativeLayout.setVisibility(8);
      paramStoryHomeHorizontalListView.setVisibility(8);
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() == 1)
    {
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramBaseViewHolder.a(2131374506);
      localObject = (TextView)paramBaseViewHolder.a(2131374508);
      paramBaseViewHolder = (TextView)paramBaseViewHolder.a(2131374507);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      FeedSegment.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        ((TextView)localObject).setTextColor(-7829368);
        paramBaseViewHolder.setTextColor(-7829368);
      }
      else
      {
        ((TextView)localObject).setTextColor(-16777216);
        paramBaseViewHolder.setTextColor(-16777216);
      }
      if (paramRelativeLayout.isUploadFail())
      {
        ((TextView)localObject).setText(HardCodeUtil.a(2131705333));
        ((TextView)localObject).setTextColor(-7829368);
      }
      else
      {
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          ((TextView)localObject).setText(UIUtils.a(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        } else {
          ((TextView)localObject).setText(UIUtils.b(paramRelativeLayout.mCreateTime));
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem))
        {
          paramBaseViewHolder.setVisibility(0);
          paramBaseViewHolder.setText(paramRelativeLayout.mOwnerName);
        }
        else
        {
          paramBaseViewHolder.setVisibility(8);
        }
      }
      if (QQStoryContext.a()) {
        ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      }
    }
    else
    {
      paramRelativeLayout.setVisibility(8);
      paramStoryHomeHorizontalListView.setVisibility(0);
      localObject = (FeedItemThumbAdapter)paramBaseViewHolder.a("adapter");
      paramRelativeLayout = (RelativeLayout)localObject;
      if (localObject == null)
      {
        paramRelativeLayout = this.jdField_a_of_type_AndroidContentContext;
        localObject = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
        paramInt = this.jdField_a_of_type_Int;
        paramRelativeLayout = new FeedItemThumbAdapter(paramRelativeLayout, (Activity)localObject, paramInt, PlayModeUtils.a(paramInt, this.jdField_b_of_type_Int));
        paramBaseViewHolder.a("adapter", paramRelativeLayout);
        paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298603));
        paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
        paramRelativeLayout.a(this);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramInt = i;
        while (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            SLog.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
            break;
          }
          paramInt += 1;
        }
      }
      paramRelativeLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), localVideoListFeedItem);
      paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size());
      paramStoryHomeHorizontalListView.setLoadMoreComplete(localVideoListFeedItem.mIsVideoEnd ^ true);
      paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
      paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
      paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
      paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new GeneralFeedProfileSegment.1(this, paramStoryHomeHorizontalListView, paramRelativeLayout));
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (UIUtils.b()) {
      return;
    }
    paramInt = PlayModeUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    StoryPlayerLauncher.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = StoryReportor.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
      paramView = paramVideoListFeedItem.getOwner().getUnionId();
    } else {
      paramView = "";
    }
    StoryReportor.a("home_page", "clk_card", StoryReportor.a(paramVideoListFeedItem), FeedItemThumbAdapter.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), StoryReportor.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
  }
  
  protected void a(TextView paramTextView, int paramInt, String paramString)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        paramTextView.setVisibility(8);
        paramTextView.setOnClickListener(null);
      }
      else
      {
        paramTextView.setText(paramString);
        paramTextView.setTextColor(-13844490);
        paramTextView.setBackgroundDrawable(null);
        paramTextView.setPadding(0, 0, 0, 0);
        paramTextView.setVisibility(0);
        paramTextView.setOnClickListener(this);
      }
    }
    else
    {
      paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167056));
      paramTextView.setBackgroundResource(2130846771);
      paramTextView.setPadding(paramInt, i, paramInt, i);
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
    }
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      paramTextView.setBackgroundResource(2130846772);
    }
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback = paramDetailEventCallback;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    SLog.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramDetailFeedItem);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
  }
  
  public void a(String paramString)
  {
    SLog.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, BaseViewHolder paramBaseViewHolder)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramBaseViewHolder.a(2131374502);
    paramBaseViewHolder = (TextView)paramBaseViewHolder.a(2131374503);
    if ((paramList != null) && (paramList.size() >= 1))
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext()) {
        if (((StoryVideoItem)paramList.next()).isUploadFail()) {
          i += 1;
        }
      }
      if (i > 0)
      {
        localLinearLayout.setVisibility(0);
        localLinearLayout.setOnClickListener(this);
        paramBaseViewHolder.setText(StoryApi.a(2131699935, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  public boolean a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    DetailEventCallback localDetailEventCallback = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback;
    if (localDetailEventCallback != null) {
      localDetailEventCallback.b();
    }
    return true;
  }
  
  public int b()
  {
    BaseViewHolder localBaseViewHolder = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
    if (localBaseViewHolder == null) {
      return 0;
    }
    return localBaseViewHolder.a().getMeasuredHeight();
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1 = "1";
    Object localObject2;
    switch (i)
    {
    default: 
      break;
    case 2131378070: 
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()))
      {
        localObject1 = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
        if (((QQUserUIItem)localObject1).isMe())
        {
          a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mVideoPullType);
        }
        else if ((!((QQUserUIItem)localObject1).isFriend()) && (((QQUserUIItem)localObject1).isSubscribe != 1))
        {
          localObject2 = (QQStoryHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()) {
            i = 11;
          } else {
            i = 7;
          }
          ((QQStoryHandler)localObject2).a(1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.ownerId, 0, i);
          ((QQUserUIItem)localObject1).isSubscribe = 1;
          paramView.setVisibility(4);
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()) {
            StoryReportor.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
          }
        }
      }
      break;
    case 2131374502: 
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a() != null)
      {
        localObject2 = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.isUploadFail())
          {
            i += 1;
            ((List)localObject2).add(localStoryVideoItem);
          }
        }
        if (i > 0)
        {
          StoryVideoUploadManager.a((List)localObject2, (Activity)this.jdField_a_of_type_AndroidContentContext);
          int j = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
          if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe()) {
            localObject1 = "2";
          }
          StoryReportor.a("home_page", "clk_retry", j, 0, new String[] { localObject1, StoryReportor.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
        }
      }
      else
      {
        SLog.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
      }
      break;
    case 2131374484: 
      a(a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem));
      StoryReportor.a("home_page", "clk_head_nick", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a), 0, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a)), "2", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, "" });
      break;
    case 2131374000: 
      localObject1 = (String)paramView.getTag();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.GeneralFeedProfileSegment
 * JD-Core Version:    0.7.0.1
 */