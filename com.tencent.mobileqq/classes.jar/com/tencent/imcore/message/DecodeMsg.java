package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;

public class DecodeMsg
{
  private msg_comm.UinPairMsg a;
  private long b;
  private ArrayList<MessageRecord> c;
  private ArrayList<msg_comm.Msg> d;
  private StringBuilder e;
  private DecodeProtoPkgContext f;
  private int g;
  private C2CMessageProcessor h;
  
  public DecodeMsg(C2CMessageProcessor paramC2CMessageProcessor, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, ArrayList<MessageRecord> paramArrayList, ArrayList<msg_comm.Msg> paramArrayList1, StringBuilder paramStringBuilder, DecodeProtoPkgContext paramDecodeProtoPkgContext, int paramInt)
  {
    this.a = paramUinPairMsg;
    this.b = paramLong;
    this.c = paramArrayList;
    this.d = paramArrayList1;
    this.e = paramStringBuilder;
    this.f = paramDecodeProtoPkgContext;
    this.g = paramInt;
    this.h = paramC2CMessageProcessor;
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    return C2CMessageProcessor.u.a(this.h.q, paramLong2, paramLong1, this.a.peer_uin.get(), this.a);
  }
  
  private static void a(DecodeProtoPkgContext paramDecodeProtoPkgContext, ArrayList<MessageRecord> paramArrayList, C2CMessageProcessor paramC2CMessageProcessor, long paramLong1, long paramLong2, List<MessageRecord> paramList)
  {
    C2CMessageProcessor.u.a(paramC2CMessageProcessor, paramArrayList, paramLong1, paramLong2, paramList, paramDecodeProtoPkgContext);
  }
  
  public DecodeMsg a()
  {
    for (;;)
    {
      try
      {
        Object localObject = (msg_comm.Msg)this.d.get(this.g);
        msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get();
        if (!((msg_comm.Msg)localObject).msg_head.has())
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("<---decodeC2CMessagePackage: msgList[");
            ((StringBuilder)localObject).append(this.g);
            ((StringBuilder)localObject).append("] : msg doesn't has msgHead.");
            QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject).toString());
            return this;
          }
        }
        else
        {
          long l3 = localMsgHead.to_uin.get();
          long l1 = localMsgHead.from_uin.get();
          long l4 = localMsgHead.from_uin.get();
          long l2 = localMsgHead.msg_time.get();
          long l5 = this.b;
          bool1 = false;
          if (l2 <= l5) {
            break label304;
          }
          bool2 = false;
          l3 = a(l3, l4);
          this.f.o = true;
          this.f.t = String.valueOf(l3);
          if (C2CMessageProcessor.a(this.e, this.g, bool1, l2, l3, this.h.q)) {
            return this;
          }
          this.f.g = bool1;
          this.f.x = l3;
          this.f.n = bool2;
          localObject = this.h.a((msg_comm.Msg)localObject, this.f);
          a(this.f, this.c, this.h, l1, l3, (List)localObject);
          return this;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException);
        }
        return this;
      }
      return this;
      label304:
      boolean bool1 = true;
      boolean bool2 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.DecodeMsg
 * JD-Core Version:    0.7.0.1
 */