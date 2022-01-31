import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Paint;
import android.os.PowerManager;
import android.view.View;

@Deprecated
public class bdds
{
  public static int a(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  @TargetApi(11)
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    if (bhtb.e()) {
      paramView.setLayerType(paramInt, paramPaint);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdds
 * JD-Core Version:    0.7.0.1
 */