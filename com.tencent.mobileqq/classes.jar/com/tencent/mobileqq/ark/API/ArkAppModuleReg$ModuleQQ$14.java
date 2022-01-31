package com.tencent.mobileqq.ark.API;

import adlj;
import alpe;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

public class ArkAppModuleReg$ModuleQQ$14
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$14(alpe paramalpe, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.jdField_a_of_type_Long);
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
        localObject = adlj.a((ark.Container)localObject);
      } while (localObject == null);
      localObject = (adlj)((WeakReference)localObject).get();
    } while (localObject == null);
    localArkFullScreenAppActivity.a((adlj)localObject, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.14
 * JD-Core Version:    0.7.0.1
 */