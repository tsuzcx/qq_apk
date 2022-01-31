package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

public class TroopListAdapter2$TroopCompator
  implements Comparator
{
  private int a(TroopListAdapter2.TroopListItemWithMask paramTroopListItemWithMask)
  {
    if ((a(paramTroopListItemWithMask) == 0L) || (paramTroopListItemWithMask.jdField_a_of_type_Int == 4)) {
      return paramTroopListItemWithMask.jdField_a_of_type_Int + 3;
    }
    return paramTroopListItemWithMask.jdField_a_of_type_Int;
  }
  
  private long a(TroopListAdapter2.TroopListItemWithMask paramTroopListItemWithMask)
  {
    if ((paramTroopListItemWithMask.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof TroopInfo)) {
      return ((TroopInfo)paramTroopListItemWithMask.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    if ((paramTroopListItemWithMask.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramTroopListItemWithMask.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(TroopListAdapter2.TroopListItemWithMask paramTroopListItemWithMask1, TroopListAdapter2.TroopListItemWithMask paramTroopListItemWithMask2)
  {
    if ((paramTroopListItemWithMask1 == null) && (paramTroopListItemWithMask2 == null)) {
      return 0;
    }
    if (paramTroopListItemWithMask1 == null) {
      return -1;
    }
    if (paramTroopListItemWithMask2 == null) {
      return 1;
    }
    if (a(paramTroopListItemWithMask1) == a(paramTroopListItemWithMask2)) {
      return (int)(a(paramTroopListItemWithMask2) - a(paramTroopListItemWithMask1));
    }
    return a(paramTroopListItemWithMask1) - a(paramTroopListItemWithMask2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.TroopCompator
 * JD-Core Version:    0.7.0.1
 */