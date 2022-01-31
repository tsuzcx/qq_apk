package com.tencent.mobileqq.apollo.game;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
{
  public static List a;
  protected BroadcastReceiver a;
  private ApolloJSContext jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
  private String jdField_a_of_type_JavaLangString = "";
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
    boolean bool2 = true;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = a(paramString);
      if ((!TextUtils.isEmpty(str)) && (str.endsWith(".js"))) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((!bool1) && (!TextUtils.isEmpty(this.b)))
        {
          str = this.b;
          paramString = a(paramString);
          str = a(str);
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)) && (paramString.trim().equals(str.trim()))) {}
          for (bool1 = bool2;; bool1 = false)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGamePlugin", 2, "[isEntryRes] " + paramString + " # " + str + " # " + bool1);
            }
            return bool1;
          }
        }
        return bool1;
      }
    }
    return false;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(paramInt, paramString1, paramString2);
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
        if (localAppInterface != null) {
          localAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramString, "com.tencent.msg.permission.pushnotify", null);
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGamePlugin", 1, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(0, paramString1, paramString2);
    }
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (a())) {}
    for (;;)
    {
      boolean bool;
      try
      {
        bool = a(paramString);
        if (!TextUtils.isEmpty(paramString))
        {
          if ((!paramString.contains("_gameid")) || (!URLUtil.isNetworkUrl(paramString))) {
            break label150;
          }
          String str = Uri.parse(paramString).getQueryParameter("_gameid");
          if (TextUtils.isEmpty(str)) {
            break label140;
          }
          if (str.trim().equals(this.jdField_a_of_type_JavaLangString))
          {
            paramString = ApolloGameResManager.a().a(paramString, this.jdField_a_of_type_JavaLangString);
            if (paramString == null)
            {
              if (!bool) {
                break;
              }
              return new WebResourceResponse();
            }
            return paramString.a();
          }
          paramString = new WebResourceResponse();
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGamePlugin", 1, paramString, new Object[0]);
      }
      label140:
      label150:
      do
      {
        return null;
        paramString = new WebResourceResponse();
        return paramString;
      } while (!bool);
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (8589934593L == paramLong) {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext == null) && (this.mRuntime != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext = new ApolloJSContext(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(this.mRuntime.a());
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (8589934594L == paramLong)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a();
        } else {
          QLog.e("ApolloGamePlugin", 1, "[handleEvent] jscontext is null");
        }
      }
      else if (8589934595L != paramLong) {}
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = true;
    if (paramString1 != null) {
      for (;;)
      {
        try
        {
          if ((!"apolloGame".equals(paramString2)) || (paramString3 == null)) {
            break;
          }
          Object localObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
          if (localObject == null) {
            break label184;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGamePlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject).toString() + " " + paramString3);
          }
          if (paramString3.equals("send"))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext == null) {
              continue;
            }
            String str = ((JSONObject)localObject).optString("cmd");
            localObject = ((JSONObject)localObject).optString("dataStr");
            if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(str, (String)localObject);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloGamePlugin", 1, localThrowable, new Object[] { "[handleJsRequest]" });
          continue;
        }
        return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
        QLog.e("ApolloGamePlugin", 1, "[handleJsRequest] jscontext null");
      }
    }
    bool = false;
    label184:
    return bool;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.b();
      ApolloGameResManager.a().a();
    }
    try
    {
      if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.mRuntime != null)) {
        this.mRuntime.a().getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      ApolloGameTimeReporter.a();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloGamePlugin", 1, "[doDestroy] exception=", localException);
      }
    }
    super.onDestroy();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    Intent localIntent = getInfoIntent();
    if (localIntent != null)
    {
      String str = localIntent.getStringExtra("game_busid");
      if (!TextUtils.isEmpty(str))
      {
        a(str);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext == null) && (paramCustomWebView != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext = new ApolloJSContext(str);
          this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(this.mRuntime.a());
          this.b = localIntent.getStringExtra("url");
        }
      }
      return;
    }
    QLog.e("ApolloGamePlugin", 1, "bus empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGamePlugin
 * JD-Core Version:    0.7.0.1
 */