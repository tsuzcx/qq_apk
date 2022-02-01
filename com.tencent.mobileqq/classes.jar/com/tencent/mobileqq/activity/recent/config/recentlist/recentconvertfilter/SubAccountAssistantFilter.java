package com.tencent.mobileqq.activity.recent.config.recentlist.recentconvertfilter;

import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentConvertFilterProcessor;
import com.tencent.mobileqq.data.RecentUser;

public class SubAccountAssistantFilter
  implements IRecentConvertFilterProcessor
{
  public boolean a(RecentUser paramRecentUser, int paramInt1, int paramInt2)
  {
    return (paramInt2 < paramInt1) && (paramRecentUser.getType() == 7000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentconvertfilter.SubAccountAssistantFilter
 * JD-Core Version:    0.7.0.1
 */