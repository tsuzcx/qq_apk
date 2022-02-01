package com.tencent.mobileqq.activity;

import java.util.Comparator;

public class TroopMemberListActivity$MyComparator
  implements Comparator<TroopMemberListActivity.ATroopMember>
{
  int a = -1;
  boolean b = false;
  
  public TroopMemberListActivity$MyComparator(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  public int a(TroopMemberListActivity.ATroopMember paramATroopMember1, TroopMemberListActivity.ATroopMember paramATroopMember2)
  {
    int j = this.a;
    if (j == 0) {
      return paramATroopMember1.d.compareToIgnoreCase(paramATroopMember2.d);
    }
    int i = -1;
    if (j == 2)
    {
      if (paramATroopMember1.t == paramATroopMember2.t) {
        return 0;
      }
      if (paramATroopMember1.t > paramATroopMember2.t)
      {
        if (this.b) {
          return -1;
        }
        return 1;
      }
      if (this.b) {
        i = 1;
      }
      return i;
    }
    if (j == 3)
    {
      if (paramATroopMember1.r == paramATroopMember2.r) {
        return 0;
      }
      if (paramATroopMember1.r > paramATroopMember2.r)
      {
        if (this.b) {
          return -1;
        }
        return 1;
      }
      if (this.b) {
        i = 1;
      }
      return i;
    }
    if (j == 1)
    {
      if (paramATroopMember1.I == paramATroopMember2.I)
      {
        i = paramATroopMember1.c.compareToIgnoreCase(paramATroopMember2.c);
        if (i == 0) {
          return 0;
        }
        if (i > 0) {
          return 1;
        }
        return -1;
      }
      if (paramATroopMember1.I < paramATroopMember2.I) {
        return 1;
      }
      return -1;
    }
    if (j == 8)
    {
      if (paramATroopMember1.T == paramATroopMember2.T) {
        return paramATroopMember1.d.compareToIgnoreCase(paramATroopMember2.d);
      }
      return paramATroopMember2.T - paramATroopMember1.T;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.MyComparator
 * JD-Core Version:    0.7.0.1
 */