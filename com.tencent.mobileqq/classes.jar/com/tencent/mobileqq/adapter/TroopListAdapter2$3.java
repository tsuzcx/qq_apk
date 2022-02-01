package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class TroopListAdapter2$3
  implements Runnable
{
  TroopListAdapter2$3(TroopListAdapter2 paramTroopListAdapter2) {}
  
  public void run()
  {
    List localList = TroopListAdapter2.a(this.this$0);
    ThreadManager.getUIHandler().post(new TroopListAdapter2.3.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.3
 * JD-Core Version:    0.7.0.1
 */