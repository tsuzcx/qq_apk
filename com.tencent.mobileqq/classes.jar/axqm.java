import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class axqm
  extends axql
{
  private int jdField_a_of_type_Int;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new axqn(this);
  private AtomicBoolean c = new AtomicBoolean(false);
  
  axqm(axqk paramaxqk)
  {
    super(paramaxqk);
    this.jdField_a_of_type_JavaLangString = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.c;
    if (axqk.a(paramaxqk).jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localAtomicBoolean.set(bool);
      return;
      bool = false;
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.c, this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    if (((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).mSource_A_ActionData = axqk.a(this.jdField_b_of_type_Axqk).jdField_a_of_type_JavaLangString;
      ((AbsShareMsg)localObject).mSourceName = axqk.a(this.jdField_b_of_type_Axqk).b;
      ((AbsShareMsg)localObject).mSourceIcon = axqk.a(this.jdField_b_of_type_Axqk).d;
      ((AbsShareMsg)localObject).mSourceUrl = axqk.a(this.jdField_b_of_type_Axqk).c;
      ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
      this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.c, this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      this.jdField_b_of_type_Axqk.d(1002);
    }
  }
  
  void a(apih paramapih)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - axqk.b(this.jdField_b_of_type_Axqk)));
    }
    paramapih = paramapih.a(axqk.a(this.jdField_b_of_type_Axqk));
    axqk.a(this.jdField_b_of_type_Axqk).d = paramapih.a();
    axqk.a(this.jdField_b_of_type_Axqk).e = paramapih.e();
    if (paramapih.a())
    {
      if (!TextUtils.isEmpty(paramapih.d())) {
        axqk.a(this.jdField_b_of_type_Axqk).jdField_a_of_type_JavaLangString = paramapih.d();
      }
      if (!TextUtils.isEmpty(paramapih.c())) {
        axqk.a(this.jdField_b_of_type_Axqk).b = paramapih.c();
      }
      if ((!TextUtils.isEmpty(paramapih.b())) && (axqk.a(this.jdField_b_of_type_Axqk) != Long.parseLong("1103584836"))) {
        axqk.a(this.jdField_b_of_type_Axqk).c = paramapih.b();
      }
    }
    axqk.a(this.jdField_b_of_type_Axqk).jdField_a_of_type_Int = 1;
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
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|appId=" + axqk.a(this.jdField_b_of_type_Axqk) + ",pkgName=" + axqk.g(this.jdField_b_of_type_Axqk) + ",retry=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    axqk.a(this.jdField_b_of_type_Axqk, System.currentTimeMillis());
    switch (axqk.b(this.jdField_b_of_type_Axqk))
    {
    default: 
      return;
    case 2: 
      xdt.a(this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Axqk.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), axqk.a(this.jdField_b_of_type_Axqk), 0L, this.jdField_a_of_type_MqqObserverBusinessObserver, axqk.g(this.jdField_b_of_type_Axqk));
      return;
    }
    Object localObject = ((aply)this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a();
    if (((apih)localObject).a(axqk.a(this.jdField_b_of_type_Axqk)))
    {
      a((apih)localObject);
      return;
    }
    long l = axqk.b(this.jdField_b_of_type_Axqk) / 1000L;
    localObject = AgentActivity.a(this.jdField_b_of_type_Axqk.jdField_a_of_type_AndroidContentContext, axqk.g(this.jdField_b_of_type_Axqk), l + "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + (String)localObject);
    }
    xdt.a(this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Axqk.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), axqk.a(this.jdField_b_of_type_Axqk), (String)localObject, l, this.jdField_a_of_type_MqqObserverBusinessObserver, axqk.g(this.jdField_b_of_type_Axqk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axqm
 * JD-Core Version:    0.7.0.1
 */