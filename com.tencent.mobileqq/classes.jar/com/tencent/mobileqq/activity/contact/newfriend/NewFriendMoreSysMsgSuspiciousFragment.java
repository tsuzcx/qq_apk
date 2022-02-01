package com.tencent.mobileqq.activity.contact.newfriend;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendMoreSysMsgSuspiciousFragment
  extends PublicBaseFragment
{
  private NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131372311);
    ((TextView)localView.findViewById(2131379444)).setText(2131699282);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131378808));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter = new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetSwipListView, localView);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter);
    paramView.findViewById(2131369487).setOnClickListener(new NewFriendMoreSysMsgSuspiciousFragment.1(this));
    ((TextView)paramView.findViewById(2131369534)).setText(2131699279);
    ReportController.b(getActivity().app, "dc00898", "", "", "0X800A32B", "0X800A32B", 0, 0, "", "", "", "");
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
    paramViewGroup = paramLayoutInflater.inflate(2131561405, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    a(paramViewGroup);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */