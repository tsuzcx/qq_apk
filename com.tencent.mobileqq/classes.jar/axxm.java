import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.nearby.nearby_ice_break.IceRsp;

class axxm
  implements aydk
{
  axxm(axxj paramaxxj) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new nearby_ice_break.IceRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (paramBundle.result.has())
      {
        if (paramBundle.result.get() == 0)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("NearbyCardHandler", 2, "sendPoBingMsg. success");
          return;
        }
        QLog.e("NearbyCardHandler", 1, "sendPoBingMsg. result=" + paramBundle.result.get() + " errorMsg=" + paramBundle.err_msg.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("NearbyCardHandler", 1, "sendPoBingMsg. error=" + QLog.getStackTraceString(paramArrayOfByte));
      return;
    }
    QLog.e("NearbyCardHandler", 1, "sendPoBingMsg. no result");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxm
 * JD-Core Version:    0.7.0.1
 */