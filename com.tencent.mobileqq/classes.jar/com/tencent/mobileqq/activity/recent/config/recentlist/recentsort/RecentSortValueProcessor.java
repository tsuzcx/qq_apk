package com.tencent.mobileqq.activity.recent.config.recentlist.recentsort;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentSortValueProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class RecentSortValueProcessor
  implements IRecentSortValueProcessor
{
  private boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return (paramQQAppInterface.getConversationFacade() != null) && (paramQQAppInterface.getConversationFacade().d(paramString, paramInt) > 0);
  }
  
  public int a(BaseQQAppInterface paramBaseQQAppInterface, RecentUserBaseData paramRecentUserBaseData, int paramInt)
  {
    int j = 0;
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {}
    int i;
    do
    {
      return paramInt;
      i = j;
      if (paramRecentUserBaseData.mUnreadNum > 0)
      {
        i = j;
        if (paramRecentUserBaseData.mUser.getType() == 0)
        {
          i = j;
          if (QvipSpecialCareManager.a(paramBaseQQAppInterface.getCurrentAccountUin() + paramRecentUserBaseData.mUser.uin))
          {
            i = j;
            if (!a((QQAppInterface)paramBaseQQAppInterface, paramRecentUserBaseData.mUser.uin, 0)) {
              i = 1;
            }
          }
        }
      }
    } while (i == 0);
    return 4096;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentsort.RecentSortValueProcessor
 * JD-Core Version:    0.7.0.1
 */