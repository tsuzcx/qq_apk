package com.tencent.avgame.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.avgame.business.api.impl.AvGameManagerImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class AVGameRoomListFragment
  extends QPublicBaseFragment
{
  private AVGameRoomListFragment.AVGameRoomListAdapter jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  public String a;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramView.findViewById(2131363295));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter = new AVGameRoomListFragment.AVGameRoomListAdapter(getQBaseActivity(), (AppInterface)getQBaseActivity().getAppRuntime(), this.jdField_a_of_type_ComTencentWidgetSwipListView, null, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter);
    ((ImageView)paramView.findViewById(2131363297)).setOnClickListener(new AVGameRoomListFragment.1(this));
    ((Button)paramView.findViewById(2131363188)).setOnClickListener(new AVGameRoomListFragment.2(this));
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
    paramBundle = getQBaseActivity().getIntent().getSerializableExtra("troop_uin");
    if ((paramBundle instanceof String)) {
      this.jdField_a_of_type_JavaLangString = ((String)paramBundle);
    }
    AvGameManagerImpl.asyncPreloadAVGameProcess(getQBaseActivity().getAppRuntime());
    paramBundle = this.jdField_a_of_type_JavaLangString;
    if (paramBundle == null) {
      paramBundle = "";
    }
    ReportController.b(null, "dc00898", "", "", "0X800B01B", "0X800B01B", 0, 0, "", "", paramBundle, "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameRoomListFragment", 2, "onCreateView");
    }
    paramViewGroup = paramLayoutInflater.inflate(2131558699, paramViewGroup, false);
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
      QLog.d("AVGameRoomListFragment", 2, "onDestroy");
    }
    AVGameRoomListFragment.AVGameRoomListAdapter localAVGameRoomListAdapter = this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter;
    if (localAVGameRoomListAdapter != null) {
      localAVGameRoomListAdapter.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    AVGameRoomListFragment.AVGameRoomListAdapter localAVGameRoomListAdapter = this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter;
    if (localAVGameRoomListAdapter != null) {
      localAVGameRoomListAdapter.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    AVGameRoomListFragment.AVGameRoomListAdapter localAVGameRoomListAdapter = this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter;
    if (localAVGameRoomListAdapter != null)
    {
      localAVGameRoomListAdapter.a();
      this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment
 * JD-Core Version:    0.7.0.1
 */