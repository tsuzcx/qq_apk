package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

class ForwardRecentActivity$10
  implements Comparator<RecentUser>
{
  ForwardRecentActivity$10(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    return (int)(paramRecentUser2.showUpTime - paramRecentUser1.showUpTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.10
 * JD-Core Version:    0.7.0.1
 */