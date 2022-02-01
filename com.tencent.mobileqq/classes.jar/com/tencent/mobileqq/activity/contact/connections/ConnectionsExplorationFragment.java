package com.tencent.mobileqq.activity.contact.connections;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ConnectionsExplorationFragment
  extends PublicBaseFragment
  implements ViewPager.OnPageChangeListener, TabLayoutCompat.OnTabSelectedListener
{
  FriendObserver a = new ConnectionsExplorationFragment.3(this);
  FriendListObserver b = new ConnectionsExplorationFragment.4(this);
  private TextView c;
  private TextView d;
  private QQAppInterface e;
  private ThemeTabLayout f;
  private ArrayList<ConnectionsTabInfo> g = new ArrayList();
  private ConnectionsExplorationViewPager h;
  private ConnectionsViewPagerAdapter i;
  private MayknowRecommendManager j;
  private LinearLayout k;
  private TextView l;
  private TopGestureLayout m;
  private boolean n = true;
  
  private int a(int paramInt)
  {
    Object localObject = this.g;
    if ((localObject != null) && (paramInt < ((ArrayList)localObject).size()))
    {
      localObject = (ConnectionsTabInfo)this.g.get(paramInt);
      if (localObject != null) {
        return ((ConnectionsTabInfo)localObject).a;
      }
    }
    return -1;
  }
  
  private void a()
  {
    if ((this.f != null) && (this.h != null))
    {
      if (this.g.size() > 1)
      {
        int i2 = a(this.h.getCurrentItem());
        int i1 = i2;
        if (i2 == -1) {
          i1 = a(0);
        }
        this.f.a(this.g, i1);
        return;
      }
      this.f.setVisibility(8);
    }
  }
  
  private void a(View paramView)
  {
    this.e = getBaseActivity().app;
    this.e.addObserver(this.b);
    this.e.addObserver(this.a);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLinearLayout.setFitsSystemWindows(true);
      localLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
    }
    this.c = ((TextView)paramView.findViewById(2131436227));
    this.c.setVisibility(0);
    this.c.setText(2131886289);
    this.d = ((TextView)paramView.findViewById(2131436180));
    this.d.setVisibility(0);
    this.d.setText("");
    this.d.setOnClickListener(new ConnectionsExplorationFragment.1(this));
    this.j = ((MayknowRecommendManager)this.e.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    this.k = ((LinearLayout)paramView.findViewById(2131437605));
    this.l = ((TextView)paramView.findViewById(2131432509));
    this.h = ((ConnectionsExplorationViewPager)paramView.findViewById(2131431242));
    this.i = new ConnectionsViewPagerAdapter(getChildFragmentManager(), getBaseActivity().app, this.g);
    this.h.setOnPageChangeListener(this);
    this.h.setAdapter(this.i);
    this.h.setOffscreenPageLimit(2);
    this.f = ((ThemeTabLayout)paramView.findViewById(2131446755));
    a(true, false);
    a(true);
    this.f.setOnTabSelectedListener(this);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.getSubThreadHandler().post(new ConnectionsExplorationFragment.2(this, paramBoolean2, paramBoolean1));
  }
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTabSelected mCurrentTabPos:");
      localStringBuilder.append(paramTab.d());
      QLog.i("ConnectionsExplorationFragment", 2, localStringBuilder.toString());
    }
    if (this.n) {
      this.n = false;
    } else {
      ReportController.b(this.e, "dc00898", "", "", "frd_recom", "frd_tab_clk", a(paramTab.d()), 0, "0", "4", "", "");
    }
    this.h.setCurrentItem(paramTab.d(), false);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.m == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getBaseActivity().getWindow().getDecorView();
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
        this.m = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void b(TabLayoutCompat.Tab paramTab)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTabUnselected mCurrentTabPos:");
      localStringBuilder.append(paramTab.d());
      QLog.i("ConnectionsExplorationFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void c(TabLayoutCompat.Tab paramTab)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTabReselected mCurrentTabPos:");
      localStringBuilder.append(paramTab.d());
      QLog.i("ConnectionsExplorationFragment", 2, localStringBuilder.toString());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131627598, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    ConnectionsViewPagerAdapter localConnectionsViewPagerAdapter = this.i;
    if (localConnectionsViewPagerAdapter != null) {
      localConnectionsViewPagerAdapter.a();
    }
    this.e.removeObserver(this.b);
    this.e.removeObserver(this.a);
    super.onDestroy();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected mCurrentTabPos:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ConnectionsExplorationFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((ConnectionsViewPagerAdapter)localObject).c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment
 * JD-Core Version:    0.7.0.1
 */