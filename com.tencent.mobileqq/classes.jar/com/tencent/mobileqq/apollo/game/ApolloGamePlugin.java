package com.tencent.mobileqq.apollo.game;

import akpk;
import akpm;
import akpr;
import alpo;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import becq;
import behg;
import bepp;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import zbj;

public class ApolloGamePlugin
  extends VasWebviewJsPlugin
{
  private static int jdField_a_of_type_Int;
  public static List<WeakReference<ApolloGamePlugin>> a;
  private akpr jdField_a_of_type_Akpr;
  protected BroadcastReceiver a;
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
    boolean bool2 = true;
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = a(paramString);
      if ((!TextUtils.isEmpty(str)) && (str.endsWith(".js")))
      {
        bool1 = true;
        if ((!bool1) && (!TextUtils.isEmpty(this.b)))
        {
          str = this.b;
          paramString = a(paramString);
          str = a(str);
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)) && (paramString.trim().equals(str.trim()))) {
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
      continue;
      continue;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() < 500)) {
      QLog.e("sava", 1, paramString);
    }
  }
  
  public void a()
  {
    if (this.mRuntime != null) {}
    for (;;)
    {
      try
      {
        Object localObject1 = this.mRuntime.a(this.mRuntime.a());
        if ((localObject1 != null) && ((localObject1 instanceof behg)))
        {
          localObject1 = (behg)localObject1;
          if (localObject1 != null)
          {
            localObject1 = ((behg)localObject1).a().a();
            if ((localObject1 != null) && (((bepp)localObject1).isShowing())) {
              ((bepp)localObject1).dismiss();
            }
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloGamePlugin", 1, localThrowable, new Object[0]);
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Akpr != null) {
      this.jdField_a_of_type_Akpr.a(paramInt, paramString1, paramString2);
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
    if (this.jdField_a_of_type_Akpr != null) {
      this.jdField_a_of_type_Akpr.a(0, paramString1, paramString2);
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
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
          Object localObject = Uri.parse(paramString).getQueryParameter("_gameid");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!URLUtil.isNetworkUrl(paramString))) {
            break label211;
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label168;
          }
          if (((String)localObject).trim().equals(this.jdField_a_of_type_JavaLangString))
          {
            localObject = akpk.a().a(paramString, this.jdField_a_of_type_JavaLangString);
            if (localObject == null)
            {
              b(alpo.a(2131700731) + paramString);
              if (!bool) {
                break;
              }
              return new WebResourceResponse();
            }
            return ((akpm)localObject).a();
          }
          paramString = new WebResourceResponse();
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGamePlugin", 1, paramString, new Object[0]);
      }
      label168:
      label211:
      do
      {
        return null;
        b(alpo.a(2131700752) + paramString);
        if (bool)
        {
          paramString = new WebResourceResponse();
          return paramString;
        }
        return null;
      } while (!bool);
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (8589934593L == paramLong)
    {
      if ((this.jdField_a_of_type_Akpr == null) && (this.mRuntime != null))
      {
        this.jdField_a_of_type_Akpr = new akpr(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Akpr.a(this.mRuntime.a());
      }
      if (this.jdField_a_of_type_Akpr != null) {
        this.jdField_a_of_type_Akpr.a(this.jdField_a_of_type_Boolean);
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (8589934594L == paramLong)
      {
        if (this.jdField_a_of_type_Akpr != null) {
          this.jdField_a_of_type_Akpr.b(this.jdField_a_of_type_Boolean);
        } else {
          QLog.e("ApolloGamePlugin", 1, "[handleEvent] jscontext is null");
        }
      }
      else if (8589934595L != paramLong) {}
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
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
            break label188;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGamePlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject).toString() + " " + paramString3);
          }
          if (paramString3.equals("send"))
          {
            if (this.jdField_a_of_type_Akpr == null) {
              continue;
            }
            String str = ((JSONObject)localObject).optString("cmd");
            localObject = ((JSONObject)localObject).optString("dataStr");
            if (this.jdField_a_of_type_Akpr != null) {
              this.jdField_a_of_type_Akpr.a(str, (String)localObject);
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
    label188:
    return bool;
  }
  
  public void onCreate()
  {
    super.onCreate();
    jdField_a_of_type_Int += 1;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Akpr != null) {
      this.jdField_a_of_type_Akpr.b();
    }
    jdField_a_of_type_Int -= 1;
    if (jdField_a_of_type_Int == 0) {
      akpk.a().a();
    }
    try
    {
      if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.mRuntime != null)) {
        this.mRuntime.a().getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloGamePlugin", 1, "[doDestroy] exception=", localException);
      }
    }
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    Intent localIntent = getInfoIntent();
    if (localIntent != null)
    {
      String str = localIntent.getStringExtra("game_busid");
      if (!TextUtils.isEmpty(str))
      {
        a(str);
        if ((this.jdField_a_of_type_Akpr == null) && (paramCustomWebView != null))
        {
          this.jdField_a_of_type_Akpr = new akpr(str);
          this.jdField_a_of_type_Akpr.a(this.mRuntime.a());
          this.b = localIntent.getStringExtra("url");
          this.jdField_a_of_type_Boolean = true;
        }
      }
      return;
    }
    QLog.e("ApolloGamePlugin", 1, "bus empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGamePlugin
 * JD-Core Version:    0.7.0.1
 */