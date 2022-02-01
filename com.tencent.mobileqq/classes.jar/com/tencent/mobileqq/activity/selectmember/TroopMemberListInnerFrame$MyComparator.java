package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import java.util.Comparator;

class TroopMemberListInnerFrame$MyComparator
  implements Comparator<TroopMemberInfo>
{
  private TroopMemberListInnerFrame$MyComparator(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public int a(TroopMemberInfo paramTroopMemberInfo1, TroopMemberInfo paramTroopMemberInfo2)
  {
    if ((paramTroopMemberInfo1 != null) && (paramTroopMemberInfo1.displayedNamePinyinFirst != null) && (paramTroopMemberInfo2 != null)) {
      return paramTroopMemberInfo1.displayedNamePinyinFirst.compareToIgnoreCase(paramTroopMemberInfo2.displayedNamePinyinFirst);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.MyComparator
 * JD-Core Version:    0.7.0.1
 */