import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class biue
  extends nkq
{
  biue(bitz parambitz, biug parambiug) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Biug != null)
    {
      paramBundle = new oidb_0x8ed.RspBody();
      if (paramArrayOfByte == null) {}
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      this.jdField_a_of_type_Biug.a(paramInt, paramBundle);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WerewolvesHandler", 2, paramArrayOfByte.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biue
 * JD-Core Version:    0.7.0.1
 */