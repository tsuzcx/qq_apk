package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;

public class ReadinjoySubscriptManagerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DecodeTaskCompletionListener, SwipListView.RightIconMenuListener
{
  private View jdField_a_of_type_AndroidViewView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private ReadinjoySubscriptManagerActivity.SubscribeAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeAdapter = null;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = null;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = null;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView = null;
  private Comparator<ReadinjoySubscriptManagerActivity.SubscribeFeedData> jdField_a_of_type_JavaUtilComparator = new ReadinjoySubscriptManagerActivity.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private View b = null;
  
  private void a(String paramString)
  {
    Context localContext = getApplicationContext();
    new PublicAccountUnfollowTask(this.app, paramString, localContext, new ReadinjoySubscriptManagerActivity.3(this, localContext)).a();
  }
  
  private void a(List<ReadinjoySubscriptManagerActivity.SubscribeFeedData> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeAdapter.a(paramList);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.hideCurShowingRightView();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeAdapter.getCount() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b()
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(new ReadInJoyNewFeedsTopGestureLayout(this));
    }
    setTitle(HardCodeUtil.a(2131712716));
    setLeftViewName(2131690601);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getRightTextView());
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718232);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366350);
    ((TextView)findViewById(2131379849)).setText(HardCodeUtil.a(2131712787));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeAdapter = new ReadinjoySubscriptManagerActivity.SubscribeAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131378681));
    TextView localTextView = new TextView(this);
    localTextView.setHeight(AIOUtils.a(20.0F, getResources()));
    localTextView.setBackgroundResource(2131167305);
    localTextView.setClickable(false);
    localTextView.setHintTextColor(getResources().getColor(2131167305));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(localTextView, null, false);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeAdapter);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(this.app, this, false);
    this.b = findViewById(2131372297);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.b.setVisibility(0);
    }
  }
  
  private void c()
  {
    ThreadManager.getSubThreadHandler().post(new ReadinjoySubscriptManagerActivity.2(this));
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label178;
      }
      if ((SystemUtil.b()) || (SystemUtil.d())) {
        break label157;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849916);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label157:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label178:
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2131560404);
    b();
    a();
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = null;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    c();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool;
    label41:
    TextView localTextView;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(this.jdField_a_of_type_Boolean);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!this.jdField_a_of_type_Boolean) {
        break label95;
      }
    }
    label95:
    for (int i = 2131718164;; i = 2131718232)
    {
      localTextView.setText(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeAdapter.notifyDataSetChanged();
      break;
      bool = false;
      break label41;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView == null) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1);
        if ((((View)localObject).getTag() instanceof ReadinjoySubscriptManagerActivity.SubscribeHolder))
        {
          localObject = (ReadinjoySubscriptManagerActivity.SubscribeHolder)((View)localObject).getTag();
          if (TextUtils.equals(ReadinjoySubscriptManagerActivity.SubscribeHolder.a((ReadinjoySubscriptManagerActivity.SubscribeHolder)localObject), paramString))
          {
            new Handler(Looper.getMainLooper()).post(new ReadinjoySubscriptManagerActivity.4(this, (ReadinjoySubscriptManagerActivity.SubscribeHolder)localObject, paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    a(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity
 * JD-Core Version:    0.7.0.1
 */