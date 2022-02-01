package com.tencent.mobileqq.activity.contact.connections;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class ConnectionsExplorationFragment$4
  extends FriendListObserver
{
  ConnectionsExplorationFragment$4(ConnectionsExplorationFragment paramConnectionsExplorationFragment) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddFriend ");
      localStringBuilder.append(paramString);
      QLog.d("ConnectionsExplorationFragment", 2, localStringBuilder.toString());
    }
    ConnectionsExplorationFragment.a(this.a, false, true);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCancelMayKnowRecommend isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      QLog.d("ConnectionsExplorationFragment", 2, localStringBuilder.toString());
    }
    ConnectionsExplorationFragment.a(this.a, false, true);
  }
  
  public void onGetConnectionsPerson(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCancelMayKnowRecommend isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ConnectionsExplorationFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      ConnectionsExplorationFragment.a(this.a, false, true);
      return;
    }
    if (paramInt1 == 1205) {
      ConnectionsExplorationFragment.a(this.a, false, false);
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetMayKnowRecommend isSuccess=");
      paramBundle.append(paramBoolean);
      QLog.d("ConnectionsExplorationFragment", 2, paramBundle.toString());
    }
    if (paramBoolean) {
      ConnectionsExplorationFragment.a(this.a, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment.4
 * JD-Core Version:    0.7.0.1
 */