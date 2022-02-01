package com.tencent.mobileqq.activity;

import java.util.List;

class TroopMemberListActivity$44$3
  implements Runnable
{
  TroopMemberListActivity$44$3(TroopMemberListActivity.44 param44, List paramList) {}
  
  public void run()
  {
    if (this.b.a.isFinishing()) {
      return;
    }
    if (this.b.a.mAdapter != null)
    {
      this.b.a.mAdapter.h = this.a;
      this.b.a.mAdapter.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.44.3
 * JD-Core Version:    0.7.0.1
 */