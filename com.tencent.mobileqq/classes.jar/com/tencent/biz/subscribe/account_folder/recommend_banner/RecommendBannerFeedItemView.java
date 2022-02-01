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
  private RoundCornerImageView a;
  private RoundCornerImageView b;
  private TextView c;
  private TextView d;
  private AddFollowTextView e;
  private CertifiedAccountMeta.StFeed f;
  private boolean g;
  private boolean h;
  private int i;
  
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
    inflate(paramContext, 2131624384, this);
    setId(2131430449);
    setMinimumHeight(DisplayUtil.a(paramContext, 213.0F));
    setPadding(DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 10.0F), DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.a = ((RoundCornerImageView)findViewById(2131431458));
    this.a.setCorner(ImmersiveUtils.dpToPx(6.0F));
    this.b = ((RoundCornerImageView)findViewById(2131428988));
    this.b.setCorner(ImmersiveUtils.dpToPx(24.0F));
    this.b.setBorder(true);
    this.b.setColor(-1);
    this.b.setBorderWidth(ImmersiveUtils.dpToPx(2.0F));
    this.b.getLayoutParams().width = ScreenUtil.dip2px(26.0F);
    this.b.getLayoutParams().height = ScreenUtil.dip2px(26.0F);
    this.c = ((TextView)findViewById(2131439121));
    this.d = ((TextView)findViewById(2131431733));
    this.e = ((AddFollowTextView)findViewById(2131433532));
    this.e.setItemPreClickListener(new RecommendBannerFeedItemView.1(this));
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
    if (paramView.getId() == 2131430449)
    {
      SubscribeLaucher.a(null, this.f);
      String str = this.f.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.i);
      localStringBuilder.append("");
      VSReporter.a(str, "auth_page", "recom_head_b", 0, 0, new String[] { "", localStringBuilder.toString(), this.f.poster.nick.get(), this.f.title.get() });
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
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int m = getWidth();
    int n = getPaddingRight();
    int i1 = getHeight();
    int i2 = getPaddingBottom();
    Paint localPaint = new Paint();
    if (this.g) {
      localPaint.setColor(-15263977);
    } else {
      localPaint.setColor(-1);
    }
    if (!this.h)
    {
      i3 = DisplayUtil.a(getContext(), 5.0F);
      localPaint.setShadowLayer(DisplayUtil.a(getContext(), 15.0F), 0, i3, 436207616);
    }
    int i3 = DisplayUtil.a(getContext(), 6.0F);
    RectF localRectF = new RectF(j, k, m - n, i1 - i2);
    float f1 = i3;
    paramCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
    super.onDraw(paramCanvas);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() != 2131430449) {
      return false;
    }
    if (this.f == null) {
      return false;
    }
    FeedbackSheetHelper.a(getContext(), this.f, new RecommendBannerFeedItemView.2(this), new RecommendBannerFeedItemView.3(this));
    paramView = this.f.poster.id.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.i);
    localStringBuilder.append("");
    VSReporter.a(paramView, "auth_page", "recom_remove", 0, 0, new String[] { "", localStringBuilder.toString(), this.f.poster.nick.get(), this.f.title.get() });
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.f != null))
    {
      paramSimpleBaseEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (TextUtils.equals(paramSimpleBaseEvent.useId, this.f.poster.id.get())) {
        this.f.poster.followState.set(paramSimpleBaseEvent.followStatus);
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
      Object localObject = this.f;
      if ((localObject != null) && (TextUtils.equals(((CertifiedAccountMeta.StFeed)localObject).id.get(), paramStFeed.id.get()))) {
        return;
      }
      this.f = paramStFeed;
      this.i = paramInt;
      SubImageLoader.a(this.f.poster.icon.get(), this.b);
      this.c.setText(this.f.poster.nick.get());
      this.d.setText(this.f.title.get());
      if (this.f.cover.width.get() > this.f.cover.height.get()) {
        MergeBitmapBlurUtil.a(this.f.cover.url.get(), this.a);
      } else {
        SubImageLoader.a(this.f.cover.url.get(), this.a);
      }
      if (this.f.poster.followState.get() == 1)
      {
        this.e.setVisibility(8);
      }
      else
      {
        this.e.setVisibility(0);
        this.e.setUserData((CertifiedAccountMeta.StUser)this.f.poster.get());
      }
      paramStFeed = this.f.poster.id.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append("");
      VSReporter.a(paramStFeed, "auth_page", "recom_exp_b", 0, 0, new String[] { "", ((StringBuilder)localObject).toString(), this.f.poster.nick.get(), this.f.title.get() });
    }
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setIsCloseShadow(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView
 * JD-Core Version:    0.7.0.1
 */