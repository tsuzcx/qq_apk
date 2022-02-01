package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import java.lang.ref.WeakReference;

class ArkAppQQModule$18
  implements Runnable
{
  ArkAppQQModule$18(ArkAppQQModule paramArkAppQQModule, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      Object localObject = ark.arkGetContainer(this.jdField_a_of_type_Long);
      if (localObject != null)
      {
        localObject = (ArkAppContainer)ArkAppContainer.a((ark.Container)localObject).get();
        if (localObject != null) {
          ((ArkAppContainer)localObject).b = this.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.18
 * JD-Core Version:    0.7.0.1
 */