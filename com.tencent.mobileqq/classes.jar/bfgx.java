import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class bfgx
{
  public static float a;
  public static int a;
  private static float jdField_b_of_type_Float;
  private static int jdField_b_of_type_Int = -1;
  private static float jdField_c_of_type_Float;
  private static int jdField_c_of_type_Int = -1;
  private static int d = -1;
  
  static
  {
    DisplayMetrics localDisplayMetrics = MiniAppEnv.g().getContext().getResources().getDisplayMetrics();
    jdField_a_of_type_Float = localDisplayMetrics.density;
    jdField_a_of_type_Int = localDisplayMetrics.densityDpi;
    jdField_b_of_type_Float = -1.0F;
    jdField_c_of_type_Float = -1.0F;
  }
  
  public static float a()
  {
    if (jdField_b_of_type_Float < 0.0F) {
      jdField_b_of_type_Float = MiniAppEnv.g().getContext().getResources().getDisplayMetrics().density;
    }
    return jdField_b_of_type_Float;
  }
  
  public static int a()
  {
    if (jdField_c_of_type_Int < 0) {
      if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation != 2) {
        break label47;
      }
    }
    label47:
    for (jdField_c_of_type_Int = MiniAppEnv.g().getContext().getResources().getDisplayMetrics().heightPixels;; jdField_c_of_type_Int = MiniAppEnv.g().getContext().getResources().getDisplayMetrics().widthPixels) {
      return jdField_c_of_type_Int;
    }
  }
  
  public static int a(float paramFloat)
  {
    return Math.round(a() * paramFloat);
  }
  
  public static int b()
  {
    if (d < 0) {
      if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation != 2) {
        break label47;
      }
    }
    label47:
    for (d = MiniAppEnv.g().getContext().getResources().getDisplayMetrics().widthPixels;; d = MiniAppEnv.g().getContext().getResources().getDisplayMetrics().heightPixels) {
      return d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgx
 * JD-Core Version:    0.7.0.1
 */