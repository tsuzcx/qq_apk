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
  public msg_comm.Msg a;
  public boolean b;
  public String c;
  public C2CMessageProcessor d;
  private ArrayList<MessageRecord> e;
  private ArrayList<DelMsgInfo> f;
  private ArrayList<MessageRecord> g;
  
  public C2CMessageProcessor$ProcessMsgPushPBSlaveMaster(C2CMessageProcessor paramC2CMessageProcessor, msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList1, boolean paramBoolean, String paramString, ArrayList<DelMsgInfo> paramArrayList, ArrayList<MessageRecord> paramArrayList2)
  {
    this.a = paramMsg;
    this.e = paramArrayList1;
    this.b = paramBoolean;
    this.c = paramString;
    this.f = paramArrayList;
    this.g = paramArrayList2;
    this.d = paramC2CMessageProcessor;
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
      if (!C2CMessageProcessor.u.a(paramMessageRecord, this, this.d)) {
        ((IMessageFacade)this.d.q.getRuntimeService(IMessageFacade.class, "")).setReadFrom(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.time);
      }
      this.g.add(paramMessageRecord);
      localObject = new DelMsgInfo();
      ((DelMsgInfo)localObject).lFromUin = Long.parseLong(paramMessageRecord.senderuin);
      ((DelMsgInfo)localObject).shMsgSeq = ((short)(int)paramMessageRecord.shmsgseq);
      ((DelMsgInfo)localObject).uMsgTime = paramMessageRecord.time;
      this.f.add(localObject);
    }
  }
  
  public ProcessMsgPushPBSlaveMaster a()
  {
    ArrayList localArrayList = this.e;
    if (localArrayList != null)
    {
      if (localArrayList.size() <= 0) {
        return this;
      }
      int j = this.e.size();
      int i = 0;
      while (i < j)
      {
        a((MessageRecord)this.e.get(i));
        i += 1;
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessor.ProcessMsgPushPBSlaveMaster
 * JD-Core Version:    0.7.0.1
 */