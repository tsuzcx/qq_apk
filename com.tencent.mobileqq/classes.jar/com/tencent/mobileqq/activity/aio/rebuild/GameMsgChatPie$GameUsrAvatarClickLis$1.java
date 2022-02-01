package com.tencent.mobileqq.activity.aio.rebuild;

import aikg;
import aikp;
import avld;
import avlf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.QLog;

public class GameMsgChatPie$GameUsrAvatarClickLis$1
  implements Runnable
{
  public GameMsgChatPie$GameUsrAvatarClickLis$1(aikp paramaikp) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((avld)aikp.a(this.this$0).getManager(358)).a(aikp.a(this.this$0));
        if (localObject == null)
        {
          QLog.w(aikg.g, 1, "GameUsrAvatarClickLis, usrInfo is null");
          return;
        }
        aikp.a(this.this$0);
        String str2 = ((GameUserInfo)localObject).mAppId;
        if (aikp.a(this.this$0))
        {
          localObject = "0";
          avlf.a(str2, "1", "145", "920", "92005", "206352", "", "", "20", (String)localObject);
          if (!aikp.b(this.this$0)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(aikg.g, 2, "GameUsrAvatarClickLis already update.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(aikg.g, 1, localThrowable, new Object[0]);
        return;
      }
      String str1 = "1";
    }
    aikp.a(this.this$0, aikp.a(this.this$0));
    aikp.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1
 * JD-Core Version:    0.7.0.1
 */