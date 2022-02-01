package com.tencent.mobileqq.activity.contact.connections;

import android.view.View;
import com.tencent.widget.SwipListView.RightIconMenuListener;

class ConnectionsExplorationClidFragment$1
  implements SwipListView.RightIconMenuListener
{
  ConnectionsExplorationClidFragment$1(ConnectionsExplorationClidFragment paramConnectionsExplorationClidFragment) {}
  
  public void onRightIconMenuHide(View paramView)
  {
    paramView = this.a.getParentFragment();
    if ((paramView != null) && ((paramView instanceof ConnectionsExplorationFragment))) {
      ((ConnectionsExplorationFragment)paramView).a(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    paramView = this.a.getParentFragment();
    if ((paramView != null) && ((paramView instanceof ConnectionsExplorationFragment))) {
      ((ConnectionsExplorationFragment)paramView).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationClidFragment.1
 * JD-Core Version:    0.7.0.1
 */