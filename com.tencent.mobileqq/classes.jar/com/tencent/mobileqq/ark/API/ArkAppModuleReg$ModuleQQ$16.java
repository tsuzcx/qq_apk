package com.tencent.mobileqq.ark.API;

import afdt;
import anfv;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

public class ArkAppModuleReg$ModuleQQ$16
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$16(anfv paramanfv, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.a);
    if (localObject == null) {}
    ArkFullScreenAppActivity localArkFullScreenAppActivity;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity));
        localArkFullScreenAppActivity = (ArkFullScreenAppActivity)BaseActivity.sTopActivity;
        localObject = afdt.a((ark.Container)localObject);
      } while (localObject == null);
      localObject = (afdt)((WeakReference)localObject).get();
    } while (localObject == null);
    localArkFullScreenAppActivity.a((afdt)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.16
 * JD-Core Version:    0.7.0.1
 */