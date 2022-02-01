package com.tencent.mobileqq.activity;

import java.util.Comparator;

public class TroopMemberListActivity$SearchResultComparator
  implements Comparator<TroopMemberListActivity.ATroopMember>
{
  public TroopMemberListActivity$SearchResultComparator(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public int a(TroopMemberListActivity.ATroopMember paramATroopMember1, TroopMemberListActivity.ATroopMember paramATroopMember2)
  {
    return paramATroopMember1.f.compareToIgnoreCase(paramATroopMember2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.SearchResultComparator
 * JD-Core Version:    0.7.0.1
 */