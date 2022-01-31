import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xdad.cmd0xdad.RspBody;

class azjx
  extends mmm
{
  azjx(azjq paramazjq, azjp paramazjp, wnb paramwnb) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null) || (this.jdField_a_of_type_Azjp == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0xdad. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.jdField_a_of_type_Azjp);
      }
      if (this.jdField_a_of_type_Azjp != null)
      {
        if (paramArrayOfByte != null) {
          paramBundle = new cmd0xdad.RspBody();
        }
      }
      else {
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = paramBundle.errmsg.get();
          this.jdField_a_of_type_Azjp.b(paramInt, paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0xdad. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
          }
          this.jdField_a_of_type_Azjp.a(-1, "InvalidProtocolBufferMicroException");
          return;
        }
      }
      this.jdField_a_of_type_Azjp.a(paramInt, "sso request error or callback is null.");
      return;
    }
    cmd0xdad.RspBody localRspBody;
    try
    {
      localRspBody = new cmd0xdad.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      paramInt = (int)localRspBody.retcode.get();
      if ((paramInt == 0) && (paramBundle != null))
      {
        this.jdField_a_of_type_Azjp.a(this.jdField_a_of_type_Wnb.a);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
      }
      this.jdField_a_of_type_Azjp.a(-1, "InvalidProtocolBufferMicroException");
      return;
    }
    paramArrayOfByte = localRspBody.errmsg.get();
    this.jdField_a_of_type_Azjp.b(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azjx
 * JD-Core Version:    0.7.0.1
 */