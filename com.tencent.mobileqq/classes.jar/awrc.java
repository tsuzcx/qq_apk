import android.text.TextUtils;

public class awrc
{
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = new Exception(paramString1);
    if (paramString2 == null)
    {
      awpu.a(paramString1);
      return;
    }
    awpu.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awrc
 * JD-Core Version:    0.7.0.1
 */