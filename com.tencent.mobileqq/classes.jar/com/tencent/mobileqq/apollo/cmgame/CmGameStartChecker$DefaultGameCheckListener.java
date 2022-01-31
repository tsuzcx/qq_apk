package com.tencent.mobileqq.apollo.cmgame;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class CmGameStartChecker$DefaultGameCheckListener
  implements OnGameStartCheckListener
{
  private AppInterface mApp;
  
  public CmGameStartChecker$DefaultGameCheckListener(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  public void onDownloadGameResDown(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null))
    {
      QLog.e("apollo_cmGame_CmGameStartChecker", 1, "onDownloadGameResDown startCheckParam == null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "onDownloadGameResDown", localBundle, null);
  }
  
  public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt) {}
  
  public void onDownloadGameResStart(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void onGameCheckStart(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null)
    {
      QLog.e("apollo_cmGame_CmGameStartChecker", 1, "onGameCheckStart startCheckParam == null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "onGameCheckStart", localBundle, null);
  }
  
  public void onSsoCmdRuleRsp(CmGameStartChecker.StartCheckParam paramStartCheckParam, String paramString)
  {
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e("apollo_cmGame_CmGameStartChecker", 1, "onSsoCmdRuleRsp startCheckParam == null");
    }
    CmGameManager localCmGameManager;
    do
    {
      return;
      localCmGameManager = CmGameUtil.a();
    } while (localCmGameManager == null);
    localCmGameManager.a(paramStartCheckParam.game.gameId, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener
 * JD-Core Version:    0.7.0.1
 */