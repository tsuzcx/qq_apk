import android.text.TextUtils;

public class asid
{
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asid
 * JD-Core Version:    0.7.0.1
 */