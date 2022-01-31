import android.os.Build;
import com.tencent.qqmini.sdk.utils.OSUtils;

public class bhaf
{
  public static volatile boolean a;
  public static volatile boolean b;
  
  static
  {
    if (Build.MODEL.contains("Android SDK built for x86")) {
      b = true;
    }
    String str1 = System.getProperty("os.arch");
    String str2 = OSUtils.getSystemProperty("ro.product.cpu.abi", "");
    if ((Build.CPU_ABI.contains("x86")) || (Build.CPU_ABI2.contains("x86")) || ((str1 != null) && (str1.contains("x86"))) || ((str2 != null) && (str2.contains("x86"))))
    {
      str1 = OSUtils.getSystemProperty("ro.dalvik.vm.native.bridge", "");
      if ((str1 != null) && (!str1.equals("0")) && (OSUtils.getSystemProperty("ro.enable.native.bridge.exec", "0").equals("0"))) {
        b = true;
      }
    }
    str1 = Build.CPU_ABI;
    str2 = Build.CPU_ABI2;
    if ((!b) && ((a(str1).booleanValue()) || (a(str2).booleanValue()))) {
      a = true;
    }
  }
  
  private static Boolean a(String paramString)
  {
    if ((paramString.equalsIgnoreCase("armeabi-v7a")) || (paramString.equalsIgnoreCase("arm64-v8a"))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhaf
 * JD-Core Version:    0.7.0.1
 */