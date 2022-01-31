package com.tencent.mobileqq.activity.aio.rebuild;

import aglv;
import agma;
import asil;
import bkeu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.QLog;

public class GameMsgChatPie$GameUsrAvatarClickLis$1
  implements Runnable
{
  public GameMsgChatPie$GameUsrAvatarClickLis$1(agma paramagma) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((asil)agma.a(this.this$0).getManager(358)).a(agma.a(this.this$0));
        if (localObject == null)
        {
          QLog.w(aglv.g, 1, "GameUsrAvatarClickLis, usrInfo is null");
          return;
        }
        bkeu localbkeu = bkeu.a();
        String str2 = ((GameUserInfo)localObject).mAppId;
        if (agma.a(this.this$0))
        {
          localObject = "0";
          localbkeu.a(str2, "1", "145", "920", "92005", "206352", "", "", "20", (String)localObject);
          if (!agma.b(this.this$0)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(aglv.g, 2, "GameUsrAvatarClickLis already update.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(aglv.g, 1, localThrowable, new Object[0]);
        return;
      }
      String str1 = "1";
    }
    agma.a(this.this$0, agma.a(this.this$0));
    agma.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1
 * JD-Core Version:    0.7.0.1
 */