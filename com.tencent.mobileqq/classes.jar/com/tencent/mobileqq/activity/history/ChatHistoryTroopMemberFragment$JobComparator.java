package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ChatHistoryTroopMemberFragment$JobComparator
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    return ChnToSpell.b(paramString1, 2).compareToIgnoreCase(ChnToSpell.b(paramString2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.JobComparator
 * JD-Core Version:    0.7.0.1
 */