package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoyWebviewPlugin;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInjoyWebShareHelper
  implements ReadInJoyShareHelperV2.OnFontSizeChangeListener
{
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public CustomWebView a;
  WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener;
  private ReadInJoyWebviewPlugin jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoyWebviewPlugin;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
  private ReadInjoyWebShareHelper.ShareInfo jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private WebViewPlugin.PluginRuntime jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
  WebUiUtils.QQBrowserBaseActivityInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = null;
  WebUiUtils.WebUiMethodInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = null;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  private List<ActionItem> jdField_a_of_type_JavaUtilList;
  private long jdField_b_of_type_Long = -1L;
  private String jdField_b_of_type_JavaLangString;
  private List<ActionItem> jdField_b_of_type_JavaUtilList;
  private String c;
  
  public ReadInjoyWebShareHelper(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, TroopMemberApiClient paramTroopMemberApiClient)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoyWebviewPlugin = paramReadInJoyWebviewPlugin;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime = paramReadInJoyWebviewPlugin.mRuntime;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = paramTroopMemberApiClient;
    this.jdField_a_of_type_AndroidAppActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
    paramReadInJoyWebviewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a());
    if ((paramReadInJoyWebviewPlugin != null) && ((paramReadInJoyWebviewPlugin instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = ((WebUiUtils.WebUiMethodInterface)paramReadInJoyWebviewPlugin);
    }
    paramReadInJoyWebviewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a());
    if ((paramReadInJoyWebviewPlugin != null) && ((paramReadInJoyWebviewPlugin instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = ((WebUiUtils.QQBrowserBaseActivityInterface)paramReadInJoyWebviewPlugin);
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.c);
      String str6 = localJSONObject.optString("share_type", "0");
      String str2 = localJSONObject.optString("title");
      String str3 = localJSONObject.optString("desc");
      String str4 = localJSONObject.optString("share_url");
      String str5 = localJSONObject.optString("image_url");
      String str7 = localJSONObject.optString("shareElement");
      String str1 = localJSONObject.optString("weibo_title");
      boolean bool = localJSONObject.optBoolean("keepShareUrl", false);
      switch (paramActionSheetItem.action)
      {
      case 72: 
        localJSONObject.put("toUin", paramActionSheetItem.uin);
        localJSONObject.put("uinType", paramActionSheetItem.uinType);
        localJSONObject.put("uinname", paramActionSheetItem.label);
      case 2: 
      case 73: 
        a(localJSONObject, str6, str2, str3, str4, str5, str7, 13, bool);
        return;
      case 3: 
        a(localJSONObject, str6, str2, str3, str4, str5);
        return;
      case 9: 
        a(localJSONObject, true, str2, str3, str4, str5, str7);
        return;
      case 10: 
        a(localJSONObject, false, str2, str3, str4, str5, str7);
        return;
      case 12: 
        paramActionSheetItem = str2;
        if (!TextUtils.isEmpty(str1)) {
          paramActionSheetItem = str1;
        }
        a(paramActionSheetItem, str3, str4, str5);
        return;
      }
      return;
    }
    catch (Exception paramActionSheetItem) {}
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (this.jdField_b_of_type_JavaLangString != null) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("action", paramString);
        if (!paramBoolean) {
          continue;
        }
        paramString = "0";
        localJSONObject.put("retCode", paramString);
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      ReadInJoyShareHelperV2.ShareReport.a.a(paramBoolean);
      return;
      paramString = "1";
    }
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((!paramBoolean) && (paramString4 != null) && (paramString4.length() > 140) && (!"3".equals(paramString1))) {
      localHashMap.put("share_url", paramString4);
    }
    if ((paramString5 != null) && (paramString5.length() > 80) && (!"2".equals(paramString1)) && (!"3".equals(paramString1)) && (!"4".equals(paramString1))) {
      localHashMap.put("image_url", paramString5);
    }
    c();
    ThreadManager.post(new ReadInjoyWebShareHelper.3(this, localHashMap, paramString4, paramString5, paramJSONObject, paramString2, paramString3, paramString6), 8, null, true);
  }
  
  private List<Integer>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList1.add(Integer.valueOf(((ActionItem)((Iterator)localObject).next()).a));
    }
    ArrayList localArrayList2 = new ArrayList();
    localObject = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList2.add(Integer.valueOf(((ActionItem)((Iterator)localObject).next()).a));
    }
    if (localArrayList2.contains(Integer.valueOf(68)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo != null) {
        break label152;
      }
      localObject = null;
      if (!TeamWorkConvertUtils.a((String)localObject)) {
        break label163;
      }
      TeamWorkConvertUtils.a(0, 3);
    }
    for (;;)
    {
      return new List[] { localArrayList1, localArrayList2 };
      label152:
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.c;
      break;
      label163:
      localArrayList2.remove(Integer.valueOf(68));
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("fromFav", false)))
    {
      this.jdField_a_of_type_Long = localIntent.getLongExtra("favID", -1L);
      this.jdField_b_of_type_Long = localIntent.getLongExtra("favGroupID", -1L);
    }
    if (this.jdField_a_of_type_Long != -1L) {
      this.jdField_b_of_type_JavaUtilList.add(2, new ActionItem("fav_move_group", 39, false));
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void e()
  {
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.a;
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.jdField_b_of_type_JavaLangString;
    String str3 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.d;
    String str4 = ((WebViewFragment)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a()).uin;
    String str5 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.f;
    QfavBuilder.a(0, str1, this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.c, str5, str2, str3, null, null, false, -1L).a("lCategory", 8L).c(str4).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(), str4);
  }
  
  private void f()
  {
    if (Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.c).matches()) {}
    for (int i = 1;; i = 0) {
      try
      {
        String str1 = URLEncoder.encode(this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.c, "UTF-8");
        WebViewFragment localWebViewFragment = (WebViewFragment)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
        str4 = localWebViewFragment.uin;
        if (i != 0)
        {
          String str5 = String.valueOf(NetConnInfoCenter.getServerTime());
          String str3 = MD5Utils.encodeHexStr(str1 + 200 + str5 + "jubao@article@123");
          Object localObject = str3;
          if (str3 != null)
          {
            localObject = str3;
            if (!str3.isEmpty()) {
              localObject = str3.toLowerCase();
            }
          }
          str3 = localWebViewFragment.publicUin;
          str1 = "https://post.mp.qq.com/jubao/index?qq=" + str4 + "&mp_uin=" + str3 + "&scene=200&sub_appname=article_webview&timestamp=" + str5 + "&sign=" + (String)localObject + "&article_url=" + str1 + "&_wv=3";
          localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", str1);
          ((Intent)localObject).putExtra("hide_more_button", true);
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          String str4;
          if (QLog.isColorLevel()) {
            QLog.d("WebShareHelper", 2, "encode shareUrl failed, because UTF-8 is unknown");
          }
          String str2 = null;
          continue;
          str2 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + str2 + "&qq=" + str4 + "&_wv=7";
        }
      }
    }
  }
  
  Activity a()
  {
    for (Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public void a()
  {
    d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener != null) {
      WxShareHelperFromReadInjoy.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener);
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getSettings().setTextZoom(SwiftBrowserShareMenuHandler.a[paramInt]);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramInt);
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    boolean bool;
    if (paramInt == -1)
    {
      bool = true;
      if (paramByte != 1) {
        break label29;
      }
      a("qq_friend", bool);
    }
    label29:
    while (paramByte != 2)
    {
      return;
      bool = false;
      break;
    }
    a("qzone", bool);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(), new ReadInjoyWebShareHelper.ItemClickProcessor(this));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setCancelListener(new ReadInjoyWebShareHelper.1(this));
    for (;;)
    {
      try
      {
        this.c = paramString;
        paramString = new JSONObject(this.c);
        JSONArray localJSONArray1 = paramString.optJSONArray("upline");
        JSONArray localJSONArray2 = paramString.optJSONArray("belowline");
        if (localJSONArray1 == null)
        {
          this.jdField_a_of_type_JavaUtilList = ReadInJoyShareHelperV2.b();
          if (localJSONArray2 == null)
          {
            this.jdField_b_of_type_JavaUtilList = ReadInJoyShareHelperV2.c();
            b();
            this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo = new ReadInjoyWebShareHelper.ShareInfo(null);
            this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.c = paramString.optString("share_url");
            this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.jdField_b_of_type_JavaLangString = paramString.optString("desc");
            this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.a = paramString.optString("title");
            this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.d = paramString.optString("image_url");
            this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.e = paramString.optString("puin");
            this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.f = paramString.optString("nick_name");
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.f)) {
              this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.f = paramString.optString("sourceName");
            }
            this.jdField_b_of_type_JavaLangString = paramString.optString("callback");
            int i = paramString.optInt("report_from");
            this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a(a(), i, this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ShareInfo.c, null);
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList = ReadInJoyShareHelperV2.a(localJSONArray1, null);
          continue;
        }
        this.jdField_b_of_type_JavaUtilList = ReadInJoyShareHelperV2.a(localJSONArray2, null);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString2);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebShareHelper", 2, "shareMsgToSina start!");
    }
    try
    {
      localObject = Uri.parse(paramString3);
      if (localObject != null)
      {
        localObject = ((Uri)localObject).getHost();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("article.mp.qq.com".equalsIgnoreCase((String)localObject)) || ("post.mp.qq.com".equalsIgnoreCase((String)localObject))))
        {
          b(paramString1, paramString2, paramString3, paramString4);
          return;
        }
      }
    }
    catch (Exception paramString2)
    {
      do
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebShareHelper", 2, "shareMsgToSina empty title or share_url");
          }
          d();
          QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
          return;
        }
        Object localObject = BaseApplicationImpl.getContext().getPackageManager();
        try
        {
          localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
          if (QLog.isColorLevel()) {
            QLog.d("WebShareHelper", 2, "shareMsgToSina installSinaWeibo:true");
          }
          ThreadManager.executeOnSubThread(new ReadInjoyWebShareHelper.6(this, paramString4, paramString1, paramString3, (ApplicationInfo)localObject, paramString2));
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label235;
            }
            QLog.d("WebShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
            try
            {
              paramString1 = URLEncoder.encode(paramString1, "UTF-8");
              paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1;
              paramString3 = URLEncoder.encode(paramString3, "UTF-8");
              paramString1 = paramString1 + "&url=" + paramString3;
              paramString3 = URLEncoder.encode(paramString4, "UTF-8");
              paramString1 = paramString1 + "&pic=" + paramString3;
              paramString1 = paramString1 + "&_wv=3";
              paramString3 = new Intent(paramString2, QQBrowserActivity.class);
              paramString3.putExtra("url", paramString1);
              paramString2.startActivity(paramString3);
              if (!QLog.isColorLevel()) {
                break label400;
              }
              QLog.d("WebShareHelper", 2, "shareMsgToSina start webview!");
              d();
            }
            catch (Exception paramString1)
            {
              QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
              paramString1.printStackTrace();
              d();
            }
            finally
            {
              d();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("WebShareHelper", 2, "shareMsgToSina end!");
      return;
    }
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i = 2;
    d();
    paramString1 = new Bundle();
    paramString1.putString("title", paramString2);
    paramString1.putString("desc", paramString3);
    paramString1.putString("detail_url", paramString4);
    paramString1.putString("from", "qq");
    if (paramJSONObject != null) {
      paramString1.putString("default_text", paramJSONObject.optString("default_text"));
    }
    paramJSONObject = new ArrayList(1);
    paramJSONObject.add(paramString5);
    paramString1.putStringArrayList("image_url", paramJSONObject);
    paramString1.putLong("req_share_id", 0L);
    paramString1.putInt("iUrlInfoFrm", 1);
    paramString1.putLong("share_begin_time", SwiftBrowserShareMenuHandler.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null)
    {
      paramString1.putString("struct_url", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
      paramString1.putBoolean("from_web", true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface.switchRequestCode(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoyWebviewPlugin, (byte)2, true);
    }
    QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(), this.jdField_a_of_type_AndroidAppActivity, paramString1, null, i);
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
    Intent localIntent = new Intent();
    paramString5 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str1 = paramJSONObject.optString("uinname");
    if ((paramString5 != null) && (paramString5.length() >= 5))
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString5);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("uinname", str1);
    }
    for (;;)
    {
      localIntent.putExtra("key_flag_from_plugin", true);
      paramString5 = paramString1;
      if (paramString1 != null)
      {
        paramString5 = paramString1;
        if (paramString1.length() > 45) {
          paramString5 = paramString1.substring(0, 45) + "…";
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
      localIntent.putExtra("title", paramString5);
      localIntent.putExtra("desc", paramString1);
      localIntent.putExtra("detail_url", paramString3);
      localIntent.putExtra("shareQQType", i);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("image_url_remote", paramString4);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696382, new Object[] { paramString5 }));
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
      localIntent.putExtra("req_type", 144);
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      localIntent.putExtra("k_back", paramJSONObject.optBoolean("back", false));
      if (paramJSONObject.has("serviceID")) {
        localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
      }
      if (paramJSONObject.has("serviceID"))
      {
        paramInt = paramJSONObject.getInt("serviceID");
        if ((paramInt == 116) || (paramInt == 123)) {
          localIntent.putExtra("compatible_text", ConfessMsgUtil.a);
        }
      }
      long l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break;
      }
      paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
      if (paramJSONObject != null)
      {
        c();
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        Share.a(paramJSONObject, this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.getAccount(), l, 3000L, new ReadInjoyWebShareHelper.2(this, localIntent));
      }
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    }
    d();
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getAccount()).createEntityManager();
        paramString5 = (AccountDetail)paramString2.find(AccountDetail.class, paramString1);
        paramString2.close();
        paramString4 = paramJSONObject.optString("src_action", "");
        paramString2 = null;
        if (TextUtils.isEmpty(paramString4)) {
          if (paramString5 == null) {
            break label1591;
          }
        }
      }
      label932:
      label942:
      label1585:
      label1591:
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
          if (paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getString(2131699723)))
          {
            boolean bool = paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getString(2131699723));
            if (bool)
            {
              paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
              if (!bool) {
                break label1120;
              }
              paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
              if (!bool) {
                break label1128;
              }
              paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
              label952:
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
            localIntent.putExtra("stuctmsg_bytes", StructMsgFactory.a(localIntent.getExtras()).getBytes());
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoyWebviewPlugin.startActivityForResult(localIntent, (byte)1);
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
              break label1585;
            }
            paramString2 = paramString1;
            break;
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
            break label932;
            label1120:
            paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
            break label942;
            label1128:
            paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
            break label952;
            paramString3 = paramJSONObject.optString("src_webActionUrl", "");
            paramString5 = paramJSONObject.optString("src_actionData", "");
            str1 = paramJSONObject.optString("src_a_actionData", "");
            String str2 = paramJSONObject.optString("src_i_actionData", "");
            if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))))
            {
              paramString3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
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
                break label1483;
              }
              localIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
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
                if (!TextUtils.isEmpty(str1)) {
                  localIntent.putExtra("struct_share_key_source_a_action_data", str1);
                }
                if (!TextUtils.isEmpty(str2)) {
                  localIntent.putExtra("struct_share_key_source_i_action_data", str2);
                }
              }
            }
            label1483:
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
              localIntent.putExtra("app_name", this.jdField_a_of_type_AndroidAppActivity.getString(2131696399));
            }
          }
          paramString2 = paramString3;
        }
      }
    }
  }
  
  void a(JSONObject paramJSONObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
    int i = -1;
    if (!WXShareHelper.a().a()) {
      i = 2131720753;
    }
    while (i != -1)
    {
      QRUtils.a(0, i);
      d();
      return;
      if (!WXShareHelper.a().b()) {
        i = 2131720754;
      }
    }
    if (paramJSONObject.optInt("WXShareToMiniProgram") == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString5 = paramJSONObject.optString("WXSharePath");
      paramJSONObject = new HashMap(1);
      paramString1 = new ReadInjoyWebShareHelper.4(this, paramBoolean, paramJSONObject, bool, paramString1, paramString2, paramString3, paramString5);
      c();
      ThreadManager.post(new ReadInjoyWebShareHelper.5(this, paramString4, bool, paramJSONObject, paramString1, paramBoolean, paramString3), 8, null, false);
      return;
    }
  }
  
  void b(String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      a(this.jdField_b_of_type_JavaLangString, paramString);
    }
  }
  
  void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      d();
      QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1;
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString3;
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString3;
        paramString1 = paramString1 + "&_wv=3";
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("WebShareHelper", 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
          paramString1.printStackTrace();
          d();
        }
      }
      finally
      {
        d();
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebShareHelper", 2, "shareMsgToSina end!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper
 * JD-Core Version:    0.7.0.1
 */