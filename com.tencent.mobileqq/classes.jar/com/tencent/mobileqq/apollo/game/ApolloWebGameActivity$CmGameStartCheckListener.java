package com.tencent.mobileqq.apollo.game;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class ApolloWebGameActivity$CmGameStartCheckListener
  extends CmGameStartChecker.DefaultGameCheckListener
{
  public ApolloWebGameActivity$CmGameStartCheckListener(ApolloWebGameActivity paramApolloWebGameActivity, AppInterface paramAppInterface)
  {
    super(paramAppInterface, false);
  }
  
  public void a(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloWebGameActivity.a(this.a)) {
      return;
    }
    QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[onGameCheckFinish] resultCode=", Long.valueOf(paramLong) });
    if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null))
    {
      if ((ApolloWebGameActivity.a(this.a) != null) && (paramStartCheckParam.requestCode != ApolloWebGameActivity.a(this.a).requestCode))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
        }
        return;
      }
      if (paramLong != 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish resultCode != 0");
        }
        paramCmGameInitParams = ApolloWebGameActivity.a(this.a).obtainMessage(17);
        paramCmGameInitParams.obj = paramStartCheckParam.wordingV2;
        ApolloWebGameActivity.a(this.a).sendMessage(paramCmGameInitParams);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish mStartCheckParam == null || mStartCheckParam.game == null");
    }
  }
  
  public void a(StartCheckParam paramStartCheckParam)
  {
    super.a(paramStartCheckParam);
    if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null))
    {
      ApolloWebGameActivity.a(this.a).game = paramStartCheckParam.game;
      if (ApolloWebGameActivity.a(this.a) != null) {
        ApolloWebGameActivity.a(this.a).a(ApolloWebGameActivity.a(this.a));
      }
      return;
    }
    QLog.e("cmgame_process.ApolloWebGameActivity", 1, "onGetGameData startCheckParam == null or game is null");
  }
  
  public void a(StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    if (ApolloWebGameActivity.a(this.a)) {
      return;
    }
    if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null))
    {
      if ((ApolloWebGameActivity.a(this.a) != null) && (paramStartCheckParam.requestCode != ApolloWebGameActivity.a(this.a).requestCode))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
        }
        return;
      }
      if (paramICmGameConfirmListener != null) {
        paramICmGameConfirmListener.a(paramStartCheckParam);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
    }
  }
  
  public void b(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloWebGameActivity.a(this.a)) {
      return;
    }
    QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[onVerifyGameFinish] resultCode=", Long.valueOf(paramLong) });
    if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null))
    {
      if ((ApolloWebGameActivity.a(this.a) != null) && (paramStartCheckParam.requestCode != ApolloWebGameActivity.a(this.a).requestCode))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onVerifyGameFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
        }
        return;
      }
      if (paramLong != 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onVerifyGameFinish resultCode != 0");
        }
        paramCmGameInitParams = ApolloWebGameActivity.a(this.a).obtainMessage(17);
        paramCmGameInitParams.obj = paramStartCheckParam.wordingV2;
        ApolloWebGameActivity.a(this.a).sendMessage(paramCmGameInitParams);
        return;
      }
      ApolloWebGameActivity.a(this.a).startCallEngine = System.currentTimeMillis();
      ApolloGameStateMachine.a().a(1, "ApolloWebGameActivity.openGame");
      ApolloGameStateMachine.a().a(2, "ApolloWebGameActivity.openGame");
      if (ApolloWebGameActivity.a(this.a) != null) {
        ApolloWebGameActivity.a(this.a).a(this.a, paramCmGameInitParams);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onVerifyGameFinish mStartCheckParam == null || mStartCheckParam.game == null");
    }
  }
  
  public void b(StartCheckParam paramStartCheckParam)
  {
    if (ApolloWebGameActivity.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      if (paramStartCheckParam == null) {
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "showGameLifeTip mStartCheckParam is null");
      } else {
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
      }
    }
    a(-1L, paramStartCheckParam, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebGameActivity.CmGameStartCheckListener
 * JD-Core Version:    0.7.0.1
 */