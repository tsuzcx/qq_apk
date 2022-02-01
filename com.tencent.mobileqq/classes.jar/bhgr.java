import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class bhgr
{
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static alxc a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return new alxc(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int c(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhgr
 * JD-Core Version:    0.7.0.1
 */