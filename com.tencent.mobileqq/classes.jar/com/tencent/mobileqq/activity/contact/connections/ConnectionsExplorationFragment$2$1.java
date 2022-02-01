package com.tencent.mobileqq.activity.contact.connections;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import java.util.ArrayList;

class ConnectionsExplorationFragment$2$1
  implements Runnable
{
  ConnectionsExplorationFragment$2$1(ConnectionsExplorationFragment.2 param2, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList = this.a;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      ConnectionsExplorationFragment.b(this.b.this$0).clear();
      ConnectionsExplorationFragment.b(this.b.this$0).addAll(this.a);
      ConnectionsExplorationFragment.c(this.b.this$0);
      if (!this.b.a)
      {
        if (ConnectionsExplorationFragment.d(this.b.this$0) != null) {
          ConnectionsExplorationFragment.d(this.b.this$0).a(ConnectionsExplorationFragment.b(this.b.this$0));
        }
        ConnectionsExplorationFragment.e(this.b.this$0).setVisibility(0);
        ConnectionsExplorationFragment.f(this.b.this$0).setVisibility(8);
      }
    }
    else
    {
      ConnectionsExplorationFragment.e(this.b.this$0).setVisibility(8);
      ConnectionsExplorationFragment.f(this.b.this$0).setVisibility(0);
      if (this.b.b) {
        ConnectionsExplorationFragment.a(this.b.this$0).f(5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment.2.1
 * JD-Core Version:    0.7.0.1
 */