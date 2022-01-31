import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blqc
  implements blqb
{
  private float jdField_a_of_type_Float;
  private File jdField_a_of_type_JavaIoFile;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaIoFile == null) || (!this.jdField_a_of_type_JavaIoFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("OriginalBgmRecognizer", 2, "recognize: invoked. info: audioFile not exist. mTargetAudioFile = " + this.jdField_a_of_type_JavaIoFile);
      }
      return;
    }
    blqf localblqf = (blqf)blmf.a().c(10);
    localblqf.a(this.jdField_a_of_type_Float);
    localblqf.a(this.jdField_a_of_type_JavaIoFile);
    localblqf.c();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqc
 * JD-Core Version:    0.7.0.1
 */