package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss.NotifyList;
import tencent.im.nearfield_discuss.nearfield_discuss.ReqExit;
import tencent.im.nearfield_discuss.nearfield_discuss.ReqGetList;
import tencent.im.nearfield_discuss.nearfield_discuss.ReqJoinDiscuss;
import tencent.im.nearfield_discuss.nearfield_discuss.RespGetList;
import tencent.im.nearfield_discuss.nearfield_discuss.RespJoinDiscuss;

@KeepClassConstructor
public class NearFieldDiscussHandler
  extends BusinessHandler
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  byte[] jdField_a_of_type_ArrayOfByte;
  
  NearFieldDiscussHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<<---handleError serviceCmd:");
    localStringBuilder.append(str);
    QLog.i("NearFieldDiscussHandler", 1, localStringBuilder.toString());
    if ("NearFieldDiscussSvr.ReqJoinDiscuss".equals(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    "NearFieldDiscussSvr.ReqGetList".equals(str);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<<---handleTimeOut serviceCmd:");
    localStringBuilder.append(str);
    QLog.i("NearFieldDiscussHandler", 1, localStringBuilder.toString());
    if ("NearFieldDiscussSvr.ReqJoinDiscuss".equals(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("NearFieldDiscussSvr.ReqGetList".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearFieldDiscussHandler", 2, "handleGetFaceToFaceDiscussInfo");
    }
    int j = paramToServiceMsg.extraData.getInt("session_id", -1);
    int i = paramToServiceMsg.extraData.getInt("join_type", -1);
    int n = paramToServiceMsg.extraData.getInt("from", 0);
    Object localObject = "";
    if (bool1) {}
    for (;;)
    {
      try
      {
        nearfield_discuss.RespJoinDiscuss localRespJoinDiscuss = new nearfield_discuss.RespJoinDiscuss();
        localRespJoinDiscuss.mergeFrom((byte[])paramObject);
        k = ((nearfield_discuss.BusiRespHead)localRespJoinDiscuss.msg_head.get()).int32_reply_code.get();
        if (k != 0) {
          break label645;
        }
        bool1 = true;
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetFaceToFaceDiscussInfo retCOde = ");
        paramFromServiceMsg.append(k);
        paramFromServiceMsg.append(" joinType = ");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append(" sessionId = ");
        paramFromServiceMsg.append(j);
        QLog.i("NearFieldDiscussHandler", 1, paramFromServiceMsg.toString());
        k = j;
        m = i;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        bool2 = bool1;
        if (!bool1) {
          break label611;
        }
        long l = Utils.a(localRespJoinDiscuss.uint32_discuss_id.get());
        ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(l);
        paramFromServiceMsg = String.valueOf(l);
        k = j;
        try
        {
          bool2 = localRespJoinDiscuss.bool_is_creater.get();
          k = j;
          j = localRespJoinDiscuss.uint32_session_id.get();
          k = j;
          m = localRespJoinDiscuss.uint32_join_type.get();
          if ((bool2) && (m == 2)) {}
          try
          {
            paramToServiceMsg = paramToServiceMsg.extraData.getString("FACE_TO_FACE_ID");
            ((ITroopCreateGrayMsg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopCreateGrayMsg.class, "")).addCreateNewTroopGrayTips(paramFromServiceMsg, false, paramToServiceMsg);
            paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            paramObject = new StringBuilder();
            paramObject.append("");
            paramObject.append(paramFromServiceMsg);
            paramObject = paramObject.toString();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("");
            ((StringBuilder)localObject).append(n);
            ReportController.b(paramToServiceMsg, "dc00899", "Grp_create_new", "", "suc_create", "face_create", 0, 0, paramObject, ((StringBuilder)localObject).toString(), "", "");
            if (m == 2)
            {
              paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy();
              if (paramToServiceMsg.b(paramFromServiceMsg, 1) != null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("NearFieldDiscussHandler", 2, "handleGetFaceToFaceDiscussInfo ru alreadyintab");
                }
              }
              else
              {
                paramObject = paramToServiceMsg.a(paramFromServiceMsg, 1);
                RecentUtil.a(paramObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade());
                paramObject.uin = paramFromServiceMsg;
                paramObject.lastmsgtime = MessageCache.a();
                paramObject.type = 1;
                paramToServiceMsg.b(paramObject);
                paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
                if (paramToServiceMsg != null) {
                  paramToServiceMsg.sendMessage(paramToServiceMsg.obtainMessage(1009));
                }
              }
            }
          }
          catch (Exception paramToServiceMsg)
          {
            i = m;
            continue;
          }
          k = j;
          bool2 = bool1;
        }
        catch (Exception paramToServiceMsg)
        {
          j = k;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearFieldDiscussHandler", 2, "handleGetFaceToFaceDiscussInfo exp", paramToServiceMsg);
      }
      boolean bool2 = false;
      int k = j;
      int m = i;
      break label611;
      bool2 = bool1;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      m = i;
      k = j;
      label611:
      notifyUI(1020, bool2, new Object[] { Integer.valueOf(k), paramFromServiceMsg, Integer.valueOf(m) });
      return;
      label645:
      bool1 = false;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1021, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearFieldDiscussHandler", 2, "handleNotifyPush");
    }
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int j = -1;
    int i = j;
    boolean bool2 = bool1;
    if (bool1) {
      try
      {
        paramToServiceMsg = new nearfield_discuss.NotifyList();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          bool1 = false;
        }
        i = paramToServiceMsg.uint32_session_id.get();
        bool2 = bool1;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearFieldDiscussHandler", 2, "handleNotifyPush exp", paramToServiceMsg);
        }
        bool2 = false;
        i = j;
      }
    }
    notifyUI(1022, bool2, new Object[] { Integer.valueOf(i) });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1020, false, new Object[] { Integer.valueOf(paramToServiceMsg.extraData.getInt("session_id")) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleGetFaceToFaceMemberListResp isSuccess:");
    paramToServiceMsg.append(bool1);
    paramToServiceMsg.append("  ResultCode:");
    paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
    QLog.i("NearFieldDiscussHandler", 1, paramToServiceMsg.toString());
    paramFromServiceMsg = null;
    boolean bool2 = bool1;
    if (bool1) {
      paramToServiceMsg = new nearfield_discuss.RespGetList();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (Exception paramToServiceMsg)
    {
      label104:
      int i;
      int j;
      int k;
      int m;
      long l;
      break label104;
    }
    paramToServiceMsg = null;
    boolean bool1 = false;
    bool2 = bool1;
    if (paramToServiceMsg != null)
    {
      bool2 = bool1;
      if (bool1)
      {
        if (paramToServiceMsg.rpt_msg_user_list.has()) {
          paramFromServiceMsg = paramToServiceMsg.rpt_msg_user_list.get();
        }
        i = 60000;
        if (paramToServiceMsg.int32_update_interval.has()) {
          i = paramToServiceMsg.int32_update_interval.get();
        }
        if (paramToServiceMsg.bytes_cookie.has()) {
          this.jdField_a_of_type_ArrayOfByte = paramToServiceMsg.bytes_cookie.get().toByteArray();
        }
        if (paramToServiceMsg.uint32_session_id.has()) {
          j = paramToServiceMsg.uint32_session_id.get();
        } else {
          j = 0;
        }
        paramObject = new nearfield_discuss.BusiRespHead();
        if (paramToServiceMsg.msg_head.has())
        {
          paramObject.int32_reply_code.set(paramToServiceMsg.msg_head.int32_reply_code.get());
          paramObject.str_result.set(paramToServiceMsg.msg_head.str_result.get());
        }
        if (paramToServiceMsg.uint32_button_switch.has()) {
          k = paramToServiceMsg.uint32_button_switch.get();
        } else {
          k = 0;
        }
        if (paramToServiceMsg.uint32_has_created.has()) {
          m = paramToServiceMsg.uint32_has_created.get();
        } else {
          m = 0;
        }
        l = 0L;
        if (paramToServiceMsg.uint64_creator.has()) {
          l = paramToServiceMsg.uint64_creator.get();
        }
        notifyUI(1021, bool1, new Object[] { paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j), paramObject, Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l) });
        return;
      }
    }
    notifyUI(1021, bool2, null);
  }
  
  public void a(String paramString, int paramInt, nearfield_discuss.LBSInfo paramLBSInfo)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("NearFieldDiscussSvr.ReqExit");
    nearfield_discuss.ReqExit localReqExit = new nearfield_discuss.ReqExit();
    if (paramLBSInfo != null) {
      localReqExit.msg_lbs_info.set(paramLBSInfo);
    }
    localReqExit.str_number.set(paramString);
    localReqExit.uint32_session_id.set(paramInt);
    localToServiceMsg.putWupBuffer(localReqExit.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt1, nearfield_discuss.LBSInfo paramLBSInfo, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getNearFieldDiscussInfo hallId=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" sessionId=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" joinType:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("NearFieldDiscussHandler", 1, ((StringBuilder)localObject).toString());
    localObject = new nearfield_discuss.ReqJoinDiscuss();
    ((nearfield_discuss.ReqJoinDiscuss)localObject).str_number.set(paramString);
    if (paramLBSInfo != null) {
      ((nearfield_discuss.ReqJoinDiscuss)localObject).msg_lbs_info.set(paramLBSInfo);
    }
    ((nearfield_discuss.ReqJoinDiscuss)localObject).uint32_session_id.set(paramInt1);
    ((nearfield_discuss.ReqJoinDiscuss)localObject).uint32_join_type.set(paramInt2);
    paramLBSInfo = createToServiceMsg("NearFieldDiscussSvr.ReqJoinDiscuss");
    paramLBSInfo.extraData.putString("FACE_TO_FACE_ID", paramString);
    paramLBSInfo.extraData.putInt("session_id", paramInt1);
    paramLBSInfo.extraData.putInt("join_type", paramInt2);
    paramLBSInfo.extraData.putInt("from", paramInt3);
    paramLBSInfo.putWupBuffer(((nearfield_discuss.ReqJoinDiscuss)localObject).toByteArray());
    paramLBSInfo.setTimeout(30000L);
    sendPbReq(paramLBSInfo);
  }
  
  public void a(String paramString, int paramInt, nearfield_discuss.LBSInfo paramLBSInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get list | sessionId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" | digits = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("NearFieldDiscussHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = createToServiceMsg("NearFieldDiscussSvr.ReqGetList");
    nearfield_discuss.ReqGetList localReqGetList = new nearfield_discuss.ReqGetList();
    if (paramLBSInfo != null) {
      localReqGetList.msg_lbs_info.set(paramLBSInfo);
    }
    localReqGetList.str_number.set(paramString);
    localReqGetList.uint32_session_id.set(paramInt);
    if ((!paramBoolean) && (this.jdField_a_of_type_ArrayOfByte != null)) {
      localReqGetList.bytes_cookie.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
    }
    ((ToServiceMsg)localObject).putWupBuffer(localReqGetList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("NearFieldDiscussSvr.ReqJoinDiscuss");
      this.allowCmdSet.add("NearFieldDiscussSvr.ReqGetList");
      this.allowCmdSet.add("NearFieldDiscussSvr.ReqExit");
      this.allowCmdSet.add("NearFieldDiscussSvr.NotifyList");
    }
    return this.allowCmdSet;
  }
  
  public Set<String> getPushPBCommandList()
  {
    return new NearFieldDiscussHandler.1(this);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return NearFieldDiscussObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("NearFieldDiscussHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if (paramFromServiceMsg.getResultCode() == 1002)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("NearFieldDiscussSvr.ReqJoinDiscuss".equalsIgnoreCase(str))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("NearFieldDiscussSvr.NotifyList".equalsIgnoreCase(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("NearFieldDiscussSvr.ReqGetList".equalsIgnoreCase(str))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    "NearFieldDiscussSvr.ReqExit".equalsIgnoreCase(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearFieldDiscussHandler
 * JD-Core Version:    0.7.0.1
 */