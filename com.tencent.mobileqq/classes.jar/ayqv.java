import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

class ayqv
  extends ayqs
{
  private SSOAccountObserver a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  ayqv(ayqr paramayqr)
  {
    super(paramayqr);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new ayqw(this);
    this.jdField_a_of_type_JavaLangString = "GetSKeyStep";
  }
  
  protected boolean a()
  {
    return (this.c.get()) && (!TextUtils.isEmpty(ayqr.f(this.jdField_b_of_type_Ayqr)));
  }
  
  protected void d()
  {
    String str = this.jdField_b_of_type_Ayqr.a.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetSKeyStep|process|account=" + str + ",refresh=" + ayqr.a(this.jdField_b_of_type_Ayqr));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      f();
    }
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_Ayqr.e())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + this.jdField_b_of_type_Ayqr.a);
        this.jdField_b_of_type_Ayqr.b(9366, "illegal app");
        c();
        return;
      }
      int i;
      if (!ayqr.a(this.jdField_b_of_type_Ayqr))
      {
        str = ((TicketManager)this.jdField_b_of_type_Ayqr.a.getManager(2)).getSkey(str);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          ayqr.d(this.jdField_b_of_type_Ayqr, str);
          this.c.set(true);
          b();
        }
      }
      while (i != 0)
      {
        if (ayqr.b(this.jdField_b_of_type_Ayqr) == 11) {
          aqgh.a("KEY_SSO_GET_TICKET_NO_PASSWD");
        }
        this.jdField_b_of_type_Ayqr.a.ssoGetTicketNoPasswd(this.jdField_b_of_type_Ayqr.a.getCurrentAccountUin(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqv
 * JD-Core Version:    0.7.0.1
 */