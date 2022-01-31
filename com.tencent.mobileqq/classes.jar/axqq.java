import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class axqq
  extends axql
{
  private int a;
  
  axqq(axqk paramaxqk)
  {
    super(paramaxqk);
    this.jdField_a_of_type_JavaLangString = "ImageUploadStep";
  }
  
  protected boolean a()
  {
    return axqk.a(this.jdField_b_of_type_Axqk).get();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|process|ready=" + axqk.a(this.jdField_b_of_type_Axqk) + ",remoteUrl=" + axqk.a(this.jdField_b_of_type_Axqk) + " ,localUrl=" + axqk.b(this.jdField_b_of_type_Axqk));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (axqk.a(this.jdField_b_of_type_Axqk).get())
    {
      b();
      return;
    }
    ThreadManager.excute(new ForwardSdkShareProcessor.ImageUploadStep.1(this), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axqq
 * JD-Core Version:    0.7.0.1
 */