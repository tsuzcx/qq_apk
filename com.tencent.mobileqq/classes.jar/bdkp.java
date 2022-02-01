import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting.LocalWtTicketPromise.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class bdkp
  implements WtTicketPromise
{
  private arbo jdField_a_of_type_Arbo;
  private WeakReference<bdko> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bdkp(bdko parambdko, arbo paramarbo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambdko);
    this.jdField_a_of_type_Arbo = paramarbo;
  }
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._pskey_map != null))
    {
      ThreadManager.excute(new ConfigSetting.LocalWtTicketPromise.1(this), 128, null, false);
      return;
    }
    if (this.jdField_a_of_type_Arbo != null) {
      this.jdField_a_of_type_Arbo.a(false);
    }
    QLog.e("ConfigSetting", 2, "get pskey failed ticket is null");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("ConfigSetting", 2, "get pskey failed ticket failed");
    if (this.jdField_a_of_type_Arbo != null) {
      this.jdField_a_of_type_Arbo.a(false);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (this.jdField_a_of_type_Arbo != null) {
      this.jdField_a_of_type_Arbo.a(false);
    }
    QLog.e("ConfigSetting", 2, "get pskey failed ticket time oiut");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkp
 * JD-Core Version:    0.7.0.1
 */