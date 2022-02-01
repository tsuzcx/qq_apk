package com.tencent.mobileqq.activity.contact.connections;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.QQToast;

class ConnectsExplorationFriendAdapter$4
  extends CardObserver
{
  ConnectsExplorationFriendAdapter$4(ConnectsExplorationFriendAdapter paramConnectsExplorationFriendAdapter) {}
  
  public void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      QQToast.a(ConnectsExplorationFriendAdapter.a(this.a), 2131698972, 3000).a();
      if (ConnectsExplorationFriendAdapter.a(this.a) != 23) {
        this.a.a(true);
      }
      return;
    }
    QQToast.a(ConnectsExplorationFriendAdapter.a(this.a), 2131698971, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.4
 * JD-Core Version:    0.7.0.1
 */