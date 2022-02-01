package com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;

public class DiscussHiddenFilter
  implements IRecentCheckFilterProcessor
{
  public String a(RecentUser paramRecentUser, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hidden_RecentUser ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(paramRecentUser.uin);
    localStringBuilder.append(";");
    return localStringBuilder.toString();
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    int i = paramRecentUser.getType();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 3000)
    {
      bool1 = bool2;
      if (paramBaseQQAppInterface != null)
      {
        paramBaseQQAppInterface = ((DiscussionManager)paramBaseQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(paramRecentUser.uin);
        if ((paramBaseQQAppInterface != null) && (!paramBaseQQAppInterface.isUIControlFlag_Hidden_RecentUser()))
        {
          bool1 = bool2;
          if (!paramBaseQQAppInterface.isHidden()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.DiscussHiddenFilter
 * JD-Core Version:    0.7.0.1
 */