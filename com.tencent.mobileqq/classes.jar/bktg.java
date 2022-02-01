import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class bktg
  implements bkvn
{
  bktg(bktf parambktf) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && (paramObject != null)) {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "server reply packet");
      }
    }
    try
    {
      paramToServiceMsg = new QSecCloudAVEngineMsg.QSecCloudRespBody();
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      bktf.a(this.a).sendMessage(bktf.a(this.a).obtainMessage(4, paramToServiceMsg));
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktg
 * JD-Core Version:    0.7.0.1
 */