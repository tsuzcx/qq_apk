package com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class KanDianPrivateChatFilter
  implements IRecentCheckFilterProcessor
{
  public String a(RecentUser paramRecentUser, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", KanDianPrivateChat,");
    localStringBuilder.append(MsfSdkUtils.getShortUin(paramRecentUser.uin));
    localStringBuilder.append(",");
    localStringBuilder.append(paramRecentUser.getType());
    localStringBuilder.append(";");
    return localStringBuilder.toString();
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    return paramRecentUser.getType() == 10013;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.KanDianPrivateChatFilter
 * JD-Core Version:    0.7.0.1
 */