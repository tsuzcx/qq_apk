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
  public String a;
  private SwipListView b;
  private AVGameRoomListFragment.AVGameRoomListAdapter c;
  
  private void a(View paramView)
  {
    this.b = ((SwipListView)paramView.findViewById(2131429169));
    this.b.setDragEnable(true);
    this.c = new AVGameRoomListFragment.AVGameRoomListAdapter(getQBaseActivity(), (AppInterface)getQBaseActivity().getAppRuntime(), this.b, null, this.a);
    this.b.setAdapter(this.c);
    ((ImageView)paramView.findViewById(2131429171)).setOnClickListener(new AVGameRoomListFragment.1(this));
    ((Button)paramView.findViewById(2131429062)).setOnClickListener(new AVGameRoomListFragment.2(this));
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
      this.a = ((String)paramBundle);
    }
    AvGameManagerImpl.asyncPreloadAVGameProcess(getQBaseActivity().getAppRuntime());
    paramBundle = this.a;
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
    paramViewGroup = paramLayoutInflater.inflate(2131624316, paramViewGroup, false);
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
    AVGameRoomListFragment.AVGameRoomListAdapter localAVGameRoomListAdapter = this.c;
    if (localAVGameRoomListAdapter != null) {
      localAVGameRoomListAdapter.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    AVGameRoomListFragment.AVGameRoomListAdapter localAVGameRoomListAdapter = this.c;
    if (localAVGameRoomListAdapter != null) {
      localAVGameRoomListAdapter.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    AVGameRoomListFragment.AVGameRoomListAdapter localAVGameRoomListAdapter = this.c;
    if (localAVGameRoomListAdapter != null)
    {
      localAVGameRoomListAdapter.a();
      this.c.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment
 * JD-Core Version:    0.7.0.1
 */