import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class bkdi
{
  public static boolean a;
  
  public static File a(File paramFile)
  {
    File localFile = new File(paramFile.getAbsolutePath() + ".shp");
    if (paramFile.exists()) {
      paramFile.renameTo(localFile);
    }
    return localFile;
  }
  
  public static String a(File paramFile)
  {
    return paramFile.getAbsolutePath() + ".shp";
  }
  
  public static boolean a()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length >= 2) && (!"0".equals(localObject[1]))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = a();
    if ((!a) && (bool)) {
      a = AVSoUtils.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSharpPUtil", 2, "isSharpPAvaliable: " + a);
    }
    return (a) && (bool);
  }
  
  public static boolean b()
  {
    String str = Build.CPU_ABI + Build.CPU_ABI2;
    if (Build.VERSION.SDK_INT < 14) {}
    while ((!str.contains("armeabi-v7a")) && (!str.contains("armeabi"))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdi
 * JD-Core Version:    0.7.0.1
 */