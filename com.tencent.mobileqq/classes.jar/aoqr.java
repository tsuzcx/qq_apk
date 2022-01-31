import android.annotation.TargetApi;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConverterImpl;
import java.io.File;
import java.lang.ref.WeakReference;

@TargetApi(18)
public class aoqr
  implements VideoConverter.VideoConverterImpl
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public boolean a(File paramFile, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      paramFile = new Thread(new aoqs(this, paramFile, paramProcessor), "VideoConvert");
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFile);
      paramFile.start();
      if (paramBoolean) {}
      try
      {
        paramFile.join();
        return true;
      }
      catch (InterruptedException paramFile)
      {
        paramFile.printStackTrace();
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoqr
 * JD-Core Version:    0.7.0.1
 */