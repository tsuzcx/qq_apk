import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting.LocalWtTicketPromise.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class axha
  implements WtTicketPromise
{
  private ammm jdField_a_of_type_Ammm;
  private WeakReference<axgz> jdField_a_of_type_JavaLangRefWeakReference;
  
  public axha(axgz paramaxgz, ammm paramammm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaxgz);
    this.jdField_a_of_type_Ammm = paramammm;
  }
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._pskey_map != null))
    {
      ThreadManager.excute(new ConfigSetting.LocalWtTicketPromise.1(this), 128, null, false);
      return;
    }
    if (this.jdField_a_of_type_Ammm != null) {
      this.jdField_a_of_type_Ammm.a(false);
    }
    QLog.e("ConfigSetting", 2, "get pskey failed ticket is null");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("ConfigSetting", 2, "get pskey failed ticket failed");
    if (this.jdField_a_of_type_Ammm != null) {
      this.jdField_a_of_type_Ammm.a(false);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (this.jdField_a_of_type_Ammm != null) {
      this.jdField_a_of_type_Ammm.a(false);
    }
    QLog.e("ConfigSetting", 2, "get pskey failed ticket time oiut");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axha
 * JD-Core Version:    0.7.0.1
 */