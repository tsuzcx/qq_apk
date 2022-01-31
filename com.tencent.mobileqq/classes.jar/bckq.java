import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bckq
{
  public static String a(String paramString)
  {
    if (a(paramString)) {
      return paramString + 140;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      QLog.d("AvatarTroopUtil", 1, "getAvatarAddress troopUin is empty");
    }
    do
    {
      return "http://p.qlogo.cn/gh/dir/file/";
      if (1 == paramInt) {
        return "http://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2 + "_" + paramString1);
      }
    } while (paramInt != 0);
    return "http://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("http://p.qlogo.cn/gh/");
  }
  
  public static String b(String paramString)
  {
    if (a(paramString)) {
      return paramString + 0;
    }
    return null;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (((paramString.length() > 1) && (paramString.startsWith("+"))) || (paramString.startsWith("-"))) {}
    for (int i = 1;; i = 0)
    {
      int j = paramString.length();
      int k;
      do
      {
        k = j - 1;
        if (k < i) {
          break;
        }
        j = k;
      } while (Character.isDigit(paramString.charAt(k)));
      return false;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckq
 * JD-Core Version:    0.7.0.1
 */