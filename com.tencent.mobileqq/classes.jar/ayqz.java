import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayqz
  extends ayqu
{
  private int a;
  
  ayqz(ayqt paramayqt)
  {
    super(paramayqt);
    this.jdField_a_of_type_JavaLangString = "ImageUploadStep";
  }
  
  protected boolean a()
  {
    return ayqt.a(this.jdField_b_of_type_Ayqt).get();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|process|ready=" + ayqt.a(this.jdField_b_of_type_Ayqt) + ",remoteUrl=" + ayqt.a(this.jdField_b_of_type_Ayqt) + " ,localUrl=" + ayqt.b(this.jdField_b_of_type_Ayqt));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (ayqt.a(this.jdField_b_of_type_Ayqt).get())
    {
      b();
      return;
    }
    ThreadManager.excute(new ForwardSdkShareProcessor.ImageUploadStep.1(this), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqz
 * JD-Core Version:    0.7.0.1
 */