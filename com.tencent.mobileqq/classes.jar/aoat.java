import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.text.SimpleDateFormat;

public class aoat
{
  public static String a()
  {
    String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    return str + "/Camera/ARVideoRecord.tmp";
  }
  
  public static boolean a()
  {
    return (Build.VERSION.SDK_INT >= 18) && (aoel.a().d) && (!Build.MODEL.equalsIgnoreCase("CAM-TL00"));
  }
  
  public static String b()
  {
    String str = ShortVideoUtils.getCameraPath();
    str = str + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
    str = str + mnh.a;
    File localFile = new File(str).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoat
 * JD-Core Version:    0.7.0.1
 */