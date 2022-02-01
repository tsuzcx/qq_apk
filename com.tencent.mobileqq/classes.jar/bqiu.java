import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;

@TargetApi(14)
public class bqiu
{
  private static float jdField_a_of_type_Float;
  private static int jdField_a_of_type_Int;
  private static int b;
  
  public static float a(Resources paramResources)
  {
    if ((b == 0) || (jdField_a_of_type_Int == 0))
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return jdField_a_of_type_Float;
  }
  
  public static int a(Resources paramResources)
  {
    if (jdField_a_of_type_Int == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return jdField_a_of_type_Int;
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new bqiv(paramView));
    paramView.setVisibility(8);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static int b(Resources paramResources)
  {
    if (b == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return b;
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    if (paramBoolean) {
      localAlphaAnimation.setStartOffset(500L);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new bqiw(paramView));
    paramView.setVisibility(0);
    paramView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqiu
 * JD-Core Version:    0.7.0.1
 */