import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;

class aotq
  implements bevw
{
  aotq(aoti paramaoti, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(bevy parambevy, bevx parambevx)
  {
    try
    {
      parambevy = parambevy.a.getWupBuffer();
      parambevx = new structmsg.RspSystemMsgRead();
      parambevx.mergeFrom(parambevy);
      int i = parambevx.head.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendGroupSystemMsgReadedReportResp reqSeq=" + this.jdField_a_of_type_Long + ";resultCode=" + i + ";latestFriendSeq=" + this.b + ";latestGroupSeq=" + this.c);
      }
      return;
    }
    catch (Exception parambevy)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", parambevy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotq
 * JD-Core Version:    0.7.0.1
 */