package com.tencent.mobileqq.activity.contact.newfriend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendMoreSysMsgSuspiciousFragment
  extends PublicBaseFragment
{
  private NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131371896);
    ((TextView)localView.findViewById(2131378796)).setText(2131699387);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131378197));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter = new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter(getBaseActivity(), getBaseActivity().app, this.jdField_a_of_type_ComTencentWidgetSwipListView, localView);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter);
    paramView.findViewById(2131369202).setOnClickListener(new NewFriendMoreSysMsgSuspiciousFragment.1(this));
    ((TextView)paramView.findViewById(2131369249)).setText(2131699384);
    ReportController.b(getBaseActivity().app, "dc00898", "", "", "0X800A32B", "0X800A32B", 0, 0, "", "", "", "");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onCreateView");
    }
    paramViewGroup = paramLayoutInflater.inflate(2131561244, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    a(paramViewGroup);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onDestroy");
    }
    NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter localSysMsgSuspiciousAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter;
    if (localSysMsgSuspiciousAdapter != null) {
      localSysMsgSuspiciousAdapter.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter localSysMsgSuspiciousAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter;
    if (localSysMsgSuspiciousAdapter != null) {
      localSysMsgSuspiciousAdapter.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter localSysMsgSuspiciousAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter;
    if (localSysMsgSuspiciousAdapter != null)
    {
      localSysMsgSuspiciousAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */