package c.t.m.sapp.c;

import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;

public class j
{
  public static String a = "TencentLocTag";
  public static LocationLogCallback b;
  
  public static void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    LocationLogCallback localLocationLogCallback = b;
    if (localLocationLogCallback != null) {
      localLocationLogCallback.onLog(paramInt, "TencentLocationComp_sapp", paramString, paramThrowable);
    }
  }
  
  public static void a(LocationLogCallback paramLocationLogCallback)
  {
    b = paramLocationLogCallback;
  }
  
  public static void a(String paramString)
  {
    a(4, paramString, null);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    a(6, paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.j
 * JD-Core Version:    0.7.0.1
 */