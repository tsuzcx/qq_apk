package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;

public class TroopListAdapter2$TroopListItem
{
  public int a;
  public DiscussionInfo a;
  public TroopInfo a;
  public int b;
  
  public TroopListAdapter2$TroopListItem(int paramInt, DiscussionInfo paramDiscussionInfo)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
  }
  
  public TroopListAdapter2$TroopListItem(int paramInt1, DiscussionInfo paramDiscussionInfo, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
    this.b = paramInt2;
  }
  
  public TroopListAdapter2$TroopListItem(int paramInt, Entity paramEntity)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem
 * JD-Core Version:    0.7.0.1
 */