package com.tencent.mobileqq.activity.contact.connections;

import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.qphone.base.util.QLog;

class ConnectionsExplorationFragment$3
  extends FriendObserver
{
  ConnectionsExplorationFragment$3(ConnectionsExplorationFragment paramConnectionsExplorationFragment) {}
  
  protected void onAddReqStatesChanged(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddReqStatesChanged isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      QLog.d("ConnectionsExplorationFragment", 2, localStringBuilder.toString());
    }
    ConnectionsExplorationFragment.a(this.a, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment.3
 * JD-Core Version:    0.7.0.1
 */