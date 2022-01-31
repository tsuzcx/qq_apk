import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class baow
  extends baop
{
  private boolean a;
  
  baow(baoo parambaoo)
  {
    super(parambaoo);
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
    if (!ndk.a(this.jdField_b_of_type_Baoo.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|no network");
      if ((baoo.a(this.jdField_b_of_type_Baoo) > 0) || (!baoo.a(this.jdField_b_of_type_Baoo).get()) || (!baoo.c(this.jdField_b_of_type_Baoo).get()) || (baoo.a(this.jdField_b_of_type_Baoo).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Baoo.b(9004, "no network");
        c();
        return;
      }
    }
    if ((this.jdField_b_of_type_Baoo.jdField_a_of_type_Baub != null) && (this.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.a != null))
    {
      awfz localawfz = new awfz();
      String str2 = (String)baoo.a(this.jdField_b_of_type_Baoo).get("audioUrl");
      String str3 = baoo.a(this.jdField_b_of_type_Baoo);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = baoo.h(this.jdField_b_of_type_Baoo);
      }
      localawfz.jdField_a_of_type_JavaLangObject = new String[] { str3, str1 };
      localawfz.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.a.b(localawfz);
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Baoo.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baow
 * JD-Core Version:    0.7.0.1
 */