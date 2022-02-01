package com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class HotChatFilter
  implements IRecentCheckFilterProcessor
{
  public String a(RecentUser paramRecentUser, int paramInt)
  {
    return "invalidate hotchat " + paramInt + "," + paramRecentUser.uin + ";";
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool = true;
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {}
    while ((paramRecentUser.getType() != 1) || ((paramRecentUser.lFlag & 1L) == 0L)) {
      return false;
    }
    paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getHotChatMng(true);
    if ((paramBaseQQAppInterface != null) && (!paramBaseQQAppInterface.b(paramRecentUser.uin))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.HotChatFilter
 * JD-Core Version:    0.7.0.1
 */