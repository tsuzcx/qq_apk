package com.tencent.mobileqq.app;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceGroupProfile;
import com.tencent.mobileqq.facetoface.Face2FaceUserProfile;
import com.tencent.mobileqq.nearby.api.ILbsUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.nearfield_group.nearfield_group.BusiReqHead;
import tencent.im.nearfield_group.nearfield_group.BusiRespHead;
import tencent.im.nearfield_group.nearfield_group.GroupProfile;
import tencent.im.nearfield_group.nearfield_group.ReqExit;
import tencent.im.nearfield_group.nearfield_group.ReqGetGroupList;
import tencent.im.nearfield_group.nearfield_group.ReqJoinGroup;
import tencent.im.nearfield_group.nearfield_group.RespExit;
import tencent.im.nearfield_group.nearfield_group.RespGetGroupList;
import tencent.im.nearfield_group.nearfield_group.RespJoinGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewGroupUser;

public class NearFieldTroopHandler
  extends BusinessHandler
{
  protected NearFieldTroopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(int paramInt, SubMsgType0x27.NewComeinUserNotify paramNewComeinUserNotify)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleNewComeinPush, msgType:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("NearFieldTroopHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    long l1;
    if (paramInt == 2)
    {
      if (paramNewComeinUserNotify.msg_new_group.has())
      {
        localObject2 = (SubMsgType0x27.NewGroup)paramNewComeinUserNotify.msg_new_group.get();
        l1 = ((SubMsgType0x27.NewGroup)localObject2).uint64_group_code.get();
        paramNewComeinUserNotify = ((SubMsgType0x27.NewGroup)localObject2).bytes_group_name.get().toStringUtf8();
        long l2 = ((SubMsgType0x27.NewGroup)localObject2).uint64_owner_uin.get();
        localObject1 = ((SubMsgType0x27.NewGroup)localObject2).bytes_owner_nick.get().toStringUtf8();
        localObject2 = ((SubMsgType0x27.NewGroup)localObject2).bytes_distance.get().toStringUtf8();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l2);
        localStringBuilder.append("");
        notifyUI(4, true, new Object[] { new Face2FaceGroupProfile((String)localObject3, paramNewComeinUserNotify, localStringBuilder.toString(), (String)localObject1, (String)localObject2) });
      }
    }
    else if ((paramInt == 3) && (paramNewComeinUserNotify.msg_new_group_user.has()))
    {
      localObject1 = (SubMsgType0x27.NewGroupUser)paramNewComeinUserNotify.msg_new_group_user.get();
      l1 = ((SubMsgType0x27.NewGroupUser)localObject1).uint64_uin.get();
      paramNewComeinUserNotify = ((SubMsgType0x27.NewGroupUser)localObject1).str_nick.get();
      paramInt = ((SubMsgType0x27.NewGroupUser)localObject1).int32_sex.get();
      int i = ((SubMsgType0x27.NewGroupUser)localObject1).int32_age.get();
      localObject1 = ((SubMsgType0x27.NewGroupUser)localObject1).bytes_distance.get().toStringUtf8();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("");
      notifyUI(5, true, new Object[] { new Face2FaceUserProfile(((StringBuilder)localObject2).toString(), paramNewComeinUserNotify, paramInt, i, (String)localObject1) });
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "NearfieldGroupSvr.ReqExit");
    nearfield_group.BusiReqHead localBusiReqHead = new nearfield_group.BusiReqHead();
    localBusiReqHead.int32_seq.set(paramInt);
    localBusiReqHead.int32_version.set(1);
    nearfield_group.ReqExit localReqExit = new nearfield_group.ReqExit();
    localReqExit.msg_head.set(localBusiReqHead);
    localReqExit.uint64_group_code.set(paramLong);
    ((ToServiceMsg)localObject).putWupBuffer(localReqExit.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("closeFace2faceTroop, troopCode:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", seqNo:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("NearFieldTroopHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    Object localObject = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "NearfieldGroupSvr.ReqJoinGroup");
    nearfield_group.BusiReqHead localBusiReqHead = new nearfield_group.BusiReqHead();
    localBusiReqHead.int32_seq.set(paramInt);
    localBusiReqHead.int32_version.set(1);
    nearfield_group.ReqJoinGroup localReqJoinGroup = new nearfield_group.ReqJoinGroup();
    localReqJoinGroup.msg_head.set(localBusiReqHead);
    localReqJoinGroup.uint64_group_code.set(paramLong1);
    localReqJoinGroup.uint64_owner_uin.set(paramLong2);
    localReqJoinGroup.bytes_distance.set(ByteStringMicro.copyFromUtf8(paramString));
    ((ToServiceMsg)localObject).putWupBuffer(localReqJoinGroup.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("joinTroop, troopCode:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", ownerUin=");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", distance=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", seqNo:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("NearFieldTroopHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleOpenFace2faceTroop:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("NearFieldTroopHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      localObject1 = new nearfield_group.RespGetGroupList();
      try
      {
        ((nearfield_group.RespGetGroupList)localObject1).mergeFrom((byte[])paramObject);
        paramObject = localObject1;
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleOpenFace2faceTroop:");
          ((StringBuilder)localObject1).append(paramObject.toString());
          QLog.e("NearFieldTroopHandler", 2, ((StringBuilder)localObject1).toString());
        }
        paramObject = null;
        paramBoolean = false;
      }
      if ((paramBoolean) && (paramObject != null))
      {
        localObject1 = (nearfield_group.BusiRespHead)paramObject.msg_head.get();
        paramObject = paramObject.rpt_msg_group_list.get();
        ArrayList localArrayList = new ArrayList();
        if (paramObject != null)
        {
          int i = 0;
          while (i < paramObject.size())
          {
            Object localObject2 = (nearfield_group.GroupProfile)paramObject.get(i);
            long l1 = ((nearfield_group.GroupProfile)localObject2).uint64_group_code.get();
            String str1 = ((nearfield_group.GroupProfile)localObject2).bytes_group_name.get().toStringUtf8();
            long l2 = ((nearfield_group.GroupProfile)localObject2).uint64_owner_uin.get();
            String str2 = ((nearfield_group.GroupProfile)localObject2).bytes_owner_nick.get().toStringUtf8();
            localObject2 = ((nearfield_group.GroupProfile)localObject2).bytes_distance.get().toStringUtf8();
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(l1);
            ((StringBuilder)localObject3).append("");
            localObject3 = ((StringBuilder)localObject3).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(l2);
            localStringBuilder.append("");
            localArrayList.add(new Face2FaceGroupProfile((String)localObject3, str1, localStringBuilder.toString(), str2, (String)localObject2));
            i += 1;
          }
        }
        notifyUI(1, paramBoolean, new Object[] { localObject1, localArrayList });
        return;
      }
    }
    notifyUI(1, false, null);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    Object localObject = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "NearfieldGroupSvr.ReqGetGroupList");
    appoint_define.LBSInfo localLBSInfo = (appoint_define.LBSInfo)((ILbsUtils)QRoute.api(ILbsUtils.class)).getLbsInfo(getClass().getSimpleName());
    if (localLBSInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearFieldTroopHandler", 2, "openFace2faceTroop, lbsInfo==null");
      }
      return false;
    }
    nearfield_group.BusiReqHead localBusiReqHead = new nearfield_group.BusiReqHead();
    localBusiReqHead.int32_seq.set(paramInt);
    localBusiReqHead.int32_version.set(1);
    nearfield_group.ReqGetGroupList localReqGetGroupList = new nearfield_group.ReqGetGroupList();
    localReqGetGroupList.msg_head.set(localBusiReqHead);
    localReqGetGroupList.uint64_group_code.set(paramLong);
    localReqGetGroupList.msg_lbs_info.set(localLBSInfo);
    ((ToServiceMsg)localObject).putWupBuffer(localReqGetGroupList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openFace2faceTroop, troopCode:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", seqNo:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("NearFieldTroopHandler", 2, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleCloseFace2faceTroop:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("NearFieldTroopHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = new nearfield_group.RespExit();
      try
      {
        ((nearfield_group.RespExit)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleCloseFace2faceTroop:");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.e("NearFieldTroopHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject = null;
        paramBoolean = false;
      }
      if ((paramBoolean) && (paramObject != null))
      {
        notifyUI(2, paramBoolean, new Object[] { (nearfield_group.BusiRespHead)paramObject.msg_head.get() });
        return;
      }
    }
    notifyUI(2, false, null);
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleJoinTroopResp:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("NearFieldTroopHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = new nearfield_group.RespJoinGroup();
      try
      {
        ((nearfield_group.RespJoinGroup)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleJoinTroopResp:");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.e("NearFieldTroopHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject = null;
        paramBoolean = false;
      }
      if ((paramBoolean) && (paramObject != null))
      {
        notifyUI(3, paramBoolean, new Object[] { (nearfield_group.BusiRespHead)paramObject.msg_head.get(), String.valueOf(paramObject.uint64_group_code.get()) });
        return;
      }
    }
    notifyUI(3, false, null);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("NearfieldGroupSvr.ReqGetGroupList");
      this.allowCmdSet.add("NearfieldGroupSvr.ReqExit");
      this.allowCmdSet.add("NearfieldGroupSvr.ReqJoinGroup");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return NearFieldTroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null) {
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    } else {
      paramToServiceMsg = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive:");
      localStringBuilder.append(paramToServiceMsg);
      QLog.d("NearFieldTroopHandler", 2, localStringBuilder.toString());
    }
    if (msgCmdFilter(paramToServiceMsg))
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("cmdfilter error=");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.d("NearFieldTroopHandler", 2, paramFromServiceMsg.toString());
      }
      return;
    }
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if ("NearfieldGroupSvr.ReqGetGroupList".equalsIgnoreCase(paramToServiceMsg))
    {
      a(bool, paramObject);
      return;
    }
    if ("NearfieldGroupSvr.ReqExit".equalsIgnoreCase(paramToServiceMsg))
    {
      b(bool, paramObject);
      return;
    }
    if ("NearfieldGroupSvr.ReqJoinGroup".equalsIgnoreCase(paramToServiceMsg)) {
      c(bool, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearFieldTroopHandler
 * JD-Core Version:    0.7.0.1
 */