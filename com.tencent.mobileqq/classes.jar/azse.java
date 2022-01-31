import android.os.Bundle;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class azse
  extends CheckConErroObserver
{
  azsf jdField_a_of_type_Azsf;
  azsg jdField_a_of_type_Azsg;
  
  public azse(TroopFileProtoReqMgr paramTroopFileProtoReqMgr, azsg paramazsg, azsf paramazsf)
  {
    this.jdField_a_of_type_Azsg = paramazsg;
    this.jdField_a_of_type_Azsf = paramazsf;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = "";
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("msf_con_erro");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopFileProtoReqMgr", 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + paramBundle);
      }
      localObject = paramBundle;
      if (this.jdField_a_of_type_Azsg != null)
      {
        FromServiceMsg localFromServiceMsg = this.jdField_a_of_type_Azsg.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
        localObject = paramBundle;
        if (localFromServiceMsg != null)
        {
          localFromServiceMsg.addAttribute("_tag_socket_connerror", paramBundle);
          localObject = paramBundle;
        }
      }
    }
    if ((this.jdField_a_of_type_Azsf != null) && (this.jdField_a_of_type_Azsf.jdField_a_of_type_Mxm != null))
    {
      paramBundle = new Bundle();
      if (this.jdField_a_of_type_Azsf.jdField_a_of_type_AndroidOsBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_Azsf.jdField_a_of_type_AndroidOsBundle);
      }
      if (this.jdField_a_of_type_Azsg.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null) {
        break label287;
      }
      paramBundle.putString("data_error_msg", this.jdField_a_of_type_Azsg.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailMsg());
      paramBundle.putInt("data_error_code", this.jdField_a_of_type_Azsg.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
      azsr.a("TroopFileProtoReqMgr", azsr.a, "cookie<" + this.jdField_a_of_type_Azsg.jdField_a_of_type_Azsf.b + "> onProtoResponse fail end. failCode:" + this.jdField_a_of_type_Azsg.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode() + " retryCount:" + this.jdField_a_of_type_Azsg.jdField_a_of_type_Akaw.c + " msfConErro:" + (String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Azsf.jdField_a_of_type_Mxm.a(-1, null, this.jdField_a_of_type_Azsf.jdField_a_of_type_AndroidOsBundle);
      return;
      label287:
      azsr.a("TroopFileProtoReqMgr", azsr.a, "cookie<" + this.jdField_a_of_type_Azsg.jdField_a_of_type_Azsf.b + "> onProtoResponse fail end. msfConErro:" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azse
 * JD-Core Version:    0.7.0.1
 */