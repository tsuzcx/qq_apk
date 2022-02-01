import android.os.Bundle;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class beeo
  extends CheckConErroObserver
{
  beep jdField_a_of_type_Beep;
  beeq jdField_a_of_type_Beeq;
  
  public beeo(TroopFileProtoReqMgr paramTroopFileProtoReqMgr, beeq parambeeq, beep parambeep)
  {
    this.jdField_a_of_type_Beeq = parambeeq;
    this.jdField_a_of_type_Beep = parambeep;
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
      if (this.jdField_a_of_type_Beeq != null)
      {
        FromServiceMsg localFromServiceMsg = this.jdField_a_of_type_Beeq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
        localObject = paramBundle;
        if (localFromServiceMsg != null)
        {
          localFromServiceMsg.addAttribute("_tag_socket_connerror", paramBundle);
          localObject = paramBundle;
        }
      }
    }
    if ((this.jdField_a_of_type_Beep != null) && (this.jdField_a_of_type_Beep.jdField_a_of_type_Nmf != null))
    {
      paramBundle = new Bundle();
      if (this.jdField_a_of_type_Beep.jdField_a_of_type_AndroidOsBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_Beep.jdField_a_of_type_AndroidOsBundle);
      }
      if ((this.jdField_a_of_type_Beeq == null) || (this.jdField_a_of_type_Beeq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null)) {
        break label294;
      }
      paramBundle.putString("data_error_msg", this.jdField_a_of_type_Beeq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailMsg());
      paramBundle.putInt("data_error_code", this.jdField_a_of_type_Beeq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
      befc.a("TroopFileProtoReqMgr", befc.a, "cookie<" + this.jdField_a_of_type_Beeq.jdField_a_of_type_Beep.b + "> onProtoResponse fail end. failCode:" + this.jdField_a_of_type_Beeq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode() + " retryCount:" + this.jdField_a_of_type_Beeq.jdField_a_of_type_Amwm.c + " msfConErro:" + (String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Beep.jdField_a_of_type_Nmf.a(-1, null, this.jdField_a_of_type_Beep.jdField_a_of_type_AndroidOsBundle);
      return;
      label294:
      befc.a("TroopFileProtoReqMgr", befc.a, "cookie<" + this.jdField_a_of_type_Beeq.jdField_a_of_type_Beep.b + "> onProtoResponse fail end. msfConErro:" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     beeo
 * JD-Core Version:    0.7.0.1
 */