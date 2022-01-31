import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class ayqz
  extends ayqs
{
  private boolean a;
  
  ayqz(ayqr paramayqr)
  {
    super(paramayqr);
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
    if (!bbev.g(this.jdField_b_of_type_Ayqr.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|no network");
      if ((ayqr.a(this.jdField_b_of_type_Ayqr) > 0) || (!ayqr.a(this.jdField_b_of_type_Ayqr).get()) || (!ayqr.c(this.jdField_b_of_type_Ayqr).get()) || (ayqr.a(this.jdField_b_of_type_Ayqr).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Ayqr.b(9004, "no network");
        c();
        return;
      }
    }
    if ((this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa != null) && (this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.a != null))
    {
      auop localauop = new auop();
      String str2 = (String)ayqr.a(this.jdField_b_of_type_Ayqr).get("audioUrl");
      String str3 = ayqr.a(this.jdField_b_of_type_Ayqr);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = ayqr.h(this.jdField_b_of_type_Ayqr);
      }
      localauop.jdField_a_of_type_JavaLangObject = new String[] { str3, str1 };
      localauop.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.a.b(localauop);
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Ayqr.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqz
 * JD-Core Version:    0.7.0.1
 */