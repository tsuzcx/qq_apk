import android.os.Build;
import android.text.TextUtils;

public class bewv
{
  private static final boolean a = belj.a("MiniGame", "MiniGameLogEnable", true);
  
  public static int a()
  {
    return belj.a("MiniGame", "MiniGameBlackDetectInterval", 3000);
  }
  
  public static String a()
  {
    return belj.a("MiniGame", "MiniGameErrorDialogContent", "游戏异常停止, 是否需要重启游戏?");
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static int b()
  {
    return belj.a("MiniGame", "MiniGameJsErrorDetectInterval", 5000);
  }
  
  public static String b()
  {
    return belj.a("MiniApp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
  }
  
  public static boolean b()
  {
    return belj.a("MiniGame", "MiniGameDexEnable", true);
  }
  
  public static int c()
  {
    return belj.a("MiniGame", "MiniGamePresentDetectInterval", 1000);
  }
  
  public static boolean c()
  {
    return belj.a("MiniGame", "MiniGameErrorDialogEnable", 1) > 0;
  }
  
  public static int d()
  {
    return belj.a("MiniGame", "MiniGameFrameNoChangeLimit", 5);
  }
  
  public static boolean d()
  {
    String str1 = Build.MANUFACTURER;
    if (TextUtils.isEmpty(str1)) {
      return true;
    }
    str1 = str1.toLowerCase();
    String str2 = belj.a("MiniGame", "MiniGameErrorDialogBlack", "");
    if (TextUtils.isEmpty(str2)) {
      return false;
    }
    return str2.contains(str1);
  }
  
  public static int e()
  {
    return belj.a("MiniGame", "MiniGameNoPresentDurationLimit", 5000);
  }
  
  public static boolean e()
  {
    return belj.a("MiniGame", "enableOpengles3", 1) > 0;
  }
  
  public static int f()
  {
    return belj.a("MiniGame", "MiniGameNoPresentTouchLimit", 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewv
 * JD-Core Version:    0.7.0.1
 */