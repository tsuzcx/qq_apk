package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgChatPie$5
  implements View.OnClickListener
{
  GameMsgChatPie$5(GameMsgChatPie paramGameMsgChatPie) {}
  
  public void onClick(View paramView)
  {
    if ((GameMsgChatPie.a(this.a) != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      GameCenterSessionInfo localGameCenterSessionInfo = GameMsgChatPie.a(this.a).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a());
      GameMsgUtil.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localGameCenterSessionInfo, "92005");
    }
    int i;
    if (GameMsgChatPie.c(this.a))
    {
      i = 1;
      if ((GameMsgChatPie.a(this.a) != null) && (GameMsgChatPie.a(this.a) != null))
      {
        if (GameMsgChatPie.a(this.a).a != 0) {
          break label205;
        }
        GameMsgUtil.b(GameMsgChatPie.a(this.a).d, "1", "145", "920", "92015", "207960", "20", GameMsgChatPie.b(this.a) + "", i + "", GameMsgChatPie.a(this.a));
      }
    }
    for (;;)
    {
      GameMsgChatPie.b(this.a, false);
      GameMsgChatPie.c(this.a, false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      label205:
      GameMsgUtil.b(GameMsgChatPie.a(this.a).d, "1", "145", "920", "92005", "207958", "20", GameMsgChatPie.b(this.a) + "", i + "", GameMsgChatPie.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.5
 * JD-Core Version:    0.7.0.1
 */