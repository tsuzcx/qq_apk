package com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class TempFilterBoxFilter
  implements IRecentCheckFilterProcessor
{
  public String a(RecentUser paramRecentUser, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ToFilterBox,");
    localStringBuilder.append(MsfSdkUtils.getShortUin(paramRecentUser.uin));
    localStringBuilder.append(",");
    localStringBuilder.append(paramRecentUser.getType());
    localStringBuilder.append(";");
    return localStringBuilder.toString();
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    return ((ITempMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).isBelongToFilterBox(paramRecentUser.uin, paramRecentUser.getType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.TempFilterBoxFilter
 * JD-Core Version:    0.7.0.1
 */