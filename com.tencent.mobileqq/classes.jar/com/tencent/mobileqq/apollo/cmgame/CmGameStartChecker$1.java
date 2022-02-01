package com.tencent.mobileqq.apollo.cmgame;

import alse;
import alvx;
import amja;
import amjj;
import amku;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class CmGameStartChecker$1
  implements Runnable
{
  CmGameStartChecker$1(CmGameStartChecker paramCmGameStartChecker) {}
  
  public void run()
  {
    if (CmGameStartChecker.a(this.this$0).game == null) {
      return;
    }
    if (CmGameStartChecker.a(this.this$0) != null)
    {
      localObject = (alse)CmGameStartChecker.a(this.this$0).get();
      if (localObject != null)
      {
        QLog.d("cmgame_process.CmGameStartChecker", 2, "gameCheckListener.onGameCheckStart startCheckParam:" + CmGameStartChecker.a(this.this$0));
        ((alse)localObject).onGameCheckStart(CmGameStartChecker.a(this.this$0));
      }
    }
    Object localObject = new amku(ApolloUtil.b(CmGameStartChecker.a(this.this$0).gameId) + "/" + "main.js.sig", ApolloUtil.a(CmGameStartChecker.a(this.this$0).gameId));
    boolean bool = amjj.a(CmGameStartChecker.a(this.this$0).isWhiteUsr, CmGameStartChecker.a(this.this$0).gameId);
    alvx.a(new Object[] { "[verifyRes], isNeedGameVerify:", Boolean.valueOf(bool) });
    if ((!bool) || (CmGameStartChecker.a(this.this$0).mGameType != 1) || (((amku)localObject).a(0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "verify pass startCheckParam:", CmGameStartChecker.a(this.this$0) });
      }
      localObject = new CmGameInitParams();
      ((CmGameInitParams)localObject).mGamePath = ApolloUtil.a(CmGameStartChecker.a(this.this$0).gameId);
      ((CmGameInitParams)localObject).mServerIp = amja.a();
      ((CmGameInitParams)localObject).mPort = amja.a();
      ((CmGameInitParams)localObject).mVersion = CmGameStartChecker.a(this.this$0).version;
      ((CmGameInitParams)localObject).mIsMaster = CmGameStartChecker.a(this.this$0).isCreator;
      ((CmGameInitParams)localObject).mGameMode = CmGameStartChecker.a(this.this$0).gameMode;
      ((CmGameInitParams)localObject).mGameEnter = CmGameStartChecker.a(this.this$0).enter;
      ((CmGameInitParams)localObject).mScreenMode = CmGameStartChecker.a(this.this$0).game.screenMode;
      ((CmGameInitParams)localObject).mViewMode = CmGameStartChecker.a(this.this$0).viewMode;
      if (!TextUtils.isEmpty(CmGameStartChecker.a(this.this$0).extendJson)) {
        ((CmGameInitParams)localObject).mGameParam = CmGameStartChecker.a(this.this$0).extendJson;
      }
      ((CmGameInitParams)localObject).mSrc = CmGameStartChecker.a(this.this$0).src;
      if (CmGameStartChecker.a(this.this$0).roomId != 0L) {
        ((CmGameInitParams)localObject).mRoomId = CmGameStartChecker.a(this.this$0).roomId;
      }
      ((CmGameInitParams)localObject).mRobotOpenId = CmGameStartChecker.a(this.this$0).mRobotOpenId;
      ((CmGameInitParams)localObject).mSessionId = CmGameStartChecker.a(this.this$0).sessionUin;
      if (CmGameStartChecker.b(this.this$0).get() != null) {
        ((CmGameInitParams)localObject).mSelfUin = ((AppInterface)CmGameStartChecker.b(this.this$0).get()).getCurrentAccountUin();
      }
      ((CmGameInitParams)localObject).mGameName = ("" + CmGameStartChecker.a(this.this$0).gameId);
      ((CmGameInitParams)localObject).mSessionType = CmGameStartChecker.a(this.this$0).sessionType;
      ((CmGameInitParams)localObject).mAioType = CmGameStartChecker.a(this.this$0).aioType;
      if ((CmGameStartChecker.a(this.this$0).src == 204) || (CmGameStartChecker.a(this.this$0).src == 220)) {
        ((CmGameInitParams)localObject).mAioType = 0;
      }
      ((CmGameInitParams)localObject).mExtraStr = CmGameStartChecker.a(this.this$0).mExtraStr;
      ((CmGameInitParams)localObject).mFriendUin = CmGameStartChecker.a(this.this$0).mFriendUin;
      ((CmGameInitParams)localObject).gender = CmGameStartChecker.a(this.this$0).gender;
      ((CmGameInitParams)localObject).isWhiteUsr = CmGameStartChecker.a(this.this$0).isWhiteUsr;
      ((CmGameInitParams)localObject).apolloStatus = CmGameStartChecker.a(this.this$0).apolloStatus;
      ((CmGameInitParams)localObject).mChineseName = CmGameStartChecker.a(this.this$0).game.name;
      ((CmGameInitParams)localObject).mActionId = CmGameStartChecker.a(this.this$0).game.actionId;
      ((CmGameInitParams)localObject).sessionOpenId = CmGameStartChecker.a(this.this$0).sessionOpenId;
      ((CmGameInitParams)localObject).extInfoFromSvr = CmGameStartChecker.a(this.this$0).extInfoFromSvr;
      ((CmGameInitParams)localObject).openId = CmGameStartChecker.a(this.this$0).openId;
      ((CmGameInitParams)localObject).gameType = CmGameStartChecker.a(this.this$0).gameTypeForRedPacket;
      ((CmGameInitParams)localObject).redUrl = CmGameStartChecker.a(this.this$0).redUrl;
      ((CmGameInitParams)localObject).adDevUin = CmGameStartChecker.a(this.this$0).adDevUin;
      ((CmGameInitParams)localObject).adForbidPosId = CmGameStartChecker.a(this.this$0).adForbidPosId;
      ((CmGameInitParams)localObject).adShareRate = CmGameStartChecker.a(this.this$0).adShareRate;
      ((CmGameInitParams)localObject).apolloGameSt = CmGameStartChecker.a(this.this$0).apolloGameSt;
      ((CmGameInitParams)localObject).apolloGameStkey = CmGameStartChecker.a(this.this$0).apolloGameStkey;
      ((CmGameInitParams)localObject).transInfo = CmGameStartChecker.a(this.this$0).transInfo;
      if (CmGameStartChecker.a(this.this$0) != null)
      {
        alse localalse = (alse)CmGameStartChecker.a(this.this$0).get();
        if (localalse != null)
        {
          QLog.d("cmgame_process.CmGameStartChecker", 2, "gameCheckListener.onGameCheckFinish startCheckParam:" + CmGameStartChecker.a(this.this$0));
          alvx.a(new Object[] { "[verifyRes], done" });
          localalse.onVerifyGameFinish(0L, CmGameStartChecker.a(this.this$0), (CmGameInitParams)localObject);
        }
      }
      ApolloGameStateMachine.a().a(2, "ApolloManager.startGame");
      try
      {
        ApolloUtil.a().edit().putLong(String.valueOf(CmGameStartChecker.a(this.this$0).gameId), NetConnInfoCenter.getServerTimeMillis()).commit();
        return;
      }
      catch (Exception localException)
      {
        return;
      }
    }
    QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "verify lua fail and delete local res startCheckParam=", CmGameStartChecker.a(this.this$0) });
    CmGameStartChecker.a(this.this$0, -13L);
    FileUtils.deleteDirectory(ApolloUtil.b(CmGameStartChecker.a(this.this$0).gameId));
    alvx.a(ApolloUtil.a(CmGameStartChecker.a(this.this$0).gameId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.1
 * JD-Core Version:    0.7.0.1
 */