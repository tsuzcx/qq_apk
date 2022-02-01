package com.tencent.ark;

final class ArkViewModel$1
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    if (ArkViewModelBase.ENV.isHardwareAcceleration()) {
      ArkEGLContextManager.getManager(1).createContext("global");
    }
    Logger.logI("ArkApp.ArkViewModel", String.format("precreateOfflineContext, used-time=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModel.1
 * JD-Core Version:    0.7.0.1
 */