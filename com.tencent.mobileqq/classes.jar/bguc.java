import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class bguc
  implements bgum
{
  bguc(bgtx parambgtx, MiniAppInfo paramMiniAppInfo) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    Object localObject = (List)bgtx.a(this.jdField_a_of_type_Bgtx).get(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
    if (localObject != null)
    {
      paramMiniAppInfo = new Bundle();
      paramMiniAppInfo.putFloat("PROGRESS", paramFloat);
      paramMiniAppInfo.putLong("TOTAL_SIZE", paramLong);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MiniCmdCallback localMiniCmdCallback = (MiniCmdCallback)((Iterator)localObject).next();
        if (localMiniCmdCallback != null) {
          try
          {
            localMiniCmdCallback.onCmdResult(false, paramMiniAppInfo);
          }
          catch (RemoteException localRemoteException) {}
        }
      }
    }
  }
  
  public void onInitGpkgInfo(int paramInt, bgun parambgun, String paramString)
  {
    QMLog.d("ApkgMainProcessManager", "onInitGpkgInfo load gpkg in main process end " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    parambgun = (List)bgtx.a(this.jdField_a_of_type_Bgtx).remove(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
    if (parambgun != null)
    {
      parambgun = parambgun.iterator();
      while (parambgun.hasNext())
      {
        paramString = (MiniCmdCallback)parambgun.next();
        if (paramString != null) {
          try
          {
            paramString.onCmdResult(true, new Bundle());
          }
          catch (RemoteException paramString) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bguc
 * JD-Core Version:    0.7.0.1
 */