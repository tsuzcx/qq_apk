package com.tencent.mobileqq.apollo.web.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController;
import com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.apollo.utils.CmShowCECapabilitiesChecker;
import com.tencent.mobileqq.apollo.utils.Dispatcher;
import com.tencent.mobileqq.apollo.utils.ResponseUtil;
import com.tencent.mobileqq.apollo.web.CmshowWebReqParam;
import com.tencent.mobileqq.apollo.web.api.IApolloJsPlugin;
import com.tencent.mobileqq.apollo.web.jsmodule.Avatar2DJsModule;
import com.tencent.mobileqq.apollo.web.jsmodule.LightGameJsModule;
import com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule;
import com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule;
import com.tencent.mobileqq.apollo.web.jsmodule.PendantAvatarJsModule;
import com.tencent.mobileqq.apollo.web.jsmodule.StoreJsModule;
import com.tencent.mobileqq.apollo.web.jsmodule.ThunderJsModule;
import com.tencent.mobileqq.apollo.web.jsmodule.WhiteFaceJsModule;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ApolloJsPluginImpl
  extends VasWebviewJsPlugin
  implements IApolloJsPlugin, IPreCreatePluginChecker
{
  private static final String TAG = "[cmshow]ApolloJsPlugin";
  private static ApolloJsPluginImpl.ApolloReceiver sApolloReceiver = new ApolloJsPluginImpl.ApolloReceiver(null);
  private ApolloStoreViewController mApolloViewController;
  private Avatar2DJsModule mAvatar2DJsModule;
  private PendantAvatarJsModule mAvatarModule;
  private Dispatcher<CmshowWebReqParam> mDispatcher = new Dispatcher();
  protected ApolloUrlInterceptor mInterceptor;
  private String mInterceptorUrl;
  private Makeup2DJsModule mMakeup2DJsModule;
  private Makeup3DJsModule mMakeup3DModule;
  private boolean mNeedCreateInterceptor;
  public Bundle mReqBundle;
  private ApolloPluginRscLoader mRscLoader;
  private StoreJsModule mStoreJsModule;
  private ApolloJsPluginImpl.CmStoreUserInfo mStoreUserInfo = new ApolloJsPluginImpl.CmStoreUserInfo();
  private ThunderJsModule mThunderJsModule;
  private WhiteFaceJsModule mWhiteFaceJsModule;
  
  public ApolloJsPluginImpl()
  {
    this.mPluginNameSpace = "apollo";
    this.mDispatcher.a(new LightGameJsModule(this));
    this.mMakeup3DModule = new Makeup3DJsModule(this);
    this.mDispatcher.a(this.mMakeup3DModule);
    this.mAvatarModule = new PendantAvatarJsModule(this);
    this.mDispatcher.a(this.mAvatarModule);
    this.mThunderJsModule = new ThunderJsModule(this);
    this.mDispatcher.a(this.mThunderJsModule);
    this.mStoreJsModule = new StoreJsModule(this);
    this.mDispatcher.a(this.mStoreJsModule);
    this.mAvatar2DJsModule = new Avatar2DJsModule(this);
    this.mDispatcher.a(this.mAvatar2DJsModule);
    this.mMakeup2DJsModule = new Makeup2DJsModule(this);
    this.mDispatcher.a(this.mMakeup2DJsModule);
    this.mWhiteFaceJsModule = new WhiteFaceJsModule(this);
    this.mDispatcher.a(this.mWhiteFaceJsModule);
  }
  
  private void callbackError(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
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
      QLog.e("[cmshow]ApolloJsPlugin", 1, localException.getMessage());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("callbackId->");
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append(" errorMsg: ");
      localStringBuilder1.append(paramString2);
      QLog.e("[cmshow]ApolloJsPlugin", 2, localStringBuilder1.toString());
    }
  }
  
  private Object getResponseAvatar(String paramString)
  {
    File localFile;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("https://cmshow.qq.com/qq_cms_avatar/")) {
        return null;
      }
      paramString = paramString.replace("https://cmshow.qq.com/qq_cms_avatar/", "");
      if (!TextUtils.isEmpty(paramString))
      {
        if (!this.mAvatarModule.b.containsKey(paramString)) {
          return null;
        }
        paramString = (ApolloJsPluginImpl.AvatarInfo)this.mAvatarModule.b.get(paramString);
        if (paramString != null)
        {
          if (TextUtils.isEmpty(paramString.a)) {
            return null;
          }
          localFile = new File(paramString.a);
          if (!localFile.exists()) {
            return null;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (paramString.b != 1) {
          break label157;
        }
        paramString = "image/gif";
        paramString = new WebResourceResponse(paramString, "utf-8", new FileInputStream(localFile));
        ResponseUtil.a(paramString);
        return paramString;
      }
      catch (FileNotFoundException paramString)
      {
        QLog.e("[cmshow]ApolloJsPlugin", 1, "getResponseAvatar exception ", paramString);
      }
      return null;
      label157:
      paramString = "image/png";
    }
  }
  
  public void createInterceptor()
  {
    String str = this.mInterceptorUrl;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.mInterceptor = ApolloUrlInterceptor.a(true, str);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "apollo_client onApolloJsCreate ApolloWebDataHandler.isInstanceCreated():true");
    }
  }
  
  public String getAbsoluteUrl()
  {
    if (this.mRuntime != null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        return localCustomWebView.getUrl();
      }
    }
    return "";
  }
  
  public Activity getActivity()
  {
    Activity localActivity = this.mRuntime.d();
    if ((localActivity != null) && (!localActivity.isFinishing()) && (!this.isDestroy)) {
      return localActivity;
    }
    return null;
  }
  
  public ApolloStoreViewController getApolloStoreViewController()
  {
    return this.mApolloViewController;
  }
  
  public ApolloJsPluginImpl.CmStoreUserInfo getCmStoreUserInfo()
  {
    return this.mStoreUserInfo;
  }
  
  public ApolloUrlInterceptor getInterceptor()
  {
    return this.mInterceptor;
  }
  
  public JSONObject getThunderJson(boolean paramBoolean)
  {
    Object localObject = getInterceptor();
    if ((localObject != null) && (((ApolloUrlInterceptor)localObject).b() != null))
    {
      if ((paramBoolean) && (!((ApolloUrlInterceptor)localObject).a()))
      {
        QLog.d("[cmshow]ApolloJsPlugin", 2, "apollo_client_apolloWebStatistics checkRunSuccess fail");
        return null;
      }
      localObject = ((ApolloUrlInterceptor)localObject).b();
      try
      {
        int i = ((ApolloWebStatistics)localObject).i;
        throw new NullPointerException();
      }
      catch (JSONException localJSONException)
      {
        QLog.e("[cmshow]ApolloJsPlugin", 1, "apollo_client_apolloWebStatistics getThunderJson error:", localJSONException);
        if (QLog.isColorLevel())
        {
          new StringBuilder().append("apollo_client_apolloWebStatistics:");
          throw new NullPointerException();
        }
      }
    }
    return null;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 40L;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" handleEvent url:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("[cmshow]ApolloJsPlugin", 1, ((StringBuilder)localObject).toString());
        }
        Object localObject = this.mInterceptor;
        if (localObject != null)
        {
          localObject = this.mInterceptor.c(paramString);
          if (localObject != null)
          {
            if (!QLog.isColorLevel()) {
              break label340;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("apollo_client handleEvent response-> ");
            localStringBuilder.append(localObject);
            localStringBuilder.append(",url:");
            localStringBuilder.append(paramString);
            QLog.d("[cmshow]ApolloJsPlugin", 1, localStringBuilder.toString());
            return localObject;
          }
        }
        if (this.mRscLoader == null) {
          this.mRscLoader = new ApolloPluginRscLoader(this);
        }
        localObject = this.mRscLoader.a(paramString);
        if (localObject != null)
        {
          if (!QLog.isColorLevel()) {
            break label343;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mRscLoader handleEvent response-> ");
          localStringBuilder.append(localObject);
          localStringBuilder.append(",url:");
          localStringBuilder.append(paramString);
          QLog.d("[cmshow]ApolloJsPlugin", 1, localStringBuilder.toString());
          return localObject;
        }
        localObject = getResponseAvatar(paramString);
        if (localObject != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getAvatar handleEvent response, url:");
            localStringBuilder.append(paramString);
            QLog.d("[cmshow]ApolloJsPlugin", 1, localStringBuilder.toString());
          }
          return localObject;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleEvent intercept by apolloClient error -> ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("[cmshow]ApolloJsPlugin", 1, localStringBuilder.toString());
      }
    } else {
      return super.handleEvent(paramString, paramLong);
    }
    label340:
    return localException;
    label343:
    return localException;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject;
    if (32L == paramLong)
    {
      if ((this.mNeedCreateInterceptor) && (this.mInterceptor == null))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("apollo_client handleEvent reinited ApolloUrlInterceptor,url:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("[cmshow]ApolloJsPlugin", 1, ((StringBuilder)localObject).toString());
        }
        this.mInterceptor = ApolloUrlInterceptor.a(true, paramString);
        this.mNeedCreateInterceptor = false;
      }
      localObject = this.mInterceptor;
      if (localObject != null)
      {
        ((ApolloUrlInterceptor)localObject).a(this.mRuntime.a());
        return this.mInterceptor.b(paramString);
      }
    }
    else if (8589934597L == paramLong)
    {
      localObject = this.mApolloViewController;
      if (localObject != null) {
        ((ApolloStoreViewController)localObject).e();
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("[cmshow]ApolloJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("apollo".equals(paramString2)) && (paramString3 != null))
    {
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleJsRequest JSON = ");
        paramString1.append(paramJsBridgeListener.toString());
        QLog.d("[cmshow]ApolloJsPlugin", 2, paramString1.toString());
      }
      paramString1 = paramJsBridgeListener.optString("callback");
      if (paramString1 == null) {
        callbackError(paramString1, "need callbackId");
      }
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("json:");
        paramString2.append(paramJsBridgeListener);
        QLog.d("[cmshow]ApolloJsPlugin", 2, paramString2.toString());
      }
      paramString2 = getActivity();
      if ((paramString2 != null) && (!this.isDestroy) && (!paramString2.isFinishing()))
      {
        paramVarArgs = new CmshowWebReqParam();
        paramVarArgs.a = paramJsBridgeListener;
        paramVarArgs.b = paramString1;
        paramVarArgs.c = paramString2;
        paramVarArgs.d = paramString3;
        paramVarArgs.e = getAbsoluteUrl();
        this.mDispatcher.a(paramString3, paramVarArgs);
        return true;
      }
      callbackError(paramString1, HardCodeUtil.a(2131898683));
      return true;
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    if (!paramString1.contains("thunder_id")) {
      return false;
    }
    this.mInterceptorUrl = paramString1;
    return true;
  }
  
  public void notifyCmShowFaceCameraResult(int paramInt, @NonNull String paramString1, @NonNull String paramString2)
  {
    this.mMakeup3DModule.a(paramInt, paramString1, paramString2);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "apollo_client onApolloJsCreate");
    }
    createInterceptor();
    ApolloEngine.isEngineReady();
    QRoute.api(ICmShowRscCacheManager.class);
    ((IAECMSShow)QRoute.api(IAECMSShow.class)).init3DCapabilityChecker();
    sApolloReceiver.a(this);
    CmShowCECapabilitiesChecker.a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.mInterceptor;
    if (localObject != null)
    {
      ((ApolloUrlInterceptor)localObject).c();
      this.mInterceptor = null;
    }
    localObject = this.mApolloViewController;
    if (localObject != null) {
      ((ApolloStoreViewController)localObject).f();
    }
    sApolloReceiver.b(this);
  }
  
  public void setApolloStoreViewController(ApolloStoreViewController paramApolloStoreViewController)
  {
    this.mApolloViewController = paramApolloStoreViewController;
  }
  
  public void setCmStoreUserInfo(ApolloJsPluginImpl.CmStoreUserInfo paramCmStoreUserInfo)
  {
    this.mStoreUserInfo = paramCmStoreUserInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl
 * JD-Core Version:    0.7.0.1
 */