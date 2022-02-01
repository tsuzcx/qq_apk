package com.tencent.mobileqq.activity.contact.connections;

import aidb;
import amvo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collections;
import mqq.os.MqqHandler;

public class ConnectsExplorationFriendAdapter$7
  implements Runnable
{
  public ConnectsExplorationFriendAdapter$7(aidb paramaidb, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = aidb.a(this.this$0).a(aidb.a(this.this$0));
    if (localArrayList != null) {
      Collections.sort(localArrayList, aidb.a(this.this$0));
    }
    ThreadManager.getUIHandler().post(new ConnectsExplorationFriendAdapter.7.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.7
 * JD-Core Version:    0.7.0.1
 */