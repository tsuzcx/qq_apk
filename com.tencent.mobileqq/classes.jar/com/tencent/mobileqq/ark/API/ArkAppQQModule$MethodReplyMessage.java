package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ArkAppQQModule$MethodReplyMessage
  extends ArkAppQQModule.TencentMethod
{
  private ArkAppQQModule$MethodReplyMessage()
  {
    super(null);
  }
  
  public String a()
  {
    return "ReplyMessage";
  }
  
  public void a(ArkAppModuleBase paramArkAppModuleBase, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
    {
      long l = paramArrayOfVariantWrapper[0].GetView();
      if (l == 0L) {
        break label111;
      }
      paramArkAppModuleBase = ark.arkGetContainer(l);
      if (paramArkAppModuleBase == null) {
        break label111;
      }
      paramArkAppModuleBase = (ArkAppContainer)ArkAppContainer.a(paramArkAppModuleBase).get();
      if ((paramArkAppModuleBase == null) || (!(paramArkAppModuleBase instanceof ArkAioContainerWrapper))) {
        break label111;
      }
    }
    label111:
    for (paramArkAppModuleBase = (MessageForArkApp)((ArkAioContainerWrapper)paramArkAppModuleBase).a.get();; paramArkAppModuleBase = null)
    {
      if (paramArkAppModuleBase == null) {
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp.ArkAppQQModule", 2, "invoke method [ReplyMessage] arkMsg is null");
        }
      }
      while (!AskAnonymousUtil.a(paramArkAppModuleBase)) {
        return;
      }
      AskAnonymousUtil.a(paramArkAppModuleBase);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.MethodReplyMessage
 * JD-Core Version:    0.7.0.1
 */