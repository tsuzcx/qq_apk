package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgChatPie$8
  implements View.OnClickListener
{
  GameMsgChatPie$8(GameMsgChatPie paramGameMsgChatPie) {}
  
  public void onClick(View paramView)
  {
    GameMsgChatPie.c(this.a);
    if ((GameMsgChatPie.a(this.a) != null) && (!TextUtils.isEmpty(GameMsgChatPie.b(this.a))))
    {
      Object localObject = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=";
      QQAppInterface localQQAppInterface = this.a.a();
      if ((!TextUtils.isEmpty(GameMsgChatPie.c(this.a))) && (localQQAppInterface != null))
      {
        if (!GameMsgChatPie.c(this.a).startsWith("&"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=");
          ((StringBuilder)localObject).append("&");
          localObject = ((StringBuilder)localObject).toString();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(GameMsgChatPie.c(this.a));
        localObject = localStringBuilder.toString();
        new AppLaucherHelper().a(localQQAppInterface, this.a.a(), GameMsgChatPie.a(this.a).c, (String)localObject, GameMsgChatPie.b(this.a), 536870912);
        ((IApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(GameMsgChatPie.a(this.a).c, localQQAppInterface.getCurrentAccountUin(), 1);
      }
    }
    else
    {
      QLog.e("GameMsgChatPie", 1, "gameinfo is null ");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.8
 * JD-Core Version:    0.7.0.1
 */