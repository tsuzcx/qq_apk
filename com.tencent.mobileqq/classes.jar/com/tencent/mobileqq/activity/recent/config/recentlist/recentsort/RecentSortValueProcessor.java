package com.tencent.mobileqq.activity.recent.config.recentlist.recentsort;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentSortValueProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
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
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return paramInt;
    }
    int k = paramRecentUserBaseData.mUnreadNum;
    int j = 0;
    int i = j;
    if (k > 0)
    {
      i = j;
      if (paramRecentUserBaseData.mUser.getType() == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramBaseQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append(paramRecentUserBaseData.mUser.uin);
        i = j;
        if (QvipSpecialCareUtil.a(localStringBuilder.toString()))
        {
          i = j;
          if (!a((QQAppInterface)paramBaseQQAppInterface, paramRecentUserBaseData.mUser.uin, 0)) {
            i = 1;
          }
        }
      }
    }
    if (i != 0) {
      paramInt = 4096;
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentsort.RecentSortValueProcessor
 * JD-Core Version:    0.7.0.1
 */