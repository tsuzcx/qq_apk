package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.adapter.MayKnowAdapter.OnRecommendsCanceledListener;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RecommendFriendActivity
  extends BaseActivity
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  MayKnowAdapter.OnRecommendsCanceledListener jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener = new RecommendFriendActivity.1(this);
  private RecommendFriendAdapter jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  SwipListView.RightIconMenuListener jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener = new RecommendFriendActivity.3(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  ArrayList<MayKnowRecommend> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private TextView b;
  private TextView c;
  
  private void a(Intent paramIntent, int paramInt, List<MayKnowRecommend> paramList)
  {
    if ((paramInt == 9) || (paramInt == 8))
    {
      paramIntent = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
      Object localObject;
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        localObject = new ArrayList(paramIntent.size());
        Iterator localIterator1 = paramIntent.iterator();
        while (localIterator1.hasNext())
        {
          MayKnowRecommend localMayKnowRecommend1 = (MayKnowRecommend)localIterator1.next();
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext())
          {
            MayKnowRecommend localMayKnowRecommend2 = (MayKnowRecommend)localIterator2.next();
            if (localMayKnowRecommend2.uin.equalsIgnoreCase(localMayKnowRecommend1.uin)) {
              ((List)localObject).add(localMayKnowRecommend2);
            }
          }
          if (paramInt == 9) {
            localMayKnowRecommend1.bHighLight = true;
          }
        }
        paramList.removeAll((Collection)localObject);
        paramList.addAll(0, paramIntent);
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder("handlePushFrds");
        if (paramIntent != null)
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject = (MayKnowRecommend)paramIntent.next();
            paramList.append(" ");
            paramList.append(((MayKnowRecommend)localObject).uin);
          }
        }
        QLog.i("qqBaseActivity", 2, paramList.toString());
      }
    }
  }
  
  private void a(String paramString)
  {
    int i = getIntent().getIntExtra("EntranceId", 0);
    if ((i == 9) || (i == 8))
    {
      Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject).next();
          if (paramString.equals(localMayKnowRecommend.uin)) {
            this.jdField_a_of_type_JavaUtilArrayList.remove(localMayKnowRecommend);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558491);
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("EntranceId", 0);
    paramBundle = localIntent.getStringExtra("uin");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376809));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.c = ((TextView)findViewById(2131366221));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131376251));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener);
    this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter = new RecommendFriendAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetSwipListView, i, this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener);
    int j = getResources().getDimensionPixelSize(2131297483);
    this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a(j);
    this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a(paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693892);
    setTitle(getString(2131693892));
    this.b = ((TextView)findViewById(2131369202));
    this.b.setVisibility(0);
    this.b.setText("");
    this.b.setOnClickListener(new RecommendFriendActivity.2(this));
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.c();
    Object localObject = null;
    try
    {
      paramBundle = (ArrayList)localIntent.getSerializableExtra("may_know_recmmds");
    }
    catch (Throwable localThrowable)
    {
      paramBundle = localObject;
      if (QLog.isColorLevel())
      {
        QLog.i("qqBaseActivity", 2, localThrowable.getMessage(), localThrowable);
        paramBundle = localObject;
      }
    }
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramBundle);
      a(localIntent, i, localArrayList);
    }
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a(localArrayList);
      this.c.setVisibility(8);
      return true;
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(4);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    RecommendFriendAdapter localRecommendFriendAdapter = this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    RecommendFriendAdapter localRecommendFriendAdapter = this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    RecommendFriendAdapter localRecommendFriendAdapter = this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.b();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecommendFriendActivity
 * JD-Core Version:    0.7.0.1
 */