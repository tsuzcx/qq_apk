package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.view.ClipDianDianTouchAreaLayout;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import olh;
import sij;
import syf;
import tdx;
import tso;

public class DailyDianDianEntranceView
  extends FrameLayout
  implements View.OnClickListener, tdx
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ClipDianDianTouchAreaLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout;
  private ReadInJoyColorBandEntranceButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton;
  private sij jdField_a_of_type_Sij;
  
  public DailyDianDianEntranceView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  public DailyDianDianEntranceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562742, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton = ((ReadInJoyColorBandEntranceButton)localView.findViewById(2131366225));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = ((ClipDianDianTouchAreaLayout)localView.findViewById(2131366228));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setOnVideoCoverClickListener(this);
    int j = syf.a().a();
    RecommendFeedsDiandianEntranceManager.a().a(j);
    QLog.d("DailyDianDianEntranceView", 1, "init | DailyFeedsDiandianEntranceManager daily feeds entryMode : " + j);
    int i = 2130849388;
    if (j == 1) {
      switch (bmhv.f())
      {
      default: 
        this.jdField_a_of_type_Sij = new sij(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton, getContext());
        this.jdField_a_of_type_Sij.a(1);
        i = 2130843169;
        switch (j)
        {
        }
        break;
      }
    }
    do
    {
      return;
      i = 2130849422;
      break;
      i = 2130849389;
      break;
      if (j != 3) {
        break;
      }
      i = 2130849387;
      break;
    } while (!bmhv.l());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setClickAnimMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setDefaultIconBigMode(80, 80);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setDefaultDrawable(getResources().getDrawable(i));
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setClickAnimMode(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.a().setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setDefaultIconBigMode(70, 70);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setDefaultDrawable(getResources().getDrawable(i));
  }
  
  public DailyDianDianEntranceView a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Sij != null) {
      this.jdField_a_of_type_Sij.c();
    }
  }
  
  public void a(tso paramtso)
  {
    if ((paramtso == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton == null)) {}
    int i;
    do
    {
      return;
      i = syf.a().a();
      QLog.d("DailyDianDianEntranceView", 1, "onEntryIconRefresh | entryMode " + i);
    } while ((i == 0) || (i == 2));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setDataSource(paramtso);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.getVisibility() == 0))
    {
      if (paramtso == null) {
        break label148;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.a(paramtso);
      QLog.d("DailyDianDianEntranceView", 1, "onEntryIconRefresh | addRedDot entryMode " + i);
    }
    for (;;)
    {
      olh.a(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", RecommendFeedsDiandianEntranceManager.a().a(1, 41505), false);
      return;
      label148:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setNotMsg();
      QLog.d("DailyDianDianEntranceView", 1, "onEntryIconRefresh | setNotMsg entryMode " + i);
    }
  }
  
  public void b(tso paramtso)
  {
    if ((paramtso == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton == null)) {}
    do
    {
      return;
      QLog.d("DailyDianDianEntranceView", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.a();
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.getVisibility() != 0));
    if (paramtso != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.a(paramtso);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setNotMsg();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setStartDelay(500L);
    localObjectAnimator.setDuration(400L);
    localObjectAnimator.start();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.DailyDianDianEntranceView
 * JD-Core Version:    0.7.0.1
 */