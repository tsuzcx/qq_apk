package com.tencent.ilive.opensdk.callbacks;

import com.tencent.ilive.opensdk.coreinterface.ICoreEventCallback;
import com.tencent.ilive.opensdk.params.IAVMediaInfo.IVideoInfo;

public class RtcCoreEventCallback
  implements ICoreEventCallback
{
  public void onAVActionEvent(int paramInt1, int paramInt2, String paramString) {}
  
  public void onAVEvent(int paramInt1, int paramInt2) {}
  
  public void onAVMediaInfoChange(IAVMediaInfo.IVideoInfo paramIVideoInfo) {}
  
  public void onAVStart() {}
  
  public void onAVStop() {}
  
  public boolean onAVStreamEvent(int paramInt, String paramString)
  {
    return false;
  }
  
  public void onAVTerminated(int paramInt) {}
  
  public void onAVTimeEvent(int paramInt1, int paramInt2, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.callbacks.RtcCoreEventCallback
 * JD-Core Version:    0.7.0.1
 */