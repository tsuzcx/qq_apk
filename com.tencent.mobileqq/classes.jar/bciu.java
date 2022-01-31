import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class bciu
  extends mxj
{
  bciu(bciq parambciq, bcix parambcix) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bcix != null)
    {
      paramBundle = new oidb_0x8e4.RspBody();
      if (paramArrayOfByte == null) {}
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      this.jdField_a_of_type_Bcix.a(paramInt, paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bciu
 * JD-Core Version:    0.7.0.1
 */