package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.module.AuthDialogEventHandler;

class ArkAppQQModule$7
  implements AuthDialogEventHandler
{
  ArkAppQQModule$7(ArkAppQQModule paramArkAppQQModule, long paramLong1, String paramString, long paramLong2) {}
  
  public void a()
  {
    ArkDispatchTask.getInstance().post(ArkAppQQModule.a(this.d), new ArkAppQQModule.7.1(this));
  }
  
  public void b()
  {
    ArkDispatchTask.getInstance().post(ArkAppQQModule.b(this.d), new ArkAppQQModule.7.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.7
 * JD-Core Version:    0.7.0.1
 */