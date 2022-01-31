import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.log.QMLog;

final class bgty
  extends MiniCmdCallback.Stub
{
  bgty(MiniCmdCallback paramMiniCmdCallback, boolean paramBoolean) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcMiniCmdCallback != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcMiniCmdCallback.onCmdResult(paramBoolean, paramBundle);
    }
    if ((this.jdField_a_of_type_Boolean) || (paramBoolean)) {
      QMLog.d("ApkgMainProcessManager", "onCmdResult() called with: succ = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgty
 * JD-Core Version:    0.7.0.1
 */