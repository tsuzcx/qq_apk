import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class blcq
{
  private static float jdField_a_of_type_Float;
  public static int a;
  private static Context jdField_a_of_type_AndroidContentContext = ;
  private static float b;
  public static int b;
  private static float c = 1.34F;
  
  static
  {
    jdField_a_of_type_Int = 320;
    jdField_b_of_type_Int = 480;
    WindowManager localWindowManager = (WindowManager)jdField_a_of_type_AndroidContentContext.getSystemService("window");
    jdField_a_of_type_Int = localWindowManager.getDefaultDisplay().getWidth();
    jdField_b_of_type_Int = localWindowManager.getDefaultDisplay().getHeight();
    jdField_b_of_type_Float = 1.1F;
  }
  
  public static int a(float paramFloat)
  {
    if (jdField_a_of_type_Float == 0.0F) {
      jdField_a_of_type_Float = jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenUtil", 2, "[@] ScreenUtil.dip2px DENSITY = " + jdField_a_of_type_Float);
    }
    return (int)(jdField_a_of_type_Float * paramFloat + 0.5F);
  }
  
  @TargetApi(13)
  public static int a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (jdField_b_of_type_Int = localPoint.y;; jdField_b_of_type_Int = paramContext.getDefaultDisplay().getHeight()) {
      return jdField_b_of_type_Int;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    float f = paramInt2 * 1.0F / paramInt1;
    return (f > jdField_b_of_type_Float) && (f < c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     blcq
 * JD-Core Version:    0.7.0.1
 */