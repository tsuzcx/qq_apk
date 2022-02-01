package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class RecommendBannerItemView
  extends RelativeLayout
  implements View.OnClickListener, SimpleEventReceiver
{
  private SquareImageView a;
  private TextView b;
  private FollowTextView c;
  private TextView d;
  private CertifiedAccountMeta.StUser e;
  private int f;
  private boolean g;
  private IRecommendBannerFlowListener h;
  private boolean i;
  private boolean j;
  
  public RecommendBannerItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RecommendBannerItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RecommendBannerItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ReportController.b(null, "dc00898", "", paramString3, paramString1, paramString2, 0, 0, paramString4, paramString5, paramString6, paramString7);
  }
  
  protected void a()
  {
    if (this.e != null) {
      SubscribeLaucher.a(getContext(), this.e);
    }
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131624385, this);
    setMinimumHeight(DisplayUtil.a(paramContext, 183.0F));
    setPadding(DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 10.0F), DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.a = ((SquareImageView)findViewById(2131428988));
    this.d = ((TextView)findViewById(2131431732));
    this.b = ((TextView)findViewById(2131439303));
    this.c = ((FollowTextView)findViewById(2131427517));
    setOnClickListener(this);
    setOnLongClickListener(new RecommendBannerItemView.1(this));
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
    a();
    CertifiedAccountMeta.StUser localStUser;
    if (this.j)
    {
      localStUser = this.e;
      if (localStUser != null) {
        VSReporter.a(localStUser.id.get(), "auth_discover", "reco_head_clk", 0, 0, new String[] { "", String.valueOf(this.f), this.e.nick.get(), this.e.desc.get() });
      }
    }
    else
    {
      localStUser = this.e;
      if (localStUser != null) {
        a("auth_page", "recom_head", localStUser.id.get(), "", "", String.valueOf(this.f), this.e.nick.get());
      }
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
    int k = getPaddingLeft();
    int m = getPaddingTop();
    int n = getWidth();
    int i1 = getPaddingRight();
    int i2 = getHeight();
    int i3 = getPaddingBottom();
    Paint localPaint = new Paint();
    if (this.g) {
      localPaint.setColor(-15263977);
    } else {
      localPaint.setColor(-1);
    }
    if (!this.i)
    {
      i4 = DisplayUtil.a(getContext(), 5.0F);
      localPaint.setShadowLayer(DisplayUtil.a(getContext(), 15.0F), 0, i4, 436207616);
    }
    int i4 = DisplayUtil.a(getContext(), 6.0F);
    RectF localRectF = new RectF(k, m, n - i1, i2 - i3);
    float f1 = i4;
    paramCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
    super.onDraw(paramCanvas);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.e != null))
    {
      paramSimpleBaseEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (TextUtils.equals(paramSimpleBaseEvent.useId, this.e.id.get()))
      {
        this.e.followState.set(paramSimpleBaseEvent.followStatus);
        IRecommendBannerFlowListener localIRecommendBannerFlowListener = this.h;
        if (localIRecommendBannerFlowListener != null)
        {
          int k = paramSimpleBaseEvent.followStatus;
          boolean bool = true;
          if (k != 1) {
            bool = false;
          }
          localIRecommendBannerFlowListener.a(bool, this.f);
        }
      }
    }
  }
  
  public void setData(CertifiedAccountMeta.StUser paramStUser, int paramInt)
  {
    this.e = paramStUser;
    this.f = paramInt;
    if (paramStUser != null)
    {
      this.b.setText(paramStUser.nick.get());
      this.d.setText(paramStUser.desc.get());
      a("auth_page", "recom_exp", paramStUser.id.get(), "", "", String.valueOf(this.f), paramStUser.nick.get());
      try
      {
        this.a.setImageURL(paramStUser.icon.get());
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setData() set icon url error! url: ");
        localStringBuilder.append(paramStUser.icon.get());
        QLog.e("RecommendBannerItemView", 2, localStringBuilder.toString(), localThrowable);
      }
    }
    this.c.setUserData(this.e);
    this.c.setFollowStateChangeListener(new RecommendBannerItemView.2(this));
  }
  
  public void setInNewFolderPage(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (this.g)
    {
      this.a.setFilterColor(1711276032);
      this.d.setTextColor(-9079435);
      this.b.setTextColor(-5723992);
      this.c.setIsInNightMode(paramBoolean);
    }
  }
  
  public void setIsCloseShadow(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setRecommendBannerFolwListener(IRecommendBannerFlowListener paramIRecommendBannerFlowListener)
  {
    this.h = paramIRecommendBannerFlowListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView
 * JD-Core Version:    0.7.0.1
 */