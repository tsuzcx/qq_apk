package com.tencent.mobileqq.activity;

import android.os.Handler;

class TroopMemberListActivity$26
  implements Runnable
{
  TroopMemberListActivity$26(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void run()
  {
    if ((this.this$0.d == 1) || (this.this$0.d == 11) || (this.this$0.d == 16))
    {
      Object[] arrayOfObject = this.this$0.a(this.this$0.b);
      this.this$0.a.sendMessage(this.this$0.a.obtainMessage(1, arrayOfObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.26
 * JD-Core Version:    0.7.0.1
 */