package com.tencent.mobileqq.ark.API;

import adll;
import alpf;
import aluc;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;

public class ArkAppModuleReg$ModuleQQ$13
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$13(alpf paramalpf, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.a);
    if (localObject == null) {}
    do
    {
      return;
      localObject = adll.a((ark.Container)localObject);
    } while ((localObject == null) || ((adll)((WeakReference)localObject).get() == null));
    aluc.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.13
 * JD-Core Version:    0.7.0.1
 */