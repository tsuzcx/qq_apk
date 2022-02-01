package com.tencent.mobileqq.activity.contact.connections;

import aixw;
import aixx;
import aixy;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import anvi;
import anyb;
import bdla;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import trf;
import trk;

public class ConnectionsExplorationFragment
  extends PublicBaseFragment
  implements ViewPager.OnPageChangeListener, trf
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  anvi jdField_a_of_type_Anvi = new aixx(this);
  private anyb jdField_a_of_type_Anyb;
  private ConnectionsExplorationViewPager jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager;
  private ConnectionsViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter;
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<aixy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private TextView b;
  private TextView c;
  
  private int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      aixy localaixy = (aixy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localaixy != null) {
        return localaixy.a;
      }
    }
    return -1;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager != null))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
      {
        int j = a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.getCurrentItem());
        int i = j;
        if (j == -1) {
          i = a(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(this.jdField_a_of_type_JavaUtilArrayList, i);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setVisibility(8);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131376947);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLinearLayout.setFitsSystemWindows(true);
      localLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369278));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689638);
    this.b = ((TextView)paramView.findViewById(2131369231));
    this.b.setVisibility(0);
    this.b.setText("");
    this.b.setOnClickListener(new aixw(this));
    this.jdField_a_of_type_Anyb = ((anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370430));
    this.c = ((TextView)paramView.findViewById(2131366162));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager = ((ConnectionsExplorationViewPager)paramView.findViewById(2131365082));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter = new ConnectionsViewPagerAdapter(getChildFragmentManager(), getActivity().app, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.setOffscreenPageLimit(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout = ((ThemeTabLayout)paramView.findViewById(2131378418));
    a(true, false);
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setOnTabSelectedListener(this);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.getSubThreadHandler().post(new ConnectionsExplorationFragment.2(this, paramBoolean2, paramBoolean1));
  }
  
  public void a(trk paramtrk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onTabSelected mCurrentTabPos:" + paramtrk.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.setCurrentItem(paramtrk.a(), false);
      return;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", a(paramtrk.a()), 0, "0", "4", "", "");
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
  
  public void b(trk paramtrk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onTabUnselected mCurrentTabPos:" + paramtrk.a());
    }
  }
  
  public void c(trk paramtrk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onTabReselected mCurrentTabPos:" + paramtrk.a());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561298, paramViewGroup, false);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    super.onDestroy();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onPageSelected mCurrentTabPos:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment
 * JD-Core Version:    0.7.0.1
 */