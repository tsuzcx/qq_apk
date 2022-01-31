import android.os.Build;
import android.text.TextUtils;

public class bdrd
{
  private static final boolean a = bdhg.a("MiniGame", "MiniGameLogEnable", true);
  
  public static int a()
  {
    return bdhg.a("MiniGame", "MiniGameBlackDetectInterval", 3000);
  }
  
  public static String a()
  {
    return bdhg.a("MiniGame", "MiniGameErrorDialogContent", "游戏异常停止, 是否需要重启游戏?");
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static int b()
  {
    return bdhg.a("MiniGame", "MiniGameJsErrorDetectInterval", 5000);
  }
  
  public static boolean b()
  {
    return bdhg.a("MiniGame", "MiniGameDexEnable", true);
  }
  
  public static int c()
  {
    return bdhg.a("MiniGame", "MiniGamePresentDetectInterval", 1000);
  }
  
  public static boolean c()
  {
    return bdhg.a("MiniGame", "MiniGameErrorDialogEnable", 1) > 0;
  }
  
  public static int d()
  {
    return bdhg.a("MiniGame", "MiniGameFrameNoChangeLimit", 5);
  }
  
  public static boolean d()
  {
    String str1 = Build.MANUFACTURER;
    if (TextUtils.isEmpty(str1)) {
      return true;
    }
    str1 = str1.toLowerCase();
    String str2 = bdhg.a("MiniGame", "MiniGameErrorDialogBlack", "");
    if (TextUtils.isEmpty(str2)) {
      return false;
    }
    return str2.contains(str1);
  }
  
  public static int e()
  {
    return bdhg.a("MiniGame", "MiniGameNoPresentDurationLimit", 5000);
  }
  
  public static boolean e()
  {
    return bdhg.a("MiniGame", "enableOpengles3", 1) > 0;
  }
  
  public static int f()
  {
    return bdhg.a("MiniGame", "MiniGameNoPresentTouchLimit", 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdrd
 * JD-Core Version:    0.7.0.1
 */