package com.tencent.mobileqq.activity.contact.newfriend;

import aeyr;
import aeys;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import awqx;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendMoreSysMsgSuspiciousFragment
  extends PublicBaseFragment
{
  private aeys jdField_a_of_type_Aeys;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131305177);
    ((TextView)localView.findViewById(2131311547)).setText(2131633765);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131310967));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_Aeys = new aeys(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetSwipListView, localView);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Aeys);
    paramView.findViewById(2131302804).setOnClickListener(new aeyr(this));
    ((TextView)paramView.findViewById(2131302847)).setText(2131633764);
    awqx.b(getActivity().app, "dc00898", "", "", "0X800A32B", "0X800A32B", 0, 0, "", "", "", "");
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
    paramViewGroup = paramLayoutInflater.inflate(2131495337, paramViewGroup, false);
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
    if (this.jdField_a_of_type_Aeys != null) {
      this.jdField_a_of_type_Aeys.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aeys != null) {
      this.jdField_a_of_type_Aeys.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aeys != null)
    {
      this.jdField_a_of_type_Aeys.a();
      this.jdField_a_of_type_Aeys.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */