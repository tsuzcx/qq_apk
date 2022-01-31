import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class bhqa
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
      a = UpdateAvSo.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSharpPUtil", 2, "isSharpPAvaliable: " + a);
    }
    return (a) && (bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhqa
 * JD-Core Version:    0.7.0.1
 */