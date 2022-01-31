import android.os.Bundle;
import android.text.TextUtils;

public abstract class asiu
{
  public static int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("ak:"))) {
      return 1;
    }
    return 0;
  }
  
  public abstract void a(String paramString1, String paramString2, Object paramObject);
  
  protected abstract boolean a(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asiu
 * JD-Core Version:    0.7.0.1
 */