package com.tencent.mobileqq.activity;

import android.os.Handler;

class TroopMemberListActivity$26
  implements Runnable
{
  TroopMemberListActivity$26(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void run()
  {
    if ((this.this$0.mFrom == 1) || (this.this$0.mFrom == 11) || (this.this$0.mFrom == 16))
    {
      Object localObject = this.this$0;
      localObject = ((TroopMemberListActivity)localObject).getDiscussionMemberFromDB(((TroopMemberListActivity)localObject).mTroopUin);
      this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(1, localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.26
 * JD-Core Version:    0.7.0.1
 */