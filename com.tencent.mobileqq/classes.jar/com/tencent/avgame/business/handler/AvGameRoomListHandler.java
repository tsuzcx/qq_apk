package com.tencent.avgame.business.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote;
import com.tencent.avgame.localvoicerecog.AVGameVoiceRecog;
import com.tencent.avgame.ui.AVGameRoomCenterFragment.BannerInfo;
import com.tencent.avgame.ui.AVGameRoomCenterFragment.RandomMatchInfo;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQVedioGamePushInfo;
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
  private QQAppInterface a;
  
  public AvGameRoomListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 2) {
      return 2;
    }
    if ((paramInt == 3) || (paramInt == 6)) {
      return 3;
    }
    if ((paramInt == 4) || (paramInt == 500) || (paramInt == 501) || (paramInt == 502)) {
      return 4;
    }
    if (paramInt == 5) {
      return 5;
    }
    if (paramInt == 1) {
      return 1;
    }
    if ((paramInt == 8) || (paramInt == 12)) {
      return 6;
    }
    if (paramInt == 9) {
      return 7;
    }
    if (paramInt == 10) {
      return 8;
    }
    if ((paramInt == 11) || (paramInt == 13)) {
      return 9;
    }
    if ((paramInt >= 500) && (paramInt <= 600)) {
      return 4;
    }
    return 1;
  }
  
  private AVGameLobbySurvivalContentInfo a(AvGameLobbyInfo.PKCardInfo paramPKCardInfo)
  {
    long l2 = 0L;
    AVGameLobbySurvivalContentInfo localAVGameLobbySurvivalContentInfo = new AVGameLobbySurvivalContentInfo(4);
    int i;
    label56:
    label82:
    long l1;
    label107:
    boolean bool;
    if (paramPKCardInfo.pk_id.has())
    {
      i = paramPKCardInfo.pk_id.get();
      localAVGameLobbySurvivalContentInfo.a(i);
      if (!paramPKCardInfo.title_url.has()) {
        break label449;
      }
      localObject = paramPKCardInfo.title_url.get();
      localAVGameLobbySurvivalContentInfo.a((String)localObject);
      if (!paramPKCardInfo.backgroud_url.has()) {
        break label456;
      }
      localObject = paramPKCardInfo.backgroud_url.get();
      localAVGameLobbySurvivalContentInfo.b((String)localObject);
      if (!paramPKCardInfo.start_time.has()) {
        break label463;
      }
      l1 = paramPKCardInfo.start_time.get();
      localAVGameLobbySurvivalContentInfo.a(l1);
      l1 = l2;
      if (paramPKCardInfo.end_time.has()) {
        l1 = paramPKCardInfo.end_time.get();
      }
      localAVGameLobbySurvivalContentInfo.b(l1);
      if (!paramPKCardInfo.is_reserve.has()) {
        break label468;
      }
      bool = paramPKCardInfo.is_reserve.get();
      label159:
      localAVGameLobbySurvivalContentInfo.a(bool);
      if (!paramPKCardInfo.reserve_user_num.has()) {
        break label474;
      }
      i = paramPKCardInfo.reserve_user_num.get();
      label184:
      localAVGameLobbySurvivalContentInfo.b(i);
      if (!paramPKCardInfo.play_user_num.has()) {
        break label479;
      }
      i = paramPKCardInfo.play_user_num.get();
      label208:
      localAVGameLobbySurvivalContentInfo.c(i);
      if (!paramPKCardInfo.wording.has()) {
        break label484;
      }
      localObject = paramPKCardInfo.wording.get();
      label233:
      localAVGameLobbySurvivalContentInfo.c((String)localObject);
      if (!paramPKCardInfo.color_start.has()) {
        break label491;
      }
      i = paramPKCardInfo.color_start.get();
      label258:
      localAVGameLobbySurvivalContentInfo.d(i);
      if (!paramPKCardInfo.color_end.has()) {
        break label496;
      }
      i = paramPKCardInfo.color_end.get();
      label282:
      localAVGameLobbySurvivalContentInfo.e(i);
      if (!paramPKCardInfo.time_wording.has()) {
        break label501;
      }
    }
    label449:
    label456:
    label463:
    label468:
    label474:
    label479:
    label484:
    label491:
    label496:
    label501:
    for (Object localObject = paramPKCardInfo.time_wording.get();; localObject = null)
    {
      localAVGameLobbySurvivalContentInfo.f((String)localObject);
      localAVGameLobbySurvivalContentInfo.g(paramPKCardInfo.background_color_url.get());
      localAVGameLobbySurvivalContentInfo.c(paramPKCardInfo.is_qqcj_activity.get());
      if (!paramPKCardInfo.player_list.has()) {
        break label507;
      }
      i = 0;
      while (i < paramPKCardInfo.player_list.get().size())
      {
        localObject = (AvGameLobbyInfo.PlayerInfo)paramPKCardInfo.player_list.get().get(i);
        if ((((AvGameLobbyInfo.PlayerInfo)localObject).has()) && (((AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.PlayerInfo)localObject).get()).uid.has())) {
          localAVGameLobbySurvivalContentInfo.a().add(Long.valueOf(((AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.PlayerInfo)localObject).get()).uid.get()));
        }
        i += 1;
      }
      i = 0;
      break;
      localObject = "";
      break label56;
      localObject = "";
      break label82;
      l1 = 0L;
      break label107;
      bool = false;
      break label159;
      i = 0;
      break label184;
      i = 0;
      break label208;
      localObject = "";
      break label233;
      i = 0;
      break label258;
      i = 0;
      break label282;
    }
    label507:
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
    if ((paramInt == 3) || (paramInt == 5)) {
      return 3;
    }
    if (paramInt == 4) {
      return 4;
    }
    if ((paramInt == 6) || (paramInt == 9)) {
      return 5;
    }
    if (paramInt == 7) {
      return 6;
    }
    if ((paramInt == 8) || (paramInt == 1000)) {
      return 7;
    }
    return 4;
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramFromServiceMsg = new AvGameRoomManager.CmdRoomLeaveRsp();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (i != 0) {
            if (paramFromServiceMsg.res.has())
            {
              paramToServiceMsg = (AvGameCommon.Result)paramFromServiceMsg.res.get();
              if (paramFromServiceMsg.room_info.has()) {
                paramFromServiceMsg = (AvGameCommon.RoomInfo)paramFromServiceMsg.room_info.get();
              }
              if ((paramToServiceMsg != null) && (paramToServiceMsg.errcode.has()) && (paramToServiceMsg.errmsg.has())) {
                QLog.i("AvGameRoomListHandler", 4, "onLeaveGameRoom success errorCode= " + paramToServiceMsg.errcode.get() + " errorMsg =" + paramToServiceMsg.errmsg.get());
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
            QLog.e("AvGameRoomListHandler", 1, "onLeaveGameRoom:" + paramToServiceMsg);
            i = 0;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
    }
    QLog.i("AvGameRoomListHandler", 4, "onLeaveGameRoom failed");
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    int k;
    String str;
    AvGameManager localAvGameManager;
    for (int i = 1;; i = 0)
    {
      k = paramToServiceMsg.extraData.getInt("_result_file_type");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("_result_game_id");
      str = paramToServiceMsg.extraData.getString("_result_url");
      localAvGameManager = (AvGameManager)this.a.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (i != 0) {
        break;
      }
      localAvGameManager.a().a(paramFromServiceMsg, k);
      return;
    }
    AvGameResultShare.FileUploadRsp localFileUploadRsp = new AvGameResultShare.FileUploadRsp();
    try
    {
      localFileUploadRsp.mergeFrom((byte[])paramObject);
      paramToServiceMsg = "";
      i = j;
      if (localFileUploadRsp.err_code.has()) {
        i = localFileUploadRsp.err_code.get();
      }
      if (localFileUploadRsp.err_msg.has()) {
        paramToServiceMsg = localFileUploadRsp.err_msg.get();
      }
      if (i != 0)
      {
        QLog.e("AvGameRoomListHandler", 1, "handleGameResultShare retCode:" + i + " errMsg:" + paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      QLog.e("AvGameRoomListHandler", 1, "handleGameResultShare:" + paramToServiceMsg);
      localAvGameManager.a().a(paramFromServiceMsg, k);
      return;
    }
    localAvGameManager.a().a(paramFromServiceMsg, k, str);
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, "createGameRoom " + paramInt1 + " troopUin: " + paramString);
    }
    Object localObject = this.a.getCurrentAccountUin();
    try
    {
      AvGameRoomManager.CmdRoomCreateReq localCmdRoomCreateReq = new AvGameRoomManager.CmdRoomCreateReq();
      localCmdRoomCreateReq.creator_uin.set(AvGameEntranceUtil.a((String)localObject));
      localCmdRoomCreateReq.game_type.set(paramInt2);
      localObject = localCmdRoomCreateReq.trans_mod;
      if (AVGameVoiceRecog.a().b()) {}
      for (paramInt2 = 0;; paramInt2 = 1)
      {
        ((PBUInt32Field)localObject).set(paramInt2);
        paramInt2 = a(paramInt1);
        localCmdRoomCreateReq.from.set(paramInt2);
        if (paramInt2 == 3)
        {
          localCmdRoomCreateReq.group_id.set(AvGameEntranceUtil.a(paramString));
          if (TextUtils.isEmpty(paramString)) {
            QLog.e("AvGameRoomListHandler", 1, "troopUin EMPTY FP =" + paramInt1);
          }
        }
        if ((GameEngine.a().f()) && (GameEngine.a().a() != null))
        {
          localCmdRoomCreateReq.pk_id.set(GameEngine.a().a().k());
          localCmdRoomCreateReq.pool_id.set(GameEngine.a().a().j());
        }
        paramString = createToServiceMsg("qqvgame.RoomManager-RoomCreate");
        paramString.putWupBuffer(localCmdRoomCreateReq.toByteArray());
        paramString.extraData.putLong("mark_extra_tag", paramLong);
        sendPbReq(paramString);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("AvGameRoomListHandler", 1, "reportUser exception:", paramString);
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
    if (QLog.isColorLevel()) {
      QLog.i("AvGameRoomListHandler", 1, "updateShareUrl request = " + localToServiceMsg);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, "joinGameRoom " + paramInt + " roomId: " + paramString1);
    }
    Object localObject = this.a.getCurrentAccountUin();
    for (;;)
    {
      try
      {
        AvGameRoomManager.CmdRoomEnterReq localCmdRoomEnterReq = new AvGameRoomManager.CmdRoomEnterReq();
        int i = b(paramInt);
        localCmdRoomEnterReq.from.set(i);
        localCmdRoomEnterReq.uin.set(AvGameEntranceUtil.a((String)localObject));
        localObject = localCmdRoomEnterReq.trans_mod;
        if (AVGameVoiceRecog.a().b())
        {
          i = 0;
          ((PBUInt32Field)localObject).set(i);
          if ((paramInt == 1) || (paramInt == 2))
          {
            if (TextUtils.isEmpty(paramString2)) {
              QLog.e("AvGameRoomListHandler", 1, "INVITER UIN EMPTY FP=" + paramInt);
            }
          }
          else
          {
            localCmdRoomEnterReq.roomid.set(AvGameEntranceUtil.a(paramString1));
            if (!TextUtils.isEmpty(paramString2)) {
              localCmdRoomEnterReq.invitor_uin.set(AvGameEntranceUtil.a(paramString2));
            }
            localCmdRoomEnterReq.init_status.set(1);
            if ((GameEngine.a().f()) && (GameEngine.a().a() != null)) {
              localCmdRoomEnterReq.pk_opponent_uin.set(GameEngine.a().a().b);
            }
            paramString1 = createToServiceMsg("qqvgame.RoomManager-RoomEnter");
            paramString1.putWupBuffer(localCmdRoomEnterReq.toByteArray());
            paramString1.extraData.putLong("mark_extra_tag", paramLong);
            sendPbReq(paramString1);
            return;
          }
          localCmdRoomEnterReq.invitor_uin.set(AvGameEntranceUtil.a(paramString2));
          continue;
        }
        i = 1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("AvGameRoomListHandler", 1, "reportUser exception:", paramString1);
        return;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameRoomListHandler", 4, "reservePKGame pkId: " + paramInt + " isReserve: " + paramBoolean);
    }
    AvGameLobbyPKReserve.ReserveReq localReserveReq = new AvGameLobbyPKReserve.ReserveReq();
    localReserveReq.pk_id.set(paramInt);
    localReserveReq.is_reserve.set(paramBoolean);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.PKReserve-Reserve");
    localToServiceMsg.extraData.putInt("pkId", paramInt);
    localToServiceMsg.putWupBuffer(localReserveReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong)
  {
    long l = AvGameEntranceUtil.a(this.a.getCurrentUin());
    AvGameRoomManager.CmdRoomLeaveReq localCmdRoomLeaveReq = new AvGameRoomManager.CmdRoomLeaveReq();
    localCmdRoomLeaveReq.roomid.set(paramLong);
    localCmdRoomLeaveReq.reason.set(1);
    localCmdRoomLeaveReq.operator_uin.set(l);
    localCmdRoomLeaveReq.target_uin.set(l);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.RoomManager-RoomLeave");
    localToServiceMsg.putWupBuffer(localCmdRoomLeaveReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("AvGameRoomListHandler", 4, "leaveGameRoom request = " + localToServiceMsg);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameRoomListHandler", 2, "startStrangerMatch uin: " + paramLong + " type:" + paramInt1 + " gender:" + paramInt2);
    }
    AvGameStrangerMatch.AddMatchUserReq localAddMatchUserReq = new AvGameStrangerMatch.AddMatchUserReq();
    localAddMatchUserReq.uin.set(paramLong);
    localAddMatchUserReq.type.set(paramInt1);
    localAddMatchUserReq.gender.set(paramInt2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatch-AddMatchUser");
    localToServiceMsg.extraData.putLong("uin", paramLong);
    localToServiceMsg.setTimeout(15000L);
    localToServiceMsg.putWupBuffer(localAddMatchUserReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameRoomListHandler", 4, "stopStrangerMatch uin: " + paramLong + " type:" + paramInt1 + " gender:" + paramInt2 + " shareId:" + paramInt3);
    }
    AvGameStrangerMatch.DelMatchUserReq localDelMatchUserReq = new AvGameStrangerMatch.DelMatchUserReq();
    localDelMatchUserReq.uin.set(paramLong);
    localDelMatchUserReq.type.set(paramInt1);
    localDelMatchUserReq.gender.set(paramInt2);
    localDelMatchUserReq.shard_id.set(paramInt3);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatch-DelMatchUser");
    localToServiceMsg.extraData.putLong("uin", paramLong);
    localToServiceMsg.putWupBuffer(localDelMatchUserReq.toByteArray());
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
    QLog.d("AvGameRoomListHandler", 1, "getShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    try
    {
      AvGameShare.CmdGetShareLinkReq localCmdGetShareLinkReq = new AvGameShare.CmdGetShareLinkReq();
      localCmdGetShareLinkReq.roomid.set(paramLong1);
      localCmdGetShareLinkReq.share_uin.set(paramLong2);
      localCmdGetShareLinkReq.share_name.set(paramString1);
      localCmdGetShareLinkReq.share_type.set(paramInt1);
      if (paramInt1 == 2)
      {
        localCmdGetShareLinkReq.play_game_id.set(paramString2);
        localCmdGetShareLinkReq.game_type.set(paramInt2);
      }
      paramString1 = createToServiceMsg("qqvgame.Share-GetShareLink");
      paramString1.putWupBuffer(localCmdGetShareLinkReq.toByteArray());
      paramString1.extraData.putLong("mark_extra_tag", paramLong3);
      sendPbReq(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("AvGameRoomListHandler", 1, "getShareLink exception: " + paramString1.getMessage());
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameRoomListHandler", 4, "getGameLobbyInfo uin: " + paramLong + " version: " + paramString);
    }
    AvGameLobbyInfo.CmdGetGameLobbyInfoReq localCmdGetGameLobbyInfoReq = new AvGameLobbyInfo.CmdGetGameLobbyInfoReq();
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.Operation-GetGameLobbyInfo");
    if (paramString != null) {
      localCmdGetGameLobbyInfoReq.version.set(paramString);
    }
    localToServiceMsg.extraData.putLong("uin", paramLong);
    localToServiceMsg.extraData.putString("version", paramString);
    localToServiceMsg.putWupBuffer(localCmdGetGameLobbyInfoReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    AvGameRoomManager.CmdRoomCreateRsp localCmdRoomCreateRsp;
    long l3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      localCmdRoomCreateRsp = new AvGameRoomManager.CmdRoomCreateRsp();
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleCreateGameRoom. ");
      }
      l3 = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      if (i == 0) {
        break label192;
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
        QLog.e("AvGameRoomListHandler", 1, "handleCreateGameRoom.  InvalidProtocolBufferMicroException result：" + paramToServiceMsg.toString());
        j = 0;
        continue;
      }
      paramFromServiceMsg = null;
      if (j == 0) {
        break label645;
      }
      if (localCmdRoomCreateRsp.res.has()) {
        break label236;
      }
      notifyUI(1, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
      QLog.d("AvGameRoomListHandler", 2, "handleCreateGameRoom.  rspBody.res.has nothing");
      return;
      i = 0;
      break;
      label192:
      j = i;
      if (paramFromServiceMsg != null)
      {
        QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        j = i;
      }
    }
    label236:
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
      QLog.d("AvGameRoomListHandler", 2, "roominfo :  " + paramFromServiceMsg.toString() + " players:" + paramFromServiceMsg.players.size() + " playerUin" + paramToServiceMsg);
      if (!localCmdRoomCreateRsp.auth_info.has()) {
        break label622;
      }
      if (!localCmdRoomCreateRsp.auth_info.has()) {
        break label617;
      }
      paramToServiceMsg = localCmdRoomCreateRsp.auth_info.get().toByteArray();
      label421:
      if (paramToServiceMsg == null) {
        break label701;
      }
      i = paramToServiceMsg.length;
    }
    for (;;)
    {
      label429:
      if (localCmdRoomCreateRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomCreateRsp.black_ban_expire_time.get();
      }
      if (localCmdRoomCreateRsp.res.errmsg.has()) {}
      for (paramObject = localCmdRoomCreateRsp.res.errmsg.get().toStringUtf8();; paramObject = "")
      {
        QLog.d("AvGameRoomListHandler", 2, new Object[] { "handleCreateGameRoom. ret = ", j + " errMsg : " + paramObject + " roomId:" + l1 + "sig length" + i + " banExpireTime:" + l2 });
        notifyUI(1, true, new Object[] { Integer.valueOf(j), paramObject, paramFromServiceMsg, paramToServiceMsg, Long.valueOf(l3), Long.valueOf(l2) });
        return;
        QLog.e("AvGameRoomListHandler", 1, "handleCreateGameRoom room_info empty");
        break;
        label617:
        paramToServiceMsg = null;
        break label421;
        label622:
        QLog.e("AvGameRoomListHandler", 1, "handleCreateGameRoom auth_info empty");
        i = 0;
        paramToServiceMsg = null;
        break label429;
      }
      label645:
      notifyUI(1, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
      QLog.d("AvGameRoomListHandler", 2, "handleCreateGameRoom. failed not suc");
      return;
      label701:
      i = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, "destroyGameRoom troopUin: " + paramString);
    }
    Object localObject = this.a.getCurrentAccountUin();
    try
    {
      AvGameRoomManager.CmdRoomDestroyReq localCmdRoomDestroyReq = new AvGameRoomManager.CmdRoomDestroyReq();
      localCmdRoomDestroyReq.uin.set(AvGameEntranceUtil.a((String)localObject));
      localCmdRoomDestroyReq.type.set(2);
      localCmdRoomDestroyReq.groupid.set(AvGameEntranceUtil.a(paramString));
      localObject = createToServiceMsg("qqvgame.RoomManager-RoomDestroy");
      ((ToServiceMsg)localObject).putWupBuffer(localCmdRoomDestroyReq.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troop_uin_extra_tag", paramString);
      sendPbReq((ToServiceMsg)localObject);
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
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, "batchGetGroupGameRoomList  troopUin: " + paramString + " start: " + paramInt1 + " batchCount: " + paramInt2);
    }
    Object localObject = this.a.getCurrentAccountUin();
    try
    {
      AvGameRoomManager.CmdRoomBatchForGroupReq localCmdRoomBatchForGroupReq = new AvGameRoomManager.CmdRoomBatchForGroupReq();
      localCmdRoomBatchForGroupReq.groupid.set(AvGameEntranceUtil.a(paramString));
      localCmdRoomBatchForGroupReq.uin.set(AvGameEntranceUtil.a((String)localObject));
      localCmdRoomBatchForGroupReq.start.set(paramInt1);
      localCmdRoomBatchForGroupReq.batch_num.set(paramInt2);
      localCmdRoomBatchForGroupReq.req_from.set(paramInt3);
      localCmdRoomBatchForGroupReq.req_platform.set(1);
      localObject = createToServiceMsg("qqvgame.RoomManager-RoomBatchForGroup");
      ((ToServiceMsg)localObject).putWupBuffer(localCmdRoomBatchForGroupReq.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troop_uin_extra_tag", paramString);
      sendPbReq((ToServiceMsg)localObject);
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
    QLog.d("AvGameRoomListHandler", 1, "getInviteBackflowInfo  key: " + paramString + " pbMark" + paramLong);
    try
    {
      AvGameShare.CmdInviteCheckReq localCmdInviteCheckReq = new AvGameShare.CmdInviteCheckReq();
      localCmdInviteCheckReq.key.set(paramString);
      paramString = createToServiceMsg("qqvgame.Share-InviteBackflowCheck");
      paramString.putWupBuffer(localCmdInviteCheckReq.toByteArray());
      paramString.extraData.putLong("mark_extra_tag", paramLong);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AvGameRoomListHandler", 1, "getInviteBackflowInfo exception: " + paramString.getMessage());
    }
  }
  
  public void a(TroopTips0x857.QQVedioGamePushInfo paramQQVedioGamePushInfo)
  {
    if (paramQQVedioGamePushInfo == null)
    {
      QLog.d("AvGameRoomListHandler", 2, "handleGameRoomPushInfo pushInfo == null");
      return;
    }
    int i;
    String str;
    if (paramQQVedioGamePushInfo.uint32_msg_type.has())
    {
      i = paramQQVedioGamePushInfo.uint32_msg_type.get();
      if (!paramQQVedioGamePushInfo.uint64_group_code.has()) {
        break label180;
      }
      str = String.valueOf(paramQQVedioGamePushInfo.uint64_group_code.get());
      label53:
      if (!paramQQVedioGamePushInfo.uint64_oper_uin.has()) {
        break label186;
      }
    }
    label180:
    label186:
    for (paramQQVedioGamePushInfo = String.valueOf(paramQQVedioGamePushInfo.uint64_oper_uin.get());; paramQQVedioGamePushInfo = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, "handleGameRoomPushInfo, msg_type = " + i + " troopUin = " + str + " oper_uin = " + paramQQVedioGamePushInfo);
      }
      if ((i >= 1) && (str.length() != 0)) {
        break label192;
      }
      QLog.d("AvGameRoomListHandler", 2, "handleGameRoomPushInfo wrong info! msg_type = " + i + " troopUin = " + str);
      return;
      i = -1;
      break;
      str = "";
      break label53;
    }
    label192:
    notifyUI(4, true, new Object[] { Integer.valueOf(i), str, paramQQVedioGamePushInfo });
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
    long l3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      l3 = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleJoinGameRoom. isSuccess = " + bool1);
      }
      if (!bool1) {
        break label210;
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
        QLog.e("AvGameRoomListHandler", 1, "handleJoinGameRoom.  false result：" + paramToServiceMsg.toString());
        bool2 = false;
        continue;
      }
      paramFromServiceMsg = null;
      if (!bool2) {
        break label614;
      }
      if (localCmdRoomEnterRsp.res.has()) {
        break label254;
      }
      notifyUI(2, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
      QLog.d("AvGameRoomListHandler", 2, "handleJoinGameRoom.  rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label210:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label254:
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
      QLog.d("AvGameRoomListHandler", 2, "roominfo :  " + paramFromServiceMsg.toString() + " players:" + paramFromServiceMsg.players.size());
      if (!localCmdRoomEnterRsp.auth_info.has()) {
        break label596;
      }
      if (!localCmdRoomEnterRsp.auth_info.has()) {
        break label591;
      }
      paramToServiceMsg = localCmdRoomEnterRsp.auth_info.get().toByteArray();
      label402:
      paramObject = paramToServiceMsg;
      if (paramToServiceMsg != null)
      {
        i = paramToServiceMsg.length;
        paramObject = paramToServiceMsg;
      }
      label414:
      if (localCmdRoomEnterRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomEnterRsp.black_ban_expire_time.get();
      }
      if (!localCmdRoomEnterRsp.res.errmsg.has()) {
        break label608;
      }
    }
    label591:
    label596:
    label608:
    for (paramToServiceMsg = localCmdRoomEnterRsp.res.errmsg.get().toStringUtf8();; paramToServiceMsg = "")
    {
      QLog.d("AvGameRoomListHandler", 2, new Object[] { "handleJoinGameRoom. ret = ", j + " errMsg : " + paramToServiceMsg + " roomId:" + l1 + "sig length" + i });
      notifyUI(2, true, new Object[] { Integer.valueOf(j), paramToServiceMsg, paramFromServiceMsg, paramObject, Long.valueOf(l3), Long.valueOf(l2) });
      return;
      QLog.e("AvGameRoomListHandler", 1, "handleJoinGameRoom room_info empty");
      break;
      paramToServiceMsg = null;
      break label402;
      QLog.e("AvGameRoomListHandler", 1, "handleJoinGameRoom auth_info empty");
      break label414;
    }
    label614:
    notifyUI(2, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
    QLog.d("AvGameRoomListHandler", 2, "handleJoinGameRoom. failed not suc");
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameRoomManager.CmdRoomBatchForGroupRsp localCmdRoomBatchForGroupRsp = new AvGameRoomManager.CmdRoomBatchForGroupRsp();
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList. isSuccess = " + bool1);
      }
      if (!bool1) {}
    }
    else
    {
      try
      {
        localCmdRoomBatchForGroupRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          label82:
          bool2 = false;
          QLog.e("AvGameRoomListHandler", 1, "handleGetGroupGameRoomList.  false result：" + paramFromServiceMsg.toString());
        }
      }
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("troop_uin_extra_tag");
      paramObject = new ArrayList();
      if (!bool2) {
        break label578;
      }
      if (localCmdRoomBatchForGroupRsp.res.has()) {
        break label266;
      }
      notifyUI(3, false, new Object[] { Integer.valueOf(-1), "", paramFromServiceMsg, paramObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList. rspBody.res.has nothing");
    }
    label266:
    label440:
    label572:
    label578:
    do
    {
      return;
      bool1 = false;
      break;
      bool2 = bool1;
      if (paramFromServiceMsg == null) {
        break label82;
      }
      QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
      bool2 = bool1;
      break label82;
      int m = localCmdRoomBatchForGroupRsp.res.errcode.get();
      if (localCmdRoomBatchForGroupRsp.res.errmsg.has()) {}
      int i;
      for (paramToServiceMsg = localCmdRoomBatchForGroupRsp.res.errmsg.get().toStringUtf8();; paramToServiceMsg = "")
      {
        List localList = localCmdRoomBatchForGroupRsp.room_infos.get();
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        i = 0;
        while (i < localList.size())
        {
          RoomInfo localRoomInfo = new RoomInfo();
          localRoomInfo.parseFrom((AvGameCommon.RoomInfo)localList.get(i));
          paramObject.add(localRoomInfo);
          i += 1;
        }
      }
      int j;
      if (localCmdRoomBatchForGroupRsp.total_room_num.has())
      {
        i = localCmdRoomBatchForGroupRsp.total_room_num.get();
        if (!localCmdRoomBatchForGroupRsp.next.has()) {
          break label566;
        }
        j = localCmdRoomBatchForGroupRsp.next.get();
        if (!localCmdRoomBatchForGroupRsp.is_end.has()) {
          break label572;
        }
      }
      for (int k = localCmdRoomBatchForGroupRsp.is_end.get();; k = 0)
      {
        notifyUI(3, true, new Object[] { Integer.valueOf(m), paramToServiceMsg, paramFromServiceMsg, paramObject, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList.get gameRoomList retcode" + m + " gameRoomList size" + paramObject.size());
        return;
        i = 0;
        break;
        j = 0;
        break label440;
      }
      notifyUI(3, false, new Object[] { Integer.valueOf(-1), "", paramFromServiceMsg, paramObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    } while (!QLog.isColorLevel());
    label566:
    QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList fail");
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameShare.CmdGetShareLinkRsp localCmdGetShareLinkRsp = new AvGameShare.CmdGetShareLinkRsp();
    boolean bool1;
    long l;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      l = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      QLog.d("AvGameRoomListHandler", 1, "handleGameShare. isSuccess = " + bool1);
      if (!bool1) {
        break label180;
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
        QLog.e("AvGameRoomListHandler", 1, "handleGameShare.  false result：" + paramToServiceMsg.toString());
        bool2 = false;
        continue;
      }
      if (!bool2) {
        break label294;
      }
      if (localCmdGetShareLinkRsp.share_url.has()) {
        break label224;
      }
      notifyUI(6, false, new Object[] { "", Long.valueOf(l) });
      QLog.e("AvGameRoomListHandler", 1, "handleGameShare. rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label180:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label224:
    paramToServiceMsg = localCmdGetShareLinkRsp.share_url.get();
    notifyUI(6, true, new Object[] { paramToServiceMsg, Long.valueOf(l) });
    QLog.d("AvGameRoomListHandler", 1, "handleGameShare.get shareUrl:" + paramToServiceMsg + " mark: " + l);
    return;
    label294:
    notifyUI(6, false, new Object[] { "", Long.valueOf(l) });
    QLog.e("AvGameRoomListHandler", 1, "handleGameShare fail");
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameShare.CmdInviteCheckRsp localCmdInviteCheckRsp = new AvGameShare.CmdInviteCheckRsp();
    boolean bool;
    long l2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      l2 = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      QLog.d("AvGameRoomListHandler", 1, "handleShareInviteBackflow. isSuccess = " + bool);
      if (!bool) {
        break label243;
      }
    }
    for (;;)
    {
      try
      {
        localCmdInviteCheckRsp.mergeFrom((byte[])paramObject);
        if (!bool) {
          break label398;
        }
        if (!localCmdInviteCheckRsp.share_type.has()) {
          break label448;
        }
        l1 = localCmdInviteCheckRsp.share_type.get();
        if ((l1 == 3L) || ((localCmdInviteCheckRsp.roomid.has()) && (localCmdInviteCheckRsp.share_uin.has()))) {
          break label279;
        }
        i = 1;
        if (i == 0) {
          break label285;
        }
        notifyUI(7, false, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(l2), Long.valueOf(l1) });
        QLog.e("AvGameRoomListHandler", 1, "handleShareInviteBackflow. rspBody.res.has nothing");
        return;
        bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("AvGameRoomListHandler", 1, "handleShareInviteBackflow.  false result：" + paramToServiceMsg.toString());
        bool = false;
        continue;
      }
      label243:
      if (paramFromServiceMsg != null) {
        QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
      }
      continue;
      label279:
      int i = 0;
      continue;
      label285:
      long l3 = localCmdInviteCheckRsp.roomid.get();
      long l4 = localCmdInviteCheckRsp.share_uin.get();
      notifyUI(7, true, new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1) });
      QLog.d("AvGameRoomListHandler", 1, "handleShareInviteBackflow.get roomId:" + l3 + " shareUin: " + l4 + " mark: " + l2);
      return;
      label398:
      notifyUI(7, false, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(l2), Long.valueOf(0L) });
      QLog.e("AvGameRoomListHandler", 1, "handleShareInviteBackflow fail");
      return;
      label448:
      long l1 = 0L;
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameRoomManager.CmdRoomDestroyRsp localCmdRoomDestroyRsp = new AvGameRoomManager.CmdRoomDestroyRsp();
    boolean bool1;
    boolean bool2;
    label82:
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleDestroyAllGameRoom. isSuccess = " + bool1);
      }
      if (!bool1) {}
    }
    else
    {
      try
      {
        localCmdRoomDestroyRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          QLog.e("AvGameRoomListHandler", 2, "handleDestroyAllGameRoom.  false result：" + paramFromServiceMsg.toString());
          bool2 = false;
        }
      }
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("troop_uin_extra_tag");
      paramToServiceMsg = "";
      if ((!bool2) || (!localCmdRoomDestroyRsp.res.has())) {
        break label274;
      }
      i = localCmdRoomDestroyRsp.res.errcode.get();
      if (!localCmdRoomDestroyRsp.res.errmsg.has()) {
        break label268;
      }
      paramToServiceMsg = localCmdRoomDestroyRsp.res.errmsg.get().toStringUtf8();
    }
    for (;;)
    {
      notifyUI(5, bool2, new Object[] { Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
      return;
      bool1 = false;
      break;
      bool2 = bool1;
      if (paramFromServiceMsg == null) {
        break label82;
      }
      QLog.e("AvGameRoomListHandler", 2, "ERRCODE:" + paramFromServiceMsg.getResultCode());
      bool2 = bool1;
      break label82;
      label268:
      paramToServiceMsg = "";
      continue;
      label274:
      i = 0;
    }
  }
  
  protected void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    int j;
    int i;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleStartStrangerMatch. isSuccess = " + bool + " " + l);
      }
      if (!bool) {
        break label333;
      }
      paramFromServiceMsg = new AvGameStrangerMatch.AddMatchUserRsp();
      j = -1;
      i = j;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = j;
        j = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        i = j;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("AvGameRoomListHandler", 2, "handleStartStrangerMatch.  false result：" + paramToServiceMsg);
          bool = false;
          paramToServiceMsg = null;
          j = i;
        }
        notifyUI(8, false, new Object[] { Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(j), paramToServiceMsg });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleStartStrangerMatch() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg }));
      }
      if ((!bool) || (j != 0)) {
        break;
      }
      notifyUI(8, true, new Object[] { Long.valueOf(l), Integer.valueOf(paramFromServiceMsg.shard_id.get()), Integer.valueOf(j), paramToServiceMsg });
      return;
    }
    label333:
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
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    int j;
    int i;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleStopStrangerMatch. isSuccess = " + bool + " " + l);
      }
      if (!bool) {
        break label313;
      }
      paramToServiceMsg = new AvGameStrangerMatch.DelMatchUserRsp();
      j = -1;
      i = j;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = j;
        j = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errcode.get();
        i = j;
        paramToServiceMsg = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errmsg.get().toStringUtf8();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("AvGameRoomListHandler", 2, "handleStopStrangerMatch.  false result：" + paramToServiceMsg);
          bool = false;
          paramToServiceMsg = null;
          j = i;
        }
        notifyUI(9, false, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleStopStrangerMatch() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg }));
      }
      if ((!bool) || (j != 0)) {
        break;
      }
      notifyUI(9, true, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg });
      return;
    }
    label313:
    notifyUI(9, false, new Object[] { Long.valueOf(l), Integer.valueOf(-1), null });
  }
  
  protected void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    Object localObject2 = paramToServiceMsg.extraData.getString("version");
    boolean bool;
    Object localObject1;
    int i;
    int j;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleGetGameLobbyInfo. isSuccess = " + bool + " " + l);
      }
      if (bool)
      {
        localObject1 = new AvGameLobbyInfo.CmdGetGameLobbyInfoRsp();
        i = 0;
        j = i;
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).mergeFrom((byte[])paramObject);
          j = i;
          if (!((AvGameCommon.Result)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).res.get()).errcode.has()) {
            continue;
          }
          j = i;
          i = ((AvGameCommon.Result)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).res.get()).errcode.get();
          j = i;
          if (!((AvGameCommon.Result)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).res.get()).errmsg.has()) {
            continue;
          }
          j = i;
          paramToServiceMsg = ((AvGameCommon.Result)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).res.get()).errmsg.get().toStringUtf8();
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          ArrayList localArrayList1;
          ArrayList localArrayList2;
          ArrayList localArrayList3;
          ArrayList localArrayList4;
          AVGameRoomCenterFragment.BannerInfo localBannerInfo;
          QLog.e("AvGameRoomListHandler", 2, "handleGetGameLobbyInfo.  false result：" + paramToServiceMsg);
          paramToServiceMsg = null;
          i = j;
          continue;
          paramFromServiceMsg = "";
          continue;
          paramFromServiceMsg = "";
          continue;
          if ((localObject2 == null) || (!((String)localObject2).equals("8.4.17"))) {
            continue;
          }
          if (!((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).operate_activity_info.has()) {
            continue;
          }
          localObject2 = ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).operate_activity_info.get();
          j = 0;
          if (j >= ((List)localObject2).size()) {
            continue;
          }
          if (!((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).pk_id.has()) {
            continue;
          }
          int k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).pk_id.get();
          if (k <= 0) {
            continue;
          }
          localArrayList2.add(a((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)));
          j += 1;
          continue;
          k = 0;
          continue;
          Object localObject3 = new AVGameLobbyCommonContentInfo(8);
          ((AVGameLobbyCommonContentInfo)localObject3).jdField_a_of_type_Int = k;
          if (!((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).title_url.has()) {
            continue;
          }
          paramFromServiceMsg = ((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).title_url.get();
          ((AVGameLobbyCommonContentInfo)localObject3).jdField_a_of_type_JavaLangString = paramFromServiceMsg;
          if (!((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).backgroud_url.has()) {
            continue;
          }
          paramFromServiceMsg = ((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).backgroud_url.get();
          ((AVGameLobbyCommonContentInfo)localObject3).jdField_b_of_type_JavaLangString = paramFromServiceMsg;
          if (!((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).game_type.has()) {
            continue;
          }
          k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).game_type.get();
          ((AVGameLobbyCommonContentInfo)localObject3).e = k;
          if (!((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).play_user_num.has()) {
            continue;
          }
          k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).play_user_num.get();
          ((AVGameLobbyCommonContentInfo)localObject3).jdField_b_of_type_Int = k;
          if (!((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).wording.has()) {
            continue;
          }
          paramFromServiceMsg = ((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).wording.get();
          ((AVGameLobbyCommonContentInfo)localObject3).jdField_c_of_type_JavaLangString = paramFromServiceMsg;
          if (!((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).color_start.has()) {
            continue;
          }
          k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).color_start.get();
          ((AVGameLobbyCommonContentInfo)localObject3).jdField_c_of_type_Int = k;
          if (!((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).color_end.has()) {
            continue;
          }
          k = ((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).color_end.get();
          ((AVGameLobbyCommonContentInfo)localObject3).d = k;
          if (!((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).player_list.has()) {
            continue;
          }
          k = 0;
          if (k >= ((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).player_list.get().size()) {
            continue;
          }
          paramFromServiceMsg = (AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.PKCardInfo)((List)localObject2).get(j)).player_list.get().get(k);
          if ((!paramFromServiceMsg.has()) || (!((AvGameLobbyInfo.PlayerInfo)paramFromServiceMsg.get()).uid.has())) {
            continue;
          }
          ((AVGameLobbyCommonContentInfo)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((AvGameLobbyInfo.PlayerInfo)paramFromServiceMsg.get()).uid.get()));
          k += 1;
          continue;
          paramFromServiceMsg = "";
          continue;
          paramFromServiceMsg = "";
          continue;
          k = 0;
          continue;
          k = 0;
          continue;
          paramFromServiceMsg = "";
          continue;
          k = 0;
          continue;
          k = 0;
          continue;
          localArrayList3.add(localObject3);
          continue;
          if (!((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).random_match_info_by_type.has()) {
            continue;
          }
          localObject1 = ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).random_match_info_by_type.get();
          j = 0;
          if (j >= ((List)localObject1).size()) {
            continue;
          }
          localObject2 = new AVGameLobbyRandomMatchContentInfo(9);
          if (!((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).title_url.has()) {
            continue;
          }
          paramFromServiceMsg = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).title_url.get();
          ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_a_of_type_JavaLangString = paramFromServiceMsg;
          if (!((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).backgroud_url.has()) {
            continue;
          }
          paramFromServiceMsg = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).backgroud_url.get();
          ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_b_of_type_JavaLangString = paramFromServiceMsg;
          if (!((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).game_type.has()) {
            continue;
          }
          k = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).game_type.get();
          ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_b_of_type_Int = k;
          if (!((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).players_num.has()) {
            continue;
          }
          k = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).players_num.get();
          ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_a_of_type_Int = k;
          if (!((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).wording.has()) {
            continue;
          }
          paramFromServiceMsg = ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).wording.get();
          ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_c_of_type_JavaLangString = paramFromServiceMsg;
          ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_c_of_type_Int = j;
          if (!((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).player_list.has()) {
            continue;
          }
          k = 0;
          if (k >= ((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).player_list.get().size()) {
            continue;
          }
          paramFromServiceMsg = (AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.RandomMatchInfo)((List)localObject1).get(j)).player_list.get().get(k);
          if ((!paramFromServiceMsg.has()) || (!((AvGameLobbyInfo.PlayerInfo)paramFromServiceMsg.get()).uid.has())) {
            continue;
          }
          ((AVGameLobbyRandomMatchContentInfo)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((AvGameLobbyInfo.PlayerInfo)paramFromServiceMsg.get()).uid.get()));
          k += 1;
          continue;
          paramFromServiceMsg = "";
          continue;
          paramFromServiceMsg = "";
          continue;
          k = 0;
          continue;
          k = 0;
          continue;
          paramFromServiceMsg = "";
          continue;
          localArrayList4.add(localObject2);
          j += 1;
          continue;
          if (!((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).random_match_info.has()) {
            continue;
          }
          paramFromServiceMsg = (AvGameLobbyInfo.RandomMatchInfo)((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).random_match_info.get();
          if (!paramFromServiceMsg.players_num.has()) {
            continue;
          }
          j = paramFromServiceMsg.players_num.get();
          paramObject.jdField_a_of_type_Int = j;
          if (!paramFromServiceMsg.player_list.has()) {
            continue;
          }
          j = 0;
          if (j >= paramFromServiceMsg.player_list.get().size()) {
            continue;
          }
          localObject2 = (AvGameLobbyInfo.PlayerInfo)paramFromServiceMsg.player_list.get().get(j);
          if ((!((AvGameLobbyInfo.PlayerInfo)localObject2).has()) || (!((AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.PlayerInfo)localObject2).get()).uid.has())) {
            continue;
          }
          paramObject.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((AvGameLobbyInfo.PlayerInfo)((AvGameLobbyInfo.PlayerInfo)localObject2).get()).uid.get()));
          j += 1;
          continue;
          j = 0;
          continue;
          if (!((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).pk_list.has()) {
            continue;
          }
          paramFromServiceMsg = ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).pk_list.get();
          j = 0;
          if (j >= paramFromServiceMsg.size()) {
            continue;
          }
          localArrayList2.add(a((AvGameLobbyInfo.PKCardInfo)paramFromServiceMsg.get(j)));
          j += 1;
          continue;
          notifyUI(10, true, new Object[] { Long.valueOf(l), localArrayList1, paramObject, localArrayList2, localArrayList3, localArrayList4, Integer.valueOf(i), paramToServiceMsg });
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AvGameRoomListHandler", 2, String.format("handleGetGameLobbyInfo() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg }));
        }
        GameUtil.a("AvGameRoomListHandler", null, null, new MessageMicro[] { localObject1 });
        if (i != 0) {
          break label1991;
        }
        paramObject = new AVGameRoomCenterFragment.RandomMatchInfo();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        localArrayList4 = new ArrayList();
        if (!((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).banner_list.has()) {
          continue;
        }
        localObject3 = ((AvGameLobbyInfo.CmdGetGameLobbyInfoRsp)localObject1).banner_list.get();
        j = 0;
        if (j >= ((List)localObject3).size()) {
          continue;
        }
        localBannerInfo = new AVGameRoomCenterFragment.BannerInfo();
        if (!((AvGameLobbyInfo.BannerInfo)((List)localObject3).get(j)).picture_url.has()) {
          continue;
        }
        paramFromServiceMsg = ((AvGameLobbyInfo.BannerInfo)((List)localObject3).get(j)).picture_url.get();
        localBannerInfo.jdField_a_of_type_JavaLangString = paramFromServiceMsg;
        if (!((AvGameLobbyInfo.BannerInfo)((List)localObject3).get(j)).skip_url.has()) {
          continue;
        }
        paramFromServiceMsg = ((AvGameLobbyInfo.BannerInfo)((List)localObject3).get(j)).skip_url.get();
        localBannerInfo.jdField_b_of_type_JavaLangString = paramFromServiceMsg;
        localArrayList1.add(localBannerInfo);
        j += 1;
        continue;
        bool = false;
        break;
        i = 0;
        continue;
        paramToServiceMsg = "";
      }
      label1991:
      notifyUI(10, false, new Object[] { Long.valueOf(l), null, null, null, null, null, Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    notifyUI(10, false, new Object[] { Long.valueOf(l), null, null, null, null, null, Integer.valueOf(-1), null });
  }
  
  protected void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = paramToServiceMsg.extraData.getInt("pkId");
    boolean bool;
    int i;
    int j;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleReservePKGame. isSuccess = " + bool + " pkId = " + k);
      }
      if (bool)
      {
        paramToServiceMsg = new AvGameLobbyPKReserve.ReserveRsp();
        i = 0;
        j = i;
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          j = i;
          if (!((AvGameCommon.Result)paramToServiceMsg.res.get()).errcode.has()) {
            continue;
          }
          j = i;
          i = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errcode.get();
          j = i;
          if (!((AvGameCommon.Result)paramToServiceMsg.res.get()).errmsg.has()) {
            continue;
          }
          j = i;
          paramToServiceMsg = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errmsg.get().toStringUtf8();
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          QLog.e("AvGameRoomListHandler", 2, "handleReservePKGame.  false result：" + paramToServiceMsg);
          bool = false;
          i = j;
          paramToServiceMsg = null;
          continue;
          notifyUI(12, false, new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramToServiceMsg });
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AvGameRoomListHandler", 2, String.format("handleReservePKGame() pkId=%d errCode=%d errMsg=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramToServiceMsg }));
        }
        if ((!bool) || (i != 0)) {
          continue;
        }
        notifyUI(12, true, new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramToServiceMsg });
        return;
        bool = false;
        break;
        i = 0;
        continue;
        paramToServiceMsg = "";
      }
    }
    notifyUI(12, false, new Object[] { Integer.valueOf(k), Integer.valueOf(-1), null });
  }
  
  protected void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    int k = paramToServiceMsg.extraData.getInt("gameType");
    int m = paramToServiceMsg.extraData.getInt("from");
    boolean bool;
    AvGameStrangerMatchV2.AddMatchUserRsp localAddMatchUserRsp;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleStartStrangerMatchV2. isSuccess = " + bool + " " + l + " " + k + " " + m);
      }
      if (bool)
      {
        localAddMatchUserRsp = new AvGameStrangerMatchV2.AddMatchUserRsp();
        j = -1;
        i = j;
      }
    }
    else
    {
      try
      {
        localAddMatchUserRsp.mergeFrom((byte[])paramObject);
        i = j;
        j = ((AvGameCommon.Result)localAddMatchUserRsp.res.get()).errcode.get();
        i = j;
        paramToServiceMsg = ((AvGameCommon.Result)localAddMatchUserRsp.res.get()).errmsg.get().toStringUtf8();
        i = j;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("AvGameRoomListHandler", 2, "handleStartStrangerMatchV2.  false result：" + paramToServiceMsg);
          bool = false;
          paramToServiceMsg = null;
          continue;
          paramFromServiceMsg = null;
        }
        notifyUI(15, false, new Object[] { Long.valueOf(l), null, Integer.valueOf(k), Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleStartStrangerMatchV2() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), paramToServiceMsg }));
      }
      if ((bool) && (i == 0)) {
        if (localAddMatchUserRsp.extra_info.has())
        {
          paramFromServiceMsg = localAddMatchUserRsp.extra_info.get().toByteArray();
          if (m != 0) {
            break label473;
          }
        }
      }
    }
    label473:
    for (int j = localAddMatchUserRsp.game_type.get();; j = k)
    {
      notifyUI(15, true, new Object[] { Long.valueOf(l), paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(i), paramToServiceMsg });
      return;
      bool = false;
      break;
      notifyUI(15, false, new Object[] { Long.valueOf(l), null, Integer.valueOf(k), Integer.valueOf(-1), null });
      return;
    }
  }
  
  protected void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    int i = paramToServiceMsg.extraData.getInt("from");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleStopStrangerMatchV2. isSuccess = " + bool + " " + l + " " + i);
      }
      if (!bool) {
        break label336;
      }
      paramToServiceMsg = new AvGameStrangerMatchV2.DelMatchUserRsp();
      j = -1;
      i = j;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = j;
        j = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errcode.get();
        i = j;
        paramToServiceMsg = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errmsg.get().toStringUtf8();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("AvGameRoomListHandler", 2, "handleStopStrangerMatchV2.  false result：" + paramToServiceMsg);
          bool = false;
          paramToServiceMsg = null;
          j = i;
        }
        notifyUI(16, false, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, String.format("handleStopStrangerMatchV2() uin=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg }));
      }
      if ((!bool) || (j != 0)) {
        break;
      }
      notifyUI(16, true, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg });
      return;
    }
    label336:
    notifyUI(16, false, new Object[] { Long.valueOf(l), Integer.valueOf(-1), null });
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return AvGameRoomListObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
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
    } while (!"qqvgame.StrangerMatchV2-DelMatchUser".equals(paramFromServiceMsg.getServiceCmd()));
    l(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.business.handler.AvGameRoomListHandler
 * JD-Core Version:    0.7.0.1
 */