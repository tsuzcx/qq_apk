package com.tencent.mobileqq.ark.base;

import com.tencent.ark.open.ArkAppMgr;

class ArkAppCenter$3
  implements Runnable
{
  ArkAppCenter$3(ArkAppCenter paramArkAppCenter) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().updateInstalledApps();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.ArkAppCenter.3
 * JD-Core Version:    0.7.0.1
 */