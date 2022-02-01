package com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentDataConvertProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import cooperation.readinjoy.ReadInJoyHelper;

public class SpecialConverter
  implements IRecentDataConvertProcessor
{
  public RecentBaseData a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    switch (paramRecentUser.getType())
    {
    }
    do
    {
      do
      {
        return null;
      } while ((paramRecentUser.msg != null) && (!(paramRecentUser.msg instanceof String)));
      return new RecentItemNewFriendMsgData(paramRecentUser);
      return new RecentItemMayKnowFriendData(paramRecentUser, paramBaseQQAppInterface.getCurrentAccountUin());
    } while ((!ReadInJoyHelper.a((QQAppInterface)paramBaseQQAppInterface)) || (ReadInJoyHelper.c()));
    return new RecentItemKandianMergeData(paramRecentUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert.SpecialConverter
 * JD-Core Version:    0.7.0.1
 */