package com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class TempMsgBoxFilter
  implements IRecentCheckFilterProcessor
{
  public String a(RecentUser paramRecentUser, int paramInt)
  {
    return paramInt + "," + MsfSdkUtils.getShortUin(paramRecentUser.uin) + "," + paramRecentUser.getType() + ";";
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    return ((TempMsgBoxManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).b(paramRecentUser.uin, paramRecentUser.getType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.TempMsgBoxFilter
 * JD-Core Version:    0.7.0.1
 */