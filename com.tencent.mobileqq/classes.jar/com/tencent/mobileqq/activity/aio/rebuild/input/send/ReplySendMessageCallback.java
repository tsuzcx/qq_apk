package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputUIUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.replymsg.ReplyMsgSender;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import java.util.ArrayList;
import java.util.List;

public class ReplySendMessageCallback
  implements ISendMessageCallback
{
  @Nullable
  private MessageRecord a(AIOContext paramAIOContext, MessageRecord paramMessageRecord)
  {
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)paramAIOContext.a(119)).a();
    Object localObject = paramMessageRecord;
    if (localSourceMsgInfo != null)
    {
      localObject = paramMessageRecord;
      if (TextUtils.isEmpty(localSourceMsgInfo.mAnonymousNickName))
      {
        localObject = paramMessageRecord;
        if (paramMessageRecord == null)
        {
          localObject = paramAIOContext.a().a().a(paramAIOContext, false);
          int i = ((List)localObject).size() - 1;
          while (i >= 0)
          {
            paramMessageRecord = (ChatMessage)((List)localObject).get(i);
            if (paramMessageRecord.shmsgseq == localSourceMsgInfo.mSourceMsgSeq) {
              break label108;
            }
            i -= 1;
          }
          paramMessageRecord = null;
          label108:
          MessageForReplyText.reportReplyMsg(paramAIOContext.a(), "suc_replyMsg", "reply_suc", paramAIOContext.a().jdField_a_of_type_JavaLangString, paramMessageRecord);
          localObject = paramMessageRecord;
        }
      }
    }
    return localObject;
  }
  
  private boolean a(BaseSessionInfo paramBaseSessionInfo)
  {
    int i = paramBaseSessionInfo.jdField_a_of_type_Int;
    boolean bool = true;
    if (i != 1)
    {
      if (paramBaseSessionInfo.jdField_a_of_type_Int == 3000) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = paramSendLogicParam.a();
    Object localObject3 = paramAIOContext.a().a().a();
    ReplyHelper localReplyHelper = (ReplyHelper)paramAIOContext.a(119);
    Object localObject2 = localReplyHelper.a(null);
    Object localObject1 = localObject2;
    if (a(paramAIOContext.a())) {
      localObject1 = a(paramAIOContext, (MessageRecord)localObject2);
    }
    ReplyTextItemBuilder.a(paramAIOContext.a(), (MessageRecord)localObject1, "0X800A369");
    if (localSendMsgParams.a != null)
    {
      localSendMsgParams.a.mType = 0;
      if (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForMixedMsg))) {
        localSendMsgParams.a.oriMsgType = 1;
      }
      if (localObject1 != null) {
        localSendMsgParams.a.packSourceMsg(paramAIOContext.a(), (MessageRecord)localObject1);
      }
    }
    paramSendLogicParam.a(AtTroopMemberSpan.a(((EditTextUI)localObject3).b(), paramArrayList));
    Object localObject4;
    if (a(paramAIOContext.a()))
    {
      InputUIUtils.a(paramAIOContext, paramAIOContext.a(), true);
      localObject2 = new ArrayList();
      localObject3 = AtTroopMemberSpan.a(((EditTextUI)localObject3).b(), (ArrayList)localObject2);
      localObject4 = localObject2;
    }
    else
    {
      localObject2 = null;
      localObject4 = localObject2;
      localObject3 = localObject2;
    }
    if (((ReceiptHelper)paramAIOContext.a(118)).a)
    {
      ReceiptMsgManager.a().a(paramAIOContext.a(), paramAIOContext.a(), paramSendLogicParam.a(), paramArrayList, localSendMsgParams);
      ((ReceiptHelper)paramAIOContext.a(118)).a();
      return true;
    }
    if (localReplyHelper.a())
    {
      ReplyMsgSender.a().a(paramAIOContext.a(), paramAIOContext.a(), paramSendLogicParam.a(), paramArrayList, localSendMsgParams, (MessageRecord)localObject1, (String)localObject3, localObject4);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.ReplySendMessageCallback
 * JD-Core Version:    0.7.0.1
 */