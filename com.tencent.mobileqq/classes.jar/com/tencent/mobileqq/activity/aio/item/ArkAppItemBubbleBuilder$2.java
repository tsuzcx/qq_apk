package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

class ArkAppItemBubbleBuilder$2
  implements DialogInterface.OnClickListener
{
  ArkAppItemBubbleBuilder$2(ArkAppItemBubbleBuilder paramArkAppItemBubbleBuilder, MessageForArkApp paramMessageForArkApp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ForwardSDKB77AIOHelper.a(this.a, this.b.e)) {
      return;
    }
    paramDialogInterface = (MessageForArkApp)MessageRecordFactory.a(this.a);
    if (paramDialogInterface.msgData == null)
    {
      if (paramDialogInterface.ark_app_message == null)
      {
        ArkAppCenter.a("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
        return;
      }
      paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
    }
    if (this.b.f != null)
    {
      paramInt = paramDialogInterface.getProcessState();
      this.b.d.getMessageFacade().h(this.b.f.b, this.b.f.a, this.a.uniseq);
      if ((paramInt != 1002) && (paramInt != 0))
      {
        Object localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          localObject = (IArkAsyncShareMsgService)((QQAppInterface)localObject).getRuntimeService(IArkAsyncShareMsgService.class, "");
          if (localObject != null)
          {
            localObject = ((IArkAsyncShareMsgService)localObject).getAsyncShareMsgManager();
            if (localObject != null) {
              ((ArkAsyncShareMsgManager)localObject).a(paramDialogInterface);
            }
          }
        }
      }
      else
      {
        this.b.d.getMessageFacade().a(paramDialogInterface, null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.2
 * JD-Core Version:    0.7.0.1
 */