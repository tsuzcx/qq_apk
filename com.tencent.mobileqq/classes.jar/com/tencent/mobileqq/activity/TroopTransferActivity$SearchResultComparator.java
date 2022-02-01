package com.tencent.mobileqq.activity;

import java.util.Comparator;

class TroopTransferActivity$SearchResultComparator
  implements Comparator<TroopTransferActivity.TroopMemberItem>
{
  private TroopTransferActivity$SearchResultComparator(TroopTransferActivity paramTroopTransferActivity) {}
  
  public int a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem1, TroopTransferActivity.TroopMemberItem paramTroopMemberItem2)
  {
    return paramTroopMemberItem1.f.compareToIgnoreCase(paramTroopMemberItem2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.SearchResultComparator
 * JD-Core Version:    0.7.0.1
 */