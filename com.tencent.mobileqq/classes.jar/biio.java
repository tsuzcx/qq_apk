import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class biio
{
  private static final String a;
  private static final String b;
  private static final String c = BaseApplicationImpl.getContext().getFilesDir().getParent();
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g;
  private static final String h;
  
  static
  {
    int i;
    if ((BaseApplicationImpl.getContext().getExternalFilesDir(null) != null) && (BaseApplicationImpl.getContext().getExternalCacheDir() != null))
    {
      i = 1;
      if (i == 0) {
        break label194;
      }
      b = BaseApplicationImpl.getContext().getExternalFilesDir(null).getPath();
    }
    for (a = BaseApplicationImpl.getContext().getExternalCacheDir().getPath();; a = BaseApplicationImpl.getContext().getCacheDir().getPath())
    {
      d = ajsd.aV + "/DCIM/Video/";
      e = ajsd.aV + ajya.a(2131700613);
      f = ajsd.aV + ajya.a(2131700614);
      g = ajsd.aV + "/Camera/Video/";
      h = ajsd.aV + "/DCIM/Camera/";
      return;
      i = 0;
      break;
      label194:
      b = BaseApplicationImpl.getContext().getFilesDir().getPath();
    }
  }
  
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
      paramString.append(axlx.a()).append(".mp4");
      if (!new File(paramString.toString()).exists()) {
        return paramString.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biio
 * JD-Core Version:    0.7.0.1
 */