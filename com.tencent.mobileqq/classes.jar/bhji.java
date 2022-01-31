import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bhji
  implements bhjh
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
    bhjl localbhjl = (bhjl)bhfm.a().c(10);
    localbhjl.a(this.jdField_a_of_type_Float);
    localbhjl.a(this.jdField_a_of_type_JavaIoFile);
    localbhjl.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhji
 * JD-Core Version:    0.7.0.1
 */