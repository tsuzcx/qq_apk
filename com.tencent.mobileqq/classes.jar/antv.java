import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class antv
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  
  static
  {
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      label28:
      File localFile;
      break label28;
    }
    if (i != 0) {}
    for (localFile = new File(alof.aX);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      b = new File(localFile, "AR_MAP").getAbsolutePath();
      a = new File(localFile, "res_precover").getAbsolutePath();
      c = new File(b, "preload_map").getAbsolutePath();
      return;
    }
  }
  
  public static String a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antv
 * JD-Core Version:    0.7.0.1
 */