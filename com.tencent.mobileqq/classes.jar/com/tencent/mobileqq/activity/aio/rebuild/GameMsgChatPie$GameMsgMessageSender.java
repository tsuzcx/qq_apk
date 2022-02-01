package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.XEditTextEx;

class GameMsgChatPie$GameMsgMessageSender
  extends BaseMessageSender
{
  public GameMsgChatPie$GameMsgMessageSender(GameMsgChatPie paramGameMsgChatPie, AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void c()
  {
    if (GameMsgChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie) == null) {
      return;
    }
    if (GameMsgChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie) != null) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie).c, "1", "145", "920", "92005", "206356", "", "", "20", "0");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().getBytes().length > GameMsgChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie).d)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.jdField_a_of_type_AndroidContentContext, 2131692792, 1);
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.t()) {
        return;
      }
      if ((!GameMsgChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie)) && (GameMsgChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie) == 3) && (GameMsgChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie) != null)) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie).c, "1", "145", "920", "92005", "207647", "", "", "8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a, "");
      }
      GameMsgChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie, true);
      super.c();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameMsgMessageSender
 * JD-Core Version:    0.7.0.1
 */