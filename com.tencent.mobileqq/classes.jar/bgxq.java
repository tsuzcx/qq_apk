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

public class bgxq
  extends bgls
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
  private bgrk jdField_a_of_type_Bgrk;
  private bgxn jdField_a_of_type_Bgxn;
  private bgxp jdField_a_of_type_Bgxp;
  private bgza jdField_a_of_type_Bgza;
  private bgzd jdField_a_of_type_Bgzd;
  private final bhbw jdField_a_of_type_Bhbw = new bhbw();
  private final FPSCallback jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback = new bgxr(this);
  private ITTEngine jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private ShareState jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareState = new ShareState();
  private String jdField_a_of_type_JavaLangString;
  private Map<Integer, bgxo> jdField_a_of_type_JavaUtilMap = new HashMap();
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
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEngineListener(new bgxt(this));
    boolean bool = bgpx.a("qqtriton", "MiniGameCodeCacheEnable", true);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEnableCodeCache(bool);
  }
  
  private static void a(ITTEngine paramITTEngine, MiniAppInfo paramMiniAppInfo)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo = "var __wxConfig = __wxConfig || {}; __wxConfig.accountInfo = __wxConfig.accountInfo || {}; \n__wxConfig.accountInfo.appId = '" + paramMiniAppInfo.appId + "';\n__wxConfig.accountInfo.icon = '" + paramMiniAppInfo.iconUrl + "';\n __wxConfig.deviceinfo='" + QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getMiniAppEnv().getContext()) + "';\n __wxConfig.miniapp_version='" + paramMiniAppInfo.version + "';\n __wxConfig.sdk_version='" + QUAUtil.getQUA() + "';\n __wxConfig.source_app='" + localMiniAppProxy.getAppName() + "';\n __wxConfig.source_uin='" + bgxl.a().a() + "';\n __wxConfig.source_version='" + localMiniAppProxy.getAppVersion() + "';\n __wxConfig.source_uin_platform='" + QUAUtil.getLoginType() + "';";
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
    this.jdField_a_of_type_Bgxp = new bgxp(paramITTEngine);
    this.jdField_a_of_type_Bgxp.a(this);
  }
  
  private void i()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      this.jdField_a_of_type_AndroidContentComponentCallbacks2 = new bgxs(this);
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
    this.jdField_a_of_type_Bgxn = new bgxn(this);
    l = System.currentTimeMillis() - l;
    bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1038, null, String.valueOf(this.jdField_b_of_type_Int), null, 0, "1", l, null);
    QMLog.i("[minigame][timecost] ", "step[initJsPluginEngine] cost time: " + l);
  }
  
  private void k()
  {
    QMLog.i("GameRuntime", "doOnEngineExit");
    if (this.jdField_a_of_type_Bgma != null) {
      this.jdField_a_of_type_Bgma.a(MiniAppEnv.g().getContext(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
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
          bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1018, null, null, null, 0, "1", l, null);
          QMLog.e("GameRuntime", "doOnPause blackTimeDuration " + l);
        }
      }
      if ((this.d) && (this.jdField_a_of_type_Long > 0L))
      {
        this.d = false;
        bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1016, "1");
        l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        if (l > 0L) {
          bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1020, null, null, null, 0, "1", l, null);
        }
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if ((l > 0L) && (this.jdField_a_of_type_Long > 0L)) {
        bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1021, null, null, null, 0, "1", l, null);
      }
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) {
        break label268;
      }
    }
    label268:
    for (long l = bgnf.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);; l = -1L)
    {
      if ((l >= 0L) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = true;
        bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 639, null, String.valueOf(l), null, 1, "1", 0L, null);
      }
      bhcn.a();
      return;
      l = 0L;
      break;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Bgxp != null) {
      this.jdField_a_of_type_Bgxp.b();
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
    if (this.jdField_a_of_type_Bgxn != null) {
      this.jdField_a_of_type_Bgxn.onDestroy();
    }
  }
  
  private void p()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      bgxo localbgxo = (bgxo)((Map.Entry)localIterator.next()).getValue();
      if (localbgxo != null) {
        localbgxo.a();
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
    bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 22, "1");
    bhcn.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "unload", null);
    bhbs.a("2unload", null, null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    bhcn.a();
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
  
  public bglu a()
  {
    return a(1);
  }
  
  public bglx a()
  {
    return this.jdField_a_of_type_Bgxp;
  }
  
  public bgxo a(int paramInt)
  {
    bgxo localbgxo = (bgxo)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localbgxo != null) {
      return localbgxo;
    }
    try
    {
      localbgxo = new bgxo(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getJsRuntime(paramInt), paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localbgxo);
      return localbgxo;
    }
    finally {}
  }
  
  public bgza a()
  {
    return this.jdField_a_of_type_Bgza;
  }
  
  public ITTEngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine;
  }
  
  public IJsPluginEngine a()
  {
    if (this.jdField_a_of_type_Bgxn != null) {
      return this.jdField_a_of_type_Bgxn.a();
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
    this.jdField_a_of_type_Bgxp.a(paramActivity);
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
    this.jdField_a_of_type_Bgxp.a(paramActivity, paramViewGroup);
  }
  
  public void a(bgmi parambgmi)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine == null)
    {
      QMLog.e("GameRuntime", "Failed to get screen shot. TTEngine is null");
      if (parambgmi != null) {
        parambgmi.onGetScreenshot(null);
      }
      return;
    }
    g();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareState.isGettingScreenShot = true;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getScreenShot(new bgxu(this, parambgmi));
  }
  
  public void a(bgza parambgza)
  {
    this.jdField_a_of_type_Bgza = parambgza;
  }
  
  public void a(bgzd parambgzd)
  {
    this.jdField_a_of_type_Bgzd = parambgzd;
  }
  
  public void a(ITTEngine paramITTEngine)
  {
    i();
    j();
    a(paramITTEngine, this.jdField_a_of_type_Bgxn);
    b(paramITTEngine);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    paramMiniAppInfo = (bgod)paramMiniAppInfo.apkgInfo;
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
    bhaw.a().d(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine);
    this.jdField_a_of_type_Bgxp.b(paramMiniAppInfo);
    this.jdField_a_of_type_Bgxn.a();
    this.jdField_a_of_type_Bhbw.b();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.g = true;
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Bgxn.onCreate(a());
    this.jdField_a_of_type_Bgxp.a(paramMiniAppInfo);
    this.jdField_a_of_type_Bhbw.a(paramMiniAppInfo);
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
      this.jdField_a_of_type_Bgxp.a();
      this.jdField_a_of_type_Bgxn.b();
      this.g = false;
      this.jdField_a_of_type_Bhbw.c();
      bhaw.a().c(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine);
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
    if (this.jdField_a_of_type_Bgxp != null) {
      return this.jdField_a_of_type_Bgxp.c();
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
      bhcn.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "load_fail", "not_foreground");
      bhbs.a("2launch_fail", "not_foreground", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
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
 * Qualified Name:     bgxq
 * JD-Core Version:    0.7.0.1
 */