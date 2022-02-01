package com.tencent.avgame.gamelogic.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.business.handler.AVGameBusinessHandler;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.IGame;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.QualityReporter;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.QuestionClassInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.PKDrawRes;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.Pair;
import com.tencent.avgame.gamelogic.observer.GameRoomObserver;
import com.tencent.avgame.localvoicerecog.api.IAVGameVoiceRecog;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
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
import com.tencent.mobileqq.qroute.QRoute;
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
import trpc.qq_vgame.playgame.AvGamePlay.SelectGameReq;
import trpc.qq_vgame.playgame.AvGamePlay.SelectGameRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterRsp;
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
    if (paramPKDrawRes != null) {
      return new SurvivalPkResultInfo.PKDrawRes(paramPKDrawRes.is_draw.get(), paramPKDrawRes.self_cost.get(), paramPKDrawRes.peer_cost.get());
    }
    return null;
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
    long l1 = 0L;
    long l2;
    if (paramBoolean)
    {
      AvGameNotify.NotifyPKUserCreateRoom localNotifyPKUserCreateRoom = (AvGameNotify.NotifyPKUserCreateRoom)paramNotifyMsg.pk_user_create_room.get();
      IGameEngine.a().a().b(paramNotifyMsg.realPoolID.get());
      l2 = 0L;
    }
    else
    {
      paramNotifyMsg = (AvGameNotify.NotifyPKUserEnterRoom)paramNotifyMsg.pk_user_enter_room.get();
      l1 = paramNotifyMsg.roomid.get();
      l2 = paramNotifyMsg.peer_uin.get();
      GameUtil.a("avgame_logic.GameRoomHandler", "handlePkRoomCreateOrEnterPush", null, new MessageMicro[] { paramNotifyMsg });
    }
    ObserverCenter.a().b(GameRoomObserver.class, 26, true, new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), Long.valueOf(l1), Boolean.valueOf(true), Long.valueOf(l2) });
  }
  
  private boolean a(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    int i = paramNotifyMsg.poolID.get();
    int j = paramNotifyMsg.realPoolID.get();
    int k = paramNotifyMsg.pkID.get();
    int m = IGameEngine.a().a().jdField_b_of_type_Int;
    if (((m != i) && (m != j)) || ((IGameEngine.a().a().c != k) && (m != 0)))
    {
      paramNotifyMsg = new StringBuilder();
      paramNotifyMsg.append("checkPkPushValid() ");
      paramNotifyMsg.append(i);
      paramNotifyMsg.append(" ");
      paramNotifyMsg.append(j);
      paramNotifyMsg.append(" ");
      paramNotifyMsg.append(m);
      QLog.d("avgame_logic.GameRoomHandler", 2, paramNotifyMsg.toString());
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
    if (paramNotifyMsg.poolID.get() == IGameEngine.a().a().j()) {
      IGameEngine.a().a().b(paramNotifyMsg.realPoolID.get());
    }
  }
  
  private void b(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    Object localObject2 = Boolean.valueOf(false);
    AvGameNotify.NotifyPKUserFail localNotifyPKUserFail = null;
    Object localObject1 = null;
    GameUtil.a("avgame_logic.GameRoomHandler", "handlePkEndUserResult", null, new MessageMicro[] { paramNotifyMsg });
    if (!a(paramNotifyMsg))
    {
      QLog.d("avgame_logic.GameRoomHandler", 2, "handlePkEndUserResult() poolId or pkId wrong ");
      return;
    }
    int i = paramNotifyMsg.type.get();
    if (i == 503)
    {
      paramNotifyMsg = (AvGameNotify.NotifyPKUserSucc)paramNotifyMsg.pk_user_succ.get();
      localObject1 = new SurvivalPkResultInfo();
      ((SurvivalPkResultInfo)localObject1).winReason = paramNotifyMsg.reason.get();
      ((SurvivalPkResultInfo)localObject1).winRound = paramNotifyMsg.cur_round.get();
      if (paramNotifyMsg.draw_res.has()) {
        ((SurvivalPkResultInfo)localObject1).pkDrawRes = a((AvGameNotify.PKDrawRes)paramNotifyMsg.draw_res.get());
      }
      ((SurvivalPkResultInfo)localObject1).winTips = paramNotifyMsg.win_tip.get();
      ((SurvivalPkResultInfo)localObject1).score = paramNotifyMsg.score.get();
      ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(1), localObject2, localObject1 });
      return;
    }
    if (i == 505)
    {
      localNotifyPKUserFail = (AvGameNotify.NotifyPKUserFail)paramNotifyMsg.pk_user_fail.get();
      localObject2 = new SurvivalPkResultInfo();
      if (localNotifyPKUserFail != null)
      {
        ((SurvivalPkResultInfo)localObject2).gameSur = false;
        ((SurvivalPkResultInfo)localObject2).rank = localNotifyPKUserFail.rank.get();
        ((SurvivalPkResultInfo)localObject2).total = localNotifyPKUserFail.total.get();
        ((SurvivalPkResultInfo)localObject2).hasAward = localNotifyPKUserFail.has_consolation_award.get();
        ((SurvivalPkResultInfo)localObject2).awardText = localNotifyPKUserFail.award_str.get().toStringUtf8();
        ((SurvivalPkResultInfo)localObject2).awardUrl = localNotifyPKUserFail.award_url.get().toStringUtf8();
        if (localNotifyPKUserFail.award_url_str.has()) {
          paramNotifyMsg = localNotifyPKUserFail.award_url_str.get().toStringUtf8();
        } else {
          paramNotifyMsg = null;
        }
        ((SurvivalPkResultInfo)localObject2).awardUrlStr = paramNotifyMsg;
        ((SurvivalPkResultInfo)localObject2).delayAward = localNotifyPKUserFail.delay_award.get();
        paramNotifyMsg = (AvGameNotify.NotifyMsg)localObject1;
        if (localNotifyPKUserFail.delay_award_tip.has()) {
          paramNotifyMsg = localNotifyPKUserFail.delay_award_tip.get().toStringUtf8();
        }
        ((SurvivalPkResultInfo)localObject2).delayAwardTip = paramNotifyMsg;
        if (localNotifyPKUserFail.draw_res.has()) {
          ((SurvivalPkResultInfo)localObject2).pkDrawRes = a((AvGameNotify.PKDrawRes)localNotifyPKUserFail.draw_res.get());
        }
        ((SurvivalPkResultInfo)localObject2).isBothClose = localNotifyPKUserFail.both_lose.get();
        ((SurvivalPkResultInfo)localObject2).score = localNotifyPKUserFail.score.get();
      }
      ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(2), localBoolean, localObject2 });
      return;
    }
    if (i == 504)
    {
      localObject1 = (AvGameNotify.NotifyPKUserFinalSucc)paramNotifyMsg.pk_user_final_succ.get();
      localObject2 = new SurvivalPkResultInfo();
      if (localObject1 != null)
      {
        ((SurvivalPkResultInfo)localObject2).gameSur = true;
        ((SurvivalPkResultInfo)localObject2).winReason = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).reason.get();
        ((SurvivalPkResultInfo)localObject2).awardText = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).award_str.get().toStringUtf8();
        ((SurvivalPkResultInfo)localObject2).awardUrl = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).award_url.get().toStringUtf8();
        ((SurvivalPkResultInfo)localObject2).hasAward = (TextUtils.isEmpty(((SurvivalPkResultInfo)localObject2).awardUrl) ^ true);
        ((SurvivalPkResultInfo)localObject2).total = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).total.get();
        if (((AvGameNotify.NotifyPKUserFinalSucc)localObject1).award_url_str.has()) {
          paramNotifyMsg = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).award_url_str.get().toStringUtf8();
        } else {
          paramNotifyMsg = null;
        }
        ((SurvivalPkResultInfo)localObject2).awardUrlStr = paramNotifyMsg;
        ((SurvivalPkResultInfo)localObject2).delayAward = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).delay_award.get();
        paramNotifyMsg = localNotifyPKUserFail;
        if (((AvGameNotify.NotifyPKUserFinalSucc)localObject1).delay_award_tip.has()) {
          paramNotifyMsg = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).delay_award_tip.get().toStringUtf8();
        }
        ((SurvivalPkResultInfo)localObject2).delayAwardTip = paramNotifyMsg;
        if (((AvGameNotify.NotifyPKUserFinalSucc)localObject1).draw_res.has()) {
          ((SurvivalPkResultInfo)localObject2).pkDrawRes = a((AvGameNotify.PKDrawRes)((AvGameNotify.NotifyPKUserFinalSucc)localObject1).draw_res.get());
        }
        ((SurvivalPkResultInfo)localObject2).winTips = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).win_tip.get();
        if (((AvGameNotify.NotifyPKUserFinalSucc)localObject1).ranking.has()) {
          paramNotifyMsg = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).ranking.get();
        } else {
          paramNotifyMsg = new ArrayList(0);
        }
        ((SurvivalPkResultInfo)localObject2).rankingUins = a(paramNotifyMsg);
        ((SurvivalPkResultInfo)localObject2).score = ((AvGameNotify.NotifyPKUserFinalSucc)localObject1).score.get();
      }
      ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(3), localBoolean, localObject2 });
      return;
    }
    if (i == 508)
    {
      paramNotifyMsg = (AvGameNotify.NotifyPKUserDraw)paramNotifyMsg.pk_user_draw.get();
      localObject1 = new SurvivalPkResultInfo();
      ((SurvivalPkResultInfo)localObject1).winRound = paramNotifyMsg.cur_round.get();
      boolean bool = paramNotifyMsg.exit_room.get();
      ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(4), Boolean.valueOf(bool), localObject1 });
      return;
    }
    if (i == 506)
    {
      paramNotifyMsg = (AvGameNotify.NotifyPKUserPass)paramNotifyMsg.pk_user_pass.get();
      localObject1 = new SurvivalPkResultInfo();
      ((SurvivalPkResultInfo)localObject1).winRound = paramNotifyMsg.cur_round.get();
      ObserverCenter.a().b(GameRoomObserver.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(5), localObject2, localObject1 });
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    Integer localInteger = Integer.valueOf(0);
    int j;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      j = 1;
    } else {
      j = 0;
    }
    int k = -1;
    if (j != 0)
    {
      paramFromServiceMsg = new AvGameStrangerMatch.AddMatchRoomRsp();
      int i = k;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = k;
        k = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        i = k;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        i = k;
      }
      catch (Exception paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("onStartStrangerMatch:");
        paramObject.append(paramToServiceMsg);
        QLog.e("avgame_logic.GameRoomHandler", 1, paramObject.toString());
        paramToServiceMsg = null;
        j = 0;
      }
      GameUtil.a("avgame_logic.GameRoomHandler", "onStartStrangerMatch()", null, new MessageMicro[] { paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatch() roomId=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg }));
      }
      if ((j != 0) && (i == 0))
      {
        j = paramFromServiceMsg.shard_id.get();
        ObserverCenter.a().b(GameRoomObserver.class, 12, true, new Object[] { Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      ObserverCenter.a().b(GameRoomObserver.class, 12, false, new Object[] { Long.valueOf(l), localInteger, Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatch() fail roomId=%d", new Object[] { Long.valueOf(l) }));
    }
    ObserverCenter.a().b(GameRoomObserver.class, 12, false, new Object[] { Long.valueOf(l), Integer.valueOf(-1), localInteger, null });
  }
  
  private void c(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    paramNotifyMsg = (AvGameNotify.NotifyPKPoolUserChange)paramNotifyMsg.pk_pool_user_change.get();
    int i = paramNotifyMsg.opt.get();
    int j = paramNotifyMsg.total.get();
    if (paramNotifyMsg.uins.has()) {
      paramNotifyMsg = paramNotifyMsg.uins.get();
    } else {
      paramNotifyMsg = new ArrayList(0);
    }
    paramNotifyMsg = b(paramNotifyMsg);
    ObserverCenter.a().b(GameRoomObserver.class, 29, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramNotifyMsg });
  }
  
  private void c(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    paramNotifyMsg = (AvGameNotify.RoomOwnerChangeGameS2CReq)paramNotifyMsg.change_game_req.get();
    int i;
    if (paramNotifyMsg.game_type.has()) {
      i = paramNotifyMsg.game_type.get();
    } else {
      i = 1;
    }
    GameUtil.a("avgame_logic.GameRoomHandler", "handlerChangeGamePush()", new String[] { "AvGameNotify.RoomOwnerChangeGameS2CReq" }, new MessageMicro[] { paramNotifyMsg });
    ObserverCenter.a().b(GameRoomObserver.class, 24, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i) });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int j;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      paramFromServiceMsg = new AvGameStrangerMatch.DelMatchRoomRsp();
      int k = -1;
      int i = k;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = k;
        k = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        i = k;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        i = k;
      }
      catch (Exception paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("onStopStrangerMatch:");
        paramObject.append(paramToServiceMsg);
        QLog.e("avgame_logic.GameRoomHandler", 1, paramObject.toString());
        paramToServiceMsg = null;
        j = 0;
      }
      GameUtil.a("avgame_logic.GameRoomHandler", "onStopStrangerMatch()", null, new MessageMicro[] { paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStopStrangerMatch() roomId=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg }));
      }
      if ((j != 0) && (i == 0)) {
        ObserverCenter.a().b(GameRoomObserver.class, 13, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg });
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStopStrangerMatch() fail roomId=%d", new Object[] { Long.valueOf(l) }));
      }
      ObserverCenter.a().b(GameRoomObserver.class, 13, false, new Object[] { Long.valueOf(l), Integer.valueOf(0), null });
    }
  }
  
  private void d(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserChangeStatusS2CReq localRoomUserChangeStatusS2CReq = (AvGameNotify.RoomUserChangeStatusS2CReq)paramNotifyMsg.room_user_change_status_req.get();
    if (localRoomUserChangeStatusS2CReq.uin.has()) {
      paramNotifyMsg = String.valueOf(localRoomUserChangeStatusS2CReq.uin.get());
    } else {
      paramNotifyMsg = "";
    }
    int i;
    if (localRoomUserChangeStatusS2CReq.user_status.has()) {
      i = localRoomUserChangeStatusS2CReq.user_status.get();
    } else {
      i = 0;
    }
    RoomInfo localRoomInfo = GameUtil.a((AvGameCommon.RoomInfo)localRoomUserChangeStatusS2CReq.room_info.get());
    GameUtil.a("avgame_logic.GameRoomHandler", "handlerChangeUserStatusPush()", new String[] { "AvGameNotify.RoomUserChangeStatusS2CReq" }, new MessageMicro[] { localRoomUserChangeStatusS2CReq });
    ObserverCenter.a().b(GameRoomObserver.class, 23, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramNotifyMsg, Integer.valueOf(i), localRoomInfo });
  }
  
  /* Error */
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4: astore 11
    //   6: aload_2
    //   7: ifnull +20 -> 27
    //   10: aload_2
    //   11: invokevirtual 468	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   14: ifeq +13 -> 27
    //   17: aload_3
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore 6
    //   24: goto +6 -> 30
    //   27: iconst_0
    //   28: istore 6
    //   30: aload_1
    //   31: ldc_w 596
    //   34: aload 11
    //   36: invokevirtual 600	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 73	java/lang/Integer
    //   42: invokevirtual 603	java/lang/Integer:intValue	()I
    //   45: istore 9
    //   47: iload 9
    //   49: iconst_2
    //   50: if_icmpne +9 -> 59
    //   53: iconst_1
    //   54: istore 10
    //   56: goto +6 -> 62
    //   59: iconst_0
    //   60: istore 10
    //   62: iload 6
    //   64: ifeq +379 -> 443
    //   67: new 605	trpc/qq_vgame/pk_manager/AvGamePkManager$PKOperationRsp
    //   70: dup
    //   71: invokespecial 606	trpc/qq_vgame/pk_manager/AvGamePkManager$PKOperationRsp:<init>	()V
    //   74: astore 11
    //   76: iconst_m1
    //   77: istore 4
    //   79: iload 4
    //   81: istore 5
    //   83: aload 11
    //   85: aload_3
    //   86: checkcast 473	[B
    //   89: checkcast 473	[B
    //   92: invokevirtual 607	trpc/qq_vgame/pk_manager/AvGamePkManager$PKOperationRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   95: pop
    //   96: iload 4
    //   98: istore 5
    //   100: aload 11
    //   102: getfield 608	trpc/qq_vgame/pk_manager/AvGamePkManager$PKOperationRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   105: invokevirtual 484	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   108: checkcast 483	trpc/qq_vgame/common/AvGameCommon$Result
    //   111: getfield 487	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   117: istore 4
    //   119: iload 4
    //   121: istore 5
    //   123: aload 11
    //   125: getfield 608	trpc/qq_vgame/pk_manager/AvGamePkManager$PKOperationRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   128: invokevirtual 484	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   131: checkcast 483	trpc/qq_vgame/common/AvGameCommon$Result
    //   134: getfield 490	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   137: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   140: invokevirtual 352	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   143: astore_1
    //   144: aload 11
    //   146: getfield 611	trpc/qq_vgame/pk_manager/AvGamePkManager$PKOperationRsp:pool_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   149: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   152: istore 5
    //   154: aload 11
    //   156: getfield 614	trpc/qq_vgame/pk_manager/AvGamePkManager$PKOperationRsp:start_user_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   159: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   162: istore 7
    //   164: aload 11
    //   166: invokestatic 620	com/tencent/avgame/gamelogic/data/PkCJOperationData:convertFromPB	(Ltrpc/qq_vgame/pk_manager/AvGamePkManager$PKOperationRsp;)Lcom/tencent/avgame/gamelogic/data/PkCJOperationData;
    //   169: astore_2
    //   170: goto +77 -> 247
    //   173: astore_2
    //   174: iload 7
    //   176: istore 6
    //   178: goto +24 -> 202
    //   181: astore_2
    //   182: goto +17 -> 199
    //   185: astore_2
    //   186: goto +10 -> 196
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: iload 5
    //   194: istore 4
    //   196: iconst_0
    //   197: istore 5
    //   199: iconst_0
    //   200: istore 6
    //   202: new 225	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   209: astore_3
    //   210: aload_3
    //   211: ldc_w 622
    //   214: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_3
    //   219: aload_2
    //   220: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: ldc 119
    //   226: iconst_1
    //   227: aload_3
    //   228: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aconst_null
    //   235: astore_2
    //   236: iconst_0
    //   237: istore 8
    //   239: iload 6
    //   241: istore 7
    //   243: iload 8
    //   245: istore 6
    //   247: ldc 119
    //   249: ldc_w 624
    //   252: aconst_null
    //   253: iconst_1
    //   254: anewarray 156	com/tencent/mobileqq/pb/MessageMicro
    //   257: dup
    //   258: iconst_0
    //   259: aload 11
    //   261: aastore
    //   262: invokestatic 161	com/tencent/avgame/gamelogic/GameUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   265: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +51 -> 319
    //   271: ldc 119
    //   273: iconst_2
    //   274: ldc_w 626
    //   277: iconst_5
    //   278: anewarray 136	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: iload 9
    //   285: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: iload 5
    //   293: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: dup
    //   298: iconst_2
    //   299: iload 4
    //   301: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   304: aastore
    //   305: dup
    //   306: iconst_3
    //   307: aload_1
    //   308: aastore
    //   309: dup
    //   310: iconst_4
    //   311: aload_2
    //   312: aastore
    //   313: invokestatic 511	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   316: invokestatic 514	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: iload 6
    //   321: ifeq +65 -> 386
    //   324: iload 4
    //   326: ifne +60 -> 386
    //   329: invokestatic 132	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   332: ldc 134
    //   334: bipush 14
    //   336: iconst_1
    //   337: bipush 6
    //   339: anewarray 136	java/lang/Object
    //   342: dup
    //   343: iconst_0
    //   344: iload 10
    //   346: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   349: aastore
    //   350: dup
    //   351: iconst_1
    //   352: iload 5
    //   354: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: iload 7
    //   362: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: aastore
    //   366: dup
    //   367: iconst_3
    //   368: iload 4
    //   370: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   373: aastore
    //   374: dup
    //   375: iconst_4
    //   376: aload_1
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: aload_2
    //   381: aastore
    //   382: invokevirtual 140	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   385: return
    //   386: invokestatic 132	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   389: ldc 134
    //   391: bipush 14
    //   393: iconst_0
    //   394: bipush 6
    //   396: anewarray 136	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: iload 10
    //   403: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   406: aastore
    //   407: dup
    //   408: iconst_1
    //   409: iload 5
    //   411: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: aastore
    //   415: dup
    //   416: iconst_2
    //   417: iload 7
    //   419: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: aastore
    //   423: dup
    //   424: iconst_3
    //   425: iload 4
    //   427: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: aastore
    //   431: dup
    //   432: iconst_4
    //   433: aload_1
    //   434: aastore
    //   435: dup
    //   436: iconst_5
    //   437: aload_2
    //   438: aastore
    //   439: invokevirtual 140	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   442: return
    //   443: aload_2
    //   444: ifnull +12 -> 456
    //   447: aload_2
    //   448: invokevirtual 629	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   451: istore 4
    //   453: goto +6 -> 459
    //   456: iconst_0
    //   457: istore 4
    //   459: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +35 -> 497
    //   465: ldc 119
    //   467: iconst_2
    //   468: ldc_w 631
    //   471: iconst_2
    //   472: anewarray 136	java/lang/Object
    //   475: dup
    //   476: iconst_0
    //   477: iload 9
    //   479: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: aastore
    //   483: dup
    //   484: iconst_1
    //   485: iload 4
    //   487: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   490: aastore
    //   491: invokestatic 511	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   494: invokestatic 514	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: invokestatic 132	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   500: ldc 134
    //   502: bipush 14
    //   504: iconst_0
    //   505: bipush 6
    //   507: anewarray 136	java/lang/Object
    //   510: dup
    //   511: iconst_0
    //   512: iload 10
    //   514: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   517: aastore
    //   518: dup
    //   519: iconst_1
    //   520: aload 11
    //   522: aastore
    //   523: dup
    //   524: iconst_2
    //   525: aload 11
    //   527: aastore
    //   528: dup
    //   529: iconst_3
    //   530: aload 11
    //   532: aastore
    //   533: dup
    //   534: iconst_4
    //   535: aconst_null
    //   536: aastore
    //   537: dup
    //   538: iconst_5
    //   539: aconst_null
    //   540: aastore
    //   541: invokevirtual 140	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   544: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	GameRoomHandler
    //   0	545	1	paramToServiceMsg	ToServiceMsg
    //   0	545	2	paramFromServiceMsg	FromServiceMsg
    //   0	545	3	paramObject	Object
    //   77	409	4	i	int
    //   81	329	5	j	int
    //   22	298	6	k	int
    //   162	256	7	m	int
    //   237	7	8	n	int
    //   45	433	9	i1	int
    //   54	459	10	bool	boolean
    //   4	527	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   164	170	173	java/lang/Exception
    //   154	164	181	java/lang/Exception
    //   144	154	185	java/lang/Exception
    //   83	96	189	java/lang/Exception
    //   100	119	189	java/lang/Exception
    //   123	144	189	java/lang/Exception
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
    //   0: iconst_0
    //   1: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4: astore_1
    //   5: iconst_0
    //   6: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   9: astore 11
    //   11: aload_2
    //   12: ifnull +20 -> 32
    //   15: aload_2
    //   16: invokevirtual 468	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +13 -> 32
    //   22: aload_3
    //   23: ifnull +9 -> 32
    //   26: iconst_1
    //   27: istore 4
    //   29: goto +6 -> 35
    //   32: iconst_0
    //   33: istore 4
    //   35: iload 4
    //   37: ifeq +504 -> 541
    //   40: new 645	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp
    //   43: dup
    //   44: invokespecial 646	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:<init>	()V
    //   47: astore_1
    //   48: aload_1
    //   49: aload_3
    //   50: checkcast 473	[B
    //   53: checkcast 473	[B
    //   56: invokevirtual 647	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   59: pop
    //   60: aload_1
    //   61: getfield 648	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   64: invokevirtual 484	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: checkcast 483	trpc/qq_vgame/common/AvGameCommon$Result
    //   70: getfield 487	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   76: istore 4
    //   78: aload_1
    //   79: getfield 648	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   82: invokevirtual 484	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   85: checkcast 483	trpc/qq_vgame/common/AvGameCommon$Result
    //   88: getfield 490	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   91: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   94: invokevirtual 352	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   97: astore_3
    //   98: aload_1
    //   99: getfield 651	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   102: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   105: istore 8
    //   107: aload_1
    //   108: getfield 654	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:user_total_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: istore 5
    //   116: aload_1
    //   117: getfield 657	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:user_in_pk	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   120: invokevirtual 420	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   123: astore_2
    //   124: aload_0
    //   125: aload_2
    //   126: invokespecial 535	com/tencent/avgame/gamelogic/handler/GameRoomHandler:b	(Ljava/util/List;)Ljava/util/List;
    //   129: astore_2
    //   130: aload_1
    //   131: getfield 660	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:change_pool_id	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   134: invokevirtual 25	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   137: istore 9
    //   139: aload_1
    //   140: getfield 663	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:real_pool_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   146: istore 6
    //   148: aload_1
    //   149: getfield 666	trpc/qq_vgame/pk_manager/AvGamePkManager$GetPKInfoRsp:fresh_at_midfield	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   152: invokevirtual 25	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   155: istore 10
    //   157: aload_3
    //   158: astore_1
    //   159: iload 4
    //   161: istore 7
    //   163: iload 8
    //   165: istore 4
    //   167: iload 6
    //   169: istore 8
    //   171: goto +165 -> 336
    //   174: astore_1
    //   175: iload 6
    //   177: istore 7
    //   179: goto +7 -> 186
    //   182: astore_1
    //   183: iconst_0
    //   184: istore 7
    //   186: iload 5
    //   188: istore 6
    //   190: iload 7
    //   192: istore 5
    //   194: goto +37 -> 231
    //   197: astore_1
    //   198: iload 5
    //   200: istore 6
    //   202: goto +23 -> 225
    //   205: astore_1
    //   206: goto +4 -> 210
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: iload 5
    //   214: istore 6
    //   216: goto +9 -> 225
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_2
    //   222: iconst_0
    //   223: istore 6
    //   225: iconst_0
    //   226: istore 9
    //   228: iconst_0
    //   229: istore 5
    //   231: iload 4
    //   233: istore 7
    //   235: aload_1
    //   236: astore 11
    //   238: iload 8
    //   240: istore 4
    //   242: aload_3
    //   243: astore_1
    //   244: aload_2
    //   245: astore_3
    //   246: goto +44 -> 290
    //   249: astore_2
    //   250: aload_3
    //   251: astore_1
    //   252: iload 4
    //   254: istore 7
    //   256: goto +17 -> 273
    //   259: astore_2
    //   260: iload 4
    //   262: istore 7
    //   264: goto +7 -> 271
    //   267: astore_2
    //   268: iconst_m1
    //   269: istore 7
    //   271: aconst_null
    //   272: astore_1
    //   273: iconst_0
    //   274: istore 4
    //   276: iconst_0
    //   277: istore 9
    //   279: aconst_null
    //   280: astore_3
    //   281: iconst_0
    //   282: istore 6
    //   284: iconst_0
    //   285: istore 5
    //   287: aload_2
    //   288: astore 11
    //   290: new 225	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   297: astore_2
    //   298: aload_2
    //   299: ldc_w 668
    //   302: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_2
    //   307: aload 11
    //   309: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 119
    //   315: iconst_1
    //   316: aload_2
    //   317: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: iconst_0
    //   324: istore 10
    //   326: iload 5
    //   328: istore 8
    //   330: iload 6
    //   332: istore 5
    //   334: aload_3
    //   335: astore_2
    //   336: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +47 -> 386
    //   342: ldc 119
    //   344: iconst_2
    //   345: ldc_w 670
    //   348: iconst_4
    //   349: anewarray 136	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: iload 4
    //   356: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_1
    //   362: iload 5
    //   364: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: aastore
    //   368: dup
    //   369: iconst_2
    //   370: iload 7
    //   372: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   375: aastore
    //   376: dup
    //   377: iconst_3
    //   378: aload_1
    //   379: aastore
    //   380: invokestatic 511	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   383: invokestatic 514	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: iload 7
    //   388: ifne +78 -> 466
    //   391: invokestatic 132	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   394: ldc 134
    //   396: bipush 17
    //   398: iconst_1
    //   399: bipush 8
    //   401: anewarray 136	java/lang/Object
    //   404: dup
    //   405: iconst_0
    //   406: iload 4
    //   408: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: aastore
    //   412: dup
    //   413: iconst_1
    //   414: iload 5
    //   416: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   419: aastore
    //   420: dup
    //   421: iconst_2
    //   422: aload_2
    //   423: aastore
    //   424: dup
    //   425: iconst_3
    //   426: iload 9
    //   428: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   431: aastore
    //   432: dup
    //   433: iconst_4
    //   434: iload 8
    //   436: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   439: aastore
    //   440: dup
    //   441: iconst_5
    //   442: iload 10
    //   444: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   447: aastore
    //   448: dup
    //   449: bipush 6
    //   451: iload 7
    //   453: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   456: aastore
    //   457: dup
    //   458: bipush 7
    //   460: aload_1
    //   461: aastore
    //   462: invokevirtual 140	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   465: return
    //   466: invokestatic 132	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   469: ldc 134
    //   471: bipush 17
    //   473: iconst_0
    //   474: bipush 8
    //   476: anewarray 136	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: iload 4
    //   483: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: iload 5
    //   491: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   494: aastore
    //   495: dup
    //   496: iconst_2
    //   497: aload_2
    //   498: aastore
    //   499: dup
    //   500: iconst_3
    //   501: iload 9
    //   503: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   506: aastore
    //   507: dup
    //   508: iconst_4
    //   509: iload 8
    //   511: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   514: aastore
    //   515: dup
    //   516: iconst_5
    //   517: iload 10
    //   519: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   522: aastore
    //   523: dup
    //   524: bipush 6
    //   526: iload 7
    //   528: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   531: aastore
    //   532: dup
    //   533: bipush 7
    //   535: aload_1
    //   536: aastore
    //   537: invokevirtual 140	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   540: return
    //   541: aload_2
    //   542: ifnull +12 -> 554
    //   545: aload_2
    //   546: invokevirtual 629	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   549: istore 4
    //   551: goto +6 -> 557
    //   554: iconst_m1
    //   555: istore 4
    //   557: ldc 119
    //   559: iconst_2
    //   560: ldc_w 672
    //   563: iconst_1
    //   564: anewarray 136	java/lang/Object
    //   567: dup
    //   568: iconst_0
    //   569: iload 4
    //   571: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: aastore
    //   575: invokestatic 511	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   578: invokestatic 514	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: invokestatic 132	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   584: ldc 134
    //   586: bipush 17
    //   588: iconst_0
    //   589: bipush 8
    //   591: anewarray 136	java/lang/Object
    //   594: dup
    //   595: iconst_0
    //   596: aload 11
    //   598: aastore
    //   599: dup
    //   600: iconst_1
    //   601: aload 11
    //   603: aastore
    //   604: dup
    //   605: iconst_2
    //   606: aconst_null
    //   607: aastore
    //   608: dup
    //   609: iconst_3
    //   610: aload_1
    //   611: aastore
    //   612: dup
    //   613: iconst_4
    //   614: aload 11
    //   616: aastore
    //   617: dup
    //   618: iconst_5
    //   619: aload_1
    //   620: aastore
    //   621: dup
    //   622: bipush 6
    //   624: iconst_m1
    //   625: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   628: aastore
    //   629: dup
    //   630: bipush 7
    //   632: aconst_null
    //   633: aastore
    //   634: invokevirtual 140	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   637: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	this	GameRoomHandler
    //   0	638	1	paramToServiceMsg	ToServiceMsg
    //   0	638	2	paramFromServiceMsg	FromServiceMsg
    //   0	638	3	paramObject	Object
    //   27	543	4	i	int
    //   114	376	5	j	int
    //   146	185	6	k	int
    //   161	366	7	m	int
    //   105	405	8	n	int
    //   137	365	9	bool1	boolean
    //   155	363	10	bool2	boolean
    //   9	606	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   148	157	174	java/lang/Exception
    //   139	148	182	java/lang/Exception
    //   130	139	197	java/lang/Exception
    //   124	130	205	java/lang/Exception
    //   116	124	209	java/lang/Exception
    //   107	116	219	java/lang/Exception
    //   98	107	249	java/lang/Exception
    //   78	98	259	java/lang/Exception
    //   48	78	267	java/lang/Exception
  }
  
  private void f(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserExitS2CReq localRoomUserExitS2CReq = (AvGameNotify.RoomUserExitS2CReq)paramNotifyMsg.room_user_exit_req.get();
    int i;
    if (localRoomUserExitS2CReq.exit_reason.has()) {
      i = localRoomUserExitS2CReq.exit_reason.get();
    } else {
      i = 0;
    }
    boolean bool = localRoomUserExitS2CReq.exit_uin.has();
    String str3 = "";
    if (bool) {
      paramNotifyMsg = String.valueOf(localRoomUserExitS2CReq.exit_uin.get());
    } else {
      paramNotifyMsg = "";
    }
    String str1;
    if (localRoomUserExitS2CReq.new_owner_uin.has()) {
      str1 = String.valueOf(localRoomUserExitS2CReq.new_owner_uin.get());
    } else {
      str1 = "";
    }
    int j;
    if (localRoomUserExitS2CReq.heartbeat_timeout.has()) {
      j = localRoomUserExitS2CReq.heartbeat_timeout.get();
    } else {
      j = 0;
    }
    int k;
    if (localRoomUserExitS2CReq.sub_reason.has()) {
      k = localRoomUserExitS2CReq.sub_reason.get();
    } else {
      k = 0;
    }
    String str2;
    if (localRoomUserExitS2CReq.onwer_tip.has()) {
      str2 = String.valueOf(localRoomUserExitS2CReq.onwer_tip.get());
    } else {
      str2 = "";
    }
    if (localRoomUserExitS2CReq.exiter_tip.has()) {
      str3 = String.valueOf(localRoomUserExitS2CReq.exiter_tip.get());
    }
    RoomInfo localRoomInfo = GameUtil.a((AvGameCommon.RoomInfo)localRoomUserExitS2CReq.room_info.get());
    GameUtil.a("avgame_logic.GameRoomHandler", "handlerExitRoomPush()", new String[] { "AvGameNotify.RoomUserExitS2CReq" }, new MessageMicro[] { localRoomUserExitS2CReq });
    ObserverCenter.a().b(GameRoomObserver.class, 21, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i), paramNotifyMsg, str1, localRoomInfo, Integer.valueOf(j), Integer.valueOf(k), str2, str3 });
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("is_from_sync");
    int k = paramToServiceMsg.extraData.getInt("snapshot_from");
    long l = paramToServiceMsg.extraData.getLong("room_id");
    String str2 = paramToServiceMsg.extraData.getString("user_uin");
    String str1 = "";
    int i;
    if (bool1)
    {
      Object localObject1 = new AvGameRoomManager.CmdRoomInfoRsp();
      try
      {
        ((AvGameRoomManager.CmdRoomInfoRsp)localObject1).mergeFrom((byte[])paramObject);
        i = ((AvGameCommon.Result)((AvGameRoomManager.CmdRoomInfoRsp)localObject1).res.get()).errcode.get();
        try
        {
          paramToServiceMsg = ((AvGameCommon.Result)((AvGameRoomManager.CmdRoomInfoRsp)localObject1).res.get()).errmsg.get().toStringUtf8();
        }
        catch (Exception paramToServiceMsg) {}
        paramFromServiceMsg = new StringBuilder();
      }
      catch (Exception paramToServiceMsg)
      {
        i = 0;
      }
      paramFromServiceMsg.append("onGetGameRoomInfo:");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.e("avgame_logic.GameRoomHandler", 1, paramFromServiceMsg.toString());
      paramToServiceMsg = "";
      bool1 = false;
      a((AvGameRoomManager.CmdRoomInfoRsp)localObject1);
      boolean bool2;
      if ((bool1) && (i == 0) && (((AvGameRoomManager.CmdRoomInfoRsp)localObject1).room_info.has()) && (((AvGameRoomManager.CmdRoomInfoRsp)localObject1).room_info.get() != null))
      {
        RoomInfo localRoomInfo = GameUtil.a((AvGameCommon.RoomInfo)((AvGameRoomManager.CmdRoomInfoRsp)localObject1).room_info.get());
        Object localObject2 = null;
        Object localObject3;
        int j;
        Object localObject4;
        if (bool3)
        {
          localObject3 = GameUtil.a((AvGameCommon.GameStatusInfo)((AvGameRoomManager.CmdRoomInfoRsp)localObject1).game_status_info.get());
          if ((localObject3 != null) && (((IGame)localObject3).a())) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          bool1 &= bool2;
          if ((IGameEngine.a().f()) && ((localObject3 instanceof Game))) {
            paramFromServiceMsg = ((Game)localObject3).a();
          } else {
            paramFromServiceMsg = GameUtil.a(((AvGameRoomManager.CmdRoomInfoRsp)localObject1).game_ranking_info);
          }
          localObject2 = (AvGameList.CmdGameListRsp)((AvGameRoomManager.CmdRoomInfoRsp)localObject1).game_cfg_info.get();
          j = ((AvGameList.CmdGameListRsp)localObject2).curr_game_index.get();
          localObject1 = ((AvGameList.CmdGameListRsp)localObject2).resource_url.get();
          localObject4 = ((AvGameList.CmdGameListRsp)localObject2).resource_md5.get();
          paramObject = new ArrayList();
          a(((AvGameList.CmdGameListRsp)localObject2).game_list.get(), paramObject);
          QLog.d("avgame_logic.GameRoomHandler", 1, String.format("onGetGameRoomInfo game valid=%b game=%s", new Object[] { Boolean.valueOf(bool2), localObject3 }));
          localObject2 = paramFromServiceMsg;
          paramFromServiceMsg = (FromServiceMsg)localObject3;
          localObject3 = localObject4;
          localObject4 = paramObject;
        }
        else
        {
          localObject1 = null;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          paramObject = paramFromServiceMsg;
          localObject4 = paramObject;
          j = 0;
          localObject3 = paramObject;
        }
        bool2 = bool1;
        if (bool1)
        {
          ObserverCenter.a().b(GameRoomObserver.class, 1, true, new Object[] { Boolean.valueOf(bool3), Long.valueOf(l), str2, localRoomInfo, paramFromServiceMsg, localObject2, localObject4, Integer.valueOf(j), localObject1, localObject3, Integer.valueOf(k) });
          bool2 = bool1;
        }
      }
      else
      {
        bool2 = bool1;
      }
      bool1 = bool2;
    }
    else
    {
      paramToServiceMsg = "";
      i = 0;
    }
    if (!bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onGetGameRoomInfo failed suc=%b errCode=%d errMsg=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), paramToServiceMsg }));
      }
      if (paramToServiceMsg == null) {
        paramToServiceMsg = str1;
      }
      ObserverCenter.a().b(GameRoomObserver.class, 1, false, new Object[] { Boolean.valueOf(bool3), Long.valueOf(l), str2, paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(k) });
    }
    QualityReporter.a(bool1, k);
  }
  
  private void g(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserEnterS2CReq localRoomUserEnterS2CReq = (AvGameNotify.RoomUserEnterS2CReq)paramNotifyMsg.room_user_enter_req.get();
    int i;
    if (localRoomUserEnterS2CReq.type.has()) {
      i = localRoomUserEnterS2CReq.type.get();
    } else {
      i = 0;
    }
    boolean bool = localRoomUserEnterS2CReq.enter_uin.has();
    String str = "";
    if (bool) {
      paramNotifyMsg = String.valueOf(localRoomUserEnterS2CReq.enter_uin.get());
    } else {
      paramNotifyMsg = "";
    }
    if (localRoomUserEnterS2CReq.inviter_uin.has()) {
      str = String.valueOf(localRoomUserEnterS2CReq.inviter_uin.get());
    }
    RoomInfo localRoomInfo = GameUtil.a((AvGameCommon.RoomInfo)localRoomUserEnterS2CReq.room_info.get());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handlerEnterRoomPush ");
    localStringBuilder.append(localRoomInfo.toString());
    QLog.d("avgame_logic.GameRoomHandler", 1, localStringBuilder.toString());
    GameUtil.a("avgame_logic.GameRoomHandler", "handlerEnterRoomPush()", new String[] { "AvGameNotify.RoomUserEnterS2CReq" }, new MessageMicro[] { localRoomUserEnterS2CReq });
    ObserverCenter.a().b(GameRoomObserver.class, 20, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i), paramNotifyMsg, str, localRoomInfo });
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject = new AvGameList.CmdGameListRsp();
      try
      {
        ((AvGameList.CmdGameListRsp)localObject).mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onGetGameRoomList:");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.e("avgame_logic.GameRoomHandler", 1, paramFromServiceMsg.toString());
        i = 0;
      }
      paramFromServiceMsg = null;
      GameUtil.a("avgame_logic.GameRoomHandler", "onGetGameRoomList()", null, new MessageMicro[] { localObject });
      if (((AvGameList.CmdGameListRsp)localObject).game_list.has()) {
        paramToServiceMsg = ((AvGameList.CmdGameListRsp)localObject).game_list.get();
      } else {
        paramToServiceMsg = null;
      }
      if ((i != 0) && (paramToServiceMsg != null))
      {
        if (((AvGameList.CmdGameListRsp)localObject).curr_game_index.has()) {
          i = ((AvGameList.CmdGameListRsp)localObject).curr_game_index.get();
        } else {
          i = 0;
        }
        paramObject = new ArrayList();
        a(paramToServiceMsg, paramObject);
        if (((AvGameList.CmdGameListRsp)localObject).resource_url.has()) {
          paramToServiceMsg = ((AvGameList.CmdGameListRsp)localObject).resource_url.get();
        } else {
          paramToServiceMsg = null;
        }
        if (((AvGameList.CmdGameListRsp)localObject).resource_md5.has()) {
          paramFromServiceMsg = ((AvGameList.CmdGameListRsp)localObject).resource_md5.get();
        }
        ObserverCenter.a().b(GameRoomObserver.class, 2, true, new Object[] { paramObject, Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg, Long.valueOf(l) });
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onGetGameRoomList success gameList = ");
          ((StringBuilder)localObject).append(paramObject);
          ((StringBuilder)localObject).append(" curGameIndex=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" resUrl = ");
          ((StringBuilder)localObject).append(paramToServiceMsg);
          ((StringBuilder)localObject).append(" resMd5 =");
          ((StringBuilder)localObject).append(paramFromServiceMsg);
          QLog.i("avgame_logic.GameRoomHandler", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onGetGameRoomList failed ");
    }
    ObserverCenter.a().b(GameRoomObserver.class, 2, false, new Object[] { Long.valueOf(l) });
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0)
    {
      paramToServiceMsg = new AvGameList.CmdGetQuestionClassRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("onGetQuestionClass:");
        paramObject.append(paramFromServiceMsg);
        QLog.e("avgame_logic.GameRoomHandler", 1, paramObject.toString());
        i = 0;
      }
      GameUtil.a("avgame_logic.GameRoomHandler", "onGetQuestionClass()", null, new MessageMicro[] { paramToServiceMsg });
      j = i;
      paramObject = paramToServiceMsg;
    }
    else
    {
      paramObject = null;
      j = i;
    }
    if ((paramObject != null) && (paramObject.res.has())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j != 0) && (i != 0) && (paramObject.res.errcode.get() == 0))
    {
      boolean bool = paramObject.question_class_title_url.has();
      paramFromServiceMsg = "";
      if (bool) {
        paramToServiceMsg = paramObject.question_class_title_url.get();
      } else {
        paramToServiceMsg = "";
      }
      if (paramObject.question_class_button_url.has()) {
        paramFromServiceMsg = paramObject.question_class_button_url.get();
      }
      ArrayList localArrayList = new ArrayList();
      if (paramObject.question_class_list.has()) {
        paramObject = paramObject.question_class_list.get();
      } else {
        paramObject = null;
      }
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        i = 0;
        while (i < paramObject.size())
        {
          AvGameList.QuestionClassInfo localQuestionClassInfo = (AvGameList.QuestionClassInfo)paramObject.get(i);
          QuestionClassInfo localQuestionClassInfo1 = new QuestionClassInfo();
          localQuestionClassInfo1.a(localQuestionClassInfo);
          localArrayList.add(localQuestionClassInfo1);
          i += 1;
        }
      }
      ObserverCenter.a().b(GameRoomObserver.class, 9, true, new Object[] { Long.valueOf(l), null, localArrayList, paramToServiceMsg, paramFromServiceMsg });
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onGetQuestionClass success! roomId = ");
        paramObject.append(l);
        paramObject.append(" questionClassInfoListSize=");
        paramObject.append(localArrayList.size());
        paramObject.append(" titleImageUrl=");
        paramObject.append(paramToServiceMsg);
        paramObject.append(" buttonImageUrl=");
        paramObject.append(paramFromServiceMsg);
        QLog.i("avgame_logic.GameRoomHandler", 2, paramObject.toString());
      }
    }
    else
    {
      if (i != 0) {
        j = paramObject.res.errcode.get();
      } else {
        j = -1;
      }
      if ((i != 0) && (paramObject.res.errmsg.has())) {
        paramToServiceMsg = paramObject.res.errmsg.get().toStringUtf8();
      } else {
        paramToServiceMsg = "拉取题库类型失败";
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onGetQuestionClass fail! errorCode = ");
      paramFromServiceMsg.append(j);
      paramFromServiceMsg.append("retMsg=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.e("avgame_logic.GameRoomHandler", 1, paramFromServiceMsg.toString());
      ObserverCenter.a().b(GameRoomObserver.class, 9, false, new Object[] { Long.valueOf(l), paramToServiceMsg, null, null, null });
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    long l2 = paramToServiceMsg.extraData.getLong("room_id");
    long l1 = 0L;
    if (i != 0)
    {
      paramFromServiceMsg = new AvGamePlay.SelectGameRsp();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("onSelectGame:");
        paramObject.append(paramToServiceMsg);
        QLog.e("avgame_logic.GameRoomHandler", 1, paramObject.toString());
        i = 0;
      }
      if (i != 0)
      {
        if (paramFromServiceMsg.res.has()) {
          paramToServiceMsg = (AvGameCommon.Result)paramFromServiceMsg.res.get();
        } else {
          paramToServiceMsg = null;
        }
        if (paramFromServiceMsg.seq.has()) {
          l1 = paramFromServiceMsg.seq.get();
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.errcode.get() == 0)) {
          ObserverCenter.a().b(GameRoomObserver.class, 6, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        } else {
          ObserverCenter.a().b(GameRoomObserver.class, 6, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("AvGameCommon.Result -> seq = ");
        paramFromServiceMsg.append(l1);
        GameUtil.a("avgame_logic.GameRoomHandler", "onSelectGame()", new String[] { paramFromServiceMsg.toString() }, new MessageMicro[] { paramToServiceMsg });
        return;
      }
    }
    QLog.e("avgame_logic.GameRoomHandler", 1, "onSelectGame()  failed ");
    ObserverCenter.a().b(GameRoomObserver.class, 6, false, new Object[] { Long.valueOf(0L), Long.valueOf(l2) });
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameShare.CmdGetShareLinkRsp localCmdGetShareLinkRsp = new AvGameShare.CmdGetShareLinkRsp();
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    long l = paramToServiceMsg.extraData.getLong("mark_extra_tag");
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("onGameGetShareLink. isSuccess = ");
    paramToServiceMsg.append(bool1);
    QLog.d("avgame_logic.GameRoomHandler", 1, paramToServiceMsg.toString());
    boolean bool2;
    if (bool1)
    {
      try
      {
        localCmdGetShareLinkRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onGameGetShareLink.  false result：");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.e("avgame_logic.GameRoomHandler", 1, paramFromServiceMsg.toString());
        bool2 = false;
      }
    }
    else
    {
      bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("ERRCODE:");
        paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
        QLog.e("avgame_logic.GameRoomHandler", 1, paramToServiceMsg.toString());
        bool2 = bool1;
      }
    }
    if (bool2)
    {
      if (!localCmdGetShareLinkRsp.share_url.has())
      {
        ObserverCenter.a().a(GameRoomObserver.class, 8, false, new Object[] { "", Long.valueOf(l) });
        QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink. rspBody.res.has nothing");
        return;
      }
      paramToServiceMsg = localCmdGetShareLinkRsp.share_url.get();
      ObserverCenter.a().a(GameRoomObserver.class, 8, true, new Object[] { paramToServiceMsg, Long.valueOf(l) });
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onGameGetShareLink.get shareUrl:");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(" mark: ");
      paramFromServiceMsg.append(l);
      QLog.d("avgame_logic.GameRoomHandler", 1, paramFromServiceMsg.toString());
      return;
    }
    ObserverCenter.a().a(GameRoomObserver.class, 8, false, new Object[] { "", Long.valueOf(l) });
    QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink fail");
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramToServiceMsg.extraData.getInt("leave_game_room_type");
    String str = paramToServiceMsg.extraData.getString("user_uin");
    long l1 = paramToServiceMsg.extraData.getLong("room_id");
    long l2 = paramToServiceMsg.extraData.getLong("scene_id");
    paramFromServiceMsg = "";
    if (i != 0)
    {
      AvGameRoomManager.CmdRoomLeaveRsp localCmdRoomLeaveRsp = new AvGameRoomManager.CmdRoomLeaveRsp();
      try
      {
        localCmdRoomLeaveRsp.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("onLeaveGameRoom():");
        paramObject.append(paramToServiceMsg);
        QLog.e("avgame_logic.GameRoomHandler", 1, paramObject.toString());
        i = 0;
      }
      if (i != 0)
      {
        paramObject = (AvGameCommon.Result)localCmdRoomLeaveRsp.res.get();
        if ((paramObject != null) && (paramObject.errcode.get() == 0))
        {
          paramToServiceMsg = GameUtil.a((AvGameCommon.RoomInfo)localCmdRoomLeaveRsp.room_info.get());
          ObserverCenter.a().a(GameRoomObserver.class, 3, true, new Object[] { Long.valueOf(l1), Integer.valueOf(j), str, paramToServiceMsg });
        }
        else
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramObject != null)
          {
            paramToServiceMsg = paramFromServiceMsg;
            if (paramObject.errmsg.has()) {
              paramToServiceMsg = paramObject.errmsg.get().toStringUtf8();
            }
          }
          ObserverCenter.a().a(GameRoomObserver.class, 3, false, new Object[] { Long.valueOf(l1), Integer.valueOf(j), str, paramToServiceMsg });
        }
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("onLeaveGameRoom() sceneId:=");
        paramToServiceMsg.append(l2);
        GameUtil.a("avgame_logic.GameRoomHandler", paramToServiceMsg.toString(), null, new MessageMicro[] { localCmdRoomLeaveRsp });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onLeaveGameRoom() failed");
    }
    ObserverCenter.a().a(GameRoomObserver.class, 3, false, new Object[] { Long.valueOf(l1), Integer.valueOf(j), str, "" });
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int j = paramToServiceMsg.extraData.getInt("change_status_from");
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    String str = "";
    if (i != 0)
    {
      AvGameRoomManager.CmdRoomChangeUserStatusRsp localCmdRoomChangeUserStatusRsp = new AvGameRoomManager.CmdRoomChangeUserStatusRsp();
      try
      {
        localCmdRoomChangeUserStatusRsp.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onChangeUserStatus():");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.e("avgame_logic.GameRoomHandler", 1, paramFromServiceMsg.toString());
        i = 0;
      }
      if (i != 0)
      {
        if (localCmdRoomChangeUserStatusRsp.res.has()) {
          paramToServiceMsg = (AvGameCommon.Result)localCmdRoomChangeUserStatusRsp.res.get();
        } else {
          paramToServiceMsg = null;
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.errcode.get() == 0) && (localCmdRoomChangeUserStatusRsp.room_info.get() != null))
        {
          paramToServiceMsg = GameUtil.a((AvGameCommon.RoomInfo)localCmdRoomChangeUserStatusRsp.room_info.get());
          ObserverCenter.a().b(GameRoomObserver.class, 4, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
        }
        else
        {
          paramFromServiceMsg = str;
          if (paramToServiceMsg != null)
          {
            paramFromServiceMsg = str;
            if (paramToServiceMsg.errmsg.has()) {
              paramFromServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();
            }
          }
          if (paramToServiceMsg != null) {
            i = paramToServiceMsg.errcode.get();
          } else {
            i = -1;
          }
          ObserverCenter.a().b(GameRoomObserver.class, 4, false, new Object[] { Long.valueOf(l), paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
        }
        GameUtil.a("avgame_logic.GameRoomHandler", "onChangeUserStatus()", null, new MessageMicro[] { localCmdRoomChangeUserStatusRsp });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onChangeUserStatus() failed");
    }
    ObserverCenter.a().b(GameRoomObserver.class, 4, false, new Object[] { Long.valueOf(l), "", Integer.valueOf(109), Integer.valueOf(j) });
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramFromServiceMsg = null;
    boolean bool2 = bool1;
    if (bool1)
    {
      ActivityCenter.GetActivitysRsp localGetActivitysRsp = new ActivityCenter.GetActivitysRsp();
      try
      {
        localGetActivitysRsp.mergeFrom((byte[])paramObject);
      }
      catch (Throwable paramToServiceMsg)
      {
        QLog.i("avgame_logic.GameRoomHandler", 1, "onGetActivityEntry, parse error.", paramToServiceMsg);
        bool1 = false;
      }
      bool2 = bool1;
      if (bool1)
      {
        if (localGetActivitysRsp.res.has()) {
          paramToServiceMsg = (AvGameCommon.Result)localGetActivitysRsp.res.get();
        } else {
          paramToServiceMsg = null;
        }
        if (paramToServiceMsg != null)
        {
          i = paramToServiceMsg.errcode.get();
          paramToServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();
        }
        else
        {
          paramToServiceMsg = null;
          i = 0;
        }
        if (i == 0)
        {
          paramFromServiceMsg = new GameActivityCenterEntry();
          paramFromServiceMsg.jdField_a_of_type_JavaLangString = localGetActivitysRsp.icon_url.get();
          paramFromServiceMsg.b = localGetActivitysRsp.jump_url.get();
          paramFromServiceMsg.jdField_a_of_type_Int = localGetActivitysRsp.red_point.get();
          break label210;
        }
        bool1 = false;
        break label210;
      }
    }
    paramToServiceMsg = null;
    int i = 0;
    boolean bool1 = bool2;
    label210:
    ObserverCenter.a().a(GameRoomObserver.class, 10, bool1, new Object[] { Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetActivityEntry, [");
      paramObject.append(bool1);
      paramObject.append(",");
      paramObject.append(i);
      paramObject.append(",");
      paramObject.append(paramToServiceMsg);
      paramObject.append(",");
      paramObject.append(paramFromServiceMsg);
      paramObject.append("]");
      QLog.i("avgame_logic.GameRoomHandler", 2, paramObject.toString());
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("playGameId");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramFromServiceMsg = null;
    boolean bool2 = bool1;
    if (bool1)
    {
      ActivityCenter.SyncShareGameRsp localSyncShareGameRsp = new ActivityCenter.SyncShareGameRsp();
      try
      {
        localSyncShareGameRsp.mergeFrom((byte[])paramObject);
      }
      catch (Throwable paramToServiceMsg)
      {
        QLog.i("avgame_logic.GameRoomHandler", 1, "onSyncShareGame, parse error.", paramToServiceMsg);
        bool1 = false;
      }
      bool2 = bool1;
      if (bool1)
      {
        if (localSyncShareGameRsp.res.has()) {
          paramToServiceMsg = (AvGameCommon.Result)localSyncShareGameRsp.res.get();
        } else {
          paramToServiceMsg = null;
        }
        if (paramToServiceMsg != null)
        {
          i = paramToServiceMsg.errcode.get();
          paramToServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();
        }
        else
        {
          paramToServiceMsg = null;
          i = 0;
        }
        if (i == 0)
        {
          paramFromServiceMsg = localSyncShareGameRsp.jump_url.get();
          break label187;
        }
        bool1 = false;
        break label187;
      }
    }
    paramToServiceMsg = null;
    int i = 0;
    boolean bool1 = bool2;
    label187:
    ObserverCenter.a().a(GameRoomObserver.class, 11, bool1, new Object[] { Integer.valueOf(i), paramToServiceMsg, str, paramFromServiceMsg });
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onSyncShareGame, [");
      paramObject.append(bool1);
      paramObject.append(",");
      paramObject.append(i);
      paramObject.append(",");
      paramObject.append(paramToServiceMsg);
      paramObject.append(",");
      paramObject.append(str);
      paramObject.append(",");
      paramObject.append(paramFromServiceMsg);
      paramObject.append("]");
      QLog.i("avgame_logic.GameRoomHandler", 2, paramObject.toString());
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    long l2 = paramToServiceMsg.extraData.getLong("room_id");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("user_uin");
    if (i != 0)
    {
      AvGameHeartBeat.CmdUserHeartBeatRsp localCmdUserHeartBeatRsp = new AvGameHeartBeat.CmdUserHeartBeatRsp();
      try
      {
        localCmdUserHeartBeatRsp.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("onStartHeartBeat():");
        paramObject.append(paramToServiceMsg);
        QLog.e("HeartBeatController", 1, paramObject.toString());
        i = 0;
      }
      if (i != 0)
      {
        if (localCmdUserHeartBeatRsp.res.has()) {
          paramToServiceMsg = (AvGameCommon.Result)localCmdUserHeartBeatRsp.res.get();
        } else {
          paramToServiceMsg = null;
        }
        long l1;
        if (localCmdUserHeartBeatRsp.seq.has()) {
          l1 = localCmdUserHeartBeatRsp.seq.get();
        } else {
          l1 = 0L;
        }
        if (localCmdUserHeartBeatRsp.report_interval.has()) {
          i = localCmdUserHeartBeatRsp.report_interval.get();
        } else {
          i = 0;
        }
        int j;
        if (paramToServiceMsg != null) {
          j = paramToServiceMsg.errcode.get();
        } else {
          j = 0;
        }
        ObserverCenter.a().a(GameRoomObserver.class, 5, true, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(l2), paramFromServiceMsg, Integer.valueOf(j) });
        if (QLog.isDevelopLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("onStartHeartBeat() success result = ");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(" seq=");
          paramToServiceMsg.append(l1);
          QLog.i("HeartBeatController", 2, paramToServiceMsg.toString());
        }
        return;
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
    int j;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      j = 1;
    } else {
      j = 0;
    }
    paramFromServiceMsg = null;
    if (j != 0)
    {
      AvGameStrangerMatchV2.AddMatchRoomRsp localAddMatchRoomRsp = new AvGameStrangerMatchV2.AddMatchRoomRsp();
      int k = -1;
      int i = k;
      try
      {
        localAddMatchRoomRsp.mergeFrom((byte[])paramObject);
        i = k;
        k = ((AvGameCommon.Result)localAddMatchRoomRsp.res.get()).errcode.get();
        i = k;
        paramToServiceMsg = ((AvGameCommon.Result)localAddMatchRoomRsp.res.get()).errmsg.get().toStringUtf8();
        i = k;
      }
      catch (Exception paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("onStartStrangerMatchV2:");
        paramObject.append(paramToServiceMsg);
        QLog.e("avgame_logic.GameRoomHandler", 1, paramObject.toString());
        paramToServiceMsg = null;
        j = 0;
      }
      GameUtil.a("avgame_logic.GameRoomHandler", "onStartStrangerMatchV2()", null, new MessageMicro[] { localAddMatchRoomRsp });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatchV2() roomId=%d errCode=%d errMsg=%s type=%d", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg, Integer.valueOf(m) }));
      }
      if ((j != 0) && (i == 0))
      {
        if (localAddMatchRoomRsp.extra_info.has()) {
          paramFromServiceMsg = localAddMatchRoomRsp.extra_info.get().toByteArray();
        }
        ObserverCenter.a().b(GameRoomObserver.class, 18, true, new Object[] { Long.valueOf(l), Integer.valueOf(m), paramFromServiceMsg, Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      ObserverCenter.a().b(GameRoomObserver.class, 18, false, new Object[] { Long.valueOf(l), Integer.valueOf(m), null, Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatchV2() fail roomId=%d", new Object[] { Long.valueOf(l) }));
    }
    ObserverCenter.a().b(GameRoomObserver.class, 18, false, new Object[] { Long.valueOf(l), Integer.valueOf(m), null, Integer.valueOf(0), null });
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int m = paramToServiceMsg.extraData.getInt("game_type");
    int j;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      paramFromServiceMsg = new AvGameStrangerMatch.DelMatchRoomRsp();
      int k = -1;
      int i = k;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = k;
        k = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        i = k;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        i = k;
      }
      catch (Exception paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("onStopStrangerMatch:");
        paramObject.append(paramToServiceMsg);
        QLog.e("avgame_logic.GameRoomHandler", 1, paramObject.toString());
        paramToServiceMsg = null;
        j = 0;
      }
      GameUtil.a("avgame_logic.GameRoomHandler", "onStopStrangerMatch()", null, new MessageMicro[] { paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStopStrangerMatch() roomId=%d errCode=%d errMsg=%s gameType=%d", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg, Integer.valueOf(m) }));
      }
      if ((j != 0) && (i == 0))
      {
        ObserverCenter.a().b(GameRoomObserver.class, 19, true, new Object[] { Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      ObserverCenter.a().b(GameRoomObserver.class, 19, false, new Object[] { Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(i), paramToServiceMsg });
      return;
    }
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
    Object localObject = IGameEngine.a().a();
    if ((paramInt1 == 2) && (localObject != null) && (paramBoolean))
    {
      if (((EngineData)localObject).o() == 6) {
        localPKOperationReq.leave_scene.set(2);
      } else if (((EngineData)localObject).o() == 7) {
        localPKOperationReq.leave_scene.set(1);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendSurvivalOperation leave_scene=");
        ((StringBuilder)localObject).append(localPKOperationReq.leave_scene.get());
        QLog.d("avgame_logic.GameRoomHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    localObject = createToServiceMsg("qqvgame.PKManager-PKOperation");
    ((ToServiceMsg)localObject).putWupBuffer(localPKOperationReq.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).addAttribute("opeType", Integer.valueOf(paramInt1));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPKInfo ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" poolId:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" reqCount:");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" isPkStart:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isInGame=");
      localStringBuilder.append(paramBoolean2);
      QLog.i("avgame_logic.GameRoomHandler", 2, localStringBuilder.toString());
    }
    b(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createGameRoom ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" troopUin: ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" scene:");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append(" trans_mod:");
      ((StringBuilder)localObject1).append(((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady());
      QLog.d("avgame_logic.GameRoomHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.appRuntime.getAccount();
    for (;;)
    {
      try
      {
        localObject1 = new AvGameRoomManager.CmdRoomCreateReq();
        ((AvGameRoomManager.CmdRoomCreateReq)localObject1).creator_uin.set(AvGameEntranceUtil.a((String)localObject2));
        ((AvGameRoomManager.CmdRoomCreateReq)localObject1).game_type.set(paramInt2);
        int i = AvGameRoomListHandler.a(paramInt1);
        ((AvGameRoomManager.CmdRoomCreateReq)localObject1).from.set(i);
        ((AvGameRoomManager.CmdRoomCreateReq)localObject1).scene.set(paramInt3);
        localObject2 = ((AvGameRoomManager.CmdRoomCreateReq)localObject1).trans_mod;
        if (((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady())
        {
          paramInt2 = 0;
          ((PBUInt32Field)localObject2).set(paramInt2);
          if (i == 3)
          {
            ((AvGameRoomManager.CmdRoomCreateReq)localObject1).group_id.set(AvGameEntranceUtil.a(paramString));
            if (TextUtils.isEmpty(paramString))
            {
              paramString = new StringBuilder();
              paramString.append("troopUin EMPTY FP =");
              paramString.append(paramInt1);
              QLog.e("avgame_logic.GameRoomHandler", 1, paramString.toString());
            }
          }
          if ((IGameEngine.a().f()) && (IGameEngine.a().a() != null))
          {
            ((AvGameRoomManager.CmdRoomCreateReq)localObject1).pk_id.set(IGameEngine.a().a().k());
            ((AvGameRoomManager.CmdRoomCreateReq)localObject1).pool_id.set(IGameEngine.a().a().j());
          }
          else if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("createGameRoom pk_id=");
            paramString.append(((AvGameRoomManager.CmdRoomCreateReq)localObject1).pk_id.get());
            paramString.append(" pool_id=");
            paramString.append(((AvGameRoomManager.CmdRoomCreateReq)localObject1).pool_id.get());
            QLog.d("avgame_logic.GameRoomHandler", 2, paramString.toString());
          }
          paramString = createToServiceMsg("qqvgame.RoomManager-RoomCreate");
          paramString.putWupBuffer(((AvGameRoomManager.CmdRoomCreateReq)localObject1).toByteArray());
          sendPbReq(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        QLog.d("avgame_logic.GameRoomHandler", 1, "reportUser exception:", paramString);
        return;
      }
      paramInt2 = 1;
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("joinGameRoom ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" roomId: ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" scene:");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(" trans_mod:");
      ((StringBuilder)localObject1).append(((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady());
      QLog.d("avgame_logic.GameRoomHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.appRuntime.getAccount();
    for (;;)
    {
      try
      {
        localObject1 = new AvGameRoomManager.CmdRoomEnterReq();
        int i = AvGameRoomListHandler.b(paramInt1);
        ((AvGameRoomManager.CmdRoomEnterReq)localObject1).from.set(i);
        ((AvGameRoomManager.CmdRoomEnterReq)localObject1).uin.set(AvGameEntranceUtil.a((String)localObject2));
        ((AvGameRoomManager.CmdRoomEnterReq)localObject1).scene.set(paramInt2);
        localObject2 = ((AvGameRoomManager.CmdRoomEnterReq)localObject1).trans_mod;
        if (((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady())
        {
          paramInt2 = 0;
          ((PBUInt32Field)localObject2).set(paramInt2);
          if ((paramInt1 == 1) || (paramInt1 == 2))
          {
            ((AvGameRoomManager.CmdRoomEnterReq)localObject1).invitor_uin.set(AvGameEntranceUtil.a(paramString2));
            if (TextUtils.isEmpty(paramString2))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("INVITER UIN EMPTY FP=");
              ((StringBuilder)localObject2).append(paramInt1);
              QLog.e("avgame_logic.GameRoomHandler", 1, ((StringBuilder)localObject2).toString());
            }
          }
          ((AvGameRoomManager.CmdRoomEnterReq)localObject1).roomid.set(AvGameEntranceUtil.a(paramString1));
          ((AvGameRoomManager.CmdRoomEnterReq)localObject1).invitor_uin.set(AvGameEntranceUtil.a(paramString2));
          if ((IGameEngine.a().f()) && (IGameEngine.a().a() != null)) {
            ((AvGameRoomManager.CmdRoomEnterReq)localObject1).pk_opponent_uin.set(IGameEngine.a().a().jdField_b_of_type_Long);
          }
          ((AvGameRoomManager.CmdRoomEnterReq)localObject1).init_status.set(0);
          paramString1 = createToServiceMsg("qqvgame.RoomManager-RoomEnter");
          paramString1.putWupBuffer(((AvGameRoomManager.CmdRoomEnterReq)localObject1).toByteArray());
          sendPbReq(paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("avgame_logic.GameRoomHandler", 1, "reportUser exception:", paramString1);
        return;
      }
      paramInt2 = 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitSurvivalPool  ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" isNeedReqGameResult=");
    localStringBuilder.append(paramBoolean);
    QLog.i("avgame_logic.GameRoomHandler", 1, localStringBuilder.toString());
    if (!IGameEngine.k()) {
      a(2, IGameEngine.a().a().k(), paramInt, 0, 0, paramBoolean);
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = new AvGameList.CmdGameListReq();
    ((AvGameList.CmdGameListReq)localObject).roomid.set(paramLong);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameList-GetGameList");
    localToServiceMsg.putWupBuffer(((AvGameList.CmdGameListReq)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGameRoomList() roomId = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("avgame_logic.GameRoomHandler", 2, ((StringBuilder)localObject).toString());
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
      else
      {
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
      paramString1 = createToServiceMsg("qqvgame.Share-GetShareLink");
      paramString1.putWupBuffer(localCmdGetShareLinkReq.toByteArray());
      paramString1.extraData.putLong("mark_extra_tag", paramLong3);
      sendPbReq(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getShareLink exception: ");
      paramString2.append(paramString1.getMessage());
      QLog.e("avgame_logic.GameRoomHandler", 1, paramString2.toString());
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    Object localObject = new AvGameHeartBeat.CmdUserHeartBeatReq();
    ((AvGameHeartBeat.CmdUserHeartBeatReq)localObject).roomid.set(paramLong);
    ((AvGameHeartBeat.CmdUserHeartBeatReq)localObject).uin.set(Long.valueOf(paramString).longValue());
    ((AvGameHeartBeat.CmdUserHeartBeatReq)localObject).room_state.set(paramInt);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.UserHeartBeat-UserHeartBeat");
    localToServiceMsg.putWupBuffer(((AvGameHeartBeat.CmdUserHeartBeatReq)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    localToServiceMsg.extraData.putString("user_uin", paramString);
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startHeartBeat() roomId = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" userUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("HeartBeatController", 2, ((StringBuilder)localObject).toString());
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("getQuestionClass() roomId = ");
      paramArrayList.append(paramLong);
      QLog.i("avgame_logic.GameRoomHandler", 2, paramArrayList.toString());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    AvGameRoomManager.CmdRoomCreateRsp localCmdRoomCreateRsp = new AvGameRoomManager.CmdRoomCreateRsp();
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameRoomHandler", 2, "handleCreateGameRoom. ");
    }
    int j;
    if (i != 0)
    {
      try
      {
        localCmdRoomCreateRsp.mergeFrom((byte[])paramObject);
        j = i;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleCreateGameRoom.  InvalidProtocolBufferMicroException result：");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.e("avgame_logic.GameRoomHandler", 1, paramFromServiceMsg.toString());
        j = 0;
      }
    }
    else
    {
      j = i;
      if (paramFromServiceMsg != null)
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("ERRCODE:");
        paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
        QLog.e("avgame_logic.GameRoomHandler", 1, paramToServiceMsg.toString());
        j = i;
      }
    }
    Object localObject = "";
    if (j != 0)
    {
      if (!localCmdRoomCreateRsp.res.has())
      {
        ObserverCenter.a().b(GameRoomObserver.class, 15, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
        QLog.d("avgame_logic.GameRoomHandler", 2, "handleCreateGameRoom.  rspBody.res.has nothing");
        return;
      }
      j = localCmdRoomCreateRsp.res.errcode.get();
      long l1;
      if (localCmdRoomCreateRsp.room_info.has())
      {
        l1 = localCmdRoomCreateRsp.room_info.roomid.get();
        paramObject = new RoomInfo();
        paramObject.parseFrom(localCmdRoomCreateRsp.room_info);
        if (paramObject.players.size() > 0) {
          paramToServiceMsg = ((Player)paramObject.players.get(0)).uin;
        } else {
          paramToServiceMsg = "";
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("roominfo :  ");
        paramFromServiceMsg.append(paramObject.toString());
        paramFromServiceMsg.append(" players:");
        paramFromServiceMsg.append(paramObject.players.size());
        paramFromServiceMsg.append(" playerUin");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.d("avgame_logic.GameRoomHandler", 2, paramFromServiceMsg.toString());
      }
      else
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleCreateGameRoom room_info empty");
        l1 = -1L;
        paramObject = null;
      }
      if (localCmdRoomCreateRsp.auth_info.has())
      {
        if (localCmdRoomCreateRsp.auth_info.has()) {
          paramToServiceMsg = localCmdRoomCreateRsp.auth_info.get().toByteArray();
        } else {
          paramToServiceMsg = null;
        }
        paramFromServiceMsg = paramToServiceMsg;
        if (paramToServiceMsg != null)
        {
          i = paramToServiceMsg.length;
          break label484;
        }
      }
      else
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleCreateGameRoom auth_info empty");
        paramFromServiceMsg = null;
      }
      i = 0;
      paramToServiceMsg = paramFromServiceMsg;
      label484:
      long l2;
      if (localCmdRoomCreateRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomCreateRsp.black_ban_expire_time.get();
      } else {
        l2 = 0L;
      }
      paramFromServiceMsg = (FromServiceMsg)localObject;
      if (localCmdRoomCreateRsp.res.errmsg.has()) {
        paramFromServiceMsg = localCmdRoomCreateRsp.res.errmsg.get().toStringUtf8();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" errMsg : ");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(" roomId:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("sig length");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" banExpireTime:");
      ((StringBuilder)localObject).append(l2);
      QLog.d("avgame_logic.GameRoomHandler", 2, new Object[] { "handleCreateGameRoom. ret = ", ((StringBuilder)localObject).toString() });
      ObserverCenter.a().b(GameRoomObserver.class, 15, true, new Object[] { Integer.valueOf(j), paramFromServiceMsg, paramObject, paramToServiceMsg, Long.valueOf(l2) });
      return;
    }
    ObserverCenter.a().b(GameRoomObserver.class, 15, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
    QLog.d("avgame_logic.GameRoomHandler", 2, "handleCreateGameRoom. failed not suc");
  }
  
  public void a(String paramString)
  {
    Object localObject = new ActivityCenter.SyncShareGameReq();
    ((ActivityCenter.SyncShareGameReq)localObject).play_game_id.set(paramString);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.ActivityCenter-SyncShareGame");
    localToServiceMsg.putWupBuffer(((ActivityCenter.SyncShareGameReq)localObject).toByteArray());
    localToServiceMsg.extraData.putString("playGameId", paramString);
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("syncShareGame, playGameId[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("avgame_logic.GameRoomHandler", 4, ((StringBuilder)localObject).toString());
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
    int i;
    try
    {
      i = paramNotifyMsg.type.get();
      l1 = paramNotifyMsg.seq.get();
      l2 = paramNotifyMsg.roomid.get();
      str = paramNotifyMsg.play_game_id.get();
      bool = false;
      QLog.d("avgame_logic.GameRoomHandler", 1, String.format("handleOnlinePush type=%d [%s] seq=%d roomId=%d gameId=%s", new Object[] { Integer.valueOf(i), GameUtil.a(i), Long.valueOf(l1), Long.valueOf(l2), str }));
      localObject = "";
      if (!IGameEngine.k()) {
        localObject = IGameEngine.a().a().b();
      }
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals(str))) {
        break label308;
      }
      AVGameExceptionReporter.a().a(str, i);
    }
    catch (Exception paramNotifyMsg)
    {
      long l1;
      long l2;
      String str;
      boolean bool;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleOnlinePush()  e = ");
      ((StringBuilder)localObject).append(paramNotifyMsg);
      QLog.d("avgame_logic.GameRoomHandler", 1, ((StringBuilder)localObject).toString());
      paramNotifyMsg.printStackTrace();
      return;
    }
    b(paramNotifyMsg);
    c(paramNotifyMsg);
    return;
    b(paramNotifyMsg);
    a(paramNotifyMsg, l1, l2);
    return;
    b(paramNotifyMsg);
    b(paramNotifyMsg, l1, l2);
    return;
    b(paramNotifyMsg);
    if (i == 501) {
      bool = true;
    }
    a(bool, paramNotifyMsg, l1);
    return;
    label308:
    do
    {
      a(paramNotifyMsg, l1, l2, str);
      return;
      do
      {
        c(paramNotifyMsg, l1, l2);
        return;
        do
        {
          d(paramNotifyMsg, l1, l2);
          return;
          do
          {
            e(paramNotifyMsg, l1, l2);
            return;
            do
            {
              f(paramNotifyMsg, l1, l2);
              return;
              do
              {
                g(paramNotifyMsg, l1, l2);
                return;
              } while (i == 1);
            } while (i == 2);
          } while (i == 3);
        } while (i == 4);
      } while (i == 101);
    } while (i == 403);
    switch (i)
    {
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterSurvivalPool first:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" pkId:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" poolId:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" round:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" localVoice:");
    localStringBuilder.append(paramInt4);
    QLog.i("avgame_logic.GameRoomHandler", 1, localStringBuilder.toString());
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 3;
    }
    if (paramInt3 < 0) {
      paramInt3 = 0;
    }
    a(i, paramInt1, paramInt2, paramInt3, paramInt4);
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
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleJoinGameRoom. isSuccess = ");
      paramToServiceMsg.append(bool1);
      QLog.d("avgame_logic.GameRoomHandler", 2, paramToServiceMsg.toString());
    }
    boolean bool2;
    if (bool1)
    {
      try
      {
        localCmdRoomEnterRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleJoinGameRoom.  false result：");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.e("avgame_logic.GameRoomHandler", 1, paramFromServiceMsg.toString());
        bool2 = false;
      }
    }
    else
    {
      bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("ERRCODE:");
        paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
        QLog.e("avgame_logic.GameRoomHandler", 1, paramToServiceMsg.toString());
        bool2 = bool1;
      }
    }
    Object localObject = "";
    paramFromServiceMsg = null;
    paramToServiceMsg = null;
    if (bool2)
    {
      if (!localCmdRoomEnterRsp.res.has())
      {
        ObserverCenter.a().b(GameRoomObserver.class, 16, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
        QLog.d("avgame_logic.GameRoomHandler", 2, "handleJoinGameRoom.  rspBody.res.has nothing");
        return;
      }
      int j = localCmdRoomEnterRsp.res.errcode.get();
      long l1 = -1L;
      if (localCmdRoomEnterRsp.room_info.has())
      {
        l1 = localCmdRoomEnterRsp.room_info.roomid.get();
        paramObject = new RoomInfo();
        paramObject.parseFrom(localCmdRoomEnterRsp.room_info);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("roominfo :  ");
        localStringBuilder.append(paramObject.toString());
        localStringBuilder.append(" players:");
        localStringBuilder.append(paramObject.players.size());
        QLog.d("avgame_logic.GameRoomHandler", 2, localStringBuilder.toString());
      }
      else
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleJoinGameRoom room_info empty");
        paramObject = null;
      }
      if (localCmdRoomEnterRsp.auth_info.has())
      {
        if (localCmdRoomEnterRsp.auth_info.has()) {
          paramToServiceMsg = localCmdRoomEnterRsp.auth_info.get().toByteArray();
        }
        paramFromServiceMsg = paramToServiceMsg;
        if (paramToServiceMsg != null)
        {
          i = paramToServiceMsg.length;
          break label461;
        }
      }
      else
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleJoinGameRoom auth_info empty");
      }
      int i = 0;
      paramToServiceMsg = paramFromServiceMsg;
      label461:
      long l2;
      if (localCmdRoomEnterRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomEnterRsp.black_ban_expire_time.get();
      } else {
        l2 = 0L;
      }
      paramFromServiceMsg = (FromServiceMsg)localObject;
      if (localCmdRoomEnterRsp.res.errmsg.has()) {
        paramFromServiceMsg = localCmdRoomEnterRsp.res.errmsg.get().toStringUtf8();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" errMsg : ");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(" roomId:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("sig length");
      ((StringBuilder)localObject).append(i);
      QLog.d("avgame_logic.GameRoomHandler", 2, new Object[] { "handleJoinGameRoom. ret = ", ((StringBuilder)localObject).toString() });
      ObserverCenter.a().b(GameRoomObserver.class, 16, true, new Object[] { Integer.valueOf(j), paramFromServiceMsg, paramObject, paramToServiceMsg, Long.valueOf(l2) });
      return;
    }
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GameRoomObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("qqvgame.GameList-GetGameList".equals(str))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
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
    if ("qqvgame.StrangerMatchV2-DelMatchRoom".equals(str)) {
      r(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.handler.GameRoomHandler
 * JD-Core Version:    0.7.0.1
 */