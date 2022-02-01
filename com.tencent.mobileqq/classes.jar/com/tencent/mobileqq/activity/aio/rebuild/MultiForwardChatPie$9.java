package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MultiForwardChatPie$9
  implements Runnable
{
  MultiForwardChatPie$9(MultiForwardChatPie paramMultiForwardChatPie, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {}
    do
    {
      return;
      localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a);
      localObject1 = localObject2;
      Object localObject3;
      if (localObject2 == null)
      {
        localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((MultiMsgProxy)localObject3).a(this.a);
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this.a == 0L)
        {
          localObject3 = MultiForwardChatPie.a(this.this$0);
          MultiMsgManager.a().a.clear();
          MultiMsgManager.a().a.addAll(MultiForwardChatPie.a(this.this$0));
          HashMap localHashMap = new HashMap();
          int i = 0;
          while (i < MultiForwardChatPie.a(this.this$0).size())
          {
            ChatMessage localChatMessage = (ChatMessage)MultiForwardChatPie.a(this.this$0).get(i);
            localObject2 = localChatMessage.getExtInfoFromExtStr("self_nickname");
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = MultiMsgManager.a().a(localChatMessage.senderuin, localChatMessage.msgseq, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (((String)localObject1).trim().length() != 0) {}
            }
            else
            {
              localObject2 = MultiMsgUtil.a(localChatMessage.senderuin);
            }
            localHashMap.put(localChatMessage.senderuin, localObject2);
            i += 1;
          }
          MultiMsgManager.a().b.clear();
          MultiMsgManager.a().b.putAll(localHashMap);
          localObject2 = localObject3;
        }
      }
    } while ((localObject2 == null) || (!(localObject2 instanceof MessageForStructing)));
    Object localObject2 = (MessageForStructing)localObject2;
    Object localObject1 = new Bundle();
    if ((((MessageForStructing)localObject2).structingMsg.source_puin != null) && (!"".equals(((MessageForStructing)localObject2).structingMsg.source_puin))) {
      ((Bundle)localObject1).putString("source_puin", ((MessageForStructing)localObject2).structingMsg.source_puin);
    }
    ((Bundle)localObject1).putInt("forward_type", -3);
    ((MessageForStructing)localObject2).structingMsg.mCommentText = null;
    ((Bundle)localObject1).putInt("structmsg_service_id", ((MessageForStructing)localObject2).structingMsg.mMsgServiceID);
    ((Bundle)localObject1).putByteArray("stuctmsg_bytes", ((MessageForStructing)localObject2).structingMsg.getBytes());
    ((Bundle)localObject1).putLong("structmsg_uniseq", this.a);
    ((Bundle)localObject1).putInt("accostType", ((MessageForStructing)localObject2).structingMsg.sourceAccoutType);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ForwardBaseOption.a((Activity)this.this$0.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.9
 * JD-Core Version:    0.7.0.1
 */