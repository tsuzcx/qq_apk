import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

class baos
  extends baop
{
  private SSOAccountObserver a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  baos(baoo parambaoo)
  {
    super(parambaoo);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new baot(this);
    this.jdField_a_of_type_JavaLangString = "GetSKeyStep";
  }
  
  protected boolean a()
  {
    return (this.c.get()) && (!TextUtils.isEmpty(baoo.f(this.jdField_b_of_type_Baoo)));
  }
  
  protected void d()
  {
    String str = this.jdField_b_of_type_Baoo.a.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetSKeyStep|process|account=" + str + ",refresh=" + baoo.a(this.jdField_b_of_type_Baoo));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      f();
    }
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_Baoo.e())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + this.jdField_b_of_type_Baoo.a);
        this.jdField_b_of_type_Baoo.b(9366, "illegal app");
        c();
        return;
      }
      int i;
      if (!baoo.a(this.jdField_b_of_type_Baoo))
      {
        str = ((TicketManager)this.jdField_b_of_type_Baoo.a.getManager(2)).getSkey(str);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          baoo.d(this.jdField_b_of_type_Baoo, str);
          this.c.set(true);
          b();
        }
      }
      while (i != 0)
      {
        if (baoo.b(this.jdField_b_of_type_Baoo) == 11) {
          arzy.a("KEY_SSO_GET_TICKET_NO_PASSWD");
        }
        this.jdField_b_of_type_Baoo.a.ssoGetTicketNoPasswd(this.jdField_b_of_type_Baoo.a.getCurrentAccountUin(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baos
 * JD-Core Version:    0.7.0.1
 */