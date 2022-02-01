import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class betr
  extends betk
{
  private boolean a;
  
  betr(betj parambetj)
  {
    super(parambetj);
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
    if (!nny.a(this.jdField_b_of_type_Betj.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|no network");
      if ((betj.a(this.jdField_b_of_type_Betj) > 0) || (!betj.b(this.jdField_b_of_type_Betj).get()) || (!this.jdField_b_of_type_Betj.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_Betj.b(9004, "no network");
        c();
        return;
      }
    }
    if ((this.jdField_b_of_type_Betj.jdField_a_of_type_Beyg != null) && (this.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.a != null))
    {
      azrh localazrh = new azrh();
      String str2 = (String)this.jdField_b_of_type_Betj.b.get("audioUrl");
      String str3 = this.jdField_b_of_type_Betj.e;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_b_of_type_Betj.f;
      }
      localazrh.jdField_a_of_type_JavaLangObject = new String[] { str3, str1 };
      localazrh.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.a.b(localazrh);
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_Betj.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betr
 * JD-Core Version:    0.7.0.1
 */