package com.tencent.mobileqq.ark.API;

import afdt;
import anfv;
import anku;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;

public class ArkAppModuleReg$ModuleQQ$13
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$13(anfv paramanfv, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.a);
    if (localObject == null) {}
    do
    {
      return;
      localObject = afdt.a((ark.Container)localObject);
    } while ((localObject == null) || ((afdt)((WeakReference)localObject).get() == null));
    anku.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.13
 * JD-Core Version:    0.7.0.1
 */