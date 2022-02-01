package com.tencent.gathererga.taid.ga;

import com.tencent.turingfd.sdk.ams.ga.TuringDIDConfig;
import com.tencent.turingfd.sdk.ams.ga.TuringDIDService;

final class TAIDGaSDK$1
  implements Runnable
{
  TAIDGaSDK$1(TuringDIDConfig paramTuringDIDConfig) {}
  
  public void run()
  {
    TuringDIDService.init(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.taid.ga.TAIDGaSDK.1
 * JD-Core Version:    0.7.0.1
 */