import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.HashMap;

public class azdh
{
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("waite", "" + paramInt);
    azri.a(VideoEnvironment.a()).a(null, "sv_waite_record_count", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a("sv_resource_download_base", paramInt1, paramInt2);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("type", "" + paramInt1);
    localHashMap.put("error", "" + paramInt2);
    azri.a(VideoEnvironment.a()).a(null, paramString, true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("cost", "" + paramLong);
    azri.a(VideoEnvironment.a()).a(null, paramString, true, 0L, 0L, localHashMap, "");
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    a("sv_resource_download_qzone", paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdh
 * JD-Core Version:    0.7.0.1
 */