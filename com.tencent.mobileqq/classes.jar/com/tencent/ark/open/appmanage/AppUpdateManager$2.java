package com.tencent.ark.open.appmanage;

import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;

class AppUpdateManager$2
  implements Runnable
{
  AppUpdateManager$2(AppUpdateManager paramAppUpdateManager, AppUpdateManager.ICheckNetworkCallback paramICheckNetworkCallback) {}
  
  public void run()
  {
    IArkDelegateNet localIArkDelegateNet = ArkDelegateManager.getInstance().getNetDelegate();
    boolean bool;
    if (localIArkDelegateNet != null) {
      bool = localIArkDelegateNet.isNetworkAvailable();
    } else {
      bool = true;
    }
    this.val$cb.onCheckNetwork(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateManager.2
 * JD-Core Version:    0.7.0.1
 */