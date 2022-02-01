package com.tencent.mobileqq.apollo.store;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ApolloGameActivity$CmGameStartCheckListener
  extends CmGameStartChecker.DefaultGameCheckListener
{
  public ApolloGameActivity$CmGameStartCheckListener(ApolloGameActivity paramApolloGameActivity, AppInterface paramAppInterface)
  {
    super(paramAppInterface, false);
  }
  
  public void a(int paramInt)
  {
    if (ApolloGameActivity.a(this.a)) {}
    while (ApolloGameActivity.a(this.a) == null) {
      return;
    }
    ApolloGameActivity.a(this.a).a(paramInt, ApolloGameActivity.a(this.a));
  }
  
  public void a(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloGameActivity.a(this.a)) {}
    do
    {
      return;
      QLog.d(this.a.a, 1, new Object[] { "[onCheckGameFinish] resultCode=", Long.valueOf(paramLong) });
      if (paramStartCheckParam == null)
      {
        QLog.e(this.a.a, 1, "onCheckGameFinish mStartCheckParam == null");
        return;
      }
      if (paramLong != 0L)
      {
        a(paramStartCheckParam, paramLong);
        return;
      }
    } while (ApolloGameActivity.a(this.a) == null);
    ApolloGameActivity.a(this.a).a(paramLong, paramStartCheckParam);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (ApolloGameActivity.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      if (paramStartCheckParam != null) {
        break label43;
      }
      QLog.d(this.a.a, 2, "showGameLifeTip mStartCheckParam is null");
    }
    for (;;)
    {
      a(paramStartCheckParam, -1L);
      return;
      label43:
      QLog.d(this.a.a, 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    if (ApolloGameActivity.a(this.a) != null) {
      ApolloGameActivity.a(this.a).a(paramStartCheckParam, paramInt);
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    if (ApolloGameActivity.a(this.a) != null) {
      ApolloGameActivity.a(this.a).b(paramStartCheckParam, paramLong);
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    if (ApolloGameActivity.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d(this.a.a, 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
          return;
          if ((ApolloGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloGameActivity.a(this.a).requestCode)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.a.a, 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
        return;
        if (paramLong > 0L) {
          break;
        }
        QLog.d(this.a.a, 2, new Object[] { "[onDownloadConfirm] packageSize is invalid, packageSize=", Long.valueOf(paramLong) });
      } while (paramICmGameConfirmListener == null);
      paramICmGameConfirmListener.a(paramStartCheckParam);
      return;
      if ((ApolloGameActivity.a(this.a) != null) && (ApolloGameActivity.a(this.a).statMap != null)) {
        ApolloGameActivity.a(this.a).statMap.put("download_confirm", Long.valueOf(1L));
      }
    } while (ApolloGameActivity.a(this.a) == null);
    ApolloGameActivity.a(this.a).a(paramStartCheckParam, paramICmGameConfirmListener, paramLong);
  }
  
  public void b(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloGameActivity.a(this.a)) {}
    do
    {
      do
      {
        return;
        QLog.d(this.a.a, 1, new Object[] { "[onVerifyGameFinish] resultCode=", Long.valueOf(paramLong) });
        if (paramStartCheckParam != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.a.a, 2, "onVerifyGameFinish mStartCheckParam == null");
      return;
      if ((ApolloGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloGameActivity.a(this.a).requestCode)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.a, 2, "onVerifyGameFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
    return;
    if (ApolloGameActivity.a(this.a) != null) {
      ApolloGameActivity.a(this.a).a(paramStartCheckParam, paramLong);
    }
    if (paramLong != 0L)
    {
      a(paramStartCheckParam, paramLong);
      return;
    }
    if (paramCmGameInitParams != null)
    {
      paramCmGameInitParams.appId = ApolloGameActivity.a(this.a).game.appId;
      paramCmGameInitParams.commFlag = ApolloGameActivity.a(this.a).commFlag;
      paramCmGameInitParams.rpUrl = ApolloGameActivity.a(this.a).rpUrl;
      paramCmGameInitParams.rpIconUrl = ApolloGameActivity.a(this.a).rpIconUrl;
    }
    if (paramCmGameInitParams != null) {
      paramCmGameInitParams.accessTokenRet = 0;
    }
    this.a.a(paramCmGameInitParams);
  }
  
  public void c(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.c(paramStartCheckParam);
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e(this.a.a, 1, "onGetGameData startCheckParam == null or game is null");
    }
    do
    {
      return;
      ApolloGameActivity.a(this.a).game = paramStartCheckParam.game;
      if (ApolloGameActivity.a(this.a) != null) {
        ApolloGameActivity.a(this.a).a(ApolloGameActivity.a(this.a));
      }
    } while (ApolloGameActivity.a(this.a) == null);
    ApolloGameActivity.a(this.a).b(paramStartCheckParam);
  }
  
  public void e(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.e(paramStartCheckParam);
    if ((ApolloGameActivity.a(this.a) != null) && (ApolloGameActivity.a(this.a).statMap != null)) {
      ApolloGameActivity.a(this.a).statMap.put("download_game_res", Long.valueOf(1L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity.CmGameStartCheckListener
 * JD-Core Version:    0.7.0.1
 */