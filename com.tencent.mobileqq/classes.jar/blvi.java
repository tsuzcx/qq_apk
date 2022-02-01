import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.HashMap;

public class blvi
{
  public static boolean a;
  public static boolean b = true;
  
  private static HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu_num", String.valueOf(DeviceInfoUtil.getCpuNumber()));
    localHashMap.put("device_level", String.valueOf(DeviceInfoUtil.getPerfLevel()));
    localHashMap.put("contain_download", String.valueOf(a));
    return localHashMap;
  }
  
  public static void a()
  {
    if (b)
    {
      blvk.a().b("ilive_monitor_cool_launch");
      return;
    }
    blvk.a().b("ilive_monitor_second_launch");
  }
  
  public static void a(String paramString)
  {
    blvk.a().b(paramString);
  }
  
  public static void b()
  {
    HashMap localHashMap = a();
    if (b)
    {
      blvk.a().a("ilive_monitor_cool_launch").a("ilive_monitor_cool_launch", localHashMap);
      blvk.a().a("ilive_monitor_cool_launch");
      b = false;
      return;
    }
    blvk.a().a("ilive_monitor_second_launch").a("ilive_monitor_second_launch", localHashMap);
    blvk.a().a("ilive_monitor_second_launch");
  }
  
  public static void b(String paramString)
  {
    blvk.a().a(paramString).a(paramString, a());
    blvk.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvi
 * JD-Core Version:    0.7.0.1
 */