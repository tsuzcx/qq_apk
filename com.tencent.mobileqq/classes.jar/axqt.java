import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class axqt
  extends axql
{
  private boolean a;
  
  axqt(axqk paramaxqk)
  {
    super(paramaxqk);
    this.jdField_a_of_type_JavaLangString = "SendMsgStep";
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "SendMsgStep|process");
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (!badq.g(this.jdField_b_of_type_Axqk.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgStep|no network");
      if ((axqk.a(this.jdField_b_of_type_Axqk) > 0) || (!axqk.a(this.jdField_b_of_type_Axqk).get()) || (!axqk.c(this.jdField_b_of_type_Axqk).get()) || (axqk.a(this.jdField_b_of_type_Axqk).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Axqk.b(9004, "no network");
        c();
        return;
      }
    }
    Object localObject = this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.c, this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    if (localObject != null) {
      this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject, null);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "14");
    ((Bundle)localObject).putString("intext_2", "" + axqk.a(this.jdField_b_of_type_Axqk));
    ((Bundle)localObject).putString("stringext_1", "" + axqk.e(this.jdField_b_of_type_Axqk));
    ((Bundle)localObject).putString("intext_3", "0");
    bcad.a().a((Bundle)localObject, "", this.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Axqk.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axqt
 * JD-Core Version:    0.7.0.1
 */