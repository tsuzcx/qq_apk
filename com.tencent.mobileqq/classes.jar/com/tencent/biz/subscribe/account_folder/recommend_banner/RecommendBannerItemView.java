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
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StUser jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IRecommendBannerFlowListener jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerIRecommendBannerFlowListener;
  private FollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
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
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser != null) {
      SubscribeLaucher.a(getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser);
    }
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131558765, this);
    setMinimumHeight(DisplayUtil.a(paramContext, 183.0F));
    setPadding(DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 10.0F), DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131363135));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365516));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371862));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)findViewById(2131361962));
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
    if (this.c)
    {
      localStUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser;
      if (localStUser != null) {
        VSReporter.a(localStUser.id.get(), "auth_discover", "reco_head_clk", 0, 0, new String[] { "", String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.desc.get() });
      }
    }
    else
    {
      localStUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser;
      if (localStUser != null) {
        a("auth_page", "recom_head", localStUser.id.get(), "", "", String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.get());
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
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser != null))
    {
      paramSimpleBaseEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (TextUtils.equals(paramSimpleBaseEvent.useId, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get()))
      {
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.followState.set(paramSimpleBaseEvent.followStatus);
        IRecommendBannerFlowListener localIRecommendBannerFlowListener = this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerIRecommendBannerFlowListener;
        if (localIRecommendBannerFlowListener != null)
        {
          int i = paramSimpleBaseEvent.followStatus;
          boolean bool = true;
          if (i != 1) {
            bool = false;
          }
          localIRecommendBannerFlowListener.a(bool, this.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public void setData(CertifiedAccountMeta.StUser paramStUser, int paramInt)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = paramStUser;
    this.jdField_a_of_type_Int = paramInt;
    if (paramStUser != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramStUser.desc.get());
      a("auth_page", "recom_exp", paramStUser.id.get(), "", "", String.valueOf(this.jdField_a_of_type_Int), paramStUser.nick.get());
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageURL(paramStUser.icon.get());
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setData() set icon url error! url: ");
        localStringBuilder.append(paramStUser.icon.get());
        QLog.e("RecommendBannerItemView", 2, localStringBuilder.toString(), localThrowable);
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new RecommendBannerItemView.2(this));
  }
  
  public void setInNewFolderPage(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(1711276032);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-9079435);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setIsInNightMode(paramBoolean);
    }
  }
  
  public void setIsCloseShadow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setRecommendBannerFolwListener(IRecommendBannerFlowListener paramIRecommendBannerFlowListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerIRecommendBannerFlowListener = paramIRecommendBannerFlowListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView
 * JD-Core Version:    0.7.0.1
 */