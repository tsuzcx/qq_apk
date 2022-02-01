import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class bqjj
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE);
  
  public static String a()
  {
    synchronized (a)
    {
      int i = new Random().nextInt(10000);
      String str = a.format(new Date()) + "_" + i;
      return str;
    }
  }
  
  public static String a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    return paramFile.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqjj
 * JD-Core Version:    0.7.0.1
 */