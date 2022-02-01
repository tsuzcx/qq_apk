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
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramATroopMember1.c.compareToIgnoreCase(paramATroopMember2.c);
    }
    label89:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            if (this.jdField_a_of_type_Int != 2) {
              break label89;
            }
            if (paramATroopMember1.jdField_b_of_type_Long == paramATroopMember2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramATroopMember1.jdField_b_of_type_Long <= paramATroopMember2.jdField_b_of_type_Long) {
              break;
            }
          } while (this.jdField_a_of_type_Boolean);
          return 1;
          if (this.jdField_a_of_type_Boolean) {}
          for (i = j;; i = -1) {
            return i;
          }
          if (this.jdField_a_of_type_Int != 3) {
            break label149;
          }
          if (paramATroopMember1.a == paramATroopMember2.a) {
            return 0;
          }
          if (paramATroopMember1.a <= paramATroopMember2.a) {
            break;
          }
        } while (this.jdField_a_of_type_Boolean);
        return 1;
        if (this.jdField_a_of_type_Boolean) {}
        for (i = k;; i = -1) {
          return i;
        }
        if (this.jdField_a_of_type_Int != 1) {
          break label208;
        }
        if (paramATroopMember1.f != paramATroopMember2.f) {
          break;
        }
        j = paramATroopMember1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramATroopMember2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramATroopMember1.f >= paramATroopMember2.f);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramATroopMember1.n == paramATroopMember2.n) {
        return paramATroopMember1.c.compareToIgnoreCase(paramATroopMember2.c);
      }
      return paramATroopMember2.n - paramATroopMember1.n;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.MyComparator
 * JD-Core Version:    0.7.0.1
 */