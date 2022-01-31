import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.TTEngineBuilder;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.MiniAppClassloader;
import java.io.File;

@bghi(a="TritonEngineInitTask")
public class bgvl
  extends bhhm
{
  private bgus jdField_a_of_type_Bgus;
  private bguy jdField_a_of_type_Bguy;
  private APIProxy jdField_a_of_type_ComTencentMobileqqTritonSdkAPIProxy;
  private IQQEnv jdField_a_of_type_ComTencentMobileqqTritonSdkIQQEnv;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private InstalledEngine jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine;
  public final String a;
  private int b;
  
  public bgvl(Context paramContext, bgqg parambgqg, bguy parambguy, IQQEnv paramIQQEnv, APIProxy paramAPIProxy)
  {
    super(paramContext, parambgqg);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = toString();
    bgwc.a().i(this.jdField_a_of_type_JavaLangString, "new TritonEngineInitTask");
    this.jdField_a_of_type_Bguy = parambguy;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkIQQEnv = paramIQQEnv;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPIProxy = paramAPIProxy;
    this.jdField_a_of_type_Bgus = new bgus();
  }
  
  private int a(InstalledEngine paramInstalledEngine)
  {
    for (;;)
    {
      try
      {
        bgyd.a(bgxz.a(), 1014, "1");
        if (paramInstalledEngine == null)
        {
          bgwc.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng] installedEngine == null, loadEngineTask is reset?");
          i = 105;
          return i;
        }
        Object localObject1 = new TTEngineBuilder();
        ((TTEngineBuilder)localObject1).setApiProxy(this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPIProxy).setQQEnv(this.jdField_a_of_type_ComTencentMobileqqTritonSdkIQQEnv).setDiskIoExecutor(new bgvm(this)).setLog(bgwc.a()).setSoLoader(new bgwd(paramInstalledEngine));
        Object localObject2 = getClass().getClassLoader();
        if (a(paramInstalledEngine))
        {
          bgwc.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng] TTEngineBuilder create TTEngine from dex");
          bgyd.a(bgxz.a(), 1003, "1");
          localObject2 = ((TTEngineBuilder)localObject1).createInstance(new MiniAppClassloader(a(paramInstalledEngine), this.jdField_a_of_type_AndroidContentContext.getApplicationInfo().nativeLibraryDir, getClass().getClassLoader()));
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            bgyd.a(bgxz.a(), 1004, "1");
            localObject1 = localObject2;
          }
          if (localObject1 == null)
          {
            bgwc.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng] TTEngineBuilder create TTEngine return null");
            i = 106;
          }
        }
        else
        {
          bgwc.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng] TTEngineBuilder create TTEngine from local lib");
          localObject1 = ((TTEngineBuilder)localObject1).createInstance((ClassLoader)localObject2);
          continue;
        }
        this.jdField_a_of_type_Bgus.a((ITTEngine)localObject1);
        long l = System.currentTimeMillis();
        bgwc.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng] initEngine");
        i = ((ITTEngine)localObject1).initEngine(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_Bguy);
        if (i != 0)
        {
          bgwc.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng] initEngine fail");
          paramInstalledEngine.jdField_b_of_type_Int = 2;
          if (i == 1001) {
            i = 107;
          }
        }
        else
        {
          paramInstalledEngine.jdField_b_of_type_Int = 3;
          QMLog.e("[minigame][timecost] ", "[MiniEng] step[initTTEngine] cost time " + (System.currentTimeMillis() - l) + ", includes steps[load so, cache jssdk]");
          bgyd.a(bgxz.a(), 1015, "1");
          i = 0;
          continue;
        }
        if (i != 2001) {
          break label391;
        }
      }
      finally {}
      int i = 108;
      continue;
      label391:
      i = 109;
    }
  }
  
  private String a(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine == null) || (TextUtils.isEmpty(paramInstalledEngine.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramInstalledEngine.jdField_b_of_type_JavaLangString);
    if (paramInstalledEngine.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
    for (paramInstalledEngine = "";; paramInstalledEngine = File.separator) {
      return paramInstalledEngine + "triton.jar";
    }
  }
  
  private boolean a(InstalledEngine paramInstalledEngine)
  {
    if (!GameWnsUtils.gameEnableDexLoader()) {
      return false;
    }
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localChannelProxy != null) && (localChannelProxy.isGooglePlayVersion()))
    {
      if (bglq.a("qqminiapp", "mini_app_google_play_load_so_switch", 0) == 1) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
    }
    paramInstalledEngine = a(paramInstalledEngine);
    if (TextUtils.isEmpty(paramInstalledEngine)) {
      return false;
    }
    return new File(paramInstalledEngine).exists();
  }
  
  private boolean a(InstalledEngine paramInstalledEngine, MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (paramInstalledEngine == null)
    {
      bgwc.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy engine == null");
      return false;
    }
    if (paramMiniAppInfo == null)
    {
      bgwc.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy gameConfig == null");
      return false;
    }
    if (paramMiniAppInfo == null)
    {
      bgwc.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy info == null");
      return false;
    }
    paramMiniAppInfo = paramMiniAppInfo.baselibMiniVersion;
    bgwc.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy minVersion=" + paramMiniAppInfo);
    if (TextUtils.isEmpty(paramMiniAppInfo)) {
      return true;
    }
    paramMiniAppInfo = new EngineVersion(paramMiniAppInfo);
    if (paramInstalledEngine.a.a(paramMiniAppInfo) >= 0) {}
    for (;;)
    {
      bgwc.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy minEngineVersion=" + paramMiniAppInfo + ",engineVersion=" + paramInstalledEngine.a + ",ret=" + bool);
      return bool;
      bool = false;
    }
  }
  
  private void b(InstalledEngine paramInstalledEngine)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null)
    {
      if (this.jdField_b_of_type_Int != -1)
      {
        bgwc.a().w(this.jdField_a_of_type_JavaLangString, "[MiniEng] engine already loaded! status=" + this.jdField_b_of_type_Int);
        return;
      }
      this.jdField_b_of_type_Int = a(paramInstalledEngine);
      if (this.jdField_b_of_type_Int == 0)
      {
        c();
        return;
      }
      a(this.jdField_b_of_type_Int, "加载引擎失败");
      return;
    }
    if (a(paramInstalledEngine, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo))
    {
      bgyd.a(bgxz.a(), 1012, "1");
      if (this.jdField_b_of_type_Int != -1)
      {
        bgwc.a().w(this.jdField_a_of_type_JavaLangString, "[MiniEng] engine already loaded! status=" + this.jdField_b_of_type_Int);
        return;
      }
      this.jdField_b_of_type_Int = a(paramInstalledEngine);
      if (this.jdField_b_of_type_Int == 0)
      {
        c();
        return;
      }
      bgyg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "load_fail", "load_baselib_fail");
      bgxl.a("2launch_fail", "load_baselib_fail", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      a(this.jdField_b_of_type_Int, "加载引擎失败");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId))) {
      bgxn.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, false);
    }
    a(104, "请升级QQ版本");
  }
  
  public ITTEngine a()
  {
    return this.jdField_a_of_type_Bgus;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine == null)
    {
      bgwc.a().w(this.jdField_a_of_type_JavaLangString, "[MiniEng] Failed to start TritonEngineInitTask, installedEngine is null");
      e();
      return;
    }
    b(this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void a(InstalledEngine paramInstalledEngine)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine = paramInstalledEngine;
  }
  
  public void b()
  {
    try
    {
      bgwc.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng]" + this + " reset ");
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = null;
      this.jdField_b_of_type_Int = -1;
      super.b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvl
 * JD-Core Version:    0.7.0.1
 */