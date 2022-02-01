package com.tencent.mobileqq.activity.aio.helper;

import anwd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.ArrayList;

class TroopAddFriendTipsHelper$2
  implements Runnable
{
  TroopAddFriendTipsHelper$2(TroopAddFriendTipsHelper paramTroopAddFriendTipsHelper, String paramString1, String paramString2) {}
  
  public void run()
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((anwd)TroopAddFriendTipsHelper.a(this.this$0).a(20)).a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.a);
    localTroopBatchAddFriendMgr.a(this.b, localArrayList, 4);
    localTroopBatchAddFriendMgr.d(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.2
 * JD-Core Version:    0.7.0.1
 */