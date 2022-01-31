import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class bhtn
{
  public static File a()
  {
    try
    {
      String str = bhbz.b;
      File localFile1 = new File(str);
      boolean bool = localFile1.exists();
      if (!bool) {
        try
        {
          new File(str, ".nomedia").createNewFile();
          if (!localFile1.mkdirs())
          {
            if (QLog.isColorLevel()) {
              QLog.w("InnerEnvironment", 2, "Unable to create external cache directory");
            }
            return null;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
    }
    finally {}
    return localFile2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhtn
 * JD-Core Version:    0.7.0.1
 */