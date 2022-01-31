package com.tencent.mobileqq.activity;

import adtr;
import adts;
import adtt;
import akkb;
import akkn;
import alwd;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import bibb;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RecommendFriendActivity
  extends BaseActivity
{
  akkb jdField_a_of_type_Akkb = new adtr(this);
  private akkn jdField_a_of_type_Akkn;
  private alwd jdField_a_of_type_Alwd;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bibb jdField_a_of_type_Bibb = new adtt(this);
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
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
            paramList.append(" ").append(((MayKnowRecommend)localObject).uin);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558454);
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("EntranceId", 0);
    paramBundle = localIntent.getStringExtra("uin");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376034));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.c = ((TextView)findViewById(2131365744));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131375480));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_Bibb);
    this.jdField_a_of_type_Akkn = new akkn(this, this.app, this.jdField_a_of_type_ComTencentWidgetSwipListView, i, this.jdField_a_of_type_Akkb);
    int j = getResources().getDimensionPixelSize(2131297295);
    this.jdField_a_of_type_Akkn.a(j);
    this.jdField_a_of_type_Akkn.a(paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368670));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694209);
    setTitle(getString(2131694209));
    this.b = ((TextView)findViewById(2131368624));
    this.b.setVisibility(0);
    this.b.setText("");
    this.b.setOnClickListener(new adts(this));
    this.jdField_a_of_type_Alwd = ((alwd)this.app.getManager(159));
    ArrayList localArrayList = this.jdField_a_of_type_Alwd.c();
    try
    {
      paramBundle = (ArrayList)localIntent.getSerializableExtra("may_know_recmmds");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramBundle);
        a(localIntent, i, localArrayList);
      }
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_Akkn.a(localArrayList);
        this.c.setVisibility(8);
        return true;
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqBaseActivity", 2, paramBundle.getMessage(), paramBundle);
        }
        paramBundle = null;
      }
      this.c.setVisibility(0);
      this.jdField_a_of_type_Alwd.a(4);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Akkn != null) {
      this.jdField_a_of_type_Akkn.c();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Akkn != null) {
      this.jdField_a_of_type_Akkn.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Akkn != null) {
      this.jdField_a_of_type_Akkn.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecommendFriendActivity
 * JD-Core Version:    0.7.0.1
 */