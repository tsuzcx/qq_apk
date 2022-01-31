import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

class artn
  implements arth
{
  artn(artm paramartm) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    QLog.d("FlutterMainQIPCModule", 1, String.format("onResult, isSuccess: %s, installDir: %s, isEngineExist: %s, isAppExist: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("KEY_INSTALL_RESULT", paramBoolean1);
    localBundle.putString("KEY_INSTALL_DIR", paramString);
    localBundle.putBoolean("KEY_IS_APP_EXIST", paramBoolean3);
    localBundle.putBoolean("KEY_IS_ENGINE_EXIST", paramBoolean2);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "FlutterSubQIPCModule", "ACTION_INSTALL_RESULT", localBundle, new arto(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artn
 * JD-Core Version:    0.7.0.1
 */