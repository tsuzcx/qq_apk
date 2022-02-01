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
import com.tencent.mobileqq.kandian.biz.detail.api.IReadInJoyArticleDetailActivity;
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
  static String a = "share";
  public static boolean ab = false;
  public CustomWebView A;
  QQProgressDialog B;
  protected View C;
  protected ImageView D;
  protected long E;
  protected GetAppInfoProto.GetAppinfoResponse F;
  protected AppRuntime G;
  protected String H;
  WXShareHelper.WXShareListener I;
  String J;
  protected float K;
  protected LinearLayout L;
  protected LinearLayout M;
  protected ImageView N;
  protected ImageView O;
  protected TextView P;
  protected TextView Q;
  protected Context R;
  public String S;
  public APICallback T;
  public String U;
  public String V;
  public String W;
  public String X;
  public String Y;
  public String Z;
  public SharePolicyInfo aa;
  protected String ac;
  protected String ad;
  public boolean ae;
  WeakReference<WebUiBaseInterface> af;
  volatile int ag;
  protected OpensdkBusinessObserver ah;
  protected Handler ai;
  private WeakReference<WebUiUtils.WebTitleBarInterface> aj;
  protected String b = null;
  protected String c = null;
  protected String d = null;
  protected String e = null;
  protected String f = null;
  protected String g = null;
  protected String h = null;
  protected String i = null;
  protected boolean j;
  protected int k;
  protected boolean l;
  protected String m;
  protected boolean n;
  protected boolean o;
  boolean p;
  int q;
  ReportDef.ShareStructMsg.Report9x r;
  protected String s;
  protected String t;
  protected String u;
  protected int v;
  protected int w;
  protected SoftReference<Bitmap> x;
  Activity y;
  Activity z;
  
  public Share(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    this.j = true;
    this.k = -1;
    this.l = false;
    this.m = null;
    this.n = false;
    this.o = false;
    this.r = new ReportDef.ShareStructMsg.Report9x();
    this.s = null;
    this.t = null;
    this.u = null;
    this.v = -1;
    this.w = -1;
    this.x = null;
    this.z = null;
    this.C = null;
    this.D = null;
    this.E = 0L;
    this.F = null;
    this.S = null;
    this.T = null;
    this.U = null;
    this.V = null;
    this.W = null;
    this.X = null;
    this.Y = null;
    this.Z = null;
    this.ac = "";
    this.ad = "";
    this.af = null;
    this.aj = null;
    this.ag = 0;
    this.ah = new Share.7(this);
    this.ai = new Share.8(this);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "Share secret init share");
    }
    this.G = paramAppRuntime;
    this.H = paramAppRuntime.getAccount();
    this.y = paramActivity;
    this.K = paramActivity.getResources().getDisplayMetrics().density;
    Object localObject;
    StringBuilder localStringBuilder;
    if ((paramActivity instanceof WebUiBaseInterface))
    {
      this.af = new WeakReference((WebUiBaseInterface)paramActivity);
    }
    else if ((paramActivity instanceof SwiftWebViewFragmentSupporter))
    {
      paramAppRuntime = ((SwiftWebViewFragmentSupporter)paramActivity).getCurrentWebViewFragment();
      if (paramAppRuntime != null)
      {
        this.af = new WeakReference(paramAppRuntime);
      }
      else if ((paramActivity instanceof QQBrowserActivity))
      {
        QLog.w(a, 2, "Caution! mWebUiUtils == null! maybe webviewfragment is invisible!");
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
            localObject = a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("cast Fragment (index: ");
            localStringBuilder.append(i1);
            localStringBuilder.append(") to WebViewFragment");
            QLog.w((String)localObject, 2, localStringBuilder.toString());
            if ((paramAppRuntime.get(i1) instanceof WebViewFragment))
            {
              this.af = new WeakReference((WebViewFragment)paramAppRuntime.get(i1));
            }
            else
            {
              paramAppRuntime = a;
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
    paramAppRuntime = this.af;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error! mWebUiUtils still null! ");
      ((StringBuilder)localObject).append(paramActivity.toString());
      QLog.e(paramAppRuntime, 2, ((StringBuilder)localObject).toString());
      return;
    }
    paramAppRuntime = (WebUiBaseInterface)paramAppRuntime.get();
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof WebUiUtils.WebUiMethodInterface)))
    {
      this.A = ((WebUiUtils.WebUiMethodInterface)paramAppRuntime).getWebView();
      if (QLog.isColorLevel())
      {
        paramAppRuntime = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" Share secret webview is null?");
        if (this.A != null) {
          bool1 = false;
        }
        ((StringBuilder)localObject).append(bool1);
        QLog.d(paramAppRuntime, 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = a;
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
    this.R = paramActivity.getApplicationContext();
    b();
  }
  
  private SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter a(String paramString, int paramInt)
  {
    boolean bool = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isWxArticle(paramString);
    paramString = null;
    if ((bool) && (paramInt == 9)) {
      return null;
    }
    Activity localActivity = this.y;
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
    if (c(paramString1)) {
      return paramString1;
    }
    if (c(paramString2)) {
      return paramString2;
    }
    if (c(paramString3)) {
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
              QLog.d(a, 2, localNumberFormatException1.getMessage());
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
                QLog.d(a, 2, localNumberFormatException2.getMessage());
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
      paramList = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QQBrowserActivity findAppIcon() iconUrl = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d(paramList, 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
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
      localObject2 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onGetSummary. forWhat = ");
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append(", title=");
      ((StringBuilder)localObject3).append(this.e);
      ((StringBuilder)localObject3).append(", desc=");
      ((StringBuilder)localObject3).append(this.h);
      ((StringBuilder)localObject3).append(", thumb=");
      ((StringBuilder)localObject3).append(this.i);
      ((StringBuilder)localObject3).append(", bitmap=");
      ((StringBuilder)localObject3).append(paramBitmap);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    if (this.z == null) {
      if (this.y.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.z = ((PluginBaseActivity)this.y).getOutActivity();
      } else {
        this.z = this.y;
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
      localObject2 = this.c;
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
    ReportCenter.a().a((Bundle)localObject3, "", this.G.getAccount(), false);
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
      paramInt = this.w;
      if (paramInt != -1) {
        paramBitmap.putInt("iUrlInfoFrm", paramInt);
      }
      paramBitmap.putLong("share_begin_time", SwiftBrowserShareMenuHandler.x);
      paramString1 = this.y;
      paramInt = i3;
      if ((paramString1 instanceof SwiftWebViewFragmentSupporter))
      {
        paramString1 = ((SwiftWebViewFragmentSupporter)paramString1).getCurrentWebViewFragment();
        if (paramString1 != null)
        {
          paramString2 = (SwiftBrowserShareMenuHandler)paramString1.getComponentProvider().a(4);
          paramBitmap.putString("strurt_msgid", paramString2.o);
          paramBitmap.putString("struct_uin", paramString2.n);
          paramBitmap.putString("struct_url", paramString1.getUrl());
          paramBitmap.putBoolean("from_web", true);
          paramInt = i3;
          if (paramString2.p != null)
          {
            paramInt = i3;
            if (!"".equals(paramString2.p))
            {
              paramBitmap.putString("source_puin", paramString2.p);
              paramInt = i3;
            }
          }
        }
        else
        {
          paramInt = 1;
        }
      }
      if ((paramInt != 0) || (!QZoneShareManager.jumpToQzoneShare(this.G.getCurrentUin(), this.z, paramBitmap, null, -1))) {
        QRUtils.a(1, 2131886094);
      }
    }
    else if (paramInt == 1)
    {
      localIntent = new Intent(this.z, ForwardRecentActivity.class);
      paramBitmap = this.y;
      if ((paramBitmap instanceof SwiftWebViewFragmentSupporter))
      {
        paramBitmap = ((SwiftWebViewFragmentSupporter)paramBitmap).getCurrentWebViewFragment();
        if ((paramBitmap != null) && (paramBitmap.getComponentProvider() != null))
        {
          localObject2 = (SwiftBrowserShareMenuHandler)paramBitmap.getComponentProvider().a(4);
          if (localObject2 != null)
          {
            paramBitmap = ((SwiftBrowserShareMenuHandler)localObject2).n();
            localObject2 = ((SwiftBrowserShareMenuHandler)localObject2).C;
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
          localObject2 = a;
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
        localIntent.setClass(this.R, DirectForwardActivity.class);
        localIntent.putExtra("toUin", (String)localObject2);
        localIntent.putExtra("uinType", paramInt);
        if ((paramBitmap != null) && (!paramBitmap.isEmpty()))
        {
          paramBitmap = paramBitmap.getString("to_uin_name");
          if (QLog.isColorLevel())
          {
            localObject2 = a;
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
        localIntent.setClass(this.R, ForwardRecentActivity.class);
      }
      localIntent.putExtra("key_flag_from_plugin", true);
      localIntent.putExtra("isWebCompShare", true);
      bool1 = b(localIntent);
      bool2 = c(localIntent);
      if (TextUtils.isEmpty(this.c)) {}
    }
    try
    {
      paramBitmap = Uri.parse(this.c);
      localObject2 = paramBitmap.getHost();
      if (!paramBitmap.isHierarchical()) {
        break label4078;
      }
      paramBitmap = paramBitmap.getQueryParameter("_pflag");
    }
    catch (Exception paramBitmap)
    {
      label3608:
      for (;;)
      {
        label1328:
        boolean bool3;
        Object localObject7;
        Object localObject8;
        Object localObject5;
        Object localObject6;
        label2117:
        long l1;
        Object localObject9;
        label2892:
        label2895:
        label4064:
        continue;
        label3373:
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
    paramBitmap = this.y;
    bool3 = paramBitmap instanceof IPublicAccountBrowser;
    localObject7 = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
    if (bool3)
    {
      localObject7 = ((IPublicAccountBrowser)paramBitmap).getPubUin();
      localObject8 = this.y.getResources();
      paramBitmap = this.y.getIntent().getStringExtra("source_name");
      if ((!TextUtils.isEmpty((CharSequence)localObject7)) && (!TextUtils.isEmpty(paramBitmap)))
      {
        localObject3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { localObject7 });
        localObject5 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { localObject7 });
        localObject4 = "https://url.cn/JS8oE7";
        localObject2 = "plugin";
      }
      else if (ab)
      {
        if (QLog.isColorLevel()) {
          QLog.d("share_tool_trace", 2, "QQ kandian");
        }
        paramBitmap = "QQ看点";
        localObject4 = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
        localObject2 = "plugin";
        localObject3 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
        localObject5 = localObject3;
      }
      else
      {
        paramBitmap = ((Resources)localObject8).getString(2131894190);
        localObject2 = " ";
        localObject4 = "https://url.cn/PWkhNu";
        localObject3 = null;
        localObject5 = null;
      }
      if (paramInt != 0)
      {
        localObject5 = this.z.getString(2131894194);
        localObject4 = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
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
      ShareMsgHelper.a(this.y, 1001, 146, "web_share", (String)localObject7, paramString4, paramString1, paramString2, String.format(((Resources)localObject8).getString(2131894173), new Object[] { localObject1 }), paramString3, "web", null, null, null, (String)localObject2, null, (String)localObject3, paramBitmap, (String)localObject4, (String)localObject5, "", localIntent, -1, null, -1L);
      paramBitmap = "";
    }
    else
    {
      paramBitmap = paramBitmap.getIntent().getStringExtra("source_name");
      if (TextUtils.isEmpty(paramBitmap))
      {
        paramBitmap = this.t;
        localObject2 = this.u;
      }
      else
      {
        localObject2 = null;
      }
      if (TextUtils.isEmpty(paramBitmap))
      {
        bool3 = this.y instanceof IReadInJoyArticleDetailActivity;
        if ((!ab) && (!bool3))
        {
          localObject2 = this.z.getString(2131894190);
          paramBitmap = MttLoader.getBrowserInfo(this.y.getApplicationContext());
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
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("share_tool_trace", 2, "QQ kandian");
          }
          paramBitmap = "QQ看点";
          localObject5 = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
          localObject2 = "plugin";
          localObject3 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
          localObject4 = localObject3;
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
        paramBitmap = this.z.getString(2131894194);
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
      localObject4 = this.y;
      if ((localObject4 instanceof SwiftWebViewFragmentSupporter))
      {
        localObject4 = ((SwiftWebViewFragmentSupporter)localObject4).getCurrentWebViewFragment();
        if (localObject4 != null)
        {
          localObject4 = (SwiftBrowserShareMenuHandler)((WebViewFragment)localObject4).getComponentProvider().a(4);
          if (!"".equals(((SwiftBrowserShareMenuHandler)localObject4).p)) {
            localObject4 = ((SwiftBrowserShareMenuHandler)localObject4).p;
          } else {
            localObject4 = ((SwiftBrowserShareMenuHandler)localObject4).n;
          }
          break label2117;
        }
      }
      localObject4 = "";
      if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(paramString3))
      {
        localObject3 = HardCodeUtil.a(2131911289);
        if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().q())) {
          paramBitmap = "https://docs.qq.com/desktop/m/index.html?_wv=2";
        } else {
          paramBitmap = TencentDocConvertConfigProcessor.a().q();
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
      localObject8 = this.z;
      if (localObject1 == null) {
        localObject1 = "";
      }
      localObject9 = ((Activity)localObject8).getString(2131894173, new Object[] { localObject1 });
      if (this.aa == null) {
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
    ReportCenter.a().a(paramString1, paramBitmap, this.G.getAccount(), false);
    return;
    if ((paramInt != 3) && (paramInt != 4))
    {
      if (paramInt == 5)
      {
        if ((this.v != -1) && (!TextUtils.isEmpty(this.s)))
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
          paramBitmap.putString("cover_url", this.s);
          paramBitmap.putString("source_name", this.t);
          paramBitmap.putInt("article_id", this.v);
          paramString1 = new ArrayList(1);
          paramString1.add(paramString4);
          paramBitmap.putStringArrayList("image_url", paramString1);
          paramBitmap.putLong("req_share_id", 0L);
          if (this.z == null) {
            this.z = this.y;
          }
          if (((IReadInJoyShareManager)QRoute.api(IReadInJoyShareManager.class)).jumpToReadInJoyShare(this.z, paramBitmap, null, 0)) {
            break label4064;
          }
          QRUtils.a(1, 2131886094);
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X8006277", "0X8006277", 0, 0, "", "", "", "");
        QLog.w(a, 1, "onGetSummary invalid shareInfo");
        return;
      }
      if ((paramInt != 6) && (paramInt != 7)) {
        if (paramInt == 8)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "shareMsgToSina start!");
          }
          paramBitmap = BaseApplicationImpl.getContext().getPackageManager();
        }
      }
    }
    try
    {
      paramBitmap = paramBitmap.getApplicationInfo("com.sina.weibo", 8192);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "shareMsgToSina installSinaWeibo:true");
      }
    }
    catch (PackageManager.NameNotFoundException paramString2)
    {
      break label2895;
    }
    try
    {
      ThreadManager.executeOnSubThread(new Share.4(this, paramString4, paramString1, paramString2, paramString3, paramBitmap));
    }
    catch (PackageManager.NameNotFoundException paramString2)
    {
      break label2892;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "shareMsgToSina installSinaWeibo:false");
    }
    try
    {
      paramString1 = URLEncoder.encode(paramString1, "UTF-8");
      paramString2 = new StringBuilder();
      paramString2.append("https://service.weibo.com/share/share.php?");
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
      paramString2 = new Intent(this.y, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      this.y.startActivity(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "shareMsgToSina start webview!");
      }
    }
    catch (Exception paramString1)
    {
      Toast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131911290), 1).show();
      paramString1.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      QLog.d(a, 2, "shareMsgToSina end!");
      return;
      if (paramInt == 9)
      {
        paramString2 = ((AppActivity)this.y).getAppRuntime();
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isKandianFavourite(this.y, paramString3, paramInt))
        {
          paramString1 = ((IFastModule)QRoute.api(IFastModule.class)).getFastWebArticleInfo(this.ad);
          paramString3 = new Bundle();
          if (paramString1 != null)
          {
            paramString3.putLong("publishAccountUin", paramString1.y);
            paramString3.putString("publishAccountName", paramString1.l);
          }
          ((IReadInJoyAtlasManager)QRoute.api(IReadInJoyAtlasManager.class)).doFavorite(this.y, null, 1, this.ad, this.e, this.h, this.i, this.ac, paramString3);
        }
        else
        {
          paramString1 = this.y;
          if ((paramString1 instanceof SwiftWebViewFragmentSupporter))
          {
            paramString1 = ((SwiftWebViewFragmentSupporter)paramString1).getCurrentWebViewFragment();
            if (paramString1 != null)
            {
              paramString1 = (SwiftBrowserShareMenuHandler)paramString1.getComponentProvider().a(4);
              if (TextUtils.isEmpty(paramString1.p)) {
                paramString1 = paramString1.n;
              } else {
                paramString1 = paramString1.p;
              }
              break label3373;
            }
          }
          paramString1 = "";
          paramString3 = this.y;
          if ((paramString3 instanceof IPublicAccountBrowser)) {
            paramString1 = ((IPublicAccountBrowser)paramString3).getPubUin();
          }
          ThreadManager.getUIHandler().post(new Share.5(this, paramString1));
        }
        QfavReport.a(paramString2, 42, 2);
        return;
        QidianManager.a(this.y, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
        return;
        paramString4 = paramString3;
        i2 = 1;
        if (paramInt == 3) {
          this.ag = 1;
        } else {
          this.ag = 2;
        }
        if (this.I == null)
        {
          this.I = new Share.3(this, paramString4);
          WXShareHelper.a().a(this.I);
        }
        this.J = String.valueOf(System.currentTimeMillis());
        if ((!TextUtils.isEmpty(this.f)) && (TeamWorkUtils.h.containsKey(this.f)))
        {
          localObject1 = (Integer)TeamWorkUtils.h.get(this.f);
          if (localObject1 != null)
          {
            i1 = ((Integer)localObject1).intValue();
            break label3608;
          }
        }
        else if (((paramString4 == null) || (!paramString4.contains("doc/"))) && (paramString4 != null) && (paramString4.contains("sheet/")))
        {
          i1 = 2;
          break label3608;
        }
        i1 = 1;
        if ((paramString4 != null) && (paramString4.contains("docs.qq.com/")))
        {
          if (paramInt == 3)
          {
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "shareMsgToWeChat! ~~~ SUMMARY_FOR_SEND_TO_WECHAT!");
            }
            WXShareHelper.a().a(this.I);
            if ((a() != null) && (a().q != null))
            {
              paramString1 = new StringBuilder();
              paramString1.append("pages/detail/detail?scene=");
              paramString1.append(a().q);
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
              paramString1 = a;
              paramString4 = new StringBuilder();
              paramString4.append("curFilePath=");
              paramString4.append(paramString2);
              QLog.d(paramString1, 2, paramString4.toString());
            }
            paramString1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getShareBitMapBase64(this.g);
            if ((!TextUtils.isEmpty(this.g)) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isBase64ImgFormatData(this.g)))
            {
              if (paramString1 == null) {
                paramString1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(i1);
              }
            }
            else {
              paramString1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(i1);
            }
            if (paramString1 != null) {
              WXShareHelper.a().a(paramString2, "gh_252c5f06840b", paramString1, this.e, this.h, paramString3);
            }
          }
          else if (paramInt == 4)
          {
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "shareMsgToWeChat_Circle!~~~ SUMMARY_FOR_SEND_TO_WECHAT_CIRCLE!");
            }
            WXShareHelper.a().a(this.I);
            paramString1 = WXShareHelper.a();
            paramString2 = this.J;
            paramBitmap = this.e;
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
          localObject3 = this.J;
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
    Bundle localBundle = QQCustomArkDialog.AppInfo.a(paramString3, paramString4, "0.0.0.1", paramString6, this.R.getResources().getDisplayMetrics().scaledDensity, null, null);
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
      QLog.d(a, 2, new Object[] { "ShareArkFromH5 buildArkShareIntent bundle = ", localBundle.toString() });
    }
    paramIntent.putExtras(localBundle);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString1, long paramLong1, String paramString2, long paramLong2, long paramLong3, OpensdkBusinessObserver paramOpensdkBusinessObserver, String paramString3, long paramLong4, boolean paramBoolean)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("8.8.17");
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
    localGetAppinfoRequest.qqv.set("8.8.17");
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
    localGetAppinfoRequest.qqv.set("8.8.17");
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
  
  private boolean b(Intent paramIntent)
  {
    Bundle localBundle = this.y.getIntent().getExtras();
    String str1 = localBundle.getString("forward_ark_app_name");
    String str2 = localBundle.getString("forward_ark_app_view");
    if ((this.ae) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      String str3 = a(getShareUrl(), this.d, this.c);
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
    try
    {
      boolean bool = "1".equals(Uri.parse(paramString).getQueryParameter("not_short"));
      return true ^ bool;
    }
    catch (Throwable paramString)
    {
      QLog.d(a, 1, paramString, new Object[0]);
    }
    return true;
  }
  
  private void c(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = new HashMap();
    if ((paramInt == 1) && (b(paramString)))
    {
      if (((paramString.length() > 180) || ((!(this.y instanceof IPublicAccountBrowser)) && (paramString.length() > 60))) && (!(this.y instanceof TeamWorkDocEditBrowserActivity)) && (!((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(paramString))) {
        ((HashMap)localObject2).put("url", paramString);
      }
      localObject1 = this.i;
      if ((localObject1 != null) && (((String)localObject1).length() > 40)) {
        ((HashMap)localObject2).put("thumb", this.i);
      }
    }
    Object localObject1 = this.x;
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
    if (((this.p) || (((HashMap)localObject2).size() > 0) || (bool)) && (paramInt != 2) && (paramInt != 9))
    {
      ThreadManager.executeOnNetWorkThread(new Share.2(this, (HashMap)localObject2, paramInt, paramString, bool));
      return;
    }
    localObject2 = this.B;
    if ((localObject2 != null) && (((QQProgressDialog)localObject2).isShowing())) {
      this.B.dismiss();
    }
    localObject2 = this.e;
    String str1 = this.h;
    String str2 = this.i;
    if (!paramBoolean) {
      localObject1 = null;
    }
    a(paramInt, (String)localObject2, str1, paramString, str2, (Bitmap)localObject1);
  }
  
  private boolean c(Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        String str2 = a(getShareUrl(), this.d, this.c);
        Object localObject = d(str2);
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
        ArkAppCenter.a(a, String.format("shareArkFromUrl, parse json failed, err=%s", new Object[] { paramIntent.getMessage() }));
      }
      return false;
      label223:
      String str1 = "{}";
    }
  }
  
  private boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("app")) && (paramString.contains("view"));
  }
  
  private HashMap<String, String> d(String paramString)
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
      ArkAppCenter.a(a, String.format("getArkInfo, parse param failed, err=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  public SharePolicyInfo a()
  {
    return this.aa;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (this.A != null) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("fontSize", paramInt1);
      ((JSONObject)localObject).put("fontScale", paramInt2);
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQWebviewSetFontSize: ");
        localStringBuilder.append(((JSONObject)localObject).toString());
        QLog.d(str, 2, localStringBuilder.toString());
      }
      localObject = WebViewPlugin.toJsScript("QQWebviewSetFontSize", (JSONObject)localObject, null);
      this.A.callJs((String)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      label101:
      break label101;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "QQWebviewSetFontSize jason error");
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
        this.A.callJs((String)localObject);
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
      QLog.d(a, 2, "share finished jason error");
    }
    if ((paramInt3 == 1) && ((paramInt2 == 0) || (paramInt2 == 1)) && (this.aa != null)) {
      ThreadManager.excute(new Share.10(this), 128, null, false);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.V != null)
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
        QLog.e(a, 1, "notifyOnShareQQSpecifiedFriend process data error!", paramString1);
      }
      this.A.callJs(this.V, new String[] { localJSONObject.toString() });
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.z = paramActivity;
  }
  
  /* Error */
  protected void a(Context paramContext, GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 1406	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:has	()Z
    //   4: ifeq +543 -> 547
    //   7: aload_2
    //   8: getfield 1410	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11: invokevirtual 1414	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   14: ifne +533 -> 547
    //   17: aload_0
    //   18: aload_2
    //   19: putfield 159	com/tencent/biz/webviewplugin/Share:F	Lcom/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse;
    //   22: aload_0
    //   23: getfield 159	com/tencent/biz/webviewplugin/Share:F	Lcom/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse;
    //   26: getfield 1418	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:iconsURL	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   29: bipush 64
    //   31: invokestatic 1420	com/tencent/biz/webviewplugin/Share:a	(Lcom/tencent/mobileqq/pb/PBRepeatMessageField;I)Ljava/lang/String;
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 159	com/tencent/biz/webviewplugin/Share:F	Lcom/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse;
    //   39: getfield 1424	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:androidInfo	Lcom/tencent/protofile/getappinfo/GetAppInfoProto$AndroidInfo;
    //   42: astore 6
    //   44: aload_2
    //   45: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: istore_3
    //   49: iload_3
    //   50: ifne +424 -> 474
    //   53: aload 6
    //   55: ifnull +419 -> 474
    //   58: aload 6
    //   60: getfield 1429	com/tencent/protofile/getappinfo/GetAppInfoProto$AndroidInfo:packName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   63: ifnonnull +6 -> 69
    //   66: goto +408 -> 474
    //   69: aload_1
    //   70: aload_2
    //   71: ldc_w 1431
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokestatic 1437	com/tencent/biz/common/util/HttpUtil:openUrlForByte	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   79: astore 5
    //   81: aload 5
    //   83: ifnonnull +58 -> 141
    //   86: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +476 -> 565
    //   92: getstatic 207	com/tencent/biz/webviewplugin/Share:a	Ljava/lang/String;
    //   95: astore_1
    //   96: new 283	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   103: astore 4
    //   105: aload 4
    //   107: ldc_w 1439
    //   110: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 4
    //   116: aload_2
    //   117: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 4
    //   123: ldc_w 1441
    //   126: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_1
    //   131: iconst_2
    //   132: aload 4
    //   134: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: return
    //   141: aload_0
    //   142: getfield 199	com/tencent/biz/webviewplugin/Share:ai	Landroid/os/Handler;
    //   145: sipush 1002
    //   148: invokevirtual 1447	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   151: astore 4
    //   153: aload 5
    //   155: iconst_0
    //   156: aload 5
    //   158: arraylength
    //   159: invokestatic 1453	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   162: astore_2
    //   163: aload 4
    //   165: aload_2
    //   166: putfield 1459	android/os/Message:obj	Ljava/lang/Object;
    //   169: aload_0
    //   170: getfield 199	com/tencent/biz/webviewplugin/Share:ai	Landroid/os/Handler;
    //   173: aload 4
    //   175: invokevirtual 1463	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   178: pop
    //   179: aload_2
    //   180: astore 4
    //   182: goto +27 -> 209
    //   185: aconst_null
    //   186: astore_2
    //   187: aload_2
    //   188: astore 4
    //   190: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +16 -> 209
    //   196: getstatic 207	com/tencent/biz/webviewplugin/Share:a	Ljava/lang/String;
    //   199: iconst_2
    //   200: ldc_w 1465
    //   203: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_2
    //   207: astore 4
    //   209: aload_1
    //   210: aload 6
    //   212: getfield 1429	com/tencent/protofile/getappinfo/GetAppInfoProto$AndroidInfo:packName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   215: invokevirtual 381	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   218: invokestatic 1470	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   221: ifeq +47 -> 268
    //   224: aload_0
    //   225: getfield 199	com/tencent/biz/webviewplugin/Share:ai	Landroid/os/Handler;
    //   228: sipush 1001
    //   231: invokevirtual 1447	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   234: astore_1
    //   235: aload_1
    //   236: aload 4
    //   238: putfield 1459	android/os/Message:obj	Ljava/lang/Object;
    //   241: aload_0
    //   242: getfield 199	com/tencent/biz/webviewplugin/Share:ai	Landroid/os/Handler;
    //   245: aload_1
    //   246: invokevirtual 1463	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   249: pop
    //   250: return
    //   251: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +293 -> 547
    //   257: getstatic 207	com/tencent/biz/webviewplugin/Share:a	Ljava/lang/String;
    //   260: iconst_2
    //   261: ldc_w 1465
    //   264: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: return
    //   268: aload_1
    //   269: ldc_w 1472
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_0
    //   279: getfield 157	com/tencent/biz/webviewplugin/Share:E	J
    //   282: invokestatic 1477	com/tencent/mobileqq/utils/AppShareIDUtil:d	(J)J
    //   285: invokestatic 1482	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   288: aastore
    //   289: invokestatic 709	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   292: ldc_w 1431
    //   295: aconst_null
    //   296: aconst_null
    //   297: invokestatic 1486	com/tencent/biz/common/util/HttpUtil:openUrl	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   300: astore_1
    //   301: aload_1
    //   302: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifeq +20 -> 325
    //   308: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +255 -> 566
    //   314: getstatic 207	com/tencent/biz/webviewplugin/Share:a	Ljava/lang/String;
    //   317: iconst_2
    //   318: ldc_w 1488
    //   321: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: return
    //   325: new 1318	org/json/JSONObject
    //   328: dup
    //   329: aload_1
    //   330: invokespecial 1490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   333: astore_1
    //   334: aload_1
    //   335: ldc_w 1492
    //   338: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   341: ifeq +20 -> 361
    //   344: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +220 -> 567
    //   350: getstatic 207	com/tencent/biz/webviewplugin/Share:a	Ljava/lang/String;
    //   353: iconst_2
    //   354: ldc_w 1495
    //   357: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: return
    //   361: aload_1
    //   362: ldc_w 1349
    //   365: invokevirtual 1499	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   368: astore_1
    //   369: aload_1
    //   370: ifnull +177 -> 547
    //   373: aload_1
    //   374: ldc_w 1501
    //   377: invokevirtual 1499	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   380: astore_1
    //   381: aload_1
    //   382: ifnull +165 -> 547
    //   385: aload_1
    //   386: ldc_w 1132
    //   389: invokevirtual 1499	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   392: astore_1
    //   393: aload_1
    //   394: ifnull +153 -> 547
    //   397: aload_1
    //   398: ldc_w 1503
    //   401: invokevirtual 1504	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   404: astore_2
    //   405: aload_1
    //   406: ldc_w 1506
    //   409: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   412: iconst_1
    //   413: if_icmpne +134 -> 547
    //   416: aload_2
    //   417: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   420: ifne +127 -> 547
    //   423: aload_0
    //   424: getfield 199	com/tencent/biz/webviewplugin/Share:ai	Landroid/os/Handler;
    //   427: sipush 1001
    //   430: invokevirtual 1447	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   433: astore_1
    //   434: aload_1
    //   435: aload 5
    //   437: iconst_0
    //   438: aload 5
    //   440: arraylength
    //   441: invokestatic 1453	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   444: putfield 1459	android/os/Message:obj	Ljava/lang/Object;
    //   447: aload_0
    //   448: getfield 199	com/tencent/biz/webviewplugin/Share:ai	Landroid/os/Handler;
    //   451: aload_1
    //   452: invokevirtual 1463	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   455: pop
    //   456: return
    //   457: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +87 -> 547
    //   463: getstatic 207	com/tencent/biz/webviewplugin/Share:a	Ljava/lang/String;
    //   466: iconst_2
    //   467: ldc_w 1465
    //   470: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: return
    //   474: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +51 -> 528
    //   480: getstatic 207	com/tencent/biz/webviewplugin/Share:a	Ljava/lang/String;
    //   483: astore_1
    //   484: new 283	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   491: astore 4
    //   493: aload 4
    //   495: ldc_w 1439
    //   498: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 4
    //   504: aload_2
    //   505: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 4
    //   511: ldc_w 1508
    //   514: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload_1
    //   519: iconst_2
    //   520: aload 4
    //   522: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: return
    //   529: astore_1
    //   530: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq +14 -> 547
    //   536: getstatic 207	com/tencent/biz/webviewplugin/Share:a	Ljava/lang/String;
    //   539: iconst_2
    //   540: aload_1
    //   541: invokevirtual 1298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   544: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    this.T = paramAPICallback;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      this.ac = paramAbsBaseArticleInfo.mArticleContentUrl;
      this.ad = paramAbsBaseArticleInfo.innerUniqueID;
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, new Object[] { "shareUrl = ", this.ac, " , rowKey = ", this.ad });
      }
    }
    else
    {
      QLog.d(a, 1, "setReadInJoyShareData but articleInfo is null.");
    }
  }
  
  public void a(SharePolicyInfo paramSharePolicyInfo)
  {
    this.aa = paramSharePolicyInfo;
  }
  
  public void a(WebUiBaseInterface paramWebUiBaseInterface)
  {
    if (paramWebUiBaseInterface == null) {
      return;
    }
    if (this.af == null) {
      this.af = new WeakReference(paramWebUiBaseInterface);
    }
    paramWebUiBaseInterface = (WebUiBaseInterface)this.af.get();
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject;
    if ((paramWebUiBaseInterface != null) && ((paramWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)))
    {
      this.A = ((WebUiUtils.WebUiMethodInterface)paramWebUiBaseInterface).getWebView();
      if (QLog.isColorLevel())
      {
        paramWebUiBaseInterface = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" Share secret webview is null?");
        if (this.A != null) {
          bool1 = false;
        }
        ((StringBuilder)localObject).append(bool1);
        QLog.d(paramWebUiBaseInterface, 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = a;
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
    this.R = this.y.getApplicationContext();
    b();
  }
  
  public void a(String paramString)
  {
    this.S = paramString;
  }
  
  public boolean a(Intent paramIntent)
  {
    boolean bool3 = b(paramIntent);
    boolean bool2 = c(paramIntent);
    paramIntent = a;
    boolean bool1 = false;
    QLog.d(paramIntent, 1, new Object[] { "ShareArkFromH5 shouldShareArkMsgToQQ bShareArkOpenApp=", Boolean.valueOf(bool3), ", bShareArkFromNormal=", Boolean.valueOf(bool2), " ,isShareArk=", Boolean.valueOf(this.ae) });
    if (((this.ae) && (bool3)) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131886089);
      return false;
    }
    Object localObject;
    if (this.r.a)
    {
      this.r.c = ReportDef.RepUtil.b(paramInt);
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "90");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      int i1;
      if (this.r.b == 0) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      localStringBuilder.append(i1);
      ((Bundle)localObject).putString("intext_1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.r.c);
      ((Bundle)localObject).putString("intext_3", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.r.b);
      ((Bundle)localObject).putString("intext_2", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString);
      ((Bundle)localObject).putString("stringext_1", localStringBuilder.toString());
      ReportCenter.a().a((Bundle)localObject, "", this.G.getAccount(), false);
      this.r.a = false;
    }
    if (!NetworkUtil.isNetSupport(this.y))
    {
      if (QLog.isColorLevel())
      {
        paramString = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSummary Fail_Network. title=");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(", desc=");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(", thumb=");
        ((StringBuilder)localObject).append(this.i);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
      QRUtils.a(1, 2131892104);
      paramString = new Bundle();
      paramString.putString("report_type", "102");
      paramString.putString("act_type", "84");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(ReportDef.RepUtil.a(1));
      paramString.putString("intext_1", ((StringBuilder)localObject).toString());
      paramString.putString("intext_3", "1");
      paramString.putString("intext_4", "0");
      ReportCenter.a().a(paramString, "", this.G.getAccount(), false);
      return false;
    }
    ab = false;
    if (Pattern.compile("http(s)?://([a-zA-Z])*\\.mp\\.qq\\.com/((kan/(article|show|album))|(group/show))(\\.)*").matcher(paramString).find()) {
      ab = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url is ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("share_tool_trace", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readInjoy JS work=");
      ((StringBuilder)localObject).append(ab);
      QLog.d("share_tool_trace", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(this.e)) && (this.e.length() > 30)) {
      this.e = this.e.substring(0, 29);
    }
    if (!TextUtils.isEmpty(this.h))
    {
      localObject = this.h;
      if ((localObject != null) && (((String)localObject).length() > 40)) {
        this.h = this.h.substring(0, 39);
      }
    }
    if ((!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.h)))
    {
      c(paramString, paramInt, paramBoolean);
      return true;
    }
    u().c(2131886090);
    boolean bool = TextUtils.isEmpty(this.ad);
    if ((!this.B.isShowing()) && (bool)) {
      this.B.show();
    }
    ThreadManager.executeOnNetWorkThread(new Share.1(this, paramString, paramInt, paramBoolean));
    return true;
  }
  
  void b()
  {
    this.E = this.y.getIntent().getLongExtra("appShareID", 146L);
    if (this.E > 0L)
    {
      this.D = ((ImageView)this.y.findViewById(2131436693));
      Object localObject1 = this.D;
      if (localObject1 == null) {
        return;
      }
      ((ImageView)localObject1).setOnClickListener(this);
      this.C = this.y.findViewById(2131436694);
      this.C.setOnClickListener(this);
      a(this.G, this.y, this.H, AppShareIDUtil.d(this.E), 0L, this.ah);
      this.L = new LinearLayout(this.R);
      this.L.setBackgroundColor(this.R.getResources().getColor(2131165497));
      this.L.setOrientation(0);
      this.L.setVisibility(8);
      this.N = new ImageView(this.R);
      this.N.setImageResource(2130843058);
      localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.R, 19.0F), (int)UITools.a(this.R, 19.0F));
      this.M = new LinearLayout(this.R);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      this.M.setPadding((int)UITools.a(this.R, 10.0F), 0, (int)UITools.a(this.R, 10.0F), 0);
      this.M.setOnClickListener(this);
      this.M.addView(this.N, (ViewGroup.LayoutParams)localObject1);
      this.L.addView(this.M, (ViewGroup.LayoutParams)localObject2);
      this.O = new ImageView(this.R);
      this.O.setImageResource(2130841138);
      localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.R, 30.0F), (int)UITools.a(this.R, 30.0F));
      this.L.addView(this.O, (ViewGroup.LayoutParams)localObject1);
      this.P = new TextView(this.R);
      this.P.setPadding((int)UITools.a(this.R, 8.0F), 0, (int)UITools.a(this.R, 8.0F), 0);
      this.P.setSingleLine(true);
      this.P.setEllipsize(TextUtils.TruncateAt.END);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
      this.P.setText(2131886910);
      this.P.setTextSize(2, 13.75F);
      this.P.setGravity(16);
      this.P.setTextColor(this.R.getResources().getColor(2131165498));
      this.L.addView(this.P, (ViewGroup.LayoutParams)localObject1);
      this.Q = new TextView(this.R);
      this.Q.setTextSize(2, 14.75F);
      this.Q.setOnClickListener(this);
      this.Q.setBackgroundResource(2130842840);
      this.Q.setGravity(17);
      this.Q.setTextColor(this.R.getResources().getColor(2131165498));
      localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.R, 56.0F), (int)UITools.a(this.R, 30.0F));
      ((LinearLayout.LayoutParams)localObject1).rightMargin = ((int)UITools.a(this.R, 10.0F));
      this.L.addView(this.Q, (ViewGroup.LayoutParams)localObject1);
      this.L.setGravity(16);
      localObject1 = new FrameLayout.LayoutParams(-1, (int)UITools.a(this.R, 44.0F));
      ((FrameLayout.LayoutParams)localObject1).gravity = 80;
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = ((int)UITools.a(this.R, 50.0F));
      localObject2 = this.y;
      if ((localObject2 instanceof SwiftWebViewFragmentSupporter))
      {
        localObject2 = ((SwiftWebViewFragmentSupporter)localObject2).getCurrentWebViewFragment();
        if ((localObject2 != null) && (((WebViewFragment)localObject2).getUIStyleHandler().y != null)) {
          ((WebViewFragment)localObject2).getUIStyleHandler().y.addView(this.L, (ViewGroup.LayoutParams)localObject1);
        }
      }
    }
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean)
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
    u().show();
    CustomWebView localCustomWebView = this.A;
    if (localCustomWebView != null)
    {
      localCustomWebView.callJs(this.S, new String[] { paramString });
      return;
    }
    QLog.w(a, 1, "notifyOnShare webview is null");
  }
  
  public boolean c()
  {
    if (this.z == null) {
      if (this.y.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.z = ((PluginBaseActivity)this.y).getOutActivity();
      } else {
        this.z = this.y;
      }
    }
    QZoneShareData localQZoneShareData = new QZoneShareData();
    if (TextUtils.isEmpty(this.e)) {
      localObject = null;
    } else {
      localObject = this.e;
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
    int i1 = this.w;
    if (i1 != -1) {
      localQZoneShareData.iUrlInfoFrm = i1;
    }
    localQZoneShareData.mShareBeginTime = SwiftBrowserShareMenuHandler.x;
    localQZoneShareData.from = 2;
    localObject = this.A;
    if (localObject != null) {
      localQZoneShareData.mWebUrl = ((CustomWebView)localObject).getUrl();
    }
    localObject = this.G;
    if (localObject != null)
    {
      QZoneShareManager.shareToQzone(this.z, ((AppRuntime)localObject).getCurrentAccountUin(), localQZoneShareData, null, -1);
      return true;
    }
    QRUtils.a(1, 2131886094);
    return true;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public void destroy()
  {
    Handler localHandler = this.ai;
    if (localHandler != null)
    {
      localHandler.removeMessages(1001);
      this.ai.removeMessages(1002);
    }
    if (this.I != null)
    {
      WXShareHelper.a().b(this.I);
      this.I = null;
    }
  }
  
  public String e()
  {
    return this.h;
  }
  
  public String f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.s;
  }
  
  public <T> T getShare()
  {
    return this;
  }
  
  public String getShareUrl()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.b))
    {
      localObject = this.b;
    }
    else
    {
      localObject = this.af;
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
  
  public String h()
  {
    return this.t;
  }
  
  public int i()
  {
    return this.v;
  }
  
  public boolean j()
  {
    return this.j;
  }
  
  public boolean k()
  {
    return this.l;
  }
  
  public int l()
  {
    return this.k;
  }
  
  public String m()
  {
    return this.m;
  }
  
  public void n()
  {
    String str = this.S;
    if (str != null) {
      this.A.callJs(str, new String[] { "7" });
    }
  }
  
  public void o()
  {
    String str = this.S;
    if (str != null) {
      this.A.callJs(str, new String[] { "8" });
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.F;
    if ((localObject != null) && (((GetAppInfoProto.GetAppinfoResponse)localObject).androidInfo != null))
    {
      localObject = this.F.androidInfo;
      Bundle localBundle;
      if ((paramView != this.D) && (paramView != this.C))
      {
        if (paramView == this.Q)
        {
          if (PackageUtil.a(this.y, ((GetAppInfoProto.AndroidInfo)localObject).packName.get()))
          {
            PackageUtil.a(this.y, ((GetAppInfoProto.AndroidInfo)localObject).packName.get(), null);
            OpenSdkStatic.a().a(this.H, String.valueOf(AppShareIDUtil.d(this.E)), "ANDROIDQQ.SHAREBAR", "203", false);
          }
          else
          {
            localBundle = new Bundle();
            localBundle.putString("uin", this.H);
            localBundle.putString("sid", this.y.getIntent().getStringExtra("vkey"));
            localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
            localBundle.putBoolean("autoDownload", true);
            localBundle.putString("packageName", ((GetAppInfoProto.AndroidInfo)localObject).packName.get());
            localBundle.putString("appId", String.valueOf(AppShareIDUtil.d(this.E)));
            AppClient.b(this.y, localBundle);
            OpenSdkStatic.a().a(this.H, String.valueOf(AppShareIDUtil.d(this.E)), "ANDROIDQQ.SHAREBAR", "202", false);
          }
          localObject = this.L;
          if (localObject != null) {
            ((LinearLayout)localObject).setVisibility(8);
          }
        }
        else if (paramView == this.M)
        {
          localObject = this.L;
          if (localObject != null) {
            ((LinearLayout)localObject).setVisibility(8);
          }
        }
      }
      else
      {
        if (PackageUtil.a(this.y, ((GetAppInfoProto.AndroidInfo)localObject).packName.get()))
        {
          PackageUtil.a(this.y, ((GetAppInfoProto.AndroidInfo)localObject).packName.get(), null);
          localObject = "run";
        }
        else
        {
          localBundle = new Bundle();
          localBundle.putString("uin", this.H);
          localBundle.putString("sid", this.y.getIntent().getStringExtra("vkey"));
          localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
          localBundle.putBoolean("autoDownload", true);
          localBundle.putString("packageName", ((GetAppInfoProto.AndroidInfo)localObject).packName.get());
          AppClient.a(this.y, String.valueOf(AppShareIDUtil.d(this.E)), 2470, localBundle);
          localObject = "setup";
        }
        Util.a(null, "", "webviewsourceclick", AppShareIDUtil.d(this.E), 0L, (String)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    String str = this.S;
    if (str != null) {
      this.A.callJs(str, new String[] { "9" });
    }
  }
  
  public void q()
  {
    String str = this.U;
    if (str != null) {
      this.A.callJs(str, new String[] { "0" });
    }
  }
  
  public void r()
  {
    String str = this.W;
    if (str != null) {
      this.A.callJs(str, new String[] { "1" });
    }
  }
  
  public void reset()
  {
    this.b = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.t = null;
    this.u = null;
    this.S = null;
    this.T = null;
    this.U = null;
    this.V = null;
    this.W = null;
    this.X = null;
    this.Y = null;
    this.j = false;
    this.k = -1;
    this.m = null;
  }
  
  public void s()
  {
    String str = this.X;
    if (str != null) {
      this.A.callJs(str, new String[] { "2" });
    }
  }
  
  public boolean setShareUrl(String paramString)
  {
    Object localObject = this.A;
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
          this.b = paramString;
          this.x = null;
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
    this.e = paramString1;
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
    this.p = true;
    if ((paramBundle != null) && (paramBundle.getInt("extra_url_info_from") == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Share info after JS capture: title=");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(", summary=");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(", thumb=");
        ((StringBuilder)localObject).append(this.i);
        ((StringBuilder)localObject).append(", shareURL=");
        ((StringBuilder)localObject).append(paramString3);
        QLog.e("shareWebPage", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.r;
      ((ReportDef.ShareStructMsg.Report9x)localObject).a = true;
      ((ReportDef.ShareStructMsg.Report9x)localObject).b = 0;
      if (TextUtils.isEmpty(paramString4))
      {
        paramString4 = this.r;
        paramString4.b |= 0x1;
      }
      else
      {
        this.q = 2;
      }
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = this.r;
        paramString2.b |= 0x2;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = this.r;
        paramString1.b |= 0x4;
      }
    }
    this.x = null;
    if (paramBundle != null) {}
    try
    {
      QLog.d(a, 1, "setSummary need parse extraData");
      this.f = paramBundle.getString("type");
      this.g = paramBundle.getString("miniprogram_image_url");
      this.w = paramBundle.getInt("extra_url_info_from", -1);
      this.s = paramBundle.getString("cover_url");
      this.t = paramBundle.getString("source_name");
      this.u = paramBundle.getString("source_icon");
      this.v = Integer.parseInt(paramBundle.getString("article_id"));
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
    QLog.w(a, 1, "setSummary extraData parse unknown exception");
    break label449;
    label434:
    QLog.w(a, 1, "setSummary extraData parse articleId exception");
    this.v = -1;
    label449:
    this.j = paramBundle.getBoolean("editable");
    this.l = paramBundle.getBoolean("isCreator");
    if (!this.o) {
      this.o = paramBundle.getBoolean("isNewCreate");
    }
    label540:
    try
    {
      this.m = paramBundle.getString("singleLineTitle");
    }
    catch (Exception paramString1)
    {
      label507:
      break label507;
    }
    this.m = null;
    QLog.w(a, 1, "setSummary extraData parse singleLineTitle exception");
    try
    {
      this.k = Integer.parseInt(paramBundle.getString("policy"));
    }
    catch (Exception paramString1)
    {
      break label540;
    }
    this.k = -1;
    this.n = paramBundle.getBoolean("contentEdited");
    paramString1 = this.y;
    if ((paramString1 != null) && ((paramString1 instanceof TeamWorkDocEditBrowserActivity)))
    {
      paramString1 = (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)((TeamWorkDocEditBrowserActivity)paramString1).getCurrentWebViewFragment();
      if (paramString1 != null)
      {
        paramString1.a(this.j, this.k);
        paramString1.a(this.o);
        paramString1.i();
        paramString1.a(true, this.m, null);
        if (this.n) {
          paramString1.d();
        }
      }
    }
    LocalMultiProcConfig.putString("msharetitle", this.e);
    LocalMultiProcConfig.putString("msharedesc", this.h);
    LocalMultiProcConfig.putString("msharethumb", this.i);
    LocalMultiProcConfig.putString("mshareurl", paramString3);
    LocalMultiProcConfig.putInt("msharefrom", this.w);
    paramString1 = this.A;
    if (paramString1 != null) {
      LocalMultiProcConfig.putString("msharecururl", paramString1.getUrl());
    }
    paramString1 = new Intent("com.tencent.qq.shareupdate");
    paramString2 = this.y;
    if (paramString2 != null) {
      paramString2.sendBroadcast(paramString1);
    }
    return true;
  }
  
  public boolean shareStructMsgForH5(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (!NetworkUtil.isNetSupport(this.y))
    {
      QRUtils.a(1, 2131892104);
      return false;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      QRUtils.a(1, 2131886089);
      return false;
    }
    int i1;
    if (this.B == null)
    {
      paramString7 = (WebUiBaseInterface)this.af.get();
      if ((paramString7 != null) && ((paramString7 instanceof WebUiUtils.WebViewProviderInterface))) {
        i1 = ((WebUiUtils.WebViewProviderInterface)paramString7).getWebTitleBarInterface().m();
      } else {
        i1 = 0;
      }
      this.B = new QQProgressDialog(this.y, i1);
      this.B.c(2131886090);
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
      String str = String.format(this.y.getResources().getString(2131894173), new Object[] { paramString2 });
      ShareMsgHelper.a(this.y, 1001, 146, "struct_msg_from_h5", paramString1, paramString5, paramString2, paramString3, str, paramString4, "web", null, null, null, "plugin", null, paramString7, paramString8, "https://url.cn/JS8oE7", paramString6, null);
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
      ReportCenter.a().a(paramString1, "", this.G.getAccount(), false);
      return true;
    }
    this.B.show();
    new Share.6(this, bool, paramString5, paramString1, paramString2, paramString3, paramString4, paramString6).start();
    return true;
  }
  
  public void t()
  {
    String str = this.Y;
    if (str != null) {
      this.A.callJs(str, new String[] { "3" });
    }
  }
  
  public QQProgressDialog u()
  {
    if (this.B == null)
    {
      Object localObject = this.af;
      if (localObject != null) {
        localObject = (WebUiBaseInterface)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      int i1;
      if ((localObject != null) && ((localObject instanceof WebUiUtils.WebViewProviderInterface)) && (!this.y.isFinishing()))
      {
        i1 = ((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface().m();
      }
      else
      {
        localObject = this.y;
        if (localObject != null)
        {
          i1 = ((Activity)localObject).getResources().getDimensionPixelSize(2131299920);
        }
        else
        {
          i1 = (int)(this.K * 50.0F + 0.5F);
          QLog.e(a, 1, "use default yOffset when getting share progress dialog.");
        }
      }
      this.B = new QQProgressDialog(this.y, i1);
      this.B.c(2131886090);
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dialog show time :");
        localStringBuilder.append(l1);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    return this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share
 * JD-Core Version:    0.7.0.1
 */