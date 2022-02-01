package com.tencent.mobileqq.apollo.api.web.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloClientQIPCModule;
import com.tencent.mobileqq.apollo.CmShowLauncher;
import com.tencent.mobileqq.apollo.api.IApolloEngine;
import com.tencent.mobileqq.apollo.api.handler.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloWebDataHandlerImpl;
import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.ResponseUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.api.web.IApolloJsPlugin;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.apollo.lightGame.RobotDataUtil;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloViewController.PlayActionData;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import dov.com.qq.im.ae.cmshow.AECMShowUtil;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApolloJsPluginImpl
  extends VasWebviewJsPlugin
  implements OnApolloViewListener, IApolloJsPlugin, IPreCreatePluginChecker
{
  private static final int DEFAULT_HEIGHT;
  private static final int DEFAULT_WIDTH = (int)((float)(DeviceInfoUtil.k() >> 1) / DeviceInfoUtil.a());
  public static final String FACE_3D_DATA_JSON = "face.json";
  public static final String FACE_3D_DATA_ZIP = "face3d.zip";
  public static final int INITFROM_GETLOCALINFO = 3;
  public static final int INITFROM_GETROLE = 2;
  public static final int INITFROM_GETSWITCH = 4;
  public static final String TAG = "ApolloJsPlugin";
  private static final int TYPE_FROM_SHOW_APOLLOVIEW = 10000;
  private static ApolloJsPluginImpl.ApolloReceiver sApolloReceiver = new ApolloJsPluginImpl.ApolloReceiver(null);
  public static int sResponseKey;
  private static int sRoleGender;
  private boolean alreadyCallBack = false;
  private Map<String, ApolloJsPluginImpl.AvatarInfo> avatarKeyInfoMap = new HashMap();
  private int avatarWidth = (int)CmShowWnsUtils.a();
  private List<String> cmShow3DMehtodList = new ApolloJsPluginImpl.5(this);
  private QQCustomDialog gameDialog;
  public int mAISwitch;
  private int mApolloStatus;
  private ApolloViewController mApolloViewContoller;
  private CmGameStartChecker mCmGameStartChecker;
  private CmGameStartChecker.DefaultGameCheckListener mCmGameStartCheckerListener;
  private String mCmShowCameraCallBackId;
  private String mCurrentUin;
  private boolean mDataInited;
  private int[] mDressIds;
  private int mGender;
  public boolean mHasInited;
  protected ApolloUrlInterceptor mInterceptor;
  private String mInterceptorUrl;
  public boolean mIsAIRole = false;
  private long mLastGameTime = 0L;
  private String mLoadedCallBackId;
  private boolean mNeedCreateInterceptor;
  private HashMap<String, ApolloJsPluginImpl.ApiReportData> mReportDataHashMap = new HashMap();
  public Bundle mReqBundle;
  private int mRoleId = -1;
  private ApolloPluginRscLoader mRscLoader;
  private String mTab;
  private Vector<String> mValidAvatarIdList = new Vector();
  
  static
  {
    DEFAULT_HEIGHT = (int)(DeviceInfoUtil.l() * 0.4D / DeviceInfoUtil.a());
    sRoleGender = 0;
  }
  
  public ApolloJsPluginImpl()
  {
    this.mPluginNameSpace = "apollo";
  }
  
  private void callBackDownloadGamePercent(int paramInt)
  {
    ThreadManager.getUIHandler().post(new ApolloJsPluginImpl.14(this, paramInt));
  }
  
  private void callbackAvatarImage(JSONObject paramJSONObject)
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "callbackAvatarImage " + paramJSONObject.toString());
      }
      if (localCustomWebView != null) {
        localCustomWebView.callJs("javascript:mqq.dispatchEvent(\"onLoadAvatarImageEvent\"," + paramJSONObject.toString() + ")");
      }
    }
  }
  
  private String getAbsoluteUrl()
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
  
  private Activity getActivity()
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing()) || (this.isDestroy)) {
      localActivity = null;
    }
    return localActivity;
  }
  
  private IApolloJsCallBack getApolloJsCallBack()
  {
    WebViewFragment localWebViewFragment = getCurrentRuntimeFragment();
    if ((localWebViewFragment instanceof IApolloJsCallBack)) {
      return (IApolloJsCallBack)localWebViewFragment;
    }
    return null;
  }
  
  private WebViewFragment getCurrentRuntimeFragment()
  {
    if (this.mRuntime != null) {
      return (WebViewFragment)this.mRuntime.a();
    }
    return null;
  }
  
  private int getReportSpanId(String paramString)
  {
    if ("change3DAvatarComponent".equals(paramString)) {
      return 1;
    }
    return -1;
  }
  
  private Object getResponseAvatar(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("https://cmshow.qq.com/qq_cms_avatar/"))) {
      return null;
    }
    paramString = paramString.replace("https://cmshow.qq.com/qq_cms_avatar/", "");
    if ((TextUtils.isEmpty(paramString)) || (!this.avatarKeyInfoMap.containsKey(paramString))) {
      return null;
    }
    paramString = (ApolloJsPluginImpl.AvatarInfo)this.avatarKeyInfoMap.get(paramString);
    if ((paramString == null) || (TextUtils.isEmpty(paramString.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    File localFile = new File(paramString.jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (paramString.jdField_a_of_type_Int == 1)
        {
          paramString = "image/gif";
          paramString = new WebResourceResponse(paramString, "utf-8", new FileInputStream(localFile));
          ResponseUtil.a(paramString);
          return paramString;
        }
      }
      catch (FileNotFoundException paramString)
      {
        QLog.e("ApolloJsPlugin", 1, "getResponseAvatar exception ", paramString);
        return null;
      }
      paramString = "image/png";
    }
  }
  
  private boolean handleCmShow3DJsRequest(String paramString1, JSONObject paramJSONObject, String paramString2, Activity paramActivity)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null) || (paramActivity == null))
    {
      QLog.e("ApolloJsPlugin", 1, "handleCmShow3DJsRequest can not handle methodName : " + paramString1 + " callbackId: " + paramString2 + " activity: " + paramActivity);
      return false;
    }
    if (this.cmShow3DMehtodList.contains(paramString1))
    {
      ApolloJsPluginImpl.ApiReportData localApiReportData = new ApolloJsPluginImpl.ApiReportData(paramString1, System.currentTimeMillis());
      this.mReportDataHashMap.put(paramString2, localApiReportData);
      int i = getReportSpanId(paramString1);
      if (i > 0)
      {
        TraceReportUtil.a(131);
        TraceReportUtil.a(131, i);
      }
    }
    if ("init3DAvatar".equals(paramString1))
    {
      handleCmShowInit3DAvatar(paramJSONObject, paramString2, paramActivity);
      return true;
    }
    if ("change3DAvatarComponent".equals(paramString1))
    {
      handleCmShowChange3DAvatarComponent(paramJSONObject, paramString2, paramActivity);
      return true;
    }
    if ("getAll3DAvatarComponent".equals(paramString1))
    {
      handleCmShowGetAll3DAvatarComponent(paramJSONObject, paramString2, paramActivity);
      return true;
    }
    if ("load3DFaceDress".equals(paramString1))
    {
      handleCmShowLoad3DFaceDress(paramJSONObject, paramString2, paramActivity);
      return true;
    }
    if ("open3DDressUpPage".equals(paramString1)) {
      if (paramJSONObject == null) {
        break label480;
      }
    }
    label480:
    for (paramString1 = paramJSONObject.optString("url");; paramString1 = null)
    {
      CmShowLauncher.a(BaseApplicationImpl.getContext(), paramString1, null);
      return true;
      if ("open3DFaceRecognition".equals(paramString1))
      {
        handleOpenCmShowFaceCamera(paramActivity, paramString2);
        return true;
      }
      if ("set3DModeType".equals(paramString1))
      {
        handleCmShowSet3DModeType(paramJSONObject, paramString2, paramActivity);
        return true;
      }
      if ("set3DFace".equals(paramString1))
      {
        handleCmShowSet3DFace(paramJSONObject, paramString2, paramActivity);
        return true;
      }
      if ("get3DFace".equals(paramString1))
      {
        handleCmShowGet3DFace(paramJSONObject, paramString2, paramActivity);
        return true;
      }
      if ("get3DFaceFull".equals(paramString1))
      {
        handleCmShowGet3DFaceFull(paramJSONObject, paramString2, paramActivity);
        return true;
      }
      if ("set3DFaceFull".equals(paramString1))
      {
        handleCmShowSet3DFaceFull(paramJSONObject, paramString2, paramActivity);
        return true;
      }
      if ("save3DFace".equals(paramString1))
      {
        handleSave3DFaceData(paramJSONObject, paramString2, paramActivity);
        return true;
      }
      if ("supportAEKit".equals(paramString1))
      {
        if (CmShowWnsUtils.f())
        {
          callbackError(paramString2, "AEKit blacklist device");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloJsPlugin", 1, "AEKit blacklist device");
          }
        }
        for (;;)
        {
          return true;
          if (AECMShowUtil.a())
          {
            callbackOk(paramString2);
          }
          else
          {
            callbackError(paramString2, "not supportAEKit");
            if (QLog.isColorLevel()) {
              QLog.d("ApolloJsPlugin", 1, "not supportAEKit");
            }
          }
        }
      }
      if (!"is3DDressLoaded".equals(paramString1)) {
        break;
      }
      handleIs3DDressLoaded(paramJSONObject, paramString2, paramActivity);
      return true;
    }
  }
  
  private boolean handleCmShowAvatarJSRequest(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if ("setSpriteAvatar".equals(paramString1))
    {
      handleSetSpriteAvatar(paramJSONObject, paramString2);
      return true;
    }
    if ("getAvatarImages".equals(paramString1))
    {
      handleGetAvatarImages(paramJSONObject, paramString2);
      return true;
    }
    return false;
  }
  
  private void handleCmShowChange3DAvatarComponent(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent]");
    int i;
    Iterator localIterator;
    try
    {
      i = paramJSONObject.optInt("type");
      localObject = paramJSONObject.optJSONObject("dressIds");
      if (localObject == null)
      {
        QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] get dressIds error");
        callbackError(paramString, "invalid params: dressId is null!");
        notifyChange3DAvatarComponentResult(false, "invalid params: dressId is null!");
        return;
      }
      paramJSONObject = new HashMap();
      localIterator = ((JSONObject)localObject).keys();
      if (localIterator == null)
      {
        QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] get dressIds keys error");
        callbackError(paramString, "invalid params: dressId is null!");
        notifyChange3DAvatarComponentResult(false, "invalid params: dressId is null!");
        return;
      }
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] error! ", paramJSONObject);
      callbackError(paramString, paramJSONObject.getMessage());
      notifyChange3DAvatarComponentResult(false, paramJSONObject.getMessage());
      return;
    }
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramJSONObject.put(Integer.valueOf(((JSONObject)localObject).optInt(str)), str);
    }
    if ((paramJSONObject == null) || (paramJSONObject.size() == 0))
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] invalid params: dressId is null!");
      callbackError(paramString, "invalid params: dressId is null!");
      notifyChange3DAvatarComponentResult(false, "invalid params: dressId is null!");
      return;
    }
    Object localObject = new ArrayList(paramJSONObject.keySet());
    ApolloClientQIPCModule.a((ArrayList)localObject, new ApolloJsPluginImpl.8(this, System.currentTimeMillis(), (ArrayList)localObject, paramString, paramActivity, i, paramJSONObject));
  }
  
  private void handleCmShowGet3DFace(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowGet3DFace]");
    paramActivity = getApolloJsCallBack();
    if (paramActivity == null)
    {
      callbackError(paramString, "No attached UI callback to handle this method!");
      return;
    }
    paramActivity = paramActivity.a();
    if (paramActivity != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(paramActivity.jdField_b_of_type_JavaLangString))
        {
          paramActivity = new JSONObject(paramActivity.jdField_b_of_type_JavaLangString);
          JSONObject localJSONObject1 = new JSONObject();
          paramJSONObject = paramJSONObject.optJSONArray("keys");
          if (paramJSONObject != null)
          {
            i = 0;
            int j = paramJSONObject.length();
            if (i < j)
            {
              String str = paramJSONObject.optString(i);
              if (TextUtils.isEmpty(str)) {
                break label176;
              }
              JSONObject localJSONObject2 = paramActivity.optJSONObject(str);
              if (localJSONObject2 == null) {
                break label176;
              }
              localJSONObject1.put(str, localJSONObject2);
              break label176;
            }
          }
          callbackOk(paramString, localJSONObject1);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        callbackError(paramString, paramJSONObject.getMessage());
        return;
      }
      callbackError(paramString, "face data is empty!");
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowGet3DFace] face data is empty! ");
      return;
      label176:
      i += 1;
    }
  }
  
  private void handleCmShowGet3DFaceFull(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowGet3DFaceFull]");
    paramJSONObject = getApolloJsCallBack();
    if (paramJSONObject == null)
    {
      callbackError(paramString, "No attached UI callback to handle this method!");
      return;
    }
    paramJSONObject = paramJSONObject.a();
    if (paramJSONObject != null) {
      try
      {
        if (!TextUtils.isEmpty(paramJSONObject.jdField_b_of_type_JavaLangString))
        {
          callbackOk(paramString, new JSONObject(paramJSONObject.jdField_b_of_type_JavaLangString));
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        callbackError(paramString, paramJSONObject.getMessage());
        return;
      }
    }
    callbackError(paramString, "face data is empty!");
    QLog.e("ApolloJsPlugin", 1, "[handleCmShowGet3DFaceFull] face data is empty! ");
  }
  
  private void handleCmShowGetAll3DAvatarComponent(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowGetAll3DAvatarComponent]");
    try
    {
      paramJSONObject = getApolloJsCallBack();
      if (paramJSONObject == null)
      {
        callbackError(paramString, "No attached UI callback to handle this method!");
        return;
      }
      paramActivity = paramJSONObject.a();
      if ((paramActivity == null) || (paramActivity.a != null))
      {
        callbackError(paramString, "dress map is empty");
        QLog.e("ApolloJsPlugin", 1, "[handleCmShowGetAll3DAvatarComponent] dress map is empty");
        return;
      }
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowGetAll3DAvatarComponent] error! ", paramJSONObject);
      callbackError(paramString, paramJSONObject.getMessage());
      return;
    }
    paramJSONObject = new JSONArray();
    paramActivity = paramActivity.a.values().iterator();
    while (paramActivity.hasNext())
    {
      String str = (String)paramActivity.next();
      paramJSONObject.put(Integer.parseInt(str.substring(str.lastIndexOf(File.separator))));
    }
    paramActivity = new JSONObject();
    paramActivity.put("dressIds", paramJSONObject);
    callbackOk(paramString, paramActivity);
  }
  
  private void handleCmShowInit3DAvatar(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar]");
    HashMap localHashMap;
    Iterator localIterator;
    try
    {
      paramActivity = paramJSONObject.optString("faceDataUrl");
      paramJSONObject = paramJSONObject.optJSONObject("dressIds");
      if ((paramJSONObject == null) || (TextUtils.isEmpty(paramActivity)))
      {
        QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] invalid params!");
        callbackError(paramString, "invalid params!");
        return;
      }
      localHashMap = new HashMap();
      localIterator = paramJSONObject.keys();
      if (localIterator == null)
      {
        QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] dressIds keys is null!");
        callbackError(paramString, "invalid params!");
        return;
      }
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] error! ", paramJSONObject);
      callbackError(paramString, paramJSONObject.getMessage());
      return;
    }
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(Integer.valueOf(paramJSONObject.optInt(str)), str);
    }
    if ((localHashMap == null) || (localHashMap.size() == 0))
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] invalid params!");
      callbackError(paramString, "invalid params!");
      return;
    }
    ApolloClientQIPCModule.a(new ArrayList(localHashMap.keySet()), new ApolloJsPluginImpl.7(this, localHashMap, paramActivity, paramString));
  }
  
  private void handleCmShowLoad3DFaceDress(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress]");
    int i = paramJSONObject.optInt("dressId");
    if (i <= 0)
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] invalid params: dressId is null!");
      callbackError(paramString, "invalid params: dressId is null!");
      return;
    }
    paramJSONObject = new ArrayList(1);
    paramJSONObject.add(Integer.valueOf(i));
    ApolloClientQIPCModule.a(paramJSONObject, new ApolloJsPluginImpl.6(this, paramString, i));
  }
  
  private void handleCmShowSet3DFace(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowSet3DFace]");
    paramActivity = getApolloJsCallBack();
    if (paramActivity == null)
    {
      callbackError(paramString, "No attached UI callback to handle this method!");
      return;
    }
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    localCmShowAssetsData.jdField_b_of_type_JavaLangString = paramJSONObject.toString();
    paramActivity.a(localCmShowAssetsData, 1);
    callbackOk(paramString);
  }
  
  private void handleCmShowSet3DFaceFull(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowSet3DFaceFull]");
    paramActivity = getApolloJsCallBack();
    if (paramActivity == null)
    {
      callbackError(paramString, "No attached UI callback to handle this method!");
      return;
    }
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    localCmShowAssetsData.jdField_b_of_type_JavaLangString = paramJSONObject.toString();
    paramActivity.a(localCmShowAssetsData, 0);
    callbackOk(paramString);
  }
  
  private void handleCmShowSet3DModeType(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowSet3DModeType]");
    paramActivity = getApolloJsCallBack();
    if (paramActivity != null)
    {
      paramJSONObject = paramJSONObject.optString("modeType");
      if ("face".equals(paramJSONObject))
      {
        paramActivity.a(1);
        callbackOk(paramString);
        return;
      }
      if ("decorate".equals(paramJSONObject))
      {
        paramActivity.a(0);
        callbackOk(paramString);
        return;
      }
      callbackError(paramString, "invalid params!");
      return;
    }
    callbackError(paramString, "No attached UI callback to handle this method!");
  }
  
  private void handleGetAvatarImages(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      QLog.e("ApolloJsPlugin", 1, "handleGetAvatarImages with json null");
      return;
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("actions");
        int i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          int k = localJSONObject.getInt("actionId");
          String str = localJSONObject.getString("actionType");
          if (!TextUtils.isEmpty(str))
          {
            j = Integer.parseInt(str);
            recordAction(k, j, localJSONObject.getInt("isDynamic"), localJSONObject.getInt("type"), this.avatarWidth, this.avatarWidth);
            i += 1;
          }
        }
        else
        {
          callbackOk(paramString, 0, "get avatar list succeed");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloJsPlugin", 1, new Object[] { "handleGetAvatarImages exception", paramJSONObject.toString(), localException });
        callbackError(paramString, "params parse error");
        return;
      }
      int j = 0;
    }
  }
  
  private void handleIs3DDressLoaded(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.e("ApolloJsPlugin", 1, "[handleIs3DDressLoaded] callbackId :" + paramString);
    this.mLoadedCallBackId = paramString;
  }
  
  private void handleOpenCmShowFaceCamera(Activity paramActivity, String paramString)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleOpenCmShowFaceCamera]");
    this.mCmShowCameraCallBackId = paramString;
    CmShowLauncher.a(paramActivity);
  }
  
  private void handleSave3DFaceData(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @NotNull Activity paramActivity)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleSave3DFaceData]");
    this.mApolloStatus = 3;
    this.mReqBundle.clear();
    paramJSONObject = paramJSONObject.optString("data");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      QLog.e("ApolloJsPlugin", 1, "[handleSave3DFaceData] get face data fail! ");
      callbackError(paramString, "face data is empty!");
      return;
    }
    this.mReqBundle.putString("apollo_face3DData", paramJSONObject);
    super.sendRemoteReq(DataFactory.a("ipc_apollo_save_3d_face", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void handleSetSpriteAvatar(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      QLog.e("ApolloJsPlugin", 1, "handleSetSpriteAvatar with json null");
      callbackError(paramString, "params parse error");
      return;
    }
    for (;;)
    {
      try
      {
        int j = paramJSONObject.getInt("actionId");
        int k = paramJSONObject.getInt("isDynamic");
        paramJSONObject.getInt("type");
        String str = paramJSONObject.getString("actionType");
        if (!TextUtils.isEmpty(str))
        {
          i = Integer.parseInt(str);
          ApolloClientQIPCModule.a(this.mRuntime.a().getCurrentUin(), j, i, k, new ApolloJsPluginImpl.4(this, paramString));
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ApolloJsPlugin", 1, new Object[] { "handleSetSpriteAvatar exception", paramJSONObject.toString(), localJSONException });
        callbackError(paramString, "params parse error");
        return;
      }
      int i = 0;
    }
  }
  
  private void notifyChange3DAvatarComponentResult(boolean paramBoolean, String paramString)
  {
    QLog.e("ApolloJsPlugin", 1, "[notifyChange3DAvatarComponentResult] success :" + paramBoolean + " message:" + paramString);
    if (TextUtils.isEmpty(this.mLoadedCallBackId)) {
      return;
    }
    if (paramBoolean) {
      callbackOk(this.mLoadedCallBackId);
    }
    for (;;)
    {
      this.mLoadedCallBackId = "";
      return;
      callbackError(this.mLoadedCallBackId, paramString);
    }
  }
  
  private void recordAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    ApolloClientQIPCModule.a(this.mRuntime.a().getCurrentUin(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, new ApolloJsPluginImpl.3(this, paramInt3, paramInt4));
  }
  
  private void reportApiCallback(String paramString1, String paramString2)
  {
    ApolloJsPluginImpl.ApiReportData localApiReportData;
    int j;
    if (this.mReportDataHashMap.containsKey(paramString1))
    {
      localApiReportData = (ApolloJsPluginImpl.ApiReportData)this.mReportDataHashMap.get(paramString1);
      if (localApiReportData != null)
      {
        j = getReportSpanId(localApiReportData.jdField_a_of_type_JavaLangString);
        if (j > 0) {
          if (!"ok".equals(paramString2)) {
            break label114;
          }
        }
      }
    }
    label114:
    for (int i = 0;; i = -1)
    {
      TraceReportUtil.a(131, j, i, new Object[] { paramString2 });
      TraceReportUtil.b(131);
      ApolloQualityReportUtil.a("dressup_js_api", String.valueOf(System.currentTimeMillis() - localApiReportData.jdField_a_of_type_Long), localApiReportData.jdField_a_of_type_JavaLangString, paramString2);
      this.mReportDataHashMap.remove(paramString1);
      return;
    }
  }
  
  public void callbackCmShowFaceCameraResult(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("result", paramInt);
      localJSONObject1.put("msg", "");
      if (paramInt == 0)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("dressMap", new JSONObject(paramString1));
        localJSONObject2.put("face", paramString2);
        callbackOk(this.mCmShowCameraCallBackId, localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloJsPlugin", 2, "callbackId->" + this.mCmShowCameraCallBackId + " callbackOk" + localJSONObject1.toString());
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ApolloJsPlugin", 2, paramString1.getMessage());
    }
  }
  
  void callbackError(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramString2);
      super.callJs(paramString1 + "&&" + paramString1 + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.e("ApolloJsPlugin", 2, "callbackId->" + paramString1 + " errorMsg: " + paramString2);
      }
      reportApiCallback(paramString1, paramString2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloJsPlugin", 2, localException.getMessage());
        }
      }
    }
  }
  
  void callbackOk(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", "");
      super.callJs(paramString + "&&" + paramString + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "callbackId->" + paramString + " callbackOk" + localJSONObject.toString());
      }
      reportApiCallback(paramString, "ok");
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ApolloJsPlugin", 2, paramString.getMessage());
    }
  }
  
  void callbackOk(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("msg", paramString2);
      callbackOk(paramString1, localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ApolloJsPlugin", 2, paramString1.getMessage());
    }
  }
  
  void callbackOk(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", "");
      if (paramJSONObject != null) {
        localJSONObject.put("data", paramJSONObject);
      }
      callJs(paramString, new String[] { localJSONObject.toString() });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "callbackId->" + paramString + " callbackOk" + localJSONObject.toString());
      }
      reportApiCallback(paramString, "ok");
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ApolloJsPlugin", 2, paramString.getMessage());
    }
  }
  
  public void callbackRecordAction(@NotNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("actionId", paramInt1);
      localJSONObject.put("isDynamic", paramInt2);
      localJSONObject.put("type", paramInt3);
      localJSONObject.put("img", "https://cmshow.qq.com/qq_cms_avatar/" + paramString);
      callbackAvatarImage(localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("ApolloJsPlugin", 1, new Object[] { "callbackRecordAction exception ", Integer.valueOf(paramInt1), paramString });
    }
  }
  
  boolean checkSdcard(Context paramContext)
  {
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      QQToast.a(paramContext, HardCodeUtil.a(2131700508), 0).a();
      return false;
    }
    return true;
  }
  
  public void createInterceptor()
  {
    String str = this.mInterceptorUrl;
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      this.mInterceptor = ApolloUrlInterceptor.a(true, str);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloJsPlugin", 2, "apollo_client onApolloJsCreate ApolloWebDataHandler.isInstanceCreated():true");
  }
  
  public ApolloUrlInterceptor getInterceptor()
  {
    return this.mInterceptor;
  }
  
  public int getRemoteKey()
  {
    return this.mOnRemoteResp.key;
  }
  
  public JSONObject getThunderJson(boolean paramBoolean)
  {
    Object localObject = getInterceptor();
    if ((localObject != null) && (((ApolloUrlInterceptor)localObject).a() != null))
    {
      if ((!paramBoolean) || (((ApolloUrlInterceptor)localObject).a())) {
        break label44;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "apollo_client_apolloWebStatistics checkRunSuccess fail");
      }
    }
    for (;;)
    {
      return null;
      label44:
      localObject = ((ApolloUrlInterceptor)localObject).a();
      try
      {
        int i = ((ApolloWebStatistics)localObject).jdField_a_of_type_Int;
        throw new NullPointerException();
        if (!QLog.isColorLevel()) {
          continue;
        }
        new StringBuilder().append("apollo_client_apolloWebStatistics:");
        throw new NullPointerException();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ApolloJsPlugin", 2, "apollo_client_apolloWebStatistics getThunderJson error:", localJSONException);
        }
      }
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 40L;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    Object localObject3;
    if (paramLong == 8L) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloJsPlugin", 1, " handleEvent url:" + paramString);
        }
        Object localObject1;
        if (this.mInterceptor != null)
        {
          localObject3 = this.mInterceptor.a(paramString);
          if (localObject3 != null)
          {
            localObject1 = localObject3;
            if (!QLog.isColorLevel()) {
              break label287;
            }
            QLog.d("ApolloJsPlugin", 1, "apollo_client handleEvent response-> " + localObject3 + ",url:" + paramString);
            return localObject3;
          }
        }
        if (this.mRscLoader == null) {
          this.mRscLoader = new ApolloPluginRscLoader(this);
        }
        localObject3 = this.mRscLoader.a(paramString);
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (!QLog.isColorLevel()) {
            break label287;
          }
          QLog.d("ApolloJsPlugin", 1, "mRscLoader handleEvent response-> " + localObject3 + ",url:" + paramString);
          return localObject3;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloJsPlugin", 1, "handleEvent intercept by apolloClient error -> " + localException.getMessage());
      }
    }
    do
    {
      return super.handleEvent(paramString, paramLong);
      localObject3 = getResponseAvatar(paramString);
    } while (localObject3 == null);
    Object localObject2 = localObject3;
    if (QLog.isColorLevel())
    {
      QLog.d("ApolloJsPlugin", 1, "getAvatar handleEvent response, url:" + paramString);
      localObject2 = localObject3;
    }
    label287:
    return localObject2;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (32L == paramLong)
    {
      if ((this.mNeedCreateInterceptor) && (this.mInterceptor == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloJsPlugin", 1, "apollo_client handleEvent reinited ApolloUrlInterceptor,url:" + paramString);
        }
        this.mInterceptor = ApolloUrlInterceptor.a(true, paramString);
        this.mNeedCreateInterceptor = false;
      }
      if (this.mInterceptor != null)
      {
        this.mInterceptor.a(this.mRuntime.a());
        return this.mInterceptor.b(paramString);
      }
    }
    else if ((8589934597L == paramLong) && (this.mApolloViewContoller != null))
    {
      this.mApolloViewContoller.c();
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"apollo".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramVarArgs = null;
    try
    {
      localObject1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (localObject1 == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject1).toString());
      }
      paramString2 = ((JSONObject)localObject1).optString("callback");
      if (paramString2 != null) {
        break label240;
      }
      try
      {
        throw new Exception("need callbackId");
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramString1 = paramString2;
      }
    }
    catch (Throwable paramJsBridgeListener)
    {
      for (;;)
      {
        Object localObject1;
        int k;
        paramString1 = paramVarArgs;
        continue;
        continue;
        int j = 0;
        continue;
        paramJsBridgeListener = null;
        boolean bool2 = bool1;
        break label10305;
        continue;
        continue;
        int i = 0;
        continue;
        i += 1;
        continue;
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        i += 1;
        bool1 = bool2;
        continue;
        paramJsBridgeListener = null;
        continue;
        bool1 = false;
        continue;
        i += 1;
        bool1 = bool2;
        continue;
        i = j;
        if (!bool2)
        {
          i = 1;
          continue;
          k += 1;
          bool1 = bool2;
          continue;
          j += 1;
          continue;
          i = 1;
          continue;
          i = 2;
          continue;
          for (;;)
          {
            j += 1;
            break;
            i = 0;
          }
          i = 2;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          if (bool1)
          {
            i = 1;
          }
          else
          {
            i = 0;
            continue;
            i = 0;
            continue;
            i = 0;
          }
        }
      }
    }
    QLog.e("ApolloJsPlugin", 1, paramJsBridgeListener.getMessage());
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("result", 1);
      paramString2.put("msg", paramJsBridgeListener.getMessage());
      super.callJs(paramString1 + "&&" + paramString1 + "(" + paramString2.toString() + ");");
      for (;;)
      {
        return true;
        label240:
        if (QLog.isColorLevel()) {
          QLog.d("ApolloJsPlugin", 2, "json:" + localObject1);
        }
        paramVarArgs = getActivity();
        if ((paramVarArgs == null) || (this.isDestroy) || (paramVarArgs.isFinishing()))
        {
          callbackError(paramString2, HardCodeUtil.a(2131700515));
          return true;
        }
        if ("startRecord".equals(paramString3))
        {
          j = ((JSONObject)localObject1).optInt("maxDuration", 5);
          if (j <= 100) {
            break label10238;
          }
          j = 100;
          i = 1;
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (paramVarArgs.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
              break label10241;
            }
            i = 1;
          }
          if (i == 0)
          {
            if ((paramVarArgs instanceof BaseActivity)) {
              ((BaseActivity)paramVarArgs).requestPermissions(new ApolloJsPluginImpl.1(this), 2, new String[] { "android.permission.RECORD_AUDIO" });
            }
            callbackError(paramString2, "don't have permission!");
          }
          else
          {
            this.mReqBundle.clear();
            this.mReqBundle.putInt("maxDuration", j);
            super.sendRemoteReq(DataFactory.a("ipc_apollo_start_record_msg", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          }
        }
        else if ("stopRecord".equals(paramString3))
        {
          super.sendRemoteReq(DataFactory.a("ipc_apollo_stop_record_msg", paramString2, this.mOnRemoteResp.key, null), false, true);
        }
        else if ("startUploadRecord".equals(paramString3))
        {
          super.sendRemoteReq(DataFactory.a("ipc_apollo_upload_record_msg", paramString2, this.mOnRemoteResp.key, null), false, true);
        }
        else if ("startPlayLastRecord".equals(paramString3))
        {
          paramJsBridgeListener = ((JSONObject)localObject1).optString("url", "");
          this.mReqBundle.clear();
          this.mReqBundle.putString("url", paramJsBridgeListener);
          super.sendRemoteReq(DataFactory.a("ipc_apollo_play_last_record_msg", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        else if ("stopPlayLastRecord".equals(paramString3))
        {
          super.sendRemoteReq(DataFactory.a("ipc_apollo_stop_last_record_msg", paramString2, this.mOnRemoteResp.key, null), false, true);
        }
        else if ("getPlaymateMsgList".equals(paramString3))
        {
          paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("uinList");
          if (paramJsBridgeListener != null)
          {
            this.mReqBundle.clear();
            this.mReqBundle.putString("uinList", paramJsBridgeListener.toString());
            super.sendRemoteReq(DataFactory.a("ipc_apollo_get_playmate_msg", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
          }
          else
          {
            callbackError(paramString2, "uinList is null");
          }
        }
        else if ("openCmGameAio".equals(paramString3))
        {
          paramJsBridgeListener = ((JSONObject)localObject1).optString("friendUin");
          paramString1 = ((JSONObject)localObject1).optString("nickName");
          i = ((JSONObject)localObject1).optInt("src");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            this.mReqBundle.clear();
            this.mReqBundle.putString("friendUin", paramJsBridgeListener);
            if (!TextUtils.isEmpty(paramString1)) {
              this.mReqBundle.putString("nickName", paramString1);
            }
            this.mReqBundle.putInt("src", i);
            super.sendRemoteReq(DataFactory.a("ipc_apollo_open_cmgame_aio", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            callbackOk(paramString2);
          }
          else
          {
            callbackError(paramString2, "friendUin is empty");
          }
        }
        else
        {
          label4382:
          if ("isApolloEngineReady".equals(paramString3))
          {
            if (((IApolloEngine)QRoute.api(IApolloEngine.class)).checkEngineReady()) {
              callbackOk(paramString2);
            }
            for (;;)
            {
              if (!QLog.isColorLevel()) {
                break label947;
              }
              QLog.d("ApolloJsPlugin", 2, new Object[] { "isApolloEngineReady:", Boolean.valueOf(((IApolloEngine)QRoute.api(IApolloEngine.class)).checkEngineReady()) });
              break;
              callbackError(paramString2, "ApolloEngine is not ready");
            }
          }
          else
          {
            label947:
            if ("clearThunderCache".equals(paramString3))
            {
              paramJsBridgeListener = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/webview/");
              if (paramJsBridgeListener.exists())
              {
                paramJsBridgeListener = paramJsBridgeListener.listFiles();
                if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length > 0))
                {
                  j = paramJsBridgeListener.length;
                  i = 0;
                  if (i < j)
                  {
                    paramString1 = paramJsBridgeListener[i];
                    if ((!paramString1.isDirectory()) || (!new File(paramString1, paramString1.getName() + ".txt").exists())) {
                      break label10247;
                    }
                    FileUtils.a(paramString1.getAbsolutePath());
                    if (!QLog.isColorLevel()) {
                      break label10247;
                    }
                    QLog.d("ApolloJsPlugin", 2, "clearThunderCache, htmlFileDir:" + paramString1.getName());
                    break label10247;
                  }
                }
              }
              callbackOk(paramString2);
            }
            else if ("stopThunderCache".equals(paramString3))
            {
              ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).stopThunderCache();
              callbackOk(paramString2);
            }
            else if ("resumeThunderCache".equals(paramString3))
            {
              ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).resumeThunderCache();
              callbackOk(paramString2);
            }
            else
            {
              long l;
              Object localObject3;
              int m;
              Object localObject2;
              if ("startApolloGame".equals(paramString3))
              {
                l = System.currentTimeMillis();
                if (l - this.mLastGameTime <= 1000L)
                {
                  callbackError(paramString2, HardCodeUtil.a(2131700497));
                  return true;
                }
                this.mLastGameTime = l;
                j = ((JSONObject)localObject1).optInt("gameId");
                l = ((JSONObject)localObject1).optLong("roomId");
                if (((JSONObject)localObject1).optInt("isCreator", 1) != 1) {
                  break label10256;
                }
                bool1 = true;
                i = 1;
                if (((JSONObject)localObject1).has("gameMode")) {
                  i = ((JSONObject)localObject1).optInt("gameMode");
                }
                k = ((JSONObject)localObject1).optInt("src");
                paramString3 = ((JSONObject)localObject1).optString("gameParam");
                paramString1 = ((JSONObject)localObject1).optString("friendUin");
                paramJsBridgeListener = ((JSONObject)localObject1).optString("friendOpenId");
                bool2 = ((JSONObject)localObject1).optBoolean("isEnterAIO");
                if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                  break label10235;
                }
                paramJsBridgeListener = paramString1;
                localObject3 = ((JSONObject)localObject1).optString("uinName");
                m = ((JSONObject)localObject1).optInt("openTempAIOOnFinish");
                localObject2 = ((JSONObject)localObject1).optString("tempAIOUin");
                String str1 = ((JSONObject)localObject1).optString("tempAIONickName");
                String str2 = ((JSONObject)localObject1).optString("gameName");
                if ((paramVarArgs != null) && (!paramVarArgs.isFinishing()))
                {
                  if (bool2)
                  {
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putString("uin", paramString1);
                    ((Bundle)localObject1).putInt("uintype", 0);
                    ((Bundle)localObject1).putString("troop_uin", "");
                    ((Bundle)localObject1).putString("uinname", (String)localObject3);
                    ((Bundle)localObject1).putBoolean("launchApolloGame", true);
                    ((Bundle)localObject1).putInt("gameId", j);
                    ((Bundle)localObject1).putInt("gameMode", i);
                    ((Bundle)localObject1).putString("openId", paramJsBridgeListener);
                    ((Bundle)localObject1).putString("gameParam", paramString3);
                    ((Bundle)localObject1).putString("gameName", str2);
                    ((Bundle)localObject1).putInt("src", k);
                    ((Bundle)localObject1).putInt("enter", 3);
                    paramJsBridgeListener = AIOUtils.a(new Intent(paramVarArgs, SplashActivity.class), new int[] { 2 });
                    paramJsBridgeListener.putExtras((Bundle)localObject1);
                    paramVarArgs.startActivity(paramJsBridgeListener);
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "[startApolloGame] openAIO:" + ((Bundle)localObject1).toString());
                    }
                    callbackOk(paramString2);
                  }
                  else
                  {
                    paramString1 = new CmGameStartChecker.StartCheckParam(j, bool1, "luanch", l, 4, i, 0, 0, "", k, str2);
                    paramString1.mExtraStr = ((JSONObject)localObject1).toString();
                    paramString1.extendJson = paramString3;
                    paramString1.mFriendUin = paramJsBridgeListener;
                    paramString1.mTempAIONickName = str1;
                    paramString1.mTempAIOUin = ((String)localObject2);
                    if (m != 1) {
                      break label10262;
                    }
                    bool1 = true;
                    paramString1.mOpenTempAIOOnFinish = bool1;
                    if (paramString1.src == 318) {
                      paramString1.disableMinGame = true;
                    }
                    if (!TextUtils.isEmpty(paramString3))
                    {
                      paramJsBridgeListener = ApolloUtilImpl.getJsonStrValue(paramString3, "rbOpenId");
                      if (!TextUtils.isEmpty(paramJsBridgeListener))
                      {
                        paramString1.mRobotOpenId = paramJsBridgeListener;
                        if (((IApolloUtil)QRoute.api(IApolloUtil.class)).getJsonIntValue(paramString3, "gameId") > 0) {
                          paramString1.gameId = j;
                        }
                        paramString1.src = 318001;
                        paramString1.disableMinGame = true;
                        RobotDataUtil.a((String)localObject2);
                      }
                    }
                    this.mReqBundle.clear();
                    this.mReqBundle.putSerializable("StartCheckParam", paramString1);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_start_apollo_game", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                }
                else {
                  callbackError(paramString2, HardCodeUtil.a(2131700491));
                }
              }
              else
              {
                if ("checkGameStatus".equals(paramString3))
                {
                  if (!FileUtils.a())
                  {
                    callbackError(paramString2, "sdcard未装");
                    return true;
                  }
                  if (FileUtils.c() < 52428800.0F)
                  {
                    callbackError(paramString2, HardCodeUtil.a(2131700496));
                    return true;
                  }
                  i = ((JSONObject)localObject1).optInt("gameId");
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("gameId", i);
                  paramJsBridgeListener = DataFactory.a("IPC_APOLLO_DOWNLOAD_GAME", paramString2, this.mOnRemoteResp.key, this.mReqBundle);
                  this.alreadyCallBack = false;
                  super.sendRemoteReq(paramJsBridgeListener, false, true);
                  return true;
                }
                if ("chooseFriendPlayGame".equals(paramString3))
                {
                  i = ((JSONObject)localObject1).optInt("gameId");
                  paramJsBridgeListener = new ApolloGameMsgInfo();
                  paramJsBridgeListener.gameId = i;
                  ApolloGameBasicEventUtil.a(paramJsBridgeListener, this.mRuntime.a(), 2);
                  return true;
                }
                if ("dispatchGameEvent".equals(paramString3))
                {
                  paramJsBridgeListener = CmGameUtil.a();
                  if (paramJsBridgeListener != null) {
                    paramJsBridgeListener.c(((JSONObject)localObject1).toString());
                  }
                  callbackOk(paramString2);
                }
                else if ("setBackViewVisibility".equals(paramString3))
                {
                  i = ((JSONObject)localObject1).optInt("visibility");
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    ((IApolloActivityJsCallBack)paramVarArgs).c(i);
                    callbackOk(paramString2);
                  }
                  else
                  {
                    callbackError(paramString2, "ApolloViewController not inited or not ApolloStoreActivity");
                  }
                }
                else if ("openApolloShareFloatView".equals(paramString3))
                {
                  paramString1 = ((JSONObject)localObject1).optString("backgroundImage");
                  paramString3 = ((JSONObject)localObject1).optString("nickName");
                  paramJsBridgeListener = null;
                  if ((this.mRuntime.a() instanceof BaseActivity)) {
                    paramJsBridgeListener = ((BaseActivity)this.mRuntime.a()).getAppInterface();
                  }
                  if (this.mApolloViewContoller != null)
                  {
                    this.mApolloViewContoller.a(paramVarArgs, paramJsBridgeListener, paramString1, paramString3);
                    callbackOk(paramString2);
                  }
                  else if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    ((IApolloActivityJsCallBack)paramVarArgs).a(paramVarArgs, paramString1, paramString3);
                    callbackOk(paramString2);
                  }
                  else
                  {
                    callbackError(paramString2, "ApolloViewController not inited or not ApolloStoreActivity");
                  }
                }
                else if ("openDiyActionFloatView".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("defaultText");
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack)) {
                    ((IApolloActivityJsCallBack)paramVarArgs).a(paramJsBridgeListener);
                  } else {
                    callbackError(paramString2, HardCodeUtil.a(2131700525));
                  }
                }
                else if ("sayHi".equals(paramString3))
                {
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    paramJsBridgeListener = ((IApolloActivityJsCallBack)paramVarArgs).a();
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                  }
                  else if (this.mApolloViewContoller != null)
                  {
                    paramJsBridgeListener = this.mApolloViewContoller.a();
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                  }
                  else
                  {
                    callbackError(paramString2, "ApolloViewController not inited or not ApolloStoreActivity");
                  }
                }
                else if ("setCapsuleOpened".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("uin");
                  if (TextUtils.isEmpty(paramJsBridgeListener))
                  {
                    callbackError(paramString2, "uin is empty");
                  }
                  else
                  {
                    this.mReqBundle.clear();
                    this.mReqBundle.putString("apollo_uin", paramJsBridgeListener);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_setcapsule", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                  }
                }
                else if ("openBox".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("uin");
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    paramJsBridgeListener = ((IApolloActivityJsCallBack)paramVarArgs).a(paramJsBridgeListener);
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                  }
                  else
                  {
                    callbackError(paramString2, HardCodeUtil.a(2131700531));
                  }
                }
                else if ("setApolloViewVisibility".equals(paramString3))
                {
                  i = ((JSONObject)localObject1).optInt("visibility", 0);
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    ((IApolloActivityJsCallBack)paramVarArgs).d(i);
                    callbackOk(paramString2);
                    return true;
                  }
                  if (this.mApolloViewContoller == null)
                  {
                    callbackError(paramString2, "ApolloViewController is null");
                    return false;
                  }
                  this.mApolloViewContoller.b(i);
                  callbackOk(paramString2);
                }
                else if ("initApolloView".equals(paramString3))
                {
                  if (!((IApolloEngine)QRoute.api(IApolloEngine.class)).checkEngineReady())
                  {
                    callbackError(paramString2, "engine is not ready");
                    return false;
                  }
                  if ((this.mApolloViewContoller == null) && ((this.mRuntime.a().getParent() instanceof RelativeLayout)))
                  {
                    this.mApolloViewContoller = new ApolloViewController((RelativeLayout)this.mRuntime.a().getParent(), null);
                    this.mApolloViewContoller.a(this);
                  }
                  if (this.mApolloViewContoller == null)
                  {
                    callbackError(paramString2, "ApolloViewController is null");
                    return false;
                  }
                  i = ((JSONObject)localObject1).optInt("disableTouch", 0);
                  j = ((JSONObject)localObject1).optInt("scrollByWebView", 0);
                  if ((this.mRuntime.a() instanceof TouchWebView))
                  {
                    paramString1 = (TouchWebView)this.mRuntime.a();
                    if (j <= 0) {
                      break label10281;
                    }
                    paramJsBridgeListener = this.mApolloViewContoller;
                    paramString1.setOnScrollChangedListener(paramJsBridgeListener);
                  }
                  paramJsBridgeListener = this.mApolloViewContoller;
                  if (i <= 0) {
                    break label10286;
                  }
                  bool1 = true;
                  paramJsBridgeListener.b(bool1);
                  paramString3 = new ApolloWebAvatarParam();
                  paramString3.isMain = true;
                  paramString3.apolloId = ((JSONObject)localObject1).optString("apolloId", "me");
                  paramString3.x = ((JSONObject)localObject1).optInt("x", DEFAULT_WIDTH);
                  paramString3.y = ((JSONObject)localObject1).optInt("y", DEFAULT_HEIGHT);
                  paramString3.uin = ((JSONObject)localObject1).optString("uin");
                  if (TextUtils.isEmpty(paramString3.uin)) {
                    paramString3.uin = this.mRuntime.a().getCurrentAccountUin();
                  }
                  paramString3.nickName = ((JSONObject)localObject1).optString("nickName");
                  paramString3.type = 0;
                  paramString3.tab = "mall";
                  paramString3.rate = ((float)((JSONObject)localObject1).optDouble("rate", 0.0D));
                  paramString3.roleId = ((JSONObject)localObject1).optInt("roleId");
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("tapRect");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() >= 4))
                  {
                    paramString3.tapRectX = paramJsBridgeListener.getInt(0);
                    paramString3.tapRectY = paramJsBridgeListener.getInt(1);
                    paramString3.tapRectWidth = paramJsBridgeListener.getInt(2);
                    paramString3.tapRectHeight = paramJsBridgeListener.getInt(3);
                  }
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
                  bool1 = false;
                  if (paramString3.roleId > 0) {
                    bool1 = ApolloUtilImpl.checkRoleRes(paramString3.roleId);
                  }
                  bool2 = bool1;
                  if (paramJsBridgeListener != null)
                  {
                    bool2 = bool1;
                    if (paramJsBridgeListener.length() > 0)
                    {
                      j = paramJsBridgeListener.length();
                      paramString3.dressIds = new int[j];
                      i = 0;
                      bool2 = bool1;
                      if (i < j)
                      {
                        k = paramJsBridgeListener.getInt(i);
                        paramString3.dressIds[i] = k;
                        bool2 = bool1;
                        if (paramString3.roleId <= 0) {
                          break label10268;
                        }
                        bool2 = bool1;
                        if (!bool1) {
                          break label10268;
                        }
                        bool2 = ApolloUtilImpl.checkDressRes(k);
                        break label10268;
                      }
                    }
                  }
                  paramString3.isResExist = bool2;
                  this.mValidAvatarIdList.clear();
                  this.mValidAvatarIdList.add(paramString3.apolloId);
                  if (!bool2)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "initApolloView, should request resource");
                    }
                    paramVarArgs = new ArrayList(1);
                    paramVarArgs.add(paramString3);
                    this.mReqBundle.clear();
                    paramString1 = ((JSONObject)localObject1).optString("reqUrl");
                    paramJsBridgeListener = paramString1;
                    if (TextUtils.isEmpty(paramString1)) {
                      paramJsBridgeListener = getAbsoluteUrl();
                    }
                    if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                      this.mReqBundle.putString("reqUrl", paramJsBridgeListener);
                    }
                    this.mReqBundle.putInt("from", 1);
                    this.mReqBundle.putSerializable("apolloList", paramVarArgs);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_check_avatar_res", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                    this.mApolloViewContoller.a(true, paramString3.x, paramString3.y);
                  }
                  else
                  {
                    paramJsBridgeListener = this.mApolloViewContoller.a(1, true, paramString3);
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                  }
                }
                else if ("initAvatar".equals(paramString3))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "initAvatar");
                  }
                  if (!IApolloActivityJsCallBack.class.isInstance(paramVarArgs))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "initAvatar, not ApolloStoreActivity");
                    }
                    if ((paramVarArgs instanceof BaseActivity))
                    {
                      paramJsBridgeListener = ((BaseActivity)paramVarArgs).getAppInterface();
                      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramVarArgs, null, "share", this.mRuntime.a().getUrl(), paramJsBridgeListener);
                    }
                    ThreadManager.getSubThreadHandler().postDelayed(new ApolloJsPluginImpl.2(this), 2000L);
                  }
                  j = 0;
                  localObject2 = new ApolloWebAvatarParam();
                  ((ApolloWebAvatarParam)localObject2).isMain = true;
                  ((ApolloWebAvatarParam)localObject2).apolloId = ((JSONObject)localObject1).optString("apolloId", "me");
                  ((ApolloWebAvatarParam)localObject2).type = ((JSONObject)localObject1).optInt("type");
                  ((ApolloWebAvatarParam)localObject2).x = ((JSONObject)localObject1).optInt("x", DEFAULT_WIDTH);
                  ((ApolloWebAvatarParam)localObject2).y = ((JSONObject)localObject1).optInt("y", DEFAULT_HEIGHT);
                  this.mTab = ((JSONObject)localObject1).optString("tab");
                  ((ApolloWebAvatarParam)localObject2).tab = this.mTab;
                  ((ApolloWebAvatarParam)localObject2).rate = ((float)((JSONObject)localObject1).optDouble("rate", 0.0D));
                  ((ApolloWebAvatarParam)localObject2).uin = ((JSONObject)localObject1).optString("uin");
                  ((ApolloWebAvatarParam)localObject2).nickName = ((JSONObject)localObject1).optString("nickName");
                  ((ApolloWebAvatarParam)localObject2).greeting = ((JSONObject)localObject1).optString("greeting");
                  paramString3 = this.mRuntime.a().getCurrentAccountUin();
                  if (TextUtils.isEmpty(((ApolloWebAvatarParam)localObject2).uin)) {
                    ((ApolloWebAvatarParam)localObject2).uin = paramString3;
                  }
                  this.mCurrentUin = ((ApolloWebAvatarParam)localObject2).uin;
                  ((ApolloWebAvatarParam)localObject2).roleId = ((JSONObject)localObject1).optInt("roleId");
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("tapRect");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() >= 4))
                  {
                    ((ApolloWebAvatarParam)localObject2).tapRectX = paramJsBridgeListener.getInt(0);
                    ((ApolloWebAvatarParam)localObject2).tapRectY = paramJsBridgeListener.getInt(1);
                    ((ApolloWebAvatarParam)localObject2).tapRectWidth = paramJsBridgeListener.getInt(2);
                    ((ApolloWebAvatarParam)localObject2).tapRectHeight = paramJsBridgeListener.getInt(3);
                  }
                  bool1 = false;
                  if (((ApolloWebAvatarParam)localObject2).roleId > 0) {
                    bool1 = ApolloUtilImpl.checkRoleRes(((ApolloWebAvatarParam)localObject2).roleId);
                  }
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
                  l = ((JSONObject)localObject1).optLong("avatarTs");
                  if ((paramJsBridgeListener == null) || (paramJsBridgeListener.length() <= 0)) {
                    break label10226;
                  }
                  k = paramJsBridgeListener.length();
                  paramString1 = new int[k];
                  i = 0;
                  if (i < k)
                  {
                    paramString1[i] = paramJsBridgeListener.getInt(i);
                    bool2 = bool1;
                    if (((ApolloWebAvatarParam)localObject2).roleId <= 0) {
                      break label10292;
                    }
                    bool2 = bool1;
                    if (!bool1) {
                      break label10292;
                    }
                    bool2 = ApolloUtilImpl.checkDressRes(paramString1[i]);
                    break label10292;
                  }
                  ((ApolloWebAvatarParam)localObject2).dressIds = paramString1;
                  bool2 = bool1;
                  paramJsBridgeListener = paramString1;
                  if (!this.mCurrentUin.equals(paramString3)) {
                    break label10305;
                  }
                  this.mRoleId = ((ApolloWebAvatarParam)localObject2).roleId;
                  this.mDressIds = paramString1;
                  bool2 = bool1;
                  paramJsBridgeListener = paramString1;
                  break label10305;
                  this.mValidAvatarIdList.clear();
                  this.mValidAvatarIdList.add(((ApolloWebAvatarParam)localObject2).apolloId);
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    paramVarArgs = (IApolloActivityJsCallBack)paramVarArgs;
                    if (i != 0)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloJsPlugin", 2, "initAvatar, should request resource");
                      }
                      localObject3 = new ArrayList(1);
                      ((ArrayList)localObject3).add(localObject2);
                      this.mReqBundle.clear();
                      paramString3 = ((JSONObject)localObject1).optString("reqUrl");
                      paramString1 = paramString3;
                      if (TextUtils.isEmpty(paramString3)) {
                        paramString1 = getAbsoluteUrl();
                      }
                      if (!TextUtils.isEmpty(paramString1)) {
                        this.mReqBundle.putString("reqUrl", paramString1);
                      }
                      this.mReqBundle.putInt("from", 0);
                      this.mReqBundle.putSerializable("apolloList", (Serializable)localObject3);
                      super.sendRemoteReq(DataFactory.a("ipc_apollo_check_avatar_res", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                      paramVarArgs.a(true, ((ApolloWebAvatarParam)localObject2).x, ((ApolloWebAvatarParam)localObject2).y);
                    }
                  }
                  for (;;)
                  {
                    if (i != 0) {
                      break label4382;
                    }
                    this.mReqBundle.clear();
                    this.mReqBundle.putInt("from", 0);
                    this.mReqBundle.putString("uin", ((JSONObject)localObject1).optString("uin"));
                    this.mReqBundle.putLong("avatarTs", l);
                    this.mReqBundle.putIntArray("dressId", paramJsBridgeListener);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_update_avatar_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                    break;
                    paramString1 = paramVarArgs.a(this.mApolloStatus, (ApolloWebAvatarParam)localObject2);
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramString1 + ");");
                    continue;
                    QLog.e("ApolloJsPlugin", 1, "initAvatar, not apollo store activity");
                    callbackError(paramString2, HardCodeUtil.a(2131700514));
                  }
                }
                else if ("addAvatar".equals(paramString3))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "addAvatar");
                  }
                  if (!(paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "addAvatar, not IApolloActivityJsCallBack, check mApolloViewContoller");
                    }
                    if ((this.mApolloViewContoller == null) && ((this.mRuntime.a().getParent() instanceof RelativeLayout)))
                    {
                      this.mApolloViewContoller = new ApolloViewController((RelativeLayout)this.mRuntime.a().getParent(), null);
                      this.mApolloViewContoller.a(this);
                    }
                    if (this.mApolloViewContoller == null)
                    {
                      QLog.e("ApolloJsPlugin", 1, "addAvatar, mApolloViewContoller null");
                      callbackError(paramString2, "ApolloViewController is null");
                      return false;
                    }
                  }
                  paramJsBridgeListener = ((JSONObject)localObject1).getJSONArray("apolloList");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    i = 0;
                    paramString1 = new ArrayList(paramJsBridgeListener.length());
                    m = paramJsBridgeListener.length();
                    j = 0;
                    if (j >= m) {
                      break label10220;
                    }
                    localObject1 = paramJsBridgeListener.getJSONObject(j);
                    paramString3 = new ApolloWebAvatarParam();
                    paramString3.isMain = false;
                    paramString3.apolloId = ((JSONObject)localObject1).optString("apolloId");
                    paramString3.x = ((JSONObject)localObject1).optInt("x", DEFAULT_WIDTH);
                    paramString3.y = ((JSONObject)localObject1).optInt("y", DEFAULT_HEIGHT);
                    paramString3.nickName = ((JSONObject)localObject1).optString("nickName");
                    paramString3.uin = ((JSONObject)localObject1).optString("uin");
                    if ((TextUtils.isEmpty(paramString3.apolloId)) || (TextUtils.isEmpty(paramString3.uin)))
                    {
                      QLog.e("ApolloJsPlugin", 1, "addAvatar, apolloId or uin is null");
                      j = 1;
                      if (j != 0)
                      {
                        QLog.e("ApolloJsPlugin", 1, "addAvatar, param invalid");
                        callbackError(paramString2, HardCodeUtil.a(2131700517));
                      }
                    }
                    else
                    {
                      paramString3.rate = ((float)((JSONObject)localObject1).optDouble("rate", 0.0D));
                      paramString3.roleId = ((JSONObject)localObject1).optInt("roleId");
                      localObject1 = ((JSONObject)localObject1).optJSONArray("dressIds");
                      bool1 = false;
                      if (paramString3.roleId > 0) {
                        bool1 = ApolloUtilImpl.checkRoleRes(paramString3.roleId);
                      }
                      bool2 = bool1;
                      if (localObject1 != null)
                      {
                        bool2 = bool1;
                        if (((JSONArray)localObject1).length() > 0)
                        {
                          int n = ((JSONArray)localObject1).length();
                          paramString3.dressIds = new int[n];
                          k = 0;
                          bool2 = bool1;
                          if (k < n)
                          {
                            int i1 = ((JSONArray)localObject1).getInt(k);
                            paramString3.dressIds[k] = i1;
                            bool2 = bool1;
                            if (paramString3.roleId <= 0) {
                              break label10320;
                            }
                            bool2 = bool1;
                            if (!bool1) {
                              break label10320;
                            }
                            bool2 = ApolloUtilImpl.checkDressRes(i1);
                            break label10320;
                          }
                        }
                      }
                      paramString3.isResExist = bool2;
                      if (bool2) {
                        break;
                      }
                      i = 1;
                      paramString1.add(paramString3);
                      if (this.mValidAvatarIdList.contains(paramString3.apolloId)) {
                        break label10333;
                      }
                      this.mValidAvatarIdList.add(paramString3.apolloId);
                      break label10333;
                    }
                    if (i != 0)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloJsPlugin", 2, "addAvatar, should request resource");
                      }
                      this.mReqBundle.clear();
                      this.mReqBundle.putInt("from", 2);
                      this.mReqBundle.putSerializable("apolloList", paramString1);
                      super.sendRemoteReq(DataFactory.a("ipc_apollo_check_avatar_res", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                    }
                    else if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                    {
                      paramJsBridgeListener = ((IApolloActivityJsCallBack)paramVarArgs).a(paramString1);
                      super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                    }
                    else if (this.mApolloViewContoller != null)
                    {
                      paramJsBridgeListener = this.mApolloViewContoller.a(paramString1);
                      super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                    }
                    else
                    {
                      QLog.e("ApolloJsPlugin", 1, "addAvatar, controller null");
                      callbackError(paramString2, HardCodeUtil.a(2131700529));
                    }
                  }
                  else
                  {
                    QLog.e("ApolloJsPlugin", 1, "addAvatar, param list null");
                    callbackError(paramString2, HardCodeUtil.a(2131700537));
                  }
                }
                else if ("destroyAvatar".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("apolloList");
                  if ((paramJsBridgeListener == null) || (paramJsBridgeListener.length() == 0))
                  {
                    callbackError(paramString2, HardCodeUtil.a(2131700526));
                  }
                  else
                  {
                    paramString1 = new ArrayList();
                    i = 0;
                    j = paramJsBridgeListener.length();
                    while (i < j)
                    {
                      paramString3 = paramJsBridgeListener.getString(i);
                      paramString1.add(paramString3);
                      this.mValidAvatarIdList.remove(paramString3);
                      i += 1;
                    }
                    if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                    {
                      ((IApolloActivityJsCallBack)paramVarArgs).a(paramString1);
                      callbackOk(paramString2);
                    }
                    else if (this.mApolloViewContoller != null)
                    {
                      this.mApolloViewContoller.a(paramString1);
                      callbackOk(paramString2);
                    }
                    else
                    {
                      QLog.e("ApolloJsPlugin", 1, "destroyAvatar, controller null");
                      callbackError(paramString2, HardCodeUtil.a(2131700521));
                    }
                  }
                }
                else if ("getRoleId".equals(paramString3))
                {
                  if (!this.mDataInited)
                  {
                    this.mReqBundle.clear();
                    this.mReqBundle.putInt("apollo_initFrom", 2);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                    return true;
                  }
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  paramString1 = new JSONObject();
                  j = this.mRoleId;
                  i = j;
                  if (j <= 0)
                  {
                    if (this.mGender == 1) {
                      break label10342;
                    }
                    if (this.mGender != 0) {
                      break label10348;
                    }
                    break label10342;
                  }
                  paramString1.put("roleId", i);
                  paramJsBridgeListener.put("data", paramString1);
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("getLocalInfo".equals(paramString3))
                {
                  if (!this.mDataInited)
                  {
                    this.mReqBundle.clear();
                    this.mReqBundle.putInt("apollo_initFrom", 3);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                    return true;
                  }
                  if ((this.mDressIds == null) || (this.mDressIds.length <= 0))
                  {
                    callbackError(paramString2, HardCodeUtil.a(2131700507));
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
                    }
                  }
                  else
                  {
                    paramJsBridgeListener = new JSONObject();
                    paramJsBridgeListener.put("result", 0);
                    paramJsBridgeListener.put("msg", "");
                    paramString1 = new JSONObject();
                    paramString3 = new JSONArray();
                    paramVarArgs = this.mDressIds;
                    j = paramVarArgs.length;
                    i = 0;
                    while (i < j)
                    {
                      paramString3.put(Integer.valueOf(paramVarArgs[i]));
                      i += 1;
                    }
                    paramString1.put("dressIds", paramString3);
                    paramJsBridgeListener.put("data", paramString1);
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "array->" + paramString3);
                    }
                  }
                }
                else if ("preview".equals(paramString3))
                {
                  if (!checkSdcard(paramVarArgs))
                  {
                    callbackError(paramString2, "sdcard未装");
                    return true;
                  }
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
                    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                    {
                      j = paramJsBridgeListener.length();
                      paramString1 = new int[j];
                      i = 0;
                      while (i < j)
                      {
                        paramString1[i] = paramJsBridgeListener.getInt(i);
                        i += 1;
                      }
                      k = paramString1.length;
                      i = 1;
                      j = 0;
                      if (j < k)
                      {
                        m = paramString1[j];
                        if ((i == 0) || (!ApolloUtilImpl.checkDressRes(m))) {
                          break label10363;
                        }
                        i = 1;
                        break label10354;
                      }
                      if (i != 0)
                      {
                        paramJsBridgeListener = ((IApolloActivityJsCallBack)paramVarArgs).a(paramString1);
                        super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                        if (QLog.isColorLevel()) {
                          QLog.e("ApolloJsPlugin", 2, "callbackId->" + paramString2 + " callbackOk" + paramJsBridgeListener);
                        }
                      }
                      else
                      {
                        this.mReqBundle.clear();
                        this.mReqBundle.putIntArray("apollo_dressIds", paramString1);
                        super.sendRemoteReq(DataFactory.a("ipc_apollo_preview", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                      }
                    }
                    else
                    {
                      callbackError(paramString2, "dressIds为空");
                    }
                  }
                  else
                  {
                    callbackError(paramString2, HardCodeUtil.a(2131700522));
                  }
                }
                else if (("previewOnFrame".equals(paramString3)) || ("previewAction".equals(paramString3)))
                {
                  if (!checkSdcard(paramVarArgs))
                  {
                    callbackError(paramString2, "sdcard未装");
                    return true;
                  }
                  i = ((JSONObject)localObject1).optInt("actionId");
                  j = ((JSONObject)localObject1).optInt("type");
                  k = ((JSONObject)localObject1).optInt("isSpecial");
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("title");
                  paramString1 = ((JSONObject)localObject1).optString("subTitle");
                  paramVarArgs = ((JSONObject)localObject1).optString("apolloId", "me");
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("apollo_previewAction", i);
                  this.mReqBundle.putBoolean("apollo_previewOnFrame", "previewOnFrame".equals(paramString3));
                  paramString3 = this.mReqBundle;
                  if (sRoleGender != 2) {
                    break label10369;
                  }
                  i = 1;
                  paramString3.putInt("apollo_partnerRoleId", i);
                  this.mReqBundle.putInt("apollo_type", j);
                  this.mReqBundle.putInt("apollo_isSpecial", k);
                  this.mReqBundle.putString("apollo_json", ((JSONObject)localObject1).toString());
                  this.mReqBundle.putString("apollo_id", paramVarArgs);
                  this.mReqBundle.putString("title", paramJsBridgeListener);
                  this.mReqBundle.putString("subTitle", paramString1);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_preview_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                }
                else if ("setup".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    j = paramJsBridgeListener.length();
                    this.mDressIds = new int[j];
                    i = 0;
                    while (i < j)
                    {
                      this.mDressIds[i] = paramJsBridgeListener.getInt(i);
                      i += 1;
                    }
                  }
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    this.mApolloStatus = 1;
                    ((IApolloActivityJsCallBack)paramVarArgs).a(this.mRoleId, this.mDressIds);
                    callbackOk(paramString2);
                    this.mReqBundle.clear();
                    paramJsBridgeListener = ((JSONObject)localObject1).optString("userData");
                    this.mReqBundle.putString("apollo_userData", paramJsBridgeListener);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_setup", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                  else
                  {
                    callbackError(paramString2, HardCodeUtil.a(2131700503));
                  }
                }
                else if ("changeRole".equals(paramString3))
                {
                  if (!checkSdcard(paramVarArgs))
                  {
                    callbackError(paramString2, "sdcard未装");
                    return true;
                  }
                  j = ((JSONObject)localObject1).getInt("roleId");
                  if (j > 0) {
                    this.mRoleId = j;
                  }
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
                  if ((j > 0) && (paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    k = paramJsBridgeListener.length();
                    this.mDressIds = new int[k];
                    i = 0;
                    while (i < k)
                    {
                      this.mDressIds[i] = paramJsBridgeListener.getInt(i);
                      i += 1;
                    }
                    paramJsBridgeListener = ((JSONObject)localObject1).optString("userData");
                    paramString1 = new JSONObject(paramJsBridgeListener);
                    sRoleGender = paramString1.optInt("sex");
                    if (paramString1.optJSONObject("role").optInt("aiFlag", 0) != 1) {
                      break label10375;
                    }
                    bool1 = true;
                    this.mIsAIRole = bool1;
                    this.mRoleId = j;
                    this.mReqBundle.clear();
                    this.mReqBundle.putIntArray("apollo_dressIds", this.mDressIds);
                    this.mReqBundle.putInt("apollo_roleId", this.mRoleId);
                    this.mReqBundle.putInt("apollo_fromSelf", 0);
                    this.mReqBundle.putString("apollo_userData", paramJsBridgeListener);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_changerole", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                  }
                  else
                  {
                    callbackError(paramString2, HardCodeUtil.a(2131700510));
                  }
                }
                else if ("closeWebview".equals(paramString3))
                {
                  super.sendRemoteReq(DataFactory.a("ipc_kandian_hb_close_guid", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  paramVarArgs.finish();
                  if (!(paramVarArgs instanceof IApolloActivityJsCallBack)) {
                    paramVarArgs.overridePendingTransition(0, 0);
                  }
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("getSwitch".equals(paramString3))
                {
                  if (!this.mDataInited)
                  {
                    this.mReqBundle.clear();
                    this.mReqBundle.putInt("apollo_initFrom", 4);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                    return true;
                  }
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  paramString1 = new JSONObject();
                  paramString1.put("status", this.mApolloStatus);
                  paramJsBridgeListener.put("data", paramString1);
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("openFloatTransparentView".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject1).getString("url");
                  i = ((JSONObject)localObject1).getInt("closeBtn");
                  j = ((JSONObject)localObject1).optInt("fullScreen");
                  paramString1 = new Intent(paramVarArgs, ApolloFloatActivity.class);
                  paramString1.putExtra("extra_key_click_time", System.currentTimeMillis());
                  paramString1.putExtra("extra_key_weburl", paramJsBridgeListener);
                  if (i != 1) {
                    break label10381;
                  }
                  bool1 = true;
                  paramString1.putExtra("extra_key_close_btn", bool1);
                  if (j != 1) {
                    break label10387;
                  }
                  bool1 = true;
                  paramString1.putExtra("extra_key_fullscreen", bool1);
                  paramString1.putExtra("big_brother_source_key", "biz_src_zf_lmx");
                  paramVarArgs.startActivity(paramString1);
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("openApolloShow".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("nick");
                  paramString1 = ((JSONObject)localObject1).optString("uin");
                  paramString3 = new Intent(paramVarArgs, ApolloGuestsStateActivity.class);
                  paramString3.putExtra("extra_guest_nick", paramJsBridgeListener);
                  paramString3.putExtra("extra_guest_uin", paramString1);
                  paramVarArgs.startActivity(paramString3);
                  paramVarArgs.overridePendingTransition(0, 0);
                  callbackOk(paramString2);
                }
                else if ("getFriendsByOpenApollo".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_get_openapollo_friends", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("sendActionToFrd".equals(paramString3))
                {
                  i = ((JSONObject)localObject1).optInt("actionId", -1);
                  j = ((JSONObject)localObject1).optInt("pkgId", -1);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, new Object[] { "apolloJsPlugin call sendActionToFrd, pkgId=", Integer.valueOf(j), ", actionId=", Integer.valueOf(i) });
                  }
                  paramJsBridgeListener = new Bundle();
                  paramJsBridgeListener.putInt("forward_type", 26);
                  paramJsBridgeListener.putInt("apollo_actionid_key", i);
                  paramJsBridgeListener.putInt("apollo_pkgid_key", j);
                  paramString1 = new Intent(this.mRuntime.a().getApplicationContext(), ForwardRecentActivity.class);
                  paramString1.addFlags(268435456);
                  paramString1.addFlags(67108864);
                  paramString1.putExtras(paramJsBridgeListener);
                  this.mRuntime.a().startActivity(paramString1);
                }
                else if ("refreshAction".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_refresh_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call refreshAction");
                  }
                }
                else if ("getLocalFavAction".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_getfav_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call getLocalFavAction");
                  }
                }
                else if ("addCustomAction".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  i = ((JSONObject)localObject1).optInt("actionId");
                  j = ((JSONObject)localObject1).optInt("textType");
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("actionText");
                  k = ((JSONObject)localObject1).optInt("audioId");
                  m = ((JSONObject)localObject1).optInt("playOriginalAudio");
                  float f = ((JSONObject)localObject1).optInt("audioStartTime");
                  this.mReqBundle.putInt("actionId", i);
                  this.mReqBundle.putString("actionText", paramJsBridgeListener);
                  this.mReqBundle.putInt("textType", j);
                  this.mReqBundle.putInt("audioId", k);
                  this.mReqBundle.putInt("playOriginalAudio", m);
                  this.mReqBundle.putFloat("audioStartTime", f);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_add_fav_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call addCustomAction");
                  }
                }
                else if ("delLocalFavAction".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("delJson", ((JSONObject)localObject1).opt("favActionDel").toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_del_fav_list", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call delLocalFavList");
                  }
                }
                else if ("writeLocalData".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("writeData", ((JSONObject)localObject1).toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_write_local", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call writeLocalData");
                  }
                }
                else if ("redbagCallback".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  i = ((JSONObject)localObject1).optInt("bonusSuccess", 0);
                  if (i == 1)
                  {
                    this.mReqBundle.putInt("bonusSuccess", i);
                    super.sendRemoteReq(DataFactory.a("ipc_kandian_hb_lottery", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                }
                else if ("removeBubble".equals(paramString3))
                {
                  l = ((JSONObject)localObject1).optLong("bubbleId");
                  this.mReqBundle.clear();
                  this.mReqBundle.putLong("bubble_id", l);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_clear_bubble", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("downloadImageOnFrame".equals(paramString3))
                {
                  i = new Random().nextInt();
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("apollo_previewAction", i);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_downloadImageOnFrame", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                }
                else if ("addGame".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("gameListJson", ((JSONObject)localObject1).toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_add_game", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("delGame".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("gameListJson", ((JSONObject)localObject1).toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_del_game", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("updateGameList".equals(paramString3))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, new Object[] { "[handleJsRequest] updateGameList, json=", localObject1 });
                  }
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("gameListJson", ((JSONObject)localObject1).toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_update_game_list", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("isCmFaceAdded".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("faceIdList");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    this.mReqBundle.putString("faceIdList", paramJsBridgeListener.toString());
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_is_cm_face_added", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                  else
                  {
                    paramJsBridgeListener = new JSONObject();
                    paramJsBridgeListener.put("result", 1);
                    paramJsBridgeListener.put("msg", HardCodeUtil.a(2131700499));
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                  }
                }
                else if ("addCmFace".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("faceIdList");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    this.mReqBundle.putString("faceIdList", paramJsBridgeListener.toString());
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_add_cm_face", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                  else
                  {
                    paramJsBridgeListener = new JSONObject();
                    paramJsBridgeListener.put("result", 1);
                    paramJsBridgeListener.put("msg", HardCodeUtil.a(2131700516));
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                  }
                }
                else if ("downloadTbs".equals(paramString3))
                {
                  paramJsBridgeListener = this.mRuntime.a();
                  if ((paramJsBridgeListener instanceof BrowserAppInterface)) {
                    ((BrowserAppInterface)paramJsBridgeListener).a(true);
                  }
                }
                else if ("setLeftViewIcon".equals(paramString3))
                {
                  paramString1 = ((JSONObject)localObject1).optString("url");
                  if (!TextUtils.isEmpty(paramString1))
                  {
                    paramJsBridgeListener = (SwiftBrowserUIStyleHandler)access$101(this, 2);
                    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a != null) && (paramJsBridgeListener.a.a != null))
                    {
                      paramString3 = URLDrawable.URLDrawableOptions.obtain();
                      paramString3.mLoadingDrawable = paramVarArgs.getResources().getDrawable(2130851150);
                      paramString1 = URLDrawable.getDrawable(paramString1, paramString3);
                      paramString1.startDownload();
                      paramJsBridgeListener.a.a.setBackgroundDrawable(paramString1);
                    }
                  }
                }
                else if ("getUserInfo".equals(paramString3))
                {
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  paramString1 = new JSONObject();
                  paramString3 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4);
                  paramVarArgs = this.mRuntime.a().getCurrentAccountUin();
                  bool1 = paramString3.getBoolean(paramVarArgs + "_" + "sp_key_new_store_whitelist", false);
                  bool2 = paramString3.getBoolean(paramVarArgs + "_" + "sp_key_drawer_game_entry_whitelist", false);
                  if (!QLog.isColorLevel()) {
                    break label10393;
                  }
                  QLog.d("ApolloJsPlugin", 2, new Object[] { "getUserInfo, isNewStoreUser=", Boolean.valueOf(bool1), ", isGameBoxUser=", Boolean.valueOf(bool2) });
                  break label10393;
                  paramString1.put("isInNewShopWhiteList", i);
                  if (!bool2) {
                    break label10410;
                  }
                  i = 1;
                  paramString1.put("isInGameBoxWhiteList", i);
                  paramJsBridgeListener.put("data", paramString1);
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("showGameCard".equals(paramString3))
                {
                  ApolloUtilImpl.launchGameDetailView(((JSONObject)localObject1).optInt("gameId"), ((JSONObject)localObject1).optString("extraInfo"), this.mRuntime.a());
                }
                else if ("createShortcut".equals(paramString3))
                {
                  ApolloGameUtil.b(((JSONObject)localObject1).optInt("src"), ((JSONObject)localObject1).optString("name"));
                  callbackOk(paramString2);
                }
                else if ("openCmGameMatch".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("url", ((JSONObject)localObject1).optString("url"));
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, new Object[] { "openCmGameMatch, url=", paramString1 });
                  }
                  super.sendRemoteReq(DataFactory.a("ipc_open_cm_game_match_page", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("isTcpConnected".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  super.sendRemoteReq(DataFactory.a("ipc_cm_game_conn_connected", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("checkCmGameWebView".equals(paramString3))
                {
                  if ((paramVarArgs instanceof QQBrowserActivity))
                  {
                    paramJsBridgeListener = ((QQBrowserActivity)paramVarArgs).getCurrentWebViewFragment();
                    paramString1 = getAbsoluteUrl();
                    if ((!(paramJsBridgeListener instanceof CmGameFragment)) && (!TextUtils.isEmpty(paramString1)))
                    {
                      QLog.d("ApolloJsPlugin", 1, "[checkCmGameWebView] not CmGameFragment");
                      callbackOk(paramString2);
                      paramVarArgs.finish();
                      CmGameUtil.a(paramVarArgs, paramString1);
                    }
                    else
                    {
                      QLog.d("ApolloJsPlugin", 1, "[checkCmGameWebView] is CmGameFragment");
                      callbackOk(paramString2);
                    }
                  }
                }
                else if ("sendGameAppArkMessage".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("friendUin");
                  paramString1 = ((JSONObject)localObject1).optJSONObject("arkInfo");
                  if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (paramString1 != null))
                  {
                    this.mReqBundle.putString("friendUin", paramJsBridgeListener);
                    this.mReqBundle.putString("arkInfo", paramString1.toString());
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "sendGameAppArkMessage");
                    }
                    super.sendRemoteReq(DataFactory.a("ipc_open_cm_game_send_game_app_ark_msg", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                  else
                  {
                    callbackError(paramString2, "param error");
                  }
                }
                else if ("saveGameToPlus".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("launchUrl");
                  paramString1 = ((JSONObject)localObject1).optString("gameName");
                  paramString3 = ((JSONObject)localObject1).optString("iconUrl");
                  paramVarArgs = ((JSONObject)localObject1).optString("appid");
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "saveGameToPlus url=" + paramJsBridgeListener);
                  }
                  if ((!TextUtils.isEmpty(paramVarArgs)) && (!TextUtils.isEmpty(paramJsBridgeListener)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
                  {
                    this.mReqBundle.putString("launchUrl", paramJsBridgeListener);
                    this.mReqBundle.putString("gameName", paramString1);
                    this.mReqBundle.putString("iconUrl", paramString3);
                    this.mReqBundle.putString("appid", paramVarArgs);
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "sendGameAppArkMessage");
                    }
                    super.sendRemoteReq(DataFactory.a("ipc_save_game_to_plus", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                  else
                  {
                    callbackError(paramString2, "param error");
                  }
                }
                else if ("isX86".equals(paramString3))
                {
                  paramJsBridgeListener = new JSONObject();
                  if (!ApolloGameUtil.a()) {
                    break label10416;
                  }
                  i = 1;
                  paramJsBridgeListener.put("result", i);
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, new Object[] { "isX86:", Boolean.valueOf(ApolloGameUtil.a()) });
                  }
                }
                else if (handleCmShow3DJsRequest(paramString3, (JSONObject)localObject1, paramString2, paramVarArgs))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 1, "handleCmShow3DJsRequest handled " + paramString3);
                  }
                }
                else if ((handleCmShowAvatarJSRequest(paramString3, (JSONObject)localObject1, paramString2)) && (QLog.isColorLevel()))
                {
                  QLog.d("ApolloJsPlugin", 1, "handleCmShowAvatarJSRequest handled " + paramString3);
                }
              }
            }
          }
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("ApolloJsPlugin", 1, paramJsBridgeListener.getMessage());
      }
    }
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    if (!paramString1.contains("thunder_id")) {
      return false;
    }
    this.mInterceptorUrl = paramString1;
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, "apollo_client onApolloJsCreate");
    }
    createInterceptor();
    ((IApolloEngine)QRoute.api(IApolloEngine.class)).checkEngineReady();
    QRoute.api(ICmShowRscCacheManager.class);
    AECMShowUtil.a();
    this.mReqBundle = new Bundle();
    sResponseKey = this.mOnRemoteResp.key;
    sApolloReceiver.a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mInterceptor != null)
    {
      this.mInterceptor.a();
      this.mInterceptor = null;
    }
    if (this.mApolloViewContoller != null) {
      this.mApolloViewContoller.d();
    }
    if (this.gameDialog != null) {
      this.gameDialog.dismiss();
    }
    sApolloReceiver.b(this);
    this.mCmGameStartChecker = null;
    this.mCmGameStartCheckerListener = null;
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, new Object[] { "onNotifyLongTouch:", paramString });
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, new Object[] { "[onNotifyStatusChanged] status=", Integer.valueOf(paramInt), ", apolloId=", paramString });
    }
    if (TextUtils.isEmpty(paramString))
    {
      super.callJs("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar();");
      return;
    }
    super.callJs(String.format("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar('%s');", new Object[] { paramString }));
  }
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject3;
    String str;
    Object localObject2;
    Object localObject1;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject3 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      localObject2 = paramBundle.getBundle("response");
      if ((localObject3 != null) && (localObject2 != null))
      {
        localObject1 = getActivity();
        if ((localObject1 != null) && (!this.isDestroy) && (!((Activity)localObject1).isFinishing())) {
          break label98;
        }
        callbackError(str, HardCodeUtil.a(2131700495));
      }
    }
    label97:
    return;
    label98:
    int j;
    label192:
    boolean bool1;
    label2087:
    label2150:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            try
            {
              if (!"ipc_apollo_start_record_msg".equals(localObject3)) {
                break label192;
              }
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
            }
            catch (Throwable paramBundle)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ApolloJsPlugin", 2, paramBundle.getMessage());
              }
              callbackError(str, HardCodeUtil.a(2131700500));
              return;
            }
            callbackError(str, i + "");
            return;
            if ("ipc_apollo_stop_record_msg".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, i + "");
              return;
            }
            if ("ipc_apollo_upload_record_msg".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, i + "");
              return;
            }
            if ("ipc_apollo_play_last_record_msg".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, i + "");
              return;
            }
            if ("ipc_apollo_stop_last_record_msg".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, i + "");
              return;
            }
            if ("ipc_apollo_get_playmate_msg".equals(localObject3))
            {
              paramBundle = ((Bundle)localObject2).getString("result");
              super.callJs(str + "&&" + str + "(" + paramBundle + ");");
              return;
            }
            if ("ipc_apollo_preview".equals(localObject3))
            {
              paramBundle = ((Bundle)localObject2).getIntArray("apollo_dressIds");
              if ((((Bundle)localObject2).getInt("apollo_result") == 0) && (paramBundle != null))
              {
                callbackError(str, HardCodeUtil.a(2131700501));
                return;
              }
              if (this.mApolloViewContoller != null)
              {
                paramBundle = this.mApolloViewContoller.a(paramBundle);
                super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                if (QLog.isColorLevel()) {
                  QLog.e("ApolloJsPlugin", 2, "callbackId->" + str + " callbackOk" + paramBundle);
                }
              }
              else if ((localObject1 instanceof IApolloActivityJsCallBack))
              {
                paramBundle = ((IApolloActivityJsCallBack)localObject1).a(paramBundle);
                super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                if (QLog.isColorLevel()) {
                  QLog.e("ApolloJsPlugin", 2, "callbackId->" + str + " callbackOk" + paramBundle);
                }
              }
              else
              {
                callbackError(str, HardCodeUtil.a(2131700512));
              }
            }
            else
            {
              Object localObject4;
              Object localObject5;
              Object localObject6;
              if (("ipc_apollo_preview_action".equals(localObject3)) || ("ipc_apollo_preview_audio_action".equals(localObject3)))
              {
                i = ((Bundle)localObject2).getInt("apollo_previewAction");
                j = ((Bundle)localObject2).getInt("apollo_apolloVipFlag");
                int k = ((Bundle)localObject2).getInt("apollo_apolloVipLevel");
                paramBundle = ((Bundle)localObject2).getString("title");
                localObject4 = ((Bundle)localObject2).getString("subTitle");
                localObject5 = ((Bundle)localObject2).getString("apollo_json");
                bool1 = ((Bundle)localObject2).getBoolean("apollo_previewOnFrame");
                Object localObject7 = new JSONObject((String)localObject5);
                int m = ((JSONObject)localObject7).optInt("type");
                int n = ((JSONObject)localObject7).optInt("isSpecial");
                int i1 = ((JSONObject)localObject7).optInt("vipLevel");
                int i2 = ((JSONObject)localObject7).optInt("feeType");
                int i3 = ((JSONObject)localObject7).optInt("isDiyAction");
                int i4 = ((JSONObject)localObject7).optInt("textType");
                int i5 = ((JSONObject)localObject7).optInt("playCount");
                int i6 = ((JSONObject)localObject7).optInt("playOriginalAudio");
                int i7 = ((JSONObject)localObject7).optInt("audioId");
                float f1 = (float)((JSONObject)localObject7).optDouble("audioStartTime");
                float f2 = (float)((JSONObject)localObject7).optDouble("frameTime");
                localObject6 = ((JSONObject)localObject7).optString("text");
                ((JSONObject)localObject7).optString("animationName");
                int i8 = ((Bundle)localObject2).getInt("apollo_result");
                int i9 = ((Bundle)localObject2).getInt("apollo_partnerRoleId");
                localObject7 = ((Bundle)localObject2).getString("apollo_id");
                boolean bool2 = ((Bundle)localObject2).getBoolean("apollo_is_super_yellow");
                localObject2 = new ApolloViewController.PlayActionData();
                ((ApolloViewController.PlayActionData)localObject2).jdField_a_of_type_Int = i5;
                ((ApolloViewController.PlayActionData)localObject2).jdField_b_of_type_Int = i;
                ((ApolloViewController.PlayActionData)localObject2).jdField_c_of_type_Int = m;
                ((ApolloViewController.PlayActionData)localObject2).jdField_d_of_type_Int = n;
                ((ApolloViewController.PlayActionData)localObject2).e = i1;
                ((ApolloViewController.PlayActionData)localObject2).f = j;
                ((ApolloViewController.PlayActionData)localObject2).g = k;
                ((ApolloViewController.PlayActionData)localObject2).h = i2;
                ((ApolloViewController.PlayActionData)localObject2).i = i9;
                ((ApolloViewController.PlayActionData)localObject2).j = i3;
                ((ApolloViewController.PlayActionData)localObject2).k = i4;
                ((ApolloViewController.PlayActionData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject6);
                ((ApolloViewController.PlayActionData)localObject2).l = i6;
                ((ApolloViewController.PlayActionData)localObject2).m = i7;
                ((ApolloViewController.PlayActionData)localObject2).jdField_a_of_type_Float = f1;
                ((ApolloViewController.PlayActionData)localObject2).jdField_b_of_type_Float = f2;
                ((ApolloViewController.PlayActionData)localObject2).jdField_a_of_type_Boolean = bool1;
                ((ApolloViewController.PlayActionData)localObject2).jdField_c_of_type_JavaLangString = paramBundle;
                ((ApolloViewController.PlayActionData)localObject2).jdField_d_of_type_JavaLangString = ((String)localObject4);
                ((ApolloViewController.PlayActionData)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject7);
                ((ApolloViewController.PlayActionData)localObject2).jdField_b_of_type_Boolean = bool2;
                if ((i8 == 0) && (i > 0))
                {
                  if ("ipc_apollo_preview_audio_action".equals(localObject3))
                  {
                    paramBundle = ApolloViewController.a("ApolloViewController is null or Activity not instanceof IApolloActivityJsCallBack");
                    if (this.mApolloViewContoller != null)
                    {
                      paramBundle = this.mApolloViewContoller.a((ApolloViewController.PlayActionData)localObject2);
                      super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                    }
                    while (QLog.isColorLevel())
                    {
                      QLog.e("ApolloJsPlugin", 2, "IPC_APOLLO_PREVIEW_AUDIO_ACTION callbackId->" + str + " callbackOk" + paramBundle);
                      return;
                      if ((localObject1 instanceof IApolloActivityJsCallBack))
                      {
                        paramBundle = ((IApolloActivityJsCallBack)localObject1).a((ApolloViewController.PlayActionData)localObject2);
                        super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                      }
                    }
                  }
                  else if ("ipc_apollo_preview_action".equals(localObject3))
                  {
                    localObject3 = new File(((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).getAudioFilePath(i7));
                    if ((i7 > 0) && (!((File)localObject3).exists()))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("ApolloJsPlugin", 2, "IPC_APOLLO_PREVIEW_ACTION audio file no exsit callbackId->" + str);
                      }
                      this.mReqBundle.clear();
                      this.mReqBundle.putInt("apollo_previewAction", i);
                      this.mReqBundle.putInt("apollo_apolloVipFlag", j);
                      this.mReqBundle.putInt("apollo_apolloVipLevel", k);
                      this.mReqBundle.putBoolean("apollo_previewOnFrame", bool1);
                      this.mReqBundle.putInt("apollo_partnerRoleId", i9);
                      this.mReqBundle.putInt("apollo_audioId", i7);
                      this.mReqBundle.putString("apollo_json", ((String)localObject5).toString());
                      this.mReqBundle.putString("title", paramBundle);
                      this.mReqBundle.putString("subTitle", (String)localObject4);
                      super.sendRemoteReq(DataFactory.a("ipc_apollo_preview_audio_action", str, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                      return;
                    }
                    paramBundle = ApolloViewController.a("ApolloViewController is null or Activity not instanceof IApolloActivityJsCallBack");
                    if ((localObject1 instanceof IApolloActivityJsCallBack))
                    {
                      paramBundle = ((IApolloActivityJsCallBack)localObject1).a((ApolloViewController.PlayActionData)localObject2);
                      super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                    }
                    while (QLog.isColorLevel())
                    {
                      QLog.e("ApolloJsPlugin", 2, "IPC_APOLLO_PREVIEW_ACTION callbackId->" + str + " callbackOk" + paramBundle);
                      return;
                      if (this.mApolloViewContoller != null)
                      {
                        paramBundle = this.mApolloViewContoller.a((ApolloViewController.PlayActionData)localObject2);
                        super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                      }
                      else
                      {
                        callbackError(str, HardCodeUtil.a(2131700530));
                      }
                    }
                  }
                }
                else {
                  callbackError(str, HardCodeUtil.a(2131700527) + (String)localObject3);
                }
              }
              else if ("ipc_apollo_check_avatar_res".equals(localObject3))
              {
                i = ((Bundle)localObject2).getInt("result");
                j = ((Bundle)localObject2).getInt("from");
                paramBundle = ((Bundle)localObject2).getString("msg");
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_CHECK_AVATAR_RES, ret=", Integer.valueOf(i), ", msg=", paramBundle, ", from=", Integer.valueOf(j) });
                }
                localObject3 = (ArrayList)((Bundle)localObject2).getSerializable("apolloList");
                if (i == 0)
                {
                  if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0))
                  {
                    callbackError(str, HardCodeUtil.a(2131700506));
                    return;
                  }
                  paramBundle = ((Bundle)localObject2).getString("reqUrl");
                  if (TextUtils.isEmpty(paramBundle)) {
                    break label5552;
                  }
                  localObject2 = getAbsoluteUrl();
                  if (paramBundle.equals(localObject2)) {
                    break label5552;
                  }
                  callbackError(str, "WebView已经切换url");
                  QLog.e("ApolloJsPlugin", 1, new Object[] { "reqUrl:", paramBundle, " absoluteUrl:", localObject2 });
                  return;
                  localObject2 = (ApolloWebAvatarParam)((ArrayList)localObject3).get(0);
                  if (((ApolloWebAvatarParam)localObject2).isResExist)
                  {
                    if (this.mValidAvatarIdList.contains(((ApolloWebAvatarParam)localObject2).apolloId))
                    {
                      paramBundle = "";
                      if (j == 1)
                      {
                        if (this.mApolloViewContoller == null) {
                          break label5566;
                        }
                        paramBundle = this.mApolloViewContoller.a(1, true, (ApolloWebAvatarParam)localObject2);
                      }
                      for (;;)
                      {
                        super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                        return;
                        if (j == 0)
                        {
                          if (!(localObject1 instanceof IApolloActivityJsCallBack)) {
                            break;
                          }
                          paramBundle = ((IApolloActivityJsCallBack)localObject1).a(this.mApolloStatus, (ApolloWebAvatarParam)localObject2);
                        }
                      }
                    }
                    QLog.e("ApolloJsPlugin", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] initAvatar abort, apolloId is detroyed, id=", ((ApolloWebAvatarParam)localObject2).apolloId });
                    return;
                  }
                  paramBundle = null;
                  localObject1 = getActivity();
                  if ((localObject1 instanceof BaseActivity)) {
                    paramBundle = ((BaseActivity)localObject1).getAppInterface();
                  }
                  if (paramBundle != null)
                  {
                    ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(paramBundle, ((ApolloWebAvatarParam)localObject2).uin, new ApolloJsPluginImpl.9(this, (ApolloWebAvatarParam)localObject2, j, str), ((ApolloWebAvatarParam)localObject2).roleId, ((ApolloWebAvatarParam)localObject2).dressIds, -1, -1, false);
                    return;
                  }
                  callbackError(str, "获取AppInterface失败");
                  return;
                  if (j == 2)
                  {
                    localObject2 = new AtomicInteger(0);
                    paramBundle = null;
                    localObject4 = getActivity();
                    if ((localObject4 instanceof BaseActivity)) {
                      paramBundle = ((BaseActivity)localObject4).getAppInterface();
                    }
                    localObject4 = ((ArrayList)localObject3).iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localObject5 = (ApolloWebAvatarParam)((Iterator)localObject4).next();
                      if (((ApolloWebAvatarParam)localObject5).isResExist)
                      {
                        localObject6 = new ArrayList();
                        ((ArrayList)localObject6).add(localObject5);
                        if (this.mValidAvatarIdList.contains(((ApolloWebAvatarParam)localObject5).apolloId))
                        {
                          if (!(localObject1 instanceof IApolloActivityJsCallBack)) {
                            break label2501;
                          }
                          ((IApolloActivityJsCallBack)localObject1).a((ArrayList)localObject6);
                        }
                        for (;;)
                        {
                          ((AtomicInteger)localObject2).getAndIncrement();
                          if (((AtomicInteger)localObject2).get() != ((ArrayList)localObject3).size()) {
                            break;
                          }
                          callbackOk(str);
                          break;
                          if (this.mApolloViewContoller != null) {
                            this.mApolloViewContoller.a((ArrayList)localObject6);
                          }
                        }
                      }
                      if (paramBundle != null)
                      {
                        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(paramBundle, ((ApolloWebAvatarParam)localObject5).uin, new ApolloJsPluginImpl.10(this, (ApolloWebAvatarParam)localObject5, (AtomicInteger)localObject2, (ArrayList)localObject3, str), ((ApolloWebAvatarParam)localObject5).roleId, ((ApolloWebAvatarParam)localObject5).dressIds, -1, -1, false);
                      }
                      else
                      {
                        QLog.e("ApolloJsPlugin", 1, new Object[] { "addAvatar, app null, uin=", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(((ApolloWebAvatarParam)localObject5).uin) });
                        ((AtomicInteger)localObject2).getAndIncrement();
                        if (((AtomicInteger)localObject2).get() == ((ArrayList)localObject3).size()) {
                          callbackOk(str);
                        }
                      }
                    }
                  }
                }
                else
                {
                  if (j != 2) {
                    QQToast.a((Context)localObject1, HardCodeUtil.a(2131700494), 1).a();
                  }
                  callbackError(str, HardCodeUtil.a(2131700504));
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "下载素材角色装扮素材失败->mRoleId" + this.mRoleId + " mDressIds->" + this.mDressIds);
                  }
                }
              }
              else
              {
                if ("ipc_apollo_changerole".equals(localObject3))
                {
                  i = ((Bundle)localObject2).getInt("apollo_result");
                  j = ((Bundle)localObject2).getInt("apollo_roleId");
                  localObject1 = ((Bundle)localObject2).getIntArray("apollo_dressIds");
                  if (localObject1 != null)
                  {
                    paramBundle = (Bundle)localObject1;
                    if (localObject1.length > 0) {}
                  }
                  else
                  {
                    paramBundle = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(j);
                  }
                  this.mDressIds = paramBundle;
                  this.mRoleId = j;
                  this.mApolloStatus = 1;
                  if ((i == 0) && (paramBundle != null) && (paramBundle.length > 0))
                  {
                    callbackOk(str);
                    return;
                  }
                  callbackError(str, HardCodeUtil.a(2131700490));
                  return;
                }
                if ("ipc_apollo_get_apollo_data".equals(localObject3))
                {
                  this.mDataInited = true;
                  i = ((Bundle)localObject2).getInt("apollo_initFrom");
                  this.mRoleId = ((Bundle)localObject2).getInt("apollo_roleId");
                  this.mGender = ((Bundle)localObject2).getInt("apollo_gender");
                  this.mApolloStatus = ((Bundle)localObject2).getInt("apollo_apolloStatus");
                  this.mDressIds = ((Bundle)localObject2).getIntArray("apollo_dressIds");
                  sRoleGender = ((Bundle)localObject2).getInt("apollo_roleGender");
                  if (this.mRoleId <= 0)
                  {
                    if ((this.mGender != 1) && (this.mGender != 0)) {
                      break label3009;
                    }
                    this.mRoleId = 1;
                  }
                  for (;;)
                  {
                    if (3 == i)
                    {
                      if ((this.mDressIds == null) || (this.mDressIds.length <= 0))
                      {
                        callbackError(str, HardCodeUtil.a(2131700532));
                        if (!QLog.isColorLevel()) {
                          break;
                        }
                        QLog.d("ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
                        return;
                        this.mRoleId = 2;
                        continue;
                      }
                      paramBundle = new JSONObject();
                      paramBundle.put("result", 0);
                      paramBundle.put("msg", "");
                      localObject1 = new JSONObject();
                      localObject2 = new JSONArray();
                      localObject3 = this.mDressIds;
                      j = localObject3.length;
                      i = 0;
                      while (i < j)
                      {
                        ((JSONArray)localObject2).put(Integer.valueOf(localObject3[i]));
                        i += 1;
                      }
                      ((JSONObject)localObject1).put("dressIds", localObject2);
                      paramBundle.put("data", localObject1);
                      super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d("ApolloJsPlugin", 2, "dressIds.array->" + localObject2);
                      return;
                    }
                  }
                  if (2 == i)
                  {
                    if (this.mRoleId <= 0)
                    {
                      callbackError(str, HardCodeUtil.a(2131700511));
                      return;
                    }
                    paramBundle = new JSONObject();
                    paramBundle.put("result", 0);
                    paramBundle.put("msg", "");
                    localObject1 = new JSONObject();
                    ((JSONObject)localObject1).put("roleId", this.mRoleId);
                    paramBundle.put("data", localObject1);
                    super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
                    return;
                  }
                  if (4 == i)
                  {
                    paramBundle = new JSONObject();
                    paramBundle.put("result", 0);
                    paramBundle.put("msg", "");
                    localObject1 = new JSONObject();
                    ((JSONObject)localObject1).put("status", this.mApolloStatus);
                    paramBundle.put("data", localObject1);
                    super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
                  }
                }
                else if ("ipc_apollo_get_openapollo_friends".equals(localObject3))
                {
                  i = ((Bundle)localObject2).getInt("apollo_result");
                  paramBundle = ((Bundle)localObject2).getString("apollo_data");
                  if (i == 0)
                  {
                    localObject1 = new JSONObject();
                    ((JSONObject)localObject1).put("result", 0);
                    ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                    super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
                  }
                  while (QLog.isColorLevel())
                  {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS onResponse dataStr is:" + paramBundle);
                    return;
                    callbackError(str, HardCodeUtil.a(2131700519));
                  }
                }
                else if ("ipc_apollo_query_mine_redinfo".equals(localObject3))
                {
                  i = ((Bundle)localObject2).getInt("isNewFlag");
                  if ((i == 1) && ((localObject1 instanceof IApolloActivityJsCallBack))) {
                    ((IApolloActivityJsCallBack)localObject1).b();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_QUERY_MINE_REDINFO onResponse dataInt is:" + i);
                  }
                }
                else if ("ipc_apollo_getfav_action".equals(localObject3))
                {
                  paramBundle = ((Bundle)localObject2).getString("getFavResult");
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                  ((JSONObject)localObject1).put("result", 0);
                  super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_GETFAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
                  }
                }
                else if ("ipc_apollo_add_fav_action".equals(localObject3))
                {
                  paramBundle = ((Bundle)localObject2).getString("addFavAction");
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                  ((JSONObject)localObject1).put("result", 0);
                  super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_ADD_FAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
                  }
                }
                else
                {
                  if (!"ipc_apollo_del_fav_action".equals(localObject3)) {
                    break;
                  }
                  paramBundle = ((Bundle)localObject2).getString("delFavAction");
                  i = new JSONObject(paramBundle).optInt("ret");
                  localObject1 = new JSONObject();
                  if (i == 0)
                  {
                    ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                    ((JSONObject)localObject1).put("result", 0);
                    super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
                  }
                  while (QLog.isColorLevel())
                  {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_DEL_FAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
                    return;
                    if (i == 1) {
                      callbackError(str, HardCodeUtil.a(2131700509));
                    } else if (i == 2) {
                      callbackError(str, HardCodeUtil.a(2131700518));
                    } else {
                      callbackError(str, HardCodeUtil.a(2131700505));
                    }
                  }
                }
              }
            }
          }
          if ("ipc_apollo_del_fav_list".equals(localObject3))
          {
            paramBundle = new JSONObject(((Bundle)localObject2).getString("delFavListAction"));
            localObject1 = new JSONObject();
            if (paramBundle.optBoolean("delHasError")) {
              ((JSONObject)localObject1).put("result", 1);
            }
            for (;;)
            {
              ((JSONObject)localObject1).put("data", paramBundle.opt("errorList"));
              super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_DEL_FAV_List onResponse data is:" + ((JSONObject)localObject1).toString());
              return;
              ((JSONObject)localObject1).put("result", 0);
            }
          }
          if (!"ipc_apollo_write_local".equals(localObject3)) {
            break;
          }
          paramBundle = new JSONObject(((Bundle)localObject2).getString("writeRet"));
          super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
        } while (!QLog.isColorLevel());
        QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_WRITE_LOCAL onResponse data is:" + paramBundle.toString());
        return;
        if (!"ipc_apollo_downloadImageOnFrame".equals(localObject3)) {
          break;
        }
      } while (!(localObject1 instanceof IApolloActivityJsCallBack));
      ((IApolloActivityJsCallBack)localObject1).b(str);
      return;
      if ((!"ipc_apollo_add_game".equals(localObject3)) && (!"ipc_apollo_del_game".equals(localObject3))) {
        break;
      }
      paramBundle = String.format("%s({\"result\":%d, \"message\":\"%s\"});", new Object[] { str, Integer.valueOf(((Bundle)localObject2).getInt("result")), ((Bundle)localObject2).getString("message") });
      super.callJs(paramBundle);
    } while (!QLog.isColorLevel());
    label2501:
    QLog.d("ApolloJsPlugin", 2, new Object[] { "cmd=", localObject3, ", callbackStr=", paramBundle });
    label3009:
    return;
    if ("ipc_apollo_start_apollo_game".equals(localObject3))
    {
      if (((Bundle)localObject2).getInt("result") == 0)
      {
        callbackOk(str);
        return;
      }
      callbackError(str, HardCodeUtil.a(2131700523));
      return;
    }
    if ("ipc_apollo_choose_friend_play_game".equals(localObject3))
    {
      i = ((Bundle)localObject2).getInt("gameId");
      j = ((Bundle)localObject2).getInt("gameMode");
      if (((Bundle)localObject2).getBoolean("hasGameRunning"))
      {
        this.gameDialog = DialogUtil.a((Context)localObject1, 0, "", HardCodeUtil.a(2131700493), 2131690800, 2131694615, new ApolloJsPluginImpl.11(this, i, j), new ApolloJsPluginImpl.12(this));
        if ((localObject1 instanceof BaseActivity)) {
          VipUtils.a(((BaseActivity)localObject1).getAppInterface(), "cmshow", "Apollo", "game_alert_show", 3, 0, new String[0]);
        }
        this.gameDialog.show();
        return;
      }
      paramBundle = new ApolloGameMsgInfo();
      paramBundle.gameId = i;
      ApolloGameBasicEventUtil.a(paramBundle, this.mRuntime.a(), 2);
      return;
    }
    if ("IPC_APOLLO_DOWNLOAD_GAME".equals(localObject3))
    {
      paramBundle = (CmGameStartChecker.StartCheckParam)((Bundle)localObject2).getSerializable("StartCheckParam");
      if (paramBundle == null)
      {
        callbackError(str, HardCodeUtil.a(2131700534));
        return;
      }
      localObject1 = CmGameUtil.a();
      this.mCmGameStartChecker = new CmGameStartChecker((AppInterface)localObject1);
      this.mCmGameStartCheckerListener = new ApolloJsPluginImpl.13(this, (AppInterface)localObject1, false, str);
      this.mCmGameStartChecker.a(paramBundle, this.mCmGameStartCheckerListener);
      return;
    }
    if ("ipc_apollo_update_game_list".equals(localObject3))
    {
      paramBundle = String.format("%s({\"result\":%d});", new Object[] { str, Integer.valueOf(((Bundle)localObject2).getInt("result")) });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_UPDATE_GAME_LIST, result=", paramBundle });
      }
      super.callJs(paramBundle);
      return;
    }
    if ("ipc_apollo_add_cm_face".equals(localObject3))
    {
      paramBundle = String.format("%s({\"result\":%d,\"msg\":\"%s\"});", new Object[] { str, Integer.valueOf(((Bundle)localObject2).getInt("result")), ((Bundle)localObject2).getString("msg") });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_ADD_CM_FACE, result=", paramBundle });
      }
      super.callJs(paramBundle);
      return;
    }
    if ("ipc_apollo_is_cm_face_added".equals(localObject3))
    {
      i = ((Bundle)localObject2).getInt("result");
      paramBundle = ((Bundle)localObject2).getString("msg");
      paramBundle = String.format("%s({\"result\":%d,\"data\":{\"status\":%s}, \"msg\":\"%s\"});", new Object[] { str, Integer.valueOf(i), ((Bundle)localObject2).getString("status"), paramBundle });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_IS_CM_FACE_ADDED, result=", paramBundle });
      }
      super.callJs(paramBundle);
      return;
    }
    if ("ipc_apollo_setcapsule".equals(localObject3))
    {
      if (((Bundle)localObject2).getInt("result") == 0)
      {
        callbackOk(str);
        return;
      }
      callbackError(str, "result != 0");
      return;
    }
    if ("ipc_cm_game_conn_connected".equals(localObject3)) {
      if (!((Bundle)localObject2).getBoolean("isConnected")) {
        break label5580;
      }
    }
    label5552:
    label5566:
    label5580:
    for (int i = 1;; i = 0)
    {
      paramBundle = String.format("%s({\"result\":%d,\"data\":{\"isConnected\":%d}});", new Object[] { str, Integer.valueOf(0), Integer.valueOf(i) });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_CM_GAME_CONN_CONNECTED, result=", paramBundle });
      }
      super.callJs(paramBundle);
      return;
      if ("ipc_open_cm_game_match_page".equals(localObject3))
      {
        if (((Bundle)localObject2).getInt("result") == 0)
        {
          callbackOk(str);
          return;
        }
        callbackError(str, "open failed");
        return;
      }
      if ("ipc_open_cm_game_send_game_app_ark_msg".equals(localObject3))
      {
        if (((Bundle)localObject2).getInt("result") == 0)
        {
          callbackOk(str);
          return;
        }
        callbackError(str, "send failed");
        return;
      }
      if ("ipc_apollo_save_3d_face".equals(localObject3))
      {
        paramBundle = ((Bundle)localObject2).getString("faceUrl");
        if (((Bundle)localObject2).getInt("result") == 0)
        {
          if (paramBundle == null) {
            break label97;
          }
          localObject1 = new JSONObject();
          bool1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShow3DFaceUrlReplace", true);
          localObject2 = QzoneConfig.getInstance().getConfig("CMShow", "CMShow3DFaceCosHost", "3dcmshow-75972.gzc.vod.tencent-cloud.com");
          localObject3 = QzoneConfig.getInstance().getConfig("CMShow", "CMShow3DFaceCdnHost", "3dcmshow.gtimg.cn");
          if ((bool1) && (paramBundle.contains((CharSequence)localObject2))) {
            ((JSONObject)localObject1).put(ApolloConstant.e, paramBundle.replace((CharSequence)localObject2, (CharSequence)localObject3));
          }
          for (;;)
          {
            callbackOk(str, (JSONObject)localObject1);
            return;
            ((JSONObject)localObject1).put(ApolloConstant.e, paramBundle);
          }
        }
        callbackError(str, "get faceUrl failed");
        return;
      }
      super.onResponse(paramBundle);
      return;
      if (j == 1) {
        break label2087;
      }
      if (j != 0) {
        break;
      }
      break label2087;
      paramBundle = "{\"result\":1, \"msg\": \"终端初始化错误\" }";
      break label2150;
      paramBundle = "{\"result\":1, \"msg\": \"非商城页面\" }";
      break label2150;
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, "Avatar view is Ready.");
    }
  }
  
  public void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.sendRemoteReq(paramBundle, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl
 * JD-Core Version:    0.7.0.1
 */