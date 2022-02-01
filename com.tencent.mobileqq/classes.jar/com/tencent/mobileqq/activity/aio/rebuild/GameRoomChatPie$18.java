package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.werewolves.WerewolvesObserver;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class GameRoomChatPie$18
  extends WerewolvesObserver
{
  GameRoomChatPie$18(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownLoadedPluginResult result = ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      this.a.bM();
      return;
    }
    QQToast.makeText(this.a.aX(), HardCodeUtil.a(2131903091), 0).show();
    if (this.a.bE != null) {
      this.a.bE.setProgress(0);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotifyGameRoomSpeakerStatus uin = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" isSeaking = ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.a.ah.b.equals(String.valueOf(paramLong1)))
    {
      if (this.a.bC == null) {
        return;
      }
      localObject = this.a.bC.c();
      if (localObject != null) {
        ((WerewolvesPluginInterface)localObject).a(String.valueOf(paramLong2), paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.18
 * JD-Core Version:    0.7.0.1
 */