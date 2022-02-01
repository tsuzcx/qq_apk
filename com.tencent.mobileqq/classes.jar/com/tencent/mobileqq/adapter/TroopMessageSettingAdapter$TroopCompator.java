package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.Comparator;

public class TroopMessageSettingAdapter$TroopCompator
  implements Comparator<TroopInfo>
{
  public int a(TroopInfo paramTroopInfo1, TroopInfo paramTroopInfo2)
  {
    if (paramTroopInfo1.lastMsgTime > paramTroopInfo2.lastMsgTime) {
      return -1;
    }
    if (paramTroopInfo1.lastMsgTime < paramTroopInfo2.lastMsgTime) {
      return 1;
    }
    return ContactSorter.a(paramTroopInfo1.mComparePartInt, paramTroopInfo1.mCompareSpell, paramTroopInfo2.mComparePartInt, paramTroopInfo2.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopMessageSettingAdapter.TroopCompator
 * JD-Core Version:    0.7.0.1
 */