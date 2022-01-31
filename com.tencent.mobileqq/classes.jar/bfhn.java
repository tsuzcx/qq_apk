import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class bfhn
  implements bfju
{
  bfhn(bfhm parambfhm) {}
  
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
      bfhm.a(this.a).sendMessage(bfhm.a(this.a).obtainMessage(4, paramToServiceMsg));
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfhn
 * JD-Core Version:    0.7.0.1
 */