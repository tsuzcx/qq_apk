import android.annotation.TargetApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConverterImpl;
import java.io.File;

@TargetApi(18)
public class aozd
  implements VideoConverter.VideoConverterImpl
{
  boolean a = false;
  boolean b = false;
  
  public boolean a(File paramFile, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    if (!this.a)
    {
      this.a = true;
      paramFile = new aoze(this, paramFile, paramProcessor);
      if (!paramBoolean)
      {
        ThreadManagerV2.excute(paramFile, 16, null, false);
        return true;
      }
      paramFile.run();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aozd
 * JD-Core Version:    0.7.0.1
 */