package com.tencent.mobileqq.activity;

import android.os.Handler;
import java.util.List;

class TroopMemberListActivity$42$1$1
  implements Runnable
{
  TroopMemberListActivity$42$1$1(TroopMemberListActivity.42.1 param1, TroopMemberListActivity.ATroopMember paramATroopMember) {}
  
  public void run()
  {
    this.b.b.a.removeItem(this.b.a);
    synchronized (this.b.b.a)
    {
      this.b.b.a.mListData.add(this.a);
      this.b.b.a.mHandler.sendEmptyMessage(9);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.42.1.1
 * JD-Core Version:    0.7.0.1
 */