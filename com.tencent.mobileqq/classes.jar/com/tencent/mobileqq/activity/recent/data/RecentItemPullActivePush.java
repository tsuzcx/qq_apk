package com.tencent.mobileqq.activity.recent.data;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class RecentItemPullActivePush
  extends RecentUserBaseData
{
  public long b;
  
  public RecentItemPullActivePush(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = paramLong;
    this.c = TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush
 * JD-Core Version:    0.7.0.1
 */