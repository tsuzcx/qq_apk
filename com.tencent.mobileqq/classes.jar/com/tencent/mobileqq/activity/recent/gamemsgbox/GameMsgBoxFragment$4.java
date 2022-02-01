package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.os.Handler;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.qphone.base.util.QLog;

class GameMsgBoxFragment$4
  implements Runnable
{
  GameMsgBoxFragment$4(GameMsgBoxFragment paramGameMsgBoxFragment, String paramString) {}
  
  public void run()
  {
    IGameMsgBoxManager localIGameMsgBoxManager = (IGameMsgBoxManager)GameMsgBoxFragment.d(this.this$0).getRuntimeService(IGameMsgBoxManager.class);
    RecentUser localRecentUser = localIGameMsgBoxManager.syncGetLastRecentUser(this.a);
    if (localRecentUser == null)
    {
      if (!this.a.equals(this.this$0.getString(2131889881)))
      {
        QLog.e("GameMsgBoxFragment", 1, "initOpenSyncView recentUser is null.");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameMsgBoxFragment", 2, "show king of glory sync page since all switches are blocked");
      }
      ThreadManagerV2.getUIHandlerV2().post(new GameMsgBoxFragment.4.1(this));
      return;
    }
    Object localObject = (IGameMsgManagerService)GameMsgBoxFragment.d(this.this$0).getRuntimeService(IGameMsgManagerService.class, "");
    GameMsgBoxFragment.a(this.this$0, ((IGameMsgManagerService)localObject).findGameSwitchConfig(this.a));
    if (GameMsgBoxFragment.h(this.this$0) == null)
    {
      QLog.e("GameMsgBoxFragment", 2, "initOpenSyncView switchConfig is null.");
      return;
    }
    if (GameMsgBoxFragment.h(this.this$0).mSyncSwitch == 1)
    {
      QLog.e("GameMsgBoxFragment", 2, "syncSwitch is open.");
      ThreadManagerV2.getUIHandlerV2().post(new GameMsgBoxFragment.4.2(this));
      return;
    }
    localObject = localIGameMsgBoxManager.findGameDetailInfoByConvertUin(localRecentUser.uin);
    if (localObject != null)
    {
      int i = localIGameMsgBoxManager.getUnreadCount(localRecentUser.uin);
      ThreadManagerV2.getUIHandlerV2().post(new GameMsgBoxFragment.4.3(this, (GameDetailInfo)localObject, i, localRecentUser));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.4
 * JD-Core Version:    0.7.0.1
 */