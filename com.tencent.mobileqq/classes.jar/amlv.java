import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;

class amlv
  implements bavp
{
  amlv(amlp paramamlp, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(bavr parambavr, bavq parambavq)
  {
    try
    {
      parambavr = parambavr.a.getWupBuffer();
      parambavq = new structmsg.RspSystemMsgRead();
      parambavq.mergeFrom(parambavr);
      int i = parambavq.head.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp reqSeq=" + this.jdField_a_of_type_Long + ";resultCode=" + i + ";latestFriendSeq=" + this.b + ";latestGroupSeq=" + this.c);
      }
      return;
    }
    catch (Exception parambavr)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", parambavr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amlv
 * JD-Core Version:    0.7.0.1
 */