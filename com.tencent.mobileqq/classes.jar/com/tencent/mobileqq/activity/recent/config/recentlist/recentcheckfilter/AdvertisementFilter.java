package com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter;

import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;

public class AdvertisementFilter
  implements IRecentCheckFilterProcessor
{
  public String a(RecentUser paramRecentUser, int paramInt)
  {
    return "";
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    if (paramRecentUser.lFlag == 16L)
    {
      AdvertisementRecentUserManager.a().a((QQAppInterface)paramBaseQQAppInterface, paramRecentUser);
      return false;
    }
    if (paramRecentUser.getType() == 10005) {
      ImaxAdRecentUserManager.a().a((QQAppInterface)paramBaseQQAppInterface, paramRecentUser);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.AdvertisementFilter
 * JD-Core Version:    0.7.0.1
 */