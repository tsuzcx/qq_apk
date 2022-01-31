import android.os.Build;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class bfxq
{
  private static int a = -1;
  
  public static boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        int i;
        if (a != -1)
        {
          i = a;
          if (i == 1) {
            return bool;
          }
          bool = false;
          continue;
        }
        Object localObject1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_module_black_list", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (TextUtils.isEmpty(""))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              a = 0;
              bool = false;
            }
          }
          else
          {
            localObject1 = "" + "," + (String)localObject1;
            continue;
          }
          try
          {
            localObject1 = ((String)localObject1).split(",");
            String str2 = Build.MODEL.toLowerCase();
            String str3 = Build.MANUFACTURER.toLowerCase();
            QLog.i("QzoneModuleCompat", 1, "Device info -- model: " + str2 + ", manufacturer: " + str3 + ", platform: " + System.getProperty("ro.board.platform"));
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              Object localObject3 = localObject1[i];
              if ((!localObject3.contains(str2)) && (!localObject3.equals(str3))) {
                continue;
              }
              a = 1;
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("QzoneModuleCompat", 1, "catch an exception:", localThrowable);
            a = 0;
            bool = false;
          }
          continue;
          i += 1;
        }
        else
        {
          String str1 = "";
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfxq
 * JD-Core Version:    0.7.0.1
 */