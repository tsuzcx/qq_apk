package com.tencent.mobileqq.ark.API;

import afdt;
import anfv;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;

public class ArkAppModuleReg$ModuleQQ$18
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$18(anfv paramanfv, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      Object localObject = ark.arkGetContainer(this.jdField_a_of_type_Long);
      if (localObject != null)
      {
        localObject = (afdt)afdt.a((ark.Container)localObject).get();
        if (localObject != null) {
          ((afdt)localObject).b = this.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.18
 * JD-Core Version:    0.7.0.1
 */