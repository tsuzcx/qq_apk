import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

class betn
  extends betk
{
  SSOAccountObserver a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  betn(betj parambetj)
  {
    super(parambetj);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new beto(this);
    this.jdField_a_of_type_JavaLangString = "GetSKeyStep";
  }
  
  protected boolean a()
  {
    return (this.c.get()) && (!TextUtils.isEmpty(betj.a(this.jdField_b_of_type_Betj)));
  }
  
  protected void d()
  {
    String str = this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|process|account=" + bjqq.a(str) + ",refresh=" + betj.a(this.jdField_b_of_type_Betj));
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      f();
    }
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_Betj.e())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_b_of_type_Betj.b(9366, "illegal app");
        c();
        return;
      }
      int i;
      if (!betj.a(this.jdField_b_of_type_Betj))
      {
        str = ((TicketManager)this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(str);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          betj.a(this.jdField_b_of_type_Betj, str);
          this.c.set(true);
          b();
        }
      }
      while (i != 0)
      {
        if (this.jdField_b_of_type_Betj.jdField_a_of_type_Int == 11) {
          avcw.a("KEY_SSO_GET_TICKET_NO_PASSWD");
        }
        this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ssoGetTicketNoPasswd(this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betn
 * JD-Core Version:    0.7.0.1
 */