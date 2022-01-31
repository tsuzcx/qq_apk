import android.os.Bundle;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class ayti
  extends CheckConErroObserver
{
  aytk jdField_a_of_type_Aytk;
  aytl jdField_a_of_type_Aytl;
  
  public ayti(ProtoReqManager paramProtoReqManager, aytl paramaytl, aytk paramaytk)
  {
    this.jdField_a_of_type_Aytl = paramaytl;
    this.jdField_a_of_type_Aytk = paramaytk;
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
      if (this.jdField_a_of_type_Aytl != null)
      {
        localObject = this.jdField_a_of_type_Aytl.a;
        if (localObject != null) {
          ((FromServiceMsg)localObject).addAttribute("_tag_socket_connerror", paramBundle);
        }
      }
    }
    if (this.jdField_a_of_type_Aytk.a != null) {
      this.jdField_a_of_type_Aytk.a.a(this.jdField_a_of_type_Aytl, this.jdField_a_of_type_Aytk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayti
 * JD-Core Version:    0.7.0.1
 */