package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class TroopMemberListActivity$JobComparator
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    return ChnToSpell.a(paramString1, 2).compareToIgnoreCase(ChnToSpell.a(paramString2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.JobComparator
 * JD-Core Version:    0.7.0.1
 */