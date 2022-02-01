package com.tencent.avgame.gamelogic.controller;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AnswerInfo;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.avgame.gamelogic.handler.GamePlayHandler;
import com.tencent.avgame.gamelogic.listener.GameResultListener;
import com.tencent.avgame.gamelogic.listener.GameStatusListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;
import com.tencent.avgame.gamelogic.listener.SyncListener;
import com.tencent.avgame.gamelogic.observer.GamePlayObserver;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.avgame.gamelogic.data.AnswerInfo;>;
import mqq.app.MobileQQ;

public class GameController
  extends GamePlayObserver
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new GameController.1(this));
  private GameResultListener jdField_a_of_type_ComTencentAvgameGamelogicListenerGameResultListener;
  private GameStatusListener jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener;
  private IDataCtrl<EngineData> jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl;
  private SyncListener jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener;
  BaseAVGameAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface;
  
  public GameController(BaseAVGameAppInterface paramBaseAVGameAppInterface, GameStatusListener paramGameStatusListener, GameResultListener paramGameResultListener, SyncListener paramSyncListener, IDataCtrl paramIDataCtrl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface = paramBaseAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener = paramGameStatusListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameResultListener = paramGameResultListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener = paramSyncListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl = paramIDataCtrl;
    paramBaseAVGameAppInterface.addObserver(this, false);
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, ITopic paramITopic, AnswerInfo paramAnswerInfo)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerWrong")) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onAnswerWrong [seq,rId,gId]=[%d,%d,%s] topic=%s answerInfo=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramITopic, paramAnswerInfo }));
    }
    paramString = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    paramString.jdField_a_of_type_Byte = 0;
    if (paramString.a(paramITopic, paramAnswerInfo, false)) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.h(paramString);
    }
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if ((paramLong1 != 0L) && (paramLong1 == localEngineData.a()) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase(localEngineData.b()))) {
      return true;
    }
    QLog.d("avgame_logic.GameController", 1, String.format("%s bValidSession=false [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString1 }));
    return false;
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBoolean = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a(paramLong2, paramLong1);
    } else {
      paramBoolean = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a(paramLong2, paramLong1, false);
    }
    if (!paramBoolean)
    {
      QLog.d("avgame_logic.GameController", 1, String.format("%s bValidSeq=false [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString1 }));
      return false;
    }
    return true;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onSendNormalVoiceAnswer.", new Object[0]));
    }
    IGameEngine.a().c();
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean, int paramInt3)
  {
    GamePlayHandler localGamePlayHandler = (GamePlayHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.c);
    if (paramBoolean)
    {
      localGamePlayHandler.a(paramInt1, paramString1, paramInt2, paramString2, paramLong, paramString3, paramInt3);
      return;
    }
    localGamePlayHandler.a(paramString1, paramInt2, paramString2, paramLong, paramString3);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (!a(paramLong2, paramString, paramLong1, "onGameOverPush")) {
      return;
    }
    if (!a(paramLong2, paramString, paramLong1, "onGameOverPush", true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onGameOverPush [seq,rId,gId]=[%d,%d,%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString }));
    }
    paramString = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if (paramString.c()) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.a(paramString, true);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a().updateRecogTxt("");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2, ITopic paramITopic, Player paramPlayer, long paramLong3, AnswerInfo paramAnswerInfo)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush")) {
      return;
    }
    if (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush", true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onAnswerRightPush [seq,rId,gId]=[%d,%d,%s] score=%d, player=%s, topic=%s, actorScore=%d, combo=%d answerInfo=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Integer.valueOf(paramInt1), paramPlayer, paramITopic, Integer.valueOf(paramInt2), Long.valueOf(paramLong3), paramAnswerInfo.toString() }));
    }
    EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    String str = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getAccount();
    boolean bool = str.equals(paramPlayer.uin);
    if ((localEngineData.g()) && (!localEngineData.h()))
    {
      if (!str.equals(String.valueOf(paramAnswerInfo.uin))) {
        if (paramAnswerInfo.answer_result == 1)
        {
          if (localEngineData.a(paramITopic, paramInt1, paramPlayer, paramLong3, paramInt2, paramAnswerInfo, false)) {
            this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.b(localEngineData, paramInt1);
          }
        }
        else {
          a(paramLong1, paramLong2, paramString, paramITopic, paramAnswerInfo);
        }
      }
    }
    else if (((!localEngineData.g()) || (localEngineData.h()) || (!bool)) && (localEngineData.a(paramITopic, paramInt1, paramPlayer, paramLong3, paramInt2, paramAnswerInfo, true))) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.b(localEngineData, paramInt1);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onReceiveTranlationResultInfo [uin,translationTime,playGameId,answer]=[%d,%d,%s,%s] ", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(paramInt), paramString2, paramString3 }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.a(paramLong3, paramInt, paramString2, paramString3);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, ITopic paramITopic)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush")) {
      return;
    }
    if (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush", true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onAnswerTimeoutPush [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramITopic }));
    }
    paramString = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if (paramString.c(paramITopic)) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.h(paramString);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, ITopic paramITopic, Player paramPlayer)
  {
    if (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush")) {
      return;
    }
    if (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush", true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onPlayerChangePush [seq,rId,gId]=[%d,%d,%s] player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramPlayer, paramITopic }));
    }
    paramString = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if (paramString.a(paramPlayer, paramITopic)) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.g(paramString);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, ITopic paramITopic, String paramString2)
  {
    if (!a(paramLong2, paramString1, paramLong1, "onTopicChangePush")) {
      return;
    }
    if (!a(paramLong2, paramString1, paramLong1, "onTopicChangePush", true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onTopicChangePush [[seq,rId,gId]=[%d,%d,%s] switcherUin=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, paramITopic }));
    }
    paramString1 = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if (paramString1.a(paramITopic))
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.a(paramString1, paramString2);
      if ((GameUtil.b(paramString1.c())) && (paramString1.a().size() == 0)) {
        b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b());
      }
    }
    if (IGameEngine.a().f()) {
      ReportController.b(null, "dc00898", "", "", "0X800B8C4", "0X800B8C4", paramString1.d(), 0, String.valueOf(paramString1.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.winRound + 1), "", "", "");
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, GameInfo paramGameInfo, Player paramPlayer, ITopic paramITopic)
  {
    EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if ((paramLong2 != 0L) && (localEngineData.a() == paramLong2))
    {
      if (!a(paramLong2, paramString, paramLong1, "onGameStartPush", true)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onGameStartPush [seq,rId,gId]=[%d,%d,%s] gInfo=%s, player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramGameInfo, paramPlayer, paramITopic }));
      }
      localEngineData.a(Game.a(paramLong2, paramString, paramGameInfo, paramPlayer, paramITopic));
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.f(localEngineData);
      if (GameUtil.b(localEngineData.c())) {
        b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin(), localEngineData.a(), localEngineData.b());
      }
      if (IGameEngine.a().f()) {
        ReportController.b(null, "dc00898", "", "", "0X800B8C4", "0X800B8C4", localEngineData.d(), 0, String.valueOf(localEngineData.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.winRound + 1), "", "", "");
      }
      return;
    }
    QLog.d("avgame_logic.GameController", 1, String.format("onGameStartPush bValidSession=false seq=%d roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, ITopic paramITopic)
  {
    if (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush")) {
      return;
    }
    if (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush", true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onAnswerExposurePush [seq,rId,gId]=[%d,%d,%s] tips=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, paramITopic }));
    }
    paramString1 = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if (paramString1.d(paramITopic)) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.e(paramString2, paramString1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, Player paramPlayer)
  {
    if (!a(paramLong2, paramString1, paramLong1, "onNextPlayerTipPush")) {
      return;
    }
    if (!a(paramLong2, paramString1, paramLong1, "onNextPlayerTipPush", true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onNextPlayerTipPush [seq,rId,gId]=[%d,%d,%s] tips=%s, player=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, paramPlayer }));
    }
    paramString1 = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if (paramString1.a(paramPlayer)) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.d(paramString2, paramString1);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, List<AnswerInfo> paramList, ITopic paramITopic, int paramInt)
  {
    if (!a(paramLong2, paramString, paramLong1, "onReceiveAnswerFinishInfo")) {
      return;
    }
    if (!a(paramLong2, paramString, paramLong1, "onReceiveAnswerFinishInfo", true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onReceiveAnswerFinishInfo", new Object[0]));
    }
    Object localObject = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    Iterator localIterator1 = paramList.iterator();
    int i = 0;
    int j = 0;
    paramList = (List<AnswerInfo>)localObject;
    while (localIterator1.hasNext())
    {
      AnswerInfo localAnswerInfo = (AnswerInfo)localIterator1.next();
      if (this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getAccount().equals(String.valueOf(localAnswerInfo.uin)))
      {
        j = 1;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameController", 2, String.format("onReceiveAnswerFinishInfo [seq,rId,gId]=[%d,%d,%s] topic=%s answerInfo=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramITopic, localAnswerInfo }));
        }
        Iterator localIterator2 = paramList.a().getPlayers().iterator();
        localObject = null;
        while (localIterator2.hasNext())
        {
          Player localPlayer = (Player)localIterator2.next();
          if (localPlayer.uin.equals(String.valueOf(localAnswerInfo.uin)))
          {
            localObject = localPlayer;
            i = 1;
          }
        }
        if (paramList.b()) {
          if (localAnswerInfo.answer_result == 1)
          {
            if (paramList.a(paramList.a(), paramInt, (Player)localObject, 0L, 0, localAnswerInfo, true)) {
              this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.b(paramList, paramInt);
            }
          }
          else {
            a(paramLong1, paramLong2, paramString, paramList.a(), localAnswerInfo);
          }
        }
      }
    }
    paramList.jdField_a_of_type_Byte = 0;
    if (i == 0) {
      paramList.jdField_a_of_type_Byte = ((byte)(paramList.jdField_a_of_type_Byte | 0x2));
    }
    if (j == 0) {
      paramList.jdField_a_of_type_Byte = ((byte)(paramList.jdField_a_of_type_Byte | 0x1));
    }
    if ((paramList.jdField_a_of_type_Byte > 0) && (paramList.c(paramList.a()))) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.h(paramList);
    }
    paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramString.obj = paramITopic;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 2000L);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, ITopic paramITopic)
  {
    if (!a(paramLong1, paramString, paramLong2, "onSwitchTopicSuc")) {
      return;
    }
    if (!a(paramLong1, paramString, paramLong2, "onSwitchTopicSuc", false)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onSwitchTopicSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, paramITopic }));
    }
    paramString = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if (paramString.a(paramITopic))
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.d(paramString);
      if ((GameUtil.b(paramString.c())) && (paramString.a().size() == 0)) {
        b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin(), paramString.a(), paramString.b());
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onSwitchTopicFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.a(paramLong, paramString1, paramString2);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, RoomInfo paramRoomInfo, List<Long> paramList)
  {
    QLog.d("avgame_logic.GameController", 1, String.format("onStartGameFail uin=%s roomId=%d gameType=%d errCode=%d, errMsg=%s", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    if (IGameEngine.a().f()) {
      AVGameExceptionReporter.a().a(9, null, String.valueOf(paramInt2), paramString2);
    }
    if ((paramRoomInfo != null) && (paramInt2 == 405)) {
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramRoomInfo, false);
    }
    if (paramInt2 == 406)
    {
      paramString2 = "";
      RoomInfo localRoomInfo = ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a();
      Object localObject = paramString2;
      if (paramList != null)
      {
        localObject = paramString2;
        if (paramList.size() > 0)
        {
          localObject = paramString2;
          if (paramRoomInfo != null)
          {
            paramList = paramList.iterator();
            for (;;)
            {
              localObject = paramString2;
              if (!paramList.hasNext()) {
                break;
              }
              paramRoomInfo = localRoomInfo.getNick(((Long)paramList.next()).toString());
              if ((paramRoomInfo != null) && (paramRoomInfo.length() > 0)) {
                if (paramString2.length() > 0)
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(paramString2);
                  ((StringBuilder)localObject).append("、");
                  ((StringBuilder)localObject).append(paramRoomInfo);
                  paramString2 = ((StringBuilder)localObject).toString();
                }
                else
                {
                  paramString2 = paramRoomInfo;
                }
              }
            }
          }
        }
      }
      paramString2 = MobileQQ.sMobileQQ;
      paramString2 = String.format(MobileQQ.getContext().getResources().getString(2131690315), new Object[] { localObject });
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, GameInfo paramGameInfo, Player paramPlayer, ITopic paramITopic)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin().equals(paramString1)) && (paramLong1 != 0L) && (paramLong1 == ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a()) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a(paramLong2, paramLong1, false))
      {
        QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSeq=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onStartGameSuc uin=%s type=%d [seq,rId,gId]=[%d,%d,%s], gInfo=%s player=%s topic=%s", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2, paramGameInfo, paramPlayer, paramITopic }));
      }
      paramString1 = Game.a(paramLong1, paramString2, paramGameInfo, paramPlayer, paramITopic);
      paramString2 = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
      paramString2.a(paramString1);
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.c(paramString2);
      if (GameUtil.b(paramString2.c())) {
        b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin(), paramString2.a(), paramString2.b());
      }
      if (IGameEngine.a().f()) {
        ReportController.b(null, "dc00898", "", "", "0X800B8C4", "0X800B8C4", paramString2.d(), 0, String.valueOf(paramString2.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.winRound + 1), "", "", "");
      }
      return;
    }
    QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSession=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.a(paramString1, paramLong1, paramInt, -1, MobileQQ.sMobileQQ.getResources().getString(2131690464));
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    ((GamePlayHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.c)).a(paramString1, paramLong, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    ((GamePlayHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.c)).a(paramString1, paramLong, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((GamePlayHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.c)).a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListFail gId=%s msg=%s", new Object[] { paramString2, paramString3 }));
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameResultListener.a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, List<UserScore> paramList)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListSuc gId=%s scoreListSize=%d", new Object[] { paramString2, Integer.valueOf(paramList.size()) }));
    paramString1 = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if (paramString2 != null)
    {
      if (!paramString2.equalsIgnoreCase(paramString1.b())) {
        return;
      }
      if (paramString1.a(paramList)) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameResultListener.i(paramString1);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString1, boolean paramBoolean2, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onSendClickAnswer.isSuc=%b errCode=%d errMsg=%s answerRight=%b rightAnswer=%s score=%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt1), paramString1, Boolean.valueOf(paramBoolean2), paramString2, Integer.valueOf(paramInt2) }));
    }
    IGameEngine.a().c();
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameController", 1, String.format("onUploadResourceResult isSucc=%b gId=%s filetype=%d url=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameResultListener.a(paramBoolean, paramString1, paramInt, paramString2);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2, ITopic paramITopic)
  {
    if (!a(paramLong1, paramString, paramLong2, "onSwitchTopicSuc")) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onPullTopicsSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, paramITopic }));
    }
    EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if (localEngineData.b(paramITopic))
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.e(localEngineData);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.b(paramLong1, paramString, "");
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onPullTopicsFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = MobileQQ.sMobileQQ;
      str = MobileQQ.getContext().getResources().getString(2131690434);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameStatusListener.b(paramLong, paramString1, str);
  }
  
  public void b(String paramString1, long paramLong, String paramString2)
  {
    ((GamePlayHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.c)).a(paramString1, paramLong, paramString2, true);
  }
  
  protected void b(boolean paramBoolean1, int paramInt1, String paramString1, boolean paramBoolean2, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onSendPKVoiceAnswer.isSuc=%b errCode=%d errMsg=%s answerRight=%b rightAnswer=%s score=%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt1), paramString1, Boolean.valueOf(paramBoolean2), paramString2, Integer.valueOf(paramInt2) }));
    }
    IGameEngine.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameController
 * JD-Core Version:    0.7.0.1
 */