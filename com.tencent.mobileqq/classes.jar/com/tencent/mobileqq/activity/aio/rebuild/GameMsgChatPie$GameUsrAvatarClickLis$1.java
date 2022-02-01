package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msgInfo.GameUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

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
        Object localObject = ((IGameMsgManagerService)GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0).getRuntimeService(IGameMsgManagerService.class, "")).findGameUserInfo(GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0));
        if (localObject == null)
        {
          QLog.w("GameMsgChatPie", 1, "GameUsrAvatarClickLis, usrInfo is null");
          return;
        }
        GameMsgChatPie.a(GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0), (Context)this.this$0.a.get(), GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0));
        IGameMsgHelperApi localIGameMsgHelperApi = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
        String str2 = ((GameUserInfo)localObject).mAppId;
        if (GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0))
        {
          localObject = "0";
          localIGameMsgHelperApi.reportForGameMsg(str2, "1", "145", "920", "92005", "206352", "", "", "20", (String)localObject);
          if (GameMsgChatPie.GameUsrAvatarClickLis.b(this.this$0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("GameMsgChatPie", 2, "GameUsrAvatarClickLis already update.");
            return;
          }
          GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0, GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0));
          GameMsgChatPie.GameUsrAvatarClickLis.a(this.this$0, true);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameMsgChatPie", 1, localThrowable, new Object[0]);
        return;
      }
      String str1 = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1
 * JD-Core Version:    0.7.0.1
 */