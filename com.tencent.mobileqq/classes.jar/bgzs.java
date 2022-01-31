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

@bglp(a="TritonEngineInitTask")
public class bgzs
  extends bhlt
{
  private bgyz jdField_a_of_type_Bgyz;
  private bgzf jdField_a_of_type_Bgzf;
  private APIProxy jdField_a_of_type_ComTencentMobileqqTritonSdkAPIProxy;
  private IQQEnv jdField_a_of_type_ComTencentMobileqqTritonSdkIQQEnv;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private InstalledEngine jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine;
  public final String a;
  private int b;
  
  public bgzs(Context paramContext, bgun parambgun, bgzf parambgzf, IQQEnv paramIQQEnv, APIProxy paramAPIProxy)
  {
    super(paramContext, parambgun);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = toString();
    bhaj.a().i(this.jdField_a_of_type_JavaLangString, "new TritonEngineInitTask");
    this.jdField_a_of_type_Bgzf = parambgzf;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkIQQEnv = paramIQQEnv;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPIProxy = paramAPIProxy;
    this.jdField_a_of_type_Bgyz = new bgyz();
  }
  
  private int a(InstalledEngine paramInstalledEngine)
  {
    for (;;)
    {
      try
      {
        bhck.a(bhcg.a(), 1014, "1");
        if (paramInstalledEngine == null)
        {
          bhaj.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng] installedEngine == null, loadEngineTask is reset?");
          i = 105;
          return i;
        }
        Object localObject1 = new TTEngineBuilder();
        ((TTEngineBuilder)localObject1).setApiProxy(this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPIProxy).setQQEnv(this.jdField_a_of_type_ComTencentMobileqqTritonSdkIQQEnv).setDiskIoExecutor(new bgzt(this)).setLog(bhaj.a()).setSoLoader(new bhak(paramInstalledEngine));
        Object localObject2 = getClass().getClassLoader();
        if (a(paramInstalledEngine))
        {
          bhaj.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng] TTEngineBuilder create TTEngine from dex");
          bhck.a(bhcg.a(), 1003, "1");
          localObject2 = ((TTEngineBuilder)localObject1).createInstance(new MiniAppClassloader(a(paramInstalledEngine), this.jdField_a_of_type_AndroidContentContext.getApplicationInfo().nativeLibraryDir, getClass().getClassLoader()));
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            bhck.a(bhcg.a(), 1004, "1");
            localObject1 = localObject2;
          }
          if (localObject1 == null)
          {
            bhaj.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng] TTEngineBuilder create TTEngine return null");
            i = 106;
          }
        }
        else
        {
          bhaj.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng] TTEngineBuilder create TTEngine from local lib");
          localObject1 = ((TTEngineBuilder)localObject1).createInstance((ClassLoader)localObject2);
          continue;
        }
        this.jdField_a_of_type_Bgyz.a((ITTEngine)localObject1);
        long l = System.currentTimeMillis();
        bhaj.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng] initEngine");
        i = ((ITTEngine)localObject1).initEngine(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_Bgzf);
        if (i != 0)
        {
          bhaj.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng] initEngine fail");
          paramInstalledEngine.jdField_b_of_type_Int = 2;
          if (i == 1001) {
            i = 107;
          }
        }
        else
        {
          paramInstalledEngine.jdField_b_of_type_Int = 3;
          QMLog.e("[minigame][timecost] ", "[MiniEng] step[initTTEngine] cost time " + (System.currentTimeMillis() - l) + ", includes steps[load so, cache jssdk]");
          bhck.a(bhcg.a(), 1015, "1");
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
      if (bgpx.a("qqminiapp", "mini_app_google_play_load_so_switch", 0) == 1) {}
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
      bhaj.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy engine == null");
      return false;
    }
    if (paramMiniAppInfo == null)
    {
      bhaj.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy gameConfig == null");
      return false;
    }
    if (paramMiniAppInfo == null)
    {
      bhaj.a().e(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy info == null");
      return false;
    }
    paramMiniAppInfo = paramMiniAppInfo.baselibMiniVersion;
    bhaj.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy minVersion=" + paramMiniAppInfo);
    if (TextUtils.isEmpty(paramMiniAppInfo)) {
      return true;
    }
    paramMiniAppInfo = new EngineVersion(paramMiniAppInfo);
    if (paramInstalledEngine.a.a(paramMiniAppInfo) >= 0) {}
    for (;;)
    {
      bhaj.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng]isGameSatisfy minEngineVersion=" + paramMiniAppInfo + ",engineVersion=" + paramInstalledEngine.a + ",ret=" + bool);
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
        bhaj.a().w(this.jdField_a_of_type_JavaLangString, "[MiniEng] engine already loaded! status=" + this.jdField_b_of_type_Int);
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
      bhck.a(bhcg.a(), 1012, "1");
      if (this.jdField_b_of_type_Int != -1)
      {
        bhaj.a().w(this.jdField_a_of_type_JavaLangString, "[MiniEng] engine already loaded! status=" + this.jdField_b_of_type_Int);
        return;
      }
      this.jdField_b_of_type_Int = a(paramInstalledEngine);
      if (this.jdField_b_of_type_Int == 0)
      {
        c();
        return;
      }
      bhcn.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "load_fail", "load_baselib_fail");
      bhbs.a("2launch_fail", "load_baselib_fail", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      a(this.jdField_b_of_type_Int, "加载引擎失败");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId))) {
      bhbu.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, false);
    }
    a(104, "请升级QQ版本");
  }
  
  public ITTEngine a()
  {
    return this.jdField_a_of_type_Bgyz;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine == null)
    {
      bhaj.a().w(this.jdField_a_of_type_JavaLangString, "[MiniEng] Failed to start TritonEngineInitTask, installedEngine is null");
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
      bhaj.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng]" + this + " reset ");
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
 * Qualified Name:     bgzs
 * JD-Core Version:    0.7.0.1
 */