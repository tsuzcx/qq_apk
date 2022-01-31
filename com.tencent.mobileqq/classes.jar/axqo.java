import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

class axqo
  extends axql
{
  private SSOAccountObserver a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  axqo(axqk paramaxqk)
  {
    super(paramaxqk);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new axqp(this);
    this.jdField_a_of_type_JavaLangString = "GetSKeyStep";
  }
  
  protected boolean a()
  {
    return (this.c.get()) && (!TextUtils.isEmpty(axqk.f(this.jdField_b_of_type_Axqk)));
  }
  
  protected void d()
  {
    String str = this.jdField_b_of_type_Axqk.a.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetSKeyStep|process|account=" + str + ",refresh=" + axqk.a(this.jdField_b_of_type_Axqk));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      f();
    }
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_Axqk.e())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + this.jdField_b_of_type_Axqk.a);
        this.jdField_b_of_type_Axqk.b(9366, "illegal app");
        c();
        return;
      }
      int i;
      if ((!axqk.a(this.jdField_b_of_type_Axqk)) && (!bcgd.a(str)))
      {
        str = ((TicketManager)this.jdField_b_of_type_Axqk.a.getManager(2)).getSkey(str);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          axqk.d(this.jdField_b_of_type_Axqk, str);
          this.c.set(true);
          b();
        }
      }
      while (i != 0)
      {
        this.jdField_b_of_type_Axqk.a.ssoGetTicketNoPasswd(this.jdField_b_of_type_Axqk.a.getCurrentAccountUin(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axqo
 * JD-Core Version:    0.7.0.1
 */