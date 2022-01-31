package com.tencent.mobileqq.ark.API;

import adlj;
import alpe;
import alub;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;

public class ArkAppModuleReg$ModuleQQ$13
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$13(alpe paramalpe, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.a);
    if (localObject == null) {}
    do
    {
      return;
      localObject = adlj.a((ark.Container)localObject);
    } while ((localObject == null) || ((adlj)((WeakReference)localObject).get() == null));
    alub.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.13
 * JD-Core Version:    0.7.0.1
 */