package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import java.lang.ref.WeakReference;

class ArkAppQQModule$14
  implements Runnable
{
  ArkAppQQModule$14(ArkAppQQModule paramArkAppQQModule, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject2 = ark.arkGetContainer(this.jdField_a_of_type_Long);
    if (localObject2 == null) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = ArkAppModuleBase.a();
        } while (!(localObject1 instanceof ArkFullScreenAppActivity));
        localObject1 = (ArkFullScreenAppActivity)localObject1;
        localObject2 = ArkAppContainer.a((ark.Container)localObject2);
      } while (localObject2 == null);
      localObject2 = (ArkAppContainer)((WeakReference)localObject2).get();
    } while (localObject2 == null);
    ((ArkFullScreenAppActivity)localObject1).a((ArkAppContainer)localObject2, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.14
 * JD-Core Version:    0.7.0.1
 */