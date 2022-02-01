import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

class bdut
  extends bduq
{
  private SSOAccountObserver a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  bdut(bdup parambdup)
  {
    super(parambdup);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bduu(this);
    this.jdField_a_of_type_JavaLangString = "GetSKeyStep";
  }
  
  protected boolean a()
  {
    return (this.c.get()) && (!TextUtils.isEmpty(bdup.f(this.jdField_b_of_type_Bdup)));
  }
  
  protected void d()
  {
    String str = this.jdField_b_of_type_Bdup.a.getCurrentAccountUin();
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|process|account=" + bipr.a(str) + ",refresh=" + bdup.a(this.jdField_b_of_type_Bdup));
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      f();
    }
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_Bdup.e())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + this.jdField_b_of_type_Bdup.a);
        this.jdField_b_of_type_Bdup.b(9366, "illegal app");
        c();
        return;
      }
      int i;
      if (!bdup.a(this.jdField_b_of_type_Bdup))
      {
        str = ((TicketManager)this.jdField_b_of_type_Bdup.a.getManager(2)).getSkey(str);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          bdup.d(this.jdField_b_of_type_Bdup, str);
          this.c.set(true);
          b();
        }
      }
      while (i != 0)
      {
        if (bdup.b(this.jdField_b_of_type_Bdup) == 11) {
          aukw.a("KEY_SSO_GET_TICKET_NO_PASSWD");
        }
        this.jdField_b_of_type_Bdup.a.ssoGetTicketNoPasswd(this.jdField_b_of_type_Bdup.a.getCurrentAccountUin(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdut
 * JD-Core Version:    0.7.0.1
 */