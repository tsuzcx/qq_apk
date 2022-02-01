import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class apyz
  extends WtloginObserver
{
  apyz(apyx paramapyx, apza paramapza) {}
  
  public void onGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.LoginHandler", 2, "OnGetOpenKeyWithoutPasswd userAccount=" + paramString + ", dwSrcAppid=" + paramLong1 + ", dwDstAppid=" + paramLong2 + ", dwMainSigMap=" + paramInt1 + ", ret=" + paramInt2);
    }
    apyx.a(this.jdField_a_of_type_Apyx, null);
    if (paramInt2 == 0)
    {
      paramArrayOfByte1 = util.buf_to_string(paramArrayOfByte1);
      paramArrayOfByte2 = util.buf_to_string(paramArrayOfByte2);
      this.jdField_a_of_type_Apza.a(paramString, paramLong2, paramArrayOfByte1, paramArrayOfByte2);
      return;
    }
    this.jdField_a_of_type_Apza.a(null, 0L, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyz
 * JD-Core Version:    0.7.0.1
 */