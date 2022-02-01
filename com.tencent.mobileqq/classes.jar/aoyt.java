import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.RspBody;

class aoyt
  implements aoyz
{
  aoyt(aoys paramaoys) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_cmd0xe27.RspBody paramRspBody)
  {
    long l = paramRspBody.uint32_test_keep_silence_sec.get();
    paramToServiceMsg = this.a;
    if (l <= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      aoys.a(paramToServiceMsg, bool);
      if (l > 0L)
      {
        aoys.a(this.a).removeMessages(6);
        aoys.a(this.a).sendEmptyMessageDelayed(6, l);
        if (QLog.isColorLevel()) {
          QLog.d("FrontBackReportManager", 2, "receive keep silence");
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyt
 * JD-Core Version:    0.7.0.1
 */