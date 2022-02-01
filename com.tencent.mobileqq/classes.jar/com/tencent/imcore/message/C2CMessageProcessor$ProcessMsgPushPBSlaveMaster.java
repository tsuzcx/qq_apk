package com.tencent.imcore.message;

import OnlinePushPack.DelMsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import msf.msgcomm.msg_comm.Msg;

public class C2CMessageProcessor$ProcessMsgPushPBSlaveMaster
{
  public C2CMessageProcessor a;
  public String a;
  private ArrayList<MessageRecord> a;
  public msg_comm.Msg a;
  public boolean a;
  private ArrayList<DelMsgInfo> b;
  private ArrayList<MessageRecord> c;
  
  public C2CMessageProcessor$ProcessMsgPushPBSlaveMaster(C2CMessageProcessor paramC2CMessageProcessor, msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList1, boolean paramBoolean, String paramString, ArrayList<DelMsgInfo> paramArrayList, ArrayList<MessageRecord> paramArrayList2)
  {
    this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg = paramMsg;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramArrayList;
    this.c = paramArrayList2;
    this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor = paramC2CMessageProcessor;
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: ");
      ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
      ((StringBuilder)localObject).append(" mr.msgtype: ");
      ((StringBuilder)localObject).append(paramMessageRecord.msgtype);
      ((StringBuilder)localObject).append(" mr.frienduin: ");
      ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
      ((StringBuilder)localObject).append(" mr.shmsgseq: ");
      ((StringBuilder)localObject).append(paramMessageRecord.shmsgseq);
      ((StringBuilder)localObject).append(" mr.time:");
      ((StringBuilder)localObject).append(paramMessageRecord.time);
      ((StringBuilder)localObject).append(" mr.msg: ");
      ((StringBuilder)localObject).append(paramMessageRecord.getLogColorContent());
      QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (paramMessageRecord.frienduin != null)
    {
      if (paramMessageRecord.frienduin.length() <= 2) {
        return;
      }
      paramMessageRecord.isread = true;
      paramMessageRecord.issend = 2;
      if (!C2CMessageProcessor.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramMessageRecord, this, this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor)) {
        ((IMessageFacade)this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).setReadFrom(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.time);
      }
      this.c.add(paramMessageRecord);
      localObject = new DelMsgInfo();
      ((DelMsgInfo)localObject).lFromUin = Long.parseLong(paramMessageRecord.senderuin);
      ((DelMsgInfo)localObject).shMsgSeq = ((short)(int)paramMessageRecord.shmsgseq);
      ((DelMsgInfo)localObject).uMsgTime = paramMessageRecord.time;
      this.b.add(localObject);
    }
  }
  
  public ProcessMsgPushPBSlaveMaster a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null)
    {
      if (localArrayList.size() <= 0) {
        return this;
      }
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessor.ProcessMsgPushPBSlaveMaster
 * JD-Core Version:    0.7.0.1
 */