import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bnqp
{
  public static String a()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(localDate);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "1";
    }
    return "2";
  }
  
  public static String a(Long paramLong)
  {
    float f = (float)paramLong.longValue() / 1000.0F;
    return new DecimalFormat("0.00").format(f);
  }
  
  public static HashMap<String, String> a(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2)
  {
    paramHashMap1 = new HashMap(paramHashMap1);
    Iterator localIterator = paramHashMap2.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHashMap1.put(str, paramHashMap2.get(str));
    }
    return paramHashMap1;
  }
  
  public static void a()
  {
    bnqu.a().a("AEKIT_CAMERA_FIRST_LAUNCH", 1, 0);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (bnqu.a().a("AEKIT_CAMERA_FIRST_LAUNCH", 0, 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b()
  {
    if (bnqu.a().a("sp_key_ae_camera_launch_mark", 0)) {
      return false;
    }
    bnqu.a().a("sp_key_ae_camera_launch_mark", true, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqp
 * JD-Core Version:    0.7.0.1
 */