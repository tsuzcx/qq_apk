package com.tencent.mobileqq.activity.aio.rebuild;

import aiah;
import aiat;
import avds;
import avdu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.QLog;

public class GameMsgChatPie$GameUsrAvatarClickLis$1
  implements Runnable
{
  public GameMsgChatPie$GameUsrAvatarClickLis$1(aiat paramaiat) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((avds)aiat.a(this.this$0).getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(aiat.a(this.this$0));
        if (localObject == null)
        {
          QLog.w(aiah.b, 1, "GameUsrAvatarClickLis, usrInfo is null");
          return;
        }
        aiat.a(this.this$0);
        String str2 = ((GameUserInfo)localObject).mAppId;
        if (aiat.a(this.this$0))
        {
          localObject = "0";
          avdu.a(str2, "1", "145", "920", "92005", "206352", "", "", "20", (String)localObject);
          if (!aiat.b(this.this$0)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(aiah.b, 2, "GameUsrAvatarClickLis already update.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(aiah.b, 1, localThrowable, new Object[0]);
        return;
      }
      String str1 = "1";
    }
    aiat.a(this.this$0, aiat.a(this.this$0));
    aiat.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1
 * JD-Core Version:    0.7.0.1
 */