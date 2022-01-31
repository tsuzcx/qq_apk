import android.os.Bundle;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class barf
  extends CheckConErroObserver
{
  barh jdField_a_of_type_Barh;
  bari jdField_a_of_type_Bari;
  
  public barf(ProtoReqManager paramProtoReqManager, bari parambari, barh parambarh)
  {
    this.jdField_a_of_type_Bari = parambari;
    this.jdField_a_of_type_Barh = parambarh;
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
      if (this.jdField_a_of_type_Bari != null)
      {
        localObject = this.jdField_a_of_type_Bari.a;
        if (localObject != null) {
          ((FromServiceMsg)localObject).addAttribute("_tag_socket_connerror", paramBundle);
        }
      }
    }
    if (this.jdField_a_of_type_Barh.a != null) {
      this.jdField_a_of_type_Barh.a.a(this.jdField_a_of_type_Bari, this.jdField_a_of_type_Barh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     barf
 * JD-Core Version:    0.7.0.1
 */