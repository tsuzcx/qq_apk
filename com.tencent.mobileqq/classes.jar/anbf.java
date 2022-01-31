import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoIpcServer.1;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;

public class anbf
  extends QIPCModule
{
  public anbf()
  {
    super("CameraEmoIpcServer");
  }
  
  public static anbf a()
  {
    return anbg.a();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoIpcServer", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if ("qipc_action_camera_emo_create_gif_and_upload".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      localArrayList1 = paramBundle.getStringArrayList("qipc_param_camera_emo_png_dirs");
      localArrayList2 = paramBundle.getStringArrayList("qipc_param_camera_emo_texts");
      paramBundle = paramBundle.getStringArrayList("qipc_param_camera_emo_snapshots");
      if ((localArrayList1 == null) || (localArrayList2 == null)) {
        break label242;
      }
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        break label324;
      }
    }
    label324:
    for (paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramString = null)
    {
      if (paramString == null)
      {
        QLog.d("CameraEmoIpcServer", 2, "CameraEmoIpcServer.onCall get app failed");
        localBundle.putInt("qipc_param_camera_emo_upload_result", 16);
        callbackResult(paramInt, EIPCResult.createExceptionResult(new Exception("app == null")));
        paramString = new HashMap();
        paramString.put("sucFlag", "0");
        paramString.put("retCode", String.valueOf(16));
        awrn.a(BaseApplication.getContext()).a(null, "CamEmoUpload", false, 0L, 0L, paramString, null);
        return null;
      }
      ThreadManager.excute(new CameraEmoIpcServer.1(this, paramBundle, localArrayList1, localArrayList2), 64, null, false);
      callbackResult(paramInt, EIPCResult.createSuccessResult(localBundle));
      return null;
      label242:
      QLog.d("CameraEmoIpcServer", 2, "CameraEmoIpcServer.onCall params error");
      localBundle.putInt("qipc_param_camera_emo_upload_result", 16);
      callbackResult(paramInt, EIPCResult.createExceptionResult(new Exception("pngDirs == null || texts == null")));
      paramString = new HashMap();
      paramString.put("sucFlag", "0");
      paramString.put("retCode", String.valueOf(16));
      awrn.a(BaseApplication.getContext()).a(null, "CamEmoUpload", false, 0L, 0L, paramString, null);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anbf
 * JD-Core Version:    0.7.0.1
 */