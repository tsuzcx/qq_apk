import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.LocalWtTicketPromise.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class ayhi
  implements WtTicketPromise
{
  private anbr jdField_a_of_type_Anbr;
  private WeakReference<ayhh> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ayhi(ayhh paramayhh, anbr paramanbr)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramayhh);
    this.jdField_a_of_type_Anbr = paramanbr;
  }
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._pskey_map != null))
    {
      ThreadManager.excute(new ConfigSettingForDataLine.LocalWtTicketPromise.1(this), 128, null, false);
      return;
    }
    if (this.jdField_a_of_type_Anbr != null) {
      this.jdField_a_of_type_Anbr.a(false);
    }
    QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket is null");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket failed");
    if (this.jdField_a_of_type_Anbr != null) {
      this.jdField_a_of_type_Anbr.a(false);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (this.jdField_a_of_type_Anbr != null) {
      this.jdField_a_of_type_Anbr.a(false);
    }
    QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket time oiut");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhi
 * JD-Core Version:    0.7.0.1
 */