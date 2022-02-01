package com.tencent.mobileqq.activity.recent.config.recentlist.recentconvertfilter;

import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentConvertFilterProcessor;
import com.tencent.mobileqq.data.RecentUser;

public class ReadInJoyFilter
  implements IRecentConvertFilterProcessor
{
  public boolean a(RecentUser paramRecentUser, int paramInt1, int paramInt2)
  {
    return paramRecentUser.getType() == 9503;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentconvertfilter.ReadInJoyFilter
 * JD-Core Version:    0.7.0.1
 */