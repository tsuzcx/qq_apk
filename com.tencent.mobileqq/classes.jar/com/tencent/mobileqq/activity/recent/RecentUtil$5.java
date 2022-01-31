package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import java.util.List;
import sdf;

public final class RecentUtil$5
  implements Runnable
{
  public RecentUtil$5(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = sdf.a().a(this.a);
    int i;
    int j;
    label19:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localObject = (TroopBarData)localList.get(j);
      if (localObject != null) {
        break label58;
      }
    }
    for (;;)
    {
      j += 1;
      break label19;
      i = localList.size();
      break;
      label58:
      localObject = this.a.a().a(((TroopBarData)localObject).mUin, 1008);
      if (localObject != null) {
        sdf.a().a(this.a, ((QQMessageFacade.Message)localObject).time);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.5
 * JD-Core Version:    0.7.0.1
 */