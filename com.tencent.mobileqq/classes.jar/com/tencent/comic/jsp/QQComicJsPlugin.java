package com.tencent.comic.jsp;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.data.ExtraParams;
import com.tencent.comic.data.VipComicDataHelper;
import com.tencent.comic.utils.AppHelper;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.webbundle.WebBundleReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.SubTabParam;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.SubTabRedHotParam;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQComicJsPlugin
  extends VasWebviewJsPlugin
{
  public static final Handler a;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static String f = null;
  public int a;
  QQComicJsCallback jdField_a_of_type_ComTencentComicJspQQComicJsCallback = new QQComicJsPlugin.1(this);
  public QQComicJsPluginProxy a;
  public String a;
  public final AtomicInteger a;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public String b = null;
  public String c = "";
  public String d = "";
  String e = null;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QQComicJsPluginDeamon", 0);
    localHandlerThread.start();
    jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public QQComicJsPlugin()
  {
    this.jdField_a_of_type_ComTencentComicJspQQComicJsPluginProxy = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_Int = 0;
    this.mPluginNameSpace = "comic";
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.remove("openWithWebBundle");
      paramBundle.remove("real_url");
      paramBundle.remove("preload_url");
      paramBundle.remove("bundle_data");
    }
  }
  
  private void a(String paramString, WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      int i;
      if (!paramWebViewFragment.getSwiftTitleUI().a(false))
      {
        i = -1;
        paramWebViewFragment = "not exist sub tab";
      }
      else
      {
        paramWebViewFragment = "ok";
        i = 0;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", i);
        localJSONObject.put("message", paramWebViewFragment);
      }
      catch (JSONException paramWebViewFragment)
      {
        QLog.e("QQComicJsPlugin", 1, paramWebViewFragment, new Object[0]);
        a(paramString, paramWebViewFragment.getMessage());
      }
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", -1);
      localJSONObject.put("msg", paramString2);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("&&");
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("(");
      localStringBuilder2.append(localJSONObject.toString());
      localStringBuilder2.append(");");
      super.callJs(localStringBuilder2.toString());
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQComicJsPlugin", 2, localException.getMessage());
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("callbackId->");
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append(" errorMsg: ");
      localStringBuilder1.append(paramString2);
      QLog.e("QQComicJsPlugin", 2, localStringBuilder1.toString());
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = paramJSONObject.optInt("type");
  }
  
  private void a(JSONObject paramJSONObject, String paramString, SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      boolean bool1 = paramJSONObject.optBoolean("titleHide");
      boolean bool2 = paramJSONObject.optBoolean("bottomHide");
      paramWebViewFragment.getSwiftTitleUI().b(bool1 ^ true);
      paramSwiftWebViewFragmentSupporter.setBottomBarVisibility(bool2 ^ true);
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void a(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initPrivateSettingIcon ");
      localStringBuilder.append(paramJSONObject.optInt("status", -1));
      QLog.i("QQComicJsPlugin", 2, localStringBuilder.toString());
    }
    if (paramWebViewFragment != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramJSONObject.optInt("status", -1));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
      this.b = paramJSONObject.optString("callbackName");
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0)
      {
        paramJSONObject = AppHelper.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("boodo_");
        localStringBuilder.append(this.mRuntime.a().getCurrentAccountUin());
        if (!paramJSONObject.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("private_read_red_dot", false))
        {
          paramWebViewFragment.getSwiftTitleUI().d(true);
          QLog.i("QQComicJsPlugin", 1, "show private read red dot.");
        }
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("code", 0);
        super.callJs(paramString, new String[] { paramJSONObject.toString() });
      }
    }
    else
    {
      a(paramString, "webViewFragment == null");
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      VipComicDataHelper.jdField_a_of_type_ComTencentComicDataExtraParams.b(this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setContainerInfo success on Resume extrasParams: ");
      localStringBuilder.append(VipComicDataHelper.jdField_a_of_type_ComTencentComicDataExtraParams.toString());
      QLog.d("QQComicJsPlugin", 2, localStringBuilder.toString());
    }
  }
  
  private void b(String paramString, WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      int i;
      if (!paramWebViewFragment.getSwiftTitleUI().a(true))
      {
        i = -1;
        paramWebViewFragment = "not exist sub tab";
      }
      else
      {
        paramWebViewFragment = "ok";
        i = 0;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", i);
        localJSONObject.put("message", paramWebViewFragment);
      }
      catch (JSONException paramWebViewFragment)
      {
        QLog.e("QQComicJsPlugin", 1, paramWebViewFragment, new Object[0]);
        a(paramString, paramWebViewFragment.getMessage());
      }
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void b(JSONObject paramJSONObject)
  {
    VipComicHelper.a(paramJSONObject.optInt("useWebBundle"));
  }
  
  private void b(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      int j = paramJSONObject.optInt("action");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("subIndexArray");
      int[] arrayOfInt = null;
      paramJSONObject = arrayOfInt;
      if (localJSONArray != null)
      {
        paramJSONObject = arrayOfInt;
        if (localJSONArray.length() > 0)
        {
          arrayOfInt = new int[localJSONArray.length()];
          int i = 0;
          for (;;)
          {
            paramJSONObject = arrayOfInt;
            if (i >= localJSONArray.length()) {
              break;
            }
            arrayOfInt[i] = localJSONArray.getInt(i);
            i += 1;
          }
        }
      }
      if (((j != 1) && (j != 2)) || (paramJSONObject == null))
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("code", -1);
        paramJSONObject.put("message", "param is invalid");
        super.callJs(paramString, new String[] { paramJSONObject.toString() });
        return;
      }
      paramWebViewFragment.getSwiftTitleUI().a(new SwiftIphoneTitleBarUI.SubTabRedHotParam(paramJSONObject, j, paramString));
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private static String c()
  {
    File localFile = AppHelper.a().getCacheDir();
    StringBuilder localStringBuilder;
    if (localFile != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localFile.getAbsolutePath());
      localStringBuilder.append("/qqcomic/cache/");
      return localStringBuilder.toString();
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (Environment.getExternalStorageDirectory().exists()))
    {
      localFile = AppHelper.a().getExternalCacheDir();
      if (localFile != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localFile.getAbsolutePath());
        localStringBuilder.append("/qqcomic/cache/");
        return localStringBuilder.toString();
      }
      return VFSAssistantUtils.getSDKPrivatePath("tencent/MobileQQ/qqcomic/cache/");
    }
    return null;
  }
  
  private void c(String paramString, WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject1.put("code", 0);
        localJSONObject1.put("message", "ok");
        localJSONObject2.put("subIndex", paramWebViewFragment.getSwiftTitleUI().a());
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (JSONException paramWebViewFragment)
      {
        QLog.e("QQComicJsPlugin", 1, paramWebViewFragment, new Object[0]);
        a(paramString, paramWebViewFragment.getMessage());
      }
      super.callJs(paramString, new String[] { localJSONObject1.toString() });
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    String str2 = paramJSONObject.optString("bundle_url", "");
    paramJSONObject.optString("preloadSource", "");
    paramJSONObject = this.mRuntime.a();
    if (paramJSONObject != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("url", str1);
      VipComicHelper.a(localIntent);
      if (localJSONObject != null)
      {
        localIntent.putExtra("openWithWebBundle", true);
        if (WebBundleManager.getInstance("comic").openWebViewWithWebBundle(paramJSONObject, str1, localJSONObject, localIntent, str2)) {
          return;
        }
        WebBundleReportUtils.a(str1, false, WebBundleReportUtils.b);
      }
      else
      {
        WebBundleReportUtils.a(str1, false, WebBundleReportUtils.e);
      }
      a(localIntent.getExtras());
      VipComicHelper.a(paramJSONObject, localIntent, 100);
    }
  }
  
  private void c(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    int j = paramJSONObject.optInt("tabNum", 2);
    int k = paramJSONObject.optInt("subIndex");
    String str = paramJSONObject.optString("switchCallback");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("subTextArray");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      paramJSONObject = new String[localJSONArray.length()];
      int i = 0;
      while (i < localJSONArray.length())
      {
        paramJSONObject[i] = localJSONArray.getString(i);
        i += 1;
      }
    }
    else
    {
      paramJSONObject = null;
    }
    if (paramWebViewFragment != null)
    {
      paramWebViewFragment.getSwiftTitleUI().a(new SwiftIphoneTitleBarUI.SubTabParam(k, j, str, paramString, paramJSONObject));
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void d(String paramString, WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      paramWebViewFragment.getSwiftTitleUI().b(paramString);
      return;
    }
    QLog.e("QQComicJsPlugin", 1, "webViewFragment == null");
    a(paramString, "webViewFragment == null");
  }
  
  private void d(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    paramJSONObject = paramJSONObject.optString("switchCallback");
    int i;
    if (TextUtils.isEmpty(paramJSONObject))
    {
      i = -1;
      paramJSONObject = "the subTabCallback isEmpty";
    }
    else
    {
      if (paramWebViewFragment != null) {
        paramWebViewFragment.getSwiftTitleUI().a.a(paramJSONObject, false);
      }
      paramJSONObject = "ok";
      i = 0;
    }
    if (paramWebViewFragment != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject1.put("code", i);
        localJSONObject1.put("message", paramJSONObject);
        localJSONObject2.put("subIndex", paramWebViewFragment.getSwiftTitleUI().a());
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("QQComicJsPlugin", 1, paramJSONObject, new Object[0]);
        a(paramString, paramJSONObject.getMessage());
      }
      super.callJs(paramString, new String[] { localJSONObject1.toString() });
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void e(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    paramJSONObject = paramJSONObject.optString("name", "");
    if (paramWebViewFragment != null)
    {
      paramWebViewFragment.getSwiftTitleUI().c(paramJSONObject);
      return;
    }
    QLog.e("QQComicJsPlugin", 1, "webViewFragment == null");
    a(paramString, "webViewFragment == null");
  }
  
  private void f(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    int i = paramJSONObject.optInt("alpha");
    if (paramWebViewFragment != null)
    {
      paramWebViewFragment.getSwiftTitleUI().b(i);
      return;
    }
    QLog.e("QQComicJsPlugin", 1, "webViewFragment == null");
    a(paramString, "webViewFragment == null");
  }
  
  public long a()
  {
    for (;;)
    {
      try
      {
        localObject2 = c();
        l1 = 0L;
        if (localObject2 == null) {
          return 0L;
        }
        localStack = new Stack();
        localStack.push(localObject2);
        if (localStack.isEmpty()) {
          continue;
        }
        localObject2 = new File((String)localStack.pop());
        l2 = l1;
        if (!((File)localObject2).isDirectory()) {
          continue;
        }
        arrayOfString = ((File)localObject2).list();
        l2 = l1;
        if (arrayOfString == null) {
          continue;
        }
        j = arrayOfString.length;
        i = 0;
      }
      finally
      {
        Object localObject2;
        long l1;
        Stack localStack;
        long l2;
        String[] arrayOfString;
        int j;
        int i;
        File localFile;
        continue;
        throw localObject1;
        continue;
        i += 1;
        continue;
      }
      l2 = l1;
      if (i < j)
      {
        localFile = new File((File)localObject2, arrayOfString[i]);
        if (localFile.isDirectory())
        {
          localStack.push(localFile.getAbsolutePath());
          continue;
        }
        l1 += localFile.length();
        continue;
      }
      l1 = ((File)localObject2).length();
      l1 = l2 + l1;
    }
    return l1;
  }
  
  public void a()
  {
    QQComicJsPluginProxy localQQComicJsPluginProxy = this.jdField_a_of_type_ComTencentComicJspQQComicJsPluginProxy;
    if (localQQComicJsPluginProxy != null) {
      localQQComicJsPluginProxy.a();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      f = paramString;
      boolean bool = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if (bool) {
        return;
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      ThreadManager.post(new QQComicJsPlugin.4(this), 5, null, true);
      return;
    }
    finally {}
  }
  
  void a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentComicJspQQComicJsPluginProxy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "create a new js plugin");
      }
      this.jdField_a_of_type_ComTencentComicJspQQComicJsPluginProxy = QQComicPluginBridge.a(this.mRuntime, this.jdField_a_of_type_ComTencentComicJspQQComicJsCallback);
    }
    QQComicJsPluginProxy localQQComicJsPluginProxy = this.jdField_a_of_type_ComTencentComicJspQQComicJsPluginProxy;
    if (localQQComicJsPluginProxy != null)
    {
      localQQComicJsPluginProxy.a(paramString1, paramJSONObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "create js plugin failed");
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("code", 2002);
        paramString1.put("message", "create js plugin failed");
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      super.callJs(paramString2, new String[] { paramString1.toString() });
    }
  }
  
  public void a(String paramString1, JSONObject paramJSONObject, String paramString2, long paramLong)
  {
    jdField_a_of_type_AndroidOsHandler.post(new QQComicJsPlugin.3(this, paramLong, paramString1, paramJSONObject, paramString2));
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 258L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934601L)
    {
      if (!TextUtils.isEmpty(this.e))
      {
        super.callJs(this.e, new String[] { "" });
        return true;
      }
    }
    else if ((paramLong == 2L) || (paramLong == 256L)) {
      b();
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      QLog.d("QQComicJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if (("comic".equals(paramString2)) && (paramString1 != null)) {
      if (paramString3 == null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        if (paramVarArgs.length > 0) {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        } else {
          paramJsBridgeListener = new JSONObject();
        }
        paramString1 = paramJsBridgeListener.optString("callback", "");
        paramString2 = this.mRuntime.a();
        paramVarArgs = (WebViewFragment)this.mRuntime.a();
        boolean bool = "getFirstShowData".equals(paramString3);
        if (bool)
        {
          paramJsBridgeListener = (String)VipComicDataHelper.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
          paramString2 = new JSONObject();
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2.put("code", 0);
            paramString2.put("message", "ok");
            paramString2.put("data", paramJsBridgeListener);
            break label1354;
          }
          paramString2.put("code", -1);
          paramString2.put("message", HardCodeUtil.a(1996881922));
          paramString2.put("data", "");
          break label1354;
          super.callJs(paramString1, new String[] { paramString2.toString() });
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("js getFirstShowData:");
            paramString1.append(paramJsBridgeListener);
            QLog.d("QQComicJsPlugin", 2, paramString1.toString());
          }
        }
        else if ("setTitleBarBackground".equals(paramString3))
        {
          f(paramJsBridgeListener, paramString1, paramVarArgs);
        }
        else if ("onWebViewScrollChanged".equals(paramString3))
        {
          d(paramString1, paramVarArgs);
        }
        else if ("setTitleName".equals(paramString3))
        {
          e(paramJsBridgeListener, paramString1, paramVarArgs);
        }
        else if ("attachSwitchChannel".equals(paramString3))
        {
          d(paramJsBridgeListener, paramString1, paramVarArgs);
        }
        else if ("setSwitchChannel".equals(paramString3))
        {
          c(paramJsBridgeListener, paramString1, paramVarArgs);
        }
        else if ("getSwitchChannel".equals(paramString3))
        {
          c(paramString1, paramVarArgs);
        }
        else if ("showSwitchChannel".equals(paramString3))
        {
          b(paramString1, paramVarArgs);
        }
        else if ("hideSwitchChannel".equals(paramString3))
        {
          a(paramString1, paramVarArgs);
        }
        else if ("setTabRedPoint".equals(paramString3))
        {
          b(paramJsBridgeListener, paramString1, paramVarArgs);
        }
        else if ("getTitleBarHeight".equals(paramString3))
        {
          paramJsBridgeListener = new JSONObject();
          paramString2 = new JSONObject();
          int j = this.mRuntime.a().getResources().getDimensionPixelSize(2131299168);
          i = j;
          if (ImmersiveUtils.isSupporImmersive() == 1) {
            i = j + ImmersiveUtils.getStatusBarHeight(this.mRuntime.a());
          }
          paramString2.put("height", i);
          paramJsBridgeListener.put("code", 0);
          paramJsBridgeListener.put("message", "ok");
          paramJsBridgeListener.put("data", paramString2);
          super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
        }
        else if ("openQQBrowser".equals(paramString3))
        {
          paramString1 = new Intent();
          paramString1.putExtra("url", paramJsBridgeListener.optString("url"));
          VipComicHelper.a(paramString2, paramString1, -1);
        }
        else if ("closeCurrentWebview".equals(paramString3))
        {
          if (!paramString2.isFinishing()) {
            paramString2.finish();
          }
        }
        else if ("setTitleAndBottomBar".equals(paramString3))
        {
          a(paramJsBridgeListener, paramString1, (SwiftWebViewFragmentSupporter)paramString2, paramVarArgs);
        }
        else if ("setLeftCallback".equals(paramString3))
        {
          this.e = paramJsBridgeListener.optString("leftcallback");
        }
        else if ("openView".equals(paramString3))
        {
          paramString1 = paramJsBridgeListener.getJSONObject("options");
          paramJsBridgeListener = paramJsBridgeListener.optString("name");
          paramString3 = new Intent();
          paramString3.setComponent(new ComponentName("com.tencent.mobileqq", paramJsBridgeListener));
          paramString3.putExtra("options", paramString1.toString());
          paramString2.startActivity(paramString3);
        }
        else if ("getReporterInfo".equals(paramString3))
        {
          paramJsBridgeListener = new JSONObject();
          paramString2 = new JSONObject();
          paramString2.put("mod", VipComicDataHelper.jdField_a_of_type_JavaLangString);
          paramString2.put("land_page", VipComicDataHelper.c);
          paramString2.put("obj_ownerid", VipComicDataHelper.b);
          paramJsBridgeListener.put("data", paramString2);
          paramJsBridgeListener.put("resultCode", 0);
          paramJsBridgeListener.put("message", "ok");
          super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
        }
        else if ("getCacheSize".equals(paramString3))
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("result", 0);
          paramJsBridgeListener.put("message", "ok");
          paramString2 = new JSONObject();
          paramString2.put("size", a());
          if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            break label1357;
          }
          i = 1;
          paramString2.put("status", i);
          paramJsBridgeListener.put("data", paramString2);
          super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
        }
        else if ("clearCache".equals(paramString3))
        {
          a(paramString1);
        }
        else if ("initPrivateSettingIcon".equals(paramString3))
        {
          a(paramJsBridgeListener, paramString1, paramVarArgs);
        }
        else if ("openWebBundleView".equals(paramString3))
        {
          c(paramJsBridgeListener);
        }
        else if ("setColorfulTabInfo".equals(paramString3))
        {
          bool = QLog.isColorLevel();
          if (bool)
          {
            paramString1 = new StringBuilder();
            paramString1.append("setColorfulTabInfo ");
            paramString1.append(paramJsBridgeListener.optString("tabTitle", "fail"));
            QLog.d("QQComicJsPlugin", 2, paramString1.toString());
          }
          this.c = paramJsBridgeListener.optString("tabTitle", "");
          this.d = paramJsBridgeListener.optString("tabSubTitle", "");
        }
        else if ("setWebBundleOption".equals(paramString3))
        {
          b(paramJsBridgeListener);
        }
        else if ("setShareOption".equals(paramString3))
        {
          a(paramJsBridgeListener);
        }
        else if ("setContainerInfo".equals(paramString3))
        {
          this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramJsBridgeListener.optString("read_params"));
          VipComicDataHelper.jdField_a_of_type_ComTencentComicDataExtraParams.b(this.jdField_a_of_type_OrgJsonJSONObject);
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("setContainerInfo success extrasParams: ");
            paramJsBridgeListener.append(VipComicDataHelper.jdField_a_of_type_ComTencentComicDataExtraParams.toString());
            QLog.d("QQComicJsPlugin", 2, paramJsBridgeListener.toString());
          }
        }
        else if (QQComicPluginBridge.a)
        {
          ThreadManager.getUIHandler().post(new QQComicJsPlugin.2(this, paramString3, paramJsBridgeListener, paramString1));
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "js plugin is not ready...");
          }
          a(paramString3, paramJsBridgeListener, paramString1, 3000L);
        }
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        QLog.e("QQComicJsPlugin", 1, "handle js error!", paramJsBridgeListener);
        return true;
      }
      return false;
      label1354:
      continue;
      label1357:
      int i = 2;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QQComicJsPluginProxy localQQComicJsPluginProxy = this.jdField_a_of_type_ComTencentComicJspQQComicJsPluginProxy;
    if (localQQComicJsPluginProxy != null) {
      localQQComicJsPluginProxy.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.jsp.QQComicJsPlugin
 * JD-Core Version:    0.7.0.1
 */