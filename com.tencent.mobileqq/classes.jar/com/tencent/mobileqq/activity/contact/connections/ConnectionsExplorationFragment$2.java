package com.tencent.mobileqq.activity.contact.connections;

import anpk;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class ConnectionsExplorationFragment$2
  implements Runnable
{
  ConnectionsExplorationFragment$2(ConnectionsExplorationFragment paramConnectionsExplorationFragment, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    ArrayList localArrayList = ConnectionsExplorationFragment.a(this.this$0).a();
    ThreadManager.getUIHandler().post(new ConnectionsExplorationFragment.2.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment.2
 * JD-Core Version:    0.7.0.1
 */