package com.tencent.biz.expand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import com.tencent.biz.expand.api.GenericSerializable;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.biz.expand.utils.NetSpeedChecker;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.mobileqq.flutter.report.QFlutterReporter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin.OnOpenResultListener;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.mobileqq.qroute.module.QRoutePluginOpenParams.Builder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandPluginLauncher;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "()V", "extraParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "mComputeRemainTimeOnce", "", "mDownloadStartTime", "", "mHasDownload", "mIsDownloading", "mJumpUrl", "mLastEnterTime", "mLoadingFragment", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/expand/ui/ExpandPluginLoadingFragment;", "mNetSpeedChecker", "Lcom/tencent/biz/expand/utils/NetSpeedChecker;", "mPluginPid", "", "mTotalRxBytes", "checkAndLoadPlugin", "", "checkAndUpdateNetworkStatus", "checkPluginInstalled", "closeLoading", "params", "Landroid/os/Bundle;", "computeRemainTime", "remainSize", "startDownloadSize", "createExpandIntent", "Landroid/content/Intent;", "hasDownload", "createNamedWidget", "name", "enterPlugin", "activityContext", "Landroid/content/Context;", "jumpUrl", "getExtendFriendManager", "Lcom/tencent/mobileqq/extendfriend/ExtendFriendManager;", "installPlugin", "manager", "Lcom/tencent/mobileqq/qroute/module/IQRoutePlugin;", "loadPlugin", "onNetMobile2None", "onNetMobile2Wifi", "p0", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "registerLoadingFragment", "loadFragment", "resetData", "unregisterLoadingFragment", "Companion", "PluginMode", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLauncher
  implements INetInfoHandler
{
  private static Intent jdField_a_of_type_AndroidContentIntent;
  public static final ExpandPluginLauncher.Companion a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)ExpandPluginLauncher.Companion.instance.2.INSTANCE);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final NetSpeedChecker jdField_a_of_type_ComTencentBizExpandUtilsNetSpeedChecker = new NetSpeedChecker();
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<ExpandPluginLoadingFragment> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  private HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandUiExpandPluginLauncher$Companion = new ExpandPluginLauncher.Companion(null);
  }
  
  private final Intent a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    ExtendFriendManager localExtendFriendManager = a();
    if (localExtendFriendManager == null) {
      Intrinsics.throwNpe();
    }
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("isPresent", Integer.valueOf(1));
    Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get("sourceType");
    if (localObject2 != null)
    {
      localObject1 = (Map)localHashMap;
      localObject2 = ExtendFriendPublicFragmentActivity.a(((Integer)localObject2).intValue());
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ExtendFriendPublicFragme…omPage(sourceType as Int)");
      ((Map)localObject1).put("from", localObject2);
    }
    ((Map)localHashMap).put("startTime", String.valueOf(System.currentTimeMillis()) + "");
    localObject2 = (Map)localHashMap;
    label187:
    int i;
    if (QLog.isDebugVersion())
    {
      localObject1 = "0";
      ((Map)localObject2).put("isRelease", localObject1);
      localObject2 = (Map)localHashMap;
      if (!QLog.isDebugVersion()) {
        break label963;
      }
      localObject1 = "0";
      ((Map)localObject2).put("serverEnv", localObject1);
      localObject1 = (Map)localHashMap;
      localObject2 = BaseApplication.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplication.getContext()");
      localObject2 = ((BaseApplication)localObject2).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplication.getContext().resources");
      ((Map)localObject1).put("screenWidth", Integer.valueOf(ViewUtils.c(((Resources)localObject2).getDisplayMetrics().widthPixels)));
      localObject1 = (Map)localHashMap;
      localObject2 = BaseApplication.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplication.getContext()");
      localObject2 = ((BaseApplication)localObject2).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplication.getContext().resources");
      ((Map)localObject1).put("screenHeight", Integer.valueOf(ViewUtils.c(((Resources)localObject2).getDisplayMetrics().heightPixels)));
      if (localExtendFriendManager.a() != null)
      {
        localObject1 = (Map)localHashMap;
        localObject2 = localExtendFriendManager.a();
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((ExtendFriendConfig)localObject2).jdField_a_of_type_JavaLangString;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "extendFriendManager.exte…Config!!.centerBannerList");
        ((Map)localObject1).put("centerBannerList", localObject2);
        localObject1 = localExtendFriendManager.a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = (CharSequence)((ExtendFriendConfig)localObject1).b;
        if ((localObject1 != null) && (!StringsKt.isBlank((CharSequence)localObject1))) {
          break label971;
        }
        i = 1;
        label414:
        if (i != 0) {
          break label976;
        }
        i = 1;
        label420:
        localObject2 = (Map)localHashMap;
        if (i != 1) {
          break label981;
        }
        localObject1 = localExtendFriendManager.a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((ExtendFriendConfig)localObject1).b;
        label454:
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "when(hasTestStrId) {\n   ….toString()\n            }");
        ((Map)localObject2).put("testId", localObject1);
      }
      QLog.d("ExpandPluginLauncher", 4, "jump2FlutterExpandByWidgetName " + localIntent.getStringExtra("centerBannerList"));
      localObject2 = (Map)localHashMap;
      if (!localExtendFriendManager.o()) {
        break label1021;
      }
      localObject1 = "1";
      label529:
      ((Map)localObject2).put("isHasPersonalLabels", localObject1);
      boolean bool1 = localExtendFriendManager.n();
      boolean bool2 = localExtendFriendManager.q();
      if (bool1 == bool2)
      {
        localObject1 = LogUtils.a;
        if (QLog.isColorLevel()) {
          QLog.d("ExpandPluginLauncher", 2, "usedNewMatch and firstPromptExtendFriendNewUser flag is the same");
        }
      }
      if ((bool1) || (!bool2)) {
        break label1028;
      }
      ((Map)localHashMap).put("isUsedNewExpand", "0");
      localExtendFriendManager.e(false);
      label613:
      ((Map)localHashMap).put("userCategory", String.valueOf(localExtendFriendManager.i()));
      localObject2 = (Map)localHashMap;
      if (!localExtendFriendManager.a().f()) {
        break label1048;
      }
      localObject1 = "1";
      label658:
      ((Map)localObject2).put("isHasNewUserMoment", localObject1);
      localObject1 = (Map)localHashMap;
      localObject2 = localExtendFriendManager.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "extendFriendManager.configManager");
      ((Map)localObject1).put("isHasUpgradeIntroduce", String.valueOf(((ExpandConfigManager)localObject2).a()));
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("sourceType")) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaUtilHashMap.get("sourceType"), Integer.valueOf(2)))) {
        break label1055;
      }
      i = 1;
      label745:
      localObject2 = (Map)localHashMap;
      if (i == 0) {
        break label1060;
      }
    }
    label1028:
    label1048:
    label1055:
    label1060:
    for (Object localObject1 = localExtendFriendManager.j();; localObject1 = "")
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "if (isLebaSource) extend…ndManager.wavesId else \"\"");
      ((Map)localObject2).put("wavesId", localObject1);
      localIntent.putExtra("QFLUTTER_NEEDREPORT", QFlutterReporter.a());
      localIntent.putExtra("isDownloadPlugin", paramBoolean);
      ((Map)localHashMap).put("jump", this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject1 = StringCompanionObject.INSTANCE;
        localObject1 = new Object[1];
        localObject1[0] = localIntent.toString();
        localObject1 = String.format("jump2FlutterExpandByWidgetName params=%s", Arrays.copyOf((Object[])localObject1, localObject1.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
        QLog.d("ExpandPluginLauncher", 2, (String)localObject1);
      }
      localObject1 = new GenericSerializable();
      ((GenericSerializable)localObject1).set(localHashMap);
      localIntent.putExtra("params", (Serializable)localObject1);
      localObject1 = LogUtils.a;
      if (QLog.isColorLevel()) {
        QLog.d("ExpandPluginLauncher", 2, "jump2FlutterExpandByWidgetName params=" + localHashMap);
      }
      return localIntent;
      localObject1 = "1";
      break;
      label963:
      localObject1 = "1";
      break label187;
      label971:
      i = 0;
      break label414;
      label976:
      i = 0;
      break label420;
      label981:
      if (i == 0)
      {
        localObject1 = localExtendFriendManager.a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = String.valueOf(((ExtendFriendConfig)localObject1).d);
        break label454;
      }
      throw new NoWhenBranchMatchedException();
      label1021:
      localObject1 = "0";
      break label529;
      ((Map)localHashMap).put("isUsedNewExpand", "1");
      break label613;
      localObject1 = "0";
      break label658;
      i = 0;
      break label745;
    }
  }
  
  @NotNull
  public static final ExpandPluginLauncher a()
  {
    return jdField_a_of_type_ComTencentBizExpandUiExpandPluginLauncher$Companion.a();
  }
  
  private final ExtendFriendManager a()
  {
    Object localObject1 = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.sApplication");
    Object localObject2 = ((BaseApplicationImpl)localObject1).getRuntime();
    localObject1 = localObject2;
    if (!(localObject2 instanceof AppInterface)) {
      localObject1 = null;
    }
    localObject1 = (AppInterface)localObject1;
    if (localObject1 != null) {}
    for (localObject1 = ((AppInterface)localObject1).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof ExtendFriendManager)) {
        localObject2 = null;
      }
      return (ExtendFriendManager)localObject2;
    }
  }
  
  private final void a(int paramInt, long paramLong)
  {
    double d = this.jdField_a_of_type_ComTencentBizExpandUtilsNetSpeedChecker.a(0.3D, paramInt, paramLong);
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandPluginLauncher", 2, "remainTime " + d);
    }
    localObject = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {
      ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject, d, 0.0D, 2, null);
    }
  }
  
  private final void a(IQRoutePlugin paramIQRoutePlugin)
  {
    paramIQRoutePlugin.install((IQRoutePluginInstallListener)new ExpandPluginLauncher.installPlugin.1(this));
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject1 = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 != null) {
      ((ExpandPluginLoadingFragment)localObject1).c(0);
    }
    Object localObject2 = new QRoutePluginOpenParams.Builder().setComponentName("com.tencent.mobileqq.shadowplugins.expand.ExpandMainActivity").setSubModuleId("expand-plugin").setContext((Context)BaseActivity.sTopActivity);
    localObject1 = jdField_a_of_type_AndroidContentIntent;
    if (localObject1 != null) {}
    for (;;)
    {
      localObject1 = ((QRoutePluginOpenParams.Builder)localObject2).setIntent((Intent)localObject1).setOpenResultListener((IQRoutePlugin.OnOpenResultListener)new ExpandPluginLauncher.loadPlugin.params.1(this));
      localObject2 = QRoute.plugin("expand");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "qrouteModule");
      if (((IQRoutePlugin)localObject2).isInstalled()) {
        ((IQRoutePlugin)localObject2).openActivityForResult(((QRoutePluginOpenParams.Builder)localObject1).build());
      }
      return;
      localObject1 = a(paramBoolean);
    }
  }
  
  private final boolean a()
  {
    boolean bool = false;
    Object localObject1 = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.sApplication");
    if ((((BaseApplicationImpl)localObject1).getRuntime() instanceof QQAppInterface))
    {
      localObject1 = QRoute.plugin("expand");
      if (((IQRoutePlugin)localObject1).exist())
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "qrouteModule");
        if (((IQRoutePlugin)localObject1).isInstalled())
        {
          localObject1 = LogUtils.a;
          if (QLog.isColorLevel()) {
            QLog.d("ExpandPluginLauncher", 2, "plugin has  installed");
          }
          bool = true;
          return bool;
        }
        Object localObject2 = LogUtils.a;
        if (QLog.isColorLevel()) {
          QLog.d("ExpandPluginLauncher", 2, "plugin not installed");
        }
        localObject2 = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject2 != null) {
          ((ExpandPluginLoadingFragment)localObject2).a();
        }
        b();
        a((IQRoutePlugin)localObject1);
        return false;
      }
      localObject1 = LogUtils.a;
      QLog.e("ExpandPluginLauncher", 1, "plugin info is null", (Throwable)null);
    }
    for (;;)
    {
      localObject1 = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null) {
        ((ExpandPluginLoadingFragment)localObject1).a();
      }
      localObject1 = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 == null) {
        break;
      }
      ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject1, LoadingStatus.LOADING_ERROR, 1, 0, 4, null);
      return false;
      localObject1 = LogUtils.a;
      QLog.e("ExpandPluginLauncher", 1, "runtime not instance of QQAppInterface", (Throwable)null);
    }
  }
  
  private final void b()
  {
    QLog.d("ExpandPluginLauncher", 2, "checkAndLoadPlugin");
    c();
    if (a())
    {
      LogUtils localLogUtils = LogUtils.a;
      if (QLog.isColorLevel()) {
        QLog.d("ExpandPluginLauncher", 2, "load plugin");
      }
      a(this, false, 1, null);
    }
  }
  
  private final boolean b()
  {
    if (!NetworkUtil.a())
    {
      Object localObject = LogUtils.a;
      QLog.e("ExpandPluginLauncher", 1, "onInstallError network error", (Throwable)null);
      localObject = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
      }
      return false;
    }
    return true;
  }
  
  private final void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public final void a()
  {
    QLog.d("ExpandPluginLauncher", 2, "unregisterLoadingFragment " + System.identityHashCode(this.jdField_a_of_type_JavaLangRefWeakReference.get()));
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    AppNetConnInfo.registerConnectionChangeReceiver((Context)BaseApplicationImpl.sApplication, (INetInfoHandler)this);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull HashMap<String, Object> paramHashMap, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "activityContext");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "params");
    Intrinsics.checkParameterIsNotNull(paramString, "jumpUrl");
    QLog.d("ExpandPluginLauncher", 1, "enterPlugin");
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long < 1000)
    {
      QLog.e("ExpandPluginLauncher", 2, "error double enter");
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramHashMap = new Intent();
    paramHashMap.putExtra("plugin_process_id", this.jdField_a_of_type_Int);
    paramHashMap.putExtra("public_fragment_window_feature", 1);
    QPublicTransFragmentActivity.b(paramContext, paramHashMap, ExpandPluginLoadingFragment.class);
  }
  
  public final void a(@NotNull Bundle paramBundle)
  {
    boolean bool = false;
    Intrinsics.checkParameterIsNotNull(paramBundle, "params");
    QLog.d("ExpandPluginLauncher", 2, "closeLoading " + System.identityHashCode(this.jdField_a_of_type_JavaLangRefWeakReference.get()));
    int i = paramBundle.getInt("pluginPid", 0);
    paramBundle = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_Int == i) {
        bool = true;
      }
      paramBundle.a(bool);
      paramBundle.a(System.currentTimeMillis());
      paramBundle.e(2);
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public final void a(@NotNull ExpandPluginLoadingFragment paramExpandPluginLoadingFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandPluginLoadingFragment, "loadFragment");
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      QLog.e("ExpandPluginLauncher", 2, "loading already exits!!");
      paramExpandPluginLoadingFragment.e(5);
      return;
    }
    QLog.d("ExpandPluginLauncher", 2, "registerLoadingFragment " + System.identityHashCode(paramExpandPluginLoadingFragment));
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramExpandPluginLoadingFragment);
    paramExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramExpandPluginLoadingFragment != null) {
      paramExpandPluginLoadingFragment.a((View.OnClickListener)new ExpandPluginLauncher.registerLoadingFragment.1(this));
    }
    AppNetConnInfo.registerConnectionChangeReceiver((Context)BaseApplicationImpl.sApplication, (INetInfoHandler)this);
    b();
  }
  
  public void onNetMobile2None()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      ExpandPluginLoadingFragment localExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localExpandPluginLoadingFragment != null) {
        ExpandPluginLoadingFragment.a(localExpandPluginLoadingFragment, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
      }
    }
  }
  
  public void onNetMobile2Wifi(@Nullable String paramString) {}
  
  public void onNetNone2Mobile(@Nullable String paramString)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      c();
      paramString = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null) {
        ExpandPluginLoadingFragment.a(paramString, LoadingStatus.LOADING, 0, 0, 6, null);
      }
    }
  }
  
  public void onNetNone2Wifi(@Nullable String paramString)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      c();
      paramString = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null) {
        ExpandPluginLoadingFragment.a(paramString, LoadingStatus.LOADING, 0, 0, 6, null);
      }
    }
  }
  
  public void onNetWifi2Mobile(@Nullable String paramString) {}
  
  public void onNetWifi2None()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      ExpandPluginLoadingFragment localExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localExpandPluginLoadingFragment != null) {
        ExpandPluginLoadingFragment.a(localExpandPluginLoadingFragment, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLauncher
 * JD-Core Version:    0.7.0.1
 */