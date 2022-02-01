package com.tencent.mobileqq.activity.contact.connections;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.QQToast;

class ConnectsExplorationFriendAdapter$4
  extends CardObserver
{
  ConnectsExplorationFriendAdapter$4(ConnectsExplorationFriendAdapter paramConnectsExplorationFriendAdapter) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      QQToast.makeText(ConnectsExplorationFriendAdapter.c(this.a), 2131897060, 3000).show();
      if (ConnectsExplorationFriendAdapter.a(this.a) != 23) {
        this.a.a(true);
      }
    }
    else
    {
      QQToast.makeText(ConnectsExplorationFriendAdapter.c(this.a), 2131897059, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.4
 * JD-Core Version:    0.7.0.1
 */