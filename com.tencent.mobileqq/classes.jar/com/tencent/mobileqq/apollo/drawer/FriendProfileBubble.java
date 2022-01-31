package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
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
    int i = ApolloManager.a(paramQQAppInterface);
    if ((paramSpriteDrawerInfoManager == null) || (paramContext == null) || (paramQQAppInterface == null) || (i == 1)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      paramContext = "apollo_friend_profile_drawer_first" + paramQQAppInterface.getCurrentAccountUin();
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(paramContext, true));
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileBubble", 2, "onBubbleShow first");
    }
    SpriteUtil.a(paramSpriteDrawerInfoManager, paramString, 3);
    localSharedPreferences.edit().putBoolean(paramContext, false).commit();
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_show", 0, 0, new String[] { "", "", "", this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.FriendProfileBubble
 * JD-Core Version:    0.7.0.1
 */