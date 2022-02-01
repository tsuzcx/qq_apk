import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.LocalWtTicketPromise.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class bedm
  implements WtTicketPromise
{
  private arpy jdField_a_of_type_Arpy;
  private WeakReference<bedl> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bedm(bedl parambedl, arpy paramarpy)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambedl);
    this.jdField_a_of_type_Arpy = paramarpy;
  }
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._pskey_map != null))
    {
      ThreadManager.excute(new ConfigSettingForDataLine.LocalWtTicketPromise.1(this), 128, null, false);
      return;
    }
    if (this.jdField_a_of_type_Arpy != null) {
      this.jdField_a_of_type_Arpy.a(false);
    }
    QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket is null");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket failed");
    if (this.jdField_a_of_type_Arpy != null) {
      this.jdField_a_of_type_Arpy.a(false);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (this.jdField_a_of_type_Arpy != null) {
      this.jdField_a_of_type_Arpy.a(false);
    }
    QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket time oiut");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedm
 * JD-Core Version:    0.7.0.1
 */