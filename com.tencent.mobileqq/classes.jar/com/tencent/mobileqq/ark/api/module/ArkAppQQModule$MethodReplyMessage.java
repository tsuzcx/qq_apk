package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.ark.module.ArkAppModuleBase;
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
      paramArrayOfVariantWrapper = null;
      paramArkAppModuleBase = paramArrayOfVariantWrapper;
      if (l != 0L)
      {
        paramVariantWrapper = ark.arkGetContainer(l);
        paramArkAppModuleBase = paramArrayOfVariantWrapper;
        if (paramVariantWrapper != null)
        {
          paramVariantWrapper = (ArkAppContainer)ArkAppContainer.a(paramVariantWrapper).get();
          paramArkAppModuleBase = paramArrayOfVariantWrapper;
          if (paramVariantWrapper != null)
          {
            paramArkAppModuleBase = paramArrayOfVariantWrapper;
            if ((paramVariantWrapper instanceof ArkAioContainerWrapper)) {
              paramArkAppModuleBase = (MessageForArkApp)((ArkAioContainerWrapper)paramVariantWrapper).a.get();
            }
          }
        }
      }
      if (paramArkAppModuleBase == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp.ArkAppQQModule", 2, "invoke method [ReplyMessage] arkMsg is null");
        }
        return;
      }
      if (AskAnonymousUtil.a(paramArkAppModuleBase)) {
        AskAnonymousUtil.a(paramArkAppModuleBase);
      }
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return null;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.MethodReplyMessage
 * JD-Core Version:    0.7.0.1
 */