import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class ayqv
  extends ayqu
{
  private int jdField_a_of_type_Int;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new ayqw(this);
  private AtomicBoolean c = new AtomicBoolean(false);
  
  ayqv(ayqt paramayqt)
  {
    super(paramayqt);
    this.jdField_a_of_type_JavaLangString = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.c;
    if (ayqt.a(paramayqt).jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localAtomicBoolean.set(bool);
      return;
      bool = false;
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.c, this.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
    if (((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).mSource_A_ActionData = ayqt.a(this.jdField_b_of_type_Ayqt).jdField_a_of_type_JavaLangString;
      ((AbsShareMsg)localObject).mSourceName = ayqt.a(this.jdField_b_of_type_Ayqt).b;
      ((AbsShareMsg)localObject).mSourceIcon = ayqt.a(this.jdField_b_of_type_Ayqt).d;
      ((AbsShareMsg)localObject).mSourceUrl = ayqt.a(this.jdField_b_of_type_Ayqt).c;
      ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
      this.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.c, this.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      this.jdField_b_of_type_Ayqt.d(1002);
    }
  }
  
  void a(aqas paramaqas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - ayqt.b(this.jdField_b_of_type_Ayqt)));
    }
    ayqt.a(this.jdField_b_of_type_Ayqt).d = paramaqas.a();
    ayqt.a(this.jdField_b_of_type_Ayqt).e = paramaqas.e();
    if (paramaqas.a())
    {
      if (!TextUtils.isEmpty(paramaqas.d())) {
        ayqt.a(this.jdField_b_of_type_Ayqt).jdField_a_of_type_JavaLangString = paramaqas.d();
      }
      if (!TextUtils.isEmpty(paramaqas.c())) {
        ayqt.a(this.jdField_b_of_type_Ayqt).b = paramaqas.c();
      }
      if ((!TextUtils.isEmpty(paramaqas.b())) && (ayqt.a(this.jdField_b_of_type_Ayqt) != Long.parseLong("1103584836"))) {
        ayqt.a(this.jdField_b_of_type_Ayqt).c = paramaqas.b();
      }
    }
    ayqt.a(this.jdField_b_of_type_Ayqt).jdField_a_of_type_Int = 1;
    g();
    this.c.set(true);
    b();
  }
  
  protected boolean a()
  {
    return this.c.get();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|appId=" + ayqt.a(this.jdField_b_of_type_Ayqt) + ",pkgName=" + ayqt.g(this.jdField_b_of_type_Ayqt) + ",retry=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    ayqt.a(this.jdField_b_of_type_Ayqt, System.currentTimeMillis());
    switch (ayqt.b(this.jdField_b_of_type_Ayqt))
    {
    default: 
      return;
    case 2: 
      xmq.a(this.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Ayqt.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ayqt.a(this.jdField_b_of_type_Ayqt), 0L, this.jdField_a_of_type_MqqObserverBusinessObserver, ayqt.g(this.jdField_b_of_type_Ayqt));
      return;
    }
    Object localObject = ((aqfo)this.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a(ayqt.a(this.jdField_b_of_type_Ayqt));
    if (localObject != null)
    {
      a((aqas)localObject);
      return;
    }
    long l = ayqt.b(this.jdField_b_of_type_Ayqt) / 1000L;
    localObject = AgentActivity.a(this.jdField_b_of_type_Ayqt.jdField_a_of_type_AndroidContentContext, ayqt.g(this.jdField_b_of_type_Ayqt), l + "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + (String)localObject);
    }
    xmq.a(this.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Ayqt.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ayqt.a(this.jdField_b_of_type_Ayqt), (String)localObject, l, this.jdField_a_of_type_MqqObserverBusinessObserver, ayqt.g(this.jdField_b_of_type_Ayqt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqv
 * JD-Core Version:    0.7.0.1
 */