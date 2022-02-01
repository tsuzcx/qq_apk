package com.tencent.mobileqq.activity.contact.connections;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;

public class ConnectionsExplorationClidFragment
  extends ReportV4Fragment
{
  private int jdField_a_of_type_Int = 0;
  private ConnectsExplorationFriendAdapter jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  SwipListView.RightIconMenuListener jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener = new ConnectionsExplorationClidFragment.1(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131376753));
    View localView = paramView.findViewById(2131366333);
    paramView = paramView.findViewById(2131370750);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter = new ConnectsExplorationFriendAdapter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, localView, paramView, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter.a();
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationClidFragment", 2, "ConnectionsExplorationClidFragment onPageSelected " + this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter.a();
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationClidFragment", 2, "ConnectionsExplorationClidFragment doOnDestroy " + this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter.c();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561404, paramViewGroup, false);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    b();
    super.onDestroy();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationClidFragment", 2, " onResume");
    }
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationClidFragment
 * JD-Core Version:    0.7.0.1
 */