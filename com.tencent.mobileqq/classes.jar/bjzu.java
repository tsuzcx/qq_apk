import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

class bjzu
  extends SSOAccountObserver
{
  bjzu(bjzo parambjzo, OpenSDKAppInterface paramOpenSDKAppInterface, bjzw parambjzw) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramBundle.getInt("code")))
    {
      QLog.d("SSOAccountObserver", 1, new Object[] { "-->getTicketNoPasswd onFailed", ", action", Integer.valueOf(paramInt1), ", code=", localObject });
      this.jdField_a_of_type_Bjzw.a(paramString, paramBundle);
      return;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.d("SSOAccountObserver", 1, "-->getTicketNoPasswd onGetTicketNoPasswd");
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      bjwg.a(paramString, System.currentTimeMillis());
    }
    WtloginManager localWtloginManager = (WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1);
    bjzb localbjzb = new bjzb();
    localbjzb.jdField_b_of_type_JavaLangString = new String(paramArrayOfByte);
    localbjzb.jdField_a_of_type_JavaLangString = Long.toString(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(localWtloginManager, paramString));
    localbjzb.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
    localbjzb.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    this.jdField_a_of_type_Bjzw.a(localbjzb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjzu
 * JD-Core Version:    0.7.0.1
 */