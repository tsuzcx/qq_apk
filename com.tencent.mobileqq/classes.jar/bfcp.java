import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xdad.cmd0xdad.RspBody;

class bfcp
  extends nme
{
  bfcp(bfci parambfci, bfch parambfch, zsy paramzsy) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null) || (this.jdField_a_of_type_Bfch == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0xdad. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.jdField_a_of_type_Bfch);
      }
      if (this.jdField_a_of_type_Bfch != null)
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
          this.jdField_a_of_type_Bfch.b(paramInt, paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0xdad. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
          }
          this.jdField_a_of_type_Bfch.a(-1, "InvalidProtocolBufferMicroException");
          return;
        }
      }
      this.jdField_a_of_type_Bfch.a(paramInt, "sso request error or callback is null.");
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
        this.jdField_a_of_type_Bfch.a(this.jdField_a_of_type_Zsy.a);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
      }
      this.jdField_a_of_type_Bfch.a(-1, "InvalidProtocolBufferMicroException");
      return;
    }
    paramArrayOfByte = localRspBody.errmsg.get();
    this.jdField_a_of_type_Bfch.b(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfcp
 * JD-Core Version:    0.7.0.1
 */