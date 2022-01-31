import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.minigame.task.InstalledEngineLoadTask.1;
import com.tencent.qqmini.sdk.minigame.utils.TTHandleThread;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

@bglp(a="InstalledEngineLoadTask")
public class bgzn
  extends bhlt
  implements bgvz
{
  private EngineChannel jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel;
  private InstalledEngine jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine;
  private final String jdField_a_of_type_JavaLangString = "[MiniEng]" + toString();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int b;
  private int c;
  
  public bgzn(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
    bhaj.a().i(this.jdField_a_of_type_JavaLangString, "new InstalledEngineLoadTask");
  }
  
  private String a(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = new File(paramString);
    if (((File)localObject).exists()) {}
    for (;;)
    {
      try
      {
        localObject = bham.a((File)localObject);
        if (localObject == null) {
          continue;
        }
      }
      catch (IOException localIOException)
      {
        str = "";
        continue;
      }
      bhaj.a().d(this.jdField_a_of_type_JavaLangString, "[MiniEng] calcMD5 " + paramString + ", md5:" + (String)localObject + ", cost:" + (System.currentTimeMillis() - l));
      return localObject;
      localObject = "";
      continue;
      String str = "";
    }
  }
  
  private boolean a(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine == null) || (TextUtils.isEmpty(paramInstalledEngine.jdField_b_of_type_JavaLangString))) {
      return false;
    }
    File localFile = new File(paramInstalledEngine.jdField_b_of_type_JavaLangString);
    if ((!localFile.exists()) || (localFile.isFile())) {
      return false;
    }
    boolean bool;
    try
    {
      localObject1 = new File(localFile, "verify.json");
      if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
        break label134;
      }
      bhaj.a().i(this.jdField_a_of_type_JavaLangString, "verifyEngine " + paramInstalledEngine + " has no verify.json, skip!");
      return true;
    }
    catch (Throwable paramInstalledEngine)
    {
      bhaj.a().e(this.jdField_a_of_type_JavaLangString, "verifyEngine exception.", paramInstalledEngine);
      bool = false;
    }
    return bool;
    label134:
    Object localObject1 = bgpc.b((File)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      bhaj.a().i(this.jdField_a_of_type_JavaLangString, "verifyEngine " + paramInstalledEngine + " verify.json has no content, skip!");
      return true;
    }
    if (QMLog.isColorLevel()) {
      bhaj.a().d(this.jdField_a_of_type_JavaLangString, "verifyEngine " + paramInstalledEngine + " content:" + (String)localObject1);
    }
    localObject1 = new JSONObject((String)localObject1);
    if (!((JSONObject)localObject1).has("verify_list"))
    {
      bhaj.a().i(this.jdField_a_of_type_JavaLangString, "verifyEngine " + paramInstalledEngine + " verify.json has no verify_list, skip!");
      return true;
    }
    paramInstalledEngine = ((JSONObject)localObject1).getJSONArray("verify_list");
    int i = 0;
    for (;;)
    {
      if (i < paramInstalledEngine.length())
      {
        if (paramInstalledEngine.get(i) == null)
        {
          bhaj.a().e(this.jdField_a_of_type_JavaLangString, "配置文件格式异常！！请使用json工具检测");
          break label621;
        }
        Object localObject3 = (JSONObject)paramInstalledEngine.get(i);
        localObject1 = ((JSONObject)localObject3).optString("name");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label621;
        }
        Object localObject2 = new File(localFile, (String)localObject1);
        if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile()))
        {
          bhaj.a().w(this.jdField_a_of_type_JavaLangString, "verifyEngine file " + (String)localObject1 + " not found");
          bool = false;
          break;
        }
        int j = ((JSONObject)localObject3).optInt("length");
        if ((j > 0) && (((File)localObject2).length() != j))
        {
          bhaj.a().w(this.jdField_a_of_type_JavaLangString, "verifyEngine file " + (String)localObject1 + " length fail, config_length:" + j + ", local_length:" + ((File)localObject2).length());
          bool = false;
          break;
        }
        localObject3 = ((JSONObject)localObject3).optString("md5");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label621;
        }
        localObject2 = a(((File)localObject2).getAbsolutePath());
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject3).equalsIgnoreCase((String)localObject2))) {
          break label621;
        }
        bhaj.a().w(this.jdField_a_of_type_JavaLangString, "verifyEngine file " + (String)localObject1 + " md5 fail, config_md5:" + (String)localObject3 + ", local_md5:" + (String)localObject2);
        bool = false;
        break;
      }
      bool = true;
      break;
      label621:
      i += 1;
    }
  }
  
  private InstalledEngine b()
  {
    InstalledEngine localInstalledEngine = new InstalledEngine();
    localInstalledEngine.jdField_a_of_type_Int = 2;
    localInstalledEngine.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion = EngineVersion.a(b() + "_" + "1.14.0.00225");
    localInstalledEngine.jdField_b_of_type_JavaLangString = "";
    localInstalledEngine.jdField_a_of_type_Boolean = true;
    localInstalledEngine.jdField_b_of_type_Boolean = true;
    localInstalledEngine.jdField_a_of_type_JavaLangString = "MiniGame-Default";
    bhaj.a().i(this.jdField_a_of_type_JavaLangString, "generateDefaultEngine, " + localInstalledEngine);
    return localInstalledEngine;
  }
  
  private static String b()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    paramBundle.putInt("baseLibType", 2);
    paramBundle.putInt("enginePid", Process.myPid());
    bhaj.a().i(this.jdField_a_of_type_JavaLangString, "installEngineRequestCount, " + this.b + " upgradeEngineRequestCount, " + this.c + "," + paramInt);
    if (paramInt == 5) {
      this.c += 1;
    }
    if (paramInt == 3) {
      this.b += 1;
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel != null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(paramInt, paramBundle);
      return;
    }
    bhaj.a().w(this.jdField_a_of_type_JavaLangString, "failed sendCommand mEngineChannel is null");
  }
  
  private void d()
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
    TTHandleThread.a().a(new InstalledEngineLoadTask.1(this), 100L);
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
      bhaj.a().e(this.jdField_a_of_type_JavaLangString, "getInstalledEnginePath failed, engine:" + localInstalledEngine + DebugUtil.getStackTrace());
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    if (this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel == null)
    {
      h();
      return;
    }
    d();
    h();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    bhaj.a().i(this.jdField_a_of_type_JavaLangString, "onReceiveData what=" + paramInt);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramInt == 55) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    }
    Object localObject;
    if (paramInt == 51) {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getParcelableArrayList("installedEngineList");
        if (paramBundle != null)
        {
          bhaj.a().i(this.jdField_a_of_type_JavaLangString, "getInstalledEngineList success " + paramBundle.size());
          paramBundle = paramBundle.iterator();
          if (paramBundle.hasNext())
          {
            localObject = (InstalledEngine)paramBundle.next();
            if (a((InstalledEngine)localObject))
            {
              this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine = ((InstalledEngine)localObject);
              bhaj.a().i(this.jdField_a_of_type_JavaLangString, "verifyEngine " + localObject + " success, break");
            }
          }
          else
          {
            label193:
            if (this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine == null) {
              break label340;
            }
            bhaj.a().i(this.jdField_a_of_type_JavaLangString, "get InstalledEngine success:" + this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine);
            c();
          }
        }
      }
    }
    label340:
    do
    {
      do
      {
        return;
        bhaj.a().w(this.jdField_a_of_type_JavaLangString, "verifyEngine " + localObject + " fail, check next one");
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("invalidEngine", (Parcelable)localObject);
        b(56, localBundle);
        break;
        bhaj.a().i(this.jdField_a_of_type_JavaLangString, "getInstalledEngineList gameEngineList is null");
        break label193;
        bhaj.a().i(this.jdField_a_of_type_JavaLangString, "getInstalledEngineList data is null");
        break label193;
        if (this.b < 2)
        {
          bhaj.a().i(this.jdField_a_of_type_JavaLangString, "no engine installed, send cmd WHAT_INSTALL_LATEST_ENGINE");
          b(3, new Bundle());
          return;
        }
        bhaj.a().i(this.jdField_a_of_type_JavaLangString, "no engine installed but installEngineRequestCount reaches max 2");
        this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine = b();
        c();
        return;
        if (paramInt == 52)
        {
          bhaj.a().i(this.jdField_a_of_type_JavaLangString, "EVENT_INSTALL_LATEST_ENGINE_BEGIN");
          return;
        }
        if (paramInt != 53) {
          break label531;
        }
      } while (paramBundle == null);
      localObject = paramBundle.getString("engineInstallerMessage");
      float f = paramBundle.getFloat("engineInstallerProgress");
      bhaj.a().i(this.jdField_a_of_type_JavaLangString, "EVENT_INSTALL_LATEST_ENGINE_PROCESS, message:" + (String)localObject + ", progress:" + f);
      paramBundle = new bgzy().a((String)localObject).a(f).a();
      a().notifyRuntimeEvent(2011, new Object[] { paramBundle });
      return;
    } while (paramInt != 54);
    label531:
    bhaj.a().i(this.jdField_a_of_type_JavaLangString, "EVENT_INSTALL_LATEST_ENGINE_FINISH");
    b(1, new Bundle());
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel = paramEngineChannel;
  }
  
  public void b()
  {
    try
    {
      bhaj.a().i(this.jdField_a_of_type_JavaLangString, "[MiniEng]" + this + " reset ");
      this.b = 0;
      this.c = 0;
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine = null;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = null;
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
 * Qualified Name:     bgzn
 * JD-Core Version:    0.7.0.1
 */