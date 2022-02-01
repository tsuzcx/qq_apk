package com.tencent.mobileqq.activity.contact.newfriend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendMoreSysMsgSuspiciousFragment
  extends PublicBaseFragment
{
  private SwipListView a;
  private NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter b;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131439340);
    ((TextView)localView.findViewById(2131447476)).setText(2131897418);
    this.a = ((SwipListView)paramView.findViewById(2131446714));
    this.a.setDragEnable(true);
    this.b = new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter(getBaseActivity(), getBaseActivity().app, this.a, localView);
    this.a.setAdapter(this.b);
    paramView.findViewById(2131436180).setOnClickListener(new NewFriendMoreSysMsgSuspiciousFragment.1(this));
    ((TextView)paramView.findViewById(2131436227)).setText(2131897415);
    ReportController.b(getBaseActivity().app, "dc00898", "", "", "0X800A32B", "0X800A32B", 0, 0, "", "", "", "");
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
    paramViewGroup = paramLayoutInflater.inflate(2131627600, paramViewGroup, false);
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
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onDestroy");
    }
    NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter localSysMsgSuspiciousAdapter = this.b;
    if (localSysMsgSuspiciousAdapter != null) {
      localSysMsgSuspiciousAdapter.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter localSysMsgSuspiciousAdapter = this.b;
    if (localSysMsgSuspiciousAdapter != null) {
      localSysMsgSuspiciousAdapter.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter localSysMsgSuspiciousAdapter = this.b;
    if (localSysMsgSuspiciousAdapter != null)
    {
      localSysMsgSuspiciousAdapter.a();
      this.b.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */