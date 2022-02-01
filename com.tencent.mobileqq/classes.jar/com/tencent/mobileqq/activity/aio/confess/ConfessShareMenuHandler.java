package com.tencent.mobileqq.activity.aio.confess;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface.ActionItem;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.MD5Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfessShareMenuHandler
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, RangeButtonView.OnChangeListener
{
  public static final int[] a;
  public static long b;
  public int a;
  public long a;
  public Activity a;
  public PopupWindow a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  public Share a;
  private ConfessShareMenuHandler.UIParam jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessShareMenuHandler$UIParam;
  public ShareActionSheetBuilder a;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  public String a;
  public final ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<IPublicAccountJavascriptInterface.ActionItem> b;
  public boolean b;
  private int c;
  public String c;
  public boolean c;
  public String d;
  boolean d;
  private String e;
  public boolean e;
  private String f;
  public boolean f;
  private boolean g = false;
  private boolean h = false;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 95, 100, 107, 115, 127 };
    jdField_b_of_type_Long = -1L;
  }
  
  public ConfessShareMenuHandler(Activity paramActivity, WebView paramWebView)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 4L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    a();
  }
  
  private void c()
  {
    if (a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.getShareUrl()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "is not need load share js..");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "loadShareJs");
      }
      a(System.currentTimeMillis());
      int j = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int i = j;
      if (j < 0) {
        i = 190;
      }
      String str = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
      WebView localWebView = this.jdField_a_of_type_ComTencentSmttSdkWebView;
      if (localWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:");
        localStringBuilder.append(str);
        localStringBuilder.append(";");
        localWebView.loadUrl(localStringBuilder.toString());
      }
    }
  }
  
  public TroopMemberApiClient a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    return this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  }
  
  public String a()
  {
    Share localShare = this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
    if (localShare == null) {
      return "";
    }
    return localShare.getShareUrl();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("url");
    if (this.jdField_e_of_type_JavaLangString == null)
    {
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("key_params_qq");
      if (this.jdField_e_of_type_JavaLangString == null) {
        this.jdField_e_of_type_JavaLangString = "";
      }
    }
    localObject = this.jdField_e_of_type_JavaLangString;
    this.jdField_f_of_type_JavaLangString = ((String)localObject);
    a((String)localObject);
  }
  
  public void a(int paramInt)
  {
    String str2 = a();
    if (str2 == null) {
      str2 = this.jdField_e_of_type_JavaLangString;
    }
    Object localObject = Uri.parse(str2);
    if ((!"article.mp.qq.com".equalsIgnoreCase(((Uri)localObject).getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(((Uri)localObject).getHost()))) {
      return;
    }
    String str1;
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("article_id");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str1 = "";
    }
    if (str1 == null) {
      str1 = "";
    }
    if (paramInt != 21)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 12: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1012", "");
        return;
      case 11: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1008", "");
        return;
      case 10: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1004", "");
        return;
      case 9: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1003", "");
        return;
      case 8: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1009", "");
        return;
      case 7: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1010", "");
        return;
      case 6: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1007", "");
        return;
      case 5: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1005", "");
        return;
      case 4: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1006", "");
        return;
      case 3: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1002", "");
        return;
      case 2: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1001", "");
        return;
      }
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1011", "");
      return;
    }
    ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1013", "");
  }
  
  @TargetApi(12)
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    Object localObject3;
    String str1;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    int j;
    int i;
    Object localObject5;
    if (paramBundle != null)
    {
      localObject3 = paramBundle.getString("qq", "");
      str1 = paramBundle.getString("public_uin", "");
      localObject1 = paramBundle.getString("source_public_uin", "");
      localObject2 = paramBundle.getString("default_url", "");
      localObject4 = paramBundle.getString("msg_id", "");
      j = paramBundle.getInt("troop_app_id", 0);
      i = paramBundle.getInt("troop_id", 0);
      localObject5 = paramBundle.getString("troop_app_info_url", "");
      paramBundle.getInt("uin_type", 0);
    }
    else
    {
      str2 = "";
      str1 = "";
      localObject1 = str1;
      localObject2 = localObject1;
      localObject3 = localObject2;
      localObject4 = localObject3;
      j = 0;
      i = 0;
      localObject5 = localObject3;
      localObject3 = str2;
    }
    String str2 = this.jdField_e_of_type_JavaLangString;
    if (!TextUtils.isEmpty(null)) {
      throw new NullPointerException();
    }
    String str3 = paramString;
    boolean bool;
    if (paramInt == 1)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(str3);
      QRUtils.a(2, 2131691296);
      if ((this.h) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c();
      }
    }
    else if (paramInt == 11)
    {
      bool = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(str3).matches();
    }
    try
    {
      paramString = URLEncoder.encode(str3, "UTF-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      label258:
      break label258;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
    }
    paramString = null;
    if (bool)
    {
      str2 = String.valueOf(NetConnInfoCenter.getServerTime());
      paramBundle = new StringBuilder();
      paramBundle.append(paramString);
      paramBundle.append(200);
      paramBundle.append(str2);
      paramBundle.append("jubao@article@123");
      localObject5 = MD5Utils.encodeHexStr(paramBundle.toString());
      paramBundle = (Bundle)localObject5;
      if (localObject5 != null)
      {
        paramBundle = (Bundle)localObject5;
        if (!((String)localObject5).isEmpty()) {
          paramBundle = ((String)localObject5).toLowerCase();
        }
      }
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("https://post.mp.qq.com/jubao/index?qq=");
      ((StringBuilder)localObject5).append((String)localObject3);
      ((StringBuilder)localObject5).append("&mp_uin=");
      ((StringBuilder)localObject5).append(str1);
      ((StringBuilder)localObject5).append("&scene=200&sub_appname=article_webview&timestamp=");
      ((StringBuilder)localObject5).append(str2);
      ((StringBuilder)localObject5).append("&sign=");
      ((StringBuilder)localObject5).append(paramBundle);
      ((StringBuilder)localObject5).append("&article_url=");
      ((StringBuilder)localObject5).append(paramString);
      ((StringBuilder)localObject5).append("&_wv=3");
      paramString = ((StringBuilder)localObject5).toString();
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("https://guanjia.qq.com/online_server/m_report.html?shareUrl=");
      paramBundle.append(paramString);
      paramBundle.append("&qq=");
      paramBundle.append((String)localObject3);
      paramBundle.append("&_wv=7");
      paramString = paramBundle.toString();
    }
    paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    paramBundle.putExtra("url", paramString);
    paramBundle.putExtra("hide_more_button", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
    if ((localObject1 != null) && (!"".equals(localObject1)))
    {
      paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, (String)localObject1, (String)localObject4, (String)localObject2, paramString, false);
      break label3129;
      if (paramInt == 2)
      {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl())) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
          if (TextUtils.isEmpty(str2))
          {
            if (str3.equals(this.jdField_f_of_type_JavaLangString))
            {
              bool = true;
              break label749;
            }
          }
          else if (!TextUtils.isEmpty(null))
          {
            paramString = this.jdField_f_of_type_JavaLangString;
            throw new NullPointerException();
          }
        }
        bool = false;
        label749:
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.g = bool;
        a(str3, str2, null);
      }
      else if (paramInt == 4)
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(str3));
        paramString.putExtra("normal", true);
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
    }
    catch (ActivityNotFoundException paramString)
    {
      label811:
      long l1;
      long l2;
      break label811;
    }
    QRUtils.a(1, 2131695222);
    ReportController.b(null, "P_CliOper", "VIPCOMIC", "", "0X800619F", "0X800619F", 1000, 0, Util.b((String)localObject2, new String[0]), null, null, null);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
    if ((localObject1 != null) && (!"".equals(localObject1)))
    {
      paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1006, 0, (String)localObject1, (String)localObject4, (String)localObject2, paramString, false);
      break label3129;
      if (paramInt != 5) {
        if (paramInt == 3)
        {
          jdField_b_of_type_Long = System.currentTimeMillis();
          paramString = str2;
          if (TextUtils.isEmpty(str2)) {
            paramString = null;
          }
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1002, paramString, this.jdField_c_of_type_Int);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, 2, false);
          } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.s)) {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.f();
          } else {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
          }
          ReportCenter.a().a("", "", "", "1000", "102", "0", false);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
        }
        else if (paramInt == 6)
        {
          if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.setShareUrl(str3)) {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, 9, false);
          }
          if ((localObject1 != null) && (!"".equals(localObject1)))
          {
            paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject2);
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, (String)localObject1, (String)localObject4, (String)localObject2, paramString, false);
          }
        }
        else if ((paramInt != 9) && (paramInt != 10))
        {
          if (paramInt == 13)
          {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, 5, true);
          }
          else if (paramInt == 16)
          {
            paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            paramString.putExtra("url", (String)localObject5);
            paramString.putExtra("hide_operation_bar", true);
            paramString.putExtra("hide_more_button", true);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(i);
            paramBundle = paramString.toString();
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(j);
            ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, paramBundle, paramString.toString(), "", "");
          }
          else if (paramInt == 17)
          {
            if (paramBundle != null) {
              paramString = paramBundle.getString("troop_app_share_url", "");
            } else {
              paramString = "";
            }
            paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            paramBundle.putExtra("url", paramString);
            paramBundle.putExtra("hide_operation_bar", true);
            paramBundle.putExtra("hide_more_button", true);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(i);
            paramBundle = paramString.toString();
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(j);
            ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, paramBundle, paramString.toString(), "", "");
          }
          else if (paramInt == 7)
          {
            b();
          }
          else if ((paramInt != 19) && (paramInt != 20))
          {
            if (paramInt == 12)
            {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, 8, false);
              } else {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, 8, false);
              }
              paramBundle = this.jdField_e_of_type_JavaLangString;
              paramString = this.jdField_a_of_type_ComTencentSmttSdkWebView;
              if (paramString != null) {
                paramBundle = paramString.getUrl();
              }
              paramString = Uri.parse(paramBundle);
              try
              {
                paramString = paramString.getQueryParameter("article_id");
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                paramString = "";
              }
              if (paramString == null) {
                paramString = "";
              }
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800787A", "0X800787A", 0, 0, paramString, paramBundle, "", "");
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1005, paramBundle, this.jdField_c_of_type_Int);
            }
            else if (paramInt == 34)
            {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b();
              } else if (QLog.isColorLevel()) {
                QLog.d("diandian", 2, "dian dian is here");
              }
            }
            else
            {
              l1 = 0L;
              if (paramInt == 35)
              {
                paramString = this.jdField_b_of_type_JavaUtilArrayList;
                if (paramString != null)
                {
                  paramString = paramString.iterator();
                  while (paramString.hasNext())
                  {
                    paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                    if (paramBundle.jdField_a_of_type_Int == 3) {
                      try
                      {
                        paramString = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString);
                        l1 = paramString.getLong("uin");
                        paramString = paramString.optString("name");
                      }
                      catch (JSONException paramString)
                      {
                        paramString.printStackTrace();
                        return;
                      }
                    }
                  }
                }
                paramString = null;
                paramBundle = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
                localObject1 = this.jdField_a_of_type_AndroidAppActivity;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(l1);
                ((StringBuilder)localObject2).append("");
                paramString = paramBundle.startAddFriend((Context)localObject1, 1, ((StringBuilder)localObject2).toString(), null, 3001, 3999, paramString, null, null, null, null);
                ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidAppActivity, paramString);
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
              }
              else if (paramInt == 30)
              {
                paramString = this.jdField_b_of_type_JavaUtilArrayList;
                l2 = l1;
                if (paramString != null)
                {
                  l2 = l1;
                  if (this.jdField_e_of_type_Boolean)
                  {
                    paramString = paramString.iterator();
                    do
                    {
                      l2 = l1;
                      if (!paramString.hasNext()) {
                        break;
                      }
                      paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                    } while (paramBundle.jdField_a_of_type_Int != 1);
                    try
                    {
                      l2 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
                    }
                    catch (JSONException paramString)
                    {
                      paramString.printStackTrace();
                      return;
                    }
                  }
                }
                paramString = new Intent();
                paramBundle = new Bundle();
                paramString.setComponent(new ComponentName(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class));
                paramBundle.putString("uin", String.valueOf(l2));
                paramBundle.putInt("uintype", 1008);
                paramString.putExtras(paramBundle);
                paramString.putExtra("is_come_from_readinjoy", true);
                paramString.setFlags(67108864);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
              }
              else
              {
                if ((paramInt == 37) && (this.jdField_f_of_type_Boolean))
                {
                  paramString = this.jdField_b_of_type_JavaUtilArrayList;
                  l2 = l1;
                  if (paramString != null)
                  {
                    paramBundle = paramString.iterator();
                    do
                    {
                      l2 = l1;
                      if (!paramBundle.hasNext()) {
                        break;
                      }
                      paramString = (IPublicAccountJavascriptInterface.ActionItem)paramBundle.next();
                    } while (paramString.jdField_a_of_type_Int != 1);
                    try
                    {
                      l2 = new JSONObject(paramString.jdField_b_of_type_JavaLangString).getLong("uin");
                    }
                    catch (JSONException paramString)
                    {
                      paramString.printStackTrace();
                      return;
                    }
                  }
                  paramString = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
                  paramBundle = new StringBuilder();
                  paramBundle.append(l2);
                  paramBundle.append("");
                  paramString.putExtra("uin", paramBundle.toString());
                  paramString.putExtra("uintype", 0);
                  this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
                  return;
                }
                if (paramInt == 31)
                {
                  paramString = this.jdField_b_of_type_JavaUtilArrayList;
                  l2 = l1;
                  if (paramString != null)
                  {
                    paramBundle = paramString.iterator();
                    do
                    {
                      l2 = l1;
                      if (!paramBundle.hasNext()) {
                        break;
                      }
                      paramString = (IPublicAccountJavascriptInterface.ActionItem)paramBundle.next();
                    } while (paramString.jdField_a_of_type_Int != 2);
                    try
                    {
                      l2 = new JSONObject(paramString.jdField_b_of_type_JavaLangString).getLong("puin");
                    }
                    catch (JSONException paramString)
                    {
                      paramString.printStackTrace();
                      return;
                    }
                  }
                  paramBundle = new ActivityURIRequest(this.jdField_a_of_type_AndroidAppActivity, "/pubaccount/detail");
                  paramString = paramBundle.extra();
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append(l2);
                  ((StringBuilder)localObject1).append("");
                  paramString.putString("uin", ((StringBuilder)localObject1).toString());
                  paramBundle.extra().putBoolean("from_js", true);
                  QRoute.startUri(paramBundle, null);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
                }
                else if (paramInt == 38)
                {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.d();
                }
              }
            }
          }
          else
          {
            if (paramInt == 19) {
              i = 6;
            } else {
              i = 7;
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, i, false);
            } else {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, i, true);
            }
          }
        }
        else
        {
          paramString = null;
          if (TextUtils.isEmpty(str2)) {
            str2 = paramString;
          }
          if (paramInt == 9) {
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, str2, this.jdField_c_of_type_Int);
          } else {
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, str2, this.jdField_c_of_type_Int);
          }
          if (!WXShareHelper.a().a()) {
            i = 2131720478;
          } else if (!WXShareHelper.a().b()) {
            i = 2131720479;
          } else {
            i = -1;
          }
          if (i != -1)
          {
            QRUtils.a(0, i);
          }
          else if (paramInt == 9)
          {
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, 3, true);
            } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.t)) {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.g();
            } else {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, 3, true);
            }
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
            if ((localObject1 != null) && (!"".equals(localObject1)))
            {
              paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject2);
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, (String)localObject1, (String)localObject4, (String)localObject2, paramString, false);
            }
          }
          else
          {
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, 4, true);
            } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.u)) {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.h();
            } else {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(str3, 4, true);
            }
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
          }
          if (paramInt == 9) {
            ReportCenter.a().a("", "", "", "1000", "103", "0", false);
          } else if (paramInt == 10) {
            ReportCenter.a().a("", "", "", "1000", "104", "0", false);
          }
        }
      }
    }
    label3129:
    a(paramInt);
  }
  
  public void a(long paramLong) {}
  
  public void a(Share paramShare)
  {
    if (paramShare == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      localObject = this.jdField_e_of_type_JavaLangString;
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareButtonEvent((String)localObject);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = paramShare;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessShareMenuHandler$UIParam.jdField_a_of_type_Long;
      a();
      c();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(BaseApplicationImpl.getApplication().getString(2131719029));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(this);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
      }
      catch (Exception paramShare)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("actionSheet.show exception=");
          ((StringBuilder)localObject).append(paramShare);
          QLog.d("SwiftBrowserShareMenuHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessShareMenuHandler$UIParam = new ConfessShareMenuHandler.UIParam();
    paramString = Uri.parse(paramString);
    if (paramString.isHierarchical())
    {
      String str = paramString.getQueryParameter("_wv");
      StringBuilder localStringBuilder2;
      if (str != null) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessShareMenuHandler$UIParam.jdField_a_of_type_Long = Long.parseLong(str, 10);
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("parser _wv param(");
          localStringBuilder2.append(str);
          localStringBuilder2.append(") error:");
          localStringBuilder2.append(localNumberFormatException1.getMessage());
          QLog.e("SwiftBrowserShareMenuHandler", 1, localStringBuilder2.toString());
        }
      }
      str = paramString.getQueryParameter("_fv");
      if (str != null) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessShareMenuHandler$UIParam.jdField_b_of_type_Long = Long.parseLong(str, 10);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("parser _fv param(");
          localStringBuilder2.append(str);
          localStringBuilder2.append(") error:");
          localStringBuilder2.append(localNumberFormatException2.getMessage());
          QLog.e("SwiftBrowserShareMenuHandler", 1, localStringBuilder2.toString());
        }
      }
      str = paramString.getQueryParameter("_wwv");
      if (str != null) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessShareMenuHandler$UIParam.c = Long.parseLong(str, 10);
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("parser _wwv param(");
          localStringBuilder2.append(str);
          localStringBuilder2.append(") error:");
          localStringBuilder2.append(localNumberFormatException3.getMessage());
          QLog.e("SwiftBrowserShareMenuHandler", 1, localStringBuilder2.toString());
        }
      }
      paramString = paramString.getQueryParameter("_cwv");
      if (paramString != null) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessShareMenuHandler$UIParam.d = Long.parseLong(paramString, 10);
          return;
        }
        catch (NumberFormatException paramString)
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("parser _cwv param(");
          localStringBuilder1.append(str);
          localStringBuilder1.append(") error:");
          localStringBuilder1.append(paramString.getMessage());
          QLog.e("SwiftBrowserShareMenuHandler", 1, localStringBuilder1.toString());
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = paramString3;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, paramString2, this.jdField_c_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, 1, false);
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.q)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e();
    } else {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, 1, false);
    }
    ReportCenter.a().a("", "", "", "1000", "101", "0", false);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
  }
  
  public boolean a(String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentBizWebviewpluginShare.getShareUrl();
    boolean bool3 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (str.equals(Util.a(paramString, new String[0]))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localObject1 = null;
    }
    IPublicAccountH5AbilityPlugin localIPublicAccountH5AbilityPlugin = (IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696399);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839067;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 2;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696413);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839068;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 3;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isOSVersionSupportReadInJoy()) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:kandian")) && (localObject1 != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("readinjoy_");
      ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getAccount());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
      if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false)))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696414);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839066;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 13;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696420);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839071;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 9;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696402);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839065;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 10;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((this.g) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696417);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839070;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 12;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696395);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842741;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 5;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696396);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842737;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 4;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((0x10 & this.jdField_a_of_type_Long) == 0L)) {
      QidianManager.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696411);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130844486;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 20;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    localObject2 = new ArrayList();
    Object localObject3;
    Object localObject4;
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    int i;
    if (this.jdField_e_of_type_Boolean)
    {
      localObject3 = this.jdField_b_of_type_JavaUtilArrayList;
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject3).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          i = ((IPublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_Int;
          if (i != 1)
          {
            if (i == 2)
            {
              localObject4 = new ShareActionSheetBuilder.ActionSheetItem();
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).label = BaseApplicationImpl.getApplication().getString(2131695251);
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).icon = 2130842735;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).iconNeedBg = true;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).action = 31;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).argus = "";
              ((ArrayList)localObject2).add(localObject4);
            }
          }
          else
          {
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_JavaLangString)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695194);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_JavaLangString;
            }
            localActionSheetItem.icon = 2130842743;
            localActionSheetItem.iconNeedBg = true;
            localActionSheetItem.action = 30;
            localActionSheetItem.argus = "";
            ((ArrayList)localObject2).add(localActionSheetItem);
          }
        }
      }
    }
    if (this.jdField_f_of_type_Boolean)
    {
      localObject3 = this.jdField_b_of_type_JavaUtilArrayList;
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject3).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          i = ((IPublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_Int;
          if (i != 1)
          {
            if (i == 3)
            {
              localObject4 = new ShareActionSheetBuilder.ActionSheetItem();
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).label = BaseApplicationImpl.getApplication().getString(2131696400);
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).icon = 2130842744;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).iconNeedBg = true;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).action = 35;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).argus = "";
              ((ArrayList)localObject2).add(localObject4);
            }
          }
          else
          {
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_JavaLangString)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695194);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_JavaLangString;
            }
            localActionSheetItem.icon = 2130842743;
            localActionSheetItem.iconNeedBg = true;
            localActionSheetItem.action = 37;
            localActionSheetItem.argus = "";
            ((ArrayList)localObject2).add(localActionSheetItem);
          }
        }
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696385);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130844237;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 6;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696394);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842739;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 7;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696391);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839063;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 1;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle")) && (this.jdField_b_of_type_Boolean))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696397);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842727;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 11;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    return (List[])new ArrayList[] { localArrayList, localObject2 };
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131559104, null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject, -1, -2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131367100);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131702603), TypedValue.applyDimension(1, 15.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131702607), TypedValue.applyDimension(1, 16.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131702606), TypedValue.applyDimension(1, 18.0F, FontSettingManager.systemMetrics)));
    ((RangeButtonView)localObject).setTitleData(localArrayList);
    ((RangeButtonView)localObject).setOnChangerListener(this);
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_b_of_type_Int);
    localArrayList = new ArrayList();
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691120));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691121));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691122));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691123));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691124));
    ((RangeButtonView)localObject).setContentDescList(localArrayList);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentSmttSdkWebView, 83, 0, 0);
  }
  
  @TargetApi(14)
  public void b(int paramInt)
  {
    WebView localWebView = this.jdField_a_of_type_ComTencentSmttSdkWebView;
    if (localWebView != null)
    {
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      this.jdField_b_of_type_Int = paramInt;
      paramInt = jdField_a_of_type_ArrayOfInt[paramInt];
      localWebView.getSettings().setTextZoom(paramInt);
    }
  }
  
  public void onChange(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    b(paramInt2);
    a().a(this.jdField_b_of_type_Int);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemClick, tag = ");
      boolean bool;
      if (localObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("SwiftBrowserShareMenuHandler", 2, localStringBuilder.toString());
    }
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      a(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a.action, a(), new Bundle());
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */