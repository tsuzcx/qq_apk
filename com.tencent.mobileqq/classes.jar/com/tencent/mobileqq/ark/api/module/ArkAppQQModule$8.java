package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.module.AuthDialogEventHandler;

class ArkAppQQModule$8
  implements AuthDialogEventHandler
{
  ArkAppQQModule$8(ArkAppQQModule paramArkAppQQModule, long paramLong, String paramString) {}
  
  public void a()
  {
    ArkDispatchTask.getInstance().post(ArkAppQQModule.c(this.c), new ArkAppQQModule.8.1(this));
  }
  
  public void b()
  {
    ArkDispatchTask.getInstance().post(ArkAppQQModule.d(this.c), new ArkAppQQModule.8.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.8
 * JD-Core Version:    0.7.0.1
 */