package com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentDataConvertProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;

public class SpecialConverter
  implements IRecentDataConvertProcessor
{
  public RecentBaseData a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    int i = paramRecentUser.getType();
    if (i != 4000)
    {
      if (i != 7220)
      {
        if (i == 8111) {
          return new RecentItemMayKnowFriendData(paramRecentUser, paramBaseQQAppInterface.getCurrentAccountUin());
        }
      }
      else if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) && (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getRemoveKandianFlag())) {
        return new RecentItemKandianMergeData(paramRecentUser);
      }
    }
    else {
      if ((paramRecentUser.msg == null) || ((paramRecentUser.msg instanceof String))) {
        break label105;
      }
    }
    return null;
    label105:
    return new RecentItemNewFriendMsgData(paramRecentUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert.SpecialConverter
 * JD-Core Version:    0.7.0.1
 */