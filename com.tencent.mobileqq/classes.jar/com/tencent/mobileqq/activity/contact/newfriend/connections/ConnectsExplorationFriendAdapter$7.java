package com.tencent.mobileqq.activity.contact.newfriend.connections;

import ahns;
import alwd;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collections;
import mqq.os.MqqHandler;

public class ConnectsExplorationFriendAdapter$7
  implements Runnable
{
  public ConnectsExplorationFriendAdapter$7(ahns paramahns, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = ahns.a(this.this$0).a(ahns.a(this.this$0));
    if (localArrayList != null) {
      Collections.sort(localArrayList, ahns.a(this.this$0));
    }
    ThreadManager.getUIHandler().post(new ConnectsExplorationFriendAdapter.7.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationFriendAdapter.7
 * JD-Core Version:    0.7.0.1
 */