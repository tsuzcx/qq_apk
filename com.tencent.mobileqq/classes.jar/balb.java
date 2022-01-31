import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x9e9.cmd0x9e9.RspBody;

class balb
  extends mxl
{
  balb(bakt parambakt, baks parambaks) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "requestGiftPoint. onResult error=" + paramInt + " data=" + paramArrayOfByte);
      }
      if (this.jdField_a_of_type_Baks != null) {
        this.jdField_a_of_type_Baks.a(paramInt, "sso request error or callback is null.");
      }
    }
    do
    {
      return;
      paramBundle = new cmd0x9e9.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        this.jdField_a_of_type_Baks.a(paramBundle.int64_total_point.get() / 100L);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.i(".troop.send_gift", 2, "requestGiftPoint. error=" + QLog.getStackTraceString(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     balb
 * JD-Core Version:    0.7.0.1
 */