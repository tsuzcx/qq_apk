import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

class aqal
  implements aqac
{
  aqal(aqak paramaqak) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    QLog.d("FlutterMainQIPCModule", 1, String.format("onResult, isSuccess: %s, installDir: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("KEY_INSTALL_RESULT", paramBoolean1);
    localBundle.putString("KEY_INSTALL_DIR", paramString);
    localBundle.putBoolean("KEY_IS_APP_EXIST", paramBoolean3);
    localBundle.putBoolean("KEY_IS_ENGINE_EXIST", paramBoolean2);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "FlutterSubQIPCModule", "ACTION_INSTALL_RESULT", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqal
 * JD-Core Version:    0.7.0.1
 */