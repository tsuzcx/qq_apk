package com.tencent.mobileqq.apollo.lightGame;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class CmGameLoadingFragment$CmGameStartCheckListener
  extends CmGameStartChecker.DefaultGameCheckListener
{
  public CmGameLoadingFragment$CmGameStartCheckListener(CmGameLoadingFragment paramCmGameLoadingFragment, AppInterface paramAppInterface)
  {
    super(paramAppInterface, true);
  }
  
  public void a(int paramInt)
  {
    if (CmGameLoadingFragment.a(this.a)) {}
    while (CmGameLoadingFragment.a(this.a) == null) {
      return;
    }
    CmGameLoadingFragment.a(this.a).a(paramInt, CmGameLoadingFragment.a(this.a));
  }
  
  public void a(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (CmGameLoadingFragment.a(this.a)) {}
    do
    {
      return;
      if (paramStartCheckParam == null)
      {
        QLog.e("cmgame_process.CmGameLoadingFragment", 1, "onCheckGameFinish mStartCheckParam == null");
        return;
      }
      if (paramLong != 0L)
      {
        a(paramStartCheckParam, paramLong);
        return;
      }
    } while (CmGameLoadingFragment.a(this.a) == null);
    CmGameLoadingFragment.a(this.a).a(paramLong, paramStartCheckParam);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (CmGameLoadingFragment.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      if (paramStartCheckParam != null) {
        break label38;
      }
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, "showGameLifeTip mStartCheckParam is null");
    }
    for (;;)
    {
      a(paramStartCheckParam, -1L);
      return;
      label38:
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    if (CmGameLoadingFragment.a(this.a) != null) {
      CmGameLoadingFragment.a(this.a).a(paramStartCheckParam, paramInt);
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    CmGameServerQIPCModule.a().a(paramStartCheckParam, paramLong, null);
    if (CmGameLoadingFragment.a(this.a) != null) {
      CmGameLoadingFragment.a(this.a).b(paramStartCheckParam, paramLong);
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    if (CmGameLoadingFragment.a(this.a)) {}
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
          QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
          return;
          if ((CmGameLoadingFragment.a(this.a) == null) || (paramStartCheckParam.requestCode == CmGameLoadingFragment.a(this.a).requestCode)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
        return;
        if (paramLong > 0L) {
          break;
        }
        QLog.d("cmgame_process.CmGameLoadingFragment", 2, new Object[] { "[onDownloadConfirm] packageSize is invalid, packageSize=", Long.valueOf(paramLong) });
      } while (paramICmGameConfirmListener == null);
      paramICmGameConfirmListener.a(paramStartCheckParam);
      return;
      if ((CmGameLoadingFragment.a(this.a) != null) && (CmGameLoadingFragment.a(this.a).statMap != null)) {
        CmGameLoadingFragment.a(this.a).statMap.put("download_confirm", Long.valueOf(1L));
      }
    } while (CmGameLoadingFragment.a(this.a) == null);
    CmGameLoadingFragment.a(this.a).a(paramStartCheckParam, paramICmGameConfirmListener, paramLong);
  }
  
  public void b(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (CmGameLoadingFragment.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((paramCmGameInitParams != null) && (CmGameLoadingFragment.a(this.a) != null))
          {
            paramCmGameInitParams.commFlag = CmGameLoadingFragment.a(this.a).commFlag;
            paramCmGameInitParams.mSSORule = CmGameLoadingFragment.a(this.a).mSSORule;
            if (CmGameLoadingFragment.a(this.a).game != null) {
              paramCmGameInitParams.appId = CmGameLoadingFragment.a(this.a).game.appId;
            }
            paramCmGameInitParams.rpUrl = CmGameLoadingFragment.a(this.a).rpUrl;
            paramCmGameInitParams.rpIconUrl = CmGameLoadingFragment.a(this.a).rpIconUrl;
          }
          if (paramCmGameInitParams != null) {
            paramCmGameInitParams.accessTokenRet = 0;
          }
          CmGameServerQIPCModule.a().a(paramStartCheckParam, paramLong, paramCmGameInitParams);
          QLog.d("cmgame_process.CmGameLoadingFragment", 1, new Object[] { "[onCheckGameFinish] resultCode=", Long.valueOf(paramLong) });
          if (paramStartCheckParam != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onCheckGameFinish mStartCheckParam == null");
        return;
        if ((CmGameLoadingFragment.a(this.a) == null) || (paramStartCheckParam.requestCode == CmGameLoadingFragment.a(this.a).requestCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onCheckGameFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
      return;
      if (paramLong != 0L)
      {
        a(paramStartCheckParam, paramLong);
        return;
      }
    } while (CmGameLoadingFragment.a(this.a) == null);
    CmGameLoadingFragment.a(this.a).a(paramStartCheckParam, paramLong);
  }
  
  public void c(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.c(paramStartCheckParam);
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e("cmgame_process.CmGameLoadingFragment", 1, "onGetGameData startCheckParam == null or game is null");
    }
    do
    {
      return;
      CmGameLoadingFragment.a(this.a).game = paramStartCheckParam.game;
    } while (CmGameLoadingFragment.a(this.a) == null);
    CmGameLoadingFragment.a(this.a).b(paramStartCheckParam);
  }
  
  public void e(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.e(paramStartCheckParam);
    if ((CmGameLoadingFragment.a(this.a) != null) && (CmGameLoadingFragment.a(this.a).statMap != null)) {
      CmGameLoadingFragment.a(this.a).statMap.put("download_game_res", Long.valueOf(1L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment.CmGameStartCheckListener
 * JD-Core Version:    0.7.0.1
 */