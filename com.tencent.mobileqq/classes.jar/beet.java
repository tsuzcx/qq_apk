import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.10;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.11;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.3;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.4;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.5;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.6;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class beet
  extends bedh
  implements Handler.Callback
{
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public final QQBrowserActivity a;
  public WebViewFragment a;
  public Boolean a;
  public final Object a;
  public String a;
  public HashSet<String> a;
  Map<String, RedAppInfo> jdField_a_of_type_JavaUtilMap;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  boolean jdField_a_of_type_Boolean = false;
  
  public beet(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaLangString = null;
    if ((paramActivity instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)paramActivity);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = null;
  }
  
  private static Pair<Integer, Integer> a(String paramString)
  {
    int i = 0;
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getHost();
        if ((!TextUtils.isEmpty(paramString)) && (myl.a().l(paramString)))
        {
          k = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
          int m = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels;
          i = m;
          j = k;
          if (!paramString.contains("cmshow")) {
            i = m - (int)mww.a(BaseApplicationImpl.getApplication(), 54.0F);
          }
        }
      }
    }
    for (int j = k;; j = 0) {
      return new Pair(Integer.valueOf(j), Integer.valueOf(i));
    }
  }
  
  private String a()
  {
    Object localObject;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.size() > 1))
    {
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        localObject = (bikc)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web")).getManager(213);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("1113.100803");
        this.jdField_a_of_type_JavaUtilMap = ((bikc)localObject).a(localArrayList);
      }
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        break label244;
      }
      localObject = (RedAppInfo)this.jdField_a_of_type_JavaUtilMap.get("1113.100803");
      if ((localObject != null) && (((RedAppInfo)localObject).b() != 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.size() > 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d == 0))
      {
        localObject = (WebViewTabBarData)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.get(4);
        if (localObject != null)
        {
          return ((WebViewTabBarData)localObject).url;
          i = 0;
        }
        else
        {
          return "";
        }
      }
      else
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d + 1;
        if (i < this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.size()) {}
        while (i > 0)
        {
          localObject = (WebViewTabBarData)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.get(i);
          if (localObject != null)
          {
            return ((WebViewTabBarData)localObject).url;
            i = -1;
          }
          else
          {
            return "";
          }
        }
        return null;
        label244:
        i = 0;
      }
    }
  }
  
  public static void a(WebView paramWebView, String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    int i = ((Integer)((Pair)localObject).first).intValue();
    int j = ((Integer)((Pair)localObject).second).intValue();
    if ((i <= 0) || (j <= 0) || (paramWebView == null) || (paramWebView.getX5WebViewExtension() == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {}
    for (localObject = "";; localObject = bege.a(paramString2))
    {
      ThreadManager.getUIHandler().post(new SwiftBrowserTBSHandler.11(paramString2, paramString1, paramWebView, i, j, (String)localObject));
      return;
    }
  }
  
  private void c()
  {
    if (befr.b())
    {
      String str = a();
      if ((!TextUtils.isEmpty(str)) && (befr.a(str)) && (!str.contains("asyncMode=3")) && (!str.contains("sonic=1"))) {
        ThreadManager.post(new SwiftBrowserTBSHandler.10(this, str), 5, null, true);
      }
    }
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
      paramString = null;
    }
    String str;
    do
    {
      do
      {
        return paramString;
        if ("openBrowserList".equals(paramString))
        {
          QLog.d("SwiftBrowserTBSHandler", 1, "XChooserActivity 已在725下架");
          return null;
        }
        if (!"addDownloadTask".equals(paramString)) {
          break;
        }
        if (paramBundle == null) {
          return null;
        }
        str = paramBundle.getString("task_name");
        paramString = paramBundle.getString("task_url");
        paramBundle = paramBundle.getString("appid");
        this.jdField_a_of_type_JavaLangString = paramString;
        paramString = paramBundle;
      } while (paramBundle == null);
      paramString = paramBundle;
    } while (str == null);
    paramString = bfkb.a().a(paramBundle);
    if (paramString != null)
    {
      paramString = paramString.d;
      Bundle localBundle = new Bundle();
      localBundle.putString(bfjy.b, paramBundle);
      localBundle.putString(bfjy.j, paramString);
      localBundle.putInt(bfjy.k, 2);
      localBundle.putString(bfjy.l, str);
      localBundle.putBoolean(bfjy.r, false);
      localBundle.putBoolean(bfjy.x, false);
      localBundle.putString(bfjy.m, "_" + paramBundle);
      bfju.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, localBundle, "biz_src_yyb", null, 0);
      return paramBundle;
    }
    ThreadManager.post(new SwiftBrowserTBSHandler.4(this, paramBundle, str), 8, null, true);
    return paramBundle;
    if ("cancelDownloadTask".equals(paramString))
    {
      paramString = paramBundle.getString("download_id");
      if (!bfju.a(paramString)) {
        return Boolean.valueOf(false);
      }
      bfju.a(paramString, "_" + paramString, true);
      return Boolean.valueOf(true);
    }
    if ("queryDownloadTask".equals(paramString))
    {
      paramString = paramBundle.getString("download_id");
      paramString = bfkb.a().a(paramString);
      if (paramString == null) {
        return Integer.valueOf(0);
      }
      switch (paramString.a())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        return Integer.valueOf(0);
      case 10: 
        return Integer.valueOf(5);
      case 4: 
        return Integer.valueOf(3);
      case 2: 
        return Integer.valueOf(1);
      }
      return Integer.valueOf(2);
    }
    if ("installDownloadTask".equals(paramString))
    {
      paramString = paramBundle.getString("download_id");
      paramBundle = bfkb.a().a(paramString);
      if ((paramBundle == null) || (paramBundle.a() != 4)) {
        return Boolean.valueOf(false);
      }
      paramBundle = new Bundle();
      paramBundle.putString(bfjy.b, paramString);
      paramBundle.putInt(bfjy.k, 5);
      paramBundle.putBoolean(bfjy.r, false);
      paramBundle.putBoolean(bfjy.x, false);
      bfju.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramBundle, "biz_src_yyb", null, 0);
      return Boolean.valueOf(true);
    }
    if ("notifyQBiconShine".equals(paramString))
    {
      paramString = (beey)this.jdField_a_of_type_Bedi.a().a(2);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Befb.z = true;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserTBSHandler", 2, "QQBrowser has related content.");
        }
      }
    }
    for (;;)
    {
      return null;
      if ("onNotifyResourceRequestURL".equals(paramString))
      {
        if (paramBundle.containsKey("url"))
        {
          paramString = paramBundle.getString("url");
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")))
          {
            str = Uri.parse(paramString).getQueryParameter("_bid");
            if (!TextUtils.isEmpty(str))
            {
              if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserTBSHandler", 2, "ServiceWorkerOffline Notify Resource RequestURL: " + paramBundle.getString("url"));
              }
              if (this.jdField_a_of_type_JavaUtilHashSet == null) {
                this.jdField_a_of_type_JavaUtilHashSet = new HashSet(6);
              }
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str))
              {
                this.jdField_a_of_type_JavaUtilHashSet.add(str);
                ThreadManager.getUIHandler().postDelayed(new SwiftBrowserTBSHandler.5(this, paramString), 5000L);
              }
            }
          }
        }
      }
      else if ("netTimeConsumingReport".equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserTBSHandler", 2, "netTimeConsumingReport start");
        }
        if (paramBundle.containsKey("firstbyte")) {
          for (;;)
          {
            try
            {
              paramString = paramBundle.getString("firstbyte");
              str = paramBundle.getString("firstscreen");
              paramBundle = paramBundle.getString("firstword");
              if (TextUtils.isEmpty(paramString)) {
                break label1121;
              }
              l1 = Long.parseLong(paramString);
              if (TextUtils.isEmpty(str)) {
                break label1127;
              }
              l2 = Long.parseLong(str);
              if (TextUtils.isEmpty(paramBundle)) {
                break label1133;
              }
              l3 = Long.parseLong(paramBundle);
              if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserTBSHandler", 2, String.format("receive firstByteStr: %s, receive firstScreenStr: %s", new Object[] { paramString, str }));
              }
              long l6 = 0L;
              long l5 = 0L;
              long l4 = 0L;
              paramString = (beep)this.jdField_a_of_type_Bedi.a().a(-2);
              if (paramString != null)
              {
                l6 = paramString.b;
                l5 = paramString.c;
                l4 = paramString.q;
                paramString.f = l1;
                paramString.g = l2;
                paramString.e = l3;
              }
              VasWebviewUtil.reportX5SpeedData(paramString);
              if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserTBSHandler", 2, String.format("webview start - click start: %d, loadurl - webview start: %d, first byte - loadurl: %d, first screen - first byte: %d", new Object[] { Long.valueOf(l5 - l6), Long.valueOf(l4 - l5), Long.valueOf(l1 - l4), Long.valueOf(l2 - l1) }));
              }
              QLog.i("SwiftBrowserTBSHandler", 1, "Web_qqbrowser_X5_from_loadUrl_to_FirstByte, cost=" + (l1 - l4));
              QLog.i("SwiftBrowserTBSHandler", 1, "Web_qqbrowser_X5_from_FirstByte_to_FirstScreen, cost=" + (l2 - l1));
              QLog.i("SwiftBrowserTBSHandler", 1, "from click to firstWord time = " + (l3 - l6));
            }
            catch (Exception paramString)
            {
              QLog.e("SwiftBrowserTBSHandler", 2, "", paramString);
            }
            break;
            label1121:
            long l1 = 0L;
            continue;
            label1127:
            long l2 = 0L;
            continue;
            label1133:
            long l3 = 0L;
          }
        }
      }
      else if ("onUploadLiveLogFinished".equals(paramString))
      {
        boolean bool = paramBundle.getBoolean("result", false);
        QLog.d("SwiftBrowserTBSHandler", 1, "onUploadLiveLogFinished, result: " + bool);
        if ((UiApiPlugin.jdField_a_of_type_AndroidOsResultReceiver != null) && (UiApiPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() != -1L))
        {
          paramString = new Bundle();
          paramString.putLong("seq", UiApiPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
          paramBundle = UiApiPlugin.jdField_a_of_type_AndroidOsResultReceiver;
          if (bool) {}
          for (int i = 0;; i = -3)
          {
            paramBundle.send(i, paramString);
            UiApiPlugin.jdField_a_of_type_AndroidOsResultReceiver = null;
            UiApiPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(-1L);
            break;
          }
        }
      }
      else if (paramString.equalsIgnoreCase("onReportStgwTime"))
      {
        a(paramBundle);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null)) {
      return;
    }
    Object localObject1 = WebAccelerateHelper.getInstance().getTBSDpcParam();
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (((String)localObject1).charAt(0) == '1') {
        break label340;
      }
      if (!QLog.isColorLevel()) {
        break label450;
      }
      QLog.i("SwiftBrowserTBSHandler", 2, "warning: disable tbs, " + (String)localObject1);
      i = 0;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (i != 0)) {
        if ("CN".equals(Locale.getDefault().getCountry())) {
          if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new beeu(this)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TBS_update", 2, "tbs need download");
            }
            QbSdk.setUploadCode(BaseApplication.getContext(), 150);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a(false);
            label158:
            i = 1;
            label160:
            if (this.jdField_a_of_type_Bedi == null) {
              break label445;
            }
          }
        }
      }
      label431:
      label438:
      label445:
      for (localObject1 = (beep)this.jdField_a_of_type_Bedi.a().a(-2);; localObject1 = null)
      {
        if (((localObject1 == null) || (!((beep)localObject1).i)) && (!QLog.isColorLevel())) {
          break label448;
        }
        int j = QbSdk.getTbsVersion(BaseApplicationImpl.getApplication());
        Object localObject2;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("tbs current webview:");
          if (j == 0)
          {
            localObject2 = "sys";
            label239:
            QLog.d("TBS_update", 2, (String)localObject2);
          }
        }
        else
        {
          if ((localObject1 == null) || (!((beep)localObject1).i)) {
            break;
          }
          localObject2 = new StringBuilder().append("tbs_cover_");
          if (i == 0) {
            break label438;
          }
          if (j <= 0) {
            break label431;
          }
          localObject1 = "tbs";
        }
        for (;;)
        {
          azmj.b(null, "P_CliOper", "BizTechReport", "", "web", (String)localObject1, 0, 1, j, "", "", "", "");
          return;
          QLog.e("SwiftBrowserTBSHandler", 1, "error: no dpc param!");
          label340:
          i = 1;
          break;
          if (!QLog.isColorLevel()) {
            break label158;
          }
          QLog.d("TBS_update", 2, "tbs no need download");
          break label158;
          if (QLog.isColorLevel())
          {
            QLog.d("TBS_update", 2, "tbs loc/tz not match");
            i = 0;
            break label160;
            if (QLog.isColorLevel()) {
              QLog.d("TBS_update", 2, "tbs update disabled");
            }
          }
          i = 0;
          break label160;
          localObject2 = "x5_" + j;
          break label239;
          localObject1 = "sys";
          continue;
          localObject1 = "dis";
        }
      }
      label448:
      break;
      label450:
      i = 0;
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = null;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
              this.jdField_a_of_type_AndroidAppDialog.dismiss();
            }
          } while (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
          return;
        } while (this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_Boolean = true;
        c();
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView();
        }
      } while (paramBundle == null);
      paramBundle = (atfz)paramBundle.getPluginEngine().a("x5");
    } while (paramBundle == null);
    paramBundle.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    VasWebviewUtil.reportVasStatus("WebViewStatus", "x5_preload", "0", 0, 0, paramInt, 0, paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserTBSHandler", 2, "handlePreloadCallback: type=" + paramInt + ", url=" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (atfz)((CustomWebView)localObject).getPluginEngine().a("x5");
        if (localObject != null) {
          ((atfz)localObject).a(paramInt, paramString);
        }
      }
      return;
    }
  }
  
  void a(Bundle paramBundle)
  {
    Object localObject3;
    String str;
    Object localObject1;
    if (paramBundle != null)
    {
      localObject3 = "";
      str = "";
      localObject1 = localObject3;
    }
    label168:
    label207:
    for (Object localObject2 = localObject3;; localObject2 = "") {
      for (;;)
      {
        try
        {
          if (paramBundle.containsKey("url"))
          {
            localObject2 = localObject3;
            localObject1 = paramBundle.getString("url");
          }
          localObject2 = localObject1;
          if (!paramBundle.containsKey("requestTime")) {
            break label207;
          }
          localObject2 = localObject1;
          localObject3 = paramBundle.getString("requestTime");
          localObject2 = localObject3;
          localObject3 = str;
          localObject4 = localObject2;
          localObject5 = localObject1;
          QLog.e("SwiftBrowserTBSHandler", 1, "handleStgwTime error!", paramBundle);
        }
        catch (Throwable paramBundle)
        {
          try
          {
            if (paramBundle.containsKey("upstreamResponseTime"))
            {
              localObject3 = paramBundle.getString("upstreamResponseTime");
              localObject5 = localObject1;
              localObject4 = localObject2;
            }
            QLog.d("SwiftBrowserTBSHandler", 1, "handle stgw time, requestTime: " + localObject4 + "s, responseTime: " + (String)localObject3 + "s, url: " + ndq.b(localObject5, new String[0]));
            return;
          }
          catch (Throwable paramBundle)
          {
            Object localObject4;
            Object localObject5;
            break label168;
          }
          paramBundle = paramBundle;
          localObject3 = "";
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        localObject3 = str;
        localObject4 = localObject2;
        localObject5 = localObject1;
        continue;
        QLog.d("SwiftBrowserTBSHandler", 1, "handleStgwTime error, data is not JSONObject!");
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt < 12)
    {
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setConnectTimeout(20000);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.connect();
        i = localHttpURLConnection.getResponseCode();
        if ((i != 301) && (i != 302)) {
          break label143;
        }
        paramString = localHttpURLConnection.getHeaderFields().keySet().iterator();
        String str;
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
          str = (String)paramString.next();
        } while (!"location".equalsIgnoreCase(str));
        paramString = localHttpURLConnection.getHeaderField(str);
      }
      catch (Throwable paramString)
      {
        HttpURLConnection localHttpURLConnection;
        int i;
        label143:
        while (QLog.isColorLevel())
        {
          QLog.e("SwiftBrowserTBSHandler", 2, paramString.getMessage());
          return;
          paramString = null;
        }
      }
      if (paramString != null)
      {
        a(MsfSdkUtils.insertMtype("Web", paramString), paramInt + 1);
        return;
        if (i == 200)
        {
          this.jdField_a_of_type_Long = localHttpURLConnection.getContentLength();
          this.jdField_a_of_type_JavaLangString = localHttpURLConnection.getURL().toString();
        }
      }
      localHttpURLConnection.disconnect();
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null)) {
      return;
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {}
    Object localObject;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
          this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this);
        }
        localObject = bfkb.a().a("801097412");
        if ((localObject == null) || (!bdee.h(BaseApplicationImpl.getApplication()))) {
          break;
        }
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
        this.jdField_a_of_type_JavaLangString = ((DownloadInfo)localObject).d;
        if (paramBoolean)
        {
          paramString = BaseApplicationImpl.getApplication().getResources().getString(2131689504);
          QQToast.a(BaseApplicationImpl.getApplication(), 2, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102));
          return;
        }
      }
      finally {}
      paramString = BaseApplicationImpl.getApplication().getResources().getString(2131689510);
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing())
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      ThreadManager.post(new SwiftBrowserTBSHandler.6(this), 8, null, true);
      paramString = new beev(this);
      localObject = new beew(this);
      if (!bdee.h(BaseApplicationImpl.getApplication())) {
        break label351;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102));
      if (!paramBoolean) {
        break label335;
      }
    }
    label335:
    for (paramString = BaseApplicationImpl.getApplication().getResources().getString(2131689504);; paramString = BaseApplicationImpl.getApplication().getResources().getString(2131689510))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break;
    }
    label351:
    if (paramBoolean)
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843906);
      this.jdField_a_of_type_AndroidAppDialog = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, localDrawable, BaseApplicationImpl.getApplication().getResources().getString(2131689503), " ", BaseApplicationImpl.getApplication().getResources().getString(2131690624), BaseApplicationImpl.getApplication().getResources().getString(2131689502), paramString, (View.OnClickListener)localObject);
      this.jdField_a_of_type_AndroidAppDialog.show();
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("qb_info", 0);
      if (paramString == null) {
        break label567;
      }
    }
    label567:
    for (paramString = paramString.getString("icon_url", null);; paramString = null)
    {
      localObject = new beex(this);
      if (paramString != null)
      {
        paramString = URLDrawable.getDrawable(paramString);
        paramString.setURLDrawableListener((URLDrawable.URLDrawableListener)localObject);
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(103, paramString));
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidAppDialog = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, BaseApplicationImpl.getApplication().getResources().getString(2131689509), 2131690624, 2131689502, paramString, (View.OnClickListener)localObject);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Bedi.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return true;
            paramMessage = (String)paramMessage.obj;
            try
            {
              paramMessage = new JSONObject(paramMessage);
              localObject1 = paramMessage.getJSONObject("icon");
              Object localObject2 = paramMessage.getJSONObject("content");
              paramMessage = ((JSONObject)localObject1).getString("timestamp");
              localObject1 = ((JSONObject)localObject1).getString("url");
              String str = ((JSONObject)localObject2).getString("timestamp");
              localObject2 = ((JSONObject)localObject2).getString("memo");
              Object localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("qb_info", 0);
              if (localObject3 != null)
              {
                localObject3 = ((SharedPreferences)localObject3).edit();
                ((SharedPreferences.Editor)localObject3).putString("icon_time", paramMessage);
                ((SharedPreferences.Editor)localObject3).putString("icon_url", (String)localObject1);
                ((SharedPreferences.Editor)localObject3).putString("content_time", str);
                ((SharedPreferences.Editor)localObject3).putString("content_memo", (String)localObject2);
                ((SharedPreferences.Editor)localObject3).commit();
                return true;
              }
            }
            catch (Exception paramMessage)
            {
              return true;
            }
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.i));
        paramMessage = (Bundle)paramMessage.obj;
        if (paramMessage != null)
        {
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("qb_info", 0);
          if (localObject1 != null)
          {
            paramMessage.putString("param_content_memo", ((SharedPreferences)localObject1).getString("content_memo", null));
            paramMessage.putString("param_icon_path", ((SharedPreferences)localObject1).getString("icon_url", null));
          }
          paramMessage.putString("param_user_agent", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().getUserAgentString());
          paramMessage.putString("param_refer_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl());
          localObject1 = paramMessage.getString("qb_param_url");
          if ((localObject1 != null) && (((String)localObject1).length() != 0))
          {
            paramMessage.remove("qb_param_url");
            paramMessage.putBoolean("param_isqbdownload", true);
            aqrb.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, (String)localObject1, paramMessage);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        return true;
        ThreadManager.post(new SwiftBrowserTBSHandler.3(this), 8, null, true);
        return true;
        paramMessage = (Drawable)paramMessage.obj;
      } while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) || (paramMessage == null));
      Object localObject1 = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131379238);
      ((ImageView)localObject1).setImageDrawable(null);
      ((ImageView)localObject1).setImageDrawable(paramMessage);
      return true;
      paramMessage = (String)paramMessage.obj;
    } while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) || (paramMessage == null));
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131379240)).setText(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beet
 * JD-Core Version:    0.7.0.1
 */