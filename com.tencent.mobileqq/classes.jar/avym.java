import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class avym
{
  public static int a = 12;
  public static boolean a;
  
  public static int a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    return paramContext.getDisplayMetrics().widthPixels - AIOUtils.dp2px(42.0F, paramContext) * 2;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    paramInt /= 5;
    int i = a(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramContext.heightPixels * 1.0F / paramContext.widthPixels;
    if (QLog.isColorLevel()) {
      QLog.d("VelocityUtil", 2, "getInitVelocity() displayMetrics.widthPixels = " + paramContext.widthPixels + ", displayMetrics.heightPixels = " + paramContext.heightPixels + ", ratio = " + f + ", 16.F/9.F = " + 1.777778F + ",viewPagerClientWidth = " + i);
    }
    if ((f > 1.777778F) && (QLog.isColorLevel())) {
      QLog.d("VelocityUtil", 2, "getInitVelocity() ratio > 16.F/9.F");
    }
    QLog.d("VelocityUtil", 1, "getInitVelocity: pendingVelocity = " + paramInt + ", viewPagerClientWidth = " + i);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avym
 * JD-Core Version:    0.7.0.1
 */