import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.Map;

public class bnpm
{
  private static Map<Integer, Long> a(long paramLong)
  {
    Map localMap = bnly.a(LocalMultiProcConfig.getString("CTIME_MAP" + paramLong, ""));
    if (!localMap.containsKey(Integer.valueOf(0))) {
      localMap.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    return localMap;
  }
  
  public static Map<Integer, Long> a(Long paramLong)
  {
    return a(paramLong.longValue());
  }
  
  public static void a(Integer paramInteger, Long paramLong)
  {
    Map localMap = a(paramLong);
    localMap.put(paramInteger, Long.valueOf(System.currentTimeMillis() / 1000L));
    if (QLog.isColorLevel()) {
      QLog.d("QZonePersonalizeH5Service", 2, "updateCTime: " + paramInteger + "timestamp: " + System.currentTimeMillis() / 1000L);
    }
    a(localMap, paramLong);
  }
  
  public static void a(Map<Integer, Long> paramMap, Long paramLong)
  {
    LocalMultiProcConfig.putString("CTIME_MAP" + paramLong, bnly.a(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpm
 * JD-Core Version:    0.7.0.1
 */