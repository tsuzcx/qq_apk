package com.tencent.mobileqq.activity.aio.rebuild;

import ahfp;
import ahgb;
import atyd;
import atyf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.QLog;

public class GameMsgChatPie$GameUsrAvatarClickLis$1
  implements Runnable
{
  public GameMsgChatPie$GameUsrAvatarClickLis$1(ahgb paramahgb) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((atyd)ahgb.a(this.this$0).getManager(358)).a(ahgb.a(this.this$0));
        if (localObject == null)
        {
          QLog.w(ahfp.b, 1, "GameUsrAvatarClickLis, usrInfo is null");
          return;
        }
        ahgb.a(this.this$0);
        String str2 = ((GameUserInfo)localObject).mAppId;
        if (ahgb.a(this.this$0))
        {
          localObject = "0";
          atyf.a(str2, "1", "145", "920", "92005", "206352", "", "", "20", (String)localObject);
          if (!ahgb.b(this.this$0)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(ahfp.b, 2, "GameUsrAvatarClickLis already update.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(ahfp.b, 1, localThrowable, new Object[0]);
        return;
      }
      String str1 = "1";
    }
    ahgb.a(this.this$0, ahgb.a(this.this$0));
    ahgb.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1
 * JD-Core Version:    0.7.0.1
 */