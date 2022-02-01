package com.tencent.mobileqq.activity.faceunlock;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class FaceUnblockCameraJsApiPlugin$2$1
  implements Runnable
{
  FaceUnblockCameraJsApiPlugin$2$1(FaceUnblockCameraJsApiPlugin.2 param2, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retCode", 0);
      localJSONObject.put("base64", this.a);
      this.b.this$0.callJs(FaceUnblockCameraJsApiPlugin.a(this.b.this$0), new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock callJs error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */