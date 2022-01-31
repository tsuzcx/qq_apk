import android.view.View;
import android.view.ViewGroup;

public class bewf
{
  private static long jdField_a_of_type_Long = 400L;
  private static boolean jdField_a_of_type_Boolean;
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    paramViewGroup.invalidate();
    View localView = paramViewGroup.getChildAt(0);
    paramViewGroup = paramViewGroup.getChildAt(1);
    beuu localbeuu = new beuu(paramViewGroup);
    localbeuu.setDuration(jdField_a_of_type_Long);
    localbeuu.setFillAfter(true);
    localbeuu.setAnimationListener(new bewg(localView, paramViewGroup));
    paramViewGroup.startAnimation(localbeuu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewf
 * JD-Core Version:    0.7.0.1
 */