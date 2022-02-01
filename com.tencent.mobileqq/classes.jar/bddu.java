import android.os.Build;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class bddu
{
  public static final List<String> a = Arrays.asList(new String[] { "VIVO X7", "VIVO XPLAY5A", "VIVO X6SPLUS", "VIVO X6S A", "REDMI NOTE 3", "REDMI NOTE 4X", "MI 5", "MI-4C", "CAM-AL00", "MLA-AL10", "CAZ-AL10", "VNS-AL00" });
  
  public static boolean a()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i == 22) || (i == 23) || (i == 24))
    {
      String str = Build.MODEL.toUpperCase();
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        if (str.contains((String)localIterator.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    return (Build.MANUFACTURER.toLowerCase().contains("samsung")) && (Build.VERSION.SDK_INT == 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddu
 * JD-Core Version:    0.7.0.1
 */