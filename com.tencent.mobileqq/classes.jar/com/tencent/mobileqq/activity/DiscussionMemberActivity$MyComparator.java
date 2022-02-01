package com.tencent.mobileqq.activity;

import java.util.Comparator;

class DiscussionMemberActivity$MyComparator
  implements Comparator<DiscussionMemberActivity.DiscussionMember>
{
  private DiscussionMemberActivity$MyComparator(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  public int a(DiscussionMemberActivity.DiscussionMember paramDiscussionMember1, DiscussionMemberActivity.DiscussionMember paramDiscussionMember2)
  {
    return paramDiscussionMember1.c.compareToIgnoreCase(paramDiscussionMember2.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.MyComparator
 * JD-Core Version:    0.7.0.1
 */