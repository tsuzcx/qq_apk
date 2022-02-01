import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

class bfsz
  extends nis
{
  bfsz(bfst parambfst, bfss parambfss) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new oidb_0x962.RspBody();
    if (paramArrayOfByte != null) {}
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (this.jdField_a_of_type_Bfss != null) {
        this.jdField_a_of_type_Bfss.a(paramInt, paramBundle);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_gift", 2, "send_oidb_0x962. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsz
 * JD-Core Version:    0.7.0.1
 */