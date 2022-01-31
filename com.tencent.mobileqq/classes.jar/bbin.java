import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class bbin
{
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.android.launcher.permission.READ_SETTINGS", "com.android.launcher2.permission.READ_SETTINGS", "com.android.launcher3.permission.READ_SETTINGS", "com.google.android.launcher.permission.READ_SETTINGS", "com.huawei.android.launcher.permission.READ_SETTINGS", "com.huawei.launcher2.permission.READ_SETTINGS", "com.huawei.launcher3.permission.READ_SETTINGS", "com.bbk.launcher2.permission.READ_SETTINGS", "com.huaqin.launcherEx.permission.READ_SETTINGS", "com.htc.launcher.permission.READ_SETTINGS", "com.htc.launcher.settings", "com.oppo.launcher.permission.READ_SETTINGS", "com.meizu.android.launcher.permission.READ_SETTINGS", "com.meizu.launcher2.permission.READ_SETTINGS", "com.meizu.android.launcher3.permission.READ_SETTINGS", "com.lenovo.launcher.permission.READ_SETTINGS", "com.ebproductions.android.launcher.permission.READ_SETTINGS", "com.android.mylauncher.permission.READ_SETTINGS", "com.sec.android.app.twlauncher.settings.READ_SETTINGS", "com.fede.launcher.permission.READ_SETTINGS", "net.qihoo.launcher.permission.READ_SETTINGS", "com.qihoo360.launcher.permission.READ_SETTINGS", "com.lge.launcher.permission.READ_SETTINGS", "org.adw.launcher.permission.READ_SETTINGS", "telecom.mdesk.permission.READ_SETTINGS" };
  private static int jdField_b_of_type_Int;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { ajyc.a(2131710769), ajyc.a(2131710770) };
  private static int jdField_c_of_type_Int;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString = { ajyc.a(2131710773), ajyc.a(2131710768), ajyc.a(2131710767), ajyc.a(2131710772) };
  private static int jdField_d_of_type_Int;
  private static final String[] jdField_d_of_type_ArrayOfJavaLangString = { ajyc.a(2131710774) };
  private static int jdField_e_of_type_Int;
  private static final String[] jdField_e_of_type_ArrayOfJavaLangString = { ajyc.a(2131710771) };
  private static int jdField_f_of_type_Int;
  private static final String[] jdField_f_of_type_ArrayOfJavaLangString = { "vivo" };
  private static int g;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = 100;
    jdField_d_of_type_Int = -1;
    jdField_e_of_type_Int = 100;
    jdField_f_of_type_Int = -1;
    g = 6;
  }
  
  public static String a(Context paramContext)
  {
    if (jdField_a_of_type_JavaLangString == null)
    {
      jdField_a_of_type_JavaLangString = a(paramContext, jdField_a_of_type_ArrayOfJavaLangString);
      if (jdField_a_of_type_JavaLangString == null) {
        break label88;
      }
    }
    label88:
    for (jdField_a_of_type_JavaLangString = "content://" + jdField_a_of_type_JavaLangString + "/favorites?notify=true";; jdField_a_of_type_JavaLangString = "empty")
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.shortcut", 2, "getShortcutUri.shortcutUri=" + jdField_a_of_type_JavaLangString);
      }
      return jdField_a_of_type_JavaLangString;
    }
  }
  
  private static String a(Context paramContext, String[] paramArrayOfString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getInstalledPackages(10);
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)paramContext.next()).providers;
          if (arrayOfProviderInfo != null)
          {
            int k = arrayOfProviderInfo.length;
            int i = 0;
            while (i < k)
            {
              ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
              if (localProviderInfo != null)
              {
                int m = paramArrayOfString.length;
                int j = 0;
                while (j < m)
                {
                  if (paramArrayOfString[j].equals(localProviderInfo.readPermission))
                  {
                    paramContext = localProviderInfo.authority;
                    return paramContext;
                  }
                  j += 1;
                }
              }
              i += 1;
            }
          }
        }
      }
      return null;
    }
    catch (RuntimeException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbin
 * JD-Core Version:    0.7.0.1
 */