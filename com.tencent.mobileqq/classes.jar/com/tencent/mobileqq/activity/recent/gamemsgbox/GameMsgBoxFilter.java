package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;

public class GameMsgBoxFilter
  implements IRecentCheckFilterProcessor
{
  public String a(RecentUser paramRecentUser, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(MsfSdkUtils.getShortUin(paramRecentUser.uin));
    localStringBuilder.append(",");
    localStringBuilder.append(paramRecentUser.getType());
    localStringBuilder.append(";");
    return localStringBuilder.toString();
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    return ((paramRecentUser.getType() == 10007) && (!TextUtils.equals(paramRecentUser.uin, "2747277822"))) || ((!((IGameMsgBoxABTestApi)QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab()) && (paramRecentUser.getType() == 10015)) || ((((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) && (paramRecentUser.getType() == 10015));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFilter
 * JD-Core Version:    0.7.0.1
 */