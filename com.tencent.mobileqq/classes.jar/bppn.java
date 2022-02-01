import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bppn
  implements bppm
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
    bppq localbppq = (bppq)bplq.a().c(10);
    localbppq.a(this.jdField_a_of_type_Float);
    localbppq.a(this.jdField_a_of_type_JavaIoFile);
    localbppq.c();
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
 * Qualified Name:     bppn
 * JD-Core Version:    0.7.0.1
 */