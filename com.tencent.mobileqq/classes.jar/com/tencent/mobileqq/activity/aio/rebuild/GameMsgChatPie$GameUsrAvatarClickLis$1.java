package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.QLog;

class GameMsgChatPie$GameUsrAvatarClickLis$1
  implements Runnable
{
  GameMsgChatPie$GameUsrAvatarClickLis$1(GameMsgChatPie.GameUsrAvatarClickLis paramGameUsrAvatarClickLis) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((GameMsgManager)GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0).getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0));
        if (localObject == null)
        {
          QLog.w(GameMsgChatPie.f, 1, "GameUsrAvatarClickLis, usrInfo is null");
          return;
        }
        GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0);
        String str2 = ((GameUserInfo)localObject).mAppId;
        if (GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0))
        {
          localObject = "0";
          GameMsgUtil.a(str2, "1", "145", "920", "92005", "206352", "", "", "20", (String)localObject);
          if (!GameMsgChatPie.GameUsrAvatarClickLis.b(this.this$0)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(GameMsgChatPie.f, 2, "GameUsrAvatarClickLis already update.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(GameMsgChatPie.f, 1, localThrowable, new Object[0]);
        return;
      }
      String str1 = "1";
    }
    GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0, GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0));
    GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1
 * JD-Core Version:    0.7.0.1
 */