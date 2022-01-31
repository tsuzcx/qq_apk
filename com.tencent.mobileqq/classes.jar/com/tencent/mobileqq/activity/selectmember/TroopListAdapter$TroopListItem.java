package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;

public class TroopListAdapter$TroopListItem
{
  public int a;
  public DiscussionInfo a;
  public TroopInfo a;
  
  public TroopListAdapter$TroopListItem(TroopListAdapter paramTroopListAdapter, int paramInt, DiscussionInfo paramDiscussionInfo)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
  }
  
  public TroopListAdapter$TroopListItem(TroopListAdapter paramTroopListAdapter, int paramInt, Entity paramEntity)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListAdapter.TroopListItem
 * JD-Core Version:    0.7.0.1
 */