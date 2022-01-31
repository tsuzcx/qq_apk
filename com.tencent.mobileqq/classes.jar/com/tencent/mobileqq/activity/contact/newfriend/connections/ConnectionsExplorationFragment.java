package com.tencent.mobileqq.activity.contact.newfriend.connections;

import aflw;
import aflx;
import afly;
import ajxl;
import akac;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import axqw;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import rtz;
import rue;

public class ConnectionsExplorationFragment
  extends PublicBaseFragment
  implements ViewPager.OnPageChangeListener, rtz
{
  ajxl jdField_a_of_type_Ajxl = new aflx(this);
  private akac jdField_a_of_type_Akac;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConnectionsExplorationViewPager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsExplorationViewPager;
  private ConnectionsViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsViewPagerAdapter;
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<afly> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private TextView b;
  private TextView c;
  
  private int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      afly localafly = (afly)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localafly != null) {
        return localafly.a;
      }
    }
    return -1;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsExplorationViewPager != null))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
      {
        int j = a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsExplorationViewPager.getCurrentItem());
        int i = j;
        if (j == -1) {
          i = a(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(this.jdField_a_of_type_JavaUtilArrayList, i);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setVisibility(8);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131375491);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLinearLayout.setFitsSystemWindows(true);
      localLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368472));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689730);
    this.b = ((TextView)paramView.findViewById(2131368429));
    this.b.setVisibility(0);
    this.b.setText("");
    this.b.setOnClickListener(new aflw(this));
    this.jdField_a_of_type_Akac = ((akac)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369473));
    this.c = ((TextView)paramView.findViewById(2131365659));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsExplorationViewPager = ((ConnectionsExplorationViewPager)paramView.findViewById(2131364624));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsViewPagerAdapter = new ConnectionsViewPagerAdapter(getChildFragmentManager(), getActivity().app, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsExplorationViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsExplorationViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsExplorationViewPager.setOffscreenPageLimit(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout = ((ThemeTabLayout)paramView.findViewById(2131376812));
    a(true, false);
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setOnTabSelectedListener(this);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.getSubThreadHandler().post(new ConnectionsExplorationFragment.2(this, paramBoolean2, paramBoolean1));
  }
  
  public void a(rue paramrue)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onTabSelected mCurrentTabPos:" + paramrue.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsExplorationViewPager.setCurrentItem(paramrue.a(), false);
      return;
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", a(paramrue.a()), 0, "0", "4", "", "");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
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
  
  public void b(rue paramrue)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onTabUnselected mCurrentTabPos:" + paramrue.a());
    }
  }
  
  public void c(rue paramrue)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onTabReselected mCurrentTabPos:" + paramrue.a());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560913, paramViewGroup, false);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsViewPagerAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
    super.onDestroy();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onPageSelected mCurrentTabPos:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsViewPagerAdapter.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectionsExplorationFragment
 * JD-Core Version:    0.7.0.1
 */