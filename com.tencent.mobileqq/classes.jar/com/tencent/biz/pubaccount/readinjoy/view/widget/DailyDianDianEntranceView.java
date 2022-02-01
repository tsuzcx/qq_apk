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
import bmqa;
import com.tencent.biz.pubaccount.readinjoy.view.ClipDianDianTouchAreaLayout;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import oat;
import ryj;
import smj;
import svi;
import tkf;

public class DailyDianDianEntranceView
  extends FrameLayout
  implements View.OnClickListener, svi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ClipDianDianTouchAreaLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout;
  private ReadInJoyColorBandEntranceButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton;
  private ryj jdField_a_of_type_Ryj;
  
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
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562752, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton = ((ReadInJoyColorBandEntranceButton)localView.findViewById(2131366049));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = ((ClipDianDianTouchAreaLayout)localView.findViewById(2131366052));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setOnVideoCoverClickListener(this);
    int j = smj.a().a();
    RecommendFeedsDiandianEntranceManager.a().b(j);
    QLog.d("DailyDianDianEntranceView", 1, "init | DailyFeedsDiandianEntranceManager daily feeds entryMode : " + j);
    int i = 2130849365;
    if (j == 1) {
      switch (bmqa.d())
      {
      default: 
        this.jdField_a_of_type_Ryj = new ryj(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton, getContext());
        this.jdField_a_of_type_Ryj.a(1);
        i = 2130843059;
        switch (j)
        {
        }
        break;
      }
    }
    do
    {
      return;
      i = 2130849399;
      break;
      i = 2130849366;
      break;
      if (j != 3) {
        break;
      }
      i = 2130849364;
      break;
    } while (!bmqa.h());
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
    if (this.jdField_a_of_type_Ryj != null) {
      this.jdField_a_of_type_Ryj.c();
    }
  }
  
  public void a(tkf paramtkf)
  {
    if ((paramtkf == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton == null)) {}
    int i;
    do
    {
      return;
      i = smj.a().a();
      QLog.d("DailyDianDianEntranceView", 1, "onEntryIconRefresh | entryMode " + i);
    } while ((i == 0) || (i == 2));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setDataSource(paramtkf);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.getVisibility() == 0))
    {
      if (paramtkf == null) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.a(paramtkf);
      QLog.d("DailyDianDianEntranceView", 1, "onEntryIconRefresh | addRedDot entryMode " + i);
    }
    for (;;)
    {
      oat.a(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", RecommendFeedsDiandianEntranceManager.a().b(1), false);
      return;
      label146:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.setNotMsg();
      QLog.d("DailyDianDianEntranceView", 1, "onEntryIconRefresh | setNotMsg entryMode " + i);
    }
  }
  
  public void b(tkf paramtkf)
  {
    if ((paramtkf == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton == null)) {}
    do
    {
      return;
      QLog.d("DailyDianDianEntranceView", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.a();
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.getVisibility() != 0));
    if (paramtkf != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotReadInJoyColorBandEntranceButton.a(paramtkf);
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