package com.tencent.mobileqq.activity.contact.newfriend.connections;

import aflt;
import afly;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bfvx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class ConnectionsExplorationClidFragment
  extends Fragment
{
  private int jdField_a_of_type_Int;
  private afly jdField_a_of_type_Afly;
  bfvx jdField_a_of_type_Bfvx = new aflt(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131374959));
    View localView = paramView.findViewById(2131365658);
    paramView = paramView.findViewById(2131369504);
    this.jdField_a_of_type_Afly = new afly(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, localView, paramView, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Afly.a();
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_Bfvx);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationClidFragment", 2, "ConnectionsExplorationClidFragment onPageSelected " + this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Afly != null)
    {
      this.jdField_a_of_type_Afly.a();
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
    if (this.jdField_a_of_type_Afly != null) {
      this.jdField_a_of_type_Afly.c();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560913, paramViewGroup, false);
    a(paramLayoutInflater);
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
    if (this.jdField_a_of_type_Afly != null) {
      this.jdField_a_of_type_Afly.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectionsExplorationClidFragment
 * JD-Core Version:    0.7.0.1
 */