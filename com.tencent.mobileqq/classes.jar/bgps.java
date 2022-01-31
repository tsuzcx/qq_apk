import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.log.QMLog;

class bgps
  implements bgrp
{
  bgps(bgpr parambgpr, MiniCmdCallback paramMiniCmdCallback, String paramString) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcMiniCmdCallback == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1)) {
      try
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcMiniCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
      catch (Exception localException)
      {
        QMLog.e("MiniAppCmdServlet", "cmd response exception. cmd=" + this.jdField_a_of_type_JavaLangString, localException);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcMiniCmdCallback.onCmdResult(false, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgps
 * JD-Core Version:    0.7.0.1
 */