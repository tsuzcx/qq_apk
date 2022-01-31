package com.tencent.mobileqq.ark.API;

import adaj;
import alat;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;

public class ArkAppModuleReg$ModuleQQ$18
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$18(alat paramalat, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      Object localObject = ark.arkGetContainer(this.jdField_a_of_type_Long);
      if (localObject != null)
      {
        localObject = (adaj)adaj.a((ark.Container)localObject).get();
        if (localObject != null) {
          ((adaj)localObject).b = this.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.18
 * JD-Core Version:    0.7.0.1
 */