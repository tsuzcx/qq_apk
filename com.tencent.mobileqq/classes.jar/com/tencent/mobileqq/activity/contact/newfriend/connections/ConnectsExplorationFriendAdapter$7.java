package com.tencent.mobileqq.activity.contact.newfriend.connections;

import afly;
import akaa;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collections;
import mqq.os.MqqHandler;

public class ConnectsExplorationFriendAdapter$7
  implements Runnable
{
  public ConnectsExplorationFriendAdapter$7(afly paramafly, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = afly.a(this.this$0).a(afly.a(this.this$0));
    if (localArrayList != null) {
      Collections.sort(localArrayList, afly.a(this.this$0));
    }
    ThreadManager.getUIHandler().post(new ConnectsExplorationFriendAdapter.7.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationFriendAdapter.7
 * JD-Core Version:    0.7.0.1
 */