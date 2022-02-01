package com.tencent.biz.addContactTroopView;

import tencent.im.troop_view.troopviewInfo.RspBody;

class AddContactTroopManage$1
  implements Runnable
{
  AddContactTroopManage$1(AddContactTroopManage paramAddContactTroopManage, troopviewInfo.RspBody paramRspBody) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      this.this$0.b = this.a;
      AddContactTroopManage.a(this.this$0, this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.AddContactTroopManage.1
 * JD-Core Version:    0.7.0.1
 */