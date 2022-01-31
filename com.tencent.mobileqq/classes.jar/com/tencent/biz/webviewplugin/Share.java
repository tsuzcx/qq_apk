package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.MQLruCache;
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
import com.tencent.av.utils.UITools;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.open.agent.report.ReportDef.ShareStructMsg.Report9x;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.stat.MttLoader.BrowserInfo;
import cooperation.plugin.PluginBaseActivity;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.readinjoy.ReadInJoyShareManager;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import php;
import phs;
import phu;
import phv;
import phw;
import phy;
import pia;

public class Share
  implements View.OnClickListener, ReportDef
{
  public static String a;
  public static boolean f;
  public float a;
  protected int a;
  public long a;
  public Activity a;
  public Context a;
  protected Handler a;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public CustomWebView a;
  public AppInterface a;
  public SharePolicyInfo a;
  public QQProgressDialog a;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  ReportDef.ShareStructMsg.Report9x jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x = new ReportDef.ShareStructMsg.Report9x();
  public GetAppInfoProto.GetAppinfoResponse a;
  public SoftReference a;
  public WeakReference a;
  protected BusinessObserver a;
  protected boolean a;
  public int b;
  Activity b;
  protected ImageView b;
  protected LinearLayout b;
  public TextView b;
  public String b;
  protected boolean b;
  protected int c;
  public ImageView c;
  public String c;
  protected boolean c;
  public int d;
  public String d;
  protected boolean d;
  public volatile int e;
  protected String e;
  public boolean e;
  protected String f;
  public String g;
  public String h;
  protected String i;
  protected String j;
  protected String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  protected String t = "";
  protected String u = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "share";
  }
  
  public Share(AppInterface paramAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new phy(this);
    this.jdField_a_of_type_AndroidOsHandler = new pia(this);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Share secret init share");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.l = paramAppInterface.getAccount();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Float = paramActivity.getResources().getDisplayMetrics().density;
    if ((paramActivity instanceof WebUiBaseInterface)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((WebUiBaseInterface)paramActivity);
    }
    while (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "Error! mWebUiUtils still null! " + paramActivity.toString());
      return;
      if ((paramActivity instanceof SwiftWebViewFragmentSupporter))
      {
        paramAppInterface = ((SwiftWebViewFragmentSupporter)paramActivity).b();
        if (paramAppInterface != null)
        {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
        }
        else if ((paramActivity instanceof QQBrowserActivity))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "Caution! mWebUiUtils == null! maybe webviewfragment is invisible!");
          paramAppInterface = (QQBrowserActivity)paramActivity;
          localObject = paramAppInterface.getSupportFragmentManager();
          if (localObject != null)
          {
            localObject = ((FragmentManager)localObject).getFragments();
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              int i1 = paramAppInterface.jdField_d_of_type_Int;
              if ((i1 >= 0) && (i1 < ((List)localObject).size())) {}
              for (;;)
              {
                QLog.w(jdField_a_of_type_JavaLangString, 2, "cast Fragment (index: " + i1 + ") to WebViewFragment");
                if (!(((List)localObject).get(i1) instanceof WebViewFragment)) {
                  break label383;
                }
                this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((WebViewFragment)((List)localObject).get(i1));
                break;
                i1 = 0;
              }
              label383:
              QLog.e(jdField_a_of_type_JavaLangString, 2, "cast Fragment (index: " + i1 + ") is null!");
            }
          }
        }
      }
    }
    paramAppInterface = (WebUiBaseInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramAppInterface != null) && ((paramAppInterface instanceof WebUiUtils.WebUiMethodInterface)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((WebUiUtils.WebUiMethodInterface)paramAppInterface).a();
      if (QLog.isColorLevel())
      {
        paramAppInterface = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder().append(" Share secret webview is null?");
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
          bool1 = true;
        }
        QLog.d(paramAppInterface, 2, bool1);
      }
    }
    while (!QLog.isColorLevel())
    {
      this.jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
      a();
      return;
    }
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append(" Share secret baseInterface is null?");
    if (paramAppInterface == null) {}
    for (;;)
    {
      QLog.d((String)localObject, 2, bool1);
      break;
      bool1 = false;
    }
  }
  
  public static final String a(PBRepeatMessageField paramPBRepeatMessageField, int paramInt)
  {
    List localList = null;
    Object localObject = localList;
    int i2;
    int i1;
    if (paramPBRepeatMessageField != null)
    {
      localObject = localList;
      if (!paramPBRepeatMessageField.isEmpty())
      {
        localList = paramPBRepeatMessageField.get();
        i2 = localList.size();
        i1 = 0;
        paramPBRepeatMessageField = null;
        if (i1 >= i2) {
          break label276;
        }
        localObject = (GetAppInfoProto.MsgIconsurl)localList.get(i1);
      }
    }
    label257:
    label264:
    label267:
    label273:
    label276:
    for (;;)
    {
      try
      {
        int i3 = Integer.valueOf(((GetAppInfoProto.MsgIconsurl)localObject).size.get()).intValue();
        if (i3 < paramInt) {
          break label273;
        }
        localObject = ((GetAppInfoProto.MsgIconsurl)localObject).url.get();
        paramPBRepeatMessageField = (PBRepeatMessageField)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramPBRepeatMessageField = (PBRepeatMessageField)localObject;
          localObject = paramPBRepeatMessageField;
          if (paramPBRepeatMessageField == null)
          {
            i1 = i2 - 1;
            if (i1 < 0) {
              break label267;
            }
            localObject = (GetAppInfoProto.MsgIconsurl)localList.get(i1);
          }
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          i2 = Integer.valueOf(((GetAppInfoProto.MsgIconsurl)localObject).size.get()).intValue();
          if (i2 >= paramInt) {
            break label264;
          }
          localObject = ((GetAppInfoProto.MsgIconsurl)localObject).url.get();
          paramPBRepeatMessageField = (PBRepeatMessageField)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label257;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity findAppIcon() iconUrl = " + (String)localObject);
          }
          return localObject;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          if (!QLog.isColorLevel()) {
            break label257;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, localNumberFormatException2.getMessage());
        }
        localNumberFormatException1 = localNumberFormatException1;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, localNumberFormatException1.getMessage());
        }
        i1 += 1;
      }
      for (;;)
      {
        i1 -= 1;
        break;
      }
      PBRepeatMessageField localPBRepeatMessageField = paramPBRepeatMessageField;
      continue;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetSummary. title=" + this.jdField_d_of_type_JavaLangString + ", desc=" + this.g + ", thumb=" + this.h + ", bitmap=" + paramBitmap);
    }
    Object localObject1;
    Object localObject2;
    int i2;
    if (this.jdField_b_of_type_AndroidAppActivity == null)
    {
      if (this.jdField_a_of_type_AndroidAppActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.jdField_b_of_type_AndroidAppActivity = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
    }
    else if ((paramInt != 2) && (paramInt != 1) && (paramInt != 3))
    {
      localObject1 = paramString2;
      if (paramInt != 4) {}
    }
    else
    {
      localObject2 = new Bundle();
      i2 = 0;
      if (TextUtils.isEmpty(paramString4)) {
        i2 = 1;
      }
      i1 = i2;
      localObject1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = this.jdField_c_of_type_JavaLangString;
        i1 = i2;
        localObject1 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          i1 = i2 | 0x2;
          localObject1 = paramString2;
        }
      }
      i2 = i1;
      if (TextUtils.isEmpty(paramString1)) {
        i2 = i1 | 0x4;
      }
      ((Bundle)localObject2).putString("report_type", "102");
      ((Bundle)localObject2).putString("act_type", "94");
      paramString2 = new StringBuilder().append("");
      if (i2 != 0) {
        break label633;
      }
    }
    label633:
    for (int i1 = 0;; i1 = 1)
    {
      ((Bundle)localObject2).putString("intext_1", i1);
      ((Bundle)localObject2).putString("intext_3", "" + ReportDef.RepUtil.b(paramInt));
      ((Bundle)localObject2).putString("intext_2", "" + i2);
      ((Bundle)localObject2).putString("stringext_1", paramString3);
      ReportCenter.a().a((Bundle)localObject2, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
      paramString2 = (String)localObject1;
      if (paramInt != 2) {
        break label639;
      }
      localObject1 = new Bundle();
      paramBitmap = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramBitmap = paramString3;
      }
      ((Bundle)localObject1).putString("title", paramBitmap);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString3;
      }
      ((Bundle)localObject1).putString("desc", paramString1);
      ((Bundle)localObject1).putString("detail_url", paramString3);
      paramString1 = new ArrayList(1);
      paramString1.add(paramString4);
      ((Bundle)localObject1).putStringArrayList("image_url", paramString1);
      ((Bundle)localObject1).putLong("req_share_id", 0L);
      if (this.jdField_d_of_type_Int != -1) {
        ((Bundle)localObject1).putInt("iUrlInfoFrm", this.jdField_d_of_type_Int);
      }
      ((Bundle)localObject1).putLong("share_begin_time", SwiftBrowserShareMenuHandler.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SwiftWebViewFragmentSupporter))
      {
        paramString1 = ((SwiftWebViewFragmentSupporter)this.jdField_a_of_type_AndroidAppActivity).b();
        ((Bundle)localObject1).putString("strurt_msgid", paramString1.j);
        ((Bundle)localObject1).putString("struct_uin", paramString1.i);
        ((Bundle)localObject1).putString("struct_url", paramString1.g);
        ((Bundle)localObject1).putBoolean("from_web", true);
        if ((paramString1.k != null) && (!"".equals(paramString1.k))) {
          ((Bundle)localObject1).putString("source_puin", paramString1.k);
        }
      }
      if (!QZoneShareManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_AndroidAppActivity, (Bundle)localObject1, null)) {
        QRUtils.a(1, 2131435496);
      }
      return;
      this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
      break;
    }
    label639:
    Intent localIntent;
    if (paramInt == 1)
    {
      localIntent = new Intent(this.jdField_b_of_type_AndroidAppActivity, ForwardRecentActivity.class);
      localIntent.putExtra("key_flag_from_plugin", true);
      localIntent.putExtra("isWebCompShare", true);
      i1 = 0;
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label3017;
      }
    }
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      Object localObject6;
      String str1;
      String str2;
      Object localObject3;
      label1041:
      long l1;
      try
      {
        localObject2 = Uri.parse(this.jdField_c_of_type_JavaLangString);
        localObject1 = ((Uri)localObject2).getHost();
        paramBitmap = null;
        if (((Uri)localObject2).isHierarchical()) {
          paramBitmap = ((Uri)localObject2).getQueryParameter("_pflag");
        }
        paramInt = i1;
        if (!TextUtils.isEmpty(paramBitmap)) {
          if (!"post.mp.qq.com".equalsIgnoreCase((String)localObject1))
          {
            paramInt = i1;
            if (!"url.cn".equalsIgnoreCase((String)localObject1)) {}
          }
          else
          {
            i2 = Integer.parseInt(paramBitmap);
            paramInt = i1;
            if ((i2 >> 4 & 0x1) == 1) {
              paramInt = 1;
            }
          }
        }
      }
      catch (Exception paramBitmap)
      {
        paramInt = 0;
        continue;
        paramBitmap = " ";
        localObject1 = null;
        localObject2 = null;
        localObject3 = "http://url.cn/PWkhNu";
        localObject4 = ((Resources)localObject7).getString(2131430118);
        continue;
        paramBitmap = "plugin";
        localObject1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { str4 });
        localObject2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { str4 });
        localObject3 = "http://url.cn/JS8oE7";
        continue;
        str2 = "";
        localObject4 = " ";
        localObject1 = null;
        localObject3 = null;
        localObject2 = null;
        str1 = "http://url.cn/UQoBHn";
        l1 = 801097412L;
        paramBitmap = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("source_name");
        localObject5 = paramBitmap;
        if (!TextUtils.isEmpty(paramBitmap)) {
          continue;
        }
        localObject5 = this.k;
        paramBitmap = (Bitmap)localObject5;
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          break label1438;
        }
        if (!jdField_f_of_type_Boolean) {
          break label1692;
        }
        localObject5 = "QQ看点";
        localObject6 = "https://q.url.cn/s/jBJuV";
        String str3 = "plugin";
        String str4 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
        Object localObject7 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
        paramBitmap = (Bitmap)localObject5;
        localObject2 = localObject6;
        localObject4 = str3;
        localObject1 = str4;
        localObject3 = localObject7;
        if (!QLog.isColorLevel()) {
          break label1438;
        }
        QLog.d("share_tool_trace", 2, "QQ kandian");
        localObject3 = localObject7;
        localObject1 = str4;
        localObject4 = str3;
        localObject2 = localObject6;
        paramBitmap = (Bitmap)localObject5;
      }
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof PublicAccountBrowser))
      {
        str4 = ((PublicAccountBrowser)this.jdField_a_of_type_AndroidAppActivity).a();
        localObject7 = this.jdField_a_of_type_AndroidAppActivity.getResources();
        localObject4 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("source_name");
        if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
          if (jdField_f_of_type_Boolean)
          {
            localObject5 = "QQ看点";
            localObject6 = "https://q.url.cn/s/jBJuV";
            str1 = "plugin";
            str2 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
            str3 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
            paramBitmap = str1;
            localObject1 = str2;
            localObject2 = str3;
            localObject3 = localObject6;
            localObject4 = localObject5;
            if (QLog.isColorLevel())
            {
              QLog.d("share_tool_trace", 2, "QQ kandian");
              localObject4 = localObject5;
              localObject3 = localObject6;
              localObject2 = str3;
              localObject1 = str2;
              paramBitmap = str1;
            }
            if (paramInt != 0)
            {
              localObject4 = this.jdField_b_of_type_AndroidAppActivity.getString(2131430131);
              localObject3 = "https://q.url.cn/s/jBJuV";
              paramBitmap = "plugin";
              localObject1 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
              localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
            }
            ShareMsgHelper.a(this.jdField_a_of_type_AndroidAppActivity, 1001, 1, "web_share", str4, paramString4, paramString1, paramString2, String.format(((Resources)localObject7).getString(2131430119), new Object[] { paramString1 }), paramString3, "web", null, null, null, paramBitmap, null, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, "", localIntent, -1, null, -1L);
            i1 = 0;
            if (TextUtils.isEmpty(paramString4)) {
              i1 = 1;
            }
            paramInt = i1;
            if (TextUtils.isEmpty(paramString2)) {
              paramInt = i1 | 0x2;
            }
            i1 = paramInt;
            if (TextUtils.isEmpty(paramString1)) {
              i1 = paramInt | 0x4;
            }
            paramString1 = new Bundle();
            paramString1.putString("report_type", "102");
            paramString1.putString("act_type", "14");
            paramString1.putString("intext_3", "1");
            paramString1.putString("intext_2", "" + i1);
            paramString1.putString("stringext_1", "" + paramString3);
            ReportCenter.a().a(paramString1, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
            return;
          }
        }
      }
      label1438:
      if (paramInt != 0)
      {
        localObject2 = this.jdField_b_of_type_AndroidAppActivity.getString(2131430131);
        paramBitmap = "plugin";
        localObject5 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
        localObject6 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
        localObject4 = "https://q.url.cn/s/jBJuV";
      }
      for (;;)
      {
        if ("QQ空间".equals(localObject2)) {}
        for (localObject3 = "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/logo_16.png";; localObject3 = localObject4)
        {
          localObject1 = str2;
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof SwiftWebViewFragmentSupporter))
          {
            localObject4 = ((SwiftWebViewFragmentSupporter)this.jdField_a_of_type_AndroidAppActivity).b();
            localObject1 = str2;
            if (localObject4 != null)
            {
              if ("".equals(((WebViewFragment)localObject4).k)) {
                break label1833;
              }
              localObject1 = ((WebViewFragment)localObject4).k;
            }
          }
          label1547:
          if (TeamWorkUtils.a(paramString3))
          {
            paramBitmap = "web";
            localObject2 = "腾讯文档";
            localObject4 = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("tim_convert_teamwork_pre_" + this.l, 0).getString("tim_myfile_teamwork_list_url", TeamWorkUtils.jdField_b_of_type_JavaLangString);
            localObject3 = TeamWorkUtils.jdField_c_of_type_JavaLangString;
            paramInt = 95;
            l1 = TeamWorkUtils.jdField_a_of_type_Long;
          }
          for (;;)
          {
            ShareMsgHelper.a(this.jdField_b_of_type_AndroidAppActivity, 1001, paramInt, "web_share", (String)localObject1, paramString4, paramString1, paramString2, this.jdField_b_of_type_AndroidAppActivity.getString(2131430119, new Object[] { paramString1 }), paramString3, "web", null, null, null, paramBitmap, null, (String)localObject5, (String)localObject6, (String)localObject3, (String)localObject2, "", localIntent, -1, (String)localObject4, l1);
            break label1041;
            label1692:
            localObject2 = this.jdField_b_of_type_AndroidAppActivity.getString(2131430118);
            paramBitmap = MttLoader.getBrowserInfo(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
            if ((paramBitmap != null) && (!TextUtils.isEmpty(paramBitmap.packageName))) {}
            for (paramBitmap = paramBitmap.packageName + "://" + paramString3;; paramBitmap = "com.tencent.mtt://" + paramString3)
            {
              localObject3 = "tencent100446242://" + paramString3;
              localObject1 = paramBitmap;
              paramBitmap = (Bitmap)localObject2;
              localObject2 = "http://url.cn/PWkhNu";
              localObject4 = "app";
              break;
            }
            label1833:
            localObject1 = ((WebViewFragment)localObject4).i;
            break label1547;
            if ((paramInt == 3) || (paramInt == 4)) {
              if (paramInt == 3)
              {
                this.jdField_e_of_type_Int = 1;
                label1863:
                if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new phu(this, paramString3);
                  WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
                }
                this.m = String.valueOf(System.currentTimeMillis());
                if ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (!"sheet".equals(this.jdField_e_of_type_JavaLangString))) {
                  break label2029;
                }
                i1 = 2;
              }
            }
            for (;;)
            {
              if (paramString3.contains("docs.qq.com/"))
              {
                if (paramInt == 3)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToWeChat! ~~~ SUMMARY_FOR_SEND_TO_WECHAT!");
                  }
                  WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
                  paramString1 = "pages/detail/detail?url=" + paramString3;
                  WXShareHelper.a().a(paramString1, "gh_252c5f06840b", a(i1), this.jdField_d_of_type_JavaLangString, this.g, paramString3);
                  return;
                  this.jdField_e_of_type_Int = 2;
                  break label1863;
                  label2029:
                  if (paramString3.contains("doc/"))
                  {
                    i1 = 1;
                    continue;
                  }
                  if (!paramString3.contains("sheet/")) {
                    break label2968;
                  }
                  i1 = 2;
                  continue;
                }
                if (paramInt != 4) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToWeChat_Circle!~~~ SUMMARY_FOR_SEND_TO_WECHAT_CIRCLE!");
                }
                WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
                paramString2 = WXShareHelper.a();
                paramString4 = this.m;
                paramBitmap = this.jdField_d_of_type_JavaLangString;
                localObject1 = a(i1);
                if (TextUtils.isEmpty(this.g))
                {
                  paramString1 = paramString3;
                  if (paramInt != 3) {
                    break label2161;
                  }
                }
                label2161:
                for (paramInt = 0;; paramInt = 1)
                {
                  paramString2.b(paramString4, paramBitmap, (Bitmap)localObject1, paramString1, paramString3, paramInt);
                  return;
                  paramString1 = this.g;
                  break;
                }
              }
              paramString4 = WXShareHelper.a();
              localObject1 = this.m;
              if (TextUtils.isEmpty(paramString2))
              {
                paramString2 = paramString3;
                if (paramInt != 3) {
                  break label2212;
                }
              }
              label2212:
              for (paramInt = 0;; paramInt = 1)
              {
                paramString4.b((String)localObject1, paramString1, paramBitmap, paramString2, paramString3, paramInt);
                return;
                break;
              }
              if (paramInt == 5)
              {
                if ((this.jdField_c_of_type_Int == -1) || (TextUtils.isEmpty(this.j)))
                {
                  ReportController.b(null, "CliOper", "", "", "0X8006277", "0X8006277", 0, 0, "", "", "", "");
                  QLog.w(jdField_a_of_type_JavaLangString, 1, "onGetSummary invalid shareInfo");
                  return;
                }
                localObject1 = new Bundle();
                paramBitmap = paramString1;
                if (TextUtils.isEmpty(paramString1)) {
                  paramBitmap = paramString3;
                }
                ((Bundle)localObject1).putString("title", paramBitmap);
                paramString1 = paramString2;
                if (TextUtils.isEmpty(paramString2)) {
                  paramString1 = paramString3;
                }
                ((Bundle)localObject1).putString("desc", paramString1);
                ((Bundle)localObject1).putString("detail_url", paramString3);
                ((Bundle)localObject1).putString("cover_url", this.j);
                ((Bundle)localObject1).putString("source_name", this.k);
                ((Bundle)localObject1).putInt("article_id", this.jdField_c_of_type_Int);
                paramString1 = new ArrayList(1);
                paramString1.add(paramString4);
                ((Bundle)localObject1).putStringArrayList("image_url", paramString1);
                ((Bundle)localObject1).putLong("req_share_id", 0L);
                if (this.jdField_b_of_type_AndroidAppActivity == null) {
                  this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
                }
                if (ReadInJoyShareManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_AndroidAppActivity, (Bundle)localObject1, null, 0)) {
                  break;
                }
                QRUtils.a(1, 2131435496);
                return;
              }
              if ((paramInt == 6) || (paramInt == 7))
              {
                QidianManager.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
                return;
              }
              if (paramInt == 8)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
                }
                paramString2 = BaseApplicationImpl.getContext().getPackageManager();
                try
                {
                  paramString2 = paramString2.getApplicationInfo("com.sina.weibo", 8192);
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:true");
                  }
                  ThreadManager.executeOnSubThread(new phv(this, paramString4, paramString1, paramString3, paramString2));
                }
                catch (PackageManager.NameNotFoundException paramString2)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
                    }
                    try
                    {
                      paramString1 = URLEncoder.encode(paramString1, "UTF-8");
                      paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
                      paramString2 = URLEncoder.encode(paramString3, "UTF-8");
                      paramString1 = paramString1 + "&url=" + paramString2;
                      paramString2 = URLEncoder.encode(paramString4, "UTF-8");
                      paramString1 = paramString1 + "&pic=" + paramString2;
                      paramString1 = paramString1 + "&_wv=3";
                      paramString2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                      paramString2.putExtra("url", paramString1);
                      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString2);
                      if (QLog.isColorLevel()) {
                        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
                      }
                    }
                    catch (Exception paramString1)
                    {
                      Toast.makeText(BaseApplicationImpl.getContext(), "分享失败！", 1).show();
                      paramString1.printStackTrace();
                    }
                  }
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
                return;
              }
              if (paramInt != 9) {
                break;
              }
              paramString2 = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
              if ((this.jdField_a_of_type_AndroidAppActivity instanceof FastWebActivity))
              {
                paramString3 = ReadInJoyLogicEngine.a().a();
                paramString1 = null;
                if (paramString3 != null) {
                  paramString1 = paramString3.a(this.u);
                }
                paramString3 = new Bundle();
                if (paramString1 != null)
                {
                  paramString3.putLong("publishAccountUin", paramString1.c);
                  paramString3.putString("publishAccountName", paramString1.jdField_e_of_type_JavaLangString);
                }
                ReadInJoyAtlasManager.a().a(this.jdField_a_of_type_AndroidAppActivity, null, 1, this.u, this.jdField_d_of_type_JavaLangString, this.g, this.h, this.t, paramString3);
              }
              for (;;)
              {
                QfavReport.a(paramString2, 42, 2);
                return;
                QfavBuilder.a(0, this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null, this.g, this.h, null, null, false, -1L).c(this.l).b(this.jdField_a_of_type_AndroidAppActivity, this.l, 2, null);
              }
              label2968:
              i1 = 1;
            }
            paramInt = 1;
            localObject4 = str1;
          }
        }
        localObject5 = localObject4;
        localObject4 = localObject2;
        localObject2 = paramBitmap;
        paramBitmap = (Bitmap)localObject5;
        localObject5 = localObject1;
        localObject6 = localObject3;
      }
      label3017:
      paramInt = 0;
    }
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString, long paramLong1, long paramLong2, BusinessObserver paramBusinessObserver)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("7.6.8");
    localGetAppinfoRequest.setHasFlag(true);
    paramContext = new NewIntent(paramContext, OpensdkServlet.class);
    paramContext.putExtra("uin", paramString);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    if (paramLong2 > 0L) {
      paramContext.putExtra("timeout", paramLong2);
    }
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString1, long paramLong1, String paramString2, long paramLong2, long paramLong3, BusinessObserver paramBusinessObserver)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("7.6.8");
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.md5time.set(paramLong3);
    localGetAppinfoRequest.signature.set(paramString2);
    localGetAppinfoRequest.channel_source.set(paramLong2);
    paramContext = new NewIntent(paramContext, OpensdkServlet.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    paramContext.putExtra("timeout", 15000L);
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString1, long paramLong1, String paramString2, long paramLong2, BusinessObserver paramBusinessObserver)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("7.6.8");
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.md5time.set(paramLong2);
    localGetAppinfoRequest.signature.set(paramString2);
    paramContext = new NewIntent(paramContext, OpensdkServlet.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    paramContext.putExtra("timeout", 15000L);
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString, long paramLong, BusinessObserver paramBusinessObserver)
  {
    a(paramAppInterface, paramContext, paramString, paramLong, 0L, paramBusinessObserver);
  }
  
  private void b(String paramString, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = new HashMap();
    if (paramInt == 1)
    {
      if (((paramString.length() > 180) || ((!(this.jdField_a_of_type_AndroidAppActivity instanceof PublicAccountBrowser)) && (paramString.length() > 60))) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof TeamWorkDocEditBrowserActivity)) && (!TeamWorkUtils.a(paramString))) {
        ((HashMap)localObject).put("url", paramString);
      }
      if ((this.h != null) && (this.h.length() > 40)) {
        ((HashMap)localObject).put("thumb", this.h);
      }
    }
    Bitmap localBitmap;
    if (this.jdField_a_of_type_JavaLangRefSoftReference == null)
    {
      localBitmap = null;
      if ((!paramBoolean) || ((paramInt != 3) && (paramInt != 4)) || (localBitmap != null) || (TextUtils.isEmpty(this.h))) {
        break label208;
      }
    }
    for (;;)
    {
      if (((!this.jdField_e_of_type_Boolean) && (((HashMap)localObject).size() <= 0) && (!bool)) || (paramInt == 2) || (paramInt == 9)) {
        break label214;
      }
      ThreadManager.executeOnNetWorkThread(new phs(this, (HashMap)localObject, paramInt, paramString, bool));
      return;
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      break;
      label208:
      bool = false;
    }
    label214:
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    localObject = this.jdField_d_of_type_JavaLangString;
    String str1 = this.g;
    String str2 = this.h;
    if (paramBoolean) {}
    for (;;)
    {
      a(paramInt, (String)localObject, str1, paramString, str2, localBitmap);
      return;
      localBitmap = null;
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Bitmap a(int paramInt)
  {
    String str;
    if (paramInt == 1)
    {
      paramInt = 2130845623;
      str = "static://DefaultTeamWorkShareDoc";
      if (BaseApplicationImpl.sImageCache == null) {
        break label91;
      }
    }
    label91:
    for (Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str);; localBitmap1 = null)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null)
      {
        localBitmap1 = BitmapManager.b(this.jdField_a_of_type_AndroidAppActivity.getResources(), paramInt);
        localBitmap2 = localBitmap1;
        if (localBitmap1 != null)
        {
          localBitmap2 = localBitmap1;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put(str, localBitmap1);
            localBitmap2 = localBitmap1;
          }
        }
      }
      return localBitmap2;
      paramInt = 2130845625;
      str = "static://DefaultTeamWorkShareSheet";
      break;
    }
  }
  
  public SharePolicyInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
  }
  
  public QQProgressDialog a()
  {
    WebUiBaseInterface localWebUiBaseInterface;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        break label118;
      }
      localWebUiBaseInterface = (WebUiBaseInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebUiBaseInterface == null) || (!(localWebUiBaseInterface instanceof WebUiUtils.WebTitleBarInterface))) {
        break label124;
      }
      i1 = ((WebUiUtils.WebTitleBarInterface)localWebUiBaseInterface).b();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435497);
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "dialog show time :" + l1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      label118:
      localWebUiBaseInterface = null;
      break;
      label124:
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        i1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448);
      }
      else
      {
        i1 = (int)(50.0F * this.jdField_a_of_type_Float + 0.5F);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "use default yOffset when getting share progress dialog.");
      }
    }
  }
  
  public String a()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        return "";
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          localObject = (WebUiBaseInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localObject != null) && ((localObject instanceof WebUiUtils.WebUiMethodInterface))) {
            localObject = ((WebUiUtils.WebUiMethodInterface)localObject).b();
          }
        }
      }
      else
      {
        return Util.a((String)localObject, new String[0]);
      }
      localObject = "";
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("appShareID", 0L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131366776));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        break label52;
      }
    }
    label52:
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131366775);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.l, AppShareIDUtil.b(this.jdField_a_of_type_Long), this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493506));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840189);
        localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 19.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 19.0F));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
        this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839198);
        localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 30.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131428575);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 13.75F);
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493507));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 14.75F);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130839796);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493507));
        localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 56.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
        ((LinearLayout.LayoutParams)localObject1).rightMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
        localObject1 = new FrameLayout.LayoutParams(-1, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 44.0F));
        ((FrameLayout.LayoutParams)localObject1).gravity = 80;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      } while (!(this.jdField_a_of_type_AndroidAppActivity instanceof SwiftWebViewFragmentSupporter));
      localObject2 = ((SwiftWebViewFragmentSupporter)this.jdField_a_of_type_AndroidAppActivity).b();
    } while ((localObject2 == null) || (((WebViewFragment)localObject2).a.a == null));
    ((WebViewFragment)localObject2).a.a.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(Context paramContext, GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    Bitmap localBitmap = null;
    byte[] arrayOfByte;
    try
    {
      if ((paramGetAppinfoResponse.has()) && (paramGetAppinfoResponse.ret.get() == 0))
      {
        this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = paramGetAppinfoResponse;
        paramGetAppinfoResponse = a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 64);
        localAndroidInfo = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        if ((TextUtils.isEmpty(paramGetAppinfoResponse)) || (localAndroidInfo == null) || (localAndroidInfo.packName == null))
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + paramGetAppinfoResponse + ", androidInfo is null, OR androidInfo.packName is null !!!");
          }
        }
        else
        {
          arrayOfByte = HttpUtil.a(paramContext, paramGetAppinfoResponse, "GET", null, null);
          if (arrayOfByte == null)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + paramGetAppinfoResponse + ", imageBytes is NULL!!!!!!!!");
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      GetAppInfoProto.AndroidInfo localAndroidInfo;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramContext.getMessage());
        return;
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002);
        paramGetAppinfoResponse = localBitmap;
        try
        {
          localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
          paramGetAppinfoResponse = localBitmap;
          localMessage.obj = localBitmap;
          paramGetAppinfoResponse = localBitmap;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = paramGetAppinfoResponse;
            if (QLog.isColorLevel())
            {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
              localGetAppinfoResponse = paramGetAppinfoResponse;
            }
          }
          paramContext = HttpUtil.a(paramContext, String.format("http://openmobile.qq.com/api/get_app_info_by_id?appid=%d", new Object[] { Long.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)) }), "GET", null, null);
          if (!TextUtils.isEmpty(paramContext)) {
            break label366;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity urlResponse is null");
          return;
          paramContext = new JSONObject(paramContext);
          if (paramContext.getInt("retcode") == 0) {
            break label402;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity retcode is -1");
          return;
          paramContext = paramContext.getJSONObject("result");
          if (paramContext == null) {
            return;
          }
          paramContext = paramContext.getJSONObject("mobile");
          if (paramContext == null) {
            return;
          }
          paramContext = paramContext.getJSONObject("android");
          if (paramContext == null) {
            return;
          }
          paramGetAppinfoResponse = paramContext.getString("yyb_url");
          if ((paramContext.getInt("AppState") != 1) || (TextUtils.isEmpty(paramGetAppinfoResponse))) {
            return;
          }
          paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
          try
          {
            paramContext.obj = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
            return;
          }
          catch (OutOfMemoryError paramContext)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
          }
        }
        if (PackageUtil.a(paramContext, localAndroidInfo.packName.get()))
        {
          paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
          try
          {
            paramContext.obj = localBitmap;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
            return;
          }
          catch (OutOfMemoryError paramContext)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
        }
      }
    }
    label366:
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null)
    {
      this.t = paramArticleInfo.mArticleContentUrl;
      this.u = paramArticleInfo.innerUniqueID;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "shareUrl = ", this.t, " , rowKey = ", this.u });
      }
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "setReadInJoyShareData but articleInfo is null.");
  }
  
  public void a(SharePolicyInfo paramSharePolicyInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = paramSharePolicyInfo;
  }
  
  public void a(String paramString)
  {
    this.n = paramString;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      paramString = "0";
    }
    for (;;)
    {
      a().show();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.n, new String[] { paramString });
      return;
      if (paramInt == 2) {
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
    }
  }
  
  public boolean a()
  {
    QZoneShareData localQZoneShareData;
    if (this.jdField_b_of_type_AndroidAppActivity == null)
    {
      if (this.jdField_a_of_type_AndroidAppActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.jdField_b_of_type_AndroidAppActivity = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
    }
    else
    {
      localQZoneShareData = new QZoneShareData();
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label193;
      }
      localObject = null;
      label57:
      localQZoneShareData.jdField_b_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.g)) {
        break label201;
      }
    }
    label193:
    label201:
    for (Object localObject = null;; localObject = this.g)
    {
      localQZoneShareData.jdField_c_of_type_JavaLangString = ((String)localObject);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(this.h);
      localQZoneShareData.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      localQZoneShareData.jdField_d_of_type_JavaLangString = a();
      if (this.jdField_d_of_type_Int != -1) {
        localQZoneShareData.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
      }
      localQZoneShareData.jdField_b_of_type_Long = SwiftBrowserShareMenuHandler.jdField_b_of_type_Long;
      localQZoneShareData.jdField_b_of_type_Int = 2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
        localQZoneShareData.m = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl();
      }
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        break label209;
      }
      QZoneShareManager.a(this.jdField_b_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), localQZoneShareData, null, -1);
      return true;
      this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
      break;
      localObject = this.jdField_d_of_type_JavaLangString;
      break label57;
    }
    label209:
    QRUtils.a(1, 2131435496);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    Object localObject;
    Uri localUri;
    do
    {
      do
      {
        return false;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramString)));
      localObject = Uri.parse((String)localObject);
      localUri = Uri.parse(paramString);
    } while ((((Uri)localObject).isOpaque()) || (localUri.isOpaque()) || (!((Uri)localObject).getScheme().equals(localUri.getScheme())) || (!((Uri)localObject).getHost().equals(localUri.getHost())));
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131435498);
      return false;
    }
    Bundle localBundle;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_b_of_type_Int = ReportDef.RepUtil.b(paramInt);
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "90");
      localStringBuilder = new StringBuilder().append("");
      if (this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_a_of_type_Int != 0) {
        break label407;
      }
    }
    label407:
    for (int i1 = 0;; i1 = 1)
    {
      localBundle.putString("intext_1", i1);
      localBundle.putString("intext_3", "" + this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_b_of_type_Int);
      localBundle.putString("intext_2", "" + this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_a_of_type_Int);
      localBundle.putString("stringext_1", "" + paramString);
      ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
      this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x.jdField_a_of_type_Boolean = false;
      if (NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getSummary Fail_Network. title=" + this.jdField_d_of_type_JavaLangString + ", desc=" + this.g + ", thumb=" + this.h);
      }
      QRUtils.a(1, 2131434827);
      paramString = new Bundle();
      paramString.putString("report_type", "102");
      paramString.putString("act_type", "84");
      paramString.putString("intext_1", "" + ReportDef.RepUtil.a(1));
      paramString.putString("intext_3", "1");
      paramString.putString("intext_4", "0");
      ReportCenter.a().a(paramString, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
      return false;
    }
    jdField_f_of_type_Boolean = false;
    if (Pattern.compile("http(s)?://([a-zA-Z])*\\.mp\\.qq\\.com/((kan/(article|show|album))|(group/show))(\\.)*").matcher(paramString).find()) {
      jdField_f_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("share_tool_trace", 2, "url is " + paramString);
      QLog.d("share_tool_trace", 2, "readInjoy JS work=" + jdField_f_of_type_Boolean);
    }
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.length() > 30)) {
      this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.substring(0, 29);
    }
    if ((!TextUtils.isEmpty(this.g)) && (this.g != null) && (this.g.length() > 40)) {
      this.g = this.g.substring(0, 39);
    }
    if ((!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.g)))
    {
      b(paramString, paramInt, paramBoolean);
      return true;
    }
    a().c(2131435497);
    boolean bool = TextUtils.isEmpty(this.u);
    if ((!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (bool)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    ThreadManager.executeOnNetWorkThread(new php(this, paramString, paramInt, paramBoolean));
    return true;
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +13 -> 17
    //   7: aload_0
    //   8: aload_3
    //   9: invokevirtual 1395	com/tencent/biz/webviewplugin/Share:a	(Ljava/lang/String;)Z
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 282	com/tencent/biz/webviewplugin/Share:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   22: aload_0
    //   23: aload_2
    //   24: putfield 286	com/tencent/biz/webviewplugin/Share:g	Ljava/lang/String;
    //   27: aload_0
    //   28: aload 4
    //   30: putfield 290	com/tencent/biz/webviewplugin/Share:h	Ljava/lang/String;
    //   33: aload_0
    //   34: getfield 290	com/tencent/biz/webviewplugin/Share:h	Ljava/lang/String;
    //   37: ifnull +43 -> 80
    //   40: aload_0
    //   41: getfield 290	com/tencent/biz/webviewplugin/Share:h	Ljava/lang/String;
    //   44: ldc_w 1397
    //   47: invokevirtual 1400	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +30 -> 80
    //   53: aload_0
    //   54: new 150	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 1402
    //   64: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 290	com/tencent/biz/webviewplugin/Share:h	Ljava/lang/String;
    //   71: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: putfield 290	com/tencent/biz/webviewplugin/Share:h	Ljava/lang/String;
    //   80: aload_0
    //   81: iconst_1
    //   82: putfield 915	com/tencent/biz/webviewplugin/Share:jdField_e_of_type_Boolean	Z
    //   85: aload 5
    //   87: ifnull +173 -> 260
    //   90: aload 5
    //   92: ldc_w 1404
    //   95: invokevirtual 1405	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   98: iconst_1
    //   99: if_icmpne +161 -> 260
    //   102: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +69 -> 174
    //   108: ldc_w 1407
    //   111: iconst_2
    //   112: new 150	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 1409
    //   122: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 282	com/tencent/biz/webviewplugin/Share:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   129: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 1411
    //   135: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: getfield 286	com/tencent/biz/webviewplugin/Share:g	Ljava/lang/String;
    //   142: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 288
    //   148: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 290	com/tencent/biz/webviewplugin/Share:h	Ljava/lang/String;
    //   155: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 1413
    //   161: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_3
    //   165: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_0
    //   175: getfield 71	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x	Lcom/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x;
    //   178: iconst_1
    //   179: putfield 1346	com/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x:jdField_a_of_type_Boolean	Z
    //   182: aload_0
    //   183: getfield 71	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x	Lcom/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x;
    //   186: iconst_0
    //   187: putfield 1350	com/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x:jdField_a_of_type_Int	I
    //   190: aload 4
    //   192: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifeq +418 -> 613
    //   198: aload_0
    //   199: getfield 71	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x	Lcom/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x;
    //   202: astore 4
    //   204: aload 4
    //   206: aload 4
    //   208: getfield 1350	com/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x:jdField_a_of_type_Int	I
    //   211: iconst_1
    //   212: ior
    //   213: putfield 1350	com/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x:jdField_a_of_type_Int	I
    //   216: aload_2
    //   217: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +18 -> 238
    //   223: aload_0
    //   224: getfield 71	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x	Lcom/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x;
    //   227: astore_2
    //   228: aload_2
    //   229: aload_2
    //   230: getfield 1350	com/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x:jdField_a_of_type_Int	I
    //   233: iconst_2
    //   234: ior
    //   235: putfield 1350	com/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x:jdField_a_of_type_Int	I
    //   238: aload_1
    //   239: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifeq +18 -> 260
    //   245: aload_0
    //   246: getfield 71	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentOpenAgentReportReportDef$ShareStructMsg$Report9x	Lcom/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x;
    //   249: astore_1
    //   250: aload_1
    //   251: aload_1
    //   252: getfield 1350	com/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x:jdField_a_of_type_Int	I
    //   255: iconst_4
    //   256: ior
    //   257: putfield 1350	com/tencent/open/agent/report/ReportDef$ShareStructMsg$Report9x:jdField_a_of_type_Int	I
    //   260: aload_0
    //   261: aconst_null
    //   262: putfield 913	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangRefSoftReference	Ljava/lang/ref/SoftReference;
    //   265: aload 5
    //   267: ifnull +251 -> 518
    //   270: getstatic 57	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   273: iconst_1
    //   274: ldc_w 1415
    //   277: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload_0
    //   281: aload 5
    //   283: ldc_w 1417
    //   286: invokevirtual 1418	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   289: putfield 612	com/tencent/biz/webviewplugin/Share:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   292: aload_0
    //   293: aload 5
    //   295: ldc_w 1420
    //   298: invokevirtual 1418	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   301: putfield 1422	com/tencent/biz/webviewplugin/Share:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   304: aload_0
    //   305: aload 5
    //   307: ldc_w 1404
    //   310: iconst_m1
    //   311: invokevirtual 1425	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   314: putfield 75	com/tencent/biz/webviewplugin/Share:jdField_d_of_type_Int	I
    //   317: aload_0
    //   318: aload 5
    //   320: ldc_w 654
    //   323: invokevirtual 1418	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   326: putfield 641	com/tencent/biz/webviewplugin/Share:j	Ljava/lang/String;
    //   329: aload_0
    //   330: aload 5
    //   332: ldc_w 475
    //   335: invokevirtual 1418	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   338: putfield 534	com/tencent/biz/webviewplugin/Share:k	Ljava/lang/String;
    //   341: aload_0
    //   342: aload 5
    //   344: ldc_w 656
    //   347: invokevirtual 1418	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   350: invokestatic 465	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   353: putfield 73	com/tencent/biz/webviewplugin/Share:jdField_c_of_type_Int	I
    //   356: aload_0
    //   357: aload 5
    //   359: ldc_w 1427
    //   362: invokevirtual 1430	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   365: putfield 64	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_Boolean	Z
    //   368: aload_0
    //   369: aload 5
    //   371: ldc_w 1432
    //   374: invokevirtual 1430	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   377: putfield 1434	com/tencent/biz/webviewplugin/Share:jdField_b_of_type_Boolean	Z
    //   380: aload_0
    //   381: getfield 1436	com/tencent/biz/webviewplugin/Share:jdField_d_of_type_Boolean	Z
    //   384: ifne +15 -> 399
    //   387: aload_0
    //   388: aload 5
    //   390: ldc_w 1438
    //   393: invokevirtual 1430	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   396: putfield 1436	com/tencent/biz/webviewplugin/Share:jdField_d_of_type_Boolean	Z
    //   399: aload_0
    //   400: aload 5
    //   402: ldc_w 1440
    //   405: invokevirtual 1418	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   408: putfield 1441	com/tencent/biz/webviewplugin/Share:i	Ljava/lang/String;
    //   411: aload_0
    //   412: aload 5
    //   414: ldc_w 1443
    //   417: invokevirtual 1418	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   420: invokestatic 465	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   423: putfield 66	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_Int	I
    //   426: aload_0
    //   427: aload 5
    //   429: ldc_w 1445
    //   432: invokevirtual 1430	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   435: putfield 1447	com/tencent/biz/webviewplugin/Share:jdField_c_of_type_Boolean	Z
    //   438: aload_0
    //   439: getfield 122	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   442: ifnull +76 -> 518
    //   445: aload_0
    //   446: getfield 122	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   449: instanceof 905
    //   452: ifeq +66 -> 518
    //   455: aload_0
    //   456: getfield 122	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   459: checkcast 905	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   462: invokevirtual 1448	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   465: checkcast 1450	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   468: astore_1
    //   469: aload_1
    //   470: ifnull +48 -> 518
    //   473: aload_1
    //   474: aload_0
    //   475: getfield 64	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_Boolean	Z
    //   478: aload_0
    //   479: getfield 66	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_Int	I
    //   482: invokevirtual 1453	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZI)V
    //   485: aload_1
    //   486: aload_0
    //   487: getfield 1436	com/tencent/biz/webviewplugin/Share:jdField_d_of_type_Boolean	Z
    //   490: invokevirtual 1455	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:b	(Z)V
    //   493: aload_1
    //   494: invokevirtual 1457	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:k	()V
    //   497: aload_1
    //   498: iconst_1
    //   499: aload_0
    //   500: getfield 1441	com/tencent/biz/webviewplugin/Share:i	Ljava/lang/String;
    //   503: aconst_null
    //   504: invokevirtual 1460	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   507: aload_0
    //   508: getfield 1447	com/tencent/biz/webviewplugin/Share:jdField_c_of_type_Boolean	Z
    //   511: ifeq +7 -> 518
    //   514: aload_1
    //   515: invokevirtual 1462	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:h	()V
    //   518: ldc_w 1464
    //   521: aload_0
    //   522: getfield 282	com/tencent/biz/webviewplugin/Share:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   525: invokestatic 1467	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: ldc_w 1469
    //   531: aload_0
    //   532: getfield 286	com/tencent/biz/webviewplugin/Share:g	Ljava/lang/String;
    //   535: invokestatic 1467	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   538: ldc_w 1471
    //   541: aload_0
    //   542: getfield 290	com/tencent/biz/webviewplugin/Share:h	Ljava/lang/String;
    //   545: invokestatic 1467	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: ldc_w 1473
    //   551: aload_3
    //   552: invokestatic 1467	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: ldc_w 1475
    //   558: aload_0
    //   559: getfield 75	com/tencent/biz/webviewplugin/Share:jdField_d_of_type_Int	I
    //   562: invokestatic 1476	cooperation/qzone/LocalMultiProcConfig:putInt	(Ljava/lang/String;I)V
    //   565: aload_0
    //   566: getfield 217	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   569: ifnull +16 -> 585
    //   572: ldc_w 1478
    //   575: aload_0
    //   576: getfield 217	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   579: invokevirtual 1330	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   582: invokestatic 1467	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: new 426	android/content/Intent
    //   588: dup
    //   589: ldc_w 1480
    //   592: invokespecial 1481	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   595: astore_1
    //   596: aload_0
    //   597: getfield 122	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   600: ifnull +11 -> 611
    //   603: aload_0
    //   604: getfield 122	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   607: aload_1
    //   608: invokevirtual 1484	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   611: iconst_1
    //   612: ireturn
    //   613: aload_0
    //   614: iconst_2
    //   615: putfield 1485	com/tencent/biz/webviewplugin/Share:jdField_b_of_type_Int	I
    //   618: goto -402 -> 216
    //   621: astore_1
    //   622: getstatic 57	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   625: iconst_1
    //   626: ldc_w 1487
    //   629: invokestatic 175	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload_0
    //   633: iconst_m1
    //   634: putfield 73	com/tencent/biz/webviewplugin/Share:jdField_c_of_type_Int	I
    //   637: goto -281 -> 356
    //   640: astore_1
    //   641: getstatic 57	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   644: iconst_1
    //   645: ldc_w 1489
    //   648: invokestatic 175	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: goto -295 -> 356
    //   654: astore_1
    //   655: aload_0
    //   656: aconst_null
    //   657: putfield 1441	com/tencent/biz/webviewplugin/Share:i	Ljava/lang/String;
    //   660: getstatic 57	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   663: iconst_1
    //   664: ldc_w 1491
    //   667: invokestatic 175	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: goto -259 -> 411
    //   673: astore_1
    //   674: aload_0
    //   675: iconst_m1
    //   676: putfield 66	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_Int	I
    //   679: goto -253 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	Share
    //   0	682	1	paramString1	String
    //   0	682	2	paramString2	String
    //   0	682	3	paramString3	String
    //   0	682	4	paramString4	String
    //   0	682	5	paramBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   270	356	621	java/lang/NumberFormatException
    //   270	356	640	java/lang/Exception
    //   399	411	654	java/lang/Exception
    //   411	426	673	java/lang/Exception
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QRUtils.a(1, 2131434827);
      return false;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      QRUtils.a(1, 2131435498);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      paramString7 = (WebUiBaseInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((paramString7 == null) || (!(paramString7 instanceof WebUiUtils.WebTitleBarInterface))) {
        break label454;
      }
    }
    label139:
    label186:
    label192:
    label454:
    for (int i1 = ((WebUiUtils.WebTitleBarInterface)paramString7).b();; i1 = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435497);
      boolean bool;
      if (paramString4.length() > 180)
      {
        bool = true;
        if ((paramString5 == null) || (paramString5.length() <= 40)) {
          break label186;
        }
        i1 = 1;
        if ((!bool) && (i1 == 0)) {
          break label192;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        new phw(this, bool, paramString5, paramString1, paramString2, paramString3, paramString4, paramString6).start();
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        i1 = 0;
        break label139;
        paramString7 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
        paramString8 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
        String str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430119), new Object[] { paramString2 });
        ShareMsgHelper.a(this.jdField_a_of_type_AndroidAppActivity, 1001, 1, "struct_msg_from_h5", paramString1, paramString5, paramString2, paramString3, str, paramString4, "web", null, null, null, "plugin", null, paramString7, paramString8, "http://url.cn/JS8oE7", paramString6, null);
        int i2 = 0;
        if (TextUtils.isEmpty(paramString5)) {
          i2 = 1;
        }
        i1 = i2;
        if (TextUtils.isEmpty(paramString3)) {
          i1 = i2 | 0x2;
        }
        i2 = i1;
        if (TextUtils.isEmpty(paramString2)) {
          i2 = i1 | 0x4;
        }
        paramString1 = new Bundle();
        paramString1.putString("report_type", "102");
        paramString1.putString("act_type", "14");
        paramString1.putString("intext_3", "1");
        paramString1.putString("intext_2", "" + i2);
        paramString1.putString("stringext_1", "" + paramString4);
        ReportCenter.a().a(paramString1, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.g = null;
    this.h = null;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
    this.r = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.i = null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public void d()
  {
    if (this.n != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.n, new String[] { "7" });
    }
  }
  
  public String e()
  {
    return this.j;
  }
  
  public void e()
  {
    if (this.n != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.n, new String[] { "8" });
    }
  }
  
  public String f()
  {
    return this.k;
  }
  
  public void f()
  {
    if (this.n != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.n, new String[] { "9" });
    }
  }
  
  public String g()
  {
    return this.i;
  }
  
  public void g()
  {
    if (this.o != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.o, new String[] { "0" });
    }
  }
  
  public void h()
  {
    if (this.p != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.p, new String[] { "1" });
    }
  }
  
  public void i()
  {
    if (this.q != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.q, new String[] { "2" });
    }
  }
  
  public void j()
  {
    if (this.r != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.r, new String[] { "3" });
    }
  }
  
  public void onClick(View paramView)
  {
    GetAppInfoProto.AndroidInfo localAndroidInfo;
    if ((this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
    {
      localAndroidInfo = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
      if ((paramView != this.jdField_a_of_type_AndroidWidgetImageView) && (paramView != this.jdField_a_of_type_AndroidViewView)) {
        break label196;
      }
      if (!PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get())) {
        break label97;
      }
      PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get(), null);
      paramView = "run";
      Util.a(null, "", "webviewsourceclick", AppShareIDUtil.b(this.jdField_a_of_type_Long), 0L, paramView);
    }
    label97:
    do
    {
      for (;;)
      {
        return;
        paramView = new Bundle();
        paramView.putString("uin", this.l);
        paramView.putString("sid", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("vkey"));
        paramView.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
        paramView.putBoolean("autoDownload", true);
        paramView.putString("packageName", localAndroidInfo.packName.get());
        AppClient.a(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), 2470, paramView);
        paramView = "setup";
        break;
        if (paramView != this.jdField_b_of_type_AndroidWidgetTextView) {
          break label407;
        }
        if (PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get()))
        {
          PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get(), null);
          OpenSdkStatic.a().a(this.l, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "203", false);
        }
        while (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          return;
          paramView = new Bundle();
          paramView.putString("uin", this.l);
          paramView.putString("sid", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("vkey"));
          paramView.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
          paramView.putBoolean("autoDownload", true);
          paramView.putString("packageName", localAndroidInfo.packName.get());
          paramView.putString("appId", String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)));
          AppClient.b(this.jdField_a_of_type_AndroidAppActivity, paramView);
          OpenSdkStatic.a().a(this.l, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "202", false);
        }
      }
    } while ((paramView != this.jdField_b_of_type_AndroidWidgetLinearLayout) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    label196:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    label407:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share
 * JD-Core Version:    0.7.0.1
 */