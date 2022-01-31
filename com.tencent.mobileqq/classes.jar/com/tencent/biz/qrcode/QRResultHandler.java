package com.tencent.biz.qrcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.StringUtil;
import java.net.URLEncoder;

public class QRResultHandler
{
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, QRActionEntity paramQRActionEntity, String paramString, Bundle paramBundle)
  {
    if ((paramQRActionEntity == null) || (paramQRActionEntity.a() == 0))
    {
      a(paramQQAppInterface, paramActivity, paramString);
      return 0;
    }
    for (;;)
    {
      try
      {
        switch (paramQRActionEntity.c)
        {
        case 4: 
        case 5: 
        case 7: 
        case 8: 
        case 9: 
          a(paramQQAppInterface, paramActivity, paramString);
          return 0;
        }
      }
      catch (Exception paramQRActionEntity)
      {
        a(paramQQAppInterface, paramActivity, paramString);
        return 0;
      }
      a(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a() + "", paramBundle.getBoolean("issupportwpa", false));
      return 1;
      String str2 = "";
      String str1 = str2;
      if (!TextUtils.isEmpty(paramString))
      {
        Uri localUri = Uri.parse(paramString);
        str1 = str2;
        if (localUri != null)
        {
          str1 = str2;
          if (localUri.isHierarchical()) {
            str1 = localUri.getQueryParameter("jump_from");
          }
        }
      }
      a(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a() + "", str1, paramBundle.getString("authKey"));
      return 2;
      a(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a() + "", paramBundle);
      return 3;
      a(paramActivity, paramQRActionEntity);
      return paramQRActionEntity.c;
      a(paramQQAppInterface, paramActivity, SubscriptUtil.a(paramQRActionEntity.a().a()), paramBundle);
      return 10;
    }
  }
  
  private static String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(Base64Util.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static void a(Context paramContext, QRActionEntity paramQRActionEntity)
  {
    CrmUtils.a(paramContext, null, String.valueOf(paramQRActionEntity.a().a()), false, 1, true, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramString = 1024 + "http://qm.qq.com/cgi-bin/result" + "?p=a&v=" + DeviceInfoUtil.d() + "&r=" + URLEncoder.encode(paramString).replaceAll("\\+", "%20") + "&_wv=1027";
    paramQQAppInterface.putExtra("title", paramActivity.getString(2131429916));
    paramQQAppInterface.putExtra("url", paramString);
    paramQQAppInterface.putExtra("key_isReadModeEnabled", true);
    if (paramActivity.getIntent().getBooleanExtra("QRDecode", false) == true)
    {
      paramActivity.startActivityForResult(paramQQAppInterface, 2);
      return;
    }
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt)
  {
    paramQQAppInterface = new Intent(paramActivity, QRCardActivity.class);
    paramQQAppInterface.putExtra("CARDMODE", paramInt);
    paramQQAppInterface.putExtra("QRCARDSTR", paramString);
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  private static final void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null)
    {
      String str = paramBundle.getString("extvalue");
      paramBundle = paramBundle.getString("exttype");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBundle)))
      {
        localIntent.putExtra("extvalue", str);
        localIntent.putExtra("exttype", paramBundle);
      }
    }
    localIntent.putExtra("source", 1);
    PublicAccountUtil.a(localIntent, paramQQAppInterface, paramActivity, paramString, -1);
    PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_1", "scan");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString1);
    localBundle.putString("card_type", "group");
    localBundle.putString("authKey", paramString3);
    localBundle.putString("from", "qrcode");
    if (!TextUtils.isEmpty(JumpAction.i)) {
      localBundle.putString("appid", JumpAction.i);
    }
    if (!TextUtils.isEmpty(JumpAction.j)) {
      localBundle.putString("openid", a(JumpAction.j));
    }
    JumpAction.i = null;
    JumpAction.j = null;
    paramString1 = paramString2;
    if (StringUtil.a(paramString2))
    {
      if (!(paramActivity instanceof ScannerActivity)) {
        break label210;
      }
      paramString1 = "ScannerActivity";
    }
    for (;;)
    {
      localBundle.putString("jump_from", paramString1);
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.a(localBundle)).toString());
      if (paramQQAppInterface != null) {
        paramQQAppInterface.b();
      }
      return;
      label210:
      paramString1 = paramString2;
      if ((paramActivity instanceof QRJumpActivity)) {
        paramString1 = "QRJumpActivity";
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString);
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      localBundle.putString("wpa", paramString);
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.a(localBundle)).toString());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a();
        paramQQAppInterface.b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.QRResultHandler
 * JD-Core Version:    0.7.0.1
 */