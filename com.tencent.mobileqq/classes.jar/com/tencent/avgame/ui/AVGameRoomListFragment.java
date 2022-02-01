package com.tencent.avgame.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import bcef;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import mxn;
import nim;
import nin;
import nio;

public class AVGameRoomListFragment
  extends PublicBaseFragment
{
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  public String a;
  private nio jdField_a_of_type_Nio;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131363229));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_Nio = new nio(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetSwipListView, null, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Nio);
    ((ImageView)paramView.findViewById(2131363231)).setOnClickListener(new nim(this));
    ((Button)paramView.findViewById(2131363179)).setOnClickListener(new nin(this));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getSerializableExtra("troop_uin");
    if ((paramBundle instanceof String)) {
      this.jdField_a_of_type_JavaLangString = ((String)paramBundle);
    }
    mxn.a(getActivity().app);
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (paramBundle = this.jdField_a_of_type_JavaLangString;; paramBundle = "")
    {
      bcef.b(null, "dc00898", "", "", "0X800B01B", "0X800B01B", 0, 0, "", "", paramBundle, "");
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameRoomListFragment", 2, "onCreateView");
    }
    paramViewGroup = paramLayoutInflater.inflate(2131558743, paramViewGroup, false);
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
      QLog.d("AVGameRoomListFragment", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Nio != null) {
      this.jdField_a_of_type_Nio.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Nio != null) {
      this.jdField_a_of_type_Nio.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Nio != null)
    {
      this.jdField_a_of_type_Nio.a();
      this.jdField_a_of_type_Nio.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment
 * JD-Core Version:    0.7.0.1
 */