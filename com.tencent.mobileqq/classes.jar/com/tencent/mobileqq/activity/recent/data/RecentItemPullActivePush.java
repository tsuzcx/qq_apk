package com.tencent.mobileqq.activity.recent.data;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class RecentItemPullActivePush
  extends AbsRecentUserBusinessBaseData
{
  public long time;
  
  public RecentItemPullActivePush(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(String paramString, long paramLong)
  {
    this.mTitleName = paramString;
    this.time = paramLong;
    this.mShowTime = TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush
 * JD-Core Version:    0.7.0.1
 */