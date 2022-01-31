import android.os.Bundle;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class aytg
  extends CheckConErroObserver
{
  ayti jdField_a_of_type_Ayti;
  aytj jdField_a_of_type_Aytj;
  
  public aytg(ProtoReqManager paramProtoReqManager, aytj paramaytj, ayti paramayti)
  {
    this.jdField_a_of_type_Aytj = paramaytj;
    this.jdField_a_of_type_Ayti = paramayti;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getString("msf_con_erro");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + paramBundle);
      }
      if (this.jdField_a_of_type_Aytj != null)
      {
        localObject = this.jdField_a_of_type_Aytj.a;
        if (localObject != null) {
          ((FromServiceMsg)localObject).addAttribute("_tag_socket_connerror", paramBundle);
        }
      }
    }
    if (this.jdField_a_of_type_Ayti.a != null) {
      this.jdField_a_of_type_Ayti.a.a(this.jdField_a_of_type_Aytj, this.jdField_a_of_type_Ayti);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aytg
 * JD-Core Version:    0.7.0.1
 */