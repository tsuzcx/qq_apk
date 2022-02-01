import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class bdur
  extends bduq
{
  private int jdField_a_of_type_Int;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new bdus(this);
  private AtomicBoolean c = new AtomicBoolean(false);
  
  bdur(bdup parambdup)
  {
    super(parambdup);
    this.jdField_a_of_type_JavaLangString = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.c;
    if (bdup.a(parambdup).jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localAtomicBoolean.set(bool);
      return;
      bool = false;
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.c, this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    if (((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).mSource_A_ActionData = bdup.a(this.jdField_b_of_type_Bdup).jdField_a_of_type_JavaLangString;
      ((AbsShareMsg)localObject).mSourceName = bdup.a(this.jdField_b_of_type_Bdup).b;
      ((AbsShareMsg)localObject).mSourceIcon = bdup.a(this.jdField_b_of_type_Bdup).d;
      ((AbsShareMsg)localObject).mSourceUrl = bdup.a(this.jdField_b_of_type_Bdup).c;
      ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
      this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.c, this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      this.jdField_b_of_type_Bdup.d(1002);
    }
  }
  
  void a(aufu paramaufu)
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - bdup.b(this.jdField_b_of_type_Bdup)));
    bdup.a(this.jdField_b_of_type_Bdup).d = paramaufu.a();
    bdup.a(this.jdField_b_of_type_Bdup).e = paramaufu.e();
    if (paramaufu.a())
    {
      if (!TextUtils.isEmpty(paramaufu.d())) {
        bdup.a(this.jdField_b_of_type_Bdup).jdField_a_of_type_JavaLangString = paramaufu.d();
      }
      if (!TextUtils.isEmpty(paramaufu.c())) {
        bdup.a(this.jdField_b_of_type_Bdup).b = paramaufu.c();
      }
      if ((!TextUtils.isEmpty(paramaufu.b())) && (bdup.a(this.jdField_b_of_type_Bdup) != Long.parseLong("1103584836"))) {
        bdup.a(this.jdField_b_of_type_Bdup).c = paramaufu.b();
      }
    }
    bdup.a(this.jdField_b_of_type_Bdup).jdField_a_of_type_Int = 1;
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
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|process|appId=" + bdup.a(this.jdField_b_of_type_Bdup) + ",pkgName=" + bdup.g(this.jdField_b_of_type_Bdup) + ",retry=" + this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    bdup.a(this.jdField_b_of_type_Bdup, System.currentTimeMillis());
    switch (bdup.b(this.jdField_b_of_type_Bdup))
    {
    default: 
      return;
    case 2: 
      abcr.a(this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Bdup.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), bdup.a(this.jdField_b_of_type_Bdup), 0L, this.jdField_a_of_type_MqqObserverBusinessObserver, bdup.g(this.jdField_b_of_type_Bdup));
      return;
    }
    Object localObject = ((auke)this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a(bdup.a(this.jdField_b_of_type_Bdup));
    if (localObject != null)
    {
      a((aufu)localObject);
      return;
    }
    long l = bdup.b(this.jdField_b_of_type_Bdup) / 1000L;
    localObject = AgentActivity.a(this.jdField_b_of_type_Bdup.jdField_a_of_type_AndroidContentContext, bdup.g(this.jdField_b_of_type_Bdup), l + "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + (String)localObject);
    }
    abcr.a(this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Bdup.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), bdup.a(this.jdField_b_of_type_Bdup), (String)localObject, l, this.jdField_a_of_type_MqqObserverBusinessObserver, bdup.g(this.jdField_b_of_type_Bdup));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdur
 * JD-Core Version:    0.7.0.1
 */