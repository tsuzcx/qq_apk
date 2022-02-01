package com.tencent.mobileqq.activity.aio.rebuild;

import aias;
import aiax;
import autd;
import bmxq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.QLog;

public class GameMsgChatPie$GameUsrAvatarClickLis$1
  implements Runnable
{
  public GameMsgChatPie$GameUsrAvatarClickLis$1(aiax paramaiax) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((autd)aiax.a(this.this$0).getManager(358)).a(aiax.a(this.this$0));
        if (localObject == null)
        {
          QLog.w(aias.g, 1, "GameUsrAvatarClickLis, usrInfo is null");
          return;
        }
        aiax.a(this.this$0);
        bmxq localbmxq = bmxq.a();
        String str2 = ((GameUserInfo)localObject).mAppId;
        if (aiax.a(this.this$0))
        {
          localObject = "0";
          localbmxq.a(str2, "1", "145", "920", "92005", "206352", "", "", "20", (String)localObject);
          if (!aiax.b(this.this$0)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(aias.g, 2, "GameUsrAvatarClickLis already update.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(aias.g, 1, localThrowable, new Object[0]);
        return;
      }
      String str1 = "1";
    }
    aiax.a(this.this$0, aiax.a(this.this$0));
    aiax.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1
 * JD-Core Version:    0.7.0.1
 */