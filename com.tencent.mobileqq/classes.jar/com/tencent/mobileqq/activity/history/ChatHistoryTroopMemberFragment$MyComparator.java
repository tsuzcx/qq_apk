package com.tencent.mobileqq.activity.history;

import java.util.Comparator;

public class ChatHistoryTroopMemberFragment$MyComparator
  implements Comparator<ChatHistoryTroopMemberFragment.ATroopMember>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public ChatHistoryTroopMemberFragment$MyComparator(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember1, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember2)
  {
    int j = this.jdField_a_of_type_Int;
    if (j == 0) {
      return paramATroopMember1.c.compareToIgnoreCase(paramATroopMember2.c);
    }
    int i = -1;
    if (j == 2)
    {
      if (paramATroopMember1.jdField_b_of_type_Long == paramATroopMember2.jdField_b_of_type_Long) {
        return 0;
      }
      if (paramATroopMember1.jdField_b_of_type_Long > paramATroopMember2.jdField_b_of_type_Long)
      {
        if (this.jdField_a_of_type_Boolean) {
          return -1;
        }
        return 1;
      }
      if (this.jdField_a_of_type_Boolean) {
        i = 1;
      }
      return i;
    }
    if (j == 3)
    {
      if (paramATroopMember1.a == paramATroopMember2.a) {
        return 0;
      }
      if (paramATroopMember1.a > paramATroopMember2.a)
      {
        if (this.jdField_a_of_type_Boolean) {
          return -1;
        }
        return 1;
      }
      if (this.jdField_a_of_type_Boolean) {
        i = 1;
      }
      return i;
    }
    if (j == 1)
    {
      if (paramATroopMember1.f == paramATroopMember2.f)
      {
        i = paramATroopMember1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramATroopMember2.jdField_b_of_type_JavaLangString);
        if (i == 0) {
          return 0;
        }
        if (i > 0) {
          return 1;
        }
        return -1;
      }
      if (paramATroopMember1.f < paramATroopMember2.f) {
        return 1;
      }
      return -1;
    }
    if (j == 8)
    {
      if (paramATroopMember1.n == paramATroopMember2.n) {
        return paramATroopMember1.c.compareToIgnoreCase(paramATroopMember2.c);
      }
      return paramATroopMember2.n - paramATroopMember1.n;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.MyComparator
 * JD-Core Version:    0.7.0.1
 */