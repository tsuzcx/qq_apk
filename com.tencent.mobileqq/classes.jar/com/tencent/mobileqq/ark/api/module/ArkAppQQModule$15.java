package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import java.lang.ref.WeakReference;

class ArkAppQQModule$15
  implements Runnable
{
  ArkAppQQModule$15(ArkAppQQModule paramArkAppQQModule, long paramLong) {}
  
  public void run()
  {
    Object localObject2 = ark.arkGetContainer(this.a);
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = ArkAppQQModuleBase.f();
    if ((localObject1 instanceof ArkFullScreenAppActivity))
    {
      localObject1 = (ArkFullScreenAppActivity)localObject1;
      localObject2 = ArkAppContainer.a((ark.Container)localObject2);
      if (localObject2 != null)
      {
        localObject2 = (ArkAppContainer)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          ((ArkFullScreenAppActivity)localObject1).a((ArkAppContainer)localObject2, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.15
 * JD-Core Version:    0.7.0.1
 */