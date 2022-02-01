package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper;
import com.tencent.biz.subscribe.utils.MergeBitmapBlurUtil;
import com.tencent.biz.subscribe.widget.textview.AddFollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class RecommendBannerFeedItemView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, SimpleEventReceiver
{
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private AddFollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private boolean jdField_b_of_type_Boolean;
  
  public RecommendBannerFeedItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RecommendBannerFeedItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RecommendBannerFeedItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131558764, this);
    setId(2131364418);
    setMinimumHeight(DisplayUtil.a(paramContext, 213.0F));
    setPadding(DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 10.0F), DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131365284));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(6.0F));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131363135));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(24.0F));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setBorder(true);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setColor(-1);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setBorderWidth(ImmersiveUtils.dpToPx(2.0F));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = ScreenUtil.dip2px(26.0F);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ScreenUtil.dip2px(26.0F);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371697));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365517));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView = ((AddFollowTextView)findViewById(2131367079));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setItemPreClickListener(new RecommendBannerFeedItemView.1(this));
    setOnClickListener(this);
    setOnLongClickListener(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364418)
    {
      SubscribeLaucher.a(null, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("");
      VSReporter.a(str, "auth_page", "recom_head_b", 0, 0, new String[] { "", localStringBuilder.toString(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getWidth();
    int m = getPaddingRight();
    int n = getHeight();
    int i1 = getPaddingBottom();
    Paint localPaint = new Paint();
    if (this.jdField_a_of_type_Boolean) {
      localPaint.setColor(-15263977);
    } else {
      localPaint.setColor(-1);
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      i2 = DisplayUtil.a(getContext(), 5.0F);
      localPaint.setShadowLayer(DisplayUtil.a(getContext(), 15.0F), 0, i2, 436207616);
    }
    int i2 = DisplayUtil.a(getContext(), 6.0F);
    RectF localRectF = new RectF(i, j, k - m, n - i1);
    float f = i2;
    paramCanvas.drawRoundRect(localRectF, f, f, localPaint);
    super.onDraw(paramCanvas);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() != 2131364418) {
      return false;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return false;
    }
    FeedbackSheetHelper.a(getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new RecommendBannerFeedItemView.2(this), new RecommendBannerFeedItemView.3(this));
    paramView = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("");
    VSReporter.a(paramView, "auth_page", "recom_remove", 0, 0, new String[] { "", localStringBuilder.toString(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
    {
      paramSimpleBaseEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (TextUtils.equals(paramSimpleBaseEvent.useId, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get())) {
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.set(paramSimpleBaseEvent.followStatus);
      }
    }
  }
  
  public void setData(CertifiedAccountMeta.StFeed paramStFeed, int paramInt)
  {
    if (paramStFeed != null)
    {
      if (!paramStFeed.has()) {
        return;
      }
      Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      if ((localObject != null) && (TextUtils.equals(((CertifiedAccountMeta.StFeed)localObject).id.get(), paramStFeed.id.get()))) {
        return;
      }
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      this.jdField_a_of_type_Int = paramInt;
      SubImageLoader.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get(), this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get());
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.width.get() > this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.height.get()) {
        MergeBitmapBlurUtil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView);
      } else {
        SubImageLoader.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView);
      }
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.get() == 1)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setUserData((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.get());
      }
      paramStFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("");
      VSReporter.a(paramStFeed, "auth_page", "recom_exp_b", 0, 0, new String[] { "", ((StringBuilder)localObject).toString(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
    }
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setIsCloseShadow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView
 * JD-Core Version:    0.7.0.1
 */