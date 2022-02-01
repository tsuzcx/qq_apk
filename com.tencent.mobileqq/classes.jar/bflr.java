import android.os.Bundle;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class bflr
  extends CheckConErroObserver
{
  bfls jdField_a_of_type_Bfls;
  bflt jdField_a_of_type_Bflt;
  
  public bflr(TroopFileProtoReqMgr paramTroopFileProtoReqMgr, bflt parambflt, bfls parambfls)
  {
    this.jdField_a_of_type_Bflt = parambflt;
    this.jdField_a_of_type_Bfls = parambfls;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = "";
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("msf_con_erro");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopFileProtoReqMgr", 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + paramBundle);
      }
      localObject1 = paramBundle;
      if (this.jdField_a_of_type_Bflt != null)
      {
        localObject2 = this.jdField_a_of_type_Bflt.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
        localObject1 = paramBundle;
        if (localObject2 != null)
        {
          ((FromServiceMsg)localObject2).addAttribute("_tag_socket_connerror", paramBundle);
          localObject1 = paramBundle;
        }
      }
    }
    if ((this.jdField_a_of_type_Bfls != null) && (this.jdField_a_of_type_Bfls.jdField_a_of_type_Ntf != null))
    {
      paramBundle = new Bundle();
      if (this.jdField_a_of_type_Bfls.jdField_a_of_type_AndroidOsBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_Bfls.jdField_a_of_type_AndroidOsBundle);
      }
      if ((this.jdField_a_of_type_Bflt != null) && (this.jdField_a_of_type_Bflt.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg != null))
      {
        paramBundle.putString("data_error_msg", this.jdField_a_of_type_Bflt.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailMsg());
        paramBundle.putInt("data_error_code", this.jdField_a_of_type_Bflt.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
        bfmf.a("TroopFileProtoReqMgr", bfmf.a, "cookie<" + this.jdField_a_of_type_Bflt.jdField_a_of_type_Bfls.b + "> onProtoResponse fail end. failCode:" + this.jdField_a_of_type_Bflt.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode() + " retryCount:" + this.jdField_a_of_type_Bflt.jdField_a_of_type_Anza.c + " msfConErro:" + (String)localObject1);
        this.jdField_a_of_type_Bfls.jdField_a_of_type_Ntf.a(-1, null, this.jdField_a_of_type_Bfls.jdField_a_of_type_AndroidOsBundle);
      }
    }
    else
    {
      return;
    }
    paramInt = bfmf.a;
    Object localObject2 = new StringBuilder().append("cookie<");
    if ((this.jdField_a_of_type_Bflt != null) && (this.jdField_a_of_type_Bflt.jdField_a_of_type_Bfls != null)) {}
    for (paramBundle = Long.valueOf(this.jdField_a_of_type_Bflt.jdField_a_of_type_Bfls.b);; paramBundle = "")
    {
      bfmf.a("TroopFileProtoReqMgr", paramInt, paramBundle + "> onProtoResponse fail end. msfConErro:" + (String)localObject1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bflr
 * JD-Core Version:    0.7.0.1
 */