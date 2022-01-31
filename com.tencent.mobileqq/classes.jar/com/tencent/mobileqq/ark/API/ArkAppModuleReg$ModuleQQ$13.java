package com.tencent.mobileqq.ark.API;

import afii;
import anke;
import anpd;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;

public class ArkAppModuleReg$ModuleQQ$13
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$13(anke paramanke, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.a);
    if (localObject == null) {}
    do
    {
      return;
      localObject = afii.a((ark.Container)localObject);
    } while ((localObject == null) || ((afii)((WeakReference)localObject).get() == null));
    anpd.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.13
 * JD-Core Version:    0.7.0.1
 */