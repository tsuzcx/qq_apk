import android.os.Bundle;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class ayro
  extends CheckConErroObserver
{
  ayrp jdField_a_of_type_Ayrp;
  ayrq jdField_a_of_type_Ayrq;
  
  public ayro(TroopFileProtoReqMgr paramTroopFileProtoReqMgr, ayrq paramayrq, ayrp paramayrp)
  {
    this.jdField_a_of_type_Ayrq = paramayrq;
    this.jdField_a_of_type_Ayrp = paramayrp;
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
      if (this.jdField_a_of_type_Ayrq != null)
      {
        FromServiceMsg localFromServiceMsg = this.jdField_a_of_type_Ayrq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
        localObject = paramBundle;
        if (localFromServiceMsg != null)
        {
          localFromServiceMsg.addAttribute("_tag_socket_connerror", paramBundle);
          localObject = paramBundle;
        }
      }
    }
    if ((this.jdField_a_of_type_Ayrp != null) && (this.jdField_a_of_type_Ayrp.jdField_a_of_type_Mmn != null))
    {
      paramBundle = new Bundle();
      if (this.jdField_a_of_type_Ayrp.jdField_a_of_type_AndroidOsBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_Ayrp.jdField_a_of_type_AndroidOsBundle);
      }
      if (this.jdField_a_of_type_Ayrq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null) {
        break label287;
      }
      paramBundle.putString("data_error_msg", this.jdField_a_of_type_Ayrq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailMsg());
      paramBundle.putInt("data_error_code", this.jdField_a_of_type_Ayrq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
      aysb.a("TroopFileProtoReqMgr", aysb.a, "cookie<" + this.jdField_a_of_type_Ayrq.jdField_a_of_type_Ayrp.b + "> onProtoResponse fail end. failCode:" + this.jdField_a_of_type_Ayrq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode() + " retryCount:" + this.jdField_a_of_type_Ayrq.jdField_a_of_type_Ajmn.c + " msfConErro:" + (String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ayrp.jdField_a_of_type_Mmn.a(-1, null, this.jdField_a_of_type_Ayrp.jdField_a_of_type_AndroidOsBundle);
      return;
      label287:
      aysb.a("TroopFileProtoReqMgr", aysb.a, "cookie<" + this.jdField_a_of_type_Ayrq.jdField_a_of_type_Ayrp.b + "> onProtoResponse fail end. msfConErro:" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayro
 * JD-Core Version:    0.7.0.1
 */