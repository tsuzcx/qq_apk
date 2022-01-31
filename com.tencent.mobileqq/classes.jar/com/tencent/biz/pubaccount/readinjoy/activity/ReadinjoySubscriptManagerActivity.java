package com.tencent.biz.pubaccount.readinjoy.activity;

import aepi;
import ajjp;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import bdbc;
import bdep;
import bibb;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;
import nsb;
import oau;
import oav;
import oaw;
import oaz;
import oba;

public class ReadinjoySubscriptManagerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bdbc, bibb
{
  private ajjp jdField_a_of_type_Ajjp;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private Comparator<oaz> jdField_a_of_type_JavaUtilComparator = new oau(this);
  private oaw jdField_a_of_type_Oaw;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  private void a(String paramString)
  {
    Context localContext = getApplicationContext();
    new nsb(this.app, paramString, localContext, new oav(this, localContext)).a();
  }
  
  private void a(List<oaz> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_Oaw.a(paramList);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.t();
    }
    if (this.jdField_a_of_type_Oaw.getCount() == 0)
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
    setTitle(alud.a(2131713136));
    setLeftViewName(2131690382);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getRightTextView());
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718883);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365761);
    ((TextView)findViewById(2131378345)).setText(alud.a(2131713208));
    this.jdField_a_of_type_Oaw = new oaw(this, null);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131377231));
    TextView localTextView = new TextView(this);
    localTextView.setHeight(aepi.a(20.0F, getResources()));
    localTextView.setBackgroundResource(2131167140);
    localTextView.setClickable(false);
    localTextView.setHintTextColor(getResources().getColor(2131167140));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(localTextView, null, false);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Oaw);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnItemClickListener(this.jdField_a_of_type_Oaw);
    this.jdField_a_of_type_Ajjp = new ajjp(this.app, this, false);
    this.b = findViewById(2131371168);
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
      if ((bdep.b()) || (bdep.d())) {
        break label157;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848998);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bdep.b()) && (!bdep.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bdep.d())
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2131560128);
    b();
    a();
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ajjp != null)
    {
      this.jdField_a_of_type_Ajjp.a();
      this.jdField_a_of_type_Ajjp = null;
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
      return;
    }
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(this.jdField_a_of_type_Boolean);
      paramView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!this.jdField_a_of_type_Boolean) {
        break label84;
      }
    }
    label84:
    for (int i = 2131718804;; i = 2131718883)
    {
      paramView.setText(i);
      this.jdField_a_of_type_Oaw.notifyDataSetChanged();
      return;
      bool = false;
      break;
    }
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
        if ((((View)localObject).getTag() instanceof oba))
        {
          localObject = (oba)((View)localObject).getTag();
          if (TextUtils.equals(oba.a((oba)localObject), paramString))
          {
            new Handler(Looper.getMainLooper()).post(new ReadinjoySubscriptManagerActivity.4(this, (oba)localObject, paramBitmap));
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