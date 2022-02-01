package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import java.util.Comparator;

class TroopAssistantActivity$23
  implements Comparator<RecentBaseData>
{
  TroopAssistantActivity$23(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    if (((paramRecentBaseData1 instanceof RecentTroopAssistantItem)) && ((paramRecentBaseData2 instanceof RecentTroopAssistantItem)))
    {
      paramRecentBaseData1 = (RecentTroopAssistantItem)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentTroopAssistantItem)paramRecentBaseData2;
      TroopManager localTroopManager = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
      boolean bool1 = localTroopManager.o(paramRecentBaseData1.getRecentUserUin());
      boolean bool2 = localTroopManager.o(paramRecentBaseData2.getRecentUserUin());
      if ((bool1) && (!bool2)) {
        return -1;
      }
      if ((!bool1) && (bool2)) {
        return 1;
      }
      if ((!bool1) && (!bool2))
      {
        l1 = Math.max(paramRecentBaseData1.getLastMsgTime(), paramRecentBaseData1.getLastDraftTime());
        l2 = Math.max(paramRecentBaseData2.getLastMsgTime(), paramRecentBaseData2.getLastDraftTime());
      }
      else
      {
        l1 = paramRecentBaseData1.mDisplayTime;
        l2 = paramRecentBaseData2.mDisplayTime;
      }
      if (l1 > l2) {
        l1 = 3L;
      } else if (l1 < l2) {
        l1 = 1L;
      } else {
        l1 = 2L;
      }
      long l2 = 0;
      long l1 = (int)(l1 | l2) - (int)(l2 | 0x2);
      if (l1 == 0L) {
        return 0;
      }
      if (l1 < 0L) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.23
 * JD-Core Version:    0.7.0.1
 */