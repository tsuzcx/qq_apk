package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.video.VideoStructMsgHelper;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.ShareReport;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QShareUtils
{
  public static String a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QShareUtils";
  }
  
  private String a(JSONObject paramJSONObject)
  {
    String str2 = paramJSONObject.optString("puin", null);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramJSONObject.optString("oaUin");
    }
    return str1;
  }
  
  private String a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    String str;
    if ((!TextUtils.isEmpty(paramJSONObject.optString("wx_share_url"))) && (paramInt == 9)) {
      str = paramJSONObject.optString("wx_share_url");
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (TextUtils.isEmpty(paramJSONObject.optString("wx_circle_share_url")));
      str = paramString;
    } while (paramInt != 10);
    return paramJSONObject.optString("wx_circle_share_url");
  }
  
  private String a(JSONObject paramJSONObject, String paramString1, AccountDetail paramAccountDetail, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramAccountDetail != null) {
        paramString3 = paramAccountDetail.name;
      }
      paramAccountDetail = paramString3;
      if (TextUtils.isEmpty(paramString3))
      {
        paramAccountDetail = paramString3;
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
        return paramString1;
        if (paramJSONObject.has("sourceName")) {
          paramString3 = paramJSONObject.optString("sourceName");
        }
        paramJSONObject = paramString3;
        if (TextUtils.isEmpty(paramString3))
        {
          paramJSONObject = paramString3;
          if (paramAccountDetail != null) {
            paramJSONObject = paramAccountDetail.name;
          }
        }
      } while (TextUtils.isEmpty(paramJSONObject));
    }
    return paramJSONObject;
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity);
    }
  }
  
  private void a(Activity paramActivity, Intent paramIntent, long paramLong)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    if (localAppInterface != null)
    {
      a(paramActivity);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      paramIntent.putExtra("struct_share_key_source_name", Long.toString(paramLong));
      Share.a(localAppInterface, paramActivity, localAppInterface.getAccount(), paramLong, 3000L, new QShareUtils.4(this, paramIntent, paramActivity));
    }
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina empty title or share_url");
      }
      QQToast.a(BaseActivity.sTopActivity, 0, 2131719291, 0).b(BaseActivity.sTopActivity.getResources().getDimensionPixelSize(2131299166));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        String str = "https://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
        paramString2 = URLEncoder.encode(paramString2, "UTF-8");
        paramString1 = paramString2;
        if (paramString3 != null)
        {
          paramString1 = paramString2;
          if (paramString3.contains("kandianshare.html5.qq.com")) {
            paramString1 = URLEncoder.encode(paramString3, "UTF-8");
          }
        }
        paramString1 = str + "&url=" + paramString1;
        paramString2 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString2;
        paramString1 = paramString1 + "&_wv=3";
        paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
        paramString2.putExtra("url", paramString1);
        paramActivity.startActivity(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
          paramActivity.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
  }
  
  private void a(Activity paramActivity, JSONObject paramJSONObject, Intent paramIntent)
  {
    a(paramActivity);
    c();
    String str2 = a(paramJSONObject);
    Object localObject1;
    Object localObject2;
    String str3;
    label139:
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      localObject1 = (AppInterface)ReadInJoyUtils.a();
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory(((AppInterface)localObject1).getAccount()).createEntityManager();
      localObject2 = (AccountDetail)((EntityManager)localObject1).find(AccountDetail.class, str2);
      ((EntityManager)localObject1).close();
      localObject1 = paramJSONObject.optString("src_action", "");
      str3 = a(paramJSONObject, str2, (AccountDetail)localObject2, (String)localObject1, null);
      if (str3.equalsIgnoreCase(paramActivity.getString(2131699723)))
      {
        boolean bool = str3.equalsIgnoreCase(paramActivity.getString(2131699723));
        if (bool)
        {
          localObject1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
          if (!bool) {
            break label285;
          }
          localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1";
          if (!bool) {
            break label293;
          }
          str1 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
          label149:
          paramIntent.putExtra("source_puin", str2);
          paramIntent.putExtra("struct_share_key_source_action", "plugin");
          paramIntent.putExtra("struct_share_key_source_a_action_data", (String)localObject1);
          paramIntent.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
          paramIntent.putExtra("struct_share_key_content_a_action_DATA", (String)localObject1);
          paramIntent.putExtra("struct_share_key_source_icon", str1);
          paramIntent.putExtra("app_name", str3);
          label220:
          paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
          if (!TextUtils.isEmpty(paramJSONObject)) {
            break label736;
          }
          paramIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
        }
      }
    }
    for (;;)
    {
      paramJSONObject = StructMsgFactory.a(paramIntent.getExtras());
      if (paramJSONObject != null) {
        break label748;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "build struct msg fail");
      }
      return;
      localObject1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
      break;
      label285:
      localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
      break label139;
      label293:
      str1 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
      break label149;
      localObject2 = paramJSONObject.optString("src_iconUrl", "");
      str1 = paramJSONObject.optString("src_actionData", "");
      String str4 = paramJSONObject.optString("src_a_actionData", "");
      String str5 = paramJSONObject.optString("src_i_actionData", "");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (("web".equals(localObject1)) && ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).contains("webcard.mp.qq.com")))) || ((!"web".equals(localObject1)) && (TextUtils.isEmpty(str1)) && ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str5)))))
      {
        localObject1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { str2 });
        localObject2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { str2 });
        paramIntent.putExtra("struct_share_key_source_action", "plugin");
        paramIntent.putExtra("struct_share_key_source_a_action_data", (String)localObject1);
        paramIntent.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
      }
      for (;;)
      {
        paramIntent.putExtra("source_puin", str2);
        paramIntent.putExtra("app_name", str3);
        localObject1 = paramJSONObject.optString("src_iconUrl", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label637;
        }
        paramIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
        break;
        paramIntent.putExtra("struct_share_key_source_action", (String)localObject1);
        if ("web".equals(localObject1))
        {
          paramIntent.putExtra("struct_share_key_source_url", (String)localObject2);
          paramIntent.putExtra("source_url", (String)localObject2);
        }
        else
        {
          if (!TextUtils.isEmpty(str1)) {
            paramIntent.putExtra("struct_share_key_source_action_data", str1);
          }
          if (!TextUtils.isEmpty(str4)) {
            paramIntent.putExtra("struct_share_key_source_a_action_data", str4);
          }
          if (!TextUtils.isEmpty(str5)) {
            paramIntent.putExtra("struct_share_key_source_i_action_data", str5);
          }
        }
      }
      label637:
      paramIntent.putExtra("struct_share_key_source_icon", (String)localObject1);
      break label220;
      if (paramJSONObject.has("source_name"))
      {
        localObject1 = paramJSONObject.optString("source_name");
        paramIntent.putExtra("app_name", (String)localObject1);
        if ((!"手Q阅读".equals(localObject1)) || (!paramJSONObject.has("srcIconUrl"))) {
          break label220;
        }
        paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
        break label220;
      }
      paramIntent.putExtra("app_name", paramActivity.getString(2131696399));
      break label220;
      label736:
      paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
    }
    label748:
    paramIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
    paramActivity.startActivityForResult(paramIntent, 21);
  }
  
  private void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    Object localObject = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str = paramJSONObject.optString("friendName");
    if ((localObject != null) && (((String)localObject).length() >= 5))
    {
      localIntent.setClass(paramActivity.getApplicationContext(), DirectForwardActivity.class);
      localIntent.putExtra("toUin", (String)localObject);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("uinname", str);
    }
    for (;;)
    {
      localObject = paramJSONObject.optJSONObject("shareVideoMsgForArk");
      if (localObject == null) {
        break;
      }
      localIntent.putExtras(VideoStructMsgHelper.a.a((JSONObject)localObject));
      paramActivity.startActivityForResult(localIntent, 21);
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
    }
    localIntent.putExtra("key_flag_from_plugin", true);
    localObject = paramString1;
    if (paramString1 != null)
    {
      localObject = paramString1;
      if (paramString1.length() > 45) {
        localObject = paramString1.substring(0, 45) + "…";
      }
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 60) {
        paramString1 = paramString2.substring(0, 60) + "…";
      }
    }
    i = paramInt;
    if (paramInt <= 0) {
      i = 13;
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", (String)localObject);
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("detail_url", paramString3);
    localIntent.putExtra("shareQQType", i);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_share_id", paramJSONObject.optLong("app_id", -1L));
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString4);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696382, new Object[] { localObject }));
    localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
    localIntent.putExtra("is_need_show_toast", paramBoolean);
    if (paramJSONObject.has("contentAction")) {
      localIntent.putExtra("struct_share_key_content_action", paramJSONObject.getString("contentAction"));
    }
    if (paramJSONObject.has("actionData")) {
      localIntent.putExtra("struct_share_key_content_action_DATA", paramJSONObject.getString("actionData"));
    }
    if (paramJSONObject.has("sourceAction")) {
      localIntent.putExtra("struct_share_key_source_action", paramJSONObject.getString("sourceAction"));
    }
    if (paramJSONObject.has("isShareFlag")) {
      localIntent.putExtra("is_share_flag", Integer.parseInt(paramJSONObject.getString("isShareFlag")));
    }
    if (paramJSONObject.has("srcActionData")) {
      localIntent.putExtra("struct_share_key_source_action_data", paramJSONObject.getString("srcActionData"));
    }
    if (paramJSONObject.has("appName")) {
      localIntent.putExtra("app_name", paramJSONObject.getString("appName"));
    }
    if (paramJSONObject.has("source_name")) {
      localIntent.putExtra("app_name", paramJSONObject.getString("source_name"));
    }
    if (paramJSONObject.has("sourceName")) {
      localIntent.putExtra("app_name", paramJSONObject.getString("sourceName"));
    }
    if ("audio".equals(paramString5))
    {
      paramInt = 2;
      localIntent.putExtra("audio_url", paramString6);
    }
    for (;;)
    {
      localIntent.putExtra("req_type", paramInt);
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      paramBoolean = paramJSONObject.optBoolean("back", true);
      if (paramJSONObject.has("k_back")) {
        paramBoolean = paramJSONObject.getBoolean("k_back");
      }
      localIntent.putExtra("k_back", paramBoolean);
      if (paramJSONObject.has("serviceID")) {
        localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
      }
      long l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break;
      }
      a(paramActivity, localIntent, l);
      return;
      i = paramJSONObject.optInt("req_type", 1);
      paramInt = i;
      if (i == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i;
      }
    }
    a(paramActivity, paramJSONObject, localIntent);
  }
  
  private void a(JSONObject paramJSONObject, int paramInt1, Activity paramActivity, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, int paramInt3)
  {
    if (paramInt1 == 72)
    {
      paramJSONObject.put("toUin", paramString1);
      paramJSONObject.put("uinType", paramInt2);
      paramJSONObject.put("friendName", paramString2);
    }
    if ((paramString6 != null) && (paramString6.contains("kandianshare.html5.qq.com")))
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(paramActivity, paramJSONObject, paramString3, paramString4, paramString6, paramString7, paramString8, paramString9, paramInt3, paramBoolean);
        return;
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramActivity, paramJSONObject, paramString3, paramString4, paramString5, paramString7, paramString8, paramString9, paramInt3, paramBoolean);
      return;
    }
  }
  
  private void a(JSONObject paramJSONObject, int paramInt, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap(1);
    int i = -1;
    if ((paramInt != 9) || (!WXShareHelper.a().a())) {
      i = 2131720753;
    }
    while (i != -1)
    {
      QRUtils.a(0, i);
      return;
      if (!WXShareHelper.a().b()) {
        i = 2131720754;
      }
    }
    boolean bool;
    String str;
    if ((paramJSONObject.optInt("WXShareToMiniProgram") == 1) && (paramInt == 9))
    {
      bool = true;
      str = paramJSONObject.optString("WXSharePath");
      if (!TextUtils.isEmpty(paramJSONObject.optString("WXShareMiniProgramSourceID"))) {
        break label161;
      }
    }
    label161:
    for (paramJSONObject = "gh_eaa1f0b1626b";; paramJSONObject = paramJSONObject.optString("WXShareMiniProgramSourceID"))
    {
      b();
      paramJSONObject = new QShareUtils.1(this, localHashMap, bool, paramString1, paramString2, paramString3, str, paramJSONObject, paramInt, paramString6, paramString5);
      if (!TextUtils.isEmpty(paramString4)) {
        break label172;
      }
      paramJSONObject.run();
      return;
      bool = false;
      break;
    }
    label172:
    ThreadManager.post(new QShareUtils.2(this, paramString4, bool, localHashMap, paramAppInterface, paramJSONObject), 8, null, false);
  }
  
  private void a(JSONObject paramJSONObject, Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    if ((paramString4 != null) && (paramString4.contains("kandianshare.html5.qq.com"))) {
      localBundle.putString("detail_url", paramString4);
    }
    for (;;)
    {
      localBundle.putString("from", "qq");
      localBundle.putString("default_text", paramJSONObject.optString("default_text"));
      paramJSONObject = new ArrayList(1);
      paramJSONObject.add(paramString5);
      localBundle.putStringArrayList("image_url", paramJSONObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 1);
      localBundle.putLong("share_begin_time", SwiftBrowserShareMenuHandler.b);
      if (!QZoneShareManager.jumpToQzoneShare(paramAppInterface, paramActivity, localBundle, null, 125)) {
        QRUtils.a(1, 2131689486);
      }
      return;
      localBundle.putString("detail_url", paramString3);
    }
  }
  
  public static List<Integer>[] a(boolean paramBoolean, Set<String> paramSet)
  {
    if (BaseApplicationImpl.getApplication().getRuntime() == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    if ((!paramSet.contains("menuItem:share:kandian")) && (!paramSet.contains("menuItem:share:diandian")) && (paramBoolean)) {
      localArrayList1.add(Integer.valueOf(13));
    }
    if (!paramSet.contains("menuItem:share:qq")) {
      localArrayList1.add(Integer.valueOf(2));
    }
    if (!paramSet.contains("menuItem:share:QZone")) {
      localArrayList1.add(Integer.valueOf(3));
    }
    if (!paramSet.contains("menuItem:share:appMessage")) {
      localArrayList1.add(Integer.valueOf(9));
    }
    if (!paramSet.contains("menuItem:share:timeline")) {
      localArrayList1.add(Integer.valueOf(10));
    }
    if (!paramSet.contains("menuItem:share:sinaWeibo")) {
      localArrayList1.add(Integer.valueOf(12));
    }
    if (!paramSet.contains("menuItem:openWithQQBrowser")) {
      localArrayList1.add(Integer.valueOf(5));
    }
    if (!paramSet.contains("menuItem:openWithSafari")) {
      localArrayList1.add(Integer.valueOf(4));
    }
    ArrayList localArrayList2 = new ArrayList();
    if (!paramSet.contains("menuItem:screenShotShare")) {
      localArrayList2.add(Integer.valueOf(21));
    }
    if (!paramSet.contains("menuItem:copyUrl")) {
      localArrayList2.add(Integer.valueOf(1));
    }
    if (!paramSet.contains("menuItem:exposeArticle")) {
      localArrayList2.add(Integer.valueOf(11));
    }
    Collections.sort(localArrayList2);
    return new List[] { localArrayList1, localArrayList2 };
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new QShareUtils.3(this);
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "dialog dimiss time :" + l);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  int a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    default: 
      return -1;
    case 2: 
      return 0;
    case 3: 
      return 1;
    case 9: 
      return 2;
    case 10: 
      return 3;
    case 12: 
      return 4;
    case 13: 
      return 7;
    }
    return 8;
  }
  
  public void a()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt1, Activity paramActivity, String paramString1, int paramInt2, String paramString2)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    for (;;)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      String str6;
      String str8;
      String str9;
      try
      {
        paramJSONObject.optString("source_name", "QQ浏览器");
        str1 = paramJSONObject.optString("title");
        str2 = paramJSONObject.optString("desc");
        str3 = paramJSONObject.optString("share_url");
        str4 = paramJSONObject.optString("aio_share_url");
        String str5 = paramJSONObject.optString("qzone_share_url");
        str6 = paramJSONObject.optString("image_url");
        String str7 = paramJSONObject.optString("flash_url");
        str8 = paramJSONObject.optString("shareText");
        str9 = paramJSONObject.optString("shouldSharePlainTextChannel");
        if (paramJSONObject.optInt("hideSuccessToast") != 1) {
          break label296;
        }
        bool = true;
        int i = paramJSONObject.optInt("shareQQType", 13);
        if ((paramInt1 == 72) || (paramInt1 == 2) || (paramInt1 == 73))
        {
          a(paramJSONObject, paramInt1, paramActivity, paramString1, paramInt2, paramString2, str1, str2, str3, str4, str6, "news", str7, bool, i);
          return;
        }
        if (paramInt1 == 3)
        {
          a(paramJSONObject, paramActivity, localAppInterface, str1, str2, str3, str5, str6);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      if ((paramInt1 == 9) || (paramInt1 == 10))
      {
        a(paramJSONObject, paramInt1, localAppInterface, str1, str2, a(paramJSONObject, str3, paramInt1), str6, str8, str9);
        ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), ReadInJoyShareHelperV2.ShareReport.a.a(), 1);
        return;
      }
      if (paramInt1 == 12)
      {
        a(paramActivity, str1, str3, str4, str6);
        ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), ReadInJoyShareHelperV2.ShareReport.a.a(), 1);
      }
      return;
      label296:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils
 * JD-Core Version:    0.7.0.1
 */