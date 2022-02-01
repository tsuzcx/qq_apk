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
  private RoundCornerImageView a;
  private RoundCornerImageView b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private boolean f;
  private boolean g;
  private CertifiedAccountMeta.StEntry h;
  
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
    inflate(paramContext, 2131624383, this);
    setMinimumHeight(DisplayUtil.a(paramContext, 213.0F));
    setPadding(DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 10.0F), DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.a = ((RoundCornerImageView)findViewById(2131428988));
    this.a.setCorner(ImmersiveUtils.dpToPx(7.0F));
    this.b = ((RoundCornerImageView)findViewById(2131429015));
    this.b.setCorner(ImmersiveUtils.dpToPx(7.0F));
    this.d = ((TextView)findViewById(2131439303));
    this.e = ((TextView)findViewById(2131427517));
    this.c = ((ImageView)findViewById(2131440383));
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
    if (this.f) {
      localPaint.setColor(-15263977);
    } else {
      localPaint.setColor(-1);
    }
    if (!this.g)
    {
      i2 = DisplayUtil.a(getContext(), 5.0F);
      localPaint.setShadowLayer(DisplayUtil.a(getContext(), 15.0F), 0, i2, 436207616);
    }
    int i2 = DisplayUtil.a(getContext(), 6.0F);
    RectF localRectF = new RectF(i, j, k - m, n - i1);
    float f1 = i2;
    paramCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
    super.onDraw(paramCanvas);
  }
  
  public void setEntry(CertifiedAccountMeta.StEntry paramStEntry)
  {
    this.h = paramStEntry;
    paramStEntry = this.h;
    if (paramStEntry == null) {
      return;
    }
    if (paramStEntry.cover != null) {
      UIUtils.a(this.a, this.h.cover.url.get(), this.a.getWidth(), this.a.getHeight(), null, "");
    }
    this.d.setText(this.h.title.get());
    if (SubscribeLaucher.a(this.h.type.get()))
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setIsCloseShadow(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerEntryItemView
 * JD-Core Version:    0.7.0.1
 */