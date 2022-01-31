import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;

class amhg
  implements barg
{
  amhg(amha paramamha, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(bari parambari, barh parambarh)
  {
    try
    {
      parambari = parambari.a.getWupBuffer();
      parambarh = new structmsg.RspSystemMsgRead();
      parambarh.mergeFrom(parambari);
      int i = parambarh.head.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp reqSeq=" + this.jdField_a_of_type_Long + ";resultCode=" + i + ";latestFriendSeq=" + this.b + ";latestGroupSeq=" + this.c);
      }
      return;
    }
    catch (Exception parambari)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", parambari);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhg
 * JD-Core Version:    0.7.0.1
 */