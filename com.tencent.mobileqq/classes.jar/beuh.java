import android.app.Activity;
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
import com.tencent.qqmini.sdk.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.GameRuntime.3;
import com.tencent.qqmini.sdk.minigame.GameRuntime.4;
import com.tencent.qqmini.sdk.minigame.GameRuntime.6;
import java.util.HashMap;
import java.util.Map;

public class beuh
  extends begw
{
  public static boolean a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private beue jdField_a_of_type_Beue;
  private beug jdField_a_of_type_Beug;
  private final beyd jdField_a_of_type_Beyd = new beyd();
  private final FPSCallback jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback = new beui(this);
  private ITTEngine jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String jdField_a_of_type_JavaLangString;
  private Map<Integer, beuf> jdField_a_of_type_JavaUtilMap = new HashMap();
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d;
  private boolean e = true;
  
  public beuh()
  {
    this.jdField_a_of_type_Beru = new beru();
  }
  
  private void a(ITTEngine paramITTEngine, IJSEngine paramIJSEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine = paramITTEngine;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setJsEngine(paramIJSEngine);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.addGameLifeCycle(new beud(this));
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.addFPSCallback(this.jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEngineListener(new beuj(this));
    boolean bool = belj.a("MiniGame", "MiniGameCodeCacheEnable", true);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEnableCodeCache(bool);
  }
  
  private static void a(ITTEngine paramITTEngine, MiniAppInfo paramMiniAppInfo)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo = "var __wxConfig = __wxConfig || {}; __wxConfig.accountInfo = __wxConfig.accountInfo || {}; \n__wxConfig.accountInfo.appId = '" + paramMiniAppInfo.appId + "';\n__wxConfig.accountInfo.icon = '" + paramMiniAppInfo.iconUrl + "';\n __wxConfig.deviceinfo='" + bfgt.b(MiniAppEnv.g().getContext()) + "';\n __wxConfig.miniapp_version='" + paramMiniAppInfo.version + "';\n __wxConfig.sdk_version='" + bfgt.a() + "';\n __wxConfig.source_app='" + localMiniAppProxy.getAppName() + "';\n __wxConfig.source_uin='" + beuc.a().a() + "';\n __wxConfig.source_version='" + localMiniAppProxy.getAppVersion() + "';\n __wxConfig.source_uin_platform='" + bfgt.e() + "';";
      besl.b("GameRuntime", "injectAccountInfoConfig:" + paramMiniAppInfo);
      paramITTEngine.getJsRuntime(1).evaluateJs(paramMiniAppInfo);
      paramITTEngine.getJsRuntime(2).evaluateJs(paramMiniAppInfo);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null)
    {
      l = this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getLastBlackTime();
      if ((this.jdField_c_of_type_Boolean) && (l > 0L))
      {
        l = System.currentTimeMillis() - l;
        if (l > 0L)
        {
          this.jdField_c_of_type_Boolean = false;
          beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1018, null, null, null, 0, "1", l, null);
          besl.d("GameRuntime", "doOnPause blackTimeDuration " + l);
        }
      }
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long > 0L))
      {
        this.jdField_b_of_type_Boolean = false;
        beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1016, "1");
        l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        if (l > 0L) {
          beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1020, null, null, null, 0, "1", l, null);
        }
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if ((l > 0L) && (this.jdField_a_of_type_Long > 0L)) {
        beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1021, null, null, null, 0, "1", l, null);
      }
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) {
        break label267;
      }
    }
    label267:
    for (long l = beig.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);; l = -1L)
    {
      if ((l >= 0L) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = true;
        beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 639, null, String.valueOf(l), null, 1, "1", 0L, null);
      }
      beyu.a();
      return;
      l = 0L;
      break;
    }
  }
  
  private void i()
  {
    beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 22, "1");
    beyu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "unload", null);
    bexz.a("2unload", null, null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    beyu.a();
  }
  
  private void j()
  {
    if (belj.a("MiniGame", "MiniGameKillAllGamesWhenDestroy", 0) != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.removeFPSCallback(this.jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback);
      return;
    }
    besl.b("GameRuntime", "[MiniEng]doOnDestroy killProcess");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GameRuntime.4(this), 300L);
  }
  
  private void k()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      a().getApplicationContext().registerComponentCallbacks(new beuk(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getNativeBufferPool().newNativeBuffer(paramArrayOfByte, paramInt1, paramInt2);
    }
    return 0;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public Context a()
  {
    return MiniAppEnv.g().getContext();
  }
  
  public begy a()
  {
    return a(1);
  }
  
  public behb a()
  {
    return this.jdField_a_of_type_Beug;
  }
  
  public beuf a(int paramInt)
  {
    beuf localbeuf = (beuf)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localbeuf != null) {
      return localbeuf;
    }
    try
    {
      localbeuf = new beuf(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getJsRuntime(paramInt), paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localbeuf);
      return localbeuf;
    }
    finally {}
  }
  
  public ITTEngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine;
  }
  
  public IJsPluginEngine a()
  {
    return this.jdField_a_of_type_Beue.a();
  }
  
  public CapsuleButton a()
  {
    return this.jdField_a_of_type_Beug.a();
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
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
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_Beug.a(paramActivity);
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
    this.jdField_a_of_type_Beug.a(paramActivity, paramViewGroup);
  }
  
  public void a(ITTEngine paramITTEngine)
  {
    long l1 = System.currentTimeMillis();
    k();
    this.jdField_a_of_type_Beue = new beue(this);
    a(paramITTEngine, this.jdField_a_of_type_Beue);
    long l2 = System.currentTimeMillis();
    beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1038, null, null, null, 0, "1", l2 - l1, null);
    this.jdField_a_of_type_Beug = new beug(paramITTEngine);
    this.jdField_a_of_type_Beug.a(this);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    paramMiniAppInfo = (bejy)paramMiniAppInfo.apkgInfo;
    paramMiniAppInfo.a = new bequ();
    paramMiniAppInfo.a.a = new berj();
    paramMiniAppInfo.a.a.jdField_a_of_type_Int = 60000;
    paramMiniAppInfo.a.a.b = 60000;
    paramMiniAppInfo.a.a.d = 60000;
    paramMiniAppInfo.a.a.c = 60000;
    a(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, false);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onResume();
    this.jdField_a_of_type_Beug.b(paramMiniAppInfo);
    this.jdField_a_of_type_Beue.a();
    this.jdField_a_of_type_Beyd.b();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.e = true;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
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
  
  public void b(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_Beue.onCreate(a());
    this.jdField_a_of_type_Beug.a(paramMiniAppInfo);
    this.jdField_a_of_type_Beyd.a(paramMiniAppInfo);
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void c()
  {
    try
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onPause();
      this.jdField_a_of_type_Beug.a();
      this.jdField_a_of_type_Beue.b();
      this.e = false;
      this.jdField_a_of_type_Beyd.c();
      g();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        besl.d("GameRuntime", "doOnPause reportOnPause ", localThrowable);
      }
    }
  }
  
  public boolean c()
  {
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return bool;
    }
  }
  
  public void d() {}
  
  public boolean d()
  {
    return this.jdField_a_of_type_Beug.b();
  }
  
  public void e()
  {
    if (bepo.a().a() != null) {
      bepo.a().a().notifyRuntimeEvent(64, new Object[0]);
    }
    j();
    this.jdField_a_of_type_Beug.b();
    this.jdField_a_of_type_Beue.onDestroy();
    i();
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    if (!this.e)
    {
      beyu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "load_fail", "not_foreground");
      bexz.a("2launch_fail", "not_foreground", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      besl.d("GameRuntime", "not in forground, donot lauchGame");
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new GameRuntime.6(this));
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Beug.a();
  }
  
  public void g()
  {
    if (a() != null)
    {
      besl.d("GameRuntime", "onHide()");
      a().a("onAppEnterBackground", "", -1);
    }
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return true;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new GameRuntime.3(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beuh
 * JD-Core Version:    0.7.0.1
 */