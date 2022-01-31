import android.text.TextUtils;

public class bkex
  extends bfxc
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
 * Qualified Name:     bkex
 * JD-Core Version:    0.7.0.1
 */