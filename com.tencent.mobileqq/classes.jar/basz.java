import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class basz
  extends basy
{
  private int jdField_a_of_type_Int;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new bata(this);
  private AtomicBoolean c = new AtomicBoolean(false);
  
  basz(basx parambasx)
  {
    super(parambasx);
    this.jdField_a_of_type_JavaLangString = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.c;
    if (basx.a(parambasx).jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localAtomicBoolean.set(bool);
      return;
      bool = false;
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.c, this.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    if (((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).mSource_A_ActionData = basx.a(this.jdField_b_of_type_Basx).jdField_a_of_type_JavaLangString;
      ((AbsShareMsg)localObject).mSourceName = basx.a(this.jdField_b_of_type_Basx).b;
      ((AbsShareMsg)localObject).mSourceIcon = basx.a(this.jdField_b_of_type_Basx).d;
      ((AbsShareMsg)localObject).mSourceUrl = basx.a(this.jdField_b_of_type_Basx).c;
      ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
      this.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.c, this.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      this.jdField_b_of_type_Basx.d(1002);
    }
  }
  
  void a(aryj paramaryj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - basx.b(this.jdField_b_of_type_Basx)));
    }
    basx.a(this.jdField_b_of_type_Basx).d = paramaryj.a();
    basx.a(this.jdField_b_of_type_Basx).e = paramaryj.e();
    if (paramaryj.a())
    {
      if (!TextUtils.isEmpty(paramaryj.d())) {
        basx.a(this.jdField_b_of_type_Basx).jdField_a_of_type_JavaLangString = paramaryj.d();
      }
      if (!TextUtils.isEmpty(paramaryj.c())) {
        basx.a(this.jdField_b_of_type_Basx).b = paramaryj.c();
      }
      if ((!TextUtils.isEmpty(paramaryj.b())) && (basx.a(this.jdField_b_of_type_Basx) != Long.parseLong("1103584836"))) {
        basx.a(this.jdField_b_of_type_Basx).c = paramaryj.b();
      }
    }
    basx.a(this.jdField_b_of_type_Basx).jdField_a_of_type_Int = 1;
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
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|appId=" + basx.a(this.jdField_b_of_type_Basx) + ",pkgName=" + basx.g(this.jdField_b_of_type_Basx) + ",retry=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    basx.a(this.jdField_b_of_type_Basx, System.currentTimeMillis());
    switch (basx.b(this.jdField_b_of_type_Basx))
    {
    default: 
      return;
    case 2: 
      zfy.a(this.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Basx.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), basx.a(this.jdField_b_of_type_Basx), 0L, this.jdField_a_of_type_MqqObserverBusinessObserver, basx.g(this.jdField_b_of_type_Basx));
      return;
    }
    Object localObject = ((asdm)this.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a(basx.a(this.jdField_b_of_type_Basx));
    if (localObject != null)
    {
      a((aryj)localObject);
      return;
    }
    long l = basx.b(this.jdField_b_of_type_Basx) / 1000L;
    localObject = AgentActivity.a(this.jdField_b_of_type_Basx.jdField_a_of_type_AndroidContentContext, basx.g(this.jdField_b_of_type_Basx), l + "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + (String)localObject);
    }
    zfy.a(this.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Basx.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), basx.a(this.jdField_b_of_type_Basx), (String)localObject, l, this.jdField_a_of_type_MqqObserverBusinessObserver, basx.g(this.jdField_b_of_type_Basx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basz
 * JD-Core Version:    0.7.0.1
 */