import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class ayqt
  extends ayqs
{
  private int jdField_a_of_type_Int;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new ayqu(this);
  private AtomicBoolean c = new AtomicBoolean(false);
  
  ayqt(ayqr paramayqr)
  {
    super(paramayqr);
    this.jdField_a_of_type_JavaLangString = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.c;
    if (ayqr.a(paramayqr).jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localAtomicBoolean.set(bool);
      return;
      bool = false;
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.c, this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    if (((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).mSource_A_ActionData = ayqr.a(this.jdField_b_of_type_Ayqr).jdField_a_of_type_JavaLangString;
      ((AbsShareMsg)localObject).mSourceName = ayqr.a(this.jdField_b_of_type_Ayqr).b;
      ((AbsShareMsg)localObject).mSourceIcon = ayqr.a(this.jdField_b_of_type_Ayqr).d;
      ((AbsShareMsg)localObject).mSourceUrl = ayqr.a(this.jdField_b_of_type_Ayqr).c;
      ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
      this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.c, this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      this.jdField_b_of_type_Ayqr.d(1002);
    }
  }
  
  void a(aqaq paramaqaq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - ayqr.b(this.jdField_b_of_type_Ayqr)));
    }
    ayqr.a(this.jdField_b_of_type_Ayqr).d = paramaqaq.a();
    ayqr.a(this.jdField_b_of_type_Ayqr).e = paramaqaq.e();
    if (paramaqaq.a())
    {
      if (!TextUtils.isEmpty(paramaqaq.d())) {
        ayqr.a(this.jdField_b_of_type_Ayqr).jdField_a_of_type_JavaLangString = paramaqaq.d();
      }
      if (!TextUtils.isEmpty(paramaqaq.c())) {
        ayqr.a(this.jdField_b_of_type_Ayqr).b = paramaqaq.c();
      }
      if ((!TextUtils.isEmpty(paramaqaq.b())) && (ayqr.a(this.jdField_b_of_type_Ayqr) != Long.parseLong("1103584836"))) {
        ayqr.a(this.jdField_b_of_type_Ayqr).c = paramaqaq.b();
      }
    }
    ayqr.a(this.jdField_b_of_type_Ayqr).jdField_a_of_type_Int = 1;
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
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|appId=" + ayqr.a(this.jdField_b_of_type_Ayqr) + ",pkgName=" + ayqr.g(this.jdField_b_of_type_Ayqr) + ",retry=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    ayqr.a(this.jdField_b_of_type_Ayqr, System.currentTimeMillis());
    switch (ayqr.b(this.jdField_b_of_type_Ayqr))
    {
    default: 
      return;
    case 2: 
      xmt.a(this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Ayqr.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ayqr.a(this.jdField_b_of_type_Ayqr), 0L, this.jdField_a_of_type_MqqObserverBusinessObserver, ayqr.g(this.jdField_b_of_type_Ayqr));
      return;
    }
    Object localObject = ((aqfm)this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a(ayqr.a(this.jdField_b_of_type_Ayqr));
    if (localObject != null)
    {
      a((aqaq)localObject);
      return;
    }
    long l = ayqr.b(this.jdField_b_of_type_Ayqr) / 1000L;
    localObject = AgentActivity.a(this.jdField_b_of_type_Ayqr.jdField_a_of_type_AndroidContentContext, ayqr.g(this.jdField_b_of_type_Ayqr), l + "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + (String)localObject);
    }
    xmt.a(this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Ayqr.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ayqr.a(this.jdField_b_of_type_Ayqr), (String)localObject, l, this.jdField_a_of_type_MqqObserverBusinessObserver, ayqr.g(this.jdField_b_of_type_Ayqr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqt
 * JD-Core Version:    0.7.0.1
 */