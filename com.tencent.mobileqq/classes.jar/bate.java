import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class bate
  extends basy
{
  private AtomicInteger a;
  public boolean a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  bate(basx parambasx)
  {
    super(parambasx);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "RichStep";
    g();
  }
  
  protected boolean a()
  {
    return (!this.c.get()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "RichStep|process|neeRich=" + this.c + ",lack=" + basx.a(this.jdField_b_of_type_Basx));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (this.c.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      ThreadManager.post(new ForwardSdkShareProcessor.RichStep.1(this), 5, null, true);
      return;
    }
    b();
  }
  
  void g()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.c.set(false);
    if ((TextUtils.isEmpty(basx.a(this.jdField_b_of_type_Basx))) && (TextUtils.isEmpty(basx.b(this.jdField_b_of_type_Basx)))) {
      basx.a(this.jdField_b_of_type_Basx, basx.a(this.jdField_b_of_type_Basx) | 0x1);
    }
    if (TextUtils.isEmpty(basx.c(this.jdField_b_of_type_Basx))) {
      basx.a(this.jdField_b_of_type_Basx, basx.a(this.jdField_b_of_type_Basx) | 0x2);
    }
    if (TextUtils.isEmpty(basx.d(this.jdField_b_of_type_Basx))) {
      basx.a(this.jdField_b_of_type_Basx, basx.a(this.jdField_b_of_type_Basx) | 0x4);
    }
    if (basx.a(this.jdField_b_of_type_Basx) > 0) {
      this.c.set(true);
    }
    if (basx.b(this.jdField_b_of_type_Basx) == 11) {
      this.c.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bate
 * JD-Core Version:    0.7.0.1
 */