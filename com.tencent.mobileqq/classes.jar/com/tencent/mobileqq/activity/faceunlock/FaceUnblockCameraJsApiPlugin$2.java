package com.tencent.mobileqq.activity.faceunlock;

import ajqj;
import android.util.Base64;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class FaceUnblockCameraJsApiPlugin$2
  implements Runnable
{
  public FaceUnblockCameraJsApiPlugin$2(ajqj paramajqj, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = FileUtils.readFile(this.a);
      if (localObject != null)
      {
        localObject = Base64.encodeToString((byte[])localObject, 0);
        ThreadManager.getUIHandler().post(new FaceUnblockCameraJsApiPlugin.2.1(this, (String)localObject));
        return;
      }
      QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock FileUtils.readFile returns null, filepath:" + this.a);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock read from filePath error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */