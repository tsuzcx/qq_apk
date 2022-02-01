package com.tencent.mobileqq.ark.API;

import agpq;
import apix;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;

public class ArkAppQQModule$18
  implements Runnable
{
  public ArkAppQQModule$18(apix paramapix, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      Object localObject = ark.arkGetContainer(this.jdField_a_of_type_Long);
      if (localObject != null)
      {
        localObject = (agpq)agpq.a((ark.Container)localObject).get();
        if (localObject != null) {
          ((agpq)localObject).b = this.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.18
 * JD-Core Version:    0.7.0.1
 */