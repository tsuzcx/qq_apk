package com.tencent.imcore.message;

import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.tencent.imcore.message.api.IOnLinePushMessageProcessorService;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.message.OnLinePushMsgTypeProcessorDispatcher;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class BaseOnLinePushMessageProcessor$ProcessOneMsg
{
  protected long a;
  protected MsgInfo a;
  protected SvcReqPushMsg a;
  protected FromServiceMsg a;
  protected String a;
  protected ArrayList<MessageRecord> a;
  protected boolean a;
  protected ArrayList<MsgInfo> b;
  protected boolean b;
  protected ArrayList<DelMsgInfo> c;
  protected ArrayList<String> d;
  
  public BaseOnLinePushMessageProcessor$ProcessOneMsg(BaseOnLinePushMessageProcessor paramBaseOnLinePushMessageProcessor, BaseOnLinePushMessageProcessor.ProcessOneMsgBuildParams paramProcessOneMsgBuildParams)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramProcessOneMsgBuildParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    this.jdField_a_of_type_OnlinePushPackSvcReqPushMsg = paramProcessOneMsgBuildParams.jdField_a_of_type_OnlinePushPackSvcReqPushMsg;
    this.jdField_a_of_type_JavaLangString = paramProcessOneMsgBuildParams.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaUtilArrayList = paramProcessOneMsgBuildParams.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_b_of_type_JavaUtilArrayList = paramProcessOneMsgBuildParams.jdField_b_of_type_JavaUtilArrayList;
    this.c = paramProcessOneMsgBuildParams.c;
    this.jdField_a_of_type_Long = paramProcessOneMsgBuildParams.jdField_a_of_type_Long;
    this.d = paramProcessOneMsgBuildParams.d;
    this.jdField_a_of_type_OnlinePushPackMsgInfo = paramProcessOneMsgBuildParams.jdField_a_of_type_OnlinePushPackMsgInfo;
    this.jdField_b_of_type_Boolean = paramProcessOneMsgBuildParams.jdField_a_of_type_Boolean;
  }
  
  private void a()
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_OnlinePushPackMsgInfo.uAppShareID > 0L)) {
      this.d.add(AppShareIDUtil.a(this.jdField_a_of_type_OnlinePushPackMsgInfo.uAppShareID));
    }
  }
  
  private void a(int paramInt)
  {
    if ((42 != paramInt) && (83 != paramInt) && (127 != paramInt) && (QLog.isColorLevel())) {
      MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: ");
      localStringBuilder.append(this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin);
      localStringBuilder.append(" msgInfo.shMsgType: ");
      localStringBuilder.append(this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgType);
      localStringBuilder.append(" msgInfo.uRealMsgTime: ");
      localStringBuilder.append(this.jdField_a_of_type_OnlinePushPackMsgInfo.uRealMsgTime);
      localStringBuilder.append(" msgInfo.shMsgSeq: ");
      localStringBuilder.append(this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq);
      localStringBuilder.append(", msgInfo.lMsgUid");
      localStringBuilder.append(this.jdField_a_of_type_OnlinePushPackMsgInfo.lMsgUid);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(Exception paramException)
  {
    paramException.printStackTrace();
    if ((this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg != null) && (QLog.isColorLevel()))
    {
      paramException = new StringBuilder();
      paramException.append("~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: ");
      paramException.append(HexUtil.bytes2HexStr(this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg));
      QLog.w("Q.msg.BaseMessageProcessor", 2, paramException.toString());
    }
  }
  
  private boolean a(SvcReqPushMsg paramSvcReqPushMsg, ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo, int paramInt)
  {
    paramSvcReqPushMsg = BaseOnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageBaseOnLinePushMessageProcessor, paramInt, paramMsgInfo, paramSvcReqPushMsg);
    if (paramSvcReqPushMsg != null)
    {
      if (paramSvcReqPushMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        paramArrayList.add(paramSvcReqPushMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (paramSvcReqPushMsg.jdField_a_of_type_Boolean) {
        return true;
      }
    }
    return false;
  }
  
  public ProcessOneMsg a()
  {
    try
    {
      int i = this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgType;
      long l1 = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
      long l2 = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
      DelMsgInfo localDelMsgInfo = new DelMsgInfo();
      ((IOnLinePushMessageProcessorService)QRoute.api(IOnLinePushMessageProcessorService.class)).changeBuddyOnline(this.jdField_a_of_type_ComTencentImcoreMessageBaseOnLinePushMessageProcessor.a, this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin);
      localDelMsgInfo.lFromUin = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
      localDelMsgInfo.shMsgSeq = this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq;
      localDelMsgInfo.uMsgTime = this.jdField_a_of_type_OnlinePushPackMsgInfo.uMsgTime;
      localDelMsgInfo.vMsgCookies = this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsgCookies;
      this.c.add(localDelMsgInfo);
      a(i);
      boolean bool = OnLinePushMsgTypeProcessorDispatcher.a().containsKey(Integer.valueOf(i));
      if (bool)
      {
        try
        {
          bool = a(this.jdField_a_of_type_OnlinePushPackSvcReqPushMsg, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_OnlinePushPackMsgInfo, i);
          if (bool)
          {
            this.jdField_a_of_type_Boolean = true;
            return this;
          }
          a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, 0, -1000, null, null, -1, l1, l2, false, this.jdField_b_of_type_Boolean);
        }
        catch (Exception localException1)
        {
          break label240;
        }
      }
      else
      {
        ProcessOneMsg localProcessOneMsg1 = this;
        try
        {
          bool = localProcessOneMsg1.a(localDelMsgInfo);
          if (!bool) {
            break label246;
          }
          return localProcessOneMsg1;
        }
        catch (Exception localException2) {}
      }
      a(localException3);
    }
    catch (Exception localException3) {}
    label240:
    label246:
    ProcessOneMsg localProcessOneMsg2 = this;
    a();
    localProcessOneMsg2.jdField_a_of_type_Boolean = false;
    return localProcessOneMsg2;
  }
  
  protected void a(ArrayList<MessageRecord> paramArrayList, long paramLong1, MsgInfo paramMsgInfo, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, int paramInt3, long paramLong2, long paramLong3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (paramString == null) {
        return;
      }
      MessageRecord localMessageRecord = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramInt2);
      if (paramInt1 == 1006)
      {
        IOnLinePushMessageProcessorService localIOnLinePushMessageProcessorService = (IOnLinePushMessageProcessorService)QRoute.api(IOnLinePushMessageProcessorService.class);
        String str = localIOnLinePushMessageProcessorService.getPhoneNumByUin(this.jdField_a_of_type_ComTencentImcoreMessageBaseOnLinePushMessageProcessor.a, String.valueOf(paramLong2));
        localMessageRecord.init(String.valueOf(paramLong1), localIOnLinePushMessageProcessorService.getPhoneNumByUin(this.jdField_a_of_type_ComTencentImcoreMessageBaseOnLinePushMessageProcessor.a, String.valueOf(paramLong3)), str, paramString, paramMsgInfo.uRealMsgTime, paramInt2, paramInt1, paramMsgInfo.uMsgTime);
      }
      else
      {
        localMessageRecord.init(paramLong1, paramLong3, paramLong2, paramString, paramMsgInfo.uRealMsgTime, paramInt2, paramInt1, paramMsgInfo.uMsgTime);
      }
      localMessageRecord.shmsgseq = paramMsgInfo.shMsgSeq;
      localMessageRecord.isread = paramBoolean1;
      localMessageRecord.msgUid = paramMsgInfo.lMsgUid;
      localMessageRecord.msgData = paramArrayOfByte;
      if (paramInt3 > 0) {
        localMessageRecord.setExtraFlag(paramInt3);
      }
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentImcoreMessageBaseOnLinePushMessageProcessor.a, localMessageRecord, true)) {
        paramArrayList.add(localMessageRecord);
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("----------handleC2COnlinePushMsgResp after analysis friendUin: ");
        paramArrayList.append(paramLong3);
        paramArrayList.append(" msgType: ");
        paramArrayList.append(paramInt2);
        paramArrayList.append(" friendType: ");
        paramArrayList.append(paramInt1);
        paramArrayList.append(" shMsgSeq: ");
        paramArrayList.append(paramMsgInfo.shMsgSeq);
        paramArrayList.append(" msgContent: ");
        paramArrayList.append(MessageRecordUtil.a(paramString));
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramArrayList.toString());
      }
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean a(DelMsgInfo paramDelMsgInfo)
  {
    return true;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseOnLinePushMessageProcessor.ProcessOneMsg
 * JD-Core Version:    0.7.0.1
 */