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
    return "hidden_RecentUser " + paramInt + "," + paramRecentUser.uin + ";";
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    if ((paramRecentUser.getType() == 3000) && (paramBaseQQAppInterface != null))
    {
      paramBaseQQAppInterface = ((DiscussionManager)paramBaseQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramRecentUser.uin);
      return (paramBaseQQAppInterface == null) || (paramBaseQQAppInterface.isUIControlFlag_Hidden_RecentUser()) || (paramBaseQQAppInterface.isHidden());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.DiscussHiddenFilter
 * JD-Core Version:    0.7.0.1
 */