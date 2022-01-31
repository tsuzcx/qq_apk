import android.os.Bundle;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class azsg
  extends CheckConErroObserver
{
  azsh jdField_a_of_type_Azsh;
  azsi jdField_a_of_type_Azsi;
  
  public azsg(TroopFileProtoReqMgr paramTroopFileProtoReqMgr, azsi paramazsi, azsh paramazsh)
  {
    this.jdField_a_of_type_Azsi = paramazsi;
    this.jdField_a_of_type_Azsh = paramazsh;
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
      if (this.jdField_a_of_type_Azsi != null)
      {
        FromServiceMsg localFromServiceMsg = this.jdField_a_of_type_Azsi.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
        localObject = paramBundle;
        if (localFromServiceMsg != null)
        {
          localFromServiceMsg.addAttribute("_tag_socket_connerror", paramBundle);
          localObject = paramBundle;
        }
      }
    }
    if ((this.jdField_a_of_type_Azsh != null) && (this.jdField_a_of_type_Azsh.jdField_a_of_type_Mxj != null))
    {
      paramBundle = new Bundle();
      if (this.jdField_a_of_type_Azsh.jdField_a_of_type_AndroidOsBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_Azsh.jdField_a_of_type_AndroidOsBundle);
      }
      if (this.jdField_a_of_type_Azsi.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null) {
        break label287;
      }
      paramBundle.putString("data_error_msg", this.jdField_a_of_type_Azsi.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailMsg());
      paramBundle.putInt("data_error_code", this.jdField_a_of_type_Azsi.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
      azst.a("TroopFileProtoReqMgr", azst.a, "cookie<" + this.jdField_a_of_type_Azsi.jdField_a_of_type_Azsh.b + "> onProtoResponse fail end. failCode:" + this.jdField_a_of_type_Azsi.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode() + " retryCount:" + this.jdField_a_of_type_Azsi.jdField_a_of_type_Akau.c + " msfConErro:" + (String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Azsh.jdField_a_of_type_Mxj.a(-1, null, this.jdField_a_of_type_Azsh.jdField_a_of_type_AndroidOsBundle);
      return;
      label287:
      azst.a("TroopFileProtoReqMgr", azst.a, "cookie<" + this.jdField_a_of_type_Azsi.jdField_a_of_type_Azsh.b + "> onProtoResponse fail end. msfConErro:" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azsg
 * JD-Core Version:    0.7.0.1
 */