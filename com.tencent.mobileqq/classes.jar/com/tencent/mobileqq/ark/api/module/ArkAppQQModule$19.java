package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.ChooseImageCallBack;

class ArkAppQQModule$19
  implements ChooseImageIPCModule.ChooseImageCallBack
{
  ArkAppQQModule$19(ArkAppQQModule paramArkAppQQModule, long paramLong) {}
  
  public void a(String paramString)
  {
    ArkDispatchTask.getInstance().post(ArkAppQQModule.n(this.b), new ArkAppQQModule.19.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.19
 * JD-Core Version:    0.7.0.1
 */