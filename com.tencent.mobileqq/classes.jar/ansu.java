import android.text.TextUtils;

public class ansu
{
  public static int a = 300;
  public static int b = 300;
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return ajsd.bh + akvt.a(paramString);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://p.qpic.cn/");
    localStringBuilder.append(paramString2).append("/").append(paramString3).append("/").append(paramString1).append("/0");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansu
 * JD-Core Version:    0.7.0.1
 */