package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgSayHiCallback;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryAIOGreetInfoRsp;
import com.tencent.qphone.base.util.QLog;

class GameMsgSayHiHelper$1
  implements IGameMsgSayHiCallback
{
  GameMsgSayHiHelper$1(GameMsgSayHiHelper paramGameMsgSayHiHelper, String paramString1, String paramString2) {}
  
  public void a(long paramLong, String paramString, GameMsgGreeting.QueryAIOGreetInfoRsp paramQueryAIOGreetInfoRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGameMsgSayHiInfo ret:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" err:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" mIsChatAioDestroyed:");
    localStringBuilder.append(GameMsgSayHiHelper.a(this.c));
    QLog.i("GameMsgSayHiHelper", 1, localStringBuilder.toString());
    GameMsgSayHiHelper.a(this.c, false);
    if (GameMsgSayHiHelper.a(this.c)) {
      return;
    }
    if ((paramLong == 0L) && (paramQueryAIOGreetInfoRsp != null)) {
      ThreadManagerV2.getUIHandlerV2().post(new GameMsgSayHiHelper.1.1(this, paramQueryAIOGreetInfoRsp));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.a))) {
      this.c.a(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgSayHiHelper.1
 * JD-Core Version:    0.7.0.1
 */