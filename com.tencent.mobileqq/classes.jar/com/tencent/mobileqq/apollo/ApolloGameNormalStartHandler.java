package com.tencent.mobileqq.apollo;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ApolloGameNormalStartHandler
{
  private static long a;
  
  private static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4, long paramLong, String paramString3, String paramString4, String paramString5)
  {
    if (paramActivity == null) {}
    while (paramQQAppInterface == null) {
      return;
    }
    long l = System.currentTimeMillis();
    if (l - a < 2000L)
    {
      QLog.e("ApolloGameNormalStartHandler", 1, "current - mLastLuanchGameTime < 2000");
      return;
    }
    a = l;
    paramActivity.runOnUiThread(new ApolloGameNormalStartHandler.1(paramInt1, paramLong, paramInt2, paramInt3, paramQQAppInterface, paramString2, paramInt4, paramString5, paramString1, paramString3, paramString4, paramActivity));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameNormalStartHandler", 2, new Object[] { "startGameFromArkApp, args:", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloGameNormalStartHandler", 2, "startGameFromArkApp app is null");
      return;
    }
    for (;;)
    {
      Object localObject2;
      int k;
      try
      {
        localObject2 = new JSONObject(paramString);
        if (!((JSONObject)localObject2).optBoolean("isGameApp"))
        {
          k = ((JSONObject)localObject2).getInt("gameID");
          int m = ((JSONObject)localObject2).getInt("gameMode");
          str1 = ((JSONObject)localObject2).optString("roomId");
          int n = ((JSONObject)localObject2).getInt("src");
          str2 = ((JSONObject)localObject2).optString("gameParam");
          String str3 = ((JSONObject)localObject2).optString("gameName");
          j = 0;
          i = 0;
          paramString = "";
          localObject1 = BaseActivity.sTopActivity;
          if (!(BaseActivity.sTopActivity instanceof FragmentActivity)) {
            break label561;
          }
          Object localObject3 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
          if (localObject3 == null) {
            break label561;
          }
          localObject1 = ((ChatFragment)localObject3).a();
          if (((BaseChatPie)localObject1).a() != null)
          {
            i = ((BaseChatPie)localObject1).a().jdField_a_of_type_Int;
            paramString = ((BaseChatPie)localObject1).a().jdField_a_of_type_JavaLangString;
          }
          localObject1 = ((BaseChatPie)localObject1).a();
          localObject3 = ((JSONObject)localObject2).optString("tempAIOUin");
          localObject2 = ((JSONObject)localObject2).optString("tempAIONickName");
          long l = 0L;
          if (!TextUtils.isEmpty(str1)) {
            l = Long.parseLong(str1);
          }
          a((Activity)localObject1, paramQQAppInterface, k, m, str2, i, paramString, n, l, (String)localObject3, (String)localObject2, str3);
          if ((i != 1036) || (l <= 0L) || (TextUtils.isEmpty((CharSequence)localObject3))) {
            break;
          }
          CmGameSessionUtil.b(paramQQAppInterface, (String)localObject3, i, k, l);
          com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.O = true;
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloGameNormalStartHandler", 1, "startGameFromArkApp, exception=", paramQQAppInterface);
        return;
      }
      paramString = ((JSONObject)localObject2).optString("appID");
      Object localObject1 = ((JSONObject)localObject2).optString("paramsStr");
      String str1 = ((JSONObject)localObject2).optString("packageName");
      String str2 = ((JSONObject)localObject2).optString("flags");
      ((JSONObject)localObject2).optString("type");
      if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str1)))
      {
        QLog.e("ApolloGameNormalStartHandler", 1, "[startGameFromArkApp] game app param error");
        return;
      }
      if (!PackageUtil.a(BaseActivity.sTopActivity, str1))
      {
        paramQQAppInterface = String.format("https://m.gamecenter.qq.com/directout/detail/%s?_wv=2147484679&_wwv=4&ADTAG=limixiuteam&autodownload=1&pf=invite&appid=%s&notShowPub=1&asyncMode=3&appType=1&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0", new Object[] { paramString, paramString });
        paramString = new Intent(BaseActivity.sTopActivity, QQBrowserActivity.class);
        paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.openQQBrowserActivity(BaseActivity.sTopActivity, paramQQAppInterface, -1L, paramString, false, -1);
        return;
      }
      int j = 268435456;
      try
      {
        k = Integer.parseInt(str2);
        if ((0x4000000 & k) != 67108864) {
          break label555;
        }
        j = 335544320;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ApolloGameNormalStartHandler", 1, "[startGameFromArkApp] parse flag exception:", localException);
          continue;
          j = 268435456;
        }
      }
      int i = j;
      if ((0x20000000 & k) == 536870912) {
        i = j | 0x20000000;
      }
      j = i;
      if ((k & 0x400000) == 4194304) {
        j = i | 0x400000;
      }
      QLog.d("ApolloGameNormalStartHandler", 1, "[startGameFromArkApp] start game app");
      new AppLaucherHelper().a(paramQQAppInterface, BaseActivity.sTopActivity, paramString, (String)localObject1, str1, j);
      return;
      label555:
      label561:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler
 * JD-Core Version:    0.7.0.1
 */