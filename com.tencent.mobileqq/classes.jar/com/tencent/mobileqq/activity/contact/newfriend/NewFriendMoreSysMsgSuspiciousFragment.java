package com.tencent.mobileqq.activity.contact.newfriend;

import afkf;
import afkg;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import axqy;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendMoreSysMsgSuspiciousFragment
  extends PublicBaseFragment
{
  private afkg jdField_a_of_type_Afkg;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131370850);
    ((TextView)localView.findViewById(2131377363)).setText(2131699558);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131376778));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_Afkg = new afkg(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetSwipListView, localView);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Afkg);
    paramView.findViewById(2131368429).setOnClickListener(new afkf(this));
    ((TextView)paramView.findViewById(2131368472)).setText(2131699557);
    axqy.b(getActivity().app, "dc00898", "", "", "0X800A32B", "0X800A32B", 0, 0, "", "", "", "");
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
    paramViewGroup = paramLayoutInflater.inflate(2131560914, paramViewGroup, false);
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
    if (this.jdField_a_of_type_Afkg != null) {
      this.jdField_a_of_type_Afkg.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Afkg != null) {
      this.jdField_a_of_type_Afkg.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Afkg != null)
    {
      this.jdField_a_of_type_Afkg.a();
      this.jdField_a_of_type_Afkg.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */