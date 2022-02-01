import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

class bjqg
  extends SSOAccountObserver
{
  bjqg(bjqa parambjqa, OpenSDKAppInterface paramOpenSDKAppInterface, bjqi parambjqi) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramBundle.getInt("code")))
    {
      QLog.d("SSOAccountObserver", 1, new Object[] { "-->getTicketNoPasswd onFailed", ", action", Integer.valueOf(paramInt1), ", code=", localObject });
      this.jdField_a_of_type_Bjqi.a(paramString, paramBundle);
      return;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.d("SSOAccountObserver", 1, "-->getTicketNoPasswd onGetTicketNoPasswd");
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      bjmq.a(paramString, System.currentTimeMillis());
    }
    WtloginManager localWtloginManager = (WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1);
    bjpl localbjpl = new bjpl();
    localbjpl.jdField_b_of_type_JavaLangString = new String(paramArrayOfByte);
    localbjpl.jdField_a_of_type_JavaLangString = Long.toString(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(localWtloginManager, paramString));
    localbjpl.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
    localbjpl.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    this.jdField_a_of_type_Bjqi.a(localbjpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjqg
 * JD-Core Version:    0.7.0.1
 */