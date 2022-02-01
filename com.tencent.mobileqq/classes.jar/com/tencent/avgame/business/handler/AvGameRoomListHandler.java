package com.tencent.avgame.business.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyConstants.BannerInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyConstants.RandomMatchInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote;
import com.tencent.avgame.localvoicerecog.api.IAVGameVoiceRecog;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
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
import java.util.List;
import java.util.Set;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;
import trpc.qq_vgame.pk_reserve.AvGameLobbyPKReserve.ReserveReq;
import trpc.qq_vgame.pk_reserve.AvGameLobbyPKReserve.ReserveRsp;
import trpc.qq_vgame.resultshare.AvGameResultShare.FileUploadReq;
import trpc.qq_vgame.resultshare.AvGameResultShare.FileUploadRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomBatchForGroupReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomBatchForGroupRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomDestroyReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomDestroyRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveRsp;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkReq;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkRsp;
import trpc.qq_vgame.share.AvGameShare.CmdInviteCheckReq;
import trpc.qq_vgame.share.AvGameShare.CmdInviteCheckRsp;
import trpc.qq_vgame.stranger_match.AvGameLobbyInfo.BannerInfo;
import trpc.qq_vgame.stranger_match.AvGameLobbyInfo.CmdGetGameLobbyInfoReq;
import trpc.qq_vgame.stranger_match.AvGameLobbyInfo.CmdGetGameLobbyInfoRsp;
import trpc.qq_vgame.stranger_match.AvGameLobbyInfo.PKCardInfo;
import trpc.qq_vgame.stranger_match.AvGameLobbyInfo.PlayerInfo;
import trpc.qq_vgame.stranger_match.AvGameLobbyInfo.RandomMatchInfo;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.AddMatchUserReq;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.AddMatchUserRsp;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.DelMatchUserReq;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.DelMatchUserRsp;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.AddMatchUserReq;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.AddMatchUserRsp;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.DelMatchUserReq;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.DelMatchUserRsp;

public class AvGameRoomListHandler
  extends BusinessHandler
{
  public static final String a = "com.tencent.avgame.business.handler.AvGameRoomListHandler";
  private BaseQQAppInterface a;
  
  public AvGameRoomListHandler(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
    this.a = paramBaseQQAppInterface;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 2) {
      return 2;
    }
    int i = 3;
    if (paramInt != 3)
    {
      int j = 6;
      if (paramInt == 6) {
        return 3;
      }
      int k = 4;
      i = k;
      if (paramInt != 4)
      {
        i = k;
        if (paramInt != 500)
        {
          i = k;
          if (paramInt != 501)
          {
            if (paramInt == 502) {
              return 4;
            }
            if (paramInt == 5) {
              return 5;
            }
            if (paramInt == 1) {
              return 1;
            }
            i = j;
            if (paramInt != 8)
            {
              if (paramInt == 12) {
                return 6;
              }
              i = 9;
              if (paramInt == 9) {
                return 7;
              }
              if (paramInt == 10) {
                return 8;
              }
              if (paramInt != 11)
              {
                if (paramInt == 13) {
                  return 9;
                }
                if ((paramInt >= 500) && (paramInt <= 600)) {
                  return 4;
                }
                return 1;
              }
            }
            return i;
          }
        }
      }
    }
    return i;
  }
  
  private AVGameLobbySurvivalContentInfo a(AvGameLobbyInfo.PKCardInfo paramPKCardInfo)
  {
    AVGameLobbySurvivalContentInfo localAVGameLobbySurvivalContentInfo = new AVGameLobbySurvivalContentInfo(4);
    boolean bool = paramPKCardInfo.pk_id.has();
    int j = 0;
    int i;
    if (bool) {
      i = paramPKCardInfo.pk_id.get();
    } else {
      i = 0;
    }
    localAVGameLobbySurvivalContentInfo.a(i);
    bool = paramPKCardInfo.title_url.has();
    String str = "";
    if (bool) {
      localObject = paramPKCardInfo.title_url.get();
    } else {
      localObject = "";
    }
    localAVGameLobbySurvivalContentInfo.a((String)localObject);
    if (paramPKCardInfo.backgroud_url.has()) {
      localObject = paramPKCardInfo.backgroud_url.get();
    } else {
      localObject = "";
    }
    localAVGameLobbySurvivalContentInfo.b((String)localObject);
    bool = paramPKCardInfo.start_time.has();
    long l2 = 0L;
    if (bool) {
      l1 = paramPKCardInfo.start_time.get();
    } else {
      l1 = 0L;
    }
    localAVGameLobbySurvivalContentInfo.a(l1);
    long l1 = l2;
    if (paramPKCardInfo.end_time.has()) {
      l1 = paramPKCardInfo.end_time.get();
    }
    localAVGameLobbySurvivalContentInfo.b(l1);
    if (paramPKCardInfo.is_reserve.has()) {
      bool = paramPKCardInfo.is_reserve.get();
    } else {
      bool = false;
    }
    localAVGameLobbySurvivalContentInfo.a(bool);
    if (paramPKCardInfo.reserve_user_num.has()) {
      i = paramPKCardInfo.reserve_user_num.get();
    } else {
      i = 0;
    }
    localAVGameLobbySurvivalContentInfo.b(i);
    if (paramPKCardInfo.play_user_num.has()) {
      i = paramPKCardInfo.play_user_num.get();
    } else {
      i = 0;
    }
    localAVGameLobbySurvivalContentInfo.c(i);
    Object localObject = str;
    if (paramPKCardInfo.wording.has()) {
      localObject = paramPKCardInfo.wording.get();
    }
    localAVGameLobbySurvivalContentInfo.c((String)localObject);
    if (paramPKCardInfo.color_start.has()) {
      i = paramPKCardInfo.color_start.get();
    } else {
      i = 0;
    }
    localAVGameLobbySurvivalContentInfo.d(i);
    if (paramPKCardInfo.color_end.has()) {
      i = paramPKCardInfo.color_end.get();
    } else {
      i = 0;
    }
    localAVGameLobbySurvivalContentInfo.e(i);
    if (paramPKCardInfo.time_wording.has()) {
      localObject = paramPKCardInfo.time_wording.get();
    } else {
      localObject = null;
    }
    localAVGameLobbySurvivalContentInfo.f((String)localObject);
    localAVGameLobbySurvivalContentInfo.g(paramPKCardInfo.background_color_url.get());
    localAVGameLobbySurvivalContentInfo.c(paramPKCardInfo.is_qqcj_activity.get());
    if (paramPKCardInfo.player_list.has())
    {
      i = j;
      while (i < paramPKCardInfo.player_list.get().size())
      {
        localObject = (AvGameLobbyInfo.PlayerInfo)paramPKCardInfo.player_list.get().get(i);
        if ((((AvGameLobbyInfo.PlayerInfo)localObject).has()) && (((AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.PlayerInfo)localObject).get()).uid.has())) {
          localAVGameLobbySurvivalContentInfo.a().add(Long.valueOf(((AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.PlayerInfo)localObject).get()).uid.get()));
        }
        i += 1;
      }
    }
    return localAVGameLobbySurvivalContentInfo;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 2;
    }
    if (paramInt != 3)
    {
      int i = 5;
      if (paramInt == 5) {
        return 3;
      }
      if (paramInt == 4) {
        return 4;
      }
      if (paramInt != 6)
      {
        if (paramInt == 9) {
          return 5;
        }
        i = 7;
        if (paramInt == 7) {
          return 6;
        }
        if (paramInt != 8)
        {
          if (paramInt == 1000) {
            return 7;
          }
          return 4;
        }
      }
      return i;
    }
    return 3;
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramFromServiceMsg = new AvGameRoomManager.CmdRoomLeaveRsp();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("onLeaveGameRoom:");
        paramObject.append(paramToServiceMsg);
        QLog.e("AvGameRoomListHandler", 1, paramObject.toString());
        i = 0;
      }
      if (i != 0)
      {
        if (paramFromServiceMsg.res.has()) {
          paramToServiceMsg = (AvGameCommon.Result)paramFromServiceMsg.res.get();
        } else {
          paramToServiceMsg = null;
        }
        if (paramFromServiceMsg.room_info.has()) {
          paramFromServiceMsg = (AvGameCommon.RoomInfo)paramFromServiceMsg.room_info.get();
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.errcode.has()) && (paramToServiceMsg.errmsg.has()))
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onLeaveGameRoom success errorCode= ");
          paramFromServiceMsg.append(paramToServiceMsg.errcode.get());
          paramFromServiceMsg.append(" errorMsg =");
          paramFromServiceMsg.append(paramToServiceMsg.errmsg.get());
          QLog.i("AvGameRoomListHandler", 4, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    QLog.i("AvGameRoomListHandler", 4, "onLeaveGameRoom failed");
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    int k = paramToServiceMsg.extraData.getInt("_result_file_type");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("_result_game_id");
    String str = paramToServiceMsg.extraData.getString("_result_url");
    IAvGameManager localIAvGameManager = (IAvGameManager)this.a.getRuntimeService(IAvGameManager.class);
    if (i == 0)
    {
      localIAvGameManager.getGameResultShareMgr().a(paramFromServiceMsg, k);
      return;
    }
    paramToServiceMsg = new AvGameResultShare.FileUploadRsp();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      i = j;
      if (paramToServiceMsg.err_code.has()) {
        i = paramToServiceMsg.err_code.get();
      }
      if (paramToServiceMsg.err_msg.has()) {
        paramToServiceMsg = paramToServiceMsg.err_msg.get();
      } else {
        paramToServiceMsg = "";
      }
      if (i != 0)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGameResultShare retCode:");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append(" errMsg:");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.e("AvGameRoomListHandler", 1, paramFromServiceMsg.toString());
        return;
      }
      localIAvGameManager.getGameResultShareMgr().a(paramFromServiceMsg, k, str);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramObject = new StringBuilder();
      paramObject.append("handleGameResultShare:");
      paramObject.append(paramToServiceMsg);
      QLog.e("AvGameRoomListHandler", 1, paramObject.toString());
      localIAvGameManager.getGameResultShareMgr().a(paramFromServiceMsg, k);
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createGameRoom ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" troopUin: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("AvGameRoomListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.a.getCurrentAccountUin();
    for (;;)
    {
      try
      {
        localObject1 = new AvGameRoomManager.CmdRoomCreateReq();
        ((AvGameRoomManager.CmdRoomCreateReq)localObject1).creator_uin.set(AvGameEntranceUtil.a((String)localObject2));
        ((AvGameRoomManager.CmdRoomCreateReq)localObject1).game_type.set(paramInt2);
        localObject2 = ((AvGameRoomManager.CmdRoomCreateReq)localObject1).trans_mod;
        if (((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady())
        {
          paramInt2 = 0;
          ((PBUInt32Field)localObject2).set(paramInt2);
          paramInt2 = a(paramInt1);
          ((AvGameRoomManager.CmdRoomCreateReq)localObject1).from.set(paramInt2);
          if (paramInt2 == 3)
          {
            ((AvGameRoomManager.CmdRoomCreateReq)localObject1).group_id.set(AvGameEntranceUtil.a(paramString));
            if (TextUtils.isEmpty(paramString))
            {
              paramString = new StringBuilder();
              paramString.append("troopUin EMPTY FP =");
              paramString.append(paramInt1);
              QLog.e("AvGameRoomListHandler", 1, paramString.toString());
            }
          }
          if ((IGameEngine.a().f()) && (IGameEngine.a().a() != null))
          {
            ((AvGameRoomManager.CmdRoomCreateReq)localObject1).pk_id.set(IGameEngine.a().a().k());
            ((AvGameRoomManager.CmdRoomCreateReq)localObject1).pool_id.set(IGameEngine.a().a().j());
          }
          paramString = createToServiceMsg("qqvgame.RoomManager-RoomCreate");
          paramString.putWupBuffer(((AvGameRoomManager.CmdRoomCreateReq)localObject1).toByteArray());
          paramString.extraData.putLong("mark_extra_tag", paramLong);
          sendPbReq(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        QLog.d("AvGameRoomListHandler", 1, "reportUser exception:", paramString);
        return;
      }
      paramInt2 = 1;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    long l = this.a.getLongAccountUin();
    AvGameResultShare.FileUploadReq localFileUploadReq = new AvGameResultShare.FileUploadReq();
    localFileUploadReq.file_type.set(paramInt);
    localFileUploadReq.file_url.set(paramString2);
    localFileUploadReq.play_game_id.set(paramString1);
    localFileUploadReq.uin.set(l);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.ResultShare-FileUpload");
    localToServiceMsg.extraData.putString("_result_game_id", paramString1);
    localToServiceMsg.extraData.putInt("_result_file_type", paramInt);
    localToServiceMsg.extraData.putString("_result_url", paramString2);
    localToServiceMsg.putWupBuffer(localFileUploadReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("updateShareUrl request = ");
      paramString1.append(localToServiceMsg);
      QLog.i("AvGameRoomListHandler", 1, paramString1.toString());
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("joinGameRoom ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" roomId: ");
      ((StringBuilder)localObject1).append(paramString1);
      QLog.d("AvGameRoomListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.a.getCurrentAccountUin();
    for (;;)
    {
      try
      {
        localObject1 = new AvGameRoomManager.CmdRoomEnterReq();
        i = b(paramInt);
        ((AvGameRoomManager.CmdRoomEnterReq)localObject1).from.set(i);
        ((AvGameRoomManager.CmdRoomEnterReq)localObject1).uin.set(AvGameEntranceUtil.a((String)localObject2));
        localObject2 = ((AvGameRoomManager.CmdRoomEnterReq)localObject1).trans_mod;
        if (((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady())
        {
          i = 0;
          ((PBUInt32Field)localObject2).set(i);
          if ((paramInt == 1) || (paramInt == 2)) {
            if (TextUtils.isEmpty(paramString2))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("INVITER UIN EMPTY FP=");
              ((StringBuilder)localObject2).append(paramInt);
              QLog.e("AvGameRoomListHandler", 1, ((StringBuilder)localObject2).toString());
            }
            else
            {
              ((AvGameRoomManager.CmdRoomEnterReq)localObject1).invitor_uin.set(AvGameEntranceUtil.a(paramString2));
            }
          }
          ((AvGameRoomManager.CmdRoomEnterReq)localObject1).roomid.set(AvGameEntranceUtil.a(paramString1));
          if (!TextUtils.isEmpty(paramString2)) {
            ((AvGameRoomManager.CmdRoomEnterReq)localObject1).invitor_uin.set(AvGameEntranceUtil.a(paramString2));
          }
          ((AvGameRoomManager.CmdRoomEnterReq)localObject1).init_status.set(1);
          if ((IGameEngine.a().f()) && (IGameEngine.a().a() != null)) {
            ((AvGameRoomManager.CmdRoomEnterReq)localObject1).pk_opponent_uin.set(IGameEngine.a().a().b);
          }
          paramString1 = createToServiceMsg("qqvgame.RoomManager-RoomEnter");
          paramString1.putWupBuffer(((AvGameRoomManager.CmdRoomEnterReq)localObject1).toByteArray());
          paramString1.extraData.putLong("mark_extra_tag", paramLong);
          sendPbReq(paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("AvGameRoomListHandler", 1, "reportUser exception:", paramString1);
        return;
      }
      int i = 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reservePKGame pkId: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isReserve: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("AvGameRoomListHandler", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new AvGameLobbyPKReserve.ReserveReq();
    ((AvGameLobbyPKReserve.ReserveReq)localObject).pk_id.set(paramInt);
    ((AvGameLobbyPKReserve.ReserveReq)localObject).is_reserve.set(paramBoolean);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.PKReserve-Reserve");
    localToServiceMsg.extraData.putInt("pkId", paramInt);
    localToServiceMsg.putWupBuffer(((AvGameLobbyPKReserve.ReserveReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong)
  {
    long l = AvGameEntranceUtil.a(this.a.getCurrentUin());
    Object localObject = new AvGameRoomManager.CmdRoomLeaveReq();
    ((AvGameRoomManager.CmdRoomLeaveReq)localObject).roomid.set(paramLong);
    ((AvGameRoomManager.CmdRoomLeaveReq)localObject).reason.set(1);
    ((AvGameRoomManager.CmdRoomLeaveReq)localObject).operator_uin.set(l);
    ((AvGameRoomManager.CmdRoomLeaveReq)localObject).target_uin.set(l);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.RoomManager-RoomLeave");
    localToServiceMsg.putWupBuffer(((AvGameRoomManager.CmdRoomLeaveReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("leaveGameRoom request = ");
      ((StringBuilder)localObject).append(localToServiceMsg);
      QLog.i("AvGameRoomListHandler", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startStrangerMatch uin: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" type:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" gender:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("AvGameRoomListHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new AvGameStrangerMatch.AddMatchUserReq();
    ((AvGameStrangerMatch.AddMatchUserReq)localObject).uin.set(paramLong);
    ((AvGameStrangerMatch.AddMatchUserReq)localObject).type.set(paramInt1);
    ((AvGameStrangerMatch.AddMatchUserReq)localObject).gender.set(paramInt2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatch-AddMatchUser");
    localToServiceMsg.extraData.putLong("uin", paramLong);
    localToServiceMsg.setTimeout(15000L);
    localToServiceMsg.putWupBuffer(((AvGameStrangerMatch.AddMatchUserReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopStrangerMatch uin: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" type:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" gender:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" shareId:");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.i("AvGameRoomListHandler", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new AvGameStrangerMatch.DelMatchUserReq();
    ((AvGameStrangerMatch.DelMatchUserReq)localObject).uin.set(paramLong);
    ((AvGameStrangerMatch.DelMatchUserReq)localObject).type.set(paramInt1);
    ((AvGameStrangerMatch.DelMatchUserReq)localObject).gender.set(paramInt2);
    ((AvGameStrangerMatch.DelMatchUserReq)localObject).shard_id.set(paramInt3);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatch-DelMatchUser");
    localToServiceMsg.extraData.putLong("uin", paramLong);
    localToServiceMsg.putWupBuffer(((AvGameStrangerMatch.DelMatchUserReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameRoomListHandler", 4, String.format("stopStrangerMatchV2. uin=%d gameType=%d from=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    AvGameStrangerMatchV2.DelMatchUserReq localDelMatchUserReq = new AvGameStrangerMatchV2.DelMatchUserReq();
    localDelMatchUserReq.uin.set(paramLong);
    localDelMatchUserReq.game_type.set(paramInt1);
    if (paramArrayOfByte != null) {
      localDelMatchUserReq.extr_info.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramArrayOfByte = createToServiceMsg("qqvgame.StrangerMatchV2-DelMatchUser");
    paramArrayOfByte.extraData.putLong("uin", paramLong);
    paramArrayOfByte.extraData.putInt("gameType", paramInt1);
    paramArrayOfByte.extraData.putInt("from", paramInt2);
    paramArrayOfByte.putWupBuffer(localDelMatchUserReq.toByteArray());
    sendPbReq(paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getShareLink  roomId: ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" shareUin: ");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(" shareName: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" shareType: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" gameId: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" gameType: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" pbMark");
    ((StringBuilder)localObject).append(paramLong3);
    QLog.d("AvGameRoomListHandler", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new AvGameShare.CmdGetShareLinkReq();
      ((AvGameShare.CmdGetShareLinkReq)localObject).roomid.set(paramLong1);
      ((AvGameShare.CmdGetShareLinkReq)localObject).share_uin.set(paramLong2);
      ((AvGameShare.CmdGetShareLinkReq)localObject).share_name.set(paramString1);
      ((AvGameShare.CmdGetShareLinkReq)localObject).share_type.set(paramInt1);
      if (paramInt1 == 2)
      {
        ((AvGameShare.CmdGetShareLinkReq)localObject).play_game_id.set(paramString2);
        ((AvGameShare.CmdGetShareLinkReq)localObject).game_type.set(paramInt2);
      }
      paramString1 = createToServiceMsg("qqvgame.Share-GetShareLink");
      paramString1.putWupBuffer(((AvGameShare.CmdGetShareLinkReq)localObject).toByteArray());
      paramString1.extraData.putLong("mark_extra_tag", paramLong3);
      sendPbReq(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getShareLink exception: ");
      paramString2.append(paramString1.getMessage());
      QLog.e("AvGameRoomListHandler", 1, paramString2.toString());
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGameLobbyInfo uin: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" version: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("AvGameRoomListHandler", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new AvGameLobbyInfo.CmdGetGameLobbyInfoReq();
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.Operation-GetGameLobbyInfo");
    if (paramString != null) {
      ((AvGameLobbyInfo.CmdGetGameLobbyInfoReq)localObject).version.set(paramString);
    }
    localToServiceMsg.extraData.putLong("uin", paramLong);
    localToServiceMsg.extraData.putString("version", paramString);
    localToServiceMsg.putWupBuffer(((AvGameLobbyInfo.CmdGetGameLobbyInfoReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
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
      QLog.d("AvGameRoomListHandler", 2, "handleCreateGameRoom. ");
    }
    long l3 = paramToServiceMsg.extraData.getLong("mark_extra_tag");
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
        QLog.e("AvGameRoomListHandler", 1, paramFromServiceMsg.toString());
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
        QLog.e("AvGameRoomListHandler", 1, paramToServiceMsg.toString());
        j = i;
      }
    }
    Object localObject = "";
    if (j != 0)
    {
      if (!localCmdRoomCreateRsp.res.has())
      {
        notifyUI(1, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
        QLog.d("AvGameRoomListHandler", 2, "handleCreateGameRoom.  rspBody.res.has nothing");
        return;
      }
      j = localCmdRoomCreateRsp.res.errcode.get();
      long l1 = -1L;
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
        QLog.d("AvGameRoomListHandler", 2, paramFromServiceMsg.toString());
      }
      else
      {
        QLog.e("AvGameRoomListHandler", 1, "handleCreateGameRoom room_info empty");
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
          break label497;
        }
      }
      else
      {
        QLog.e("AvGameRoomListHandler", 1, "handleCreateGameRoom auth_info empty");
        paramFromServiceMsg = null;
      }
      i = 0;
      paramToServiceMsg = paramFromServiceMsg;
      label497:
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
      QLog.d("AvGameRoomListHandler", 2, new Object[] { "handleCreateGameRoom. ret = ", ((StringBuilder)localObject).toString() });
      notifyUI(1, true, new Object[] { Integer.valueOf(j), paramFromServiceMsg, paramObject, paramToServiceMsg, Long.valueOf(l3), Long.valueOf(l2) });
      return;
    }
    notifyUI(1, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
    QLog.d("AvGameRoomListHandler", 2, "handleCreateGameRoom. failed not suc");
  }
  
  public void a(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("destroyGameRoom troopUin: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("AvGameRoomListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.a.getCurrentAccountUin();
    try
    {
      localObject1 = new AvGameRoomManager.CmdRoomDestroyReq();
      ((AvGameRoomManager.CmdRoomDestroyReq)localObject1).uin.set(AvGameEntranceUtil.a((String)localObject2));
      ((AvGameRoomManager.CmdRoomDestroyReq)localObject1).type.set(2);
      ((AvGameRoomManager.CmdRoomDestroyReq)localObject1).groupid.set(AvGameEntranceUtil.a(paramString));
      localObject2 = createToServiceMsg("qqvgame.RoomManager-RoomDestroy");
      ((ToServiceMsg)localObject2).putWupBuffer(((AvGameRoomManager.CmdRoomDestroyReq)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putString("troop_uin_extra_tag", paramString);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("AvGameRoomListHandler", 1, "destroyGameRoom exception:", paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("batchGetGroupGameRoomList  troopUin: ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" start: ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" batchCount: ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("AvGameRoomListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.a.getCurrentAccountUin();
    try
    {
      localObject1 = new AvGameRoomManager.CmdRoomBatchForGroupReq();
      ((AvGameRoomManager.CmdRoomBatchForGroupReq)localObject1).groupid.set(AvGameEntranceUtil.a(paramString));
      ((AvGameRoomManager.CmdRoomBatchForGroupReq)localObject1).uin.set(AvGameEntranceUtil.a((String)localObject2));
      ((AvGameRoomManager.CmdRoomBatchForGroupReq)localObject1).start.set(paramInt1);
      ((AvGameRoomManager.CmdRoomBatchForGroupReq)localObject1).batch_num.set(paramInt2);
      ((AvGameRoomManager.CmdRoomBatchForGroupReq)localObject1).req_from.set(paramInt3);
      ((AvGameRoomManager.CmdRoomBatchForGroupReq)localObject1).req_platform.set(1);
      localObject2 = createToServiceMsg("qqvgame.RoomManager-RoomBatchForGroup");
      ((ToServiceMsg)localObject2).putWupBuffer(((AvGameRoomManager.CmdRoomBatchForGroupReq)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putString("troop_uin_extra_tag", paramString);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("AvGameRoomListHandler", 1, "batchGetGroupGameRoomList exception:", paramString);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getInviteBackflowInfo  key: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" pbMark");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("AvGameRoomListHandler", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new AvGameShare.CmdInviteCheckReq();
      ((AvGameShare.CmdInviteCheckReq)localObject).key.set(paramString);
      paramString = createToServiceMsg("qqvgame.Share-InviteBackflowCheck");
      paramString.putWupBuffer(((AvGameShare.CmdInviteCheckReq)localObject).toByteArray());
      paramString.extraData.putLong("mark_extra_tag", paramLong);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getInviteBackflowInfo exception: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("AvGameRoomListHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGameRoomPushInfo, msg_type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" troopUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" oper_uin = ");
      localStringBuilder.append(paramString2);
      QLog.i("AvGameRoomListHandler", 2, localStringBuilder.toString());
    }
    if ((paramInt >= 1) && (paramString1.length() != 0))
    {
      notifyUI(4, true, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("handleGameRoomPushInfo wrong info! msg_type = ");
    paramString2.append(paramInt);
    paramString2.append(" troopUin = ");
    paramString2.append(paramString1);
    QLog.d("AvGameRoomListHandler", 2, paramString2.toString());
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, String.format("startStrangerMatchV2. uin=%d gameType=%d from=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    AvGameStrangerMatchV2.AddMatchUserReq localAddMatchUserReq = new AvGameStrangerMatchV2.AddMatchUserReq();
    localAddMatchUserReq.uin.set(paramLong);
    localAddMatchUserReq.game_type.set(paramInt1);
    localAddMatchUserReq.from.set(paramInt2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatchV2-AddMatchUser");
    localToServiceMsg.putWupBuffer(localAddMatchUserReq.toByteArray());
    localToServiceMsg.extraData.putLong("uin", paramLong);
    localToServiceMsg.extraData.putInt("gameType", paramInt1);
    localToServiceMsg.extraData.putInt("from", paramInt2);
    sendPbReq(localToServiceMsg);
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
    long l3 = paramToServiceMsg.extraData.getLong("mark_extra_tag");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleJoinGameRoom. isSuccess = ");
      paramToServiceMsg.append(bool1);
      QLog.d("AvGameRoomListHandler", 2, paramToServiceMsg.toString());
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
        QLog.e("AvGameRoomListHandler", 1, paramFromServiceMsg.toString());
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
        QLog.e("AvGameRoomListHandler", 1, paramToServiceMsg.toString());
        bool2 = bool1;
      }
    }
    Object localObject = "";
    if (bool2)
    {
      if (!localCmdRoomEnterRsp.res.has())
      {
        notifyUI(2, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
        QLog.d("AvGameRoomListHandler", 2, "handleJoinGameRoom.  rspBody.res.has nothing");
        return;
      }
      int j = localCmdRoomEnterRsp.res.errcode.get();
      long l1 = -1L;
      if (localCmdRoomEnterRsp.room_info.has())
      {
        l1 = localCmdRoomEnterRsp.room_info.roomid.get();
        paramObject = new RoomInfo();
        paramObject.parseFrom(localCmdRoomEnterRsp.room_info);
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("roominfo :  ");
        paramToServiceMsg.append(paramObject.toString());
        paramToServiceMsg.append(" players:");
        paramToServiceMsg.append(paramObject.players.size());
        QLog.d("AvGameRoomListHandler", 2, paramToServiceMsg.toString());
      }
      else
      {
        QLog.e("AvGameRoomListHandler", 1, "handleJoinGameRoom room_info empty");
        paramObject = null;
      }
      if (localCmdRoomEnterRsp.auth_info.has())
      {
        if (localCmdRoomEnterRsp.auth_info.has()) {
          paramToServiceMsg = localCmdRoomEnterRsp.auth_info.get().toByteArray();
        } else {
          paramToServiceMsg = null;
        }
        paramFromServiceMsg = paramToServiceMsg;
        if (paramToServiceMsg != null)
        {
          i = paramToServiceMsg.length;
          break label472;
        }
      }
      else
      {
        QLog.e("AvGameRoomListHandler", 1, "handleJoinGameRoom auth_info empty");
        paramFromServiceMsg = null;
      }
      int i = 0;
      paramToServiceMsg = paramFromServiceMsg;
      label472:
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
      QLog.d("AvGameRoomListHandler", 2, new Object[] { "handleJoinGameRoom. ret = ", ((StringBuilder)localObject).toString() });
      notifyUI(2, true, new Object[] { Integer.valueOf(j), paramFromServiceMsg, paramObject, paramToServiceMsg, Long.valueOf(l3), Long.valueOf(l2) });
      return;
    }
    notifyUI(2, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
    QLog.d("AvGameRoomListHandler", 2, "handleJoinGameRoom. failed not suc");
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameRoomManager.CmdRoomBatchForGroupRsp localCmdRoomBatchForGroupRsp = new AvGameRoomManager.CmdRoomBatchForGroupRsp();
    Object localObject1 = Integer.valueOf(1);
    Object localObject2 = Integer.valueOf(0);
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetGroupGameRoomList. isSuccess = ");
      localStringBuilder.append(bool);
      QLog.d("AvGameRoomListHandler", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      try
      {
        localCmdRoomBatchForGroupRsp.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetGroupGameRoomList.  false result：");
        paramObject.append(paramFromServiceMsg.toString());
        QLog.e("AvGameRoomListHandler", 1, paramObject.toString());
        bool = false;
      }
    }
    else if (paramFromServiceMsg != null)
    {
      paramObject = new StringBuilder();
      paramObject.append("ERRCODE:");
      paramObject.append(paramFromServiceMsg.getResultCode());
      QLog.e("AvGameRoomListHandler", 1, paramObject.toString());
    }
    paramObject = paramToServiceMsg.extraData.getString("troop_uin_extra_tag");
    paramFromServiceMsg = new ArrayList();
    paramToServiceMsg = "";
    if (bool)
    {
      if (!localCmdRoomBatchForGroupRsp.res.has())
      {
        notifyUI(3, false, new Object[] { Integer.valueOf(-1), "", paramObject, paramFromServiceMsg, localObject2, localObject2, localObject1 });
        QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList. rspBody.res.has nothing");
        return;
      }
      int m = localCmdRoomBatchForGroupRsp.res.errcode.get();
      if (localCmdRoomBatchForGroupRsp.res.errmsg.has()) {
        paramToServiceMsg = localCmdRoomBatchForGroupRsp.res.errmsg.get().toStringUtf8();
      }
      localObject1 = localCmdRoomBatchForGroupRsp.room_infos.get();
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = new RoomInfo();
          ((RoomInfo)localObject2).parseFrom((AvGameCommon.RoomInfo)((List)localObject1).get(i));
          paramFromServiceMsg.add(localObject2);
          i += 1;
        }
      }
      if (localCmdRoomBatchForGroupRsp.total_room_num.has()) {
        i = localCmdRoomBatchForGroupRsp.total_room_num.get();
      } else {
        i = 0;
      }
      int j;
      if (localCmdRoomBatchForGroupRsp.next.has()) {
        j = localCmdRoomBatchForGroupRsp.next.get();
      } else {
        j = 0;
      }
      int k;
      if (localCmdRoomBatchForGroupRsp.is_end.has()) {
        k = localCmdRoomBatchForGroupRsp.is_end.get();
      } else {
        k = 0;
      }
      notifyUI(3, true, new Object[] { Integer.valueOf(m), paramToServiceMsg, paramObject, paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetGroupGameRoomList.get gameRoomList retcode");
      paramToServiceMsg.append(m);
      paramToServiceMsg.append(" gameRoomList size");
      paramToServiceMsg.append(paramFromServiceMsg.size());
      QLog.d("AvGameRoomListHandler", 2, paramToServiceMsg.toString());
      return;
    }
    notifyUI(3, false, new Object[] { Integer.valueOf(-1), "", paramObject, paramFromServiceMsg, localObject2, localObject2, localObject1 });
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList fail");
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
    paramToServiceMsg.append("handleGameShare. isSuccess = ");
    paramToServiceMsg.append(bool1);
    QLog.d("AvGameRoomListHandler", 1, paramToServiceMsg.toString());
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
        paramFromServiceMsg.append("handleGameShare.  false result：");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.e("AvGameRoomListHandler", 1, paramFromServiceMsg.toString());
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
        QLog.e("AvGameRoomListHandler", 1, paramToServiceMsg.toString());
        bool2 = bool1;
      }
    }
    if (bool2)
    {
      if (!localCmdGetShareLinkRsp.share_url.has())
      {
        notifyUI(6, false, new Object[] { "", Long.valueOf(l) });
        QLog.e("AvGameRoomListHandler", 1, "handleGameShare. rspBody.res.has nothing");
        return;
      }
      paramToServiceMsg = localCmdGetShareLinkRsp.share_url.get();
      notifyUI(6, true, new Object[] { paramToServiceMsg, Long.valueOf(l) });
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGameShare.get shareUrl:");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(" mark: ");
      paramFromServiceMsg.append(l);
      QLog.d("AvGameRoomListHandler", 1, paramFromServiceMsg.toString());
      return;
    }
    notifyUI(6, false, new Object[] { "", Long.valueOf(l) });
    QLog.e("AvGameRoomListHandler", 1, "handleGameShare fail");
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameShare.CmdInviteCheckRsp localCmdInviteCheckRsp = new AvGameShare.CmdInviteCheckRsp();
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    long l2 = paramToServiceMsg.extraData.getLong("mark_extra_tag");
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleShareInviteBackflow. isSuccess = ");
    paramToServiceMsg.append(bool1);
    QLog.d("AvGameRoomListHandler", 1, paramToServiceMsg.toString());
    boolean bool2;
    if (bool1)
    {
      try
      {
        localCmdInviteCheckRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleShareInviteBackflow.  false result：");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.e("AvGameRoomListHandler", 1, paramFromServiceMsg.toString());
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
        QLog.e("AvGameRoomListHandler", 1, paramToServiceMsg.toString());
        bool2 = bool1;
      }
    }
    if (bool2)
    {
      long l1;
      if (localCmdInviteCheckRsp.share_type.has()) {
        l1 = localCmdInviteCheckRsp.share_type.get();
      } else {
        l1 = 0L;
      }
      int i;
      if ((l1 != 3L) && ((!localCmdInviteCheckRsp.roomid.has()) || (!localCmdInviteCheckRsp.share_uin.has()))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        notifyUI(7, false, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(l2), Long.valueOf(l1) });
        QLog.e("AvGameRoomListHandler", 1, "handleShareInviteBackflow. rspBody.res.has nothing");
        return;
      }
      long l3 = localCmdInviteCheckRsp.roomid.get();
      long l4 = localCmdInviteCheckRsp.share_uin.get();
      notifyUI(7, true, new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1) });
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleShareInviteBackflow.get roomId:");
      paramToServiceMsg.append(l3);
      paramToServiceMsg.append(" shareUin: ");
      paramToServiceMsg.append(l4);
      paramToServiceMsg.append(" mark: ");
      paramToServiceMsg.append(l2);
      QLog.d("AvGameRoomListHandler", 1, paramToServiceMsg.toString());
      return;
    }
    notifyUI(7, false, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(l2), Long.valueOf(0L) });
    QLog.e("AvGameRoomListHandler", 1, "handleShareInviteBackflow fail");
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameRoomManager.CmdRoomDestroyRsp localCmdRoomDestroyRsp = new AvGameRoomManager.CmdRoomDestroyRsp();
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleDestroyAllGameRoom. isSuccess = ");
      localStringBuilder.append(bool1);
      QLog.d("AvGameRoomListHandler", 2, localStringBuilder.toString());
    }
    boolean bool2;
    if (bool1)
    {
      try
      {
        localCmdRoomDestroyRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleDestroyAllGameRoom.  false result：");
        paramObject.append(paramFromServiceMsg.toString());
        QLog.e("AvGameRoomListHandler", 2, paramObject.toString());
        bool2 = false;
      }
    }
    else
    {
      bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        paramObject = new StringBuilder();
        paramObject.append("ERRCODE:");
        paramObject.append(paramFromServiceMsg.getResultCode());
        QLog.e("AvGameRoomListHandler", 2, paramObject.toString());
        bool2 = bool1;
      }
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("troop_uin_extra_tag");
    paramToServiceMsg = "";
    int i;
    if ((bool2) && (localCmdRoomDestroyRsp.res.has()))
    {
      int j = localCmdRoomDestroyRsp.res.errcode.get();
      i = j;
      if (localCmdRoomDestroyRsp.res.errmsg.has())
      {
        paramToServiceMsg = localCmdRoomDestroyRsp.res.errmsg.get().toStringUtf8();
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    notifyUI(5, bool2, new Object[] { Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
  }
  
  protected void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleStartStrangerMatch. isSuccess = ");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(l);
      QLog.d("AvGameRoomListHandler", 2, paramToServiceMsg.toString());
    }
    paramToServiceMsg = null;
    int j = -1;
    if (bool)
    {
      AvGameStrangerMatch.AddMatchUserRsp localAddMatchUserRsp = new AvGameStrangerMatch.AddMatchUserRsp();
      int i = j;
      try
      {
        localAddMatchUserRsp.mergeFrom((byte[])paramObject);
        i = j;
        j = ((AvGameCommon.Result)localAddMatchUserRsp.res.get()).errcode.get();
        i = j;
        paramFromServiceMsg = ((AvGameCommon.Result)localAddMatchUserRsp.res.get()).errmsg.get().toStringUtf8();
        paramToServiceMsg = paramFromServiceMsg;
        i = j;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleStartStrangerMatch.  false result：");
        paramObject.append(paramFromServiceMsg);
        QLog.e("AvGameRoomListHandler", 2, paramObject.toString());
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleStartStrangerMatch() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg }));
      }
      if ((bool) && (i == 0))
      {
        notifyUI(8, true, new Object[] { Long.valueOf(l), Integer.valueOf(localAddMatchUserRsp.shard_id.get()), Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      notifyUI(8, false, new Object[] { Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    notifyUI(8, false, new Object[] { Long.valueOf(l), Integer.valueOf(-1), Integer.valueOf(-1), null });
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("qqvgame.RoomManager-RoomCreate");
      this.allowCmdSet.add("qqvgame.RoomManager-RoomEnter");
      this.allowCmdSet.add("qqvgame.RoomManager-RoomLeave");
      this.allowCmdSet.add("qqvgame.RoomManager-RoomBatchForGroup");
      this.allowCmdSet.add("qqvgame.ResultShare-FileUpload");
      this.allowCmdSet.add("qqvgame.Share-GetShareLink");
      this.allowCmdSet.add("qqvgame.Share-InviteBackflowCheck");
      this.allowCmdSet.add("qqvgame.RoomManager-RoomDestroy");
      this.allowCmdSet.add("qqvgame.StrangerMatch-AddMatchUser");
      this.allowCmdSet.add("qqvgame.StrangerMatch-DelMatchUser");
      this.allowCmdSet.add("qqvgame.Operation-GetGameLobbyInfo");
      this.allowCmdSet.add("qqvgame.PKReserve-Reserve");
      this.allowCmdSet.add("qqvgame.StrangerMatchV2-AddMatchUser");
      this.allowCmdSet.add("qqvgame.StrangerMatchV2-DelMatchUser");
    }
    return this.allowCmdSet;
  }
  
  protected void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleStopStrangerMatch. isSuccess = ");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(l);
      QLog.d("AvGameRoomListHandler", 2, paramToServiceMsg.toString());
    }
    paramToServiceMsg = null;
    int j = -1;
    if (bool)
    {
      paramFromServiceMsg = new AvGameStrangerMatch.DelMatchUserRsp();
      int i = j;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = j;
        j = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        i = j;
        paramFromServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        paramToServiceMsg = paramFromServiceMsg;
        i = j;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleStopStrangerMatch.  false result：");
        paramObject.append(paramFromServiceMsg);
        QLog.e("AvGameRoomListHandler", 2, paramObject.toString());
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleStopStrangerMatch() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg }));
      }
      if ((bool) && (i == 0))
      {
        notifyUI(9, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      notifyUI(9, false, new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    notifyUI(9, false, new Object[] { Long.valueOf(l), Integer.valueOf(-1), null });
  }
  
  protected void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = "";
    long l = paramToServiceMsg.extraData.getLong("uin");
    Object localObject3 = paramToServiceMsg.extraData.getString("version");
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetGameLobbyInfo. isSuccess = ");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(l);
      QLog.d("AvGameRoomListHandler", 2, paramToServiceMsg.toString());
    }
    if (bool)
    {
      Object localObject2 = new AvGameLobbyInfo.CmdGetGameLobbyInfoRsp();
      int i;
      try
      {
        ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).mergeFrom((byte[])paramObject);
        if (((AvGameCommon.Result)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).res.get()).errcode.has()) {
          i = ((AvGameCommon.Result)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).res.get()).errcode.get();
        } else {
          i = 0;
        }
        try
        {
          if (((AvGameCommon.Result)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).res.get()).errmsg.has()) {
            paramObject = ((AvGameCommon.Result)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).res.get()).errmsg.get().toStringUtf8();
          } else {
            paramObject = "";
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
        paramFromServiceMsg = new StringBuilder();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i = 0;
      }
      paramFromServiceMsg.append("handleGetGameLobbyInfo.  false result：");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.e("AvGameRoomListHandler", 2, paramFromServiceMsg.toString());
      paramObject = null;
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleGetGameLobbyInfo() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramObject }));
      }
      GameUtil.a("AvGameRoomListHandler", null, null, new MessageMicro[] { localObject2 });
      if (i == 0)
      {
        AVGameLobbyConstants.RandomMatchInfo localRandomMatchInfo = new AVGameLobbyConstants.RandomMatchInfo();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        ArrayList localArrayList4 = new ArrayList();
        int j;
        if (((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).banner_list.has())
        {
          paramFromServiceMsg = ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).banner_list.get();
          j = 0;
          while (j < paramFromServiceMsg.size())
          {
            AVGameLobbyConstants.BannerInfo localBannerInfo = new AVGameLobbyConstants.BannerInfo();
            if (((AvGameLobbyInfo.BannerInfo)paramFromServiceMsg.get(j)).picture_url.has()) {
              paramToServiceMsg = ((AvGameLobbyInfo.BannerInfo)paramFromServiceMsg.get(j)).picture_url.get();
            } else {
              paramToServiceMsg = "";
            }
            localBannerInfo.jdField_a_of_type_JavaLangString = paramToServiceMsg;
            if (((AvGameLobbyInfo.BannerInfo)paramFromServiceMsg.get(j)).skip_url.has()) {
              paramToServiceMsg = ((AvGameLobbyInfo.BannerInfo)paramFromServiceMsg.get(j)).skip_url.get();
            } else {
              paramToServiceMsg = "";
            }
            localBannerInfo.jdField_b_of_type_JavaLangString = paramToServiceMsg;
            localArrayList1.add(localBannerInfo);
            j += 1;
          }
        }
        int k;
        if ((localObject3 != null) && (((String)localObject3).equals("8.4.17")))
        {
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          if (((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).operate_activity_info.has())
          {
            localObject3 = ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).operate_activity_info.get();
            j = 0;
            paramToServiceMsg = (ToServiceMsg)localObject1;
            for (;;)
            {
              paramFromServiceMsg = paramToServiceMsg;
              if (j >= ((List)localObject3).size()) {
                break;
              }
              if (((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).pk_id.has()) {
                k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).pk_id.get();
              } else {
                k = 0;
              }
              if (k > 0)
              {
                localArrayList2.add(a((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)));
              }
              else
              {
                localObject1 = new AVGameLobbyCommonContentInfo(8);
                ((AVGameLobbyCommonContentInfo)localObject1).jdField_a_of_type_Int = k;
                if (((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).title_url.has()) {
                  paramFromServiceMsg = ((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).title_url.get();
                } else {
                  paramFromServiceMsg = paramToServiceMsg;
                }
                ((AVGameLobbyCommonContentInfo)localObject1).jdField_a_of_type_JavaLangString = paramFromServiceMsg;
                if (((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).backgroud_url.has()) {
                  paramFromServiceMsg = ((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).backgroud_url.get();
                } else {
                  paramFromServiceMsg = paramToServiceMsg;
                }
                ((AVGameLobbyCommonContentInfo)localObject1).jdField_b_of_type_JavaLangString = paramFromServiceMsg;
                if (((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).game_type.has()) {
                  k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).game_type.get();
                } else {
                  k = 0;
                }
                ((AVGameLobbyCommonContentInfo)localObject1).e = k;
                if (((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).play_user_num.has()) {
                  k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).play_user_num.get();
                } else {
                  k = 0;
                }
                ((AVGameLobbyCommonContentInfo)localObject1).jdField_b_of_type_Int = k;
                if (((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).wording.has()) {
                  paramFromServiceMsg = ((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).wording.get();
                } else {
                  paramFromServiceMsg = paramToServiceMsg;
                }
                ((AVGameLobbyCommonContentInfo)localObject1).jdField_c_of_type_JavaLangString = paramFromServiceMsg;
                if (((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).color_start.has()) {
                  k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).color_start.get();
                } else {
                  k = 0;
                }
                ((AVGameLobbyCommonContentInfo)localObject1).jdField_c_of_type_Int = k;
                if (((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).color_end.has()) {
                  k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).color_end.get();
                } else {
                  k = 0;
                }
                ((AVGameLobbyCommonContentInfo)localObject1).d = k;
                paramFromServiceMsg = paramToServiceMsg;
                if (((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).player_list.has())
                {
                  k = 0;
                  for (;;)
                  {
                    paramFromServiceMsg = paramToServiceMsg;
                    if (k >= ((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).player_list.get().size()) {
                      break;
                    }
                    paramFromServiceMsg = (AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.PKCardInfo)((List)localObject3).get(j)).player_list.get().get(k);
                    if ((paramFromServiceMsg.has()) && (((AvGameLobbyInfo.PlayerInfo)paramFromServiceMsg.get()).uid.has())) {
                      ((AVGameLobbyCommonContentInfo)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((AvGameLobbyInfo.PlayerInfo)paramFromServiceMsg.get()).uid.get()));
                    }
                    k += 1;
                  }
                }
                paramToServiceMsg = paramFromServiceMsg;
                localArrayList3.add(localObject1);
              }
              j += 1;
            }
          }
          if (((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).random_match_info_by_type.has())
          {
            localObject1 = ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).random_match_info_by_type.get();
            j = 0;
          }
        }
        else
        {
          while (j < ((List)localObject1).size())
          {
            localObject2 = new AVGameLobbyRandomMatchContentInfo(9);
            if (((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).title_url.has()) {
              paramToServiceMsg = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).title_url.get();
            } else {
              paramToServiceMsg = paramFromServiceMsg;
            }
            ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_a_of_type_JavaLangString = paramToServiceMsg;
            if (((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).backgroud_url.has()) {
              paramToServiceMsg = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).backgroud_url.get();
            } else {
              paramToServiceMsg = paramFromServiceMsg;
            }
            ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_b_of_type_JavaLangString = paramToServiceMsg;
            if (((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).game_type.has()) {
              k = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).game_type.get();
            } else {
              k = 0;
            }
            ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_b_of_type_Int = k;
            if (((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).players_num.has()) {
              k = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).players_num.get();
            } else {
              k = 0;
            }
            ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_a_of_type_Int = k;
            if (((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).wording.has()) {
              paramToServiceMsg = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).wording.get();
            } else {
              paramToServiceMsg = paramFromServiceMsg;
            }
            ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_c_of_type_JavaLangString = paramToServiceMsg;
            ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_c_of_type_Int = j;
            if (((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).player_list.has())
            {
              k = 0;
              while (k < ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).player_list.get().size())
              {
                paramToServiceMsg = (AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).player_list.get().get(k);
                if ((paramToServiceMsg.has()) && (((AvGameLobbyInfo.PlayerInfo)paramToServiceMsg.get()).uid.has())) {
                  ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((AvGameLobbyInfo.PlayerInfo)paramToServiceMsg.get()).uid.get()));
                }
                k += 1;
              }
            }
            localArrayList4.add(localObject2);
            j += 1;
            continue;
            if (((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).random_match_info.has())
            {
              paramToServiceMsg = (AvGameLobbyInfo.RandomMatchInfo)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).random_match_info.get();
              if (paramToServiceMsg.players_num.has()) {
                j = paramToServiceMsg.players_num.get();
              } else {
                j = 0;
              }
              localRandomMatchInfo.jdField_a_of_type_Int = j;
              if (paramToServiceMsg.player_list.has())
              {
                j = 0;
                while (j < paramToServiceMsg.player_list.get().size())
                {
                  paramFromServiceMsg = (AvGameLobbyInfo.PlayerInfo)paramToServiceMsg.player_list.get().get(j);
                  if ((paramFromServiceMsg.has()) && (((AvGameLobbyInfo.PlayerInfo)paramFromServiceMsg.get()).uid.has())) {
                    localRandomMatchInfo.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((AvGameLobbyInfo.PlayerInfo)paramFromServiceMsg.get()).uid.get()));
                  }
                  j += 1;
                }
              }
            }
            if (((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).pk_list.has())
            {
              paramToServiceMsg = ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject2).pk_list.get();
              j = 0;
              while (j < paramToServiceMsg.size())
              {
                localArrayList2.add(a((AvGameLobbyInfo.PKCardInfo)paramToServiceMsg.get(j)));
                j += 1;
              }
            }
          }
        }
        notifyUI(10, true, new Object[] { Long.valueOf(l), localArrayList1, localRandomMatchInfo, localArrayList2, localArrayList3, localArrayList4, Integer.valueOf(i), paramObject });
        return;
      }
      notifyUI(10, false, new Object[] { Long.valueOf(l), null, null, null, null, null, Integer.valueOf(i), paramObject });
      return;
    }
    notifyUI(10, false, new Object[] { Long.valueOf(l), null, null, null, null, null, Integer.valueOf(-1), null });
  }
  
  protected void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramToServiceMsg.extraData.getInt("pkId");
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleReservePKGame. isSuccess = ");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(" pkId = ");
      paramToServiceMsg.append(j);
      QLog.d("AvGameRoomListHandler", 2, paramToServiceMsg.toString());
    }
    paramFromServiceMsg = null;
    if (bool)
    {
      paramToServiceMsg = new AvGameLobbyPKReserve.ReserveRsp();
      int i;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (((AvGameCommon.Result)paramToServiceMsg.res.get()).errcode.has()) {
          i = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errcode.get();
        } else {
          i = 0;
        }
        try
        {
          if (((AvGameCommon.Result)paramToServiceMsg.res.get()).errmsg.has()) {
            paramToServiceMsg = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errmsg.get().toStringUtf8();
          } else {
            paramToServiceMsg = "";
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
        paramObject = new StringBuilder();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i = 0;
      }
      paramObject.append("handleReservePKGame.  false result：");
      paramObject.append(paramToServiceMsg);
      QLog.e("AvGameRoomListHandler", 2, paramObject.toString());
      bool = false;
      paramToServiceMsg = paramFromServiceMsg;
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleReservePKGame() pkId=%d errCode=%d errMsg=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramToServiceMsg }));
      }
      if ((bool) && (i == 0))
      {
        notifyUI(12, true, new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      notifyUI(12, false, new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    notifyUI(12, false, new Object[] { Integer.valueOf(j), Integer.valueOf(-1), null });
  }
  
  protected void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    int j = paramToServiceMsg.extraData.getInt("gameType");
    int k = paramToServiceMsg.extraData.getInt("from");
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleStartStrangerMatchV2. isSuccess = ");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(j);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(k);
      QLog.d("AvGameRoomListHandler", 2, paramToServiceMsg.toString());
    }
    if (bool)
    {
      AvGameStrangerMatchV2.AddMatchUserRsp localAddMatchUserRsp = new AvGameStrangerMatchV2.AddMatchUserRsp();
      int i;
      try
      {
        localAddMatchUserRsp.mergeFrom((byte[])paramObject);
        i = ((AvGameCommon.Result)localAddMatchUserRsp.res.get()).errcode.get();
        try
        {
          paramToServiceMsg = ((AvGameCommon.Result)localAddMatchUserRsp.res.get()).errmsg.get().toStringUtf8();
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
        paramFromServiceMsg = new StringBuilder();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i = -1;
      }
      paramFromServiceMsg.append("handleStartStrangerMatchV2.  false result：");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.e("AvGameRoomListHandler", 2, paramFromServiceMsg.toString());
      bool = false;
      paramToServiceMsg = null;
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleStartStrangerMatchV2() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg }));
      }
      if ((bool) && (i == 0))
      {
        if (localAddMatchUserRsp.extra_info.has()) {
          paramFromServiceMsg = localAddMatchUserRsp.extra_info.get().toByteArray();
        } else {
          paramFromServiceMsg = null;
        }
        if (k == 0) {
          j = localAddMatchUserRsp.game_type.get();
        }
        notifyUI(15, true, new Object[] { Long.valueOf(l), paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      notifyUI(15, false, new Object[] { Long.valueOf(l), null, Integer.valueOf(j), Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    notifyUI(15, false, new Object[] { Long.valueOf(l), null, Integer.valueOf(j), Integer.valueOf(-1), null });
  }
  
  protected void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    int i = paramToServiceMsg.extraData.getInt("from");
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleStopStrangerMatchV2. isSuccess = ");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(i);
      QLog.d("AvGameRoomListHandler", 2, paramToServiceMsg.toString());
    }
    paramToServiceMsg = null;
    int j = -1;
    if (bool)
    {
      paramFromServiceMsg = new AvGameStrangerMatchV2.DelMatchUserRsp();
      i = j;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = j;
        j = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        i = j;
        paramFromServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        i = j;
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleStopStrangerMatchV2.  false result：");
        paramObject.append(paramFromServiceMsg);
        QLog.e("AvGameRoomListHandler", 2, paramObject.toString());
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleStopStrangerMatchV2() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg }));
      }
      if ((bool) && (i == 0))
      {
        notifyUI(16, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      notifyUI(16, false, new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    notifyUI(16, false, new Object[] { Long.valueOf(l), Integer.valueOf(-1), null });
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return AvGameRoomListObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ("qqvgame.RoomManager-RoomCreate".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.RoomManager-RoomEnter".equals(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.RoomManager-RoomLeave".equals(paramFromServiceMsg.getServiceCmd()))
    {
      m(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.RoomManager-RoomBatchForGroup".equals(paramFromServiceMsg.getServiceCmd()))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.ResultShare-FileUpload".equals(paramFromServiceMsg.getServiceCmd()))
    {
      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.RoomManager-RoomDestroy".equals(paramFromServiceMsg.getServiceCmd()))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.Share-GetShareLink".equals(paramFromServiceMsg.getServiceCmd()))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.Share-InviteBackflowCheck".equals(paramFromServiceMsg.getServiceCmd()))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.StrangerMatch-AddMatchUser".equals(paramFromServiceMsg.getServiceCmd()))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.StrangerMatch-DelMatchUser".equals(paramFromServiceMsg.getServiceCmd()))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.Operation-GetGameLobbyInfo".equals(paramFromServiceMsg.getServiceCmd()))
    {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.PKReserve-Reserve".equals(paramFromServiceMsg.getServiceCmd()))
    {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.StrangerMatchV2-AddMatchUser".equals(paramFromServiceMsg.getServiceCmd()))
    {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.StrangerMatchV2-DelMatchUser".equals(paramFromServiceMsg.getServiceCmd())) {
      l(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.handler.AvGameRoomListHandler
 * JD-Core Version:    0.7.0.1
 */