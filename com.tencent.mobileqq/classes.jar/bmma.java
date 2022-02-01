import android.text.TextUtils;

public class bmma
  extends bjwa
{
  public void i(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains("onRenderFrame"))) {
      return;
    }
    super.i(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmma
 * JD-Core Version:    0.7.0.1
 */