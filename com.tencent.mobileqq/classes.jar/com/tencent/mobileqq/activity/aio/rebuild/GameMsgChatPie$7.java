package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameDetailInfo;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgChatPie$7
  implements View.OnClickListener
{
  GameMsgChatPie$7(GameMsgChatPie paramGameMsgChatPie) {}
  
  public void onClick(View paramView)
  {
    GameMsgChatPie.c(this.a);
    if ((GameMsgChatPie.a(this.a) != null) && (!TextUtils.isEmpty(GameMsgChatPie.b(this.a))))
    {
      String str = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=";
      QQAppInterface localQQAppInterface = this.a.a();
      if ((!TextUtils.isEmpty(GameMsgChatPie.c(this.a))) && (localQQAppInterface != null))
      {
        if (!GameMsgChatPie.c(this.a).startsWith("&")) {
          str = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=" + "&";
        }
        str = str + GameMsgChatPie.c(this.a);
        new AppLaucherHelper().a(localQQAppInterface, this.a.a(), GameMsgChatPie.a(this.a).d, str, GameMsgChatPie.b(this.a), 536870912);
        ((IApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(GameMsgChatPie.a(this.a).d, localQQAppInterface.getCurrentAccountUin(), 1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e(GameMsgChatPie.f, 1, "gameinfo is null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.7
 * JD-Core Version:    0.7.0.1
 */