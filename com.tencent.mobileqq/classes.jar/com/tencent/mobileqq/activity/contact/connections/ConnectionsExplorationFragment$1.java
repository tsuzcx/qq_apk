package com.tencent.mobileqq.activity.contact.connections;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ConnectionsExplorationFragment$1
  implements View.OnClickListener
{
  ConnectionsExplorationFragment$1(ConnectionsExplorationFragment paramConnectionsExplorationFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getBaseActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment.1
 * JD-Core Version:    0.7.0.1
 */