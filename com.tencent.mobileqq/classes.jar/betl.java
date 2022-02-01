import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class betl
  extends betk
{
  private int jdField_a_of_type_Int;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new betm(this);
  private AtomicBoolean c = new AtomicBoolean(false);
  
  betl(betj parambetj)
  {
    super(parambetj);
    this.jdField_a_of_type_JavaLangString = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.c;
    if (parambetj.jdField_a_of_type_Beyh.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localAtomicBoolean.set(bool);
      return;
      bool = false;
    }
  }
  
  void a(auxp paramauxp)
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - betj.b(this.jdField_b_of_type_Betj)));
    this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.d = paramauxp.a();
    this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.e = paramauxp.e();
    if (paramauxp.a())
    {
      if (!TextUtils.isEmpty(paramauxp.d())) {
        this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.jdField_a_of_type_JavaLangString = paramauxp.d();
      }
      if (!TextUtils.isEmpty(paramauxp.c())) {
        this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.b = paramauxp.c();
      }
      if ((!TextUtils.isEmpty(paramauxp.b())) && (betj.a(this.jdField_b_of_type_Betj) != Long.parseLong("1103584836"))) {
        this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.c = paramauxp.b();
      }
    }
    this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.jdField_a_of_type_Int = 1;
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
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|process|appId=" + betj.a(this.jdField_b_of_type_Betj) + ",pkgName=" + betj.b(this.jdField_b_of_type_Betj) + ",retry=" + this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    betj.a(this.jdField_b_of_type_Betj, System.currentTimeMillis());
    switch (this.jdField_b_of_type_Betj.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      abgu.a(this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Betj.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), betj.a(this.jdField_b_of_type_Betj), 0L, this.jdField_a_of_type_MqqObserverBusinessObserver, betj.b(this.jdField_b_of_type_Betj));
      return;
    }
    Object localObject = ((avcd)this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a(betj.a(this.jdField_b_of_type_Betj));
    if (localObject != null)
    {
      a((auxp)localObject);
      return;
    }
    long l = betj.b(this.jdField_b_of_type_Betj) / 1000L;
    localObject = AgentActivity.a(this.jdField_b_of_type_Betj.jdField_a_of_type_AndroidContentContext, betj.b(this.jdField_b_of_type_Betj), l + "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + (String)localObject);
    }
    abgu.a(this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Betj.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), betj.a(this.jdField_b_of_type_Betj), (String)localObject, l, this.jdField_a_of_type_MqqObserverBusinessObserver, betj.b(this.jdField_b_of_type_Betj));
  }
  
  void g()
  {
    Object localObject = this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.c, this.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    if (((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).mSource_A_ActionData = this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.jdField_a_of_type_JavaLangString;
      ((AbsShareMsg)localObject).mSourceName = this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.b;
      ((AbsShareMsg)localObject).mSourceIcon = this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.d;
      ((AbsShareMsg)localObject).mSourceUrl = this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.c;
      ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
      this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.c, this.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      this.jdField_b_of_type_Betj.d(1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betl
 * JD-Core Version:    0.7.0.1
 */