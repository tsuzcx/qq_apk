import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class apvp
  extends WtloginObserver
{
  apvp(apvn paramapvn, apvq paramapvq) {}
  
  public void onGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.LoginHandler", 2, "OnGetOpenKeyWithoutPasswd userAccount=" + paramString + ", dwSrcAppid=" + paramLong1 + ", dwDstAppid=" + paramLong2 + ", dwMainSigMap=" + paramInt1 + ", ret=" + paramInt2);
    }
    apvn.a(this.jdField_a_of_type_Apvn, null);
    if (paramInt2 == 0)
    {
      paramArrayOfByte1 = util.buf_to_string(paramArrayOfByte1);
      paramArrayOfByte2 = util.buf_to_string(paramArrayOfByte2);
      this.jdField_a_of_type_Apvq.a(paramString, paramLong2, paramArrayOfByte1, paramArrayOfByte2);
      return;
    }
    this.jdField_a_of_type_Apvq.a(null, 0L, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvp
 * JD-Core Version:    0.7.0.1
 */