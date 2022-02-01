package com.tencent.comic.hippy;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class BoodoHippyBirdge$1
  implements EIPCResultCallback
{
  BoodoHippyBirdge$1(BoodoHippyBirdge.ICheckPluginListener paramICheckPluginListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("retCode");
    paramEIPCResult = paramEIPCResult.getString("msg");
    BoodoHippyBirdge.ICheckPluginListener localICheckPluginListener = this.val$checkPluginListener;
    if (localICheckPluginListener != null) {
      localICheckPluginListener.onResult(i, paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.hippy.BoodoHippyBirdge.1
 * JD-Core Version:    0.7.0.1
 */