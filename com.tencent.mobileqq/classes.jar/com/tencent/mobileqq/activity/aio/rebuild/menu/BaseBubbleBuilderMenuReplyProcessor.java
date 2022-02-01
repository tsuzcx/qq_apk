package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;

public class BaseBubbleBuilderMenuReplyProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  public BaseBubbleBuilderMenuReplyProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  private void a(Context paramContext, ChatMessage paramChatMessage)
  {
    if (!a(paramContext))
    {
      Object localObject;
      if ((paramContext instanceof FragmentActivity))
      {
        localObject = ((FragmentActivity)paramContext).getChatFragment();
        if (localObject != null) {
          ((ChatFragment)localObject).a().d(paramChatMessage);
        }
      }
      if ((paramChatMessage instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)paramChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 81) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, (MessageForStructing)localObject, "reply");
        }
      }
      ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, "0X800A368");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    a(paramContext, paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    if ((paramChatMessage == null) || (paramChatMessage.shmsgseq == 0L)) {}
    do
    {
      do
      {
        return;
      } while ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0));
      if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (paramChatMessage.isSupportReply()))
      {
        paramQQCustomMenu.a(2131376927, paramContext.getString(2131697689), 2130839065);
        MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000));
    paramQQCustomMenu.a(2131376927, paramContext.getString(2131697689), 2130839065);
    MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramChatMessage, paramQQCustomMenu, paramContext);
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131376927;
  }
  
  protected boolean a(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697388, 0).b(paramContext.getResources().getDimensionPixelSize(2131299166));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuReplyProcessor
 * JD-Core Version:    0.7.0.1
 */