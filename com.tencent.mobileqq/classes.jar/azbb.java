import KQQ.BatchRequest;
import KQQ.ReqBatchProcess;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetMultiTroopInfoReq;
import friendlist.GetTroopAppointRemarkReq;
import friendlist.GetTroopListReqV2Simplify;
import friendlist.GetTroopMemberListReq;
import friendlist.GetTroopRemarkReq;
import friendlist.ModifyGroupCardReq;
import friendlist.ModifyGroupInfoReq;
import java.io.IOException;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x899.oidb_0x899.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class azbb
{
  private AppInterface a;
  
  public azbb(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    byte b1 = paramToServiceMsg.extraData.getByte("bGetMSFMsgFlag");
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("vecCookies");
    ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecGroupInfo");
    byte b2 = paramToServiceMsg.extraData.getByte("bGroupFlagExt");
    byte b3 = paramToServiceMsg.extraData.getByte("bGetLongGroupName");
    paramToServiceMsg = new GetTroopListReqV2Simplify();
    paramToServiceMsg.uin = l;
    paramToServiceMsg.bGetMSFMsgFlag = b1;
    paramToServiceMsg.vecCookies = arrayOfByte;
    paramToServiceMsg.vecGroupInfo = localArrayList;
    paramToServiceMsg.bGroupFlagExt = b2;
    paramToServiceMsg.bGetLongGroupName = b3;
    if (QLog.isColorLevel()) {
      QLog.d("TroopSender", 2, "handleTroopGetList bGetLongGroupName = " + b3);
    }
    paramToServiceMsg.shVersion = 7;
    paramToServiceMsg.versionNum = 1L;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopListReqV2Simplify");
    paramUniPacket.put("GetTroopListReqV2Simplify", paramToServiceMsg);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    GetTroopMemberListReq localGetTroopMemberListReq = new GetTroopMemberListReq();
    localGetTroopMemberListReq.uin = l;
    localGetTroopMemberListReq.GroupCode = paramToServiceMsg.getLong("troop_uin");
    localGetTroopMemberListReq.GroupUin = paramToServiceMsg.getLong("troop_code");
    localGetTroopMemberListReq.Version = paramToServiceMsg.getLong("version");
    localGetTroopMemberListReq.NextUin = paramToServiceMsg.getLong("nextuin");
    localGetTroopMemberListReq.ReqType = paramToServiceMsg.getInt("reqType", 0);
    localGetTroopMemberListReq.GetListAppointTime = paramToServiceMsg.getLong("get_list_appoint_time", 0L);
    localGetTroopMemberListReq.cRichCardNameVer = 1;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopMemberListReq");
    paramUniPacket.put("GTML", localGetTroopMemberListReq);
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "FriendListService.handleTroopGetMemberList, troopUin: " + localGetTroopMemberListReq.GroupCode + " |troopCode: " + localGetTroopMemberListReq.GroupUin + "|ReqType:" + localGetTroopMemberListReq.ReqType + "|GetListAppointTime:" + localGetTroopMemberListReq.GetListAppointTime);
    }
    return true;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {}
    GetTroopRemarkReq localGetTroopRemarkReq;
    do
    {
      return false;
      paramToServiceMsg = paramToServiceMsg.extraData;
      localGetTroopRemarkReq = new GetTroopRemarkReq();
      localGetTroopRemarkReq.uin = l;
      localGetTroopRemarkReq.GroupCode = paramToServiceMsg.getLong("troop_uin");
      localGetTroopRemarkReq.GroupUin = paramToServiceMsg.getLong("troop_code");
    } while ((localGetTroopRemarkReq.GroupCode == 0L) || (localGetTroopRemarkReq.GroupUin == 0L));
    localGetTroopRemarkReq.NextUin = paramToServiceMsg.getLong("nextuin");
    localGetTroopRemarkReq.Seq = 0L;
    paramToServiceMsg.getBoolean("force_refresh");
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopRemarkReq");
    paramUniPacket.put("GTR", localGetTroopRemarkReq);
    return true;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetMultiTroopInfoReq(Long.parseLong(paramToServiceMsg.getUin()), (ArrayList)paramToServiceMsg.extraData.getSerializable("vecGroupCode"), (byte)1);
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetMultiTroopInfoReq");
    paramUniPacket.put("GMTIREQ", paramToServiceMsg);
    return true;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Long.parseLong(paramToServiceMsg.getUin());
    ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecUinInfo");
    long l1 = paramToServiceMsg.extraData.getLong("dwZero");
    long l2 = paramToServiceMsg.extraData.getLong("dwGroupCode");
    long l3 = paramToServiceMsg.extraData.getLong("dwNewSeq");
    paramToServiceMsg = new ModifyGroupCardReq();
    paramToServiceMsg.dwGroupCode = l2;
    paramToServiceMsg.dwNewSeq = l3;
    paramToServiceMsg.dwZero = l1;
    paramToServiceMsg.vecUinInfo = localArrayList;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("ModifyGroupCardReq");
    paramUniPacket.put("MGCREQ", paramToServiceMsg);
    return true;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    try
    {
      long l = Long.parseLong(paramToServiceMsg.getUin());
      ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecUinList");
      if ((localArrayList != null) && (localArrayList.size() != 0))
      {
        Object localObject = paramToServiceMsg.extraData.getString("GroupUin");
        String str = paramToServiceMsg.extraData.getString("GroupCode");
        byte b = paramToServiceMsg.extraData.getByte("cRichInfo");
        paramToServiceMsg = new GetTroopAppointRemarkReq();
        paramToServiceMsg.cRichInfo = b;
        paramToServiceMsg.GroupCode = Long.parseLong((String)localObject);
        paramToServiceMsg.GroupUin = Long.parseLong(str);
        paramToServiceMsg.cRichCardNameVer = 1;
        localObject = new ArrayList();
        int i = 0;
        while (i < localArrayList.size())
        {
          ((ArrayList)localObject).add(Long.valueOf(Long.parseLong((String)localArrayList.get(i))));
          i += 1;
        }
        paramToServiceMsg.vecUinList = ((ArrayList)localObject);
        paramToServiceMsg.uin = l;
        paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        paramUniPacket.setFuncName("GetTroopAppointRemarkReq");
        paramUniPacket.put("GTA", paramToServiceMsg);
        return true;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      return false;
    }
    return false;
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    ModifyGroupInfoReq localModifyGroupInfoReq = new ModifyGroupInfoReq();
    localModifyGroupInfoReq.dwGroupCode = paramToServiceMsg.extraData.getLong("dwGroupCode");
    localModifyGroupInfoReq.cGroupOption = paramToServiceMsg.extraData.getLong("cGroupOption");
    localModifyGroupInfoReq.dwGroupClass = paramToServiceMsg.extraData.getLong("dwGroupClass");
    localModifyGroupInfoReq.strGroupName = paramToServiceMsg.extraData.getString("strGroupName");
    localModifyGroupInfoReq.wGroupFace = paramToServiceMsg.extraData.getInt("wGroupFace");
    localModifyGroupInfoReq.strGroupMemo = paramToServiceMsg.extraData.getString("strGroupMemo");
    localModifyGroupInfoReq.dwValidMask = paramToServiceMsg.extraData.getLong("dwValidMask");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("strFingerMemo");
    String str = banh.b(paramToServiceMsg);
    try
    {
      byte[] arrayOfByte = str.getBytes("utf-8");
      if (arrayOfByte.length > 120) {}
      for (localModifyGroupInfoReq.strFingerMemo = ndp.a(arrayOfByte, 120);; localModifyGroupInfoReq.strFingerMemo = str)
      {
        localModifyGroupInfoReq.strRichFingerMemo = ndd.a(paramToServiceMsg);
        localModifyGroupInfoReq.wVersion = 1;
        paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        paramUniPacket.setFuncName("ModifyGroupInfoReq");
        paramUniPacket.put("MGIREQ", localModifyGroupInfoReq);
        return true;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        localModifyGroupInfoReq.strFingerMemo = "";
      }
    }
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("troop_code");
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("is_admin");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("param_get_credit_info");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("param_get_troop_class_type");
    if (l == 0L) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopSender", 2, "handlerBatchGetGroupInfoReq：" + l + ",isMember=" + bool1 + ",isGetTroopCreditInfo=" + bool2);
    }
    ReqBatchProcess localReqBatchProcess = new ReqBatchProcess();
    localReqBatchProcess.batch_request_list = new ArrayList();
    int i;
    if (bool3)
    {
      localObject1 = new oidb_0x88d.GroupInfo();
      ((oidb_0x88d.GroupInfo)localObject1).uint32_group_class_ext.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).string_group_class_text.set(ByteStringMicro.EMPTY);
      ((oidb_0x88d.GroupInfo)localObject1).string_group_name.set(ByteStringMicro.EMPTY);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_group_face.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint64_subscription_uin.set(0L);
      ((oidb_0x88d.GroupInfo)localObject1).uint64_group_owner.set(0L);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_is_modify_conf_group_name.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_is_modify_conf_group_face.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_is_conf_group.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_group_member_num.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_no_finger_open_flag.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_no_code_finger_open_flag.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_is_group_freeze.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flagext4.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_group_freeze_reason.set(0);
      localObject2 = new oidb_0x88d.ReqGroupInfo();
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(l);
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint32_last_get_group_name_time.set(0);
      ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
      localObject1 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.a.getAppid());
      ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      localPBUInt32Field = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type;
      if (bool1) {}
      for (i = 0;; i = 1)
      {
        localPBUInt32Field.set(i);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
        localObject1 = new BatchRequest();
        ((BatchRequest)localObject1).type = 1;
        ((BatchRequest)localObject1).seq = 0;
        ((BatchRequest)localObject1).buffer = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
        localReqBatchProcess.batch_request_list.add(localObject1);
        paramUniPacket.setServantName("ProfileService");
        paramUniPacket.setFuncName("ReqBatchProcess");
        paramUniPacket.put("ReqBatchProcess", localReqBatchProcess);
        paramToServiceMsg.putWupBuffer(paramUniPacket.encode());
        return true;
      }
    }
    if (bool2)
    {
      localObject1 = new oidb_0x88d.GroupInfo();
      ((oidb_0x88d.GroupInfo)localObject1).uint32_group_sec_level.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_group_sec_level_info.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flagext4.set(0);
      ((oidb_0x88d.GroupInfo)localObject1).uint32_group_freeze_reason.set(0);
      localObject2 = new oidb_0x88d.ReqGroupInfo();
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(l);
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint32_last_get_group_name_time.set(0);
      ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
      localObject1 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.a.getAppid());
      ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
      localPBUInt32Field = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type;
      if (bool1) {}
      for (i = 19;; i = 1)
      {
        localPBUInt32Field.set(i);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
        localObject1 = new BatchRequest();
        ((BatchRequest)localObject1).type = 1;
        ((BatchRequest)localObject1).seq = 0;
        ((BatchRequest)localObject1).buffer = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
        localReqBatchProcess.batch_request_list.add(localObject1);
        break;
      }
    }
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).string_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_grade.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_active_member_num.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flag_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_certification_type.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).string_certification_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_member_max_num.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_member_num.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_app_privilege_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_type_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_create_time.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint64_subscription_uin.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_modify_conf_group_name.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_modify_conf_group_face.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_conf_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_no_finger_open_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_no_code_finger_open_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_group_freeze.set(0);
    Object localObject2 = new oidb_0x88d.GroupExInfoOnly();
    ((oidb_0x88d.GroupExInfoOnly)localObject2).uint32_money_for_add_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).st_group_ex_info.set((MessageMicro)localObject2);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_allow_conf_group_member_modify_group_name.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_allow_conf_group_member_nick.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_allow_conf_group_member_at_all.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).string_long_group_name.set(ByteStringMicro.EMPTY);
    if (!bool1) {
      ((oidb_0x88d.GroupInfo)localObject1).uint64_group_owner.set(0L);
    }
    localObject2 = new oidb_0x88d.GroupGeoInfo();
    ((oidb_0x88d.GroupGeoInfo)localObject2).bytes_geocontent.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).group_geo_info.set((MessageMicro)localObject2);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_class_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_class_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flagext3.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
    localObject2 = new oidb_0x88d.TagRecord();
    ((oidb_0x88d.TagRecord)localObject2).uint32_bad_num.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).rpt_tag_record.add((MessageMicro)localObject2);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint64_subscription_uin.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_auto_agree_join_group_user_num_for_conf_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_auto_agree_join_group_user_num_for_normal_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flagext4.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_freeze_reason.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_allow_recall_msg.set(0);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(l);
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint32_last_get_group_name_time.set(0);
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
    localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(200000020);
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    PBUInt32Field localPBUInt32Field = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type;
    if (bool1)
    {
      i = 0;
      label1260:
      localPBUInt32Field.set(i);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
      localObject1 = new BatchRequest();
      ((BatchRequest)localObject1).type = 1;
      ((BatchRequest)localObject1).seq = 0;
      ((BatchRequest)localObject1).buffer = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
      localReqBatchProcess.batch_request_list.add(localObject1);
      localObject2 = new oidb_0x899.memberlist();
      ((oidb_0x899.memberlist)localObject2).uint64_member_uin.set(0L);
      localObject1 = new oidb_0x899.ReqBody();
      ((oidb_0x899.ReqBody)localObject1).uint64_group_code.set(l);
      ((oidb_0x899.ReqBody)localObject1).uint64_start_uin.set(0L);
      if (!bool1) {
        break label1715;
      }
      ((oidb_0x899.ReqBody)localObject1).uint32_identify_flag.set(5);
      label1393:
      ((oidb_0x899.ReqBody)localObject1).uint32_member_num.set(6);
      ((oidb_0x899.ReqBody)localObject1).uint32_filter_method.set(0);
      ((oidb_0x899.ReqBody)localObject1).memberlist_opt.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2201);
      if (!bool1) {
        break label1727;
      }
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    }
    for (;;)
    {
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x899.ReqBody)localObject1).toByteArray()));
      localObject1 = new BatchRequest();
      ((BatchRequest)localObject1).type = 1;
      ((BatchRequest)localObject1).seq = 1;
      ((BatchRequest)localObject1).buffer = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
      localReqBatchProcess.batch_request_list.add(localObject1);
      if (!bool1) {
        break;
      }
      localObject2 = new oidb_0x787.Filter();
      ((oidb_0x787.Filter)localObject2).uint32_sys_show_flag.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_user_show_flag.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_special_title.set(0);
      localObject1 = new oidb_0x787.ReqBody();
      ((oidb_0x787.ReqBody)localObject1).uint64_group_code.set(l);
      ((oidb_0x787.ReqBody)localObject1).uint64_begin_uin.set(0L);
      ((oidb_0x787.ReqBody)localObject1).uint64_data_time.set(0L);
      ((oidb_0x787.ReqBody)localObject1).rpt_uin_list.add(Long.valueOf(this.a.getLongAccountUin()));
      ((oidb_0x787.ReqBody)localObject1).opt_filter.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1927);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject1).toByteArray()));
      localObject1 = new BatchRequest();
      ((BatchRequest)localObject1).type = 1;
      ((BatchRequest)localObject1).seq = 2;
      ((BatchRequest)localObject1).buffer = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
      localReqBatchProcess.batch_request_list.add(localObject1);
      break;
      i = 1;
      break label1260;
      label1715:
      ((oidb_0x899.ReqBody)localObject1).uint32_identify_flag.set(2);
      break label1393;
      label1727:
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("TroopSender", 2, "create wup buffer cmd: " + str);
    }
    if ("friendlist.GetTroopListReqV2".equalsIgnoreCase(str)) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.getTroopMemberList".equalsIgnoreCase(str)) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.getTroopRemark".equalsIgnoreCase(str)) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.GetMultiTroopInfoReq".equalsIgnoreCase(str)) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(str)) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.GetTroopAppointRemarkReq".equalsIgnoreCase(str)) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.ModifyGroupInfoReq".equalsIgnoreCase(str)) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if ("ProfileService.ReqBatchProcess".equalsIgnoreCase(str)) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbb
 * JD-Core Version:    0.7.0.1
 */