import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;

class aogk
  implements bdxd
{
  aogk(aogd paramaogd, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    try
    {
      parambdxf = parambdxf.a.getWupBuffer();
      parambdxe = new structmsg.RspSystemMsgRead();
      parambdxe.mergeFrom(parambdxf);
      int i = parambdxe.head.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp reqSeq=" + this.jdField_a_of_type_Long + ";resultCode=" + i + ";latestFriendSeq=" + this.b + ";latestGroupSeq=" + this.c);
      }
      return;
    }
    catch (Exception parambdxf)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", parambdxf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogk
 * JD-Core Version:    0.7.0.1
 */