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
import axlk;
import baxn;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.widget.textview.AddFollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import wil;
import wis;
import wjk;
import wjl;
import wjm;
import wpt;
import wpv;
import wsg;
import wsq;
import xhb;

public class RecommendBannerFeedItemView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, wpv
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
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131558694, this);
    setId(2131364011);
    setMinimumHeight(baxn.a(paramContext, 213.0F));
    setPadding(baxn.a(paramContext, 6.0F), baxn.a(paramContext, 10.0F), baxn.a(paramContext, 6.0F), baxn.a(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131364798));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(6.0F));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131362938));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(24.0F));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setBorder(true);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setColor(-1);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setBorderWidth(ImmersiveUtils.a(2.0F));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = axlk.a(26.0F);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = axlk.a(26.0F);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370647));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365017));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView = ((AddFollowTextView)findViewById(2131366536));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setItemPreClickListener(new wjk(this));
    setOnClickListener(this);
    setOnLongClickListener(this);
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (TextUtils.equals(((FollowUpdateEvent)paramSimpleBaseEvent).useId, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()))) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
    }
  }
  
  protected void onAttachedToWindow()
  {
    wpt.a().a(this);
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    wis.a(null, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    xhb.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_page", "recom_head_b", 0, 0, new String[] { "", this.jdField_a_of_type_Int + "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
  }
  
  protected void onDetachedFromWindow()
  {
    wpt.a().b(this);
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
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        i2 = baxn.a(getContext(), 5.0F);
        localPaint.setShadowLayer(baxn.a(getContext(), 15.0F), 0, i2, 436207616);
      }
      int i2 = baxn.a(getContext(), 6.0F);
      paramCanvas.drawRoundRect(new RectF(i, j, k - m, n - i1), i2, i2, localPaint);
      super.onDraw(paramCanvas);
      return;
      localPaint.setColor(-1);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return false;
    } while (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    wsg.a(getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new wjl(this), new wjm(this));
    xhb.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_page", "recom_remove", 0, 0, new String[] { "", this.jdField_a_of_type_Int + "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
    return true;
  }
  
  public void setData(CertifiedAccountMeta.StFeed paramStFeed, int paramInt)
  {
    if ((paramStFeed == null) || (!paramStFeed.has())) {}
    while ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (TextUtils.equals(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), paramStFeed.id.get()))) {
      return;
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
    wil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get(), this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get());
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.width.get() > this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.height.get())
    {
      wsq.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView);
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.get() != 1) {
        break label294;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setVisibility(8);
    }
    for (;;)
    {
      xhb.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_page", "recom_exp_b", 0, 0, new String[] { "", this.jdField_a_of_type_Int + "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
      return;
      wil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView);
      break;
      label294:
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setUserData((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.get());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView
 * JD-Core Version:    0.7.0.1
 */