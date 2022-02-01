package com.tencent.avgame.gamelogic.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.business.handler.AVGameBusinessHandler;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.IGame;
import com.tencent.avgame.gamelogic.QualityReporter;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.PkCJOperationData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.QuestionClassInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.PKDrawRes;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.Pair;
import com.tencent.avgame.gamelogic.observer.GameRoomObserver;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.localvoicerecog.AVGameVoiceRecog;
import com.tencent.avgame.util.AVGameCmdUtil;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import trpc.qq_vgame.activity_center.ActivityCenter.GetActivitysReq;
import trpc.qq_vgame.activity_center.ActivityCenter.GetActivitysRsp;
import trpc.qq_vgame.activity_center.ActivityCenter.SyncShareGameReq;
import trpc.qq_vgame.activity_center.ActivityCenter.SyncShareGameRsp;
import trpc.qq_vgame.common.AvGameCommon.GameStatusInfo;
import trpc.qq_vgame.common.AvGameCommon.PKUserRankInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;
import trpc.qq_vgame.common.AvGameCommon.UinWrap;
import trpc.qq_vgame.game_list.AvGameList.CmdGameListReq;
import trpc.qq_vgame.game_list.AvGameList.CmdGameListRsp;
import trpc.qq_vgame.game_list.AvGameList.CmdGetQuestionClassReq;
import trpc.qq_vgame.game_list.AvGameList.CmdGetQuestionClassRsp;
import trpc.qq_vgame.game_list.AvGameList.GameListItemInfo;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfo;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKPoolUserChange;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserCreateRoom;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserDraw;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserEnterRoom;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserFail;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserFinalSucc;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserPass;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserSucc;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyRoomMatchStatus;
import trpc.qq_vgame.nofity.AvGameNotify.PKDrawRes;
import trpc.qq_vgame.nofity.AvGameNotify.RoomDestoryS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomOwnerChangeGameS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomUserChangeStatusS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomUserEnterS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomUserExitS2CReq;
import trpc.qq_vgame.pk_manager.AvGamePkManager.GetPKInfoReq;
import trpc.qq_vgame.pk_manager.AvGamePkManager.PKOperationReq;
import trpc.qq_vgame.pk_manager.AvGamePkManager.PKOperationRsp;
import trpc.qq_vgame.playgame.AvGamePlay.SelectGameReq;
import trpc.qq_vgame.playgame.AvGamePlay.SelectGameRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomInfoReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomInfoRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveRsp;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkReq;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkRsp;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.AddMatchRoomReq;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.AddMatchRoomRsp;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.DelMatchRoomReq;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.DelMatchRoomRsp;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.AddMatchRoomReq;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.AddMatchRoomRsp;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.DelMatchRoomReq;
import trpc.qq_vgame.user_heartbeat.AvGameHeartBeat.CmdUserHeartBeatReq;
import trpc.qq_vgame.user_heartbeat.AvGameHeartBeat.CmdUserHeartBeatRsp;

public class GameRoomHandler
  extends AVGameBusinessHandler
{
  public GameRoomHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private SurvivalPkResultInfo.PKDrawRes a(AvGameNotify.PKDrawRes paramPKDrawRes)
  {
    SurvivalPkResultInfo.PKDrawRes localPKDrawRes = null;
    if (paramPKDrawRes != null) {
      localPKDrawRes = new SurvivalPkResultInfo.PKDrawRes(paramPKDrawRes.is_draw.get(), paramPKDrawRes.self_cost.get(), paramPKDrawRes.peer_cost.get());
    }
    return localPKDrawRes;
  }
  
  private List<SurvivalPkResultInfo.Pair<Integer, Long>> a(List<AvGameCommon.PKUserRankInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AvGameCommon.PKUserRankInfo localPKUserRankInfo = (AvGameCommon.PKUserRankInfo)paramList.next();
      localArrayList.add(new SurvivalPkResultInfo.Pair(Integer.valueOf(localPKUserRankInfo.rank.get()), Long.valueOf(localPKUserRankInfo.uin.get())));
    }
    return localArrayList;
  }
  
  private void a(List<AvGameList.GameListItemInfo> paramList, List<GameItem> paramList1)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AvGameList.GameListItemInfo localGameListItemInfo = (AvGameList.GameListItemInfo)paramList.next();
        if (localGameListItemInfo != null)
        {
          GameItem localGameItem = new GameItem();
          localGameItem.a(localGameListItemInfo);
          paramList1.add(localGameItem);
        }
      }
    }
  }
  
  private void a(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    if (!a(paramNotifyMsg))
    {
      QLog.d("avgame_logic.GameRoomHandler", 2, "handlePkUserMatchTimeout() poolId or pkId wrong ");
      return;
    }
    ObserverCenter.a().b(GameRoomObserver.class, 28, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  private void a(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2, String paramString)
  {
    paramNotifyMsg = (AvGameNotify.NotifyRoomMatchStatus)paramNotifyMsg.room_match_status.get();
    GameUtil.a("avgame_logic.GameRoomHandler", "NT_ROOM_MATCH_STATUS", null, new MessageMicro[] { paramNotifyMsg });
    if (paramNotifyMsg != null) {
      ObserverCenter.a().b(GameRoomObserver.class, 25, true, new Object[] { Long.valueOf(paramNotifyMsg.roomid.get()), Integer.valueOf(paramNotifyMsg.status.get()) });
    }
  }
  
  private void a(AvGameRoomManager.CmdRoomInfoRsp paramCmdRoomInfoRsp) {}
  
  private void a(boolean paramBoolean, AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong)
  {
    if (!a(paramNotifyMsg))
    {
      QLog.d("avgame_logic.GameRoomHandler", 2, "handlePkRoomCreateOrEnterPush() poolId or pkId wrong ");
      return;
    }
    long l1;
    long l2;
    if (paramBoolean)
    {
      AvGameNotify.NotifyPKUserCreateRoom localNotifyPKUserCreateRoom = (AvGameNotify.NotifyPKUserCreateRoom)paramNotifyMsg.pk_user_create_room.get();
      GameEngine.a().a().b(paramNotifyMsg.realPoolID.get());
      l1 = 0L;
      l2 = 0L;
    }
    for (;;)
    {
      ObserverCenter.a().b(GameRoomObserver.class, 26, true, new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), Long.valueOf(l2), Boolean.valueOf(true), Long.valueOf(l1) });
      return;
      paramNotifyMsg = (AvGameNotify.NotifyPKUserEnterRoom)paramNotifyMsg.pk_user_enter_room.get();
      l2 = paramNotifyMsg.roomid.get();
      l1 = paramNotifyMsg.peer_uin.get();
      GameUtil.a("avgame_logic.GameRoomHandler", "handlePkRoomCreateOrEnterPush", null, new MessageMicro[] { paramNotifyMsg });
    }
  }
  
  private boolean a(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    int i = paramNotifyMsg.poolID.get();
    int j = paramNotifyMsg.realPoolID.get();
    int k = paramNotifyMsg.pkID.get();
    int m = GameEngine.a().a().jdField_b_of_type_Int;
    if (((m != i) && (m != j)) || ((GameEngine.a().a().c != k) && (m != 0)))
    {
      QLog.d("avgame_logic.GameRoomHandler", 2, "checkPkPushValid() " + i + " " + j + " " + m);
      return false;
    }
    return true;
  }
  
  private List<Long> b(List<AvGameCommon.UinWrap> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Long.valueOf(((AvGameCommon.UinWrap)paramList.next()).uin.get()));
    }
    return localArrayList;
  }
  
  private void b(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    if (paramNotifyMsg.poolID.get() == GameEngine.a().a().j()) {
      GameEngine.a().a().b(paramNotifyMsg.realPoolID.get());
    }
  }
  
  private void b(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    GameUtil.a("avgame_logic.GameRoomHandler", "handlePkEndUserResult", null, new MessageMicro[] { paramNotifyMsg });
    if (!a(paramNotifyMsg)) {
      QLog.d("avgame_logic.GameRoomHandler", 2, "handlePkEndUserResult() poolId or pkId wrong ");
    }
    int i;
    label486:
    label491:
    label638:
    do
    {
      return;
      i = paramNotifyMsg.type.get();
      if (i == 503)
      {
        paramNotifyMsg = (AvGameNotify.NotifyPKUserSucc)paramNotifyMsg.pk_user_succ.get();
        localObject = new SurvivalPkResultInfo();
        ((SurvivalPkResultInfo)localObject).winReason = paramNotifyMsg.reason.get();
        ((SurvivalPkResultInfo)localObject).winRound = paramNotifyMsg.cur_round.get();
        if (paramNotifyMsg.draw_res.has()) {
          ((SurvivalPkResultInfo)localObject).pkDrawRes = a((AvGameNotify.PKDrawRes)paramNotifyMsg.draw_res.get());
        }
        ((SurvivalPkResultInfo)localObject).winTips = paramNotifyMsg.win_tip.get();
        ((SurvivalPkResultInfo)localObject).score = paramNotifyMsg.score.get();
        ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(1), Boolean.valueOf(false), localObject });
        return;
      }
      SurvivalPkResultInfo localSurvivalPkResultInfo;
      if (i == 505)
      {
        localObject = (AvGameNotify.NotifyPKUserFail)paramNotifyMsg.pk_user_fail.get();
        localSurvivalPkResultInfo = new SurvivalPkResultInfo();
        if (localObject != null)
        {
          localSurvivalPkResultInfo.gameSur = false;
          localSurvivalPkResultInfo.rank = ((AvGameNotify.NotifyPKUserFail)localObject).rank.get();
          localSurvivalPkResultInfo.total = ((AvGameNotify.NotifyPKUserFail)localObject).total.get();
          localSurvivalPkResultInfo.hasAward = ((AvGameNotify.NotifyPKUserFail)localObject).has_consolation_award.get();
          localSurvivalPkResultInfo.awardText = ((AvGameNotify.NotifyPKUserFail)localObject).award_str.get().toStringUtf8();
          localSurvivalPkResultInfo.awardUrl = ((AvGameNotify.NotifyPKUserFail)localObject).award_url.get().toStringUtf8();
          if (!((AvGameNotify.NotifyPKUserFail)localObject).award_url_str.has()) {
            break label486;
          }
          paramNotifyMsg = ((AvGameNotify.NotifyPKUserFail)localObject).award_url_str.get().toStringUtf8();
          localSurvivalPkResultInfo.awardUrlStr = paramNotifyMsg;
          localSurvivalPkResultInfo.delayAward = ((AvGameNotify.NotifyPKUserFail)localObject).delay_award.get();
          if (!((AvGameNotify.NotifyPKUserFail)localObject).delay_award_tip.has()) {
            break label491;
          }
        }
        for (paramNotifyMsg = ((AvGameNotify.NotifyPKUserFail)localObject).delay_award_tip.get().toStringUtf8();; paramNotifyMsg = null)
        {
          localSurvivalPkResultInfo.delayAwardTip = paramNotifyMsg;
          if (((AvGameNotify.NotifyPKUserFail)localObject).draw_res.has()) {
            localSurvivalPkResultInfo.pkDrawRes = a((AvGameNotify.PKDrawRes)((AvGameNotify.NotifyPKUserFail)localObject).draw_res.get());
          }
          localSurvivalPkResultInfo.isBothClose = ((AvGameNotify.NotifyPKUserFail)localObject).both_lose.get();
          localSurvivalPkResultInfo.score = ((AvGameNotify.NotifyPKUserFail)localObject).score.get();
          ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(2), Boolean.valueOf(true), localSurvivalPkResultInfo });
          return;
          paramNotifyMsg = null;
          break;
        }
      }
      boolean bool;
      if (i == 504)
      {
        localObject = (AvGameNotify.NotifyPKUserFinalSucc)paramNotifyMsg.pk_user_final_succ.get();
        localSurvivalPkResultInfo = new SurvivalPkResultInfo();
        if (localObject != null)
        {
          localSurvivalPkResultInfo.gameSur = true;
          localSurvivalPkResultInfo.winReason = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).reason.get();
          localSurvivalPkResultInfo.awardText = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).award_str.get().toStringUtf8();
          localSurvivalPkResultInfo.awardUrl = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).award_url.get().toStringUtf8();
          if (TextUtils.isEmpty(localSurvivalPkResultInfo.awardUrl)) {
            break label823;
          }
          bool = true;
          localSurvivalPkResultInfo.hasAward = bool;
          localSurvivalPkResultInfo.total = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).total.get();
          if (!((AvGameNotify.NotifyPKUserFinalSucc)localObject).award_url_str.has()) {
            break label829;
          }
          paramNotifyMsg = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).award_url_str.get().toStringUtf8();
          localSurvivalPkResultInfo.awardUrlStr = paramNotifyMsg;
          localSurvivalPkResultInfo.delayAward = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).delay_award.get();
          if (!((AvGameNotify.NotifyPKUserFinalSucc)localObject).delay_award_tip.has()) {
            break label834;
          }
          paramNotifyMsg = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).delay_award_tip.get().toStringUtf8();
          localSurvivalPkResultInfo.delayAwardTip = paramNotifyMsg;
          if (((AvGameNotify.NotifyPKUserFinalSucc)localObject).draw_res.has()) {
            localSurvivalPkResultInfo.pkDrawRes = a((AvGameNotify.PKDrawRes)((AvGameNotify.NotifyPKUserFinalSucc)localObject).draw_res.get());
          }
          localSurvivalPkResultInfo.winTips = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).win_tip.get();
          if (!((AvGameNotify.NotifyPKUserFinalSucc)localObject).ranking.has()) {
            break label839;
          }
        }
        for (paramNotifyMsg = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).ranking.get();; paramNotifyMsg = new ArrayList(0))
        {
          localSurvivalPkResultInfo.rankingUins = a(paramNotifyMsg);
          localSurvivalPkResultInfo.score = ((AvGameNotify.NotifyPKUserFinalSucc)localObject).score.get();
          ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(3), Boolean.valueOf(true), localSurvivalPkResultInfo });
          return;
          bool = false;
          break;
          paramNotifyMsg = null;
          break label638;
          paramNotifyMsg = null;
          break label680;
        }
      }
      if (i == 508)
      {
        paramNotifyMsg = (AvGameNotify.NotifyPKUserDraw)paramNotifyMsg.pk_user_draw.get();
        localObject = new SurvivalPkResultInfo();
        ((SurvivalPkResultInfo)localObject).winRound = paramNotifyMsg.cur_round.get();
        bool = paramNotifyMsg.exit_room.get();
        ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(4), Boolean.valueOf(bool), localObject });
        return;
      }
    } while (i != 506);
    label680:
    label823:
    label829:
    label834:
    label839:
    paramNotifyMsg = (AvGameNotify.NotifyPKUserPass)paramNotifyMsg.pk_user_pass.get();
    Object localObject = new SurvivalPkResultInfo();
    ((SurvivalPkResultInfo)localObject).winRound = paramNotifyMsg.cur_round.get();
    ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(5), Boolean.valueOf(false), localObject });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label318;
      }
      paramFromServiceMsg = new AvGameStrangerMatch.AddMatchRoomRsp();
      int k = -1;
      j = k;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        j = k;
        k = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        j = k;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        j = k;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          i = 0;
          QLog.e("avgame_logic.GameRoomHandler", 1, "onStartStrangerMatch:" + paramToServiceMsg);
          paramToServiceMsg = null;
        }
        ObserverCenter.a().b(GameRoomObserver.class, 12, false, new Object[] { Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(j), paramToServiceMsg });
        return;
      }
      GameUtil.a("avgame_logic.GameRoomHandler", "onStartStrangerMatch()", null, new MessageMicro[] { paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatch() roomId=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg }));
      }
      if ((i == 0) || (j != 0)) {
        break;
      }
      i = paramFromServiceMsg.shard_id.get();
      ObserverCenter.a().b(GameRoomObserver.class, 12, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
      return;
    }
    label318:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatch() fail roomId=%d", new Object[] { Long.valueOf(l) }));
    }
    ObserverCenter.a().b(GameRoomObserver.class, 12, false, new Object[] { Long.valueOf(l), Integer.valueOf(-1), Integer.valueOf(0), null });
  }
  
  private void c(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    paramNotifyMsg = (AvGameNotify.NotifyPKPoolUserChange)paramNotifyMsg.pk_pool_user_change.get();
    int i = paramNotifyMsg.opt.get();
    int j = paramNotifyMsg.total.get();
    if (paramNotifyMsg.uins.has()) {}
    for (paramNotifyMsg = paramNotifyMsg.uins.get();; paramNotifyMsg = new ArrayList(0))
    {
      paramNotifyMsg = b(paramNotifyMsg);
      ObserverCenter.a().b(GameRoomObserver.class, 29, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramNotifyMsg });
      return;
    }
  }
  
  private void c(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    paramNotifyMsg = (AvGameNotify.RoomOwnerChangeGameS2CReq)paramNotifyMsg.change_game_req.get();
    if (paramNotifyMsg.game_type.has()) {}
    for (int i = paramNotifyMsg.game_type.get();; i = 1)
    {
      GameUtil.a("avgame_logic.GameRoomHandler", "handlerChangeGamePush()", new String[] { "AvGameNotify.RoomOwnerChangeGameS2CReq" }, new MessageMicro[] { paramNotifyMsg });
      ObserverCenter.a().b(GameRoomObserver.class, 24, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i) });
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label258;
      }
      paramFromServiceMsg = new AvGameStrangerMatch.DelMatchRoomRsp();
      int k = -1;
      int j = k;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        j = k;
        k = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        j = k;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        j = k;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          i = 0;
          QLog.e("avgame_logic.GameRoomHandler", 1, "onStopStrangerMatch:" + paramToServiceMsg);
          paramToServiceMsg = null;
        }
      }
      GameUtil.a("avgame_logic.GameRoomHandler", "onStopStrangerMatch()", null, new MessageMicro[] { paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStopStrangerMatch() roomId=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg }));
      }
      if ((i != 0) && (j == 0)) {
        ObserverCenter.a().b(GameRoomObserver.class, 13, true, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg });
      }
      return;
    }
    label258:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStopStrangerMatch() fail roomId=%d", new Object[] { Long.valueOf(l) }));
    }
    ObserverCenter.a().b(GameRoomObserver.class, 13, false, new Object[] { Long.valueOf(l), Integer.valueOf(0), null });
  }
  
  private void d(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserChangeStatusS2CReq localRoomUserChangeStatusS2CReq = (AvGameNotify.RoomUserChangeStatusS2CReq)paramNotifyMsg.room_user_change_status_req.get();
    if (localRoomUserChangeStatusS2CReq.uin.has())
    {
      paramNotifyMsg = String.valueOf(localRoomUserChangeStatusS2CReq.uin.get());
      if (!localRoomUserChangeStatusS2CReq.user_status.has()) {
        break label154;
      }
    }
    label154:
    for (int i = localRoomUserChangeStatusS2CReq.user_status.get();; i = 0)
    {
      RoomInfo localRoomInfo = GameUtil.a((AvGameCommon.RoomInfo)localRoomUserChangeStatusS2CReq.room_info.get());
      GameUtil.a("avgame_logic.GameRoomHandler", "handlerChangeUserStatusPush()", new String[] { "AvGameNotify.RoomUserChangeStatusS2CReq" }, new MessageMicro[] { localRoomUserChangeStatusS2CReq });
      ObserverCenter.a().b(GameRoomObserver.class, 23, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramNotifyMsg, Integer.valueOf(i), localRoomInfo });
      return;
      paramNotifyMsg = "";
      break;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2;
    boolean bool;
    label46:
    AvGamePkManager.PKOperationRsp localPKOperationRsp;
    int n;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      i2 = ((Integer)paramToServiceMsg.getAttribute("opeType", Integer.valueOf(0))).intValue();
      if (i2 != 2) {
        break label337;
      }
      bool = true;
      if (i == 0) {
        break label459;
      }
      localPKOperationRsp = new AvGamePkManager.PKOperationRsp();
      j = -1;
      m = 0;
      n = 0;
      k = j;
    }
    for (;;)
    {
      try
      {
        localPKOperationRsp.mergeFrom((byte[])paramObject);
        k = j;
        j = ((AvGameCommon.Result)localPKOperationRsp.res.get()).errcode.get();
        k = j;
        paramToServiceMsg = ((AvGameCommon.Result)localPKOperationRsp.res.get()).errmsg.get().toStringUtf8();
        k = n;
      }
      catch (Exception paramFromServiceMsg)
      {
        int i1;
        label337:
        j = 0;
        i = k;
        m = 0;
        paramToServiceMsg = null;
        k = j;
        j = m;
      }
      try
      {
        i1 = localPKOperationRsp.pool_id.get();
        k = n;
        m = i1;
        n = localPKOperationRsp.start_user_num.get();
        k = n;
        m = i1;
        paramFromServiceMsg = PkCJOperationData.convertFromPB(localPKOperationRsp);
        k = i1;
        m = i;
        i = j;
        GameUtil.a("avgame_logic.GameRoomHandler", "onSendSurvivalOperation()", null, new MessageMicro[] { localPKOperationRsp });
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onSendSurvivalOperation() opeType=%d poolId=%d errCode=%d errMsg=%s cjOpData=%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(k), Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg }));
        }
        if ((m == 0) || (i != 0)) {
          break label402;
        }
        ObserverCenter.a().b(GameRoomObserver.class, 14, true, new Object[] { Boolean.valueOf(bool), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          i = j;
          j = k;
          k = m;
        }
      }
      i = 0;
      break;
      bool = false;
      break label46;
      m = 0;
      QLog.e("avgame_logic.GameRoomHandler", 1, "onSendSurvivalOperation:" + paramFromServiceMsg);
      paramFromServiceMsg = null;
      n = j;
    }
    label402:
    ObserverCenter.a().b(GameRoomObserver.class, 14, false, new Object[] { Boolean.valueOf(bool), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
    return;
    label459:
    if (paramFromServiceMsg != null) {}
    for (i = paramFromServiceMsg.getResultCode();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onSendSurvivalOperation() fail opeType=%d code:%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i) }));
      }
      ObserverCenter.a().b(GameRoomObserver.class, 14, false, new Object[] { Boolean.valueOf(bool), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null });
      return;
    }
  }
  
  private void e(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    paramNotifyMsg = (AvGameNotify.RoomDestoryS2CReq)paramNotifyMsg.room_destory_req.get();
    GameUtil.a("avgame_logic.GameRoomHandler", "handlerDestroyRoomPush()", new String[] { "AvGameNotify.RoomDestoryS2CReq" }, new MessageMicro[] { paramNotifyMsg });
    ObserverCenter.a().b(GameRoomObserver.class, 22, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  /* Error */
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +361 -> 362
    //   4: aload_2
    //   5: invokevirtual 468	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifeq +354 -> 362
    //   11: aload_3
    //   12: ifnull +350 -> 362
    //   15: iconst_1
    //   16: istore 4
    //   18: iload 4
    //   20: ifeq +494 -> 514
    //   23: new 645	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp
    //   26: dup
    //   27: invokespecial 646	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:<init>	()V
    //   30: astore 13
    //   32: iconst_m1
    //   33: istore 4
    //   35: iconst_0
    //   36: istore 8
    //   38: iconst_0
    //   39: istore 6
    //   41: iconst_0
    //   42: istore 9
    //   44: iload 4
    //   46: istore 5
    //   48: aload 13
    //   50: aload_3
    //   51: checkcast 473	[B
    //   54: checkcast 473	[B
    //   57: invokevirtual 647	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: iload 4
    //   63: istore 5
    //   65: aload 13
    //   67: getfield 648	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   70: invokevirtual 484	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   73: checkcast 483	trpc/qq_vgame/common/AvGameCommon$Result
    //   76: getfield 487	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   79: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   82: istore 4
    //   84: iload 4
    //   86: istore 5
    //   88: aload 13
    //   90: getfield 648	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   93: invokevirtual 484	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   96: checkcast 483	trpc/qq_vgame/common/AvGameCommon$Result
    //   99: getfield 490	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   102: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   105: invokevirtual 352	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   108: astore_1
    //   109: iload 6
    //   111: istore 7
    //   113: aload 13
    //   115: getfield 651	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   118: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   121: istore 5
    //   123: iload 6
    //   125: istore 7
    //   127: iload 5
    //   129: istore 8
    //   131: aload 13
    //   133: getfield 654	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:user_total_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   136: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   139: istore 6
    //   141: iload 6
    //   143: istore 7
    //   145: iload 5
    //   147: istore 8
    //   149: aload_0
    //   150: aload 13
    //   152: getfield 657	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:user_in_pk	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   155: invokevirtual 420	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   158: invokespecial 535	com/tencent/avgame/gamelogic/handler/GameRoomHandler:b	(Ljava/util/List;)Ljava/util/List;
    //   161: astore_2
    //   162: aload 13
    //   164: getfield 660	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:change_pool_id	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   167: invokevirtual 25	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   170: istore 11
    //   172: iload 9
    //   174: istore 7
    //   176: aload 13
    //   178: getfield 663	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:real_pool_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   181: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   184: istore 8
    //   186: iload 8
    //   188: istore 7
    //   190: aload 13
    //   192: getfield 666	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:fresh_at_midfield	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   195: invokevirtual 25	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   198: istore 10
    //   200: iload 8
    //   202: istore 7
    //   204: iload 4
    //   206: istore 9
    //   208: aload_1
    //   209: astore_3
    //   210: iload 5
    //   212: istore 8
    //   214: iload 6
    //   216: istore 5
    //   218: aload_2
    //   219: astore_1
    //   220: iload 11
    //   222: istore 12
    //   224: iload 7
    //   226: istore 4
    //   228: iload 10
    //   230: istore 11
    //   232: invokestatic 495	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +47 -> 282
    //   238: ldc 119
    //   240: iconst_2
    //   241: ldc_w 668
    //   244: iconst_4
    //   245: anewarray 136	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: iload 8
    //   252: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: iload 5
    //   260: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: aastore
    //   264: dup
    //   265: iconst_2
    //   266: iload 9
    //   268: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: aastore
    //   272: dup
    //   273: iconst_3
    //   274: aload_3
    //   275: aastore
    //   276: invokestatic 503	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: iload 9
    //   284: ifne +155 -> 439
    //   287: invokestatic 132	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   290: ldc 134
    //   292: bipush 17
    //   294: iconst_1
    //   295: bipush 8
    //   297: anewarray 136	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: iload 8
    //   304: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: aastore
    //   308: dup
    //   309: iconst_1
    //   310: iload 5
    //   312: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: aastore
    //   316: dup
    //   317: iconst_2
    //   318: aload_1
    //   319: aastore
    //   320: dup
    //   321: iconst_3
    //   322: iload 12
    //   324: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   327: aastore
    //   328: dup
    //   329: iconst_4
    //   330: iload 4
    //   332: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: aastore
    //   336: dup
    //   337: iconst_5
    //   338: iload 11
    //   340: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   343: aastore
    //   344: dup
    //   345: bipush 6
    //   347: iload 9
    //   349: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: bipush 7
    //   356: aload_3
    //   357: aastore
    //   358: invokevirtual 140	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   361: return
    //   362: iconst_0
    //   363: istore 4
    //   365: goto -347 -> 18
    //   368: astore_3
    //   369: iconst_0
    //   370: istore 4
    //   372: iconst_0
    //   373: istore 10
    //   375: aconst_null
    //   376: astore_1
    //   377: iconst_0
    //   378: istore 8
    //   380: iconst_0
    //   381: istore 6
    //   383: aconst_null
    //   384: astore_2
    //   385: iload 5
    //   387: istore 7
    //   389: iload 8
    //   391: istore 5
    //   393: ldc 119
    //   395: iconst_1
    //   396: new 225	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   403: ldc_w 670
    //   406: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload_3
    //   410: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: iconst_0
    //   420: istore 11
    //   422: iload 10
    //   424: istore 12
    //   426: iload 6
    //   428: istore 8
    //   430: aload_2
    //   431: astore_3
    //   432: iload 7
    //   434: istore 9
    //   436: goto -204 -> 232
    //   439: invokestatic 132	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   442: ldc 134
    //   444: bipush 17
    //   446: iconst_0
    //   447: bipush 8
    //   449: anewarray 136	java/lang/Object
    //   452: dup
    //   453: iconst_0
    //   454: iload 8
    //   456: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: dup
    //   461: iconst_1
    //   462: iload 5
    //   464: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: aastore
    //   468: dup
    //   469: iconst_2
    //   470: aload_1
    //   471: aastore
    //   472: dup
    //   473: iconst_3
    //   474: iload 12
    //   476: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   479: aastore
    //   480: dup
    //   481: iconst_4
    //   482: iload 4
    //   484: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   487: aastore
    //   488: dup
    //   489: iconst_5
    //   490: iload 11
    //   492: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   495: aastore
    //   496: dup
    //   497: bipush 6
    //   499: iload 9
    //   501: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   504: aastore
    //   505: dup
    //   506: bipush 7
    //   508: aload_3
    //   509: aastore
    //   510: invokevirtual 140	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   513: return
    //   514: aload_2
    //   515: ifnull +102 -> 617
    //   518: aload_2
    //   519: invokevirtual 629	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   522: istore 4
    //   524: ldc 119
    //   526: iconst_2
    //   527: ldc_w 672
    //   530: iconst_1
    //   531: anewarray 136	java/lang/Object
    //   534: dup
    //   535: iconst_0
    //   536: iload 4
    //   538: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   541: aastore
    //   542: invokestatic 503	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   545: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   548: invokestatic 132	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   551: ldc 134
    //   553: bipush 17
    //   555: iconst_0
    //   556: bipush 8
    //   558: anewarray 136	java/lang/Object
    //   561: dup
    //   562: iconst_0
    //   563: iconst_0
    //   564: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   567: aastore
    //   568: dup
    //   569: iconst_1
    //   570: iconst_0
    //   571: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: aastore
    //   575: dup
    //   576: iconst_2
    //   577: aconst_null
    //   578: aastore
    //   579: dup
    //   580: iconst_3
    //   581: iconst_0
    //   582: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   585: aastore
    //   586: dup
    //   587: iconst_4
    //   588: iconst_0
    //   589: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   592: aastore
    //   593: dup
    //   594: iconst_5
    //   595: iconst_0
    //   596: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   599: aastore
    //   600: dup
    //   601: bipush 6
    //   603: iconst_m1
    //   604: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   607: aastore
    //   608: dup
    //   609: bipush 7
    //   611: aconst_null
    //   612: aastore
    //   613: invokevirtual 140	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   616: return
    //   617: iconst_m1
    //   618: istore 4
    //   620: goto -96 -> 524
    //   623: astore_3
    //   624: iconst_0
    //   625: istore 9
    //   627: iconst_0
    //   628: istore 10
    //   630: aconst_null
    //   631: astore 13
    //   633: iload 7
    //   635: istore 5
    //   637: iload 8
    //   639: istore 6
    //   641: aload_1
    //   642: astore_2
    //   643: iload 4
    //   645: istore 7
    //   647: iload 9
    //   649: istore 4
    //   651: aload 13
    //   653: astore_1
    //   654: goto -261 -> 393
    //   657: astore 13
    //   659: iconst_0
    //   660: istore 9
    //   662: iconst_0
    //   663: istore 10
    //   665: iload 5
    //   667: istore 7
    //   669: aload_1
    //   670: astore_3
    //   671: iload 4
    //   673: istore 8
    //   675: iload 9
    //   677: istore 4
    //   679: aload_2
    //   680: astore_1
    //   681: iload 6
    //   683: istore 5
    //   685: iload 7
    //   687: istore 6
    //   689: aload_3
    //   690: astore_2
    //   691: iload 8
    //   693: istore 7
    //   695: aload 13
    //   697: astore_3
    //   698: goto -305 -> 393
    //   701: astore 13
    //   703: iload 11
    //   705: istore 10
    //   707: iload 5
    //   709: istore 8
    //   711: aload_1
    //   712: astore_3
    //   713: iload 4
    //   715: istore 9
    //   717: iload 7
    //   719: istore 4
    //   721: aload_2
    //   722: astore_1
    //   723: iload 6
    //   725: istore 5
    //   727: iload 8
    //   729: istore 6
    //   731: aload_3
    //   732: astore_2
    //   733: iload 9
    //   735: istore 7
    //   737: aload 13
    //   739: astore_3
    //   740: goto -347 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	GameRoomHandler
    //   0	743	1	paramToServiceMsg	ToServiceMsg
    //   0	743	2	paramFromServiceMsg	FromServiceMsg
    //   0	743	3	paramObject	Object
    //   16	704	4	i	int
    //   46	680	5	j	int
    //   39	691	6	k	int
    //   111	625	7	m	int
    //   36	692	8	n	int
    //   42	692	9	i1	int
    //   198	508	10	bool1	boolean
    //   170	534	11	bool2	boolean
    //   222	253	12	bool3	boolean
    //   30	622	13	localGetPKInfoRsp	trpc.qq_vgame.pk_manager.AvGamePkManager.GetPKInfoRsp
    //   657	39	13	localException1	Exception
    //   701	37	13	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	61	368	java/lang/Exception
    //   65	84	368	java/lang/Exception
    //   88	109	368	java/lang/Exception
    //   113	123	623	java/lang/Exception
    //   131	141	623	java/lang/Exception
    //   149	162	623	java/lang/Exception
    //   162	172	657	java/lang/Exception
    //   176	186	701	java/lang/Exception
    //   190	200	701	java/lang/Exception
  }
  
  private void f(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserExitS2CReq localRoomUserExitS2CReq = (AvGameNotify.RoomUserExitS2CReq)paramNotifyMsg.room_user_exit_req.get();
    int i;
    label56:
    String str1;
    label80:
    int j;
    label101:
    int k;
    label122:
    String str2;
    if (localRoomUserExitS2CReq.exit_reason.has())
    {
      i = localRoomUserExitS2CReq.exit_reason.get();
      if (!localRoomUserExitS2CReq.exit_uin.has()) {
        break label303;
      }
      paramNotifyMsg = String.valueOf(localRoomUserExitS2CReq.exit_uin.get());
      if (!localRoomUserExitS2CReq.new_owner_uin.has()) {
        break label310;
      }
      str1 = String.valueOf(localRoomUserExitS2CReq.new_owner_uin.get());
      if (!localRoomUserExitS2CReq.heartbeat_timeout.has()) {
        break label318;
      }
      j = localRoomUserExitS2CReq.heartbeat_timeout.get();
      if (!localRoomUserExitS2CReq.sub_reason.has()) {
        break label324;
      }
      k = localRoomUserExitS2CReq.sub_reason.get();
      if (!localRoomUserExitS2CReq.onwer_tip.has()) {
        break label330;
      }
      str2 = String.valueOf(localRoomUserExitS2CReq.onwer_tip.get());
      label146:
      if (!localRoomUserExitS2CReq.exiter_tip.has()) {
        break label338;
      }
    }
    label303:
    label310:
    label318:
    label324:
    label330:
    label338:
    for (String str3 = String.valueOf(localRoomUserExitS2CReq.exiter_tip.get());; str3 = "")
    {
      RoomInfo localRoomInfo = GameUtil.a((AvGameCommon.RoomInfo)localRoomUserExitS2CReq.room_info.get());
      GameUtil.a("avgame_logic.GameRoomHandler", "handlerExitRoomPush()", new String[] { "AvGameNotify.RoomUserExitS2CReq" }, new MessageMicro[] { localRoomUserExitS2CReq });
      ObserverCenter.a().b(GameRoomObserver.class, 21, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i), paramNotifyMsg, str1, localRoomInfo, Integer.valueOf(j), Integer.valueOf(k), str2, str3 });
      return;
      i = 0;
      break;
      paramNotifyMsg = "";
      break label56;
      str1 = "";
      break label80;
      j = 0;
      break label101;
      k = 0;
      break label122;
      str2 = "";
      break label146;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool4;
    int k;
    long l;
    String str;
    int j;
    int i;
    Object localObject2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool4 = paramToServiceMsg.extraData.getBoolean("is_from_sync");
      k = paramToServiceMsg.extraData.getInt("snapshot_from");
      l = paramToServiceMsg.extraData.getLong("room_id");
      str = paramToServiceMsg.extraData.getString("user_uin");
      j = 0;
      i = 0;
      paramToServiceMsg = "";
      if (bool1)
      {
        localObject2 = new AvGameRoomManager.CmdRoomInfoRsp();
        i = j;
      }
    }
    else
    {
      try
      {
        ((AvGameRoomManager.CmdRoomInfoRsp)localObject2).mergeFrom((byte[])paramObject);
        i = j;
        j = ((AvGameCommon.Result)((AvGameRoomManager.CmdRoomInfoRsp)localObject2).res.get()).errcode.get();
        i = j;
        paramFromServiceMsg = ((AvGameCommon.Result)((AvGameRoomManager.CmdRoomInfoRsp)localObject2).res.get()).errmsg.get().toStringUtf8();
        paramToServiceMsg = paramFromServiceMsg;
        i = j;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          RoomInfo localRoomInfo;
          IGame localIGame;
          Object localObject1;
          ArrayList localArrayList;
          QLog.e("avgame_logic.GameRoomHandler", 1, "onGetGameRoomInfo:" + paramFromServiceMsg);
          bool1 = false;
          continue;
          boolean bool2 = false;
          continue;
          paramFromServiceMsg = GameUtil.a(((AvGameRoomManager.CmdRoomInfoRsp)localObject2).game_ranking_info);
        }
      }
      a((AvGameRoomManager.CmdRoomInfoRsp)localObject2);
      bool3 = bool1;
      if (bool1)
      {
        bool3 = bool1;
        if (i == 0)
        {
          bool3 = bool1;
          if (((AvGameRoomManager.CmdRoomInfoRsp)localObject2).room_info.has())
          {
            bool3 = bool1;
            if (((AvGameRoomManager.CmdRoomInfoRsp)localObject2).room_info.get() != null)
            {
              localRoomInfo = GameUtil.a((AvGameCommon.RoomInfo)((AvGameRoomManager.CmdRoomInfoRsp)localObject2).room_info.get());
              localIGame = null;
              localObject1 = null;
              localArrayList = null;
              j = 0;
              paramFromServiceMsg = null;
              paramObject = null;
              bool2 = bool1;
              if (bool4)
              {
                localIGame = GameUtil.a((AvGameCommon.GameStatusInfo)((AvGameRoomManager.CmdRoomInfoRsp)localObject2).game_status_info.get());
                if ((localIGame == null) || (!localIGame.a())) {
                  break label681;
                }
                bool2 = true;
                if ((!GameEngine.a().f()) || (!(localIGame instanceof Game))) {
                  break label687;
                }
                paramFromServiceMsg = ((Game)localIGame).a();
                localObject1 = (AvGameList.CmdGameListRsp)((AvGameRoomManager.CmdRoomInfoRsp)localObject2).game_cfg_info.get();
                j = ((AvGameList.CmdGameListRsp)localObject1).curr_game_index.get();
                localObject2 = ((AvGameList.CmdGameListRsp)localObject1).resource_url.get();
                paramObject = ((AvGameList.CmdGameListRsp)localObject1).resource_md5.get();
                localArrayList = new ArrayList();
                a(((AvGameList.CmdGameListRsp)localObject1).game_list.get(), localArrayList);
                QLog.d("avgame_logic.GameRoomHandler", 1, String.format("onGetGameRoomInfo game valid=%b game=%s", new Object[] { Boolean.valueOf(bool2), localIGame }));
                bool2 = bool1 & bool2;
                localObject1 = paramFromServiceMsg;
                paramFromServiceMsg = (FromServiceMsg)localObject2;
              }
              bool3 = bool2;
              if (bool2) {
                ObserverCenter.a().b(GameRoomObserver.class, 1, true, new Object[] { Boolean.valueOf(bool4), Long.valueOf(l), str, localRoomInfo, localIGame, localObject1, localArrayList, Integer.valueOf(j), paramFromServiceMsg, paramObject, Integer.valueOf(k) });
              }
            }
          }
        }
      }
    }
    for (boolean bool3 = bool2;; bool3 = bool1)
    {
      if (!bool3)
      {
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onGetGameRoomInfo failed suc=%b errCode=%d errMsg=%s", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(i), paramToServiceMsg }));
        }
        paramFromServiceMsg = paramToServiceMsg;
        if (paramToServiceMsg == null) {
          paramFromServiceMsg = "";
        }
        ObserverCenter.a().b(GameRoomObserver.class, 1, false, new Object[] { Boolean.valueOf(bool4), Long.valueOf(l), str, paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(k) });
      }
      QualityReporter.a(bool3, k);
      return;
      bool1 = false;
      break;
      label681:
      label687:
      paramToServiceMsg = "";
    }
  }
  
  private void g(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserEnterS2CReq localRoomUserEnterS2CReq = (AvGameNotify.RoomUserEnterS2CReq)paramNotifyMsg.room_user_enter_req.get();
    int i;
    if (localRoomUserEnterS2CReq.type.has())
    {
      i = localRoomUserEnterS2CReq.type.get();
      if (!localRoomUserEnterS2CReq.enter_uin.has()) {
        break label213;
      }
      paramNotifyMsg = String.valueOf(localRoomUserEnterS2CReq.enter_uin.get());
      label56:
      if (!localRoomUserEnterS2CReq.inviter_uin.has()) {
        break label220;
      }
    }
    label213:
    label220:
    for (String str = String.valueOf(localRoomUserEnterS2CReq.inviter_uin.get());; str = "")
    {
      RoomInfo localRoomInfo = GameUtil.a((AvGameCommon.RoomInfo)localRoomUserEnterS2CReq.room_info.get());
      QLog.d("avgame_logic.GameRoomHandler", 1, "handlerEnterRoomPush " + localRoomInfo.toString());
      GameUtil.a("avgame_logic.GameRoomHandler", "handlerEnterRoomPush()", new String[] { "AvGameNotify.RoomUserEnterS2CReq" }, new MessageMicro[] { localRoomUserEnterS2CReq });
      ObserverCenter.a().b(GameRoomObserver.class, 20, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i), paramNotifyMsg, str, localRoomInfo });
      return;
      i = 0;
      break;
      paramNotifyMsg = "";
      break label56;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        AvGameList.CmdGameListRsp localCmdGameListRsp = new AvGameList.CmdGameListRsp();
        try
        {
          localCmdGameListRsp.mergeFrom((byte[])paramObject);
          GameUtil.a("avgame_logic.GameRoomHandler", "onGetGameRoomList()", null, new MessageMicro[] { localCmdGameListRsp });
          if (localCmdGameListRsp.game_list.has())
          {
            paramToServiceMsg = localCmdGameListRsp.game_list.get();
            if ((i == 0) || (paramToServiceMsg == null)) {
              break label346;
            }
            if (!localCmdGameListRsp.curr_game_index.has()) {
              break label335;
            }
            i = localCmdGameListRsp.curr_game_index.get();
            paramObject = new ArrayList();
            a(paramToServiceMsg, paramObject);
            if (!localCmdGameListRsp.resource_url.has()) {
              break label341;
            }
            paramToServiceMsg = localCmdGameListRsp.resource_url.get();
            paramFromServiceMsg = localObject;
            if (localCmdGameListRsp.resource_md5.has()) {
              paramFromServiceMsg = localCmdGameListRsp.resource_md5.get();
            }
            ObserverCenter.a().b(GameRoomObserver.class, 2, true, new Object[] { paramObject, Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg, Long.valueOf(l) });
            if (QLog.isColorLevel()) {
              QLog.i("avgame_logic.GameRoomHandler", 2, "onGetGameRoomList success gameList = " + paramObject + " curGameIndex=" + i + " resUrl = " + paramToServiceMsg + " resMd5 =" + paramFromServiceMsg);
            }
            return;
            i = 0;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          for (;;)
          {
            QLog.e("avgame_logic.GameRoomHandler", 1, "onGetGameRoomList:" + paramToServiceMsg);
            i = 0;
            continue;
            paramToServiceMsg = null;
            continue;
            label335:
            i = 0;
            continue;
            label341:
            paramToServiceMsg = null;
          }
        }
      }
    }
    label346:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onGetGameRoomList failed ");
    }
    ObserverCenter.a().b(GameRoomObserver.class, 2, false, new Object[] { Long.valueOf(l) });
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i == 0) {
        break label565;
      }
      paramToServiceMsg = new AvGameList.CmdGetQuestionClassRsp();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        GameUtil.a("avgame_logic.GameRoomHandler", "onGetQuestionClass()", null, new MessageMicro[] { paramToServiceMsg });
        paramObject = paramToServiceMsg;
        j = i;
        if ((paramObject != null) && (paramObject.res.has()))
        {
          i = 1;
          if ((j == 0) || (i == 0) || (paramObject.res.errcode.get() != 0)) {
            break label426;
          }
          if (!paramObject.question_class_title_url.has()) {
            continue;
          }
          paramToServiceMsg = paramObject.question_class_title_url.get();
          if (!paramObject.question_class_button_url.has()) {
            continue;
          }
          paramFromServiceMsg = paramObject.question_class_button_url.get();
          localArrayList = new ArrayList();
          if (!paramObject.question_class_list.has()) {
            continue;
          }
          paramObject = paramObject.question_class_list.get();
          if ((paramObject == null) || (paramObject.size() <= 0)) {
            continue;
          }
          i = 0;
          if (i >= paramObject.size()) {
            continue;
          }
          AvGameList.QuestionClassInfo localQuestionClassInfo = (AvGameList.QuestionClassInfo)paramObject.get(i);
          QuestionClassInfo localQuestionClassInfo1 = new QuestionClassInfo();
          localQuestionClassInfo1.a(localQuestionClassInfo);
          localArrayList.add(localQuestionClassInfo1);
          i += 1;
          continue;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        ArrayList localArrayList;
        i = 0;
        QLog.e("avgame_logic.GameRoomHandler", 1, "onGetQuestionClass:" + paramFromServiceMsg);
        continue;
        i = 0;
        continue;
        paramToServiceMsg = "";
        continue;
        paramFromServiceMsg = "";
        continue;
        paramObject = null;
        continue;
        ObserverCenter.a().b(GameRoomObserver.class, 9, true, new Object[] { Long.valueOf(l), null, localArrayList, paramToServiceMsg, paramFromServiceMsg });
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameRoomHandler", 2, "onGetQuestionClass success! roomId = " + l + " questionClassInfoListSize=" + localArrayList.size() + " titleImageUrl=" + paramToServiceMsg + " buttonImageUrl=" + paramFromServiceMsg);
        }
        return;
      }
      label426:
      if (i != 0)
      {
        j = paramObject.res.errcode.get();
        if ((i == 0) || (!paramObject.res.errmsg.has())) {
          break label558;
        }
      }
      label558:
      for (paramToServiceMsg = paramObject.res.errmsg.get().toStringUtf8();; paramToServiceMsg = "拉取题库类型失败")
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "onGetQuestionClass fail! errorCode = " + j + "retMsg=" + paramToServiceMsg);
        ObserverCenter.a().b(GameRoomObserver.class, 9, false, new Object[] { Long.valueOf(l), paramToServiceMsg, null, null, null });
        return;
        j = -1;
        break;
      }
      label565:
      paramObject = null;
      int j = i;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    long l2;
    for (;;)
    {
      l2 = paramToServiceMsg.extraData.getLong("room_id");
      if (i != 0)
      {
        paramFromServiceMsg = new AvGamePlay.SelectGameRsp();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (i != 0) {
            if (paramFromServiceMsg.res.has())
            {
              paramToServiceMsg = (AvGameCommon.Result)paramFromServiceMsg.res.get();
              if (!paramFromServiceMsg.seq.has()) {
                break label234;
              }
              l1 = paramFromServiceMsg.seq.get();
              if ((paramToServiceMsg == null) || (paramToServiceMsg.errcode.get() != 0)) {
                break label240;
              }
              ObserverCenter.a().b(GameRoomObserver.class, 6, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
              GameUtil.a("avgame_logic.GameRoomHandler", "onSelectGame()", new String[] { "AvGameCommon.Result -> seq = " + l1 }, new MessageMicro[] { paramToServiceMsg });
              return;
              i = 0;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          for (;;)
          {
            QLog.e("avgame_logic.GameRoomHandler", 1, "onSelectGame:" + paramToServiceMsg);
            i = 0;
            continue;
            paramToServiceMsg = null;
            continue;
            label234:
            long l1 = 0L;
            continue;
            label240:
            ObserverCenter.a().b(GameRoomObserver.class, 6, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
          }
        }
      }
    }
    QLog.e("avgame_logic.GameRoomHandler", 1, "onSelectGame()  failed ");
    ObserverCenter.a().b(GameRoomObserver.class, 6, false, new Object[] { Long.valueOf(0L), Long.valueOf(l2) });
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameShare.CmdGetShareLinkRsp localCmdGetShareLinkRsp = new AvGameShare.CmdGetShareLinkRsp();
    boolean bool1;
    long l;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      l = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      QLog.d("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink. isSuccess = " + bool1);
      if (!bool1) {
        break label185;
      }
    }
    for (;;)
    {
      try
      {
        localCmdGetShareLinkRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink.  false result：" + paramToServiceMsg.toString());
        bool2 = false;
        continue;
      }
      if (!bool2) {
        break label303;
      }
      if (localCmdGetShareLinkRsp.share_url.has()) {
        break label229;
      }
      ObserverCenter.a().a(GameRoomObserver.class, 8, false, new Object[] { "", Long.valueOf(l) });
      QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink. rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label185:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label229:
    paramToServiceMsg = localCmdGetShareLinkRsp.share_url.get();
    ObserverCenter.a().a(GameRoomObserver.class, 8, true, new Object[] { paramToServiceMsg, Long.valueOf(l) });
    QLog.d("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink.get shareUrl:" + paramToServiceMsg + " mark: " + l);
    return;
    label303:
    ObserverCenter.a().a(GameRoomObserver.class, 8, false, new Object[] { "", Long.valueOf(l) });
    QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink fail");
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    int j;
    long l1;
    for (;;)
    {
      j = paramToServiceMsg.extraData.getInt("leave_game_room_type");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("user_uin");
      l1 = paramToServiceMsg.extraData.getLong("room_id");
      long l2 = paramToServiceMsg.extraData.getLong("scene_id");
      if (i == 0) {
        break label325;
      }
      AvGameRoomManager.CmdRoomLeaveRsp localCmdRoomLeaveRsp = new AvGameRoomManager.CmdRoomLeaveRsp();
      try
      {
        localCmdRoomLeaveRsp.mergeFrom((byte[])paramObject);
        if (i == 0) {
          break label325;
        }
        paramToServiceMsg = (AvGameCommon.Result)localCmdRoomLeaveRsp.res.get();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.errcode.get() == 0))
        {
          paramToServiceMsg = GameUtil.a((AvGameCommon.RoomInfo)localCmdRoomLeaveRsp.room_info.get());
          ObserverCenter.a().a(GameRoomObserver.class, 3, true, new Object[] { Long.valueOf(l1), Integer.valueOf(j), paramFromServiceMsg, paramToServiceMsg });
          GameUtil.a("avgame_logic.GameRoomHandler", "onLeaveGameRoom() sceneId:=" + l2, null, new MessageMicro[] { localCmdRoomLeaveRsp });
          return;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("avgame_logic.GameRoomHandler", 1, "onLeaveGameRoom():" + paramToServiceMsg);
          i = 0;
        }
        if (paramToServiceMsg == null) {
          break label318;
        }
      }
    }
    if (paramToServiceMsg.errmsg.has()) {}
    label318:
    for (paramToServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();; paramToServiceMsg = "")
    {
      ObserverCenter.a().a(GameRoomObserver.class, 3, false, new Object[] { Long.valueOf(l1), Integer.valueOf(j), paramFromServiceMsg, paramToServiceMsg });
      break;
    }
    label325:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onLeaveGameRoom() failed");
    }
    ObserverCenter.a().a(GameRoomObserver.class, 3, false, new Object[] { Long.valueOf(l1), Integer.valueOf(j), paramFromServiceMsg, "" });
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int j = paramToServiceMsg.extraData.getInt("change_status_from");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label322;
      }
      AvGameRoomManager.CmdRoomChangeUserStatusRsp localCmdRoomChangeUserStatusRsp = new AvGameRoomManager.CmdRoomChangeUserStatusRsp();
      try
      {
        localCmdRoomChangeUserStatusRsp.mergeFrom((byte[])paramObject);
        if (i == 0) {
          break label322;
        }
        if (localCmdRoomChangeUserStatusRsp.res.has())
        {
          paramToServiceMsg = (AvGameCommon.Result)localCmdRoomChangeUserStatusRsp.res.get();
          if ((paramToServiceMsg == null) || (paramToServiceMsg.errcode.get() != 0) || (localCmdRoomChangeUserStatusRsp.room_info.get() == null)) {
            break label226;
          }
          paramToServiceMsg = GameUtil.a((AvGameCommon.RoomInfo)localCmdRoomChangeUserStatusRsp.room_info.get());
          ObserverCenter.a().b(GameRoomObserver.class, 4, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
          GameUtil.a("avgame_logic.GameRoomHandler", "onChangeUserStatus()", null, new MessageMicro[] { localCmdRoomChangeUserStatusRsp });
          return;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("avgame_logic.GameRoomHandler", 1, "onChangeUserStatus():" + paramToServiceMsg);
          i = 0;
          continue;
          paramToServiceMsg = null;
        }
        label226:
        if (paramToServiceMsg == null) {
          break label309;
        }
      }
    }
    if (paramToServiceMsg.errmsg.has())
    {
      paramFromServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();
      label251:
      if (paramToServiceMsg == null) {
        break label316;
      }
    }
    label309:
    label316:
    for (int i = paramToServiceMsg.errcode.get();; i = -1)
    {
      ObserverCenter.a().b(GameRoomObserver.class, 4, false, new Object[] { Long.valueOf(l), paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramFromServiceMsg = "";
      break label251;
    }
    label322:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onChangeUserStatus() failed");
    }
    ObserverCenter.a().b(GameRoomObserver.class, 4, false, new Object[] { Long.valueOf(l), "", Integer.valueOf(109), Integer.valueOf(j) });
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    paramToServiceMsg = null;
    boolean bool;
    ActivityCenter.GetActivitysRsp localGetActivitysRsp;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label300;
      }
      localGetActivitysRsp = new ActivityCenter.GetActivitysRsp();
    }
    for (;;)
    {
      try
      {
        localGetActivitysRsp.mergeFrom((byte[])paramObject);
        if (bool) {
          if (localGetActivitysRsp.res.has())
          {
            paramFromServiceMsg = (AvGameCommon.Result)localGetActivitysRsp.res.get();
            if (paramFromServiceMsg != null)
            {
              i = paramFromServiceMsg.errcode.get();
              paramToServiceMsg = paramFromServiceMsg.errmsg.get().toStringUtf8();
            }
            if (i != 0) {
              continue;
            }
            paramFromServiceMsg = new GameActivityCenterEntry();
            paramFromServiceMsg.jdField_a_of_type_JavaLangString = localGetActivitysRsp.icon_url.get();
            paramFromServiceMsg.b = localGetActivitysRsp.jump_url.get();
            paramFromServiceMsg.jdField_a_of_type_Int = localGetActivitysRsp.red_point.get();
            ObserverCenter.a().a(GameRoomObserver.class, 10, bool, new Object[] { Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
            if (QLog.isColorLevel()) {
              QLog.i("avgame_logic.GameRoomHandler", 2, "onGetActivityEntry, [" + bool + "," + i + "," + paramToServiceMsg + "," + paramFromServiceMsg + "]");
            }
            return;
            bool = false;
          }
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        bool = false;
        QLog.i("avgame_logic.GameRoomHandler", 1, "onGetActivityEntry, parse error.", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = null;
        continue;
        bool = false;
        paramFromServiceMsg = null;
        continue;
        paramToServiceMsg = null;
        i = 0;
        paramFromServiceMsg = null;
        continue;
      }
      label300:
      paramToServiceMsg = null;
      i = 0;
      paramFromServiceMsg = null;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("playGameId");
    int i = 0;
    paramToServiceMsg = null;
    boolean bool;
    ActivityCenter.SyncShareGameRsp localSyncShareGameRsp;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label293;
      }
      localSyncShareGameRsp = new ActivityCenter.SyncShareGameRsp();
    }
    for (;;)
    {
      try
      {
        localSyncShareGameRsp.mergeFrom((byte[])paramObject);
        if (bool) {
          if (localSyncShareGameRsp.res.has())
          {
            paramFromServiceMsg = (AvGameCommon.Result)localSyncShareGameRsp.res.get();
            if (paramFromServiceMsg != null)
            {
              i = paramFromServiceMsg.errcode.get();
              paramToServiceMsg = paramFromServiceMsg.errmsg.get().toStringUtf8();
            }
            if (i != 0) {
              continue;
            }
            paramFromServiceMsg = localSyncShareGameRsp.jump_url.get();
            ObserverCenter.a().a(GameRoomObserver.class, 11, bool, new Object[] { Integer.valueOf(i), paramToServiceMsg, str, paramFromServiceMsg });
            if (QLog.isColorLevel()) {
              QLog.i("avgame_logic.GameRoomHandler", 2, "onSyncShareGame, [" + bool + "," + i + "," + paramToServiceMsg + "," + str + "," + paramFromServiceMsg + "]");
            }
            return;
            bool = false;
          }
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        bool = false;
        QLog.i("avgame_logic.GameRoomHandler", 1, "onSyncShareGame, parse error.", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = null;
        continue;
        bool = false;
        paramFromServiceMsg = null;
        continue;
        paramToServiceMsg = null;
        i = 0;
        paramFromServiceMsg = null;
        continue;
      }
      label293:
      paramToServiceMsg = null;
      i = 0;
      paramFromServiceMsg = null;
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    long l2;
    for (;;)
    {
      l2 = paramToServiceMsg.extraData.getLong("room_id");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("user_uin");
      if (i != 0)
      {
        AvGameHeartBeat.CmdUserHeartBeatRsp localCmdUserHeartBeatRsp = new AvGameHeartBeat.CmdUserHeartBeatRsp();
        try
        {
          localCmdUserHeartBeatRsp.mergeFrom((byte[])paramObject);
          if (i != 0) {
            if (localCmdUserHeartBeatRsp.res.has())
            {
              paramToServiceMsg = (AvGameCommon.Result)localCmdUserHeartBeatRsp.res.get();
              if (!localCmdUserHeartBeatRsp.seq.has()) {
                break label292;
              }
              l1 = localCmdUserHeartBeatRsp.seq.get();
              if (!localCmdUserHeartBeatRsp.report_interval.has()) {
                break label298;
              }
              i = localCmdUserHeartBeatRsp.report_interval.get();
              if (paramToServiceMsg == null) {
                break label304;
              }
              j = paramToServiceMsg.errcode.get();
              ObserverCenter.a().a(GameRoomObserver.class, 5, true, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(l2), paramFromServiceMsg, Integer.valueOf(j) });
              if (QLog.isDevelopLevel()) {
                QLog.i("HeartBeatController", 2, "onStartHeartBeat() success result = " + j + " seq=" + l1);
              }
              return;
              i = 0;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          for (;;)
          {
            QLog.e("HeartBeatController", 1, "onStartHeartBeat():" + paramToServiceMsg);
            i = 0;
            continue;
            paramToServiceMsg = null;
            continue;
            label292:
            long l1 = 0L;
            continue;
            label298:
            i = 0;
            continue;
            label304:
            int j = 0;
          }
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("HeartBeatController", 2, "onStartHeartBeat() failed");
    }
    ObserverCenter.a().a(GameRoomObserver.class, 5, false, new Object[] { "", Long.valueOf(l2), paramFromServiceMsg });
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int m = paramToServiceMsg.extraData.getInt("game_type");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label364;
      }
      paramFromServiceMsg = new AvGameStrangerMatchV2.AddMatchRoomRsp();
      int k = -1;
      j = k;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        j = k;
        k = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        j = k;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        j = k;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          i = 0;
          QLog.e("avgame_logic.GameRoomHandler", 1, "onStartStrangerMatchV2:" + paramToServiceMsg);
          paramToServiceMsg = null;
          continue;
          paramFromServiceMsg = null;
        }
        ObserverCenter.a().b(GameRoomObserver.class, 18, false, new Object[] { Long.valueOf(l), Integer.valueOf(m), null, Integer.valueOf(j), paramToServiceMsg });
        return;
      }
      GameUtil.a("avgame_logic.GameRoomHandler", "onStartStrangerMatchV2()", null, new MessageMicro[] { paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatchV2() roomId=%d errCode=%d errMsg=%s type=%d", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg, Integer.valueOf(m) }));
      }
      if ((i == 0) || (j != 0)) {
        break label316;
      }
      if (!paramFromServiceMsg.extra_info.has()) {
        break;
      }
      paramFromServiceMsg = paramFromServiceMsg.extra_info.get().toByteArray();
      ObserverCenter.a().b(GameRoomObserver.class, 18, true, new Object[] { Long.valueOf(l), Integer.valueOf(m), paramFromServiceMsg, Integer.valueOf(j), paramToServiceMsg });
      return;
    }
    label316:
    label364:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatchV2() fail roomId=%d", new Object[] { Long.valueOf(l) }));
    }
    ObserverCenter.a().b(GameRoomObserver.class, 18, false, new Object[] { Long.valueOf(l), Integer.valueOf(m), null, Integer.valueOf(0), null });
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int m = paramToServiceMsg.extraData.getInt("game_type");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label330;
      }
      paramFromServiceMsg = new AvGameStrangerMatch.DelMatchRoomRsp();
      int k = -1;
      j = k;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        j = k;
        k = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        j = k;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        j = k;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          i = 0;
          QLog.e("avgame_logic.GameRoomHandler", 1, "onStopStrangerMatch:" + paramToServiceMsg);
          paramToServiceMsg = null;
        }
        ObserverCenter.a().b(GameRoomObserver.class, 19, false, new Object[] { Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(j), paramToServiceMsg });
        return;
      }
      GameUtil.a("avgame_logic.GameRoomHandler", "onStopStrangerMatch()", null, new MessageMicro[] { paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStopStrangerMatch() roomId=%d errCode=%d errMsg=%s gameType=%d", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg, Integer.valueOf(m) }));
      }
      if ((i == 0) || (j != 0)) {
        break;
      }
      ObserverCenter.a().b(GameRoomObserver.class, 19, true, new Object[] { Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(j), paramToServiceMsg });
      return;
    }
    label330:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStopStrangerMatch() fail roomId=%d", new Object[] { Long.valueOf(l) }));
    }
    ObserverCenter.a().b(GameRoomObserver.class, 19, false, new Object[] { Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(0), null });
  }
  
  public void a()
  {
    ActivityCenter.GetActivitysReq localGetActivitysReq = new ActivityCenter.GetActivitysReq();
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.ActivityCenter-GetActivitys");
    localToServiceMsg.putWupBuffer(localGetActivitysReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 4, "sendGetActivityEntryReq");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AvGamePkManager.PKOperationReq localPKOperationReq = new AvGamePkManager.PKOperationReq();
    localPKOperationReq.uin.set(Long.parseLong(this.appRuntime.getAccount()));
    localPKOperationReq.pk_id.set(paramInt2);
    localPKOperationReq.opt.set(paramInt1);
    if (paramInt1 != 1) {
      localPKOperationReq.pool_id.set(paramInt3);
    }
    localPKOperationReq.cur_round.set(paramInt4);
    localPKOperationReq.support_cj.set(true);
    localPKOperationReq.local_mod_status.set(paramInt5);
    Object localObject = GameEngine.a().a();
    if ((paramInt1 == 2) && (localObject != null) && (paramBoolean))
    {
      if (((EngineData)localObject).o() != 6) {
        break label216;
      }
      localPKOperationReq.leave_scene.set(2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("avgame_logic.GameRoomHandler", 2, "sendSurvivalOperation leave_scene=" + localPKOperationReq.leave_scene.get());
      }
      localObject = createToServiceMsg("qqvgame.PKManager-PKOperation");
      ((ToServiceMsg)localObject).putWupBuffer(localPKOperationReq.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).addAttribute("opeType", Integer.valueOf(paramInt1));
      sendPbReq((ToServiceMsg)localObject);
      return;
      label216:
      if (((EngineData)localObject).o() == 7) {
        localPKOperationReq.leave_scene.set(1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "getPKInfo " + paramInt1 + " poolId:" + paramInt2 + " reqCount:" + paramInt4 + " isPkStart:" + paramBoolean1 + " isInGame=" + paramBoolean2);
    }
    b(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameRoomHandler", 2, "createGameRoom " + paramInt1 + " troopUin: " + paramString + " scene:" + paramInt3 + " trans_mod:" + AVGameVoiceRecog.a().b());
    }
    Object localObject = this.appRuntime.getAccount();
    try
    {
      AvGameRoomManager.CmdRoomCreateReq localCmdRoomCreateReq = new AvGameRoomManager.CmdRoomCreateReq();
      localCmdRoomCreateReq.creator_uin.set(AvGameEntranceUtil.a((String)localObject));
      localCmdRoomCreateReq.game_type.set(paramInt2);
      int i = AvGameRoomListHandler.a(paramInt1);
      localCmdRoomCreateReq.from.set(i);
      localCmdRoomCreateReq.scene.set(paramInt3);
      localObject = localCmdRoomCreateReq.trans_mod;
      if (AVGameVoiceRecog.a().b()) {}
      for (paramInt2 = 0;; paramInt2 = 1)
      {
        ((PBUInt32Field)localObject).set(paramInt2);
        if (i == 3)
        {
          localCmdRoomCreateReq.group_id.set(AvGameEntranceUtil.a(paramString));
          if (TextUtils.isEmpty(paramString)) {
            QLog.e("avgame_logic.GameRoomHandler", 1, "troopUin EMPTY FP =" + paramInt1);
          }
        }
        if ((GameEngine.a().f()) && (GameEngine.a().a() != null))
        {
          localCmdRoomCreateReq.pk_id.set(GameEngine.a().a().k());
          localCmdRoomCreateReq.pool_id.set(GameEngine.a().a().j());
          if (QLog.isColorLevel()) {
            QLog.d("avgame_logic.GameRoomHandler", 2, "createGameRoom pk_id=" + localCmdRoomCreateReq.pk_id.get() + " pool_id=" + localCmdRoomCreateReq.pool_id.get());
          }
        }
        paramString = createToServiceMsg("qqvgame.RoomManager-RoomCreate");
        paramString.putWupBuffer(localCmdRoomCreateReq.toByteArray());
        sendPbReq(paramString);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("avgame_logic.GameRoomHandler", 1, "reportUser exception:", paramString);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameRoomHandler", 2, "joinGameRoom " + paramInt1 + " roomId: " + paramString1 + " scene:" + paramInt2 + " trans_mod:" + AVGameVoiceRecog.a().b());
    }
    Object localObject = this.appRuntime.getAccount();
    try
    {
      AvGameRoomManager.CmdRoomEnterReq localCmdRoomEnterReq = new AvGameRoomManager.CmdRoomEnterReq();
      int j = AvGameRoomListHandler.b(paramInt1);
      localCmdRoomEnterReq.from.set(j);
      localCmdRoomEnterReq.uin.set(AvGameEntranceUtil.a((String)localObject));
      localCmdRoomEnterReq.scene.set(paramInt2);
      localObject = localCmdRoomEnterReq.trans_mod;
      if (AVGameVoiceRecog.a().b()) {}
      for (paramInt2 = i;; paramInt2 = 1)
      {
        ((PBUInt32Field)localObject).set(paramInt2);
        if ((paramInt1 == 1) || (paramInt1 == 2))
        {
          localCmdRoomEnterReq.invitor_uin.set(AvGameEntranceUtil.a(paramString2));
          if (TextUtils.isEmpty(paramString2)) {
            QLog.e("avgame_logic.GameRoomHandler", 1, "INVITER UIN EMPTY FP=" + paramInt1);
          }
        }
        localCmdRoomEnterReq.roomid.set(AvGameEntranceUtil.a(paramString1));
        localCmdRoomEnterReq.invitor_uin.set(AvGameEntranceUtil.a(paramString2));
        if ((GameEngine.a().f()) && (GameEngine.a().a() != null)) {
          localCmdRoomEnterReq.pk_opponent_uin.set(GameEngine.a().a().jdField_b_of_type_Long);
        }
        localCmdRoomEnterReq.init_status.set(0);
        paramString1 = createToServiceMsg("qqvgame.RoomManager-RoomEnter");
        paramString1.putWupBuffer(localCmdRoomEnterReq.toByteArray());
        sendPbReq(paramString1);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("avgame_logic.GameRoomHandler", 1, "reportUser exception:", paramString1);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    QLog.i("avgame_logic.GameRoomHandler", 1, "exitSurvivalPool  " + paramInt + " isNeedReqGameResult=" + paramBoolean);
    a(2, GameEngine.a().a().k(), paramInt, 0, 0, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    AvGameList.CmdGameListReq localCmdGameListReq = new AvGameList.CmdGameListReq();
    localCmdGameListReq.roomid.set(paramLong);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameList-GetGameList");
    localToServiceMsg.putWupBuffer(localCmdGameListReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "getGameRoomList() roomId = " + paramLong);
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("stopStrangerMatch() roomId=%d shareId=%d ownerUin=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt), Long.valueOf(paramLong2) }));
    }
    AvGameStrangerMatch.DelMatchRoomReq localDelMatchRoomReq = new AvGameStrangerMatch.DelMatchRoomReq();
    localDelMatchRoomReq.roomid.set(paramLong1);
    localDelMatchRoomReq.type.set(0);
    localDelMatchRoomReq.shard_id.set(paramInt);
    localDelMatchRoomReq.owner_uin.set(paramLong2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatch-DelMatchRoom");
    localToServiceMsg.putWupBuffer(localDelMatchRoomReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong1);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AvGameRoomManager.CmdRoomLeaveReq localCmdRoomLeaveReq = new AvGameRoomManager.CmdRoomLeaveReq();
    localCmdRoomLeaveReq.roomid.set(paramLong);
    localCmdRoomLeaveReq.reason.set(paramInt);
    localCmdRoomLeaveReq.operator_uin.set(Long.valueOf(paramString1).longValue());
    localCmdRoomLeaveReq.target_uin.set(Long.valueOf(paramString2).longValue());
    localCmdRoomLeaveReq.scene.set(0);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.RoomManager-RoomLeave");
    localToServiceMsg.putWupBuffer(localCmdRoomLeaveReq.toByteArray());
    localToServiceMsg.extraData.putInt("leave_game_room_type", paramInt);
    localToServiceMsg.extraData.putString("user_uin", paramString2);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    localToServiceMsg.extraData.putLong("scene_id", 0L);
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("leaveGameRoom() leaveType=%d rId=%d [opUin,dstUin]=[%s,%s] scene=%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString1, paramString2, Integer.valueOf(0) }));
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("startStrangerMatch() roomId=%d ownerUin=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    AvGameStrangerMatch.AddMatchRoomReq localAddMatchRoomReq = new AvGameStrangerMatch.AddMatchRoomReq();
    localAddMatchRoomReq.roomid.set(paramLong1);
    localAddMatchRoomReq.type.set(0);
    localAddMatchRoomReq.owner_uin.set(paramLong2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatch-AddMatchRoom");
    localToServiceMsg.putWupBuffer(localAddMatchRoomReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong1);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("startStrangerMatchV2() roomId=%d ownerUin=%d gameType=%d from=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    AvGameStrangerMatchV2.AddMatchRoomReq localAddMatchRoomReq = new AvGameStrangerMatchV2.AddMatchRoomReq();
    localAddMatchRoomReq.roomid.set(paramLong1);
    localAddMatchRoomReq.game_type.set(paramInt1);
    localAddMatchRoomReq.owner_uin.set(paramLong2);
    localAddMatchRoomReq.from.set(paramInt2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatchV2-AddMatchRoom");
    localToServiceMsg.putWupBuffer(localAddMatchRoomReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong1);
    localToServiceMsg.extraData.putInt("game_type", paramInt1);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("stopStrangerMatch() roomId=%d ownerUin=%d gameType=%d from=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    AvGameStrangerMatchV2.DelMatchRoomReq localDelMatchRoomReq = new AvGameStrangerMatchV2.DelMatchRoomReq();
    localDelMatchRoomReq.roomid.set(paramLong1);
    localDelMatchRoomReq.game_type.set(paramInt1);
    if (paramArrayOfByte != null) {
      localDelMatchRoomReq.extr_info.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localDelMatchRoomReq.owner_uin.set(paramLong2);
    localDelMatchRoomReq.from.set(paramInt2);
    paramArrayOfByte = createToServiceMsg("qqvgame.StrangerMatchV2-DelMatchRoom");
    paramArrayOfByte.putWupBuffer(localDelMatchRoomReq.toByteArray());
    paramArrayOfByte.setTimeout(30000L);
    paramArrayOfByte.extraData.putLong("room_id", paramLong1);
    paramArrayOfByte.extraData.putInt("game_type", paramInt1);
    sendPbReq(paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    try
    {
      AvGameShare.CmdGetShareLinkReq localCmdGetShareLinkReq = new AvGameShare.CmdGetShareLinkReq();
      if (paramInt1 == 4)
      {
        localCmdGetShareLinkReq.share_uin.set(paramLong2);
        localCmdGetShareLinkReq.share_type.set(paramInt1);
      }
      for (;;)
      {
        paramString1 = createToServiceMsg("qqvgame.Share-GetShareLink");
        paramString1.putWupBuffer(localCmdGetShareLinkReq.toByteArray());
        paramString1.extraData.putLong("mark_extra_tag", paramLong3);
        sendPbReq(paramString1);
        return;
        localCmdGetShareLinkReq.roomid.set(paramLong1);
        localCmdGetShareLinkReq.share_uin.set(paramLong2);
        localCmdGetShareLinkReq.share_name.set(paramString1);
        localCmdGetShareLinkReq.share_type.set(paramInt1);
        if (paramInt1 == 2)
        {
          localCmdGetShareLinkReq.play_game_id.set(paramString2);
          localCmdGetShareLinkReq.game_type.set(paramInt2);
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("avgame_logic.GameRoomHandler", 1, "getShareLink exception: " + paramString1.getMessage());
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    AvGameHeartBeat.CmdUserHeartBeatReq localCmdUserHeartBeatReq = new AvGameHeartBeat.CmdUserHeartBeatReq();
    localCmdUserHeartBeatReq.roomid.set(paramLong);
    localCmdUserHeartBeatReq.uin.set(Long.valueOf(paramString).longValue());
    localCmdUserHeartBeatReq.room_state.set(paramInt);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.UserHeartBeat-UserHeartBeat");
    localToServiceMsg.putWupBuffer(localCmdUserHeartBeatReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    localToServiceMsg.extraData.putString("user_uin", paramString);
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("HeartBeatController", 2, "startHeartBeat() roomId = " + paramLong + " userUin=" + paramString);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AvGameRoomManager.CmdRoomChangeUserStatusReq localCmdRoomChangeUserStatusReq = new AvGameRoomManager.CmdRoomChangeUserStatusReq();
    localCmdRoomChangeUserStatusReq.roomid.set(paramLong);
    localCmdRoomChangeUserStatusReq.uin.set(Long.valueOf(paramString).longValue());
    localCmdRoomChangeUserStatusReq.user_status.set(paramInt1);
    localCmdRoomChangeUserStatusReq.scene.set(paramInt3);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.RoomManager-RoomUserStatusChange");
    localToServiceMsg.putWupBuffer(localCmdRoomChangeUserStatusReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    localToServiceMsg.extraData.putInt("change_status_from", paramInt2);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("changUserStatus() rId=%d uin=%s uStatus=%d scene=%d", new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) }));
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AvGameRoomManager.CmdRoomInfoReq localCmdRoomInfoReq = new AvGameRoomManager.CmdRoomInfoReq();
    localCmdRoomInfoReq.roomids.set(paramLong);
    localCmdRoomInfoReq.uin.set(Long.valueOf(paramString).longValue());
    Object localObject = localCmdRoomInfoReq.opt;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localCmdRoomInfoReq.scene.set(paramInt2);
      localObject = createToServiceMsg("qqvgame.RoomManager-RoomInfoGet");
      ((ToServiceMsg)localObject).putWupBuffer(localCmdRoomInfoReq.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("is_from_sync", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putInt("snapshot_from", paramInt1);
      ((ToServiceMsg)localObject).extraData.putString("user_uin", paramString);
      ((ToServiceMsg)localObject).extraData.putLong("room_id", paramLong);
      sendPbReq((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("getGameRoomInfo() roomId=%d uin=%s fromSync=%b from=%d scene=%d", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      return;
    }
  }
  
  public void a(long paramLong, ArrayList<Integer> paramArrayList)
  {
    AvGameList.CmdGetQuestionClassReq localCmdGetQuestionClassReq = new AvGameList.CmdGetQuestionClassReq();
    localCmdGetQuestionClassReq.roomid.set(paramLong);
    localCmdGetQuestionClassReq.game_type_list.set(paramArrayList);
    paramArrayList = createToServiceMsg("qqvgame.GameList-GetQuestionClass");
    paramArrayList.putWupBuffer(localCmdGetQuestionClassReq.toByteArray());
    paramArrayList.setTimeout(30000L);
    paramArrayList.extraData.putLong("room_id", paramLong);
    sendPbReq(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "getQuestionClass() roomId = " + paramLong);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    AvGameRoomManager.CmdRoomCreateRsp localCmdRoomCreateRsp;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      localCmdRoomCreateRsp = new AvGameRoomManager.CmdRoomCreateRsp();
      if (QLog.isColorLevel()) {
        QLog.d("avgame_logic.GameRoomHandler", 2, "handleCreateGameRoom. ");
      }
      if (i == 0) {
        break label177;
      }
    }
    for (;;)
    {
      try
      {
        localCmdRoomCreateRsp.mergeFrom((byte[])paramObject);
        j = i;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleCreateGameRoom.  InvalidProtocolBufferMicroException result：" + paramToServiceMsg.toString());
        j = 0;
        continue;
      }
      paramFromServiceMsg = null;
      if (j == 0) {
        break label628;
      }
      if (localCmdRoomCreateRsp.res.has()) {
        break label221;
      }
      ObserverCenter.a().b(GameRoomObserver.class, 15, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
      QLog.d("avgame_logic.GameRoomHandler", 2, "handleCreateGameRoom.  rspBody.res.has nothing");
      return;
      i = 0;
      break;
      label177:
      j = i;
      if (paramFromServiceMsg != null)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        j = i;
      }
    }
    label221:
    int j = localCmdRoomCreateRsp.res.errcode.get();
    long l1 = -1L;
    long l2 = 0L;
    if (localCmdRoomCreateRsp.room_info.has())
    {
      l1 = localCmdRoomCreateRsp.room_info.roomid.get();
      paramFromServiceMsg = new RoomInfo();
      paramFromServiceMsg.parseFrom(localCmdRoomCreateRsp.room_info);
      paramToServiceMsg = "";
      if (paramFromServiceMsg.players.size() > 0) {
        paramToServiceMsg = ((Player)paramFromServiceMsg.players.get(0)).uin;
      }
      QLog.d("avgame_logic.GameRoomHandler", 2, "roominfo :  " + paramFromServiceMsg.toString() + " players:" + paramFromServiceMsg.players.size() + " playerUin" + paramToServiceMsg);
      if (!localCmdRoomCreateRsp.auth_info.has()) {
        break label604;
      }
      if (!localCmdRoomCreateRsp.auth_info.has()) {
        break label599;
      }
      paramToServiceMsg = localCmdRoomCreateRsp.auth_info.get().toByteArray();
      label407:
      if (paramToServiceMsg == null) {
        break label681;
      }
      i = paramToServiceMsg.length;
    }
    for (;;)
    {
      label415:
      if (localCmdRoomCreateRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomCreateRsp.black_ban_expire_time.get();
      }
      if (localCmdRoomCreateRsp.res.errmsg.has()) {}
      for (paramObject = localCmdRoomCreateRsp.res.errmsg.get().toStringUtf8();; paramObject = "")
      {
        QLog.d("avgame_logic.GameRoomHandler", 2, new Object[] { "handleCreateGameRoom. ret = ", j + " errMsg : " + paramObject + " roomId:" + l1 + "sig length" + i + " banExpireTime:" + l2 });
        ObserverCenter.a().b(GameRoomObserver.class, 15, true, new Object[] { Integer.valueOf(j), paramObject, paramFromServiceMsg, paramToServiceMsg, Long.valueOf(l2) });
        return;
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleCreateGameRoom room_info empty");
        break;
        label599:
        paramToServiceMsg = null;
        break label407;
        label604:
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleCreateGameRoom auth_info empty");
        i = 0;
        paramToServiceMsg = null;
        break label415;
      }
      label628:
      ObserverCenter.a().b(GameRoomObserver.class, 15, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
      QLog.d("avgame_logic.GameRoomHandler", 2, "handleCreateGameRoom. failed not suc");
      return;
      label681:
      i = 0;
    }
  }
  
  public void a(String paramString)
  {
    ActivityCenter.SyncShareGameReq localSyncShareGameReq = new ActivityCenter.SyncShareGameReq();
    localSyncShareGameReq.play_game_id.set(paramString);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.ActivityCenter-SyncShareGame");
    localToServiceMsg.putWupBuffer(localSyncShareGameReq.toByteArray());
    localToServiceMsg.extraData.putString("playGameId", paramString);
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 4, "syncShareGame, playGameId[" + paramString + "]");
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    AvGamePlay.SelectGameReq localSelectGameReq = new AvGamePlay.SelectGameReq();
    localSelectGameReq.uin.set(Long.valueOf(paramString).longValue());
    localSelectGameReq.roomid.set(paramLong);
    localSelectGameReq.type.set(paramInt);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameManager-SelectGame");
    localToServiceMsg.putWupBuffer(localSelectGameReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("selectGame() %s rId=%d gType=%d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      long l1;
      long l2;
      String str2;
      try
      {
        i = paramNotifyMsg.type.get();
        l1 = paramNotifyMsg.seq.get();
        l2 = paramNotifyMsg.roomid.get();
        str2 = paramNotifyMsg.play_game_id.get();
        QLog.d("avgame_logic.GameRoomHandler", 1, String.format("handleOnlinePush type=%d [%s] seq=%d roomId=%d gameId=%s", new Object[] { Integer.valueOf(i), GameUtil.a(i), Long.valueOf(l1), Long.valueOf(l2), str2 }));
        if (GameEngine.a().a() == null) {
          break label433;
        }
        str1 = GameEngine.a().a().b();
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1)) || (str1.equals(str2))) {
          break label301;
        }
        CJSurvivalFestivalReporter.a(str2, i);
      }
      catch (Exception paramNotifyMsg)
      {
        QLog.d("avgame_logic.GameRoomHandler", 1, "handleOnlinePush()  e = " + paramNotifyMsg);
        paramNotifyMsg.printStackTrace();
        return;
      }
      g(paramNotifyMsg, l1, l2);
      return;
      f(paramNotifyMsg, l1, l2);
      return;
      e(paramNotifyMsg, l1, l2);
      return;
      d(paramNotifyMsg, l1, l2);
      return;
      c(paramNotifyMsg, l1, l2);
      return;
      a(paramNotifyMsg, l1, l2, str2);
      return;
      b(paramNotifyMsg);
      if (i == 501) {
        bool = true;
      }
      a(bool, paramNotifyMsg, l1);
      return;
      b(paramNotifyMsg);
      b(paramNotifyMsg, l1, l2);
      return;
      b(paramNotifyMsg);
      a(paramNotifyMsg, l1, l2);
      return;
      b(paramNotifyMsg);
      c(paramNotifyMsg);
      return;
      label301:
      switch (i)
      {
      }
      return;
      label433:
      String str1 = "";
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    QLog.i("avgame_logic.GameRoomHandler", 1, "enterSurvivalPool first:" + paramBoolean + " pkId:" + paramInt1 + " poolId:" + paramInt2 + " round:" + paramInt3 + " localVoice:" + paramInt4);
    if (paramBoolean)
    {
      if (paramInt3 >= 0) {
        break label102;
      }
      paramInt3 = 0;
    }
    label102:
    for (;;)
    {
      a(i, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      i = 3;
      break;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AvGamePkManager.GetPKInfoReq localGetPKInfoReq = new AvGamePkManager.GetPKInfoReq();
    localGetPKInfoReq.pk_id.set(paramInt1);
    localGetPKInfoReq.pool_id.set(paramInt2);
    localGetPKInfoReq.pull_count.set(paramInt4);
    localGetPKInfoReq.pk_start.set(paramBoolean1);
    localGetPKInfoReq.in_game.set(paramBoolean2);
    localGetPKInfoReq.scene.set(paramInt3);
    localGetPKInfoReq.uin.set(Long.parseLong(this.appRuntime.getAccount()));
    localGetPKInfoReq.support_fresh_at_midfield.set(true);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.PKManager-GetPKInfo");
    localToServiceMsg.putWupBuffer(localGetPKInfoReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  public void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AvGameRoomManager.CmdRoomLeaveReq localCmdRoomLeaveReq = new AvGameRoomManager.CmdRoomLeaveReq();
    localCmdRoomLeaveReq.roomid.set(paramLong);
    localCmdRoomLeaveReq.reason.set(paramInt);
    localCmdRoomLeaveReq.operator_uin.set(Long.valueOf(paramString1).longValue());
    localCmdRoomLeaveReq.target_uin.set(Long.valueOf(paramString2).longValue());
    localCmdRoomLeaveReq.scene.set(1);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.RoomManager-RoomLeave");
    localToServiceMsg.putWupBuffer(localCmdRoomLeaveReq.toByteArray());
    localToServiceMsg.extraData.putInt("leave_game_room_type", paramInt);
    localToServiceMsg.extraData.putString("user_uin", paramString2);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    localToServiceMsg.extraData.putLong("scene_id", 1L);
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("leaveGameRoomForQQCJ() leaveType=%d rId=%d [opUin,dstUin]=[%s,%s] scene=%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString1, paramString2, Integer.valueOf(1) }));
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameRoomManager.CmdRoomEnterRsp localCmdRoomEnterRsp = new AvGameRoomManager.CmdRoomEnterRsp();
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("avgame_logic.GameRoomHandler", 2, "handleJoinGameRoom. isSuccess = " + bool1);
      }
      if (!bool1) {
        break label195;
      }
    }
    for (;;)
    {
      try
      {
        localCmdRoomEnterRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleJoinGameRoom.  false result：" + paramToServiceMsg.toString());
        bool2 = false;
        continue;
      }
      paramFromServiceMsg = null;
      if (!bool2) {
        break label596;
      }
      if (localCmdRoomEnterRsp.res.has()) {
        break label239;
      }
      ObserverCenter.a().b(GameRoomObserver.class, 16, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
      QLog.d("avgame_logic.GameRoomHandler", 2, "handleJoinGameRoom.  rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label195:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label239:
    int j = localCmdRoomEnterRsp.res.errcode.get();
    long l1 = -1L;
    paramObject = null;
    int i = 0;
    long l2 = 0L;
    if (localCmdRoomEnterRsp.room_info.has())
    {
      l1 = localCmdRoomEnterRsp.room_info.roomid.get();
      paramFromServiceMsg = new RoomInfo();
      paramFromServiceMsg.parseFrom(localCmdRoomEnterRsp.room_info);
      QLog.d("avgame_logic.GameRoomHandler", 2, "roominfo :  " + paramFromServiceMsg.toString() + " players:" + paramFromServiceMsg.players.size());
      if (!localCmdRoomEnterRsp.auth_info.has()) {
        break label577;
      }
      if (!localCmdRoomEnterRsp.auth_info.has()) {
        break label572;
      }
      paramToServiceMsg = localCmdRoomEnterRsp.auth_info.get().toByteArray();
      label387:
      paramObject = paramToServiceMsg;
      if (paramToServiceMsg != null)
      {
        i = paramToServiceMsg.length;
        paramObject = paramToServiceMsg;
      }
      label399:
      if (localCmdRoomEnterRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomEnterRsp.black_ban_expire_time.get();
      }
      if (!localCmdRoomEnterRsp.res.errmsg.has()) {
        break label589;
      }
    }
    label572:
    label577:
    label589:
    for (paramToServiceMsg = localCmdRoomEnterRsp.res.errmsg.get().toStringUtf8();; paramToServiceMsg = "")
    {
      QLog.d("avgame_logic.GameRoomHandler", 2, new Object[] { "handleJoinGameRoom. ret = ", j + " errMsg : " + paramToServiceMsg + " roomId:" + l1 + "sig length" + i });
      ObserverCenter.a().b(GameRoomObserver.class, 16, true, new Object[] { Integer.valueOf(j), paramToServiceMsg, paramFromServiceMsg, paramObject, Long.valueOf(l2) });
      return;
      QLog.e("avgame_logic.GameRoomHandler", 1, "handleJoinGameRoom room_info empty");
      break;
      paramToServiceMsg = null;
      break label387;
      QLog.e("avgame_logic.GameRoomHandler", 1, "handleJoinGameRoom auth_info empty");
      break label399;
    }
    label596:
    ObserverCenter.a().b(GameRoomObserver.class, 16, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
    QLog.d("avgame_logic.GameRoomHandler", 2, "handleJoinGameRoom. failed not suc");
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      String[] arrayOfString = AVGameCmdUtil.a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          this.allowCmdSet.add(str);
        }
        i += 1;
      }
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return GameRoomObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("qqvgame.GameList-GetGameList".equals(str)) {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("qqvgame.RoomManager-RoomInfoGet".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomLeave".equals(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomUserStatusChange".equals(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.UserHeartBeat-UserHeartBeat".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.GameManager-SelectGame".equals(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.Share-GetShareLink".equals(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.GameList-GetQuestionClass".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.ActivityCenter-GetActivitys".equals(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.ActivityCenter-SyncShareGame".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.StrangerMatch-AddMatchRoom".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.StrangerMatch-DelMatchRoom".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.PKManager-PKOperation".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomCreate".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomEnter".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.PKManager-GetPKInfo".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.StrangerMatchV2-AddMatchRoom".equals(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"qqvgame.StrangerMatchV2-DelMatchRoom".equals(str));
    r(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.handler.GameRoomHandler
 * JD-Core Version:    0.7.0.1
 */