import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IAppUpdateListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class bjdz
  implements IActivityResultListener
{
  bjdz(bjdt parambjdt, IActivityResultManager paramIActivityResultManager, MiniAppProxy.IAppUpdateListener paramIAppUpdateListener) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
    boolean bool;
    if (paramInt1 == 1003)
    {
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break label89;
      }
      bool = paramIntent.getBooleanExtra("getUpgradeInfo", true);
      if (!bool) {
        break label57;
      }
      paramIntent = "最新版本无需更新";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMiniAppProxy$IAppUpdateListener.onGetAppUpdateResult(bool, paramIntent);
      return true;
      label57:
      paramIntent = "获取版本信息失败";
      QLog.d("MiniAppProxyImpl", 1, "getUpgradeInfo: " + bool);
    }
    label89:
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMiniAppProxy$IAppUpdateListener.onGetAppUpdateResult(true, "版本过低需要更新");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjdz
 * JD-Core Version:    0.7.0.1
 */