import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class batf
  extends basy
{
  private boolean a;
  
  batf(basx parambasx)
  {
    super(parambasx);
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
    if (!ndk.a(this.jdField_b_of_type_Basx.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|no network");
      if ((basx.a(this.jdField_b_of_type_Basx) > 0) || (!basx.a(this.jdField_b_of_type_Basx).get()) || (!basx.c(this.jdField_b_of_type_Basx).get()) || (basx.a(this.jdField_b_of_type_Basx).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Basx.b(9004, "no network");
        c();
        return;
      }
    }
    if ((this.jdField_b_of_type_Basx.jdField_a_of_type_Bayk != null) && (this.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.a != null))
    {
      awki localawki = new awki();
      String str2 = (String)basx.a(this.jdField_b_of_type_Basx).get("audioUrl");
      String str3 = basx.a(this.jdField_b_of_type_Basx);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = basx.h(this.jdField_b_of_type_Basx);
      }
      localawki.jdField_a_of_type_JavaLangObject = new String[] { str3, str1 };
      localawki.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.a.b(localawki);
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Basx.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batf
 * JD-Core Version:    0.7.0.1
 */