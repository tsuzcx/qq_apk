package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebShareUtils
{
  private static final String jdField_a_of_type_JavaLangString = FastWebShareUtils.class.getSimpleName();
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  private String b;
  
  private int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 13;
    }
    return i;
  }
  
  private String a(AccountDetail paramAccountDetail, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = localObject1;
      if (paramAccountDetail != null) {
        paramString1 = paramAccountDetail.name;
      }
      paramAccountDetail = paramString1;
      if (TextUtils.isEmpty(paramString1))
      {
        paramAccountDetail = paramString1;
        if (paramJSONObject.has("sourceName")) {
          paramAccountDetail = paramJSONObject.optString("sourceName");
        }
      }
      paramJSONObject = paramAccountDetail;
      if (!TextUtils.isEmpty(paramAccountDetail)) {}
    }
    else
    {
      do
      {
        return paramString2;
        paramString1 = localObject2;
        if (paramJSONObject.has("sourceName")) {
          paramString1 = paramJSONObject.optString("sourceName");
        }
        paramJSONObject = paramString1;
        if (TextUtils.isEmpty(paramString1))
        {
          paramJSONObject = paramString1;
          if (paramAccountDetail != null) {
            paramJSONObject = paramAccountDetail.name;
          }
        }
      } while (TextUtils.isEmpty(paramJSONObject));
    }
    return paramJSONObject;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 45) {
        str = paramString.substring(0, 45) + "…";
      }
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return new UrlBuilder(paramString1).a("title", paramString2).a("url", paramString3).a("pic", paramString4).a("_wv", "3").a();
  }
  
  private void a(long paramLong, AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent)
  {
    Share.a(paramAppInterface, paramActivity, paramAppInterface.getAccount(), paramLong, 3000L, new FastWebShareUtils.4(this, paramIntent, paramActivity));
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, ArticleInfo paramArticleInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArticleInfo == null)) {
      return;
    }
    paramContext = RIJTransMergeKanDianReport.a(paramContext, paramArticleInfo, (int)paramArticleInfo.mChannelID, "1");
    try
    {
      paramContext.put("location", paramInt);
      ReportUtil.a(paramArticleInfo, paramString, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, ArticleInfo paramArticleInfo, int paramInt2)
  {
    if (paramInt2 == -1)
    {
      a(paramContext, paramString, paramInt1, paramArticleInfo);
      return;
    }
    paramContext = RIJTransMergeKanDianReport.a(paramContext, paramArticleInfo, (int)paramArticleInfo.mChannelID, "1", paramInt2);
    try
    {
      paramContext.put("location", paramInt1);
      ReportUtil.a(paramArticleInfo, paramString, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramIntent.putExtra(paramString1, paramString2);
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    int i = 2;
    if ("audio".equals(paramString1)) {
      paramIntent.putExtra("audio_url", paramString2);
    }
    for (;;)
    {
      int j = i;
      if (i == 1) {
        j = 144;
      }
      paramIntent.putExtra("req_type", j);
      if (paramJSONObject.has("report")) {
        paramIntent.putExtra("report", paramJSONObject.getString("report"));
      }
      return;
      i = paramJSONObject.optInt("req_type", 1);
      if (i == 2) {
        paramIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
      }
    }
  }
  
  private void a(Intent paramIntent, String paramString1, JSONObject paramJSONObject, String paramString2, boolean paramBoolean)
  {
    if ((paramIntent == null) || (paramJSONObject == null)) {}
    while (!paramJSONObject.has(paramString2)) {
      return;
    }
    if (paramBoolean) {}
    try
    {
      paramIntent.putExtra(paramString1, Integer.parseInt(paramJSONObject.getString(paramString2)));
      return;
    }
    catch (JSONException paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleShareMsgToQQParams] paramsKey = " + paramString2 + ", e = " + paramIntent);
      return;
      paramIntent.putExtra(paramString1, paramJSONObject.getString(paramString2));
      return;
    }
    catch (NumberFormatException paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleShareMsgToQQParams] paramsKey = " + paramString2 + ", e = " + paramIntent);
    }
  }
  
  private void a(Intent paramIntent, JSONObject paramJSONObject)
  {
    paramIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    boolean bool = paramJSONObject.optBoolean("back", false);
    if (paramJSONObject.has("k_back")) {
      bool = paramJSONObject.getBoolean("k_back");
    }
    paramIntent.putExtra("k_back", bool);
    if (paramJSONObject.has("serviceID")) {
      paramIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
    }
  }
  
  private void a(Intent paramIntent, JSONObject paramJSONObject, Activity paramActivity)
  {
    long l = paramJSONObject.optLong("appid", 0L);
    if (l > 0L)
    {
      paramJSONObject = (AppInterface)ReadInJoyUtils.a();
      if (paramJSONObject != null)
      {
        a(paramActivity);
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        paramIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        a(l, paramJSONObject, paramActivity, paramIntent);
      }
      return;
    }
    a(paramActivity);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      l = System.currentTimeMillis();
      QLog.d(jdField_a_of_type_JavaLangString, 2, "dialog dimiss time :" + l);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    Object localObject2 = paramJSONObject.optString("puin", null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramJSONObject.optString("oaUin");
    }
    Object localObject3;
    String str;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = (AppInterface)ReadInJoyUtils.a();
      localObject2 = ((AppInterface)localObject2).getEntityManagerFactory(((AppInterface)localObject2).getAccount()).createEntityManager();
      localObject3 = (AccountDetail)((EntityManager)localObject2).find(AccountDetail.class, (String)localObject1);
      ((EntityManager)localObject2).close();
      localObject2 = paramJSONObject.optString("src_action", "");
      str = a((AccountDetail)localObject3, (String)localObject2, paramJSONObject, (String)localObject1);
      if (str.equalsIgnoreCase(paramActivity.getString(2131699723)))
      {
        boolean bool = str.equalsIgnoreCase(paramActivity.getString(2131699723));
        if (bool)
        {
          paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
          if (!bool) {
            break label404;
          }
          localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1";
          label295:
          if (!bool) {
            break label412;
          }
          localObject3 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
          label305:
          paramIntent.putExtra("source_puin", (String)localObject1);
          paramIntent.putExtra("struct_share_key_source_action", "plugin");
          paramIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
          paramIntent.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
          paramIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
          paramIntent.putExtra("struct_share_key_source_icon", (String)localObject3);
          paramIntent.putExtra("app_name", str);
        }
      }
    }
    for (;;)
    {
      paramJSONObject = StructMsgFactory.a(paramIntent.getExtras());
      if (paramJSONObject != null) {
        break label564;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "build struct msg fail");
      return;
      paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
      break;
      label404:
      localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
      break label295;
      label412:
      localObject3 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
      break label305;
      localObject3 = paramJSONObject.optString("puin");
      paramJSONObject.put("src_webActionUrl", ReadInJoyConstants.k + Base64Util.encodeToString(((String)localObject3).getBytes(), 2));
      a(paramIntent, paramJSONObject, (String)localObject2, (String)localObject1, str);
      continue;
      if (paramJSONObject.has("sourceName"))
      {
        localObject1 = paramJSONObject.optString("sourceName");
        paramIntent.putExtra("app_name", (String)localObject1);
        if (("手Q阅读".equals(localObject1)) && (paramJSONObject.has("srcIconUrl"))) {
          paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
        }
      }
      else
      {
        paramIntent.putExtra("app_name", paramActivity.getString(2131696399));
      }
    }
    label564:
    paramIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
    paramActivity.startActivityForResult(paramIntent, 1);
  }
  
  private void a(Intent paramIntent, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    String str1 = paramJSONObject.optString("src_webActionUrl", "");
    String str2 = paramJSONObject.optString("src_actionData", "");
    String str3 = paramJSONObject.optString("src_a_actionData", "");
    String str4 = paramJSONObject.optString("src_i_actionData", "");
    if ((TextUtils.isEmpty(paramString1)) || (("web".equals(paramString1)) && ((TextUtils.isEmpty(str1)) || (str1.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString1)) && (TextUtils.isEmpty(str2)) && ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))))
    {
      paramString1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { paramString2 });
      str1 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString2 });
      paramIntent.putExtra("struct_share_key_source_action", "plugin");
      paramIntent.putExtra("struct_share_key_source_a_action_data", paramString1);
      paramIntent.putExtra("struct_share_key_source_i_action_data", str1);
    }
    for (;;)
    {
      paramIntent.putExtra("source_puin", paramString2);
      paramIntent.putExtra("app_name", paramString3);
      paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        break;
      }
      paramIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
      return;
      paramIntent.putExtra("struct_share_key_source_action", paramString1);
      if ("web".equals(paramString1))
      {
        paramString1 = ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, str1, ReadinjoyReportUtils.f);
        paramIntent.putExtra("struct_share_key_source_url", paramString1);
        paramIntent.putExtra("source_url", paramString1);
      }
      else
      {
        a(paramIntent, "struct_share_key_source_action_data", str2);
        a(paramIntent, "struct_share_key_source_a_action_data", str3);
        a(paramIntent, "struct_share_key_source_i_action_data", str4);
      }
    }
    paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new FastWebShareUtils.1(this, paramArticleInfo, paramInt);
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, ArticleInfo paramArticleInfo, String paramString7, Activity paramActivity, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap(1);
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    int j = -1;
    int i;
    if (paramInt == 9)
    {
      i = 3;
      if (WXShareHelper.a().a()) {
        break label60;
      }
      paramInt = 2131720753;
    }
    for (;;)
    {
      if (paramInt == -1) {
        break label79;
      }
      QRUtils.a(0, paramInt);
      return;
      i = 4;
      break;
      label60:
      paramInt = j;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131720754;
      }
    }
    label79:
    a(paramArticleInfo, i);
    paramString1 = new FastWebShareUtils.2(this, localHashMap, paramBoolean, paramString3, paramString4, paramString5, paramString1, paramString2, localAppInterface, paramString7, paramArticleInfo, i);
    if (TextUtils.isEmpty(paramString6))
    {
      paramString1.run();
      return;
    }
    a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ThreadManager.post(new FastWebShareUtils.3(this, paramString6, paramBoolean, localHashMap, localAppInterface, paramString1), 8, null, false);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, ArticleInfo paramArticleInfo, String paramString4, Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina empty title or share_url");
      }
      QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = a("https://v.t.sina.com.cn/share/share.php?", paramString1, paramString2, paramString3);
        paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
        paramString2.putExtra("url", paramString1);
        paramActivity.startActivity(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
        }
        a(localAppInterface.getApplication().getApplicationContext(), paramString4, 6, paramArticleInfo);
        ReportUtil.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 5, -1, false);
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina error! msg=" + paramString1);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
  }
  
  private void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4, ArticleInfo paramArticleInfo, String paramString5, Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    localBundle.putString("detail_url", paramString3);
    localBundle.putString("from", "qq");
    if (paramJSONObject != null) {
      localBundle.putString("default_text", paramJSONObject.optString("default_text"));
    }
    paramString1 = new ArrayList(1);
    if ((TextUtils.isEmpty(paramString4)) && (paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mFirstPagePicUrl))) {
      paramString1.add(paramArticleInfo.mFirstPagePicUrl);
    }
    for (;;)
    {
      localBundle.putStringArrayList("image_url", paramString1);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 1);
      localBundle.putLong("share_begin_time", SwiftBrowserShareMenuHandler.b);
      if (QZoneShareManager.jumpToQzoneShare(localAppInterface, paramActivity, localBundle, null, 1)) {
        break;
      }
      QRUtils.a(1, 2131689486);
      ReportUtil.b(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 2, -1, false, false);
      return;
      paramString1.add(paramString4);
    }
    a(localAppInterface.getApplication().getApplicationContext(), paramString5, 3, paramArticleInfo);
    ReportUtil.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 2, -1, false);
  }
  
  public static boolean a()
  {
    return TextUtils.equals("1", (CharSequence)ReadInJoyHelper.a("kandian_daily_fast_web_bottom_share", "0"));
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() >= 5);
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 60) {
        str = paramString.substring(0, 60) + "…";
      }
    }
    return str;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    Intent localIntent = new Intent();
    String str1 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str2 = paramJSONObject.optString("friendName");
    if (a(str1))
    {
      localIntent.setClass(paramActivity.getApplicationContext(), DirectForwardActivity.class);
      localIntent.putExtra("toUin", str1);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("uinname", str2);
    }
    for (;;)
    {
      localIntent.putExtra("key_flag_from_plugin", true);
      paramString1 = a(paramString1);
      paramString2 = b(paramString2);
      paramInt = a(paramInt);
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("title", paramString1);
      localIntent.putExtra("desc", paramString2);
      localIntent.putExtra("detail_url", paramString3);
      localIntent.putExtra("shareQQType", paramInt);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("image_url_remote", paramString4);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696382, new Object[] { paramString1 }));
      localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
      a(localIntent, "struct_share_key_content_action", paramJSONObject, "contentAction", false);
      a(localIntent, "struct_share_key_content_action_DATA", paramJSONObject, "actionData", false);
      a(localIntent, "struct_share_key_source_action", paramJSONObject, "sourceAction", false);
      a(localIntent, "is_share_flag", paramJSONObject, "isShareFlag", true);
      a(localIntent, "struct_share_key_source_action_data", paramJSONObject, "srcActionData", false);
      a(localIntent, "app_name", paramJSONObject, "appName", false);
      a(localIntent, paramString5, paramString6, paramJSONObject);
      a(localIntent, paramJSONObject);
      a(localIntent, paramJSONObject, paramActivity);
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt1, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    label49:
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    boolean bool1;
    if (((Boolean)ReadInJoyHelper.a("is_share_strike", Boolean.valueOf(false))).booleanValue())
    {
      QRUtils.a(1, 2131719291);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sharing is stroked!");
      return;
    }
    else
    {
      if (paramArticleInfo != null) {
        switch (paramArticleInfo.shareCalcuPermission)
        {
        }
      }
      String str6;
      String str7;
      label215:
      int i;
      for (;;)
      {
        try
        {
          paramString3 = new JSONObject(paramString3);
          str1 = paramString3.optString("share_type", "0");
          str2 = paramString3.optString("title");
          str3 = paramString3.optString("desc");
          str4 = paramString3.optString("share_url");
          str5 = paramString3.optString("image_url");
          str6 = paramString3.optString("shareElement");
          str7 = paramString3.optString("flash_url");
          boolean bool2 = false;
          bool1 = bool2;
          if ((paramActivity instanceof FastWebActivity))
          {
            bool1 = bool2;
            if ("2".equals(str1))
            {
              if (paramString3.optInt("mini_program_enabled", 1) != 1) {
                break label393;
              }
              bool1 = true;
              break;
            }
          }
          if (paramArticleInfo == null) {
            break label399;
          }
          paramString1 = paramArticleInfo.innerUniqueID;
          i = paramString3.optInt("shareQQType", 13);
          if (paramInt1 != 72) {
            break label555;
          }
          paramString3.put("toUin", paramString4);
          paramString3.put("uinType", paramInt2);
          paramString3.put("friendName", paramString5);
          a(paramActivity, paramString3, str2, str3, str4, str5, str6, str7, i);
          a(localAppInterface.getApplication().getApplicationContext(), paramString2, 2, paramArticleInfo);
          ReportUtil.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 1, 19, false);
          return;
        }
        catch (Exception paramArticleInfo)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "doShareAction error! msg=" + paramArticleInfo);
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "allow share but don't calculate!");
          continue;
          ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), paramArticleInfo, 2);
          continue;
          label393:
          bool1 = false;
          break;
          label399:
          paramString1 = "";
        }
      }
      label407:
      a(paramActivity, paramString3, str2, str3, str4, str5, str6, str7, i);
      a(localAppInterface.getApplication().getApplicationContext(), paramString2, 2, paramArticleInfo);
      ReportUtil.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 1, -1, false);
      return;
      label461:
      if (paramInt1 != 3) {
        break label569;
      }
      a(str2, str3, str4, paramString3, str5, paramArticleInfo, paramString2, paramActivity);
      return;
    }
    for (;;)
    {
      a(paramString1, str1, paramInt1, str2, str3, str4, str5, paramArticleInfo, paramString2, paramActivity, bool1);
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), paramArticleInfo, 1);
      return;
      if (paramInt1 != 12) {
        break label49;
      }
      a(str2, str4, str5, paramArticleInfo, paramString2, paramActivity);
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), paramArticleInfo, 1);
      return;
      break label215;
      label555:
      if (paramInt1 == 2) {
        break label407;
      }
      if (paramInt1 != 73) {
        break label461;
      }
      break label407;
      label569:
      if (paramInt1 != 9) {
        if (paramInt1 != 10) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils
 * JD-Core Version:    0.7.0.1
 */