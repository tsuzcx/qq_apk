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
  private static final ark.ApplicationCallback jdField_a_of_type_ComTencentArkArk$ApplicationCallback = new ArkAppContainer.1();
  public static String a;
  protected static ArrayList<WeakReference<ArkAppContainer>> a;
  public static String c = "";
  int jdField_a_of_type_Int = -1;
  protected ArkViewModelBase.Size a;
  public ArkAppInfo.TimeRecord a;
  public ArkAppMessage.Config a;
  public String b;
  protected boolean b;
  protected WeakReference<ArkAppContainer> c;
  private String d;
  protected WeakReference<ArkAppContainer.ArkAppModuleCallback> d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ArkAppContainer()
  {
    super(jdField_a_of_type_ComTencentArkArk$ApplicationCallback, ArkAiAppCenter.jdField_b_of_type_Boolean ^ true);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config = null;
    this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord = new ArkAppInfo.TimeRecord(this.mTimeRecord);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_b_of_type_Boolean = false;
    ((IArkEnvironment)QRoute.api(IArkEnvironment.class)).setScriptLeakCheckEnabled(true);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(this);
    jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_JavaLangRefWeakReference);
  }
  
  public ArkAppContainer(boolean paramBoolean)
  {
    super(localApplicationCallback, paramBoolean);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config = null;
    this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord = new ArkAppInfo.TimeRecord(this.mTimeRecord);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_b_of_type_Boolean = false;
    ArkMultiProcUtil.a();
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(this);
    jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_JavaLangRefWeakReference);
  }
  
  protected static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    QLog.i("ArkApp.ArkAppContainer", 1, "getAppInterface, return null");
    return null;
  }
  
  public static WeakReference<ArkAppContainer> a(ark.Container paramContainer)
  {
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilArrayList.size())
    {
      WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilArrayList.get(i);
      ArkAppContainer localArkAppContainer = (ArkAppContainer)localWeakReference.get();
      if ((localArkAppContainer != null) && (localArkAppContainer.getContainer() == paramContainer)) {
        return localWeakReference;
      }
      i += 1;
    }
    return new WeakReference(null);
  }
  
  private static void b(ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    if (paramAppPathInfo == null) {
      return;
    }
    QQAppInterface localQQAppInterface = a();
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
  
  private static void b(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public ArkViewModelBase.Size a()
  {
    return this.jdField_a_of_type_ComTencentArkArkViewModelBase$Size;
  }
  
  public String a()
  {
    return "";
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentArkArkViewModelBase$Size = new ArkViewModelBase.Size(paramInt1, paramInt2);
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString)
  {
    jdField_c_of_type_JavaLangString = "";
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1008)) {
      jdField_c_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(ArkAppContainer.ArkAppModuleCallback paramArkAppModuleCallback)
  {
    this.jdField_d_of_type_JavaLangRefWeakReference = new WeakReference(paramArkAppModuleCallback);
  }
  
  public void a(String paramString)
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
    b(str1);
    b(str2);
    b(str3);
    if (TextUtils.isEmpty(paramString1)) {
      QLog.d("ArkApp.ArkAppContainer", 1, String.format("ArkTemp.loadArkApp app=null mAppInfo.appName=%s, mAppInfo.appView=%s, appPath=%s", new Object[] { this.mAppInfo.name, this.mAppInfo.view, paramString1 }), new RuntimeException());
    }
    doLoadArkApp(paramString1, str1, str2, str3, bool1, bool2, paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ArkAppContainer.ArkAppModuleCallback localArkAppModuleCallback = (ArkAppContainer.ArkAppModuleCallback)this.jdField_d_of_type_JavaLangRefWeakReference.get();
    if (localArkAppModuleCallback != null) {
      localArkAppModuleCallback.a(this, paramString1, paramString2);
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, SessionInfo paramSessionInfo)
  {
    jdField_a_of_type_JavaLangString = null;
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config = new ArkAppMessage.Config();
    paramSessionInfo = a();
    this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.fromString(paramSessionInfo);
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.round != null) && (this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.round.intValue() == 0)) {
      bool = false;
    } else {
      bool = true;
    }
    this.mRoundCorner = bool;
    if (!TextUtils.isEmpty(paramString4)) {
      a(paramString4);
    }
    String str = ArkAppCenterUtil.a();
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    ArkAppCenter.a("ArkApp.ArkAppContainer", String.format(Locale.CHINA, "ArkSafe.init appName=%s, appView=%s, appMinVersion=%s, senderuin=%s, scale=%f, res-scale=%f-%f, system-scale=%f-%f, config=%s, metaData=%s, appconfig=%s", new Object[] { paramString1, paramString2, paramString3, jdField_c_of_type_JavaLangString, Float.valueOf(paramFloat), Float.valueOf(localDisplayMetrics.density), Float.valueOf(localDisplayMetrics.scaledDensity), Float.valueOf(FontSettingManager.systemMetrics.density), Float.valueOf(FontSettingManager.systemMetrics.scaledDensity), paramSessionInfo, paramString4, str }));
    return super.init(paramString1, paramString2, paramString3, paramString4, str, paramFloat);
  }
  
  protected void applicationCreate(ark.Application paramApplication)
  {
    super.applicationCreate(paramApplication);
    if (paramApplication != null) {
      this.jdField_d_of_type_JavaLangString = paramApplication.GetVersion();
    }
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void c()
  {
    ArkAppContainer.ArkAppModuleCallback localArkAppModuleCallback = (ArkAppContainer.ArkAppModuleCallback)this.jdField_d_of_type_JavaLangRefWeakReference.get();
    if (localArkAppModuleCallback != null) {
      localArkAppModuleCallback.a(this);
    }
  }
  
  public void d()
  {
    if (this.mViewImpl != null)
    {
      this.mViewImpl.resetInputState();
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppContainer", 2, String.format("resetInputState done.in.wrapper: %h", new Object[] { this }));
      }
    }
  }
  
  protected void destroy()
  {
    jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_c_of_type_JavaLangRefWeakReference);
    super.destroy();
  }
  
  public ark.Container getContainer()
  {
    return this.mContainer;
  }
  
  protected void initLibrary()
  {
    ark.MediaSetStub(ArkMediaPlayer.a);
  }
  
  protected void onFirstDrawEnd()
  {
    super.onFirstDrawEnd();
    ThreadManager.executeOnSubThread(new ArkAppContainer.3(this));
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord.beginOfGetApp = System.currentTimeMillis();
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
      a(null, -1, HardCodeUtil.a(2131690166));
      return true;
    }
    localObject = this.mViewImpl;
    if (localObject != null) {
      ((ArkViewImplement)localObject).onLoading();
    }
    ArkAppMgr.getInstance().getAppPathByName(paramAppInfo.name, paramAppInfo.appMinVersion, new ArkAppContainer.AppPathCallback(this.jdField_c_of_type_JavaLangRefWeakReference));
    return false;
  }
  
  protected void onRunAppFailed()
  {
    Object localObject = this.mViewImpl;
    if (localObject != null) {
      if ((this.mApplication != null) && (this.mApplication.GetScriptType() == 2) && (!ark.Application.JSCLoaded()))
      {
        localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131693634);
        this.mErrorInfo.msg = a((String)localObject);
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
        localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131693635);
        this.mErrorInfo.msg = a((String)localObject);
        this.mErrorInfo.canRetry = false;
      }
    }
    super.onRunAppFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer
 * JD-Core Version:    0.7.0.1
 */