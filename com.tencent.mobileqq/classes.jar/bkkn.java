import android.os.Build;
import java.io.File;

public class bkkn
  extends bkla
{
  private static final String d = aljq.aW + "/DCIM/Video/";
  private static final String e = aljq.aW + alpo.a(2131700982);
  private static final String f = aljq.aW + alpo.a(2131700983);
  private static final String g = aljq.aW + "/Camera/Video/";
  private static final String h = aljq.aW + "/DCIM/Camera/";
  
  public static String a()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      return e;
    }
    if ((str.contains("MX4")) || (str.contains("MX6")) || (str.contains("MX5")) || (str.contains("M355")) || (str.contains("M571C"))) {
      return d;
    }
    if (str.contains("M040")) {
      return g;
    }
    if ((str.contains("VIVO X7")) || (str.contains("VIVO X6A")) || (str.contains("VIVO XPLAY6")) || (str.contains("VIVO X5PRO")) || (str.contains("VIVO X9 PLUS")) || (str.contains("VIVO Y51A")) || (str.contains("VIVO X9I")) || (str.contains("VIVO X9")) || (str.contains("VIVO X6D"))) {
      return f;
    }
    return h;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    File localFile = new File(localStringBuilder.toString());
    paramString = localStringBuilder;
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    for (paramString = localStringBuilder;; paramString = new StringBuilder(paramString))
    {
      paramString.append(azhd.a()).append(".mp4");
      if (!new File(paramString.toString()).exists()) {
        return paramString.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkn
 * JD-Core Version:    0.7.0.1
 */