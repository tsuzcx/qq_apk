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
  ArrayList<MayKnowRecommend> a = new ArrayList();
  MayKnowAdapter.OnRecommendsCanceledListener b = new RecommendFriendActivity.1(this);
  SwipListView.RightIconMenuListener c = new RecommendFriendActivity.3(this);
  private SwipListView d;
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private TextView h;
  private RecommendFriendAdapter i;
  private MayknowRecommendManager j;
  private TopGestureLayout k;
  
  private void a(Intent paramIntent, int paramInt, List<MayKnowRecommend> paramList)
  {
    if ((paramInt == 9) || (paramInt == 8))
    {
      paramIntent = (ArrayList)this.a.clone();
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
    int m = getIntent().getIntExtra("EntranceId", 0);
    if ((m == 9) || (m == 8))
    {
      Object localObject = (ArrayList)this.a.clone();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject).next();
          if (paramString.equals(localMayKnowRecommend.uin)) {
            this.a.remove(localMayKnowRecommend);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.k == null)
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
        this.k = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.k;
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
    setContentView(2131624040);
    Intent localIntent = getIntent();
    int m = localIntent.getIntExtra("EntranceId", 0);
    paramBundle = localIntent.getStringExtra("uin");
    this.e = ((LinearLayout)findViewById(2131445137));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.e.setFitsSystemWindows(true);
      this.e.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.h = ((TextView)findViewById(2131432509));
    this.d = ((SwipListView)findViewById(2131444459));
    this.d.setDragEnable(true);
    this.d.setRightIconMenuListener(this.c);
    this.i = new RecommendFriendAdapter(this, this.app, this.d, m, this.b);
    int n = getResources().getDimensionPixelSize(2131298134);
    this.i.a(n);
    this.i.a(paramBundle);
    this.f = ((TextView)findViewById(2131436227));
    this.f.setVisibility(0);
    this.f.setText(2131891513);
    setTitle(getString(2131891513));
    this.g = ((TextView)findViewById(2131436180));
    this.g.setVisibility(0);
    this.g.setText("");
    this.g.setOnClickListener(new RecommendFriendActivity.2(this));
    this.j = ((MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    ArrayList localArrayList = this.j.f();
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
      this.a.addAll(paramBundle);
      a(localIntent, m, localArrayList);
    }
    if (localArrayList.size() > 0)
    {
      this.i.a(localArrayList);
      this.h.setVisibility(8);
      return true;
    }
    this.h.setVisibility(0);
    this.j.e(4);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    RecommendFriendAdapter localRecommendFriendAdapter = this.i;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    RecommendFriendAdapter localRecommendFriendAdapter = this.i;
    if (localRecommendFriendAdapter != null) {
      localRecommendFriendAdapter.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    RecommendFriendAdapter localRecommendFriendAdapter = this.i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecommendFriendActivity
 * JD-Core Version:    0.7.0.1
 */