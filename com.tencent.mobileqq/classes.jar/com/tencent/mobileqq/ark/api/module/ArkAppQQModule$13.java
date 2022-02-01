package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.ark.ArkTipsManager;
import java.lang.ref.WeakReference;

class ArkAppQQModule$13
  implements Runnable
{
  ArkAppQQModule$13(ArkAppQQModule paramArkAppQQModule, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.a);
    if (localObject == null) {
      return;
    }
    localObject = ArkAppContainer.a((ark.Container)localObject);
    if ((localObject != null) && ((ArkAppContainer)((WeakReference)localObject).get() != null)) {
      ArkTipsManager.b().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.13
 * JD-Core Version:    0.7.0.1
 */