package com.tencent.mobileqq.apollo.game;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.RSAVerify;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
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
      localObject1 = (OnGameStartCheckListener)CmGameStartChecker.a(this.this$0).get();
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("gameCheckListener.onGameCheckStart startCheckParam:");
        ((StringBuilder)localObject2).append(CmGameStartChecker.a(this.this$0));
        QLog.d("cmgame_process.CmGameStartChecker", 2, ((StringBuilder)localObject2).toString());
        ((OnGameStartCheckListener)localObject1).c(CmGameStartChecker.a(this.this$0));
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ApolloUtilImpl.getApolloGameResPath(CmGameStartChecker.a(this.this$0).gameId));
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append("main.js.sig");
    localObject1 = new RSAVerify(((StringBuilder)localObject1).toString(), ApolloUtilImpl.getApolloGameLuaPath(CmGameStartChecker.a(this.this$0).gameId));
    if ((ApolloGameRscVerify.a(CmGameStartChecker.a(this.this$0).isWhiteUsr, CmGameStartChecker.a(this.this$0).gameId)) && (CmGameStartChecker.a(this.this$0).mGameType == 1) && (!((RSAVerify)localObject1).a(0)))
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "verify lua fail and delete local res startCheckParam=", CmGameStartChecker.a(this.this$0) });
      CmGameStartChecker.a(this.this$0, -13L);
      FileUtils.deleteDirectory(ApolloUtilImpl.getApolloGameResPath(CmGameStartChecker.a(this.this$0).gameId));
      CmGameUtil.a(ApolloUtilImpl.getApolloGameLuaPath(CmGameStartChecker.a(this.this$0).gameId));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "verify pass startCheckParam:", CmGameStartChecker.a(this.this$0) });
    }
    localObject1 = new CmGameInitParams();
    ((CmGameInitParams)localObject1).mGamePath = ApolloUtilImpl.getApolloGameLuaPath(CmGameStartChecker.a(this.this$0).gameId);
    ((CmGameInitParams)localObject1).mServerIp = ApolloGameBasicEventUtil.a();
    ((CmGameInitParams)localObject1).mPort = ApolloGameBasicEventUtil.a();
    ((CmGameInitParams)localObject1).mVersion = CmGameStartChecker.a(this.this$0).version;
    ((CmGameInitParams)localObject1).mIsMaster = CmGameStartChecker.a(this.this$0).isCreator;
    ((CmGameInitParams)localObject1).mGameMode = CmGameStartChecker.a(this.this$0).gameMode;
    ((CmGameInitParams)localObject1).mGameEnter = CmGameStartChecker.a(this.this$0).enter;
    ((CmGameInitParams)localObject1).mScreenMode = CmGameStartChecker.a(this.this$0).game.screenMode;
    ((CmGameInitParams)localObject1).mViewMode = CmGameStartChecker.a(this.this$0).viewMode;
    if (!TextUtils.isEmpty(CmGameStartChecker.a(this.this$0).extendJson)) {
      ((CmGameInitParams)localObject1).mGameParam = CmGameStartChecker.a(this.this$0).extendJson;
    }
    ((CmGameInitParams)localObject1).mSrc = CmGameStartChecker.a(this.this$0).src;
    if (CmGameStartChecker.a(this.this$0).roomId != 0L) {
      ((CmGameInitParams)localObject1).mRoomId = CmGameStartChecker.a(this.this$0).roomId;
    }
    ((CmGameInitParams)localObject1).mRobotOpenId = CmGameStartChecker.a(this.this$0).mRobotOpenId;
    ((CmGameInitParams)localObject1).mSessionId = CmGameStartChecker.a(this.this$0).sessionUin;
    if (CmGameStartChecker.b(this.this$0).get() != null) {
      ((CmGameInitParams)localObject1).mSelfUin = ((AppInterface)CmGameStartChecker.b(this.this$0).get()).getCurrentAccountUin();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(CmGameStartChecker.a(this.this$0).gameId);
    ((CmGameInitParams)localObject1).mGameName = ((StringBuilder)localObject2).toString();
    ((CmGameInitParams)localObject1).mSessionType = CmGameStartChecker.a(this.this$0).sessionType;
    ((CmGameInitParams)localObject1).mAioType = CmGameStartChecker.a(this.this$0).aioType;
    if ((CmGameStartChecker.a(this.this$0).src == 204) || (CmGameStartChecker.a(this.this$0).src == 220)) {
      ((CmGameInitParams)localObject1).mAioType = 0;
    }
    ((CmGameInitParams)localObject1).mExtraStr = CmGameStartChecker.a(this.this$0).mExtraStr;
    ((CmGameInitParams)localObject1).mFriendUin = CmGameStartChecker.a(this.this$0).mFriendUin;
    ((CmGameInitParams)localObject1).gender = CmGameStartChecker.a(this.this$0).gender;
    ((CmGameInitParams)localObject1).isWhiteUsr = CmGameStartChecker.a(this.this$0).isWhiteUsr;
    ((CmGameInitParams)localObject1).apolloStatus = CmGameStartChecker.a(this.this$0).apolloStatus;
    ((CmGameInitParams)localObject1).mChineseName = CmGameStartChecker.a(this.this$0).game.name;
    ((CmGameInitParams)localObject1).mActionId = CmGameStartChecker.a(this.this$0).game.actionId;
    ((CmGameInitParams)localObject1).sessionOpenId = CmGameStartChecker.a(this.this$0).sessionOpenId;
    ((CmGameInitParams)localObject1).extInfoFromSvr = CmGameStartChecker.a(this.this$0).extInfoFromSvr;
    ((CmGameInitParams)localObject1).openId = CmGameStartChecker.a(this.this$0).openId;
    ((CmGameInitParams)localObject1).gameType = CmGameStartChecker.a(this.this$0).gameTypeForRedPacket;
    ((CmGameInitParams)localObject1).redUrl = CmGameStartChecker.a(this.this$0).redUrl;
    ((CmGameInitParams)localObject1).adDevUin = CmGameStartChecker.a(this.this$0).adDevUin;
    ((CmGameInitParams)localObject1).adForbidPosId = CmGameStartChecker.a(this.this$0).adForbidPosId;
    ((CmGameInitParams)localObject1).adShareRate = CmGameStartChecker.a(this.this$0).adShareRate;
    ((CmGameInitParams)localObject1).apolloGameSt = CmGameStartChecker.a(this.this$0).apolloGameSt;
    ((CmGameInitParams)localObject1).apolloGameStkey = CmGameStartChecker.a(this.this$0).apolloGameStkey;
    ((CmGameInitParams)localObject1).transInfo = CmGameStartChecker.a(this.this$0).transInfo;
    if (CmGameStartChecker.a(this.this$0) != null)
    {
      localObject2 = (OnGameStartCheckListener)CmGameStartChecker.a(this.this$0).get();
      if (localObject2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gameCheckListener.onGameCheckFinish startCheckParam:");
        localStringBuilder.append(CmGameStartChecker.a(this.this$0));
        QLog.d("cmgame_process.CmGameStartChecker", 2, localStringBuilder.toString());
        ((OnGameStartCheckListener)localObject2).b(0L, CmGameStartChecker.a(this.this$0), (CmGameInitParams)localObject1);
      }
    }
    ApolloGameStateMachine.a().a(2, "ApolloManager.startGame");
    try
    {
      ApolloUtilImpl.getGameResSp().edit().putLong(String.valueOf(CmGameStartChecker.a(this.this$0).gameId), NetConnInfoCenter.getServerTimeMillis()).commit();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "startGame error, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameStartChecker.1
 * JD-Core Version:    0.7.0.1
 */