import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.GameRuntime.4;
import com.tencent.qqmini.sdk.minigame.GameRuntime.5;
import com.tencent.qqmini.sdk.minigame.GameRuntime.6;
import com.tencent.qqmini.sdk.minigame.GameRuntime.8;
import com.tencent.qqmini.sdk.minigame.GameRuntime.9;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bgtj
  extends bghl
{
  public static boolean a;
  private static boolean jdField_b_of_type_Boolean = ;
  private static boolean jdField_c_of_type_Boolean = GameWnsUtils.killAllGamesWhenDestroy();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ComponentCallbacks2 jdField_a_of_type_AndroidContentComponentCallbacks2;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bgnd jdField_a_of_type_Bgnd;
  private bgtg jdField_a_of_type_Bgtg;
  private bgti jdField_a_of_type_Bgti;
  private bgut jdField_a_of_type_Bgut;
  private bguw jdField_a_of_type_Bguw;
  private final bgxp jdField_a_of_type_Bgxp = new bgxp();
  private final FPSCallback jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback = new bgtk(this);
  private ITTEngine jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private ShareState jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareState = new ShareState();
  private String jdField_a_of_type_JavaLangString;
  private Map<Integer, bgth> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_b_of_type_Int = 3;
  private long jdField_b_of_type_Long;
  private long jdField_c_of_type_Long;
  private boolean d = true;
  private boolean e = true;
  private boolean f;
  private boolean g = true;
  
  private void a(ITTEngine paramITTEngine, IJSEngine paramIJSEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine = paramITTEngine;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setJsEngine(paramIJSEngine);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.addFPSCallback(this.jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEngineListener(new bgtm(this));
    boolean bool = bglq.a("qqtriton", "MiniGameCodeCacheEnable", true);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEnableCodeCache(bool);
  }
  
  private static void a(ITTEngine paramITTEngine, MiniAppInfo paramMiniAppInfo)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo = "var __wxConfig = __wxConfig || {}; __wxConfig.accountInfo = __wxConfig.accountInfo || {}; \n__wxConfig.accountInfo.appId = '" + paramMiniAppInfo.appId + "';\n__wxConfig.accountInfo.icon = '" + paramMiniAppInfo.iconUrl + "';\n __wxConfig.deviceinfo='" + QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getMiniAppEnv().getContext()) + "';\n __wxConfig.miniapp_version='" + paramMiniAppInfo.version + "';\n __wxConfig.sdk_version='" + QUAUtil.getQUA() + "';\n __wxConfig.source_app='" + localMiniAppProxy.getAppName() + "';\n __wxConfig.source_uin='" + bgte.a().a() + "';\n __wxConfig.source_version='" + localMiniAppProxy.getAppVersion() + "';\n __wxConfig.source_uin_platform='" + QUAUtil.getLoginType() + "';";
      QMLog.i("GameRuntime", "injectAccountInfoConfig:" + paramMiniAppInfo);
      paramITTEngine.getJsRuntime(1).evaluateJs(paramMiniAppInfo);
      paramITTEngine.getJsRuntime(2).evaluateJs(paramMiniAppInfo);
    }
  }
  
  private String b()
  {
    if (this.f) {
      return "firstLaunch" + this.jdField_b_of_type_Int;
    }
    return "twiceLaunch" + this.jdField_b_of_type_Int;
  }
  
  private void b(ITTEngine paramITTEngine)
  {
    this.jdField_a_of_type_Bgti = new bgti(paramITTEngine);
    this.jdField_a_of_type_Bgti.a(this);
  }
  
  private void i()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      this.jdField_a_of_type_AndroidContentComponentCallbacks2 = new bgtl(this);
      MiniAppEnv.g().getContext().getApplicationContext().registerComponentCallbacks(this.jdField_a_of_type_AndroidContentComponentCallbacks2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void j()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Bgtg = new bgtg(this);
    l = System.currentTimeMillis() - l;
    bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1038, null, String.valueOf(this.jdField_b_of_type_Int), null, 0, "1", l, null);
    QMLog.i("[minigame][timecost] ", "step[initJsPluginEngine] cost time: " + l);
  }
  
  private void k()
  {
    QMLog.i("GameRuntime", "doOnEngineExit");
    if (this.jdField_a_of_type_Bght != null) {
      this.jdField_a_of_type_Bght.a(MiniAppEnv.g().getContext(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null)
    {
      l = this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getLastBlackTime();
      if ((this.e) && (l > 0L))
      {
        l = System.currentTimeMillis() - l;
        if (l > 0L)
        {
          this.e = false;
          bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1018, null, null, null, 0, "1", l, null);
          QMLog.e("GameRuntime", "doOnPause blackTimeDuration " + l);
        }
      }
      if ((this.d) && (this.jdField_a_of_type_Long > 0L))
      {
        this.d = false;
        bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1016, "1");
        l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        if (l > 0L) {
          bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1020, null, null, null, 0, "1", l, null);
        }
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if ((l > 0L) && (this.jdField_a_of_type_Long > 0L)) {
        bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1021, null, null, null, 0, "1", l, null);
      }
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) {
        break label268;
      }
    }
    label268:
    for (long l = bgiy.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);; l = -1L)
    {
      if ((l >= 0L) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = true;
        bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 639, null, String.valueOf(l), null, 1, "1", 0L, null);
      }
      bgyg.a();
      return;
      l = 0L;
      break;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Bgti != null) {
      this.jdField_a_of_type_Bgti.b();
    }
  }
  
  private void n()
  {
    if (!jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.removeFPSCallback(this.jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback);
      QMLog.i("GameRuntime", "[MiniEng]doOnDestroy killAllGamesWhenDestroy :" + jdField_c_of_type_Boolean);
      ThreadManager.a(new GameRuntime.4(this), 16, null, false);
      return;
    }
    QMLog.i("GameRuntime", "[MiniEng]doOnDestroy killProcess");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GameRuntime.5(this), 300L);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Bgtg != null) {
      this.jdField_a_of_type_Bgtg.onDestroy();
    }
  }
  
  private void p()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      bgth localbgth = (bgth)((Map.Entry)localIterator.next()).getValue();
      if (localbgth != null) {
        localbgth.a();
      }
    }
  }
  
  private void q()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.jdField_a_of_type_AndroidContentComponentCallbacks2 != null)) {}
    try
    {
      MiniAppEnv.g().getContext().getApplicationContext().unregisterComponentCallbacks(this.jdField_a_of_type_AndroidContentComponentCallbacks2);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("GameRuntime", "Failed to unRegisterComponentCallback", localException);
    }
  }
  
  private void r()
  {
    bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 22, "1");
    bgyg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "unload", null);
    bgxl.a("2unload", null, null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    bgyg.a();
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getNativeBufferPool().newNativeBuffer(paramArrayOfByte, paramInt1, paramInt2);
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getCurrentDrawCount();
    }
    return 0L;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public Context a()
  {
    return AppLoaderFactory.g().getMiniAppEnv().getContext();
  }
  
  public bghn a()
  {
    return a(1);
  }
  
  public bghq a()
  {
    return this.jdField_a_of_type_Bgti;
  }
  
  public bgth a(int paramInt)
  {
    bgth localbgth = (bgth)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localbgth != null) {
      return localbgth;
    }
    try
    {
      localbgth = new bgth(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getJsRuntime(paramInt), paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localbgth);
      return localbgth;
    }
    finally {}
  }
  
  public bgut a()
  {
    return this.jdField_a_of_type_Bgut;
  }
  
  public ITTEngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine;
  }
  
  public IJsPluginEngine a()
  {
    if (this.jdField_a_of_type_Bgtg != null) {
      return this.jdField_a_of_type_Bgtg.a();
    }
    return null;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public ShareState a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareState;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.handleFocusGain();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_Bgti.a(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == paramActivity) && (this.jdField_a_of_type_AndroidViewViewGroup == paramViewGroup)) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onCreate(paramActivity);
    this.jdField_a_of_type_Bgti.a(paramActivity, paramViewGroup);
  }
  
  public void a(bgib parambgib)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine == null)
    {
      QMLog.e("GameRuntime", "Failed to get screen shot. TTEngine is null");
      if (parambgib != null) {
        parambgib.onGetScreenshot(null);
      }
      return;
    }
    g();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareState.isGettingScreenShot = true;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getScreenShot(new bgtn(this, parambgib));
  }
  
  public void a(bgut parambgut)
  {
    this.jdField_a_of_type_Bgut = parambgut;
  }
  
  public void a(bguw parambguw)
  {
    this.jdField_a_of_type_Bguw = parambguw;
  }
  
  public void a(ITTEngine paramITTEngine)
  {
    i();
    j();
    a(paramITTEngine, this.jdField_a_of_type_Bgtg);
    b(paramITTEngine);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    paramMiniAppInfo = (bgjw)paramMiniAppInfo.apkgInfo;
    paramMiniAppInfo.a = new AppConfigInfo();
    paramMiniAppInfo.a.networkTimeoutInfo = new NetworkTimeoutInfo();
    paramMiniAppInfo.a.networkTimeoutInfo.request = 60000;
    paramMiniAppInfo.a.networkTimeoutInfo.connectSocket = 60000;
    paramMiniAppInfo.a.networkTimeoutInfo.downloadFile = 60000;
    paramMiniAppInfo.a.networkTimeoutInfo.uploadFile = 60000;
    a(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, false, null);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onResume();
    bgwp.a().d(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine);
    this.jdField_a_of_type_Bgti.b(paramMiniAppInfo);
    this.jdField_a_of_type_Bgtg.a();
    this.jdField_a_of_type_Bgxp.b();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.g = true;
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Bgtg.onCreate(a());
    this.jdField_a_of_type_Bgti.a(paramMiniAppInfo);
    this.jdField_a_of_type_Bgxp.a(paramMiniAppInfo);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public byte[] a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getNativeBufferPool().getNativeBuffer(paramInt);
    }
    return new byte[0];
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.handleFocusLoss();
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    try
    {
      l();
      this.jdField_a_of_type_Bgti.a();
      this.jdField_a_of_type_Bgtg.b();
      this.g = false;
      this.jdField_a_of_type_Bgxp.c();
      bgwp.a().c(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine);
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("GameRuntime", "doOnPause reportOnPause ", localThrowable);
      }
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Bgti != null) {
      return this.jdField_a_of_type_Bgti.c();
    }
    return false;
  }
  
  public void d() {}
  
  public boolean d()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    return false;
  }
  
  public void e()
  {
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(64, new Object[0]);
    m();
    n();
    p();
    q();
    o();
    r();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    if (!this.g)
    {
      bgyg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "load_fail", "not_foreground");
      bgxl.a("2launch_fail", "not_foreground", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      QMLog.e("GameRuntime", "not in forground, donot lauchGame");
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new GameRuntime.6(this));
  }
  
  protected void g()
  {
    ThreadManager.c().post(new GameRuntime.8(this));
  }
  
  public void h()
  {
    ThreadManager.c().post(new GameRuntime.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtj
 * JD-Core Version:    0.7.0.1
 */