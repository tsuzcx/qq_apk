import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class blpy
{
  public static int a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return 0;
    }
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpy
 * JD-Core Version:    0.7.0.1
 */