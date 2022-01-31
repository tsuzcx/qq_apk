package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nvt;

public class GeneralFeedProfileSegment
  extends SegmentView
  implements View.OnClickListener, QQStoryAutoPlayView.StoryCoverClickListener, StoryHomeHorizontalListView.OnOverScrollRightListener, StoryHomeHorizontalListView.OnScrollChangeListener, LoadingMoreHelper.OnLoadMoreListener
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private DetailEventCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback;
  public DetailFeedItem a;
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
    int j = 2;
    int i = 1;
    if ((paramDetailFeedItem.d()) || (paramDetailFeedItem.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramDetailFeedItem.f()) {
        break;
      }
      if (paramDetailFeedItem.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
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
    Object localObject = (RelativeLayout)paramBaseViewHolder.a(2131371680);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131371694);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131362743);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131371697);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131371687);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131371695);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131371646);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramBaseViewHolder.a(2131371701);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramBaseViewHolder.a(2131371682);
    ((RelativeLayout)localObject).setOnClickListener(this);
    UIUtils.b(localImageView, localQQUserUIItem.headUrl, 68, 68, ImageUtil.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).blurb)) {
        break label325;
      }
      localObject = ((GeneralRecommendFeedItem)localObject).blurb;
      label222:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label353;
      }
      localTextView1.setText((CharSequence)localObject);
      localTextView1.setVisibility(0);
      label241:
      localStoryUserBadgeView.setUnionID(localQQUserUIItem.getUnionId(), 2);
      if (!this.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      if (!localQQUserUIItem.isMe()) {
        break label363;
      }
      a(localTextView2, 0, null);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), paramBaseViewHolder);
      a(paramInt, paramBaseViewHolder, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramBaseViewHolder.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
      break label222;
      label339:
      localObject = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (StoryProfileUtils.a(localQQUserUIItem)) {
        a(localTextView2, 1, "关注");
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List paramList, int paramInt) {}
  
  public void H_()
  {
    a(a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem));
  }
  
  public void I_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e())) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e())) {
      return a(paramInt, paramBaseViewHolder);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970703, paramViewGroup, false));
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
    switch (paramInt)
    {
    default: 
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
    boolean bool = false;
    if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.c())
    {
      AssertUtils.a(false, "general feed should have video list, but it's not a video list feed.");
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() == 1)
    {
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramBaseViewHolder.a(2131371647);
      TextView localTextView = (TextView)paramBaseViewHolder.a(2131371648);
      paramBaseViewHolder = (TextView)paramBaseViewHolder.a(2131371649);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      FeedSegment.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramBaseViewHolder.setTextColor(-7829368);
      }
      while (paramRelativeLayout.isUploadFail())
      {
        localTextView.setText("上传失败");
        localTextView.setTextColor(-7829368);
        return;
        localTextView.setTextColor(-16777216);
        paramBaseViewHolder.setTextColor(-16777216);
      }
      if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
        localTextView.setText(UIUtils.a(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
      }
      while ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem))
      {
        paramBaseViewHolder.setVisibility(0);
        paramBaseViewHolder.setText(paramRelativeLayout.mOwnerName);
        return;
        localTextView.setText(UIUtils.b(paramRelativeLayout.mCreateTime));
      }
      paramBaseViewHolder.setVisibility(8);
      return;
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (FeedItemThumbAdapter)paramBaseViewHolder.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new FeedItemThumbAdapter(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, PlayModeUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramBaseViewHolder.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131560280));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(paramRelativeLayout);
    }
    for (paramBaseViewHolder = paramRelativeLayout;; paramBaseViewHolder = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            SLog.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.a(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramBaseViewHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new nvt(this, paramStoryHomeHorizontalListView, paramBaseViewHolder));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (UIUtils.b()) {
      return;
    }
    paramInt = PlayModeUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      StoryPlayVideoActivity.a((FragmentActivity)this.jdField_a_of_type_AndroidContentContext, paramVideoListFeedItem.ownerId, paramStoryVideoItem.mVid, paramVideoListFeedItem.feedId, paramInt, -1, paramView);
      paramInt = StoryReportor.b(paramVideoListFeedItem);
      if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
        break label241;
      }
    }
    label241:
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      StoryReportor.a("home_page", "clk_card", StoryReportor.a(paramVideoListFeedItem), FeedItemThumbAdapter.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), StoryReportor.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
      return;
      int i = FeedSegment.a(paramVideoListFeedItem);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem))
      {
        long l = ((ShareGroupItem)paramVideoListFeedItem.getOwner()).groupUin;
        localObject1 = localObject2;
        if (l != -1L) {
          localObject1 = String.valueOf(l);
        }
      }
      StoryPlayVideoActivity.a((FragmentActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.ownerId, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, i, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType, true, paramInt, this.jdField_a_of_type_Int, paramView);
      break;
    }
  }
  
  protected void a(TextView paramTextView, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      paramTextView.setVisibility(8);
      paramTextView.setOnClickListener(null);
      return;
    case 1: 
      paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494214));
      paramTextView.setBackgroundResource(2130843489);
      paramTextView.setPadding(paramInt, i, paramInt, i);
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    }
    paramTextView.setText(paramString);
    paramTextView.setTextColor(-13844490);
    paramTextView.setBackgroundDrawable(null);
    paramTextView.setPadding(0, 0, 0, 0);
    paramTextView.setVisibility(0);
    paramTextView.setOnClickListener(this);
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
  
  protected void a(List paramList, BaseViewHolder paramBaseViewHolder)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramBaseViewHolder.a(2131371699);
    paramBaseViewHolder = (TextView)paramBaseViewHolder.a(2131371700);
    if ((paramList == null) || (paramList.size() < 1))
    {
      localLinearLayout.setVisibility(8);
      return;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      if (!((StoryVideoItem)paramList.next()).isUploadFail()) {
        break label137;
      }
      i += 1;
    }
    label137:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localLinearLayout.setVisibility(0);
        localLinearLayout.setOnClickListener(this);
        paramBaseViewHolder.setText(StoryApi.a(2131432095, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a().getMeasuredHeight();
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
          } while ((!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()));
          localObject1 = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
          if (((QQUserUIItem)localObject1).isMe())
          {
            a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mVideoPullType);
            return;
          }
        } while ((((QQUserUIItem)localObject1).isFriend()) || (((QQUserUIItem)localObject1).isSubscribe == 1));
        Object localObject2 = (QQStoryHandler)PlayModeUtils.a().a(98);
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()) {}
        for (i = 11;; i = 7)
        {
          ((QQStoryHandler)localObject2).a(1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.ownerId, 0, i);
          ((QQUserUIItem)localObject1).isSubscribe = 1;
          paramView.setVisibility(4);
          if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.e()) {
            break;
          }
          StoryReportor.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
          return;
        }
        a(a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem));
        StoryReportor.a("home_page", "clk_head_nick", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a), 0, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a)), "2", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, "" });
        return;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a() == null) {
          break;
        }
        paramView = new ArrayList();
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().iterator();
        for (i = 0; ((Iterator)localObject1).hasNext(); i = j)
        {
          localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
          j = i;
          if (((StoryVideoItem)localObject2).isUploadFail())
          {
            j = i + 1;
            paramView.add(localObject2);
          }
        }
      } while (i <= 0);
      StoryVideoUploadManager.a(paramView, (Activity)this.jdField_a_of_type_AndroidContentContext);
      int j = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        StoryReportor.a("home_page", "clk_retry", j, 0, new String[] { paramView, StoryReportor.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
        return;
      }
      SLog.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
      return;
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.GeneralFeedProfileSegment
 * JD-Core Version:    0.7.0.1
 */