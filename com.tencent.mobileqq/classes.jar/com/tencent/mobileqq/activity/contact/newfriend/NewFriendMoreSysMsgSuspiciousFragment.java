package com.tencent.mobileqq.activity.contact.newfriend;

import ahhk;
import ahhl;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import azmj;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendMoreSysMsgSuspiciousFragment
  extends PublicBaseFragment
{
  private ahhl jdField_a_of_type_Ahhl;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131371160);
    ((TextView)localView.findViewById(2131377896)).setText(2131699913);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131377290));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_Ahhl = new ahhl(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetSwipListView, localView);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Ahhl);
    paramView.findViewById(2131368613).setOnClickListener(new ahhk(this));
    ((TextView)paramView.findViewById(2131368659)).setText(2131699912);
    azmj.b(getActivity().app, "dc00898", "", "", "0X800A32B", "0X800A32B", 0, 0, "", "", "", "");
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
    paramViewGroup = paramLayoutInflater.inflate(2131561097, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Ahhl != null) {
      this.jdField_a_of_type_Ahhl.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ahhl != null) {
      this.jdField_a_of_type_Ahhl.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ahhl != null)
    {
      this.jdField_a_of_type_Ahhl.a();
      this.jdField_a_of_type_Ahhl.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */