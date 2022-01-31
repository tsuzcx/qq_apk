import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.GameRuntime.3;
import com.tencent.qqmini.sdk.minigame.GameRuntime.4;
import com.tencent.qqmini.sdk.minigame.GameRuntime.5;
import com.tencent.qqmini.sdk.minigame.GameRuntime.7;
import java.util.HashMap;
import java.util.Map;

public class bdoz
  extends bdcw
{
  public static boolean a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private bdow jdField_a_of_type_Bdow;
  private bdoy jdField_a_of_type_Bdoy;
  private final bdsg jdField_a_of_type_Bdsg = new bdsg();
  private final FPSCallback jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback = new bdpa(this);
  private ITTEngine jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private Map<Integer, bdox> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean b;
  private boolean c = true;
  private boolean d = true;
  private boolean e;
  private boolean f = true;
  
  public bdoz()
  {
    this.jdField_a_of_type_Bdgb = new bdgb();
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static void a(ITTEngine paramITTEngine, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramITTEngine != null) && (paramMiniAppInfo != null))
    {
      paramMiniAppInfo = "var __wxConfig = __wxConfig || {}; __wxConfig.accountInfo = __wxConfig.accountInfo || {}; \n__wxConfig.accountInfo.appId = '" + paramMiniAppInfo.appId + "';\n__wxConfig.accountInfo.icon = '" + paramMiniAppInfo.iconUrl + "'; __wxConfig.deviceinfo='" + bdzd.b(MiniAppEnv.g().getContext()) + "'; __wxConfig.miniapp_version='" + paramMiniAppInfo.version + "';";
      bdnw.b("GameRuntime", "injectAccountInfoConfig:" + paramMiniAppInfo);
      paramITTEngine.getJsRuntime(1).evaluateJs(paramMiniAppInfo);
      paramITTEngine.getJsRuntime(2).evaluateJs(paramMiniAppInfo);
    }
  }
  
  private int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  private void b(ITTEngine paramITTEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine = paramITTEngine;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setJsEngine(this.jdField_a_of_type_Bdow);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.addGameLifeCycle(new bdov(this));
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.addFPSCallback(this.jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEngineListener(new bdpb(this));
    boolean bool = bdhg.a("MiniGame", "MiniGameCodeCacheEnable", true);
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEnableCodeCache(bool);
  }
  
  private void g()
  {
    MiniAppInfo localMiniAppInfo = a();
    String str1;
    if (localMiniAppInfo != null)
    {
      str1 = localMiniAppInfo.appId;
      if (localMiniAppInfo == null) {
        break label85;
      }
    }
    label85:
    for (String str2 = localMiniAppInfo.name;; str2 = "")
    {
      bdnw.b("GameRuntime", "game[" + str1 + "][" + str2 + "] 游戏启动(GameActivity onCreate)");
      if (localMiniAppInfo != null) {
        bdsu.a(localMiniAppInfo, 24, "1");
      }
      a(0);
      return;
      str1 = "";
      break;
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine == null) || (this.b)) {
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new GameRuntime.3(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {}
    for (long l = this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getLastBlackTime();; l = 0L)
    {
      if ((this.d) && (l > 0L))
      {
        l = System.currentTimeMillis() - l;
        if (l > 0L)
        {
          this.d = false;
          bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1018, null, null, null, 0, "1", l, null);
          bdnw.d("GameRuntime", "doOnPause blackTimeDuration " + l);
        }
      }
      if ((this.c) && (this.jdField_a_of_type_Long > 0L))
      {
        this.c = false;
        bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1016, "1");
        l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        if (l > 0L) {
          bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1020, null, null, null, 0, "1", l, null);
        }
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if ((l > 0L) && (this.jdField_a_of_type_Long > 0L)) {
        bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1021, null, null, null, 0, "1", l, null);
      }
      l = bdeg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
      if ((l >= 0L) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = true;
        bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 639, null, String.valueOf(l), null, 1, "1", 0L, null);
      }
      bdsx.a();
      return;
    }
  }
  
  private void j()
  {
    bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 22, "1");
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) {
      if ((b() == 0) || (b() == 1))
      {
        bdsx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "load_fail", "loading_page_kill");
        bdsc.a("2launch_fail", "loading_page_kill", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      }
    }
    for (;;)
    {
      bdsx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "unload", null);
      bdsc.a("2unload", null, null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      bdsx.a();
      return;
      bdnw.d("GameRuntime", "doOnDestroy kill self gameConfig=null");
    }
  }
  
  private void k()
  {
    if (bdhg.a("MiniGame", "MiniGameKillAllGamesWhenDestroy", 1) != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.removeFPSCallback(this.jdField_a_of_type_ComTencentMobileqqTritonSdkFPSCallback);
      return;
    }
    bdnw.b("GameRuntime", "[MiniEng]doOnDestroy killProcess");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GameRuntime.5(this), 300L);
  }
  
  private void l()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      a().getApplicationContext().registerComponentCallbacks(new bdpc(this));
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
  
  public bdcy a()
  {
    return a(1);
  }
  
  public bdda a()
  {
    return null;
  }
  
  public bdox a(int paramInt)
  {
    bdox localbdox = (bdox)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localbdox != null) {
      return localbdox;
    }
    try
    {
      localbdox = new bdox(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getJsRuntime(paramInt), paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localbdox);
      return localbdox;
    }
    finally {}
  }
  
  public CapsuleButton a()
  {
    return this.jdField_a_of_type_Bdoy.a();
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.handleFocusGain();
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_Bdoy.a(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bdoy.a(paramActivity, paramViewGroup);
  }
  
  public void a(ITTEngine paramITTEngine)
  {
    l();
    this.jdField_a_of_type_Bdow = new bdow(this);
    b(paramITTEngine);
    this.jdField_a_of_type_Bdoy = new bdoy(paramITTEngine);
    this.jdField_a_of_type_Bdoy.a(this);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    paramMiniAppInfo = (bdfx)paramMiniAppInfo.apkgInfo;
    paramMiniAppInfo.a = new bdml();
    paramMiniAppInfo.a.a = new bdmz();
    paramMiniAppInfo.a.a.jdField_a_of_type_Int = 60000;
    paramMiniAppInfo.a.a.b = 60000;
    paramMiniAppInfo.a.a.d = 60000;
    paramMiniAppInfo.a.a.c = 60000;
    a(this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, false);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    h();
    this.jdField_a_of_type_Bdoy.b(paramMiniAppInfo);
    this.jdField_a_of_type_Bdow.a();
    this.jdField_a_of_type_Bdsg.b();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.f = true;
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
    this.jdField_a_of_type_Bdow.onCreate(a());
    this.jdField_a_of_type_Bdoy.a(paramMiniAppInfo);
    this.jdField_a_of_type_Bdsg.a(paramMiniAppInfo);
    g();
  }
  
  public void c()
  {
    try
    {
      i();
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onPause();
      this.b = false;
      this.f = false;
      this.jdField_a_of_type_Bdoy.a();
      this.jdField_a_of_type_Bdow.b();
      this.jdField_a_of_type_Bdsg.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bdnw.d("GameRuntime", "doOnPause reportOnPause ", localThrowable);
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
    return this.jdField_a_of_type_Bdoy.b();
  }
  
  public void e()
  {
    k();
    this.jdField_a_of_type_Bdoy.b();
    this.jdField_a_of_type_Bdow.onDestroy();
    j();
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
    if (!this.f)
    {
      bdsx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "load_fail", "not_foreground");
      bdsc.a("2launch_fail", "not_foreground", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      bdnw.d("GameRuntime", "not in forground, donot lauchGame");
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new GameRuntime.7(this));
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Bdoy.a();
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    do
    {
      return true;
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new GameRuntime.4(this));
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) {
        break;
      }
      if (b() == 0)
      {
        bdsx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "load_fail", "loading_page_back_press");
        return true;
      }
    } while (b() != 1);
    bdsx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "show_fail", "loading_page_back_press");
    return true;
    bdnw.d("GameRuntime", "doOnBackPressed gameConfig=null");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdoz
 * JD-Core Version:    0.7.0.1
 */