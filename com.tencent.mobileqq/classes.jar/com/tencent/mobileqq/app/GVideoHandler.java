package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvGVideoLevelInfo.Medal;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.DealInviteReqBody;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.DealInviteRspBody;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.ReqBody;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoStateGetListener;
import com.tencent.mobileqq.intervideo.groupvideo.VideoStateInfo;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.cs.cmd0x2323.BodyMsg;
import tencent.im.cs.cmd0x2323.ReqBody;
import tencent.im.cs.cmd0x2323.RspBody;
import tencent.im.cs.cmd0x3fb.cmd0x3fb.GrayMsg;
import tencent.im.cs.cmd0x3fb.cmd0x3fb.ReqBody;
import tencent.im.cs.cmd0x3fb.cmd0x3fb.RspBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.LevelInfo;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.LevelMsg;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.Medal;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.ReqBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.RspBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.UserInfo;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.ReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusInfo;
import tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusReq;
import tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusRsp;

public class GVideoHandler
  extends BusinessHandler
{
  protected static int a = 1;
  protected static int b = 2;
  private GVideoStateGetListener c;
  private QQAppInterface d;
  
  GVideoHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.d = paramQQAppInterface;
  }
  
  private void a(String paramString, boolean paramBoolean, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, oidb_0xa8d.RspBody paramRspBody)
  {
    paramRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    if (paramRspBody.uint64_group_code.has()) {
      paramString = String.valueOf(paramRspBody.uint64_group_code.get());
    }
    if (paramRspBody.uint32_req_type.has()) {
      if (paramRspBody.uint32_req_type.get() == a) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
    if (paramBoolean)
    {
      paramOIDBSSOPkg = (oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody)paramRspBody.msg_join_group.get();
      paramRspBody = new TroopInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      boolean bool;
      if (paramOIDBSSOPkg.uint32_GroupFlagEx.has())
      {
        paramRspBody.dwGroupFlagExt = paramOIDBSSOPkg.uint32_GroupFlagEx.get();
        bool = TroopInfo.isVisitorSpeakEnabled(paramOIDBSSOPkg.uint32_GroupFlagEx.get());
        localStringBuilder.append(" dwGroupFlagExt: ");
        localStringBuilder.append(paramRspBody.dwGroupFlagExt);
        localStringBuilder.append(" visitorSpeakEnabled: ");
        localStringBuilder.append(bool);
      }
      else
      {
        bool = false;
      }
      int i;
      if (paramOIDBSSOPkg.uint32_SpeakInterval.has())
      {
        i = paramOIDBSSOPkg.uint32_SpeakInterval.get();
        localStringBuilder.append(" speakInterval: ");
        localStringBuilder.append(i);
      }
      else
      {
        i = 0;
      }
      int j;
      if (paramOIDBSSOPkg.uint32_StartSpeakInterval.has())
      {
        j = paramOIDBSSOPkg.uint32_StartSpeakInterval.get();
        localStringBuilder.append(" startSpeakInterval: ");
        localStringBuilder.append(j);
      }
      else
      {
        j = 0;
      }
      if (paramOIDBSSOPkg.uint32_GroupClassEx.has())
      {
        paramRspBody.dwGroupClassExt = paramOIDBSSOPkg.uint32_GroupClassEx.get();
        localStringBuilder.append(" dwGroupClassExt: ");
        localStringBuilder.append(paramRspBody.dwGroupClassExt);
      }
      if (paramOIDBSSOPkg.uint32_GroupClass.has())
      {
        paramRspBody.trooptype = paramOIDBSSOPkg.uint32_GroupClass.get();
        localStringBuilder.append(" trooptype: ");
        localStringBuilder.append(paramRspBody.trooptype);
      }
      if (paramOIDBSSOPkg.uint32_MaxMember.has())
      {
        paramRspBody.wMemberMax = paramOIDBSSOPkg.uint32_MaxMember.get();
        localStringBuilder.append(" wMemberMax: ");
        localStringBuilder.append(paramRspBody.wMemberMax);
      }
      if (paramOIDBSSOPkg.uint32_SpecialClass.has())
      {
        paramRspBody.wSpecialClass = paramOIDBSSOPkg.uint32_SpecialClass.get();
        localStringBuilder.append(" wSpecialClass: ");
        localStringBuilder.append(paramRspBody.wSpecialClass);
      }
      if (paramOIDBSSOPkg.bytes_GroupName.has())
      {
        paramRspBody.troopname = paramOIDBSSOPkg.bytes_GroupName.get().toStringUtf8();
        localStringBuilder.append(" troopname: ");
        localStringBuilder.append(paramRspBody.troopname);
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.inOrOutOpenTroop", 2, localStringBuilder.toString());
      }
      notifyUI(GVideoObserver.d, true, new Object[] { paramString, Integer.valueOf(2131893916), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
    }
    else
    {
      notifyUI(GVideoObserver.d, true, new Object[] { paramString, Integer.valueOf(2131893913), Boolean.valueOf(paramBoolean) });
    }
    paramOIDBSSOPkg = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramOIDBSSOPkg != null)
    {
      if (!paramBoolean) {
        paramString = null;
      }
      paramOIDBSSOPkg.t(paramString);
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleRequestGroupVideoStateList: isSuccess = ");
      paramToServiceMsg.append(bool);
      QLog.d("GVideoHandler", 2, paramToServiceMsg.toString());
    }
    if (bool)
    {
      paramToServiceMsg = new cmd0x2323.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.ret.has()) && (paramToServiceMsg.ret.get() == 0))
        {
          paramFromServiceMsg = paramToServiceMsg.body_msg.get();
          paramToServiceMsg = new ArrayList();
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          while (paramFromServiceMsg.hasNext())
          {
            paramObject = (cmd0x2323.BodyMsg)paramFromServiceMsg.next();
            VideoStateInfo localVideoStateInfo = new VideoStateInfo();
            localVideoStateInfo.a = paramObject.group_code.get();
            localVideoStateInfo.c = paramObject.action.get();
            localVideoStateInfo.b = paramObject.user_num.get();
            localVideoStateInfo.f = paramObject.video_user_list.get();
            localVideoStateInfo.d = paramObject.stage_mode.get();
            localVideoStateInfo.e = paramObject.game_id.get();
            localVideoStateInfo.g = paramObject.live_extra_mode.get();
            paramToServiceMsg.add(localVideoStateInfo);
          }
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleRequestGroupVideoStateList: msgInfos size ");
            paramFromServiceMsg.append(paramToServiceMsg.size());
            QLog.d("GVideoHandler", 2, paramFromServiceMsg.toString());
          }
          if (this.c != null) {
            this.c.a(paramToServiceMsg);
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleRequestGroupVideoStateList: InvalidProtocolBufferMicroException  = ");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.d("GVideoHandler", 2, paramFromServiceMsg.toString());
        }
      }
    }
    this.c = null;
  }
  
  public long a(int paramInt, long paramLong)
  {
    Object localObject1 = new cmd0x3fb.GrayMsg();
    ((cmd0x3fb.GrayMsg)localObject1).uint32_subcmd.set(1);
    Object localObject2 = new cmd0x3fb.ReqBody();
    ((cmd0x3fb.ReqBody)localObject2).uint32_identity.set(paramInt);
    ((cmd0x3fb.ReqBody)localObject2).uint32_client_id.set(2);
    ((cmd0x3fb.ReqBody)localObject2).str_version.set("8.8.17");
    ((cmd0x3fb.ReqBody)localObject2).uint64_to_guin.set(paramLong);
    ((cmd0x3fb.GrayMsg)localObject1).msg_gray_req.set((MessageMicro)localObject2);
    localObject2 = createToServiceMsg("qunVideoGray.0x3fb_0");
    Bundle localBundle = ((ToServiceMsg)localObject2).extraData;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localBundle.putString("troop_uin", localStringBuilder.toString());
    ((ToServiceMsg)localObject2).extraData.putLong("timeSeq", SystemClock.elapsedRealtime());
    ((ToServiceMsg)localObject2).putWupBuffer(((cmd0x3fb.GrayMsg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
    long l = ((ToServiceMsg)localObject2).extraData.getLong("timeSeq");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" requestVideoGrayWebConfig, identity:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" client_id: 2 str_version:");
      ((StringBuilder)localObject1).append("8.8.17");
      ((StringBuilder)localObject1).append(" to_guin:");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" timeKey:");
      ((StringBuilder)localObject1).append(l);
      QLog.d("GVideoHandler", 2, ((StringBuilder)localObject1).toString());
    }
    return l;
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    cmd0x3fe.LevelMsg localLevelMsg = new cmd0x3fe.LevelMsg();
    localLevelMsg.uint32_subcmd.set(1);
    Object localObject = new cmd0x3fe.ReqBody();
    cmd0x3fe.UserInfo localUserInfo = new cmd0x3fe.UserInfo();
    localUserInfo.uint64_uin.set(paramLong1);
    localUserInfo.uint32_online_time.set(paramInt);
    ((cmd0x3fe.ReqBody)localObject).rpt_msg_user_info.add(localUserInfo);
    ((cmd0x3fe.ReqBody)localObject).uint64_group_code.set(paramLong2);
    localLevelMsg.msg_level_req.set((MessageMicro)localObject);
    localObject = createToServiceMsg("qunVideoOnlineLevel.0x3fe_0");
    ((ToServiceMsg)localObject).putWupBuffer(localLevelMsg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    long l = paramToServiceMsg.extraData.getLong("timeSeq");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troop_uin");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetTroopHideWebConfig: isSuccess = ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" code:");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      ((StringBuilder)localObject).append(" sendTimeKey:");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(" troopUin:");
      ((StringBuilder)localObject).append(paramToServiceMsg);
      QLog.d("GVideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (bool) {
      localObject = new cmd0x3fb.GrayMsg();
    }
    for (;;)
    {
      try
      {
        ((cmd0x3fb.GrayMsg)localObject).mergeFrom((byte[])paramObject);
        paramObject = (cmd0x3fb.RspBody)((cmd0x3fb.GrayMsg)localObject).msg_gray_rsp.get();
        ((IFactoryApi)QRoute.api(IFactoryApi.class)).monitorReport("2729126");
        if ((paramObject.int32_ret.has()) && (paramObject.int32_ret.get() == 0))
        {
          i = paramObject.int32_color.get();
          localObject = paramObject.str_url.get();
          int j = paramObject.int32_gray_flag.get();
          int k = paramObject.int32_enter_glive_strategy.get();
          String str1 = paramObject.str_update_title.get();
          String str2 = paramObject.str_update_content.get();
          int m = paramObject.int32_pre_download_toggle.get();
          notifyUI(GVideoObserver.b, true, new Object[] { paramToServiceMsg, Integer.valueOf(i), localObject, Integer.valueOf(j), Integer.valueOf(k), str1, str2, Integer.valueOf(m), Integer.valueOf(paramFromServiceMsg.getResultCode()), Long.valueOf(l) });
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("<---- handleGetTroopHideWebConfig,troopUin=");
            paramFromServiceMsg.append(paramToServiceMsg);
            paramFromServiceMsg.append(" ,color=");
            paramFromServiceMsg.append(i);
            paramFromServiceMsg.append(", url=");
            paramFromServiceMsg.append((String)localObject);
            paramFromServiceMsg.append(" flag:");
            paramFromServiceMsg.append(j);
            paramFromServiceMsg.append(" ,strategy:");
            paramFromServiceMsg.append(k);
            paramFromServiceMsg.append(" title:");
            paramFromServiceMsg.append(str1);
            paramFromServiceMsg.append(" content:");
            paramFromServiceMsg.append(str2);
            paramFromServiceMsg.append(" preDownloadToggle:");
            paramFromServiceMsg.append(m);
            QLog.d(".troop.notify_feeds.data", 2, paramFromServiceMsg.toString());
          }
          ((IFactoryApi)QRoute.api(IFactoryApi.class)).monitorTrigger("2729127");
          ReportController.b(this.d, "dc00899", "Huayang_video", "", "group_video", "GetTroopHideWebConfig", 1, 0, "", "8.8.17", "", "");
          return;
        }
        notifyUI(GVideoObserver.b, false, new Object[] { paramToServiceMsg, Integer.valueOf(0), "", Integer.valueOf(-1), Integer.valueOf(-1), "", "", Integer.valueOf(-1), Integer.valueOf(-1), Long.valueOf(l) });
        paramFromServiceMsg = this.d;
        if (!paramObject.int32_ret.has()) {
          break label948;
        }
        i = paramObject.int32_ret.get();
        ReportController.b(paramFromServiceMsg, "dc00899", "Huayang_video", "", "group_video", "GetTroopHideWebConfig", 0, i, "", "8.8.17", "", "");
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        notifyUI(GVideoObserver.b, false, new Object[] { paramToServiceMsg, Integer.valueOf(0), "", Integer.valueOf(-1), Integer.valueOf(-1), "", "", Integer.valueOf(-1), Integer.valueOf(-1), Long.valueOf(l) });
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("GetTroopHideWebConfig exp:, ");
          paramToServiceMsg.append(paramFromServiceMsg.toString());
          paramToServiceMsg.append(" ---->");
          QLog.e(".troop.notify_feeds.data", 2, paramToServiceMsg.toString());
        }
        ReportController.b(this.d, "dc00899", "Huayang_video", "", "group_video", "GetTroopHideWebConfig", 0, 0, paramFromServiceMsg.toString(), "8.8.17", "", "");
        return;
      }
      notifyUI(GVideoObserver.b, false, new Object[] { paramToServiceMsg, Integer.valueOf(0), "", Integer.valueOf(-1), Integer.valueOf(-1), "", "", Integer.valueOf(-1), Integer.valueOf(paramFromServiceMsg.getResultCode()), Long.valueOf(l) });
      return;
      label948:
      int i = -1;
    }
  }
  
  public void a(String paramString)
  {
    UserFollowStatus.UserFollowStatusReq localUserFollowStatusReq = new UserFollowStatus.UserFollowStatusReq();
    Object localObject = new ArrayList();
    try
    {
      ((List)localObject).add(Long.valueOf(Long.parseLong(paramString)));
      localUserFollowStatusReq.uin.set(Long.parseLong(this.d.getCurrentAccountUin()));
      localUserFollowStatusReq.dst_uin_list.set((List)localObject);
      localObject = createToServiceMsg("NearbyExt.query_user_follow_status");
      ((ToServiceMsg)localObject).extraData.putString("distUin", paramString);
      ((ToServiceMsg)localObject).putWupBuffer(localUserFollowStatusReq.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFollowStatus:NumberFormatException");
        ((StringBuilder)localObject).append(localNumberFormatException.toString());
        ((StringBuilder)localObject).append("|distUin:");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("GVideoHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" troopUin:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",inviterUin:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", inviteId:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("GVideoHandler.troopgroup_vedio.invite", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x6d1.ReqBody();
    cmd0x6d1.DealInviteReqBody localDealInviteReqBody = new cmd0x6d1.DealInviteReqBody();
    try
    {
      localDealInviteReqBody.uint64_group_code.set(Long.parseLong(paramString1));
      localDealInviteReqBody.str_id.set(paramString2);
      localDealInviteReqBody.uint64_uin.set(paramLong);
      localDealInviteReqBody.uint32_deal_result.set(paramInt);
      ((cmd0x6d1.ReqBody)localObject).deal_invite_req_body.set(localDealInviteReqBody);
      ((cmd0x6d1.ReqBody)localObject).uint32_app_type.set(2);
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(1745);
      paramString1.uint32_service_type.set(3);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x6d1.ReqBody)localObject).toByteArray()));
      paramString2 = createToServiceMsg("OidbSvc.0x6d1_3");
      paramString2.putWupBuffer(paramString1.toByteArray());
      sendPbReq(paramString2);
      return;
    }
    catch (NumberFormatException paramString2)
    {
      label220:
      break label220;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(" NumberFormatException, troopUin:");
      paramString2.append(paramString1);
      QLog.d("GVideoHandler", 2, paramString2.toString());
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = ((IBizTroopInfoService)this.d.getRuntimeService(IBizTroopInfoService.class, "")).getCurrentOpenTroop();
      localObject1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("joinOrExitOpenTroop:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", ");
      if (paramBoolean) {
        paramString = "join";
      } else {
        paramString = "exit";
      }
      ((StringBuilder)localObject2).append(paramString);
      QLog.d(".troop.inOrOutOpenTroop", 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      long l1 = Long.parseLong((String)localObject1);
      long l2 = Long.parseLong(this.d.getCurrentUin());
      paramString = new oidb_0xa8d.ReqBody();
      paramString.uint64_group_code.set(l1);
      localObject2 = paramString.uint32_req_type;
      int i;
      if (paramBoolean) {
        i = a;
      } else {
        i = b;
      }
      ((PBUInt32Field)localObject2).set(i);
      paramString.uint32_req_client_type.set(1);
      if (paramBoolean)
      {
        localObject2 = new oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody();
        ((oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody)localObject2).uint64_visitor_uin.set(l2);
        paramString.msg_join_group.set((MessageMicro)localObject2);
      }
      else
      {
        localObject2 = new oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody();
        ((oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody)localObject2).uint64_visitor_uin.set(l2);
        paramString.msg_exit_group.set((MessageMicro)localObject2);
      }
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2701);
      PBUInt32Field localPBUInt32Field = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type;
      if (paramBoolean) {
        i = a;
      } else {
        i = b;
      }
      localPBUInt32Field.set(i);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
      paramString = createToServiceMsg("OidbSvc.0xa8d");
      paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      paramString.extraData.putString("troopUin", (String)localObject1);
      paramString.extraData.putBoolean("isJoin", paramBoolean);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("joinOrExitOpenTroop:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e(".troop.inOrOutOpenTroop", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(List<Long> paramList, GVideoStateGetListener paramGVideoStateGetListener)
  {
    cmd0x2323.ReqBody localReqBody = new cmd0x2323.ReqBody();
    localReqBody.group_code_list.set(paramList);
    ToServiceMsg localToServiceMsg = createToServiceMsg("videohub_group_notify_read.cmd0x2323");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(localToServiceMsg);
    this.c = paramGVideoStateGetListener;
    if (QLog.isColorLevel())
    {
      paramGVideoStateGetListener = new StringBuilder();
      paramGVideoStateGetListener.append(" requestGroupVideoState, groupUins size:");
      paramGVideoStateGetListener.append(paramList.size());
      QLog.d("GVideoHandler", 2, paramGVideoStateGetListener.toString());
    }
  }
  
  public void a(long[] paramArrayOfLong, long paramLong)
  {
    cmd0x3fe.LevelMsg localLevelMsg = new cmd0x3fe.LevelMsg();
    localLevelMsg.uint32_subcmd.set(6);
    cmd0x3fe.ReqBody localReqBody = new cmd0x3fe.ReqBody();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      cmd0x3fe.UserInfo localUserInfo = new cmd0x3fe.UserInfo();
      localUserInfo.uint64_uin.set(l);
      localReqBody.rpt_msg_user_info.add(localUserInfo);
      i += 1;
    }
    localReqBody.uint64_group_code.set(paramLong);
    localLevelMsg.msg_level_req.set(localReqBody);
    paramArrayOfLong = createToServiceMsg("qunVideoOnlineLevel.0x3fe_0");
    paramArrayOfLong.putWupBuffer(localLevelMsg.toByteArray());
    sendPbReq(paramArrayOfLong);
  }
  
  void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      paramToServiceMsg = new cmd0x3fe.RspBody();
      if (paramObject == null) {
        return;
      }
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramToServiceMsg.int32_ret.has()) {
          return;
        }
        if (paramToServiceMsg.int32_ret.get() != 0) {
          return;
        }
        if (!paramToServiceMsg.uint32_subcmd.has()) {
          return;
        }
        int k = paramToServiceMsg.uint32_subcmd.get();
        paramToServiceMsg = paramToServiceMsg.rpt_msg_level_info;
        Object[] arrayOfObject = new Object[paramToServiceMsg.size()];
        int i = 0;
        while (i < paramToServiceMsg.size())
        {
          paramFromServiceMsg = (cmd0x3fe.LevelInfo)paramToServiceMsg.get(i);
          long l = paramFromServiceMsg.uint64_uin.get();
          int m = paramFromServiceMsg.uint32_online_level.get();
          int n = paramFromServiceMsg.uint32_show_level.get();
          int i1 = paramFromServiceMsg.uint32_level_color.get();
          int i2 = paramFromServiceMsg.uint32_score.get();
          int i3 = paramFromServiceMsg.uint32_req_flag.get();
          int i4 = paramFromServiceMsg.uint32_req_timer.get();
          int i5 = paramFromServiceMsg.uint32_user_identity.get();
          String str = paramFromServiceMsg.nickname.get();
          ArrayList localArrayList = new ArrayList();
          paramObject = paramFromServiceMsg.rpt_medal_list.get();
          paramFromServiceMsg = paramToServiceMsg;
          int j = i;
          if (paramObject != null)
          {
            paramObject = paramObject.iterator();
            for (;;)
            {
              paramFromServiceMsg = paramToServiceMsg;
              j = i;
              if (!paramObject.hasNext()) {
                break;
              }
              paramFromServiceMsg = (cmd0x3fe.Medal)paramObject.next();
              localArrayList.add(new RecvGVideoLevelInfo.Medal(paramFromServiceMsg.uint32_id.get(), paramFromServiceMsg.uint32_level.get(), paramFromServiceMsg.uint32_type.get(), paramFromServiceMsg.str_icon_url.get(), paramFromServiceMsg.str_head_icon_url.get(), paramFromServiceMsg.str_name.get()));
            }
          }
          arrayOfObject[j] = new RecvGVideoLevelInfo(l, m, n, i1, i2, i3, i4, k, i5, str, localArrayList);
          i = j + 1;
          paramToServiceMsg = paramFromServiceMsg;
        }
        i = GVideoObserver.c;
        try
        {
          notifyUI(i, true, arrayOfObject);
          return;
        }
        catch (Exception paramToServiceMsg) {}
        if (!QLog.isColorLevel()) {
          break label395;
        }
      }
      catch (Exception paramToServiceMsg) {}
      QLog.e("GVideoHandler", 2, "handleGetGVideoLevelInfo error", paramToServiceMsg);
      label395:
      return;
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("receive cmd=OidbSvc.0x6d1, DealInviteRspBody, isSuccess:");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      QLog.i("GVideoHandler.troopgroup_vedio.invite", 2, paramToServiceMsg.toString());
    }
    try
    {
      if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        break label110;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      new cmd0x6d1.DealInviteRspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label95:
      label110:
      break label95;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GVideoHandler", 2, "receive cmd=OidbSvc.0x6d1.DealInviteReqBody, InvalidProtocolBufferMicroException");
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troopUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isJoin");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleJoinOrExitOpenTroop:");
      localStringBuilder.append(str);
      localStringBuilder.append(",");
      if (bool) {
        paramToServiceMsg = "join";
      } else {
        paramToServiceMsg = "exit";
      }
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append(",");
      localStringBuilder.append(paramFromServiceMsg.isSuccess());
      QLog.d(".troop.inOrOutOpenTroop", 2, localStringBuilder.toString());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      notifyUI(GVideoObserver.d, false, new Object[] { str, Integer.valueOf(2131893915), Boolean.valueOf(bool) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      int i = -1;
      if (paramToServiceMsg.uint32_result.has()) {
        i = paramToServiceMsg.uint32_result.get();
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("sso result:");
        paramFromServiceMsg.append(i);
        QLog.d(".troop.inOrOutOpenTroop", 2, paramFromServiceMsg.toString());
      }
      if (i != 0)
      {
        if (i != 197)
        {
          notifyUI(GVideoObserver.d, false, new Object[] { str, Integer.valueOf(2131893915), Boolean.valueOf(bool) });
          return;
        }
        notifyUI(GVideoObserver.d, false, new Object[] { str, Integer.valueOf(2131893914), Boolean.valueOf(bool) });
        return;
      }
      paramFromServiceMsg = new oidb_0xa8d.RspBody();
      try
      {
        a(str, bool, paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleJoinOrExitOpenTroop:");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.d(".troop.inOrOutOpenTroop", 2, paramFromServiceMsg.toString());
        }
        notifyUI(GVideoObserver.d, false, new Object[] { str, Integer.valueOf(2131893915), Boolean.valueOf(bool) });
        return;
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("pkg.mergeFrom:");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.e(".troop.inOrOutOpenTroop", 2, paramFromServiceMsg.toString());
      }
      notifyUI(GVideoObserver.d, false, new Object[] { str, Integer.valueOf(2131893915), Boolean.valueOf(bool) });
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (!paramFromServiceMsg.isSuccess())
      {
        notifyUI(GVideoObserver.e, false, new Object[] { paramToServiceMsg.extraData.getString("distUin"), Boolean.valueOf(false) });
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new UserFollowStatus.UserFollowStatusRsp();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.follow_status_info_list.has())
        {
          paramObject = paramFromServiceMsg.follow_status_info_list.get().iterator();
          if (paramObject.hasNext())
          {
            paramFromServiceMsg = (UserFollowStatus.UserFollowStatusInfo)paramObject.next();
            if (paramFromServiceMsg.dst_uin.get() != Long.parseLong(paramToServiceMsg.extraData.getString("distUin"))) {
              continue;
            }
            paramObject = new StringBuilder();
            paramObject.append(paramFromServiceMsg.dst_uin.get());
            paramObject.append("");
            paramObject = paramObject.toString();
            int i = paramFromServiceMsg.follow_status.get();
            int j = GVideoObserver.e;
            if (i != 1) {
              break label381;
            }
            bool = true;
            notifyUI(j, true, new Object[] { paramObject, Boolean.valueOf(bool) });
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("handleGetFollowStatus, uin:");
              paramFromServiceMsg.append(paramObject);
              paramFromServiceMsg.append("|followStatus:");
              paramFromServiceMsg.append(i);
              QLog.d("GVideoHandlerQ.nearby.follow", 2, paramFromServiceMsg.toString());
            }
            return;
          }
        }
        notifyUI(GVideoObserver.e, false, new Object[] { paramToServiceMsg.extraData.getString("distUin"), Boolean.valueOf(false) });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyUI(GVideoObserver.e, false, new Object[] { paramToServiceMsg.extraData.getString("distUin"), Boolean.valueOf(false) });
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetFollowStatus,InvalidProtocolBufferMicroException: ");
          paramToServiceMsg.append(paramFromServiceMsg.toString());
          QLog.i("GVideoHandlerQ.nearby.follow", 2, paramToServiceMsg.toString());
        }
      }
      return;
      label381:
      boolean bool = false;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("videohub_group_notify_read.cmd0x2323");
      this.allowCmdSet.add("qunVideoGray.0x3fb_0");
      this.allowCmdSet.add("qunVideoOnlineLevel.0x3fe_0");
      this.allowCmdSet.add("OidbSvc.0x6d1_3");
      this.allowCmdSet.add("OidbSvc.0xa8d");
      this.allowCmdSet.add("NearbyExt.query_user_follow_status");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GVideoObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("GVideoHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("videohub_group_notify_read.cmd0x2323".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qunVideoGray.0x3fb_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qunVideoOnlineLevel.0x3fe_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6d1_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa8d".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("NearbyExt.query_user_follow_status".equals(paramFromServiceMsg.getServiceCmd())) {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GVideoHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.GVideoHandler
 * JD-Core Version:    0.7.0.1
 */