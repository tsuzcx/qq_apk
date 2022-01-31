import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class axqs
  extends axql
{
  private boolean a;
  
  axqs(axqk paramaxqk)
  {
    super(paramaxqk);
    this.jdField_a_of_type_JavaLangString = "SendMsgByServerStep";
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "SendMsgByServerStep|process");
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (!badq.g(this.jdField_b_of_type_Axqk.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|no network");
      if ((axqk.a(this.jdField_b_of_type_Axqk) > 0) || (!axqk.a(this.jdField_b_of_type_Axqk).get()) || (!axqk.c(this.jdField_b_of_type_Axqk).get()) || (axqk.a(this.jdField_b_of_type_Axqk).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Axqk.b(9004, "no network");
        c();
        return;
      }
    }
    if ((this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt != null) && (this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.a != null))
    {
      atqr localatqr = new atqr();
      String str2 = (String)axqk.a(this.jdField_b_of_type_Axqk).get("audioUrl");
      String str3 = axqk.a(this.jdField_b_of_type_Axqk);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = axqk.h(this.jdField_b_of_type_Axqk);
      }
      localatqr.jdField_a_of_type_JavaLangObject = new String[] { str3, str1 };
      localatqr.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.a.b(localatqr);
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Axqk.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axqs
 * JD-Core Version:    0.7.0.1
 */