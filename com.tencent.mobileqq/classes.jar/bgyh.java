import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

final class bgyh
  extends MiniCmdCallback.Stub
{
  bgyh(MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    QMLog.d("ApkgMainProcessManager", "removeSubProcessLoadTask() called with: miniAppConfig = [" + this.a + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyh
 * JD-Core Version:    0.7.0.1
 */