import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class bduy
  extends bduq
{
  private boolean a;
  
  bduy(bdup parambdup)
  {
    super(parambdup);
    this.jdField_a_of_type_JavaLangString = "SendMsgStep";
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void d()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SendMsgStep|process");
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (!nmd.a(this.jdField_b_of_type_Bdup.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgStep|no network");
      if ((bdup.a(this.jdField_b_of_type_Bdup) > 0) || (!bdup.b(this.jdField_b_of_type_Bdup).get()) || (!bdup.c(this.jdField_b_of_type_Bdup).get()) || (bdup.a(this.jdField_b_of_type_Bdup).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Bdup.b(9004, "no network");
        c();
        return;
      }
    }
    Object localObject = this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.c, this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    if (localObject != null) {
      this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject, null);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "14");
    ((Bundle)localObject).putString("intext_2", "" + bdup.a(this.jdField_b_of_type_Bdup));
    ((Bundle)localObject).putString("stringext_1", "" + bdup.e(this.jdField_b_of_type_Bdup));
    ((Bundle)localObject).putString("intext_3", "0");
    bipi.a().a((Bundle)localObject, "", this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Bdup.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduy
 * JD-Core Version:    0.7.0.1
 */