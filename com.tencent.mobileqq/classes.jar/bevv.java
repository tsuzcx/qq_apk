import android.os.Bundle;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class bevv
  extends CheckConErroObserver
{
  bevx jdField_a_of_type_Bevx;
  bevy jdField_a_of_type_Bevy;
  
  public bevv(ProtoReqManager paramProtoReqManager, bevy parambevy, bevx parambevx)
  {
    this.jdField_a_of_type_Bevy = parambevy;
    this.jdField_a_of_type_Bevx = parambevx;
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
      if (this.jdField_a_of_type_Bevy != null)
      {
        localObject = this.jdField_a_of_type_Bevy.a;
        if (localObject != null) {
          ((FromServiceMsg)localObject).addAttribute("_tag_socket_connerror", paramBundle);
        }
      }
    }
    if (this.jdField_a_of_type_Bevx.a != null) {
      this.jdField_a_of_type_Bevx.a.a(this.jdField_a_of_type_Bevy, this.jdField_a_of_type_Bevx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bevv
 * JD-Core Version:    0.7.0.1
 */