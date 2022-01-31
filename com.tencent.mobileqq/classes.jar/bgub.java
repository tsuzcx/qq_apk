import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class bgub
  implements bgrh
{
  bgub(bgtx parambgtx, MiniAppInfo paramMiniAppInfo) {}
  
  public void onInitApkgInfo(int paramInt, bgjw parambgjw, String paramString)
  {
    QMLog.d("ApkgMainProcessManager", "onInitApkgInfo load apkg in main process end " + parambgjw);
    parambgjw = (List)bgtx.a(this.jdField_a_of_type_Bgtx).remove(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
    if (parambgjw != null)
    {
      parambgjw = parambgjw.iterator();
      while (parambgjw.hasNext())
      {
        paramString = (MiniCmdCallback)parambgjw.next();
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
 * Qualified Name:     bgub
 * JD-Core Version:    0.7.0.1
 */