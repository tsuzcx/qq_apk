package com.tencent.mobileqq.apollo.game;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ApolloGamePlugin
  extends VasWebviewJsPlugin
  implements IPreCreatePluginChecker
{
  private static int jdField_a_of_type_Int;
  public static List<WeakReference<ApolloGamePlugin>> a;
  protected BroadcastReceiver a;
  private ApolloJSContext jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ApolloGamePlugin()
  {
    this.mPluginNameSpace = "apolloGame";
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf("?");
      str = paramString;
      if (i >= 0)
      {
        str = paramString;
        if (i < paramString.length()) {
          str = paramString.substring(0, i);
        }
      }
    }
    return str;
  }
  
  private boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!"Android.H5".equals(this.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(String paramString)
  {
    boolean bool1 = this.jdField_a_of_type_Boolean;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = a(paramString);
      if ((!TextUtils.isEmpty(str)) && (str.endsWith(".js"))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((!bool1) && (!TextUtils.isEmpty(this.b)))
      {
        str = this.b;
        paramString = a(paramString);
        str = a(str);
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(str))
          {
            bool1 = bool2;
            if (paramString.trim().equals(str.trim())) {
              return true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() < 500)) {
      QLog.e("sava", 1, paramString);
    }
  }
  
  public void a()
  {
    if (this.mRuntime == null) {
      return;
    }
    Object localObject2 = null;
    try
    {
      WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
      Object localObject1 = localObject2;
      if (localWebUiBaseInterface != null)
      {
        localObject1 = localObject2;
        if ((localWebUiBaseInterface instanceof WebUiUtils.WebShareInterface)) {
          localObject1 = (WebUiUtils.WebShareInterface)localWebUiBaseInterface;
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((Share)((WebUiUtils.WebShareInterface)localObject1).getShare()).a();
        if ((localObject1 != null) && (((QQProgressDialog)localObject1).isShowing()))
        {
          ((QQProgressDialog)localObject1).dismiss();
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloGamePlugin", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    ApolloJSContext localApolloJSContext = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
    if (localApolloJSContext != null) {
      localApolloJSContext.a(paramInt, paramString1, paramString2);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      jdField_a_of_type_JavaUtilList.add(new WeakReference(this));
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ApolloGamePlugin.GameEventReceiver(this);
    paramString = new IntentFilter();
    paramString.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    try
    {
      if (this.mRuntime != null)
      {
        AppInterface localAppInterface = this.mRuntime.a();
        if (localAppInterface != null)
        {
          localAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramString, "com.tencent.msg.permission.pushnotify", null);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow]ApolloGamePlugin", 1, paramString, new Object[0]);
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8L;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      if (!a()) {
        return null;
      }
    }
    for (;;)
    {
      boolean bool;
      try
      {
        bool = a(paramString);
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        Object localObject = Uri.parse(paramString).getQueryParameter("_gameid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (URLUtil.isNetworkUrl(paramString)))
        {
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131700602));
            ((StringBuilder)localObject).append(paramString);
            b(((StringBuilder)localObject).toString());
            if (!bool) {
              break;
            }
            return new WebResourceResponse();
          }
          if (!((String)localObject).trim().equals(this.jdField_a_of_type_JavaLangString)) {
            return new WebResourceResponse();
          }
          localObject = ApolloGameResManager.a().a(paramString, this.jdField_a_of_type_JavaLangString);
          if (localObject == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131700581));
            ((StringBuilder)localObject).append(paramString);
            b(((StringBuilder)localObject).toString());
            if (!bool) {
              break label241;
            }
            return new WebResourceResponse();
          }
          paramString = ((ApolloGameResManager.ApolloGameRes)localObject).a();
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("[cmshow]ApolloGamePlugin", 1, paramString, new Object[0]);
      }
      while (!bool) {
        return null;
      }
    }
    return null;
    label241:
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    ApolloJSContext localApolloJSContext;
    if (8589934593L == paramLong)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext == null) && (this.mRuntime != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext = new ApolloJSContext(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(this.mRuntime.a());
      }
      localApolloJSContext = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
      if (localApolloJSContext != null) {
        localApolloJSContext.a(this.jdField_a_of_type_Boolean);
      }
    }
    else if (8589934594L == paramLong)
    {
      localApolloJSContext = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
      if (localApolloJSContext != null) {
        localApolloJSContext.b(this.jdField_a_of_type_Boolean);
      } else {
        QLog.e("[cmshow]ApolloGamePlugin", 1, "[handleEvent] jscontext is null");
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (paramString1 != null)
    {
      try
      {
        if (!"apolloGame".equals(paramString2)) {
          break label199;
        }
        if (paramString3 == null) {
          return false;
        }
        Object localObject1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (localObject1 == null) {
          return true;
        }
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleJsRequest JSON = ");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(paramString3);
          QLog.d("[cmshow]ApolloGamePlugin", 2, ((StringBuilder)localObject2).toString());
        }
        if (paramString3.equals("send")) {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null)
          {
            localObject2 = ((JSONObject)localObject1).optString("cmd");
            localObject1 = ((JSONObject)localObject1).optString("dataStr");
            if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a((String)localObject2, (String)localObject1);
            }
          }
          else
          {
            QLog.e("[cmshow]ApolloGamePlugin", 1, "[handleJsRequest] jscontext null");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]ApolloGamePlugin", 1, localThrowable, new Object[] { "[handleJsRequest]" });
      }
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    label199:
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return paramString1.contains("apollo_bk");
  }
  
  protected void onCreate()
  {
    super.onCreate();
    jdField_a_of_type_Int += 1;
  }
  
  protected void onDestroy()
  {
    ApolloJSContext localApolloJSContext = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
    if (localApolloJSContext != null) {
      localApolloJSContext.a();
    }
    jdField_a_of_type_Int -= 1;
    if (jdField_a_of_type_Int == 0) {
      ApolloGameResManager.a().a();
    }
    try
    {
      if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.mRuntime != null)) {
        this.mRuntime.a().getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloGamePlugin", 1, "[doDestroy] exception=", localException);
    }
    super.onDestroy();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    Intent localIntent = getInfoIntent();
    if (localIntent == null)
    {
      QLog.e("[cmshow]ApolloGamePlugin", 1, "bus empty");
      return;
    }
    String str = localIntent.getStringExtra("game_busid");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    a(str);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext == null) && (paramCustomWebView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext = new ApolloJSContext(str);
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(this.mRuntime.a());
      this.b = localIntent.getStringExtra("url");
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGamePlugin
 * JD-Core Version:    0.7.0.1
 */