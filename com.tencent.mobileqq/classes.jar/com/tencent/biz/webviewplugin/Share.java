package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.tencent.av.utils.UITools;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.kandian.biz.account.api.IFastModule;
import com.tencent.mobileqq.kandian.biz.atlas.favorite.api.IReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInJoyShareManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.open.agent.report.ReportDef.ShareStructMsg.Report9x;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.stat.MttLoader.BrowserInfo;
import cooperation.plugin.PluginBaseActivity;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class Share
  implements View.OnClickListener, WebUiUtils.WebShareInterface, ReportDef
{
  static String jdField_a_of_type_JavaLangString = "share";
  public static boolean f = false;
  protected float a;
  protected int a;
  protected long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  protected Context a;
  protected Handler a;
  protected View a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  public CustomWebView a;
  public APICallback a;
  public SharePolicyInfo a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  ReportDef.ShareStructMsg.Report9x jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x;
  protected OpensdkBusinessObserver a;
  protected GetAppInfoProto.GetAppinfoResponse a;
  protected SoftReference<Bitmap> a;
  WeakReference<WebUiBaseInterface> jdField_a_of_type_JavaLangRefWeakReference;
  protected AppRuntime a;
  protected boolean a;
  int jdField_b_of_type_Int;
  Activity jdField_b_of_type_AndroidAppActivity;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  protected String b;
  private WeakReference<WebUiUtils.WebTitleBarInterface> jdField_b_of_type_JavaLangRefWeakReference;
  protected boolean b;
  protected int c;
  protected ImageView c;
  protected String c;
  protected boolean c;
  protected int d;
  protected String d;
  protected boolean d;
  volatile int jdField_e_of_type_Int;
  protected String e;
  boolean jdField_e_of_type_Boolean;
  protected String f;
  protected String g;
  public boolean g;
  protected String h = null;
  protected String i = null;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  protected String w;
  protected String x;
  
  public Share(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    boolean bool2 = true;
    boolean bool1 = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
    this.j = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x = new ReportDef.ShareStructMsg.Report9x();
    this.k = null;
    this.l = null;
    this.m = null;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    this.jdField_b_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = null;
    this.p = null;
    this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = null;
    this.q = null;
    this.r = null;
    this.s = null;
    this.t = null;
    this.u = null;
    this.v = null;
    this.w = "";
    this.x = "";
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentOpenAppcommonOpensdkBusinessObserver = new Share.7(this);
    this.jdField_a_of_type_AndroidOsHandler = new Share.8(this);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Share secret init share");
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.n = paramAppRuntime.getAccount();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Float = paramActivity.getResources().getDisplayMetrics().density;
    Object localObject;
    StringBuilder localStringBuilder;
    if ((paramActivity instanceof WebUiBaseInterface))
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((WebUiBaseInterface)paramActivity);
    }
    else if ((paramActivity instanceof SwiftWebViewFragmentSupporter))
    {
      paramAppRuntime = ((SwiftWebViewFragmentSupporter)paramActivity).getCurrentWebViewFragment();
      if (paramAppRuntime != null)
      {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
      }
      else if ((paramActivity instanceof QQBrowserActivity))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "Caution! mWebUiUtils == null! maybe webviewfragment is invisible!");
        localObject = (QQBrowserActivity)paramActivity;
        paramAppRuntime = ((QQBrowserActivity)localObject).getSupportFragmentManager();
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.getFragments();
          if ((paramAppRuntime != null) && (paramAppRuntime.size() > 0))
          {
            int i1 = ((QQBrowserActivity)localObject).currentTabIndex;
            if ((i1 < 0) || (i1 >= paramAppRuntime.size())) {
              i1 = 0;
            }
            localObject = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("cast Fragment (index: ");
            localStringBuilder.append(i1);
            localStringBuilder.append(") to WebViewFragment");
            QLog.w((String)localObject, 2, localStringBuilder.toString());
            if ((paramAppRuntime.get(i1) instanceof WebViewFragment))
            {
              this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((WebViewFragment)paramAppRuntime.get(i1));
            }
            else
            {
              paramAppRuntime = jdField_a_of_type_JavaLangString;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("cast Fragment (index: ");
              ((StringBuilder)localObject).append(i1);
              ((StringBuilder)localObject).append(") is null!");
              QLog.e(paramAppRuntime, 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
    paramAppRuntime = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error! mWebUiUtils still null! ");
      ((StringBuilder)localObject).append(paramActivity.toString());
      QLog.e(paramAppRuntime, 2, ((StringBuilder)localObject).toString());
      return;
    }
    paramAppRuntime = (WebUiBaseInterface)paramAppRuntime.get();
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof WebUiUtils.WebUiMethodInterface)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((WebUiUtils.WebUiMethodInterface)paramAppRuntime).getWebView();
      if (QLog.isColorLevel())
      {
        paramAppRuntime = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" Share secret webview is null?");
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          bool1 = false;
        }
        ((StringBuilder)localObject).append(bool1);
        QLog.d(paramAppRuntime, 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" Share secret baseInterface is null?");
      if (paramAppRuntime == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
    a();
  }
  
  private SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter a(String paramString, int paramInt)
  {
    boolean bool = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isWxArticle(paramString);
    paramString = null;
    if ((bool) && (paramInt == 9)) {
      return null;
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)) {
      return (SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)localActivity;
    }
    if ((localActivity instanceof SwiftWebViewFragmentSupporter)) {
      paramString = ((SwiftWebViewFragmentSupporter)localActivity).getCurrentWebViewFragment();
    }
    return paramString;
  }
  
  public static final String a(PBRepeatMessageField<GetAppInfoProto.MsgIconsurl> paramPBRepeatMessageField, int paramInt)
  {
    paramPBRepeatMessageField = a(paramPBRepeatMessageField);
    if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty())) {
      return a(paramPBRepeatMessageField, paramInt);
    }
    return null;
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    if (b(paramString1)) {
      return paramString1;
    }
    if (b(paramString2)) {
      return paramString2;
    }
    if (b(paramString3)) {
      return paramString3;
    }
    return paramString1;
  }
  
  public static final String a(List<Share.IconUrlSize> paramList, int paramInt)
  {
    Share.IconUrlSize localIconUrlSize1 = null;
    Object localObject2 = null;
    Object localObject1 = localIconUrlSize1;
    if (paramList != null)
    {
      localObject1 = localIconUrlSize1;
      if (!paramList.isEmpty())
      {
        int i2 = paramList.size();
        int i1 = 0;
        localObject1 = localObject2;
        for (;;)
        {
          localObject2 = localObject1;
          if (i1 >= i2) {
            break;
          }
          localIconUrlSize1 = (Share.IconUrlSize)paramList.get(i1);
          try
          {
            int i3 = Integer.valueOf(localIconUrlSize1.b.get()).intValue();
            localObject2 = localObject1;
            if (i3 >= paramInt)
            {
              localObject1 = localIconUrlSize1.a.get();
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject2 = localObject1;
              }
            }
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d(jdField_a_of_type_JavaLangString, 2, localNumberFormatException1.getMessage());
              localObject2 = localObject1;
            }
            i1 += 1;
            localObject1 = localObject2;
          }
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          i1 = i2 - 1;
          for (;;)
          {
            localObject1 = localObject2;
            if (i1 < 0) {
              break;
            }
            Share.IconUrlSize localIconUrlSize2 = (Share.IconUrlSize)paramList.get(i1);
            try
            {
              i2 = Integer.valueOf(localIconUrlSize2.b.get()).intValue();
              localObject1 = localObject2;
              if (i2 < paramInt)
              {
                localObject2 = localIconUrlSize2.a.get();
                localObject1 = localObject2;
                if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                  localObject1 = localObject2;
                }
              }
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.d(jdField_a_of_type_JavaLangString, 2, localNumberFormatException2.getMessage());
                localObject1 = localObject2;
              }
              i1 -= 1;
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QQBrowserActivity findAppIcon() iconUrl = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d(paramList, 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private HashMap<String, String> a(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = Uri.parse(paramString);
        Iterator localIterator = paramString.getQueryParameterNames().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = paramString.getQueryParameter(str1);
            if (!TextUtils.isEmpty(str2)) {
              localHashMap.put(str1, str2);
            }
          }
        }
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      ArkAppCenter.a(jdField_a_of_type_JavaLangString, String.format("getArkInfo, parse param failed, err=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  public static List<Share.IconUrlSize> a(PBRepeatMessageField<GetAppInfoProto.MsgIconsurl> paramPBRepeatMessageField)
  {
    if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty()))
    {
      Object localObject = paramPBRepeatMessageField.get();
      paramPBRepeatMessageField = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GetAppInfoProto.MsgIconsurl localMsgIconsurl = (GetAppInfoProto.MsgIconsurl)((Iterator)localObject).next();
        paramPBRepeatMessageField.add(new Share.IconUrlSize(localMsgIconsurl.url, localMsgIconsurl.size));
      }
      return paramPBRepeatMessageField;
    }
    return new ArrayList();
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    Object localObject1 = paramString1;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onGetSummary. forWhat = ");
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append(", title=");
      ((StringBuilder)localObject3).append(this.jdField_e_of_type_JavaLangString);
      ((StringBuilder)localObject3).append(", desc=");
      ((StringBuilder)localObject3).append(this.h);
      ((StringBuilder)localObject3).append(", thumb=");
      ((StringBuilder)localObject3).append(this.i);
      ((StringBuilder)localObject3).append(", bitmap=");
      ((StringBuilder)localObject3).append(paramBitmap);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    if (this.jdField_b_of_type_AndroidAppActivity == null) {
      if (this.jdField_a_of_type_AndroidAppActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.jdField_b_of_type_AndroidAppActivity = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      } else {
        this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
      }
    }
    int i3 = 0;
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != 3) && (paramInt != 4)) {
      break label471;
    }
    Object localObject3 = new Bundle();
    if (TextUtils.isEmpty(paramString4)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      localObject2 = this.jdField_c_of_type_JavaLangString;
      paramString2 = (String)localObject2;
      i1 = i2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        i1 = i2 | 0x2;
        paramString2 = (String)localObject2;
      }
    }
    else
    {
      i1 = i2;
    }
    int i2 = i1;
    if (TextUtils.isEmpty(paramString1)) {
      i2 = i1 | 0x4;
    }
    ((Bundle)localObject3).putString("report_type", "102");
    ((Bundle)localObject3).putString("act_type", "94");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    if (i2 == 0) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    ((StringBuilder)localObject2).append(i1);
    ((Bundle)localObject3).putString("intext_1", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(ReportDef.RepUtil.b(paramInt));
    ((Bundle)localObject3).putString("intext_3", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(i2);
    ((Bundle)localObject3).putString("intext_2", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject3).putString("stringext_1", paramString3);
    ReportCenter.a().a((Bundle)localObject3, "", this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
    label471:
    Intent localIntent;
    label871:
    Object localObject4;
    boolean bool1;
    boolean bool2;
    if (paramInt == 2)
    {
      paramBitmap = new Bundle();
      if (TextUtils.isEmpty(paramString1)) {
        localObject1 = paramString3;
      }
      paramBitmap.putString("title", (String)localObject1);
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString3;
      } else {
        paramString1 = paramString2;
      }
      paramBitmap.putString("desc", paramString1);
      paramBitmap.putString("detail_url", paramString3);
      paramString1 = new ArrayList(1);
      paramString1.add(paramString4);
      paramBitmap.putStringArrayList("image_url", paramString1);
      paramBitmap.putLong("req_share_id", 0L);
      paramInt = this.jdField_d_of_type_Int;
      if (paramInt != -1) {
        paramBitmap.putInt("iUrlInfoFrm", paramInt);
      }
      paramBitmap.putLong("share_begin_time", SwiftBrowserShareMenuHandler.jdField_b_of_type_Long);
      paramString1 = this.jdField_a_of_type_AndroidAppActivity;
      paramInt = i3;
      if ((paramString1 instanceof SwiftWebViewFragmentSupporter))
      {
        paramString1 = ((SwiftWebViewFragmentSupporter)paramString1).getCurrentWebViewFragment();
        if (paramString1 != null)
        {
          paramString2 = (SwiftBrowserShareMenuHandler)paramString1.getComponentProvider().a(4);
          paramBitmap.putString("strurt_msgid", paramString2.jdField_b_of_type_JavaLangString);
          paramBitmap.putString("struct_uin", paramString2.jdField_a_of_type_JavaLangString);
          paramBitmap.putString("struct_url", paramString1.getUrl());
          paramBitmap.putBoolean("from_web", true);
          paramInt = i3;
          if (paramString2.jdField_c_of_type_JavaLangString != null)
          {
            paramInt = i3;
            if (!"".equals(paramString2.jdField_c_of_type_JavaLangString))
            {
              paramBitmap.putString("source_puin", paramString2.jdField_c_of_type_JavaLangString);
              paramInt = i3;
            }
          }
        }
        else
        {
          paramInt = 1;
        }
      }
      if ((paramInt != 0) || (!QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), this.jdField_b_of_type_AndroidAppActivity, paramBitmap, null, -1))) {
        QRUtils.a(1, 2131689486);
      }
    }
    else if (paramInt == 1)
    {
      localIntent = new Intent(this.jdField_b_of_type_AndroidAppActivity, ForwardRecentActivity.class);
      paramBitmap = this.jdField_a_of_type_AndroidAppActivity;
      if ((paramBitmap instanceof SwiftWebViewFragmentSupporter))
      {
        paramBitmap = ((SwiftWebViewFragmentSupporter)paramBitmap).getCurrentWebViewFragment();
        if ((paramBitmap != null) && (paramBitmap.getComponentProvider() != null))
        {
          localObject2 = (SwiftBrowserShareMenuHandler)paramBitmap.getComponentProvider().a(4);
          if (localObject2 != null)
          {
            paramBitmap = ((SwiftBrowserShareMenuHandler)localObject2).a();
            localObject2 = ((SwiftBrowserShareMenuHandler)localObject2).h;
            break label871;
          }
        }
        paramBitmap = null;
        localObject2 = "";
        localIntent.putExtra("forward_source_business_type", 100500);
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = "";
        }
        localIntent.putExtra("forward_source_sub_business_type", (String)localObject3);
      }
      else
      {
        paramBitmap = null;
      }
      if ((paramBitmap != null) && (!paramBitmap.isEmpty()))
      {
        localObject3 = paramBitmap.getString("to_qq");
        i1 = paramBitmap.getInt("to_uin_type");
        localObject2 = localObject3;
        paramInt = i1;
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("onGetSummary() called : toUin = ");
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append(", uinType = ");
          ((StringBuilder)localObject4).append(i1);
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject4).toString());
          localObject2 = localObject3;
          paramInt = i1;
        }
      }
      else
      {
        localObject2 = "";
        paramInt = 0;
      }
      if ((localObject2 != null) && (((String)localObject2).length() >= 5))
      {
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
        localIntent.putExtra("toUin", (String)localObject2);
        localIntent.putExtra("uinType", paramInt);
        if ((paramBitmap != null) && (!paramBitmap.isEmpty()))
        {
          paramBitmap = paramBitmap.getString("to_uin_name");
          if (QLog.isColorLevel())
          {
            localObject2 = jdField_a_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onGetSummary() called : nickName = ");
            ((StringBuilder)localObject3).append(paramBitmap);
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
          localIntent.putExtra("nickName", paramBitmap);
        }
      }
      else
      {
        localIntent.putExtra("isWebCompShare", true);
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      }
      localIntent.putExtra("key_flag_from_plugin", true);
      localIntent.putExtra("isWebCompShare", true);
      bool1 = b(localIntent);
      bool2 = c(localIntent);
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    }
    try
    {
      paramBitmap = Uri.parse(this.jdField_c_of_type_JavaLangString);
      localObject2 = paramBitmap.getHost();
      if (!paramBitmap.isHierarchical()) {
        break label4060;
      }
      paramBitmap = paramBitmap.getQueryParameter("_pflag");
    }
    catch (Exception paramBitmap)
    {
      label3590:
      for (;;)
      {
        label1328:
        boolean bool3;
        Object localObject7;
        Object localObject8;
        Object localObject5;
        Object localObject6;
        label2100:
        long l1;
        Object localObject9;
        label2875:
        label2878:
        label4046:
        continue;
        label3355:
        paramBitmap = null;
      }
    }
    if ((!TextUtils.isEmpty(paramBitmap)) && (("post.mp.qq.com".equalsIgnoreCase((String)localObject2)) || ("url.cn".equalsIgnoreCase((String)localObject2))))
    {
      paramInt = Integer.parseInt(paramBitmap);
      if ((paramInt >> 4 & 0x1) == 1)
      {
        paramInt = 1;
        break label1328;
      }
    }
    paramInt = 0;
    paramBitmap = this.jdField_a_of_type_AndroidAppActivity;
    bool3 = paramBitmap instanceof IPublicAccountBrowser;
    localObject7 = "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
    if (bool3)
    {
      localObject7 = ((IPublicAccountBrowser)paramBitmap).getPubUin();
      localObject8 = this.jdField_a_of_type_AndroidAppActivity.getResources();
      paramBitmap = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("source_name");
      if ((!TextUtils.isEmpty((CharSequence)localObject7)) && (!TextUtils.isEmpty(paramBitmap)))
      {
        localObject3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { localObject7 });
        localObject5 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { localObject7 });
        localObject4 = "https://url.cn/JS8oE7";
        localObject2 = "plugin";
      }
      else if (jdField_f_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("share_tool_trace", 2, "QQ kandian");
        }
        paramBitmap = "QQ看点";
        localObject4 = "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
        localObject2 = "plugin";
        localObject3 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
        localObject5 = localObject3;
      }
      else
      {
        paramBitmap = ((Resources)localObject8).getString(2131696418);
        localObject2 = " ";
        localObject4 = "https://url.cn/PWkhNu";
        localObject3 = null;
        localObject5 = null;
      }
      if (paramInt != 0)
      {
        localObject5 = this.jdField_b_of_type_AndroidAppActivity.getString(2131696422);
        localObject4 = "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
        localObject2 = "plugin";
        localObject3 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
        paramBitmap = (Bitmap)localObject3;
      }
      else
      {
        localObject6 = localObject5;
        localObject5 = paramBitmap;
        paramBitmap = (Bitmap)localObject6;
      }
      ShareMsgHelper.a(this.jdField_a_of_type_AndroidAppActivity, 1001, 146, "web_share", (String)localObject7, paramString4, paramString1, paramString2, String.format(((Resources)localObject8).getString(2131696401), new Object[] { localObject1 }), paramString3, "web", null, null, null, (String)localObject2, null, (String)localObject3, paramBitmap, (String)localObject4, (String)localObject5, "", localIntent, -1, null, -1L);
      paramBitmap = "";
    }
    else
    {
      paramBitmap = paramBitmap.getIntent().getStringExtra("source_name");
      if (TextUtils.isEmpty(paramBitmap))
      {
        paramBitmap = this.l;
        localObject2 = this.m;
      }
      else
      {
        localObject2 = null;
      }
      if (TextUtils.isEmpty(paramBitmap))
      {
        if (jdField_f_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("share_tool_trace", 2, "QQ kandian");
          }
          paramBitmap = "QQ看点";
          localObject5 = "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
          localObject2 = "plugin";
          localObject3 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
          localObject4 = localObject3;
        }
        else
        {
          localObject2 = this.jdField_b_of_type_AndroidAppActivity.getString(2131696418);
          paramBitmap = MttLoader.getBrowserInfo(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
          if ((paramBitmap != null) && (!TextUtils.isEmpty(paramBitmap.packageName)))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramBitmap.packageName);
            ((StringBuilder)localObject3).append("://");
            ((StringBuilder)localObject3).append(paramString3);
            paramBitmap = ((StringBuilder)localObject3).toString();
          }
          else
          {
            paramBitmap = new StringBuilder();
            paramBitmap.append("com.tencent.mtt://");
            paramBitmap.append(paramString3);
            paramBitmap = paramBitmap.toString();
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("tencent100446242://");
          ((StringBuilder)localObject3).append(paramString3);
          localObject4 = ((StringBuilder)localObject3).toString();
          localObject5 = "https://url.cn/PWkhNu";
          localObject3 = paramBitmap;
          localObject6 = "app";
          paramBitmap = (Bitmap)localObject2;
          localObject2 = localObject6;
        }
      }
      else
      {
        localObject6 = " ";
        localObject3 = null;
        localObject4 = null;
        localObject5 = localObject2;
        localObject2 = localObject6;
      }
      if (paramInt != 0)
      {
        paramBitmap = this.jdField_b_of_type_AndroidAppActivity.getString(2131696422);
        localObject2 = "plugin";
        localObject5 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
        localObject6 = localObject5;
        localObject3 = localObject7;
      }
      else
      {
        localObject6 = localObject4;
        localObject4 = localObject5;
        localObject5 = localObject3;
        localObject3 = localObject4;
      }
      if ("QQ空间".equals(paramBitmap)) {
        localObject3 = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/logo_16.png";
      }
      localObject4 = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject4 instanceof SwiftWebViewFragmentSupporter))
      {
        localObject4 = ((SwiftWebViewFragmentSupporter)localObject4).getCurrentWebViewFragment();
        if (localObject4 != null)
        {
          localObject4 = (SwiftBrowserShareMenuHandler)((WebViewFragment)localObject4).getComponentProvider().a(4);
          if (!"".equals(((SwiftBrowserShareMenuHandler)localObject4).jdField_c_of_type_JavaLangString)) {
            localObject4 = ((SwiftBrowserShareMenuHandler)localObject4).jdField_c_of_type_JavaLangString;
          } else {
            localObject4 = ((SwiftBrowserShareMenuHandler)localObject4).jdField_a_of_type_JavaLangString;
          }
          break label2100;
        }
      }
      localObject4 = "";
      if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(paramString3))
      {
        localObject3 = HardCodeUtil.a(2131713747);
        if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().h())) {
          paramBitmap = "https://docs.qq.com/desktop/m/index.html?_wv=2";
        } else {
          paramBitmap = TencentDocConvertConfigProcessor.a().h();
        }
        paramInt = 95;
        localObject7 = paramBitmap;
        l1 = 101458937L;
        paramBitmap = "web";
        localObject2 = "https://docs.qq.com/desktop/favicon.ico";
      }
      else
      {
        localObject7 = "https://url.cn/UQoBHn";
        localObject8 = localObject3;
        l1 = 801097412L;
        localObject9 = localObject2;
        paramInt = 146;
        localObject3 = paramBitmap;
        localObject2 = localObject8;
        paramBitmap = (Bitmap)localObject9;
      }
      if ((!bool2) && (!bool1)) {
        i1 = 1001;
      } else {
        i1 = 38;
      }
      localObject8 = this.jdField_b_of_type_AndroidAppActivity;
      if (localObject1 == null) {
        localObject1 = "";
      }
      localObject9 = ((Activity)localObject8).getString(2131696401, new Object[] { localObject1 });
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo == null) {
        i2 = -1;
      } else {
        i2 = 1001;
      }
      localObject1 = "";
      ShareMsgHelper.a((Context)localObject8, i1, paramInt, "web_share", (String)localObject4, paramString4, paramString1, paramString2, (String)localObject9, paramString3, "web", null, null, null, paramBitmap, null, (String)localObject5, (String)localObject6, (String)localObject2, (String)localObject3, "", localIntent, i2, (String)localObject7, l1);
      paramBitmap = (Bitmap)localObject1;
    }
    if (TextUtils.isEmpty(paramString4)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    paramInt = i1;
    if (TextUtils.isEmpty(paramString2)) {
      paramInt = i1 | 0x2;
    }
    int i1 = paramInt;
    if (TextUtils.isEmpty(paramString1)) {
      i1 = paramInt | 0x4;
    }
    paramString1 = new Bundle();
    paramString1.putString("report_type", "102");
    paramString1.putString("act_type", "14");
    paramString1.putString("intext_3", "1");
    paramString2 = new StringBuilder();
    paramString2.append(paramBitmap);
    paramString2.append(i1);
    paramString1.putString("intext_2", paramString2.toString());
    paramString2 = new StringBuilder();
    paramString2.append(paramBitmap);
    paramString2.append(paramString3);
    paramString1.putString("stringext_1", paramString2.toString());
    ReportCenter.a().a(paramString1, paramBitmap, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
    return;
    if ((paramInt != 3) && (paramInt != 4))
    {
      if (paramInt == 5)
      {
        if ((this.jdField_c_of_type_Int != -1) && (!TextUtils.isEmpty(this.k)))
        {
          paramBitmap = new Bundle();
          if (TextUtils.isEmpty(paramString1)) {
            localObject1 = paramString3;
          }
          paramBitmap.putString("title", (String)localObject1);
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = paramString3;
          } else {
            paramString1 = paramString2;
          }
          paramBitmap.putString("desc", paramString1);
          paramBitmap.putString("detail_url", paramString3);
          paramBitmap.putString("cover_url", this.k);
          paramBitmap.putString("source_name", this.l);
          paramBitmap.putInt("article_id", this.jdField_c_of_type_Int);
          paramString1 = new ArrayList(1);
          paramString1.add(paramString4);
          paramBitmap.putStringArrayList("image_url", paramString1);
          paramBitmap.putLong("req_share_id", 0L);
          if (this.jdField_b_of_type_AndroidAppActivity == null) {
            this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
          }
          if (((IReadInJoyShareManager)QRoute.api(IReadInJoyShareManager.class)).jumpToReadInJoyShare(this.jdField_b_of_type_AndroidAppActivity, paramBitmap, null, 0)) {
            break label4046;
          }
          QRUtils.a(1, 2131689486);
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X8006277", "0X8006277", 0, 0, "", "", "", "");
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGetSummary invalid shareInfo");
        return;
      }
      if ((paramInt != 6) && (paramInt != 7)) {
        if (paramInt == 8)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
          }
          paramBitmap = BaseApplicationImpl.getContext().getPackageManager();
        }
      }
    }
    try
    {
      paramBitmap = paramBitmap.getApplicationInfo("com.sina.weibo", 8192);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:true");
      }
    }
    catch (PackageManager.NameNotFoundException paramString2)
    {
      break label2878;
    }
    try
    {
      ThreadManager.executeOnSubThread(new Share.4(this, paramString4, paramString1, paramString2, paramString3, paramBitmap));
    }
    catch (PackageManager.NameNotFoundException paramString2)
    {
      break label2875;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
    }
    try
    {
      paramString1 = URLEncoder.encode(paramString1, "UTF-8");
      paramString2 = new StringBuilder();
      paramString2.append("https://v.t.sina.com.cn/share/share.php?");
      paramString2.append("title=");
      paramString2.append(paramString1);
      paramString1 = paramString2.toString();
      paramString2 = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = new StringBuilder();
      paramString3.append(paramString1);
      paramString3.append("&url=");
      paramString3.append(paramString2);
      paramString1 = paramString3.toString();
      paramString2 = URLEncoder.encode(paramString4, "UTF-8");
      paramString3 = new StringBuilder();
      paramString3.append(paramString1);
      paramString3.append("&pic=");
      paramString3.append(paramString2);
      paramString1 = paramString3.toString();
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("&_wv=3");
      paramString1 = paramString2.toString();
      paramString2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
      }
    }
    catch (Exception paramString1)
    {
      Toast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131713748), 1).show();
      paramString1.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
      return;
      if (paramInt == 9)
      {
        paramString2 = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isKandianFavourite(this.jdField_a_of_type_AndroidAppActivity, paramString3, paramInt))
        {
          paramString1 = ((IFastModule)QRoute.api(IFastModule.class)).getFastWebArticleInfo(this.x);
          paramString3 = new Bundle();
          if (paramString1 != null)
          {
            paramString3.putLong("publishAccountUin", paramString1.jdField_e_of_type_Long);
            paramString3.putString("publishAccountName", paramString1.jdField_e_of_type_JavaLangString);
          }
          ((IReadInJoyAtlasManager)QRoute.api(IReadInJoyAtlasManager.class)).doFavorite(this.jdField_a_of_type_AndroidAppActivity, null, 1, this.x, this.jdField_e_of_type_JavaLangString, this.h, this.i, this.w, paramString3);
        }
        else
        {
          paramString1 = this.jdField_a_of_type_AndroidAppActivity;
          if ((paramString1 instanceof SwiftWebViewFragmentSupporter))
          {
            paramString1 = ((SwiftWebViewFragmentSupporter)paramString1).getCurrentWebViewFragment();
            if (paramString1 != null)
            {
              paramString1 = (SwiftBrowserShareMenuHandler)paramString1.getComponentProvider().a(4);
              if (TextUtils.isEmpty(paramString1.jdField_c_of_type_JavaLangString)) {
                paramString1 = paramString1.jdField_a_of_type_JavaLangString;
              } else {
                paramString1 = paramString1.jdField_c_of_type_JavaLangString;
              }
              break label3355;
            }
          }
          paramString1 = "";
          paramString3 = this.jdField_a_of_type_AndroidAppActivity;
          if ((paramString3 instanceof IPublicAccountBrowser)) {
            paramString1 = ((IPublicAccountBrowser)paramString3).getPubUin();
          }
          ThreadManager.getUIHandler().post(new Share.5(this, paramString1));
        }
        QfavReport.a(paramString2, 42, 2);
        return;
        QidianManager.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
        return;
        paramString4 = paramString3;
        i2 = 1;
        if (paramInt == 3) {
          this.jdField_e_of_type_Int = 1;
        } else {
          this.jdField_e_of_type_Int = 2;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new Share.3(this, paramString4);
          WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
        }
        this.o = String.valueOf(System.currentTimeMillis());
        if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (TeamWorkUtils.b.containsKey(this.jdField_f_of_type_JavaLangString)))
        {
          localObject1 = (Integer)TeamWorkUtils.b.get(this.jdField_f_of_type_JavaLangString);
          if (localObject1 != null)
          {
            i1 = ((Integer)localObject1).intValue();
            break label3590;
          }
        }
        else if (((paramString4 == null) || (!paramString4.contains("doc/"))) && (paramString4 != null) && (paramString4.contains("sheet/")))
        {
          i1 = 2;
          break label3590;
        }
        i1 = 1;
        if ((paramString4 != null) && (paramString4.contains("docs.qq.com/")))
        {
          if (paramInt == 3)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToWeChat! ~~~ SUMMARY_FOR_SEND_TO_WECHAT!");
            }
            WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
            if ((a() != null) && (a().l != null))
            {
              paramString1 = new StringBuilder();
              paramString1.append("pages/detail/detail?scene=");
              paramString1.append(a().l);
              paramString2 = paramString1.toString();
            }
            else
            {
              paramString1 = new StringBuilder();
              paramString1.append("pages/detail/detail?url=");
              paramString1.append(paramString4);
              paramString2 = paramString1.toString();
            }
            if (QLog.isColorLevel())
            {
              paramString1 = jdField_a_of_type_JavaLangString;
              paramString4 = new StringBuilder();
              paramString4.append("curFilePath=");
              paramString4.append(paramString2);
              QLog.d(paramString1, 2, paramString4.toString());
            }
            paramString1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getShareBitMapBase64(this.jdField_g_of_type_JavaLangString);
            if ((!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isBase64ImgFormatData(this.jdField_g_of_type_JavaLangString)))
            {
              if (paramString1 == null) {
                paramString1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(i1);
              }
            }
            else {
              paramString1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(i1);
            }
            if (paramString1 != null) {
              WXShareHelper.a().a(paramString2, "gh_252c5f06840b", paramString1, this.jdField_e_of_type_JavaLangString, this.h, paramString3);
            }
          }
          else if (paramInt == 4)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToWeChat_Circle!~~~ SUMMARY_FOR_SEND_TO_WECHAT_CIRCLE!");
            }
            WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
            paramString1 = WXShareHelper.a();
            paramString2 = this.o;
            paramBitmap = this.jdField_e_of_type_JavaLangString;
            localObject1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTeamWorkForH5ShareBitMap(i1);
            if (!TextUtils.isEmpty(this.h)) {
              paramString4 = this.h;
            }
            i1 = i2;
            if (paramInt == 3) {
              i1 = 0;
            }
            paramString1.a(paramString2, paramBitmap, (Bitmap)localObject1, paramString4, paramString3, i1);
          }
        }
        else
        {
          localObject2 = WXShareHelper.a();
          localObject3 = this.o;
          localObject1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            localObject1 = paramString4;
          }
          if (paramInt == 3) {
            paramInt = 0;
          } else {
            paramInt = 1;
          }
          ((WXShareHelper)localObject2).a((String)localObject3, paramString1, paramBitmap, (String)localObject1, paramString3, paramInt);
        }
      }
    }
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    Bundle localBundle = QQCustomArkDialog.AppInfo.a(paramString3, paramString4, "0.0.0.1", paramString6, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, null, null);
    localBundle.putBoolean("forward_ark_app_direct", false);
    localBundle.putString("forward_ark_app_name", paramString3);
    localBundle.putString("forward_ark_app_view", paramString4);
    localBundle.putString("forward_ark_app_meta", paramString6);
    localBundle.putString("forward_ark_app_desc", paramString5);
    localBundle.putString("forward_ark_app_prompt", paramString2);
    localBundle.putString("forward_ark_app_config", paramString7);
    if (!TextUtils.isEmpty(paramString8)) {
      localBundle.putString("forward_ark_app_ver", paramString8);
    }
    localBundle.putBoolean("forward_ark_from_h5", true);
    localBundle.putString("forward_ark_h5_from_normal", paramString1);
    localBundle.putBoolean("is_ark_display_share", true);
    localBundle.putString("forward_appId_ark_from_sdk", paramString9);
    localBundle.putString("struct_share_key_source_name", paramString10);
    localBundle.putString("struct_share_key_source_action_data", paramString11);
    localBundle.putString("struct_share_key_source_a_action_data_from_h5", paramString12);
    localBundle.putString("struct_share_key_source_url", paramString13);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "ShareArkFromH5 buildArkShareIntent bundle = ", localBundle.toString() });
    }
    paramIntent.putExtras(localBundle);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString1, long paramLong1, String paramString2, long paramLong2, long paramLong3, OpensdkBusinessObserver paramOpensdkBusinessObserver, String paramString3, long paramLong4, boolean paramBoolean)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("8.7.0");
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.md5time.set(paramLong3);
    localGetAppinfoRequest.signature.set(paramString2);
    localGetAppinfoRequest.channel_source.set(paramLong2);
    if (!TextUtils.isEmpty(paramString3)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramString3);
    }
    localGetAppinfoRequest.referer.set(2);
    paramContext = new NewIntent(paramContext, OpensdkServlet.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    paramContext.putExtra("timeout", paramLong4);
    paramContext.putExtra("key_support_retry", paramBoolean);
    paramContext.setObserver(paramOpensdkBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString1, long paramLong1, String paramString2, long paramLong2, OpensdkBusinessObserver paramOpensdkBusinessObserver, String paramString3)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("8.7.0");
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.md5time.set(paramLong2);
    localGetAppinfoRequest.signature.set(paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramString3);
    }
    localGetAppinfoRequest.referer.set(2);
    paramContext = new NewIntent(paramContext, OpensdkServlet.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    paramContext.putExtra("timeout", 15000L);
    paramContext.setObserver(paramOpensdkBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppRuntime paramAppRuntime, Context paramContext, String paramString, long paramLong1, long paramLong2, OpensdkBusinessObserver paramOpensdkBusinessObserver)
  {
    a(paramAppRuntime, paramContext, paramString, paramLong1, paramLong2, paramOpensdkBusinessObserver, MobileQQ.getContext().getPackageName());
  }
  
  public static final void a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, long paramLong1, long paramLong2, OpensdkBusinessObserver paramOpensdkBusinessObserver, String paramString2)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("8.7.0");
    localGetAppinfoRequest.setHasFlag(true);
    if (!TextUtils.isEmpty(paramString2)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramString2);
    }
    localGetAppinfoRequest.referer.set(2);
    paramContext = new NewIntent(paramContext, OpensdkServlet.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    if (paramLong2 > 0L) {
      paramContext.putExtra("timeout", paramLong2);
    }
    paramContext.setObserver(paramOpensdkBusinessObserver);
    paramAppRuntime.startServlet(paramContext);
  }
  
  private boolean a(String paramString)
  {
    try
    {
      boolean bool = "1".equals(Uri.parse(paramString).getQueryParameter("not_short"));
      return true ^ bool;
    }
    catch (Throwable paramString)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
    return true;
  }
  
  private void b(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = new HashMap();
    if ((paramInt == 1) && (a(paramString)))
    {
      if (((paramString.length() > 180) || ((!(this.jdField_a_of_type_AndroidAppActivity instanceof IPublicAccountBrowser)) && (paramString.length() > 60))) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof TeamWorkDocEditBrowserActivity)) && (!((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(paramString))) {
        ((HashMap)localObject2).put("url", paramString);
      }
      localObject1 = this.i;
      if ((localObject1 != null) && (((String)localObject1).length() > 40)) {
        ((HashMap)localObject2).put("thumb", this.i);
      }
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (Bitmap)((SoftReference)localObject1).get();
    }
    boolean bool;
    if ((paramBoolean) && ((paramInt == 3) || (paramInt == 4)) && (localObject1 == null) && (!TextUtils.isEmpty(this.i))) {
      bool = true;
    } else {
      bool = false;
    }
    if (((this.jdField_e_of_type_Boolean) || (((HashMap)localObject2).size() > 0) || (bool)) && (paramInt != 2) && (paramInt != 9))
    {
      ThreadManager.executeOnNetWorkThread(new Share.2(this, (HashMap)localObject2, paramInt, paramString, bool));
      return;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject2 != null) && (((QQProgressDialog)localObject2).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    localObject2 = this.jdField_e_of_type_JavaLangString;
    String str1 = this.h;
    String str2 = this.i;
    if (!paramBoolean) {
      localObject1 = null;
    }
    a(paramInt, (String)localObject2, str1, paramString, str2, (Bitmap)localObject1);
  }
  
  private boolean b(Intent paramIntent)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    String str1 = localBundle.getString("forward_ark_app_name");
    String str2 = localBundle.getString("forward_ark_app_view");
    if ((this.jdField_g_of_type_Boolean) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      String str3 = a(getShareUrl(), this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      String str4 = localBundle.getString("forward_ark_app_meta");
      String str5 = localBundle.getString("forward_ark_app_config");
      String str6 = localBundle.getString("forward_ark_app_desc");
      a(paramIntent, str3, localBundle.getString("forward_ark_app_prompt"), str1, str2, str6, str4, str5, "", localBundle.getString("forward_appId_ark_from_sdk"), localBundle.getString("struct_share_key_source_name"), localBundle.getString("struct_share_key_source_action_data"), localBundle.getString("struct_share_key_source_a_action_data"), localBundle.getString("struct_share_key_source_url"));
      return true;
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("app")) && (paramString.contains("view"));
  }
  
  private boolean c(Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        String str2 = a(getShareUrl(), this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        Object localObject = a(str2);
        if ((!((Map)localObject).isEmpty()) && (((Map)localObject).containsKey("app")) && (((Map)localObject).containsKey("view")))
        {
          String str3 = (String)((Map)localObject).get("app");
          String str4 = (String)((Map)localObject).get("view");
          if (!((Map)localObject).containsKey("meta")) {
            break label223;
          }
          str1 = (String)((Map)localObject).get("meta");
          String str5 = (String)((Map)localObject).get("config");
          localObject = (String)((Map)localObject).get("ver");
          if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)))
          {
            a(paramIntent, str2, "", str3, str4, "", str1, str5, (String)localObject, "", "", "", "", "");
            return true;
          }
        }
      }
      catch (Exception paramIntent)
      {
        ArkAppCenter.a(jdField_a_of_type_JavaLangString, String.format("shareArkFromUrl, parse json failed, err=%s", new Object[] { paramIntent.getMessage() }));
      }
      return false;
      label223:
      String str1 = "{}";
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public SharePolicyInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
  }
  
  public QQProgressDialog a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null) {
        localObject = (WebUiBaseInterface)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      int i1;
      if ((localObject != null) && ((localObject instanceof WebUiUtils.WebViewProviderInterface)) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
      {
        i1 = ((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface().a();
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity;
        if (localObject != null)
        {
          i1 = ((Activity)localObject).getResources().getDimensionPixelSize(2131299168);
        }
        else
        {
          i1 = (int)(this.jdField_a_of_type_Float * 50.0F + 0.5F);
          QLog.e(jdField_a_of_type_JavaLangString, 1, "use default yOffset when getting share progress dialog.");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131689482);
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dialog show time :");
        localStringBuilder.append(l1);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  public String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("appShareID", 146L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131369587));
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 == null) {
        return;
      }
      ((ImageView)localObject1).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131369588);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidAppActivity, this.n, AppShareIDUtil.b(this.jdField_a_of_type_Long), 0L, this.jdField_a_of_type_ComTencentOpenAppcommonOpensdkBusinessObserver);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165271));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842132);
      localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 19.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 19.0F));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840395);
      localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 30.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690091);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 13.75F);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165272));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 14.75F);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130841923);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165272));
      localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 56.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
      ((LinearLayout.LayoutParams)localObject1).rightMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
      localObject1 = new FrameLayout.LayoutParams(-1, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 44.0F));
      ((FrameLayout.LayoutParams)localObject1).gravity = 80;
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject2 instanceof SwiftWebViewFragmentSupporter))
      {
        localObject2 = ((SwiftWebViewFragmentSupporter)localObject2).getCurrentWebViewFragment();
        if ((localObject2 != null) && (((WebViewFragment)localObject2).getUIStyleHandler().a != null)) {
          ((WebViewFragment)localObject2).getUIStyleHandler().a.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject1);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("fontSize", paramInt1);
      ((JSONObject)localObject).put("fontScale", paramInt2);
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQWebviewSetFontSize: ");
        localStringBuilder.append(((JSONObject)localObject).toString());
        QLog.d(str, 2, localStringBuilder.toString());
      }
      localObject = WebViewPlugin.toJsScript("QQWebviewSetFontSize", (JSONObject)localObject, null);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs((String)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      label101:
      break label101;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWebviewSetFontSize jason error");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("policy", paramInt1);
      ((JSONObject)localObject).put("result", paramBoolean);
      ((JSONObject)localObject).put("shareSource", paramInt3);
      ((JSONObject)localObject).put("prePolicy", paramInt2);
      localObject = WebViewPlugin.toJsScript("didFinishShare", (JSONObject)localObject, null);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs((String)localObject);
      } else {
        ThreadManager.getUIHandler().post(new Share.9(this, (String)localObject));
      }
    }
    catch (JSONException localJSONException)
    {
      label102:
      break label102;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "share finished jason error");
    }
    if ((paramInt3 == 1) && ((paramInt2 == 0) || (paramInt2 == 1)) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo != null)) {
      ThreadManager.excute(new Share.10(this), 128, null, false);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.r != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("targetUinType", paramInt);
        localJSONObject.put("targetUin", paramString1);
        localJSONObject.put("targetNickname", paramString2);
      }
      catch (JSONException paramString1)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "notifyOnShareQQSpecifiedFriend process data error!", paramString1);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.r, new String[] { localJSONObject.toString() });
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
  }
  
  /* Error */
  protected void a(Context paramContext, GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 1554	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:has	()Z
    //   4: ifeq +543 -> 547
    //   7: aload_2
    //   8: getfield 1558	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11: invokevirtual 1562	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   14: ifne +533 -> 547
    //   17: aload_0
    //   18: aload_2
    //   19: putfield 125	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse	Lcom/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse;
    //   22: aload_0
    //   23: getfield 125	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse	Lcom/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse;
    //   26: getfield 1566	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:iconsURL	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   29: bipush 64
    //   31: invokestatic 1568	com/tencent/biz/webviewplugin/Share:a	(Lcom/tencent/mobileqq/pb/PBRepeatMessageField;I)Ljava/lang/String;
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 125	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse	Lcom/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse;
    //   39: getfield 1572	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:androidInfo	Lcom/tencent/protofile/getappinfo/GetAppInfoProto$AndroidInfo;
    //   42: astore 6
    //   44: aload_2
    //   45: invokestatic 363	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: istore_3
    //   49: iload_3
    //   50: ifne +424 -> 474
    //   53: aload 6
    //   55: ifnull +419 -> 474
    //   58: aload 6
    //   60: getfield 1577	com/tencent/protofile/getappinfo/GetAppInfoProto$AndroidInfo:packName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   63: ifnonnull +6 -> 69
    //   66: goto +408 -> 474
    //   69: aload_1
    //   70: aload_2
    //   71: ldc_w 1579
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokestatic 1585	com/tencent/biz/common/util/HttpUtil:openUrlForByte	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   79: astore 5
    //   81: aload 5
    //   83: ifnonnull +58 -> 141
    //   86: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +476 -> 565
    //   92: getstatic 173	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: astore_1
    //   96: new 249	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   103: astore 4
    //   105: aload 4
    //   107: ldc_w 1587
    //   110: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 4
    //   116: aload_2
    //   117: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 4
    //   123: ldc_w 1589
    //   126: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_1
    //   131: iconst_2
    //   132: aload 4
    //   134: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: return
    //   141: aload_0
    //   142: getfield 165	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   145: sipush 1002
    //   148: invokevirtual 1595	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   151: astore 4
    //   153: aload 5
    //   155: iconst_0
    //   156: aload 5
    //   158: arraylength
    //   159: invokestatic 1601	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   162: astore_2
    //   163: aload 4
    //   165: aload_2
    //   166: putfield 1607	android/os/Message:obj	Ljava/lang/Object;
    //   169: aload_0
    //   170: getfield 165	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   173: aload 4
    //   175: invokevirtual 1611	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   178: pop
    //   179: aload_2
    //   180: astore 4
    //   182: goto +27 -> 209
    //   185: aconst_null
    //   186: astore_2
    //   187: aload_2
    //   188: astore 4
    //   190: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +16 -> 209
    //   196: getstatic 173	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   199: iconst_2
    //   200: ldc_w 1613
    //   203: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_2
    //   207: astore 4
    //   209: aload_1
    //   210: aload 6
    //   212: getfield 1577	com/tencent/protofile/getappinfo/GetAppInfoProto$AndroidInfo:packName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   215: invokevirtual 347	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   218: invokestatic 1618	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   221: ifeq +47 -> 268
    //   224: aload_0
    //   225: getfield 165	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   228: sipush 1001
    //   231: invokevirtual 1595	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   234: astore_1
    //   235: aload_1
    //   236: aload 4
    //   238: putfield 1607	android/os/Message:obj	Ljava/lang/Object;
    //   241: aload_0
    //   242: getfield 165	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   245: aload_1
    //   246: invokevirtual 1611	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   249: pop
    //   250: return
    //   251: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +293 -> 547
    //   257: getstatic 173	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   260: iconst_2
    //   261: ldc_w 1613
    //   264: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: return
    //   268: aload_1
    //   269: ldc_w 1620
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_0
    //   279: getfield 123	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_Long	J
    //   282: invokestatic 1333	com/tencent/mobileqq/utils/AppShareIDUtil:b	(J)J
    //   285: invokestatic 1625	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   288: aastore
    //   289: invokestatic 416	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   292: ldc_w 1579
    //   295: aconst_null
    //   296: aconst_null
    //   297: invokestatic 1629	com/tencent/biz/common/util/HttpUtil:openUrl	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   300: astore_1
    //   301: aload_1
    //   302: invokestatic 363	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifeq +20 -> 325
    //   308: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +255 -> 566
    //   314: getstatic 173	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   317: iconst_2
    //   318: ldc_w 1631
    //   321: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: return
    //   325: new 1466	org/json/JSONObject
    //   328: dup
    //   329: aload_1
    //   330: invokespecial 1633	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   333: astore_1
    //   334: aload_1
    //   335: ldc_w 1635
    //   338: invokevirtual 1636	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   341: ifeq +20 -> 361
    //   344: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +220 -> 567
    //   350: getstatic 173	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   353: iconst_2
    //   354: ldc_w 1638
    //   357: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: return
    //   361: aload_1
    //   362: ldc_w 1497
    //   365: invokevirtual 1642	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   368: astore_1
    //   369: aload_1
    //   370: ifnull +177 -> 547
    //   373: aload_1
    //   374: ldc_w 1644
    //   377: invokevirtual 1642	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   380: astore_1
    //   381: aload_1
    //   382: ifnull +165 -> 547
    //   385: aload_1
    //   386: ldc_w 1113
    //   389: invokevirtual 1642	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   392: astore_1
    //   393: aload_1
    //   394: ifnull +153 -> 547
    //   397: aload_1
    //   398: ldc_w 1646
    //   401: invokevirtual 1647	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   404: astore_2
    //   405: aload_1
    //   406: ldc_w 1649
    //   409: invokevirtual 1636	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   412: iconst_1
    //   413: if_icmpne +134 -> 547
    //   416: aload_2
    //   417: invokestatic 363	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   420: ifne +127 -> 547
    //   423: aload_0
    //   424: getfield 165	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   427: sipush 1001
    //   430: invokevirtual 1595	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   433: astore_1
    //   434: aload_1
    //   435: aload 5
    //   437: iconst_0
    //   438: aload 5
    //   440: arraylength
    //   441: invokestatic 1601	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   444: putfield 1607	android/os/Message:obj	Ljava/lang/Object;
    //   447: aload_0
    //   448: getfield 165	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   451: aload_1
    //   452: invokevirtual 1611	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   455: pop
    //   456: return
    //   457: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +87 -> 547
    //   463: getstatic 173	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   466: iconst_2
    //   467: ldc_w 1613
    //   470: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: return
    //   474: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +51 -> 528
    //   480: getstatic 173	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   483: astore_1
    //   484: new 249	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   491: astore 4
    //   493: aload 4
    //   495: ldc_w 1587
    //   498: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 4
    //   504: aload_2
    //   505: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 4
    //   511: ldc_w 1651
    //   514: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload_1
    //   519: iconst_2
    //   520: aload 4
    //   522: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: return
    //   529: astore_1
    //   530: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq +14 -> 547
    //   536: getstatic 173	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   539: iconst_2
    //   540: aload_1
    //   541: invokevirtual 412	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   544: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: return
    //   548: astore_2
    //   549: goto -364 -> 185
    //   552: astore 4
    //   554: goto -367 -> 187
    //   557: astore_1
    //   558: goto -307 -> 251
    //   561: astore_1
    //   562: goto -105 -> 457
    //   565: return
    //   566: return
    //   567: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	Share
    //   0	568	1	paramContext	Context
    //   0	568	2	paramGetAppinfoResponse	GetAppInfoProto.GetAppinfoResponse
    //   48	2	3	bool	boolean
    //   103	418	4	localObject	Object
    //   552	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   79	360	5	arrayOfByte	byte[]
    //   42	169	6	localAndroidInfo	GetAppInfoProto.AndroidInfo
    // Exception table:
    //   from	to	target	type
    //   0	49	529	java/lang/Exception
    //   58	66	529	java/lang/Exception
    //   69	81	529	java/lang/Exception
    //   86	140	529	java/lang/Exception
    //   141	153	529	java/lang/Exception
    //   153	163	529	java/lang/Exception
    //   163	179	529	java/lang/Exception
    //   190	206	529	java/lang/Exception
    //   209	235	529	java/lang/Exception
    //   235	250	529	java/lang/Exception
    //   251	267	529	java/lang/Exception
    //   268	324	529	java/lang/Exception
    //   325	360	529	java/lang/Exception
    //   361	369	529	java/lang/Exception
    //   373	381	529	java/lang/Exception
    //   385	393	529	java/lang/Exception
    //   397	434	529	java/lang/Exception
    //   434	456	529	java/lang/Exception
    //   457	473	529	java/lang/Exception
    //   474	528	529	java/lang/Exception
    //   153	163	548	java/lang/OutOfMemoryError
    //   163	179	552	java/lang/OutOfMemoryError
    //   235	250	557	java/lang/OutOfMemoryError
    //   434	456	561	java/lang/OutOfMemoryError
  }
  
  public void a(APICallback paramAPICallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = paramAPICallback;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      this.w = paramAbsBaseArticleInfo.mArticleContentUrl;
      this.x = paramAbsBaseArticleInfo.innerUniqueID;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "shareUrl = ", this.w, " , rowKey = ", this.x });
      }
    }
    else
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setReadInJoyShareData but articleInfo is null.");
    }
  }
  
  public void a(SharePolicyInfo paramSharePolicyInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = paramSharePolicyInfo;
  }
  
  public void a(WebUiBaseInterface paramWebUiBaseInterface)
  {
    if (paramWebUiBaseInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebUiBaseInterface);
    }
    paramWebUiBaseInterface = (WebUiBaseInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject;
    if ((paramWebUiBaseInterface != null) && ((paramWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((WebUiUtils.WebUiMethodInterface)paramWebUiBaseInterface).getWebView();
      if (QLog.isColorLevel())
      {
        paramWebUiBaseInterface = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" Share secret webview is null?");
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          bool1 = false;
        }
        ((StringBuilder)localObject).append(bool1);
        QLog.d(paramWebUiBaseInterface, 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" Share secret baseInterface is null?");
      if (paramWebUiBaseInterface == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidAppActivity.getApplicationContext();
    a();
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      paramString = "0";
    } else if (paramInt == 2) {
      paramString = "1";
    } else if (paramInt == 3) {
      paramString = "2";
    } else if (paramInt == 4) {
      paramString = "3";
    } else if (paramInt == 8) {
      paramString = "4";
    } else if (paramInt == 6) {
      paramString = "5";
    } else if (paramInt == 7) {
      paramString = "6";
    } else {
      paramString = "-1";
    }
    a().show();
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localCustomWebView != null)
    {
      localCustomWebView.callJs(this.p, new String[] { paramString });
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "notifyOnShare webview is null");
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_AndroidAppActivity == null) {
      if (this.jdField_a_of_type_AndroidAppActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.jdField_b_of_type_AndroidAppActivity = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      } else {
        this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
      }
    }
    QZoneShareData localQZoneShareData = new QZoneShareData();
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localObject = null;
    } else {
      localObject = this.jdField_e_of_type_JavaLangString;
    }
    localQZoneShareData.mTitle = ((String)localObject);
    if (TextUtils.isEmpty(this.h)) {
      localObject = null;
    } else {
      localObject = this.h;
    }
    localQZoneShareData.mSummary = ((String)localObject);
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(this.i);
    localQZoneShareData.mImageUrls = ((ArrayList)localObject);
    localQZoneShareData.targetUrl = getShareUrl();
    int i1 = this.jdField_d_of_type_Int;
    if (i1 != -1) {
      localQZoneShareData.iUrlInfoFrm = i1;
    }
    localQZoneShareData.mShareBeginTime = SwiftBrowserShareMenuHandler.jdField_b_of_type_Long;
    localQZoneShareData.from = 2;
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localObject != null) {
      localQZoneShareData.mWebUrl = ((CustomWebView)localObject).getUrl();
    }
    localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localObject != null)
    {
      QZoneShareManager.shareToQzone(this.jdField_b_of_type_AndroidAppActivity, ((AppRuntime)localObject).getCurrentAccountUin(), localQZoneShareData, null, -1);
      return true;
    }
    QRUtils.a(1, 2131689486);
    return true;
  }
  
  public boolean a(Intent paramIntent)
  {
    boolean bool3 = b(paramIntent);
    boolean bool2 = c(paramIntent);
    paramIntent = jdField_a_of_type_JavaLangString;
    boolean bool1 = false;
    QLog.d(paramIntent, 1, new Object[] { "ShareArkFromH5 shouldShareArkMsgToQQ bShareArkOpenApp=", Boolean.valueOf(bool3), ", bShareArkFromNormal=", Boolean.valueOf(bool2), " ,isShareArk=", Boolean.valueOf(this.jdField_g_of_type_Boolean) });
    if (((this.jdField_g_of_type_Boolean) && (bool3)) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131689481);
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_b_of_type_Int = ReportDef.RepUtil.b(paramInt);
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "90");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      int i1;
      if (this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_a_of_type_Int == 0) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      localStringBuilder.append(i1);
      ((Bundle)localObject).putString("intext_1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_b_of_type_Int);
      ((Bundle)localObject).putString("intext_3", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_a_of_type_Int);
      ((Bundle)localObject).putString("intext_2", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString);
      ((Bundle)localObject).putString("stringext_1", localStringBuilder.toString());
      ReportCenter.a().a((Bundle)localObject, "", this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
      this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_a_of_type_Boolean = false;
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
    {
      if (QLog.isColorLevel())
      {
        paramString = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSummary Fail_Network. title=");
        ((StringBuilder)localObject).append(this.jdField_e_of_type_JavaLangString);
        ((StringBuilder)localObject).append(", desc=");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(", thumb=");
        ((StringBuilder)localObject).append(this.i);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
      QRUtils.a(1, 2131694424);
      paramString = new Bundle();
      paramString.putString("report_type", "102");
      paramString.putString("act_type", "84");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(ReportDef.RepUtil.a(1));
      paramString.putString("intext_1", ((StringBuilder)localObject).toString());
      paramString.putString("intext_3", "1");
      paramString.putString("intext_4", "0");
      ReportCenter.a().a(paramString, "", this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
      return false;
    }
    jdField_f_of_type_Boolean = false;
    if (Pattern.compile("http(s)?://([a-zA-Z])*\\.mp\\.qq\\.com/((kan/(article|show|album))|(group/show))(\\.)*").matcher(paramString).find()) {
      jdField_f_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url is ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("share_tool_trace", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readInjoy JS work=");
      ((StringBuilder)localObject).append(jdField_f_of_type_Boolean);
      QLog.d("share_tool_trace", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.length() > 30)) {
      this.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString.substring(0, 29);
    }
    if (!TextUtils.isEmpty(this.h))
    {
      localObject = this.h;
      if ((localObject != null) && (((String)localObject).length() > 40)) {
        this.h = this.h.substring(0, 39);
      }
    }
    if ((!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.h)))
    {
      b(paramString, paramInt, paramBoolean);
      return true;
    }
    a().c(2131689482);
    boolean bool = TextUtils.isEmpty(this.x);
    if ((!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (bool)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    ThreadManager.executeOnNetWorkThread(new Share.1(this, paramString, paramInt, paramBoolean));
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.h;
  }
  
  public void b()
  {
    String str = this.p;
    if (str != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(str, new String[] { "7" });
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.i;
  }
  
  public void c()
  {
    String str = this.p;
    if (str != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(str, new String[] { "8" });
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String d()
  {
    return this.k;
  }
  
  public void d()
  {
    String str = this.p;
    if (str != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(str, new String[] { "9" });
    }
  }
  
  public void destroy()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
  }
  
  public String e()
  {
    return this.l;
  }
  
  public void e()
  {
    String str = this.q;
    if (str != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(str, new String[] { "0" });
    }
  }
  
  public String f()
  {
    return this.j;
  }
  
  public void f()
  {
    String str = this.s;
    if (str != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(str, new String[] { "1" });
    }
  }
  
  public void g()
  {
    String str = this.t;
    if (str != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(str, new String[] { "2" });
    }
  }
  
  public <T> T getShare()
  {
    return this;
  }
  
  public String getShareUrl()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (WebUiBaseInterface)((WeakReference)localObject).get();
        if ((localObject != null) && ((localObject instanceof WebUiUtils.WebUiMethodInterface)))
        {
          localObject = ((WebUiUtils.WebUiMethodInterface)localObject).getCurrentUrl();
          break label62;
        }
      }
      localObject = "";
    }
    label62:
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    return Util.a((String)localObject, new String[0]);
  }
  
  public void h()
  {
    String str = this.u;
    if (str != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(str, new String[] { "3" });
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse;
    if ((localObject != null) && (((GetAppInfoProto.GetAppinfoResponse)localObject).androidInfo != null))
    {
      localObject = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
      Bundle localBundle;
      if ((paramView != this.jdField_a_of_type_AndroidWidgetImageView) && (paramView != this.jdField_a_of_type_AndroidViewView))
      {
        if (paramView == this.jdField_b_of_type_AndroidWidgetTextView)
        {
          if (PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, ((GetAppInfoProto.AndroidInfo)localObject).packName.get()))
          {
            PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, ((GetAppInfoProto.AndroidInfo)localObject).packName.get(), null);
            OpenSdkStatic.a().a(this.n, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "203", false);
          }
          else
          {
            localBundle = new Bundle();
            localBundle.putString("uin", this.n);
            localBundle.putString("sid", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("vkey"));
            localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
            localBundle.putBoolean("autoDownload", true);
            localBundle.putString("packageName", ((GetAppInfoProto.AndroidInfo)localObject).packName.get());
            localBundle.putString("appId", String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)));
            AppClient.b(this.jdField_a_of_type_AndroidAppActivity, localBundle);
            OpenSdkStatic.a().a(this.n, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "202", false);
          }
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (localObject != null) {
            ((LinearLayout)localObject).setVisibility(8);
          }
        }
        else if (paramView == this.jdField_b_of_type_AndroidWidgetLinearLayout)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (localObject != null) {
            ((LinearLayout)localObject).setVisibility(8);
          }
        }
      }
      else
      {
        if (PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, ((GetAppInfoProto.AndroidInfo)localObject).packName.get()))
        {
          PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, ((GetAppInfoProto.AndroidInfo)localObject).packName.get(), null);
          localObject = "run";
        }
        else
        {
          localBundle = new Bundle();
          localBundle.putString("uin", this.n);
          localBundle.putString("sid", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("vkey"));
          localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
          localBundle.putBoolean("autoDownload", true);
          localBundle.putString("packageName", ((GetAppInfoProto.AndroidInfo)localObject).packName.get());
          AppClient.a(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), 2470, localBundle);
          localObject = "setup";
        }
        Util.a(null, "", "webviewsourceclick", AppShareIDUtil.b(this.jdField_a_of_type_Long), 0L, (String)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void reset()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.h = null;
    this.i = null;
    this.l = null;
    this.m = null;
    this.p = null;
    this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = null;
    this.q = null;
    this.r = null;
    this.s = null;
    this.t = null;
    this.u = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.j = null;
  }
  
  public boolean setShareUrl(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localObject == null) {
      return false;
    }
    localObject = ((CustomWebView)localObject).getUrl();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      localObject = Uri.parse((String)localObject);
      Uri localUri = Uri.parse(paramString);
      if (!((Uri)localObject).isOpaque())
      {
        if (localUri.isOpaque()) {
          return false;
        }
        if ((((Uri)localObject).getScheme().equals(localUri.getScheme())) && (((Uri)localObject).getHost().equals(localUri.getHost())))
        {
          this.jdField_b_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_JavaLangRefSoftReference = null;
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString3)) && (!setShareUrl(paramString3))) {
      return false;
    }
    this.jdField_e_of_type_JavaLangString = paramString1;
    this.h = paramString2;
    this.i = paramString4;
    Object localObject = this.i;
    if ((localObject != null) && (((String)localObject).startsWith("//")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("http:");
      ((StringBuilder)localObject).append(this.i);
      this.i = ((StringBuilder)localObject).toString();
    }
    this.jdField_e_of_type_Boolean = true;
    if ((paramBundle != null) && (paramBundle.getInt("extra_url_info_from") == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Share info after JS capture: title=");
        ((StringBuilder)localObject).append(this.jdField_e_of_type_JavaLangString);
        ((StringBuilder)localObject).append(", summary=");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(", thumb=");
        ((StringBuilder)localObject).append(this.i);
        ((StringBuilder)localObject).append(", shareURL=");
        ((StringBuilder)localObject).append(paramString3);
        QLog.e("shareWebPage", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x;
      ((ReportDef.ShareStructMsg.Report9x)localObject).jdField_a_of_type_Boolean = true;
      ((ReportDef.ShareStructMsg.Report9x)localObject).jdField_a_of_type_Int = 0;
      if (TextUtils.isEmpty(paramString4))
      {
        paramString4 = this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x;
        paramString4.jdField_a_of_type_Int |= 0x1;
      }
      else
      {
        this.jdField_b_of_type_Int = 2;
      }
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x;
        paramString2.jdField_a_of_type_Int |= 0x2;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x;
        paramString1.jdField_a_of_type_Int |= 0x4;
      }
    }
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    if (paramBundle != null) {}
    try
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setSummary need parse extraData");
      this.jdField_f_of_type_JavaLangString = paramBundle.getString("type");
      this.jdField_g_of_type_JavaLangString = paramBundle.getString("miniprogram_image_url");
      this.jdField_d_of_type_Int = paramBundle.getInt("extra_url_info_from", -1);
      this.k = paramBundle.getString("cover_url");
      this.l = paramBundle.getString("source_name");
      this.m = paramBundle.getString("source_icon");
      this.jdField_c_of_type_Int = Integer.parseInt(paramBundle.getString("article_id"));
    }
    catch (NumberFormatException paramString1)
    {
      break label434;
    }
    catch (Exception paramString1)
    {
      label421:
      break label421;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "setSummary extraData parse unknown exception");
    break label449;
    label434:
    QLog.w(jdField_a_of_type_JavaLangString, 1, "setSummary extraData parse articleId exception");
    this.jdField_c_of_type_Int = -1;
    label449:
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("editable");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("isCreator");
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_Boolean = paramBundle.getBoolean("isNewCreate");
    }
    label540:
    try
    {
      this.j = paramBundle.getString("singleLineTitle");
    }
    catch (Exception paramString1)
    {
      label507:
      break label507;
    }
    this.j = null;
    QLog.w(jdField_a_of_type_JavaLangString, 1, "setSummary extraData parse singleLineTitle exception");
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramBundle.getString("policy"));
    }
    catch (Exception paramString1)
    {
      break label540;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("contentEdited");
    paramString1 = this.jdField_a_of_type_AndroidAppActivity;
    if ((paramString1 != null) && ((paramString1 instanceof TeamWorkDocEditBrowserActivity)))
    {
      paramString1 = (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)((TeamWorkDocEditBrowserActivity)paramString1).getCurrentWebViewFragment();
      if (paramString1 != null)
      {
        paramString1.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
        paramString1.a(this.jdField_d_of_type_Boolean);
        paramString1.h();
        paramString1.a(true, this.j, null);
        if (this.jdField_c_of_type_Boolean) {
          paramString1.c();
        }
      }
    }
    LocalMultiProcConfig.putString("msharetitle", this.jdField_e_of_type_JavaLangString);
    LocalMultiProcConfig.putString("msharedesc", this.h);
    LocalMultiProcConfig.putString("msharethumb", this.i);
    LocalMultiProcConfig.putString("mshareurl", paramString3);
    LocalMultiProcConfig.putInt("msharefrom", this.jdField_d_of_type_Int);
    paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (paramString1 != null) {
      LocalMultiProcConfig.putString("msharecururl", paramString1.getUrl());
    }
    paramString1 = new Intent("com.tencent.qq.shareupdate");
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    if (paramString2 != null) {
      paramString2.sendBroadcast(paramString1);
    }
    return true;
  }
  
  public boolean shareStructMsgForH5(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
    {
      QRUtils.a(1, 2131694424);
      return false;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      QRUtils.a(1, 2131689481);
      return false;
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      paramString7 = (WebUiBaseInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((paramString7 != null) && ((paramString7 instanceof WebUiUtils.WebViewProviderInterface))) {
        i1 = ((WebUiUtils.WebViewProviderInterface)paramString7).getWebTitleBarInterface().a();
      } else {
        i1 = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131689482);
    }
    boolean bool;
    if (paramString4.length() > 180) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramString5 != null) && (paramString5.length() > 40)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((!bool) && (i1 == 0))
    {
      paramString7 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
      paramString8 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
      String str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696401), new Object[] { paramString2 });
      ShareMsgHelper.a(this.jdField_a_of_type_AndroidAppActivity, 1001, 146, "struct_msg_from_h5", paramString1, paramString5, paramString2, paramString3, str, paramString4, "web", null, null, null, "plugin", null, paramString7, paramString8, "https://url.cn/JS8oE7", paramString6, null);
      if (TextUtils.isEmpty(paramString5)) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      i1 = i2;
      if (TextUtils.isEmpty(paramString3)) {
        i1 = i2 | 0x2;
      }
      int i2 = i1;
      if (TextUtils.isEmpty(paramString2)) {
        i2 = i1 | 0x4;
      }
      paramString1 = new Bundle();
      paramString1.putString("report_type", "102");
      paramString1.putString("act_type", "14");
      paramString1.putString("intext_3", "1");
      paramString2 = new StringBuilder();
      paramString2.append("");
      paramString2.append(i2);
      paramString1.putString("intext_2", paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append("");
      paramString2.append(paramString4);
      paramString1.putString("stringext_1", paramString2.toString());
      ReportCenter.a().a(paramString1, "", this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    new Share.6(this, bool, paramString5, paramString1, paramString2, paramString3, paramString4, paramString6).start();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share
 * JD-Core Version:    0.7.0.1
 */