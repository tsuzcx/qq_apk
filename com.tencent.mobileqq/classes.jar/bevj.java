import android.os.Bundle;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class bevj
  extends CheckConErroObserver
{
  bevk jdField_a_of_type_Bevk;
  bevl jdField_a_of_type_Bevl;
  
  public bevj(TroopFileProtoReqMgr paramTroopFileProtoReqMgr, bevl parambevl, bevk parambevk)
  {
    this.jdField_a_of_type_Bevl = parambevl;
    this.jdField_a_of_type_Bevk = parambevk;
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
      if (this.jdField_a_of_type_Bevl != null)
      {
        FromServiceMsg localFromServiceMsg = this.jdField_a_of_type_Bevl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
        localObject = paramBundle;
        if (localFromServiceMsg != null)
        {
          localFromServiceMsg.addAttribute("_tag_socket_connerror", paramBundle);
          localObject = paramBundle;
        }
      }
    }
    if ((this.jdField_a_of_type_Bevk != null) && (this.jdField_a_of_type_Bevk.jdField_a_of_type_Niv != null))
    {
      paramBundle = new Bundle();
      if (this.jdField_a_of_type_Bevk.jdField_a_of_type_AndroidOsBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_Bevk.jdField_a_of_type_AndroidOsBundle);
      }
      if (this.jdField_a_of_type_Bevl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null) {
        break label287;
      }
      paramBundle.putString("data_error_msg", this.jdField_a_of_type_Bevl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailMsg());
      paramBundle.putInt("data_error_code", this.jdField_a_of_type_Bevl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
      bevx.a("TroopFileProtoReqMgr", bevx.a, "cookie<" + this.jdField_a_of_type_Bevl.jdField_a_of_type_Bevk.b + "> onProtoResponse fail end. failCode:" + this.jdField_a_of_type_Bevl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode() + " retryCount:" + this.jdField_a_of_type_Bevl.jdField_a_of_type_Anqe.c + " msfConErro:" + (String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bevk.jdField_a_of_type_Niv.a(-1, null, this.jdField_a_of_type_Bevk.jdField_a_of_type_AndroidOsBundle);
      return;
      label287:
      bevx.a("TroopFileProtoReqMgr", bevx.a, "cookie<" + this.jdField_a_of_type_Bevl.jdField_a_of_type_Bevk.b + "> onProtoResponse fail end. msfConErro:" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bevj
 * JD-Core Version:    0.7.0.1
 */