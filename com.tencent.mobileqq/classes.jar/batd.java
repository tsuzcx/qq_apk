import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class batd
  extends basy
{
  private int a;
  
  batd(basx parambasx)
  {
    super(parambasx);
    this.jdField_a_of_type_JavaLangString = "ImageUploadStep";
  }
  
  protected boolean a()
  {
    return basx.a(this.jdField_b_of_type_Basx).get();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|process|ready=" + basx.a(this.jdField_b_of_type_Basx) + ",remoteUrl=" + basx.a(this.jdField_b_of_type_Basx) + " ,localUrl=" + basx.b(this.jdField_b_of_type_Basx));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (basx.a(this.jdField_b_of_type_Basx).get())
    {
      b();
      return;
    }
    ThreadManager.excute(new ForwardSdkShareProcessor.ImageUploadStep.1(this), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batd
 * JD-Core Version:    0.7.0.1
 */