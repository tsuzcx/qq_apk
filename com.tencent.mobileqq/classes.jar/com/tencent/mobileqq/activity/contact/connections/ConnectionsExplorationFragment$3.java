package com.tencent.mobileqq.activity.contact.connections;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class ConnectionsExplorationFragment$3
  extends FriendListObserver
{
  ConnectionsExplorationFragment$3(ConnectionsExplorationFragment paramConnectionsExplorationFragment) {}
  
  public void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onAddFriend " + paramString);
    }
    ConnectionsExplorationFragment.a(this.a, false, true);
  }
  
  public void onAddReqStatesChanged(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onAddReqStatesChanged isSuccess=" + paramBoolean + " " + paramString);
    }
    ConnectionsExplorationFragment.a(this.a, false, true);
  }
  
  public void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onCancelMayKnowRecommend isSuccess=" + paramBoolean + " " + paramString);
    }
    ConnectionsExplorationFragment.a(this.a, false, true);
  }
  
  public void onGetConnectionsPerson(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onCancelMayKnowRecommend isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ConnectionsExplorationFragment.a(this.a, false, true);
    }
    while (paramInt1 != 1205) {
      return;
    }
    ConnectionsExplorationFragment.a(this.a, false, false);
  }
  
  public void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onGetMayKnowRecommend isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ConnectionsExplorationFragment.a(this.a, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment.3
 * JD-Core Version:    0.7.0.1
 */