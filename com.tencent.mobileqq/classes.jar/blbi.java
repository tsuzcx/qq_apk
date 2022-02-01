import android.os.Bundle;
import com.tencent.ims.SafeReport.RspBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QSecRptControllerImpl;

public class blbi
  extends nkq
{
  public blbi(QSecRptControllerImpl paramQSecRptControllerImpl) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new SafeReport.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if ((paramBundle.uint32_result.has()) && (QLog.isColorLevel())) {
        QLog.d("QSRPT", 2, String.format("report result: %d", new Object[] { Integer.valueOf(paramBundle.uint32_result.get()) }));
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbi
 * JD-Core Version:    0.7.0.1
 */