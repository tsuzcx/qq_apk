import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.qphone.base.util.BaseApplication;

public class bjrk
{
  static volatile String a = null;
  
  private static Object a(Object paramObject)
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (localObject1 == null) {}
    for (;;)
    {
      return paramObject;
      try
      {
        localObject1 = ((WifiManager)localObject1).getConnectionInfo();
        if (localObject1 == null) {
          continue;
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static String a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        b();
      }
      if (("N/A".equals(a)) || ("00:00:00:00:00:00".equals(a)) || ("FF:FF:FF:FF:FF:FF".equalsIgnoreCase(a))) {
        return null;
      }
    }
    finally {}
    return a;
  }
  
  public static String b()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = a("N/A");
        if (localObject1 != "N/A")
        {
          String str = ((WifiInfo)localObject1).getBSSID();
          localObject1 = str;
          if (str == null) {
            localObject1 = "N/A";
          }
          a = (String)localObject1;
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrk
 * JD-Core Version:    0.7.0.1
 */