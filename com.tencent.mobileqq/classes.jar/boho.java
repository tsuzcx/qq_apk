import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import java.util.ArrayList;
import java.util.List;

public class boho
{
  private static List<String> a = new ArrayList();
  
  static
  {
    a.add("pbem00");
  }
  
  public static int a(double paramDouble)
  {
    double d = Math.floor(paramDouble);
    paramDouble = Math.ceil(paramDouble);
    if (d % 2.0D == 0.0D) {
      return (int)d;
    }
    return (int)paramDouble;
  }
  
  public static <T> T a(T paramT1, T paramT2)
  {
    if (DeviceUtils.getTotalRamMemory(BaseApplicationImpl.getContext()) <= 2147483648L) {
      return paramT1;
    }
    return paramT2;
  }
  
  public static <T> T a(T paramT1, T paramT2, T paramT3)
  {
    if (OfflineConfig.getPhonePerfLevel() <= 2) {
      return paramT1;
    }
    if (((OfflineConfig.getPhonePerfLevel() > 2) && (OfflineConfig.getPhonePerfLevel() <= 3)) || (a.contains(Build.MODEL.toLowerCase()))) {
      return paramT2;
    }
    return paramT3;
  }
  
  public static String a()
  {
    return (String)a("低端机", "中端机", "高端机");
  }
  
  public static <T> T b(T paramT1, T paramT2, T paramT3)
  {
    long l = DeviceUtils.getTotalRamMemory(BaseApplicationImpl.getContext());
    if (l <= 2147483648L) {
      return paramT1;
    }
    if (l <= 4294967296L) {
      return paramT2;
    }
    return paramT3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boho
 * JD-Core Version:    0.7.0.1
 */