package com.tencent.biz.pubaccount.troopbarassit;

import java.util.Comparator;

class TroopBarAssistantManager$1
  implements Comparator<TroopBarData>
{
  TroopBarAssistantManager$1(TroopBarAssistantManager paramTroopBarAssistantManager) {}
  
  public int a(TroopBarData paramTroopBarData1, TroopBarData paramTroopBarData2)
  {
    long l1 = Math.max(paramTroopBarData1.mLastMsgTime, paramTroopBarData1.mLastDraftTime);
    long l2 = Math.max(paramTroopBarData2.mLastMsgTime, paramTroopBarData2.mLastDraftTime);
    boolean bool = paramTroopBarData2.mIsSticky;
    int i = -1;
    if ((bool) && (!paramTroopBarData1.mIsSticky)) {}
    do
    {
      do
      {
        return 1;
        if ((!paramTroopBarData2.mIsSticky) && (paramTroopBarData1.mIsSticky)) {
          return -1;
        }
        if ((!paramTroopBarData2.mIsSticky) || (!paramTroopBarData1.mIsSticky)) {
          break;
        }
      } while (paramTroopBarData2.mLastStickyTime > paramTroopBarData1.mLastStickyTime);
      if (paramTroopBarData2.mLastStickyTime != paramTroopBarData1.mLastStickyTime) {
        return i;
      }
      break;
    } while (l1 < l2);
    if (l1 == l2) {
      i = 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.1
 * JD-Core Version:    0.7.0.1
 */