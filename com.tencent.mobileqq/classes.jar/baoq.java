import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class baoq
  extends baop
{
  private int jdField_a_of_type_Int;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new baor(this);
  private AtomicBoolean c = new AtomicBoolean(false);
  
  baoq(baoo parambaoo)
  {
    super(parambaoo);
    this.jdField_a_of_type_JavaLangString = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.c;
    if (baoo.a(parambaoo).jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localAtomicBoolean.set(bool);
      return;
      bool = false;
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.c, this.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Long);
    if (((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).mSource_A_ActionData = baoo.a(this.jdField_b_of_type_Baoo).jdField_a_of_type_JavaLangString;
      ((AbsShareMsg)localObject).mSourceName = baoo.a(this.jdField_b_of_type_Baoo).b;
      ((AbsShareMsg)localObject).mSourceIcon = baoo.a(this.jdField_b_of_type_Baoo).d;
      ((AbsShareMsg)localObject).mSourceUrl = baoo.a(this.jdField_b_of_type_Baoo).c;
      ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
      this.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.c, this.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      this.jdField_b_of_type_Baoo.d(1002);
    }
  }
  
  void a(arua paramarua)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - baoo.b(this.jdField_b_of_type_Baoo)));
    }
    baoo.a(this.jdField_b_of_type_Baoo).d = paramarua.a();
    baoo.a(this.jdField_b_of_type_Baoo).e = paramarua.e();
    if (paramarua.a())
    {
      if (!TextUtils.isEmpty(paramarua.d())) {
        baoo.a(this.jdField_b_of_type_Baoo).jdField_a_of_type_JavaLangString = paramarua.d();
      }
      if (!TextUtils.isEmpty(paramarua.c())) {
        baoo.a(this.jdField_b_of_type_Baoo).b = paramarua.c();
      }
      if ((!TextUtils.isEmpty(paramarua.b())) && (baoo.a(this.jdField_b_of_type_Baoo) != Long.parseLong("1103584836"))) {
        baoo.a(this.jdField_b_of_type_Baoo).c = paramarua.b();
      }
    }
    baoo.a(this.jdField_b_of_type_Baoo).jdField_a_of_type_Int = 1;
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
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|appId=" + baoo.a(this.jdField_b_of_type_Baoo) + ",pkgName=" + baoo.g(this.jdField_b_of_type_Baoo) + ",retry=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    baoo.a(this.jdField_b_of_type_Baoo, System.currentTimeMillis());
    switch (baoo.b(this.jdField_b_of_type_Baoo))
    {
    default: 
      return;
    case 2: 
      zbj.a(this.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Baoo.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), baoo.a(this.jdField_b_of_type_Baoo), 0L, this.jdField_a_of_type_MqqObserverBusinessObserver, baoo.g(this.jdField_b_of_type_Baoo));
      return;
    }
    Object localObject = ((arzd)this.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a(baoo.a(this.jdField_b_of_type_Baoo));
    if (localObject != null)
    {
      a((arua)localObject);
      return;
    }
    long l = baoo.b(this.jdField_b_of_type_Baoo) / 1000L;
    localObject = AgentActivity.a(this.jdField_b_of_type_Baoo.jdField_a_of_type_AndroidContentContext, baoo.g(this.jdField_b_of_type_Baoo), l + "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + (String)localObject);
    }
    zbj.a(this.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Baoo.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), baoo.a(this.jdField_b_of_type_Baoo), (String)localObject, l, this.jdField_a_of_type_MqqObserverBusinessObserver, baoo.g(this.jdField_b_of_type_Baoo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoq
 * JD-Core Version:    0.7.0.1
 */