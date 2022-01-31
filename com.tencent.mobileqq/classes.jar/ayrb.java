import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class ayrb
  extends ayqu
{
  private boolean a;
  
  ayrb(ayqt paramayqt)
  {
    super(paramayqt);
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
    if (!bbfj.g(this.jdField_b_of_type_Ayqt.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|no network");
      if ((ayqt.a(this.jdField_b_of_type_Ayqt) > 0) || (!ayqt.a(this.jdField_b_of_type_Ayqt).get()) || (!ayqt.c(this.jdField_b_of_type_Ayqt).get()) || (ayqt.a(this.jdField_b_of_type_Ayqt).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Ayqt.b(9004, "no network");
        c();
        return;
      }
    }
    if ((this.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc != null) && (this.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.a != null))
    {
      auor localauor = new auor();
      String str2 = (String)ayqt.a(this.jdField_b_of_type_Ayqt).get("audioUrl");
      String str3 = ayqt.a(this.jdField_b_of_type_Ayqt);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = ayqt.h(this.jdField_b_of_type_Ayqt);
      }
      localauor.jdField_a_of_type_JavaLangObject = new String[] { str3, str1 };
      localauor.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.a.b(localauor);
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Ayqt.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrb
 * JD-Core Version:    0.7.0.1
 */