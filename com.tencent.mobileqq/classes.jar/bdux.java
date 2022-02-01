import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class bdux
  extends bduq
{
  private boolean a;
  
  bdux(bdup parambdup)
  {
    super(parambdup);
    this.jdField_a_of_type_JavaLangString = "SendMsgByServerStep";
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void d()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|process");
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (!nmd.a(this.jdField_b_of_type_Bdup.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|no network");
      if ((bdup.a(this.jdField_b_of_type_Bdup) > 0) || (!bdup.b(this.jdField_b_of_type_Bdup).get()) || (!bdup.c(this.jdField_b_of_type_Bdup).get()) || (bdup.a(this.jdField_b_of_type_Bdup).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Bdup.b(9004, "no network");
        c();
        return;
      }
    }
    if ((this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn != null) && (this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.a != null))
    {
      ayyu localayyu = new ayyu();
      String str2 = (String)bdup.a(this.jdField_b_of_type_Bdup).get("audioUrl");
      String str3 = bdup.a(this.jdField_b_of_type_Bdup);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = bdup.h(this.jdField_b_of_type_Bdup);
      }
      localayyu.jdField_a_of_type_JavaLangObject = new String[] { str3, str1 };
      localayyu.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.a.b(localayyu);
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Bdup.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdux
 * JD-Core Version:    0.7.0.1
 */