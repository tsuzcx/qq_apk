package com.tencent.aelight.camera.ae.cmshow;

import android.graphics.Bitmap;
import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

class AECMShowRequestController$2
  implements EIPCResultCallback
{
  AECMShowRequestController$2(AECMShowRequestController paramAECMShowRequestController, Bitmap paramBitmap) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = paramEIPCResult.isSuccess();
    int j = 736;
    int n = 90;
    int k = j;
    int m = n;
    if (bool)
    {
      k = j;
      m = n;
      if (paramEIPCResult.data != null)
      {
        paramEIPCResult = (HashMap)paramEIPCResult.data.getSerializable("key_request_image_param");
        k = j;
        m = n;
        if (paramEIPCResult != null)
        {
          int i = j;
          if (paramEIPCResult.containsKey("KEY_CMSHOW_IMG_MAX_LENGTH"))
          {
            i = j;
            if (((Integer)paramEIPCResult.get("KEY_CMSHOW_IMG_MAX_LENGTH")).intValue() > 0) {
              i = ((Integer)paramEIPCResult.get("KEY_CMSHOW_IMG_MAX_LENGTH")).intValue();
            }
          }
          k = i;
          m = n;
          if (paramEIPCResult.containsKey("KEY_CMSHOW_IMG_QUALITY"))
          {
            k = i;
            m = n;
            if (((Integer)paramEIPCResult.get("KEY_CMSHOW_IMG_QUALITY")).intValue() > 0)
            {
              m = ((Integer)paramEIPCResult.get("KEY_CMSHOW_IMG_QUALITY")).intValue();
              k = i;
            }
          }
        }
      }
    }
    AECMShowRequestController.a(this.b, this.a, k, m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController.2
 * JD-Core Version:    0.7.0.1
 */