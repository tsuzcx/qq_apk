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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalidate hotchat ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(paramRecentUser.uin);
    localStringBuilder.append(";");
    return localStringBuilder.toString();
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool1 = paramBaseQQAppInterface instanceof QQAppInterface;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (paramRecentUser.getType() == 1)
    {
      bool1 = bool2;
      if ((paramRecentUser.lFlag & 1L) != 0L)
      {
        paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getHotChatMng(true);
        bool1 = bool2;
        if (paramBaseQQAppInterface != null)
        {
          bool1 = bool2;
          if (!paramBaseQQAppInterface.b(paramRecentUser.uin)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.HotChatFilter
 * JD-Core Version:    0.7.0.1
 */