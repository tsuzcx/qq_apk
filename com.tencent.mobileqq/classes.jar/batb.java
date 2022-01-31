import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

class batb
  extends basy
{
  private SSOAccountObserver a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  batb(basx parambasx)
  {
    super(parambasx);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new batc(this);
    this.jdField_a_of_type_JavaLangString = "GetSKeyStep";
  }
  
  protected boolean a()
  {
    return (this.c.get()) && (!TextUtils.isEmpty(basx.f(this.jdField_b_of_type_Basx)));
  }
  
  protected void d()
  {
    String str = this.jdField_b_of_type_Basx.a.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetSKeyStep|process|account=" + str + ",refresh=" + basx.a(this.jdField_b_of_type_Basx));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      f();
    }
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_Basx.e())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + this.jdField_b_of_type_Basx.a);
        this.jdField_b_of_type_Basx.b(9366, "illegal app");
        c();
        return;
      }
      int i;
      if (!basx.a(this.jdField_b_of_type_Basx))
      {
        str = ((TicketManager)this.jdField_b_of_type_Basx.a.getManager(2)).getSkey(str);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          basx.d(this.jdField_b_of_type_Basx, str);
          this.c.set(true);
          b();
        }
      }
      while (i != 0)
      {
        if (basx.b(this.jdField_b_of_type_Basx) == 11) {
          aseh.a("KEY_SSO_GET_TICKET_NO_PASSWD");
        }
        this.jdField_b_of_type_Basx.a.ssoGetTicketNoPasswd(this.jdField_b_of_type_Basx.a.getCurrentAccountUin(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batb
 * JD-Core Version:    0.7.0.1
 */