package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import aaak;
import aaam;
import aaej;
import aaex;
import aaff;
import aafi;
import abbe;
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
import bdll;
import bhgr;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class RecommendBannerItemView
  extends RelativeLayout
  implements aaam, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StUser jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser;
  private aaex jdField_a_of_type_Aaex;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
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
    bdll.b(null, "dc00898", "", paramString3, paramString1, paramString2, 0, 0, paramString4, paramString5, paramString6, paramString7);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser != null) {
      aaej.a(getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser);
    }
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131558794, this);
    setMinimumHeight(bhgr.a(paramContext, 183.0F));
    setPadding(bhgr.a(paramContext, 6.0F), bhgr.a(paramContext, 10.0F), bhgr.a(paramContext, 6.0F), bhgr.a(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131363109));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365387));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371813));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)findViewById(2131361947));
    setOnClickListener(this);
    setOnLongClickListener(new aaff(this));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    aaak.a().a(this);
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    a();
    if (this.c) {
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser != null) {
        abbe.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), "auth_discover", "reco_head_clk", 0, 0, new String[] { "", String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.desc.get() });
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser != null) {
        a("auth_page", "recom_head", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), "", "", String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.get());
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    aaak.a().b(this);
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
        i2 = bhgr.a(getContext(), 5.0F);
        localPaint.setShadowLayer(bhgr.a(getContext(), 15.0F), 0, i2, 436207616);
      }
      int i2 = bhgr.a(getContext(), 6.0F);
      paramCanvas.drawRoundRect(new RectF(i, j, k - m, n - i1), i2, i2, localPaint);
      super.onDraw(paramCanvas);
      return;
      localPaint.setColor(-1);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    aaex localaaex;
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser != null) && (TextUtils.equals(((FollowUpdateEvent)paramSimpleBaseEvent).useId, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get())))
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
      if (this.jdField_a_of_type_Aaex != null)
      {
        localaaex = this.jdField_a_of_type_Aaex;
        if (((FollowUpdateEvent)paramSimpleBaseEvent).followStatus != 1) {
          break label91;
        }
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      localaaex.a(bool, this.jdField_a_of_type_Int);
      return;
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
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageURL(paramStUser.icon.get());
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new aafi(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("RecommendBannerItemView", 2, "setData() set icon url error! url: " + paramStUser.icon.get(), localThrowable);
      }
    }
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
  
  public void setRecommendBannerFolwListener(aaex paramaaex)
  {
    this.jdField_a_of_type_Aaex = paramaaex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView
 * JD-Core Version:    0.7.0.1
 */