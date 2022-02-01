package com.tencent.mobileqq.activity.recent.gamemsgbox;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class GameMsgBoxOpenSyncView$1
  implements Runnable
{
  GameMsgBoxOpenSyncView$1(GameMsgBoxOpenSyncView paramGameMsgBoxOpenSyncView) {}
  
  public void run()
  {
    IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(IGameMsgManagerService.class, "");
    GameSwitchConfig localGameSwitchConfig = localIGameMsgManagerService.findGameSwitchConfig(GameMsgBoxOpenSyncView.a(this.this$0));
    localGameSwitchConfig.mBlockSwitch = 0;
    localGameSwitchConfig.mSyncSwitch = 1;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localGameSwitchConfig);
    localIGameMsgManagerService.saveOrUpdateGameSwitchConfigs(localArrayList);
    ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).setGameSwitch(GameMsgBoxOpenSyncView.b(this.this$0), GameMsgBoxOpenSyncView.a(this.this$0), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxOpenSyncView.1
 * JD-Core Version:    0.7.0.1
 */