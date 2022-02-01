package com.tencent.mobileqq.apollo.web.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.game.CmGameStartChecker;
import com.tencent.mobileqq.apollo.game.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloViewController.PlayActionData;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.apollo.utils.CmShowCECapabilitiesChecker;
import com.tencent.mobileqq.apollo.utils.ResponseUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.web.CmshowWebReqParam;
import com.tencent.mobileqq.apollo.web.api.IApolloJsPlugin;
import com.tencent.mobileqq.apollo.web.jsmodule.LightGameJsModule;
import com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule;
import com.tencent.mobileqq.apollo.web.jsmodule.PendantAvatarJsModule;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.Dispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
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
  public static final String TAG = "[cmshow]ApolloJsPlugin";
  private static final int TYPE_FROM_SHOW_APOLLOVIEW = 10000;
  private static ApolloJsPluginImpl.ApolloReceiver sApolloReceiver = new ApolloJsPluginImpl.ApolloReceiver(null);
  public static int sResponseKey;
  private static int sRoleGender;
  private QQCustomDialog gameDialog;
  public int mAISwitch;
  private int mApolloStatus;
  private ApolloViewController mApolloViewContoller;
  private PendantAvatarJsModule mAvatarModule;
  private CmGameStartChecker mCmGameStartChecker;
  private CmGameStartChecker.DefaultGameCheckListener mCmGameStartCheckerListener;
  private String mCurrentUin;
  private boolean mDataInited;
  private Dispatcher<CmshowWebReqParam> mDispatcher = new Dispatcher();
  private int[] mDressIds;
  private int mGender;
  public boolean mHasInited;
  protected ApolloUrlInterceptor mInterceptor;
  private String mInterceptorUrl;
  public boolean mIsAIRole = false;
  private Makeup3DJsModule mMakeup3DModule;
  private boolean mNeedCreateInterceptor;
  public Bundle mReqBundle;
  private int mRoleId = -1;
  private ApolloPluginRscLoader mRscLoader;
  private String mTab;
  private Vector<String> mValidAvatarIdList = new Vector();
  
  static
  {
    double d1 = DeviceInfoUtil.l();
    Double.isNaN(d1);
    double d2 = DeviceInfoUtil.a();
    Double.isNaN(d2);
    DEFAULT_HEIGHT = (int)(d1 * 0.4D / d2);
    sRoleGender = 0;
  }
  
  public ApolloJsPluginImpl()
  {
    this.mPluginNameSpace = "apollo";
    this.mDispatcher.a(new LightGameJsModule(this));
    this.mMakeup3DModule = new Makeup3DJsModule(this);
    this.mDispatcher.a(this.mMakeup3DModule);
    this.mAvatarModule = new PendantAvatarJsModule(this);
    this.mDispatcher.a(this.mAvatarModule);
  }
  
  private void callBackDownloadGamePercent(int paramInt)
  {
    ThreadManager.getUIHandler().post(new ApolloJsPluginImpl.6(this, paramInt));
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
    if ((localActivity != null) && (!localActivity.isFinishing()) && (!this.isDestroy)) {
      return localActivity;
    }
    return null;
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
        if (!this.mAvatarModule.a.containsKey(paramString)) {
          return null;
        }
        paramString = (ApolloJsPluginImpl.AvatarInfo)this.mAvatarModule.a.get(paramString);
        if (paramString != null)
        {
          if (TextUtils.isEmpty(paramString.jdField_a_of_type_JavaLangString)) {
            return null;
          }
          localFile = new File(paramString.jdField_a_of_type_JavaLangString);
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
        if (paramString.jdField_a_of_type_Int != 1) {
          break label160;
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
      label160:
      paramString = "image/png";
    }
  }
  
  private void handleIPCAddCmFace(String paramString, Bundle paramBundle)
  {
    paramString = String.format("%s({\"result\":%d,\"msg\":\"%s\"});", new Object[] { paramString, Integer.valueOf(paramBundle.getInt("result")), paramBundle.getString("msg") });
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_ADD_CM_FACE, result=", paramString });
    }
    super.callJs(paramString);
  }
  
  private void handleIPCAddFavAction(String paramString, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("addFavAction");
    paramBundle = new JSONObject();
    paramBundle.put("data", new JSONObject((String)localObject));
    paramBundle.put("result", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&&");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(paramBundle.toString());
    ((StringBuilder)localObject).append(");");
    super.callJs(((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("IPC_APOLLO_ADD_FAV_ACTION onResponse data is:");
      paramString.append(paramBundle.toString());
      QLog.d("[cmshow]ApolloJsPlugin", 2, paramString.toString());
    }
  }
  
  private void handleIPCApolloChangeRole(String paramString, Bundle paramBundle)
  {
    int i = paramBundle.getInt("apollo_result");
    int j = paramBundle.getInt("apollo_roleId");
    int[] arrayOfInt = paramBundle.getIntArray("apollo_dressIds");
    if (arrayOfInt != null)
    {
      paramBundle = arrayOfInt;
      if (arrayOfInt.length > 0) {}
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
      callbackOk(paramString);
      return;
    }
    callbackError(paramString, HardCodeUtil.a(2131700631));
  }
  
  private void handleIPCApolloDelFavList(String paramString, Bundle paramBundle)
  {
    Object localObject = new JSONObject(paramBundle.getString("delFavListAction"));
    paramBundle = new JSONObject();
    if (((JSONObject)localObject).optBoolean("delHasError")) {
      paramBundle.put("result", 1);
    } else {
      paramBundle.put("result", 0);
    }
    paramBundle.put("data", ((JSONObject)localObject).opt("errorList"));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&&");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(paramBundle.toString());
    ((StringBuilder)localObject).append(");");
    super.callJs(((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("IPC_APOLLO_DEL_FAV_List onResponse data is:");
      paramString.append(paramBundle.toString());
      QLog.d("[cmshow]ApolloJsPlugin", 2, paramString.toString());
    }
  }
  
  private void handleIPCApolloDownloadPic(String paramString, Activity paramActivity)
  {
    if ((paramActivity instanceof IApolloActivityJsCallBack)) {
      ((IApolloActivityJsCallBack)paramActivity).b(paramString);
    }
  }
  
  private void handleIPCApolloGetApolloData(String paramString, Bundle paramBundle)
  {
    this.mDataInited = true;
    int j = paramBundle.getInt("apollo_initFrom");
    this.mRoleId = paramBundle.getInt("apollo_roleId");
    this.mGender = paramBundle.getInt("apollo_gender");
    this.mApolloStatus = paramBundle.getInt("apollo_apolloStatus");
    this.mDressIds = paramBundle.getIntArray("apollo_dressIds");
    sRoleGender = paramBundle.getInt("apollo_roleGender");
    if (this.mRoleId <= 0)
    {
      i = this.mGender;
      if ((i != 1) && (i != 0)) {
        this.mRoleId = 2;
      } else {
        this.mRoleId = 1;
      }
    }
    int i = 0;
    Object localObject1;
    if (3 == j)
    {
      paramBundle = this.mDressIds;
      if ((paramBundle != null) && (paramBundle.length > 0))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("result", 0);
        ((JSONObject)localObject1).put("msg", "");
        Object localObject2 = new JSONObject();
        paramBundle = new JSONArray();
        int[] arrayOfInt = this.mDressIds;
        j = arrayOfInt.length;
        while (i < j)
        {
          paramBundle.put(Integer.valueOf(arrayOfInt[i]));
          i += 1;
        }
        ((JSONObject)localObject2).put("dressIds", paramBundle);
        ((JSONObject)localObject1).put("data", localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("&&");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        ((StringBuilder)localObject2).append(");");
        super.callJs(((StringBuilder)localObject2).toString());
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("dressIds.array->");
          paramString.append(paramBundle);
          QLog.d("[cmshow]ApolloJsPlugin", 2, paramString.toString());
        }
      }
      else
      {
        callbackError(paramString, HardCodeUtil.a(2131700673));
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
        }
      }
    }
    else
    {
      if (2 == j)
      {
        if (this.mRoleId <= 0)
        {
          callbackError(paramString, HardCodeUtil.a(2131700652));
          return;
        }
        paramBundle = new JSONObject();
        paramBundle.put("result", 0);
        paramBundle.put("msg", "");
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("roleId", this.mRoleId);
        paramBundle.put("data", localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("&&");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(paramBundle.toString());
        ((StringBuilder)localObject1).append(");");
        super.callJs(((StringBuilder)localObject1).toString());
        return;
      }
      if (4 == j)
      {
        paramBundle = new JSONObject();
        paramBundle.put("result", 0);
        paramBundle.put("msg", "");
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("status", this.mApolloStatus);
        paramBundle.put("data", localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("&&");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(paramBundle.toString());
        ((StringBuilder)localObject1).append(");");
        super.callJs(((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void handleIPCApolloGetFavAction(String paramString, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("getFavResult");
    paramBundle = new JSONObject();
    paramBundle.put("data", new JSONObject((String)localObject));
    paramBundle.put("result", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&&");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(paramBundle.toString());
    ((StringBuilder)localObject).append(");");
    super.callJs(((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("IPC_APOLLO_GETFAV_ACTION onResponse data is:");
      paramString.append(paramBundle.toString());
      QLog.d("[cmshow]ApolloJsPlugin", 2, paramString.toString());
    }
  }
  
  private void handleIPCApolloGetOpenApolloFriends(String paramString, Bundle paramBundle)
  {
    int i = paramBundle.getInt("apollo_result");
    paramBundle = paramBundle.getString("apollo_data");
    if (i == 0)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("data", new JSONObject(paramBundle));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append(");");
      super.callJs(localStringBuilder.toString());
    }
    else
    {
      callbackError(paramString, HardCodeUtil.a(2131700660));
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("IPC_APOLLO_GET_OPENAPOLLO_FRIENDS onResponse dataStr is:");
      paramString.append(paramBundle);
      QLog.d("[cmshow]ApolloJsPlugin", 2, paramString.toString());
    }
  }
  
  private void handleIPCApolloQueryMineRedInfo(Bundle paramBundle, Activity paramActivity)
  {
    int i = paramBundle.getInt("isNewFlag");
    if ((i == 1) && ((paramActivity instanceof IApolloActivityJsCallBack))) {
      ((IApolloActivityJsCallBack)paramActivity).b();
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("IPC_APOLLO_QUERY_MINE_REDINFO onResponse dataInt is:");
      paramBundle.append(i);
      QLog.d("[cmshow]ApolloJsPlugin", 2, paramBundle.toString());
    }
  }
  
  private void handleIPCApolloStartRecordMsg(String paramString, Bundle paramBundle)
  {
    int i = paramBundle.getInt("result", -1000);
    if (i == 0)
    {
      callbackOk(paramString);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append(i);
    paramBundle.append("");
    callbackError(paramString, paramBundle.toString());
  }
  
  private void handleIPCApolloStopRecord(String paramString, Bundle paramBundle)
  {
    int i = paramBundle.getInt("result", -1000);
    if (i == 0)
    {
      callbackOk(paramString);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append(i);
    paramBundle.append("");
    callbackError(paramString, paramBundle.toString());
  }
  
  private void handleIPCApolloWriteLocal(String paramString, Bundle paramBundle)
  {
    paramBundle = new JSONObject(paramBundle.getString("writeRet"));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&&");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(paramBundle.toString());
    localStringBuilder.append(");");
    super.callJs(localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("IPC_APOLLO_WRITE_LOCAL onResponse data is:");
      paramString.append(paramBundle.toString());
      QLog.d("[cmshow]ApolloJsPlugin", 2, paramString.toString());
    }
  }
  
  private void handleIPCCMGameConnConnected(String paramString, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void handleIPCCheckAvatarRes(String paramString, Bundle paramBundle, Activity paramActivity)
  {
    int i = paramBundle.getInt("result");
    int j = paramBundle.getInt("from");
    Object localObject1 = paramBundle.getString("msg");
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_CHECK_AVATAR_RES, ret=", Integer.valueOf(i), ", msg=", localObject1, ", from=", Integer.valueOf(j) });
    }
    Object localObject2 = (ArrayList)paramBundle.getSerializable("apolloList");
    if (i != 0)
    {
      if (j != 2) {
        QQToast.a(paramActivity, HardCodeUtil.a(2131700635), 1).a();
      }
      callbackError(paramString, HardCodeUtil.a(2131700645));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("下载素材角色装扮素材失败->mRoleId");
        paramString.append(this.mRoleId);
        paramString.append(" mDressIds->");
        paramString.append(this.mDressIds);
        QLog.d("[cmshow]ApolloJsPlugin", 2, paramString.toString());
      }
      return;
    }
    if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
    {
      paramBundle = paramBundle.getString("reqUrl");
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject1 = getAbsoluteUrl();
        if (!paramBundle.equals(localObject1))
        {
          callbackError(paramString, "WebView已经切换url");
          QLog.e("[cmshow]ApolloJsPlugin", 1, new Object[] { "reqUrl:", paramBundle, " absoluteUrl:", localObject1 });
          return;
        }
      }
      localObject1 = null;
      paramBundle = null;
      Object localObject3;
      if ((j != 1) && (j != 0))
      {
        if (j == 2)
        {
          localObject1 = new AtomicInteger(0);
          localObject3 = getActivity();
          if ((localObject3 instanceof QBaseActivity)) {
            paramBundle = ((QBaseActivity)localObject3).getAppRuntime();
          }
          localObject3 = ((ArrayList)localObject2).iterator();
        }
      }
      else {
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (ApolloWebAvatarParam)((Iterator)localObject3).next();
          if (((ApolloWebAvatarParam)localObject4).isResExist)
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject4);
            if (this.mValidAvatarIdList.contains(((ApolloWebAvatarParam)localObject4).apolloId)) {
              if ((paramActivity instanceof IApolloActivityJsCallBack))
              {
                ((IApolloActivityJsCallBack)paramActivity).a(localArrayList);
              }
              else
              {
                localObject4 = this.mApolloViewContoller;
                if (localObject4 != null) {
                  ((ApolloViewController)localObject4).a(localArrayList);
                }
              }
            }
            ((AtomicInteger)localObject1).getAndIncrement();
            if (((AtomicInteger)localObject1).get() == ((ArrayList)localObject2).size()) {
              callbackOk(paramString);
            }
          }
          else
          {
            if (paramBundle == null)
            {
              QLog.e("[cmshow]ApolloJsPlugin", 1, new Object[] { "addAvatar, app null, uin=", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(((ApolloWebAvatarParam)localObject4).uin) });
              ((AtomicInteger)localObject1).getAndIncrement();
              if (((AtomicInteger)localObject1).get() == ((ArrayList)localObject2).size()) {
                callbackOk(paramString);
              }
              return;
            }
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(paramBundle, ((ApolloWebAvatarParam)localObject4).uin, new ApolloJsPluginImpl.5(this, paramString, (ApolloWebAvatarParam)localObject4, (AtomicInteger)localObject1, (ArrayList)localObject2), ((ApolloWebAvatarParam)localObject4).roleId, ((ApolloWebAvatarParam)localObject4).dressIds, -1, -1, false);
            continue;
            localObject2 = (ApolloWebAvatarParam)((ArrayList)localObject2).get(0);
            if (((ApolloWebAvatarParam)localObject2).isResExist)
            {
              if (this.mValidAvatarIdList.contains(((ApolloWebAvatarParam)localObject2).apolloId))
              {
                if (j == 1)
                {
                  paramBundle = this.mApolloViewContoller;
                  if (paramBundle != null) {
                    paramBundle = paramBundle.a(1, true, (ApolloWebAvatarParam)localObject2);
                  } else {
                    paramBundle = "{\"result\":1, \"msg\": \"终端初始化错误\" }";
                  }
                }
                else if (j == 0)
                {
                  if ((paramActivity instanceof IApolloActivityJsCallBack)) {
                    paramBundle = ((IApolloActivityJsCallBack)paramActivity).a(this.mApolloStatus, (ApolloWebAvatarParam)localObject2);
                  } else {
                    paramBundle = "{\"result\":1, \"msg\": \"非商城页面\" }";
                  }
                }
                else
                {
                  paramBundle = "";
                }
                paramActivity = new StringBuilder();
                paramActivity.append(paramString);
                paramActivity.append("&&");
                paramActivity.append(paramString);
                paramActivity.append("(");
                paramActivity.append(paramBundle);
                paramActivity.append(");");
                super.callJs(paramActivity.toString());
                return;
              }
              QLog.e("[cmshow]ApolloJsPlugin", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] initAvatar abort, apolloId is detroyed, id=", ((ApolloWebAvatarParam)localObject2).apolloId });
              return;
            }
            paramActivity = getActivity();
            paramBundle = (Bundle)localObject1;
            if ((paramActivity instanceof QBaseActivity)) {
              paramBundle = ((QBaseActivity)paramActivity).getAppRuntime();
            }
            if (paramBundle == null)
            {
              callbackError(paramString, "获取AppInterface失败");
              return;
            }
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(paramBundle, ((ApolloWebAvatarParam)localObject2).uin, new ApolloJsPluginImpl.4(this, paramString, (ApolloWebAvatarParam)localObject2, j), ((ApolloWebAvatarParam)localObject2).roleId, ((ApolloWebAvatarParam)localObject2).dressIds, -1, -1, false);
          }
        }
      }
      return;
    }
    callbackError(paramString, HardCodeUtil.a(2131700647));
  }
  
  private void handleIPCDelFavAction(String paramString, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("delFavAction");
    int i = new JSONObject((String)localObject).optInt("ret");
    paramBundle = new JSONObject();
    if (i == 0)
    {
      paramBundle.put("data", new JSONObject((String)localObject));
      paramBundle.put("result", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&&");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramBundle.toString());
      ((StringBuilder)localObject).append(");");
      super.callJs(((StringBuilder)localObject).toString());
    }
    else if (i == 1)
    {
      callbackError(paramString, HardCodeUtil.a(2131700650));
    }
    else if (i == 2)
    {
      callbackError(paramString, HardCodeUtil.a(2131700659));
    }
    else
    {
      callbackError(paramString, HardCodeUtil.a(2131700646));
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("IPC_APOLLO_DEL_FAV_ACTION onResponse data is:");
      paramString.append(paramBundle.toString());
      QLog.d("[cmshow]ApolloJsPlugin", 2, paramString.toString());
    }
  }
  
  private void handleIPCDownloadGame(String paramString, Bundle paramBundle)
  {
    paramBundle = (StartCheckParam)paramBundle.getSerializable("StartCheckParam");
    if (paramBundle == null)
    {
      callbackError(paramString, HardCodeUtil.a(2131700675));
      return;
    }
    AppInterface localAppInterface = CmGameUtil.a();
    this.mCmGameStartChecker = new CmGameStartChecker(localAppInterface);
    this.mCmGameStartCheckerListener = new ApolloJsPluginImpl.3(this, localAppInterface, false, paramString);
    this.mCmGameStartChecker.a(paramBundle, this.mCmGameStartCheckerListener);
  }
  
  private void handleIPCIsCMFaceAdded(String paramString, Bundle paramBundle)
  {
    int i = paramBundle.getInt("result");
    String str = paramBundle.getString("msg");
    paramString = String.format("%s({\"result\":%d,\"data\":{\"status\":%s}, \"msg\":\"%s\"});", new Object[] { paramString, Integer.valueOf(i), paramBundle.getString("status"), str });
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_IS_CM_FACE_ADDED, result=", paramString });
    }
    super.callJs(paramString);
  }
  
  private void handleIPCPlayLastRecordMsg(String paramString, Bundle paramBundle)
  {
    int i = paramBundle.getInt("result", -1000);
    if (i == 0)
    {
      callbackOk(paramString);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append(i);
    paramBundle.append("");
    callbackError(paramString, paramBundle.toString());
  }
  
  private void handleIPCPreviewAction(String paramString1, String paramString2, Bundle paramBundle, Activity paramActivity)
  {
    int i = paramBundle.getInt("apollo_previewAction");
    if ((paramBundle.getInt("apollo_result") == 0) && (i > 0))
    {
      String str = paramBundle.getString("apollo_json");
      JSONObject localJSONObject = new JSONObject(str);
      ApolloViewController.PlayActionData localPlayActionData = new ApolloViewController.PlayActionData();
      localPlayActionData.jdField_a_of_type_Int = localJSONObject.optInt("playCount");
      localPlayActionData.jdField_b_of_type_Int = i;
      localPlayActionData.jdField_c_of_type_Int = localJSONObject.optInt("type");
      localPlayActionData.jdField_d_of_type_Int = localJSONObject.optInt("isSpecial");
      localPlayActionData.e = localJSONObject.optInt("vipLevel");
      localPlayActionData.f = paramBundle.getInt("apollo_apolloVipFlag");
      localPlayActionData.g = paramBundle.getInt("apollo_apolloVipLevel");
      localPlayActionData.h = localJSONObject.optInt("feeType");
      localPlayActionData.i = paramBundle.getInt("apollo_partnerRoleId");
      localPlayActionData.j = localJSONObject.optInt("isDiyAction");
      localPlayActionData.k = localJSONObject.optInt("textType");
      localPlayActionData.jdField_a_of_type_JavaLangString = localJSONObject.optString("text");
      localPlayActionData.l = localJSONObject.optInt("playOriginalAudio");
      localPlayActionData.m = localJSONObject.optInt("audioId");
      localPlayActionData.jdField_a_of_type_Float = ((float)localJSONObject.optDouble("audioStartTime"));
      localPlayActionData.jdField_b_of_type_Float = ((float)localJSONObject.optDouble("frameTime"));
      localPlayActionData.jdField_a_of_type_Boolean = paramBundle.getBoolean("apollo_previewOnFrame");
      localPlayActionData.jdField_c_of_type_JavaLangString = paramBundle.getString("title");
      localPlayActionData.jdField_d_of_type_JavaLangString = paramBundle.getString("subTitle");
      localPlayActionData.jdField_b_of_type_JavaLangString = paramBundle.getString("apollo_id");
      localPlayActionData.jdField_b_of_type_Boolean = paramBundle.getBoolean("apollo_is_super_yellow");
      if ("ipc_apollo_preview_audio_action".equals(paramString1))
      {
        paramString1 = ApolloViewController.a("ApolloViewController is null or Activity not instanceof IApolloActivityJsCallBack");
        paramBundle = this.mApolloViewContoller;
        if (paramBundle != null)
        {
          paramString1 = paramBundle.a(localPlayActionData);
          paramBundle = new StringBuilder();
          paramBundle.append(paramString2);
          paramBundle.append("&&");
          paramBundle.append(paramString2);
          paramBundle.append("(");
          paramBundle.append(paramString1);
          paramBundle.append(");");
          super.callJs(paramBundle.toString());
        }
        else if ((paramActivity instanceof IApolloActivityJsCallBack))
        {
          paramString1 = ((IApolloActivityJsCallBack)paramActivity).a(localPlayActionData);
          paramBundle = new StringBuilder();
          paramBundle.append(paramString2);
          paramBundle.append("&&");
          paramBundle.append(paramString2);
          paramBundle.append("(");
          paramBundle.append(paramString1);
          paramBundle.append(");");
          super.callJs(paramBundle.toString());
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("IPC_APOLLO_PREVIEW_AUDIO_ACTION callbackId->");
          paramBundle.append(paramString2);
          paramBundle.append(" callbackOk");
          paramBundle.append(paramString1);
          QLog.e("[cmshow]ApolloJsPlugin", 2, paramBundle.toString());
        }
      }
      else if ("ipc_apollo_preview_action".equals(paramString1))
      {
        paramString1 = new File(((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).getAudioFilePath(localPlayActionData.m));
        if ((localPlayActionData.m > 0) && (!paramString1.exists()))
        {
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("IPC_APOLLO_PREVIEW_ACTION audio file no exsit callbackId->");
            paramString1.append(paramString2);
            QLog.e("[cmshow]ApolloJsPlugin", 2, paramString1.toString());
          }
          this.mReqBundle.clear();
          this.mReqBundle.putInt("apollo_previewAction", localPlayActionData.jdField_b_of_type_Int);
          this.mReqBundle.putInt("apollo_apolloVipFlag", localPlayActionData.f);
          this.mReqBundle.putInt("apollo_apolloVipLevel", localPlayActionData.g);
          this.mReqBundle.putBoolean("apollo_previewOnFrame", localPlayActionData.jdField_a_of_type_Boolean);
          this.mReqBundle.putInt("apollo_partnerRoleId", localPlayActionData.i);
          this.mReqBundle.putInt("apollo_audioId", localPlayActionData.m);
          this.mReqBundle.putString("apollo_json", str);
          this.mReqBundle.putString("title", localPlayActionData.jdField_c_of_type_JavaLangString);
          this.mReqBundle.putString("subTitle", localPlayActionData.jdField_d_of_type_JavaLangString);
          super.sendRemoteReq(DataFactory.a("ipc_apollo_preview_audio_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
          return;
        }
        paramString1 = ApolloViewController.a("ApolloViewController is null or Activity not instanceof IApolloActivityJsCallBack");
        if ((paramActivity instanceof IApolloActivityJsCallBack))
        {
          paramString1 = ((IApolloActivityJsCallBack)paramActivity).a(localPlayActionData);
          paramBundle = new StringBuilder();
          paramBundle.append(paramString2);
          paramBundle.append("&&");
          paramBundle.append(paramString2);
          paramBundle.append("(");
          paramBundle.append(paramString1);
          paramBundle.append(");");
          super.callJs(paramBundle.toString());
        }
        else
        {
          paramBundle = this.mApolloViewContoller;
          if (paramBundle != null)
          {
            paramString1 = paramBundle.a(localPlayActionData);
            paramBundle = new StringBuilder();
            paramBundle.append(paramString2);
            paramBundle.append("&&");
            paramBundle.append(paramString2);
            paramBundle.append("(");
            paramBundle.append(paramString1);
            paramBundle.append(");");
            super.callJs(paramBundle.toString());
          }
          else
          {
            callbackError(paramString2, HardCodeUtil.a(2131700671));
          }
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("IPC_APOLLO_PREVIEW_ACTION callbackId->");
          paramBundle.append(paramString2);
          paramBundle.append(" callbackOk");
          paramBundle.append(paramString1);
          QLog.e("[cmshow]ApolloJsPlugin", 2, paramBundle.toString());
        }
      }
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append(HardCodeUtil.a(2131700668));
    paramBundle.append(paramString1);
    callbackError(paramString2, paramBundle.toString());
  }
  
  private void handleIPCSetCapsule(String paramString, Bundle paramBundle)
  {
    if (paramBundle.getInt("result") == 0)
    {
      callbackOk(paramString);
      return;
    }
    callbackError(paramString, "result != 0");
  }
  
  private void handleIPCStartApolloGame(String paramString, Bundle paramBundle)
  {
    if (paramBundle.getInt("result") == 0)
    {
      callbackOk(paramString);
      return;
    }
    callbackError(paramString, HardCodeUtil.a(2131700664));
  }
  
  private void handleIPCStopLastRecordMsg(String paramString, Bundle paramBundle)
  {
    int i = paramBundle.getInt("result", -1000);
    if (i == 0)
    {
      callbackOk(paramString);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append(i);
    paramBundle.append("");
    callbackError(paramString, paramBundle.toString());
  }
  
  private void handleIPCUploadRecordMsg(String paramString, Bundle paramBundle)
  {
    int i = paramBundle.getInt("result", -1000);
    if (i == 0)
    {
      callbackOk(paramString);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append(i);
    paramBundle.append("");
    callbackError(paramString, paramBundle.toString());
  }
  
  private void handleJsApiAddAvatar(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "addAvatar");
    }
    boolean bool3 = paramActivity instanceof IApolloActivityJsCallBack;
    if (!bool3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloJsPlugin", 2, "addAvatar, not IApolloActivityJsCallBack, check mApolloViewContoller");
      }
      if ((this.mApolloViewContoller == null) && ((this.mRuntime.a().getParent() instanceof RelativeLayout)))
      {
        this.mApolloViewContoller = new ApolloViewController((RelativeLayout)this.mRuntime.a().getParent(), null);
        this.mApolloViewContoller.a(this);
      }
      if (this.mApolloViewContoller == null)
      {
        QLog.e("[cmshow]ApolloJsPlugin", 1, "addAvatar, mApolloViewContoller null");
        callbackError(paramString, "ApolloViewController is null");
        return;
      }
    }
    Object localObject = "apolloList";
    JSONArray localJSONArray = paramJSONObject.getJSONArray("apolloList");
    if ((localJSONArray != null) && (localJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList(localJSONArray.length());
      int m = localJSONArray.length();
      int j = 0;
      int i = 0;
      paramJSONObject = (JSONObject)localObject;
      while (j < m)
      {
        localObject = localJSONArray.getJSONObject(j);
        ApolloWebAvatarParam localApolloWebAvatarParam = new ApolloWebAvatarParam();
        localApolloWebAvatarParam.isMain = false;
        localApolloWebAvatarParam.apolloId = ((JSONObject)localObject).optString("apolloId");
        localApolloWebAvatarParam.x = ((JSONObject)localObject).optInt("x", DEFAULT_WIDTH);
        localApolloWebAvatarParam.y = ((JSONObject)localObject).optInt("y", DEFAULT_HEIGHT);
        localApolloWebAvatarParam.nickName = ((JSONObject)localObject).optString("nickName");
        localApolloWebAvatarParam.uin = ((JSONObject)localObject).optString("uin");
        if ((!TextUtils.isEmpty(localApolloWebAvatarParam.apolloId)) && (!TextUtils.isEmpty(localApolloWebAvatarParam.uin)))
        {
          localApolloWebAvatarParam.rate = ((float)((JSONObject)localObject).optDouble("rate", 0.0D));
          localApolloWebAvatarParam.roleId = ((JSONObject)localObject).optInt("roleId");
          localObject = ((JSONObject)localObject).optJSONArray("dressIds");
          boolean bool1;
          if (localApolloWebAvatarParam.roleId > 0) {
            bool1 = CMResUtil.b(localApolloWebAvatarParam.roleId);
          } else {
            bool1 = false;
          }
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            int n = ((JSONArray)localObject).length();
            localApolloWebAvatarParam.dressIds = new int[n];
            int k = 0;
            for (;;)
            {
              bool2 = bool1;
              if (k >= n) {
                break;
              }
              int i1 = ((JSONArray)localObject).getInt(k);
              localApolloWebAvatarParam.dressIds[k] = i1;
              bool2 = bool1;
              if (localApolloWebAvatarParam.roleId > 0)
              {
                bool2 = bool1;
                if (bool1) {
                  bool2 = CMResUtil.a(i1);
                }
              }
              k += 1;
              bool1 = bool2;
            }
          }
          boolean bool2 = bool1;
          localApolloWebAvatarParam.isResExist = bool2;
          if (!bool2) {
            i = 1;
          }
          localArrayList.add(localApolloWebAvatarParam);
          if (!this.mValidAvatarIdList.contains(localApolloWebAvatarParam.apolloId)) {
            this.mValidAvatarIdList.add(localApolloWebAvatarParam.apolloId);
          }
          j += 1;
        }
        else
        {
          QLog.e("[cmshow]ApolloJsPlugin", 1, "addAvatar, apolloId or uin is null");
          j = 1;
          break label556;
        }
      }
      j = 0;
      label556:
      if (j != 0)
      {
        QLog.e("[cmshow]ApolloJsPlugin", 1, "addAvatar, param invalid");
        callbackError(paramString, HardCodeUtil.a(2131700658));
        return;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloJsPlugin", 2, "addAvatar, should request resource");
        }
        this.mReqBundle.clear();
        this.mReqBundle.putInt("from", 2);
        this.mReqBundle.putSerializable(paramJSONObject, localArrayList);
        super.sendRemoteReq(DataFactory.a("ipc_apollo_check_avatar_res", paramString, this.mOnRemoteResp.key, this.mReqBundle), true, true);
        return;
      }
      if (bool3)
      {
        paramJSONObject = ((IApolloActivityJsCallBack)paramActivity).a(localArrayList);
        paramActivity = new StringBuilder();
        paramActivity.append(paramString);
        paramActivity.append("&&");
        paramActivity.append(paramString);
        paramActivity.append("(");
        paramActivity.append(paramJSONObject);
        paramActivity.append(");");
        super.callJs(paramActivity.toString());
        return;
      }
      paramJSONObject = this.mApolloViewContoller;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.a(localArrayList);
        paramActivity = new StringBuilder();
        paramActivity.append(paramString);
        paramActivity.append("&&");
        paramActivity.append(paramString);
        paramActivity.append("(");
        paramActivity.append(paramJSONObject);
        paramActivity.append(");");
        super.callJs(paramActivity.toString());
        return;
      }
      QLog.e("[cmshow]ApolloJsPlugin", 1, "addAvatar, controller null");
      callbackError(paramString, HardCodeUtil.a(2131700670));
      return;
    }
    QLog.e("[cmshow]ApolloJsPlugin", 1, "addAvatar, param list null");
    callbackError(paramString, HardCodeUtil.a(2131700678));
  }
  
  private void handleJsApiAddCmFace(String paramString, JSONObject paramJSONObject)
  {
    this.mReqBundle.clear();
    paramJSONObject = paramJSONObject.optJSONArray("faceIdList");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      this.mReqBundle.putString("faceIdList", paramJSONObject.toString());
      super.sendRemoteReq(DataFactory.a("ipc_apollo_add_cm_face", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    paramJSONObject = new JSONObject();
    paramJSONObject.put("result", 1);
    paramJSONObject.put("msg", HardCodeUtil.a(2131700657));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&&");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(paramJSONObject.toString());
    localStringBuilder.append(");");
    super.callJs(localStringBuilder.toString());
  }
  
  private void handleJsApiAddCustomAction(String paramString, JSONObject paramJSONObject)
  {
    this.mReqBundle.clear();
    int i = paramJSONObject.optInt("actionId");
    int j = paramJSONObject.optInt("textType");
    String str = paramJSONObject.optString("actionText");
    int k = paramJSONObject.optInt("audioId");
    int m = paramJSONObject.optInt("playOriginalAudio");
    float f = paramJSONObject.optInt("audioStartTime");
    this.mReqBundle.putInt("actionId", i);
    this.mReqBundle.putString("actionText", str);
    this.mReqBundle.putInt("textType", j);
    this.mReqBundle.putInt("audioId", k);
    this.mReqBundle.putInt("playOriginalAudio", m);
    this.mReqBundle.putFloat("audioStartTime", f);
    super.sendRemoteReq(DataFactory.a("ipc_apollo_add_fav_action", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "apolloJsPlugin call addCustomAction");
    }
  }
  
  private void handleJsApiAetApolloViewVisibility(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    int i = paramJSONObject.optInt("visibility", 0);
    if ((paramActivity instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)paramActivity).d(i);
      callbackOk(paramString);
      return;
    }
    paramJSONObject = this.mApolloViewContoller;
    if (paramJSONObject == null)
    {
      callbackError(paramString, "ApolloViewController is null");
      return;
    }
    paramJSONObject.b(i);
    callbackOk(paramString);
  }
  
  private void handleJsApiChangeRole(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    if (!checkSdcard(paramActivity))
    {
      callbackError(paramString, "sdcard未装");
      return;
    }
    int j = paramJSONObject.getInt("roleId");
    if (j > 0) {
      this.mRoleId = j;
    }
    paramActivity = paramJSONObject.optJSONArray("dressIds");
    if ((j > 0) && (paramActivity != null) && (paramActivity.length() > 0))
    {
      int k = paramActivity.length();
      this.mDressIds = new int[k];
      int i = 0;
      while (i < k)
      {
        this.mDressIds[i] = paramActivity.getInt(i);
        i += 1;
      }
      paramJSONObject = paramJSONObject.optString("userData");
      paramActivity = new JSONObject(paramJSONObject);
      sRoleGender = paramActivity.optInt("sex");
      boolean bool;
      if (paramActivity.optJSONObject("role").optInt("aiFlag", 0) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.mIsAIRole = bool;
      this.mRoleId = j;
      this.mReqBundle.clear();
      this.mReqBundle.putIntArray("apollo_dressIds", this.mDressIds);
      this.mReqBundle.putInt("apollo_roleId", this.mRoleId);
      this.mReqBundle.putInt("apollo_fromSelf", 0);
      this.mReqBundle.putString("apollo_userData", paramJSONObject);
      super.sendRemoteReq(DataFactory.a("ipc_apollo_changerole", paramString, this.mOnRemoteResp.key, this.mReqBundle), true, true);
      return;
    }
    callbackError(paramString, HardCodeUtil.a(2131700651));
  }
  
  private void handleJsApiClearThunderCache(String paramString)
  {
    Object localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/webview/");
    if (!((File)localObject).exists())
    {
      callbackOk(paramString);
      return;
    }
    localObject = ((File)localObject).listFiles();
    if ((localObject != null) && (localObject.length != 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        File localFile = localObject[i];
        if (localFile.isDirectory())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localFile.getName());
          localStringBuilder.append(".txt");
          if (new File(localFile, localStringBuilder.toString()).exists())
          {
            FileUtils.deleteDirectory(localFile.getAbsolutePath());
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("clearThunderCache, htmlFileDir:");
              localStringBuilder.append(localFile.getName());
              QLog.d("[cmshow]ApolloJsPlugin", 2, localStringBuilder.toString());
            }
          }
        }
        i += 1;
      }
      callbackOk(paramString);
      return;
    }
    callbackOk(paramString);
  }
  
  private void handleJsApiCloseWebView(String paramString, Activity paramActivity)
  {
    super.sendRemoteReq(DataFactory.a("ipc_kandian_hb_close_guid", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    paramActivity.finish();
    if (!(paramActivity instanceof IApolloActivityJsCallBack)) {
      paramActivity.overridePendingTransition(0, 0);
    }
    paramActivity = new JSONObject();
    paramActivity.put("result", 0);
    paramActivity.put("msg", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&&");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(paramActivity.toString());
    localStringBuilder.append(");");
    super.callJs(localStringBuilder.toString());
  }
  
  private void handleJsApiDelLocalFavAction(String paramString, JSONObject paramJSONObject)
  {
    this.mReqBundle.clear();
    this.mReqBundle.putString("delJson", paramJSONObject.opt("favActionDel").toString());
    super.sendRemoteReq(DataFactory.a("ipc_apollo_del_fav_list", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "apolloJsPlugin call delLocalFavList");
    }
  }
  
  private void handleJsApiDestroyAvatar(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("apolloList");
    if ((localJSONArray != null) && (localJSONArray.length() != 0))
    {
      paramJSONObject = new ArrayList();
      int i = 0;
      int j = localJSONArray.length();
      while (i < j)
      {
        String str = localJSONArray.getString(i);
        paramJSONObject.add(str);
        this.mValidAvatarIdList.remove(str);
        i += 1;
      }
      if ((paramActivity instanceof IApolloActivityJsCallBack))
      {
        ((IApolloActivityJsCallBack)paramActivity).a(paramJSONObject);
        callbackOk(paramString);
        return;
      }
      paramActivity = this.mApolloViewContoller;
      if (paramActivity != null)
      {
        paramActivity.a(paramJSONObject);
        callbackOk(paramString);
        return;
      }
      QLog.e("[cmshow]ApolloJsPlugin", 1, "destroyAvatar, controller null");
      callbackError(paramString, HardCodeUtil.a(2131700662));
      return;
    }
    callbackError(paramString, HardCodeUtil.a(2131700667));
  }
  
  private void handleJsApiDownloadImageOnFrame(String paramString)
  {
    int i = new Random().nextInt();
    this.mReqBundle.clear();
    this.mReqBundle.putInt("apollo_previewAction", i);
    super.sendRemoteReq(DataFactory.a("ipc_apollo_downloadImageOnFrame", paramString, this.mOnRemoteResp.key, this.mReqBundle), true, true);
  }
  
  private void handleJsApiDownloadTbs()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      ((BrowserAppInterface)localAppInterface).a(true);
    }
  }
  
  private void handleJsApiGetFriendsByOpenApollo(String paramString)
  {
    this.mReqBundle.clear();
    super.sendRemoteReq(DataFactory.a("ipc_apollo_get_openapollo_friends", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void handleJsApiGetLocalFavAction(String paramString)
  {
    this.mReqBundle.clear();
    super.sendRemoteReq(DataFactory.a("ipc_apollo_getfav_action", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "apolloJsPlugin call getLocalFavAction");
    }
  }
  
  private void handleJsApiGetLocalInfo(String paramString)
  {
    boolean bool = this.mDataInited;
    int i = 0;
    if (!bool)
    {
      this.mReqBundle.clear();
      this.mReqBundle.putInt("apollo_initFrom", 3);
      super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    Object localObject1 = this.mDressIds;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", "");
      Object localObject2 = new JSONObject();
      localObject1 = new JSONArray();
      int[] arrayOfInt = this.mDressIds;
      int j = arrayOfInt.length;
      while (i < j)
      {
        ((JSONArray)localObject1).put(Integer.valueOf(arrayOfInt[i]));
        i += 1;
      }
      ((JSONObject)localObject2).put("dressIds", localObject1);
      localJSONObject.put("data", localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("&&");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(localJSONObject.toString());
      ((StringBuilder)localObject2).append(");");
      super.callJs(((StringBuilder)localObject2).toString());
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("array->");
        paramString.append(localObject1);
        QLog.d("[cmshow]ApolloJsPlugin", 2, paramString.toString());
      }
      return;
    }
    callbackError(paramString, HardCodeUtil.a(2131700648));
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
    }
  }
  
  private void handleJsApiGetRoleID(String paramString)
  {
    boolean bool = this.mDataInited;
    int i = 2;
    if (!bool)
    {
      this.mReqBundle.clear();
      this.mReqBundle.putInt("apollo_initFrom", 2);
      super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("result", 0);
    localJSONObject.put("msg", "");
    Object localObject = new JSONObject();
    int j = this.mRoleId;
    if (j <= 0)
    {
      j = this.mGender;
      if ((j == 1) || (j == 0)) {
        i = 1;
      }
    }
    else
    {
      i = j;
    }
    ((JSONObject)localObject).put("roleId", i);
    localJSONObject.put("data", localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&&");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(localJSONObject.toString());
    ((StringBuilder)localObject).append(");");
    super.callJs(((StringBuilder)localObject).toString());
  }
  
  private void handleJsApiGetSwitch(String paramString)
  {
    if (!this.mDataInited)
    {
      this.mReqBundle.clear();
      this.mReqBundle.putInt("apollo_initFrom", 4);
      super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("result", 0);
    localJSONObject.put("msg", "");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("status", this.mApolloStatus);
    localJSONObject.put("data", localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&&");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(localJSONObject.toString());
    ((StringBuilder)localObject).append(");");
    super.callJs(((StringBuilder)localObject).toString());
  }
  
  private void handleJsApiGetUserInfo(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean handleJsApiInitApolloView(String paramString, JSONObject paramJSONObject)
  {
    if (!ApolloEngine.isEngineReady())
    {
      callbackError(paramString, "engine is not ready");
      return true;
    }
    Object localObject2 = this.mApolloViewContoller;
    Object localObject1 = null;
    if ((localObject2 == null) && ((this.mRuntime.a().getParent() instanceof RelativeLayout)))
    {
      this.mApolloViewContoller = new ApolloViewController((RelativeLayout)this.mRuntime.a().getParent(), null);
      this.mApolloViewContoller.a(this);
    }
    if (this.mApolloViewContoller == null)
    {
      callbackError(paramString, "ApolloViewController is null");
      return true;
    }
    int i = paramJSONObject.optInt("disableTouch", 0);
    int j = paramJSONObject.optInt("scrollByWebView", 0);
    if ((this.mRuntime.a() instanceof TouchWebView))
    {
      localObject2 = (TouchWebView)this.mRuntime.a();
      if (j > 0) {
        localObject1 = this.mApolloViewContoller;
      }
      ((TouchWebView)localObject2).setOnScrollChangedListener((TouchWebView.OnScrollChangedListener)localObject1);
    }
    localObject1 = this.mApolloViewContoller;
    boolean bool1;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((ApolloViewController)localObject1).b(bool1);
    localObject2 = new ApolloWebAvatarParam();
    ((ApolloWebAvatarParam)localObject2).isMain = true;
    ((ApolloWebAvatarParam)localObject2).apolloId = paramJSONObject.optString("apolloId", "me");
    ((ApolloWebAvatarParam)localObject2).x = paramJSONObject.optInt("x", DEFAULT_WIDTH);
    ((ApolloWebAvatarParam)localObject2).y = paramJSONObject.optInt("y", DEFAULT_HEIGHT);
    ((ApolloWebAvatarParam)localObject2).uin = paramJSONObject.optString("uin");
    if (TextUtils.isEmpty(((ApolloWebAvatarParam)localObject2).uin)) {
      ((ApolloWebAvatarParam)localObject2).uin = this.mRuntime.a().getCurrentAccountUin();
    }
    ((ApolloWebAvatarParam)localObject2).nickName = paramJSONObject.optString("nickName");
    ((ApolloWebAvatarParam)localObject2).type = 0;
    ((ApolloWebAvatarParam)localObject2).tab = "mall";
    ((ApolloWebAvatarParam)localObject2).rate = ((float)paramJSONObject.optDouble("rate", 0.0D));
    ((ApolloWebAvatarParam)localObject2).roleId = paramJSONObject.optInt("roleId");
    localObject1 = paramJSONObject.optJSONArray("tapRect");
    if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
    {
      ((ApolloWebAvatarParam)localObject2).tapRectX = ((JSONArray)localObject1).getInt(0);
      ((ApolloWebAvatarParam)localObject2).tapRectY = ((JSONArray)localObject1).getInt(1);
      ((ApolloWebAvatarParam)localObject2).tapRectWidth = ((JSONArray)localObject1).getInt(2);
      ((ApolloWebAvatarParam)localObject2).tapRectHeight = ((JSONArray)localObject1).getInt(3);
    }
    localObject1 = paramJSONObject.optJSONArray("dressIds");
    if (((ApolloWebAvatarParam)localObject2).roleId > 0) {
      bool1 = CMResUtil.b(((ApolloWebAvatarParam)localObject2).roleId);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (localObject1 != null)
    {
      bool2 = bool1;
      if (((JSONArray)localObject1).length() > 0)
      {
        j = ((JSONArray)localObject1).length();
        ((ApolloWebAvatarParam)localObject2).dressIds = new int[j];
        i = 0;
        while (i < j)
        {
          int k = ((JSONArray)localObject1).getInt(i);
          ((ApolloWebAvatarParam)localObject2).dressIds[i] = k;
          bool2 = bool1;
          if (((ApolloWebAvatarParam)localObject2).roleId > 0)
          {
            bool2 = bool1;
            if (bool1) {
              bool2 = CMResUtil.a(k);
            }
          }
          i += 1;
          bool1 = bool2;
        }
        bool2 = bool1;
      }
    }
    ((ApolloWebAvatarParam)localObject2).isResExist = bool2;
    this.mValidAvatarIdList.clear();
    this.mValidAvatarIdList.add(((ApolloWebAvatarParam)localObject2).apolloId);
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloJsPlugin", 2, "initApolloView, should request resource");
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject2);
      this.mReqBundle.clear();
      localObject1 = paramJSONObject.optString("reqUrl");
      paramJSONObject = (JSONObject)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramJSONObject = getAbsoluteUrl();
      }
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.mReqBundle.putString("reqUrl", paramJSONObject);
      }
      this.mReqBundle.putInt("from", 1);
      this.mReqBundle.putSerializable("apolloList", localArrayList);
      super.sendRemoteReq(DataFactory.a("ipc_apollo_check_avatar_res", paramString, this.mOnRemoteResp.key, this.mReqBundle), true, true);
      this.mApolloViewContoller.a(true, ((ApolloWebAvatarParam)localObject2).x, ((ApolloWebAvatarParam)localObject2).y);
      return false;
    }
    paramJSONObject = this.mApolloViewContoller.a(1, true, (ApolloWebAvatarParam)localObject2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("&&");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("(");
    ((StringBuilder)localObject1).append(paramJSONObject);
    ((StringBuilder)localObject1).append(");");
    super.callJs(((StringBuilder)localObject1).toString());
    return false;
  }
  
  private void handleJsApiInitAvatar(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "initAvatar");
    }
    if (!IApolloActivityJsCallBack.class.isInstance(paramActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloJsPlugin", 2, "initAvatar, not ApolloStoreActivity");
      }
      if ((paramActivity instanceof QBaseActivity))
      {
        localObject1 = (AppInterface)((QBaseActivity)paramActivity).getAppRuntime();
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramActivity, null, "share", this.mRuntime.a().getUrl(), (AppInterface)localObject1);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new ApolloJsPluginImpl.1(this), 2000L);
    }
    ApolloWebAvatarParam localApolloWebAvatarParam = new ApolloWebAvatarParam();
    localApolloWebAvatarParam.isMain = true;
    localApolloWebAvatarParam.apolloId = paramJSONObject.optString("apolloId", "me");
    localApolloWebAvatarParam.type = paramJSONObject.optInt("type");
    localApolloWebAvatarParam.x = paramJSONObject.optInt("x", DEFAULT_WIDTH);
    localApolloWebAvatarParam.y = paramJSONObject.optInt("y", DEFAULT_HEIGHT);
    this.mTab = paramJSONObject.optString("tab");
    localApolloWebAvatarParam.tab = this.mTab;
    localApolloWebAvatarParam.rate = ((float)paramJSONObject.optDouble("rate", 0.0D));
    localApolloWebAvatarParam.uin = paramJSONObject.optString("uin");
    localApolloWebAvatarParam.nickName = paramJSONObject.optString("nickName");
    localApolloWebAvatarParam.greeting = paramJSONObject.optString("greeting");
    Object localObject2 = this.mRuntime.a().getCurrentAccountUin();
    if (TextUtils.isEmpty(localApolloWebAvatarParam.uin)) {
      localApolloWebAvatarParam.uin = ((String)localObject2);
    }
    this.mCurrentUin = localApolloWebAvatarParam.uin;
    localApolloWebAvatarParam.roleId = paramJSONObject.optInt("roleId");
    Object localObject1 = paramJSONObject.optJSONArray("tapRect");
    if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
    {
      localApolloWebAvatarParam.tapRectX = ((JSONArray)localObject1).getInt(0);
      localApolloWebAvatarParam.tapRectY = ((JSONArray)localObject1).getInt(1);
      localApolloWebAvatarParam.tapRectWidth = ((JSONArray)localObject1).getInt(2);
      localApolloWebAvatarParam.tapRectHeight = ((JSONArray)localObject1).getInt(3);
    }
    boolean bool1;
    if (localApolloWebAvatarParam.roleId > 0) {
      bool1 = CMResUtil.b(localApolloWebAvatarParam.roleId);
    } else {
      bool1 = false;
    }
    localObject1 = null;
    Object localObject3 = paramJSONObject.optJSONArray("dressIds");
    long l = paramJSONObject.optLong("avatarTs");
    int i;
    if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
    {
      int j = ((JSONArray)localObject3).length();
      localObject1 = new int[j];
      i = 0;
      while (i < j)
      {
        localObject1[i] = ((JSONArray)localObject3).getInt(i);
        boolean bool2 = bool1;
        if (localApolloWebAvatarParam.roleId > 0)
        {
          bool2 = bool1;
          if (bool1) {
            bool2 = CMResUtil.a(localObject1[i]);
          }
        }
        i += 1;
        bool1 = bool2;
      }
      localApolloWebAvatarParam.dressIds = ((int[])localObject1);
      if (this.mCurrentUin.equals(localObject2))
      {
        this.mRoleId = localApolloWebAvatarParam.roleId;
        this.mDressIds = ((int[])localObject1);
      }
    }
    if (!bool1) {
      i = 1;
    } else {
      i = 0;
    }
    this.mValidAvatarIdList.clear();
    this.mValidAvatarIdList.add(localApolloWebAvatarParam.apolloId);
    if ((paramActivity instanceof IApolloActivityJsCallBack))
    {
      localObject3 = (IApolloActivityJsCallBack)paramActivity;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloJsPlugin", 2, "initAvatar, should request resource");
        }
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(localApolloWebAvatarParam);
        this.mReqBundle.clear();
        localObject2 = paramJSONObject.optString("reqUrl");
        paramActivity = (Activity)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramActivity = getAbsoluteUrl();
        }
        if (!TextUtils.isEmpty(paramActivity)) {
          this.mReqBundle.putString("reqUrl", paramActivity);
        }
        this.mReqBundle.putInt("from", 0);
        this.mReqBundle.putSerializable("apolloList", localArrayList);
        super.sendRemoteReq(DataFactory.a("ipc_apollo_check_avatar_res", paramString, this.mOnRemoteResp.key, this.mReqBundle), true, true);
        ((IApolloActivityJsCallBack)localObject3).a(true, localApolloWebAvatarParam.x, localApolloWebAvatarParam.y);
      }
      else
      {
        paramActivity = ((IApolloActivityJsCallBack)localObject3).a(this.mApolloStatus, localApolloWebAvatarParam);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("&&");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(paramActivity);
        ((StringBuilder)localObject2).append(");");
        super.callJs(((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      QLog.e("[cmshow]ApolloJsPlugin", 1, "initAvatar, not apollo store activity");
      callbackError(paramString, HardCodeUtil.a(2131700655));
    }
    if (i == 0)
    {
      this.mReqBundle.clear();
      this.mReqBundle.putInt("from", 0);
      this.mReqBundle.putString("uin", paramJSONObject.optString("uin"));
      this.mReqBundle.putLong("avatarTs", l);
      this.mReqBundle.putIntArray("dressId", (int[])localObject1);
      super.sendRemoteReq(DataFactory.a("ipc_apollo_update_avatar_info", paramString, this.mOnRemoteResp.key, this.mReqBundle), true, true);
    }
  }
  
  private void handleJsApiIsApolloEngineReady(String paramString)
  {
    if (ApolloEngine.isEngineReady()) {
      callbackOk(paramString);
    } else {
      callbackError(paramString, "ApolloEngine is not ready");
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "isApolloEngineReady:", Boolean.valueOf(ApolloEngine.isEngineReady()) });
    }
  }
  
  private void handleJsApiIsCmFaceAdded(String paramString, JSONObject paramJSONObject)
  {
    this.mReqBundle.clear();
    paramJSONObject = paramJSONObject.optJSONArray("faceIdList");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      this.mReqBundle.putString("faceIdList", paramJSONObject.toString());
      super.sendRemoteReq(DataFactory.a("ipc_apollo_is_cm_face_added", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    paramJSONObject = new JSONObject();
    paramJSONObject.put("result", 1);
    paramJSONObject.put("msg", HardCodeUtil.a(2131700640));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&&");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(paramJSONObject.toString());
    localStringBuilder.append(");");
    super.callJs(localStringBuilder.toString());
  }
  
  private void handleJsApiIsTcpConnected(String paramString)
  {
    this.mReqBundle.clear();
    super.sendRemoteReq(DataFactory.a("ipc_cm_game_conn_connected", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void handleJsApiIsX86(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void handleJsApiOpenApolloShareFloatView(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    String str1 = paramJSONObject.optString("backgroundImage");
    String str2 = paramJSONObject.optString("nickName");
    if ((this.mRuntime.a() instanceof QBaseActivity)) {
      paramJSONObject = (AppInterface)((QBaseActivity)this.mRuntime.a()).getAppRuntime();
    } else {
      paramJSONObject = null;
    }
    ApolloViewController localApolloViewController = this.mApolloViewContoller;
    if (localApolloViewController != null)
    {
      localApolloViewController.a(paramActivity, paramJSONObject, str1, str2);
      callbackOk(paramString);
      return;
    }
    if ((paramActivity instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)paramActivity).a(paramActivity, str1, str2);
      callbackOk(paramString);
      return;
    }
    callbackError(paramString, "ApolloViewController not inited or not ApolloStoreActivity");
  }
  
  private void handleJsApiOpenApolloShow(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    String str = paramJSONObject.optString("nick");
    paramJSONObject = paramJSONObject.optString("uin");
    Intent localIntent = new Intent(paramActivity, ApolloGuestsStateActivity.class);
    localIntent.putExtra("extra_guest_nick", str);
    localIntent.putExtra("extra_guest_uin", paramJSONObject);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(0, 0);
    callbackOk(paramString);
  }
  
  private void handleJsApiOpenBox(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    paramJSONObject = paramJSONObject.optString("uin");
    if ((paramActivity instanceof IApolloActivityJsCallBack))
    {
      paramJSONObject = ((IApolloActivityJsCallBack)paramActivity).a(paramJSONObject);
      paramActivity = new StringBuilder();
      paramActivity.append(paramString);
      paramActivity.append("&&");
      paramActivity.append(paramString);
      paramActivity.append("(");
      paramActivity.append(paramJSONObject);
      paramActivity.append(");");
      super.callJs(paramActivity.toString());
      return;
    }
    callbackError(paramString, HardCodeUtil.a(2131700672));
  }
  
  private void handleJsApiOpenDiyActionFloatView(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    paramJSONObject = paramJSONObject.optString("defaultText");
    if ((paramActivity instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)paramActivity).a(paramJSONObject);
      return;
    }
    callbackError(paramString, HardCodeUtil.a(2131700666));
  }
  
  private void handleJsApiOpenFloatTransparentView(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    String str = paramJSONObject.getString("url");
    int i = paramJSONObject.getInt("closeBtn");
    int j = paramJSONObject.optInt("fullScreen");
    paramJSONObject = new Intent(paramActivity, ApolloFloatActivity.class);
    paramJSONObject.putExtra("extra_key_click_time", System.currentTimeMillis());
    paramJSONObject.putExtra("extra_key_weburl", str);
    boolean bool2 = true;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramJSONObject.putExtra("extra_key_close_btn", bool1);
    if (j == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramJSONObject.putExtra("extra_key_fullscreen", bool1);
    paramJSONObject.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    paramActivity.startActivity(paramJSONObject);
    paramJSONObject = new JSONObject();
    paramJSONObject.put("result", 0);
    paramJSONObject.put("msg", "");
    paramActivity = new StringBuilder();
    paramActivity.append(paramString);
    paramActivity.append("&&");
    paramActivity.append(paramString);
    paramActivity.append("(");
    paramActivity.append(paramJSONObject.toString());
    paramActivity.append(");");
    super.callJs(paramActivity.toString());
  }
  
  private void handleJsApiPreview(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    if (!checkSdcard(paramActivity))
    {
      callbackError(paramString, "sdcard未装");
      return;
    }
    if (!(paramActivity instanceof IApolloActivityJsCallBack))
    {
      callbackError(paramString, HardCodeUtil.a(2131700663));
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("dressIds");
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      int j = paramJSONObject.length();
      int[] arrayOfInt = new int[j];
      int i = 0;
      while (i < j)
      {
        arrayOfInt[i] = paramJSONObject.getInt(i);
        i += 1;
      }
      int k = arrayOfInt.length;
      j = 0;
      i = 1;
      while (j < k)
      {
        int m = arrayOfInt[j];
        if ((i != 0) && (CMResUtil.a(m))) {
          i = 1;
        } else {
          i = 0;
        }
        j += 1;
      }
      if (i != 0)
      {
        paramJSONObject = ((IApolloActivityJsCallBack)paramActivity).a(arrayOfInt);
        paramActivity = new StringBuilder();
        paramActivity.append(paramString);
        paramActivity.append("&&");
        paramActivity.append(paramString);
        paramActivity.append("(");
        paramActivity.append(paramJSONObject);
        paramActivity.append(");");
        super.callJs(paramActivity.toString());
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("callbackId->");
          paramActivity.append(paramString);
          paramActivity.append(" callbackOk");
          paramActivity.append(paramJSONObject);
          QLog.e("[cmshow]ApolloJsPlugin", 2, paramActivity.toString());
        }
      }
      else
      {
        this.mReqBundle.clear();
        this.mReqBundle.putIntArray("apollo_dressIds", arrayOfInt);
        super.sendRemoteReq(DataFactory.a("ipc_apollo_preview", paramString, this.mOnRemoteResp.key, this.mReqBundle), true, true);
      }
      return;
    }
    callbackError(paramString, "dressIds为空");
  }
  
  private void handleJsApiPreviewOnFrame(String paramString1, String paramString2, JSONObject paramJSONObject, Activity paramActivity)
  {
    if (!checkSdcard(paramActivity))
    {
      callbackError(paramString2, "sdcard未装");
      return;
    }
    int i = paramJSONObject.optInt("actionId");
    int j = paramJSONObject.optInt("type");
    int k = paramJSONObject.optInt("isSpecial");
    paramActivity = paramJSONObject.optString("title");
    String str1 = paramJSONObject.optString("subTitle");
    String str2 = paramJSONObject.optString("apolloId", "me");
    this.mReqBundle.clear();
    this.mReqBundle.putInt("apollo_previewAction", i);
    this.mReqBundle.putBoolean("apollo_previewOnFrame", "previewOnFrame".equals(paramString1));
    paramString1 = this.mReqBundle;
    int m = sRoleGender;
    i = 2;
    if (m == 2) {
      i = 1;
    }
    paramString1.putInt("apollo_partnerRoleId", i);
    this.mReqBundle.putInt("apollo_type", j);
    this.mReqBundle.putInt("apollo_isSpecial", k);
    this.mReqBundle.putString("apollo_json", paramJSONObject.toString());
    this.mReqBundle.putString("apollo_id", str2);
    this.mReqBundle.putString("title", paramActivity);
    this.mReqBundle.putString("subTitle", str1);
    super.sendRemoteReq(DataFactory.a("ipc_apollo_preview_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
  }
  
  private void handleJsApiRedbagCallback(String paramString, JSONObject paramJSONObject)
  {
    this.mReqBundle.clear();
    int i = paramJSONObject.optInt("bonusSuccess", 0);
    if (i == 1)
    {
      this.mReqBundle.putInt("bonusSuccess", i);
      super.sendRemoteReq(DataFactory.a("ipc_kandian_hb_lottery", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }
  }
  
  private void handleJsApiRefreshAction(String paramString)
  {
    this.mReqBundle.clear();
    super.sendRemoteReq(DataFactory.a("ipc_apollo_refresh_action", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "apolloJsPlugin call refreshAction");
    }
  }
  
  private void handleJsApiRemoveBubble(String paramString, JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("bubbleId");
    this.mReqBundle.clear();
    this.mReqBundle.putLong("bubble_id", l);
    super.sendRemoteReq(DataFactory.a("ipc_apollo_clear_bubble", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void handleJsApiResumeThunderCache(String paramString)
  {
    ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).resumeThunderCache();
    callbackOk(paramString);
  }
  
  private void handleJsApiSayHi(String paramString, Activity paramActivity)
  {
    StringBuilder localStringBuilder;
    if ((paramActivity instanceof IApolloActivityJsCallBack))
    {
      paramActivity = ((IApolloActivityJsCallBack)paramActivity).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append(");");
      super.callJs(localStringBuilder.toString());
      return;
    }
    paramActivity = this.mApolloViewContoller;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append(");");
      super.callJs(localStringBuilder.toString());
      return;
    }
    callbackError(paramString, "ApolloViewController not inited or not ApolloStoreActivity");
  }
  
  private void handleJsApiSendActionToFrd(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("actionId", -1);
    int j = paramJSONObject.optInt("pkgId", -1);
    Object localObject = paramJSONObject.optString("uin", "");
    int k = paramJSONObject.optInt("uinType", 0);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "apolloJsPlugin call sendActionToFrd, pkgId=", Integer.valueOf(j), ", actionId=", Integer.valueOf(i), ", uin=", localObject });
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putInt("forward_type", 26);
    paramJSONObject.putInt("apollo_actionid_key", i);
    paramJSONObject.putInt("apollo_pkgid_key", j);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Intent localIntent = new Intent();
      String str = SplashActivity.class.getName();
      localIntent.setClassName(BaseApplicationImpl.getContext(), str);
      localIntent = AIOUtils.a(localIntent, new int[] { 1 });
      localIntent.putExtra("uin", (String)localObject);
      localIntent.putExtra("uintype", k);
      localIntent.putExtra("entrance", 0);
      localIntent.putExtra("apollo_forward_key", true);
      localIntent.putExtras(paramJSONObject);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    localObject = new Intent(this.mRuntime.a().getApplicationContext(), ForwardRecentActivity.class);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtras(paramJSONObject);
    this.mRuntime.a().startActivity((Intent)localObject);
  }
  
  private void handleJsApiSetBackViewVisibility(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    int i = paramJSONObject.optInt("visibility");
    if ((paramActivity instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)paramActivity).c(i);
      callbackOk(paramString);
      return;
    }
    callbackError(paramString, "ApolloViewController not inited or not ApolloStoreActivity");
  }
  
  private void handleJsApiSetCapsuleOpened(String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("uin");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      callbackError(paramString, "uin is empty");
      return;
    }
    this.mReqBundle.clear();
    this.mReqBundle.putString("apollo_uin", paramJSONObject);
    super.sendRemoteReq(DataFactory.a("ipc_apollo_setcapsule", paramString, this.mOnRemoteResp.key, this.mReqBundle), true, true);
  }
  
  private void handleJsApiSetLeftViewIcon(JSONObject paramJSONObject, Activity paramActivity)
  {
    String str = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramJSONObject = (SwiftBrowserUIStyleHandler)access$001(this, 2);
    if ((paramJSONObject != null) && (paramJSONObject.a != null) && (paramJSONObject.a.a != null))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramActivity.getResources().getDrawable(2130851066);
      paramActivity = URLDrawable.getDrawable(str, localURLDrawableOptions);
      paramActivity.startDownload();
      paramJSONObject.a.a.setBackgroundDrawable(paramActivity);
    }
  }
  
  private void handleJsApiSetup(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("dressIds");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      int j = localJSONArray.length();
      this.mDressIds = new int[j];
      int i = 0;
      while (i < j)
      {
        this.mDressIds[i] = localJSONArray.getInt(i);
        i += 1;
      }
    }
    if ((paramActivity instanceof IApolloActivityJsCallBack))
    {
      this.mApolloStatus = 1;
      ((IApolloActivityJsCallBack)paramActivity).a(this.mRoleId, this.mDressIds);
      callbackOk(paramString);
      this.mReqBundle.clear();
      paramJSONObject = paramJSONObject.optString("userData");
      this.mReqBundle.putString("apollo_userData", paramJSONObject);
      super.sendRemoteReq(DataFactory.a("ipc_apollo_setup", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    callbackError(paramString, HardCodeUtil.a(2131700644));
  }
  
  private void handleJsApiStartPlayLoastRecord(String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("url", "");
    this.mReqBundle.clear();
    this.mReqBundle.putString("url", paramJSONObject);
    super.sendRemoteReq(DataFactory.a("ipc_apollo_play_last_record_msg", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void handleJsApiStartRecord(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    int j = paramJSONObject.optInt("maxDuration", 5);
    int i = j;
    if (j > 100) {
      i = 100;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (paramActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j == 0)
    {
      if ((paramActivity instanceof QBaseActivity)) {
        ((QBaseActivity)paramActivity).requestPermissions(new ApolloJsPluginImpl.2(this), 2, new String[] { "android.permission.RECORD_AUDIO" });
      }
      callbackError(paramString, "don't have permission!");
      return;
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("maxDuration", i);
    super.sendRemoteReq(DataFactory.a("ipc_apollo_start_record_msg", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void handleJsApiStartUploadRecord(String paramString)
  {
    super.sendRemoteReq(DataFactory.a("ipc_apollo_upload_record_msg", paramString, this.mOnRemoteResp.key, null), false, true);
  }
  
  private void handleJsApiStopPlayLastRecord(String paramString)
  {
    super.sendRemoteReq(DataFactory.a("ipc_apollo_stop_last_record_msg", paramString, this.mOnRemoteResp.key, null), false, true);
  }
  
  private void handleJsApiStopRecord(String paramString)
  {
    super.sendRemoteReq(DataFactory.a("ipc_apollo_stop_record_msg", paramString, this.mOnRemoteResp.key, null), false, true);
  }
  
  private void handleJsApiStopThunderCache(String paramString)
  {
    ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).stopThunderCache();
    callbackOk(paramString);
  }
  
  private void handleJsApiWriteLocalData(String paramString, JSONObject paramJSONObject)
  {
    this.mReqBundle.clear();
    this.mReqBundle.putString("writeData", paramJSONObject.toString());
    super.sendRemoteReq(DataFactory.a("ipc_apollo_write_local", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "apolloJsPlugin call writeLocalData");
    }
  }
  
  public void callbackCmShowFaceCameraResult(int paramInt, @NonNull String paramString1, @NonNull String paramString2)
  {
    this.mMakeup3DModule.a(paramInt, paramString1, paramString2);
  }
  
  void callbackError(String paramString1, String paramString2)
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
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ApolloJsPlugin", 2, localException.getMessage());
      }
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
  
  void callbackOk(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append(");");
      super.callJs(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("callbackId->");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" callbackOk");
        localStringBuilder.append(localJSONObject.toString());
        QLog.d("[cmshow]ApolloJsPlugin", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ApolloJsPlugin", 2, paramString.getMessage());
      }
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
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ApolloJsPlugin", 2, paramString1.getMessage());
      }
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
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("callbackId->");
        paramJSONObject.append(paramString);
        paramJSONObject.append(" callbackOk");
        paramJSONObject.append(localJSONObject.toString());
        QLog.d("[cmshow]ApolloJsPlugin", 2, paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ApolloJsPlugin", 2, paramString.getMessage());
      }
    }
  }
  
  boolean checkSdcard(Context paramContext)
  {
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      QQToast.a(paramContext, HardCodeUtil.a(2131700649), 0).a();
      return false;
    }
    return true;
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
      if ((paramBoolean) && (!((ApolloUrlInterceptor)localObject).a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloJsPlugin", 2, "apollo_client_apolloWebStatistics checkRunSuccess fail");
        }
        return null;
      }
      localObject = ((ApolloUrlInterceptor)localObject).a();
      try
      {
        int i = ((ApolloWebStatistics)localObject).jdField_a_of_type_Int;
        throw new NullPointerException();
      }
      catch (JSONException localJSONException)
      {
        QLog.e("[cmshow]ApolloJsPlugin", 2, "apollo_client_apolloWebStatistics getThunderJson error:", localJSONException);
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
          localObject = this.mInterceptor.a(paramString);
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
      localObject = this.mApolloViewContoller;
      if (localObject != null) {
        ((ApolloViewController)localObject).c();
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
      paramString2 = null;
      paramJsBridgeListener = paramString2;
      try
      {
        paramVarArgs = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramVarArgs == null) {
          return true;
        }
        paramJsBridgeListener = paramString2;
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = paramString2;
          paramString1 = new StringBuilder();
          paramJsBridgeListener = paramString2;
          paramString1.append("handleJsRequest JSON = ");
          paramJsBridgeListener = paramString2;
          paramString1.append(paramVarArgs.toString());
          paramJsBridgeListener = paramString2;
          QLog.d("[cmshow]ApolloJsPlugin", 2, paramString1.toString());
        }
        paramJsBridgeListener = paramString2;
        paramString1 = paramVarArgs.optString("callback");
        if (paramString1 != null)
        {
          paramJsBridgeListener = paramString1;
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = paramString1;
            paramString2 = new StringBuilder();
            paramJsBridgeListener = paramString1;
            paramString2.append("json:");
            paramJsBridgeListener = paramString1;
            paramString2.append(paramVarArgs);
            paramJsBridgeListener = paramString1;
            QLog.d("[cmshow]ApolloJsPlugin", 2, paramString2.toString());
          }
          paramJsBridgeListener = paramString1;
          paramString2 = getActivity();
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            if (!this.isDestroy)
            {
              paramJsBridgeListener = paramString1;
              if (!paramString2.isFinishing())
              {
                paramJsBridgeListener = paramString1;
                if ("startRecord".equals(paramString3))
                {
                  paramJsBridgeListener = paramString1;
                  handleJsApiStartRecord(paramString1, paramVarArgs, paramString2);
                }
                else
                {
                  paramJsBridgeListener = paramString1;
                  if ("stopRecord".equals(paramString3))
                  {
                    paramJsBridgeListener = paramString1;
                    handleJsApiStopRecord(paramString1);
                  }
                  else
                  {
                    paramJsBridgeListener = paramString1;
                    if ("startUploadRecord".equals(paramString3))
                    {
                      paramJsBridgeListener = paramString1;
                      handleJsApiStartUploadRecord(paramString1);
                    }
                    else
                    {
                      paramJsBridgeListener = paramString1;
                      if ("startPlayLastRecord".equals(paramString3))
                      {
                        paramJsBridgeListener = paramString1;
                        handleJsApiStartPlayLoastRecord(paramString1, paramVarArgs);
                      }
                      else
                      {
                        paramJsBridgeListener = paramString1;
                        if ("stopPlayLastRecord".equals(paramString3))
                        {
                          paramJsBridgeListener = paramString1;
                          handleJsApiStopPlayLastRecord(paramString1);
                        }
                        else
                        {
                          paramJsBridgeListener = paramString1;
                          if ("isApolloEngineReady".equals(paramString3))
                          {
                            paramJsBridgeListener = paramString1;
                            handleJsApiIsApolloEngineReady(paramString1);
                          }
                          else
                          {
                            paramJsBridgeListener = paramString1;
                            if ("clearThunderCache".equals(paramString3))
                            {
                              paramJsBridgeListener = paramString1;
                              handleJsApiClearThunderCache(paramString1);
                            }
                            else
                            {
                              paramJsBridgeListener = paramString1;
                              if ("stopThunderCache".equals(paramString3))
                              {
                                paramJsBridgeListener = paramString1;
                                handleJsApiStopThunderCache(paramString1);
                              }
                              else
                              {
                                paramJsBridgeListener = paramString1;
                                if ("resumeThunderCache".equals(paramString3))
                                {
                                  paramJsBridgeListener = paramString1;
                                  handleJsApiResumeThunderCache(paramString1);
                                }
                                else
                                {
                                  paramJsBridgeListener = paramString1;
                                  if ("setBackViewVisibility".equals(paramString3))
                                  {
                                    paramJsBridgeListener = paramString1;
                                    handleJsApiSetBackViewVisibility(paramString1, paramVarArgs, paramString2);
                                  }
                                  else
                                  {
                                    paramJsBridgeListener = paramString1;
                                    if ("openApolloShareFloatView".equals(paramString3))
                                    {
                                      paramJsBridgeListener = paramString1;
                                      handleJsApiOpenApolloShareFloatView(paramString1, paramVarArgs, paramString2);
                                    }
                                    else
                                    {
                                      paramJsBridgeListener = paramString1;
                                      if ("openDiyActionFloatView".equals(paramString3))
                                      {
                                        paramJsBridgeListener = paramString1;
                                        handleJsApiOpenDiyActionFloatView(paramString1, paramVarArgs, paramString2);
                                      }
                                      else
                                      {
                                        paramJsBridgeListener = paramString1;
                                        if ("sayHi".equals(paramString3))
                                        {
                                          paramJsBridgeListener = paramString1;
                                          handleJsApiSayHi(paramString1, paramString2);
                                        }
                                        else
                                        {
                                          paramJsBridgeListener = paramString1;
                                          if ("setCapsuleOpened".equals(paramString3))
                                          {
                                            paramJsBridgeListener = paramString1;
                                            handleJsApiSetCapsuleOpened(paramString1, paramVarArgs);
                                          }
                                          else
                                          {
                                            paramJsBridgeListener = paramString1;
                                            if ("openBox".equals(paramString3))
                                            {
                                              paramJsBridgeListener = paramString1;
                                              handleJsApiOpenBox(paramString1, paramVarArgs, paramString2);
                                            }
                                            else
                                            {
                                              paramJsBridgeListener = paramString1;
                                              if ("setApolloViewVisibility".equals(paramString3))
                                              {
                                                paramJsBridgeListener = paramString1;
                                                handleJsApiAetApolloViewVisibility(paramString1, paramVarArgs, paramString2);
                                              }
                                              else
                                              {
                                                paramJsBridgeListener = paramString1;
                                                if ("initApolloView".equals(paramString3))
                                                {
                                                  paramJsBridgeListener = paramString1;
                                                  handleJsApiInitApolloView(paramString1, paramVarArgs);
                                                }
                                                else
                                                {
                                                  paramJsBridgeListener = paramString1;
                                                  if ("initAvatar".equals(paramString3))
                                                  {
                                                    paramJsBridgeListener = paramString1;
                                                    handleJsApiInitAvatar(paramString1, paramVarArgs, paramString2);
                                                  }
                                                  else
                                                  {
                                                    paramJsBridgeListener = paramString1;
                                                    if ("addAvatar".equals(paramString3))
                                                    {
                                                      paramJsBridgeListener = paramString1;
                                                      handleJsApiAddAvatar(paramString1, paramVarArgs, paramString2);
                                                    }
                                                    else
                                                    {
                                                      paramJsBridgeListener = paramString1;
                                                      if ("destroyAvatar".equals(paramString3))
                                                      {
                                                        paramJsBridgeListener = paramString1;
                                                        handleJsApiDestroyAvatar(paramString1, paramVarArgs, paramString2);
                                                      }
                                                      else
                                                      {
                                                        paramJsBridgeListener = paramString1;
                                                        if ("getRoleId".equals(paramString3))
                                                        {
                                                          paramJsBridgeListener = paramString1;
                                                          handleJsApiGetRoleID(paramString1);
                                                        }
                                                        else
                                                        {
                                                          paramJsBridgeListener = paramString1;
                                                          if ("getLocalInfo".equals(paramString3))
                                                          {
                                                            paramJsBridgeListener = paramString1;
                                                            handleJsApiGetLocalInfo(paramString1);
                                                          }
                                                          else
                                                          {
                                                            paramJsBridgeListener = paramString1;
                                                            if ("preview".equals(paramString3))
                                                            {
                                                              paramJsBridgeListener = paramString1;
                                                              handleJsApiPreview(paramString1, paramVarArgs, paramString2);
                                                            }
                                                            else
                                                            {
                                                              paramJsBridgeListener = paramString1;
                                                              if (!"previewOnFrame".equals(paramString3))
                                                              {
                                                                paramJsBridgeListener = paramString1;
                                                                if (!"previewAction".equals(paramString3))
                                                                {
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("setup".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiSetup(paramString1, paramVarArgs, paramString2);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("changeRole".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiChangeRole(paramString1, paramVarArgs, paramString2);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("closeWebview".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiCloseWebView(paramString1, paramString2);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("getSwitch".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiGetSwitch(paramString1);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("openFloatTransparentView".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiOpenFloatTransparentView(paramString1, paramVarArgs, paramString2);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("openApolloShow".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiOpenApolloShow(paramString1, paramVarArgs, paramString2);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("getFriendsByOpenApollo".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiGetFriendsByOpenApollo(paramString1);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("sendActionToFrd".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiSendActionToFrd(paramVarArgs);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("refreshAction".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiRefreshAction(paramString1);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("getLocalFavAction".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiGetLocalFavAction(paramString1);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("addCustomAction".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiAddCustomAction(paramString1, paramVarArgs);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("delLocalFavAction".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiDelLocalFavAction(paramString1, paramVarArgs);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("writeLocalData".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiWriteLocalData(paramString1, paramVarArgs);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("redbagCallback".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiRedbagCallback(paramString1, paramVarArgs);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("removeBubble".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiRemoveBubble(paramString1, paramVarArgs);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("downloadImageOnFrame".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiDownloadImageOnFrame(paramString1);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("isCmFaceAdded".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiIsCmFaceAdded(paramString1, paramVarArgs);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("addCmFace".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiAddCmFace(paramString1, paramVarArgs);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("downloadTbs".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiDownloadTbs();
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("setLeftViewIcon".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiSetLeftViewIcon(paramVarArgs, paramString2);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("getUserInfo".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiGetUserInfo(paramString1);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if ("isTcpConnected".equals(paramString3))
                                                                  {
                                                                    paramJsBridgeListener = paramString1;
                                                                    handleJsApiIsTcpConnected(paramString1);
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  if (!"isX86".equals(paramString3)) {
                                                                    break label1419;
                                                                  }
                                                                  paramJsBridgeListener = paramString1;
                                                                  handleJsApiIsX86(paramString1);
                                                                  break label1419;
                                                                }
                                                              }
                                                              paramJsBridgeListener = paramString1;
                                                              handleJsApiPreviewOnFrame(paramString3, paramString1, paramVarArgs, paramString2);
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                label1419:
                paramJsBridgeListener = paramString1;
                CmshowWebReqParam localCmshowWebReqParam = new CmshowWebReqParam();
                paramJsBridgeListener = paramString1;
                localCmshowWebReqParam.jdField_a_of_type_OrgJsonJSONObject = paramVarArgs;
                paramJsBridgeListener = paramString1;
                localCmshowWebReqParam.jdField_a_of_type_JavaLangString = paramString1;
                paramJsBridgeListener = paramString1;
                localCmshowWebReqParam.jdField_a_of_type_AndroidAppActivity = paramString2;
                paramJsBridgeListener = paramString1;
                localCmshowWebReqParam.jdField_b_of_type_JavaLangString = paramString3;
                paramJsBridgeListener = paramString1;
                localCmshowWebReqParam.jdField_c_of_type_JavaLangString = getAbsoluteUrl();
                paramJsBridgeListener = paramString1;
                this.mDispatcher.a(paramString3, localCmshowWebReqParam);
                return true;
              }
            }
          }
          paramJsBridgeListener = paramString1;
          callbackError(paramString1, HardCodeUtil.a(2131700656));
          return true;
        }
        paramJsBridgeListener = paramString1;
        throw new Exception("need callbackId");
      }
      catch (Throwable paramString1)
      {
        QLog.e("[cmshow]ApolloJsPlugin", 1, paramString1.getMessage());
      }
    }
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("result", 1);
      paramString2.put("msg", paramString1.getMessage());
      paramString3 = new StringBuilder();
      paramString3.append(paramJsBridgeListener);
      paramString3.append("&&");
      paramString3.append(paramJsBridgeListener);
      paramString3.append("(");
      paramString3.append(paramString2.toString());
      paramString3.append(");");
      super.callJs(paramString3.toString());
      return true;
    }
    catch (Exception paramJsBridgeListener)
    {
      label1630:
      break label1630;
    }
    QLog.e("[cmshow]ApolloJsPlugin", 1, paramString1.getMessage());
    return true;
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
    this.mReqBundle = new Bundle();
    sResponseKey = this.mOnRemoteResp.key;
    sApolloReceiver.a(this);
    CmShowCECapabilitiesChecker.a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.mInterceptor;
    if (localObject != null)
    {
      ((ApolloUrlInterceptor)localObject).a();
      this.mInterceptor = null;
    }
    localObject = this.mApolloViewContoller;
    if (localObject != null) {
      ((ApolloViewController)localObject).d();
    }
    localObject = this.gameDialog;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    sApolloReceiver.b(this);
    this.mCmGameStartChecker = null;
    this.mCmGameStartCheckerListener = null;
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "onNotifyLongTouch:", paramString });
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "[onNotifyStatusChanged] status=", Integer.valueOf(paramInt), ", apolloId=", paramString });
    }
    if (TextUtils.isEmpty(paramString))
    {
      super.callJs("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar();");
      return;
    }
    super.callJs(String.format("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar('%s');", new Object[] { paramString }));
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
      return;
    }
    String str2 = paramBundle.getString("cmd");
    Bundle localBundle = paramBundle.getBundle("response");
    if (str2 != null)
    {
      if (localBundle == null) {
        return;
      }
      String str1 = paramBundle.getString("callbackid");
      Activity localActivity = getActivity();
      if ((localActivity != null) && (!this.isDestroy) && (!localActivity.isFinishing())) {
        try
        {
          if ("ipc_apollo_start_record_msg".equals(str2))
          {
            handleIPCApolloStartRecordMsg(str1, localBundle);
            return;
          }
          if ("ipc_apollo_stop_record_msg".equals(str2))
          {
            handleIPCApolloStopRecord(str1, localBundle);
            return;
          }
          if ("ipc_apollo_upload_record_msg".equals(str2))
          {
            handleIPCUploadRecordMsg(str1, localBundle);
            return;
          }
          if ("ipc_apollo_play_last_record_msg".equals(str2))
          {
            handleIPCPlayLastRecordMsg(str1, localBundle);
            return;
          }
          if ("ipc_apollo_stop_last_record_msg".equals(str2))
          {
            handleIPCStopLastRecordMsg(str1, localBundle);
            return;
          }
          if ((!"ipc_apollo_preview_action".equals(str2)) && (!"ipc_apollo_preview_audio_action".equals(str2)))
          {
            if ("ipc_apollo_check_avatar_res".equals(str2))
            {
              handleIPCCheckAvatarRes(str1, localBundle, localActivity);
              return;
            }
            if ("ipc_apollo_changerole".equals(str2))
            {
              handleIPCApolloChangeRole(str1, localBundle);
              return;
            }
            if ("ipc_apollo_get_apollo_data".equals(str2))
            {
              handleIPCApolloGetApolloData(str1, localBundle);
              return;
            }
            if ("ipc_apollo_get_openapollo_friends".equals(str2))
            {
              handleIPCApolloGetOpenApolloFriends(str1, localBundle);
              return;
            }
            if ("ipc_apollo_query_mine_redinfo".equals(str2))
            {
              handleIPCApolloQueryMineRedInfo(localBundle, localActivity);
              return;
            }
            if ("ipc_apollo_getfav_action".equals(str2))
            {
              handleIPCApolloGetFavAction(str1, localBundle);
              return;
            }
            if ("ipc_apollo_add_fav_action".equals(str2))
            {
              handleIPCAddFavAction(str1, localBundle);
              return;
            }
            if ("ipc_apollo_del_fav_action".equals(str2))
            {
              handleIPCDelFavAction(str1, localBundle);
              return;
            }
            if ("ipc_apollo_del_fav_list".equals(str2))
            {
              handleIPCApolloDelFavList(str1, localBundle);
              return;
            }
            if ("ipc_apollo_write_local".equals(str2))
            {
              handleIPCApolloWriteLocal(str1, localBundle);
              return;
            }
            if ("ipc_apollo_downloadImageOnFrame".equals(str2))
            {
              handleIPCApolloDownloadPic(str1, localActivity);
              return;
            }
            if ("ipc_apollo_start_apollo_game".equals(str2))
            {
              handleIPCStartApolloGame(str1, localBundle);
              return;
            }
            if ("IPC_APOLLO_DOWNLOAD_GAME".equals(str2))
            {
              handleIPCDownloadGame(str1, localBundle);
              return;
            }
            if ("ipc_apollo_add_cm_face".equals(str2))
            {
              handleIPCAddCmFace(str1, localBundle);
              return;
            }
            if ("ipc_apollo_is_cm_face_added".equals(str2))
            {
              handleIPCIsCMFaceAdded(str1, localBundle);
              return;
            }
            if ("ipc_apollo_setcapsule".equals(str2))
            {
              handleIPCSetCapsule(str1, localBundle);
              return;
            }
            if ("ipc_cm_game_conn_connected".equals(str2))
            {
              handleIPCCMGameConnConnected(str1, localBundle);
              return;
            }
            super.onResponse(paramBundle);
            return;
          }
          handleIPCPreviewAction(str2, str1, localBundle, localActivity);
          return;
        }
        catch (Throwable paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("[cmshow]ApolloJsPlugin", 2, paramBundle.getMessage());
          }
          callbackError(str1, HardCodeUtil.a(2131700641));
          return;
        }
      }
      callbackError(str1, HardCodeUtil.a(2131700636));
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, "Avatar view is Ready.");
    }
  }
  
  public void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.sendRemoteReq(paramBundle, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl
 * JD-Core Version:    0.7.0.1
 */