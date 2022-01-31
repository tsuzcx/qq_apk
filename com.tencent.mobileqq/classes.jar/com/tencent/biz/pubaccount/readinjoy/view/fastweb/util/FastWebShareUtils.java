package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mru;
import mrv;
import mrw;
import mrx;
import org.json.JSONObject;

public class FastWebShareUtils
{
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  private final String jdField_a_of_type_JavaLangString = FastWebShareUtils.class.getSimpleName();
  private String b;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new mru(this);
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, ArticleInfo paramArticleInfo)
  {
    paramContext = ReadInJoyUtils.a(paramContext, paramArticleInfo, (int)paramArticleInfo.mChannelID, "1");
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
  
  void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    Intent localIntent = new Intent();
    String str = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    if ((str != null) && (str.length() >= 5))
    {
      localIntent.setClass(paramActivity.getApplicationContext(), DirectForwardActivity.class);
      localIntent.putExtra("toUin", str);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("key_flag_from_plugin", true);
      str = paramString1;
      if (paramString1 != null)
      {
        str = paramString1;
        if (paramString1.length() > 45) {
          str = paramString1.substring(0, 45) + "…";
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
      localIntent.putExtra("title", str);
      localIntent.putExtra("desc", paramString1);
      localIntent.putExtra("detail_url", paramString3);
      localIntent.putExtra("shareQQType", i);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("image_url_remote", paramString4);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131430119, new Object[] { str }));
      localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
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
      if (!"audio".equals(paramString5)) {
        break label727;
      }
      paramInt = 2;
      localIntent.putExtra("audio_url", paramString6);
    }
    boolean bool;
    long l;
    for (;;)
    {
      localIntent.putExtra("req_type", paramInt);
      if (paramJSONObject.has("report")) {
        localIntent.putExtra("report", paramJSONObject.getString("report"));
      }
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
      bool = paramJSONObject.optBoolean("back", false);
      if (paramJSONObject.has("k_back")) {
        bool = paramJSONObject.getBoolean("k_back");
      }
      localIntent.putExtra("k_back", bool);
      if (paramJSONObject.has("serviceID")) {
        localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
      }
      l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break label767;
      }
      paramJSONObject = (AppInterface)ReadInJoyUtils.a();
      if (paramJSONObject != null)
      {
        a(paramActivity);
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435499);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        Share.a(paramJSONObject, paramActivity, paramJSONObject.getAccount(), l, 3000L, new mrv(this, localIntent, paramActivity));
      }
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
      break;
      label727:
      i = paramJSONObject.optInt("req_type", 1);
      paramInt = i;
      if (i == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i;
      }
    }
    label767:
    a(paramActivity);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "dialog dimiss time :" + l);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    label1029:
    label1678:
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = (AppInterface)ReadInJoyUtils.a();
        paramString2 = paramString2.getEntityManagerFactory(paramString2.getAccount()).createEntityManager();
        paramString5 = (AccountDetail)paramString2.a(AccountDetail.class, paramString1);
        paramString2.a();
        paramString4 = paramJSONObject.optString("src_action", "");
        paramString2 = null;
        if (TextUtils.isEmpty(paramString4)) {
          if (paramString5 == null) {
            break label1706;
          }
        }
      }
      label1039:
      label1049:
      label1699:
      label1706:
      for (paramString2 = paramString5.name;; paramString2 = null)
      {
        paramString3 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          paramString3 = paramString2;
          if (paramJSONObject.has("sourceName")) {
            paramString3 = paramJSONObject.optString("sourceName");
          }
        }
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString2 = paramString1;
        }
        for (;;)
        {
          label991:
          if (paramString2.equalsIgnoreCase(paramActivity.getString(2131432085)))
          {
            bool = paramString2.equalsIgnoreCase(paramActivity.getString(2131432085));
            if (bool)
            {
              paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
              if (!bool) {
                break label1221;
              }
              paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
              if (!bool) {
                break label1229;
              }
              paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString3);
              localIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
              localIntent.putExtra("struct_share_key_source_icon", paramString4);
              localIntent.putExtra("app_name", paramString2);
            }
          }
          for (;;)
          {
            paramJSONObject = StructMsgFactory.a(localIntent.getExtras());
            if (paramJSONObject != null) {
              break label1678;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "build struct msg fail");
            return;
            if (paramJSONObject.has("sourceName")) {
              paramString2 = paramJSONObject.optString("sourceName");
            }
            paramString3 = paramString2;
            if (TextUtils.isEmpty(paramString2))
            {
              paramString3 = paramString2;
              if (paramString5 != null) {
                paramString3 = paramString5.name;
              }
            }
            if (!TextUtils.isEmpty(paramString3)) {
              break label1699;
            }
            paramString2 = paramString1;
            break label991;
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
            break label1029;
            label1221:
            paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
            break label1039;
            label1229:
            paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
            break label1049;
            paramString3 = paramJSONObject.optString("src_webActionUrl", "");
            paramString5 = paramJSONObject.optString("src_actionData", "");
            paramString6 = paramJSONObject.optString("src_a_actionData", "");
            str = paramJSONObject.optString("src_i_actionData", "");
            if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(paramString6)) || (TextUtils.isEmpty(str)))))
            {
              paramString3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
              paramString4 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
            }
            for (;;)
            {
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("app_name", paramString2);
              paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
              if (!TextUtils.isEmpty(paramJSONObject)) {
                break label1581;
              }
              localIntent.putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
              break;
              localIntent.putExtra("struct_share_key_source_action", paramString4);
              if ("web".equals(paramString4))
              {
                localIntent.putExtra("struct_share_key_source_url", paramString3);
                localIntent.putExtra("source_url", paramString3);
              }
              else
              {
                if (!TextUtils.isEmpty(paramString5)) {
                  localIntent.putExtra("struct_share_key_source_action_data", paramString5);
                }
                if (!TextUtils.isEmpty(paramString6)) {
                  localIntent.putExtra("struct_share_key_source_a_action_data", paramString6);
                }
                if (!TextUtils.isEmpty(str)) {
                  localIntent.putExtra("struct_share_key_source_i_action_data", str);
                }
              }
            }
            label1581:
            localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
            continue;
            if (paramJSONObject.has("sourceName"))
            {
              paramString1 = paramJSONObject.optString("sourceName");
              localIntent.putExtra("app_name", paramString1);
              if (("手Q阅读".equals(paramString1)) && (paramJSONObject.has("srcIconUrl"))) {
                localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
              }
            }
            else
            {
              localIntent.putExtra("app_name", paramActivity.getString(2131430118));
            }
          }
          localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
          paramActivity.startActivityForResult(localIntent, 1);
          return;
          paramString2 = paramString3;
        }
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = (AppInterface)ReadInJoyUtils.a();
    Object localObject2;
    Object localObject3;
    String str1;
    String str2;
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(paramString3);
      localObject3 = ((JSONObject)localObject2).optString("share_type", "0");
      str1 = ((JSONObject)localObject2).optString("title");
      str2 = ((JSONObject)localObject2).optString("desc");
      localObject1 = ((JSONObject)localObject2).optString("share_url");
      paramString3 = ((JSONObject)localObject2).optString("image_url");
      String str3 = ((JSONObject)localObject2).optString("shareElement");
      String str4 = ((JSONObject)localObject2).optString("flash_url");
      int i = ((JSONObject)localObject2).optInt("shareQQType", 13);
      if (paramInt == 2)
      {
        a(paramActivity, (JSONObject)localObject2, str1, str2, (String)localObject1, paramString3, str3, str4, i);
        a(paramString1.getApplication().getApplicationContext(), paramString2, 2, paramArticleInfo);
        return;
      }
      if (paramInt != 3) {
        break label826;
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("title", str1);
      ((Bundle)localObject3).putString("desc", str2);
      ((Bundle)localObject3).putString("detail_url", (String)localObject1);
      ((Bundle)localObject3).putString("from", "qq");
      if (localObject2 != null) {
        ((Bundle)localObject3).putString("default_text", ((JSONObject)localObject2).optString("default_text"));
      }
      localObject1 = new ArrayList(1);
      ((ArrayList)localObject1).add(paramString3);
      ((Bundle)localObject3).putStringArrayList("image_url", (ArrayList)localObject1);
      ((Bundle)localObject3).putLong("req_share_id", 0L);
      ((Bundle)localObject3).putInt("iUrlInfoFrm", 1);
      ((Bundle)localObject3).putLong("share_begin_time", SwiftBrowserShareMenuHandler.b);
      if (!QZoneShareManager.a((QQAppInterface)paramString1, paramActivity.getApplicationContext(), (Bundle)localObject3, null, 1))
      {
        QRUtils.a(1, 2131435496);
        return;
      }
    }
    catch (Exception paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
      return;
    }
    a(paramString1.getApplication().getApplicationContext(), paramString2, 3, paramArticleInfo);
    return;
    for (;;)
    {
      localObject2 = new HashMap(1);
      paramInt = -1;
      if (!WXShareHelper.a().a()) {
        paramInt = 2131435335;
      }
      while (paramInt != -1)
      {
        QRUtils.a(0, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131435336;
        }
      }
      a();
      paramArticleInfo = new mrw(this, (Map)localObject2, str1, str2, (String)localObject1, (String)localObject3, paramString1, paramString2, paramArticleInfo);
      if (TextUtils.isEmpty(paramString3))
      {
        paramArticleInfo.run();
        return;
      }
      a(paramActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435499);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      ThreadManager.post(new mrx(this, paramString3, (Map)localObject2, paramString1, paramArticleInfo), 8, null, false);
      return;
      label826:
      do
      {
        if ((paramInt != 13) && (paramInt == 12))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
          }
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina empty title or share_url");
            }
            QQToast.a(BaseApplication.getContext(), 0, 2131435319, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
          }
          try
          {
            str1 = URLEncoder.encode(str1, "UTF-8");
            str1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + str1;
            localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
            localObject1 = str1 + "&url=" + (String)localObject1;
            paramString3 = URLEncoder.encode(paramString3, "UTF-8");
            paramString3 = (String)localObject1 + "&pic=" + paramString3;
            paramString3 = paramString3 + "&_wv=3";
            localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramString3);
            paramActivity.startActivity((Intent)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
            }
            a(paramString1.getApplication().getApplicationContext(), paramString2, 6, paramArticleInfo);
          }
          catch (Exception paramArticleInfo)
          {
            for (;;)
            {
              paramArticleInfo = paramArticleInfo;
              QQToast.a(BaseApplication.getContext(), 0, 2131435319, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
              paramArticleInfo.printStackTrace();
            }
          }
          finally {}
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
            return;
          }
        }
        return;
        if (paramInt == 9) {
          break;
        }
      } while (paramInt != 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils
 * JD-Core Version:    0.7.0.1
 */