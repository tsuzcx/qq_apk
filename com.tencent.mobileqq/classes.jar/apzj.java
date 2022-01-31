import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class apzj
{
  public static AbstractGifImage a(File paramFile, int paramInt, boolean paramBoolean)
  {
    try
    {
      if (NativeGifFactory.isUseNewGif()) {
        return new apzl(paramFile, paramInt, paramBoolean);
      }
      paramFile = new apzk(paramFile, paramInt, paramBoolean);
      return paramFile;
    }
    catch (IOException paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VoiceGifFactory", 2, "getVoiceGifObject exception. msg:" + paramFile.getMessage());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzj
 * JD-Core Version:    0.7.0.1
 */