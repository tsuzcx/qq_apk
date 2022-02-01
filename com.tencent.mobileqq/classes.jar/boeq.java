import android.os.Build;
import java.io.File;

public class boeq
  extends bofd
{
  private static final String d = antf.aZ + "/DCIM/Video/";
  private static final String e = antf.aZ + anzj.a(2131699526);
  private static final String f = antf.aZ + anzj.a(2131699527);
  private static final String g = antf.aZ + "/Camera/Video/";
  private static final String h = antf.aZ + "/DCIM/Camera/";
  
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
      paramString.append(bdfc.a()).append(".mp4");
      if (!new File(paramString.toString()).exists()) {
        return paramString.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boeq
 * JD-Core Version:    0.7.0.1
 */