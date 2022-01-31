import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayqx
  extends ayqs
{
  private int a;
  
  ayqx(ayqr paramayqr)
  {
    super(paramayqr);
    this.jdField_a_of_type_JavaLangString = "ImageUploadStep";
  }
  
  protected boolean a()
  {
    return ayqr.a(this.jdField_b_of_type_Ayqr).get();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|process|ready=" + ayqr.a(this.jdField_b_of_type_Ayqr) + ",remoteUrl=" + ayqr.a(this.jdField_b_of_type_Ayqr) + " ,localUrl=" + ayqr.b(this.jdField_b_of_type_Ayqr));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (ayqr.a(this.jdField_b_of_type_Ayqr).get())
    {
      b();
      return;
    }
    ThreadManager.excute(new ForwardSdkShareProcessor.ImageUploadStep.1(this), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqx
 * JD-Core Version:    0.7.0.1
 */