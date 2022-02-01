package com.tencent.mobileqq.activity.contact.newfriend;

import ajkk;
import ajkl;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bdll;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendMoreSysMsgSuspiciousFragment
  extends PublicBaseFragment
{
  private ajkl jdField_a_of_type_Ajkl;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131371847);
    ((TextView)localView.findViewById(2131378948)).setText(2131698470);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131378327));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_Ajkl = new ajkl(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetSwipListView, localView);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Ajkl);
    paramView.findViewById(2131369042).setOnClickListener(new ajkk(this));
    ((TextView)paramView.findViewById(2131369088)).setText(2131698469);
    bdll.b(getActivity().app, "dc00898", "", "", "0X800A32B", "0X800A32B", 0, 0, "", "", "", "");
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
    paramViewGroup = paramLayoutInflater.inflate(2131561364, paramViewGroup, false);
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
    if (this.jdField_a_of_type_Ajkl != null) {
      this.jdField_a_of_type_Ajkl.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ajkl != null) {
      this.jdField_a_of_type_Ajkl.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ajkl != null)
    {
      this.jdField_a_of_type_Ajkl.a();
      this.jdField_a_of_type_Ajkl.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */