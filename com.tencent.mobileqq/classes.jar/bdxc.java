import android.os.Bundle;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class bdxc
  extends CheckConErroObserver
{
  bdxe jdField_a_of_type_Bdxe;
  bdxf jdField_a_of_type_Bdxf;
  
  public bdxc(ProtoReqManager paramProtoReqManager, bdxf parambdxf, bdxe parambdxe)
  {
    this.jdField_a_of_type_Bdxf = parambdxf;
    this.jdField_a_of_type_Bdxe = parambdxe;
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
      if (this.jdField_a_of_type_Bdxf != null)
      {
        localObject = this.jdField_a_of_type_Bdxf.a;
        if (localObject != null) {
          ((FromServiceMsg)localObject).addAttribute("_tag_socket_connerror", paramBundle);
        }
      }
    }
    if (this.jdField_a_of_type_Bdxe.a != null) {
      this.jdField_a_of_type_Bdxe.a.a(this.jdField_a_of_type_Bdxf, this.jdField_a_of_type_Bdxe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdxc
 * JD-Core Version:    0.7.0.1
 */