package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.qphone.base.util.QLog;

class ArkAppQQModule$19$1
  implements Runnable
{
  ArkAppQQModule$19$1(ArkAppQQModule.19 param19, String paramString) {}
  
  public void run()
  {
    Object localObject = ArkAppQQModule.c(this.b.b, this.b.a);
    if (localObject == null)
    {
      ChooseImageIPCModule.a().a(null);
      return;
    }
    ark.VariantWrapper localVariantWrapper1 = ((ark.VariantWrapper)localObject).Create();
    localVariantWrapper1.SetNull();
    ark.VariantWrapper localVariantWrapper2 = ((ark.VariantWrapper)localObject).Create();
    localVariantWrapper1.SetTableAsJsonString(this.a);
    ((ark.VariantWrapper)localObject).InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1 }, localVariantWrapper2);
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
    ((ark.VariantWrapper)localObject).Reset();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQ.ChooseImage callback : ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("ArkApp", 1, ((StringBuilder)localObject).toString());
    ChooseImageIPCModule.a().a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.19.1
 * JD-Core Version:    0.7.0.1
 */