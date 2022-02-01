package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import java.lang.ref.WeakReference;

class ArkAppQQModule$10
  implements Runnable
{
  ArkAppQQModule$10(ArkAppQQModule paramArkAppQQModule, long paramLong) {}
  
  public void run()
  {
    ArkAppContainer localArkAppContainer = (ArkAppContainer)ArkAppContainer.a(ark.arkGetContainer(this.a)).get();
    if (localArkAppContainer != null) {
      localArkAppContainer.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.10
 * JD-Core Version:    0.7.0.1
 */