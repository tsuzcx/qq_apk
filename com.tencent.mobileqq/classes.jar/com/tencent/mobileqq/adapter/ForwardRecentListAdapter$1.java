package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class ForwardRecentListAdapter$1
  implements Runnable
{
  ForwardRecentListAdapter$1(ForwardRecentListAdapter paramForwardRecentListAdapter, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = ForwardRecentListAdapter.a(this.this$0, this.a);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ForwardRecentListAdapter.1.1(this, localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentListAdapter.1
 * JD-Core Version:    0.7.0.1
 */