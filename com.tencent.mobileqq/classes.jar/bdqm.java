import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.TTEngineBuilder;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.minigame.task.GameEngineLoadTask.1;
import com.tencent.qqmini.sdk.minigame.utils.TTHandleThread;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@bdcu(a="GameEngineLoadTask")
public class bdqm
  extends bdxy
  implements bdoh
{
  private bdpz jdField_a_of_type_Bdpz = new bdpz();
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private EngineChannel jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel;
  private InstalledEngine jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public volatile boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  
  public bdqm(Context paramContext, bdlq parambdlq)
  {
    super(paramContext, parambdlq);
  }
  
  private int a(InstalledEngine paramInstalledEngine)
  {
    for (;;)
    {
      try
      {
        bdsu.a(bddc.a(), 1014, "1");
        if (paramInstalledEngine == null)
        {
          bdrb.a().e("EngineLoadTask", "[MiniEng] installedEngine == null, loadEngineTask is reset?");
          i = 105;
          return i;
        }
        Object localObject1 = new TTEngineBuilder();
        ((TTEngineBuilder)localObject1).setApiProxy(new bdpe(this.jdField_a_of_type_Bdpz)).setQQEnv(new bdpl()).setDiskIoExecutor(new bdqo(this)).setLog(bdrb.a()).setSoLoader(new bdrc(paramInstalledEngine));
        Object localObject2 = getClass().getClassLoader();
        if (a())
        {
          bdrb.a().i("EngineLoadTask", "[MiniEng] TTEngineBuilder create TTEngine from dex");
          bdsu.a(bddc.a(), 1003, "1");
          localObject2 = ((TTEngineBuilder)localObject1).createInstance(new bdyy(b(), this.jdField_a_of_type_AndroidContentContext.getApplicationInfo().nativeLibraryDir, getClass().getClassLoader()));
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            bdsu.a(bddc.a(), 1004, "1");
            localObject1 = localObject2;
          }
          this.jdField_a_of_type_Bdpz.a((ITTEngine)localObject1);
          if (localObject1 == null)
          {
            bdrb.a().e("EngineLoadTask", "[MiniEng] TTEngineBuilder create TTEngine return null");
            i = 106;
          }
        }
        else
        {
          bdrb.a().i("EngineLoadTask", "[MiniEng] TTEngineBuilder create TTEngine from local lib");
          localObject1 = ((TTEngineBuilder)localObject1).createInstance((ClassLoader)localObject2);
          continue;
        }
        long l = System.currentTimeMillis();
        bdrb.a().i("EngineLoadTask", "[MiniEng] initEngine");
        i = ((ITTEngine)localObject1).initEngine(this.jdField_a_of_type_AndroidContentContext, null, null);
        if (i != 0)
        {
          bdrb.a().e("EngineLoadTask", "[MiniEng] initEngine fail");
          paramInstalledEngine.jdField_b_of_type_Int = 2;
          if (i == 1001) {
            i = 107;
          }
        }
        else
        {
          paramInstalledEngine.jdField_b_of_type_Int = 3;
          bdnw.d("[minigame][timecost] ", "[MiniEng] step[initTTEngine] cost time " + (System.currentTimeMillis() - l) + ", includes steps[load so, cache jssdk]");
          bdsu.a(bddc.a(), 1015, "1");
          i = 0;
          continue;
        }
        if (i != 2001) {
          break label384;
        }
      }
      finally {}
      int i = 108;
      continue;
      label384:
      i = 109;
    }
  }
  
  private boolean a()
  {
    if (!bdrd.b()) {}
    while (TextUtils.isEmpty(a())) {
      return false;
    }
    return new File(b()).exists();
  }
  
  private boolean a(InstalledEngine paramInstalledEngine, MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (paramInstalledEngine == null)
    {
      bdrb.a().e("EngineLoadTask", "[MiniEng]isGameSatisfy engine == null");
      return false;
    }
    if (paramMiniAppInfo == null)
    {
      bdrb.a().e("EngineLoadTask", "[MiniEng]isGameSatisfy gameConfig == null");
      return false;
    }
    if (paramMiniAppInfo == null)
    {
      bdrb.a().e("EngineLoadTask", "[MiniEng]isGameSatisfy info == null");
      return false;
    }
    paramMiniAppInfo = paramMiniAppInfo.baselibMiniVersion;
    bdrb.a().i("EngineLoadTask", "[MiniEng]isGameSatisfy minVersion=" + paramMiniAppInfo);
    if (TextUtils.isEmpty(paramMiniAppInfo)) {
      return true;
    }
    paramMiniAppInfo = new EngineVersion(paramMiniAppInfo);
    if (paramInstalledEngine.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion.a(paramMiniAppInfo) >= 0) {}
    for (;;)
    {
      bdrb.a().i("EngineLoadTask", "[MiniEng]isGameSatisfy minEngineVersion=" + paramMiniAppInfo + ",engineVersion=" + paramInstalledEngine.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion + ",ret=" + bool);
      return bool;
      bool = false;
    }
  }
  
  private String b()
  {
    if (bdpl.b()) {}
    for (String str = "/sdcard/game/";; str = a()) {
      return str + "triton.jar";
    }
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    paramBundle.putInt("baseLibType", 2);
    paramBundle.putInt("enginePid", Process.myPid());
    bdrb.a().i("EngineLoadTask", "[MiniEng]installEngineRequestCount, " + this.jdField_b_of_type_Int + " upgradeEngineRequestCount, " + this.c + "," + paramInt);
    if (paramInt == 5) {
      this.c += 1;
    }
    if (paramInt == 3) {
      this.jdField_b_of_type_Int += 1;
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel != null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(paramInt, paramBundle);
      return;
    }
    bdrb.a().w("EngineLoadTask", "[MiniEng]" + this + "failed sendCommand mEngineChannel is null");
  }
  
  private void g()
  {
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.a("GameEngine(" + Process.myPid() + ")");
    localEngineChannel.a(this);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("engineChannel", localEngineChannel);
    b(1, localBundle);
  }
  
  private void h()
  {
    TTHandleThread.a().a(new GameEngineLoadTask.1(this), 100L);
  }
  
  public ITTEngine a()
  {
    return this.jdField_a_of_type_Bdpz;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public InstalledEngine a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine;
  }
  
  public String a()
  {
    InstalledEngine localInstalledEngine = a();
    if (localInstalledEngine != null)
    {
      if (localInstalledEngine.jdField_a_of_type_Boolean) {
        return localInstalledEngine.jdField_b_of_type_JavaLangString + "/";
      }
      bdrb.a().e("EngineLoadTask", "[MiniEng] getBaseEnginePath failed, engine:" + localInstalledEngine + bdyl.a());
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine = new InstalledEngine();
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine.jdField_b_of_type_JavaLangString = (MiniAppEnv.g().getContext().getFilesDir() + "/xminilib/1.0.0");
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine.jdField_a_of_type_JavaLangString = "MiniGame";
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion = new EngineVersion("8.2.0.1552", "1.8.4.01017");
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine.jdField_b_of_type_Boolean = false;
      this.d = a(this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine);
      if (this.d != 0) {
        break label154;
      }
      c();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      if (this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel != null) {
        break;
      }
      h();
      return;
      label154:
      a(this.d, "加载引擎失败");
    }
    g();
    h();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    bdrb.a().i("EngineLoadTask", "[MiniEng] onReceiveData what=" + paramInt);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramInt == 55) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    }
    if (paramInt == 51) {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getParcelableArrayList("installedEngineList");
        if (paramBundle != null)
        {
          paramInt = paramBundle.size();
          bdrb.a().i("EngineLoadTask", "[MiniEng] getInstalledEngineList success " + paramInt);
          if (paramInt > 0)
          {
            paramBundle = (InstalledEngine)paramBundle.get(0);
            if (a(paramBundle, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo))
            {
              this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine = paramBundle;
              bdsu.a(bddc.a(), 1012, "1");
              if (this.d != -1) {
                bdrb.a().w("EngineLoadTask", "[MiniEng] engine already loaded! status=" + this.d);
              }
            }
          }
        }
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
          this.d = a(this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine);
          if (this.d == 0)
          {
            c();
            return;
          }
          bdsx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "page_view", "load_fail", "load_baselib_fail", "");
          bdsc.a("2launch_fail", "load_baselib_fail", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
          a(this.d, "加载引擎失败");
          return;
          if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId))) {
            bdse.c(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, false);
          }
          bdrb.a().i("EngineLoadTask", "[MiniEng] engine version is too low, send cmd WHAT_UPGRADE_ENGINE");
          if (this.c >= 1)
          {
            bdrb.a().i("EngineLoadTask", "[MiniEng]upgradeEngineRequestCount reaches max 1");
            a(104, "请升级QQ版本");
            return;
          }
          b(5, new Bundle());
          return;
          if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId))) {
            bdse.c(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, false);
          }
          bdrb.a().i("EngineLoadTask", "[MiniEng] no engine installed, send cmd WHAT_INSTALL_LATEST_ENGINE");
          if (this.jdField_b_of_type_Int >= 2)
          {
            bdrb.a().i("EngineLoadTask", "[MiniEng]installEngineRequestCount reaches max 2");
            a(103, "加载引擎超时");
            return;
          }
          b(3, new Bundle());
          return;
          bdrb.a().i("EngineLoadTask", "[MiniEng] getInstalledEngineList gameEngineList is null");
          a(102, "获取引擎信息失败");
          return;
          bdrb.a().i("EngineLoadTask", "[MiniEng] getInstalledEngineList data is null");
          a(102, "获取引擎信息失败");
          return;
          if (paramInt == 52)
          {
            bdrb.a().i("EngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_BEGIN");
            return;
          }
          if (paramInt != 53) {
            break;
          }
        } while (paramBundle == null);
        str = paramBundle.getString("engineInstallerMessage");
        paramBundle.getFloat("engineInstallerProgress");
        bdrb.a().i("EngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_PROCESS " + str + ",allowPostProgress:" + this.jdField_a_of_type_Boolean);
      } while (!this.jdField_a_of_type_Boolean);
      a().notifyRuntimeEvent(2011, new Object[] { str });
      return;
    } while (paramInt != 54);
    bdrb.a().i("EngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_FINISH");
    b(1, new Bundle());
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel = paramEngineChannel;
  }
  
  public void b()
  {
    try
    {
      bdrb.a().i("EngineLoadTask", "[MiniEng]" + this + " reset ");
      this.jdField_b_of_type_Int = 0;
      this.c = 0;
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = null;
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = null;
      this.d = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqm
 * JD-Core Version:    0.7.0.1
 */