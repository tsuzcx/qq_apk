package com.tencent.mobileqq.activity.aio.item;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class TextItemBuilder$2
  implements View.OnClickListener
{
  TextItemBuilder$2(TextItemBuilder paramTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = AIOUtils.a(paramView);
    if (!(localObject1 instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    MessageForText localMessageForText;
    label56:
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMessageForText = (MessageForText)localObject1;
      if (localMessageForText.sb == null) {
        break;
      }
      localObject1 = localMessageForText.sb.toString();
      ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
      if ((this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
      {
        localObject2 = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if (localObject2 != null)
        {
          localObject2 = (QWalletAIOLifeCycleHelper)((BaseChatPie)localObject2).a(27);
          if (localObject2 != null) {
            ((QWalletAIOLifeCycleHelper)localObject2).a((String)localObject1, localSendMsgParams, 0);
          }
        }
      }
      Object localObject2 = MessageForText.getTroopMemberInfoFromExtrJson(localMessageForText.getExtInfoFromExtStr(MessageConstants.i));
      ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (ArrayList)localObject2, localSendMsgParams);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1);
    localObject1 = (HotChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    for (localObject1 = "2";; localObject1 = "1")
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_msg", "", "grp_msg", "clk_like", 0, 0, localMessageForText.frienduin, "", (String)localObject1, "");
      break;
      localObject1 = localMessageForText.msg;
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */