package com.tencent.mobileqq.activity.aio.confess;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
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
import com.tencent.mobileqq.qroute.route.URIRequest;
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
  public static final int[] a = { 95, 100, 107, 115, 127 };
  public static long s = -1L;
  private boolean A = false;
  private WebView B;
  private ConfessShareMenuHandler.UIParam C;
  public Activity b;
  public Share c;
  public boolean d;
  public ShareActionSheetBuilder e;
  public final ArrayList<String> f = new ArrayList();
  public long g = 4L;
  public boolean h = false;
  public boolean i = false;
  public int j = 0;
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public PopupWindow o = null;
  TroopMemberApiClient p = null;
  boolean q = false;
  public int r = 1;
  public boolean t = false;
  public boolean u = false;
  public ArrayList<IPublicAccountJavascriptInterface.ActionItem> v = null;
  private String w;
  private String x = "";
  private int y;
  private boolean z = false;
  
  public ConfessShareMenuHandler(Activity paramActivity, WebView paramWebView)
  {
    this.b = paramActivity;
    this.B = paramWebView;
    a();
  }
  
  private void f()
  {
    if (b(this.c.getShareUrl()))
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
      int i2 = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int i1 = i2;
      if (i2 < 0) {
        i1 = 190;
      }
      String str = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", new Object[] { Integer.valueOf(i1), Integer.valueOf(i1) });
      WebView localWebView = this.B;
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
  
  public void a()
  {
    Object localObject = this.b.getIntent();
    this.w = ((Intent)localObject).getStringExtra("url");
    if (this.w == null)
    {
      this.w = ((Intent)localObject).getStringExtra("key_params_qq");
      if (this.w == null) {
        this.w = "";
      }
    }
    localObject = this.w;
    this.x = ((String)localObject);
    a((String)localObject);
  }
  
  public void a(int paramInt)
  {
    String str2 = c();
    if (str2 == null) {
      str2 = this.w;
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
    int i1;
    int i2;
    Object localObject5;
    if (paramBundle != null)
    {
      localObject3 = paramBundle.getString("qq", "");
      str1 = paramBundle.getString("public_uin", "");
      localObject1 = paramBundle.getString("source_public_uin", "");
      localObject2 = paramBundle.getString("default_url", "");
      localObject4 = paramBundle.getString("msg_id", "");
      i1 = paramBundle.getInt("troop_app_id", 0);
      i2 = paramBundle.getInt("troop_id", 0);
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
      i1 = 0;
      i2 = 0;
      localObject5 = localObject3;
      localObject3 = str2;
    }
    String str2 = this.w;
    if (!TextUtils.isEmpty(null)) {
      throw new NullPointerException();
    }
    String str3 = paramString;
    boolean bool;
    if (paramInt == 1)
    {
      ((ClipboardManager)this.b.getSystemService("clipboard")).setText(str3);
      QRUtils.a(2, 2131888247);
      if ((this.A) && (!TextUtils.isEmpty(this.c.S))) {
        this.c.o();
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
    paramBundle = new Intent(this.b, QQBrowserActivity.class);
    paramBundle.putExtra("url", paramString);
    paramBundle.putExtra("hide_more_button", true);
    this.b.startActivity(paramBundle);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
    if ((localObject1 != null) && (!"".equals(localObject1)))
    {
      paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, (String)localObject1, (String)localObject4, (String)localObject2, paramString, false);
      break label3129;
      if (paramInt == 2)
      {
        if ((!TextUtils.isEmpty(this.B.getUrl())) && (!TextUtils.isEmpty(this.x)) && (!TextUtils.isEmpty(this.x))) {
          if (TextUtils.isEmpty(str2))
          {
            if (str3.equals(this.x))
            {
              bool = true;
              break label749;
            }
          }
          else if (!TextUtils.isEmpty(null))
          {
            paramString = this.x;
            throw new NullPointerException();
          }
        }
        bool = false;
        label749:
        this.c.ae = bool;
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
      this.b.startActivity(paramString);
    }
    catch (ActivityNotFoundException paramString)
    {
      label811:
      long l1;
      long l2;
      break label811;
    }
    QRUtils.a(1, 2131892956);
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
          s = System.currentTimeMillis();
          paramString = str2;
          if (TextUtils.isEmpty(str2)) {
            paramString = null;
          }
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1002, paramString, this.y);
          if (!TextUtils.isEmpty(this.c.S)) {
            this.c.b(str3, 2, false);
          } else if (!TextUtils.isEmpty(this.c.W)) {
            this.c.r();
          } else {
            this.c.c();
          }
          ReportCenter.a().a("", "", "", "1000", "102", "0", false);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
        }
        else if (paramInt == 6)
        {
          if (this.c.setShareUrl(str3)) {
            this.c.a(str3, 9, false);
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
            this.c.a(str3, 5, true);
          }
          else if (paramInt == 16)
          {
            paramString = new Intent(this.b, QQBrowserActivity.class);
            paramString.putExtra("url", (String)localObject5);
            paramString.putExtra("hide_operation_bar", true);
            paramString.putExtra("hide_more_button", true);
            this.b.startActivity(paramString);
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(i2);
            paramBundle = paramString.toString();
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(i1);
            ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, paramBundle, paramString.toString(), "", "");
          }
          else if (paramInt == 17)
          {
            if (paramBundle != null) {
              paramString = paramBundle.getString("troop_app_share_url", "");
            } else {
              paramString = "";
            }
            paramBundle = new Intent(this.b, QQBrowserActivity.class);
            paramBundle.putExtra("url", paramString);
            paramBundle.putExtra("hide_operation_bar", true);
            paramBundle.putExtra("hide_more_button", true);
            this.b.startActivity(paramBundle);
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(i2);
            paramBundle = paramString.toString();
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(i1);
            ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, paramBundle, paramString.toString(), "", "");
          }
          else if (paramInt == 7)
          {
            d();
          }
          else if ((paramInt != 19) && (paramInt != 20))
          {
            if (paramInt == 12)
            {
              if (!TextUtils.isEmpty(this.c.S)) {
                this.c.b(str3, 8, false);
              } else {
                this.c.a(str3, 8, false);
              }
              paramBundle = this.w;
              paramString = this.B;
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
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1005, paramBundle, this.y);
            }
            else if (paramInt == 34)
            {
              if (!TextUtils.isEmpty(this.c.S)) {
                this.c.n();
              } else if (QLog.isColorLevel()) {
                QLog.d("diandian", 2, "dian dian is here");
              }
            }
            else
            {
              l1 = 0L;
              if (paramInt == 35)
              {
                paramString = this.v;
                if (paramString != null)
                {
                  paramString = paramString.iterator();
                  while (paramString.hasNext())
                  {
                    paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                    if (paramBundle.a == 3) {
                      try
                      {
                        paramString = new JSONObject(paramBundle.c);
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
                localObject2 = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
                paramBundle = this.b;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(l1);
                ((StringBuilder)localObject1).append("");
                paramString = ((IAddFriendApi)localObject2).startAddFriend(paramBundle, 1, ((StringBuilder)localObject1).toString(), null, 3001, 3999, paramString, null, null, null, null);
                ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.b, paramString);
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
              }
              else if (paramInt == 30)
              {
                paramString = this.v;
                l2 = l1;
                if (paramString != null)
                {
                  l2 = l1;
                  if (this.t)
                  {
                    paramString = paramString.iterator();
                    do
                    {
                      l2 = l1;
                      if (!paramString.hasNext()) {
                        break;
                      }
                      paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                    } while (paramBundle.a != 1);
                    try
                    {
                      l2 = new JSONObject(paramBundle.c).getLong("uin");
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
                paramString.setComponent(new ComponentName(this.b, ChatActivity.class));
                paramBundle.putString("uin", String.valueOf(l2));
                paramBundle.putInt("uintype", 1008);
                paramString.putExtras(paramBundle);
                paramString.putExtra("is_come_from_readinjoy", true);
                paramString.setFlags(67108864);
                this.b.startActivity(paramString);
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
              }
              else
              {
                if ((paramInt == 37) && (this.u))
                {
                  paramString = this.v;
                  l2 = l1;
                  if (paramString != null)
                  {
                    paramString = paramString.iterator();
                    do
                    {
                      l2 = l1;
                      if (!paramString.hasNext()) {
                        break;
                      }
                      paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                    } while (paramBundle.a != 1);
                    try
                    {
                      l2 = new JSONObject(paramBundle.c).getLong("uin");
                    }
                    catch (JSONException paramString)
                    {
                      paramString.printStackTrace();
                      return;
                    }
                  }
                  paramString = AIOUtils.a(new Intent(this.b, SplashActivity.class), null);
                  paramBundle = new StringBuilder();
                  paramBundle.append(l2);
                  paramBundle.append("");
                  paramString.putExtra("uin", paramBundle.toString());
                  paramString.putExtra("uintype", 0);
                  this.b.startActivity(paramString);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
                  return;
                }
                if (paramInt == 31)
                {
                  paramString = this.v;
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
                    } while (paramString.a != 2);
                    try
                    {
                      l2 = new JSONObject(paramString.c).getLong("puin");
                    }
                    catch (JSONException paramString)
                    {
                      paramString.printStackTrace();
                      return;
                    }
                  }
                  localObject1 = new ActivityURIRequest(this.b, "/pubaccount/detail");
                  paramString = ((ActivityURIRequest)localObject1).extra();
                  paramBundle = new StringBuilder();
                  paramBundle.append(l2);
                  paramBundle.append("");
                  paramString.putString("uin", paramBundle.toString());
                  ((ActivityURIRequest)localObject1).extra().putBoolean("from_js", true);
                  QRoute.startUri((URIRequest)localObject1, null);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
                }
                else if (paramInt == 38)
                {
                  this.c.p();
                }
              }
            }
          }
          else
          {
            if (paramInt == 19) {
              i1 = 6;
            } else {
              i1 = 7;
            }
            if (!TextUtils.isEmpty(this.c.S)) {
              this.c.b(str3, i1, false);
            } else {
              this.c.a(str3, i1, true);
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
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, str2, this.y);
          } else {
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, str2, this.y);
          }
          if (!WXShareHelper.a().b()) {
            i1 = 2131918154;
          } else if (!WXShareHelper.a().c()) {
            i1 = 2131918155;
          } else {
            i1 = -1;
          }
          if (i1 != -1)
          {
            QRUtils.a(0, i1);
          }
          else if (paramInt == 9)
          {
            if (!TextUtils.isEmpty(this.c.S)) {
              this.c.b(str3, 3, true);
            } else if (!TextUtils.isEmpty(this.c.X)) {
              this.c.s();
            } else {
              this.c.a(str3, 3, true);
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
            if (!TextUtils.isEmpty(this.c.S)) {
              this.c.b(str3, 4, true);
            } else if (!TextUtils.isEmpty(this.c.Y)) {
              this.c.t();
            } else {
              this.c.a(str3, 4, true);
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
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      localObject = this.w;
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareButtonEvent((String)localObject);
      this.c = paramShare;
      this.g = this.C.a;
      a();
      f();
      if (this.e == null) {
        this.e = new ShareActionSheetBuilder(this.b);
      }
      this.e.setActionSheetTitle(BaseApplicationImpl.getApplication().getString(2131916565));
      this.e.setActionSheetItems(b());
      this.e.setItemClickListener(this);
      this.e.setOnDismissListener(this);
      try
      {
        this.e.show();
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
    this.C = new ConfessShareMenuHandler.UIParam();
    paramString = Uri.parse(paramString);
    if (paramString.isHierarchical())
    {
      String str = paramString.getQueryParameter("_wv");
      StringBuilder localStringBuilder2;
      if (str != null) {
        try
        {
          this.C.a = Long.parseLong(str, 10);
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
          this.C.b = Long.parseLong(str, 10);
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
          this.C.c = Long.parseLong(str, 10);
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
          this.C.d = Long.parseLong(paramString, 10);
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
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, paramString2, this.y);
    if (!TextUtils.isEmpty(this.c.S)) {
      this.c.b(paramString1, 1, false);
    } else if (!TextUtils.isEmpty(this.c.U)) {
      this.c.q();
    } else {
      this.c.a(paramString1, 1, false);
    }
    ReportCenter.a().a("", "", "", "1000", "101", "0", false);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
  }
  
  @TargetApi(14)
  public void b(int paramInt)
  {
    WebView localWebView = this.B;
    if (localWebView != null)
    {
      if (this.q) {
        return;
      }
      this.r = paramInt;
      paramInt = a[paramInt];
      localWebView.getSettings().setTextZoom(paramInt);
    }
  }
  
  public boolean b(String paramString)
  {
    String str = this.c.getShareUrl();
    boolean bool3 = TextUtils.isEmpty(this.c.d());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.c.e()))
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
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localObject1 = null;
    }
    IPublicAccountH5AbilityPlugin localIPublicAccountH5AbilityPlugin = (IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:share:qq")) && ((this.g & 0x8) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894171);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839221;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 2;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:share:QZone")) && ((this.g & 0x10) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894185);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839222;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 3;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if (((this.g & 0x8000000) != 0L) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isOSVersionSupportReadInJoy()) && (!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:share:kandian")) && (localObject1 != null))
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
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894186);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839220;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 13;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:share:appMessage")) && ((this.g & 0x4000) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894192);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839225;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 9;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:share:timeline")) && ((this.g & 0x8000) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894174);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839219;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 10;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((this.z) && (!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:share:sinaWeibo")))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894189);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839224;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 12;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:openWithQQBrowser")) && ((this.g & 0x200) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894167);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130843694;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 5;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:openWithSafari")) && ((this.g & 0x100) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894168);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130843690;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 4;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:share:qiDian")) && ((0x10 & this.g) == 0L)) {
      QidianManager.a(this.b, localArrayList);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:share:qiYeQQ")) && ((this.g & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894183);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130845859;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 20;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
      localArrayList.add(localObject2);
    }
    localObject2 = new ArrayList();
    Object localObject3;
    Object localObject4;
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    int i1;
    if (this.t)
    {
      localObject3 = this.v;
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject3).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          i1 = ((IPublicAccountJavascriptInterface.ActionItem)localObject4).a;
          if (i1 != 1)
          {
            if (i1 == 2)
            {
              localObject4 = new ShareActionSheetBuilder.ActionSheetItem();
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).label = BaseApplicationImpl.getApplication().getString(2131892985);
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).icon = 2130843688;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).iconNeedBg = true;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).action = 31;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).argus = "";
              ((ArrayList)localObject2).add(localObject4);
            }
          }
          else
          {
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject4).b)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131892927);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject4).b;
            }
            localActionSheetItem.icon = 2130843696;
            localActionSheetItem.iconNeedBg = true;
            localActionSheetItem.action = 30;
            localActionSheetItem.argus = "";
            ((ArrayList)localObject2).add(localActionSheetItem);
          }
        }
      }
    }
    if (this.u)
    {
      localObject3 = this.v;
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject3).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          i1 = ((IPublicAccountJavascriptInterface.ActionItem)localObject4).a;
          if (i1 != 1)
          {
            if (i1 == 3)
            {
              localObject4 = new ShareActionSheetBuilder.ActionSheetItem();
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).label = BaseApplicationImpl.getApplication().getString(2131894172);
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).icon = 2130843697;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).iconNeedBg = true;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).action = 35;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject4).argus = "";
              ((ArrayList)localObject2).add(localObject4);
            }
          }
          else
          {
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject4).b)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131892927);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject4).b;
            }
            localActionSheetItem.icon = 2130843696;
            localActionSheetItem.iconNeedBg = true;
            localActionSheetItem.action = 37;
            localActionSheetItem.argus = "";
            ((ArrayList)localObject2).add(localActionSheetItem);
          }
        }
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:favorite")) && ((this.g & 0x2000) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894157);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130845554;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 6;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:setFont")) && (!this.i) && (this.d))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894166);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843692;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 7;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:copyUrl")) && ((this.g & 0x20) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894163);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839217;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 1;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.f, "menuItem:exposeArticle")) && (this.h))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894169);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843680;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 11;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    return (List[])new ArrayList[] { localArrayList, localObject2 };
  }
  
  public String c()
  {
    Share localShare = this.c;
    if (localShare == null) {
      return "";
    }
    return localShare.getShareUrl();
  }
  
  public void d()
  {
    Object localObject = this.b.getLayoutInflater().inflate(2131624765, null);
    this.o = new PopupWindow((View)localObject, -1, -2);
    this.o.setBackgroundDrawable(new BitmapDrawable());
    this.o.setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131433554);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131900596), TypedValue.applyDimension(1, 15.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131900600), TypedValue.applyDimension(1, 16.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131900599), TypedValue.applyDimension(1, 18.0F, FontSettingManager.systemMetrics)));
    ((RangeButtonView)localObject).setTitleData(localArrayList);
    ((RangeButtonView)localObject).setOnChangerListener(this);
    ((RangeButtonView)localObject).setThumbPosition(this.r);
    localArrayList = new ArrayList();
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131888066));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131888067));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131888068));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131888069));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131888070));
    ((RangeButtonView)localObject).setContentDescList(localArrayList);
    this.o.showAtLocation(this.B, 83, 0, 0);
  }
  
  public TroopMemberApiClient e()
  {
    if (this.p == null)
    {
      this.p = TroopMemberApiClient.a();
      this.p.e();
    }
    return this.p;
  }
  
  public void onChange(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    b(paramInt2);
    e().b(this.r);
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
      this.e.dismiss();
      a(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).c.action, c(), new Bundle());
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */