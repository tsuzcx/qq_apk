package com.tencent.mobileqq.activity.aio.rebuild;

import agqk;
import agqp;
import asmu;
import bkjb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.QLog;

public class GameMsgChatPie$GameUsrAvatarClickLis$1
  implements Runnable
{
  public GameMsgChatPie$GameUsrAvatarClickLis$1(agqp paramagqp) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((asmu)agqp.a(this.this$0).getManager(358)).a(agqp.a(this.this$0));
        if (localObject == null)
        {
          QLog.w(agqk.g, 1, "GameUsrAvatarClickLis, usrInfo is null");
          return;
        }
        bkjb localbkjb = bkjb.a();
        String str2 = ((GameUserInfo)localObject).mAppId;
        if (agqp.a(this.this$0))
        {
          localObject = "0";
          localbkjb.a(str2, "1", "145", "920", "92005", "206352", "", "", "20", (String)localObject);
          if (!agqp.b(this.this$0)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(agqk.g, 2, "GameUsrAvatarClickLis already update.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(agqk.g, 1, localThrowable, new Object[0]);
        return;
      }
      String str1 = "1";
    }
    agqp.a(this.this$0, agqp.a(this.this$0));
    agqp.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1
 * JD-Core Version:    0.7.0.1
 */