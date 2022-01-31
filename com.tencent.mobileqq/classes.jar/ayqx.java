import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

class ayqx
  extends ayqu
{
  private SSOAccountObserver a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  ayqx(ayqt paramayqt)
  {
    super(paramayqt);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new ayqy(this);
    this.jdField_a_of_type_JavaLangString = "GetSKeyStep";
  }
  
  protected boolean a()
  {
    return (this.c.get()) && (!TextUtils.isEmpty(ayqt.f(this.jdField_b_of_type_Ayqt)));
  }
  
  protected void d()
  {
    String str = this.jdField_b_of_type_Ayqt.a.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetSKeyStep|process|account=" + str + ",refresh=" + ayqt.a(this.jdField_b_of_type_Ayqt));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      f();
    }
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_Ayqt.e())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + this.jdField_b_of_type_Ayqt.a);
        this.jdField_b_of_type_Ayqt.b(9366, "illegal app");
        c();
        return;
      }
      int i;
      if (!ayqt.a(this.jdField_b_of_type_Ayqt))
      {
        str = ((TicketManager)this.jdField_b_of_type_Ayqt.a.getManager(2)).getSkey(str);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          ayqt.d(this.jdField_b_of_type_Ayqt, str);
          this.c.set(true);
          b();
        }
      }
      while (i != 0)
      {
        if (ayqt.b(this.jdField_b_of_type_Ayqt) == 11) {
          aqgj.a("KEY_SSO_GET_TICKET_NO_PASSWD");
        }
        this.jdField_b_of_type_Ayqt.a.ssoGetTicketNoPasswd(this.jdField_b_of_type_Ayqt.a.getCurrentAccountUin(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqx
 * JD-Core Version:    0.7.0.1
 */