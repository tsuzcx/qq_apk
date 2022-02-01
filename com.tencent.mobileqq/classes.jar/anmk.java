import android.os.Build;
import android.text.TextUtils;
import common.config.service.QzoneConfig;

public class anmk
{
  public static float a()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowOffscreenHeight", 118.0F);
  }
  
  public static long a()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CmsPlayerRecordTimeout", 15000L);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowToggleButtonSwitch", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowNewAnimation", 1) > 0;
  }
  
  public static boolean c()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowMemeTab", 1) > 0;
  }
  
  public static boolean d()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowKeywordAssociation", 1) > 0;
  }
  
  public static boolean e()
  {
    String str = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAEKitDeviceBlackList", "");
    if (!TextUtils.isEmpty(str)) {
      return str.contains(Build.MODEL);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmk
 * JD-Core Version:    0.7.0.1
 */