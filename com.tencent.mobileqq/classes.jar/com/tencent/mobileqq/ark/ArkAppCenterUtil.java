package com.tencent.mobileqq.ark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.fragment.app.FragmentManager;
import com.tencent.ark.ark;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppCenterUtil
{
  public static int a = BaseChatItemLayout.e;
  public static int b = BaseChatItemLayout.f;
  public static int c = BaseChatItemLayout.d;
  public static int d = BaseChatItemLayout.d;
  public static boolean e = false;
  public static DisplayMetrics f;
  private static int g = 0;
  
  static
  {
    f = null;
    a(1);
  }
  
  private static void a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    int i = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    d = i;
    if (f == null) {
      f = localDisplayMetrics;
    }
    QLog.e("ArkApp.ArkAppCenterUtil", 1, new Object[] { "ArkFold.checkArkSize model=", Build.MODEL, ",screenWidth=", Integer.valueOf(i), ",sDisplayWith=", Integer.valueOf(c), ",scene=", Integer.valueOf(paramInt) });
    if ((i >= 1536) && (c != 840))
    {
      e = true;
      c = 840;
      a = (int)(c - d() * 108.0F);
      b = a - BaseChatItemLayout.getBubblePaddingAlignHead() - BaseChatItemLayout.getBubblePaddingAlignError();
      QLog.e("ArkApp.ArkAppCenterUtil", 1, new Object[] { "ArkFold.checkArkSize handle fold screen sChatBubbleMaxWidth=", Integer.valueOf(a), ",sDisplayWith=", Integer.valueOf(c), ",sChatTextViewMaxWidth=", Integer.valueOf(b) });
    }
  }
  
  public static void a(Context paramContext, MessageForArkApp paramMessageForArkApp, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, TextPreviewActivity.class);
    localIntent.putExtra("peeruin", paramMessageForArkApp.frienduin);
    localIntent.putExtra("uin_type", paramMessageForArkApp.istroop);
    localIntent.putExtra("content", paramMessageForArkApp.ark_app_message.toAppXml());
    localIntent.putExtra("uniseq", paramMessageForArkApp.uniseq);
    localIntent.putExtra("bubbleId", paramMessageForArkApp.vipBubbleID);
    localIntent.putExtra("bubbleDiyId", paramMessageForArkApp.vipBubbleDiyTextId);
    localIntent.putExtra("fontId", paramMessageForArkApp.getExtInfoFromExtStr("vip_font_id"));
    localIntent.putExtra("troop_at_info", paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.i));
    localIntent.putExtra("senderUin", paramMessageForArkApp.senderuin);
    localIntent.putExtra("sessionType", paramInt);
    localIntent.putExtra("isMultiMsg", paramMessageForArkApp.isMultiMsg);
    String str = paramMessageForArkApp.getExtInfoFromExtStr("vip_font_effect_id");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str))) {
      i = Integer.valueOf(str).intValue();
    } else {
      i = 0;
    }
    paramInt = i;
    if (i == 0)
    {
      paramInt = i;
      if (FontManagerConstants.parseMagicFont(paramMessageForArkApp)) {
        paramInt = 1;
      }
    }
    int i = paramInt;
    if (paramInt != 0)
    {
      i = paramInt;
      if (1 == paramMessageForArkApp.istroop)
      {
        i = paramInt;
        if (AnonymousChatHelper.c(paramMessageForArkApp)) {
          i = 0;
        }
      }
    }
    localIntent.putExtra("fontEffectId", i);
    if (paramMessageForArkApp.isSend()) {
      paramMessageForArkApp = paramMessageForArkApp.selfuin;
    } else if ((paramMessageForArkApp.istroop != 1000) && (paramMessageForArkApp.istroop != 1020) && (paramMessageForArkApp.istroop != 1004)) {
      paramMessageForArkApp = paramMessageForArkApp.senderuin;
    } else {
      paramMessageForArkApp = paramMessageForArkApp.frienduin;
    }
    localIntent.putExtra("real_msg_sender_uin", paramMessageForArkApp);
    paramContext = (Activity)paramContext;
    paramContext.startActivityForResult(localIntent, 14001);
    paramContext.overridePendingTransition(2130772024, 0);
  }
  
  public static void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.screenWidthDp != g)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppCenterUtil", 2, new Object[] { "ArkFold.BaseChatePie.onConfigurationChanged.mOldScreenDp=", Integer.valueOf(g), ",newScreenDp=", Integer.valueOf(paramConfiguration.screenWidthDp) });
      }
      g = paramConfiguration.screenWidthDp;
      a(2);
    }
  }
  
  public static void a(String paramString, Context paramContext)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "ArkApp.ArkAppCenterUtil";
    }
    try
    {
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      paramString = new StringBuilder("print density info:");
      paramString.append("\n model=");
      paramString.append(Build.MODEL);
      paramString.append(", ver=");
      paramString.append(Build.VERSION.RELEASE);
      paramString.append(",SDK=");
      paramString.append(Build.VERSION.SDK_INT);
      paramString.append("\n BaseChatItemLayout.density=");
      paramString.append(BaseChatItemLayout.w);
      paramString.append("\n application density=");
      paramString.append(localDisplayMetrics.density);
      paramString.append("-");
      paramString.append(localDisplayMetrics.scaledDensity);
      if (paramContext != null)
      {
        paramContext = paramContext.getResources().getDisplayMetrics();
        paramString.append("\n activity density=");
        paramString.append(paramContext.density);
        paramString.append("-");
        paramString.append(paramContext.scaledDensity);
      }
      QLog.i(str, 1, paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkApp.ArkAppCenterUtil", 1, "printScaleInfo Exception:", paramString);
    }
  }
  
  public static boolean a()
  {
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      ChatFragment localChatFragment = (ChatFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((localChatFragment != null) && ((localChatFragment.k() instanceof PublicAccountChatPie))) {
        return true;
      }
    }
    return false;
  }
  
  public static void b()
  {
    String str = c();
    QLog.d("ArkApp.ArkAppCenterUtil", 1, new Object[] { "onThemeChanged.appconfig=", str });
    try
    {
      ark.arkApplicationSetConfig(null, str);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e("ArkApp.ArkAppCenterUtil", 1, "onThemeChanged.ark so not load.e=", localUnsatisfiedLinkError);
    }
  }
  
  public static String c()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      boolean bool = SimpleUIUtil.e();
      if (bool) {
        localJSONObject2.put("mode", "concise");
      } else {
        localJSONObject2.put("mode", "default");
      }
      localJSONObject2.put("themeId", ThemeUtil.getCurrentThemeId());
      localJSONObject1.put("theme", localJSONObject2);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ArkApp.ArkAppCenterUtil", 1, "Exception=", localJSONException);
    }
    return localJSONObject1.toString();
  }
  
  public static float d()
  {
    return BaseChatItemLayout.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenterUtil
 * JD-Core Version:    0.7.0.1
 */