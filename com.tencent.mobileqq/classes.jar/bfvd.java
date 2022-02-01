import android.os.Bundle;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class bfvd
  extends CheckConErroObserver
{
  bfve jdField_a_of_type_Bfve;
  bfvf jdField_a_of_type_Bfvf;
  
  public bfvd(TroopFileProtoReqMgr paramTroopFileProtoReqMgr, bfvf parambfvf, bfve parambfve)
  {
    this.jdField_a_of_type_Bfvf = parambfvf;
    this.jdField_a_of_type_Bfve = parambfve;
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
      if (this.jdField_a_of_type_Bfvf != null)
      {
        FromServiceMsg localFromServiceMsg = this.jdField_a_of_type_Bfvf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
        localObject = paramBundle;
        if (localFromServiceMsg != null)
        {
          localFromServiceMsg.addAttribute("_tag_socket_connerror", paramBundle);
          localObject = paramBundle;
        }
      }
    }
    if ((this.jdField_a_of_type_Bfve != null) && (this.jdField_a_of_type_Bfve.jdField_a_of_type_Nkq != null))
    {
      paramBundle = new Bundle();
      if (this.jdField_a_of_type_Bfve.jdField_a_of_type_AndroidOsBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_Bfve.jdField_a_of_type_AndroidOsBundle);
      }
      if (this.jdField_a_of_type_Bfvf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null) {
        break label287;
      }
      paramBundle.putString("data_error_msg", this.jdField_a_of_type_Bfvf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailMsg());
      paramBundle.putInt("data_error_code", this.jdField_a_of_type_Bfvf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
      bfvr.a("TroopFileProtoReqMgr", bfvr.a, "cookie<" + this.jdField_a_of_type_Bfvf.jdField_a_of_type_Bfve.b + "> onProtoResponse fail end. failCode:" + this.jdField_a_of_type_Bfvf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode() + " retryCount:" + this.jdField_a_of_type_Bfvf.jdField_a_of_type_Aock.c + " msfConErro:" + (String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfve.jdField_a_of_type_Nkq.a(-1, null, this.jdField_a_of_type_Bfve.jdField_a_of_type_AndroidOsBundle);
      return;
      label287:
      bfvr.a("TroopFileProtoReqMgr", bfvr.a, "cookie<" + this.jdField_a_of_type_Bfvf.jdField_a_of_type_Bfve.b + "> onProtoResponse fail end. msfConErro:" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfvd
 * JD-Core Version:    0.7.0.1
 */