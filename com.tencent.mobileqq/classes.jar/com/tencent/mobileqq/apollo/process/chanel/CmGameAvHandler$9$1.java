package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.TMG.sdk.AVVideoCtrl.SwitchCameraCompleteCallback;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import org.json.JSONObject;

class CmGameAvHandler$9$1
  extends AVVideoCtrl.SwitchCameraCompleteCallback
{
  CmGameAvHandler$9$1(CmGameAvHandler.9 param9) {}
  
  public void onComplete(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", i);
        localJSONObject.put("cameraPos", paramInt1);
        localJSONObject.put("errCode", paramInt2);
        CmGameUtil.a().callbackFromRequest(this.a.a, 0, "cs.audioRoom_camera_switch.local", localJSONObject.toString());
        return;
      }
      catch (Exception localException) {}
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.9.1
 * JD-Core Version:    0.7.0.1
 */