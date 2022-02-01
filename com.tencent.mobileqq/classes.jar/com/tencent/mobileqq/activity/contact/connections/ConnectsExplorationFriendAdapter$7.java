package com.tencent.mobileqq.activity.contact.connections;

import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collections;
import mqq.os.MqqHandler;

class ConnectsExplorationFriendAdapter$7
  implements Runnable
{
  ConnectsExplorationFriendAdapter$7(ConnectsExplorationFriendAdapter paramConnectsExplorationFriendAdapter, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = ConnectsExplorationFriendAdapter.d(this.this$0).a(ConnectsExplorationFriendAdapter.a(this.this$0));
    if (localArrayList != null) {
      Collections.sort(localArrayList, ConnectsExplorationFriendAdapter.e(this.this$0));
    }
    ThreadManager.getUIHandler().post(new ConnectsExplorationFriendAdapter.7.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.7
 * JD-Core Version:    0.7.0.1
 */