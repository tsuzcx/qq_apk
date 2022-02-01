package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.immersive.ImmersiveUtils;

public class RecommendBannerEntryItemView
  extends RelativeLayout
{
  private CertifiedAccountMeta.StEntry jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private boolean jdField_b_of_type_Boolean;
  
  public RecommendBannerEntryItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RecommendBannerEntryItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RecommendBannerEntryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131558763, this);
    setMinimumHeight(DisplayUtil.a(paramContext, 213.0F));
    setPadding(DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 10.0F), DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131363135));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(7.0F));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131363150));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(7.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371862));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361962));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372833));
    setOnClickListener(new RecommendBannerEntryItemView.1(this));
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
  
  public void setEntry(CertifiedAccountMeta.StEntry paramStEntry)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry = paramStEntry;
    paramStEntry = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry;
    if (paramStEntry == null) {
      return;
    }
    if (paramStEntry.cover != null) {
      UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry.cover.url.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getHeight(), null, "");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry.title.get());
    if (SubscribeLaucher.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry.type.get()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerEntryItemView
 * JD-Core Version:    0.7.0.1
 */