package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import agej;
import alno;
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
import anzj;
import aoog;
import bhjr;
import blpp;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;
import oco;
import oma;
import omb;
import omc;
import omf;
import omg;

public class ReadinjoySubscriptManagerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aoog, blpp
{
  private alno jdField_a_of_type_Alno;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private Comparator<omf> jdField_a_of_type_JavaUtilComparator = new oma(this);
  private omc jdField_a_of_type_Omc;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  private void a(String paramString)
  {
    Context localContext = getApplicationContext();
    new oco(this.app, paramString, localContext, new omb(this, localContext)).a();
  }
  
  private void a(List<omf> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_Omc.a(paramList);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.t();
    }
    if (this.jdField_a_of_type_Omc.getCount() == 0)
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
    setTitle(anzj.a(2131711624));
    setLeftViewName(2131690384);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getRightTextView());
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717127);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366048);
    ((TextView)findViewById(2131379361)).setText(anzj.a(2131711696));
    this.jdField_a_of_type_Omc = new omc(this, null);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131378197));
    TextView localTextView = new TextView(this);
    localTextView.setHeight(agej.a(20.0F, getResources()));
    localTextView.setBackgroundResource(2131167247);
    localTextView.setClickable(false);
    localTextView.setHintTextColor(getResources().getColor(2131167247));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(localTextView, null, false);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Omc);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnItemClickListener(this.jdField_a_of_type_Omc);
    this.jdField_a_of_type_Alno = new alno(this.app, this, false);
    this.b = findViewById(2131371834);
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
      if ((bhjr.b()) || (bhjr.d())) {
        break label157;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849533);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bhjr.b()) && (!bhjr.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bhjr.d())
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
  
  public void a(View paramView)
  {
    a(false);
  }
  
  public void b(View paramView)
  {
    a(true);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2131560282);
    b();
    a();
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Alno != null)
    {
      this.jdField_a_of_type_Alno.a();
      this.jdField_a_of_type_Alno = null;
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
    for (int i = 2131717059;; i = 2131717127)
    {
      localTextView.setText(i);
      this.jdField_a_of_type_Omc.notifyDataSetChanged();
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
        if ((((View)localObject).getTag() instanceof omg))
        {
          localObject = (omg)((View)localObject).getTag();
          if (TextUtils.equals(omg.a((omg)localObject), paramString))
          {
            new Handler(Looper.getMainLooper()).post(new ReadinjoySubscriptManagerActivity.4(this, (omg)localObject, paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity
 * JD-Core Version:    0.7.0.1
 */