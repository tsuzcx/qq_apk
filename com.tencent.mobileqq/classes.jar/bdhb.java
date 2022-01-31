import android.os.Build;
import android.os.Environment;
import java.io.File;

public class bdhb
{
  static String a = Environment.getExternalStorageDirectory().getAbsolutePath();
  static String b = a + "/DCIM/Video/";
  static String c = a + "/照相机/Camera/";
  static String d = a + "/相机/";
  static String e = a + "/Camera/Video/";
  static String f = a + "/DCIM/Camera/";
  
  public static String a()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      str = c;
    }
    for (;;)
    {
      bdnw.a("ShortVideoUtil", "getCameraPath: commonPath=" + str);
      return str;
      if ((str.contains("MX4")) || (str.contains("MX6")) || (str.contains("MX5")) || (str.contains("M355")) || (str.contains("M571C"))) {
        str = b;
      } else if (str.contains("M040")) {
        str = e;
      } else if ((str.contains("VIVO X7")) || (str.contains("VIVO X6A")) || (str.contains("VIVO XPLAY6")) || (str.contains("VIVO X5PRO")) || (str.contains("VIVO X9 PLUS")) || (str.contains("VIVO Y51A")) || (str.contains("VIVO X9I")) || (str.contains("VIVO X9")) || (str.contains("VIVO X6D"))) {
        str = d;
      } else {
        str = f;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdhb
 * JD-Core Version:    0.7.0.1
 */