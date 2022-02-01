import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bons
  implements bonr
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
    bonv localbonv = (bonv)bojv.a().c(10);
    localbonv.a(this.jdField_a_of_type_Float);
    localbonv.a(this.jdField_a_of_type_JavaIoFile);
    localbonv.c();
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
 * Qualified Name:     bons
 * JD-Core Version:    0.7.0.1
 */