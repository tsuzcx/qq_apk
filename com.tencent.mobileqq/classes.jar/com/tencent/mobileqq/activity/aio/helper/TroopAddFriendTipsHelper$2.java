package com.tencent.mobileqq.activity.aio.helper;

import afgi;
import amdu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.ArrayList;

public class TroopAddFriendTipsHelper$2
  implements Runnable
{
  public TroopAddFriendTipsHelper$2(afgi paramafgi, String paramString1, String paramString2) {}
  
  public void run()
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((amdu)afgi.a(this.this$0).a(20)).a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.a);
    localTroopBatchAddFriendMgr.a(this.b, localArrayList, 4);
    localTroopBatchAddFriendMgr.d(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.2
 * JD-Core Version:    0.7.0.1
 */