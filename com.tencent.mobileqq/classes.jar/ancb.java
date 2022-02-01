import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RspBody;
import com.tencent.qphone.base.util.QLog;

class ancb
  extends nmf
{
  ancb(anca paramanca) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new oidb_0x496.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        anca.a(this.a, paramBundle);
        anca.b(this.a, paramBundle);
        anca.c(this.a, paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("TroopHandler", 2, "getTroopConfig, e=" + paramArrayOfByte.toString());
        return;
      }
    }
    QLog.i("TroopHandler", 1, "getTroopConfig, errorCode=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancb
 * JD-Core Version:    0.7.0.1
 */