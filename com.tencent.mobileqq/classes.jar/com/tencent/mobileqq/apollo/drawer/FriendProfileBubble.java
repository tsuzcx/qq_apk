package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;

public class FriendProfileBubble
{
  public String a;
  
  public FriendProfileBubble(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramSpriteDrawerInfoManager != null) && (paramContext != null))
    {
      if (paramQQAppInterface == null) {
        return;
      }
      if (((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getWhiteListStatus() == 1) {
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("apollo_friend_profile_drawer_first");
      paramContext.append(paramQQAppInterface.getCurrentAccountUin());
      paramContext = paramContext.toString();
      SharedPreferences localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      if (localSharedPreferences.getBoolean(paramContext, true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]FriendProfileBubble", 2, "onBubbleShow first");
        }
        SpriteUtil.a(paramSpriteDrawerInfoManager, paramString, 3, 0);
        localSharedPreferences.edit().putBoolean(paramContext, false).commit();
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_show", 0, 0, new String[] { "", "", "", this.a });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.FriendProfileBubble
 * JD-Core Version:    0.7.0.1
 */