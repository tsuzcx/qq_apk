package com.tencent.mobileqq.activity.history;

import java.util.Comparator;

public class ChatHistoryTroopMemberFragment$MyComparator
  implements Comparator<ChatHistoryTroopMemberFragment.ATroopMember>
{
  int a = -1;
  boolean b = false;
  
  public ChatHistoryTroopMemberFragment$MyComparator(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  public int a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember1, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember2)
  {
    int j = this.a;
    if (j == 0) {
      return paramATroopMember1.d.compareToIgnoreCase(paramATroopMember2.d);
    }
    int i = -1;
    if (j == 2)
    {
      if (paramATroopMember1.u == paramATroopMember2.u) {
        return 0;
      }
      if (paramATroopMember1.u > paramATroopMember2.u)
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
      if (paramATroopMember1.s == paramATroopMember2.s) {
        return 0;
      }
      if (paramATroopMember1.s > paramATroopMember2.s)
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
      if (paramATroopMember1.H == paramATroopMember2.H)
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
      if (paramATroopMember1.H < paramATroopMember2.H) {
        return 1;
      }
      return -1;
    }
    if (j == 8)
    {
      if (paramATroopMember1.V == paramATroopMember2.V) {
        return paramATroopMember1.d.compareToIgnoreCase(paramATroopMember2.d);
      }
      return paramATroopMember2.V - paramATroopMember1.V;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.MyComparator
 * JD-Core Version:    0.7.0.1
 */