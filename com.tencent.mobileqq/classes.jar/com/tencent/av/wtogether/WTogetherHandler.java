package com.tencent.av.wtogether;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.data.ReqComResult;
import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTReqUrlResult;
import com.tencent.av.wtogether.data.WTSyncPlayInfo;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.oidb.cmd0xe37.cmd0xe37.Req0xe37;
import tencent.im.oidb.cmd0xe37.cmd0xe37.Resp0xe37;
import trpc.qq_av_together.common.WTogetherCommon.Result;
import trpc.qq_av_together.common.WTogetherCommon.RoomInfo;
import trpc.qq_av_together.common.WTogetherCommon.RoomUserInfo;
import trpc.qq_av_together.common.WTogetherCommon.VideoInfoReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdChangeVideoFileReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdChangeVideoFileRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdChangeVideoStatusReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdChangeVideoStatusRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdCloseAvTogetherReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdCloseAvTogetherRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdGetRoomInfoReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdGetRoomInfoRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdStartAvTogetherReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdStartAvTogetherRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdSyncPlayTimeReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdSyncPlayTimeRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserEnterRoomReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserEnterRoomRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserQuitRoomReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserQuitRoomRsp;

public class WTogetherHandler
  extends BusinessHandler
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "OidbSvc.0xe37_1200", "QQRTCSvc.RoomManager-StartAvTogether", "QQRTCSvc.RoomManager-CloseAvTogether", "QQRTCSvc.RoomManager-GetRoomInfo", "QQRTCSvc.RoomManager-ChangeVideoStatus", "QQRTCSvc.RoomManager-ChangeVideoFile", "QQRTCSvc.RoomManager-SyncPlayTime", "QQRTCSvc.RoomManager-UserQuitRoom", "QQRTCSvc.RoomManager-UserEnterRoom" };
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public WTogetherHandler(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    WTFileInfo localWTFileInfo = (WTFileInfo)paramToServiceMsg.extraData.getParcelable("fileInfo");
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    int j = paramToServiceMsg.extraData.getInt("seq");
    int k = paramToServiceMsg.extraData.getInt("retryCnt");
    boolean bool = paramToServiceMsg.extraData.getBoolean("needHttpsUrl");
    cmd0xe37.Resp0xe37 localResp0xe37 = new cmd0xe37.Resp0xe37();
    if ((paramObject instanceof byte[])) {
      parseOIDBPkg(paramFromServiceMsg, paramObject, localResp0xe37);
    }
    paramToServiceMsg = null;
    if (localResp0xe37.bytes_cmd_0x346_rsp_body.has()) {
      paramToServiceMsg = localResp0xe37.bytes_cmd_0x346_rsp_body.get().toByteArray();
    }
    paramObject = new WTReqUrlResult(i, l, j, localWTFileInfo, k, bool);
    WTogetherUtil.a(paramFromServiceMsg.getResultCode(), paramToServiceMsg, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), paramObject);
    if ((paramObject.b) && (k < 3) && (k >= 0))
    {
      a(i, l, j, localWTFileInfo, bool, k);
      return;
    }
    paramToServiceMsg = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
    if (paramToServiceMsg != null) {
      paramToServiceMsg.a(paramObject);
    }
    notifyUI(1, paramObject.c, paramObject);
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleRequestUrlRsp, result[");
      paramToServiceMsg.append(paramObject);
      paramToServiceMsg.append("]");
      QLog.i("WTogether.Handler", 4, paramToServiceMsg.toString());
    }
  }
  
  public static String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    ChooseFileInfo localChooseFileInfo = (ChooseFileInfo)paramToServiceMsg.extraData.getParcelable("qav_together_choose_file");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("qav_together_uin_array");
    ReqComResult localReqComResult = new ReqComResult(i, l);
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[])))
    {
      paramToServiceMsg = new WTogetherRoomMng.CmdStartAvTogetherRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleStartWTogether, error", paramFromServiceMsg);
        }
      }
      localReqComResult.a((WTogetherCommon.Result)paramToServiceMsg.res.get());
      if (paramToServiceMsg.room_info.has())
      {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramToServiceMsg.room_info.get();
        break label168;
      }
    }
    paramToServiceMsg = null;
    label168:
    paramFromServiceMsg = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
    if ((!localReqComResult.a) && (j < 3) && (j > 0) && (paramFromServiceMsg.a(localReqComResult, 0L, 6)))
    {
      a(i, l, localChooseFileInfo, arrayOfLong, j);
      return;
    }
    if ((localReqComResult.a) && (paramToServiceMsg == null))
    {
      localReqComResult.a = false;
      QLog.i("WTogether.Handler", 1, "handleStartWTogether, room info is null.");
    }
    paramFromServiceMsg.a(localReqComResult, localChooseFileInfo, paramToServiceMsg);
    notifyUI(2, localReqComResult.a, localReqComResult);
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleStartWTogether, result[");
      paramToServiceMsg.append(localReqComResult);
      paramToServiceMsg.append("]");
      QLog.i("WTogether.Handler", 4, paramToServiceMsg.toString());
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    paramToServiceMsg = new ReqComResult(i, l);
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[])))
    {
      paramFromServiceMsg = new WTogetherRoomMng.CmdCloseAvTogetherRsp();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleCloseWTogether, error", paramObject);
        }
      }
      paramToServiceMsg.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
    }
    if (paramToServiceMsg.jdField_b_of_type_Int == 1009) {
      paramToServiceMsg.a = true;
    }
    paramFromServiceMsg = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
    if ((!paramToServiceMsg.a) && (j < 3) && (j > 0) && (paramFromServiceMsg.a(paramToServiceMsg, 0L, 7)))
    {
      a(i, l, j);
      return;
    }
    paramFromServiceMsg.a(paramToServiceMsg);
    notifyUI(3, paramToServiceMsg.a, paramToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleCloseWTogether, result[");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append("]");
      QLog.i("WTogether.Handler", 4, paramFromServiceMsg.toString());
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ReqComResult localReqComResult = new ReqComResult(paramToServiceMsg.extraData.getInt("qav_together_from"), paramToServiceMsg.extraData.getLong("qav_together_room_id"), (ReqVideoAction)paramToServiceMsg.extraData.getParcelable("qav_together_action"));
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[])))
    {
      paramToServiceMsg = new WTogetherRoomMng.CmdGetRoomInfoRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleQueryRoomInfo, error", paramFromServiceMsg);
        }
      }
      localReqComResult.a((WTogetherCommon.Result)paramToServiceMsg.res.get());
      if (paramToServiceMsg.room_info.has())
      {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramToServiceMsg.room_info.get();
        break label138;
      }
    }
    paramToServiceMsg = null;
    label138:
    ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).a(localReqComResult, paramToServiceMsg);
    notifyUI(4, localReqComResult.a, localReqComResult);
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleQueryRoomInfo, result[");
      paramToServiceMsg.append(localReqComResult);
      paramToServiceMsg.append("]");
      QLog.i("WTogether.Handler", 4, paramToServiceMsg.toString());
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    ReqVideoAction localReqVideoAction = (ReqVideoAction)paramToServiceMsg.extraData.getParcelable("qav_together_action");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    ReqComResult localReqComResult = new ReqComResult(i, l, localReqVideoAction);
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[])))
    {
      paramToServiceMsg = new WTogetherRoomMng.CmdChangeVideoStatusRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleChangeVideoStatus, error", paramFromServiceMsg);
        }
      }
      localReqComResult.a((WTogetherCommon.Result)paramToServiceMsg.res.get());
      if (paramToServiceMsg.room_info.has())
      {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramToServiceMsg.room_info.get();
        break label161;
      }
    }
    paramToServiceMsg = null;
    label161:
    paramFromServiceMsg = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
    if ((!localReqComResult.a) && (j > 0) && (j < 3) && (localReqVideoAction != null) && (paramFromServiceMsg.a(localReqComResult, localReqVideoAction.jdField_a_of_type_Long, localReqVideoAction.jdField_a_of_type_Int)))
    {
      a(i, l, localReqVideoAction, j);
      return;
    }
    paramFromServiceMsg.a(localReqComResult, localReqVideoAction, paramToServiceMsg);
    notifyUI(5, localReqComResult.a, localReqComResult);
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleChangeVideoStatus, result[");
      paramToServiceMsg.append(localReqComResult);
      paramToServiceMsg.append("]");
      QLog.i("WTogether.Handler", 4, paramToServiceMsg.toString());
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    paramToServiceMsg.extraData.getLong("qav_together_seq");
    ChooseFileInfo localChooseFileInfo = (ChooseFileInfo)paramToServiceMsg.extraData.getParcelable("qav_together_choose_file");
    ReqComResult localReqComResult = new ReqComResult(i, l);
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[])))
    {
      paramToServiceMsg = new WTogetherRoomMng.CmdChangeVideoFileRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleChangeVideoFile, error", paramFromServiceMsg);
        }
      }
      localReqComResult.a((WTogetherCommon.Result)paramToServiceMsg.res.get());
      if (paramToServiceMsg.room_info.has())
      {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramToServiceMsg.room_info.get();
        break label158;
      }
    }
    paramToServiceMsg = null;
    label158:
    ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).b(localReqComResult, localChooseFileInfo, paramToServiceMsg);
    notifyUI(6, localReqComResult.a, localReqComResult);
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleChangeVideoFile, result[");
      paramToServiceMsg.append(localReqComResult);
      paramToServiceMsg.append("]");
      QLog.i("WTogether.Handler", 4, paramToServiceMsg.toString());
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l1 = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    long l2 = paramToServiceMsg.extraData.getLong("qav_together_seq");
    ReqComResult localReqComResult = new ReqComResult(i, l1);
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[])))
    {
      paramToServiceMsg = new WTogetherRoomMng.CmdSyncPlayTimeRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleSyncPlayInfo, error", paramFromServiceMsg);
        }
      }
      localReqComResult.a((WTogetherCommon.Result)paramToServiceMsg.res.get());
      if (paramToServiceMsg.room_info.has())
      {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramToServiceMsg.room_info.get();
        break label145;
      }
    }
    paramToServiceMsg = null;
    label145:
    ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).a(localReqComResult, l2, paramToServiceMsg);
    notifyUI(7, localReqComResult.a, localReqComResult);
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleSyncPlayInfo, result[");
      paramToServiceMsg.append(localReqComResult);
      paramToServiceMsg.append("]");
      QLog.i("WTogether.Handler", 4, paramToServiceMsg.toString());
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    paramToServiceMsg = new ReqComResult(i, l);
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[])))
    {
      paramFromServiceMsg = new WTogetherRoomMng.CmdUserQuitRoomRsp();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleQuitRoom, error", paramObject);
        }
      }
      paramToServiceMsg.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
      if (paramFromServiceMsg.room_info.has()) {
        paramFromServiceMsg = (WTogetherCommon.RoomInfo)paramFromServiceMsg.room_info.get();
      }
    }
    if (paramToServiceMsg.jdField_b_of_type_Int == 1009) {
      paramToServiceMsg.a = true;
    }
    paramFromServiceMsg = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
    if ((!paramToServiceMsg.a) && (j < 3) && (j > 0) && (paramFromServiceMsg.a(paramToServiceMsg, 0L, 10)))
    {
      b(i, l, j);
      return;
    }
    paramFromServiceMsg.b(paramToServiceMsg);
    notifyUI(8, paramToServiceMsg.a, paramToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleQuitRoom, result[");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append("]");
      QLog.i("WTogether.Handler", 4, paramFromServiceMsg.toString());
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    ReqComResult localReqComResult = new ReqComResult(i, l);
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[])))
    {
      paramToServiceMsg = new WTogetherRoomMng.CmdUserEnterRoomRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleEnterRoom, error", paramFromServiceMsg);
        }
      }
      localReqComResult.a((WTogetherCommon.Result)paramToServiceMsg.res.get());
      if (paramToServiceMsg.room_info.has())
      {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramToServiceMsg.room_info.get();
        break label144;
      }
    }
    paramToServiceMsg = null;
    label144:
    paramFromServiceMsg = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
    if ((!localReqComResult.a) && (j < 3) && (j > 0) && (paramFromServiceMsg.a(localReqComResult, 0L, 9)))
    {
      c(i, l, j);
      return;
    }
    paramFromServiceMsg.b(localReqComResult, paramToServiceMsg);
    notifyUI(9, localReqComResult.a, localReqComResult);
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleEnterRoom, result[");
      paramToServiceMsg.append(localReqComResult);
      paramToServiceMsg.append("], tryCnt[");
      paramToServiceMsg.append(j);
      paramToServiceMsg.append("]");
      QLog.i("WTogether.Handler", 4, paramToServiceMsg.toString());
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = new WTogetherRoomMng.CmdCloseAvTogetherReq();
    ((WTogetherRoomMng.CmdCloseAvTogetherReq)localObject).from.set(paramInt1);
    ((WTogetherRoomMng.CmdCloseAvTogetherReq)localObject).room_id.set(paramLong);
    ((WTogetherRoomMng.CmdCloseAvTogetherReq)localObject).client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-CloseAvTogether");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt1);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putInt("qav_together_try_count", paramInt2 + 1);
    localToServiceMsg.putWupBuffer(((WTogetherRoomMng.CmdCloseAvTogetherReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("closeWTogether, from[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], room[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], tryCnt[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Handler", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, WTFileInfo paramWTFileInfo, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("requestUrl, seq[");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("], from[");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("], roomId[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("], fileInfo[");
      ((StringBuilder)localObject1).append(paramWTFileInfo);
      ((StringBuilder)localObject1).append("], needHttpsUrl[");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("], retryCnt[");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append("]");
      QLog.i("WTogether.Handler", 4, ((StringBuilder)localObject1).toString());
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      label153:
      Object localObject2;
      break label153;
    }
    localObject2 = new cmd0x346.ApplyDownloadReq();
    ((cmd0x346.ApplyDownloadReq)localObject2).uint64_uin.set(l1);
    ((cmd0x346.ApplyDownloadReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramWTFileInfo.b.getBytes()));
    if (paramBoolean) {
      ((cmd0x346.ApplyDownloadReq)localObject2).uint32_need_https_url.set(1);
    }
    if (!TextUtils.isEmpty(paramWTFileInfo.c)) {
      ((cmd0x346.ApplyDownloadReq)localObject2).str_fileid.set(paramWTFileInfo.c);
    }
    ((cmd0x346.ApplyDownloadReq)localObject2).uint32_owner_type.set(2);
    Object localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).uint32_flag_support_mediaplatform.set(1);
    ((cmd0x346.ReqBody)localObject1).msg_apply_download_req.set((MessageMicro)localObject2);
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(1200);
    ((cmd0x346.ReqBody)localObject1).uint32_seq.set(paramInt2);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(4201);
    ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
    localObject2 = new cmd0x346.ExtensionReq();
    ((cmd0x346.ExtensionReq)localObject2).uint32_download_url_type.set(1);
    ((cmd0x346.ReqBody)localObject1).msg_extension_req.set((MessageMicro)localObject2);
    localObject2 = new cmd0xe37.Req0xe37();
    ((cmd0xe37.Req0xe37)localObject2).bytes_cmd_0x346_req_body.set(ByteStringMicro.copyFrom(((cmd0x346.ReqBody)localObject1).toByteArray()));
    localObject1 = makeOIDBPkg("OidbSvc.0xe37_1200", 3639, 1200, ((cmd0xe37.Req0xe37)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("qav_together_from", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putLong("qav_together_room_id", paramLong);
    ((ToServiceMsg)localObject1).extraData.putInt("seq", paramInt2);
    ((ToServiceMsg)localObject1).extraData.putInt("retryCnt", paramInt3 + 1);
    ((ToServiceMsg)localObject1).extraData.putBoolean("needHttpsUrl", paramBoolean);
    ((ToServiceMsg)localObject1).extraData.putParcelable("fileInfo", paramWTFileInfo);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, ChooseFileInfo paramChooseFileInfo)
  {
    Object localObject = new WTogetherRoomMng.CmdChangeVideoFileReq();
    ((WTogetherRoomMng.CmdChangeVideoFileReq)localObject).from.set(paramInt);
    ((WTogetherRoomMng.CmdChangeVideoFileReq)localObject).seq.set(paramLong2);
    ((WTogetherRoomMng.CmdChangeVideoFileReq)localObject).room_id.set(paramLong1);
    ((WTogetherRoomMng.CmdChangeVideoFileReq)localObject).video_info_req.set(paramChooseFileInfo.a());
    ((WTogetherRoomMng.CmdChangeVideoFileReq)localObject).client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-ChangeVideoFile");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong1);
    localToServiceMsg.extraData.putLong("qav_together_seq", paramLong2);
    localToServiceMsg.extraData.putParcelable("qav_together_choose_file", paramChooseFileInfo);
    localToServiceMsg.putWupBuffer(((WTogetherRoomMng.CmdChangeVideoFileReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeVideoFile, from[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], room[");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("], file[");
      ((StringBuilder)localObject).append(paramChooseFileInfo);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Handler", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, WTSyncPlayInfo paramWTSyncPlayInfo)
  {
    if (paramWTSyncPlayInfo == null) {
      return;
    }
    Object localObject = new WTogetherRoomMng.CmdSyncPlayTimeReq();
    ((WTogetherRoomMng.CmdSyncPlayTimeReq)localObject).from.set(paramInt);
    ((WTogetherRoomMng.CmdSyncPlayTimeReq)localObject).room_id.set(paramLong1);
    ((WTogetherRoomMng.CmdSyncPlayTimeReq)localObject).seq.set(paramLong2);
    ((WTogetherRoomMng.CmdSyncPlayTimeReq)localObject).video_status.set(paramWTSyncPlayInfo.a());
    ((WTogetherRoomMng.CmdSyncPlayTimeReq)localObject).cur_play_time.set(paramWTSyncPlayInfo.a());
    ((WTogetherRoomMng.CmdSyncPlayTimeReq)localObject).cur_play_rate.set((int)(paramWTSyncPlayInfo.a() * 100.0F));
    ((WTogetherRoomMng.CmdSyncPlayTimeReq)localObject).client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-SyncPlayTime");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong1);
    localToServiceMsg.extraData.putLong("qav_together_seq", paramLong2);
    localToServiceMsg.putWupBuffer(((WTogetherRoomMng.CmdSyncPlayTimeReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("syncPlayInfo, from[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], room[");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("], playStateInfo[");
      ((StringBuilder)localObject).append(paramWTSyncPlayInfo);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Handler", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt1, long paramLong, ChooseFileInfo paramChooseFileInfo, long[] paramArrayOfLong, int paramInt2)
  {
    if (paramChooseFileInfo == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    WTogetherRoomMng.CmdStartAvTogetherReq localCmdStartAvTogetherReq = new WTogetherRoomMng.CmdStartAvTogetherReq();
    localCmdStartAvTogetherReq.from.set(paramInt1);
    localCmdStartAvTogetherReq.creator_uin.set(AVUtil.a((String)localObject));
    localCmdStartAvTogetherReq.room_id.set(paramLong);
    localCmdStartAvTogetherReq.client_type.set(104);
    WTogetherCommon.RoomUserInfo localRoomUserInfo = new WTogetherCommon.RoomUserInfo();
    localRoomUserInfo.role.set(1);
    localRoomUserInfo.uin.set(AVUtil.a((String)localObject));
    localCmdStartAvTogetherReq.users.add(localRoomUserInfo);
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = paramArrayOfLong[i];
        localObject = new WTogetherCommon.RoomUserInfo();
        ((WTogetherCommon.RoomUserInfo)localObject).role.set(0);
        ((WTogetherCommon.RoomUserInfo)localObject).uin.set(l);
        localCmdStartAvTogetherReq.users.add((MessageMicro)localObject);
        i += 1;
      }
    }
    localCmdStartAvTogetherReq.video_info_req.set(paramChooseFileInfo.a());
    localCmdStartAvTogetherReq.client_type.set(104);
    localObject = createToServiceMsg("QQRTCSvc.RoomManager-StartAvTogether");
    ((ToServiceMsg)localObject).extraData.putInt("qav_together_from", paramInt1);
    ((ToServiceMsg)localObject).extraData.putLong("qav_together_room_id", paramLong);
    ((ToServiceMsg)localObject).extraData.putParcelable("qav_together_choose_file", paramChooseFileInfo);
    ((ToServiceMsg)localObject).extraData.putInt("qav_together_try_count", paramInt2 + 1);
    ((ToServiceMsg)localObject).extraData.putLongArray("qav_together_uin_array", paramArrayOfLong);
    ((ToServiceMsg)localObject).putWupBuffer(localCmdStartAvTogetherReq.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isDevelopLevel())
    {
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("startWTogether, from[");
      paramArrayOfLong.append(paramInt1);
      paramArrayOfLong.append("], room[");
      paramArrayOfLong.append(paramLong);
      paramArrayOfLong.append("], chooseFile[");
      paramArrayOfLong.append(paramChooseFileInfo);
      paramArrayOfLong.append("]");
      QLog.i("WTogether.Handler", 4, paramArrayOfLong.toString());
    }
  }
  
  public void a(int paramInt, long paramLong, ReqVideoAction paramReqVideoAction)
  {
    WTogetherRoomMng.CmdGetRoomInfoReq localCmdGetRoomInfoReq = new WTogetherRoomMng.CmdGetRoomInfoReq();
    localCmdGetRoomInfoReq.from.set(paramInt);
    localCmdGetRoomInfoReq.room_id.set(paramLong);
    localCmdGetRoomInfoReq.client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-GetRoomInfo");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putParcelable("qav_together_action", paramReqVideoAction);
    localToServiceMsg.putWupBuffer(localCmdGetRoomInfoReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      paramReqVideoAction = new StringBuilder();
      paramReqVideoAction.append("queryRoomInfo, from[");
      paramReqVideoAction.append(paramInt);
      paramReqVideoAction.append("], room[");
      paramReqVideoAction.append(paramLong);
      paramReqVideoAction.append("]");
      QLog.i("WTogether.Handler", 4, paramReqVideoAction.toString());
    }
  }
  
  public void a(int paramInt1, long paramLong, ReqVideoAction paramReqVideoAction, int paramInt2)
  {
    Object localObject = new WTogetherRoomMng.CmdChangeVideoStatusReq();
    ((WTogetherRoomMng.CmdChangeVideoStatusReq)localObject).from.set(paramInt1);
    ((WTogetherRoomMng.CmdChangeVideoStatusReq)localObject).room_id.set(paramLong);
    ((WTogetherRoomMng.CmdChangeVideoStatusReq)localObject).seq.set(paramReqVideoAction.jdField_a_of_type_Long);
    ((WTogetherRoomMng.CmdChangeVideoStatusReq)localObject).video_action.set(paramReqVideoAction.jdField_a_of_type_Int);
    ((WTogetherRoomMng.CmdChangeVideoStatusReq)localObject).cur_play_time.set(paramReqVideoAction.jdField_b_of_type_Long);
    ((WTogetherRoomMng.CmdChangeVideoStatusReq)localObject).cur_play_rate.set((int)(paramReqVideoAction.jdField_a_of_type_Float * 100.0F));
    ((WTogetherRoomMng.CmdChangeVideoStatusReq)localObject).video_status.set(paramReqVideoAction.jdField_b_of_type_Int);
    ((WTogetherRoomMng.CmdChangeVideoStatusReq)localObject).client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-ChangeVideoStatus");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt1);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putParcelable("qav_together_action", paramReqVideoAction);
    localToServiceMsg.extraData.putInt("qav_together_try_count", paramInt2 + 1);
    localToServiceMsg.putWupBuffer(((WTogetherRoomMng.CmdChangeVideoStatusReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeVideoStatus, from[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], room[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], action[");
      ((StringBuilder)localObject).append(paramReqVideoAction);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Handler", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = new WTogetherRoomMng.CmdUserQuitRoomReq();
    ((WTogetherRoomMng.CmdUserQuitRoomReq)localObject).from.set(paramInt1);
    ((WTogetherRoomMng.CmdUserQuitRoomReq)localObject).room_id.set(paramLong);
    ((WTogetherRoomMng.CmdUserQuitRoomReq)localObject).client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-UserQuitRoom");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt1);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putInt("qav_together_try_count", paramInt2 + 1);
    localToServiceMsg.putWupBuffer(((WTogetherRoomMng.CmdUserQuitRoomReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("quitRoom, from[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], room[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Handler", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = new WTogetherRoomMng.CmdUserEnterRoomReq();
    ((WTogetherRoomMng.CmdUserEnterRoomReq)localObject).from.set(paramInt1);
    ((WTogetherRoomMng.CmdUserEnterRoomReq)localObject).room_id.set(paramLong);
    ((WTogetherRoomMng.CmdUserEnterRoomReq)localObject).client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-UserEnterRoom");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt1);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putInt("qav_together_try_count", paramInt2 + 1);
    localToServiceMsg.putWupBuffer(((WTogetherRoomMng.CmdUserEnterRoomReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterRoom, from[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], room[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Handler", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return WTogetherObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((QLog.isColorLevel()) && (!TextUtils.equals(str, "QQRTCSvc.RoomManager-SyncPlayTime")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive, cmd[");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.i("WTogether.Handler", 2, localStringBuilder.toString());
    }
    if ("OidbSvc.0xe37_1200".equals(str))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQRTCSvc.RoomManager-StartAvTogether".equals(str))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQRTCSvc.RoomManager-CloseAvTogether".equals(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQRTCSvc.RoomManager-ChangeVideoFile".equals(str))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQRTCSvc.RoomManager-ChangeVideoStatus".equals(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQRTCSvc.RoomManager-GetRoomInfo".equals(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQRTCSvc.RoomManager-SyncPlayTime".equals(str))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQRTCSvc.RoomManager-UserQuitRoom".equals(str))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQRTCSvc.RoomManager-UserEnterRoom".equals(str)) {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherHandler
 * JD-Core Version:    0.7.0.1
 */