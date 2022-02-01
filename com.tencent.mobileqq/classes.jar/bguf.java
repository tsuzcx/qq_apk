import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

class bguf
  extends nkq
{
  bguf(bgty parambgty, bgug parambgug) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new cmd0x934.RspBody();
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      this.jdField_a_of_type_Bgug.a(paramInt, paramBundle);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(paramArrayOfByte));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguf
 * JD-Core Version:    0.7.0.1
 */