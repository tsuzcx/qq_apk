import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

class bdoj
  extends SSOAccountObserver
{
  bdoj(bdod parambdod, OpenSDKAppInterface paramOpenSDKAppInterface, bdol parambdol) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (paramString = "null";; paramString = Integer.valueOf(paramBundle.getInt("code")))
    {
      QLog.d("SSOAccountObserver", 1, new Object[] { "-->getTicketNoPasswd onFailed", ", action", Integer.valueOf(paramInt1), ", code=", paramString });
      this.jdField_a_of_type_Bdol.a();
      return;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.d("SSOAccountObserver", 1, "-->getTicketNoPasswd onGetTicketNoPasswd");
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      bdkt.a(paramString, System.currentTimeMillis());
    }
    WtloginManager localWtloginManager = (WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1);
    bdnp localbdnp = new bdnp();
    localbdnp.jdField_b_of_type_JavaLangString = new String(paramArrayOfByte);
    localbdnp.jdField_a_of_type_JavaLangString = Long.toString(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(localWtloginManager, paramString));
    localbdnp.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
    localbdnp.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    this.jdField_a_of_type_Bdol.a(localbdnp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdoj
 * JD-Core Version:    0.7.0.1
 */