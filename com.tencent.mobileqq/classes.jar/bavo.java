import android.os.Bundle;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class bavo
  extends CheckConErroObserver
{
  bavq jdField_a_of_type_Bavq;
  bavr jdField_a_of_type_Bavr;
  
  public bavo(ProtoReqManager paramProtoReqManager, bavr parambavr, bavq parambavq)
  {
    this.jdField_a_of_type_Bavr = parambavr;
    this.jdField_a_of_type_Bavq = parambavq;
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
      if (this.jdField_a_of_type_Bavr != null)
      {
        localObject = this.jdField_a_of_type_Bavr.a;
        if (localObject != null) {
          ((FromServiceMsg)localObject).addAttribute("_tag_socket_connerror", paramBundle);
        }
      }
    }
    if (this.jdField_a_of_type_Bavq.a != null) {
      this.jdField_a_of_type_Bavq.a.a(this.jdField_a_of_type_Bavr, this.jdField_a_of_type_Bavq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bavo
 * JD-Core Version:    0.7.0.1
 */