import android.os.Bundle;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

class bflx
  extends SSOAccountObserver
{
  bflx(bflw parambflw) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Bfly != null) {
      this.a.jdField_a_of_type_Bfly.a();
    }
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 == 0)
    {
      paramBundle = new WloginSimpleInfo();
      if (this.a.jdField_a_of_type_MqqManagerWtloginManager != null) {
        this.a.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, paramBundle);
      }
      paramString = "" + paramBundle._uin;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        util.LOGD("outA1 buff: " + util.buf_to_string(paramArrayOfByte));
        paramArrayOfByte = new RSACrypt(bfbm.a().a()).EncryptData(this.a.a(bfbm.a().a(), this.a.jdField_a_of_type_Long, 1L), paramArrayOfByte);
        util.LOGD("encrypt buff:" + util.buf_to_string(paramArrayOfByte));
        if (this.a.jdField_a_of_type_Bfly != null) {
          this.a.jdField_a_of_type_Bfly.a(paramString, paramArrayOfByte);
        }
      }
    }
    while (this.a.jdField_a_of_type_Bfly == null) {
      return;
    }
    this.a.jdField_a_of_type_Bfly.a();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Bfly != null) {
      this.a.jdField_a_of_type_Bfly.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bflx
 * JD-Core Version:    0.7.0.1
 */