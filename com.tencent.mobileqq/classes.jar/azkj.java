import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class azkj
{
  public static final List<String> a = Arrays.asList(new String[] { "VIVO X7", "VIVO XPLAY5A", "VIVO X6SPLUS", "VIVO X6S A", "REDMI NOTE 3", "REDMI NOTE 4X", "MI 5", "MI-4C", "CAM-AL00", "MLA-AL10", "CAZ-AL10", "VNS-AL00" });
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str1 = Build.MANUFACTURER + ";" + Build.MODEL;
    String[] arrayOfString = "Meizu;PRO 6 Plus|samsung;SM-G9250|samsung;SM-G955FD|HUAWEI;CAM-TL00|OPPO;OPPO A37m|OPPO;OPPO A59s|samsung;SM-G9280|samsung;SM-G9200|samsung;SM-G955F|Meizu;Meizu S6".split("\\|");
    boolean bool1 = bool2;
    int j;
    int i;
    if (arrayOfString != null)
    {
      bool1 = bool2;
      if (arrayOfString.length > 0)
      {
        j = arrayOfString.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str2 = arrayOfString[i];
        if ((str2 != null) && (str2.equals(str1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MediaCodecUtil", 2, "isFollowBlackPhone true: " + str1);
          }
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b()
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
  
  public static boolean c()
  {
    return (Build.MANUFACTURER.toLowerCase().contains("samsung")) && (Build.VERSION.SDK_INT == 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkj
 * JD-Core Version:    0.7.0.1
 */