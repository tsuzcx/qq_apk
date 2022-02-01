package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ArkViewModelBase.Size;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.Container;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.TimeRecord;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.component.ArkMediaPlayer;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ArkAppContainer
  extends ArkViewModel
{
  private static final ark.ApplicationCallback b = new ArkAppContainer.1();
  public static String e;
  public static String l = "";
  protected static final ArrayList<WeakReference<ArkAppContainer>> m = new ArrayList();
  private String a = "";
  public ArkAppMessage.Config d = null;
  public ArkAppInfo.TimeRecord f = new ArkAppInfo.TimeRecord(this.mTimeRecord);
  protected WeakReference<ArkAppContainer> g;
  protected ArkViewModelBase.Size h;
  public String i = "";
  protected boolean j = false;
  int k = -1;
  protected WeakReference<ArkAppContainer.ArkAppModuleCallback> n = new WeakReference(null);
  
  public ArkAppContainer()
  {
    super(b, ArkAiAppCenter.b ^ true);
    ((IArkEnvironment)QRoute.api(IArkEnvironment.class)).setScriptLeakCheckEnabled(true);
    this.g = new WeakReference(this);
    synchronized (m)
    {
      m.add(this.g);
      return;
    }
  }
  
  public ArkAppContainer(boolean paramBoolean)
  {
    super((ark.ApplicationCallback)???, paramBoolean);
    ArkMultiProcUtil.a();
    this.g = new WeakReference(this);
    synchronized (m)
    {
      m.add(this.g);
      return;
    }
  }
  
  public static WeakReference<ArkAppContainer> a(ark.Container paramContainer)
  {
    ArrayList localArrayList = m;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < m.size())
        {
          WeakReference localWeakReference = (WeakReference)m.get(i1);
          ArkAppContainer localArkAppContainer = (ArkAppContainer)localWeakReference.get();
          if ((localArkAppContainer != null) && (localArkAppContainer.getContainer() == paramContainer)) {
            return localWeakReference;
          }
        }
        else
        {
          return new WeakReference(null);
        }
      }
      finally
      {
        continue;
        throw paramContainer;
        continue;
        i1 += 1;
      }
    }
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  private static void b(ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    if (paramAppPathInfo == null) {
      return;
    }
    QQAppInterface localQQAppInterface = f();
    if (localQQAppInterface != null)
    {
      boolean bool;
      if (paramAppPathInfo.from != 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((IArkService)localQQAppInterface.getRuntimeService(IArkService.class)).reportPredownloadFirstHit(paramAppPathInfo.desc.name, bool);
    }
  }
  
  protected static QQAppInterface f()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    QLog.i("ArkApp.ArkAppContainer", 1, "getAppInterface, return null");
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.h = new ArkViewModelBase.Size(paramInt1, paramInt2);
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString)
  {
    l = "";
    if ((paramSessionInfo.a == 0) || (paramSessionInfo.a == 1008)) {
      l = paramString;
    }
  }
  
  public void a(ArkAppContainer.ArkAppModuleCallback paramArkAppModuleCallback)
  {
    this.n = new WeakReference(paramArkAppModuleCallback);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    boolean bool1;
    if (paramInt != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (paramInt == -2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    String str3 = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
    a(str1);
    a(str2);
    a(str3);
    if (TextUtils.isEmpty(paramString1)) {
      QLog.d("ArkApp.ArkAppContainer", 1, String.format("ArkTemp.loadArkApp app=null mAppInfo.appName=%s, mAppInfo.appView=%s, appPath=%s", new Object[] { this.mAppInfo.name, this.mAppInfo.view, paramString1 }), new RuntimeException());
    }
    doLoadArkApp(paramString1, str1, str2, str3, bool1, bool2, paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ArkAppContainer.ArkAppModuleCallback localArkAppModuleCallback = (ArkAppContainer.ArkAppModuleCallback)this.n.get();
    if (localArkAppModuleCallback != null) {
      localArkAppModuleCallback.a(this, paramString1, paramString2);
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, SessionInfo paramSessionInfo)
  {
    e = null;
    if (paramSessionInfo.a == 1) {
      e = paramSessionInfo.b;
    }
    this.k = paramSessionInfo.a;
    this.d = new ArkAppMessage.Config();
    paramSessionInfo = c();
    this.d.fromString(paramSessionInfo);
    boolean bool;
    if ((this.d.round != null) && (this.d.round.intValue() == 0)) {
      bool = false;
    } else {
      bool = true;
    }
    this.mRoundCorner = bool;
    if (!TextUtils.isEmpty(paramString4)) {
      c(paramString4);
    }
    String str = ArkAppCenterUtil.c();
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    ArkAppCenter.a("ArkApp.ArkAppContainer", String.format(Locale.CHINA, "ArkSafe.init appName=%s, appView=%s, appMinVersion=%s, senderuin=%s, scale=%f, res-scale=%f-%f, system-scale=%f-%f, config=%s, metaData=%s, appconfig=%s", new Object[] { paramString1, paramString2, paramString3, l, Float.valueOf(paramFloat), Float.valueOf(localDisplayMetrics.density), Float.valueOf(localDisplayMetrics.scaledDensity), Float.valueOf(FontSettingManager.systemMetrics.density), Float.valueOf(FontSettingManager.systemMetrics.scaledDensity), paramSessionInfo, paramString4, str }));
    return super.init(paramString1, paramString2, paramString3, paramString4, str, paramFloat);
  }
  
  protected void applicationCreate(ark.Application paramApplication)
  {
    super.applicationCreate(paramApplication);
    if (paramApplication != null) {
      this.a = paramApplication.GetVersion();
    }
  }
  
  public String b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public String c()
  {
    return "";
  }
  
  public void c(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return;
    }
    catch (Exception paramString)
    {
      ArkAppCenter.a("ArkApp.ArkAppContainer", String.format("CheckMetaLegality,appMeta is parse error and msg=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  protected void destroy()
  {
    synchronized (m)
    {
      m.remove(this.g);
      super.destroy();
      return;
    }
  }
  
  public String e()
  {
    return this.a;
  }
  
  public void g()
  {
    ArkAppContainer.ArkAppModuleCallback localArkAppModuleCallback = (ArkAppContainer.ArkAppModuleCallback)this.n.get();
    if (localArkAppModuleCallback != null) {
      localArkAppModuleCallback.a(this);
    }
  }
  
  public ark.Container getContainer()
  {
    return this.mContainer;
  }
  
  public void h()
  {
    if (this.mViewImpl != null)
    {
      this.mViewImpl.resetInputState();
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppContainer", 2, String.format("resetInputState done.in.wrapper: %h", new Object[] { this }));
      }
    }
  }
  
  public ArkViewModelBase.Size i()
  {
    return this.h;
  }
  
  protected void initLibrary()
  {
    ark.MediaSetStub(ArkMediaPlayer.b);
  }
  
  protected void onFirstDrawEnd()
  {
    super.onFirstDrawEnd();
    ThreadManager.executeOnSubThread(new ArkAppContainer.3(this));
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    this.f.beginOfGetApp = System.currentTimeMillis();
    Object localObject = ArkAppMgr.getInstance().getAppInfoFromCache(this.mAppInfo.name, this.mAppInfo.appMinVersion);
    if ((localObject != null) && (!TextUtils.isEmpty(((ArkAppMgr.AppPathInfo)localObject).path)))
    {
      b((ArkAppMgr.AppPathInfo)localObject);
      ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkAppContainer.2(this, (ArkAppMgr.AppPathInfo)localObject));
      return true;
    }
    if (TextUtils.isEmpty(paramAppInfo.name))
    {
      QLog.w("ArkApp.ArkAppContainer", 1, "onLoadApp, name is empty");
      a(null, -1, HardCodeUtil.a(2131887065));
      return true;
    }
    localObject = this.mViewImpl;
    if (localObject != null) {
      ((ArkViewImplement)localObject).onLoading();
    }
    ArkAppMgr.getInstance().getAppPathByName(paramAppInfo.name, paramAppInfo.appMinVersion, new ArkAppContainer.AppPathCallback(this.g));
    return false;
  }
  
  protected void onRunAppFailed()
  {
    Object localObject = this.mViewImpl;
    if (localObject != null) {
      if ((this.mApplication != null) && (this.mApplication.GetScriptType() == 2) && (!ark.Application.JSCLoaded()))
      {
        localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131891209);
        this.mErrorInfo.msg = b((String)localObject);
        this.mErrorInfo.canRetry = true;
        if (((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isJSCLibExist())
        {
          ((IArkEnvironment)QRoute.api(IArkEnvironment.class)).initJSCLibPath();
          QLog.i("ArkApp.ArkAppContainer", 1, "run app fail, jsc load fail, init path");
        }
        else
        {
          QLog.i("ArkApp.ArkAppContainer", 1, "run app fail, jsc load fail, library not exist");
        }
      }
      else
      {
        localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131891210);
        this.mErrorInfo.msg = b((String)localObject);
        this.mErrorInfo.canRetry = false;
      }
    }
    super.onRunAppFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer
 * JD-Core Version:    0.7.0.1
 */