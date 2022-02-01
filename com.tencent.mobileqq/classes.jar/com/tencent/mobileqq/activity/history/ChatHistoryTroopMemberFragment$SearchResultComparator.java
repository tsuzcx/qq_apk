package com.tencent.mobileqq.activity.history;

import java.util.Comparator;

public class ChatHistoryTroopMemberFragment$SearchResultComparator
  implements Comparator<ChatHistoryTroopMemberFragment.ATroopMember>
{
  public ChatHistoryTroopMemberFragment$SearchResultComparator(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public int a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember1, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember2)
  {
    return paramATroopMember1.g.compareToIgnoreCase(paramATroopMember2.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.SearchResultComparator
 * JD-Core Version:    0.7.0.1
 */