package com.tencent.biz.pubaccount.ecshopassit.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean.TabConfBean;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfProcessor;
import com.tencent.biz.pubaccount.ecshopassit.conf.QQShopFakeUrlHelper;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;

public class JumpUtil
{
  private static String a(String paramString1, String paramString2)
  {
    if (StringUtil.a(paramString2)) {
      return paramString1;
    }
    paramString1 = EcshopUtils.a(paramString1, EcshopUtils.a(paramString2), false);
    QLog.i("Ecshop_JumpUtil", 2, paramString1);
    return paramString1;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tab_id", paramInt);
    localIntent.putExtra("jump_url", paramString);
    try
    {
      bool = EcshopUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      localIntent.putExtra("req_qgg_title", bool);
      localIntent.putExtra("req_qgg_hide_tab", false);
      localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
      localIntent.setFlags(603979776);
      PublicFragmentActivityForTool.b(paramContext, localIntent, EcshopNewPageFragment.class);
      if (((paramContext instanceof Activity)) && (!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool)) && (!(paramContext instanceof UniteSearchActivity)))
      {
        ((Activity)paramContext).finish();
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        boolean bool = true;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      Intent localIntent = new Intent(paramContext, ChatActivity.class);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("req_qgg_hide_tab", paramBoolean);
      localIntent.putExtra("leftViewText", paramContext.getString(2131690778));
      localIntent.setFlags(4194304);
      paramContext.startActivity(localIntent);
    } while (!(paramContext instanceof Activity));
    paramString1 = (Activity)paramContext;
    if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool))) {
      paramString1.finish();
    }
    paramString1.overridePendingTransition(0, 0);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    QLog.i("Ecshop_JumpUtil", 2, "---jumpByTabIdInner---" + paramInt);
    if (paramInt == 0) {
      a(paramContext, "3046055438", paramString1, true);
    }
    Object localObject;
    EcshopConfBean.TabConfBean localTabConfBean;
    do
    {
      return;
      localObject = EcshopConfProcessor.a();
      if (localObject == null) {
        break label197;
      }
      localTabConfBean = ((EcshopConfBean)localObject).a(paramInt);
      if (localTabConfBean == null)
      {
        a(paramContext, "3046055438", paramString1, true);
        return;
      }
      localObject = ReportUtil.a(localTabConfBean.b, paramString3);
      if ((!StringUtil.a((String)localObject)) && ((((String)localObject).startsWith("http")) || (((String)localObject).startsWith("https")) || (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl((String)localObject)))) {
        break;
      }
    } while (localTabConfBean.a != 1);
    a(paramContext, "3046055438", paramString1, paramBoolean);
    return;
    paramString1 = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if (paramString1.isMiniAppUrl((String)localObject))
    {
      paramString1.startMiniApp(paramContext, (String)localObject, 1035, null);
      return;
    }
    a(paramQQAppInterface, paramContext, paramInt, (String)localObject, paramBoolean, paramString2, paramString3);
    return;
    label197:
    a(paramContext, "3046055438", paramString1, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str4 = "";
    String str1 = str4;
    String str2 = str4;
    int i;
    label70:
    label243:
    label250:
    String str3;
    try
    {
      if (ListUtils.a(paramQQAppInterface.getMessageFacade().a("3046055438", 1008)))
      {
        str1 = str4;
        str2 = str4;
        a(paramQQAppInterface, paramContext, null, "jumpTab", "", 2);
        paramContext = "";
        i = paramQQAppInterface.getConversationFacade().a("3046055438", 1008);
        if (i <= 0) {
          break label243;
        }
        str1 = "1";
        ReportUtil.a(paramQQAppInterface, "gouwu.aio.click", str1, NetConnInfoCenter.getServerTimeMillis() + "", paramContext);
        if (i <= 0) {
          break label250;
        }
      }
      for (str1 = "1";; str1 = "0")
      {
        ReportUtil.b(paramQQAppInterface, "gouwu_aio_click", str1, NetConnInfoCenter.getServerTimeMillis() + "", paramContext);
        return;
        str1 = str4;
        str2 = str4;
        MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().b("3046055438", 1008);
        if (localMessageRecord == null)
        {
          str1 = str4;
          str2 = str4;
          a(paramContext, "3046055438", paramContext.getResources().getString(2131691928), true);
          paramContext = "";
          break;
        }
        str1 = str4;
        str2 = str4;
        str4 = EcshopUtils.a(localMessageRecord);
        str1 = str4;
        str2 = str4;
        b(paramQQAppInterface, paramContext, localMessageRecord, QQShopFakeUrlHelper.b(paramQQAppInterface, EcshopUtils.b(localMessageRecord)), "", EcshopUtils.c(localMessageRecord));
        paramContext = str4;
        break;
        str1 = "0";
        break label70;
      }
      label373:
      paramContext = "1";
    }
    catch (Throwable localThrowable)
    {
      str3 = str1;
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691928), true);
      i = paramQQAppInterface.getConversationFacade().a("3046055438", 1008);
      if (i > 0)
      {
        paramContext = "1";
        ReportUtil.a(paramQQAppInterface, "gouwu.aio.click", paramContext, NetConnInfoCenter.getServerTimeMillis() + "", str1);
        if (i <= 0) {
          break label373;
        }
      }
      for (paramContext = "1";; paramContext = "0")
      {
        ReportUtil.b(paramQQAppInterface, "gouwu_aio_click", paramContext, NetConnInfoCenter.getServerTimeMillis() + "", str1);
        return;
        paramContext = "0";
        break;
      }
    }
    finally
    {
      i = paramQQAppInterface.getConversationFacade().a("3046055438", 1008);
      if (i <= 0) {
        break label471;
      }
    }
    ReportUtil.a(paramQQAppInterface, "gouwu.aio.click", paramContext, NetConnInfoCenter.getServerTimeMillis() + "", str3);
    if (i > 0) {}
    for (paramContext = "1";; paramContext = "0")
    {
      ReportUtil.b(paramQQAppInterface, "gouwu_aio_click", paramContext, NetConnInfoCenter.getServerTimeMillis() + "", str3);
      throw localObject;
      label471:
      paramContext = "0";
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    if ("fypbtn".equals(paramString3))
    {
      a(paramContext, paramInt, paramString1);
      return;
    }
    paramString3 = new Intent();
    paramString3.putExtra("tab_id", paramInt);
    String str = EcshopUtils.b();
    paramInt = paramQQAppInterface.getConversationFacade().a("3046055438", 1008);
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_JumpUtil", 2, "<<<<<<unReadPointCnt<<<<<<" + paramInt);
    }
    if (paramInt == 0) {
      if ((!StringUtil.a(str)) && (!StringUtil.a(EcshopUtils.a())))
      {
        paramQQAppInterface = new HashMap();
        paramQQAppInterface.put("prompt_id", str);
        paramQQAppInterface = EcshopUtils.a(paramString1, paramQQAppInterface, false);
      }
    }
    for (;;)
    {
      paramString3.putExtra("jump_url", paramQQAppInterface);
      QLog.i("Ecshop_JumpUtil", 2, paramQQAppInterface);
      try
      {
        bool = EcshopUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        paramString3.putExtra("req_qgg_title", bool);
        paramString3.putExtra("req_qgg_hide_tab", paramBoolean);
        paramString3.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
        paramString3.setFlags(603979776);
        PublicFragmentActivityForTool.b(paramContext, paramString3, EcshopNewPageFragment.class);
        return;
        paramQQAppInterface = a(paramString1, paramString2);
        continue;
        paramQQAppInterface = a(paramString1, paramString2);
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface.printStackTrace();
          boolean bool = true;
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, int paramInt)
  {
    EcshopUtils.a(paramMessageRecord.uniseq, paramInt + 1);
    paramMessageRecord = new Intent(paramContext, ChatActivity.class);
    paramMessageRecord.putExtra("uin", "3046055438");
    paramMessageRecord.putExtra("uintype", 1008);
    paramMessageRecord.putExtra("uinname", paramContext.getResources().getString(2131691928));
    paramMessageRecord.putExtra("leftViewText", paramContext.getString(2131690778));
    paramMessageRecord.putExtra("jump_minusonescreen_view", true);
    paramContext.startActivity(paramMessageRecord);
    ReportUtil.a(paramQQAppInterface, "gouwu.fyp.show", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    ReportUtil.b(paramQQAppInterface, "gouwu_fyp_show", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    int i = EcshopUtils.a(paramMessageRecord.uniseq);
    if (i >= EcshopUtils.a(paramQQAppInterface, paramString1))
    {
      a(paramQQAppInterface, paramContext, paramString1, paramMessageRecord, paramString2);
      return;
    }
    a(paramQQAppInterface, paramContext, paramMessageRecord, i);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = true;
    paramString1 = "";
    for (;;)
    {
      try
      {
        int i = EcshopUtils.b(paramMessageRecord);
        QLog.e("Ecshop_JumpUtil", 1, paramMessageRecord, new Object[0]);
      }
      catch (Exception paramMessageRecord)
      {
        try
        {
          paramMessageRecord = EcshopUtils.c(paramMessageRecord);
          paramString1 = paramMessageRecord;
          if (QLog.isColorLevel())
          {
            paramString1 = paramMessageRecord;
            QLog.i("Ecshop_JumpUtil", 2, "hideTabId: " + i + " params: " + paramMessageRecord);
          }
          if (i != 1) {
            break label113;
          }
          a(paramQQAppInterface, paramInt, paramContext, paramContext.getResources().getString(2131691928), bool, paramMessageRecord, paramString2);
          return;
        }
        catch (Exception paramMessageRecord)
        {
          break label97;
        }
        paramMessageRecord = paramMessageRecord;
        i = 0;
      }
      label97:
      paramMessageRecord = paramString1;
      continue;
      label113:
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, MessageRecord paramMessageRecord, String paramString2)
  {
    paramString1 = QQShopFakeUrlHelper.a(paramQQAppInterface, paramString1, "redirectScheme");
    if (StringUtil.a(paramString1))
    {
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691928), true);
      return;
    }
    String str;
    try
    {
      paramString1 = ReportUtil.a(URLDecoder.decode(paramString1, "UTF-8"), paramString2);
      str = QQShopFakeUrlHelper.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_JumpUtil", 2, "<<<<jumpByRedirectScheme<<<<decodedScheme: " + paramString1 + " <<<<<redirectHost: " + str);
      }
      if ((paramString1.startsWith("http")) || (paramString1.startsWith("https")))
      {
        paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString1);
        paramQQAppInterface.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
        if (!(paramContext instanceof Activity)) {
          paramQQAppInterface.addFlags(268435456);
        }
        paramContext.startActivity(paramQQAppInterface);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691928), true);
      return;
    }
    try
    {
      i = Integer.parseInt(QQShopFakeUrlHelper.a(paramString1, "tabId"));
      b(paramQQAppInterface, paramContext, paramMessageRecord, str, paramString2, i);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("Ecshop_JumpUtil", 2, new Object[] { Integer.valueOf(1) });
        int i = 1;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_JumpUtil", 2, "jumpByHost>>>>>>" + paramString1);
    }
    if ("jumpTab".equals(paramString1))
    {
      a(paramQQAppInterface, paramContext, paramMessageRecord, paramString1, paramString2, paramInt);
      return;
    }
    if ("jumpPreview".equals(paramString1))
    {
      a(paramQQAppInterface, paramContext, paramMessageRecord, paramString1, "fypgo");
      return;
    }
    a(paramContext, "3046055438", paramContext.getResources().getString(2131691928), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.utils.JumpUtil
 * JD-Core Version:    0.7.0.1
 */