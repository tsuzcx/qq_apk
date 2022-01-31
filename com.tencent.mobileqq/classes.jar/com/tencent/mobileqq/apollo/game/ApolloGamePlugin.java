package com.tencent.mobileqq.apollo.game;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ApolloGamePlugin
  extends VasWebviewJsPlugin
{
  public static List a;
  private ApolloJSContext jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
  private String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ApolloGamePlugin()
  {
    this.mPluginNameSpace = "apolloGame";
    if (jdField_a_of_type_JavaUtilList != null) {
      jdField_a_of_type_JavaUtilList.add(new WeakReference(this));
    }
    if ((ApolloGameActivity.a != null) && (ApolloGameActivity.a.get() != null))
    {
      ApolloGameView localApolloGameView = ((ApolloGameActivity)ApolloGameActivity.a.get()).a();
      if (localApolloGameView != null) {
        this.jdField_a_of_type_JavaLangString = String.valueOf(localApolloGameView.a());
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(paramInt, paramString1, paramString2);
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
    if (paramLong == 8L) {
      try
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("_gameid")))
        {
          String str = Uri.parse(paramString).getQueryParameter("_gameid");
          if ((!TextUtils.isEmpty(str)) && (str.trim().equals(this.jdField_a_of_type_JavaLangString)))
          {
            paramString = ApolloGameResManager.a().a(paramString, this.jdField_a_of_type_JavaLangString);
            if (paramString == null) {
              return null;
            }
            paramString = paramString.a();
            return paramString;
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGamePlugin", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (8589934593L == paramLong) {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext == null) && (this.mRuntime != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext = new ApolloJSContext();
        this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(this.mRuntime.a());
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (8589934594L == paramLong)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.e();
        }
      }
      else if (8589934595L != paramLong) {
        if (8589934597L == paramLong) {
          a(0, "sc.game_enter_background.local", "{}");
        } else if (2L == paramLong) {
          a(0, "sc.game_enter_foreground.local", "{}");
        }
      }
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
            break label181;
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
    label181:
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
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.f();
      ApolloGameResManager.a().a();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGamePlugin
 * JD-Core Version:    0.7.0.1
 */