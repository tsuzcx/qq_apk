package com.tencent.mobileqq.activity.contact.connections;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;

public class ConnectionsExplorationClidFragment
  extends BaseFragment
{
  SwipListView.RightIconMenuListener a = new ConnectionsExplorationClidFragment.1(this);
  private QQAppInterface b;
  private int c = 0;
  private int d = 0;
  private boolean e = false;
  private boolean f = false;
  private SwipListView g = null;
  private ConnectsExplorationFriendAdapter h;
  
  private void a(View paramView)
  {
    this.b = getBaseActivity().app;
    this.g = ((SwipListView)paramView.findViewById(2131444459));
    View localView = paramView.findViewById(2131432509);
    paramView = paramView.findViewById(2131437652);
    this.h = new ConnectsExplorationFriendAdapter(getBaseActivity(), this.b, this.g, localView, paramView, this.e, this.c, this.d);
    if (this.f)
    {
      this.h.a();
      this.f = false;
    }
    this.g.setDragEnable(true);
    this.g.setRightIconMenuListener(this.a);
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ConnectionsExplorationClidFragment onPageSelected ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("ConnectionsExplorationClidFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      ((ConnectsExplorationFriendAdapter)localObject).a();
      return;
    }
    this.f = true;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ConnectionsExplorationClidFragment doOnDestroy ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("ConnectionsExplorationClidFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((ConnectsExplorationFriendAdapter)localObject).c();
    }
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131627599, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
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
    ConnectsExplorationFriendAdapter localConnectsExplorationFriendAdapter = this.h;
    if (localConnectsExplorationFriendAdapter != null) {
      localConnectsExplorationFriendAdapter.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationClidFragment
 * JD-Core Version:    0.7.0.1
 */