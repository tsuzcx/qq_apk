import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class bgtx
{
  private static final bgtx jdField_a_of_type_Bgtx = new bgtx();
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.newSetFromMap(new ConcurrentHashMap());
  private ConcurrentHashMap<String, List<MiniCmdCallback>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static bgtx a()
  {
    return jdField_a_of_type_Bgtx;
  }
  
  private void a(Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramBundle.getParcelable("key_mini_app_config");
    boolean bool = paramBundle.getBoolean("key_run_in_mainprocess", false);
    if (localMiniAppInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localMiniAppInfo.appId) != null)
    {
      ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localMiniAppInfo.appId)).add(paramMiniCmdCallback);
      return;
    }
    if (!bool) {
      try
      {
        paramMiniCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilSet.contains(localMiniAppInfo.appId))
    {
      QMLog.w("ApkgMainProcessManager", "pkg already download in sub process! " + localMiniAppInfo);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localMiniAppInfo.appId, new CopyOnWriteArrayList(Collections.singletonList(paramMiniCmdCallback)));
    QMLog.d("ApkgMainProcessManager", "load apkg in main process start " + localMiniAppInfo);
    if (localMiniAppInfo.isEngineTypeMiniGame())
    {
      d(localMiniAppInfo);
      return;
    }
    c(localMiniAppInfo);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppInfo);
    bgpn.a().a("cmd_queue_mini_process_load_apkg", localBundle, new bgtz(paramMiniAppInfo));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, MiniCmdCallback paramMiniCmdCallback, boolean paramBoolean)
  {
    if (!paramMiniAppInfo.isEngineTypeMiniGame()) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramMiniAppInfo, paramMiniCmdCallback, paramBoolean, bool);
      return;
    }
  }
  
  private static void a(MiniAppInfo paramMiniAppInfo, MiniCmdCallback paramMiniCmdCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppInfo);
    localBundle.putBoolean("key_run_in_mainprocess", paramBoolean1);
    bgpn.a().a("cmd_main_process_load_pkg", localBundle, new bgty(paramMiniCmdCallback, paramBoolean2));
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
    }
  }
  
  public static void a(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    try
    {
      paramBundle.setClassLoader(bgtx.class.getClassLoader());
      localMiniAppInfo = (MiniAppInfo)paramBundle.getParcelable("key_mini_app_config");
      if (localMiniAppInfo == null) {
        return;
      }
      if ("cmd_queue_mini_process_load_apkg".equals(paramString))
      {
        a().a(localMiniAppInfo.appId);
        return;
      }
    }
    catch (Throwable paramString)
    {
      MiniAppInfo localMiniAppInfo;
      QMLog.d("ApkgMainProcessManager", "handleMiniAppCmd ", paramString);
      if (paramMiniCmdCallback != null)
      {
        try
        {
          paramMiniCmdCallback.onCmdResult(true, new Bundle());
          return;
        }
        catch (RemoteException paramString)
        {
          QMLog.d("ApkgMainProcessManager", "handleMiniAppCmd ", paramString);
          return;
        }
        if ("cmd_remove_mini_process_load_apkg".equals(paramString))
        {
          a().b(localMiniAppInfo.appId);
          return;
        }
        if ("cmd_main_process_load_pkg".equals(paramString))
        {
          a().a(paramBundle, paramMiniCmdCallback);
          return;
        }
        boolean bool = "cmd_main_process_download_pkg".equals(paramString);
        if (!bool) {}
      }
    }
  }
  
  public static void b(MiniAppInfo paramMiniAppInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppInfo);
    bgpn.a().a("cmd_remove_mini_process_load_apkg", localBundle, new bgua(paramMiniAppInfo));
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
  }
  
  private void c(MiniAppInfo paramMiniAppInfo)
  {
    bgrb.a().a(paramMiniAppInfo, new bgub(this, paramMiniAppInfo));
  }
  
  private void d(MiniAppInfo paramMiniAppInfo)
  {
    bgud.b(paramMiniAppInfo, new bguc(this, paramMiniAppInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtx
 * JD-Core Version:    0.7.0.1
 */