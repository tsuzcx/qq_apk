import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ayra
  extends ayqs
{
  private boolean a;
  
  ayra(ayqr paramayqr)
  {
    super(paramayqr);
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
    if (!bbev.g(this.jdField_b_of_type_Ayqr.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgStep|no network");
      if ((ayqr.a(this.jdField_b_of_type_Ayqr) > 0) || (!ayqr.a(this.jdField_b_of_type_Ayqr).get()) || (!ayqr.c(this.jdField_b_of_type_Ayqr).get()) || (ayqr.a(this.jdField_b_of_type_Ayqr).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Ayqr.b(9004, "no network");
        c();
        return;
      }
    }
    Object localObject = this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.c, this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    if (localObject != null) {
      this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject, null);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "14");
    ((Bundle)localObject).putString("intext_2", "" + ayqr.a(this.jdField_b_of_type_Ayqr));
    ((Bundle)localObject).putString("stringext_1", "" + ayqr.e(this.jdField_b_of_type_Ayqr));
    ((Bundle)localObject).putString("intext_3", "0");
    bded.a().a((Bundle)localObject, "", this.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Ayqr.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayra
 * JD-Core Version:    0.7.0.1
 */