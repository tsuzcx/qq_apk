import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class bgyi
  implements bgvo
{
  bgyi(bgye parambgye, MiniAppInfo paramMiniAppInfo) {}
  
  public void onInitApkgInfo(int paramInt, bgod parambgod, String paramString)
  {
    QMLog.d("ApkgMainProcessManager", "onInitApkgInfo load apkg in main process end " + parambgod);
    parambgod = (List)bgye.a(this.jdField_a_of_type_Bgye).remove(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
    if (parambgod != null)
    {
      parambgod = parambgod.iterator();
      while (parambgod.hasNext())
      {
        paramString = (MiniCmdCallback)parambgod.next();
        if (paramString != null) {
          try
          {
            paramString.onCmdResult(true, new Bundle());
          }
          catch (RemoteException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyi
 * JD-Core Version:    0.7.0.1
 */