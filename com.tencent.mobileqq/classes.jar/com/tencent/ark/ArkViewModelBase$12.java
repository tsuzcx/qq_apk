package com.tencent.ark;

class ArkViewModelBase$12
  implements Runnable
{
  ArkViewModelBase$12(ArkViewModelBase paramArkViewModelBase, String paramString) {}
  
  public void run()
  {
    ArkAppPreloader.releasePreloadApplicationAndReload(this.val$preloadAppName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.12
 * JD-Core Version:    0.7.0.1
 */