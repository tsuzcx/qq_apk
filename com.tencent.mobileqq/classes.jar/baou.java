import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class baou
  extends baop
{
  private int a;
  
  baou(baoo parambaoo)
  {
    super(parambaoo);
    this.jdField_a_of_type_JavaLangString = "ImageUploadStep";
  }
  
  protected boolean a()
  {
    return baoo.a(this.jdField_b_of_type_Baoo).get();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|process|ready=" + baoo.a(this.jdField_b_of_type_Baoo) + ",remoteUrl=" + baoo.a(this.jdField_b_of_type_Baoo) + " ,localUrl=" + baoo.b(this.jdField_b_of_type_Baoo));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (baoo.a(this.jdField_b_of_type_Baoo).get())
    {
      b();
      return;
    }
    ThreadManager.excute(new ForwardSdkShareProcessor.ImageUploadStep.1(this), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baou
 * JD-Core Version:    0.7.0.1
 */